package com.kwai.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, t {

    /* renamed from: b  reason: collision with root package name */
    private volatile INTERFACE f11282b;
    private final Class<?> c;
    private final HashMap<String, Object> d = new HashMap<>();
    private final List<Context> e = new ArrayList();
    private final ArrayList<Runnable> f = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private final CALLBACK f11281a = b();

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Class<?> cls) {
        this.c = cls;
    }

    private void a(boolean z) {
        if (!z && this.f11282b != null) {
            try {
                a((a<CALLBACK, INTERFACE>) this.f11282b, (INTERFACE) this.f11281a);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "release connect resources %s", this.f11282b);
        }
        this.f11282b = null;
        com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(z ? DownloadServiceConnectChangedEvent.ConnectStatus.lost : DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, this.c));
    }

    @Override // com.kwai.filedownloader.t
    public void a(Context context) {
        a(context, (Runnable) null);
    }

    public void a(Context context, Runnable runnable) {
        if (com.kwai.filedownloader.f.f.a(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        Intent intent = new Intent(context, this.c);
        if (runnable != null && !this.f.contains(runnable)) {
            this.f.add(runnable);
        }
        if (!this.e.contains(context)) {
            this.e.add(context);
        }
        context.bindService(intent, this, 1);
        context.startService(intent);
    }

    protected abstract void a(INTERFACE r1, CALLBACK callback);

    protected abstract CALLBACK b();

    protected abstract INTERFACE b(IBinder iBinder);

    protected abstract void b(INTERFACE r1, CALLBACK callback);

    @Override // com.kwai.filedownloader.t
    public boolean c() {
        return d() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public INTERFACE d() {
        return this.f11282b;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f11282b = b(iBinder);
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.f11282b);
        }
        try {
            b(this.f11282b, this.f11281a);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.f.clear();
        for (Runnable runnable : (List) this.f.clone()) {
            runnable.run();
        }
        com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.c));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.f11282b);
        }
        a(true);
    }
}
