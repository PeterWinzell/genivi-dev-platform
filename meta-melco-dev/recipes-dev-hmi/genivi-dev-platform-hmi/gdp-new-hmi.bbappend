FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-removed-auto-start-hmi.patch;patchdir=${WORKDIR}"
