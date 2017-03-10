SUMMARY = "W3CServer"
DESCRIPTION = "W3CServer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96af5705d6f64a88e035781ef00e98a8"

# private variables
project_name = "W3CServer"
app_binary = "W3CServer"
etc_dir = "/etc"

DEPENDS = "qtbase qtwebsockets"

# Specify the hash key for a specific 'check in' if you don't want to check out the latest from HEAD
# example SRCREV = "LP-84"

SRCREV="${W3C_BRANCH}"

SRC_URI = "git://github.com/PeterWinzell/GDP-melco.git"

# where to to look for the source files
S = "${WORKDIR}/git/${project_name}"

# required qt5 stuff
#inherit qmake5
require recipes-qt/qt5/qt5.inc

# create the directory in the rootfs file structure
FILES_${PN} += "${bindir}"
FILES_${PN} += "${etc_dir}"

# install the EXECUTABLE to bindir (usr/bin)
do_install() {
    install -d ${D}${etc_dir}
    install -d ${D}${bindir}
    install -m 0755 ${S}/vss_rel_1.json ${D}${etc_dir}
    install -m 0755 ${B}/src/${app_binary} ${D}${bindir}
}
