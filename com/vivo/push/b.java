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
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f39644a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, b> f39645b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public boolean f39646c;

    /* renamed from: d  reason: collision with root package name */
    public String f39647d;

    /* renamed from: e  reason: collision with root package name */
    public Context f39648e;

    /* renamed from: g  reason: collision with root package name */
    public volatile IPCInvoke f39650g;
    public String i;
    public Handler j;

    /* renamed from: h  reason: collision with root package name */
    public Object f39651h = new Object();

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f39649f = new AtomicInteger(1);

    public b(Context context, String str) {
        this.f39647d = null;
        this.j = null;
        this.f39648e = context;
        this.i = str;
        this.j = new Handler(Looper.getMainLooper(), new c(this));
        String b2 = com.vivo.push.util.s.b(context);
        this.f39647d = b2;
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(this.i)) {
            this.f39646c = com.vivo.push.util.z.a(context, this.f39647d) >= 1260;
            b();
            return;
        }
        Context context2 = this.f39648e;
        com.vivo.push.util.p.c(context2, "init error : push pkgname is " + this.f39647d + " ; action is " + this.i);
        this.f39646c = false;
    }

    private void d() {
        this.j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f39648e.unbindService(this);
        } catch (Exception e2) {
            com.vivo.push.util.p.a("AidlManager", "On unBindServiceException:" + e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.p.b("AidlManager", "onBindingDied : " + componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d();
        this.f39650g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f39650g == null) {
            com.vivo.push.util.p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            e();
            this.f39649f.set(1);
            return;
        }
        if (this.f39649f.get() == 2) {
            a(4);
        } else if (this.f39649f.get() != 4) {
            e();
        }
        synchronized (this.f39651h) {
            this.f39651h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f39650g = null;
        a(1);
    }

    public static b a(Context context, String str) {
        b bVar = f39645b.get(str);
        if (bVar == null) {
            synchronized (f39644a) {
                bVar = f39645b.get(str);
                if (bVar == null) {
                    bVar = new b(context, str);
                    f39645b.put(str, bVar);
                }
            }
        }
        return bVar;
    }

    private void b() {
        int i = this.f39649f.get();
        com.vivo.push.util.p.d("AidlManager", "Enter connect, Connection Status: " + i);
        if (i == 4 || i == 2 || i == 3 || i == 5 || !this.f39646c) {
            return;
        }
        a(2);
        if (!c()) {
            a(1);
            com.vivo.push.util.p.a("AidlManager", "bind core service fail");
            return;
        }
        this.j.removeMessages(1);
        this.j.sendEmptyMessageDelayed(1, 3000L);
    }

    private boolean c() {
        Intent intent = new Intent(this.i);
        intent.setPackage(this.f39647d);
        try {
            return this.f39648e.bindService(intent, this, 1);
        } catch (Exception e2) {
            com.vivo.push.util.p.a("AidlManager", "bind core error", e2);
            return false;
        }
    }

    public final boolean a() {
        String b2 = com.vivo.push.util.s.b(this.f39648e);
        this.f39647d = b2;
        if (TextUtils.isEmpty(b2)) {
            com.vivo.push.util.p.c(this.f39648e, "push pkgname is null");
            return false;
        }
        boolean z = com.vivo.push.util.z.a(this.f39648e, this.f39647d) >= 1260;
        this.f39646c = z;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.f39649f.set(i);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f39649f.get() == 2) {
            synchronized (this.f39651h) {
                try {
                    this.f39651h.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            int i = this.f39649f.get();
            if (i == 4) {
                this.j.removeMessages(2);
                this.j.sendEmptyMessageDelayed(2, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
                this.f39650g.asyncCall(bundle, null);
                return true;
            }
            com.vivo.push.util.p.d("AidlManager", "invoke error : connect status = " + i);
            return false;
        } catch (Exception e3) {
            com.vivo.push.util.p.a("AidlManager", "invoke error ", e3);
            int i2 = this.f39649f.get();
            com.vivo.push.util.p.d("AidlManager", "Enter disconnect, Connection Status: " + i2);
            if (i2 == 2) {
                d();
                a(1);
                return false;
            } else if (i2 == 3) {
                a(1);
                return false;
            } else if (i2 != 4) {
                return false;
            } else {
                a(1);
                e();
                return false;
            }
        }
    }
}
