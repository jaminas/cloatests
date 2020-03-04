#!/bin/bash

APPGIT='https://github.com/jaminas/funnycloa'
SDKDIR='/home/rinat/Android/Sdk'
PACKAGE='com.example.testdeeplink'

#sed 's/.*package="\([^"]*\)".*/\1/' ./app/app/src/main/AndroidManifest.xml

TESTGIT='https://github.com/jaminas/cloatests'
APPDIR='./app'
APPTESTDIR=${APPDIR}'/app/src/androidTest/java/tests'
GOOGLESERVICESFILE=${APPDIR}'/app/google-services.json'

TESTDIR='./test'
TESTDIRCOMMON=${TESTDIR}'/app/src/androidTest/java/tests'
HELPERDIRNAME='helper'
TEST1DIRNAME='internetoff'
TEST2DIRNAME='interneton_rcwrong'
TEST3DIRNAME='interneton_rcright'
CONFIGDIR=${TESTDIRCOMMON}'/config'

GOOGLEPACKAGE_DESCR_EQ_1='com.testovich.descr_eq_1'
GOOGLESERVICE_DESCR_EQ_1=${CONFIGDIR}'/google-services-descr_eq_1.json'

GOOGLEPACKAGE_BAD_JSON='com.testovich.bad_json'
GOOGLESERVICE_BAD_JSON=${CONFIGDIR}'/google-services-bad_json.json'

GOOGLESERVICES3=${CONFIGDIR}'/google-services-test3.json'

EMULATOR=${SDKDIR}'/emulator/emulator'
DEVICE_ION='Pixel_2_API_28_2_ION'
DEVICE_IOFF='Pixel_2_API_28'

rm -rf ${APPDIR}
rm -rf ${TESTDIR}

git clone ${APPGIT} ${APPDIR}
git clone ${TESTGIT} ${TESTDIR}
chmod 755 ${APPDIR}'/gradlew'

# заменяем имя пакета в конфигах
sed -i "s/{PACKAGE}/$PACKAGE/" ${TESTDIRCOMMON}'/'${TEST1DIRNAME}/*
sed -i "s/{PACKAGE}/$PACKAGE/" ${TESTDIRCOMMON}'/'${TEST2DIRNAME}/*
sed -i "s/{PACKAGE}/$PACKAGE/" ${TESTDIRCOMMON}'/'${TEST3DIRNAME}/*

# подготавливаем среду для тестов в приложении
mkdir -p ${APPTESTDIR}
cp -r ${TESTDIRCOMMON}'/'${HELPERDIRNAME} ${APPTESTDIR}
echo "sdk.dir=$SDKDIR" > ${APPDIR}/local.properties

# запускаем эмулятор с отключенным интернетом
${EMULATOR} -avd ${DEVICE_IOFF} &
sleep 10

# TEST 1 - NO INTERNET
sed -i "s/$PACKAGE/$GOOGLEPACKAGE_DESCR_EQ_1/" ${APPDIR}'/app/build.gradle'
cp -r ${TESTDIRCOMMON}'/'${TEST1DIRNAME} ${APPTESTDIR}
cp ${GOOGLESERVICE_DESCR_EQ_1} ${GOOGLESERVICESFILE}
cd ${APPDIR}
./gradlew connectedAndroidTest
cd .. # выходим обратно в корень
rm -rf ${APPTESTDIR}'/'${TEST1DIRNAME} # подчищаем тесты за собой

# киляем эмулятор
pkill -f ${DEVICE_IOFF}

# запускаем эмулятор с включенным интернетом
${EMULATOR} -avd ${DEVICE_ION} &
sleep 10

# TEST 2 - AVAILABLE INTERNET, WRONG REMOTE CONFIG - BAD_JSON
sed -i "s/$GOOGLEPACKAGE_DESCR_EQ_1/$GOOGLEPACKAGE_BAD_JSON/" ${APPDIR}'/app/build.gradle'
cp -r ${TESTDIRCOMMON}'/'${TEST2DIRNAME} ${APPTESTDIR}
cp ${GOOGLESERVICE_BAD_JSON} ${GOOGLESERVICESFILE}
cd ${APPDIR}
./gradlew connectedAndroidTest
cd .. # выходим обратно в корень
rm -rf ${APPTESTDIR}'/'${TEST2DIRNAME} # подчищаем тесты за собой

# киляем эмулятор
pkill -f ${DEVICE_ION}