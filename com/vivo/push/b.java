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
/* loaded from: classes6.dex */
public final class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f37341a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, b> f37342b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public boolean f37343c;

    /* renamed from: d  reason: collision with root package name */
    public String f37344d;

    /* renamed from: e  reason: collision with root package name */
    public Context f37345e;

    /* renamed from: g  reason: collision with root package name */
    public volatile IPCInvoke f37347g;

    /* renamed from: i  reason: collision with root package name */
    public String f37349i;
    public Handler j;

    /* renamed from: h  reason: collision with root package name */
    public Object f37348h = new Object();

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f37346f = new AtomicInteger(1);

    public b(Context context, String str) {
        this.f37344d = null;
        this.j = null;
        this.f37345e = context;
        this.f37349i = str;
        this.j = new Handler(Looper.getMainLooper(), new c(this));
        String b2 = com.vivo.push.util.s.b(context);
        this.f37344d = b2;
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(this.f37349i)) {
            this.f37343c = com.vivo.push.util.z.a(context, this.f37344d) >= 1260;
            b();
            return;
        }
        Context context2 = this.f37345e;
        com.vivo.push.util.p.c(context2, "init error : push pkgname is " + this.f37344d + " ; action is " + this.f37349i);
        this.f37343c = false;
    }

    private void d() {
        this.j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f37345e.unbindService(this);
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
        this.f37347g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f37347g == null) {
            com.vivo.push.util.p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            e();
            this.f37346f.set(1);
            return;
        }
        if (this.f37346f.get() == 2) {
            a(4);
        } else if (this.f37346f.get() != 4) {
            e();
        }
        synchronized (this.f37348h) {
            this.f37348h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f37347g = null;
        a(1);
    }

    public static b a(Context context, String str) {
        b bVar = f37342b.get(str);
        if (bVar == null) {
            synchronized (f37341a) {
                bVar = f37342b.get(str);
                if (bVar == null) {
                    bVar = new b(context, str);
                    f37342b.put(str, bVar);
                }
            }
        }
        return bVar;
    }

    private void b() {
        int i2 = this.f37346f.get();
        com.vivo.push.util.p.d("AidlManager", "Enter connect, Connection Status: " + i2);
        if (i2 == 4 || i2 == 2 || i2 == 3 || i2 == 5 || !this.f37343c) {
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
        Intent intent = new Intent(this.f37349i);
        intent.setPackage(this.f37344d);
        try {
            return this.f37345e.bindService(intent, this, 1);
        } catch (Exception e2) {
            com.vivo.push.util.p.a("AidlManager", "bind core error", e2);
            return false;
        }
    }

    public final boolean a() {
        String b2 = com.vivo.push.util.s.b(this.f37345e);
        this.f37344d = b2;
        if (TextUtils.isEmpty(b2)) {
            com.vivo.push.util.p.c(this.f37345e, "push pkgname is null");
            return false;
        }
        boolean z = com.vivo.push.util.z.a(this.f37345e, this.f37344d) >= 1260;
        this.f37343c = z;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        this.f37346f.set(i2);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f37346f.get() == 2) {
            synchronized (this.f37348h) {
                try {
                    this.f37348h.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            int i2 = this.f37346f.get();
            if (i2 == 4) {
                this.j.removeMessages(2);
                this.j.sendEmptyMessageDelayed(2, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
                this.f37347g.asyncCall(bundle, null);
                return true;
            }
            com.vivo.push.util.p.d("AidlManager", "invoke error : connect status = " + i2);
            return false;
        } catch (Exception e3) {
            com.vivo.push.util.p.a("AidlManager", "invoke error ", e3);
            int i3 = this.f37346f.get();
            com.vivo.push.util.p.d("AidlManager", "Enter disconnect, Connection Status: " + i3);
            if (i3 == 2) {
                d();
                a(1);
                return false;
            } else if (i3 == 3) {
                a(1);
                return false;
            } else if (i3 != 4) {
                return false;
            } else {
                a(1);
                e();
                return false;
            }
        }
    }
}
