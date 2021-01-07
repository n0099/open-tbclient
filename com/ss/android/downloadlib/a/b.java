package com.ss.android.downloadlib.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
/* loaded from: classes4.dex */
public class b {
    private static volatile b pVs;

    /* renamed from: b  reason: collision with root package name */
    private Handler f13227b = null;

    public static b eFR() {
        if (pVs == null) {
            synchronized (b.class) {
                if (pVs == null) {
                    pVs = new b();
                }
            }
        }
        return pVs;
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
            if (this.f13227b == null) {
                this.f13227b = new Handler(Looper.getMainLooper());
            }
            final String j = cVar.j();
            com.ss.android.socialbase.downloader.downloader.f.iA(context).j(cVar.g());
            this.f13227b.post(new Runnable() { // from class: com.ss.android.downloadlib.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    j.eGf().a(3, j.a(), null, "下载失败，请重试！", null, 0);
                    f aaT = com.ss.android.downloadlib.h.eGC().aaT(j);
                    if (aaT != null) {
                        aaT.f();
                    }
                }
            });
        }
    }

    public boolean b() {
        return j.i().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
