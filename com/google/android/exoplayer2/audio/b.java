package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
/* loaded from: classes5.dex */
public final class b {
    public static final b lZO = new a().dsx();
    public final int flags;
    public final int lZP;
    private AudioAttributes lZQ;
    public final int lf;

    /* loaded from: classes5.dex */
    public static final class a {
        private int lf = 0;
        private int flags = 0;
        private int lZP = 1;

        public b dsx() {
            return new b(this.lf, this.flags, this.lZP);
        }
    }

    private b(int i, int i2, int i3) {
        this.lf = i;
        this.flags = i2;
        this.lZP = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public AudioAttributes dsw() {
        if (this.lZQ == null) {
            this.lZQ = new AudioAttributes.Builder().setContentType(this.lf).setFlags(this.flags).setUsage(this.lZP).build();
        }
        return this.lZQ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.lf == bVar.lf && this.flags == bVar.flags && this.lZP == bVar.lZP;
    }

    public int hashCode() {
        return ((((this.lf + 527) * 31) + this.flags) * 31) + this.lZP;
    }
}
