package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.nps.utils.Constant;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.f;
import java.io.File;
/* loaded from: classes8.dex */
public final class n {

    /* loaded from: classes8.dex */
    public static abstract class a<T> implements c<T> {
        public c<T> Sv;

        public a(c<T> cVar) {
            this.Sv = cVar;
        }

        @Override // com.kwad.sdk.api.loader.n.c
        public final void g(Throwable th) {
            this.Sv.g(th);
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements f<a.C0625a> {
        public final IKsAdSDK Sw;
        public final String b;

        public b(String str, IKsAdSDK iKsAdSDK) {
            this.b = str;
            this.Sw = iKsAdSDK;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final c<a.C0625a> cVar) {
            try {
                final com.kwad.sdk.api.loader.f fVar = new com.kwad.sdk.api.loader.f(this.b, this.Sw);
                final f.a aVar = new f.a() { // from class: com.kwad.sdk.api.loader.n.b.1
                    @Override // com.kwad.sdk.api.loader.f.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        new StringBuilder("ConfigProducer onSuccess data:").append(bVar);
                        if (bVar.a == 1 && bVar.Sg != null) {
                            cVar.c(bVar.Sg);
                        } else {
                            cVar.g(new RuntimeException("UpdateData is illegal"));
                        }
                        try {
                            if (b.this.Sw == null || b.this.Sw.getContext() == null) {
                                return;
                            }
                            com.kwad.sdk.api.loader.d aF = com.kwad.sdk.api.loader.d.aF(b.this.Sw.getContext());
                            if (aF.a) {
                                Log.d("test.chen", "AutoRevertHandler cancel:");
                            }
                            aF.RL.set(true);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.kwad.sdk.api.loader.f.a
                    public final void a(Exception exc) {
                        cVar.g(exc);
                    }
                };
                k.b(new Runnable() { // from class: com.kwad.sdk.api.loader.f.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        fVar.a(aVar);
                    }
                });
            } catch (Exception e) {
                cVar.g(e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c<T> {
        void c(T t);

        void g(Throwable th);
    }

    /* loaded from: classes8.dex */
    public static class d implements f<a.C0625a> {
        public f<a.C0625a> Sy;
        public Context b;

        public d(f<a.C0625a> fVar, Context context) {
            this.Sy = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final c<a.C0625a> cVar) {
            this.Sy.a(new a<a.C0625a>(cVar) { // from class: com.kwad.sdk.api.loader.n.d.1
                @Override // com.kwad.sdk.api.loader.n.c
                @WorkerThread
                public final /* synthetic */ void c(@NonNull Object obj) {
                    File file;
                    Throwable th;
                    a.C0625a c0625a = (a.C0625a) obj;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        j.a(c0625a);
                        Context context = d.this.b;
                        String str = c0625a.e;
                        file = new File(com.kwad.sdk.api.loader.h.aG(context), "dynamic-" + System.currentTimeMillis() + "-" + str + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                        try {
                            i.b(c0625a.b, file);
                            j.a(c0625a, System.currentTimeMillis() - currentTimeMillis);
                            c0625a.Sf = file;
                            cVar.c(c0625a);
                        } catch (Throwable th2) {
                            th = th2;
                            j.a(c0625a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                            com.kwad.sdk.api.loader.h.f(file);
                            cVar.g(th);
                        }
                    } catch (Throwable th3) {
                        file = null;
                        th = th3;
                    }
                }
            });
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements f<Boolean> {
        public f<a.C0625a> Sy;
        public Context b;

        public e(f<a.C0625a> fVar, Context context) {
            this.Sy = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final c<Boolean> cVar) {
            this.Sy.a(new c<a.C0625a>() { // from class: com.kwad.sdk.api.loader.n.e.1
                private void a(a.C0625a c0625a, int i, Throwable th) {
                    try {
                        com.kwad.sdk.api.loader.h.d(c0625a.Sf);
                    } catch (Exception unused) {
                    }
                    j.b(c0625a, i, Log.getStackTraceString(th));
                    g(th);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.kwad.sdk.api.loader.n.c
                public final /* synthetic */ void c(@NonNull a.C0625a c0625a) {
                    a.C0625a c0625a2 = c0625a;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        j.b(c0625a2);
                        if (!com.kwad.sdk.api.loader.b.b(e.this.b, c0625a2.Sf.getPath(), c0625a2.e)) {
                            a(c0625a2, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        com.kwad.sdk.api.loader.g.b(e.this.b, c0625a2.e);
                        com.kwad.sdk.api.loader.h.f(c0625a2.Sf);
                        j.b(c0625a2, System.currentTimeMillis() - currentTimeMillis);
                        cVar.c(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0625a2, 2, th);
                    }
                }

                @Override // com.kwad.sdk.api.loader.n.c
                public final void g(Throwable th) {
                    cVar.g(th);
                }
            });
        }
    }

    /* loaded from: classes8.dex */
    public interface f<T> {
        void a(c<T> cVar);
    }

    /* loaded from: classes8.dex */
    public static class g implements f<a.C0625a> {
        public f<a.C0625a> Sy;
        public Context b;

        public g(f<a.C0625a> fVar, Context context) {
            this.Sy = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final c<a.C0625a> cVar) {
            this.Sy.a(new a<a.C0625a>(cVar) { // from class: com.kwad.sdk.api.loader.n.g.1
                private void a(a.C0625a c0625a, int i, Throwable th) {
                    try {
                        com.kwad.sdk.api.loader.h.d(c0625a.Sf);
                    } catch (Exception unused) {
                    }
                    j.a(c0625a, i, th.getMessage());
                    cVar.g(th);
                }

                @Override // com.kwad.sdk.api.loader.n.c
                public final /* synthetic */ void c(@NonNull Object obj) {
                    a.C0625a c0625a = (a.C0625a) obj;
                    try {
                        File file = c0625a.Sf;
                        boolean z = false;
                        if (!(file != null && file.exists() && file.length() > 0 && file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX))) {
                            a(c0625a, 1, new RuntimeException("Security checkFileValid fail"));
                            return;
                        }
                        String str = c0625a.c;
                        if (!TextUtils.isEmpty(str)) {
                            z = str.toLowerCase().equals(s.a(file).toLowerCase());
                        }
                        if (z) {
                            cVar.c(c0625a);
                        } else {
                            a(c0625a, 2, new RuntimeException("Security checkMd5 fail"));
                        }
                    } catch (Throwable th) {
                        a(c0625a, 3, th);
                    }
                }
            });
        }
    }

    /* loaded from: classes8.dex */
    public static class h implements f<a.C0625a> {
        public f<a.C0625a> Sy;
        public Context b;

        public h(f<a.C0625a> fVar, Context context) {
            this.Sy = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final c<a.C0625a> cVar) {
            this.Sy.a(new c<a.C0625a>() { // from class: com.kwad.sdk.api.loader.n.h.1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.kwad.sdk.api.loader.n.c
                public final /* synthetic */ void c(a.C0625a c0625a) {
                    a.C0625a c0625a2 = c0625a;
                    if (c0625a2 != null) {
                        String a = com.kwad.sdk.api.loader.g.a(h.this.b);
                        if (TextUtils.isEmpty(a)) {
                            a = Loader.get().getKsAdSDKImpl().getSDKVersion();
                        }
                        String str = c0625a2.e;
                        StringBuilder sb = new StringBuilder("UpgradeProducer curVersion:");
                        sb.append(a);
                        sb.append("-newVersion");
                        sb.append(str);
                        t.a(h.this.b, "interval", c0625a2.Se);
                        t.a(h.this.b, "lastUpdateTime", System.currentTimeMillis());
                        if (c0625a2.a == -1) {
                            com.kwad.sdk.api.loader.g.a(h.this.b, "");
                            cVar.g(new RuntimeException("DynamicType == -1, curVersion: ".concat(String.valueOf(a))));
                            return;
                        }
                        if (com.kwad.sdk.api.loader.g.a(c0625a2.e, a)) {
                            if (c0625a2.a == 1) {
                                cVar.c(c0625a2);
                                return;
                            }
                        }
                        c cVar2 = cVar;
                        cVar2.g(new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0625a2.e + " currentDynamicVersion:" + a + " dynamicType:" + c0625a2.a));
                    }
                }

                @Override // com.kwad.sdk.api.loader.n.c
                @WorkerThread
                public final void g(Throwable th) {
                    cVar.g(th);
                }
            });
        }
    }
}
