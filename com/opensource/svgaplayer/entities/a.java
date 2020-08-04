package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes8.dex */
public final class a {
    private final String audioKey;
    private final int nKs;
    private final int nKt;
    private final int nKu;
    private Integer nKv;
    private Integer nKw;
    private final int startTime;

    public final int dPx() {
        return this.nKs;
    }

    public final int dPy() {
        return this.nKt;
    }

    public final Integer dPz() {
        return this.nKv;
    }

    public final void q(Integer num) {
        this.nKv = num;
    }

    public final Integer dPA() {
        return this.nKw;
    }

    public final void r(Integer num) {
        this.nKw = num;
    }

    public a(AudioEntity audioEntity) {
        q.m(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nKs = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nKt = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nKu = num4 != null ? num4.intValue() : 0;
    }
}
