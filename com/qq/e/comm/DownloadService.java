package com.qq.e.comm;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes4.dex */
public class DownloadService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private SVSD f7553a;

    private boolean a(String str) {
        if (this.f7553a == null) {
            try {
                if (GDTADManager.getInstance().initWith(getApplicationContext(), str)) {
                    this.f7553a = GDTADManager.getInstance().getPM().getPOFactory().getAPKDownloadServiceDelegate(this);
                    this.f7553a.onCreate();
                } else {
                    GDTLogger.report("Init GDTADManager fail in DownloadService.oncreate");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.f7553a != null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GDTLogger.d("DownloadService.onBind");
        if (this.f7553a != null) {
            return this.f7553a.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.d("DownloadService.onBind,appID=" + stringExtra);
        if (StringUtil.isEmpty(stringExtra) || !a(stringExtra)) {
            return null;
        }
        return this.f7553a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f7553a != null) {
            this.f7553a.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f7553a != null) {
            this.f7553a.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.f7553a != null) {
            this.f7553a.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        if (this.f7553a != null) {
            this.f7553a.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf(i2);
            return 2;
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        if (StringUtil.isEmpty(stringExtra) || !a(stringExtra)) {
            GDTLogger.w("Failto Start new download Service");
            return 2;
        }
        return this.f7553a.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        if (this.f7553a != null) {
            this.f7553a.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (this.f7553a != null) {
            this.f7553a.onTrimMemory(i);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return this.f7553a != null ? this.f7553a.onUnbind(intent) : super.onUnbind(intent);
    }
}
