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
    private boolean mpV;
    private final m mpv;
    private final b mql;
    private final d mqm;
    private final Handler mqn;
    private final c mqo;
    private final Metadata[] mqp;
    private final long[] mqq;
    private int mqr;
    private int mqs;
    private a mqt;

    public e(d dVar, Looper looper) {
        this(dVar, looper, b.mqk);
    }

    public e(d dVar, Looper looper, b bVar) {
        super(4);
        this.mqm = (d) com.google.android.exoplayer2.util.a.checkNotNull(dVar);
        this.mqn = looper == null ? null : new Handler(looper, this);
        this.mql = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.mpv = new m();
        this.mqo = new c();
        this.mqp = new Metadata[5];
        this.mqq = new long[5];
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.mql.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mqt = this.mql.j(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.a
    protected void l(long j, boolean z) {
        dwd();
        this.mpV = false;
    }

    @Override // com.google.android.exoplayer2.s
    public void M(long j, long j2) throws ExoPlaybackException {
        if (!this.mpV && this.mqs < 5) {
            this.mqo.clear();
            if (a(this.mpv, (com.google.android.exoplayer2.a.e) this.mqo, false) == -4) {
                if (this.mqo.duu()) {
                    this.mpV = true;
                } else if (!this.mqo.dut()) {
                    this.mqo.subsampleOffsetUs = this.mpv.lZy.subsampleOffsetUs;
                    this.mqo.duF();
                    try {
                        int i = (this.mqr + this.mqs) % 5;
                        this.mqp[i] = this.mqt.a(this.mqo);
                        this.mqq[i] = this.mqo.mdD;
                        this.mqs++;
                    } catch (MetadataDecoderException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                }
            }
        }
        if (this.mqs > 0 && this.mqq[this.mqr] <= j) {
            d(this.mqp[this.mqr]);
            this.mqp[this.mqr] = null;
            this.mqr = (this.mqr + 1) % 5;
            this.mqs--;
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void dsO() {
        dwd();
        this.mqt = null;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean avR() {
        return this.mpV;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void d(Metadata metadata) {
        if (this.mqn != null) {
            this.mqn.obtainMessage(0, metadata).sendToTarget();
        } else {
            e(metadata);
        }
    }

    private void dwd() {
        Arrays.fill(this.mqp, (Object) null);
        this.mqr = 0;
        this.mqs = 0;
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
        this.mqm.a(metadata);
    }
}
