package com.kwad.sdk.core.request.model;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class TaskStat extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
    public int adStyle;
    public int count;
    public int taskType;

    public TaskStat() {
    }

    public TaskStat(int i, int i2, int i3) {
        this.adStyle = i;
        this.taskType = i2;
        this.count = i3;
    }
}
