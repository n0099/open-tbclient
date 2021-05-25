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
    public Context f66676c;

    /* renamed from: e  reason: collision with root package name */
    public c f66678e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66674a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f66675b = false;

    /* renamed from: d  reason: collision with root package name */
    public final List<Pair<com.ss.android.downloadlib.a.c.b, d>> f66677d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<b> f66679f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final ServiceConnection f66680g = new ServiceConnectionC1863a();

    /* renamed from: h  reason: collision with root package name */
    public String f66681h = "";

    /* renamed from: i  reason: collision with root package name */
    public final Object f66682i = new Object();

    /* renamed from: d.o.a.d.e$j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ServiceConnectionC1863a implements ServiceConnection {
        public ServiceConnectionC1863a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f66682i) {
                a.this.d(false);
                a.this.f66678e = c.a.a(iBinder);
                a.this.g();
                for (b bVar : a.this.f66679f) {
                    bVar.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f66682i) {
                a.this.d(false);
                a.this.f66678e = null;
                for (b bVar : a.this.f66679f) {
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
        synchronized (this.f66682i) {
            bVar.f35773e = l;
            if (TextUtils.isEmpty(bVar.f35774f)) {
                bVar.f35774f = this.f66681h;
            }
            if (this.f66678e != null) {
                try {
                    this.f66678e.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (h() || e(this.f66676c, this.f66674a)) {
                this.f66677d.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void d(boolean z) {
        this.f66675b = z;
    }

    public boolean e(Context context, boolean z) {
        if (TextUtils.isEmpty(j)) {
            JSONObject s = n.s();
            String optString = s.optString("s");
            j = d.o.a.e.a.h.b.b(s.optString(IAdRequestParam.COST_NAME), optString);
            k = d.o.a.e.a.h.b.b(s.optString("u"), optString);
            l = d.o.a.e.a.h.b.b(s.optString("w"), optString);
        }
        this.f66674a = z;
        if (context != null) {
            this.f66676c = context.getApplicationContext();
            if (TextUtils.isEmpty(l)) {
                l = this.f66676c.getPackageName();
            }
            if (this.f66678e != null || h()) {
                return true;
            }
            return this.f66676c.bindService(a(context), this.f66680g, 33);
        }
        return true;
    }

    public void f() {
        if (this.f66678e != null) {
            this.f66676c.unbindService(this.f66680g);
            this.f66678e = null;
        }
        this.f66679f.clear();
        this.f66677d.clear();
    }

    public void g() {
        for (Pair<com.ss.android.downloadlib.a.c.b, d> pair : this.f66677d) {
            try {
                this.f66678e.a((com.ss.android.downloadlib.a.c.b) pair.first, (d) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.f66677d.clear();
    }

    public boolean h() {
        return this.f66675b;
    }
}
