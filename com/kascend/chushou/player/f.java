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
    protected RelativeLayout prY;
    protected FrescoThumbnailView prZ;
    protected FrescoThumbnailView psa;
    protected ImageView pse;
    protected ProgressBar psg;
    protected TextView psh;
    protected TextView psi;
    protected TextView psj;
    protected tv.chushou.zues.c psm;
    protected final io.reactivex.disposables.a prV = new io.reactivex.disposables.a();
    protected View prW = null;
    protected View prX = null;
    protected ImageButton psb = null;
    protected ImageButton psc = null;
    protected ImageButton psd = null;
    protected PlayerErrorView psf = null;
    protected b psk = null;
    protected Context psl = null;
    protected AudioManager psn = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean pso = false;
    protected long osZ = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int as = 1;
    protected int psp = 0;
    protected String au = "";
    protected String psq = "";
    public String psr = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.prV.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.poC != null) {
            this.poC.setDisplay(surfaceHolder);
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
        if (this.prX != null && this.poC != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.prX.getLayoutParams();
            int width = this.poC.getWidth();
            int height = this.poC.getHeight();
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
            if (this.poC != null) {
                this.poC.setDisplayRect(0, 0, i3, i);
            }
            if (layoutParams.width != i7 || layoutParams.height != i8) {
                layoutParams.width = i7;
                layoutParams.height = i8;
                this.prX.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        this.ao = i;
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.psk != null) {
            this.psk.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.psl != null) {
            if (((VideoPlayer) this.psl).d) {
                b(((VideoPlayer) this.psl).euj());
                ((VideoPlayer) this.psl).a(((VideoPlayer) this.psl).euj());
                this.poC = ((VideoPlayer) this.psl).euj();
            } else {
                b(((VideoPlayer) this.psl).eui());
                ((VideoPlayer) this.psl).a(((VideoPlayer) this.psl).eui());
                this.poC = ((VideoPlayer) this.psl).eui();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.poC != null) {
            if (this.psk != null) {
                this.psk.b = 0;
                this.psk.c = 0;
            }
            AM(false);
            this.psk.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.psk.d);
                if (this.psk.d) {
                    T();
                    if (this.psd != null) {
                        this.psd.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.psc != null) {
                        this.psc.setVisibility(0);
                    }
                    if (this.psd != null) {
                        this.psd.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.prX != null) {
                        this.prX.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.psl).r != -1 && evG()) {
                    this.osZ = ((VideoPlayer) this.psl).r;
                    ((VideoPlayer) this.psl).r = -1L;
                }
                if (evG() && this.osZ > 0) {
                    this.psm.removeMessages(14);
                    this.poC.seekTo((int) this.osZ);
                }
                if (!this.ai) {
                    n(false);
                    if (this.psk.d) {
                        W();
                    }
                    if (this.poC.getDuration() > 60000) {
                        if (this.poC.getDuration() < 300000) {
                            this.psp = 60000;
                        } else {
                            this.psp = Math.min(this.poC.getDuration(), 300000);
                        }
                    } else {
                        this.psp = this.poC.getDuration();
                    }
                } else {
                    a(false, true);
                }
                AN(false);
                return;
            }
            this.psk.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.pso) {
            AN(true);
            if (this.prW != null) {
                this.prW.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.psm != null) {
                    this.psm.Sv(5);
                    this.psm.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.pso) {
            h(false);
        } else if (z) {
            if (z2) {
                AN(false);
                if (this.prW != null) {
                    this.prW.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.prW.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.psm != null) {
                        this.psm.removeMessages(5);
                    }
                }
            }
            if (this.psm != null) {
                this.psm.removeMessages(15);
                this.psm.Sv(15);
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
        if ("2".equals(this.ay) && h.etY().f4087a && this.psk != null && !this.psk.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.psl != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.psj.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.SE(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.psk != null) {
                        if (z) {
                            if (this.psk.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.psk.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.psk.c);
                                if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.psk.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.SE(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.psk.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.psk.b);
                            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.psl).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.psl).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.SE(a.i.str_unsupport_file);
                    break;
            }
            AM(false);
            AN(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(tv.chushou.common.player.a aVar) {
        if (this.prX != null) {
            this.prX.setVisibility(0);
            if (aVar != null && (this.prX instanceof SurfaceView)) {
                aVar.setDisplay(((SurfaceView) this.prX).getHolder());
            }
        }
    }

    private void b(tv.chushou.common.player.a aVar) {
        if (this.prX != null && (this.prX instanceof SurfaceView)) {
            aVar.setDisplay(((SurfaceView) this.prX).getHolder());
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.prX != null) {
            if (((VideoPlayer) this.psl).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.psl).d);
                ((VideoPlayer) this.psl).a(((VideoPlayer) this.psl).eui());
                this.poC = ((VideoPlayer) this.psl).eui();
                ((VideoPlayer) this.psl).d = false;
                if (!h.etY().f4087a) {
                    RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.psk.d) {
                                    f.this.a(((VideoPlayer) f.this.psl).eui());
                                } else if (f.this.prX != null) {
                                    f.this.prX.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.psl).euj().setDisplay(null);
                                ((VideoPlayer) f.this.psl).euj().stop();
                                ((VideoPlayer) f.this.psl).euj().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.psk.d) {
                        a(((VideoPlayer) this.psl).eui());
                    } else if (this.prX != null) {
                        this.prX.setVisibility(8);
                    }
                    ((VideoPlayer) this.psl).euj().setDisplay(null);
                    ((VideoPlayer) this.psl).euj().stop();
                    ((VideoPlayer) this.psl).euj().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.psl).d);
                ((VideoPlayer) this.psl).a(((VideoPlayer) this.psl).euj());
                this.poC = ((VideoPlayer) this.psl).euj();
                ((VideoPlayer) this.psl).d = true;
                if (!h.etY().f4087a) {
                    RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.psk.d) {
                                    f.this.a(((VideoPlayer) f.this.psl).euj());
                                } else if (f.this.prX != null) {
                                    f.this.prX.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.psl).eui().setDisplay(null);
                                ((VideoPlayer) f.this.psl).eui().stop();
                                ((VideoPlayer) f.this.psl).eui().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.psk.d) {
                        a(((VideoPlayer) this.psl).euj());
                    } else if (this.prX != null) {
                        this.prX.setVisibility(8);
                    }
                    ((VideoPlayer) this.psl).eui().setDisplay(null);
                    ((VideoPlayer) this.psl).eui().stop();
                    ((VideoPlayer) this.psl).eui().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.psq);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.psj != null) {
            this.psj.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.psl).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.psl).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.psl).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean AM(boolean z) {
        if (this.prW == null) {
            return this.ak;
        }
        View findViewById = this.prW.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.psg.setVisibility(0);
                this.psh.setVisibility(0);
                this.psh.setText(this.psl.getString(a.i.str_get_video_info));
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
        if (this.prZ != null && this.psa != null && this.prY != null) {
            if (this.psk.euJ() != null && this.psk.euJ().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.psk.euJ().mRoominfo.mCreatorAvatar)) {
                this.prZ.i(this.psk.euJ().mRoominfo.mCreatorAvatar, 0, b.a.qpY, b.a.qpY);
                this.psa.i(this.psk.euJ().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.qpY, b.a.qpY);
            } else {
                this.prZ.Ev(com.kascend.chushou.view.a.a(null));
                this.psa.Ev(com.kascend.chushou.view.a.a(null));
            }
            this.prY.setVisibility(0);
            if (this.psb != null) {
                this.psb.setEnabled(false);
            }
            R();
            if (this.psc != null) {
                this.psc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.prY != null) {
            this.prY.setVisibility(8);
        }
        V();
        if (this.psb != null) {
            this.psb.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.psa != null) {
            this.psa.clearAnimation();
        }
    }

    protected void W() {
        if (this.psa != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.psa.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean evG() {
        return "3".equals(this.psr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean AN(boolean z) {
        if (this.prW == null) {
            return false;
        }
        if (this.pse != null && this.pse.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.prW.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.prW.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.psg.setVisibility(0);
            if (this.psk == null || !this.psk.d()) {
                this.psh.setText(this.psl.getString(a.i.str_get_video_info));
                this.psh.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.etY().f4087a || this.psk == null || this.psk.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.poC.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.psm != null) {
            this.psm.removeMessages(15);
            this.psm.Sv(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.prW != null) {
            if (z) {
                if (!this.H && !this.pso) {
                    this.psi.setVisibility(0);
                    return;
                }
                return;
            }
            this.psi.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.psg != null) {
                this.psg.setVisibility(0);
            }
            if (this.psh != null) {
                this.psh.setVisibility(0);
            }
            if (this.psi != null) {
                this.psi.setVisibility(0);
            }
            if (this.psj != null) {
                this.psj.setVisibility(0);
                return;
            }
            return;
        }
        if (this.psg != null) {
            this.psg.setVisibility(8);
        }
        if (this.psh != null) {
            this.psh.setVisibility(8);
        }
        if (this.psi != null) {
            this.psi.setVisibility(8);
        }
        if (this.psj != null) {
            this.psj.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.psf != null) {
            this.psf.setVisibility(0);
            if (z) {
                this.psf.setText(a.i.str_video_player_network_error);
            } else {
                this.psf.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.psm != null) {
            this.psm.D(19, 2000L);
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
            this.psj.setText(spannableStringBuilder);
            this.psj.setVisibility(0);
        }
    }

    public void aaJ() {
        if (this.poC != null && this.poC.getPlayState() == 4) {
            this.poC.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.poC.getPlayState() == 4) {
                this.poC.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.psm != null) {
                this.psm.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa() {
        return this.psl == null || ((Activity) this.psl).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac() {
    }
}
