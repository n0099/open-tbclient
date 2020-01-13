package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.q;
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int nli;
    private final int nlj;
    private final int nlk;
    private Integer nll;
    private Integer nlm;
    private final int startTime;

    public final int dDY() {
        return this.nli;
    }

    public final int dDZ() {
        return this.nlj;
    }

    public final Integer dEa() {
        return this.nll;
    }

    public final void r(Integer num) {
        this.nll = num;
    }

    public final Integer dEb() {
        return this.nlm;
    }

    public final void s(Integer num) {
        this.nlm = num;
    }

    public a(AudioEntity audioEntity) {
        q.j(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nli = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nlj = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nlk = num4 != null ? num4.intValue() : 0;
    }
}
