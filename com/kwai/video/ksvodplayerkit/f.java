package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.cache.AwesomeCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f7291a = null;
    private final Object c = new Object();
    private Map<String, a> b = new LinkedHashMap(100);
    private com.kwai.video.ksvodplayerkit.a d = new com.kwai.video.ksvodplayerkit.a() { // from class: com.kwai.video.ksvodplayerkit.f.1
        @Override // com.kwai.video.ksvodplayerkit.a
        public String a(String str) {
            return com.kwai.video.ksvodplayerkit.c.c.c(str);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f7293a;
        long b;

        private a() {
            this.f7293a = false;
            this.b = 0L;
        }
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f7291a == null) {
                f7291a = new f();
            }
            fVar = f7291a;
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
            com.kwai.video.ksvodplayerkit.a.b.a("KSVodPlayStatManager", "size:" + this.b.size() + ", add url:" + str);
            synchronized (this.c) {
                if (this.b.size() >= 100) {
                    int i = 0;
                    Iterator<Map.Entry<String, a>> it = this.b.entrySet().iterator();
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
                if (!this.b.containsKey(str2)) {
                    a aVar = new a();
                    aVar.f7293a = AwesomeCache.isFullyCached(str2);
                    this.b.put(str2, aVar);
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
            if (!this.b.containsKey(a2)) {
                a(str);
            }
            a aVar = this.b.get(a2);
            if (aVar != null) {
                aVar.b = j;
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
            if (this.b.containsKey(a2)) {
                a aVar = this.b.get(a2);
                j = aVar != null ? aVar.b : 0L;
            } else {
                j = 0;
            }
        }
        return j;
    }
}
