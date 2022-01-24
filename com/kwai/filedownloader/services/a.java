package com.kwai.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes3.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CALLBACK a;

    /* renamed from: b  reason: collision with root package name */
    public volatile INTERFACE f58384b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f58385c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Object> f58386d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Context> f58387e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<Runnable> f58388f;

    public a(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58386d = new HashMap<>();
        this.f58387e = new ArrayList();
        this.f58388f = new ArrayList<>();
        this.f58385c = cls;
        this.a = b();
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
            if (!z && this.f58384b != null) {
                try {
                    a((a<CALLBACK, INTERFACE>) this.f58384b, (INTERFACE) this.a);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "release connect resources %s", this.f58384b);
            }
            this.f58384b = null;
            com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(z ? DownloadServiceConnectChangedEvent.ConnectStatus.lost : DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, this.f58385c));
        }
    }

    @Override // com.kwai.filedownloader.u
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            a(context, (Runnable) null);
        }
    }

    public void a(Context context, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, runnable) == null) {
            if (com.kwai.filedownloader.e.f.a(context)) {
                throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
            }
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.f58385c);
            if (runnable != null && !this.f58388f.contains(runnable)) {
                this.f58388f.add(runnable);
            }
            if (!this.f58387e.contains(context)) {
                this.f58387e.add(context);
            }
            context.bindService(intent, this, 1);
            context.startService(intent);
        }
    }

    public abstract void a(INTERFACE r1, CALLBACK callback);

    public abstract CALLBACK b();

    public abstract INTERFACE b(IBinder iBinder);

    public abstract void b(INTERFACE r1, CALLBACK callback);

    @Override // com.kwai.filedownloader.u
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? d() != null : invokeV.booleanValue;
    }

    public INTERFACE d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58384b : (INTERFACE) invokeV.objValue;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, componentName, iBinder) == null) {
            this.f58384b = b(iBinder);
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "onServiceConnected %s %s", componentName, this.f58384b);
            }
            try {
                b(this.f58384b, this.a);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            this.f58388f.clear();
            for (Runnable runnable : (List) this.f58388f.clone()) {
                runnable.run();
            }
            com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.f58385c));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, componentName) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "onServiceDisconnected %s %s", componentName, this.f58384b);
            }
            a(true);
        }
    }
}
