package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes15.dex */
public final class a {
    private final String audioKey;
    private final int oDE;
    private final int oDF;
    private final int oDG;
    private Integer oDH;
    private Integer oDI;
    private final int startTime;

    public final int ejq() {
        return this.oDE;
    }

    public final int ejr() {
        return this.oDF;
    }

    public final Integer ejs() {
        return this.oDH;
    }

    public final void t(Integer num) {
        this.oDH = num;
    }

    public final Integer ejt() {
        return this.oDI;
    }

    public final void u(Integer num) {
        this.oDI = num;
    }

    public a(AudioEntity audioEntity) {
        q.n(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.oDE = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.oDF = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.oDG = num4 != null ? num4.intValue() : 0;
    }
}
