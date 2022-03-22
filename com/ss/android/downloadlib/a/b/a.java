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
/* loaded from: classes7.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static String f42701d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f42702e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f42703f = "";

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f42704g;
    public c a;
    public Context k;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42707h = true;
    public boolean i = false;
    public volatile boolean j = false;
    public final List<Pair<b, d>> l = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<InterfaceC2037a> f42705b = new ArrayList();
    public final ServiceConnection m = new ServiceConnection() { // from class: com.ss.android.downloadlib.a.b.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f42706c) {
                a.this.a(false);
                a.this.a = c.a.a(iBinder);
                a.this.c();
                for (InterfaceC2037a interfaceC2037a : a.this.f42705b) {
                    interfaceC2037a.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f42706c) {
                a.this.a(false);
                a.this.a = null;
                for (InterfaceC2037a interfaceC2037a : a.this.f42705b) {
                    interfaceC2037a.b();
                }
            }
        }
    };
    public String n = "";

    /* renamed from: c  reason: collision with root package name */
    public final Object f42706c = new Object();

    /* renamed from: com.ss.android.downloadlib.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC2037a {
        void a();

        void b();
    }

    public static a a() {
        if (f42704g == null) {
            synchronized (a.class) {
                if (f42704g == null) {
                    f42704g = new a();
                }
            }
        }
        return f42704g;
    }

    public void b() {
        if (this.a != null) {
            this.k.unbindService(this.m);
            this.a = null;
        }
        this.f42705b.clear();
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
        return this.j;
    }

    public boolean a(Context context, boolean z) {
        if (TextUtils.isEmpty(f42701d)) {
            JSONObject i = j.i();
            String optString = i.optString("s");
            f42701d = com.ss.android.socialbase.appdownloader.f.c.a(i.optString("q"), optString);
            f42702e = com.ss.android.socialbase.appdownloader.f.c.a(i.optString("u"), optString);
            f42703f = com.ss.android.socialbase.appdownloader.f.c.a(i.optString("w"), optString);
        }
        this.i = z;
        if (context != null) {
            this.k = context.getApplicationContext();
            if (TextUtils.isEmpty(f42703f)) {
                f42703f = this.k.getPackageName();
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
        intent.setAction(f42701d);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (f42702e.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void a(b bVar, d dVar) {
        synchronized (this.f42706c) {
            bVar.f42711e = f42703f;
            if (TextUtils.isEmpty(bVar.f42712f)) {
                bVar.f42712f = this.n;
            }
            if (this.a != null) {
                try {
                    this.a.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (d() || a(this.k, this.i)) {
                this.l.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void a(boolean z) {
        this.j = z;
    }
}
