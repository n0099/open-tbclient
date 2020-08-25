package org.conscrypt;

import java.io.File;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes12.dex */
public class HostProperties {
    private static final String TEMP_DIR_PROPERTY_NAME = "org.conscrypt.tmpdir";
    private static final Logger logger = Logger.getLogger(HostProperties.class.getName());
    static final OperatingSystem OS = getOperatingSystem(System.getProperty("os.name", ""));
    static final Architecture ARCH = getArchitecture(System.getProperty("os.arch", ""));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public enum OperatingSystem {
        AIX,
        HPUX,
        OS400,
        LINUX,
        OSX,
        FREEBSD,
        OPENBSD,
        NETBSD,
        SUNOS,
        WINDOWS,
        UNKNOWN;

        public String getFileComponent() {
            return name().toLowerCase();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public enum Architecture {
        X86_64,
        X86_32 { // from class: org.conscrypt.HostProperties.Architecture.1
            @Override // org.conscrypt.HostProperties.Architecture
            public String getFileComponent() {
                return "x86";
            }
        },
        ITANIUM_64,
        SPARC_32,
        SPARC_64,
        ARM_32,
        AARCH_64,
        PPC_32,
        PPC_64,
        PPCLE_64,
        S390_32,
        S390_64,
        UNKNOWN;

        public String getFileComponent() {
            return name().toLowerCase();
        }
    }

    static boolean isWindows() {
        return OS == OperatingSystem.WINDOWS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isOSX() {
        return OS == OperatingSystem.OSX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0079 -> B:4:0x000d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File getTempDir() {
        File file;
        try {
            file = toDirectory(System.getProperty(TEMP_DIR_PROPERTY_NAME));
        } catch (Exception e) {
        }
        if (file == null) {
            file = toDirectory(System.getProperty("java.io.tmpdir"));
            if (file == null) {
                if (isWindows()) {
                    if (!isWindows()) {
                        file = new File("C:\\Windows\\Temp");
                    } else {
                        file = new File("/tmp");
                    }
                    logger.log(Level.WARNING, "Failed to get the temporary directory; falling back to: {0}", file);
                } else {
                    if (!isWindows()) {
                    }
                    logger.log(Level.WARNING, "Failed to get the temporary directory; falling back to: {0}", file);
                }
            }
        }
        return file;
    }

    private static File toDirectory(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        file.mkdirs();
        if (file.isDirectory()) {
            try {
                return file.getAbsoluteFile();
            } catch (Exception e) {
                return file;
            }
        }
        return null;
    }

    private static String normalize(String str) {
        return str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    private static OperatingSystem getOperatingSystem(String str) {
        String normalize = normalize(str);
        if (normalize.startsWith("aix")) {
            return OperatingSystem.AIX;
        }
        if (normalize.startsWith("hpux")) {
            return OperatingSystem.HPUX;
        }
        if (normalize.startsWith("os400") && (normalize.length() <= 5 || !Character.isDigit(normalize.charAt(5)))) {
            return OperatingSystem.OS400;
        }
        if (normalize.startsWith("linux")) {
            return OperatingSystem.LINUX;
        }
        if (normalize.startsWith("macosx") || normalize.startsWith("osx")) {
            return OperatingSystem.OSX;
        }
        if (normalize.startsWith("freebsd")) {
            return OperatingSystem.FREEBSD;
        }
        if (normalize.startsWith("openbsd")) {
            return OperatingSystem.OPENBSD;
        }
        if (normalize.startsWith("netbsd")) {
            return OperatingSystem.NETBSD;
        }
        if (normalize.startsWith("solaris") || normalize.startsWith("sunos")) {
            return OperatingSystem.SUNOS;
        }
        if (normalize.startsWith("windows")) {
            return OperatingSystem.WINDOWS;
        }
        return OperatingSystem.UNKNOWN;
    }

    private static Architecture getArchitecture(String str) {
        String normalize = normalize(str);
        if (normalize.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
            return Architecture.X86_64;
        }
        if (normalize.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
            return Architecture.X86_32;
        }
        if (normalize.matches("^(ia64|itanium64)$")) {
            return Architecture.ITANIUM_64;
        }
        if (normalize.matches("^(sparc|sparc32)$")) {
            return Architecture.SPARC_32;
        }
        if (normalize.matches("^(sparcv9|sparc64)$")) {
            return Architecture.SPARC_64;
        }
        if (normalize.matches("^(arm|arm32)$")) {
            return Architecture.ARM_32;
        }
        if ("aarch64".equals(normalize)) {
            return Architecture.AARCH_64;
        }
        if (normalize.matches("^(ppc|ppc32)$")) {
            return Architecture.PPC_32;
        }
        if ("ppc64".equals(normalize)) {
            return Architecture.PPC_64;
        }
        if ("ppc64le".equals(normalize)) {
            return Architecture.PPCLE_64;
        }
        if ("s390".equals(normalize)) {
            return Architecture.S390_32;
        }
        if ("s390x".equals(normalize)) {
            return Architecture.S390_64;
        }
        return Architecture.UNKNOWN;
    }

    private HostProperties() {
    }
}
