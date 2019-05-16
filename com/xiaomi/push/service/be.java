package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class be {
    private static be a;
    private static String e = null;
    private Context b;
    private boolean d;
    private Messenger h;
    private List<Message> f = new ArrayList();
    private boolean g = false;
    private Messenger c = new Messenger(new bf(this, Looper.getMainLooper()));

    private be(Context context) {
        this.d = false;
        this.b = context.getApplicationContext();
        if (a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.d = true;
        }
    }

    public static be a(Context context) {
        if (a == null) {
            a = new be(context);
        }
        return a;
    }

    private boolean a() {
        if (com.xiaomi.channel.commonutils.misc.a.f) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 104;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private synchronized void b(Intent intent) {
        if (this.g) {
            Message c = c(intent);
            if (this.f.size() >= 50) {
                this.f.remove(0);
            }
            this.f.add(c);
        } else if (this.h == null) {
            Context context = this.b;
            bg bgVar = new bg(this);
            Context context2 = this.b;
            context.bindService(intent, bgVar, 1);
            this.g = true;
            this.f.clear();
            this.f.add(c(intent));
        } else {
            try {
                this.h.send(c(intent));
            } catch (RemoteException e2) {
                this.h = null;
                this.g = false;
            }
        }
    }

    private Message c(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public boolean a(Intent intent) {
        try {
            if (com.xiaomi.channel.commonutils.android.f.a() || Build.VERSION.SDK_INT < 26) {
                this.b.startService(intent);
            } else {
                b(intent);
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }
}
