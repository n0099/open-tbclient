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
    private boolean mrM;
    private final m mrm;
    private final b msc;
    private final d msd;
    private final Handler mse;
    private final c msf;
    private final Metadata[] msh;
    private final long[] msi;
    private int msj;
    private int msk;
    private a msl;

    public e(d dVar, Looper looper) {
        this(dVar, looper, b.msb);
    }

    public e(d dVar, Looper looper, b bVar) {
        super(4);
        this.msd = (d) com.google.android.exoplayer2.util.a.checkNotNull(dVar);
        this.mse = looper == null ? null : new Handler(looper, this);
        this.msc = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.mrm = new m();
        this.msf = new c();
        this.msh = new Metadata[5];
        this.msi = new long[5];
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.msc.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.msl = this.msc.j(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.a
    protected void m(long j, boolean z) {
        dwB();
        this.mrM = false;
    }

    @Override // com.google.android.exoplayer2.s
    public void M(long j, long j2) throws ExoPlaybackException {
        if (!this.mrM && this.msk < 5) {
            this.msf.clear();
            if (a(this.mrm, (com.google.android.exoplayer2.a.e) this.msf, false) == -4) {
                if (this.msf.duS()) {
                    this.mrM = true;
                } else if (!this.msf.duR()) {
                    this.msf.subsampleOffsetUs = this.mrm.mbs.subsampleOffsetUs;
                    this.msf.dvd();
                    try {
                        int i = (this.msj + this.msk) % 5;
                        this.msh[i] = this.msl.a(this.msf);
                        this.msi[i] = this.msf.mfu;
                        this.msk++;
                    } catch (MetadataDecoderException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                }
            }
        }
        if (this.msk > 0 && this.msi[this.msj] <= j) {
            d(this.msh[this.msj]);
            this.msh[this.msj] = null;
            this.msj = (this.msj + 1) % 5;
            this.msk--;
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void dtm() {
        dwB();
        this.msl = null;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean avU() {
        return this.mrM;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void d(Metadata metadata) {
        if (this.mse != null) {
            this.mse.obtainMessage(0, metadata).sendToTarget();
        } else {
            e(metadata);
        }
    }

    private void dwB() {
        Arrays.fill(this.msh, (Object) null);
        this.msj = 0;
        this.msk = 0;
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
        this.msd.a(metadata);
    }
}
