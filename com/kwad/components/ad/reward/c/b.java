package com.kwad.components.ad.reward.c;

import com.ksad.json.annotation.KsJson;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static int STATUS_NONE = 2;
    public static int rl = 1;
    public static int rm = 3;
    public int rn;
    public int ro;

    public b() {
        this.rn = STATUS_NONE;
    }

    public final int gM() {
        return this.ro;
    }

    public final int getType() {
        return this.rn;
    }

    public b(int i) {
        this.rn = STATUS_NONE;
        this.rn = 1;
    }

    public final void M(int i) {
        this.ro = i;
    }
}
