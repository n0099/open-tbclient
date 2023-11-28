package com.kwad.sdk.commercial.d;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
@KsJson
/* loaded from: classes10.dex */
public abstract class a extends com.kwad.sdk.core.response.a.a {
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public long llsid;
    public long posId;
    public String templateId;
    public String templateVersion;

    public a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        this.creativeId = e.dZ(adTemplate);
        this.llsid = e.dM(adTemplate);
        this.posId = e.dI(adTemplate);
        AdMatrixInfo.MatrixTemplate aT = com.kwad.sdk.commercial.c.aT(adTemplate);
        if (aT != null) {
            this.templateId = aT.templateId;
            this.templateVersion = aT.templateVersion;
        }
        return this;
    }

    public a setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public a setLlsid(long j) {
        this.llsid = j;
        return this;
    }

    public a setPosId(long j) {
        this.posId = j;
        return this;
    }
}
