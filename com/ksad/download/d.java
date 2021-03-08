package com.ksad.download;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.download.DownloadTask;
import com.ksad.download.h;
import com.kwai.filedownloader.q;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class d {
    private c c;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, DownloadTask> f5298a = new ConcurrentHashMap();
    private final Map<String, Integer> b = new ConcurrentHashMap();
    private boolean d = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f5299a = new d();
    }

    public static d a() {
        return a.f5299a;
    }

    private void a(int i, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.f5298a.get(Integer.valueOf(i));
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
        } catch (Throwable th) {
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
        } else if (this.d) {
            c();
        }
        if (this.f5298a.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            b(downloadTask.getId());
            a(downloadTask.getId(), cVar, this.c);
        } else {
            this.f5298a.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.b.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
            a(downloadTask.getId(), cVar, this.c);
        }
        return downloadTask.getId();
    }

    public DownloadTask a(int i) {
        return this.f5298a.get(Integer.valueOf(i));
    }

    public void a(int i, c... cVarArr) {
        DownloadTask downloadTask = this.f5298a.get(Integer.valueOf(i));
        if (downloadTask == null || cVarArr == null) {
            return;
        }
        for (c cVar : cVarArr) {
            if (cVar != null) {
                cVar.a(i);
                downloadTask.addListener(cVar);
            }
        }
    }

    void a(@NonNull DownloadTask downloadTask) {
        this.f5298a.remove(Integer.valueOf(downloadTask.getId()));
        this.b.remove(downloadTask.getUrl());
    }

    public void a(c cVar) {
        this.c = cVar;
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
            this.d = true;
        }
    }

    public void b(int i) {
        DownloadTask downloadTask = this.f5298a.get(Integer.valueOf(i));
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

    public void c(int i) {
        DownloadTask downloadTask = this.f5298a.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.cancel();
            a(downloadTask);
        }
    }

    public void d(int i) {
        DownloadTask downloadTask = this.f5298a.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public boolean d() {
        boolean z;
        boolean z2 = false;
        for (Map.Entry<Integer, DownloadTask> entry : this.f5298a.entrySet()) {
            DownloadTask value = entry.getValue();
            if (value != null) {
                switch (value.getStatus()) {
                    case -2:
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 10:
                    case 11:
                        z = false;
                        continue;
                    case -1:
                    case 0:
                    case 4:
                    case 7:
                    case 8:
                    case 9:
                    default:
                        if (Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > 120000) {
                            z = true;
                            break;
                        } else {
                            z = false;
                            continue;
                        }
                }
            } else {
                z = z2;
            }
            z2 = z;
        }
        return z2;
    }

    public void e(int i) {
        a(i, (DownloadTask.DownloadRequest) null);
    }
}
