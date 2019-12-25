package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.t;
/* loaded from: classes4.dex */
public abstract class h {
    private a myJ;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public abstract i a(t[] tVarArr, u uVar) throws ExoPlaybackException;

    public abstract void bx(Object obj);

    public final void a(a aVar) {
        this.myJ = aVar;
    }
}
