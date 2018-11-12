package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a ifh = bTY().bUg();
    public final int ifi;
    public final boolean ifj;
    public final boolean ifk;
    public final boolean ifl;
    public final boolean ifm;
    public final Bitmap.Config ifn;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b ifo;

    public a(b bVar) {
        this.ifi = bVar.bTZ();
        this.ifj = bVar.bUa();
        this.ifk = bVar.bUb();
        this.ifl = bVar.bUc();
        this.ifm = bVar.bUe();
        this.ifn = bVar.bUf();
        this.ifo = bVar.bUd();
    }

    public static a bTX() {
        return ifh;
    }

    public static b bTY() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.ifj == aVar.ifj && this.ifk == aVar.ifk && this.ifl == aVar.ifl && this.ifm == aVar.ifm && this.ifn == aVar.ifn && this.ifo == aVar.ifo;
    }

    public int hashCode() {
        return (((((((this.ifl ? 1 : 0) + (((this.ifk ? 1 : 0) + (((this.ifj ? 1 : 0) + (this.ifi * 31)) * 31)) * 31)) * 31) + (this.ifm ? 1 : 0)) * 31) + this.ifn.ordinal()) * 31) + (this.ifo != null ? this.ifo.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.ifi), Boolean.valueOf(this.ifj), Boolean.valueOf(this.ifk), Boolean.valueOf(this.ifl), Boolean.valueOf(this.ifm), this.ifn.name(), this.ifo);
    }
}
