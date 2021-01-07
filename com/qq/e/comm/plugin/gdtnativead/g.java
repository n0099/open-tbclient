package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.r.a.a;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes4.dex */
class g extends com.qq.e.comm.plugin.r.a.a<BaseNativeExpressAd> implements NEADI {
    private ADListener d;
    private int e;
    private LoadAdParams f;
    private VideoOption g;
    private int h;
    private int i;
    private int j;
    private ADSize k;
    private Map<BaseNativeExpressAd, a> l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private a.InterfaceC1218a f12325a;

        /* renamed from: b  reason: collision with root package name */
        private Queue<ADEvent> f12326b = new LinkedList();
        private boolean c;
        private boolean d;

        public a(a.InterfaceC1218a interfaceC1218a, boolean z) {
            this.f12325a = interfaceC1218a;
            this.c = z;
        }

        private void a(ADEvent aDEvent) {
            if (this.d) {
                this.f12325a.b(aDEvent);
            } else {
                this.f12326b.offer(aDEvent);
            }
        }

        public Queue<ADEvent> a() {
            return this.f12326b;
        }

        public void b() {
            this.d = true;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.f12325a != null) {
                switch (aDEvent.getType()) {
                    case 1:
                        this.f12325a.a();
                        return;
                    case 2:
                        if (!this.c) {
                            this.f12326b.offer(aDEvent);
                            this.f12325a.a(aDEvent);
                            return;
                        }
                        this.d = this.f12325a.a(aDEvent);
                        if (this.d) {
                            this.f12325a.b(aDEvent);
                            return;
                        }
                        return;
                    case 3:
                    case 4:
                    default:
                        a(aDEvent);
                        return;
                    case 5:
                        this.f12325a.c();
                        a(aDEvent);
                        return;
                    case 6:
                        this.f12325a.b();
                        a(aDEvent);
                        return;
                }
            }
        }
    }

    public g(Context context, ADSize aDSize, String str, String str2, ADListener aDListener) {
        super(context, str2);
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.l = new HashMap();
        this.d = aDListener;
        this.k = aDSize;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int b(final BaseNativeExpressAd baseNativeExpressAd) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.i >= 0) {
            baseNativeExpressAd.setMaxVideoDuration(this.i);
        }
        if (this.h >= 0) {
            baseNativeExpressAd.setMinVideoDuration(this.h);
        }
        if (this.j >= 0) {
            baseNativeExpressAd.setVideoPlayPolicy(this.j);
        }
        if (this.g != null) {
            baseNativeExpressAd.setVideoOption(this.g);
        }
        a aVar = new a(new a.InterfaceC1218a() { // from class: com.qq.e.comm.plugin.gdtnativead.g.1
            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1218a
            public void a() {
                if (g.this.j()) {
                    return;
                }
                g.this.a((g) baseNativeExpressAd, System.currentTimeMillis() - currentTimeMillis, false, 70522);
                if (g.this.i() && g.this.c((g) baseNativeExpressAd) && !g.this.b()) {
                    g.this.a();
                }
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1218a
            public boolean a(ADEvent aDEvent) {
                int i;
                boolean z;
                if (g.this.j()) {
                    return false;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                int ecpm = baseNativeExpressAd.getECPM();
                if (baseNativeExpressAd instanceof com.qq.e.comm.plugin.r.a) {
                    i = ecpm <= 0 ? ((com.qq.e.comm.plugin.r.a) baseNativeExpressAd).getMediationPrice() : ecpm;
                    z = ((com.qq.e.comm.plugin.r.a) baseNativeExpressAd).isContractAd();
                } else {
                    i = ecpm;
                    z = false;
                }
                g.this.a((g) baseNativeExpressAd, i, z, baseNativeExpressAd.getAdapterPriority());
                g.this.a((g) baseNativeExpressAd, currentTimeMillis2 - currentTimeMillis, true, 70512);
                if (g.this.i() && g.this.d((g) baseNativeExpressAd)) {
                    g.this.h();
                    return true;
                }
                return false;
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1218a
            public void b() {
                g.this.a((g) baseNativeExpressAd, 70542);
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1218a
            public void b(ADEvent aDEvent) {
                if (g.this.d == null || !g.this.d((g) baseNativeExpressAd)) {
                    return;
                }
                g.this.d.onADEvent(aDEvent);
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1218a
            public void c() {
                g.this.b((g) baseNativeExpressAd, 70532);
            }
        }, i());
        baseNativeExpressAd.setAdListener(aVar);
        this.l.put(baseNativeExpressAd, aVar);
        if (this.f == null) {
            baseNativeExpressAd.loadAD(this.e);
            return 70502;
        }
        baseNativeExpressAd.loadAD(this.e, this.f);
        return 70502;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: a */
    public BaseNativeExpressAd b(com.qq.e.comm.plugin.r.b.c cVar) {
        if (cVar != null) {
            try {
                return com.qq.e.comm.plugin.gdtnativead.a.a(cVar.e(), this.k, this.f12660b, cVar.b(), cVar.g());
            } catch (Exception e) {
                a(70552, cVar);
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.r.a.a
    protected void a() {
        if (this.d != null) {
            this.d.onADEvent(new ADEvent(1, new Object[]{501}));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void a(BaseNativeExpressAd baseNativeExpressAd) {
        if (baseNativeExpressAd == null) {
            a();
            return;
        }
        a aVar = this.l.get(baseNativeExpressAd);
        if (aVar == null || this.d == null) {
            return;
        }
        aVar.b();
        Queue<ADEvent> a2 = aVar.a();
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        for (ADEvent aDEvent : a2) {
            this.d.onADEvent(aDEvent);
        }
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        this.e = i;
        this.f = null;
        c();
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i, LoadAdParams loadAdParams) {
        this.e = i;
        this.f = loadAdParams;
        c();
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setBrowserType(int i) {
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMaxVideoDuration(int i) {
        this.i = i;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMinVideoDuration(int i) {
        this.h = i;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoOption(VideoOption videoOption) {
        this.g = videoOption;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoPlayPolicy(int i) {
        this.j = i;
    }
}
