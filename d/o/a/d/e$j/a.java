package d.o.a.d.e$j;

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
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.ss.android.downloadlib.a.c.c;
import com.ss.android.downloadlib.a.c.d;
import d.o.a.d.f.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static String j = "";
    public static String k = "";
    public static String l = "";
    public static volatile a m;

    /* renamed from: c  reason: collision with root package name */
    public Context f65947c;

    /* renamed from: e  reason: collision with root package name */
    public c f65949e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65945a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f65946b = false;

    /* renamed from: d  reason: collision with root package name */
    public final List<Pair<com.ss.android.downloadlib.a.c.b, d>> f65948d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<b> f65950f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final ServiceConnection f65951g = new ServiceConnectionC1795a();

    /* renamed from: h  reason: collision with root package name */
    public String f65952h = "";

    /* renamed from: i  reason: collision with root package name */
    public final Object f65953i = new Object();

    /* renamed from: d.o.a.d.e$j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class ServiceConnectionC1795a implements ServiceConnection {
        public ServiceConnectionC1795a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f65953i) {
                a.this.d(false);
                a.this.f65949e = c.a.a(iBinder);
                a.this.g();
                for (b bVar : a.this.f65950f) {
                    bVar.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f65953i) {
                a.this.d(false);
                a.this.f65949e = null;
                for (b bVar : a.this.f65950f) {
                    bVar.b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void b();
    }

    public static a b() {
        if (m == null) {
            synchronized (a.class) {
                if (m == null) {
                    m = new a();
                }
            }
        }
        return m;
    }

    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction(j);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (k.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void c(com.ss.android.downloadlib.a.c.b bVar, d dVar) {
        synchronized (this.f65953i) {
            bVar.f36599e = l;
            if (TextUtils.isEmpty(bVar.f36600f)) {
                bVar.f36600f = this.f65952h;
            }
            if (this.f65949e != null) {
                try {
                    this.f65949e.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (h() || e(this.f65947c, this.f65945a)) {
                this.f65948d.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void d(boolean z) {
        this.f65946b = z;
    }

    public boolean e(Context context, boolean z) {
        if (TextUtils.isEmpty(j)) {
            JSONObject s = n.s();
            String optString = s.optString("s");
            j = d.o.a.e.a.h.b.b(s.optString(IAdRequestParam.COST_NAME), optString);
            k = d.o.a.e.a.h.b.b(s.optString("u"), optString);
            l = d.o.a.e.a.h.b.b(s.optString("w"), optString);
        }
        this.f65945a = z;
        if (context != null) {
            this.f65947c = context.getApplicationContext();
            if (TextUtils.isEmpty(l)) {
                l = this.f65947c.getPackageName();
            }
            if (this.f65949e != null || h()) {
                return true;
            }
            return this.f65947c.bindService(a(context), this.f65951g, 33);
        }
        return true;
    }

    public void f() {
        if (this.f65949e != null) {
            this.f65947c.unbindService(this.f65951g);
            this.f65949e = null;
        }
        this.f65950f.clear();
        this.f65948d.clear();
    }

    public void g() {
        for (Pair<com.ss.android.downloadlib.a.c.b, d> pair : this.f65948d) {
            try {
                this.f65949e.a((com.ss.android.downloadlib.a.c.b) pair.first, (d) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.f65948d.clear();
    }

    public boolean h() {
        return this.f65946b;
    }
}
