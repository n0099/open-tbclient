package com.kwai.filedownloader.services;

import android.app.Notification;
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
/* loaded from: classes5.dex */
public final class d extends b.a implements e.b, i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RemoteCallbackList<com.kwai.filedownloader.b.a> awx;
    public final g awy;
    public final WeakReference<FileDownloadServiceProxy> awz;

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
        this.awx = new RemoteCallbackList<>();
        this.awz = weakReference;
        this.awy = gVar;
        com.kwai.filedownloader.message.e.Eg().a(this);
    }

    private synchronized int v(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        int beginBroadcast;
        RemoteCallbackList<com.kwai.filedownloader.b.a> remoteCallbackList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, messageSnapshot)) == null) {
            synchronized (this) {
                beginBroadcast = this.awx.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        this.awx.getBroadcastItem(i).q(messageSnapshot);
                    } catch (RemoteException e) {
                        com.kwai.filedownloader.e.d.a(this, e, "callback error", new Object[0]);
                        remoteCallbackList = this.awx;
                    }
                }
                remoteCallbackList = this.awx;
                remoteCallbackList.finishBroadcast();
            }
            return beginBroadcast;
        }
        return invokeL.intValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final void DW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.awy.DW();
        }
    }

    @Override // com.kwai.filedownloader.services.i
    public final void EC() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwai.filedownloader.services.i
    public final IBinder ED() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (IBinder) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean Z(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.awy.ab(str, str2) : invokeLL.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final void a(com.kwai.filedownloader.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.awx.register(aVar);
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public final void b(com.kwai.filedownloader.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.awx.unregister(aVar);
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public final void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)}) == null) {
            this.awy.b(str, str2, z, i, i2, i3, z2, bVar, z3);
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean bW(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? this.awy.bW(i) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final byte bX(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? this.awy.bX(i) : invokeI.byteValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean bY(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? this.awy.bY(i) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean cq(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? this.awy.cq(i) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final long cr(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? this.awy.cC(i) : invokeI.longValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final long cs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? this.awy.cs(i) : invokeI.longValue;
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.awy.isIdle() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.services.i
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            com.kwai.filedownloader.message.e.Eg().a(null);
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public final void pauseAllTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.awy.EE();
        }
    }

    @Override // com.kwai.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, messageSnapshot) == null) {
            v(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.b.b
    public final void startForeground(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048593, this, i, notification) == null) || (weakReference = this.awz) == null || weakReference.get() == null) {
            return;
        }
        this.awz.get().context.startForeground(i, notification);
    }

    @Override // com.kwai.filedownloader.b.b
    public final void stopForeground(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (weakReference = this.awz) == null || weakReference.get() == null) {
            return;
        }
        this.awz.get().context.stopForeground(z);
    }
}
