package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class a implements s, t {
    private int index;
    private final int lXl;
    private u lXm;
    private com.google.android.exoplayer2.source.p lXn;
    private long lXo;
    private boolean lXp = true;
    private boolean lXq;
    private int state;

    public a(int i) {
        this.lXl = i;
    }

    @Override // com.google.android.exoplayer2.s, com.google.android.exoplayer2.t
    public final int getTrackType() {
        return this.lXl;
    }

    @Override // com.google.android.exoplayer2.s
    public final t drq() {
        return this;
    }

    @Override // com.google.android.exoplayer2.s
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h drr() {
        return null;
    }

    @Override // com.google.android.exoplayer2.s
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.s
    public final void a(u uVar, Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j, boolean z, long j2) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 0);
        this.lXm = uVar;
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
        com.google.android.exoplayer2.util.a.checkState(!this.lXq);
        this.lXn = pVar;
        this.lXp = false;
        this.lXo = j;
        a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.s
    public final com.google.android.exoplayer2.source.p drs() {
        return this.lXn;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean drt() {
        return this.lXp;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dru() {
        this.lXq = true;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean drv() {
        return this.lXq;
    }

    @Override // com.google.android.exoplayer2.s
    public final void drw() throws IOException {
        this.lXn.duX();
    }

    @Override // com.google.android.exoplayer2.s
    public final void fn(long j) throws ExoPlaybackException {
        this.lXq = false;
        this.lXp = false;
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
        this.lXn = null;
        this.lXq = false;
        dry();
    }

    @Override // com.google.android.exoplayer2.t
    public int drx() throws ExoPlaybackException {
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

    protected void dry() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u drz() {
        return this.lXm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        int b = this.lXn.b(mVar, eVar, z);
        if (b == -4) {
            if (eVar.dtf()) {
                this.lXp = true;
                return this.lXq ? -4 : -3;
            }
            eVar.mcQ += this.lXo;
        } else if (b == -5) {
            Format format = mVar.lYL;
            if (format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
                mVar.lYL = format.fz(format.subsampleOffsetUs + this.lXo);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int fo(long j) {
        return this.lXn.gg(j - this.lXo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean cRQ() {
        return this.lXp ? this.lXq : this.lXn.isReady();
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
