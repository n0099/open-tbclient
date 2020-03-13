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
    private final m mpG;
    private boolean mqg;
    private boolean mqh;
    private final Handler mqy;
    private final j myX;
    private final g myY;
    private int myZ;
    private Format mza;
    private f mzb;
    private h mzc;
    private i mzd;
    private i mze;
    private int mzf;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.myV);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.myX = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
        this.mqy = looper == null ? null : new Handler(looper, this);
        this.myY = gVar;
        this.mpG = new m();
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.myY.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        } else if (com.google.android.exoplayer2.util.i.Qq(format.sampleMimeType)) {
            return 1;
        } else {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mza = formatArr[0];
        if (this.mzb != null) {
            this.myZ = 1;
        } else {
            this.mzb = this.myY.p(this.mza);
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void l(long j, boolean z) {
        dxP();
        this.mqg = false;
        this.mqh = false;
        if (this.myZ != 0) {
            dxN();
            return;
        }
        Fy();
        this.mzb.flush();
    }

    @Override // com.google.android.exoplayer2.s
    public void M(long j, long j2) throws ExoPlaybackException {
        boolean z;
        if (!this.mqh) {
            if (this.mze == null) {
                this.mzb.gv(j);
                try {
                    this.mze = this.mzb.duB();
                } catch (SubtitleDecoderException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            }
            if (getState() == 2) {
                if (this.mzd != null) {
                    long dxO = dxO();
                    z = false;
                    while (dxO <= j) {
                        this.mzf++;
                        dxO = dxO();
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (this.mze != null) {
                    if (this.mze.duv()) {
                        if (!z && dxO() == Format.OFFSET_SAMPLE_RELATIVE) {
                            if (this.myZ == 2) {
                                dxN();
                            } else {
                                Fy();
                                this.mqh = true;
                            }
                        }
                    } else if (this.mze.mdO <= j) {
                        if (this.mzd != null) {
                            this.mzd.release();
                        }
                        this.mzd = this.mze;
                        this.mze = null;
                        this.mzf = this.mzd.gw(j);
                        z = true;
                    }
                }
                if (z) {
                    fi(this.mzd.gx(j));
                }
                if (this.myZ != 2) {
                    while (!this.mqg) {
                        try {
                            if (this.mzc == null) {
                                this.mzc = this.mzb.duA();
                                if (this.mzc == null) {
                                    return;
                                }
                            }
                            if (this.myZ == 1) {
                                this.mzc.setFlags(4);
                                this.mzb.bx(this.mzc);
                                this.mzc = null;
                                this.myZ = 2;
                                return;
                            }
                            int a = a(this.mpG, (com.google.android.exoplayer2.a.e) this.mzc, false);
                            if (a == -4) {
                                if (this.mzc.duv()) {
                                    this.mqg = true;
                                } else {
                                    this.mzc.subsampleOffsetUs = this.mpG.lZJ.subsampleOffsetUs;
                                    this.mzc.duG();
                                }
                                this.mzb.bx(this.mzc);
                                this.mzc = null;
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
    protected void dsP() {
        this.mza = null;
        dxP();
        dxM();
    }

    @Override // com.google.android.exoplayer2.s
    public boolean avR() {
        return this.mqh;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void Fy() {
        this.mzc = null;
        this.mzf = -1;
        if (this.mzd != null) {
            this.mzd.release();
            this.mzd = null;
        }
        if (this.mze != null) {
            this.mze.release();
            this.mze = null;
        }
    }

    private void dxM() {
        Fy();
        this.mzb.release();
        this.mzb = null;
        this.myZ = 0;
    }

    private void dxN() {
        dxM();
        this.mzb = this.myY.p(this.mza);
    }

    private long dxO() {
        return (this.mzf == -1 || this.mzf >= this.mzd.dxL()) ? Format.OFFSET_SAMPLE_RELATIVE : this.mzd.Lk(this.mzf);
    }

    private void fi(List<b> list) {
        if (this.mqy != null) {
            this.mqy.obtainMessage(0, list).sendToTarget();
        } else {
            fj(list);
        }
    }

    private void dxP() {
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
        this.myX.eZ(list);
    }
}
