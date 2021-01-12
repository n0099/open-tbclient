package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
public final class a {
    private final String audioKey;
    private final int pPu;
    private final int pPv;
    private final int pPw;
    private Integer pPx;
    private Integer pPy;
    private final int startTime;

    public final int eAI() {
        return this.pPu;
    }

    public final int eAJ() {
        return this.pPv;
    }

    public final Integer eAK() {
        return this.pPx;
    }

    public final void v(Integer num) {
        this.pPx = num;
    }

    public final Integer eAL() {
        return this.pPy;
    }

    public final void w(Integer num) {
        this.pPy = num;
    }

    public a(AudioEntity audioEntity) {
        p.o(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pPu = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.pPv = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.pPw = num4 != null ? num4.intValue() : 0;
    }
}
