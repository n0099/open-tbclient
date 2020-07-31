package com.kascend.chushou.player.adapter;

import android.support.annotation.Keep;
import kotlin.h;
@Keep
@h
/* loaded from: classes6.dex */
public final class DanmuAtSpan {
    private final int end;
    private final int start;

    public static /* synthetic */ DanmuAtSpan copy$default(DanmuAtSpan danmuAtSpan, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = danmuAtSpan.start;
        }
        if ((i3 & 2) != 0) {
            i2 = danmuAtSpan.end;
        }
        return danmuAtSpan.copy(i, i2);
    }

    public final int component1() {
        return this.start;
    }

    public final int component2() {
        return this.end;
    }

    public final DanmuAtSpan copy(int i, int i2) {
        return new DanmuAtSpan(i, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof DanmuAtSpan)) {
                return false;
            }
            DanmuAtSpan danmuAtSpan = (DanmuAtSpan) obj;
            if (!(this.start == danmuAtSpan.start)) {
                return false;
            }
            if (!(this.end == danmuAtSpan.end)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return (this.start * 31) + this.end;
    }

    public String toString() {
        return "DanmuAtSpan(start=" + this.start + ", end=" + this.end + ")";
    }

    public DanmuAtSpan(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getEnd() {
        return this.end;
    }
}
