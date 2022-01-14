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
import com.kuaishou.weapon.un.x;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.addownload.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static String f59386d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f59387e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f59388f = "";

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f59389g;
    public c a;
    public Context k;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59392h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59393i = false;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f59394j = false;
    public final List<Pair<b, d>> l = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<InterfaceC2181a> f59390b = new ArrayList();
    public final ServiceConnection m = new ServiceConnection() { // from class: com.ss.android.downloadlib.a.b.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f59391c) {
                a.this.a(false);
                a.this.a = c.a.a(iBinder);
                a.this.c();
                for (InterfaceC2181a interfaceC2181a : a.this.f59390b) {
                    interfaceC2181a.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f59391c) {
                a.this.a(false);
                a.this.a = null;
                for (InterfaceC2181a interfaceC2181a : a.this.f59390b) {
                    interfaceC2181a.b();
                }
            }
        }
    };
    public String n = "";

    /* renamed from: c  reason: collision with root package name */
    public final Object f59391c = new Object();

    /* renamed from: com.ss.android.downloadlib.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2181a {
        void a();

        void b();
    }

    public static a a() {
        if (f59389g == null) {
            synchronized (a.class) {
                if (f59389g == null) {
                    f59389g = new a();
                }
            }
        }
        return f59389g;
    }

    public void b() {
        if (this.a != null) {
            this.k.unbindService(this.m);
            this.a = null;
        }
        this.f59390b.clear();
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
        return this.f59394j;
    }

    public boolean a(Context context, boolean z) {
        if (TextUtils.isEmpty(f59386d)) {
            JSONObject i2 = j.i();
            String optString = i2.optString("s");
            f59386d = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("q"), optString);
            f59387e = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString(x.o), optString);
            f59388f = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("w"), optString);
        }
        this.f59393i = z;
        if (context != null) {
            this.k = context.getApplicationContext();
            if (TextUtils.isEmpty(f59388f)) {
                f59388f = this.k.getPackageName();
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
        intent.setAction(f59386d);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (f59387e.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void a(b bVar, d dVar) {
        synchronized (this.f59391c) {
            bVar.f59398e = f59388f;
            if (TextUtils.isEmpty(bVar.f59399f)) {
                bVar.f59399f = this.n;
            }
            if (this.a != null) {
                try {
                    this.a.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (d() || a(this.k, this.f59393i)) {
                this.l.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void a(boolean z) {
        this.f59394j = z;
    }
}
