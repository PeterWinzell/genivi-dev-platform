SUMMARY = "W3CServer"
DESCRIPTION = "W3CServer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96af5705d6f64a88e035781ef00e98a8"

# private variables
project_name = "W3CServer"
app_binary = "W3CServer"

DEPENDS = "qtbase qtwebsockets"

# Specify the hash key for a specific 'check in' if you don't want to check out the latest from HEAD
# example SRCREV = "295da5482fd76b2d989ccb77fb1ca05ba7ad4225"

SRCREV="${AUTOREV}"
#SRC_URI = "git://github.com/thomas68/melco-qt-proj.git"
SRC_URI = "git://github.com/PeterWinzell/GDP-melco.git"

# where to to look for the source files
S = "${WORKDIR}/git/${project_name}"

# required qt5 stuff
#inherit qmake5
require recipes-qt/qt5/qt5.inc

# create the directory in the image file structure
FILES_${PN} += "${bindir}"

# install the EXECUTABLE to bindir (usr/bin)
do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/${app_binary} ${D}${bindir}
}
