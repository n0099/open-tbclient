package d.a.l.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f46141a;

    /* renamed from: b  reason: collision with root package name */
    public static String f46142b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? TextUtils.isEmpty(f46142b) ? "armeabi-v7a" : f46142b : (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? e(context, "rtc") : (String) invokeL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? d(context, str, b(context)) : (String) invokeLL.objValue;
    }

    public static String d(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = b(context);
            }
            return str2 + File.separator + j(str);
        }
        return (String) invokeLLL.objValue;
    }

    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            String absolutePath = context.getFilesDir().getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            sb.append(File.separator);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
        return (String) invokeLL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            String str = "https://b.bdstatic.com/searchbox/androidvideo/" + h();
            f46141a = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (TextUtils.isEmpty(f46141a)) {
                f();
            }
            return c(context, f46141a) + File.separator + "jniLibs" + File.separator + a();
        }
        return (String) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return a() + "_rtc_5.5.1.zip";
        }
        return (String) invokeV.objValue;
    }

    public static boolean i(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return false;
            }
            String d2 = d(context, str, str2);
            return d.a.l.e.a.c(d2 + File.separator + "jniLibs" + File.separator + a() + File.separator + "libjingle_peerconnection_so.so");
        }
        return invokeLLL.booleanValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                String str2 = "";
                for (byte b2 : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str2 = str2 + hexString;
                }
                return str2.toLowerCase();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "armeabi-v7a";
            }
            f46142b = str;
        }
    }
}
