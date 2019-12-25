package com.google.android.exoplayer2;
/* loaded from: classes4.dex */
public interface g extends r {

    /* loaded from: classes4.dex */
    public interface a {
        void k(int i, Object obj) throws ExoPlaybackException;
    }

    void a(com.google.android.exoplayer2.source.l lVar);

    void a(b... bVarArr);

    void b(b... bVarArr);

    /* loaded from: classes4.dex */
    public static final class b {
        public final a lTQ;
        public final Object lTR;
        public final int messageType;

        public b(a aVar, int i, Object obj) {
            this.lTQ = aVar;
            this.messageType = i;
            this.lTR = obj;
        }
    }
}
