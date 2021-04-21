package d.p.a.d.f.d;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.d.f.n;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static volatile d f67705d;

    /* renamed from: a  reason: collision with root package name */
    public long f67706a = 0;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, e> f67707b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Integer> f67708c = new HashMap<>();

    public d() {
        new CopyOnWriteArrayList();
    }

    public static d a() {
        if (f67705d == null) {
            synchronized (d.class) {
                if (f67705d == null) {
                    f67705d = new d();
                }
            }
        }
        return f67705d;
    }

    @WorkerThread
    public static void b(d.p.a.b.a.c.b bVar) {
        DownloadInfo f2;
        if (bVar == null || bVar.b() <= 0 || (f2 = d.p.a.e.b.g.a.l(n.a()).f(bVar.s())) == null) {
            return;
        }
        c(f2);
    }

    @WorkerThread
    public static void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null || d.p.a.e.b.j.a.d(downloadInfo.c0()).b("delete_file_after_install", 0) == 0) {
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
        this.f67707b.remove(str);
    }

    public void e(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f67707b.put(str, eVar);
    }

    public int f(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f67708c == null) {
            this.f67708c = new HashMap<>();
        }
        if (this.f67708c.containsKey(str)) {
            return this.f67708c.get(str).intValue();
        }
        return 0;
    }

    public long g() {
        return this.f67706a;
    }

    public void h() {
        this.f67706a = System.currentTimeMillis();
    }
}
