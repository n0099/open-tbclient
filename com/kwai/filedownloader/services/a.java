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
/* loaded from: classes10.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CALLBACK f74648a;

    /* renamed from: b  reason: collision with root package name */
    public volatile INTERFACE f74649b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f74650c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Object> f74651d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Context> f74652e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<Runnable> f74653f;

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
        this.f74651d = new HashMap<>();
        this.f74652e = new ArrayList();
        this.f74653f = new ArrayList<>();
        this.f74650c = cls;
        this.f74648a = b();
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
            if (!z && this.f74649b != null) {
                try {
                    a((a<CALLBACK, INTERFACE>) this.f74649b, (INTERFACE) this.f74648a);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            if (com.kwai.filedownloader.f.d.f74563a) {
                com.kwai.filedownloader.f.d.c(this, "release connect resources %s", this.f74649b);
            }
            this.f74649b = null;
            com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(z ? DownloadServiceConnectChangedEvent.ConnectStatus.lost : DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, this.f74650c));
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
            if (com.kwai.filedownloader.f.d.f74563a) {
                com.kwai.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.f74650c);
            if (runnable != null && !this.f74653f.contains(runnable)) {
                this.f74653f.add(runnable);
            }
            if (!this.f74652e.contains(context)) {
                this.f74652e.add(context);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f74649b : (INTERFACE) invokeV.objValue;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, componentName, iBinder) == null) {
            this.f74649b = b(iBinder);
            if (com.kwai.filedownloader.f.d.f74563a) {
                com.kwai.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.f74649b);
            }
            try {
                b(this.f74649b, this.f74648a);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            this.f74653f.clear();
            for (Runnable runnable : (List) this.f74653f.clone()) {
                runnable.run();
            }
            com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.f74650c));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, componentName) == null) {
            if (com.kwai.filedownloader.f.d.f74563a) {
                com.kwai.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.f74649b);
            }
            a(true);
        }
    }
}
