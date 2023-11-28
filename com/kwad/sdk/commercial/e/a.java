package com.kwad.sdk.commercial.e;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class a {
    public static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.d.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.001d).a(com.kwad.sdk.commercial.c.aS(adTemplate)).L("ad_convert_method_call", "method_name").u(aVar));
    }

    public static void f(AdTemplate adTemplate, boolean z) {
        try {
            a(adTemplate, b.zU().cq("adUserClick").bj(z));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bd(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("adClick"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void be(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("startH5Page"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bf(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("dplinkStart"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bg(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("smallAppSuccess"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bh(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("appstoreStart"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bi(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("disableClick"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bj(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toVideoH5Web"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bk(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toDownload"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bl(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toOpenApp"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bm(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toInstallApp"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bn(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toDownloadDialog"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bo(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toDownloadThirdDialog"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bp(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toDownloadPage"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bq(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toDownloadPause"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void br(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toDownloadResume"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bs(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toDownloadNoNet"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bt(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toDoNoting"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bu(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toOpenAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bv(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toOpenDeeplinkDialog"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bw(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toH5PageDialog"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bx(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toMiddlePageDialog"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void by(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("toSmallAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }
}
