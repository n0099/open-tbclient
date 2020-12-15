package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes18.dex */
public final class a {
    private final String audioKey;
    private final int pzF;
    private final int pzG;
    private final int pzH;
    private Integer pzI;
    private Integer pzJ;
    private final int startTime;

    public final int eAe() {
        return this.pzF;
    }

    public final int eAf() {
        return this.pzG;
    }

    public final Integer eAg() {
        return this.pzI;
    }

    public final void t(Integer num) {
        this.pzI = num;
    }

    public final Integer eAh() {
        return this.pzJ;
    }

    public final void u(Integer num) {
        this.pzJ = num;
    }

    public a(AudioEntity audioEntity) {
        p.o(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pzF = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.pzG = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.pzH = num4 != null ? num4.intValue() : 0;
    }
}
