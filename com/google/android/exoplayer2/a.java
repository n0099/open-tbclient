package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class a implements s, t {
    private int index;
    private final int lXW;
    private u lXX;
    private com.google.android.exoplayer2.source.p lXY;
    private long lXZ;
    private boolean lYa = true;
    private boolean lYb;
    private int state;

    public a(int i) {
        this.lXW = i;
    }

    @Override // com.google.android.exoplayer2.s, com.google.android.exoplayer2.t
    public final int getTrackType() {
        return this.lXW;
    }

    @Override // com.google.android.exoplayer2.s
    public final t dsE() {
        return this;
    }

    @Override // com.google.android.exoplayer2.s
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h dsF() {
        return null;
    }

    @Override // com.google.android.exoplayer2.s
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.s
    public final void a(u uVar, Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j, boolean z, long j2) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 0);
        this.lXX = uVar;
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
        com.google.android.exoplayer2.util.a.checkState(!this.lYb);
        this.lXY = pVar;
        this.lYa = false;
        this.lXZ = j;
        a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.s
    public final com.google.android.exoplayer2.source.p dsG() {
        return this.lXY;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean dsH() {
        return this.lYa;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dsI() {
        this.lYb = true;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean dsJ() {
        return this.lYb;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dsK() throws IOException {
        this.lXY.dwj();
    }

    @Override // com.google.android.exoplayer2.s
    public final void fl(long j) throws ExoPlaybackException {
        this.lYb = false;
        this.lYa = false;
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
        this.lXY = null;
        this.lYb = false;
        dsM();
    }

    @Override // com.google.android.exoplayer2.t
    public int dsL() throws ExoPlaybackException {
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

    protected void dsM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u dsN() {
        return this.lXX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        int b = this.lXY.b(mVar, eVar, z);
        if (b == -4) {
            if (eVar.dus()) {
                this.lYa = true;
                return this.lYb ? -4 : -3;
            }
            eVar.mdB += this.lXZ;
        } else if (b == -5) {
            Format format = mVar.lZw;
            if (format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
                mVar.lZw = format.fx(format.subsampleOffsetUs + this.lXZ);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int fm(long j) {
        return this.lXY.ge(j - this.lXZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean cTn() {
        return this.lYa ? this.lYb : this.lXY.isReady();
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
