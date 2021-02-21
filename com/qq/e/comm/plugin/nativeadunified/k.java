package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.r.a.a;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class k extends com.qq.e.comm.plugin.r.a.a<BaseNativeUnifiedAd> implements NUADI {
    private ADListener d;
    private int e;
    private Map<BaseNativeUnifiedAd, b> f;
    private List<String> g;
    private int h;
    private int i;
    private int j;
    private int k;
    private DownAPPConfirmPolicy l;
    private int m;
    private String n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class a implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private ADListener f12320a;

        /* renamed from: b  reason: collision with root package name */
        private a.InterfaceC1207a f12321b;

        public a(a.InterfaceC1207a interfaceC1207a) {
            this.f12321b = interfaceC1207a;
        }

        public void a(ADListener aDListener) {
            this.f12320a = aDListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            this.f12320a.onADEvent(aDEvent);
            if (aDEvent.getType() == 2) {
                this.f12321b.b();
            } else if (aDEvent.getType() == 1) {
                this.f12321b.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class b implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private a.InterfaceC1207a f12322a;

        /* renamed from: b  reason: collision with root package name */
        private Queue<ADEvent> f12323b = new LinkedList();
        private boolean c;

        public b(a.InterfaceC1207a interfaceC1207a, boolean z) {
            this.f12322a = interfaceC1207a;
            this.c = z;
        }

        public Queue<ADEvent> a() {
            return this.f12323b;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (aDEvent.getType() == 2) {
                this.f12322a.a();
            } else if (aDEvent.getType() == 1) {
                if (this.c) {
                    this.f12322a.a(aDEvent);
                    this.f12322a.b(aDEvent);
                    return;
                }
                this.f12323b.offer(aDEvent);
                this.f12322a.a(aDEvent);
            } else if (SDKStatus.getSDKVersionCode() >= 70) {
                if (aDEvent.getType() == 3) {
                    this.f12322a.b();
                } else if (aDEvent.getType() == 4) {
                    this.f12322a.c();
                }
            }
        }
    }

    public k(Context context, String str, String str2, ADListener aDListener) {
        super(context, str2);
        this.f = new HashMap();
        this.i = -1;
        this.j = 0;
        this.k = 0;
        this.d = aDListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<NativeUnifiedADData> a(ADEvent aDEvent) {
        return (aDEvent == null || aDEvent.getType() != 1 || aDEvent.getParas() == null || aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof List) || ((List) aDEvent.getParas()[0]).size() < 1 || !(((List) aDEvent.getParas()[0]).get(0) instanceof NativeUnifiedADData)) ? new ArrayList() : (List) aDEvent.getParas()[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<NativeUnifiedADData> a(List<NativeUnifiedADData> list, final BaseNativeUnifiedAd baseNativeUnifiedAd) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (NativeUnifiedADData nativeUnifiedADData : list) {
            arrayList.add(com.qq.e.comm.plugin.nativeadunified.a.a(nativeUnifiedADData, new a(new a.InterfaceC1207a() { // from class: com.qq.e.comm.plugin.nativeadunified.k.2
                @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1207a
                public void a() {
                }

                @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1207a
                public boolean a(ADEvent aDEvent) {
                    return false;
                }

                @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1207a
                public void b() {
                    k.this.a((k) baseNativeUnifiedAd, 70342);
                }

                @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1207a
                public void b(ADEvent aDEvent) {
                }

                @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1207a
                public void c() {
                    k.this.b(baseNativeUnifiedAd, 70332);
                }
            })));
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int b(final BaseNativeUnifiedAd baseNativeUnifiedAd) {
        final long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b(new a.InterfaceC1207a() { // from class: com.qq.e.comm.plugin.nativeadunified.k.1
            private void a(boolean z) {
                k.this.a((k) baseNativeUnifiedAd, System.currentTimeMillis() - currentTimeMillis, z, z ? 70312 : 70322);
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1207a
            public void a() {
                a(false);
                if (!k.this.i() || k.this.b()) {
                    return;
                }
                k.this.a();
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1207a
            public boolean a(ADEvent aDEvent) {
                boolean z;
                List a2 = k.this.a(aDEvent);
                if (a2 != null && a2.size() > 0) {
                    NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) a2.get(0);
                    int i = -1;
                    if (nativeUnifiedADData != null) {
                        i = nativeUnifiedADData.getECPM();
                        if (nativeUnifiedADData instanceof com.qq.e.comm.plugin.r.a) {
                            if (i <= 0) {
                                i = ((com.qq.e.comm.plugin.r.a) nativeUnifiedADData).getMediationPrice();
                            }
                            z = ((com.qq.e.comm.plugin.r.a) nativeUnifiedADData).isContractAd();
                            k.this.a((k) baseNativeUnifiedAd, i, z, baseNativeUnifiedAd.getAdapterPriority());
                        }
                    }
                    z = false;
                    k.this.a((k) baseNativeUnifiedAd, i, z, baseNativeUnifiedAd.getAdapterPriority());
                }
                a(true);
                if (k.this.i() && k.this.d((k) baseNativeUnifiedAd) && !k.this.j()) {
                    aDEvent.getParas()[0] = k.this.a(a2, baseNativeUnifiedAd);
                    k.this.h();
                }
                return false;
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1207a
            public void b() {
                k.this.a((k) baseNativeUnifiedAd, 70342);
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1207a
            public void b(ADEvent aDEvent) {
                if (k.this.d == null) {
                    return;
                }
                k.this.d.onADEvent(aDEvent);
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1207a
            public void c() {
                k.this.b(baseNativeUnifiedAd, 70332);
            }
        }, i());
        this.f.put(baseNativeUnifiedAd, bVar);
        baseNativeUnifiedAd.setAdListener(bVar);
        if (this.g != null) {
            baseNativeUnifiedAd.setCategories(this.g);
        }
        if (this.h > 0) {
            baseNativeUnifiedAd.setMinVideoDuration(this.h);
        }
        if (this.i >= 0) {
            baseNativeUnifiedAd.setMaxVideoDuration(this.i);
        }
        baseNativeUnifiedAd.setVideoADContainerRender(this.j);
        baseNativeUnifiedAd.setVideoPlayPolicy(this.k);
        if (this.l != null) {
            baseNativeUnifiedAd.setDownAPPConfirmPolicy(this.l);
        }
        baseNativeUnifiedAd.setBrowserType(this.m);
        if (baseNativeUnifiedAd instanceof com.qq.e.comm.plugin.r.b) {
            ((com.qq.e.comm.plugin.r.b) baseNativeUnifiedAd).a(this.n);
        }
        baseNativeUnifiedAd.loadData(this.e);
        GDTLogger.d(baseNativeUnifiedAd.getClass().getSimpleName() + " load Ad");
        return 70302;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: a */
    public BaseNativeUnifiedAd b(com.qq.e.comm.plugin.r.b.c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            return com.qq.e.comm.plugin.nativeadunified.a.a(cVar.e(), this.f12361a, cVar.b(), cVar.g());
        } catch (Exception e) {
            a(70352, cVar);
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.qq.e.comm.plugin.r.a.a
    protected void a() {
        if (this.d != null) {
            this.d.onADEvent(new ADEvent(2, new Object[]{501}));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void a(BaseNativeUnifiedAd baseNativeUnifiedAd) {
        b bVar;
        if (baseNativeUnifiedAd == null || (bVar = this.f.get(baseNativeUnifiedAd)) == null) {
            a();
            return;
        }
        for (ADEvent aDEvent : bVar.a()) {
            if (aDEvent.getType() == 1) {
                aDEvent.getParas()[0] = a(a(aDEvent), baseNativeUnifiedAd);
            }
            this.d.onADEvent(aDEvent);
        }
    }

    @Override // com.qq.e.comm.pi.NUADI
    public String getAdNetWorkName() {
        return k();
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i) {
        this.e = i;
        c();
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i, LoadAdParams loadAdParams) {
        loadData(i);
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setBrowserType(int i) {
        this.m = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setCategories(List<String> list) {
        this.g = list;
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.l = downAPPConfirmPolicy;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMaxVideoDuration(int i) {
        this.i = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMinVideoDuration(int i) {
        this.h = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVastClassName(String str) {
        this.n = str;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVideoADContainerRender(int i) {
        this.j = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVideoPlayPolicy(int i) {
        this.k = i;
    }
}
