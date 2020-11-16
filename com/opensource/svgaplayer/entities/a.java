package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes17.dex */
public final class a {
    private final String audioKey;
    private final int pFX;
    private final int pFY;
    private final int pFZ;
    private Integer pGa;
    private Integer pGb;
    private final int startTime;

    public final int exg() {
        return this.pFX;
    }

    public final int exh() {
        return this.pFY;
    }

    public final Integer exi() {
        return this.pGa;
    }

    public final void t(Integer num) {
        this.pGa = num;
    }

    public final Integer exj() {
        return this.pGb;
    }

    public final void u(Integer num) {
        this.pGb = num;
    }

    public a(AudioEntity audioEntity) {
        q.n(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pFX = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.pFY = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.pFZ = num4 != null ? num4.intValue() : 0;
    }
}
