package com.kwad.sdk.commercial.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.net.URL;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.commercial.d.a {
    public String anF;
    public String anG;
    public String anH;
    public long anI;
    public long anJ;
    public int anK;
    public int anL;
    public String downloadId;
    public long downloadTime;
    public int status;
    public String url;

    public static b zR() {
        return new b();
    }

    public final b Y(long j) {
        this.downloadTime = j;
        return this;
    }

    public final b bX(int i) {
        this.status = i;
        return this;
    }

    public final b bY(int i) {
        this.anK = i;
        return this;
    }

    public final b bZ(int i) {
        this.anL = i;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.commercial.d.a
    /* renamed from: bc */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        AdInfo dP = e.dP(adTemplate);
        this.url = e.dS(adTemplate);
        try {
            this.anF = new URL(this.url).getHost();
        } catch (Throwable unused) {
        }
        this.downloadId = dP.downloadId;
        AdInfo.AdBaseInfo adBaseInfo = dP.adBaseInfo;
        this.anG = adBaseInfo.appPackageName;
        this.anH = adBaseInfo.appName;
        this.anI = dP.totalBytes;
        this.anJ = dP.soFarBytes;
        return this;
    }
}
