package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes15.dex */
public final class a {
    private final String audioKey;
    private final int pva;
    private final int pvb;
    private final int pvc;
    private Integer pvd;
    private Integer pve;
    private final int startTime;

    public final int etq() {
        return this.pva;
    }

    public final int etr() {
        return this.pvb;
    }

    public final Integer ets() {
        return this.pvd;
    }

    public final void t(Integer num) {
        this.pvd = num;
    }

    public final Integer ett() {
        return this.pve;
    }

    public final void u(Integer num) {
        this.pve = num;
    }

    public a(AudioEntity audioEntity) {
        q.n(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pva = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.pvb = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.pvc = num4 != null ? num4.intValue() : 0;
    }
}
