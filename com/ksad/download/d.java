package com.ksad.download;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.config.AppConfig;
import com.ksad.download.DownloadTask;
import com.ksad.download.h;
import com.kwai.filedownloader.q;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public c f31781c;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, DownloadTask> f31779a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Integer> f31780b = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f31782d = false;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f31783a = new d();
    }

    public static d a() {
        return a.f31783a;
    }

    private void a(int i2, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.f31779a.get(Integer.valueOf(i2));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }

    public static void a(@NonNull Context context, @NonNull File file, @Nullable f fVar) {
        h.a aVar;
        b.a(context);
        b.a(file);
        e.a().a(fVar);
        c.a a2 = new c.a().a(Integer.MAX_VALUE);
        try {
            aVar = new h.a(false);
        } catch (Throwable unused) {
            aVar = null;
        }
        if (aVar != null) {
            a2.a(aVar);
        }
        q.a(context, a2);
    }

    public int a(@NonNull DownloadTask.DownloadRequest downloadRequest, c cVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            b();
        } else if (this.f31782d) {
            c();
        }
        if (this.f31779a.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            b(downloadTask.getId());
            a(downloadTask.getId(), cVar, this.f31781c);
        } else {
            this.f31779a.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.f31780b.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
            a(downloadTask.getId(), cVar, this.f31781c);
        }
        return downloadTask.getId();
    }

    public DownloadTask a(int i2) {
        return this.f31779a.get(Integer.valueOf(i2));
    }

    public void a(int i2, c... cVarArr) {
        DownloadTask downloadTask = this.f31779a.get(Integer.valueOf(i2));
        if (downloadTask == null || cVarArr == null) {
            return;
        }
        for (c cVar : cVarArr) {
            if (cVar != null) {
                cVar.a(i2);
                downloadTask.addListener(cVar);
            }
        }
    }

    public void a(@NonNull DownloadTask downloadTask) {
        this.f31779a.remove(Integer.valueOf(downloadTask.getId()));
        this.f31780b.remove(downloadTask.getUrl());
    }

    public void a(c cVar) {
        this.f31781c = cVar;
    }

    public void b() {
        h.a aVar;
        try {
            aVar = new h.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwai.filedownloader.download.b.a().b(new c.a().a(Integer.MAX_VALUE).a(aVar));
            this.f31782d = true;
        }
    }

    public void b(int i2) {
        DownloadTask downloadTask = this.f31779a.get(Integer.valueOf(i2));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    public void c() {
        h.a aVar;
        try {
            aVar = new h.a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwai.filedownloader.download.b.a().b(new c.a().a(Integer.MAX_VALUE).a(aVar));
        }
    }

    public void c(int i2) {
        DownloadTask downloadTask = this.f31779a.get(Integer.valueOf(i2));
        if (downloadTask != null) {
            downloadTask.cancel();
            a(downloadTask);
        }
    }

    public void d(int i2) {
        DownloadTask downloadTask = this.f31779a.get(Integer.valueOf(i2));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public boolean d() {
        while (true) {
            boolean z = false;
            for (Map.Entry<Integer, DownloadTask> entry : this.f31779a.entrySet()) {
                DownloadTask value = entry.getValue();
                if (value != null) {
                    int status = value.getStatus();
                    if (status != -2 && status != 1 && status != 2 && status != 3 && status != 5 && status != 6 && status != 10 && status != 11 && Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                        z = true;
                    }
                }
            }
            return z;
        }
    }

    public void e(int i2) {
        a(i2, (DownloadTask.DownloadRequest) null);
    }
}
