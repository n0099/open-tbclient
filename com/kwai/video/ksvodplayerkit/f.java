package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.cache.AwesomeCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f38092a;

    /* renamed from: c  reason: collision with root package name */
    public final Object f38094c = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, a> f38093b = new LinkedHashMap(100);

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.a f38095d = new com.kwai.video.ksvodplayerkit.a() { // from class: com.kwai.video.ksvodplayerkit.f.1
        @Override // com.kwai.video.ksvodplayerkit.a
        public String a(String str) {
            return com.kwai.video.ksvodplayerkit.c.c.c(str);
        }
    };

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f38097a;

        /* renamed from: b  reason: collision with root package name */
        public long f38098b;

        public a() {
            this.f38097a = false;
            this.f38098b = 0L;
        }
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f38092a == null) {
                f38092a = new f();
            }
            fVar = f38092a;
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
        com.kwai.video.ksvodplayerkit.a.b.a("KSVodPlayStatManager", "size:" + this.f38093b.size() + ", add url:" + str);
        synchronized (this.f38094c) {
            if (this.f38093b.size() >= 100) {
                int i2 = 0;
                Iterator<Map.Entry<String, a>> it = this.f38093b.entrySet().iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                    i2++;
                    if (i2 >= 20) {
                        break;
                    }
                }
            }
            String a2 = this.f38095d.a(str);
            if (this.f38093b.containsKey(a2)) {
                return a2;
            }
            a aVar = new a();
            aVar.f38097a = AwesomeCache.isFullyCached(a2);
            this.f38093b.put(a2, aVar);
            return a2;
        }
    }

    public void a(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        String a2 = this.f38095d.a(str);
        synchronized (this.f38094c) {
            if (!this.f38093b.containsKey(a2)) {
                a(str);
            }
            a aVar = this.f38093b.get(a2);
            if (aVar != null) {
                aVar.f38098b = j;
            }
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return d(this.f38095d.a(str));
    }

    public long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String a2 = this.f38095d.a(str);
        synchronized (this.f38094c) {
            if (this.f38093b.containsKey(a2)) {
                a aVar = this.f38093b.get(a2);
                if (aVar != null) {
                    return aVar.f38098b;
                }
                return 0L;
            }
            return 0L;
        }
    }
}
