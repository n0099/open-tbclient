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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.kascend.chushou.a;
import com.kascend.chushou.d.h;
import com.kascend.chushou.player.ui.PlayerErrorView;
import java.util.concurrent.TimeUnit;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes5.dex */
public abstract class f extends e implements SurfaceHolder.Callback {
    protected TextView S;
    protected int ao;
    protected RelativeLayout mXP;
    protected FrescoThumbnailView mXQ;
    protected ImageView mXR;
    protected FrescoThumbnailView mXS;
    protected TextView mXT;
    protected ImageView mXX;
    protected ProgressBar mXZ;
    protected TextView mYa;
    protected TextView mYb;
    protected TextView mYc;
    protected tv.chushou.zues.c mYf;
    protected final io.reactivex.disposables.a mXN = new io.reactivex.disposables.a();
    protected View mXO = null;
    protected View N = null;
    protected ImageButton mXU = null;
    protected ImageButton mXV = null;
    protected ImageButton mXW = null;
    protected PlayerErrorView mXY = null;
    protected b mYd = null;
    protected Context mYe = null;
    protected AudioManager mYg = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean mYh = false;
    protected long kWc = 0;
    protected int ap = -1;
    protected int mYi = 0;
    protected int ar = 0;
    protected int Rb = 1;
    protected int at = 0;
    protected String au = "";
    protected String mYj = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mXN.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.mUs != null) {
            this.mUs.setDisplay(surfaceHolder);
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
        if (this.N != null && this.mUs != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.mUs.getWidth();
            int height = this.mUs.getHeight();
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
            tv.chushou.zues.utils.e.i("VideoPlayerLiveBaseFragment", String.format("width = %d,height = %d;mPlayAreaWidth=%d, mPlayAreaHeight=%d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(this.ar), Integer.valueOf(this.mYi)));
            int i7 = this.ar;
            int i8 = this.mYi;
            if (width <= 0 || height <= 0) {
                width = this.ar;
                height = this.mYi;
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
            int i10 = this.Rb;
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
                i8 = this.mYi;
            }
            tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "SetVideoViewLayout out <<<< w:" + layoutParams.width + " h:" + layoutParams.height);
            if (this.mUs != null) {
                this.mUs.setDisplayRect(0, 0, i3, i);
            }
            if (layoutParams.width != i7 || layoutParams.height != i8) {
                layoutParams.width = i7;
                layoutParams.height = i8;
                this.N.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        this.ao = i;
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mYd != null) {
            this.mYd.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mYe != null) {
            if (((VideoPlayer) this.mYe).d) {
                b(((VideoPlayer) this.mYe).dCc());
                ((VideoPlayer) this.mYe).a(((VideoPlayer) this.mYe).dCc());
                this.mUs = ((VideoPlayer) this.mYe).dCc();
            } else {
                b(((VideoPlayer) this.mYe).dCb());
                ((VideoPlayer) this.mYe).a(((VideoPlayer) this.mYe).dCb());
                this.mUs = ((VideoPlayer) this.mYe).dCb();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mUs != null) {
            if (this.mYd != null) {
                this.mYd.b = 0;
                this.mYd.c = 0;
            }
            wn(false);
            this.mYd.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.mYd.d);
                if (this.mYd.d) {
                    T();
                    if (this.mXW != null) {
                        this.mXW.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    cXs();
                    if (this.mXV != null) {
                        this.mXV.setVisibility(0);
                    }
                    if (this.mXW != null) {
                        this.mXW.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.mYe).r != -1 && ou()) {
                    this.kWc = ((VideoPlayer) this.mYe).r;
                    ((VideoPlayer) this.mYe).r = -1L;
                }
                if (ou() && this.kWc > 0) {
                    this.mYf.removeMessages(14);
                    this.mUs.seekTo((int) this.kWc);
                }
                if (!this.ai) {
                    m(false);
                    if (this.mYd.d) {
                        W();
                    }
                    if (this.mUs.getDuration() > 60000) {
                        if (this.mUs.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.mUs.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.mUs.getDuration();
                    }
                } else {
                    a(false, true);
                }
                wo(false);
                return;
            }
            this.mYd.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.mYh) {
            wo(true);
            if (this.mXO != null) {
                this.mXO.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.mYf != null) {
                    this.mYf.Of(5);
                    this.mYf.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.mYh) {
            h(false);
        } else if (z) {
            if (z2) {
                wo(false);
                if (this.mXO != null) {
                    this.mXO.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.mXO.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.mYf != null) {
                        this.mYf.removeMessages(5);
                    }
                }
            }
            if (this.mYf != null) {
                this.mYf.removeMessages(15);
                this.mYf.Of(15);
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
        if ("2".equals(this.ay) && h.dBS().a && this.mYd != null && !this.mYd.d) {
            n(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mYe != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.mYc.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.Om(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.mYd != null) {
                        if (z) {
                            if (this.mYd.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.mYd.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.mYd.c);
                                if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.mYd.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.Om(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.mYd.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.mYd.b);
                            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.mYe).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.mYe).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.Om(a.i.str_unsupport_file);
                    break;
            }
            wn(false);
            wo(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(tv.chushou.common.player.a aVar) {
        if (this.N != null) {
            this.N.setVisibility(0);
            if (aVar != null && (this.N instanceof SurfaceView)) {
                aVar.setDisplay(((SurfaceView) this.N).getHolder());
            }
        }
    }

    private void b(tv.chushou.common.player.a aVar) {
        if (this.N != null && (this.N instanceof SurfaceView)) {
            aVar.setDisplay(((SurfaceView) this.N).getHolder());
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.N != null) {
            if (((VideoPlayer) this.mYe).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.mYe).d);
                ((VideoPlayer) this.mYe).a(((VideoPlayer) this.mYe).dCb());
                this.mUs = ((VideoPlayer) this.mYe).dCb();
                ((VideoPlayer) this.mYe).d = false;
                if (!h.dBS().a) {
                    RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mYd.d) {
                                    f.this.a(((VideoPlayer) f.this.mYe).dCb());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mYe).dCc().setDisplay(null);
                                ((VideoPlayer) f.this.mYe).dCc().stop();
                                ((VideoPlayer) f.this.mYe).dCc().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mYd.d) {
                        a(((VideoPlayer) this.mYe).dCb());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mYe).dCc().setDisplay(null);
                    ((VideoPlayer) this.mYe).dCc().stop();
                    ((VideoPlayer) this.mYe).dCc().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.mYe).d);
                ((VideoPlayer) this.mYe).a(((VideoPlayer) this.mYe).dCc());
                this.mUs = ((VideoPlayer) this.mYe).dCc();
                ((VideoPlayer) this.mYe).d = true;
                if (!h.dBS().a) {
                    RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mYd.d) {
                                    f.this.a(((VideoPlayer) f.this.mYe).dCc());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mYe).dCb().setDisplay(null);
                                ((VideoPlayer) f.this.mYe).dCb().stop();
                                ((VideoPlayer) f.this.mYe).dCb().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mYd.d) {
                        a(((VideoPlayer) this.mYe).dCc());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mYe).dCb().setDisplay(null);
                    ((VideoPlayer) this.mYe).dCb().stop();
                    ((VideoPlayer) this.mYe).dCb().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.mYj);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mYc != null) {
            this.mYc.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.mYe).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.mYe).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.mYe).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wn(boolean z) {
        if (this.mXO == null) {
            return this.ak;
        }
        View findViewById = this.mXO.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.mXZ.setVisibility(0);
                this.mYa.setVisibility(0);
                this.mYa.setText(this.mYe.getString(a.i.str_get_video_info));
            }
            this.ak = true;
        }
        return this.ak;
    }

    protected void R() {
    }

    protected void cXs() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.mXQ != null && this.mXS != null && this.mXP != null) {
            if (this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.mYd.dCC().mRoominfo.mCreatorAvatar)) {
                this.mXQ.i(this.mYd.dCC().mRoominfo.mCreatorAvatar, 0, b.a.medium, b.a.medium);
                this.mXS.i(this.mYd.dCC().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.medium, b.a.medium);
            } else {
                this.mXQ.xo(com.kascend.chushou.view.a.a(null));
                this.mXS.xo(com.kascend.chushou.view.a.a(null));
            }
            this.mXP.setVisibility(0);
            if (this.mXU != null) {
                this.mXU.setEnabled(false);
            }
            R();
            if (this.mXV != null) {
                this.mXV.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.mXP != null) {
            this.mXP.setVisibility(8);
        }
        V();
        if (this.mXU != null) {
            this.mXU.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.mXS != null) {
            this.mXS.clearAnimation();
        }
    }

    protected void W() {
        if (this.mXS != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.mXS.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ou() {
        return "3".equals(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wo(boolean z) {
        if (this.mXO == null) {
            return false;
        }
        if (this.mXX != null && this.mXX.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.mXO.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.mXO.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.mXZ.setVisibility(0);
            if (this.mYd == null || !this.mYd.d()) {
                this.mYa.setText(this.mYe.getString(a.i.str_get_video_info));
                this.mYa.setVisibility(0);
            }
            a(false, false);
        } else {
            f(false);
        }
        this.ak = z;
        return this.ak;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(boolean z) {
        if (!"2".equals(this.ay) || !h.dBS().a || this.mYd == null || this.mYd.d) {
            n(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.mUs.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.mYf != null) {
            this.mYf.removeMessages(15);
            this.mYf.Of(15);
        }
    }

    protected void n(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mXO != null) {
            if (z) {
                if (!this.H && !this.mYh) {
                    this.mYb.setVisibility(0);
                    return;
                }
                return;
            }
            this.mYb.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.mXZ != null) {
                this.mXZ.setVisibility(0);
            }
            if (this.mYa != null) {
                this.mYa.setVisibility(0);
            }
            if (this.mYb != null) {
                this.mYb.setVisibility(0);
            }
            if (this.mYc != null) {
                this.mYc.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mXZ != null) {
            this.mXZ.setVisibility(8);
        }
        if (this.mYa != null) {
            this.mYa.setVisibility(8);
        }
        if (this.mYb != null) {
            this.mYb.setVisibility(8);
        }
        if (this.mYc != null) {
            this.mYc.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.mXY != null) {
            this.mXY.setVisibility(0);
            if (z) {
                this.mXY.setText(a.i.str_video_player_network_error);
            } else {
                this.mXY.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.mYf != null) {
            this.mYf.K(19, 2000L);
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
            spannableStringBuilder.append((CharSequence) (str + HanziToPinyin.Token.SEPARATOR));
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#ff5959")), length, spannableStringBuilder.length(), 17);
            if (!z) {
                spannableStringBuilder.append((CharSequence) getString(a.i.please_waiting));
            }
            this.mYc.setText(spannableStringBuilder);
            this.mYc.setVisibility(0);
        }
    }

    public void Z() {
        if (this.mUs != null && this.mUs.getPlayState() == 4) {
            this.mUs.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.mUs.getPlayState() == 4) {
                this.mUs.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.mYf != null) {
                this.mYf.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dDM() {
        return this.mYe == null || ((Activity) this.mYe).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ox() {
    }
}
