package com.mofamulu.tieba.ch;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
import com.mofamulu.tieba.sign.SignService;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class NickService extends Service {
    protected static bb a;
    protected static NickBinder b;
    protected static LinkedList c = new LinkedList();
    private NickBinder d = null;

    public static void a(TiebaApplication tiebaApplication) {
        if (a == null) {
            a((Context) tiebaApplication);
        }
    }

    public static NickBinder a() {
        if (a == null) {
            a((Context) TiebaApplication.f());
        }
        return b;
    }

    public static void a(String str, ba baVar) {
        c.add(new bc(str, baVar));
    }

    public static void b() {
        if (b != null) {
            try {
                b.b();
                TiebaApplication.f().unbindService(a);
                b = null;
                a = null;
            } catch (Throwable th) {
            }
        }
    }

    private static void a(Context context) {
        a = new bb();
        context.startService(new Intent(context, NickService.class));
        context.bindService(new Intent(context, NickService.class), a, 1);
        context.startService(new Intent(context, SignService.class));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.d = new NickBinder(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.d.c();
        this.d = null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.d;
    }
}
