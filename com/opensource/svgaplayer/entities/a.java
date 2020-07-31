package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes8.dex */
public final class a {
    private final String audioKey;
    private final int nKq;
    private final int nKr;
    private final int nKs;
    private Integer nKt;
    private Integer nKu;
    private final int startTime;

    public final int dPw() {
        return this.nKq;
    }

    public final int dPx() {
        return this.nKr;
    }

    public final Integer dPy() {
        return this.nKt;
    }

    public final void q(Integer num) {
        this.nKt = num;
    }

    public final Integer dPz() {
        return this.nKu;
    }

    public final void r(Integer num) {
        this.nKu = num;
    }

    public a(AudioEntity audioEntity) {
        q.m(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nKq = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nKr = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nKs = num4 != null ? num4.intValue() : 0;
    }
}
