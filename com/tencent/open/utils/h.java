package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public class h {
    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null || str2 != null) {
            if (str != null || str2 == null) {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int i = 0;
                while (i < split.length && i < split2.length) {
                    try {
                        int parseInt = Integer.parseInt(split[i]);
                        int parseInt2 = Integer.parseInt(split2[i]);
                        if (parseInt < parseInt2) {
                            return -1;
                        }
                        if (parseInt > parseInt2) {
                            return 1;
                        }
                        i++;
                    } catch (NumberFormatException e) {
                        return str.compareTo(str2);
                    }
                }
                if (split.length > i) {
                    return 1;
                }
                return split2.length > i ? -1 : 0;
            }
            return -1;
        }
        return 1;
    }

    public static boolean a(Context context, String str, String str2) {
        com.tencent.open.a.f.a("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (j.f(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static String b(Context context, String str) {
        String str2;
        Exception e;
        com.tencent.open.a.f.a("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(signatureArr[0].toByteArray());
            String a = j.a(messageDigest.digest());
            messageDigest.reset();
            com.tencent.open.a.f.a("openSDK_LOG.SystemUtils", "-->sign: " + a);
            messageDigest.update(j.i(packageName + "_" + a + "_" + str + ""));
            str2 = j.a(messageDigest.digest());
            try {
                messageDigest.reset();
                com.tencent.open.a.f.a("openSDK_LOG.SystemUtils", "-->signEncryped: " + str2);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                com.tencent.open.a.f.b("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
                return str2;
            }
        } catch (Exception e3) {
            str2 = "";
            e = e3;
        }
        return str2;
    }

    public static boolean a(Context context, Intent intent) {
        return (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static String a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static int c(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static int d(Context context, String str) {
        return a(a(context, Constants.PACKAGE_TIM), str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [362=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x00e2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x0052 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, String str2, int i) {
        IOException iOException;
        FileOutputStream fileOutputStream = null;
        boolean z = false;
        com.tencent.open.a.f.c("openSDK_LOG.SystemUtils", "-->extractSecureLib, libName: " + str);
        Context a = e.a();
        if (a == null) {
            com.tencent.open.a.f.c("openSDK_LOG.SystemUtils", "-->extractSecureLib, global context is null. ");
            return false;
        }
        SharedPreferences sharedPreferences = a.getSharedPreferences("secure_lib", 0);
        ?? file = new File(a.getFilesDir(), str2);
        if (file.exists()) {
            int i2 = sharedPreferences.getInt("version", 0);
            com.tencent.open.a.f.c("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: " + i + " | oldVersion: " + i2);
            iOException = i2;
            if (i == i2) {
                return true;
            }
        } else {
            File parentFile = file.getParentFile();
            iOException = file;
            if (parentFile != null) {
                iOException = file;
                if (parentFile.mkdirs()) {
                    try {
                        file.createNewFile();
                        iOException = file;
                    } catch (IOException e) {
                        e.printStackTrace();
                        iOException = e;
                    }
                }
            }
        }
        try {
            try {
                iOException = a.getAssets().open(str);
                try {
                    fileOutputStream = a.openFileOutput(str2, 0);
                    a(iOException, fileOutputStream);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putInt("version", i);
                    edit.commit();
                    if (iOException != 0) {
                        try {
                            iOException.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    z = true;
                } catch (Exception e4) {
                    e = e4;
                    com.tencent.open.a.f.b("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);
                    if (iOException != null) {
                        try {
                            iOException.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    return z;
                }
            } catch (Throwable th) {
                th = th;
                if (iOException != 0) {
                    try {
                        iOException.close();
                    } catch (IOException e7) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e8) {
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            iOException = null;
        } catch (Throwable th2) {
            th = th2;
            iOException = 0;
            if (iOException != 0) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
        return z;
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                com.tencent.open.a.f.c("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j);
                return j;
            }
        }
    }

    public static int a(String str) {
        if ("shareToQQ".equals(str)) {
            return Constants.REQUEST_QQ_SHARE;
        }
        if ("shareToQzone".equals(str)) {
            return Constants.REQUEST_QZONE_SHARE;
        }
        if ("addToQQFavorites".equals(str)) {
            return Constants.REQUEST_QQ_FAVORITES;
        }
        if ("sendToMyComputer".equals(str)) {
            return Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if ("shareToTroopBar".equals(str)) {
            return Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if ("action_login".equals(str)) {
            return Constants.REQUEST_LOGIN;
        }
        if ("action_request".equals(str)) {
            return Constants.REQUEST_API;
        }
        return -1;
    }

    public static String a(int i) {
        if (i == 10103) {
            return "shareToQQ";
        }
        if (i == 10104) {
            return "shareToQzone";
        }
        if (i == 10105) {
            return "addToQQFavorites";
        }
        if (i == 10106) {
            return "sendToMyComputer";
        }
        if (i == 10107) {
            return "shareToTroopBar";
        }
        if (i == 11101) {
            return "action_login";
        }
        if (i == 10100) {
            return "action_request";
        }
        return null;
    }
}
