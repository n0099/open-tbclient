package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class a {
    private final String audioKey;
    private final int pTU;
    private final int pTV;
    private final int pTW;
    private Integer pTX;
    private Integer pTY;
    private final int startTime;

    public final int eEA() {
        return this.pTU;
    }

    public final int eEB() {
        return this.pTV;
    }

    public final Integer eEC() {
        return this.pTX;
    }

    public final void v(Integer num) {
        this.pTX = num;
    }

    public final Integer eED() {
        return this.pTY;
    }

    public final void w(Integer num) {
        this.pTY = num;
    }

    public a(AudioEntity audioEntity) {
        p.o(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pTU = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.pTV = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.pTW = num4 != null ? num4.intValue() : 0;
    }
}
