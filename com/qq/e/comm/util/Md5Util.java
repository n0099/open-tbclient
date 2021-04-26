package com.qq.e.comm.util;

import android.util.Base64;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class Md5Util {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f36359a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, "a", "b", "c", "d", "e", "f"};

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 : bArr) {
            if (i2 < 0) {
                i2 += 256;
            }
            stringBuffer.append(f36359a[i2 / 16] + f36359a[i2 % 16]);
        }
        return stringBuffer.toString();
    }

    public static String encode(File file) {
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String byteArrayToHexString = byteArrayToHexString(messageDigest.digest());
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
                return byteArrayToHexString;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String encode(String str) {
        String str2;
        try {
            str2 = new String(str);
            try {
                return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(str2.getBytes("UTF-8")));
            } catch (Exception unused) {
                return str2;
            }
        } catch (Exception unused2) {
            str2 = null;
        }
    }

    public static String encodeBase64String(String str) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(Base64.decode(str, 0)));
        } catch (Exception e2) {
            GDTLogger.e("Exception while md5 base64String", e2);
            return null;
        }
    }

    public static byte[] hexStringtoByteArray(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < str.length() - 1; i2 += 2) {
            char charAt = str.charAt(i2);
            char charAt2 = str.charAt(i2 + 1);
            char lowerCase = Character.toLowerCase(charAt);
            char lowerCase2 = Character.toLowerCase(charAt2);
            int i3 = ((lowerCase <= '9' ? lowerCase - '0' : (lowerCase - 'a') + 10) << 4) + (lowerCase2 <= '9' ? lowerCase2 - '0' : (lowerCase2 - 'a') + 10);
            if (i3 > 127) {
                i3 -= 256;
            }
            bArr[i2 / 2] = (byte) i3;
        }
        return bArr;
    }
}
