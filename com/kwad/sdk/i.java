package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.d.a;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.config.item.n;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.report.v;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class i {

    /* loaded from: classes10.dex */
    public static class a implements com.kwad.sdk.service.a.a {
        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.a.a
        public final void g(Context context, AdTemplate adTemplate) {
            com.kwad.components.core.e.d.a.a(new a.C0644a(context).aq(adTemplate).aq(true));
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements com.kwad.sdk.service.a.f {
        public b() {
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getApiVersion() {
            return KsAdSDKImpl.get().getApiVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final int getApiVersionCode() {
            return KsAdSDKImpl.get().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppId() {
            return KsAdSDKImpl.get().getAppId();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppName() {
            return KsAdSDKImpl.get().getAppName();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Context getContext() {
            return KsAdSDKImpl.get().getContext();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean getIsExternal() {
            return KsAdSDKImpl.get().getIsExternal();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getSDKVersion() {
            return KsAdSDKImpl.get().getSDKVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean hasInitFinish() {
            return KsAdSDKImpl.get().hasInitFinish();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean isPersonalRecommend() {
            return KsAdSDKImpl.get().isPersonalRecommend();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean isProgrammaticRecommend() {
            return KsAdSDKImpl.get().isProgrammaticRecommend();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean oA() {
            com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
            if (aVar != null) {
                return aVar.oA();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.response.b.g tt() {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            if (aVar != null) {
                return aVar.tt();
            }
            return null;
        }

        @Override // com.kwad.sdk.service.a.f
        public final String yh() {
            return com.kwad.sdk.kgeo.a.yh();
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.b yi() {
            return com.kwad.sdk.kgeo.a.HJ();
        }

        @Override // com.kwad.sdk.service.a.f
        public final List<AdTemplate> yj() {
            return com.kwad.sdk.core.download.b.BU().yj();
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean aF(AdTemplate adTemplate) {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            if (aVar != null && aVar.ts()) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements com.kwad.sdk.service.a.h {
        public c() {
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getAppId() {
            return KsAdSDKImpl.get().getAppId();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getUserAgent() {
            return com.kwad.sdk.core.config.d.getUserAgent();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean wz() {
            return com.kwad.sdk.core.config.d.wz();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yA() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqM);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yB() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqN);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yC() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqO);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yD() {
            return com.kwad.sdk.core.config.d.yD();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int yE() {
            return com.kwad.sdk.core.config.d.yE();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yF() {
            return com.kwad.sdk.core.config.d.yF();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String yG() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqV);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yH() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.aqZ);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yk() {
            return com.kwad.sdk.core.config.d.yk();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yl() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.apr);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean ym() {
            return com.kwad.sdk.core.config.d.ym();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yn() {
            return com.kwad.sdk.core.config.d.yn();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String yo() {
            return com.kwad.sdk.core.config.d.yo();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String yp() {
            return com.kwad.sdk.core.config.d.yp();
        }

        @Override // com.kwad.sdk.service.a.h
        public final List<String> yq() {
            return com.kwad.sdk.core.config.d.yq();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yr() {
            return com.kwad.sdk.core.config.d.yr();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean ys() {
            return com.kwad.sdk.core.config.d.ys();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yt() {
            return com.kwad.sdk.core.config.d.AV();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yu() {
            return com.kwad.sdk.core.config.d.yu();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yv() {
            return com.kwad.sdk.core.config.d.yv();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int yw() {
            return com.kwad.sdk.core.config.d.yw();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int yx() {
            return com.kwad.sdk.core.config.d.yx();
        }

        @Override // com.kwad.sdk.service.a.h
        public final double yy() {
            return com.kwad.sdk.core.config.d.yy();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yz() {
            return com.kwad.sdk.core.config.d.yz();
        }

        public /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean T(long j) {
            return com.kwad.sdk.core.config.d.T(j);
        }

        @Override // com.kwad.sdk.service.a.h
        public final int as(Context context) {
            return com.kwad.sdk.core.config.item.c.aS(context);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean bP(String str) {
            return com.kwad.sdk.core.config.a.bP(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final <T> T getAppConfigData(T t, com.kwad.sdk.g.b<JSONObject, T> bVar) {
            return (T) com.kwad.sdk.core.config.d.AR().getAppConfigData(null, bVar);
        }
    }

    public static void yb() {
        ServiceProvider.put(com.kwad.sdk.service.a.f.class, new b((byte) 0));
        ServiceProvider.put(com.kwad.sdk.service.a.h.class, new c((byte) 0));
        ServiceProvider.put(com.kwad.sdk.service.a.e.class, new com.kwad.sdk.service.a.e() { // from class: com.kwad.sdk.i.1
            @Override // com.kwad.sdk.service.a.e
            public final void a(final com.kwad.sdk.service.a.c cVar) {
                com.kwad.components.core.d.a.a(new a.b() { // from class: com.kwad.sdk.i.1.1
                    @Override // com.kwad.components.core.d.a.b
                    public final String getKey() {
                        com.kwad.sdk.service.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            return cVar2.getKey();
                        }
                        return null;
                    }

                    @Override // com.kwad.components.core.d.a.b
                    public final JSONObject getValue() {
                        com.kwad.sdk.service.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            return cVar2.getValue();
                        }
                        return null;
                    }
                });
            }

            @Override // com.kwad.sdk.service.a.e
            public final void gatherException(Throwable th) {
                com.kwad.components.core.d.a.b(th);
            }

            @Override // com.kwad.sdk.service.a.e
            public final void a(final com.kwad.sdk.service.a.g gVar) {
                com.kwad.components.core.d.a.a(new a.c() { // from class: com.kwad.sdk.i.1.2
                    @Override // com.kwad.components.core.d.a.c
                    public final void onCrashOccur(int i, String str) {
                        com.kwad.sdk.service.a.g gVar2 = gVar;
                        if (gVar2 != null) {
                            gVar2.l(i, str);
                        }
                    }
                });
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.d.class, new com.kwad.sdk.service.a.d() { // from class: com.kwad.sdk.i.2
            @Override // com.kwad.sdk.service.a.d
            public final void a(boolean z, String str, String str2, String str3) {
                com.kwad.sdk.core.diskcache.b.a.BS().cT(str);
            }

            @Override // com.kwad.sdk.service.a.d
            public final File bO(String str) {
                return com.kwad.sdk.core.diskcache.b.a.BS().bO(str);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.j.class, new com.kwad.sdk.service.a.j() { // from class: com.kwad.sdk.i.3
            @Override // com.kwad.sdk.service.a.j
            public final boolean qo() {
                com.kwad.components.core.p.b.qn();
                return com.kwad.components.core.p.b.qo();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int qp() {
                com.kwad.components.core.p.b.qn();
                return com.kwad.components.core.p.b.qp();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int qq() {
                return com.kwad.components.core.p.b.qn().qq();
            }

            @Override // com.kwad.sdk.service.a.j
            public final InputStream wrapInputStream(InputStream inputStream) {
                com.kwad.components.core.p.b.qn();
                return com.kwad.components.core.p.b.wrapInputStream(inputStream);
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.network.k.class, new com.kwad.sdk.core.network.k() { // from class: com.kwad.sdk.i.4
            @Override // com.kwad.sdk.core.network.k
            public final com.kwad.sdk.core.b yc() {
                return com.kwad.components.core.request.model.b.qm();
            }

            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.i iVar) {
                com.kwad.sdk.commercial.a.b(iVar);
            }

            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.j jVar) {
                com.kwad.sdk.commercial.a.b(jVar);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.i.class, ImageLoaderProxy.INSTANCE);
        ServiceProvider.put(com.kwad.sdk.service.a.b.class, new com.kwad.sdk.service.a.b() { // from class: com.kwad.sdk.i.5
            @Override // com.kwad.sdk.service.a.b
            public final void yd() {
                com.kwad.components.core.o.a.pX().ae(ServiceProvider.getContext());
            }

            @Override // com.kwad.sdk.service.a.b
            public final void D(String str, String str2) {
                com.kwad.sdk.core.e.c.e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void e(@NonNull JSONObject jSONObject, int i) {
                com.kwad.components.core.o.a.pX().e(jSONObject, i);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void aE(AdTemplate adTemplate) {
                com.kwad.components.core.o.a.pX().f(adTemplate, 21007);
            }
        });
        ServiceProvider.put(v.class, new v() { // from class: com.kwad.sdk.i.6
            @Override // com.kwad.sdk.core.report.v
            public final int tq() {
                com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
                if (aVar != null) {
                    return aVar.tq();
                }
                return 0;
            }

            @Override // com.kwad.sdk.core.report.v
            public final int ye() {
                return com.kwad.sdk.core.config.d.ye();
            }

            @Override // com.kwad.sdk.core.report.v
            public final boolean S(long j) {
                n nVar = com.kwad.sdk.core.config.c.ape;
                return n.S(j);
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.video.a.f.class, new com.kwad.sdk.core.video.a.f() { // from class: com.kwad.sdk.i.7
            @Override // com.kwad.sdk.core.video.a.f
            public final boolean tr() {
                return ((com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class)).tr();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean yf() {
                return com.kwad.sdk.core.config.d.yf();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean yg() {
                return com.kwad.sdk.core.config.d.yg();
            }
        });
        ServiceProvider.put(com.kwad.sdk.utils.b.b.class, new com.kwad.sdk.utils.b.b() { // from class: com.kwad.sdk.i.8
            @Override // com.kwad.sdk.utils.b.b
            public final void a(com.kwad.sdk.utils.b.a aVar) {
                if (aVar == null) {
                    return;
                }
                com.kwad.sdk.commercial.a.b(aVar);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.a.class, new a((byte) 0));
    }
}
