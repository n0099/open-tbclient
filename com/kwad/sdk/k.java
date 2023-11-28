package com.kwad.sdk;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.utils.ay;
/* loaded from: classes10.dex */
public final class k {
    public static int akD;

    public static void U(long j) {
        final long j2;
        if (j > 0) {
            j2 = System.currentTimeMillis() - j;
        } else {
            j2 = -1;
        }
        akD++;
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.k.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.commercial.a.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aSd, new SDKInitMsg().setLaunchIntervalTime(j2).setInitCount(k.akD).setInitStatus(0));
            }
        });
    }

    public static void V(final long j) {
        if (j > 10000) {
            j = -1;
        }
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.k.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.commercial.a.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aSd, new SDKInitMsg().setTotalDurationTime(j).setInitCount(k.akD).setInitStatus(1));
            }
        });
    }

    public static void a(final com.kwai.adclient.kscommerciallogger.model.d dVar, final String str) {
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.k.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.commercial.a.a(ILoggerReporter.Category.ERROR_LOG, com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(k.akD).setErrorReason(str).setInitStatus(2));
            }
        });
    }
}
