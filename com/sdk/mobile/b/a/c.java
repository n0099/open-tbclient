package com.sdk.mobile.b.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class c implements com.sdk.base.framework.b.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ String f69199a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f69200b;

    public c(a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69200b = aVar;
        this.f69199a = str;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            this.f69200b.a(i2, i3, str);
        }
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, String str, int i3, T t, String str2) {
        String str3;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), t, str2}) == null) {
            if (i2 == 0 && com.sdk.base.framework.a.a.c.a(this.f69199a).booleanValue()) {
                context = this.f69200b.f69193d;
                String a2 = com.sdk.base.framework.f.k.a.a(context, String.valueOf(t));
                if (a2 == null) {
                    this.f69200b.a(1, "SDK解密异常", 302001, a2, str2);
                    return;
                }
                str3 = a2;
            } else {
                str3 = t;
            }
            this.f69200b.a(i2, str, i3, str3, str2);
        }
    }
}
