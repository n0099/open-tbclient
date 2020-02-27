package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
/* loaded from: classes6.dex */
public final class b {
    public static final b maC = new a().dtK();
    public final int contentType;
    public final int flags;
    public final int maD;
    private AudioAttributes maE;

    /* loaded from: classes6.dex */
    public static final class a {
        private int contentType = 0;
        private int flags = 0;
        private int maD = 1;

        public b dtK() {
            return new b(this.contentType, this.flags, this.maD);
        }
    }

    private b(int i, int i2, int i3) {
        this.contentType = i;
        this.flags = i2;
        this.maD = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public AudioAttributes dtJ() {
        if (this.maE == null) {
            this.maE = new AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.maD).build();
        }
        return this.maE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.contentType == bVar.contentType && this.flags == bVar.flags && this.maD == bVar.maD;
    }

    public int hashCode() {
        return ((((this.contentType + 527) * 31) + this.flags) * 31) + this.maD;
    }
}
