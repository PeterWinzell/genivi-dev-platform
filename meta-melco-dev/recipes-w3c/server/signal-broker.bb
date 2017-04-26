SUMMARY = "signal-broker"
DESCRIPTION = "signal-broker"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96af5705d6f64a88e035781ef00e98a8"

# private variables
project_name = "OpenDSAdapter"
app_binary = "OpenDSAdapter"
etc_dir = "/etc"
ssh_dir = "/home/root/.ssh"
init_dir = "/etc/init.d"

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
inherit update-rc.d

INITSCRIPT_NAME = "signal-broker.sh"
INITSCRIPT_PARAMS = "defaults 100"

# create the directory in the rootfs file structure
FILES_${PN} += "${bindir}"
FILES_${PN} += "${init_dir}"

# install the EXECUTABLE to bindir (usr/bin)
do_install() {
    install -d ${D}${bindir}
    install -d ${D}${init_dir}
    install -m 0755 ${B}/src/${app_binary} ${D}${bindir}
    install -m 0755 ${S}/target/linux/signal-broker.sh ${D}${init_dir}
}