package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class a {
    private final String audioKey;
    private final int pZZ;
    private final int qaa;
    private final int qab;
    private Integer qac;
    private Integer qad;
    private final int startTime;

    public final int eDh() {
        return this.pZZ;
    }

    public final int eDi() {
        return this.qaa;
    }

    public final Integer eDj() {
        return this.qac;
    }

    public final void v(Integer num) {
        this.qac = num;
    }

    public final Integer eDk() {
        return this.qad;
    }

    public final void w(Integer num) {
        this.qad = num;
    }

    public a(AudioEntity audioEntity) {
        p.o(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pZZ = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.qaa = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.qab = num4 != null ? num4.intValue() : 0;
    }
}
