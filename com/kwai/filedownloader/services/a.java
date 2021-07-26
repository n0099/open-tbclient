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
import com.kwai.filedownloader.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CALLBACK f37119a;

    /* renamed from: b  reason: collision with root package name */
    public volatile INTERFACE f37120b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f37121c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Object> f37122d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Context> f37123e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<Runnable> f37124f;

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
        this.f37122d = new HashMap<>();
        this.f37123e = new ArrayList();
        this.f37124f = new ArrayList<>();
        this.f37121c = cls;
        this.f37119a = b();
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
            if (!z && this.f37120b != null) {
                try {
                    a((a<CALLBACK, INTERFACE>) this.f37120b, (INTERFACE) this.f37119a);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.c(this, "release connect resources %s", this.f37120b);
            }
            this.f37120b = null;
            com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(z ? DownloadServiceConnectChangedEvent.ConnectStatus.lost : DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, this.f37121c));
        }
    }

    @Override // com.kwai.filedownloader.t
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            a(context, (Runnable) null);
        }
    }

    public void a(Context context, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, runnable) == null) {
            if (com.kwai.filedownloader.f.f.a(context)) {
                throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
            }
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.f37121c);
            if (runnable != null && !this.f37124f.contains(runnable)) {
                this.f37124f.add(runnable);
            }
            if (!this.f37123e.contains(context)) {
                this.f37123e.add(context);
            }
            context.bindService(intent, this, 1);
            context.startService(intent);
        }
    }

    public abstract void a(INTERFACE r1, CALLBACK callback);

    public abstract CALLBACK b();

    public abstract INTERFACE b(IBinder iBinder);

    public abstract void b(INTERFACE r1, CALLBACK callback);

    @Override // com.kwai.filedownloader.t
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? d() != null : invokeV.booleanValue;
    }

    public INTERFACE d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37120b : (INTERFACE) invokeV.objValue;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, componentName, iBinder) == null) {
            this.f37120b = b(iBinder);
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.f37120b);
            }
            try {
                b(this.f37120b, this.f37119a);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            this.f37124f.clear();
            for (Runnable runnable : (List) this.f37124f.clone()) {
                runnable.run();
            }
            com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.f37121c));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, componentName) == null) {
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.f37120b);
            }
            a(true);
        }
    }
}
