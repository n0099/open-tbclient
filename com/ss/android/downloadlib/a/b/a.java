package com.ss.android.downloadlib.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.addownload.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static String f57948d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f57949e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f57950f = "";

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f57951g;
    public c a;
    public Context k;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57954h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57955i = false;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f57956j = false;
    public final List<Pair<b, d>> l = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<InterfaceC2176a> f57952b = new ArrayList();
    public final ServiceConnection m = new ServiceConnection() { // from class: com.ss.android.downloadlib.a.b.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f57953c) {
                a.this.a(false);
                a.this.a = c.a.a(iBinder);
                a.this.c();
                for (InterfaceC2176a interfaceC2176a : a.this.f57952b) {
                    interfaceC2176a.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f57953c) {
                a.this.a(false);
                a.this.a = null;
                for (InterfaceC2176a interfaceC2176a : a.this.f57952b) {
                    interfaceC2176a.b();
                }
            }
        }
    };
    public String n = "";

    /* renamed from: c  reason: collision with root package name */
    public final Object f57953c = new Object();

    /* renamed from: com.ss.android.downloadlib.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC2176a {
        void a();

        void b();
    }

    public static a a() {
        if (f57951g == null) {
            synchronized (a.class) {
                if (f57951g == null) {
                    f57951g = new a();
                }
            }
        }
        return f57951g;
    }

    public void b() {
        if (this.a != null) {
            this.k.unbindService(this.m);
            this.a = null;
        }
        this.f57952b.clear();
        this.l.clear();
    }

    public void c() {
        for (Pair<b, d> pair : this.l) {
            try {
                this.a.a((b) pair.first, (d) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.l.clear();
    }

    public boolean d() {
        return this.f57956j;
    }

    public boolean a(Context context, boolean z) {
        if (TextUtils.isEmpty(f57948d)) {
            JSONObject i2 = j.i();
            String optString = i2.optString("s");
            f57948d = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("q"), optString);
            f57949e = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("u"), optString);
            f57950f = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("w"), optString);
        }
        this.f57955i = z;
        if (context != null) {
            this.k = context.getApplicationContext();
            if (TextUtils.isEmpty(f57950f)) {
                f57950f = this.k.getPackageName();
            }
            if (this.a != null || d()) {
                return true;
            }
            return this.k.bindService(a(context), this.m, 33);
        }
        return true;
    }

    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction(f57948d);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (f57949e.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void a(b bVar, d dVar) {
        synchronized (this.f57953c) {
            bVar.f57960e = f57950f;
            if (TextUtils.isEmpty(bVar.f57961f)) {
                bVar.f57961f = this.n;
            }
            if (this.a != null) {
                try {
                    this.a.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (d() || a(this.k, this.f57955i)) {
                this.l.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void a(boolean z) {
        this.f57956j = z;
    }
}
