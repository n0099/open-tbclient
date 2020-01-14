package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class a implements s, t {
    private int index;
    private final int lXq;
    private u lXr;
    private com.google.android.exoplayer2.source.p lXs;
    private long lXt;
    private boolean lXu = true;
    private boolean lXv;
    private int state;

    public a(int i) {
        this.lXq = i;
    }

    @Override // com.google.android.exoplayer2.s, com.google.android.exoplayer2.t
    public final int getTrackType() {
        return this.lXq;
    }

    @Override // com.google.android.exoplayer2.s
    public final t drs() {
        return this;
    }

    @Override // com.google.android.exoplayer2.s
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h drt() {
        return null;
    }

    @Override // com.google.android.exoplayer2.s
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.s
    public final void a(u uVar, Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j, boolean z, long j2) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 0);
        this.lXr = uVar;
        this.state = 1;
        vt(z);
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
        com.google.android.exoplayer2.util.a.checkState(!this.lXv);
        this.lXs = pVar;
        this.lXu = false;
        this.lXt = j;
        a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.s
    public final com.google.android.exoplayer2.source.p dru() {
        return this.lXs;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean drv() {
        return this.lXu;
    }

    @Override // com.google.android.exoplayer2.s
    public final void drw() {
        this.lXv = true;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean drx() {
        return this.lXv;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dry() throws IOException {
        this.lXs.duZ();
    }

    @Override // com.google.android.exoplayer2.s
    public final void fn(long j) throws ExoPlaybackException {
        this.lXv = false;
        this.lXu = false;
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
        this.lXs = null;
        this.lXv = false;
        drA();
    }

    @Override // com.google.android.exoplayer2.t
    public int drz() throws ExoPlaybackException {
        return 0;
    }

    @Override // com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
    }

    protected void vt(boolean z) throws ExoPlaybackException {
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

    protected void drA() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u drB() {
        return this.lXr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        int b = this.lXs.b(mVar, eVar, z);
        if (b == -4) {
            if (eVar.dth()) {
                this.lXu = true;
                return this.lXv ? -4 : -3;
            }
            eVar.mcV += this.lXt;
        } else if (b == -5) {
            Format format = mVar.lYQ;
            if (format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
                mVar.lYQ = format.fz(format.subsampleOffsetUs + this.lXt);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int fo(long j) {
        return this.lXs.gg(j - this.lXt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean cRS() {
        return this.lXu ? this.lXv : this.lXs.isReady();
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
