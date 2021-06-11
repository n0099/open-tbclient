package com.yy.hiidostatis.inner.util;

import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes7.dex */
public class InsideMode {
    public static boolean encriptIMEI = false;
    public static boolean encriptIMSI = false;
    public static boolean encriptMAC = false;
    public static EncriptType encriptType = EncriptType.NONE;
    public static HostApp hostApp = HostApp.NONE;

    /* renamed from: com.yy.hiidostatis.inner.util.InsideMode$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType;
        public static final /* synthetic */ int[] $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp;

        static {
            int[] iArr = new int[HostApp.values().length];
            $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp = iArr;
            try {
                iArr[HostApp.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp[HostApp.MI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp[HostApp.VIVO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp[HostApp.MEIPAI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[EncriptType.values().length];
            $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType = iArr2;
            try {
                iArr2[EncriptType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType[EncriptType.MD5.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType[EncriptType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType[EncriptType.DOUBLE_MD5.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum EncriptType {
        NONE,
        MD5,
        DOUBLE_MD5,
        SHA256
    }

    /* loaded from: classes7.dex */
    public enum HostApp {
        NONE,
        MI,
        VIVO,
        MEIPAI
    }

    public static String encript(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        try {
            int i2 = AnonymousClass1.$SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType[encriptType.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    return i2 != 4 ? str : Coder.encryptMD5(Coder.encryptMD5(str));
                }
                return Coder.sha256Encrypt(str);
            }
            return Coder.encryptMD5(str);
        } catch (Throwable th) {
            L.debug("InsideMode", "encript", th);
            return "";
        }
    }

    public static void initHostApp(HostApp hostApp2) {
        int i2 = AnonymousClass1.$SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp[hostApp2.ordinal()];
        if (i2 == 1) {
            encriptIMEI = false;
            encriptIMSI = false;
            encriptMAC = false;
            encriptType = EncriptType.NONE;
        } else if (i2 == 2) {
            encriptIMEI = true;
            encriptIMSI = true;
            encriptMAC = false;
            encriptType = EncriptType.SHA256;
        } else if (i2 == 3) {
            encriptIMEI = true;
            encriptIMSI = true;
            encriptMAC = true;
            encriptType = EncriptType.DOUBLE_MD5;
        } else if (i2 != 4) {
        } else {
            encriptIMEI = true;
            encriptIMSI = true;
            encriptMAC = false;
            encriptType = EncriptType.SHA256;
        }
    }

    public static boolean isSafeMac() {
        return encriptMAC;
    }

    public static String safeIMEI(String str) {
        return encriptIMEI ? encript(str) : str;
    }

    public static String safeIMSI(String str) {
        return encriptIMSI ? encript(str) : str;
    }

    public static String safeMac(String str) {
        return encriptMAC ? encript(str) : str;
    }
}
