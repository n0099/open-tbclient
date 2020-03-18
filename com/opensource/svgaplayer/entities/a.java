package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int nnO;
    private final int nnP;
    private final int nnQ;
    private Integer nnR;
    private Integer nnS;
    private final int startTime;

    public final int dFK() {
        return this.nnO;
    }

    public final int dFL() {
        return this.nnP;
    }

    public final Integer dFM() {
        return this.nnR;
    }

    public final void r(Integer num) {
        this.nnR = num;
    }

    public final Integer dFN() {
        return this.nnS;
    }

    public final void s(Integer num) {
        this.nnS = num;
    }

    public a(AudioEntity audioEntity) {
        q.j(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nnO = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nnP = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nnQ = num4 != null ? num4.intValue() : 0;
    }
}
