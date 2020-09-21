package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class b {
    private static final b nEs = dWn().dWv();
    public final int nEt;
    public final boolean nEu;
    public final boolean nEv;
    public final boolean nEw;
    public final boolean nEx;
    public final Bitmap.Config nEy;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b nEz;

    public b(c cVar) {
        this.nEt = cVar.dWo();
        this.nEu = cVar.dWp();
        this.nEv = cVar.dWq();
        this.nEw = cVar.dWr();
        this.nEx = cVar.dWt();
        this.nEy = cVar.dWu();
        this.nEz = cVar.dWs();
    }

    public static b dWm() {
        return nEs;
    }

    public static c dWn() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.nEu == bVar.nEu && this.nEv == bVar.nEv && this.nEw == bVar.nEw && this.nEx == bVar.nEx && this.nEy == bVar.nEy && this.nEz == bVar.nEz;
    }

    public int hashCode() {
        return (((((((this.nEw ? 1 : 0) + (((this.nEv ? 1 : 0) + (((this.nEu ? 1 : 0) + (this.nEt * 31)) * 31)) * 31)) * 31) + (this.nEx ? 1 : 0)) * 31) + this.nEy.ordinal()) * 31) + (this.nEz != null ? this.nEz.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.nEt), Boolean.valueOf(this.nEu), Boolean.valueOf(this.nEv), Boolean.valueOf(this.nEw), Boolean.valueOf(this.nEx), this.nEy.name(), this.nEz);
    }
}
