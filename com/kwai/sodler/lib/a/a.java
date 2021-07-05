package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.j;
import java.io.File;
/* loaded from: classes7.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public File f39749a;

    /* renamed from: b  reason: collision with root package name */
    public String f39750b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.c f39751c;

    /* renamed from: d  reason: collision with root package name */
    public String f39752d;

    /* renamed from: e  reason: collision with root package name */
    public String f39753e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwai.sodler.lib.b.b f39754f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39755g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f39756h;

    /* renamed from: i  reason: collision with root package name */
    public final String f39757i;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39756h = new byte[0];
        this.f39755g = false;
        this.f39757i = str;
        this.f39750b = str;
        this.f39751c = j.a().b();
    }

    public a a(@NonNull com.kwai.sodler.lib.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            this.f39754f = bVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39753e : (String) invokeV.objValue;
    }

    public abstract void a(Context context, String str);

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f39753e = str;
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f39752d = str;
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f39755g) {
                return true;
            }
            synchronized (this.f39756h) {
                z = this.f39755g;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39752d : (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f39750b = str;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f39755g) {
            return;
        }
        synchronized (this.f39756h) {
            this.f39755g = true;
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f39757i : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "Plugin{, ApkPath = '" + this.f39757i + "'}";
        }
        return (String) invokeV.objValue;
    }
}
