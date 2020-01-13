package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.t;
/* loaded from: classes5.dex */
public abstract class h {
    private a mCz;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public abstract i a(t[] tVarArr, u uVar) throws ExoPlaybackException;

    public abstract void by(Object obj);

    public final void a(a aVar) {
        this.mCz = aVar;
    }
}
