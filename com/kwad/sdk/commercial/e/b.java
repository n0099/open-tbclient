package com.kwad.sdk.commercial.e;

import com.ksad.json.annotation.KsJson;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.commercial.d.a {
    public int adNum;
    public String anV;
    public boolean anW;
    public boolean anX;

    public static b zU() {
        return new b();
    }

    public final b bj(boolean z) {
        this.anW = z;
        return this;
    }

    public final b bk(boolean z) {
        this.anX = z;
        return this;
    }

    public final b cd(int i) {
        this.adNum = i;
        return this;
    }

    public final b cq(String str) {
        this.anV = str;
        return this;
    }
}
