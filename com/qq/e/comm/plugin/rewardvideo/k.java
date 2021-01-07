package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.r.a.a;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes4.dex */
class k extends com.qq.e.comm.plugin.r.a.a<BaseRewardAd> implements RVADI {
    ADListener d;
    BaseRewardAd e;
    Map<BaseRewardAd, a> f;
    boolean g;
    LoadAdParams h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        a.InterfaceC1218a f12719a;

        /* renamed from: b  reason: collision with root package name */
        EnumC1219a f12720b = EnumC1219a.NO_RESULT;
        int c = 0;
        Queue<ADEvent> d = new LinkedList();

        /* renamed from: com.qq.e.comm.plugin.rewardvideo.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        enum EnumC1219a {
            LOAD_SUCCESS,
            LOAD_FAILED,
            NO_RESULT
        }

        a(a.InterfaceC1218a interfaceC1218a) {
            this.f12719a = interfaceC1218a;
        }

        private void a(ADEvent aDEvent) {
            if (this.c <= 0 || this.f12719a == null) {
                this.d.offer(aDEvent);
            } else {
                this.f12719a.b(aDEvent);
            }
        }

        void a() {
            this.c |= 2;
        }

        public Queue<ADEvent> b() {
            return this.d;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                    if (this.f12719a != null) {
                        if (this.f12719a.a(null)) {
                            this.c |= 1;
                        }
                        if (this.c > 0) {
                            this.f12719a.b(aDEvent);
                        }
                    }
                    this.f12720b = EnumC1219a.LOAD_SUCCESS;
                    this.d.offer(aDEvent);
                    return;
                case 4:
                case 6:
                    if (this.f12719a != null) {
                        if (aDEvent.getType() != 4) {
                            this.f12719a.b();
                            break;
                        } else {
                            this.f12719a.c();
                            break;
                        }
                    }
                    break;
                case 9:
                    if (this.f12720b != EnumC1219a.NO_RESULT) {
                        if (this.f12720b == EnumC1219a.LOAD_SUCCESS) {
                            a(aDEvent);
                            return;
                        }
                        return;
                    }
                    this.f12720b = EnumC1219a.LOAD_FAILED;
                    if (this.f12719a != null) {
                        this.f12719a.a();
                        return;
                    }
                    return;
            }
            a(aDEvent);
        }
    }

    public k(Context context, String str, String str2, ADListener aDListener) {
        super(context, str2);
        this.f = new HashMap();
        this.g = true;
        this.h = null;
        this.d = aDListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int b(final BaseRewardAd baseRewardAd) {
        final long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(new a.InterfaceC1218a() { // from class: com.qq.e.comm.plugin.rewardvideo.k.1
            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1218a
            public void a() {
                if (k.this.j()) {
                    return;
                }
                k.this.a((k) baseRewardAd, System.currentTimeMillis() - currentTimeMillis, false, 70222);
                if (k.this.i() && k.this.c((k) baseRewardAd) && !k.this.b()) {
                    k.this.a();
                }
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1218a
            public boolean a(ADEvent aDEvent) {
                int i;
                boolean z;
                if (k.this.j()) {
                    return false;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                int ecpm = baseRewardAd.getECPM();
                if (baseRewardAd instanceof com.qq.e.comm.plugin.r.a) {
                    i = ecpm <= 0 ? ((com.qq.e.comm.plugin.r.a) baseRewardAd).getMediationPrice() : ecpm;
                    z = ((com.qq.e.comm.plugin.r.a) baseRewardAd).isContractAd();
                } else {
                    i = ecpm;
                    z = false;
                }
                k.this.a((k) baseRewardAd, i, z, baseRewardAd.getAdapterPriority());
                k.this.a((k) baseRewardAd, currentTimeMillis2 - currentTimeMillis, true, 70212);
                if (k.this.i() && k.this.d((k) baseRewardAd) && !k.this.j()) {
                    k.this.h();
                    k.this.e = baseRewardAd;
                    return true;
                }
                return false;
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1218a
            public void b() {
                k.this.a((k) baseRewardAd, 70242);
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1218a
            public void b(ADEvent aDEvent) {
                if (k.this.d == null || !k.this.d((k) baseRewardAd)) {
                    return;
                }
                k.this.d.onADEvent(aDEvent);
            }

            @Override // com.qq.e.comm.plugin.r.a.a.InterfaceC1218a
            public void c() {
                k.this.b((k) baseRewardAd, 70232);
            }
        });
        baseRewardAd.setAdListener(aVar);
        if (SDKStatus.getSDKVersionCode() >= 80) {
            baseRewardAd.setVolumOn(this.g);
        }
        if (SDKStatus.getSDKVersionCode() >= 120) {
            baseRewardAd.setLoadAdParams(this.h);
        }
        this.f.put(baseRewardAd, aVar);
        GDTLogger.d(baseRewardAd.getClass().getSimpleName() + " load Ad");
        baseRewardAd.loadAD();
        return 70202;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: a */
    public BaseRewardAd b(com.qq.e.comm.plugin.r.b.c cVar) {
        if (cVar != null) {
            try {
                return com.qq.e.comm.plugin.rewardvideo.a.a(cVar.e(), this.f12660b, cVar.b(), cVar.g());
            } catch (Exception e) {
                a(70252, cVar);
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.r.a.a
    protected void a() {
        if (this.d != null) {
            this.d.onADEvent(new ADEvent(9, new Object[]{501}));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void a(BaseRewardAd baseRewardAd) {
        a aVar;
        this.e = baseRewardAd;
        if (this.e == null) {
            a();
        } else if (this.d != null && (aVar = this.f.get(this.e)) != null) {
            aVar.a();
            for (ADEvent aDEvent : aVar.b()) {
                this.d.onADEvent(aDEvent);
            }
        }
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getAdNetWorkName() {
        return k();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getECPM() {
        if (this.e != null) {
            return this.e.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getECPMLevel() {
        if (this.e != null) {
            return this.e.getECPMLevel();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public long getExpireTimestamp() {
        if (this.e != null) {
            return this.e.getExpireTimestamp();
        }
        return 0L;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getRewardAdType() {
        if (this.e != null) {
            return this.e.getRewardAdType();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getVideoDuration() {
        if (this.e != null) {
            return this.e.getVideoDuration();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public boolean hasShown() {
        if (this.e != null) {
            return this.e.hasShown();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void loadAD() {
        c();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.h = loadAdParams;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setVolumeOn(boolean z) {
        this.g = z;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD() {
        if (this.e != null) {
            this.e.showAD();
        }
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD(Activity activity) {
        if (this.e != null) {
            if (SDKStatus.getSDKVersionCode() >= 100) {
                this.e.showAD(activity);
            } else {
                GDTLogger.e("showAD(Activity activity) is not support in current SDK version, please upgrade");
            }
        }
    }
}
