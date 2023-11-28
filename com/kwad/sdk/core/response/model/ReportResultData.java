package com.kwad.sdk.core.response.model;
/* loaded from: classes10.dex */
public class ReportResultData extends BaseResultData implements com.kwad.sdk.core.b {
    public static final int CODE_RESULT_CHEATING_FLOW = 110009;
    public static final long serialVersionUID = 497410051317861756L;

    public boolean isCheatingFlow() {
        if (this.result == 110009) {
            return true;
        }
        return false;
    }
}
