package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
@KsJson
/* loaded from: classes10.dex */
public class g extends com.kwad.sdk.core.response.a.a {
    public String ayN;
    public String ayO;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    public static g DW() {
        return new g();
    }

    public final g dS(String str) {
        this.ayN = str;
        return this;
    }
}
