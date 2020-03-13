package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class e extends com.google.android.exoplayer2.a implements Handler.Callback {
    private final m mpG;
    private final Metadata[] mqA;
    private final long[] mqB;
    private int mqC;
    private int mqD;
    private a mqE;
    private boolean mqg;
    private final b mqw;
    private final d mqx;
    private final Handler mqy;
    private final c mqz;

    public e(d dVar, Looper looper) {
        this(dVar, looper, b.mqv);
    }

    public e(d dVar, Looper looper, b bVar) {
        super(4);
        this.mqx = (d) com.google.android.exoplayer2.util.a.checkNotNull(dVar);
        this.mqy = looper == null ? null : new Handler(looper, this);
        this.mqw = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.mpG = new m();
        this.mqz = new c();
        this.mqA = new Metadata[5];
        this.mqB = new long[5];
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.mqw.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mqE = this.mqw.j(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.a
    protected void l(long j, boolean z) {
        dwe();
        this.mqg = false;
    }

    @Override // com.google.android.exoplayer2.s
    public void M(long j, long j2) throws ExoPlaybackException {
        if (!this.mqg && this.mqD < 5) {
            this.mqz.clear();
            if (a(this.mpG, (com.google.android.exoplayer2.a.e) this.mqz, false) == -4) {
                if (this.mqz.duv()) {
                    this.mqg = true;
                } else if (!this.mqz.duu()) {
                    this.mqz.subsampleOffsetUs = this.mpG.lZJ.subsampleOffsetUs;
                    this.mqz.duG();
                    try {
                        int i = (this.mqC + this.mqD) % 5;
                        this.mqA[i] = this.mqE.a(this.mqz);
                        this.mqB[i] = this.mqz.mdO;
                        this.mqD++;
                    } catch (MetadataDecoderException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                }
            }
        }
        if (this.mqD > 0 && this.mqB[this.mqC] <= j) {
            d(this.mqA[this.mqC]);
            this.mqA[this.mqC] = null;
            this.mqC = (this.mqC + 1) % 5;
            this.mqD--;
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void dsP() {
        dwe();
        this.mqE = null;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean avR() {
        return this.mqg;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void d(Metadata metadata) {
        if (this.mqy != null) {
            this.mqy.obtainMessage(0, metadata).sendToTarget();
        } else {
            e(metadata);
        }
    }

    private void dwe() {
        Arrays.fill(this.mqA, (Object) null);
        this.mqC = 0;
        this.mqD = 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                e((Metadata) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void e(Metadata metadata) {
        this.mqx.a(metadata);
    }
}
