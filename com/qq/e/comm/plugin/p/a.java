package com.qq.e.comm.plugin.p;

import android.text.TextUtils;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f12637a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f12638b = Executors.newFixedThreadPool(5, new ThreadFactory() { // from class: com.qq.e.comm.plugin.p.a.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_IMAGE_LOADER_THREAD");
        }
    });

    private a() {
    }

    public static a a() {
        if (f12637a == null) {
            synchronized (a.class) {
                try {
                    if (f12637a == null) {
                        f12637a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12637a;
    }

    private void a(String str, ImageView imageView, b bVar, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f12638b.submit(new d(str, imageView, bVar, z));
        } else if (bVar != null) {
            bVar.a(str, 134217728, new Exception("UrlIsEmpty"));
        }
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, null, false);
    }

    public void a(String str, ImageView imageView, b bVar) {
        a(str, imageView, bVar, false);
    }

    public void a(String str, b bVar) {
        a(str, null, bVar, true);
    }
}
