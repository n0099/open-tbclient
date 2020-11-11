package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes15.dex */
public final class a {
    private final String audioKey;
    private final int pEu;
    private final int pEv;
    private final int pEw;
    private Integer pEx;
    private Integer pEy;
    private final int startTime;

    public final int exf() {
        return this.pEu;
    }

    public final int exg() {
        return this.pEv;
    }

    public final Integer exh() {
        return this.pEx;
    }

    public final void t(Integer num) {
        this.pEx = num;
    }

    public final Integer exi() {
        return this.pEy;
    }

    public final void u(Integer num) {
        this.pEy = num;
    }

    public a(AudioEntity audioEntity) {
        q.n(audioEntity, "audioItem");
        this.audioKey = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.pEu = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.pEv = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.startTime = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.pEw = num4 != null ? num4.intValue() : 0;
    }
}
