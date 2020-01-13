package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class k extends com.google.android.exoplayer2.a implements Handler.Callback {
    private final m moI;
    private final Handler mpA;
    private boolean mpi;
    private boolean mpj;
    private final j mxZ;
    private final g mya;
    private int myb;
    private Format myc;
    private f myd;
    private h mye;
    private i myf;
    private i myg;
    private int myh;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.mxX);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.mxZ = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
        this.mpA = looper == null ? null : new Handler(looper, this);
        this.mya = gVar;
        this.moI = new m();
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.mya.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        } else if (com.google.android.exoplayer2.util.i.Qc(format.sampleMimeType)) {
            return 1;
        } else {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.myc = formatArr[0];
        if (this.myd != null) {
            this.myb = 1;
        } else {
            this.myd = this.mya.p(this.myc);
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void j(long j, boolean z) {
        dwA();
        this.mpi = false;
        this.mpj = false;
        if (this.myb != 0) {
            dwy();
            return;
        }
        Da();
        this.myd.flush();
    }

    @Override // com.google.android.exoplayer2.s
    public void N(long j, long j2) throws ExoPlaybackException {
        boolean z;
        if (!this.mpj) {
            if (this.myg == null) {
                this.myd.gx(j);
                try {
                    this.myg = this.myd.dtl();
                } catch (SubtitleDecoderException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            }
            if (getState() == 2) {
                if (this.myf != null) {
                    long dwz = dwz();
                    z = false;
                    while (dwz <= j) {
                        this.myh++;
                        dwz = dwz();
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (this.myg != null) {
                    if (this.myg.dtf()) {
                        if (!z && dwz() == Format.OFFSET_SAMPLE_RELATIVE) {
                            if (this.myb == 2) {
                                dwy();
                            } else {
                                Da();
                                this.mpj = true;
                            }
                        }
                    } else if (this.myg.mcQ <= j) {
                        if (this.myf != null) {
                            this.myf.release();
                        }
                        this.myf = this.myg;
                        this.myg = null;
                        this.myh = this.myf.gy(j);
                        z = true;
                    }
                }
                if (z) {
                    fn(this.myf.gz(j));
                }
                if (this.myb != 2) {
                    while (!this.mpi) {
                        try {
                            if (this.mye == null) {
                                this.mye = this.myd.dtk();
                                if (this.mye == null) {
                                    return;
                                }
                            }
                            if (this.myb == 1) {
                                this.mye.setFlags(4);
                                this.myd.bv(this.mye);
                                this.mye = null;
                                this.myb = 2;
                                return;
                            }
                            int a = a(this.moI, (com.google.android.exoplayer2.a.e) this.mye, false);
                            if (a == -4) {
                                if (this.mye.dtf()) {
                                    this.mpi = true;
                                } else {
                                    this.mye.subsampleOffsetUs = this.moI.lYL.subsampleOffsetUs;
                                    this.mye.dtq();
                                }
                                this.myd.bv(this.mye);
                                this.mye = null;
                            } else if (a == -3) {
                                return;
                            }
                        } catch (SubtitleDecoderException e2) {
                            throw ExoPlaybackException.createForRenderer(e2, getIndex());
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void dry() {
        this.myc = null;
        dwA();
        dwx();
    }

    @Override // com.google.android.exoplayer2.s
    public boolean atB() {
        return this.mpj;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void Da() {
        this.mye = null;
        this.myh = -1;
        if (this.myf != null) {
            this.myf.release();
            this.myf = null;
        }
        if (this.myg != null) {
            this.myg.release();
            this.myg = null;
        }
    }

    private void dwx() {
        Da();
        this.myd.release();
        this.myd = null;
        this.myb = 0;
    }

    private void dwy() {
        dwx();
        this.myd = this.mya.p(this.myc);
    }

    private long dwz() {
        return (this.myh == -1 || this.myh >= this.myf.dww()) ? Format.OFFSET_SAMPLE_RELATIVE : this.myf.Lf(this.myh);
    }

    private void fn(List<b> list) {
        if (this.mpA != null) {
            this.mpA.obtainMessage(0, list).sendToTarget();
        } else {
            fo(list);
        }
    }

    private void dwA() {
        fn(Collections.emptyList());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                fo((List) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void fo(List<b> list) {
        this.mxZ.fe(list);
    }
}
