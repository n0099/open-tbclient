package com.kwad.sdk.core.diskcache.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.diskcache.b.c;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f71392a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.diskcache.a.a f71393b;

    /* renamed from: c  reason: collision with root package name */
    public Context f71394c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f71392a == null) {
                synchronized (a.class) {
                    if (f71392a == null) {
                        f71392a = new a();
                    }
                }
            }
            return f71392a;
        }
        return (a) invokeV.objValue;
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.f71393b == null) {
                com.kwad.sdk.core.d.a.e("DiskCache", "diskLruCache should be init before use");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"MissingPermission"})
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && this.f71393b == null) {
            try {
                this.f71394c = bVar.f71395a;
                if (!bVar.f71398d.exists()) {
                    bVar.f71398d.mkdirs();
                }
                this.f71393b = com.kwad.sdk.core.diskcache.a.a.a(bVar.f71398d, bVar.f71396b, 1, bVar.f71397c * 1024 * 1024);
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || d() || TextUtils.isEmpty(str)) {
            return;
        }
        c.a(this.f71393b, str, d.a(str));
    }

    public boolean a(String str, c.a aVar) {
        InterceptResult invokeLL;
        File b2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar)) == null) ? (d() || TextUtils.isEmpty(str) || !c.a(this.f71393b, str, d.a(str), aVar) || (b2 = b(str)) == null || !b2.exists()) ? false : true : invokeLL.booleanValue;
    }

    public boolean a(String str, @NonNull String str2, c.a aVar) {
        InterceptResult invokeLLL;
        File b2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, aVar)) == null) ? (d() || TextUtils.isEmpty(str) || !c.a(this.f71393b, str, d.a(str2), aVar) || (b2 = b(str2)) == null || !b2.exists()) ? false : true : invokeLLL.booleanValue;
    }

    public File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f71393b.a() : (File) invokeV.objValue;
    }

    @Nullable
    public File b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (d() || TextUtils.isEmpty(str)) {
                return null;
            }
            return new File(b(), d.a(str));
        }
        return (File) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                this.f71393b.c();
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                d.a(str, "cacheKey is not allowed empty");
                return this.f71393b.b(d.a(str));
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
