package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
/* loaded from: classes4.dex */
public abstract class a implements s, t {
    private int index;
    private final int lTu;
    private u lTv;
    private com.google.android.exoplayer2.source.p lTw;
    private long lTx;
    private boolean lTy = true;
    private boolean lTz;
    private int state;

    public a(int i) {
        this.lTu = i;
    }

    @Override // com.google.android.exoplayer2.s, com.google.android.exoplayer2.t
    public final int getTrackType() {
        return this.lTu;
    }

    @Override // com.google.android.exoplayer2.s
    public final t dqe() {
        return this;
    }

    @Override // com.google.android.exoplayer2.s
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h dqf() {
        return null;
    }

    @Override // com.google.android.exoplayer2.s
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.s
    public final void a(u uVar, Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j, boolean z, long j2) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 0);
        this.lTv = uVar;
        this.state = 1;
        vh(z);
        a(formatArr, pVar, j2);
        j(j, z);
    }

    @Override // com.google.android.exoplayer2.s
    public final void start() throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.s
    public final void a(Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(!this.lTz);
        this.lTw = pVar;
        this.lTy = false;
        this.lTx = j;
        a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.s
    public final com.google.android.exoplayer2.source.p dqg() {
        return this.lTw;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean dqh() {
        return this.lTy;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dqi() {
        this.lTz = true;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean dqj() {
        return this.lTz;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dqk() throws IOException {
        this.lTw.dtM();
    }

    @Override // com.google.android.exoplayer2.s
    public final void fi(long j) throws ExoPlaybackException {
        this.lTz = false;
        this.lTy = false;
        j(j, false);
    }

    @Override // com.google.android.exoplayer2.s
    public final void stop() throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.s
    public final void disable() {
        com.google.android.exoplayer2.util.a.checkState(this.state == 1);
        this.state = 0;
        this.lTw = null;
        this.lTz = false;
        dqm();
    }

    @Override // com.google.android.exoplayer2.t
    public int dql() throws ExoPlaybackException {
        return 0;
    }

    @Override // com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
    }

    protected void vh(boolean z) throws ExoPlaybackException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
    }

    protected void j(long j, boolean z) throws ExoPlaybackException {
    }

    protected void onStarted() throws ExoPlaybackException {
    }

    protected void onStopped() throws ExoPlaybackException {
    }

    protected void dqm() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u dqn() {
        return this.lTv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        int b = this.lTw.b(mVar, eVar, z);
        if (b == -4) {
            if (eVar.drT()) {
                this.lTy = true;
                return this.lTz ? -4 : -3;
            }
            eVar.lYY += this.lTx;
        } else if (b == -5) {
            Format format = mVar.lUU;
            if (format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
                mVar.lUU = format.fu(format.subsampleOffsetUs + this.lTx);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int fj(long j) {
        return this.lTw.gb(j - this.lTx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean cQN() {
        return this.lTy ? this.lTz : this.lTw.isReady();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(@Nullable com.google.android.exoplayer2.drm.a<?> aVar, @Nullable DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (aVar == null) {
            return false;
        }
        return aVar.c(drmInitData);
    }
}
