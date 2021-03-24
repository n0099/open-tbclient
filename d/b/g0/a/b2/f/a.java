package d.b.g0.a.b2.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.i2.e0;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.f.c;
import d.b.g0.p.d;
import d.b.g0.p.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43582a = k.f45050a;

    /* renamed from: d.b.g0.a.b2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0615a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f43583e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43584f;

        public RunnableC0615a(long j, int i) {
            this.f43583e = j;
            this.f43584f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.g0.a.b2.a.c().a(this.f43583e, this.f43584f);
            } catch (Exception e2) {
                if (a.f43582a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f43585a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f43586b;

        public static b a(int i, String str) {
            b bVar = new b();
            bVar.f43585a = i;
            bVar.f43586b = str;
            return bVar;
        }

        public static b b(String str) {
            return a(1, str);
        }

        public static b d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f43585a == 0;
        }

        @NonNull
        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.f43585a + ", message='" + this.f43586b + "'}";
        }
    }

    public static void b(int i) {
        j(0L, i);
    }

    public static b c(String str, String str2, String str3, int i) {
        if (f43582a) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long h2 = d.b.g0.a.b2.b.h(str);
        if (h2 == 0) {
            return b.b("invalid version code : " + str);
        } else if (!e0.a(new File(str2), str3)) {
            return b.b("sign failed.");
        } else {
            if (!d.F(str2, f(h2, i).getPath())) {
                return b.b("unzip bundle failed.");
            }
            if (f43582a) {
                String b2 = e.b(new File(str2), false);
                if (!TextUtils.isEmpty(b2)) {
                    h.a().putString(d.b.g0.a.b2.a.d(i), b2);
                }
            }
            if (ProcessUtils.isMainProcess()) {
                d.b.g0.a.b2.b.a(e(i), i(d(i), h2));
            }
            j(h2, i);
            if (f43582a) {
                Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + h2);
            }
            return b.d();
        }
    }

    public static long d(int i) {
        return h.a().getLong(h(i), 0L);
    }

    public static File e(int i) {
        return new File(d.b.g0.a.b2.b.c(i), "remote");
    }

    public static File f(long j, int i) {
        return new File(e(i), String.valueOf(j));
    }

    public static SwanCoreVersion g(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = f(j, i).getPath();
        swanCoreVersion.swanCoreType = 1;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    public static String h(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    public static ArrayList<Long> i(long j, long j2) {
        SwanCoreVersion b2;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : d.b.g0.a.n1.c.f.e.j().p()) {
            SwanAppCores k = cVar.k();
            if (cVar.D() && k != null && (b2 = k.b()) != null && !arrayList.contains(Long.valueOf(b2.swanCoreVersion))) {
                arrayList.add(Long.valueOf(b2.swanCoreVersion));
            }
        }
        if (f43582a) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static void j(long j, int i) {
        h.a().putLong(h(i), j);
        p.k(new RunnableC0615a(j, i), "cacheSwanCoreInfo");
    }
}
