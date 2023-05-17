package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes9.dex */
public final class UtcTimingElement {
    public final String schemeIdUri;
    public final String value;

    public UtcTimingElement(String str, String str2) {
        this.schemeIdUri = str;
        this.value = str2;
    }

    public String toString() {
        return this.schemeIdUri + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.value;
    }
}
