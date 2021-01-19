package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
public final class a {
    private final String audioKey;
    private final int pPv;
    private final int pPw;
    private final int pPx;
    private Integer pPy;
    private Integer pPz;
    private final int startTime;

    public final int eAI() {
        return this.pPv;
    }

    public final int eAJ() {
        return this.pPw;
    }

    public final Integer eAK() {
        return this.pPy;
    }

    public final void v(Integer num) {
        this.pPy = num;
    }

    public final Integer eAL() {
        return this.pPz;
    }

    public final void w(Integer num) {
        this.pPz = num;
    }

    public a(AudioEntity audioEntity) {
        p.o(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pPv = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.pPw = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.pPx = num4 != null ? num4.intValue() : 0;
    }
}
