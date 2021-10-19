package com.bytedance.sdk.openadsdk.k;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.ILoaderListener;
import com.bytedance.sdk.component.image.ImageResponse;
import com.bytedance.sdk.openadsdk.core.g;
/* loaded from: classes9.dex */
public class b implements ILoaderListener<Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f68318a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.j.a.c f68319b;

    public b(boolean z) {
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
        this.f68318a = z;
        if (z) {
            this.f68319b = com.bytedance.sdk.openadsdk.j.a.c.b();
        }
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.j.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.f68318a && (cVar = this.f68319b) != null) {
            cVar.c(str);
        }
    }

    public void b(String str) {
        com.bytedance.sdk.openadsdk.j.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.f68318a && (cVar = this.f68319b) != null) {
            cVar.f(str);
        }
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.j.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.f68318a && (cVar = this.f68319b) != null) {
            cVar.d(str);
        }
    }

    public void d(String str) {
        com.bytedance.sdk.openadsdk.j.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.f68318a && (cVar = this.f68319b) != null) {
            cVar.h(str);
        }
    }

    @Override // com.bytedance.sdk.component.image.ILoaderListener
    public void onFailed(int i2, String str, @Nullable Throwable th) {
        com.bytedance.sdk.openadsdk.j.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048581, this, i2, str, th) == null) && this.f68318a && (cVar = this.f68319b) != null) {
            cVar.b(201).g(g.a(201));
            com.bytedance.sdk.openadsdk.j.a.a().k(this.f68319b);
        }
    }

    @Override // com.bytedance.sdk.component.image.ILoaderListener
    public void onSuccess(ImageResponse<Bitmap> imageResponse) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, imageResponse) == null) && this.f68318a && this.f68319b != null) {
            if (imageResponse == null || imageResponse.getResult() == null) {
                this.f68319b.b(202).g(g.a(202));
                com.bytedance.sdk.openadsdk.j.a.a().k(this.f68319b);
            }
        }
    }

    public void a(int i2) {
        com.bytedance.sdk.openadsdk.j.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.f68318a && (cVar = this.f68319b) != null) {
            cVar.a(i2);
        }
    }
}
