package com.dxmpay.wallet.utils;

import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes11.dex */
public class StringUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern AcceptUrlPat;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f63606a;

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f63607b;

    /* renamed from: c  reason: collision with root package name */
    public static WeakReference<Paint> f63608c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1990167514, "Lcom/dxmpay/wallet/utils/StringUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1990167514, "Lcom/dxmpay/wallet/utils/StringUtil;");
                return;
            }
        }
        f63606a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        AcceptUrlPat = Pattern.compile("^(https?://|file:///android_asset/).*");
        f63607b = Pattern.compile("(.*)<color=#?((?:\\d|[a-f]){3,8})>(\\d+)</color>(.*)", 2);
        f63608c = new WeakReference<>(null);
    }

    public StringUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int i4 = 0;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int i5 = 255;
            String lowerCase = str.toLowerCase();
            try {
                String substring = lowerCase.substring(0, 2);
                String substring2 = lowerCase.substring(2, 4);
                String substring3 = lowerCase.substring(4, 6);
                String substring4 = lowerCase.substring(6, 8);
                i5 = Integer.valueOf(substring, 16).intValue();
                i2 = Integer.valueOf(substring2, 16).intValue();
                try {
                    i3 = Integer.valueOf(substring3, 16).intValue();
                    try {
                        i4 = Integer.valueOf(substring4, 16).intValue();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i3 = 0;
                    return Color.argb(i5, i2, i3, i4);
                }
            } catch (Exception unused3) {
                i2 = 0;
            }
            return Color.argb(i5, i2, i3, i4);
        }
        return invokeL.intValue;
    }

    public static String arrayToString(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) {
            if (bArr == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            i2 = (i2 < 0 || bArr.length < i2) ? 0 : 0;
            int i4 = i3 + i2;
            if (i4 > bArr.length) {
                i4 = bArr.length;
            }
            while (i2 < i4) {
                sb.append(b(bArr[i2]));
                i2++;
            }
            return sb.toString();
        }
        return (String) invokeLII.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : 0x000f: AGET  (r1v5 char A[IMMUTABLE_TYPE, REMOVE]) = 
      (wrap: char[] : 0x000d: SGET  (r2v1 char[] A[IMMUTABLE_TYPE, REMOVE]) =  com.dxmpay.wallet.utils.StringUtil.a char[])
      (wrap: int : 0x000b: ARITH  (r1v4 int A[REMOVE]) = (wrap: int : 0x0009: ARITH  (r1v3 int A[REMOVE]) = (r4v0 byte) >> (4 byte)) & (15 int))
    ), (wrap: char : 0x0018: AGET  (r4v2 char A[IMMUTABLE_TYPE, REMOVE]) = 
      (wrap: char[] : 0x0016: SGET  (r1v6 char[] A[IMMUTABLE_TYPE, REMOVE]) =  com.dxmpay.wallet.utils.StringUtil.a char[])
      (wrap: int : 0x0014: ARITH  (r4v1 int A[REMOVE]) = (r4v0 byte) & (15 byte))
    )] */
    public static String b(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(InputDeviceCompat.SOURCE_TRACKBALL, null, b2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(f63606a[(b2 >> 4) & 15]);
            sb.append(f63606a[b2 & 15]);
            return sb.toString();
        }
        return (String) invokeB.objValue;
    }

    public static float getStringWidth(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(AdIconUtil.AD_TEXT_ID, null, str, f2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0.0f;
            }
            Paint paint = f63608c.get();
            if (paint == null) {
                paint = new Paint();
                f63608c = new WeakReference<>(paint);
            }
            paint.setTextSize(f2);
            return paint.measureText(str);
        }
        return invokeLF.floatValue;
    }

    public static CharSequence parseColorString(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, charSequence)) == null) {
            if (charSequence == null) {
                return null;
            }
            Matcher matcher = f63607b.matcher(charSequence);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (matcher.matches()) {
                spannableStringBuilder.append((CharSequence) matcher.group(1));
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(a(matcher.group(2)));
                String group = matcher.group(3);
                spannableStringBuilder.append((CharSequence) group);
                spannableStringBuilder.setSpan(foregroundColorSpan, spannableStringBuilder.length() - group.length(), spannableStringBuilder.length(), 33);
                spannableStringBuilder.append((CharSequence) matcher.group(4));
            } else {
                spannableStringBuilder.append(charSequence);
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public static String urlParam2JsonStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return com.baidu.android.common.others.lang.StringUtil.EMPTY_ARRAY;
            }
            StringBuilder sb = new StringBuilder(com.baidu.android.common.others.lang.StringUtil.ARRAY_START);
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (!TextUtils.isEmpty(split[0])) {
                    sb.append(split[0]);
                    sb.append(":\"");
                    if (2 == split.length) {
                        sb.append(split[1]);
                    }
                    sb.append("\",");
                }
            }
            sb.setCharAt(sb.length() - 1, ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
