package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class e extends com.google.android.exoplayer2.a implements Handler.Callback {
    private final m mkT;
    private final b mlJ;
    private final d mlK;
    private final Handler mlL;
    private final c mlM;
    private final Metadata[] mlN;
    private final long[] mlO;
    private int mlP;
    private int mlQ;
    private a mlR;
    private boolean mlt;

    public e(d dVar, Looper looper) {
        this(dVar, looper, b.mlI);
    }

    public e(d dVar, Looper looper, b bVar) {
        super(4);
        this.mlK = (d) com.google.android.exoplayer2.util.a.checkNotNull(dVar);
        this.mlL = looper == null ? null : new Handler(looper, this);
        this.mlJ = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.mkT = new m();
        this.mlM = new c();
        this.mlN = new Metadata[5];
        this.mlO = new long[5];
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.mlJ.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mlR = this.mlJ.j(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.a
    protected void j(long j, boolean z) {
        dtE();
        this.mlt = false;
    }

    @Override // com.google.android.exoplayer2.s
    public void N(long j, long j2) throws ExoPlaybackException {
        if (!this.mlt && this.mlQ < 5) {
            this.mlM.clear();
            if (a(this.mkT, (com.google.android.exoplayer2.a.e) this.mlM, false) == -4) {
                if (this.mlM.drT()) {
                    this.mlt = true;
                } else if (!this.mlM.drS()) {
                    this.mlM.subsampleOffsetUs = this.mkT.lUU.subsampleOffsetUs;
                    this.mlM.dse();
                    try {
                        int i = (this.mlP + this.mlQ) % 5;
                        this.mlN[i] = this.mlR.a(this.mlM);
                        this.mlO[i] = this.mlM.lYY;
                        this.mlQ++;
                    } catch (MetadataDecoderException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                }
            }
        }
        if (this.mlQ > 0 && this.mlO[this.mlP] <= j) {
            d(this.mlN[this.mlP]);
            this.mlN[this.mlP] = null;
            this.mlP = (this.mlP + 1) % 5;
            this.mlQ--;
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void dqm() {
        dtE();
        this.mlR = null;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean ati() {
        return this.mlt;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void d(Metadata metadata) {
        if (this.mlL != null) {
            this.mlL.obtainMessage(0, metadata).sendToTarget();
        } else {
            e(metadata);
        }
    }

    private void dtE() {
        Arrays.fill(this.mlN, (Object) null);
        this.mlP = 0;
        this.mlQ = 0;
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
        this.mlK.a(metadata);
    }
}
