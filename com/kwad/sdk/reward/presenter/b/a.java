package com.kwad.sdk.reward.presenter.b;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.report.CommercialAction;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.core.webview.a.d;
import com.kwad.sdk.core.webview.a.h;
import com.kwad.sdk.core.webview.a.j;
import com.kwad.sdk.core.webview.a.k;
import com.kwad.sdk.core.webview.a.kwai.f;
import com.kwad.sdk.core.webview.a.l;
import com.kwad.sdk.core.webview.a.m;
import com.kwad.sdk.core.webview.a.n;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.plugin.h;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes3.dex */
public abstract class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f59661b;

    /* renamed from: c  reason: collision with root package name */
    public long f59662c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59663d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59664e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f59665f;

    /* renamed from: g  reason: collision with root package name */
    public k f59666g;

    /* renamed from: h  reason: collision with root package name */
    public h f59667h;

    /* renamed from: i  reason: collision with root package name */
    public f f59668i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.plugin.g f59669j;

    /* renamed from: k  reason: collision with root package name */
    public j f59670k;
    public long l;
    public final com.kwad.sdk.reward.a.f m = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.b.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (a.this.f59663d) {
                com.kwad.sdk.reward.k.a(((g) a.this).a);
            }
        }
    };
    public j.a n = new j.a() { // from class: com.kwad.sdk.reward.presenter.b.a.11
        @Override // com.kwad.sdk.utils.j.a
        public void a() {
            if (a.this.f59670k != null) {
                com.kwad.sdk.core.webview.a.kwai.b bVar = new com.kwad.sdk.core.webview.a.kwai.b();
                bVar.a = true;
                a.this.f59670k.a(bVar);
            }
        }

        @Override // com.kwad.sdk.utils.j.a
        public void b() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        com.kwad.sdk.core.report.a.a(aVar.f59455g, 40, aVar.f59458j.getTouchCoords(), ((g) this).a.f59453e);
        ((g) this).a.f59450b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        com.kwad.sdk.core.report.a.a(aVar.f59455g, 41, aVar.f59458j.getTouchCoords(), ((g) this).a.f59453e);
        ((g) this).a.f59450b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        ((g) this).a.f59450b.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        ((g) this).a.f59450b.e();
    }

    private void E() {
        this.l = SystemClock.elapsedRealtime();
        i.a("ad_client_apm_log", new CommercialAction.TKPerformMsg().setRenderState(0).setTemplateId(e()).setVersionCode(this.f59669j.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        i.a("ad_client_apm_log", new CommercialAction.TKPerformMsg().setRenderState(1).setRenderTime(this.l > 0 ? SystemClock.elapsedRealtime() - this.l : 0L).setTemplateId(e()).setVersionCode(this.f59669j.d()));
    }

    private void a(h hVar, ViewGroup viewGroup) {
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((g) this).a.f59455g);
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f59665f = aVar;
        aVar.a(((g) this).a.f59455g);
        this.f59665f.a = !af.e(q()) ? 1 : 0;
        com.kwad.sdk.core.webview.a aVar2 = this.f59665f;
        aVar2.f58536b = ((g) this).a.f59458j;
        aVar2.f58538d = viewGroup;
        aVar2.f58539e = null;
        hVar.a(new l());
        hVar.a(new com.kwad.sdk.core.webview.jshandler.e());
        hVar.a(new com.kwad.sdk.core.webview.a.g());
        hVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f59665f, bVar, w()));
        hVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f59665f, bVar, w()));
        hVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f59665f));
        hVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f59665f));
        com.kwad.sdk.core.webview.jshandler.d dVar = new com.kwad.sdk.core.webview.jshandler.d(this.f59665f);
        dVar.a(new d.b() { // from class: com.kwad.sdk.reward.presenter.b.a.12
            @Override // com.kwad.sdk.core.webview.jshandler.d.b
            public void a(d.a aVar3) {
                a.this.a(aVar3);
            }
        });
        hVar.a(dVar);
        hVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.f59665f, new j.b() { // from class: com.kwad.sdk.reward.presenter.b.a.13
            @Override // com.kwad.sdk.core.webview.jshandler.j.b
            public void a(j.a aVar3) {
                a.this.a(aVar3);
            }
        }));
        hVar.a(new p(new p.b() { // from class: com.kwad.sdk.reward.presenter.b.a.14
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar3) {
                if (aVar3.a == 1) {
                    a.this.F();
                } else {
                    a.this.a(aVar3.f58637b);
                }
            }
        }));
        hVar.a(new s());
        hVar.a(new t(this.f59665f, bVar));
        hVar.a(new com.kwad.sdk.core.webview.jshandler.i(new i.b() { // from class: com.kwad.sdk.reward.presenter.b.a.15
            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(int i2) {
                ((g) a.this).a.f59458j.findViewById(a.this.i()).setVisibility(8);
            }
        }));
        hVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.f59665f));
        hVar.a(new com.kwad.sdk.core.webview.a.f());
        k kVar = new k();
        this.f59666g = kVar;
        hVar.a(kVar);
        com.kwad.sdk.contentalliance.detail.video.e eVar = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.b.a.16
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a() {
                a.this.a(0.0d);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i2, int i3) {
                a.this.t();
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                a.this.f59662c = j3;
                a.this.f59663d = j2 - j3 < 800;
                a.this.a(j3);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                a.this.a(0.0d);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                if (((g) a.this).a.u) {
                    a.this.t();
                } else {
                    a.this.s();
                }
            }
        };
        this.f59664e = eVar;
        ((g) this).a.f59459k.a(eVar);
        m mVar = new m();
        mVar.a(new m.a() { // from class: com.kwad.sdk.reward.presenter.b.a.17
            @Override // com.kwad.sdk.core.webview.a.m.a
            public void a(com.kwad.sdk.core.webview.a.kwai.e eVar2) {
                com.kwad.sdk.core.report.a.a(((g) a.this).a.f59455g, 69, (int) (com.kwad.sdk.core.response.a.a.o(a.this.f59661b) / 1000), (int) (a.this.f59662c / 1000));
                boolean z = !((g) a.this).a.r || (!((g) a.this).a.v && com.kwad.sdk.core.config.b.R());
                if (eVar2.a && z) {
                    com.kwad.sdk.reward.widget.a.a(((g) a.this).a);
                    return;
                }
                com.kwad.sdk.core.report.a.a(((g) a.this).a.f59455g, (int) (com.kwad.sdk.core.response.a.a.o(a.this.f59661b) / 1000), (int) (a.this.f59662c / 1000));
                ((g) a.this).a.u = true;
                ((g) a.this).a.f59459k.a(true);
                com.kwad.sdk.reward.k.a(((g) a.this).a);
            }
        });
        hVar.a(mVar);
        n nVar = new n();
        nVar.a(new n.a() { // from class: com.kwad.sdk.reward.presenter.b.a.18
            @Override // com.kwad.sdk.core.webview.a.n.a
            public void a(com.kwad.sdk.core.webview.a.kwai.b bVar2) {
                ((g) a.this).a.f59459k.a(!bVar2.a, true);
            }
        });
        hVar.a(nVar);
        com.kwad.sdk.core.webview.a.j jVar = new com.kwad.sdk.core.webview.a.j();
        this.f59670k = jVar;
        hVar.a(jVar);
        ((g) this).a.f59459k.a(this.n);
        ax.a(com.kwad.sdk.utils.b.a(q()).a() ? new Runnable() { // from class: com.kwad.sdk.reward.presenter.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.webview.a.kwai.b bVar2 = new com.kwad.sdk.core.webview.a.kwai.b();
                bVar2.a = true;
                a.this.f59670k.a(bVar2);
            }
        } : new Runnable() { // from class: com.kwad.sdk.reward.presenter.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.webview.a.kwai.b bVar2 = new com.kwad.sdk.core.webview.a.kwai.b();
                bVar2.a = !((g) a.this).a.f59452d.isVideoSoundEnable();
                a.this.f59670k.a(bVar2);
            }
        }, 0L);
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c();
        cVar.a(new c.a() { // from class: com.kwad.sdk.reward.presenter.b.a.4
            @Override // com.kwad.sdk.core.webview.a.c.a
            public void a(final com.kwad.sdk.core.webview.a.kwai.c cVar2) {
                com.kwad.sdk.core.download.a.a.a(new a.C2083a(a.this.q()).a(((g) a.this).a.f59455g).a(((g) a.this).a.l).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.b.a.4.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        if (cVar2.a) {
                            a.this.z();
                        } else {
                            a.this.A();
                        }
                    }
                }));
            }
        });
        hVar.a(cVar);
        com.kwad.sdk.core.webview.a.d dVar2 = new com.kwad.sdk.core.webview.a.d();
        dVar2.a(new d.a() { // from class: com.kwad.sdk.reward.presenter.b.a.5
            @Override // com.kwad.sdk.core.webview.a.d.a
            public void a() {
                com.kwad.sdk.core.download.a.a.a(new a.C2083a(a.this.q()).a(((g) a.this).a.f59455g).a(((g) a.this).a.l).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.b.a.5.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        a.this.B();
                    }
                }));
            }
        });
        hVar.a(dVar2);
        com.kwad.sdk.core.webview.a.h hVar2 = new com.kwad.sdk.core.webview.a.h();
        hVar2.a(new h.a() { // from class: com.kwad.sdk.reward.presenter.b.a.6
            @Override // com.kwad.sdk.core.webview.a.h.a
            public void a() {
                ((g) a.this).a.f59450b.e();
            }
        });
        hVar.a(hVar2);
        hVar.a(new com.kwad.sdk.core.webview.a.b() { // from class: com.kwad.sdk.reward.presenter.b.a.7
            @Override // com.kwad.sdk.core.webview.a.b
            public void c() {
                super.c();
                a.this.y();
            }
        });
        hVar.a(new com.kwad.sdk.core.webview.a.e() { // from class: com.kwad.sdk.reward.presenter.b.a.8
            @Override // com.kwad.sdk.core.webview.a.e
            public void c() {
                super.c();
                a.this.D();
                a.this.C();
                a.this.h();
            }
        });
        hVar.a(new com.kwad.sdk.core.webview.a.a() { // from class: com.kwad.sdk.reward.presenter.b.a.9
            @Override // com.kwad.sdk.core.webview.a.a
            public void c() {
                super.c();
                a.this.x();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.kwad.sdk.core.report.i.a("ad_client_error_log", new CommercialAction.TKPerformMsg().setRenderState(2).setErrorReason(str).setTemplateId(e()).setVersionCode(this.f59669j.d()));
    }

    private void a(Throwable th) {
        com.kwad.sdk.core.kwai.a.a(th);
        com.kwad.sdk.core.d.a.a(th);
        com.kwad.sdk.core.report.i.a("ad_client_error_log", new CommercialAction.TKPerformMsg().setRenderState(3).setErrorReason(th.getMessage()).setTemplateId(e()).setVersionCode(this.f59669j.d()));
    }

    private boolean v() {
        if (o() == null) {
            return false;
        }
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.f59458j.findViewById(i());
        com.kwad.sdk.plugin.g gVar = (com.kwad.sdk.plugin.g) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.g.class);
        this.f59669j = gVar;
        if (gVar == null) {
            return true;
        }
        FileInputStream fileInputStream = null;
        try {
            E();
            String a = this.f59669j.a(q());
            File file = new File(a, e());
            com.kwad.sdk.plugin.h a2 = this.f59669j.a(q(), e());
            a(a2, frameLayout);
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                String inputStreamToString = IoUtils.inputStreamToString(fileInputStream2);
                if (inputStreamToString != null) {
                    File file2 = new File(a);
                    a2.a(inputStreamToString, file2.getAbsolutePath() + "/");
                    View view = a2.getView();
                    view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    frameLayout.addView(view);
                    this.f59667h = a2;
                }
                q.a(fileInputStream2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    this.f59669j.c();
                    a(th);
                    return false;
                } finally {
                    q.a(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @NonNull
    private b.c w() {
        return new b.c() { // from class: com.kwad.sdk.reward.presenter.b.a.10
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(@Nullable b.a aVar) {
                ((g) a.this).a.f59450b.a();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        com.kwad.sdk.core.report.a.c(aVar.f59455g, 17, aVar.f59453e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        com.kwad.sdk.core.report.a.c(aVar.f59455g, 18, aVar.f59453e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        com.kwad.sdk.core.report.a.a(aVar.f59455g, 39, aVar.f59458j.getTouchCoords(), ((g) this).a.f59453e);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.l = 0L;
        this.f59661b = com.kwad.sdk.core.response.a.d.j(((g) this).a.f59455g);
        ((g) this).a.a(this.m);
        this.f59668i = new f();
        if (v()) {
            return;
        }
        r();
    }

    public void a(double d2) {
        f fVar = this.f59668i;
        fVar.f58548b = false;
        fVar.f58549c = false;
        fVar.a = (int) Math.ceil(d2 / 1000.0d);
        u();
    }

    public abstract void a(d.a aVar);

    public void a(j.a aVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.contentalliance.detail.video.d dVar = this.f59664e;
        if (dVar != null) {
            ((g) this).a.f59459k.b(dVar);
        }
        ((g) this).a.b(this.m);
        j.a aVar = this.n;
        if (aVar != null) {
            ((g) this).a.f59459k.b(aVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        com.kwad.sdk.plugin.h hVar = this.f59667h;
        if (hVar != null) {
            hVar.a();
        }
    }

    public abstract String e();

    @IdRes
    public abstract int i();

    public abstract void r();

    public void s() {
        f fVar = this.f59668i;
        fVar.f58549c = true;
        fVar.f58548b = false;
        fVar.a = com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(this.f59665f.a()));
        u();
    }

    public void t() {
        f fVar = this.f59668i;
        fVar.f58548b = true;
        fVar.f58549c = false;
        u();
    }

    public void u() {
        f fVar;
        k kVar = this.f59666g;
        if (kVar == null || (fVar = this.f59668i) == null) {
            return;
        }
        kVar.a(fVar);
    }
}
