package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import d.o.a.e.b.g.d;
import d.o.a.e.b.g.j;
import d.o.a.e.b.g.s;
/* loaded from: classes6.dex */
public class SqlDownloadCacheService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36818a = SqlDownloadCacheService.class.getSimpleName();

    public static void a(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                Log.w(f36818a, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        s sVar;
        j I0 = d.I0();
        if (I0 instanceof d.o.a.e.b.m.d) {
            sVar = ((d.o.a.e.b.m.d) I0).i();
        } else {
            sVar = I0 instanceof s ? (s) I0 : null;
        }
        if (sVar instanceof IBinder) {
            return (IBinder) sVar;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d.y(getApplicationContext());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        int onStartCommand = super.onStartCommand(intent, i2, i3);
        if (d.u0()) {
            return 2;
        }
        return onStartCommand;
    }
}
