package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
/* loaded from: classes4.dex */
public interface r {

    /* loaded from: classes4.dex */
    public interface b {
        void EJ(int i);

        void a(ExoPlaybackException exoPlaybackException);

        void a(q qVar);

        void a(com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar);

        void a(x xVar, Object obj);

        void cXM();

        void onRepeatModeChanged(int i);

        void tN(boolean z);

        void tO(boolean z);

        void y(boolean z, int i);
    }

    void B(int i, long j);

    int IF(int i);

    void a(b bVar);

    void b(@Nullable q qVar);

    void b(b bVar);

    int cXu();

    long dqA();

    com.google.android.exoplayer2.b.g dqB();

    x dqC();

    boolean dqr();

    boolean dqs();

    q dqt();

    int dqv();

    int dqw();

    int dqx();

    int dqy();

    boolean dqz();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    int getRepeatMode();

    void release();

    void setRepeatMode(int i);

    void stop();

    void vi(boolean z);

    void vj(boolean z);

    /* loaded from: classes4.dex */
    public static abstract class a implements b {
        @Override // com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void tN(boolean z) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void y(boolean z, int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void tO(boolean z) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(ExoPlaybackException exoPlaybackException) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void EJ(int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(q qVar) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void cXM() {
        }
    }
}
