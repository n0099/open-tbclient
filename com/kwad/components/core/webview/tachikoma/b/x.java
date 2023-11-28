package com.kwad.components.core.webview.tachikoma.b;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
@KsJson
/* loaded from: classes10.dex */
public class x extends com.kwad.sdk.core.response.a.a {
    public String aaj;
    public int errorCode;
    public String errorReason;
    public int nD;

    public final boolean isFailed() {
        return TextUtils.equals("failed", this.aaj);
    }

    public final boolean sH() {
        return TextUtils.equals("start", this.aaj);
    }

    public final boolean sI() {
        return TextUtils.equals("end", this.aaj);
    }

    public final boolean sJ() {
        return TextUtils.equals("progress", this.aaj);
    }

    public final int sK() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return 0;
        }
    }
}
