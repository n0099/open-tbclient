package com.tencent.open.utils;

import android.annotation.SuppressLint;
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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 == 10103) {
                return "shareToQQ";
            }
            if (i2 == 10104) {
                return "shareToQzone";
            }
            if (i2 == 10105) {
                return "addToQQFavorites";
            }
            if (i2 == 10106) {
                return "sendToMyComputer";
            }
            if (i2 == 10107) {
                return "shareToTroopBar";
            }
            if (i2 == 11101) {
                return "action_login";
            }
            if (i2 == 10100) {
                return "action_request";
            }
            return null;
        }
        return (String) invokeI.objValue;
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
                String a2 = l.a(messageDigest.digest());
                messageDigest.reset();
                SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + a2);
                messageDigest.update(l.i(packageName + "_" + a2 + "_" + str + ""));
                str2 = l.a(messageDigest.digest());
                messageDigest.reset();
                StringBuilder sb = new StringBuilder();
                sb.append("-->signEncryped: ");
                sb.append(str2);
                SLog.v("openSDK_LOG.SystemUtils", sb.toString());
                return str2;
            } catch (Exception e2) {
                e2.printStackTrace();
                SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e2);
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static int c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) ? a(a(context, "com.tencent.mobileqq"), str) : invokeLL.intValue;
    }

    public static int d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) ? a(a(context, Constants.PACKAGE_TIM), str) : invokeLL.intValue;
    }

    public static int e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, str)) == null) ? a(a(context, Constants.PACKAGE_QQ_SPEED), str) : invokeLL.intValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !a() : invokeL.booleanValue;
    }

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (str == null && str2 == null) {
                return 0;
            }
            if (str == null || str2 != null) {
                if (str != null || str2 == null) {
                    String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    int i2 = 0;
                    while (i2 < split.length && i2 < split2.length) {
                        try {
                            int parseInt = Integer.parseInt(split[i2]);
                            int parseInt2 = Integer.parseInt(split2[i2]);
                            if (parseInt < parseInt2) {
                                return -1;
                            }
                            if (parseInt > parseInt2) {
                                return 1;
                            }
                            i2++;
                        } catch (NumberFormatException unused) {
                            return str.compareTo(str2);
                        }
                    }
                    if (split.length > i2) {
                        return 1;
                    }
                    return split2.length > i2 ? -1 : 0;
                }
                return -1;
            }
            return 1;
        }
        return invokeLL.intValue;
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

    public static String a(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, activity, str)) == null) {
            if (activity == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
                return "";
            }
            try {
                byte[] a2 = e.a(str);
                if (a2 == null) {
                    SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                    return "";
                }
                byte[] bArr = new byte[8];
                System.arraycopy(a2, 5, bArr, 0, 8);
                byte[] bArr2 = new byte[16];
                System.arraycopy(a2, 8, bArr2, 0, 16);
                return e.a(activity.getPackageName(), e.a(bArr2), bArr);
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e2);
                return "";
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
            } catch (PackageManager.NameNotFoundException e2) {
                SLog.e("openSDK_LOG.SystemUtils", "PackageManager.NameNotFoundException", e2);
                return false;
            } catch (Exception e3) {
                SLog.e("openSDK_LOG.SystemUtils", "Exception", e3);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, intent)) == null) ? (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) ? false : true : invokeLL.booleanValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? context.getApplicationInfo().loadLabel(context.getPackageManager()).toString() : (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        FileOutputStream fileOutputStream;
        InputStream open;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65547, null, str, str2, i2)) == null) {
            SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libName: " + str);
            Context a2 = f.a();
            if (a2 == null) {
                SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, global context is null. ");
                return false;
            }
            SharedPreferences sharedPreferences = a2.getSharedPreferences("secure_lib", 0);
            File file = new File(a2.getFilesDir(), str2);
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && parentFile.mkdirs()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                int i3 = sharedPreferences.getInt("version", 0);
                SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: " + i2 + " | oldVersion: " + i3);
                if (i2 == i3) {
                    return true;
                }
            }
            InputStream inputStream = null;
            r4 = null;
            FileOutputStream fileOutputStream2 = null;
            inputStream = null;
            try {
                open = a2.getAssets().open(str);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                fileOutputStream2 = a2.openFileOutput(str2, 0);
                a(open, fileOutputStream2);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("version", i2);
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
            } catch (Exception e4) {
                e = e4;
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

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, null, inputStream, outputStream)) != null) {
            return invokeLL.longValue;
        }
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
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if ("shareToQQ".equals(str)) {
                return 10103;
            }
            return "shareToQzone".equals(str) ? Constants.REQUEST_QZONE_SHARE : "addToQQFavorites".equals(str) ? Constants.REQUEST_QQ_FAVORITES : "sendToMyComputer".equals(str) ? Constants.REQUEST_SEND_TO_MY_COMPUTER : "shareToTroopBar".equals(str) ? Constants.REQUEST_SHARE_TO_TROOP_BAR : "action_login".equals(str) ? Constants.REQUEST_LOGIN : "action_request".equals(str) ? 10100 : -1;
        }
        return invokeL.intValue;
    }

    public static String a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            try {
                ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128);
                SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
                return applicationInfo.sourceDir;
            } catch (PackageManager.NameNotFoundException e2) {
                SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e2);
                return null;
            } catch (Exception e3) {
                SLog.e("openSDK_LOG.SystemUtils", "Exception", e3);
                return null;
            }
        }
        return (String) invokeL.objValue;
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
}
