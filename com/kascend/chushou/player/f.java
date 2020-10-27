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
    protected RelativeLayout pgU;
    protected FrescoThumbnailView pgV;
    protected FrescoThumbnailView pgW;
    protected ImageView pha;
    protected ProgressBar phc;
    protected TextView phd;
    protected TextView phe;
    protected TextView phf;
    protected tv.chushou.zues.c phi;
    protected final io.reactivex.disposables.a pgR = new io.reactivex.disposables.a();
    protected View pgS = null;
    protected View pgT = null;
    protected ImageButton pgX = null;
    protected ImageButton pgY = null;
    protected ImageButton pgZ = null;
    protected PlayerErrorView phb = null;
    protected b phg = null;
    protected Context phh = null;
    protected AudioManager phj = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean phk = false;
    protected long oiq = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int as = 1;
    protected int phl = 0;
    protected String au = "";
    protected String phm = "";
    public String phn = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.pgR.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.pdz != null) {
            this.pdz.setDisplay(surfaceHolder);
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
        if (this.pgT != null && this.pdz != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pgT.getLayoutParams();
            int width = this.pdz.getWidth();
            int height = this.pdz.getHeight();
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
            if (this.pdz != null) {
                this.pdz.setDisplayRect(0, 0, i3, i);
            }
            if (layoutParams.width != i7 || layoutParams.height != i8) {
                layoutParams.width = i7;
                layoutParams.height = i8;
                this.pgT.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        this.ao = i;
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.phg != null) {
            this.phg.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.phh != null) {
            if (((VideoPlayer) this.phh).d) {
                b(((VideoPlayer) this.phh).equ());
                ((VideoPlayer) this.phh).a(((VideoPlayer) this.phh).equ());
                this.pdz = ((VideoPlayer) this.phh).equ();
            } else {
                b(((VideoPlayer) this.phh).eqt());
                ((VideoPlayer) this.phh).a(((VideoPlayer) this.phh).eqt());
                this.pdz = ((VideoPlayer) this.phh).eqt();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.pdz != null) {
            if (this.phg != null) {
                this.phg.b = 0;
                this.phg.c = 0;
            }
            Au(false);
            this.phg.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.phg.d);
                if (this.phg.d) {
                    T();
                    if (this.pgZ != null) {
                        this.pgZ.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.pgY != null) {
                        this.pgY.setVisibility(0);
                    }
                    if (this.pgZ != null) {
                        this.pgZ.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.pgT != null) {
                        this.pgT.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.phh).r != -1 && erR()) {
                    this.oiq = ((VideoPlayer) this.phh).r;
                    ((VideoPlayer) this.phh).r = -1L;
                }
                if (erR() && this.oiq > 0) {
                    this.phi.removeMessages(14);
                    this.pdz.seekTo((int) this.oiq);
                }
                if (!this.ai) {
                    n(false);
                    if (this.phg.d) {
                        W();
                    }
                    if (this.pdz.getDuration() > 60000) {
                        if (this.pdz.getDuration() < 300000) {
                            this.phl = 60000;
                        } else {
                            this.phl = Math.min(this.pdz.getDuration(), 300000);
                        }
                    } else {
                        this.phl = this.pdz.getDuration();
                    }
                } else {
                    a(false, true);
                }
                Av(false);
                return;
            }
            this.phg.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.phk) {
            Av(true);
            if (this.pgS != null) {
                this.pgS.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.phi != null) {
                    this.phi.Ry(5);
                    this.phi.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.phk) {
            h(false);
        } else if (z) {
            if (z2) {
                Av(false);
                if (this.pgS != null) {
                    this.pgS.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.pgS.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.phi != null) {
                        this.phi.removeMessages(5);
                    }
                }
            }
            if (this.phi != null) {
                this.phi.removeMessages(15);
                this.phi.Ry(15);
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
        if ("2".equals(this.ay) && h.eqj().f4085a && this.phg != null && !this.phg.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.phh != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.phf.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.RH(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.phg != null) {
                        if (z) {
                            if (this.phg.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.phg.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.phg.c);
                                if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.phg.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.RH(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.phg.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.phg.b);
                            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.phh).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.phh).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.RH(a.i.str_unsupport_file);
                    break;
            }
            Au(false);
            Av(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(tv.chushou.common.player.a aVar) {
        if (this.pgT != null) {
            this.pgT.setVisibility(0);
            if (aVar != null && (this.pgT instanceof SurfaceView)) {
                aVar.setDisplay(((SurfaceView) this.pgT).getHolder());
            }
        }
    }

    private void b(tv.chushou.common.player.a aVar) {
        if (this.pgT != null && (this.pgT instanceof SurfaceView)) {
            aVar.setDisplay(((SurfaceView) this.pgT).getHolder());
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.pgT != null) {
            if (((VideoPlayer) this.phh).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.phh).d);
                ((VideoPlayer) this.phh).a(((VideoPlayer) this.phh).eqt());
                this.pdz = ((VideoPlayer) this.phh).eqt();
                ((VideoPlayer) this.phh).d = false;
                if (!h.eqj().f4085a) {
                    RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.phg.d) {
                                    f.this.a(((VideoPlayer) f.this.phh).eqt());
                                } else if (f.this.pgT != null) {
                                    f.this.pgT.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.phh).equ().setDisplay(null);
                                ((VideoPlayer) f.this.phh).equ().stop();
                                ((VideoPlayer) f.this.phh).equ().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.phg.d) {
                        a(((VideoPlayer) this.phh).eqt());
                    } else if (this.pgT != null) {
                        this.pgT.setVisibility(8);
                    }
                    ((VideoPlayer) this.phh).equ().setDisplay(null);
                    ((VideoPlayer) this.phh).equ().stop();
                    ((VideoPlayer) this.phh).equ().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.phh).d);
                ((VideoPlayer) this.phh).a(((VideoPlayer) this.phh).equ());
                this.pdz = ((VideoPlayer) this.phh).equ();
                ((VideoPlayer) this.phh).d = true;
                if (!h.eqj().f4085a) {
                    RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.phg.d) {
                                    f.this.a(((VideoPlayer) f.this.phh).equ());
                                } else if (f.this.pgT != null) {
                                    f.this.pgT.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.phh).eqt().setDisplay(null);
                                ((VideoPlayer) f.this.phh).eqt().stop();
                                ((VideoPlayer) f.this.phh).eqt().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.phg.d) {
                        a(((VideoPlayer) this.phh).equ());
                    } else if (this.pgT != null) {
                        this.pgT.setVisibility(8);
                    }
                    ((VideoPlayer) this.phh).eqt().setDisplay(null);
                    ((VideoPlayer) this.phh).eqt().stop();
                    ((VideoPlayer) this.phh).eqt().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.phm);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.phf != null) {
            this.phf.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.phh).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.phh).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.phh).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean Au(boolean z) {
        if (this.pgS == null) {
            return this.ak;
        }
        View findViewById = this.pgS.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.phc.setVisibility(0);
                this.phd.setVisibility(0);
                this.phd.setText(this.phh.getString(a.i.str_get_video_info));
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
        if (this.pgV != null && this.pgW != null && this.pgU != null) {
            if (this.phg.eqU() != null && this.phg.eqU().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.phg.eqU().mRoominfo.mCreatorAvatar)) {
                this.pgV.j(this.phg.eqU().mRoominfo.mCreatorAvatar, 0, b.a.qfa, b.a.qfa);
                this.pgW.j(this.phg.eqU().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.qfa, b.a.qfa);
            } else {
                this.pgV.DK(com.kascend.chushou.view.a.a(null));
                this.pgW.DK(com.kascend.chushou.view.a.a(null));
            }
            this.pgU.setVisibility(0);
            if (this.pgX != null) {
                this.pgX.setEnabled(false);
            }
            R();
            if (this.pgY != null) {
                this.pgY.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.pgU != null) {
            this.pgU.setVisibility(8);
        }
        V();
        if (this.pgX != null) {
            this.pgX.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.pgW != null) {
            this.pgW.clearAnimation();
        }
    }

    protected void W() {
        if (this.pgW != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.pgW.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean erR() {
        return "3".equals(this.phn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Av(boolean z) {
        if (this.pgS == null) {
            return false;
        }
        if (this.pha != null && this.pha.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.pgS.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.pgS.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.phc.setVisibility(0);
            if (this.phg == null || !this.phg.d()) {
                this.phd.setText(this.phh.getString(a.i.str_get_video_info));
                this.phd.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.eqj().f4085a || this.phg == null || this.phg.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.pdz.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.phi != null) {
            this.phi.removeMessages(15);
            this.phi.Ry(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.pgS != null) {
            if (z) {
                if (!this.H && !this.phk) {
                    this.phe.setVisibility(0);
                    return;
                }
                return;
            }
            this.phe.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.phc != null) {
                this.phc.setVisibility(0);
            }
            if (this.phd != null) {
                this.phd.setVisibility(0);
            }
            if (this.phe != null) {
                this.phe.setVisibility(0);
            }
            if (this.phf != null) {
                this.phf.setVisibility(0);
                return;
            }
            return;
        }
        if (this.phc != null) {
            this.phc.setVisibility(8);
        }
        if (this.phd != null) {
            this.phd.setVisibility(8);
        }
        if (this.phe != null) {
            this.phe.setVisibility(8);
        }
        if (this.phf != null) {
            this.phf.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.phb != null) {
            this.phb.setVisibility(0);
            if (z) {
                this.phb.setText(a.i.str_video_player_network_error);
            } else {
                this.phb.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.phi != null) {
            this.phi.E(19, 2000L);
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
            this.phf.setText(spannableStringBuilder);
            this.phf.setVisibility(0);
        }
    }

    public void YT() {
        if (this.pdz != null && this.pdz.getPlayState() == 4) {
            this.pdz.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.pdz.getPlayState() == 4) {
                this.pdz.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.phi != null) {
                this.phi.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa() {
        return this.phh == null || ((Activity) this.phh).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac() {
    }
}
