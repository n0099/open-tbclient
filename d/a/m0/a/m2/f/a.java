package d.a.m0.a.m2.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.m0.a.k;
import d.a.m0.a.k2.g.h;
import d.a.m0.a.v1.c.f.c;
import d.a.m0.a.v1.c.f.e;
import d.a.m0.a.v2.j0;
import d.a.m0.a.v2.q;
import d.a.m0.n.h.d;
import d.a.m0.t.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47300a = k.f46983a;

    /* renamed from: d.a.m0.a.m2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0807a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f47301e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47302f;

        public RunnableC0807a(long j, int i2) {
            this.f47301e = j;
            this.f47302f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.m0.a.m2.a.c().a(this.f47301e, this.f47302f);
            } catch (Exception e2) {
                if (a.f47300a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f47303a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f47304b;

        public static b a(int i2, String str) {
            b bVar = new b();
            bVar.f47303a = i2;
            bVar.f47304b = str;
            return bVar;
        }

        public static b b(String str) {
            return a(1, str);
        }

        public static b d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f47303a == 0;
        }

        @NonNull
        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.f47303a + ", message='" + this.f47304b + "'}";
        }
    }

    public static void b(int i2) {
        l("0", 0L, i2);
    }

    public static b c(d dVar, int i2) {
        d.a.m0.a.e0.d.h("RemoteSwanCoreControl", "doRemoteUpdate start. framework: " + dVar);
        if (dVar == null) {
            return b.b("framework is null.");
        }
        long j = dVar.f51796i;
        if (j == 0) {
            return b.b("invalid version code : " + dVar.j);
        } else if (!j0.a(new File(dVar.f51788a), dVar.m)) {
            return b.b("sign failed.");
        } else {
            String path = h(j, i2).getPath();
            if (!d.a.m0.t.d.T(dVar.f51788a, path)) {
                return b.b("unzip bundle failed.");
            }
            if (i2 == 0) {
                boolean A = d.a.m0.t.d.A(dVar.f51788a, path);
                if (f47300a) {
                    Log.d("RemoteSwanCoreControl", "isZipFileMatchUnzipResult:" + A + ",path:" + path);
                }
                if (!A) {
                    d.a.m0.a.m2.b.m(1, i2, j);
                    d.a.m0.t.d.L(path);
                    if (!d.a.m0.t.d.T(dVar.f51788a, path)) {
                        return b.b("unzip bundle failed.");
                    }
                }
            }
            if (f47300a) {
                String b2 = f.b(new File(dVar.f51788a), false);
                if (!TextUtils.isEmpty(b2)) {
                    h.a().putString(d.a.m0.a.m2.a.d(i2), b2);
                }
            }
            if (ProcessUtils.isMainProcess()) {
                d.a.m0.a.m2.b.b(g(i2), k(e(i2), j));
            }
            l(dVar.j, dVar.f51796i, i2);
            d.a.m0.a.e0.d.h("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + j);
            return b.d();
        }
    }

    public static SwanCoreVersion d(int i2) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCoreType = 1;
        swanCoreVersion.swanCoreVersionCode = e(i2);
        swanCoreVersion.swanCoreVersionName = f(i2);
        swanCoreVersion.swanCorePath = h(swanCoreVersion.swanCoreVersionCode, i2).getPath();
        return swanCoreVersion;
    }

    public static long e(int i2) {
        return h.a().getLong(i(i2), 0L);
    }

    public static String f(int i2) {
        return h.a().getString(j(i2), "");
    }

    public static File g(int i2) {
        return new File(d.a.m0.a.m2.b.d(i2), "remote");
    }

    public static File h(long j, int i2) {
        return new File(g(i2), String.valueOf(j));
    }

    public static String i(int i2) {
        return i2 == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    public static String j(int i2) {
        return i2 == 1 ? "aigames_cur_remote_ver_name_key" : "aiapps_cur_remote_ver_name_key";
    }

    public static ArrayList<Long> k(long j, long j2) {
        SwanCoreVersion b2;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : e.k().q()) {
            SwanAppCores n = cVar.n();
            if (cVar.H() && n != null && (b2 = n.b()) != null && !arrayList.contains(Long.valueOf(b2.swanCoreVersionCode))) {
                arrayList.add(Long.valueOf(b2.swanCoreVersionCode));
            }
        }
        if (f47300a) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static void l(String str, long j, int i2) {
        h.a().putString(j(i2), str);
        h.a().putLong(i(i2), j);
        q.j(new RunnableC0807a(j, i2), "cacheSwanCoreInfo");
    }
}
