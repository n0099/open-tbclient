package com.kwad.components.core.webview.b;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.offline.init.kwai.i;
import com.kwad.components.core.page.SimpleWebViewActivity;
import com.kwad.components.core.webview.b.a.f;
import com.kwad.components.core.webview.b.a.p;
import com.kwad.components.core.webview.b.a.q;
import com.kwad.components.core.webview.b.a.s;
import com.kwad.components.core.webview.b.b.d;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.b.kwai.l;
import com.kwad.components.core.webview.b.kwai.m;
import com.kwad.components.core.webview.b.kwai.n;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.download.g;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Future;
/* loaded from: classes8.dex */
public class d {
    public com.kwad.components.core.webview.b.b.d Ne;
    public e Nf;
    public com.kwad.components.core.offline.api.kwai.a Ng;
    public Future<?> Nh;
    public h Ni;
    public j Nj;
    public g Nk;
    public StyleTemplate Nl;
    public long Nm;
    public long Nr;
    public long Ns;
    public long Nt;
    public Activity mActivity;
    public AdTemplate mAdTemplate;
    public final Context mContext;
    public long tS;
    public boolean Nn = false;
    public boolean No = false;
    public boolean Np = false;
    public boolean Nq = false;
    public final Runnable Nu = new Runnable() { // from class: com.kwad.components.core.webview.b.d.10
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.b.d("TKLoadController", "已经超时");
            d.this.pM();
            d.a(d.this, true);
            d.this.pI();
        }
    };
    public final com.kwad.components.core.video.h td = new com.kwad.components.core.video.h() { // from class: com.kwad.components.core.webview.b.d.8
        private void d(double d) {
            d.this.tb.NZ = false;
            d.this.tb.Oa = false;
            d.this.tb.kD = (int) ((d / 1000.0d) + 0.5d);
            ic();
        }

        private void ic() {
            if (d.this.Nj == null || d.this.tb == null) {
                return;
            }
            d.this.Nj.a(d.this.tb);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            d.this.tb.Oa = true;
            d.this.tb.NZ = false;
            d.this.tb.kD = com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.bQ(d.this.mAdTemplate));
            ic();
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayError(int i, int i2) {
            d.this.tb.NZ = true;
            d.this.tb.Oa = false;
            ic();
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            d(j2);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
            d(0.0d);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPreparing() {
            d(0.0d);
        }
    };
    public final s tb = new s();

    /* renamed from: com.kwad.components.core.webview.b.d$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            d.this.Nm = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.e.b.d("TKLoadController", "开始读取模板 id: " + d.this.Nf.bZ());
            final StyleTemplate loadTkFileByTemplateId = d.this.Ng.loadTkFileByTemplateId(d.this.mContext, d.this.Nf.bZ());
            StringBuilder sb = new StringBuilder("读取完毕，总耗时");
            sb.append(SystemClock.elapsedRealtime() - d.this.Nm);
            sb.append(", 读取");
            if (loadTkFileByTemplateId == null) {
                str = "失败";
            } else {
                str = "成功" + loadTkFileByTemplateId.toJson() + AnonymousClass1.class.getSimpleName();
            }
            sb.append(str);
            com.kwad.sdk.core.e.b.d("TKLoadController", sb.toString());
            if (d.this.Nn) {
                return;
            }
            com.kwad.sdk.core.e.b.d("TKLoadController", "没有超时");
            bd.c(d.this.Nu);
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.b.d.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (loadTkFileByTemplateId != null) {
                        if (d.this.mActivity == null || d.this.mActivity.isFinishing()) {
                            return;
                        }
                        d.this.a(loadTkFileByTemplateId, new a() { // from class: com.kwad.components.core.webview.b.d.1.1.1
                            @Override // com.kwad.components.core.webview.b.d.a
                            public final void kU() {
                                d.this.pI();
                                com.kwad.sdk.core.e.b.d("TKLoadController", "渲染失败");
                            }

                            @Override // com.kwad.components.core.webview.b.d.a
                            public final void onSuccess() {
                                com.kwad.sdk.core.e.b.d("TKLoadController", "渲染成功");
                            }
                        });
                        return;
                    }
                    d.this.aG(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
                    com.kwad.sdk.core.e.b.d("TKLoadController", "没有模板信息" + Thread.currentThread().getName());
                    d.this.pI();
                }
            });
        }
    }

    /* loaded from: classes8.dex */
    public interface a {
        void kU();

        void onSuccess();
    }

    public d(long j, Context context) {
        this.tS = -1L;
        this.mContext = context;
        this.tS = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StyleTemplate styleTemplate, final a aVar) {
        this.Nl = styleTemplate;
        com.kwad.sdk.core.e.b.w("TKLoadController", "addTKView mTKPlugin.getState(): " + this.Ng.getState());
        if (this.Ng.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            aG(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.kU();
                return;
            }
            return;
        }
        FrameLayout ca = this.Nf.ca();
        FileInputStream fileInputStream = null;
        try {
            String jsBaseDir = this.Ng.getJsBaseDir(this.mContext, this.Nf.bZ());
            File file = new File(jsBaseDir, styleTemplate.tkFileName);
            if (!o.I(file)) {
                aG(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_FILE);
                if (aVar != null) {
                    aVar.kU();
                }
                return;
            }
            pK();
            this.Ns = SystemClock.elapsedRealtime();
            Context context = this.mContext;
            Context wrapContextIfNeed = new i(ITkOfflineCompo.PACKAGE_NAME).wrapContextIfNeed(context);
            com.kwad.sdk.core.e.b.d("TKLoadController", "context: " + context + " , resources: " + context.getResources() + "\nwrappedContext: " + wrapContextIfNeed + ", wrapped resources: " + wrapContextIfNeed.getResources());
            h view2 = this.Ng.getView(wrapContextIfNeed, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce);
            this.Nt = SystemClock.elapsedRealtime() - this.Ns;
            this.Nr = SystemClock.elapsedRealtime();
            a(view2, ca);
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                String inputStreamToString = IoUtils.inputStreamToString(fileInputStream2);
                if (inputStreamToString == null) {
                    aH(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
                    if (aVar != null) {
                        aVar.kU();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    return;
                }
                File file2 = new File(jsBaseDir);
                view2.a(inputStreamToString, file2.getAbsolutePath() + "/", new com.kwad.sdk.components.g() { // from class: com.kwad.components.core.webview.b.d.9
                    @Override // com.kwad.sdk.components.g
                    public final void onSuccess() {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.onSuccess();
                        }
                    }

                    @Override // com.kwad.sdk.components.g
                    public final void pN() {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.kU();
                        }
                    }
                });
                View view3 = view2.getView();
                view3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                ca.addView(view3);
                this.Ni = view2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    d(th);
                    if (aVar != null) {
                        aVar.kU();
                    }
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(h hVar, ViewGroup viewGroup) {
        com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        bVar.setAdTemplate(this.mAdTemplate);
        bVar.mScreenOrientation = !ag.cB(this.mContext) ? 1 : 0;
        bVar.agd = this.Nf.dD();
        bVar.Gl = viewGroup;
        bVar.Fv = null;
        this.Nf.a(hVar, bVar);
        l lVar = new l();
        lVar.a(new l.a() { // from class: com.kwad.components.core.webview.b.d.11
            @Override // com.kwad.components.core.webview.b.kwai.l.a
            public final void a(p pVar) {
                if (TextUtils.isEmpty(pVar.message)) {
                    return;
                }
                t.c(d.this.mContext, pVar.message, 0L);
            }
        });
        hVar.c(lVar);
        hVar.c(c(bVar));
        hVar.c(new com.kwad.sdk.core.webview.a.a());
        hVar.c(new com.kwad.components.core.webview.b.kwai.c());
        hVar.c(new com.kwad.components.core.webview.jshandler.i(bVar, cVar, this.Nf.getClickListener()));
        hVar.c(new com.kwad.components.core.webview.jshandler.l(bVar));
        hVar.c(new com.kwad.components.core.webview.jshandler.o(bVar));
        k kVar = new k(bVar);
        kVar.a(new k.b() { // from class: com.kwad.components.core.webview.b.d.12
            @Override // com.kwad.components.core.webview.jshandler.k.b
            public final void a(k.a aVar) {
                d.this.Nf.b(aVar);
            }
        });
        hVar.c(kVar);
        hVar.c(new r(bVar, new r.b() { // from class: com.kwad.components.core.webview.b.d.13
            @Override // com.kwad.components.core.webview.jshandler.r.b
            public final void a(r.a aVar) {
                d.this.b(aVar);
            }
        }));
        hVar.c(new x(new x.b() { // from class: com.kwad.components.core.webview.b.d.14
            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                if (aVar.status != 1) {
                    d.this.pI();
                    d.this.aH(aVar.errorMsg);
                    return;
                }
                d.this.pL();
                e eVar = d.this.Nf;
                if (eVar != null) {
                    eVar.dF();
                }
            }
        }));
        aa aaVar = new aa();
        hVar.c(aaVar);
        this.Nf.a(aaVar);
        hVar.c(new ac(bVar, cVar));
        j jVar = new j();
        this.Nj = jVar;
        hVar.c(jVar);
        this.Nf.a(this.Nj);
        if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
            final com.kwad.components.core.webview.b.kwai.g gVar = new com.kwad.components.core.webview.b.kwai.g();
            hVar.c(gVar);
            this.Nk = new g(this.mAdTemplate) { // from class: com.kwad.components.core.webview.b.d.15
                @Override // com.kwad.sdk.core.download.g, com.kwad.sdk.core.download.f
                public final void a(String str, int i, com.kwad.sdk.core.download.h hVar2) {
                    super.a(str, i, hVar2);
                    com.kwad.components.core.webview.b.a.b bVar2 = new com.kwad.components.core.webview.b.a.b();
                    bVar2.NK = 1;
                    gVar.a(bVar2);
                }
            };
            com.kwad.sdk.core.download.e.sV().a(this.Nk, this.mAdTemplate);
        }
        m mVar = new m();
        mVar.a(new m.a() { // from class: com.kwad.components.core.webview.b.d.16
            @Override // com.kwad.components.core.webview.b.kwai.m.a
            public final void b(q qVar) {
                d.this.Nf.a(qVar);
            }
        });
        hVar.c(mVar);
        n nVar = new n();
        nVar.a(new n.a() { // from class: com.kwad.components.core.webview.b.d.2
            @Override // com.kwad.components.core.webview.b.kwai.n.a
            public final void a(com.kwad.components.core.webview.b.a.i iVar) {
                d.this.Nf.b(iVar);
            }
        });
        hVar.c(nVar);
        com.kwad.components.core.webview.b.kwai.i iVar = new com.kwad.components.core.webview.b.kwai.i();
        hVar.c(iVar);
        this.Nf.a(iVar);
        hVar.c(new com.kwad.components.core.webview.b.kwai.k() { // from class: com.kwad.components.core.webview.b.d.3
            @Override // com.kwad.components.core.webview.b.kwai.k
            public final void a(com.kwad.components.core.webview.b.a.o oVar) {
                super.a(oVar);
                if (d.this.mActivity.isFinishing()) {
                    return;
                }
                if (d.this.Ne != null) {
                    d.this.Ne.dismiss();
                }
                d.b bVar2 = new d.b();
                bVar2.setAdTemplate(d.this.mAdTemplate);
                bVar2.aI(oVar.templateId);
                d.this.Ne = com.kwad.components.core.webview.b.b.d.b(bVar2);
                d.this.Ne.show(d.this.mActivity.getFragmentManager(), "");
            }
        });
        hVar.c(new com.kwad.components.core.webview.b.kwai.a() { // from class: com.kwad.components.core.webview.b.d.4
            @Override // com.kwad.components.core.webview.b.kwai.a
            public final void ie() {
                super.ie();
                if (d.this.Ne != null) {
                    d.this.Ne.dismiss();
                }
                e eVar = d.this.Nf;
                if (eVar != null) {
                    eVar.dI();
                }
            }
        });
        hVar.c(new com.kwad.components.core.webview.jshandler.g(new com.kwad.sdk.core.webview.a.kwai.b() { // from class: com.kwad.components.core.webview.b.d.5
            @Override // com.kwad.sdk.core.webview.a.kwai.b
            public final void onClose() {
                d.this.Nf.dE();
            }
        }));
        hVar.c(new com.kwad.components.core.webview.b.kwai.b() { // from class: com.kwad.components.core.webview.b.d.6
            @Override // com.kwad.components.core.webview.b.kwai.b
            public final void a(f fVar) {
                super.a(fVar);
                com.kwad.components.core.j.a.og().a(fVar.Mm, d.this.mAdTemplate, fVar.Mn);
            }
        });
        hVar.c(new com.kwad.components.core.webview.b.kwai.f() { // from class: com.kwad.components.core.webview.b.d.7
            @Override // com.kwad.components.core.webview.b.kwai.f
            public final void a(com.kwad.components.core.webview.b.a.j jVar2) {
                super.a(jVar2);
                SimpleWebViewActivity.launch(d.this.mContext, jVar2.url, jVar2.title);
            }
        });
        a(bVar, cVar, hVar, viewGroup);
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.Nn = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str) {
        StyleTemplate findStyleTemplateFromConfigById = this.Ng.findStyleTemplateFromConfigById(this.Nf.bZ());
        if (findStyleTemplateFromConfigById == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(0).setRenderState(4).setErrorReason(str).setTemplateId(this.Nf.bZ()).setVersionCode(String.valueOf(findStyleTemplateFromConfigById.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str) {
        if (!this.No || this.Np) {
            return;
        }
        this.Np = true;
        com.kwad.sdk.core.e.b.d("tkRender", "logTkRenderFail : " + str);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.Nl.tkSouce).setRenderState(2).setErrorReason(str).setTemplateId(this.Nf.bZ()).setVersionCode(String.valueOf(this.Nl.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r.a aVar) {
        FrameLayout ca = this.Nf.ca();
        if (ca != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ca.getLayoutParams();
            layoutParams.height = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.height);
            layoutParams.leftMargin = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.leftMargin);
            layoutParams.rightMargin = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.rightMargin);
            layoutParams.bottomMargin = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.bottomMargin);
            layoutParams.width = -1;
            ca.setLayoutParams(layoutParams);
        }
    }

    private void d(Throwable th) {
        com.kwad.components.core.b.a.b(th);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.Nl.tkSouce).setRenderState(3).setErrorReason(th.getMessage()).setTemplateId(this.Nf.bZ()).setVersionCode(String.valueOf(this.Nl.templateVersionCode)).toJson());
    }

    private void pG() {
        this.No = false;
        this.Np = false;
        this.Nn = false;
        this.Nq = false;
        this.Nm = 0L;
        this.Ns = 0L;
        this.Nt = 0L;
        this.Nr = 0L;
    }

    private void pH() {
        bd.runOnUiThreadDelay(this.Nu, 1000L);
        this.Nh = com.kwad.sdk.core.threads.b.vn().submit(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pI() {
        if (this.Nq) {
            return;
        }
        this.Nq = true;
        this.Nf.cb();
    }

    private void pJ() {
        com.kwad.components.core.offline.api.kwai.a aVar = this.Ng;
        StyleTemplate findStyleTemplateFromConfigById = aVar == null ? null : aVar.findStyleTemplateFromConfigById(this.Nf.bZ());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(findStyleTemplateFromConfigById == null ? 0 : findStyleTemplateFromConfigById.tkSouce).setRenderState(-1).setTemplateId(this.Nf.bZ()).setVersionCode(findStyleTemplateFromConfigById == null ? "" : String.valueOf(findStyleTemplateFromConfigById.templateVersionCode)).toJson());
    }

    private void pK() {
        this.No = true;
        com.kwad.sdk.core.e.b.d("tkrender", "logTkRenderStart");
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.Nl.tkSouce).setRenderState(0).setTemplateId(this.Nf.bZ()).setVersionCode(String.valueOf(this.Nl.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pL() {
        if (!this.No || this.Np) {
            return;
        }
        this.Np = true;
        com.kwad.sdk.core.e.b.d("tkRender", "logTkRenderSuccess");
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.Nl.tkSouce).setRenderState(1).setRenderTime(this.Nr > 0 ? SystemClock.elapsedRealtime() - this.Nr : 0L).setTemplateId(this.Nf.bZ()).setLoadTime(this.Ns - this.Nm).setInitTime(this.Nt).setVersionCode(String.valueOf(this.Nl.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM() {
        StyleTemplate findStyleTemplateFromConfigById = this.Ng.findStyleTemplateFromConfigById(this.Nf.bZ());
        if (findStyleTemplateFromConfigById == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(findStyleTemplateFromConfigById.tkSouce).setRenderState(3).setErrorReason("timeout").setTemplateId(this.Nf.bZ()).setVersionCode(String.valueOf(findStyleTemplateFromConfigById.templateVersionCode)).toJson());
    }

    public final void a(Activity activity, AdTemplate adTemplate, e eVar) {
        this.mActivity = activity;
        this.mAdTemplate = adTemplate;
        this.Nf = eVar;
        pG();
        FrameLayout ca = this.Nf.ca();
        if (ca != null) {
            ca.removeAllViews();
        }
        if (!com.kwad.sdk.core.config.d.isCanUseTk()) {
            pI();
            return;
        }
        this.Ng = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        pJ();
        com.kwad.sdk.core.e.b.d("TKLoadController", "bind mTKPlugin: " + this.Ng);
        if (this.Ng != null) {
            pH();
            return;
        }
        pI();
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(0).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.Nf.bZ()).toJson());
    }

    public void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.c.a.c cVar, h hVar, ViewGroup viewGroup) {
    }

    public com.kwad.components.core.webview.jshandler.s c(com.kwad.sdk.core.webview.b bVar) {
        return new com.kwad.components.core.webview.jshandler.s(bVar);
    }

    public final void pF() {
        Future<?> future = this.Nh;
        if (future != null) {
            future.cancel(true);
        }
        bd.c(this.Nu);
        if (this.Nk != null) {
            com.kwad.sdk.core.download.e.sV().a(this.Nk);
        }
        h hVar = this.Ni;
        if (hVar != null) {
            hVar.onDestroy();
        }
        com.kwad.components.core.webview.b.b.d dVar = this.Ne;
        if (dVar != null) {
            dVar.dismiss();
        }
    }
}
