package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class k extends com.google.android.exoplayer2.a implements Handler.Callback {
    private final m mkT;
    private final Handler mlL;
    private boolean mlt;
    private boolean mlu;
    private final j mum;
    private final g mun;
    private int muo;
    private Format mup;
    private f muq;
    private h mur;
    private i mus;
    private i mut;
    private int muu;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.muk);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.mum = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
        this.mlL = looper == null ? null : new Handler(looper, this);
        this.mun = gVar;
        this.mkT = new m();
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.mun.i(format)) {
            return a((com.google.android.exoplayer2.drm.a<?>) null, format.drmInitData) ? 4 : 2;
        } else if (com.google.android.exoplayer2.util.i.PR(format.sampleMimeType)) {
            return 1;
        } else {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mup = formatArr[0];
        if (this.muq != null) {
            this.muo = 1;
        } else {
            this.muq = this.mun.p(this.mup);
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void j(long j, boolean z) {
        dvp();
        this.mlt = false;
        this.mlu = false;
        if (this.muo != 0) {
            dvn();
            return;
        }
        CE();
        this.muq.flush();
    }

    @Override // com.google.android.exoplayer2.s
    public void N(long j, long j2) throws ExoPlaybackException {
        boolean z;
        if (!this.mlu) {
            if (this.mut == null) {
                this.muq.gs(j);
                try {
                    this.mut = this.muq.drZ();
                } catch (SubtitleDecoderException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            }
            if (getState() == 2) {
                if (this.mus != null) {
                    long dvo = dvo();
                    z = false;
                    while (dvo <= j) {
                        this.muu++;
                        dvo = dvo();
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (this.mut != null) {
                    if (this.mut.drT()) {
                        if (!z && dvo() == Format.OFFSET_SAMPLE_RELATIVE) {
                            if (this.muo == 2) {
                                dvn();
                            } else {
                                CE();
                                this.mlu = true;
                            }
                        }
                    } else if (this.mut.lYY <= j) {
                        if (this.mus != null) {
                            this.mus.release();
                        }
                        this.mus = this.mut;
                        this.mut = null;
                        this.muu = this.mus.gt(j);
                        z = true;
                    }
                }
                if (z) {
                    fn(this.mus.gu(j));
                }
                if (this.muo != 2) {
                    while (!this.mlt) {
                        try {
                            if (this.mur == null) {
                                this.mur = this.muq.drY();
                                if (this.mur == null) {
                                    return;
                                }
                            }
                            if (this.muo == 1) {
                                this.mur.setFlags(4);
                                this.muq.bu(this.mur);
                                this.mur = null;
                                this.muo = 2;
                                return;
                            }
                            int a = a(this.mkT, (com.google.android.exoplayer2.a.e) this.mur, false);
                            if (a == -4) {
                                if (this.mur.drT()) {
                                    this.mlt = true;
                                } else {
                                    this.mur.subsampleOffsetUs = this.mkT.lUU.subsampleOffsetUs;
                                    this.mur.dse();
                                }
                                this.muq.bu(this.mur);
                                this.mur = null;
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
    protected void dqm() {
        this.mup = null;
        dvp();
        dvm();
    }

    @Override // com.google.android.exoplayer2.s
    public boolean ati() {
        return this.mlu;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void CE() {
        this.mur = null;
        this.muu = -1;
        if (this.mus != null) {
            this.mus.release();
            this.mus = null;
        }
        if (this.mut != null) {
            this.mut.release();
            this.mut = null;
        }
    }

    private void dvm() {
        CE();
        this.muq.release();
        this.muq = null;
        this.muo = 0;
    }

    private void dvn() {
        dvm();
        this.muq = this.mun.p(this.mup);
    }

    private long dvo() {
        return (this.muu == -1 || this.muu >= this.mus.dvl()) ? Format.OFFSET_SAMPLE_RELATIVE : this.mus.KW(this.muu);
    }

    private void fn(List<b> list) {
        if (this.mlL != null) {
            this.mlL.obtainMessage(0, list).sendToTarget();
        } else {
            fo(list);
        }
    }

    private void dvp() {
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
        this.mum.fe(list);
    }
}
