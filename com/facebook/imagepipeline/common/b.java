package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes3.dex */
public class b {
    private static final b nan = dGh().dGp();
    public final int nao;
    public final boolean nap;
    public final boolean naq;
    public final boolean nar;
    public final boolean nas;
    public final Bitmap.Config nat;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b nau;

    public b(c cVar) {
        this.nao = cVar.dGi();
        this.nap = cVar.dGj();
        this.naq = cVar.dGk();
        this.nar = cVar.dGl();
        this.nas = cVar.dGn();
        this.nat = cVar.dGo();
        this.nau = cVar.dGm();
    }

    public static b dGg() {
        return nan;
    }

    public static c dGh() {
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
        return this.nap == bVar.nap && this.naq == bVar.naq && this.nar == bVar.nar && this.nas == bVar.nas && this.nat == bVar.nat && this.nau == bVar.nau;
    }

    public int hashCode() {
        return (((((((this.nar ? 1 : 0) + (((this.naq ? 1 : 0) + (((this.nap ? 1 : 0) + (this.nao * 31)) * 31)) * 31)) * 31) + (this.nas ? 1 : 0)) * 31) + this.nat.ordinal()) * 31) + (this.nau != null ? this.nau.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.nao), Boolean.valueOf(this.nap), Boolean.valueOf(this.naq), Boolean.valueOf(this.nar), Boolean.valueOf(this.nas), this.nat.name(), this.nau);
    }
}
