package com.kwad.sdk.core.report.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.ReportAction;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends e {
    public a(List<ReportAction> list) {
        super(list);
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return d.b() + d.h();
    }

    @Override // com.kwad.sdk.core.network.b
    public String f() {
        return d.b();
    }

    @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
    public void h() {
        super.h();
        b("kpn", "kseulivesdk");
        b("subBiz", KsAdSDKImpl.get().getAppId());
    }
}
