package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public interface r {

    /* loaded from: classes5.dex */
    public interface b {
        void EO(int i);

        void a(ExoPlaybackException exoPlaybackException);

        void a(q qVar);

        void a(com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar);

        void a(x xVar, Object obj);

        void cYR();

        void onRepeatModeChanged(int i);

        void tZ(boolean z);

        void ua(boolean z);

        void z(boolean z, int i);
    }

    void B(int i, long j);

    int IO(int i);

    void a(b bVar);

    void b(@Nullable q qVar);

    void b(b bVar);

    int cYz();

    boolean drF();

    boolean drG();

    q drH();

    int drJ();

    int drK();

    int drL();

    int drM();

    boolean drN();

    long drO();

    com.google.android.exoplayer2.b.g drP();

    x drQ();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    int getRepeatMode();

    void release();

    void setRepeatMode(int i);

    void stop();

    void vu(boolean z);

    void vv(boolean z);

    /* loaded from: classes5.dex */
    public static abstract class a implements b {
        @Override // com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void tZ(boolean z) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void z(boolean z, int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void ua(boolean z) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(ExoPlaybackException exoPlaybackException) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void EO(int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(q qVar) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void cYR() {
        }
    }
}
