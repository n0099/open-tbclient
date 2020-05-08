package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.xiaomi.push.ai;
/* loaded from: classes8.dex */
public class dx {
    private static volatile dx a;

    /* renamed from: a  reason: collision with other field name */
    private Context f229a;

    private dx(Context context) {
        this.f229a = context;
    }

    private int a(int i) {
        return Math.max(60, i);
    }

    public static dx a(Context context) {
        if (a == null) {
            synchronized (dx.class) {
                if (a == null) {
                    a = new dx(context);
                }
            }
        }
        return a;
    }

    private void a(com.xiaomi.push.service.ak akVar, ai aiVar, boolean z) {
        if (akVar.a(hr.UploadSwitch.a(), true)) {
            ei eiVar = new ei(this.f229a);
            if (z) {
                aiVar.a((ai.a) eiVar, a(akVar.a(hr.UploadFrequency.a(), 86400)));
            } else {
                aiVar.m125a((ai.a) eiVar);
            }
        }
    }

    private boolean a() {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                (this.f229a instanceof Application ? (Application) this.f229a : (Application) this.f229a.getApplicationContext()).registerActivityLifecycleCallbacks(new Cdo(this.f229a, String.valueOf(System.currentTimeMillis() / 1000)));
                return true;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ai a2 = ai.a(this.f229a);
        com.xiaomi.push.service.ak a3 = com.xiaomi.push.service.ak.a(this.f229a);
        SharedPreferences sharedPreferences = this.f229a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) < 172800000) {
            return;
        }
        a(a3, a2, false);
        if (a3.a(hr.StorageCollectionSwitch.a(), true)) {
            int a4 = a(a3.a(hr.StorageCollectionFrequency.a(), 86400));
            a2.a(new eg(this.f229a, a4), a4, 0);
        }
        boolean a5 = a3.a(hr.AppIsInstalledCollectionSwitch.a(), false);
        String a6 = a3.a(hr.AppIsInstalledList.a(), (String) null);
        if (a5 && !TextUtils.isEmpty(a6)) {
            int a7 = a(a3.a(hr.AppIsInstalledCollectionFrequency.a(), 86400));
            a2.a(new ea(this.f229a, a7, a6), a7, 0);
        }
        boolean a8 = a3.a(hr.ScreenSizeCollectionSwitch.a(), true);
        boolean a9 = a3.a(hr.AndroidVnCollectionSwitch.a(), true);
        boolean a10 = a3.a(hr.AndroidVcCollectionSwitch.a(), true);
        boolean a11 = a3.a(hr.AndroidIdCollectionSwitch.a(), true);
        boolean a12 = a3.a(hr.OperatorSwitch.a(), true);
        if (a8 || a9 || a10 || a11 || a12) {
            int a13 = a(a3.a(hr.DeviceInfoCollectionFrequency.a(), 1209600));
            a2.a(new ef(this.f229a, a13, a8, a9, a10, a11, a12), a13, 0);
        }
        boolean a14 = a3.a(hr.MacCollectionSwitch.a(), false);
        boolean a15 = a3.a(hr.IMSICollectionSwitch.a(), false);
        boolean a16 = a3.a(hr.IccidCollectionSwitch.a(), false);
        boolean a17 = a3.a(hr.DeviceIdSwitch.a(), false);
        if (a14 || a15 || a16 || a17) {
            int a18 = a(a3.a(hr.DeviceBaseInfoCollectionFrequency.a(), 1209600));
            a2.a(new ee(this.f229a, a18, a14, a15, a16, a17), a18, 0);
        }
        if (Build.VERSION.SDK_INT < 21 && a3.a(hr.AppActiveListCollectionSwitch.a(), false)) {
            int a19 = a(a3.a(hr.AppActiveListCollectionFrequency.a(), CyberPlayerManager.MEDIA_INFO_TIMED_TEXT_ERROR));
            a2.a(new dz(this.f229a, a19), a19, 0);
        }
        if (a3.a(hr.TopAppCollectionSwitch.a(), false)) {
            int a20 = a(a3.a(hr.TopAppCollectionFrequency.a(), 300));
            a2.a(new eh(this.f229a, a20), a20, 0);
        }
        if (a3.a(hr.BroadcastActionCollectionSwitch.a(), true)) {
            int a21 = a(a3.a(hr.BroadcastActionCollectionFrequency.a(), CyberPlayerManager.MEDIA_INFO_TIMED_TEXT_ERROR));
            a2.a(new ec(this.f229a, a21), a21, 0);
        }
        if (a3.a(hr.ActivityTSSwitch.a(), false)) {
            a();
        }
        if (a3.a(hr.BatteryCollectionSwitch.a(), false)) {
            int a22 = a(a3.a(hr.BatteryCollectionFrequency.a(), 3600));
            a2.a(new eb(this.f229a, a22), a22, 0);
        }
        a(a3, a2, true);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m230a() {
        ai.a(this.f229a).a(new dy(this));
    }
}
