package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes8.dex */
public class b {
    private static final b nuc = dSg().dSo();
    public final int nud;
    public final boolean nue;
    public final boolean nuf;
    public final boolean nug;
    public final boolean nuh;
    public final Bitmap.Config nui;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b nuj;

    public b(c cVar) {
        this.nud = cVar.dSh();
        this.nue = cVar.dSi();
        this.nuf = cVar.dSj();
        this.nug = cVar.dSk();
        this.nuh = cVar.dSm();
        this.nui = cVar.dSn();
        this.nuj = cVar.dSl();
    }

    public static b dSf() {
        return nuc;
    }

    public static c dSg() {
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
        return this.nue == bVar.nue && this.nuf == bVar.nuf && this.nug == bVar.nug && this.nuh == bVar.nuh && this.nui == bVar.nui && this.nuj == bVar.nuj;
    }

    public int hashCode() {
        return (((((((this.nug ? 1 : 0) + (((this.nuf ? 1 : 0) + (((this.nue ? 1 : 0) + (this.nud * 31)) * 31)) * 31)) * 31) + (this.nuh ? 1 : 0)) * 31) + this.nui.ordinal()) * 31) + (this.nuj != null ? this.nuj.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.nud), Boolean.valueOf(this.nue), Boolean.valueOf(this.nuf), Boolean.valueOf(this.nug), Boolean.valueOf(this.nuh), this.nui.name(), this.nuj);
    }
}
