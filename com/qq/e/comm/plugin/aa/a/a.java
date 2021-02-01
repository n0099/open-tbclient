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
/* loaded from: classes15.dex */
public class a implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f11652a = null;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, c> f11653b = new ConcurrentHashMap();
    private final com.qq.e.comm.plugin.j.b c = new b.a().a(Executors.newFixedThreadPool(15, new ThreadFactory() { // from class: com.qq.e.comm.plugin.aa.a.a.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_DOWNLOAD_THREAD");
        }
    })).b(10000).a(10000).a();

    private a() {
    }

    public static a a() {
        if (f11652a == null) {
            synchronized (a.class) {
                try {
                    if (f11652a == null) {
                        f11652a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11652a;
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
        c cVar = this.f11653b.get(b2);
        if (cVar == null) {
            c cVar2 = new c(b2, bVar, aVar, this.c);
            cVar2.a(this);
            this.f11653b.put(b2, cVar2);
            s.f12591a.submit(cVar2);
        } else if (!cVar.a()) {
            GDTLogger.e("Downloader instance with same tag has not been destroyed!");
        } else {
            cVar.a(aVar);
            GDTLogger.w("Task has been started!", null);
        }
    }

    @Override // com.qq.e.comm.plugin.aa.a.c.a
    public void a(String str) {
        this.f11653b.remove(str);
    }
}
