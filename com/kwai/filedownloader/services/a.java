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
    public final CALLBACK a;
    public volatile INTERFACE b;
    public final Class<?> c;
    public final HashMap<String, Object> d;
    public final List<Context> e;
    public final ArrayList<Runnable> f;

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
        this.d = new HashMap<>();
        this.e = new ArrayList();
        this.f = new ArrayList<>();
        this.c = cls;
        this.a = a();
    }

    private void a(Context context, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, runnable) == null) {
            if (com.kwai.filedownloader.e.f.a(context)) {
                throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
            }
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.c);
            if (!this.e.contains(context)) {
                this.e.add(context);
            }
            context.bindService(intent, this, 1);
            context.startService(intent);
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "release connect resources %s", this.b);
            }
            this.b = null;
            com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.c));
        }
    }

    public abstract CALLBACK a();

    public abstract INTERFACE a(IBinder iBinder);

    @Override // com.kwai.filedownloader.u
    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            a(context, (Runnable) null);
        }
    }

    public abstract void a(INTERFACE r1, CALLBACK callback);

    public final INTERFACE b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (INTERFACE) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.u
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? b() != null : invokeV.booleanValue;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, componentName, iBinder) == null) {
            this.b = a(iBinder);
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "onServiceConnected %s %s", componentName, this.b);
            }
            try {
                a((a<CALLBACK, INTERFACE>) this.b, (INTERFACE) this.a);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.f.clear();
            for (Runnable runnable : (List) this.f.clone()) {
                runnable.run();
            }
            com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.c));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, componentName) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "onServiceDisconnected %s %s", componentName, this.b);
            }
            a(true);
        }
    }
}
