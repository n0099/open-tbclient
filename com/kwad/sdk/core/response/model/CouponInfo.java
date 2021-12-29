package com.kwad.sdk.core.response.model;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class CouponInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
    public static final long serialVersionUID = -9143537899646897962L;
    public String displayActionWords;
    public String displayBase;
    public String displayName;
    public String displayTitle;
    public String displayType;
    public String displayValue;

    public String getDisplayActionWords() {
        return this.displayActionWords;
    }

    public String getDisplayBase() {
        return this.displayBase;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDisplayTitle() {
        return this.displayTitle;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }
}
