package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.utils.Util;
import java.util.Map;
/* loaded from: classes10.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, ResponseHeader responseHeader, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, context, responseHeader, str) == null) {
            HiAnalyticsUtil.getInstance();
            Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
            if (!TextUtils.isEmpty(str)) {
                mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(str));
            }
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_API_CALLED, mapFromRequestHeader);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, context, str, str2, str3, str4) == null) {
            Map<String, String> mapForBi = a.getMapForBi(context, str);
            mapForBi.put("appid", str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = TransactionIdCreater.getId(str2, str);
            }
            mapForBi.put("transId", str3);
            mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "req");
            if (!TextUtils.isEmpty(str4)) {
                mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(str4));
            }
            mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_API_CALLED, mapForBi);
        }
    }
}
