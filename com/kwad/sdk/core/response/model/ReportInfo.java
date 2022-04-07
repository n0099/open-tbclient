package com.kwad.sdk.core.response.model;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class ReportInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = 6025862320437448216L;
    public String content;
    public int reportId;

    public ReportInfo() {
    }

    public ReportInfo(int i, String str) {
        this.reportId = i;
        this.content = str;
    }
}
