package com.qq.e.comm.managers.status;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes7.dex */
public class APPStatus {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Context f42447b;

    public APPStatus(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f42447b = context;
    }

    public String getAPPID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String getAPPName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42447b.getPackageName() : (String) invokeV.objValue;
    }

    public String getAPPRealName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String aPPName = getAPPName();
            if (!StringUtil.isEmpty(aPPName)) {
                try {
                    return this.f42447b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f42447b.getPackageManager()).toString();
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getAPPVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String aPPName = getAPPName();
            if (!StringUtil.isEmpty(aPPName)) {
                try {
                    return this.f42447b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}
