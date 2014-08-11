DESCRIPTION = "The YAML.pm module implements a YAML Loader and Dumper based on the \
YAML 1.0 specification. <http://www.yaml.org/spec/>"

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-2.0"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/YAML"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://cpan.metacpan.org/authors/id/I/IN/INGY/YAML-1.01.tar.gz"

SRC_URI[md5sum] = "274eb90f9d665dbef55219f4eea4d239"
SRC_URI[sha256sum] = "5ddba9d8fa0bed7d944b8ec5df47366003d4e11afc36fc9a32ef4a1afd461192"
DEPENDS += "test-yaml-perl"

S = "${WORKDIR}/YAML-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"