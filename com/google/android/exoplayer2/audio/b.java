package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
/* loaded from: classes4.dex */
public final class b {
    public static final b lVZ = new a().drl();
    public final int flags;
    public final int lWa;
    private AudioAttributes lWb;
    public final int li;

    /* loaded from: classes4.dex */
    public static final class a {
        private int li = 0;
        private int flags = 0;
        private int lWa = 1;

        public b drl() {
            return new b(this.li, this.flags, this.lWa);
        }
    }

    private b(int i, int i2, int i3) {
        this.li = i;
        this.flags = i2;
        this.lWa = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public AudioAttributes drk() {
        if (this.lWb == null) {
            this.lWb = new AudioAttributes.Builder().setContentType(this.li).setFlags(this.flags).setUsage(this.lWa).build();
        }
        return this.lWb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.li == bVar.li && this.flags == bVar.flags && this.lWa == bVar.lWa;
    }

    public int hashCode() {
        return ((((this.li + 527) * 31) + this.flags) * 31) + this.lWa;
    }
}
