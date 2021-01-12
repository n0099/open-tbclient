package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.cache.AwesomeCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f11074a = null;
    private final Object c = new Object();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, a> f11075b = new LinkedHashMap(100);
    private com.kwai.video.ksvodplayerkit.a d = new com.kwai.video.ksvodplayerkit.a() { // from class: com.kwai.video.ksvodplayerkit.f.1
        @Override // com.kwai.video.ksvodplayerkit.a
        public String a(String str) {
            return com.kwai.video.ksvodplayerkit.c.c.c(str);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f11077a;

        /* renamed from: b  reason: collision with root package name */
        long f11078b;

        private a() {
            this.f11077a = false;
            this.f11078b = 0L;
        }
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f11074a == null) {
                f11074a = new f();
            }
            fVar = f11074a;
        }
        return fVar;
    }

    private boolean d(String str) {
        return AwesomeCache.isFullyCached(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            com.kwai.video.ksvodplayerkit.a.b.a("KSVodPlayStatManager", "size:" + this.f11075b.size() + ", add url:" + str);
            synchronized (this.c) {
                if (this.f11075b.size() >= 100) {
                    int i = 0;
                    Iterator<Map.Entry<String, a>> it = this.f11075b.entrySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                        it.remove();
                        i++;
                        if (i >= 20) {
                            break;
                        }
                    }
                }
                str2 = this.d.a(str);
                if (!this.f11075b.containsKey(str2)) {
                    a aVar = new a();
                    aVar.f11077a = AwesomeCache.isFullyCached(str2);
                    this.f11075b.put(str2, aVar);
                }
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        String a2 = this.d.a(str);
        synchronized (this.c) {
            if (!this.f11075b.containsKey(a2)) {
                a(str);
            }
            a aVar = this.f11075b.get(a2);
            if (aVar != null) {
                aVar.f11078b = j;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return d(this.d.a(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c(String str) {
        long j;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String a2 = this.d.a(str);
        synchronized (this.c) {
            if (this.f11075b.containsKey(a2)) {
                a aVar = this.f11075b.get(a2);
                j = aVar != null ? aVar.f11078b : 0L;
            } else {
                j = 0;
            }
        }
        return j;
    }
}
