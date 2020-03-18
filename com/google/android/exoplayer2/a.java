package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class a implements s, t {
    private int index;
    private final int lZP;
    private u lZQ;
    private com.google.android.exoplayer2.source.p lZR;
    private long lZS;
    private boolean lZT = true;
    private boolean lZU;
    private int state;

    public a(int i) {
        this.lZP = i;
    }

    @Override // com.google.android.exoplayer2.s, com.google.android.exoplayer2.t
    public final int getTrackType() {
        return this.lZP;
    }

    @Override // com.google.android.exoplayer2.s
    public final t dte() {
        return this;
    }

    @Override // com.google.android.exoplayer2.s
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h dtf() {
        return null;
    }

    @Override // com.google.android.exoplayer2.s
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.s
    public final void a(u uVar, Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j, boolean z, long j2) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 0);
        this.lZQ = uVar;
        this.state = 1;
        vE(z);
        a(formatArr, pVar, j2);
        m(j, z);
    }

    @Override // com.google.android.exoplayer2.s
    public final void start() throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.s
    public final void a(Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(!this.lZU);
        this.lZR = pVar;
        this.lZT = false;
        this.lZS = j;
        a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.s
    public final com.google.android.exoplayer2.source.p dtg() {
        return this.lZR;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean dth() {
        return this.lZT;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dti() {
        this.lZU = true;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean dtj() {
        return this.lZU;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dtk() throws IOException {
        this.lZR.dwJ();
    }

    @Override // com.google.android.exoplayer2.s
    public final void fm(long j) throws ExoPlaybackException {
        this.lZU = false;
        this.lZT = false;
        m(j, false);
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
        this.lZR = null;
        this.lZU = false;
        dtm();
    }

    @Override // com.google.android.exoplayer2.t
    public int dtl() throws ExoPlaybackException {
        return 0;
    }

    @Override // com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
    }

    protected void vE(boolean z) throws ExoPlaybackException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
    }

    protected void m(long j, boolean z) throws ExoPlaybackException {
    }

    protected void onStarted() throws ExoPlaybackException {
    }

    protected void onStopped() throws ExoPlaybackException {
    }

    protected void dtm() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u dtn() {
        return this.lZQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        int b = this.lZR.b(mVar, eVar, z);
        if (b == -4) {
            if (eVar.duS()) {
                this.lZT = true;
                return this.lZU ? -4 : -3;
            }
            eVar.mfu += this.lZS;
        } else if (b == -5) {
            Format format = mVar.mbs;
            if (format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
                mVar.mbs = format.fy(format.subsampleOffsetUs + this.lZS);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int fn(long j) {
        return this.lZR.gf(j - this.lZS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean cTK() {
        return this.lZT ? this.lZU : this.lZR.isReady();
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
