package com.qq.e.comm;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes2.dex */
public class DownloadService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public SVSD f35455a;

    private boolean a(String str) {
        if (this.f35455a == null) {
            try {
                if (GDTADManager.getInstance().initWith(getApplicationContext(), str)) {
                    SVSD aPKDownloadServiceDelegate = GDTADManager.getInstance().getPM().getPOFactory().getAPKDownloadServiceDelegate(this);
                    this.f35455a = aPKDownloadServiceDelegate;
                    aPKDownloadServiceDelegate.onCreate();
                } else {
                    GDTLogger.report("Init GDTADManager fail in DownloadService.oncreate");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.f35455a != null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GDTLogger.d("DownloadService.onBind");
        SVSD svsd = this.f35455a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.d("DownloadService.onBind,appID=" + stringExtra);
        if (StringUtil.isEmpty(stringExtra) || !a(stringExtra)) {
            return null;
        }
        return this.f35455a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.f35455a;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        SVSD svsd = this.f35455a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.f35455a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.f35455a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            stopSelf(i3);
            return 2;
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        if (StringUtil.isEmpty(stringExtra) || !a(stringExtra)) {
            GDTLogger.w("Failto Start new download Service");
            return 2;
        }
        return this.f35455a.onStartCommand(intent, i2, i3);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.f35455a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        SVSD svsd = this.f35455a;
        if (svsd != null) {
            svsd.onTrimMemory(i2);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.f35455a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }
}
