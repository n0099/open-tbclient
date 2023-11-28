package com.kwad.components.ad.splashscreen.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    public static volatile b CS;

    public static b kO() {
        if (CS == null) {
            synchronized (b.class) {
                if (CS == null) {
                    CS = new b();
                }
            }
        }
        return CS;
    }

    public static StyleTemplate S(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dq(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k != null) {
            styleTemplate.templateId = k.templateId;
            styleTemplate.templateMd5 = k.templateMd5;
            styleTemplate.templateUrl = k.templateUrl;
            styleTemplate.templateVersionCode = (int) k.templateVersionCode;
        }
        return styleTemplate;
    }

    public static void Z(@NonNull AdTemplate adTemplate) {
        long j;
        boolean bd = com.kwad.sdk.core.response.b.a.bd(e.dP(adTemplate));
        int i = 1;
        SplashMonitorInfo status = new SplashMonitorInfo().setStatus(1);
        if (bd) {
            i = 2;
        }
        SplashMonitorInfo type = status.setType(i);
        if (d.a(com.kwad.components.ad.splashscreen.b.a.CP)) {
            j = 1;
        } else {
            j = 2;
        }
        com.kwad.sdk.commercial.a.k(type.setLoadProcessType(j).setAdTemplate(adTemplate));
    }

    public static void aa(@NonNull AdTemplate adTemplate) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(dP);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setStatus(4).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP));
        if (bd) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.a.k(creativeId.setType(i).setAdTemplate(adTemplate));
    }

    public static void p(long j) {
        long j2;
        SplashMonitorInfo status = new SplashMonitorInfo().setStatus(1);
        if (d.a(com.kwad.components.ad.splashscreen.b.a.CP)) {
            j2 = 1;
        } else {
            j2 = 2;
        }
        com.kwad.sdk.commercial.a.h(status.setLoadProcessType(j2).setPosId(j));
    }

    public static void q(long j) {
        com.kwad.sdk.commercial.a.i(new SplashMonitorInfo().setStatus(1).setPosId(j));
    }

    public static void a(@NonNull AdTemplate adTemplate, int i, long j, long j2) {
        int i2;
        long j3;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo dP = e.dP(adTemplate);
        SplashMonitorInfo splashMonitorInfo = new SplashMonitorInfo();
        if (adTemplate.notNetworkRequest) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        SplashMonitorInfo beforeLoadDataTime = splashMonitorInfo.setType(i2).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j2);
        if (d.a(com.kwad.components.ad.splashscreen.b.a.CP)) {
            j3 = 1;
        } else {
            j3 = 2;
        }
        com.kwad.sdk.commercial.a.h(beforeLoadDataTime.setLoadProcessType(j3).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP)).setAdTemplate(adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, int i, long j, long j2) {
        String str;
        int i2;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo dP = e.dP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(dP)) {
            str = com.kwad.sdk.core.response.b.a.K(dP);
        } else {
            str = com.kwad.sdk.core.response.b.a.aU(dP).materialUrl;
        }
        SplashMonitorInfo splashMonitorInfo = new SplashMonitorInfo();
        if (adTemplate.notNetworkRequest) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        com.kwad.sdk.commercial.a.h(splashMonitorInfo.setType(i2).setStatus(5).setCheckStatus(i).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j2).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP)).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, int i) {
        String str;
        long j2;
        AdInfo dP = e.dP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(dP)) {
            str = com.kwad.sdk.core.response.b.a.K(dP);
        } else {
            str = com.kwad.sdk.core.response.b.a.aU(dP).materialUrl;
        }
        File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(com.kwad.sdk.core.response.b.a.aZ(dP));
        if (bO != null && bO.exists()) {
            j2 = bO.length();
        } else {
            j2 = 0;
        }
        int i2 = 1;
        SplashMonitorInfo url = new SplashMonitorInfo().setStatus(1).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP)).setCostTime(j).setCacheValidTime(dP.adPreloadInfo.validityPeriod * 1000).setSize(j2).setUrl(str);
        if (!com.kwad.sdk.core.response.b.a.bc(dP)) {
            i2 = 2;
        }
        com.kwad.sdk.commercial.a.g(false, url.setMaterialType(i2).setType(i).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, boolean z) {
        int i;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo dP = e.dP(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(dP);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setStatus(6).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP));
        int i2 = 1;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        SplashMonitorInfo loadDataTime = creativeId.setViewSource(i).setLoadDataTime(elapsedRealtime);
        if (bd) {
            i2 = 2;
        }
        com.kwad.sdk.commercial.a.k(loadDataTime.setType(i2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long di;
        SplashMonitorInfo tkRenderType = new SplashMonitorInfo().setStatus(101).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.de(adTemplate));
        e.dP(adTemplate);
        if (h.U(adTemplate)) {
            di = com.kwad.sdk.core.response.b.b.dd(adTemplate);
        } else {
            di = com.kwad.sdk.core.response.b.b.di(e.dP(adTemplate));
        }
        com.kwad.sdk.commercial.a.k(tkRenderType.setTkDefaultTimeout(di).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long di;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(102).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.de(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.dP(adTemplate);
        if (h.U(adTemplate)) {
            di = com.kwad.sdk.core.response.b.b.dd(adTemplate);
        } else {
            di = com.kwad.sdk.core.response.b.b.di(e.dP(adTemplate));
        }
        com.kwad.sdk.commercial.a.k(templateVersionCode.setTkDefaultTimeout(di).setAdTemplate(adTemplate));
    }

    public static void c(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long di;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(106).setTkRenderType(com.kwad.sdk.core.response.b.b.de(adTemplate)).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.dP(adTemplate);
        if (h.U(adTemplate)) {
            di = com.kwad.sdk.core.response.b.b.dd(adTemplate);
        } else {
            di = com.kwad.sdk.core.response.b.b.di(e.dP(adTemplate));
        }
        com.kwad.sdk.commercial.a.k(templateVersionCode.setTkDefaultTimeout(di).setAdTemplate(adTemplate));
    }

    public static void d(@NonNull AdTemplate adTemplate, long j) {
        int i;
        long j2;
        AdInfo dP = e.dP(adTemplate);
        SplashMonitorInfo splashMonitorInfo = new SplashMonitorInfo();
        if (adTemplate.notNetworkRequest) {
            i = 2;
        } else {
            i = 1;
        }
        SplashMonitorInfo loadDataTime = splashMonitorInfo.setType(i).setStatus(2).setBeforeLoadDataTime(j).setLoadDataTime(adTemplate.loadDataTime);
        if (d.a(com.kwad.components.ad.splashscreen.b.a.CP)) {
            j2 = 1;
        } else {
            j2 = 2;
        }
        com.kwad.sdk.commercial.a.h(loadDataTime.setLoadProcessType(j2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP)).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, long j) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(dP);
        SplashMonitorInfo status = new SplashMonitorInfo().setStatus(5);
        if (bd) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.a.k(status.setType(i).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP)).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate, int i, long j, int i2, long j2, long j3, long j4, long j5, long j6) {
        long di;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(104).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.de(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.dP(adTemplate);
        if (h.U(adTemplate)) {
            di = com.kwad.sdk.core.response.b.b.dd(adTemplate);
        } else {
            di = com.kwad.sdk.core.response.b.b.di(e.dP(adTemplate));
        }
        com.kwad.sdk.commercial.a.k(templateVersionCode.setTkDefaultTimeout(di).setSoSource(i).setSoLoadTime(j).setOfflineSource(i2).setOfflineLoadTime(j2).setTkFileLoadTime(j3).setTkInitTime(j4).setTkRenderTime(j5).setTkTotalTime(j6).setAdTemplate(adTemplate));
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, boolean z) {
        int i = 1;
        if (adTemplate == null) {
            SplashMonitorInfo errorMsg = new SplashMonitorInfo().setErrorMsg(str);
            if (!z) {
                i = 2;
            }
            com.kwad.sdk.commercial.a.l(errorMsg.setViewSource(i));
            return;
        }
        SplashMonitorInfo errorMsg2 = new SplashMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(e.dP(adTemplate))).setErrorMsg(str);
        if (!z) {
            i = 2;
        }
        com.kwad.sdk.commercial.a.l(errorMsg2.setViewSource(i).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull List<AdTemplate> list, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        for (AdTemplate adTemplate : list) {
            arrayList.add(com.kwad.sdk.core.response.b.a.aZ(e.dP(adTemplate)));
        }
        com.kwad.sdk.commercial.a.i(new SplashMonitorInfo().setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).setPosId(j2));
    }

    public static void ab(@Nullable AdTemplate adTemplate) {
        String str;
        boolean z;
        int i;
        AdMatrixInfo.SplashPlayCardTKInfo dc = com.kwad.sdk.core.response.b.b.dc(adTemplate);
        boolean z2 = true;
        if (TextUtils.isEmpty(dc.templateId)) {
            str = SplashMonitorInfo.TEMPLATE_ID_EMPTY;
            z = true;
        } else {
            str = "";
            z = false;
        }
        if (dc.renderType != 1) {
            str = str + SplashMonitorInfo.TEMPLATE_RENER_TYPE_ERROR;
            i = dc.renderType;
        } else {
            i = -1;
            z2 = z;
        }
        if (!z2) {
            return;
        }
        com.kwad.sdk.commercial.a.m(new SplashMonitorInfo().setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }

    public static void ac(AdTemplate adTemplate) {
        AdInfo dP = e.dP(adTemplate);
        com.kwad.sdk.commercial.a.k(new SplashMonitorInfo().setStatus(3001).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setUrl(com.kwad.sdk.core.response.b.a.aU(dP).materialUrl).setAdTemplate(adTemplate));
    }

    public static void ad(AdTemplate adTemplate) {
        AdInfo dP = e.dP(adTemplate);
        com.kwad.sdk.commercial.a.k(new SplashMonitorInfo().setStatus(3002).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setUrl(com.kwad.sdk.core.response.b.a.aU(dP).materialUrl).setAdTemplate(adTemplate));
    }

    public static void ae(AdTemplate adTemplate) {
        AdInfo dP = e.dP(adTemplate);
        com.kwad.sdk.commercial.a.k(new SplashMonitorInfo().setStatus(3003).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setUrl(com.kwad.sdk.core.response.b.a.aU(dP).materialUrl).setAdTemplate(adTemplate));
    }

    public static void b(int i, String str, long j) {
        com.kwad.sdk.commercial.a.i(new SplashMonitorInfo().setStatus(3).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void b(boolean z, int i, String str, long j) {
        int i2;
        SplashMonitorInfo status = new SplashMonitorInfo().setStatus(4);
        if (z) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        com.kwad.sdk.commercial.a.n(status.setType(i2).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void c(boolean z, int i, String str, long j) {
        int i2;
        SplashMonitorInfo status = new SplashMonitorInfo().setStatus(4);
        if (z) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        com.kwad.sdk.commercial.a.h(status.setType(i2).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void d(@NonNull AdTemplate adTemplate, int i, String str) {
        String str2;
        AdInfo dP = e.dP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(dP)) {
            str2 = com.kwad.sdk.core.response.b.a.K(dP);
        } else {
            str2 = com.kwad.sdk.core.response.b.a.aU(dP).materialUrl;
        }
        int i2 = 2;
        SplashMonitorInfo errorMsg = new SplashMonitorInfo().setStatus(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setUrl(str2).setErrorCode(i).setErrorMsg(str);
        if (com.kwad.sdk.core.response.b.a.bc(dP)) {
            i2 = 1;
        }
        com.kwad.sdk.commercial.a.g(true, errorMsg.setMaterialType(i2).setType(1).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, int i, String str) {
        int i2;
        String K;
        AdInfo dP = e.dP(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(dP);
        SplashMonitorInfo preloadId = new SplashMonitorInfo().setStatus(3).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP));
        if (bd) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        SplashMonitorInfo type = preloadId.setType(i2);
        if (bd) {
            K = com.kwad.sdk.core.response.b.a.aU(dP).materialUrl;
        } else {
            K = com.kwad.sdk.core.response.b.a.K(dP);
        }
        com.kwad.sdk.commercial.a.k(type.setUrl(K).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void f(long j, long j2) {
        long j3;
        SplashMonitorInfo beforeLoadDataTime = new SplashMonitorInfo().setStatus(11).setBeforeLoadDataTime(j2);
        if (d.a(com.kwad.components.ad.splashscreen.b.a.CP)) {
            j3 = 1;
        } else {
            j3 = 2;
        }
        com.kwad.sdk.commercial.a.h(beforeLoadDataTime.setLoadProcessType(j3).setPosId(j));
    }

    public static void f(@NonNull AdTemplate adTemplate, long j) {
        long j2;
        AdInfo dP = e.dP(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(dP);
        int i = 2;
        SplashMonitorInfo status = new SplashMonitorInfo().setStatus(2);
        if (!bd) {
            i = 1;
        }
        SplashMonitorInfo preloadId = status.setType(i).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP));
        if (d.a(com.kwad.components.ad.splashscreen.b.a.CP)) {
            j2 = 1;
        } else {
            j2 = 2;
        }
        com.kwad.sdk.commercial.a.k(preloadId.setLoadProcessType(j2).setAdTemplate(adTemplate));
    }

    public final void c(AdTemplate adTemplate, String str) {
        long di;
        StyleTemplate S = S(adTemplate);
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(103).setTkRenderType(com.kwad.sdk.core.response.b.b.de(adTemplate)).setTemplateId(S.templateId).setTemplateVersionCode(S.templateVersionCode);
        e.dP(adTemplate);
        if (h.U(adTemplate)) {
            di = com.kwad.sdk.core.response.b.b.dd(adTemplate);
        } else {
            di = com.kwad.sdk.core.response.b.b.di(e.dP(adTemplate));
        }
        com.kwad.sdk.commercial.a.k(templateVersionCode.setTkDefaultTimeout(di).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public final void d(AdTemplate adTemplate, String str) {
        long di;
        StyleTemplate S = S(adTemplate);
        SplashMonitorInfo errorMsg = new SplashMonitorInfo().setStatus(105).setTemplateId(S.templateId).setTemplateVersionCode(S.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.de(adTemplate)).setErrorMsg(str);
        e.dP(adTemplate);
        if (h.U(adTemplate)) {
            di = com.kwad.sdk.core.response.b.b.dd(adTemplate);
        } else {
            di = com.kwad.sdk.core.response.b.b.di(e.dP(adTemplate));
        }
        com.kwad.sdk.commercial.a.k(errorMsg.setTkDefaultTimeout(di).setAdTemplate(adTemplate));
    }

    public static void g(@NonNull AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.b.a.J(e.dP(adTemplate))));
            arrayList2.add(com.kwad.sdk.core.response.b.a.aZ(e.dP(adTemplate)));
        }
        com.kwad.sdk.commercial.a.j(new SplashMonitorInfo().setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).setPosId(adResultData.getPosId()));
    }
}
