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
    public Context f67457c;

    /* renamed from: e  reason: collision with root package name */
    public c f67459e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67455a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f67456b = false;

    /* renamed from: d  reason: collision with root package name */
    public final List<Pair<com.ss.android.downloadlib.a.c.b, d>> f67458d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<b> f67460f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final ServiceConnection f67461g = new ServiceConnectionC1856a();

    /* renamed from: h  reason: collision with root package name */
    public String f67462h = "";
    public final Object i = new Object();

    /* renamed from: d.o.a.d.e$j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class ServiceConnectionC1856a implements ServiceConnection {
        public ServiceConnectionC1856a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.i) {
                a.this.d(false);
                a.this.f67459e = c.a.a(iBinder);
                a.this.g();
                for (b bVar : a.this.f67460f) {
                    bVar.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.i) {
                a.this.d(false);
                a.this.f67459e = null;
                for (b bVar : a.this.f67460f) {
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
        synchronized (this.i) {
            bVar.f38919e = l;
            if (TextUtils.isEmpty(bVar.f38920f)) {
                bVar.f38920f = this.f67462h;
            }
            if (this.f67459e != null) {
                try {
                    this.f67459e.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (h() || e(this.f67457c, this.f67455a)) {
                this.f67458d.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void d(boolean z) {
        this.f67456b = z;
    }

    public boolean e(Context context, boolean z) {
        if (TextUtils.isEmpty(j)) {
            JSONObject s = n.s();
            String optString = s.optString("s");
            j = d.o.a.e.a.h.b.b(s.optString(IAdRequestParam.COST_NAME), optString);
            k = d.o.a.e.a.h.b.b(s.optString("u"), optString);
            l = d.o.a.e.a.h.b.b(s.optString("w"), optString);
        }
        this.f67455a = z;
        if (context != null) {
            this.f67457c = context.getApplicationContext();
            if (TextUtils.isEmpty(l)) {
                l = this.f67457c.getPackageName();
            }
            if (this.f67459e != null || h()) {
                return true;
            }
            return this.f67457c.bindService(a(context), this.f67461g, 33);
        }
        return true;
    }

    public void f() {
        if (this.f67459e != null) {
            this.f67457c.unbindService(this.f67461g);
            this.f67459e = null;
        }
        this.f67460f.clear();
        this.f67458d.clear();
    }

    public void g() {
        for (Pair<com.ss.android.downloadlib.a.c.b, d> pair : this.f67458d) {
            try {
                this.f67459e.a((com.ss.android.downloadlib.a.c.b) pair.first, (d) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.f67458d.clear();
    }

    public boolean h() {
        return this.f67456b;
    }
}
