package com.google.android.exoplayer2;
/* loaded from: classes5.dex */
public interface g extends r {

    /* loaded from: classes5.dex */
    public interface a {
        void k(int i, Object obj) throws ExoPlaybackException;
    }

    void a(com.google.android.exoplayer2.source.l lVar);

    void a(b... bVarArr);

    void b(b... bVarArr);

    /* loaded from: classes5.dex */
    public static final class b {
        public final a lXH;
        public final Object lXI;
        public final int messageType;

        public b(a aVar, int i, Object obj) {
            this.lXH = aVar;
            this.messageType = i;
            this.lXI = obj;
        }
    }
}
