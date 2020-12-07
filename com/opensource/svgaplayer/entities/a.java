package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes18.dex */
public final class a {
    private final String audioKey;
    private final int pzD;
    private final int pzE;
    private final int pzF;
    private Integer pzG;
    private Integer pzH;
    private final int startTime;

    public final int eAd() {
        return this.pzD;
    }

    public final int eAe() {
        return this.pzE;
    }

    public final Integer eAf() {
        return this.pzG;
    }

    public final void t(Integer num) {
        this.pzG = num;
    }

    public final Integer eAg() {
        return this.pzH;
    }

    public final void u(Integer num) {
        this.pzH = num;
    }

    public a(AudioEntity audioEntity) {
        p.o(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pzD = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.pzE = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.pzF = num4 != null ? num4.intValue() : 0;
    }
}
