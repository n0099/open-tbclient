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
    private final m moN;
    private final Handler mpF;
    private boolean mpn;
    private boolean mpo;
    private final j mye;
    private final g myf;
    private int myg;
    private Format myh;
    private f myi;
    private h myj;
    private i myk;
    private i myl;
    private int mym;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.myc);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.mye = (j) com.google.android.exoplayer2.util.a.checkNotNull(jVar);
        this.mpF = looper == null ? null : new Handler(looper, this);
        this.myf = gVar;
        this.moN = new m();
    }

    @Override // com.google.android.exoplayer2.t
    public int e(Format format) {
        if (this.myf.i(format)) {
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
        this.myh = formatArr[0];
        if (this.myi != null) {
            this.myg = 1;
        } else {
            this.myi = this.myf.p(this.myh);
        }
    }

    @Override // com.google.android.exoplayer2.a
    protected void j(long j, boolean z) {
        dwC();
        this.mpn = false;
        this.mpo = false;
        if (this.myg != 0) {
            dwA();
            return;
        }
        Da();
        this.myi.flush();
    }

    @Override // com.google.android.exoplayer2.s
    public void N(long j, long j2) throws ExoPlaybackException {
        boolean z;
        if (!this.mpo) {
            if (this.myl == null) {
                this.myi.gx(j);
                try {
                    this.myl = this.myi.dtn();
                } catch (SubtitleDecoderException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            }
            if (getState() == 2) {
                if (this.myk != null) {
                    long dwB = dwB();
                    z = false;
                    while (dwB <= j) {
                        this.mym++;
                        dwB = dwB();
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (this.myl != null) {
                    if (this.myl.dth()) {
                        if (!z && dwB() == Format.OFFSET_SAMPLE_RELATIVE) {
                            if (this.myg == 2) {
                                dwA();
                            } else {
                                Da();
                                this.mpo = true;
                            }
                        }
                    } else if (this.myl.mcV <= j) {
                        if (this.myk != null) {
                            this.myk.release();
                        }
                        this.myk = this.myl;
                        this.myl = null;
                        this.mym = this.myk.gy(j);
                        z = true;
                    }
                }
                if (z) {
                    fn(this.myk.gz(j));
                }
                if (this.myg != 2) {
                    while (!this.mpn) {
                        try {
                            if (this.myj == null) {
                                this.myj = this.myi.dtm();
                                if (this.myj == null) {
                                    return;
                                }
                            }
                            if (this.myg == 1) {
                                this.myj.setFlags(4);
                                this.myi.bv(this.myj);
                                this.myj = null;
                                this.myg = 2;
                                return;
                            }
                            int a = a(this.moN, (com.google.android.exoplayer2.a.e) this.myj, false);
                            if (a == -4) {
                                if (this.myj.dth()) {
                                    this.mpn = true;
                                } else {
                                    this.myj.subsampleOffsetUs = this.moN.lYQ.subsampleOffsetUs;
                                    this.myj.dts();
                                }
                                this.myi.bv(this.myj);
                                this.myj = null;
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
    protected void drA() {
        this.myh = null;
        dwC();
        dwz();
    }

    @Override // com.google.android.exoplayer2.s
    public boolean atB() {
        return this.mpo;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return true;
    }

    private void Da() {
        this.myj = null;
        this.mym = -1;
        if (this.myk != null) {
            this.myk.release();
            this.myk = null;
        }
        if (this.myl != null) {
            this.myl.release();
            this.myl = null;
        }
    }

    private void dwz() {
        Da();
        this.myi.release();
        this.myi = null;
        this.myg = 0;
    }

    private void dwA() {
        dwz();
        this.myi = this.myf.p(this.myh);
    }

    private long dwB() {
        return (this.mym == -1 || this.mym >= this.myk.dwy()) ? Format.OFFSET_SAMPLE_RELATIVE : this.myk.Lf(this.mym);
    }

    private void fn(List<b> list) {
        if (this.mpF != null) {
            this.mpF.obtainMessage(0, list).sendToTarget();
        } else {
            fo(list);
        }
    }

    private void dwC() {
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
        this.mye.fe(list);
    }
}
