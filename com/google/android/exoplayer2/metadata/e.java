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
    private boolean mpT;
    private final m mpt;
    private final b mqj;
    private final d mqk;
    private final Handler mql;
    private final c mqm;
    private final Metadata[] mqn;
    private final long[] mqo;
    private int mqp;
    private int mqq;
    private a mqr;

    public e(d dVar, Looper looper) {
        this(dVar, looper, b.mqi);
    }

    public e(d dVar, Looper looper, b bVar) {
        super(4);
        this.mqk = (d) com.google.android.exoplayer2.util.a.checkNotNull(dVar);
        this.mql = looper == null ? null : new Handler(looper, this);
        this.mqj = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.mpt = new m();
        this.mqm = new c();
        this.mqn = new Metadata[5];
        this.mqo = new long[5];
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.mqj.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mqr = this.mqj.j(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.a
    protected void l(long j, boolean z) {
        dwb();
        this.mpT = false;
    }

    @Override // com.google.android.exoplayer2.s
    public void M(long j, long j2) throws ExoPlaybackException {
        if (!this.mpT && this.mqq < 5) {
            this.mqm.clear();
            if (a(this.mpt, (com.google.android.exoplayer2.a.e) this.mqm, false) == -4) {
                if (this.mqm.dus()) {
                    this.mpT = true;
                } else if (!this.mqm.dur()) {
                    this.mqm.subsampleOffsetUs = this.mpt.lZw.subsampleOffsetUs;
                    this.mqm.duD();
                    try {
                        int i = (this.mqp + this.mqq) % 5;
                        this.mqn[i] = this.mqr.a(this.mqm);
                        this.mqo[i] = this.mqm.mdB;
                        this.mqq++;
                    } catch (MetadataDecoderException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                }
            }
        }
        if (this.mqq > 0 && this.mqo[this.mqp] <= j) {
            d(this.mqn[this.mqp]);
            this.mqn[this.mqp] = null;
            this.mqp = (this.mqp + 1) % 5;
            this.mqq--;
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void dsM() {
        dwb();
        this.mqr = null;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean avP() {
        return this.mpT;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void d(Metadata metadata) {
        if (this.mql != null) {
            this.mql.obtainMessage(0, metadata).sendToTarget();
        } else {
            e(metadata);
        }
    }

    private void dwb() {
        Arrays.fill(this.mqn, (Object) null);
        this.mqp = 0;
        this.mqq = 0;
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
        this.mqk.a(metadata);
    }
}
