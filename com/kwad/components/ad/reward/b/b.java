package com.kwad.components.ad.reward.b;

import com.ksad.json.annotation.KsJson;
@KsJson
/* loaded from: classes9.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public static int STATUS_NONE = 2;
    public static int oJ = 1;
    public static int oK = 3;
    public int oL;
    public int oM;

    public b() {
        this.oL = STATUS_NONE;
    }

    public b(int i) {
        this.oL = STATUS_NONE;
        this.oL = 1;
    }

    public final void N(int i) {
        this.oM = i;
    }

    public final int getType() {
        return this.oL;
    }

    public final int gs() {
        return this.oM;
    }
}
