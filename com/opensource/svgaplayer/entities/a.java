package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int nBF;
    private final int nBG;
    private final int nBH;
    private Integer nBI;
    private Integer nBJ;
    private final int startTime;

    public final int dLX() {
        return this.nBF;
    }

    public final int dLY() {
        return this.nBG;
    }

    public final Integer dLZ() {
        return this.nBI;
    }

    public final void r(Integer num) {
        this.nBI = num;
    }

    public final Integer dMa() {
        return this.nBJ;
    }

    public final void s(Integer num) {
        this.nBJ = num;
    }

    public a(AudioEntity audioEntity) {
        q.m(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nBF = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nBG = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nBH = num4 != null ? num4.intValue() : 0;
    }
}
