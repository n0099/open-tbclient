package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes16.dex */
public final class a {
    private final String audioKey;
    private final int oom;
    private final int oon;
    private final int ooo;
    private Integer oop;
    private Integer ooq;
    private final int startTime;

    public final int efF() {
        return this.oom;
    }

    public final int efG() {
        return this.oon;
    }

    public final Integer efH() {
        return this.oop;
    }

    public final void r(Integer num) {
        this.oop = num;
    }

    public final Integer efI() {
        return this.ooq;
    }

    public final void s(Integer num) {
        this.ooq = num;
    }

    public a(AudioEntity audioEntity) {
        q.m(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.oom = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.oon = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.ooo = num4 != null ? num4.intValue() : 0;
    }
}
