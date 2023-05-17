package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ErrorEnum a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (TextUtils.isEmpty(BaseUtils.getLocalToken(context, null))) {
                if (AutoInitHelper.isAutoInitEnabled(context)) {
                    HMSLog.e("TokenUtil", "Token not exist, try auto init");
                    AutoInitHelper.doAutoInit(context);
                    return ErrorEnum.ERROR_AUTO_INITIALIZING;
                }
                HMSLog.e("TokenUtil", "Token not exist");
                return ErrorEnum.ERROR_NO_TOKEN;
            }
            return ErrorEnum.SUCCESS;
        }
        return (ErrorEnum) invokeL.objValue;
    }
}
