package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class a {
    private final String audioKey;
    private final int pZA;
    private final int pZB;
    private Integer pZC;
    private Integer pZD;
    private final int pZz;
    private final int startTime;

    public final int eCZ() {
        return this.pZz;
    }

    public final int eDa() {
        return this.pZA;
    }

    public final Integer eDb() {
        return this.pZC;
    }

    public final void v(Integer num) {
        this.pZC = num;
    }

    public final Integer eDc() {
        return this.pZD;
    }

    public final void w(Integer num) {
        this.pZD = num;
    }

    public a(AudioEntity audioEntity) {
        p.o(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pZz = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.pZA = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.pZB = num4 != null ? num4.intValue() : 0;
    }
}
