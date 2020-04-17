package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int mKA;
    private Integer mKB;
    private Integer mKC;
    private final int mKy;
    private final int mKz;
    private final int startTime;

    public final int dzN() {
        return this.mKy;
    }

    public final int dzO() {
        return this.mKz;
    }

    public final Integer dzP() {
        return this.mKB;
    }

    public final void q(Integer num) {
        this.mKB = num;
    }

    public final Integer dzQ() {
        return this.mKC;
    }

    public final void r(Integer num) {
        this.mKC = num;
    }

    public a(AudioEntity audioEntity) {
        q.j(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.mKy = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.mKz = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.mKA = num4 != null ? num4.intValue() : 0;
    }
}
