package com.kascend.chushou.player;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.d.h;
import com.kascend.chushou.player.ui.PlayerErrorView;
import java.util.concurrent.TimeUnit;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes6.dex */
public abstract class f extends e implements SurfaceHolder.Callback {
    protected ImageView Q;
    protected TextView S;
    protected TextView T;
    protected int ao;
    protected RelativeLayout opF;
    protected FrescoThumbnailView opG;
    protected FrescoThumbnailView opH;
    protected ImageView opL;
    protected ProgressBar opN;
    protected TextView opO;
    protected TextView opP;
    protected TextView opQ;
    protected tv.chushou.zues.c opT;
    protected final io.reactivex.disposables.a opC = new io.reactivex.disposables.a();
    protected View opD = null;
    protected View opE = null;
    protected ImageButton opI = null;
    protected ImageButton opJ = null;
    protected ImageButton opK = null;
    protected PlayerErrorView opM = null;
    protected b opR = null;
    protected Context opS = null;
    protected AudioManager opU = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean opV = false;
    protected long nFO = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int as = 1;
    protected int opW = 0;
    protected String au = "";
    protected String opX = "";
    public String opY = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.opC.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.omi != null) {
            this.omi.setDisplay(surfaceHolder);
        }
        this.aj = true;
        Q();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.aj = false;
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceDestroyed");
    }

    protected void Q() {
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", ">>>>>>>>>SetVideoViewLayout<<<<<<<<<<<<<<<<");
        if (this.opE != null && this.omi != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.opE.getLayoutParams();
            int width = this.omi.getWidth();
            int height = this.omi.getHeight();
            if (this.ap >= 0) {
                if (width > height && this.ap == 1) {
                    d(0);
                    return;
                } else if (width < height && (this.ap == 0 || this.ap == 6)) {
                    d(1);
                    h(1);
                    return;
                }
            }
            tv.chushou.zues.utils.e.i("VideoPlayerLiveBaseFragment", String.format("width = %d,height = %d;mPlayAreaWidth=%d, mPlayAreaHeight=%d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(this.ar), Integer.valueOf(this.aq)));
            int i7 = this.ar;
            int i8 = this.aq;
            if (width <= 0 || height <= 0) {
                width = this.ar;
                height = this.aq;
            }
            if (width == 0 || height == 0) {
                i = height;
                i2 = 0;
                i3 = width;
                i4 = 0;
            } else if (width > i7 || height > i8) {
                if ((i7 * height) / width > i8) {
                    int i9 = (i8 * width) / height;
                    if (i9 > i7) {
                        i = (i7 * height) / width;
                        i3 = i7;
                    } else {
                        i3 = i9;
                        i = i8;
                    }
                } else {
                    i = (i7 * height) / width;
                    if (i > i8) {
                        i3 = (i8 * width) / height;
                        i = i8;
                    } else {
                        i3 = i7;
                    }
                }
                i4 = i;
                i2 = i3;
            } else {
                i = height;
                i2 = 0;
                i3 = width;
                i4 = 0;
            }
            int i10 = this.as;
            if (i10 == 0) {
                if ((i8 * i3) / i >= i7) {
                    i7 = (i3 * i8) / i;
                } else if ((i7 * i) / i3 >= i8) {
                    i8 = (i * i7) / i3;
                }
                i = i8;
                i3 = i7;
            } else if (i10 == 1) {
                if (i3 == 0 || i == 0) {
                    i8 = i4;
                    i7 = i2;
                } else if ((i7 * i) / i3 > i8) {
                    i6 = (i8 * i3) / i;
                    if (i6 > i7) {
                        i8 = (i7 * i) / i3;
                    }
                    i7 = i6;
                } else {
                    i5 = (i7 * i) / i3;
                    if (i5 > i8) {
                        i7 = (i8 * i3) / i;
                    }
                    i8 = i5;
                }
            } else if (i10 == 2) {
                if (i3 <= i7 && i <= i8) {
                    i8 = i;
                    i7 = i3;
                } else if ((i7 * i) / i3 > i8) {
                    i6 = (i8 * i3) / i;
                    if (i6 > i7) {
                        i8 = (i7 * i) / i3;
                    }
                    i7 = i6;
                } else {
                    i5 = (i7 * i) / i3;
                    if (i5 > i8) {
                        i7 = (i8 * i3) / i;
                    }
                    i8 = i5;
                }
            } else {
                i7 = this.ar;
                i8 = this.aq;
            }
            tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "SetVideoViewLayout out <<<< w:" + layoutParams.width + " h:" + layoutParams.height);
            if (this.omi != null) {
                this.omi.setDisplayRect(0, 0, i3, i);
            }
            if (layoutParams.width != i7 || layoutParams.height != i8) {
                layoutParams.width = i7;
                layoutParams.height = i8;
                this.opE.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        this.ao = i;
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.opR != null) {
            this.opR.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.opS != null) {
            if (((VideoPlayer) this.opS).d) {
                b(((VideoPlayer) this.opS).egu());
                ((VideoPlayer) this.opS).a(((VideoPlayer) this.opS).egu());
                this.omi = ((VideoPlayer) this.opS).egu();
            } else {
                b(((VideoPlayer) this.opS).egt());
                ((VideoPlayer) this.opS).a(((VideoPlayer) this.opS).egt());
                this.omi = ((VideoPlayer) this.opS).egt();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.omi != null) {
            if (this.opR != null) {
                this.opR.b = 0;
                this.opR.c = 0;
            }
            zm(false);
            this.opR.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.opR.d);
                if (this.opR.d) {
                    T();
                    if (this.opK != null) {
                        this.opK.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.opJ != null) {
                        this.opJ.setVisibility(0);
                    }
                    if (this.opK != null) {
                        this.opK.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.opE != null) {
                        this.opE.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.opS).r != -1 && ehR()) {
                    this.nFO = ((VideoPlayer) this.opS).r;
                    ((VideoPlayer) this.opS).r = -1L;
                }
                if (ehR() && this.nFO > 0) {
                    this.opT.removeMessages(14);
                    this.omi.seekTo((int) this.nFO);
                }
                if (!this.ai) {
                    n(false);
                    if (this.opR.d) {
                        W();
                    }
                    if (this.omi.getDuration() > 60000) {
                        if (this.omi.getDuration() < 300000) {
                            this.opW = 60000;
                        } else {
                            this.opW = Math.min(this.omi.getDuration(), 300000);
                        }
                    } else {
                        this.opW = this.omi.getDuration();
                    }
                } else {
                    a(false, true);
                }
                zn(false);
                return;
            }
            this.opR.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.opV) {
            zn(true);
            if (this.opD != null) {
                this.opD.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.opT != null) {
                    this.opT.PH(5);
                    this.opT.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.opV) {
            h(false);
        } else if (z) {
            if (z2) {
                zn(false);
                if (this.opD != null) {
                    this.opD.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.opD.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.opT != null) {
                        this.opT.removeMessages(5);
                    }
                }
            }
            if (this.opT != null) {
                this.opT.removeMessages(15);
                this.opT.PH(15);
            }
            a(z2, z3);
        } else {
            a(true, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if ("2".equals(this.ay) && h.egj().f4087a && this.opR != null && !this.opR.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.opS != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.opQ.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.PQ(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.opR != null) {
                        if (z) {
                            if (this.opR.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.opR.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.opR.c);
                                if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.opR.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.PQ(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.opR.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.opR.b);
                            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.opS).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.opS).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.PQ(a.i.str_unsupport_file);
                    break;
            }
            zm(false);
            zn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(tv.chushou.common.player.a aVar) {
        if (this.opE != null) {
            this.opE.setVisibility(0);
            if (aVar != null && (this.opE instanceof SurfaceView)) {
                aVar.setDisplay(((SurfaceView) this.opE).getHolder());
            }
        }
    }

    private void b(tv.chushou.common.player.a aVar) {
        if (this.opE != null && (this.opE instanceof SurfaceView)) {
            aVar.setDisplay(((SurfaceView) this.opE).getHolder());
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.opE != null) {
            if (((VideoPlayer) this.opS).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.opS).d);
                ((VideoPlayer) this.opS).a(((VideoPlayer) this.opS).egt());
                this.omi = ((VideoPlayer) this.opS).egt();
                ((VideoPlayer) this.opS).d = false;
                if (!h.egj().f4087a) {
                    RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.opR.d) {
                                    f.this.a(((VideoPlayer) f.this.opS).egt());
                                } else if (f.this.opE != null) {
                                    f.this.opE.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.opS).egu().setDisplay(null);
                                ((VideoPlayer) f.this.opS).egu().stop();
                                ((VideoPlayer) f.this.opS).egu().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.opR.d) {
                        a(((VideoPlayer) this.opS).egt());
                    } else if (this.opE != null) {
                        this.opE.setVisibility(8);
                    }
                    ((VideoPlayer) this.opS).egu().setDisplay(null);
                    ((VideoPlayer) this.opS).egu().stop();
                    ((VideoPlayer) this.opS).egu().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.opS).d);
                ((VideoPlayer) this.opS).a(((VideoPlayer) this.opS).egu());
                this.omi = ((VideoPlayer) this.opS).egu();
                ((VideoPlayer) this.opS).d = true;
                if (!h.egj().f4087a) {
                    RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.opR.d) {
                                    f.this.a(((VideoPlayer) f.this.opS).egu());
                                } else if (f.this.opE != null) {
                                    f.this.opE.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.opS).egt().setDisplay(null);
                                ((VideoPlayer) f.this.opS).egt().stop();
                                ((VideoPlayer) f.this.opS).egt().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.opR.d) {
                        a(((VideoPlayer) this.opS).egu());
                    } else if (this.opE != null) {
                        this.opE.setVisibility(8);
                    }
                    ((VideoPlayer) this.opS).egt().setDisplay(null);
                    ((VideoPlayer) this.opS).egt().stop();
                    ((VideoPlayer) this.opS).egt().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.opX);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.opQ != null) {
            this.opQ.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.opS).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.opS).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.opS).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean zm(boolean z) {
        if (this.opD == null) {
            return this.ak;
        }
        View findViewById = this.opD.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.opN.setVisibility(0);
                this.opO.setVisibility(0);
                this.opO.setText(this.opS.getString(a.i.str_get_video_info));
            }
            this.ak = true;
        }
        return this.ak;
    }

    protected void R() {
    }

    protected void S() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.opG != null && this.opH != null && this.opF != null) {
            if (this.opR.egU() != null && this.opR.egU().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.opR.egU().mRoominfo.mCreatorAvatar)) {
                this.opG.i(this.opR.egU().mRoominfo.mCreatorAvatar, 0, b.a.pnM, b.a.pnM);
                this.opH.i(this.opR.egU().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.pnM, b.a.pnM);
            } else {
                this.opG.Dr(com.kascend.chushou.view.a.a(null));
                this.opH.Dr(com.kascend.chushou.view.a.a(null));
            }
            this.opF.setVisibility(0);
            if (this.opI != null) {
                this.opI.setEnabled(false);
            }
            R();
            if (this.opJ != null) {
                this.opJ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.opF != null) {
            this.opF.setVisibility(8);
        }
        V();
        if (this.opI != null) {
            this.opI.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.opH != null) {
            this.opH.clearAnimation();
        }
    }

    protected void W() {
        if (this.opH != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.opH.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ehR() {
        return "3".equals(this.opY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zn(boolean z) {
        if (this.opD == null) {
            return false;
        }
        if (this.opL != null && this.opL.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.opD.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.opD.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.opN.setVisibility(0);
            if (this.opR == null || !this.opR.d()) {
                this.opO.setText(this.opS.getString(a.i.str_get_video_info));
                this.opO.setVisibility(0);
            }
            a(false, false);
        } else {
            f(false);
        }
        this.ak = z;
        return this.ak;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(boolean z) {
        if (!"2".equals(this.ay) || !h.egj().f4087a || this.opR == null || this.opR.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.omi.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.opT != null) {
            this.opT.removeMessages(15);
            this.opT.PH(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.opD != null) {
            if (z) {
                if (!this.H && !this.opV) {
                    this.opP.setVisibility(0);
                    return;
                }
                return;
            }
            this.opP.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.opN != null) {
                this.opN.setVisibility(0);
            }
            if (this.opO != null) {
                this.opO.setVisibility(0);
            }
            if (this.opP != null) {
                this.opP.setVisibility(0);
            }
            if (this.opQ != null) {
                this.opQ.setVisibility(0);
                return;
            }
            return;
        }
        if (this.opN != null) {
            this.opN.setVisibility(8);
        }
        if (this.opO != null) {
            this.opO.setVisibility(8);
        }
        if (this.opP != null) {
            this.opP.setVisibility(8);
        }
        if (this.opQ != null) {
            this.opQ.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.opM != null) {
            this.opM.setVisibility(0);
            if (z) {
                this.opM.setText(a.i.str_video_player_network_error);
            } else {
                this.opM.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.opT != null) {
            this.opT.D(19, 2000L);
        }
    }

    public void a(String str, String str2, boolean z) {
        if (!str2.isEmpty()) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (z) {
                spannableStringBuilder.append((CharSequence) getString(a.i.changed_lines));
            } else {
                spannableStringBuilder.append((CharSequence) getString(a.i.changing_lines));
            }
            spannableStringBuilder.append((CharSequence) (str + " "));
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#ff5959")), length, spannableStringBuilder.length(), 17);
            if (!z) {
                spannableStringBuilder.append((CharSequence) getString(a.i.please_waiting));
            }
            this.opQ.setText(spannableStringBuilder);
            this.opQ.setVisibility(0);
        }
    }

    public void WZ() {
        if (this.omi != null && this.omi.getPlayState() == 4) {
            this.omi.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.omi.getPlayState() == 4) {
                this.omi.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.opT != null) {
                this.opT.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa() {
        return this.opS == null || ((Activity) this.opS).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac() {
    }
}
