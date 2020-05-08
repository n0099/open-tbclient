package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class a {
    private final String audioKey;
    private final int mKB;
    private final int mKC;
    private final int mKD;
    private Integer mKE;
    private Integer mKF;
    private final int startTime;

    public final int dzJ() {
        return this.mKB;
    }

    public final int dzK() {
        return this.mKC;
    }

    public final Integer dzL() {
        return this.mKE;
    }

    public final void q(Integer num) {
        this.mKE = num;
    }

    public final Integer dzM() {
        return this.mKF;
    }

    public final void r(Integer num) {
        this.mKF = num;
    }

    public a(AudioEntity audioEntity) {
        q.j(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.mKB = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.mKC = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.mKD = num4 != null ? num4.intValue() : 0;
    }
}
