package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class a {
    private final String audioKey;
    private final int oel;
    private final int oem;
    private final int oen;
    private Integer oeo;
    private Integer oep;
    private final int startTime;

    public final int ebz() {
        return this.oel;
    }

    public final int ebA() {
        return this.oem;
    }

    public final Integer ebB() {
        return this.oeo;
    }

    public final void r(Integer num) {
        this.oeo = num;
    }

    public final Integer ebC() {
        return this.oep;
    }

    public final void s(Integer num) {
        this.oep = num;
    }

    public a(AudioEntity audioEntity) {
        q.m(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.oel = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.oem = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.oen = num4 != null ? num4.intValue() : 0;
    }
}
