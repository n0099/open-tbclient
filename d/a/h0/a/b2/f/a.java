package d.a.h0.a.b2.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.i2.e0;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import d.a.h0.a.n1.c.f.c;
import d.a.h0.p.d;
import d.a.h0.p.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41588a = k.f43101a;

    /* renamed from: d.a.h0.a.b2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0587a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f41589e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f41590f;

        public RunnableC0587a(long j, int i2) {
            this.f41589e = j;
            this.f41590f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.h0.a.b2.a.c().a(this.f41589e, this.f41590f);
            } catch (Exception e2) {
                if (a.f41588a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f41591a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f41592b;

        public static b a(int i2, String str) {
            b bVar = new b();
            bVar.f41591a = i2;
            bVar.f41592b = str;
            return bVar;
        }

        public static b b(String str) {
            return a(1, str);
        }

        public static b d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f41591a == 0;
        }

        @NonNull
        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.f41591a + ", message='" + this.f41592b + "'}";
        }
    }

    public static void b(int i2) {
        j(0L, i2);
    }

    public static b c(String str, String str2, String str3, int i2) {
        if (f41588a) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long h2 = d.a.h0.a.b2.b.h(str);
        if (h2 == 0) {
            return b.b("invalid version code : " + str);
        } else if (!e0.a(new File(str2), str3)) {
            return b.b("sign failed.");
        } else {
            if (!d.F(str2, f(h2, i2).getPath())) {
                return b.b("unzip bundle failed.");
            }
            if (f41588a) {
                String b2 = e.b(new File(str2), false);
                if (!TextUtils.isEmpty(b2)) {
                    h.a().putString(d.a.h0.a.b2.a.d(i2), b2);
                }
            }
            if (ProcessUtils.isMainProcess()) {
                d.a.h0.a.b2.b.a(e(i2), i(d(i2), h2));
            }
            j(h2, i2);
            if (f41588a) {
                Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + h2);
            }
            return b.d();
        }
    }

    public static long d(int i2) {
        return h.a().getLong(h(i2), 0L);
    }

    public static File e(int i2) {
        return new File(d.a.h0.a.b2.b.c(i2), "remote");
    }

    public static File f(long j, int i2) {
        return new File(e(i2), String.valueOf(j));
    }

    public static SwanCoreVersion g(int i2, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = f(j, i2).getPath();
        swanCoreVersion.swanCoreType = 1;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    public static String h(int i2) {
        return i2 == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    public static ArrayList<Long> i(long j, long j2) {
        SwanCoreVersion b2;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : d.a.h0.a.n1.c.f.e.j().p()) {
            SwanAppCores l = cVar.l();
            if (cVar.D() && l != null && (b2 = l.b()) != null && !arrayList.contains(Long.valueOf(b2.swanCoreVersion))) {
                arrayList.add(Long.valueOf(b2.swanCoreVersion));
            }
        }
        if (f41588a) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static void j(long j, int i2) {
        h.a().putLong(h(i2), j);
        p.k(new RunnableC0587a(j, i2), "cacheSwanCoreInfo");
    }
}
