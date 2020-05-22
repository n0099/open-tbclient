package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int neF;
    private final int neG;
    private final int neH;
    private Integer neI;
    private Integer neJ;
    private final int startTime;

    public final int dHd() {
        return this.neF;
    }

    public final int dHe() {
        return this.neG;
    }

    public final Integer dHf() {
        return this.neI;
    }

    public final void r(Integer num) {
        this.neI = num;
    }

    public final Integer dHg() {
        return this.neJ;
    }

    public final void s(Integer num) {
        this.neJ = num;
    }

    public a(AudioEntity audioEntity) {
        q.m(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.neF = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.neG = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.neH = num4 != null ? num4.intValue() : 0;
    }
}
