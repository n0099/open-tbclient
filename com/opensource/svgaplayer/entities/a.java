package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.q;
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int nln;
    private final int nlo;
    private final int nlp;
    private Integer nlq;
    private Integer nlr;
    private final int startTime;

    public final int dEa() {
        return this.nln;
    }

    public final int dEb() {
        return this.nlo;
    }

    public final Integer dEc() {
        return this.nlq;
    }

    public final void r(Integer num) {
        this.nlq = num;
    }

    public final Integer dEd() {
        return this.nlr;
    }

    public final void s(Integer num) {
        this.nlr = num;
    }

    public a(AudioEntity audioEntity) {
        q.j(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nln = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nlo = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nlp = num4 != null ? num4.intValue() : 0;
    }
}
