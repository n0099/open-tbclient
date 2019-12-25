package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.u;
/* loaded from: classes4.dex */
public final class f {
    private int hashCode;
    public final long length;
    private final String mqB;
    public final long start;

    public f(String str, long j, long j2) {
        this.mqB = str == null ? "" : str;
        this.start = j;
        this.length = j2;
    }

    public Uri Pi(String str) {
        return u.fi(str, this.mqB);
    }

    public String Pj(String str) {
        return u.fj(str, this.mqB);
    }

    public f a(f fVar, String str) {
        f fVar2 = null;
        String Pj = Pj(str);
        if (fVar != null && Pj.equals(fVar.Pj(str))) {
            if (this.length != -1 && this.start + this.length == fVar.start) {
                fVar2 = new f(Pj, this.start, fVar.length != -1 ? this.length + fVar.length : -1L);
            } else if (fVar.length != -1 && fVar.start + fVar.length == this.start) {
                fVar2 = new f(Pj, fVar.start, this.length != -1 ? fVar.length + this.length : -1L);
            }
        }
        return fVar2;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((int) this.start) + 527) * 31) + ((int) this.length)) * 31) + this.mqB.hashCode();
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
        f fVar = (f) obj;
        return this.start == fVar.start && this.length == fVar.length && this.mqB.equals(fVar.mqB);
    }
}
