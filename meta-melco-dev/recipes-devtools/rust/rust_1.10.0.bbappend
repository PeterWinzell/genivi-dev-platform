FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://remove_werror_for_x86_64_linux_gnu.patch"
