package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class a implements s, t {
    private int index;
    private final int lXY;
    private u lXZ;
    private com.google.android.exoplayer2.source.p lYa;
    private long lYb;
    private boolean lYc = true;
    private boolean lYd;
    private int state;

    public a(int i) {
        this.lXY = i;
    }

    @Override // com.google.android.exoplayer2.s, com.google.android.exoplayer2.t
    public final int getTrackType() {
        return this.lXY;
    }

    @Override // com.google.android.exoplayer2.s
    public final t dsG() {
        return this;
    }

    @Override // com.google.android.exoplayer2.s
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h dsH() {
        return null;
    }

    @Override // com.google.android.exoplayer2.s
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.s
    public final void a(u uVar, Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j, boolean z, long j2) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.checkState(this.state == 0);
        this.lXZ = uVar;
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
        com.google.android.exoplayer2.util.a.checkState(!this.lYd);
        this.lYa = pVar;
        this.lYc = false;
        this.lYb = j;
        a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.s
    public final com.google.android.exoplayer2.source.p dsI() {
        return this.lYa;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean dsJ() {
        return this.lYc;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dsK() {
        this.lYd = true;
    }

    @Override // com.google.android.exoplayer2.s
    public final boolean dsL() {
        return this.lYd;
    }

    @Override // com.google.android.exoplayer2.s
    public final void dsM() throws IOException {
        this.lYa.dwl();
    }

    @Override // com.google.android.exoplayer2.s
    public final void fl(long j) throws ExoPlaybackException {
        this.lYd = false;
        this.lYc = false;
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
        this.lYa = null;
        this.lYd = false;
        dsO();
    }

    @Override // com.google.android.exoplayer2.t
    public int dsN() throws ExoPlaybackException {
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

    protected void dsO() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u dsP() {
        return this.lXZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        int b = this.lYa.b(mVar, eVar, z);
        if (b == -4) {
            if (eVar.duu()) {
                this.lYc = true;
                return this.lYd ? -4 : -3;
            }
            eVar.mdD += this.lYb;
        } else if (b == -5) {
            Format format = mVar.lZy;
            if (format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
                mVar.lZy = format.fx(format.subsampleOffsetUs + this.lYb);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int fm(long j) {
        return this.lYa.ge(j - this.lYb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean cTp() {
        return this.lYc ? this.lYd : this.lYa.isReady();
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
