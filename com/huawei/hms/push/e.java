package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "e";
    public transient /* synthetic */ FieldHolder $fh;

    public static Bundle a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, str, str2)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("sdkVer", String.valueOf(60500300));
            bundle.putString("pkgName", context.getPackageName());
            bundle.putString("aaid", HmsInstanceId.getInstance(context).getId());
            PushProxy proxy = ProxyCenter.getProxy();
            if (proxy != null) {
                bundle.putString("proxyType", proxy.getProxyType());
            }
            bundle.putString("msgId", str);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString(RemoteMessageConst.ANALYTIC_INFO, str2);
            }
            return bundle;
        }
        return (Bundle) invokeLLL.objValue;
    }

    public static void a(Context context, Bundle bundle, String str) {
        PushBaseAnalytics pushAnalytics;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65537, null, context, bundle, str) != null) || bundle == null || (pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics()) == null) {
            return;
        }
        bundle.putString("sdk_version", String.valueOf(60500300));
        String str2 = a;
        HMSLog.i(str2, "eventId:" + str);
        pushAnalytics.report(context, str, bundle);
    }

    public static void a(Context context, String str, String str2, String str3) {
        PushBaseAnalytics pushAnalytics;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65538, null, context, str, str2, str3) != null) || (pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics()) == null) {
            return;
        }
        Bundle a2 = a(context, str, str2);
        String str4 = a;
        HMSLog.i(str4, "eventId:" + str3);
        pushAnalytics.report(context, str3, a2);
    }
}
