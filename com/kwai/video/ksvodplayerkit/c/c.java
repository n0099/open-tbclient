package com.kwai.video.ksvodplayerkit.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.util.Locale;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f39920a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.kwai.video.ksvodplayerkit.a f39921b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-593728436, "Lcom/kwai/video/ksvodplayerkit/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-593728436, "Lcom/kwai/video/ksvodplayerkit/c/c;");
                return;
            }
        }
        f39920a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return invokeL.intValue;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, bArr, i2, i3)) == null) {
            if (bArr != null) {
                if (i2 < 0 || i2 + i3 > bArr.length) {
                    throw new IndexOutOfBoundsException();
                }
                int i4 = i3 * 2;
                char[] cArr = new char[i4];
                int i5 = 0;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = bArr[i6 + i2] & 255;
                    int i8 = i5 + 1;
                    char[] cArr2 = f39920a;
                    cArr[i5] = cArr2[i7 >> 4];
                    i5 = i8 + 1;
                    cArr[i8] = cArr2[i7 & 15];
                }
                return new String(cArr, 0, i4);
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeLII.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.toLowerCase().startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
        }
        return invokeL.booleanValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
        return invokeL.intValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().contains(".m3u8");
        }
        return invokeL.booleanValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (f39921b != null) {
                return f39921b.a(str);
            }
            String lowerCase = d(str).toLowerCase(Locale.US);
            try {
                String path = Uri.parse(str).getPath();
                if (!TextUtils.isEmpty(path)) {
                    return e(path) + lowerCase;
                }
            } catch (Exception e2) {
                com.kwai.video.ksvodplayerkit.a.b.e("VodPlayerUtils", e2.getMessage());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str != null && !TextUtils.isEmpty(str)) {
                try {
                    String path = Uri.parse(str).getPath();
                    if (path == null) {
                        return ".xxx";
                    }
                    int lastIndexOf = path.lastIndexOf(46);
                    String substring = path.substring(lastIndexOf);
                    return (lastIndexOf < 0 || lastIndexOf >= path.length() + (-2)) ? ".mp4" : substring != null ? substring.toLowerCase() : substring;
                } catch (Throwable th) {
                    com.kwai.video.ksvodplayerkit.a.b.e("VodPlayerUtils", "fail to parse ext from url: " + str, th);
                }
            }
            return ".mp4";
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            String str2 = null;
            if (str != null) {
                try {
                    if (str.length() != 0) {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        if (messageDigest == null) {
                            return null;
                        }
                        messageDigest.update(str.getBytes("UTF-8"));
                        byte[] digest = messageDigest.digest();
                        if (digest == null || digest.length < 1) {
                            return null;
                        }
                        str2 = a(digest, 0, digest.length);
                        return str2;
                    }
                    return "";
                } catch (Throwable unused) {
                    return str2;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
