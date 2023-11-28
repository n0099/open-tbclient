package com.kwad.components.core.n;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
/* loaded from: classes10.dex */
public final class a {
    public static void ar(int i) {
        com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("offline_component_performance", "load_status").u(new b().as(i).z(1L)).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void b(int i, long j) {
        com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("offline_component_performance", "load_status").u(new b().as(i).z(2L).A(j)).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }
}
