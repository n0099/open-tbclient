package com.kwai.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Runnable> atw;
    public final Class<?> avI;
    public final CALLBACK awm;
    public volatile INTERFACE awn;
    public final HashMap<String, Object> awo;
    public final List<Context> awp;

    public a(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.awo = new HashMap<>();
        this.awp = new ArrayList();
        this.atw = new ArrayList<>();
        this.avI = cls;
        this.awm = CW();
    }

    private void a(Context context, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, runnable) == null) {
            if (com.kwai.filedownloader.e.f.dE(context)) {
                throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
            }
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.avI);
            if (!this.awp.contains(context)) {
                this.awp.add(context);
            }
            context.bindService(intent, this, 1);
            context.startService(intent);
        }
    }

    private void bE(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "release connect resources %s", this.awn);
            }
            this.awn = null;
            com.kwai.filedownloader.f.CE().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.avI));
        }
    }

    public abstract CALLBACK CW();

    public final INTERFACE Eq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.awn : (INTERFACE) invokeV.objValue;
    }

    public abstract void a(INTERFACE r1, CALLBACK callback);

    public abstract INTERFACE b(IBinder iBinder);

    @Override // com.kwai.filedownloader.u
    public final void dC(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            a(context, (Runnable) null);
        }
    }

    @Override // com.kwai.filedownloader.u
    public final boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Eq() != null : invokeV.booleanValue;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, componentName, iBinder) == null) {
            this.awn = b(iBinder);
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "onServiceConnected %s %s", componentName, this.awn);
            }
            try {
                a((a<CALLBACK, INTERFACE>) this.awn, (INTERFACE) this.awm);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.atw.clear();
            for (Runnable runnable : (List) this.atw.clone()) {
                runnable.run();
            }
            com.kwai.filedownloader.f.CE().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.avI));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, componentName) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "onServiceDisconnected %s %s", componentName, this.awn);
            }
            bE(true);
        }
    }
}
