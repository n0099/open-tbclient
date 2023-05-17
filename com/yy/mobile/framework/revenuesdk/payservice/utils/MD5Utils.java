package com.yy.mobile.framework.revenuesdk.payservice.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes10.dex */
public class MD5Utils {
    public static final String TAG = "MD5Utils";

    public static String bufferToHex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return bufferToHex(bArr, 0, bArr.length);
    }

    public static String fileMd5(File file) {
        if (file == null) {
            return "";
        }
        try {
            return getFileMD5String(file);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getFileMd5String(String str) throws IOException {
        if (str != null && str.length() != 0) {
            return getFileMD5String(new File(str));
        }
        return null;
    }

    public static String getMD5String(String str) {
        if (str == null) {
            return null;
        }
        return getMD5String(str.getBytes());
    }

    public static String bufferToHex(byte[] bArr, int i, int i2) {
        if (bArr != null && i >= 0 && i2 >= 0) {
            StringBuilder sb = new StringBuilder(i2 * 2);
            int i3 = i2 + i;
            while (i < i3) {
                String hexString = Integer.toHexString(bArr[i] & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
                i++;
            }
            return sb.toString();
        }
        return null;
    }

    public static String fileMd5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return getFileMd5String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getMD5String(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return bufferToHex(messageDigest.digest());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0039 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0057 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0007 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.io.File */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.security.DigestInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: java.security.DigestInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.security.DigestInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: java.security.DigestInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: java.security.DigestInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: java.security.DigestInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v9, resolved type: java.security.DigestInputStream */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
        if (r5 != 0) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.security.DigestInputStream] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.security.DigestInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getFileMD5String(File file) throws IOException {
        FileInputStream fileInputStream;
        String str = null;
        if (file != 0) {
            try {
                if (file.exists()) {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        fileInputStream = new FileInputStream(file);
                        try {
                            file = new DigestInputStream(fileInputStream, messageDigest);
                            try {
                                while (file.read(new byte[4096]) > 0) {
                                }
                                str = bufferToHex(file.getMessageDigest().digest());
                                fileInputStream.close();
                            } catch (NoSuchAlgorithmException e) {
                                e = e;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                            }
                        } catch (NoSuchAlgorithmException e2) {
                            e = e2;
                            file = 0;
                        } catch (Throwable th) {
                            th = th;
                            file = 0;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (file != 0) {
                                file.close();
                            }
                            throw th;
                        }
                    } catch (NoSuchAlgorithmException e3) {
                        e = e3;
                        file = 0;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        fileInputStream = null;
                        th = th2;
                        file = 0;
                    }
                    file.close();
                    return str;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }
}
