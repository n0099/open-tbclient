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
/* loaded from: classes7.dex */
public class a {
    public static String j = "";
    public static String k = "";
    public static String l = "";
    public static volatile a m;

    /* renamed from: c  reason: collision with root package name */
    public Context f70566c;

    /* renamed from: e  reason: collision with root package name */
    public c f70568e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f70564a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f70565b = false;

    /* renamed from: d  reason: collision with root package name */
    public final List<Pair<com.ss.android.downloadlib.a.c.b, d>> f70567d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<b> f70569f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final ServiceConnection f70570g = new ServiceConnectionC1926a();

    /* renamed from: h  reason: collision with root package name */
    public String f70571h = "";

    /* renamed from: i  reason: collision with root package name */
    public final Object f70572i = new Object();

    /* renamed from: d.o.a.d.e$j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ServiceConnectionC1926a implements ServiceConnection {
        public ServiceConnectionC1926a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f70572i) {
                a.this.d(false);
                a.this.f70568e = c.a.a(iBinder);
                a.this.g();
                for (b bVar : a.this.f70569f) {
                    bVar.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f70572i) {
                a.this.d(false);
                a.this.f70568e = null;
                for (b bVar : a.this.f70569f) {
                    bVar.b();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        synchronized (this.f70572i) {
            bVar.f39555e = l;
            if (TextUtils.isEmpty(bVar.f39556f)) {
                bVar.f39556f = this.f70571h;
            }
            if (this.f70568e != null) {
                try {
                    this.f70568e.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (h() || e(this.f70566c, this.f70564a)) {
                this.f70567d.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void d(boolean z) {
        this.f70565b = z;
    }

    public boolean e(Context context, boolean z) {
        if (TextUtils.isEmpty(j)) {
            JSONObject s = n.s();
            String optString = s.optString("s");
            j = d.o.a.e.a.h.b.b(s.optString(IAdRequestParam.COST_NAME), optString);
            k = d.o.a.e.a.h.b.b(s.optString("u"), optString);
            l = d.o.a.e.a.h.b.b(s.optString("w"), optString);
        }
        this.f70564a = z;
        if (context != null) {
            this.f70566c = context.getApplicationContext();
            if (TextUtils.isEmpty(l)) {
                l = this.f70566c.getPackageName();
            }
            if (this.f70568e != null || h()) {
                return true;
            }
            return this.f70566c.bindService(a(context), this.f70570g, 33);
        }
        return true;
    }

    public void f() {
        if (this.f70568e != null) {
            this.f70566c.unbindService(this.f70570g);
            this.f70568e = null;
        }
        this.f70569f.clear();
        this.f70567d.clear();
    }

    public void g() {
        for (Pair<com.ss.android.downloadlib.a.c.b, d> pair : this.f70567d) {
            try {
                this.f70568e.a((com.ss.android.downloadlib.a.c.b) pair.first, (d) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.f70567d.clear();
    }

    public boolean h() {
        return this.f70565b;
    }
}
