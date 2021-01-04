package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class a {
    private final String audioKey;
    private final int pSm;
    private final int pSn;
    private final int pSo;
    private Integer pSp;
    private Integer pSq;
    private final int startTime;

    public final int eDW() {
        return this.pSm;
    }

    public final int eDX() {
        return this.pSn;
    }

    public final Integer eDY() {
        return this.pSp;
    }

    public final void v(Integer num) {
        this.pSp = num;
    }

    public final Integer eDZ() {
        return this.pSq;
    }

    public final void w(Integer num) {
        this.pSq = num;
    }

    public a(AudioEntity audioEntity) {
        p.o(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pSm = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.pSn = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.pSo = num4 != null ? num4.intValue() : 0;
    }
}
