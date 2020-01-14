package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
/* loaded from: classes5.dex */
public final class b {
    public static final b lZT = new a().dsz();
    public final int flags;
    public final int lZU;
    private AudioAttributes lZV;
    public final int lf;

    /* loaded from: classes5.dex */
    public static final class a {
        private int lf = 0;
        private int flags = 0;
        private int lZU = 1;

        public b dsz() {
            return new b(this.lf, this.flags, this.lZU);
        }
    }

    private b(int i, int i2, int i3) {
        this.lf = i;
        this.flags = i2;
        this.lZU = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public AudioAttributes dsy() {
        if (this.lZV == null) {
            this.lZV = new AudioAttributes.Builder().setContentType(this.lf).setFlags(this.flags).setUsage(this.lZU).build();
        }
        return this.lZV;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.lf == bVar.lf && this.flags == bVar.flags && this.lZU == bVar.lZU;
    }

    public int hashCode() {
        return ((((this.lf + 527) * 31) + this.flags) * 31) + this.lZU;
    }
}
