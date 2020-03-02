package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
/* loaded from: classes6.dex */
public final class b {
    public static final b maE = new a().dtM();
    public final int contentType;
    public final int flags;
    public final int maF;
    private AudioAttributes maG;

    /* loaded from: classes6.dex */
    public static final class a {
        private int contentType = 0;
        private int flags = 0;
        private int maF = 1;

        public b dtM() {
            return new b(this.contentType, this.flags, this.maF);
        }
    }

    private b(int i, int i2, int i3) {
        this.contentType = i;
        this.flags = i2;
        this.maF = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public AudioAttributes dtL() {
        if (this.maG == null) {
            this.maG = new AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.maF).build();
        }
        return this.maG;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.contentType == bVar.contentType && this.flags == bVar.flags && this.maF == bVar.maF;
    }

    public int hashCode() {
        return ((((this.contentType + 527) * 31) + this.flags) * 31) + this.maF;
    }
}
