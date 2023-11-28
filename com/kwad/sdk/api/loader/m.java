package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.f;
import java.io.File;
/* loaded from: classes10.dex */
public final class m {

    /* loaded from: classes10.dex */
    public interface c<T> {
        void g(T t);
    }

    /* loaded from: classes10.dex */
    public interface f<T> {
        void a(v vVar, c<T> cVar);
    }

    /* loaded from: classes10.dex */
    public static abstract class a<T> implements c<T> {
        public c<T> amh;

        public a(c<T> cVar) {
            this.amh = cVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements f<a.C0692a> {
        public f<a.C0692a> aml;

        public d(f<a.C0692a> fVar) {
            this.aml = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0692a> cVar) {
            this.aml.a(vVar, new a<a.C0692a>(cVar) { // from class: com.kwad.sdk.api.loader.m.d.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                @WorkerThread
                /* renamed from: c */
                public void g(@NonNull a.C0692a c0692a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        j.a(c0692a);
                        file = com.kwad.sdk.api.loader.h.p(vVar.getContext(), c0692a.sdkVersion);
                        i.c(c0692a.alv, file);
                        j.a(c0692a, System.currentTimeMillis() - currentTimeMillis);
                        c0692a.alw = file;
                        cVar.g(c0692a);
                    } catch (Throwable th) {
                        j.a(c0692a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                        com.kwad.sdk.api.loader.h.j(file);
                    }
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static class e implements f<Boolean> {
        public f<a.C0692a> aml;

        public e(f<a.C0692a> fVar) {
            this.aml = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<Boolean> cVar) {
            this.aml.a(vVar, new c<a.C0692a>() { // from class: com.kwad.sdk.api.loader.m.e.1
                private void a(a.C0692a c0692a, int i, Throwable th) {
                    com.kwad.sdk.api.loader.h.j(c0692a.alw);
                    j.b(c0692a, i, Log.getStackTraceString(th));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void g(@NonNull a.C0692a c0692a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        j.b(c0692a);
                        if (!com.kwad.sdk.api.loader.b.a(vVar.getContext(), getClass().getClassLoader(), c0692a.alw.getPath(), c0692a.sdkVersion)) {
                            a(c0692a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        com.kwad.sdk.api.loader.g.n(vVar.getContext(), c0692a.sdkVersion);
                        com.kwad.sdk.api.loader.h.j(c0692a.alw);
                        j.b(c0692a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.g(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0692a, 2, th);
                    }
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static class g implements f<a.C0692a> {
        public f<a.C0692a> aml;

        public g(f<a.C0692a> fVar) {
            this.aml = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(v vVar, final c<a.C0692a> cVar) {
            this.aml.a(vVar, new a<a.C0692a>(cVar) { // from class: com.kwad.sdk.api.loader.m.g.1
                private void a(a.C0692a c0692a, int i, Throwable th) {
                    com.kwad.sdk.api.loader.h.j(c0692a.alw);
                    j.a(c0692a, i, th.getMessage());
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void g(@NonNull a.C0692a c0692a) {
                    try {
                        File file = c0692a.alw;
                        if (!r.k(file)) {
                            a(c0692a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!r.a(file, c0692a.md5)) {
                            a(c0692a, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            cVar.g(c0692a);
                        }
                    } catch (Throwable th) {
                        a(c0692a, 3, th);
                    }
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static class h implements f<a.C0692a> {
        public f<a.C0692a> aml;

        public h(f<a.C0692a> fVar) {
            this.aml = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0692a> cVar) {
            this.aml.a(vVar, new c<a.C0692a>() { // from class: com.kwad.sdk.api.loader.m.h.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void g(a.C0692a c0692a) {
                    String ay = com.kwad.sdk.api.loader.g.ay(vVar.getContext());
                    if (TextUtils.isEmpty(ay)) {
                        ay = com.kwad.sdk.api.c.zc().getSDKVersion();
                    }
                    String str = c0692a.sdkVersion;
                    StringBuilder sb = new StringBuilder("UpgradeProducer curVersion:");
                    sb.append(ay);
                    sb.append("-newVersion");
                    sb.append(str);
                    t.a(vVar.getContext(), "interval", c0692a.interval);
                    t.a(vVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0692a.zg()) {
                        u.aE(vVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + ay);
                    } else if (com.kwad.sdk.api.loader.g.G(c0692a.sdkVersion, ay) && c0692a.zf()) {
                        cVar.g(c0692a);
                    } else {
                        new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0692a.sdkVersion + " currentDynamicVersion:" + ay + " dynamicType:" + c0692a.alu);
                    }
                }
            });
        }
    }

    public static f<Boolean> zo() {
        return new e(new g(new d(new h(new b()))));
    }

    /* loaded from: classes10.dex */
    public static class b implements f<a.C0692a> {
        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0692a> cVar) {
            try {
                new com.kwad.sdk.api.loader.f(vVar).a(new f.a() { // from class: com.kwad.sdk.api.loader.m.b.1
                    @Override // com.kwad.sdk.api.loader.f.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        new StringBuilder("ConfigProducer onSuccess data:").append(bVar);
                        if (bVar.zh()) {
                            cVar.g(bVar.aly);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.d.ax(vVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
