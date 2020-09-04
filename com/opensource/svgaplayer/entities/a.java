package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class a {
    private final String audioKey;
    private final int oeD;
    private final int oeE;
    private final int oeF;
    private Integer oeG;
    private Integer oeH;
    private final int startTime;

    public final int ebI() {
        return this.oeD;
    }

    public final int ebJ() {
        return this.oeE;
    }

    public final Integer ebK() {
        return this.oeG;
    }

    public final void r(Integer num) {
        this.oeG = num;
    }

    public final Integer ebL() {
        return this.oeH;
    }

    public final void s(Integer num) {
        this.oeH = num;
    }

    public a(AudioEntity audioEntity) {
        q.m(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.oeD = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.oeE = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.oeF = num4 != null ? num4.intValue() : 0;
    }
}
