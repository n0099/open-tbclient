package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class t {
    private int hashCode;
    public final int length;
    private final Format[] mrI;

    public t(Format... formatArr) {
        com.google.android.exoplayer2.util.a.checkState(formatArr.length > 0);
        this.mrI = formatArr;
        this.length = formatArr.length;
    }

    public Format KL(int i) {
        return this.mrI[i];
    }

    public int m(Format format) {
        for (int i = 0; i < this.mrI.length; i++) {
            if (format == this.mrI[i]) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.mrI) + 527;
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        return this.length == tVar.length && Arrays.equals(this.mrI, tVar.mrI);
    }
}
