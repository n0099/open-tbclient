package com.google.android.exoplayer2;
/* loaded from: classes6.dex */
public interface g extends r {

    /* loaded from: classes6.dex */
    public interface a {
        void k(int i, Object obj) throws ExoPlaybackException;
    }

    void a(com.google.android.exoplayer2.source.l lVar);

    void a(b... bVarArr);

    void b(b... bVarArr);

    /* loaded from: classes6.dex */
    public static final class b {
        public final a mam;
        public final Object man;
        public final int messageType;

        public b(a aVar, int i, Object obj) {
            this.mam = aVar;
            this.messageType = i;
            this.man = obj;
        }
    }
}
