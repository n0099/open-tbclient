package com.bytedance.sdk.openadsdk.l;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.d.m;
/* loaded from: classes5.dex */
public class c implements g<Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31458a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.k.a.c f31459b;

    public c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31458a = z;
        if (z) {
            this.f31459b = com.bytedance.sdk.openadsdk.k.a.c.b();
        }
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.k.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.f31458a && (cVar = this.f31459b) != null) {
            cVar.c(str);
        }
    }

    public void b(String str) {
        com.bytedance.sdk.openadsdk.k.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.f31458a && (cVar = this.f31459b) != null) {
            cVar.g(str);
        }
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.k.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && this.f31458a && (cVar = this.f31459b) != null) {
            cVar.d(str);
        }
    }

    public void d(String str) {
        com.bytedance.sdk.openadsdk.k.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && this.f31458a && (cVar = this.f31459b) != null) {
            cVar.i(str);
        }
    }

    public void a(int i2) {
        com.bytedance.sdk.openadsdk.k.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.f31458a && (cVar = this.f31459b) != null) {
            cVar.a(i2);
        }
    }

    @Override // com.bytedance.sdk.component.d.g
    public void a(m<Bitmap> mVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) && this.f31458a && this.f31459b != null) {
            if (mVar == null || mVar.a() == null) {
                this.f31459b.b(202).h(com.bytedance.sdk.openadsdk.core.g.a(202));
                com.bytedance.sdk.openadsdk.k.a.a().k(this.f31459b);
            }
        }
    }

    @Override // com.bytedance.sdk.component.d.g
    public void a(int i2, String str, @Nullable Throwable th) {
        com.bytedance.sdk.openadsdk.k.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, th) == null) && this.f31458a && (cVar = this.f31459b) != null) {
            cVar.b(201).h(com.bytedance.sdk.openadsdk.core.g.a(201));
            com.bytedance.sdk.openadsdk.k.a.a().k(this.f31459b);
        }
    }
}
