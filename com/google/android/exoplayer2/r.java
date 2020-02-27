package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public interface r {

    /* loaded from: classes6.dex */
    public interface b {
        void A(boolean z, int i);

        void ET(int i);

        void a(ExoPlaybackException exoPlaybackException);

        void a(q qVar);

        void a(com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar);

        void a(x xVar, Object obj);

        void daf();

        void onRepeatModeChanged(int i);

        void ud(boolean z);

        void ue(boolean z);
    }

    void A(int i, long j);

    int IT(int i);

    void a(b bVar);

    void b(@Nullable q qVar);

    void b(b bVar);

    int cZN();

    boolean dsR();

    boolean dsS();

    q dsT();

    int dsV();

    int dsW();

    int dsX();

    int dsY();

    boolean dsZ();

    long dta();

    com.google.android.exoplayer2.b.g dtb();

    x dtc();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    int getRepeatMode();

    void release();

    void setRepeatMode(int i);

    void stop();

    void vy(boolean z);

    void vz(boolean z);

    /* loaded from: classes6.dex */
    public static abstract class a implements b {
        @Override // com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(com.google.android.exoplayer2.source.u uVar, com.google.android.exoplayer2.b.g gVar) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void ud(boolean z) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void A(boolean z, int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void ue(boolean z) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(ExoPlaybackException exoPlaybackException) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void ET(int i) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void a(q qVar) {
        }

        @Override // com.google.android.exoplayer2.r.b
        public void daf() {
        }
    }
}
