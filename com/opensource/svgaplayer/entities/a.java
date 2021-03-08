package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
public final class a {
    private final String audioKey;
    private final int qaN;
    private final int qaO;
    private final int qaP;
    private Integer qaQ;
    private Integer qaR;
    private final int startTime;

    public final int eDn() {
        return this.qaN;
    }

    public final int eDo() {
        return this.qaO;
    }

    public final Integer eDp() {
        return this.qaQ;
    }

    public final void v(Integer num) {
        this.qaQ = num;
    }

    public final Integer eDq() {
        return this.qaR;
    }

    public final void w(Integer num) {
        this.qaR = num;
    }

    public a(AudioEntity audioEntity) {
        p.p(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.qaN = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.qaO = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.qaP = num4 != null ? num4.intValue() : 0;
    }
}
