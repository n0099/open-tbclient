package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes7.dex */
public class ag {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f39317a;

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f39318b;

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f39319c;

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleDateFormat f39320d;

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f39321e;

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f39322f;

    /* renamed from: g  reason: collision with root package name */
    public static final SimpleDateFormat f39323g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408734204, "Lcom/kwad/sdk/utils/ag;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408734204, "Lcom/kwad/sdk/utils/ag;");
                return;
            }
        }
        f39317a = new SimpleDateFormat("MM/dd", Locale.US);
        f39318b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        f39319c = new SimpleDateFormat("MM月dd日", Locale.US);
        f39320d = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
        f39321e = new SimpleDateFormat("HH:mm", Locale.US);
        f39322f = new SimpleDateFormat("MM-dd", Locale.US);
        f39323g = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? j <= 9999 ? String.valueOf(j) : j < 10000000 ? String.format("%.1fw", Double.valueOf(new BigDecimal(String.valueOf(j / 10000.0d)).setScale(1, 1).doubleValue())) : "999.9w" : (String) invokeJ.objValue;
    }

    public static String a(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, str)) == null) ? j <= 0 ? str : a(j) : (String) invokeJL.objValue;
    }

    public static String a(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, context, j)) == null) {
            if (j < 0) {
                return "";
            }
            long currentTimeMillis = System.currentTimeMillis();
            long abs = Math.abs(currentTimeMillis - j);
            return abs < 60000 ? "刚刚" : abs < 3600000 ? String.format("%d分钟前", Integer.valueOf((int) (abs / 60000))) : abs < 86400000 ? String.format("%d小时前", Integer.valueOf((int) (abs / 3600000))) : j >= (currentTimeMillis - ((((long) Calendar.getInstance().getTimeZone().getRawOffset()) + currentTimeMillis) % 86400000)) - 86400000 ? String.format("昨天%s", c(j)) : a(currentTimeMillis, j) ? d(j) : e(j);
        }
        return (String) invokeLJ.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, str2)) == null) ? TextUtils.isEmpty(str) ? str2 : str : (String) invokeLL.objValue;
    }

    public static boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            int i2 = calendar.get(1);
            calendar.setTimeInMillis(j2);
            return i2 == calendar.get(1);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str) : invokeL.booleanValue;
    }

    public static String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) {
            if (j <= 9999) {
                return String.valueOf(j);
            }
            int i2 = (j > 100000000L ? 1 : (j == 100000000L ? 0 : -1));
            double d2 = j;
            return i2 < 0 ? String.format("%.1fw", Double.valueOf(new BigDecimal(String.valueOf(d2 / 10000.0d)).setScale(1, 1).doubleValue())) : String.format("%.1f亿", Double.valueOf(new BigDecimal(String.valueOf(d2 / 1.0E8d)).setScale(1, 1).doubleValue()));
        }
        return (String) invokeJ.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.matches(".*\\.kpg.*");
        }
        return invokeL.booleanValue;
    }

    public static String c(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j)) == null) {
            synchronized (f39321e) {
                format = f39321e.format(new Date(j));
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? !TextUtils.isEmpty(str) ? str.trim().replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1") : "" : (String) invokeL.objValue;
    }

    public static String d(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65547, null, j)) == null) {
            synchronized (f39322f) {
                format = f39322f.format(new Date(j));
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String e(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65548, null, j)) == null) {
            synchronized (f39323g) {
                format = f39323g.format(new Date(j));
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }
}
