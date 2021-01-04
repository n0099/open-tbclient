package com.ss.android.downloadlib.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
/* loaded from: classes4.dex */
public class b {
    private static volatile b pTK;

    /* renamed from: b  reason: collision with root package name */
    private Handler f13226b = null;

    public static b eFn() {
        if (pTK == null) {
            synchronized (b.class) {
                if (pTK == null) {
                    pTK = new b();
                }
            }
        }
        return pTK;
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
            if (this.f13226b == null) {
                this.f13226b = new Handler(Looper.getMainLooper());
            }
            final String j = cVar.j();
            com.ss.android.socialbase.downloader.downloader.f.iA(context).j(cVar.g());
            this.f13226b.post(new Runnable() { // from class: com.ss.android.downloadlib.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    j.eFB().a(3, j.a(), null, "下载失败，请重试！", null, 0);
                    f aaS = com.ss.android.downloadlib.h.eFY().aaS(j);
                    if (aaS != null) {
                        aaS.f();
                    }
                }
            });
        }
    }

    public boolean b() {
        return j.i().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
