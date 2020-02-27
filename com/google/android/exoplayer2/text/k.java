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
    private boolean mpT;
    private boolean mpU;
    private final m mpt;
    private final Handler mql;
    private final j myK;
    private final g myL;
    private int myM;
    private Format myN;
    private f myO;
    private h myP;
    private i myQ;
    private i myR;
    private int myS;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.myI);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.myK = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
        this.mql = looper == null ? null : new Handler(looper, this);
        this.myL = gVar;
        this.mpt = new m();
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.myL.i(format)) {
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
        this.myN = formatArr[0];
        if (this.myO != null) {
            this.myM = 1;
        } else {
            this.myO = this.myL.p(this.myN);
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void l(long j, boolean z) {
        dxM();
        this.mpT = false;
        this.mpU = false;
        if (this.myM != 0) {
            dxK();
            return;
        }
        Fw();
        this.myO.flush();
    }

    @Override // com.google.android.exoplayer2.s
    public void M(long j, long j2) throws ExoPlaybackException {
        boolean z;
        if (!this.mpU) {
            if (this.myR == null) {
                this.myO.gv(j);
                try {
                    this.myR = this.myO.duy();
                } catch (SubtitleDecoderException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            }
            if (getState() == 2) {
                if (this.myQ != null) {
                    long dxL = dxL();
                    z = false;
                    while (dxL <= j) {
                        this.myS++;
                        dxL = dxL();
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (this.myR != null) {
                    if (this.myR.dus()) {
                        if (!z && dxL() == Format.OFFSET_SAMPLE_RELATIVE) {
                            if (this.myM == 2) {
                                dxK();
                            } else {
                                Fw();
                                this.mpU = true;
                            }
                        }
                    } else if (this.myR.mdB <= j) {
                        if (this.myQ != null) {
                            this.myQ.release();
                        }
                        this.myQ = this.myR;
                        this.myR = null;
                        this.myS = this.myQ.gw(j);
                        z = true;
                    }
                }
                if (z) {
                    fi(this.myQ.gx(j));
                }
                if (this.myM != 2) {
                    while (!this.mpT) {
                        try {
                            if (this.myP == null) {
                                this.myP = this.myO.dux();
                                if (this.myP == null) {
                                    return;
                                }
                            }
                            if (this.myM == 1) {
                                this.myP.setFlags(4);
                                this.myO.bx(this.myP);
                                this.myP = null;
                                this.myM = 2;
                                return;
                            }
                            int a = a(this.mpt, (com.google.android.exoplayer2.a.e) this.myP, false);
                            if (a == -4) {
                                if (this.myP.dus()) {
                                    this.mpT = true;
                                } else {
                                    this.myP.subsampleOffsetUs = this.mpt.lZw.subsampleOffsetUs;
                                    this.myP.duD();
                                }
                                this.myO.bx(this.myP);
                                this.myP = null;
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
    protected void dsM() {
        this.myN = null;
        dxM();
        dxJ();
    }

    @Override // com.google.android.exoplayer2.s
    public boolean avP() {
        return this.mpU;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void Fw() {
        this.myP = null;
        this.myS = -1;
        if (this.myQ != null) {
            this.myQ.release();
            this.myQ = null;
        }
        if (this.myR != null) {
            this.myR.release();
            this.myR = null;
        }
    }

    private void dxJ() {
        Fw();
        this.myO.release();
        this.myO = null;
        this.myM = 0;
    }

    private void dxK() {
        dxJ();
        this.myO = this.myL.p(this.myN);
    }

    private long dxL() {
        return (this.myS == -1 || this.myS >= this.myQ.dxI()) ? Format.OFFSET_SAMPLE_RELATIVE : this.myQ.Lk(this.myS);
    }

    private void fi(List<b> list) {
        if (this.mql != null) {
            this.mql.obtainMessage(0, list).sendToTarget();
        } else {
            fj(list);
        }
    }

    private void dxM() {
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
        this.myK.eZ(list);
    }
}
