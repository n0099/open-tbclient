package d.a.l0.a.r1.l.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.a1.e;
import d.a.l0.a.j2.c;
import d.a.l0.a.v2.q;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.f1.f.a {

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f48211d = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, SwanAppConfigData> f48212b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48213c;

    /* renamed from: d.a.l0.a.r1.l.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0866a implements Runnable {
        public RunnableC0866a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            a.this.b();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (d.a.l0.a.f1.f.a.f45528a) {
                Log.d("SwanPerformance", "async batch parse app.json cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Comparator<File> {
        public b(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file == null) {
                return 1;
            }
            if (file2 == null) {
                return -1;
            }
            return (int) ((b(file) - b(file2)) * (-1));
        }

        public final long b(@NonNull File file) {
            return file.lastModified();
        }

        public /* synthetic */ b(a aVar, RunnableC0866a runnableC0866a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f48215a = new a(null);
    }

    public /* synthetic */ a(RunnableC0866a runnableC0866a) {
        this();
    }

    public static a e() {
        return c.f48215a;
    }

    public final void b() {
        File[] listFiles;
        File g2 = e.g();
        if (!g2.exists() || (listFiles = g2.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (String str : f48211d) {
            c(new File(g2, str));
        }
    }

    public final void c(File file) {
        File d2;
        SwanAppConfigData a2;
        if (file == null || !file.exists() || !file.isDirectory() || (d2 = d(file)) == null || (a2 = d.a.l0.a.f1.c.a.a(d2)) == null) {
            return;
        }
        this.f48212b.put(d2.getAbsolutePath(), a2);
    }

    public final File d(File file) {
        if (file != null && !file.isFile()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                if (listFiles.length > 1) {
                    Arrays.sort(listFiles, new b(this, null));
                }
                return listFiles[0];
            }
            c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_START_PLAY);
            bVar.h(file.getAbsolutePath());
            bVar.k("async parse swanApp");
            bVar.m();
            if (d.a.l0.a.f1.f.a.f45528a) {
                Log.d("SwanPerformance", file.getAbsolutePath() + " is an empty folder");
            }
        }
        return null;
    }

    public void f() {
        ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap = this.f48212b;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            this.f48212b.clear();
        }
        this.f48213c = false;
        if (d.a.l0.a.f1.f.a.f45528a) {
            Log.d("SwanPerformance", "release app.json batch cache");
        }
    }

    public void g(String str) {
        ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f48212b) == null || concurrentHashMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, SwanAppConfigData>> it = this.f48212b.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, SwanAppConfigData> next = it.next();
            if (next != null) {
                String key = next.getKey();
                if (!TextUtils.isEmpty(key) && key.contains(str)) {
                    this.f48212b.remove(key);
                    break;
                }
            }
        }
        if (d.a.l0.a.f1.f.a.f45528a) {
            Log.d("SwanPerformance", "release app.json appId = " + str);
        }
    }

    public final void h() {
        f48211d.add("eot71qyZ0ino8W34o3XG6aQ9YdAn4R1m");
        f48211d.add("AZQtr4jkpf90T3X9QMWVLF1bkeV4LXxD");
        f48211d.add("AukeaxXFpdt1qCe7lE35VCvH27x6ayWI");
        f48211d.add("flFqXclepWs7RdugAszy9eERL7G5dS0I");
        f48211d.add("oFx3nbdDN6GWF3Vb0Wh7EDBMBxRTTcfe");
    }

    @AnyThread
    public void i() {
        if (this.f48213c) {
            if (d.a.l0.a.f1.f.a.f45528a) {
                Log.d("SwanPerformance", "has batch parse app.json, size = " + this.f48212b.size());
                return;
            }
            return;
        }
        this.f48213c = true;
        try {
            q.j(new RunnableC0866a(), "startAsyncBatchParseAppJson");
        } catch (Throwable th) {
            if (d.a.l0.a.f1.f.a.f45528a) {
                Log.e("SwanPerformance", "batch parse app.json exception");
                th.printStackTrace();
            }
        }
    }

    public SwanAppConfigData j(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        String absolutePath = file.getAbsolutePath();
        if (TextUtils.isEmpty(absolutePath)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = this.f48212b.get(absolutePath);
        if (d.a.l0.a.f1.f.a.f45528a) {
            StringBuilder sb = new StringBuilder();
            sb.append("try obtain config data success = ");
            sb.append(swanAppConfigData != null);
            Log.d("SwanPerformance", sb.toString());
        }
        return swanAppConfigData;
    }

    public a() {
        this.f48212b = new ConcurrentHashMap<>();
        this.f48213c = false;
        h();
    }
}
