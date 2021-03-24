package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.cache.AwesomeCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f37315a;

    /* renamed from: c  reason: collision with root package name */
    public final Object f37317c = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, a> f37316b = new LinkedHashMap(100);

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.a f37318d = new com.kwai.video.ksvodplayerkit.a() { // from class: com.kwai.video.ksvodplayerkit.f.1
        @Override // com.kwai.video.ksvodplayerkit.a
        public String a(String str) {
            return com.kwai.video.ksvodplayerkit.c.c.c(str);
        }
    };

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f37320a;

        /* renamed from: b  reason: collision with root package name */
        public long f37321b;

        public a() {
            this.f37320a = false;
            this.f37321b = 0L;
        }
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f37315a == null) {
                f37315a = new f();
            }
            fVar = f37315a;
        }
        return fVar;
    }

    private boolean d(String str) {
        return AwesomeCache.isFullyCached(str);
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.kwai.video.ksvodplayerkit.a.b.a("KSVodPlayStatManager", "size:" + this.f37316b.size() + ", add url:" + str);
        synchronized (this.f37317c) {
            if (this.f37316b.size() >= 100) {
                int i = 0;
                Iterator<Map.Entry<String, a>> it = this.f37316b.entrySet().iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                    i++;
                    if (i >= 20) {
                        break;
                    }
                }
            }
            String a2 = this.f37318d.a(str);
            if (this.f37316b.containsKey(a2)) {
                return a2;
            }
            a aVar = new a();
            aVar.f37320a = AwesomeCache.isFullyCached(a2);
            this.f37316b.put(a2, aVar);
            return a2;
        }
    }

    public void a(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        String a2 = this.f37318d.a(str);
        synchronized (this.f37317c) {
            if (!this.f37316b.containsKey(a2)) {
                a(str);
            }
            a aVar = this.f37316b.get(a2);
            if (aVar != null) {
                aVar.f37321b = j;
            }
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return d(this.f37318d.a(str));
    }

    public long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String a2 = this.f37318d.a(str);
        synchronized (this.f37317c) {
            if (this.f37316b.containsKey(a2)) {
                a aVar = this.f37316b.get(a2);
                if (aVar != null) {
                    return aVar.f37321b;
                }
                return 0L;
            }
            return 0L;
        }
    }
}
