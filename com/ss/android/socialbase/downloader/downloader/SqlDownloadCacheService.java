package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
/* loaded from: classes4.dex */
public class SqlDownloadCacheService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13428a = SqlDownloadCacheService.class.getSimpleName();

    public static void a(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                Log.w(f13428a, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(getApplicationContext());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        t tVar;
        k eHf = b.eHf();
        if (eHf instanceof com.ss.android.socialbase.downloader.impls.d) {
            tVar = ((com.ss.android.socialbase.downloader.impls.d) eHf).eJm();
        } else if (!(eHf instanceof t)) {
            tVar = null;
        } else {
            tVar = (t) eHf;
        }
        if (tVar instanceof IBinder) {
            return (IBinder) tVar;
        }
        return new Binder();
    }
}
