package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.cache.AwesomeCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f37316a;

    /* renamed from: c  reason: collision with root package name */
    public final Object f37318c = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, a> f37317b = new LinkedHashMap(100);

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.a f37319d = new com.kwai.video.ksvodplayerkit.a() { // from class: com.kwai.video.ksvodplayerkit.f.1
        @Override // com.kwai.video.ksvodplayerkit.a
        public String a(String str) {
            return com.kwai.video.ksvodplayerkit.c.c.c(str);
        }
    };

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f37321a;

        /* renamed from: b  reason: collision with root package name */
        public long f37322b;

        public a() {
            this.f37321a = false;
            this.f37322b = 0L;
        }
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f37316a == null) {
                f37316a = new f();
            }
            fVar = f37316a;
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
        com.kwai.video.ksvodplayerkit.a.b.a("KSVodPlayStatManager", "size:" + this.f37317b.size() + ", add url:" + str);
        synchronized (this.f37318c) {
            if (this.f37317b.size() >= 100) {
                int i = 0;
                Iterator<Map.Entry<String, a>> it = this.f37317b.entrySet().iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                    i++;
                    if (i >= 20) {
                        break;
                    }
                }
            }
            String a2 = this.f37319d.a(str);
            if (this.f37317b.containsKey(a2)) {
                return a2;
            }
            a aVar = new a();
            aVar.f37321a = AwesomeCache.isFullyCached(a2);
            this.f37317b.put(a2, aVar);
            return a2;
        }
    }

    public void a(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        String a2 = this.f37319d.a(str);
        synchronized (this.f37318c) {
            if (!this.f37317b.containsKey(a2)) {
                a(str);
            }
            a aVar = this.f37317b.get(a2);
            if (aVar != null) {
                aVar.f37322b = j;
            }
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return d(this.f37319d.a(str));
    }

    public long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String a2 = this.f37319d.a(str);
        synchronized (this.f37318c) {
            if (this.f37317b.containsKey(a2)) {
                a aVar = this.f37317b.get(a2);
                if (aVar != null) {
                    return aVar.f37322b;
                }
                return 0L;
            }
            return 0L;
        }
    }
}
