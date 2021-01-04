package com.qq.e.comm.plugin.aa.a;

import android.text.TextUtils;
import com.qq.e.comm.plugin.aa.a.c;
import com.qq.e.comm.plugin.j.b;
import com.qq.e.comm.plugin.util.s;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes3.dex */
public class a implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f11949a = null;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, c> f11950b = new ConcurrentHashMap();
    private final com.qq.e.comm.plugin.j.b c = new b.a().a(Executors.newFixedThreadPool(15, new ThreadFactory() { // from class: com.qq.e.comm.plugin.aa.a.a.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_DOWNLOAD_THREAD");
        }
    })).b(10000).a(10000).a();

    private a() {
    }

    public static a a() {
        if (f11949a == null) {
            synchronized (a.class) {
                try {
                    if (f11949a == null) {
                        f11949a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11949a;
    }

    private String b(String str) {
        if (str == null) {
            throw new NullPointerException("Tag can't be null!");
        }
        return String.valueOf(str.hashCode());
    }

    public void a(b bVar, String str, com.qq.e.comm.plugin.j.a aVar) {
        if (TextUtils.isEmpty(bVar.c())) {
            if (aVar != null) {
                aVar.a(new com.qq.e.comm.plugin.j.c(134217728, "UrlIsEmpty"));
                return;
            }
            return;
        }
        String b2 = b(str);
        c cVar = this.f11950b.get(b2);
        if (cVar == null) {
            c cVar2 = new c(b2, bVar, aVar, this.c);
            cVar2.a(this);
            this.f11950b.put(b2, cVar2);
            s.f12888a.submit(cVar2);
        } else if (!cVar.a()) {
            GDTLogger.e("Downloader instance with same tag has not been destroyed!");
        } else {
            cVar.a(aVar);
            GDTLogger.w("Task has been started!", null);
        }
    }

    @Override // com.qq.e.comm.plugin.aa.a.c.a
    public void a(String str) {
        this.f11950b.remove(str);
    }
}
