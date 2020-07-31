package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes3.dex */
public class b {
    private static final b nal = dGg().dGo();
    public final int nam;
    public final boolean nan;
    public final boolean nao;
    public final boolean nap;
    public final boolean naq;
    public final Bitmap.Config nar;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b nas;

    public b(c cVar) {
        this.nam = cVar.dGh();
        this.nan = cVar.dGi();
        this.nao = cVar.dGj();
        this.nap = cVar.dGk();
        this.naq = cVar.dGm();
        this.nar = cVar.dGn();
        this.nas = cVar.dGl();
    }

    public static b dGf() {
        return nal;
    }

    public static c dGg() {
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
        return this.nan == bVar.nan && this.nao == bVar.nao && this.nap == bVar.nap && this.naq == bVar.naq && this.nar == bVar.nar && this.nas == bVar.nas;
    }

    public int hashCode() {
        return (((((((this.nap ? 1 : 0) + (((this.nao ? 1 : 0) + (((this.nan ? 1 : 0) + (this.nam * 31)) * 31)) * 31)) * 31) + (this.naq ? 1 : 0)) * 31) + this.nar.ordinal()) * 31) + (this.nas != null ? this.nas.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.nam), Boolean.valueOf(this.nan), Boolean.valueOf(this.nao), Boolean.valueOf(this.nap), Boolean.valueOf(this.naq), this.nar.name(), this.nas);
    }
}
