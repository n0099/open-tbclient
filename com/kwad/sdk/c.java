package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.config.AppConfig;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.r;
import com.kwad.framework.filedownloader.services.c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.j;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class c {
    public com.kwad.sdk.a akb;
    public d akd;
    public Context mContext;
    public final Map<Integer, DownloadTask> ajZ = new ConcurrentHashMap();
    public final Map<String, Integer> aka = new ConcurrentHashMap();
    public boolean akc = false;

    /* loaded from: classes10.dex */
    public static final class a {
        public static final c akg = new c();
    }

    public static c xA() {
        return a.akg;
    }

    public static boolean xD() {
        try {
            Class.forName("com.kwad.sdk.api.proxy.app.BaseFragmentActivity.RequestInstallPermissionActivity");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void xE() {
        j.a aVar;
        try {
            aVar = new j.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.ve().b(new c.b().bC(Integer.MAX_VALUE).a(aVar));
            this.akc = true;
        }
    }

    public static void xF() {
        j.a aVar;
        try {
            aVar = new j.a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.ve().b(new c.b().bC(Integer.MAX_VALUE).a(aVar));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final File xB() {
        return aw.cL(this.mContext);
    }

    public final d xC() {
        if (this.akd == null) {
            this.akd = new com.kwad.sdk.core.download.b.a();
        }
        return this.akd;
    }

    private void a(int i, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.ajZ.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }

    private void a(int i, com.kwad.sdk.a... aVarArr) {
        DownloadTask downloadTask = this.ajZ.get(Integer.valueOf(i));
        if (downloadTask != null) {
            for (int i2 = 0; i2 < 2; i2++) {
                com.kwad.sdk.a aVar = aVarArr[i2];
                if (aVar != null) {
                    aVar.setId(i);
                    downloadTask.addListener(aVar);
                }
            }
        }
    }

    public static void bL(String str) {
        if (str == null) {
            return;
        }
        q.delete(com.kwad.framework.filedownloader.f.f.bm(str));
        q.delete(str);
    }

    private void bM(int i) {
        DownloadTask downloadTask = this.ajZ.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    private void h(@NonNull DownloadTask downloadTask) {
        this.ajZ.remove(Integer.valueOf(downloadTask.getId()));
        this.aka.remove(downloadTask.getUrl());
    }

    public final void a(com.kwad.sdk.a aVar) {
        this.akb = aVar;
    }

    public final void bN(int i) {
        DownloadTask bL = bL(i);
        if (bL == null) {
            return;
        }
        if (bL.isUserPause()) {
            resume(i);
        } else {
            pause(i);
        }
    }

    public final void cancel(int i) {
        DownloadTask downloadTask = this.ajZ.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.cancel();
            h(downloadTask);
        }
    }

    public final void g(DownloadTask downloadTask) {
        final String bn = ad.bn(downloadTask.getUrl());
        ak.a(downloadTask.getTargetFilePath(), new ak.a() { // from class: com.kwad.sdk.c.2
            @Override // com.kwad.sdk.utils.ak.a
            public final void f(Throwable th) {
                com.kwad.sdk.core.download.b.BU().f(bn, th);
            }

            @Override // com.kwad.sdk.utils.ak.a
            public final void ob() {
                com.kwad.sdk.core.download.b.BU().dg(bn);
            }
        });
    }

    public final void init(@NonNull Context context) {
        this.mContext = context;
        r.a(context, new c.b().bC(Integer.MAX_VALUE).a(new c.a() { // from class: com.kwad.sdk.c.1
            @Override // com.kwad.framework.filedownloader.services.c.a
            public final c.b vk() {
                try {
                    j.a aVar = new j.a(false);
                    aVar.aX("");
                    return aVar;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }));
    }

    public final void pause(int i) {
        DownloadTask downloadTask = this.ajZ.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public final void resume(int i) {
        a(i, (DownloadTask.DownloadRequest) null);
    }

    public final int a(@NonNull DownloadTask.DownloadRequest downloadRequest, com.kwad.sdk.a aVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            xE();
        } else if (this.akc) {
            xF();
        }
        if (this.ajZ.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            bM(downloadTask.getId());
        } else {
            this.ajZ.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.aka.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
        }
        a(downloadTask.getId(), null, this.akb);
        return downloadTask.getId();
    }

    public final DownloadTask bL(int i) {
        return this.ajZ.get(Integer.valueOf(i));
    }

    public final boolean xG() {
        while (true) {
            boolean z = false;
            for (Map.Entry<Integer, DownloadTask> entry : this.ajZ.entrySet()) {
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
}
