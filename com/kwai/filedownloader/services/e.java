package com.kwai.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.b.b;
import com.kwai.filedownloader.n;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public final class e extends b.a implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g a;
    public final WeakReference<FileDownloadServiceProxy> b;

    /* loaded from: classes5.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = weakReference;
        this.a = gVar;
    }

    @Override // com.kwai.filedownloader.b.b
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.a();
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public final void a(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, notification) == null) || (weakReference = this.b) == null || weakReference.get() == null) {
            return;
        }
        this.b.get().context.startForeground(i, notification);
    }

    @Override // com.kwai.filedownloader.b.b
    public final void a(com.kwai.filedownloader.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public final void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)}) == null) {
            this.a.a(str, str2, z, i, i2, i3, z2, bVar, z3);
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public final void a(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (weakReference = this.b) == null || weakReference.get() == null) {
            return;
        }
        this.b.get().context.stopForeground(z);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.a.a(i) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? this.a.a(str, str2) : invokeLL.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final void b(com.kwai.filedownloader.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.b() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? this.a.e(i) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final long c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? this.a.b(i) : invokeI.longValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.c();
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public final long d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? this.a.c(i) : invokeI.longValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final byte e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? this.a.d(i) : invokeI.byteValue;
    }

    @Override // com.kwai.filedownloader.services.i
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            n.b().a(this);
        }
    }

    @Override // com.kwai.filedownloader.services.i
    public final IBinder f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (IBinder) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) ? this.a.f(i) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.services.i
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            n.b().a();
        }
    }
}
