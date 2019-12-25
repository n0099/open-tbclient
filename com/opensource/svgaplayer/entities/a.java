package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
public final class a {
    private final String audioKey;
    private final int mLG;
    private final int mLH;
    private final int mLI;
    private Integer mLJ;
    private Integer mLK;
    private final int startTime;

    public final int dAf() {
        return this.mLG;
    }

    public final int dAg() {
        return this.mLH;
    }

    public final Integer dAh() {
        return this.mLJ;
    }

    public final void r(Integer num) {
        this.mLJ = num;
    }

    public final Integer dAi() {
        return this.mLK;
    }

    public final void s(Integer num) {
        this.mLK = num;
    }

    public a(AudioEntity audioEntity) {
        p.j(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.mLG = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.mLH = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.mLI = num4 != null ? num4.intValue() : 0;
    }
}
