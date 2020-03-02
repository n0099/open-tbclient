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
    private boolean mpV;
    private boolean mpW;
    private final m mpv;
    private final Handler mqn;
    private final j myM;
    private final g myN;
    private int myO;
    private Format myP;
    private f myQ;
    private h myR;
    private i myS;
    private i myT;
    private int myU;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.myK);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.myM = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
        this.mqn = looper == null ? null : new Handler(looper, this);
        this.myN = gVar;
        this.mpv = new m();
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.myN.i(format)) {
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
        this.myP = formatArr[0];
        if (this.myQ != null) {
            this.myO = 1;
        } else {
            this.myQ = this.myN.p(this.myP);
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void l(long j, boolean z) {
        dxO();
        this.mpV = false;
        this.mpW = false;
        if (this.myO != 0) {
            dxM();
            return;
        }
        Fy();
        this.myQ.flush();
    }

    @Override // com.google.android.exoplayer2.s
    public void M(long j, long j2) throws ExoPlaybackException {
        boolean z;
        if (!this.mpW) {
            if (this.myT == null) {
                this.myQ.gv(j);
                try {
                    this.myT = this.myQ.duA();
                } catch (SubtitleDecoderException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            }
            if (getState() == 2) {
                if (this.myS != null) {
                    long dxN = dxN();
                    z = false;
                    while (dxN <= j) {
                        this.myU++;
                        dxN = dxN();
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (this.myT != null) {
                    if (this.myT.duu()) {
                        if (!z && dxN() == Format.OFFSET_SAMPLE_RELATIVE) {
                            if (this.myO == 2) {
                                dxM();
                            } else {
                                Fy();
                                this.mpW = true;
                            }
                        }
                    } else if (this.myT.mdD <= j) {
                        if (this.myS != null) {
                            this.myS.release();
                        }
                        this.myS = this.myT;
                        this.myT = null;
                        this.myU = this.myS.gw(j);
                        z = true;
                    }
                }
                if (z) {
                    fi(this.myS.gx(j));
                }
                if (this.myO != 2) {
                    while (!this.mpV) {
                        try {
                            if (this.myR == null) {
                                this.myR = this.myQ.duz();
                                if (this.myR == null) {
                                    return;
                                }
                            }
                            if (this.myO == 1) {
                                this.myR.setFlags(4);
                                this.myQ.bx(this.myR);
                                this.myR = null;
                                this.myO = 2;
                                return;
                            }
                            int a = a(this.mpv, (com.google.android.exoplayer2.a.e) this.myR, false);
                            if (a == -4) {
                                if (this.myR.duu()) {
                                    this.mpV = true;
                                } else {
                                    this.myR.subsampleOffsetUs = this.mpv.lZy.subsampleOffsetUs;
                                    this.myR.duF();
                                }
                                this.myQ.bx(this.myR);
                                this.myR = null;
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
    protected void dsO() {
        this.myP = null;
        dxO();
        dxL();
    }

    @Override // com.google.android.exoplayer2.s
    public boolean avR() {
        return this.mpW;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void Fy() {
        this.myR = null;
        this.myU = -1;
        if (this.myS != null) {
            this.myS.release();
            this.myS = null;
        }
        if (this.myT != null) {
            this.myT.release();
            this.myT = null;
        }
    }

    private void dxL() {
        Fy();
        this.myQ.release();
        this.myQ = null;
        this.myO = 0;
    }

    private void dxM() {
        dxL();
        this.myQ = this.myN.p(this.myP);
    }

    private long dxN() {
        return (this.myU == -1 || this.myU >= this.myS.dxK()) ? Format.OFFSET_SAMPLE_RELATIVE : this.myS.Lk(this.myU);
    }

    private void fi(List<b> list) {
        if (this.mqn != null) {
            this.mqn.obtainMessage(0, list).sendToTarget();
        } else {
            fj(list);
        }
    }

    private void dxO() {
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
        this.myM.eZ(list);
    }
}
