package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class e extends com.google.android.exoplayer2.a implements Handler.Callback {
    private final m moN;
    private final b mpD;
    private final d mpE;
    private final Handler mpF;
    private final c mpG;
    private final Metadata[] mpH;
    private final long[] mpI;
    private int mpJ;
    private int mpK;
    private a mpL;
    private boolean mpn;

    public e(d dVar, Looper looper) {
        this(dVar, looper, b.mpC);
    }

    public e(d dVar, Looper looper, b bVar) {
        super(4);
        this.mpE = (d) com.google.android.exoplayer2.util.a.checkNotNull(dVar);
        this.mpF = looper == null ? null : new Handler(looper, this);
        this.mpD = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.moN = new m();
        this.mpG = new c();
        this.mpH = new Metadata[5];
        this.mpI = new long[5];
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.mpD.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mpL = this.mpD.j(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.a
    protected void j(long j, boolean z) {
        duR();
        this.mpn = false;
    }

    @Override // com.google.android.exoplayer2.s
    public void N(long j, long j2) throws ExoPlaybackException {
        if (!this.mpn && this.mpK < 5) {
            this.mpG.clear();
            if (a(this.moN, (com.google.android.exoplayer2.a.e) this.mpG, false) == -4) {
                if (this.mpG.dth()) {
                    this.mpn = true;
                } else if (!this.mpG.dtg()) {
                    this.mpG.subsampleOffsetUs = this.moN.lYQ.subsampleOffsetUs;
                    this.mpG.dts();
                    try {
                        int i = (this.mpJ + this.mpK) % 5;
                        this.mpH[i] = this.mpL.a(this.mpG);
                        this.mpI[i] = this.mpG.mcV;
                        this.mpK++;
                    } catch (MetadataDecoderException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                }
            }
        }
        if (this.mpK > 0 && this.mpI[this.mpJ] <= j) {
            d(this.mpH[this.mpJ]);
            this.mpH[this.mpJ] = null;
            this.mpJ = (this.mpJ + 1) % 5;
            this.mpK--;
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void drA() {
        duR();
        this.mpL = null;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean atB() {
        return this.mpn;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void d(Metadata metadata) {
        if (this.mpF != null) {
            this.mpF.obtainMessage(0, metadata).sendToTarget();
        } else {
            e(metadata);
        }
    }

    private void duR() {
        Arrays.fill(this.mpH, (Object) null);
        this.mpJ = 0;
        this.mpK = 0;
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
        this.mpE.a(metadata);
    }
}
