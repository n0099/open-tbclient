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
/* loaded from: classes8.dex */
public final class ae extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Notification f862a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f863a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f864a;
    public final /* synthetic */ String b;

    public ae(int i, String str, Context context, String str2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, context, str2, notification};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.f864a = str;
        this.f863a = context;
        this.b = str2;
        this.f862a = notification;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo223a() {
        InterceptResult invokeV;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b = ac.b(this.a, this.f864a);
            return b;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ac.b(this.f863a, this.b, this.a, this.f864a, this.f862a);
        }
    }
}
