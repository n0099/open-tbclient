package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class a implements s, t {
    private int index;
    private final int lYj;
    private u lYk;
    private com.google.android.exoplayer2.source.p lYl;
    private long lYm;
    private boolean lYn = true;
    private boolean lYo;
    private int state;

    public a(int i) {
        this.lYj = i;
    }

    @Override // com.google.android.exoplayer2.s, com.google.android.exoplayer2.t
    public final int getTrackType() {
        return this.lYj;
    }

    @Override // com.google.android.exoplayer2.s
    public final t dsH() {
        return this;
    }

    @Override // com.google.android.exoplayer2.s
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h dsI() {
        return null;
    }

    @Override // com.google.android.exoplayer2.s
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.s
    public final void a(u uVar, Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j, boolean z, long j2) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 0);
        this.lYk = uVar;
        this.state = 1;
        vx(z);
        a(formatArr, pVar, j2);
        l(j, z);
    }

    @Override // com.google.android.exoplayer2.s
    public final void start() throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.s
    public final void a(Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(!this.lYo);
        this.lYl = pVar;
        this.lYn = false;
        this.lYm = j;
        a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.s
    public final com.google.android.exoplayer2.source.p dsJ() {
        return this.lYl;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean dsK() {
        return this.lYn;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dsL() {
        this.lYo = true;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean dsM() {
        return this.lYo;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dsN() throws IOException {
        this.lYl.dwm();
    }

    @Override // com.google.android.exoplayer2.s
    public final void fl(long j) throws ExoPlaybackException {
        this.lYo = false;
        this.lYn = false;
        l(j, false);
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
        this.lYl = null;
        this.lYo = false;
        dsP();
    }

    @Override // com.google.android.exoplayer2.t
    public int dsO() throws ExoPlaybackException {
        return 0;
    }

    @Override // com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
    }

    protected void vx(boolean z) throws ExoPlaybackException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
    }

    protected void l(long j, boolean z) throws ExoPlaybackException {
    }

    protected void onStarted() throws ExoPlaybackException {
    }

    protected void onStopped() throws ExoPlaybackException {
    }

    protected void dsP() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u dsQ() {
        return this.lYk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        int b = this.lYl.b(mVar, eVar, z);
        if (b == -4) {
            if (eVar.duv()) {
                this.lYn = true;
                return this.lYo ? -4 : -3;
            }
            eVar.mdO += this.lYm;
        } else if (b == -5) {
            Format format = mVar.lZJ;
            if (format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
                mVar.lZJ = format.fx(format.subsampleOffsetUs + this.lYm);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int fm(long j) {
        return this.lYl.ge(j - this.lYm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean cTq() {
        return this.lYn ? this.lYo : this.lYl.isReady();
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
