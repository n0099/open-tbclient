package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int nlO;
    private final int nlP;
    private final int nlQ;
    private Integer nlR;
    private Integer nlS;
    private final int startTime;

    public final int dFh() {
        return this.nlO;
    }

    public final int dFi() {
        return this.nlP;
    }

    public final Integer dFj() {
        return this.nlR;
    }

    public final void r(Integer num) {
        this.nlR = num;
    }

    public final Integer dFk() {
        return this.nlS;
    }

    public final void s(Integer num) {
        this.nlS = num;
    }

    public a(AudioEntity audioEntity) {
        q.j(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.nlO = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.nlP = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.nlQ = num4 != null ? num4.intValue() : 0;
    }
}
