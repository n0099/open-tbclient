package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class b implements ServiceConnection {
    private static final Object a = new Object();
    private static Map<String, b> b = new HashMap();
    private boolean c;
    private String d;
    private Context e;
    private volatile IPCInvoke g;
    private String i;
    private Handler j;
    private Object h = new Object();
    private AtomicInteger f = new AtomicInteger(1);

    private b(Context context, String str) {
        this.d = null;
        this.j = null;
        this.e = context;
        this.i = str;
        this.j = new Handler(Looper.getMainLooper(), new c(this));
        this.d = com.vivo.push.util.s.b(context);
        if (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.i)) {
            com.vivo.push.util.p.c(this.e, "init error : push pkgname is " + this.d + " ; action is " + this.i);
            this.c = false;
            return;
        }
        this.c = com.vivo.push.util.z.a(context, this.d) >= 1260;
        b();
    }

    public static b a(Context context, String str) {
        b bVar = b.get(str);
        if (bVar == null) {
            synchronized (a) {
                bVar = b.get(str);
                if (bVar == null) {
                    bVar = new b(context, str);
                    b.put(str, bVar);
                }
            }
        }
        return bVar;
    }

    public final boolean a() {
        this.d = com.vivo.push.util.s.b(this.e);
        if (TextUtils.isEmpty(this.d)) {
            com.vivo.push.util.p.c(this.e, "push pkgname is null");
            return false;
        }
        this.c = com.vivo.push.util.z.a(this.e, this.d) >= 1260;
        return this.c;
    }

    private void b() {
        int i = this.f.get();
        com.vivo.push.util.p.d("AidlManager", "Enter connect, Connection Status: " + i);
        if (i != 4 && i != 2 && i != 3 && i != 5 && this.c) {
            a(2);
            if (!c()) {
                a(1);
                com.vivo.push.util.p.a("AidlManager", "bind core service fail");
                return;
            }
            this.j.removeMessages(1);
            this.j.sendEmptyMessageDelayed(1, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    private boolean c() {
        Intent intent = new Intent(this.i);
        intent.setPackage(this.d);
        try {
            return this.e.bindService(intent, this, 1);
        } catch (Exception e) {
            com.vivo.push.util.p.a("AidlManager", "bind core error", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.f.set(i);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d();
        this.g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.g == null) {
            com.vivo.push.util.p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            e();
            this.f.set(1);
            return;
        }
        if (this.f.get() == 2) {
            a(4);
        } else if (this.f.get() != 4) {
            e();
        }
        synchronized (this.h) {
            this.h.notifyAll();
        }
    }

    private void d() {
        this.j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.e.unbindService(this);
        } catch (Exception e) {
            com.vivo.push.util.p.a("AidlManager", "On unBindServiceException:" + e.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.g = null;
        a(1);
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.p.b("AidlManager", "onBindingDied : " + componentName);
    }

    public final boolean a(Bundle bundle) {
        int i;
        b();
        if (this.f.get() == 2) {
            synchronized (this.h) {
                try {
                    this.h.wait(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            i = this.f.get();
        } catch (Exception e2) {
            com.vivo.push.util.p.a("AidlManager", "invoke error ", e2);
            int i2 = this.f.get();
            com.vivo.push.util.p.d("AidlManager", "Enter disconnect, Connection Status: " + i2);
            switch (i2) {
                case 2:
                    d();
                    a(1);
                    break;
                case 3:
                    a(1);
                    break;
                case 4:
                    a(1);
                    e();
                    break;
            }
        }
        if (i != 4) {
            com.vivo.push.util.p.d("AidlManager", "invoke error : connect status = " + i);
            return false;
        }
        this.j.removeMessages(2);
        this.j.sendEmptyMessageDelayed(2, 30000L);
        this.g.asyncCall(bundle, null);
        return true;
    }
}
