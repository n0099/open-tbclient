package com.qq.e.comm.plugin.intersitial2.fullscreen;

import android.text.TextUtils;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ba;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f12135a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Set<a>> f12136b = new ConcurrentHashMap();

    /* loaded from: classes15.dex */
    public interface a {
        void a();

        void a(int i);

        void a(com.qq.e.comm.plugin.j.c cVar);

        void a(String str);
    }

    private b() {
    }

    public static b a() {
        if (f12135a == null) {
            synchronized (b.class) {
                try {
                    if (f12135a == null) {
                        f12135a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12135a;
    }

    public void a(String str) {
        Set<a> set;
        if (TextUtils.isEmpty(str) || (set = this.f12136b.get(str)) == null) {
            return;
        }
        set.clear();
    }

    public void a(final String str, String str2, a aVar, final com.qq.e.comm.plugin.y.c cVar) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("download url null");
            return;
        }
        if (aVar != null) {
            Set<a> set = this.f12136b.get(str);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(aVar);
            this.f12136b.put(str, set);
        }
        com.qq.e.comm.plugin.aa.a.a.a().a(new b.a().b(str).a(ah.a(str)).a(ah.f()).a(), str, new com.qq.e.comm.plugin.j.a() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.b.1
            private int d;

            @Override // com.qq.e.comm.plugin.j.a
            public void a() {
                GDTLogger.d("onStarted");
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Set<a> set2 = (Set) b.this.f12136b.get(str);
                        if (set2 == null || set2.size() <= 0) {
                            return;
                        }
                        for (a aVar2 : set2) {
                            aVar2.a();
                        }
                    }
                });
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(long j, long j2, final int i) {
                GDTLogger.d("downloading video ---> Progress: " + i + "%");
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.b.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Set<a> set2 = (Set) b.this.f12136b.get(str);
                        if (set2 == null || set2.size() <= 0) {
                            return;
                        }
                        for (a aVar2 : set2) {
                            aVar2.a(i);
                        }
                    }
                });
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(long j, boolean z) {
                this.d = (int) (j >> 10);
                GDTLogger.d("onConnected isRangeSupport: " + z + ", total: " + j);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(final com.qq.e.comm.plugin.j.c cVar2) {
                GDTLogger.w("Video download Failed, code: " + cVar2.a() + ", msg: " + cVar2.b(), null);
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.b.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Set<a> set2 = (Set) b.this.f12136b.get(str);
                        if (set2 != null && set2.size() > 0) {
                            for (a aVar2 : set2) {
                                aVar2.a(cVar2);
                            }
                        }
                        b.this.f12136b.remove(str);
                    }
                });
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(File file, long j) {
                GDTLogger.d("onCompleted");
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.b.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Set<a> set2 = (Set) b.this.f12136b.get(str);
                        if (set2 != null && set2.size() > 0) {
                            for (a aVar2 : set2) {
                                File d = ah.d(str);
                                aVar2.a(d == null ? "" : d.getAbsolutePath());
                            }
                        }
                        b.this.f12136b.remove(str);
                    }
                });
                ba.a(j, this.d, str, cVar);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void b() {
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void c() {
            }
        });
    }
}
