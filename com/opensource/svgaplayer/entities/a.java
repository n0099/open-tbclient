package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int nfP;
    private final int nfQ;
    private final int nfR;
    private Integer nfS;
    private Integer nfT;
    private final int startTime;

    public final int dHr() {
        return this.nfP;
    }

    public final int dHs() {
        return this.nfQ;
    }

    public final Integer dHt() {
        return this.nfS;
    }

    public final void r(Integer num) {
        this.nfS = num;
    }

    public final Integer dHu() {
        return this.nfT;
    }

    public final void s(Integer num) {
        this.nfT = num;
    }

    public a(AudioEntity audioEntity) {
        q.m(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nfP = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nfQ = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nfR = num4 != null ? num4.intValue() : 0;
    }
}
