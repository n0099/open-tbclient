package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class k extends com.google.android.exoplayer2.a implements Handler.Callback {
    private final j mAE;
    private final g mAF;
    private int mAG;
    private Format mAH;
    private f mAI;
    private h mAJ;
    private i mAK;
    private i mAL;
    private int mAM;
    private boolean mrM;
    private boolean mrN;
    private final m mrm;
    private final Handler mse;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.mAC);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.mAE = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
        this.mse = looper == null ? null : new Handler(looper, this);
        this.mAF = gVar;
        this.mrm = new m();
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.mAF.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        } else if (com.google.android.exoplayer2.util.i.Qp(format.sampleMimeType)) {
            return 1;
        } else {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mAH = formatArr[0];
        if (this.mAI != null) {
            this.mAG = 1;
        } else {
            this.mAI = this.mAF.p(this.mAH);
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void m(long j, boolean z) {
        dym();
        this.mrM = false;
        this.mrN = false;
        if (this.mAG != 0) {
            dyk();
            return;
        }
        FD();
        this.mAI.flush();
    }

    @Override // com.google.android.exoplayer2.s
    public void M(long j, long j2) throws ExoPlaybackException {
        boolean z;
        if (!this.mrN) {
            if (this.mAL == null) {
                this.mAI.gw(j);
                try {
                    this.mAL = this.mAI.duY();
                } catch (SubtitleDecoderException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            }
            if (getState() == 2) {
                if (this.mAK != null) {
                    long dyl = dyl();
                    z = false;
                    while (dyl <= j) {
                        this.mAM++;
                        dyl = dyl();
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (this.mAL != null) {
                    if (this.mAL.duS()) {
                        if (!z && dyl() == Format.OFFSET_SAMPLE_RELATIVE) {
                            if (this.mAG == 2) {
                                dyk();
                            } else {
                                FD();
                                this.mrN = true;
                            }
                        }
                    } else if (this.mAL.mfu <= j) {
                        if (this.mAK != null) {
                            this.mAK.release();
                        }
                        this.mAK = this.mAL;
                        this.mAL = null;
                        this.mAM = this.mAK.gx(j);
                        z = true;
                    }
                }
                if (z) {
                    fi(this.mAK.gy(j));
                }
                if (this.mAG != 2) {
                    while (!this.mrM) {
                        try {
                            if (this.mAJ == null) {
                                this.mAJ = this.mAI.duX();
                                if (this.mAJ == null) {
                                    return;
                                }
                            }
                            if (this.mAG == 1) {
                                this.mAJ.setFlags(4);
                                this.mAI.bx(this.mAJ);
                                this.mAJ = null;
                                this.mAG = 2;
                                return;
                            }
                            int a = a(this.mrm, (com.google.android.exoplayer2.a.e) this.mAJ, false);
                            if (a == -4) {
                                if (this.mAJ.duS()) {
                                    this.mrM = true;
                                } else {
                                    this.mAJ.subsampleOffsetUs = this.mrm.mbs.subsampleOffsetUs;
                                    this.mAJ.dvd();
                                }
                                this.mAI.bx(this.mAJ);
                                this.mAJ = null;
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
    protected void dtm() {
        this.mAH = null;
        dym();
        dyj();
    }

    @Override // com.google.android.exoplayer2.s
    public boolean avU() {
        return this.mrN;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void FD() {
        this.mAJ = null;
        this.mAM = -1;
        if (this.mAK != null) {
            this.mAK.release();
            this.mAK = null;
        }
        if (this.mAL != null) {
            this.mAL.release();
            this.mAL = null;
        }
    }

    private void dyj() {
        FD();
        this.mAI.release();
        this.mAI = null;
        this.mAG = 0;
    }

    private void dyk() {
        dyj();
        this.mAI = this.mAF.p(this.mAH);
    }

    private long dyl() {
        return (this.mAM == -1 || this.mAM >= this.mAK.dyi()) ? Format.OFFSET_SAMPLE_RELATIVE : this.mAK.Lq(this.mAM);
    }

    private void fi(List<b> list) {
        if (this.mse != null) {
            this.mse.obtainMessage(0, list).sendToTarget();
        } else {
            fj(list);
        }
    }

    private void dym() {
        fi(Collections.emptyList());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                fj((List) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void fj(List<b> list) {
        this.mAE.eZ(list);
    }
}
