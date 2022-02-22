package com.kwad.sdk.core.report;

import com.kwad.sdk.core.network.BaseResultData;
/* loaded from: classes4.dex */
public class ReportResultData extends BaseResultData implements com.kwad.sdk.core.b {
    public static final int CODE_RESULT_CHEATING_FLOW = 110009;

    public boolean isCheatingFlow() {
        return this.result == 110009;
    }
}
