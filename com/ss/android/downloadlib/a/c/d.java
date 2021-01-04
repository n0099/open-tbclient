package com.ss.android.downloadlib.a.c;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.downloader.downloader.f;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class d {
    private static volatile d pTX;

    /* renamed from: b  reason: collision with root package name */
    private long f13244b = 0;
    private ConcurrentHashMap<String, e> c = new ConcurrentHashMap<>();
    private HashMap<String, Integer> d = new HashMap<>();
    private List<String> e = new CopyOnWriteArrayList();

    public static d eFu() {
        if (pTX == null) {
            synchronized (d.class) {
                if (pTX == null) {
                    pTX = new d();
                }
            }
        }
        return pTX;
    }

    public void a(String str, e eVar) {
        if (!TextUtils.isEmpty(str)) {
            this.c.put(str, eVar);
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b() {
        return this.f13244b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f13244b = System.currentTimeMillis();
    }

    public int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.d == null) {
            this.d = new HashMap<>();
        }
        if (this.d.containsKey(str)) {
            return this.d.get(str).intValue();
        }
        return 0;
    }

    @WorkerThread
    public static void d(com.ss.android.b.a.b.a aVar) {
        com.ss.android.socialbase.downloader.g.c h;
        if (aVar != null && aVar.j() > 0 && (h = f.iA(j.a()).h(aVar.t())) != null) {
            a(h);
        }
    }

    @WorkerThread
    public static void a(com.ss.android.socialbase.downloader.g.c cVar) {
        File file;
        if (cVar != null && com.ss.android.socialbase.downloader.k.a.SR(cVar.g()).a("delete_file_after_install", 0) != 0) {
            try {
                String str = cVar.k() + File.separator + cVar.h();
                if (!TextUtils.isEmpty(str) && (file = new File(str)) != null && file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
