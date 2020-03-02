package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int nlQ;
    private final int nlR;
    private final int nlS;
    private Integer nlT;
    private Integer nlU;
    private final int startTime;

    public final int dFj() {
        return this.nlQ;
    }

    public final int dFk() {
        return this.nlR;
    }

    public final Integer dFl() {
        return this.nlT;
    }

    public final void r(Integer num) {
        this.nlT = num;
    }

    public final Integer dFm() {
        return this.nlU;
    }

    public final void s(Integer num) {
        this.nlU = num;
    }

    public a(AudioEntity audioEntity) {
        q.j(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nlQ = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nlR = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nlS = num4 != null ? num4.intValue() : 0;
    }
}
