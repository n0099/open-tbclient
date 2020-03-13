package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int nmb;
    private final int nmc;
    private final int nmd;
    private Integer nme;
    private Integer nmf;
    private final int startTime;

    public final int dFk() {
        return this.nmb;
    }

    public final int dFl() {
        return this.nmc;
    }

    public final Integer dFm() {
        return this.nme;
    }

    public final void r(Integer num) {
        this.nme = num;
    }

    public final Integer dFn() {
        return this.nmf;
    }

    public final void s(Integer num) {
        this.nmf = num;
    }

    public a(AudioEntity audioEntity) {
        q.j(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nmb = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nmc = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nmd = num4 != null ? num4.intValue() : 0;
    }
}
