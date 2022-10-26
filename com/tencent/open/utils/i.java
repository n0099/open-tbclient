package com.tencent.open.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
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
        return (String) invokeI.objValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if ("shareToQQ".equals(str)) {
                return 10103;
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
                return 10100;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (str == null && str2 == null) {
                return 0;
            }
            if (str != null && str2 == null) {
                return 1;
            }
            if (str == null && str2 != null) {
                return -1;
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
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
                } catch (NumberFormatException unused) {
                    return str.compareTo(str2);
                }
            }
            if (split.length > i) {
                return 1;
            }
            if (split2.length <= i) {
                return 0;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, outputStream)) == null) {
            byte[] bArr = new byte[8192];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr, 0, 8192);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                    j += read;
                } else {
                    SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j);
                    return j;
                }
            }
        } else {
            return invokeLL.longValue;
        }
    }

    public static String a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            try {
                ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128);
                SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
                return applicationInfo.sourceDir;
            } catch (PackageManager.NameNotFoundException e) {
                SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e);
                return null;
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.SystemUtils", "Exception", e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, activity, str)) == null) {
            if (activity == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
                return "";
            }
            try {
                byte[] a = e.a(str);
                if (a == null) {
                    SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                    return "";
                }
                byte[] bArr = new byte[8];
                System.arraycopy(a, 5, bArr, 0, 8);
                byte[] bArr2 = new byte[16];
                System.arraycopy(a, 8, bArr2, 0, 16);
                return e.a(activity.getPackageName(), e.a(bArr2), bArr);
            } catch (Exception e) {
                SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (context == null || context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29 || a()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static int c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) {
            return a(a(context, "com.tencent.mobileqq"), str);
        }
        return invokeLL.intValue;
    }

    public static int d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) {
            return a(a(context, Constants.PACKAGE_TIM), str);
        }
        return invokeLL.intValue;
    }

    public static int e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, str)) == null) {
            return a(a(context, Constants.PACKAGE_QQ_SPEED), str);
        }
        return invokeLL.intValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", new Class[0]).invoke(Environment.class, new Object[0])).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, intent)) == null) {
            if (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, str2)) == null) {
            SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
            try {
                for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                    if (l.f(signature.toCharsString()).equals(str2)) {
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        FileOutputStream fileOutputStream;
        InputStream open;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65547, null, str, str2, i)) == null) {
            SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libName: " + str);
            Context a = f.a();
            if (a == null) {
                SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, global context is null. ");
                return false;
            }
            SharedPreferences sharedPreferences = a.getSharedPreferences("secure_lib", 0);
            File file = new File(a.getFilesDir(), str2);
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && parentFile.mkdirs()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = sharedPreferences.getInt("version", 0);
                SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: " + i + " | oldVersion: " + i2);
                if (i == i2) {
                    return true;
                }
            }
            InputStream inputStream = null;
            r4 = null;
            FileOutputStream fileOutputStream2 = null;
            inputStream = null;
            try {
                open = a.getAssets().open(str);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                fileOutputStream2 = a.openFileOutput(str2, 0);
                a(open, fileOutputStream2);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("version", i);
                edit.commit();
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException unused) {
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                FileOutputStream fileOutputStream3 = fileOutputStream2;
                inputStream = open;
                fileOutputStream = fileOutputStream3;
                try {
                    SLog.e("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                FileOutputStream fileOutputStream4 = fileOutputStream2;
                inputStream = open;
                fileOutputStream = fileOutputStream4;
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        }
        return invokeLLI.booleanValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            String str2 = "";
            SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
            try {
                String packageName = context.getPackageName();
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(signatureArr[0].toByteArray());
                String a = l.a(messageDigest.digest());
                messageDigest.reset();
                SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + a);
                messageDigest.update(l.i(packageName + "_" + a + "_" + str + ""));
                str2 = l.a(messageDigest.digest());
                messageDigest.reset();
                StringBuilder sb = new StringBuilder();
                sb.append("-->signEncryped: ");
                sb.append(str2);
                SLog.v("openSDK_LOG.SystemUtils", sb.toString());
                return str2;
            } catch (Exception e) {
                e.printStackTrace();
                SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            try {
                context.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);
                SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled true");
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                SLog.e("openSDK_LOG.SystemUtils", "PackageManager.NameNotFoundException", e);
                return false;
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.SystemUtils", "Exception", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
