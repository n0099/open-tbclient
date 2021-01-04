package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.r.a.a;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseSplashAd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes3.dex */
class d extends com.qq.e.comm.plugin.r.a.a<BaseSplashAd> implements NSPVI {
    private ViewGroup d;
    private View e;
    private int f;
    private LoadAdParams g;
    private ADListener h;
    private BaseSplashAd i;
    private Map<BaseSplashAd, a> j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        a.InterfaceC1177a f12807a;

        /* renamed from: b  reason: collision with root package name */
        boolean f12808b;
        boolean c;
        boolean d = false;
        Queue<ADEvent> e = new LinkedList();

        public a(a.InterfaceC1177a interfaceC1177a) {
            this.f12807a = interfaceC1177a;
        }

        void a() {
            this.d = true;
        }

        public Queue<ADEvent> b() {
            return this.e;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            GDTLogger.d("SplashAdViewMediator type--" + aDEvent.getType());
            switch (aDEvent.getType()) {
                case 2:
                    this.e.offer(aDEvent);
                    if (this.f12807a != null && !this.c) {
                        this.c = true;
                        this.f12807a.a();
                    }
                    if (this.f12807a == null || !this.f12808b) {
                        return;
                    }
                    this.f12807a.b(aDEvent);
                    return;
                case 4:
                    if (this.f12807a != null) {
                        this.f12807a.b();
                        break;
                    }
                    break;
                case 6:
                    if (this.f12807a != null) {
                        this.f12807a.b(aDEvent);
                        this.f12807a.c();
                        return;
                    }
                    return;
                case 7:
                    this.f12808b = true;
                    if (this.f12807a != null) {
                        if (this.f12807a.a(aDEvent)) {
                            this.d = true;
                        }
                        if (this.d) {
                            this.f12807a.b(aDEvent);
                        }
                    }
                    this.e.offer(aDEvent);
                    return;
            }
            if (!this.f12808b || this.f12807a == null) {
                return;
            }
            this.f12807a.b(aDEvent);
        }
    }

    public d(Context context, String str, String str2) {
        super(context, str2);
        this.f = -1;
        this.j = new HashMap();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int b(final BaseSplashAd baseSplashAd) {
        final long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(new a.InterfaceC1177a() { // from class: com.qq.e.comm.plugin.splash.d.1
            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1177a
            public void a() {
                if (d.this.j()) {
                    return;
                }
                d.this.a((d) baseSplashAd, System.currentTimeMillis() - currentTimeMillis, false, 70122);
                if (d.this.i() && d.this.c((d) baseSplashAd) && !d.this.b()) {
                    d.this.a();
                }
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1177a
            public boolean a(ADEvent aDEvent) {
                int i;
                boolean z;
                if (d.this.j()) {
                    return false;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                int ecpm = SDKStatus.getSDKVersionCode() >= 100 ? baseSplashAd.getECPM() : -1;
                if (baseSplashAd instanceof com.qq.e.comm.plugin.r.a) {
                    i = ecpm <= 0 ? ((com.qq.e.comm.plugin.r.a) baseSplashAd).getMediationPrice() : ecpm;
                    z = ((com.qq.e.comm.plugin.r.a) baseSplashAd).isContractAd();
                } else {
                    i = ecpm;
                    z = false;
                }
                d.this.a((d) baseSplashAd, i, z, baseSplashAd.getAdapterPriority());
                d.this.a((d) baseSplashAd, currentTimeMillis2 - currentTimeMillis, true, 70112);
                if (d.this.i() && d.this.d((d) baseSplashAd) && !d.this.j()) {
                    d.this.h();
                    d.this.i = baseSplashAd;
                    return true;
                }
                return false;
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1177a
            public void b() {
                d.this.a((d) baseSplashAd, 70142);
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1177a
            public void b(ADEvent aDEvent) {
                if (d.this.h == null || !d.this.d((d) baseSplashAd)) {
                    return;
                }
                d.this.h.onADEvent(aDEvent);
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1177a
            public void c() {
                d.this.b((d) baseSplashAd, 70132);
            }
        });
        baseSplashAd.setAdListener(aVar);
        this.j.put(baseSplashAd, aVar);
        if (this.f > 0) {
            baseSplashAd.setFetchDelay(this.f);
        }
        if (this.e != null) {
            baseSplashAd.setSkipView(this.e);
        }
        if (this.g != null) {
            baseSplashAd.setLoadAdParams(this.g);
        }
        if (this.d == null) {
            baseSplashAd.fetchAdOnly();
        } else {
            baseSplashAd.fetchAndShowIn(this.d);
        }
        GDTLogger.d(baseSplashAd.getClass().getSimpleName() + " load Ad");
        return 70102;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: a */
    public BaseSplashAd b(com.qq.e.comm.plugin.r.b.c cVar) {
        if (cVar != null) {
            try {
                return com.qq.e.comm.plugin.splash.a.a(cVar.e(), this.f12658a, cVar.b(), cVar.g());
            } catch (Exception e) {
                a(70152, cVar);
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.r.a.a
    protected void a() {
        if (this.h != null) {
            this.c.post(new Runnable() { // from class: com.qq.e.comm.plugin.splash.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.h.onADEvent(new ADEvent(2, new Object[]{501}));
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void a(BaseSplashAd baseSplashAd) {
        a aVar;
        this.i = baseSplashAd;
        if (this.i == null) {
            a();
        } else if (this.h != null && (aVar = this.j.get(this.i)) != null) {
            aVar.a();
            for (ADEvent aDEvent : aVar.b()) {
                this.h.onADEvent(aDEvent);
            }
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAdOnly() {
        c();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        if (i()) {
            this.d = viewGroup;
            c();
            return;
        }
        GDTLogger.e("SplashAdViewMediator fetchAndShowIn 不支持并行拉取");
        a();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getAdNetWorkName() {
        return k();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getECPMLevel() {
        return this.i != null ? this.i.getECPMLevel() : "";
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void preload() {
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdListener(ADListener aDListener) {
        this.h = aDListener;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdLogoMargin(int i, int i2) {
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFetchDelay(int i) {
        this.f = i;
        a(i);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFloatView(View view) {
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.g = loadAdParams;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSkipView(View view) {
        this.e = view;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showAd(ViewGroup viewGroup) {
        this.d = viewGroup;
        if (this.i != null) {
            this.i.showAd(viewGroup);
        } else {
            a();
        }
    }
}
