package com.kwad.sdk.crash.report.request;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends d {
    public a(List<ReportEvent> list) {
        a("eventList", list);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.q();
    }
}
