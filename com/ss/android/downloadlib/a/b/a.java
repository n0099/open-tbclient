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
    public static String f61725d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f61726e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f61727f = "";

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f61728g;
    public c a;

    /* renamed from: k  reason: collision with root package name */
    public Context f61734k;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61731h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61732i = false;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f61733j = false;
    public final List<Pair<b, d>> l = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<InterfaceC2164a> f61729b = new ArrayList();
    public final ServiceConnection m = new ServiceConnection() { // from class: com.ss.android.downloadlib.a.b.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f61730c) {
                a.this.a(false);
                a.this.a = c.a.a(iBinder);
                a.this.c();
                for (InterfaceC2164a interfaceC2164a : a.this.f61729b) {
                    interfaceC2164a.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f61730c) {
                a.this.a(false);
                a.this.a = null;
                for (InterfaceC2164a interfaceC2164a : a.this.f61729b) {
                    interfaceC2164a.b();
                }
            }
        }
    };
    public String n = "";

    /* renamed from: c  reason: collision with root package name */
    public final Object f61730c = new Object();

    /* renamed from: com.ss.android.downloadlib.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2164a {
        void a();

        void b();
    }

    public static a a() {
        if (f61728g == null) {
            synchronized (a.class) {
                if (f61728g == null) {
                    f61728g = new a();
                }
            }
        }
        return f61728g;
    }

    public void b() {
        if (this.a != null) {
            this.f61734k.unbindService(this.m);
            this.a = null;
        }
        this.f61729b.clear();
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
        return this.f61733j;
    }

    public boolean a(Context context, boolean z) {
        if (TextUtils.isEmpty(f61725d)) {
            JSONObject i2 = j.i();
            String optString = i2.optString("s");
            f61725d = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("q"), optString);
            f61726e = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString(x.o), optString);
            f61727f = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("w"), optString);
        }
        this.f61732i = z;
        if (context != null) {
            this.f61734k = context.getApplicationContext();
            if (TextUtils.isEmpty(f61727f)) {
                f61727f = this.f61734k.getPackageName();
            }
            if (this.a != null || d()) {
                return true;
            }
            return this.f61734k.bindService(a(context), this.m, 33);
        }
        return true;
    }

    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction(f61725d);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (f61726e.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void a(b bVar, d dVar) {
        synchronized (this.f61730c) {
            bVar.f61738e = f61727f;
            if (TextUtils.isEmpty(bVar.f61739f)) {
                bVar.f61739f = this.n;
            }
            if (this.a != null) {
                try {
                    this.a.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (d() || a(this.f61734k, this.f61732i)) {
                this.l.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void a(boolean z) {
        this.f61733j = z;
    }
}
