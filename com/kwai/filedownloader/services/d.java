package com.kwai.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.b.b;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.e;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class d extends b.a implements e.b, i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RemoteCallbackList<com.kwai.filedownloader.b.a> a;

    /* renamed from: b  reason: collision with root package name */
    public final g f41775b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<FileDownloadServiceProxy> f41776c;

    public d(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
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
        this.a = new RemoteCallbackList<>();
        this.f41776c = weakReference;
        this.f41775b = gVar;
        com.kwai.filedownloader.message.e.a().a(this);
    }

    private synchronized int b(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        int beginBroadcast;
        RemoteCallbackList<com.kwai.filedownloader.b.a> remoteCallbackList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, messageSnapshot)) == null) {
            synchronized (this) {
                beginBroadcast = this.a.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        this.a.getBroadcastItem(i).a(messageSnapshot);
                    } catch (RemoteException e2) {
                        com.kwai.filedownloader.e.d.a(this, e2, "callback error", new Object[0]);
                        remoteCallbackList = this.a;
                    }
                }
                remoteCallbackList = this.a;
                remoteCallbackList.finishBroadcast();
            }
            return beginBroadcast;
        }
        return invokeL.intValue;
    }

    @Override // com.kwai.filedownloader.services.i
    public IBinder a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) ? this : (IBinder) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f41775b.a();
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public void a(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, notification) == null) || (weakReference = this.f41776c) == null || weakReference.get() == null) {
            return;
        }
        this.f41776c.get().context.startForeground(i, notification);
    }

    @Override // com.kwai.filedownloader.services.i
    public void a(Intent intent, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, intent, i, i2) == null) {
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public void a(com.kwai.filedownloader.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.a.register(aVar);
        }
    }

    @Override // com.kwai.filedownloader.message.e.b
    public void a(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, messageSnapshot) == null) {
            b(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)}) == null) {
            this.f41775b.a(str, str2, z, i, i2, i3, z2, bVar, z3);
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public void a(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (weakReference = this.f41776c) == null || weakReference.get() == null) {
            return;
        }
        this.f41776c.get().context.stopForeground(z);
    }

    @Override // com.kwai.filedownloader.b.b
    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? this.f41775b.b(i) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) ? this.f41775b.a(str, str2) : invokeLL.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public void b(com.kwai.filedownloader.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.a.unregister(aVar);
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f41775b.b() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? this.f41775b.f(i) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public long c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? this.f41775b.c(i) : invokeI.longValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f41775b.c();
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public long d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) ? this.f41775b.d(i) : invokeI.longValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public byte e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) ? this.f41775b.e(i) : invokeI.byteValue;
    }

    @Override // com.kwai.filedownloader.services.i
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            com.kwai.filedownloader.message.e.a().a((e.b) null);
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) ? this.f41775b.g(i) : invokeI.booleanValue;
    }
}
