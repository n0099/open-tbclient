package com.ss.android.downloadlib.addownload.c;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class d {
    public static volatile d a;

    /* renamed from: b  reason: collision with root package name */
    public long f42791b = 0;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, e> f42792c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Integer> f42793d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public List<String> f42794e = new CopyOnWriteArrayList();

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public long b() {
        return this.f42791b;
    }

    public void c() {
        this.f42791b = System.currentTimeMillis();
    }

    public int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f42793d == null) {
            this.f42793d = new HashMap<>();
        }
        if (this.f42793d.containsKey(str)) {
            return this.f42793d.get(str).intValue();
        }
        return 0;
    }

    public void a(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f42792c.put(str, eVar);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f42792c.remove(str);
    }

    @WorkerThread
    public static void a(com.ss.android.downloadad.api.a.b bVar) {
        DownloadInfo downloadInfo;
        if (bVar == null || bVar.b() <= 0 || (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s())) == null) {
            return;
        }
        a(downloadInfo);
    }

    @WorkerThread
    public static void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
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
}
