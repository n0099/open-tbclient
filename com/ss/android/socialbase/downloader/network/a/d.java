package com.ss.android.socialbase.downloader.network.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.ss.android.socialbase.downloader.model.c> f62032b;

    /* renamed from: c  reason: collision with root package name */
    public i f62033c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62034d;

    /* renamed from: e  reason: collision with root package name */
    public long f62035e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f62036f;

    @Override // com.ss.android.socialbase.downloader.network.i
    public InputStream a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            InputStream inputStream = this.f62036f;
            if (inputStream != null) {
                return inputStream;
            }
            return null;
        }
        return (InputStream) invokeV.objValue;
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 >= 200 && i2 < 300 : invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            i iVar = this.f62033c;
            if (iVar != null) {
                return iVar.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (iVar = this.f62033c) == null) {
            return;
        }
        iVar.c();
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public void d() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (iVar = this.f62033c) == null) {
            return;
        }
        iVar.d();
    }

    public void e() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.a) {
                if (this.f62034d && this.f62033c == null) {
                    this.a.wait();
                }
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f62032b : (List) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                if (this.f62033c != null) {
                    return a(this.f62033c.b());
                }
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? System.currentTimeMillis() - this.f62035e < b.a : invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            i iVar = this.f62033c;
            if (iVar != null) {
                return iVar.a(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
