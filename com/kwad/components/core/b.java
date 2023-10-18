package com.kwad.components.core;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.m;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.report.k;
import com.kwad.sdk.core.report.r;
import com.kwad.sdk.core.response.a.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import com.kwad.sdk.service.kwai.h;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {

    /* loaded from: classes10.dex */
    public static class a implements com.kwad.sdk.core.download.d {
        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.download.d
        public final void a(int i, AdTemplate adTemplate) {
            if (i != 1) {
                return;
            }
            com.kwad.sdk.core.report.a.f(adTemplate, (JSONObject) null);
        }
    }

    /* renamed from: com.kwad.components.core.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0618b implements com.kwad.sdk.service.kwai.b {
    }

    /* loaded from: classes10.dex */
    public static class c implements com.kwad.sdk.service.kwai.d {
        public c() {
        }

        public /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean G(AdTemplate adTemplate) {
            com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            return aVar != null && aVar.qn();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String getApiVersion() {
            return KsAdSDKImpl.get().getApiVersion();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final int getApiVersionCode() {
            return KsAdSDKImpl.get().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String getAppId() {
            return KsAdSDKImpl.get().getAppId();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String getAppName() {
            return KsAdSDKImpl.get().getAppName();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final Context getContext() {
            return KsAdSDKImpl.get().getContext();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean getIsExternal() {
            return KsAdSDKImpl.get().getIsExternal();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String getSDKVersion() {
            return KsAdSDKImpl.get().getSDKVersion();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final SdkConfig getSdkConfig() {
            return KsAdSDKImpl.get().getSdkConfig();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean isDebugLogEnable() {
            return KsAdSDKImpl.get().isDebugLogEnable();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean isPersonalRecommend() {
            return KsAdSDKImpl.get().isPersonalRecommend();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean isProgrammaticRecommend() {
            return KsAdSDKImpl.get().isProgrammaticRecommend();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final e lw() {
            com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            if (aVar != null) {
                return aVar.lw();
            }
            return null;
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements f {
        public d() {
        }

        public /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean ae(String str) {
            return com.kwad.sdk.core.config.a.ae(str);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int af(Context context) {
            return com.kwad.sdk.core.config.item.c.bm(context);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String getAppId() {
            return KsAdSDKImpl.get().getAppId();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String getUserAgent() {
            return com.kwad.sdk.core.config.d.getUserAgent();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean i(long j) {
            return com.kwad.sdk.core.config.d.i(j);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lA() {
            return com.kwad.sdk.core.config.d.lA();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String lB() {
            return com.kwad.sdk.core.config.d.lB();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String lC() {
            return com.kwad.sdk.core.config.d.lC();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final List<String> lD() {
            return com.kwad.sdk.core.config.d.lD();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lE() {
            return com.kwad.sdk.core.config.d.lE();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lF() {
            return com.kwad.sdk.core.config.d.lF();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lG() {
            return com.kwad.sdk.core.config.d.lG();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lH() {
            return com.kwad.sdk.core.config.d.se();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final float lI() {
            return com.kwad.sdk.core.config.d.lI();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final float lJ() {
            return com.kwad.sdk.core.config.d.lJ();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lK() {
            return com.kwad.sdk.core.config.d.lK();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lL() {
            return com.kwad.sdk.core.config.d.lL();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int lM() {
            return com.kwad.sdk.core.config.d.lM();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int lN() {
            return com.kwad.sdk.core.config.d.lN();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final float lO() {
            return com.kwad.sdk.core.config.d.lO();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lx() {
            return com.kwad.sdk.core.config.d.lx();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean ly() {
            return com.kwad.sdk.core.config.d.ly();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lz() {
            return com.kwad.sdk.core.config.d.lz();
        }
    }

    @NonNull
    public static AdHttpProxy le() {
        if (com.kwad.components.core.a.aw.booleanValue()) {
            return lf();
        }
        try {
            return com.kwad.sdk.core.network.kwai.b.tF() != null ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
        } catch (Throwable unused) {
            return new com.kwad.sdk.core.network.b.a();
        }
    }

    public static AdHttpProxy lf() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return new Random().nextInt(2) == 0 ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
    }

    public static void lg() {
        ServiceProvider.put(com.kwad.sdk.service.kwai.e.class, new com.kwad.sdk.service.kwai.e() { // from class: com.kwad.components.core.b.1
            @Override // com.kwad.sdk.service.kwai.e
            public final Class<?> getProxyRealClass(Class<?> cls) {
                return KsAdSDKImpl.getProxyRealClass(cls);
            }

            @Override // com.kwad.sdk.service.kwai.e
            public final Object lm() {
                return KsAdSDKImpl.get().getProxyForHttp();
            }
        });
    }

    public static void lh() {
        ServiceProvider.put(com.kwad.sdk.service.kwai.d.class, new c((byte) 0));
        ServiceProvider.put(f.class, new d((byte) 0));
    }

    public static void li() {
        ServiceProvider.put(com.kwad.sdk.service.kwai.a.class, new com.kwad.sdk.service.kwai.a() { // from class: com.kwad.components.core.b.2
            @Override // com.kwad.sdk.service.kwai.a
            public final void a(boolean z, String str, String str2, String str3) {
                com.kwad.sdk.core.diskcache.a.a.sS().bA(str);
            }

            @Override // com.kwad.sdk.service.kwai.a
            public final File ad(String str) {
                return com.kwad.sdk.core.diskcache.a.a.sS().ad(str);
            }
        });
    }

    public static void lj() {
        ServiceProvider.put(com.kwad.sdk.service.kwai.b.class, new C0618b());
    }

    public static void lk() {
        ServiceProvider.put(h.class, new h() { // from class: com.kwad.components.core.b.3
            @Override // com.kwad.sdk.service.kwai.h
            public final boolean ln() {
                com.kwad.components.core.l.b.or();
                return com.kwad.components.core.l.b.ln();
            }

            @Override // com.kwad.sdk.service.kwai.h
            public final int lo() {
                com.kwad.components.core.l.b.or();
                return com.kwad.components.core.l.b.lo();
            }

            @Override // com.kwad.sdk.service.kwai.h
            public final int lp() {
                return com.kwad.components.core.l.b.or().lp();
            }

            @Override // com.kwad.sdk.service.kwai.h
            public final InputStream wrapInputStream(InputStream inputStream) {
                com.kwad.components.core.l.b.or();
                return com.kwad.components.core.l.b.wrapInputStream(inputStream);
            }
        });
        ServiceProvider.put(l.class, new l() { // from class: com.kwad.components.core.b.4
            @Override // com.kwad.sdk.core.network.l
            public final void a(double d2, j jVar) {
                k.b(d2, jVar);
            }

            @Override // com.kwad.sdk.core.network.l
            public final void a(double d2, com.kwad.sdk.core.network.k kVar) {
                k.b(d2, kVar);
            }

            @Override // com.kwad.sdk.core.network.l
            public final com.kwad.sdk.core.b lq() {
                return com.kwad.components.core.k.kwai.c.oq();
            }
        });
        ll();
    }

    public static void ll() {
        ServiceProvider.put(r.class, new r() { // from class: com.kwad.components.core.b.5
            @Override // com.kwad.sdk.core.report.r
            public final boolean h(long j) {
                m mVar = com.kwad.sdk.core.config.c.Ui;
                return m.h(j);
            }

            @Override // com.kwad.sdk.core.report.r
            public final int lr() {
                return com.kwad.sdk.core.config.d.lr();
            }

            @Override // com.kwad.sdk.core.report.r
            public final int ls() {
                com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                if (aVar != null) {
                    return aVar.ls();
                }
                return 0;
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.download.d.class, new a((byte) 0));
        ServiceProvider.put(com.kwad.sdk.core.video.kwai.f.class, new com.kwad.sdk.core.video.kwai.f() { // from class: com.kwad.components.core.b.6
            @Override // com.kwad.sdk.core.video.kwai.f
            public final boolean lt() {
                return com.kwad.sdk.core.config.d.lt();
            }

            @Override // com.kwad.sdk.core.video.kwai.f
            public final boolean lu() {
                return com.kwad.sdk.core.config.d.lu();
            }

            @Override // com.kwad.sdk.core.video.kwai.f
            public final boolean lv() {
                return ((com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class)).lv();
            }
        });
        ServiceProvider.put(com.kwad.sdk.utils.a.b.class, new com.kwad.sdk.utils.a.b() { // from class: com.kwad.components.core.b.7
            @Override // com.kwad.sdk.utils.a.b
            public final void a(com.kwad.sdk.utils.a.a aVar) {
                if (aVar == null) {
                    return;
                }
                k.b(aVar);
            }
        });
    }
}
