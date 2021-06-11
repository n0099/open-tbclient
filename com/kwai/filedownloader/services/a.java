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
/* loaded from: classes7.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, t {

    /* renamed from: b  reason: collision with root package name */
    public volatile INTERFACE f37862b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f37863c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Object> f37864d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final List<Context> f37865e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<Runnable> f37866f = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public final CALLBACK f37861a = b();

    public a(Class<?> cls) {
        this.f37863c = cls;
    }

    private void a(boolean z) {
        if (!z && this.f37862b != null) {
            try {
                a((a<CALLBACK, INTERFACE>) this.f37862b, (INTERFACE) this.f37861a);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        if (com.kwai.filedownloader.f.d.f37776a) {
            com.kwai.filedownloader.f.d.c(this, "release connect resources %s", this.f37862b);
        }
        this.f37862b = null;
        com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(z ? DownloadServiceConnectChangedEvent.ConnectStatus.lost : DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, this.f37863c));
    }

    @Override // com.kwai.filedownloader.t
    public void a(Context context) {
        a(context, (Runnable) null);
    }

    public void a(Context context, Runnable runnable) {
        if (com.kwai.filedownloader.f.f.a(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        if (com.kwai.filedownloader.f.d.f37776a) {
            com.kwai.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        Intent intent = new Intent(context, this.f37863c);
        if (runnable != null && !this.f37866f.contains(runnable)) {
            this.f37866f.add(runnable);
        }
        if (!this.f37865e.contains(context)) {
            this.f37865e.add(context);
        }
        context.bindService(intent, this, 1);
        context.startService(intent);
    }

    public abstract void a(INTERFACE r1, CALLBACK callback);

    public abstract CALLBACK b();

    public abstract INTERFACE b(IBinder iBinder);

    public abstract void b(INTERFACE r1, CALLBACK callback);

    @Override // com.kwai.filedownloader.t
    public boolean c() {
        return d() != null;
    }

    public INTERFACE d() {
        return this.f37862b;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f37862b = b(iBinder);
        if (com.kwai.filedownloader.f.d.f37776a) {
            com.kwai.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.f37862b);
        }
        try {
            b(this.f37862b, this.f37861a);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        this.f37866f.clear();
        for (Runnable runnable : (List) this.f37866f.clone()) {
            runnable.run();
        }
        com.kwai.filedownloader.f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.f37863c));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwai.filedownloader.f.d.f37776a) {
            com.kwai.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.f37862b);
        }
        a(true);
    }
}
