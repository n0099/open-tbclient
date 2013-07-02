package com.mofamulu.tieba.sign;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class SignService extends Service {
    public static am a;
    private static SignServiceBinder b;
    private static ServiceConnection c;
    private SignServiceBinder d = null;

    public static SignServiceBinder a() {
        if (c == null) {
            a(TiebaApplication.f());
        }
        return b;
    }

    public static SignServiceBinder b() {
        if (c == null) {
            return null;
        }
        return b;
    }

    public static void c() {
        if (b != null) {
            try {
                TiebaApplication.f().unbindService(c);
                b.a();
                b = null;
                c = null;
            } catch (Throwable th) {
            }
        }
    }

    public static void a(TiebaApplication tiebaApplication) {
        if (c == null) {
            c = new an();
            tiebaApplication.startService(new Intent(tiebaApplication, SignService.class));
            tiebaApplication.bindService(new Intent(tiebaApplication, SignService.class), c, 1);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        a(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        a(intent);
        return 1;
    }

    private void a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("start_for_auto_sign", false)) {
            this.d.f();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.d = new SignServiceBinder(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.d != null) {
            this.d.b();
        }
        this.d = null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.d;
    }
}
