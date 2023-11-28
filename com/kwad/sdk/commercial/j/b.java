package com.kwad.sdk.commercial.j;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.commercial.d.a {
    public String anD;
    public int anE;
    public String aof;
    public int aog;
    public int status;

    public static b Ad() {
        return new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.commercial.d.a
    /* renamed from: bD */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cA(String str) {
        this.aof = str;
        return this;
    }

    public final b cB(String str) {
        this.anD = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.commercial.d.a
    /* renamed from: cC */
    public final b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    public final b ci(int i) {
        this.status = i;
        return this;
    }

    public final b cj(int i) {
        this.anE = i;
        return this;
    }

    public final b ck(int i) {
        this.aog = i;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.commercial.d.a
    /* renamed from: cl */
    public final b setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }
}
