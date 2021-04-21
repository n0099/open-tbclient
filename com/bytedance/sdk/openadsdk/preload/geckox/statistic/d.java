package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.geckox.d.g;
import com.bytedance.sdk.openadsdk.preload.geckox.d.h;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.StatisticModel;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.i;
/* loaded from: classes5.dex */
public class d {
    public static com.bytedance.sdk.openadsdk.preload.b.b.a a(final com.bytedance.sdk.openadsdk.preload.geckox.b bVar) {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.1
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar2, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.a(bVar2, dVar);
                e.a(com.bytedance.sdk.openadsdk.preload.geckox.b.this, b.a(dVar.c()));
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar2, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                e.a(com.bytedance.sdk.openadsdk.preload.geckox.b.this, b.a(dVar.c()));
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar2, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                e.a(com.bytedance.sdk.openadsdk.preload.geckox.b.this, b.a(dVar.c()));
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a b(final Context context) {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.5
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                Pair pair = (Pair) bVar.b(h.class);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                String uri = ((Uri) pair.first).toString();
                a2.f30026h = false;
                a2.f30025g = SystemClock.uptimeMillis();
                a2.f30023e.add(new StatisticModel.PackageStatisticModel.DownloadFailRecords(uri, th.getMessage()));
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.f30026h = true;
                a2.f30025g = SystemClock.uptimeMillis();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void c(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.c(bVar, dVar);
                Pair pair = (Pair) bVar.b(h.class);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                a2.f30022d = ((Uri) pair.first).toString();
                a2.p = i.a(context);
                a2.f30024f = SystemClock.uptimeMillis();
                a2.q = Long.valueOf(((UpdatePackage) pair.second).getPatch().getId());
                a2.r = Long.valueOf(((UpdatePackage) pair.second).getFullPackage().getId());
                a2.f30021c = ((UpdatePackage) pair.second).getChannel();
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a c() {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.8
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.j = false;
                a2.n = SystemClock.uptimeMillis();
                a2.t = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.j = true;
                a2.n = SystemClock.uptimeMillis();
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a d() {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.9
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.C = false;
                a2.z = SystemClock.uptimeMillis();
                a2.E = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.C = true;
                a2.z = SystemClock.uptimeMillis();
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a e() {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.10
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.D = false;
                a2.A = SystemClock.uptimeMillis();
                a2.F = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.D = true;
                a2.A = SystemClock.uptimeMillis();
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a f() {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.11
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.k = false;
                a2.u = th.getMessage();
                a2.o = SystemClock.uptimeMillis();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.k = true;
                a2.o = SystemClock.uptimeMillis();
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a g() {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.2
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.D = false;
                a2.A = SystemClock.uptimeMillis();
                a2.F = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.D = false;
                a2.A = SystemClock.uptimeMillis();
                a2.F = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.a(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.D = true;
                a2.A = SystemClock.uptimeMillis();
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a h() {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.3
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.k = false;
                a2.o = SystemClock.uptimeMillis();
                a2.u = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.k = false;
                a2.o = SystemClock.uptimeMillis();
                a2.F = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.a(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.k = true;
                a2.o = SystemClock.uptimeMillis();
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a a(final Context context) {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.4
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                Pair pair = (Pair) bVar.b(g.class);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                String uri = ((Uri) pair.first).toString();
                a2.B = false;
                a2.y = SystemClock.uptimeMillis();
                a2.w.add(new StatisticModel.PackageStatisticModel.DownloadFailRecords(uri, th.getMessage()));
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.B = true;
                a2.y = SystemClock.uptimeMillis();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void c(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.c(bVar, dVar);
                Pair pair = (Pair) bVar.b(g.class);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                a2.v = ((Uri) pair.first).toString();
                a2.p = i.a(context);
                a2.x = SystemClock.uptimeMillis();
                a2.r = Long.valueOf(((UpdatePackage) pair.second).getFullPackage().getId());
                a2.f30021c = ((UpdatePackage) pair.second).getChannel();
                if (!TextUtils.isEmpty(((UpdatePackage) pair.second).getAccessKey())) {
                    a2.f30019a = ((UpdatePackage) pair.second).getAccessKey();
                }
                if (TextUtils.isEmpty(((UpdatePackage) pair.second).getGroupName())) {
                    return;
                }
                a2.f30020b = ((UpdatePackage) pair.second).getGroupName();
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.7
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.j = false;
                a2.m = SystemClock.uptimeMillis();
                a2.t = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.j = true;
                a2.m = SystemClock.uptimeMillis();
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a a() {
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.6
            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.i = false;
                a2.l = SystemClock.uptimeMillis();
                a2.s = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel()).i = true;
            }
        };
    }
}
