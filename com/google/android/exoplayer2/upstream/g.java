package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class g {
    public final long fOW;
    public final int flags;
    public final String key;
    public final long length;
    public final byte[] mHG;
    public final long mHH;
    public final Uri uri;

    public g(Uri uri, int i) {
        this(uri, 0L, -1L, null, i);
    }

    public g(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public g(Uri uri, long j, long j2, String str, int i) {
        this(uri, j, j, j2, str, i);
    }

    public g(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public g(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0);
        com.google.android.exoplayer2.util.a.checkArgument(j2 >= 0);
        com.google.android.exoplayer2.util.a.checkArgument(j3 > 0 || j3 == -1);
        this.uri = uri;
        this.mHG = bArr;
        this.mHH = j;
        this.fOW = j2;
        this.length = j3;
        this.key = str;
        this.flags = i;
    }

    public boolean LW(int i) {
        return (this.flags & i) == i;
    }

    public String toString() {
        return "DataSpec[" + this.uri + ", " + Arrays.toString(this.mHG) + ", " + this.mHH + ", " + this.fOW + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    }

    public g gG(long j) {
        return V(j, this.length != -1 ? this.length - j : -1L);
    }

    public g V(long j, long j2) {
        return (j == 0 && this.length == j2) ? this : new g(this.uri, this.mHG, this.mHH + j, this.fOW + j, j2, this.key, this.flags);
    }
}
