package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes9.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, context, str, str2, str3, str4)) == null) {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            grsBaseInfo.setSerCountry(str4);
            if (!TextUtils.isEmpty(str3)) {
                grsBaseInfo.setAppName(str3);
            }
            String synGetGrsUrl = new GrsClient(context, grsBaseInfo).synGetGrsUrl(str, str2);
            if (TextUtils.isEmpty(synGetGrsUrl)) {
                HMSLog.i("QueryGrs", "Query Grs base url is empty.");
                return "";
            }
            HMSLog.i("QueryGrs", "Query Grs base url success.");
            return synGetGrsUrl;
        }
        return (String) invokeLLLLL.objValue;
    }
}
