package d.b.h0.a.b2.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.b.h0.a.a2.g.h;
import d.b.h0.a.i2.e0;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
import d.b.h0.a.n1.c.f.c;
import d.b.h0.p.d;
import d.b.h0.p.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44304a = k.f45772a;

    /* renamed from: d.b.h0.a.b2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0648a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f44305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44306f;

        public RunnableC0648a(long j, int i) {
            this.f44305e = j;
            this.f44306f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.h0.a.b2.a.c().a(this.f44305e, this.f44306f);
            } catch (Exception e2) {
                if (a.f44304a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f44307a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f44308b;

        public static b a(int i, String str) {
            b bVar = new b();
            bVar.f44307a = i;
            bVar.f44308b = str;
            return bVar;
        }

        public static b b(String str) {
            return a(1, str);
        }

        public static b d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f44307a == 0;
        }

        @NonNull
        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.f44307a + ", message='" + this.f44308b + "'}";
        }
    }

    public static void b(int i) {
        j(0L, i);
    }

    public static b c(String str, String str2, String str3, int i) {
        if (f44304a) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long h2 = d.b.h0.a.b2.b.h(str);
        if (h2 == 0) {
            return b.b("invalid version code : " + str);
        } else if (!e0.a(new File(str2), str3)) {
            return b.b("sign failed.");
        } else {
            if (!d.F(str2, f(h2, i).getPath())) {
                return b.b("unzip bundle failed.");
            }
            if (f44304a) {
                String b2 = e.b(new File(str2), false);
                if (!TextUtils.isEmpty(b2)) {
                    h.a().putString(d.b.h0.a.b2.a.d(i), b2);
                }
            }
            if (ProcessUtils.isMainProcess()) {
                d.b.h0.a.b2.b.a(e(i), i(d(i), h2));
            }
            j(h2, i);
            if (f44304a) {
                Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + h2);
            }
            return b.d();
        }
    }

    public static long d(int i) {
        return h.a().getLong(h(i), 0L);
    }

    public static File e(int i) {
        return new File(d.b.h0.a.b2.b.c(i), "remote");
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
        for (c cVar : d.b.h0.a.n1.c.f.e.j().p()) {
            SwanAppCores k = cVar.k();
            if (cVar.D() && k != null && (b2 = k.b()) != null && !arrayList.contains(Long.valueOf(b2.swanCoreVersion))) {
                arrayList.add(Long.valueOf(b2.swanCoreVersion));
            }
        }
        if (f44304a) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static void j(long j, int i) {
        h.a().putLong(h(i), j);
        p.k(new RunnableC0648a(j, i), "cacheSwanCoreInfo");
    }
}
