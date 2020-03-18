package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public interface r {

    /* loaded from: classes6.dex */
    public interface b {
        void A(boolean z, int i);

        void Fa(int i);

        void a(ExoPlaybackException exoPlaybackException);

        void a(q qVar);

        void a(com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar);

        void a(x xVar, Object obj);

        void daF();

        void onRepeatModeChanged(int i);

        void uk(boolean z);

        void ul(boolean z);
    }

    void A(int i, long j);

    int IZ(int i);

    void a(b bVar);

    void b(@Nullable q qVar);

    void b(b bVar);

    int dan();

    long dtA();

    com.google.android.exoplayer2.b.g dtB();

    x dtC();

    boolean dtr();

    boolean dts();

    q dtt();

    int dtv();

    int dtw();

    int dtx();

    int dty();

    boolean dtz();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    int getRepeatMode();

    void release();

    void setRepeatMode(int i);

    void stop();

    void vF(boolean z);

    void vG(boolean z);

    /* loaded from: classes6.dex */
    public static abstract class a implements b {
        @Override // com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void uk(boolean z) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void A(boolean z, int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void ul(boolean z) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(ExoPlaybackException exoPlaybackException) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void Fa(int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(q qVar) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void daF() {
        }
    }
}
