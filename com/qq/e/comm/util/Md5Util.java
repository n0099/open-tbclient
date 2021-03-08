package com.qq.e.comm.util;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidu.pass.biometrics.face.liveness.d.b;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public class Md5Util {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f7595a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", b.f2804a, "c", "d", "e", "f"};

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            stringBuffer.append(f7595a[i / 16] + f7595a[i % 16]);
        }
        return stringBuffer.toString();
    }

    public static String encode(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2;
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream3 = null;
        try {
            messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            fileInputStream2 = new FileInputStream(file);
        } catch (Exception e) {
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream2.read(bArr);
                if (read <= 0) {
                    String byteArrayToHexString = byteArrayToHexString(messageDigest.digest());
                    try {
                        fileInputStream2.close();
                        return byteArrayToHexString;
                    } catch (Exception e2) {
                        return byteArrayToHexString;
                    }
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception e3) {
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (Exception e4) {
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e5) {
                }
            }
            throw th;
        }
    }

    public static String encode(String str) {
        try {
            String str2 = new String(str);
            try {
                return byteArrayToHexString(MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(str2.getBytes("UTF-8")));
            } catch (Exception e) {
                return str2;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static String encodeBase64String(String str) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(Base64.decode(str, 0)));
        } catch (Exception e) {
            GDTLogger.e("Exception while md5 base64String", e);
            return null;
        }
    }

    public static byte[] hexStringtoByteArray(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() - 1; i += 2) {
            char charAt = str.charAt(i);
            char charAt2 = str.charAt(i + 1);
            char lowerCase = Character.toLowerCase(charAt);
            char lowerCase2 = Character.toLowerCase(charAt2);
            int i2 = (lowerCase <= '9' ? lowerCase - '0' : (lowerCase - 'a') + 10) << 4;
            int i3 = lowerCase2 <= '9' ? i2 + (lowerCase2 - '0') : i2 + (lowerCase2 - 'a') + 10;
            if (i3 > 127) {
                i3 += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i / 2] = (byte) i3;
        }
        return bArr;
    }
}
