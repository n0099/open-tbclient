package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int nBI;
    private final int nBJ;
    private final int nBK;
    private Integer nBL;
    private Integer nBM;
    private final int startTime;

    public final int dMb() {
        return this.nBI;
    }

    public final int dMc() {
        return this.nBJ;
    }

    public final Integer dMd() {
        return this.nBL;
    }

    public final void r(Integer num) {
        this.nBL = num;
    }

    public final Integer dMe() {
        return this.nBM;
    }

    public final void s(Integer num) {
        this.nBM = num;
    }

    public a(AudioEntity audioEntity) {
        q.m(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nBI = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nBJ = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nBK = num4 != null ? num4.intValue() : 0;
    }
}
