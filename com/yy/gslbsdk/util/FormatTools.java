package com.yy.gslbsdk.util;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes6.dex */
public class FormatTools {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FormatTools";
    public static SimpleDateFormat full_date_format1;
    public static SimpleDateFormat full_date_format2;
    public static SimpleDateFormat full_date_time_format1;
    public static SimpleDateFormat full_date_time_format2;
    public static SimpleDateFormat full_date_time_format3;
    public static SimpleDateFormat full_time_format;
    public static SimpleDateFormat time_hour_minute_format;
    public static DecimalFormat two_decimal;
    public static SimpleDateFormat year_format;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(423499992, "Lcom/yy/gslbsdk/util/FormatTools;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(423499992, "Lcom/yy/gslbsdk/util/FormatTools;");
                return;
            }
        }
        full_date_time_format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        full_date_time_format2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        full_date_time_format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        full_date_format1 = new SimpleDateFormat("yyyy/MM/dd");
        full_date_format2 = new SimpleDateFormat("yyyy-MM-dd");
        full_time_format = new SimpleDateFormat("HH:mm:ss");
        time_hour_minute_format = new SimpleDateFormat("HH:mm");
        year_format = new SimpleDateFormat("yyyy");
        two_decimal = new DecimalFormat("0.00");
    }

    public FormatTools() {
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

    public static boolean containInList(List<?> list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, obj)) == null) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().equals(obj)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int daysOfTwo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            try {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                calendar.setTime(simpleDateFormat.parse(str + " 00:00:00"));
                int i2 = calendar.get(6);
                calendar.setTime(simpleDateFormat.parse(str2 + " 00:00:00"));
                return calendar.get(6) - i2;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static String getDateStr(SimpleDateFormat simpleDateFormat, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, simpleDateFormat, j)) == null) {
            try {
                return simpleDateFormat.format(new Date(j));
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return null;
            }
        }
        return (String) invokeLJ.objValue;
    }

    public static long getDateTimestamp(SimpleDateFormat simpleDateFormat, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, simpleDateFormat, str)) == null) {
            try {
                if (str == null) {
                    return new Date().getTime();
                }
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e2) {
                LogTools.printWarning(TAG, e2);
                return 0L;
            }
        }
        return invokeLL.longValue;
    }

    public static String getDayBeginFromOne(SimpleDateFormat simpleDateFormat, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, simpleDateFormat, str, i2)) == null) {
            try {
                Calendar calendar = Calendar.getInstance();
                if (str == null) {
                    calendar.setTime(new Date());
                } else {
                    calendar.setTime(simpleDateFormat.parse(str));
                }
                calendar.add(5, i2);
                return simpleDateFormat.format(calendar.getTime());
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return null;
            }
        }
        return (String) invokeLLI.objValue;
    }

    public static Date getSecondBeginFromOne(SimpleDateFormat simpleDateFormat, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, simpleDateFormat, str, i2)) == null) {
            try {
                Calendar calendar = Calendar.getInstance();
                if (str == null) {
                    calendar.setTime(new Date());
                } else {
                    calendar.setTime(simpleDateFormat.parse(str));
                }
                calendar.add(13, i2);
                return calendar.getTime();
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return null;
            }
        }
        return (Date) invokeLLI.objValue;
    }
}
