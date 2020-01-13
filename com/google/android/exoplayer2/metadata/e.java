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
    private final m moI;
    private final Handler mpA;
    private final c mpB;
    private final Metadata[] mpC;
    private final long[] mpD;
    private int mpE;
    private int mpF;
    private a mpG;
    private boolean mpi;
    private final b mpy;
    private final d mpz;

    public e(d dVar, Looper looper) {
        this(dVar, looper, b.mpx);
    }

    public e(d dVar, Looper looper, b bVar) {
        super(4);
        this.mpz = (d) com.google.android.exoplayer2.util.a.checkNotNull(dVar);
        this.mpA = looper == null ? null : new Handler(looper, this);
        this.mpy = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.moI = new m();
        this.mpB = new c();
        this.mpC = new Metadata[5];
        this.mpD = new long[5];
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.mpy.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mpG = this.mpy.j(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.a
    protected void j(long j, boolean z) {
        duP();
        this.mpi = false;
    }

    @Override // com.google.android.exoplayer2.s
    public void N(long j, long j2) throws ExoPlaybackException {
        if (!this.mpi && this.mpF < 5) {
            this.mpB.clear();
            if (a(this.moI, (com.google.android.exoplayer2.a.e) this.mpB, false) == -4) {
                if (this.mpB.dtf()) {
                    this.mpi = true;
                } else if (!this.mpB.dte()) {
                    this.mpB.subsampleOffsetUs = this.moI.lYL.subsampleOffsetUs;
                    this.mpB.dtq();
                    try {
                        int i = (this.mpE + this.mpF) % 5;
                        this.mpC[i] = this.mpG.a(this.mpB);
                        this.mpD[i] = this.mpB.mcQ;
                        this.mpF++;
                    } catch (MetadataDecoderException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                }
            }
        }
        if (this.mpF > 0 && this.mpD[this.mpE] <= j) {
            d(this.mpC[this.mpE]);
            this.mpC[this.mpE] = null;
            this.mpE = (this.mpE + 1) % 5;
            this.mpF--;
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void dry() {
        duP();
        this.mpG = null;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean atB() {
        return this.mpi;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void d(Metadata metadata) {
        if (this.mpA != null) {
            this.mpA.obtainMessage(0, metadata).sendToTarget();
        } else {
            e(metadata);
        }
    }

    private void duP() {
        Arrays.fill(this.mpC, (Object) null);
        this.mpE = 0;
        this.mpF = 0;
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
        this.mpz.a(metadata);
    }
}
