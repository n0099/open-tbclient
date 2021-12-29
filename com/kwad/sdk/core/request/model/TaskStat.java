package com.kwad.sdk.core.request.model;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class TaskStat extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
    public int adStyle;
    public int count;
    public int taskType;

    public TaskStat() {
    }

    public TaskStat(int i2, int i3, int i4) {
        this.adStyle = i2;
        this.taskType = i3;
        this.count = i4;
    }
}
