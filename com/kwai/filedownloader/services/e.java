package com.kwai.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.c.b;
import com.kwai.filedownloader.m;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class e extends b.a implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final g f67074a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<FileDownloadServiceProxy> f67075b;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(e eVar);
    }

    public e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {weakReference, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67075b = weakReference;
        this.f67074a = gVar;
    }

    @Override // com.kwai.filedownloader.services.i
    public IBinder a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.c.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f67074a.a();
        }
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(int i2, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, notification) == null) || (weakReference = this.f67075b) == null || weakReference.get() == null) {
            return;
        }
        this.f67075b.get().context.startForeground(i2, notification);
    }

    @Override // com.kwai.filedownloader.services.i
    public void a(Intent intent, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, intent, i2, i3) == null) {
            m.b().a(this);
        }
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(com.kwai.filedownloader.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
        }
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)}) == null) {
            this.f67074a.a(str, str2, z, i2, i3, i4, z2, bVar, z3);
        }
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (weakReference = this.f67075b) == null || weakReference.get() == null) {
            return;
        }
        this.f67075b.get().context.stopForeground(z);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.f67074a.b(i2) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) ? this.f67074a.a(str, str2) : invokeLL.booleanValue;
    }

    @Override // com.kwai.filedownloader.c.b
    public void b(com.kwai.filedownloader.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
        }
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f67074a.b() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this.f67074a.f(i2) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.c.b
    public long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? this.f67074a.c(i2) : invokeI.longValue;
    }

    @Override // com.kwai.filedownloader.c.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f67074a.c();
        }
    }

    @Override // com.kwai.filedownloader.c.b
    public long d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? this.f67074a.d(i2) : invokeI.longValue;
    }

    @Override // com.kwai.filedownloader.services.i
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m.b().a();
        }
    }

    @Override // com.kwai.filedownloader.c.b
    public byte e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? this.f67074a.e(i2) : invokeI.byteValue;
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? this.f67074a.g(i2) : invokeI.booleanValue;
    }
}
