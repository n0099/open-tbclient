package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import com.kwad.framework.filedownloader.f.f;
import java.util.List;
/* loaded from: classes10.dex */
public final class a {
    public long afA;
    public long afB;
    public long afz;
    public int id;
    public int index;

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.afz;
    }

    public final long vX() {
        return this.afA;
    }

    public final long vY() {
        return this.afB;
    }

    public static long q(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.vX() - aVar.getStartOffset();
        }
        return j;
    }

    public final void M(long j) {
        this.afA = j;
    }

    public final void N(long j) {
        this.afB = j;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setStartOffset(long j) {
        this.afz = j;
    }

    public final String toString() {
        return f.b("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.id), Integer.valueOf(this.index), Long.valueOf(this.afz), Long.valueOf(this.afB), Long.valueOf(this.afA));
    }

    public final ContentValues vZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put("startOffset", Long.valueOf(this.afz));
        contentValues.put("currentOffset", Long.valueOf(this.afA));
        contentValues.put("endOffset", Long.valueOf(this.afB));
        return contentValues;
    }
}
