package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
/* loaded from: classes2.dex */
public final class ae extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f71400a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Notification f886a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f887a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f888a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f71401b;

    public ae(int i2, String str, Context context, String str2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, context, str2, notification};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71400a = i2;
        this.f888a = str;
        this.f887a = context;
        this.f71401b = str2;
        this.f886a = notification;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo187a() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b2 = ac.b(this.f71400a, this.f888a);
            return b2;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ac.b(this.f887a, this.f71401b, this.f71400a, this.f888a, this.f886a);
        }
    }
}
