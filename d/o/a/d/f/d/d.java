package d.o.a.d.f.d;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.f.n;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static volatile d f70670d;

    /* renamed from: a  reason: collision with root package name */
    public long f70671a = 0;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, e> f70672b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Integer> f70673c = new HashMap<>();

    public d() {
        new CopyOnWriteArrayList();
    }

    public static d a() {
        if (f70670d == null) {
            synchronized (d.class) {
                if (f70670d == null) {
                    f70670d = new d();
                }
            }
        }
        return f70670d;
    }

    @WorkerThread
    public static void b(d.o.a.b.a.c.b bVar) {
        DownloadInfo f2;
        if (bVar == null || bVar.b() <= 0 || (f2 = d.o.a.e.b.g.a.l(n.a()).f(bVar.s())) == null) {
            return;
        }
        c(f2);
    }

    @WorkerThread
    public static void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null || d.o.a.e.b.j.a.d(downloadInfo.c0()).b("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.F0() + File.separator + downloadInfo.q0();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f70672b.remove(str);
    }

    public void e(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f70672b.put(str, eVar);
    }

    public int f(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f70673c == null) {
            this.f70673c = new HashMap<>();
        }
        if (this.f70673c.containsKey(str)) {
            return this.f70673c.get(str).intValue();
        }
        return 0;
    }

    public long g() {
        return this.f70671a;
    }

    public void h() {
        this.f70671a = System.currentTimeMillis();
    }
}
