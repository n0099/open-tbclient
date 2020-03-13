package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
/* loaded from: classes6.dex */
public final class b {
    public static final b maP = new a().dtN();
    public final int contentType;
    public final int flags;
    public final int maQ;
    private AudioAttributes maR;

    /* loaded from: classes6.dex */
    public static final class a {
        private int contentType = 0;
        private int flags = 0;
        private int maQ = 1;

        public b dtN() {
            return new b(this.contentType, this.flags, this.maQ);
        }
    }

    private b(int i, int i2, int i3) {
        this.contentType = i;
        this.flags = i2;
        this.maQ = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public AudioAttributes dtM() {
        if (this.maR == null) {
            this.maR = new AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.maQ).build();
        }
        return this.maR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.contentType == bVar.contentType && this.flags == bVar.flags && this.maQ == bVar.maQ;
    }

    public int hashCode() {
        return ((((this.contentType + 527) * 31) + this.flags) * 31) + this.maQ;
    }
}
