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
/* loaded from: classes10.dex */
public final class ae extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f78108a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Notification f885a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f886a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f887a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f78109b;

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
        this.f78108a = i2;
        this.f887a = str;
        this.f886a = context;
        this.f78109b = str2;
        this.f885a = notification;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo187a() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b2 = ac.b(this.f78108a, this.f887a);
            return b2;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ac.b(this.f886a, this.f78109b, this.f78108a, this.f887a, this.f885a);
        }
    }
}
