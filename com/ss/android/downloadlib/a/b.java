package com.ss.android.downloadlib.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
/* loaded from: classes6.dex */
public class b {
    private static volatile b qbw;

    /* renamed from: b  reason: collision with root package name */
    private Handler f12929b = null;

    public static b eEz() {
        if (qbw == null) {
            synchronized (b.class) {
                if (qbw == null) {
                    qbw = new b();
                }
            }
        }
        return qbw;
    }

    public void a(Context context, com.ss.android.socialbase.downloader.g.c cVar) {
        if (b() && cVar != null) {
            try {
                File file = new File(cVar.k(), cVar.h());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f12929b == null) {
                this.f12929b = new Handler(Looper.getMainLooper());
            }
            final String j = cVar.j();
            com.ss.android.socialbase.downloader.downloader.f.iB(context).j(cVar.g());
            this.f12929b.post(new Runnable() { // from class: com.ss.android.downloadlib.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    j.eEN().a(3, j.a(), null, "下载失败，请重试！", null, 0);
                    f aaZ = com.ss.android.downloadlib.h.eFl().aaZ(j);
                    if (aaZ != null) {
                        aaZ.f();
                    }
                }
            });
        }
    }

    public boolean b() {
        return j.i().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
