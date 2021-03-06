SUMMARY = "W3CServer"
DESCRIPTION = "W3CServer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96af5705d6f64a88e035781ef00e98a8"

# private variables
project_name = "W3CServer"
app_binary = "W3CServer"
etc_dir = "/etc"
ssh_dir = "/home/root/.ssh"
init_dir = "/etc/init.d"

DEPENDS = "qtbase qtwebsockets"

# Specify the hash key for a specific 'check in' if you don't want to check out the latest from HEAD

SRCREV="${AUTOREV}"
SRC_URI = "git://github.com/PeterWinzell/GDP-melco.git;branch=${W3C_BRANCH}"

# where to to look for the source files
S = "${WORKDIR}/git/${project_name}"

# required qt5 stuff
#inherit qmake5
require recipes-qt/qt5/qt5.inc
inherit update-rc.d

INITSCRIPT_NAME = "w3c-server.sh"
INITSCRIPT_PARAMS = "defaults 95"

# create the directory in the rootfs file structure
FILES_${PN} += "${bindir}"
FILES_${PN} += "${etc_dir}"
FILES_${PN} += "${ssh_dir}"
FILES_${PN} += "${init_dir}"

do_install() {
    install -d ${D}${etc_dir}
    install -d ${D}${init_dir}
    install -d ${D}${bindir}
    install -d ${D}${ssh_dir}
    install -m 0755 ${S}/vss_rel_1.0.json ${D}${etc_dir}
    install -m 0755 ${S}/vss_rel_1.0.vsi ${D}${etc_dir}
    install -m 0755 ${S}/target/linux/w3c-server.sh ${D}${init_dir}
    install -m 0755 ${B}/src/${app_binary} ${D}${bindir}
    cat ${S}/id_rsa.pub >> ${D}${ssh_dir}/authorized_keys
}

