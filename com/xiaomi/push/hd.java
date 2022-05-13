package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hd {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hd a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final Context f450a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, he> f451a;

    public hd(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f451a = new HashMap();
        this.f450a = context;
    }

    public static hd a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
                return null;
            }
            if (a == null) {
                synchronized (hd.class) {
                    if (a == null) {
                        a = new hd(context);
                    }
                }
            }
            return a;
        }
        return (hd) invokeL.objValue;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, str2, str3, str4, Long.valueOf(j), str5})) == null) {
            hj hjVar = new hj();
            hjVar.d(str3);
            hjVar.c(str4);
            hjVar.a(j);
            hjVar.b(str5);
            hjVar.a(true);
            hjVar.a("push_sdk_channel");
            hjVar.e(str2);
            return a(hjVar, str);
        }
        return invokeCommon.booleanValue;
    }

    public he a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            he heVar = this.f451a.get("UPLOADER_PUSH_CHANNEL");
            if (heVar != null) {
                return heVar;
            }
            he heVar2 = this.f451a.get("UPLOADER_HTTP");
            if (heVar2 != null) {
                return heVar2;
            }
            return null;
        }
        return (he) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, he> m410a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f451a : (Map) invokeV.objValue;
    }

    public void a(he heVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, heVar, str) == null) {
            if (heVar == null) {
                com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
            } else if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
            } else {
                m410a().put(str, heVar);
            }
        }
    }

    public boolean a(hj hjVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, hjVar, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m109a("pkgName is null or empty, upload ClientUploadDataItem failed.");
                return false;
            } else if (com.xiaomi.push.service.bm.a(hjVar, false)) {
                return false;
            } else {
                if (TextUtils.isEmpty(hjVar.d())) {
                    hjVar.f(com.xiaomi.push.service.bm.a());
                }
                hjVar.g(str);
                com.xiaomi.push.service.bn.a(this.f450a, hjVar);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean a(String str, String str2, long j, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j), str3})) == null) ? a(this.f450a.getPackageName(), this.f450a.getPackageName(), str, str2, j, str3) : invokeCommon.booleanValue;
    }
}
