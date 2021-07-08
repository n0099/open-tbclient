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
/* loaded from: classes6.dex */
public final class ae extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40580a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Notification f881a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f882a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f883a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40581b;

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
        this.f40580a = i2;
        this.f883a = str;
        this.f882a = context;
        this.f40581b = str2;
        this.f881a = notification;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo184a() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b2 = ac.b(this.f40580a, this.f883a);
            return b2;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ac.b(this.f882a, this.f40581b, this.f40580a, this.f883a, this.f881a);
        }
    }
}
