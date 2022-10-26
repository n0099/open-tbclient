package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.nps.utils.Constant;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.f;
import java.io.File;
/* loaded from: classes7.dex */
public final class n {

    /* loaded from: classes7.dex */
    public abstract class a implements c {
        public c Sv;

        public a(c cVar) {
            this.Sv = cVar;
        }

        @Override // com.kwad.sdk.api.loader.n.c
        public final void g(Throwable th) {
            this.Sv.g(th);
        }
    }

    /* loaded from: classes7.dex */
    public final class b implements f {
        public final IKsAdSDK Sw;
        public final String b;

        public b(String str, IKsAdSDK iKsAdSDK) {
            this.b = str;
            this.Sw = iKsAdSDK;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final c cVar) {
            try {
                final com.kwad.sdk.api.loader.f fVar = new com.kwad.sdk.api.loader.f(this.b, this.Sw);
                final f.a aVar = new f.a() { // from class: com.kwad.sdk.api.loader.n.b.1
                    @Override // com.kwad.sdk.api.loader.f.a
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

    /* loaded from: classes7.dex */
    public interface c {
        void c(Object obj);

        void g(Throwable th);
    }

    /* loaded from: classes7.dex */
    public final class d implements f {
        public f Sy;
        public Context b;

        public d(f fVar, Context context) {
            this.Sy = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final c cVar) {
            this.Sy.a(new a(cVar) { // from class: com.kwad.sdk.api.loader.n.d.1
                @Override // com.kwad.sdk.api.loader.n.c
                public final /* synthetic */ void c(Object obj) {
                    File file;
                    Throwable th;
                    a.C0593a c0593a = (a.C0593a) obj;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        j.a(c0593a);
                        Context context = d.this.b;
                        String str = c0593a.e;
                        file = new File(com.kwad.sdk.api.loader.h.aG(context), "dynamic-" + System.currentTimeMillis() + "-" + str + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                        try {
                            i.b(c0593a.b, file);
                            j.a(c0593a, System.currentTimeMillis() - currentTimeMillis);
                            c0593a.Sf = file;
                            cVar.c(c0593a);
                        } catch (Throwable th2) {
                            th = th2;
                            j.a(c0593a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
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

    /* loaded from: classes7.dex */
    public final class e implements f {
        public f Sy;
        public Context b;

        public e(f fVar, Context context) {
            this.Sy = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final c cVar) {
            this.Sy.a(new c() { // from class: com.kwad.sdk.api.loader.n.e.1
                private void a(a.C0593a c0593a, int i, Throwable th) {
                    try {
                        com.kwad.sdk.api.loader.h.d(c0593a.Sf);
                    } catch (Exception unused) {
                    }
                    j.b(c0593a, i, Log.getStackTraceString(th));
                    g(th);
                }

                @Override // com.kwad.sdk.api.loader.n.c
                public final /* synthetic */ void c(Object obj) {
                    a.C0593a c0593a = (a.C0593a) obj;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        j.b(c0593a);
                        if (!com.kwad.sdk.api.loader.b.b(e.this.b, c0593a.Sf.getPath(), c0593a.e)) {
                            a(c0593a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        com.kwad.sdk.api.loader.g.b(e.this.b, c0593a.e);
                        com.kwad.sdk.api.loader.h.f(c0593a.Sf);
                        j.b(c0593a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.c(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0593a, 2, th);
                    }
                }

                @Override // com.kwad.sdk.api.loader.n.c
                public final void g(Throwable th) {
                    cVar.g(th);
                }
            });
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(c cVar);
    }

    /* loaded from: classes7.dex */
    public final class g implements f {
        public f Sy;
        public Context b;

        public g(f fVar, Context context) {
            this.Sy = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final c cVar) {
            this.Sy.a(new a(cVar) { // from class: com.kwad.sdk.api.loader.n.g.1
                private void a(a.C0593a c0593a, int i, Throwable th) {
                    try {
                        com.kwad.sdk.api.loader.h.d(c0593a.Sf);
                    } catch (Exception unused) {
                    }
                    j.a(c0593a, i, th.getMessage());
                    cVar.g(th);
                }

                @Override // com.kwad.sdk.api.loader.n.c
                public final /* synthetic */ void c(Object obj) {
                    a.C0593a c0593a = (a.C0593a) obj;
                    try {
                        File file = c0593a.Sf;
                        boolean z = false;
                        if (!(file != null && file.exists() && file.length() > 0 && file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX))) {
                            a(c0593a, 1, new RuntimeException("Security checkFileValid fail"));
                            return;
                        }
                        String str = c0593a.c;
                        if (!TextUtils.isEmpty(str)) {
                            z = str.toLowerCase().equals(s.a(file).toLowerCase());
                        }
                        if (z) {
                            cVar.c(c0593a);
                        } else {
                            a(c0593a, 2, new RuntimeException("Security checkMd5 fail"));
                        }
                    } catch (Throwable th) {
                        a(c0593a, 3, th);
                    }
                }
            });
        }
    }

    /* loaded from: classes7.dex */
    public final class h implements f {
        public f Sy;
        public Context b;

        public h(f fVar, Context context) {
            this.Sy = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final c cVar) {
            this.Sy.a(new c() { // from class: com.kwad.sdk.api.loader.n.h.1
                @Override // com.kwad.sdk.api.loader.n.c
                public final /* synthetic */ void c(Object obj) {
                    a.C0593a c0593a = (a.C0593a) obj;
                    if (c0593a != null) {
                        String a = com.kwad.sdk.api.loader.g.a(h.this.b);
                        if (TextUtils.isEmpty(a)) {
                            a = Loader.get().getKsAdSDKImpl().getSDKVersion();
                        }
                        String str = c0593a.e;
                        StringBuilder sb = new StringBuilder("UpgradeProducer curVersion:");
                        sb.append(a);
                        sb.append("-newVersion");
                        sb.append(str);
                        t.a(h.this.b, "interval", c0593a.Se);
                        t.a(h.this.b, "lastUpdateTime", System.currentTimeMillis());
                        if (c0593a.a == -1) {
                            com.kwad.sdk.api.loader.g.a(h.this.b, "");
                            cVar.g(new RuntimeException("DynamicType == -1, curVersion: ".concat(String.valueOf(a))));
                            return;
                        }
                        if (com.kwad.sdk.api.loader.g.a(c0593a.e, a)) {
                            if (c0593a.a == 1) {
                                cVar.c(c0593a);
                                return;
                            }
                        }
                        c cVar2 = cVar;
                        cVar2.g(new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0593a.e + " currentDynamicVersion:" + a + " dynamicType:" + c0593a.a));
                    }
                }

                @Override // com.kwad.sdk.api.loader.n.c
                public final void g(Throwable th) {
                    cVar.g(th);
                }
            });
        }
    }
}
