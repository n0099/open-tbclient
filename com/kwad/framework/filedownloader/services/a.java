package com.kwad.framework.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    public final Class<?> agR;
    public volatile INTERFACE ahx;
    public final HashMap<String, Object> ahy = new HashMap<>();
    public final List<Context> ahz = new ArrayList();
    public final ArrayList<Runnable> aeE = new ArrayList<>();
    public final CALLBACK ahw = uH();

    public abstract void a(INTERFACE r1, CALLBACK callback);

    public abstract INTERFACE b(IBinder iBinder);

    public abstract CALLBACK uH();

    public a(Class<?> cls) {
        this.agR = cls;
    }

    private void bf(boolean z) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "release connect resources %s", this.ahx);
        }
        this.ahx = null;
        com.kwad.framework.filedownloader.f.up().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.agR));
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void ak(Context context) {
        a(context, (Runnable) null);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.ahx);
        }
        bf(true);
    }

    private void a(Context context, Runnable runnable) {
        if (!com.kwad.framework.filedownloader.f.f.an(context)) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.agR);
            if (!this.ahz.contains(context)) {
                this.ahz.add(context);
            }
            context.bindService(intent, this, 1);
            context.startService(intent);
            return;
        }
        throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        if (wg() != null) {
            return true;
        }
        return false;
    }

    public final INTERFACE wg() {
        return this.ahx;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.ahx = b(iBinder);
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.ahx);
        }
        try {
            a((a<CALLBACK, INTERFACE>) this.ahx, (INTERFACE) this.ahw);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.aeE.clear();
        for (Runnable runnable : (List) this.aeE.clone()) {
            runnable.run();
        }
        com.kwad.framework.filedownloader.f.up().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.agR));
    }
}
