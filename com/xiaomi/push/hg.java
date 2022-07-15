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
public class hg {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hg a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final Context f1185a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, hh> f1186a;

    public hg(Context context) {
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
        this.f1186a = new HashMap();
        this.f1185a = context;
    }

    public static hg a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
                return null;
            }
            if (a == null) {
                synchronized (hg.class) {
                    if (a == null) {
                        a = new hg(context);
                    }
                }
            }
            return a;
        }
        return (hg) invokeL.objValue;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, str2, str3, str4, Long.valueOf(j), str5})) == null) {
            hn hnVar = new hn();
            hnVar.d(str3);
            hnVar.c(str4);
            hnVar.a(j);
            hnVar.b(str5);
            hnVar.a(true);
            hnVar.a("push_sdk_channel");
            hnVar.e(str2);
            return a(hnVar, str);
        }
        return invokeCommon.booleanValue;
    }

    public hh a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            hh hhVar = this.f1186a.get("UPLOADER_PUSH_CHANNEL");
            if (hhVar != null) {
                return hhVar;
            }
            hh hhVar2 = this.f1186a.get("UPLOADER_HTTP");
            if (hhVar2 != null) {
                return hhVar2;
            }
            return null;
        }
        return (hh) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, hh> m1333a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1186a : (Map) invokeV.objValue;
    }

    public void a(hh hhVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hhVar, str) == null) {
            if (hhVar == null) {
                com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
            } else if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
            } else {
                m1333a().put(str, hhVar);
            }
        }
    }

    public boolean a(hn hnVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, hnVar, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m1027a("pkgName is null or empty, upload ClientUploadDataItem failed.");
                return false;
            } else if (com.xiaomi.push.service.bz.a(hnVar, false)) {
                return false;
            } else {
                if (TextUtils.isEmpty(hnVar.d())) {
                    hnVar.f(com.xiaomi.push.service.bz.a());
                }
                hnVar.g(str);
                com.xiaomi.push.service.ca.a(this.f1185a, hnVar);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean a(String str, String str2, long j, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j), str3})) == null) ? a(this.f1185a.getPackageName(), this.f1185a.getPackageName(), str, str2, j, str3) : invokeCommon.booleanValue;
    }
}
