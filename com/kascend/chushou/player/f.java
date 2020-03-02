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
    protected RelativeLayout mXR;
    protected FrescoThumbnailView mXS;
    protected ImageView mXT;
    protected FrescoThumbnailView mXU;
    protected TextView mXV;
    protected ImageView mXZ;
    protected ProgressBar mYb;
    protected TextView mYc;
    protected TextView mYd;
    protected TextView mYe;
    protected tv.chushou.zues.c mYh;
    protected final io.reactivex.disposables.a mXP = new io.reactivex.disposables.a();
    protected View mXQ = null;
    protected View N = null;
    protected ImageButton mXW = null;
    protected ImageButton mXX = null;
    protected ImageButton mXY = null;
    protected PlayerErrorView mYa = null;
    protected b mYf = null;
    protected Context mYg = null;
    protected AudioManager mYi = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean mYj = false;
    protected long kWe = 0;
    protected int ap = -1;
    protected int mYk = 0;
    protected int ar = 0;
    protected int Rb = 1;
    protected int at = 0;
    protected String au = "";
    protected String mYl = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mXP.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.mUu != null) {
            this.mUu.setDisplay(surfaceHolder);
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
        if (this.N != null && this.mUu != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.mUu.getWidth();
            int height = this.mUu.getHeight();
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
            tv.chushou.zues.utils.e.i("VideoPlayerLiveBaseFragment", String.format("width = %d,height = %d;mPlayAreaWidth=%d, mPlayAreaHeight=%d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(this.ar), Integer.valueOf(this.mYk)));
            int i7 = this.ar;
            int i8 = this.mYk;
            if (width <= 0 || height <= 0) {
                width = this.ar;
                height = this.mYk;
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
                i8 = this.mYk;
            }
            tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "SetVideoViewLayout out <<<< w:" + layoutParams.width + " h:" + layoutParams.height);
            if (this.mUu != null) {
                this.mUu.setDisplayRect(0, 0, i3, i);
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
        if (this.mYf != null) {
            this.mYf.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mYg != null) {
            if (((VideoPlayer) this.mYg).d) {
                b(((VideoPlayer) this.mYg).dCe());
                ((VideoPlayer) this.mYg).a(((VideoPlayer) this.mYg).dCe());
                this.mUu = ((VideoPlayer) this.mYg).dCe();
            } else {
                b(((VideoPlayer) this.mYg).dCd());
                ((VideoPlayer) this.mYg).a(((VideoPlayer) this.mYg).dCd());
                this.mUu = ((VideoPlayer) this.mYg).dCd();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mUu != null) {
            if (this.mYf != null) {
                this.mYf.b = 0;
                this.mYf.c = 0;
            }
            wn(false);
            this.mYf.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.mYf.d);
                if (this.mYf.d) {
                    T();
                    if (this.mXY != null) {
                        this.mXY.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    cXu();
                    if (this.mXX != null) {
                        this.mXX.setVisibility(0);
                    }
                    if (this.mXY != null) {
                        this.mXY.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.mYg).r != -1 && ou()) {
                    this.kWe = ((VideoPlayer) this.mYg).r;
                    ((VideoPlayer) this.mYg).r = -1L;
                }
                if (ou() && this.kWe > 0) {
                    this.mYh.removeMessages(14);
                    this.mUu.seekTo((int) this.kWe);
                }
                if (!this.ai) {
                    m(false);
                    if (this.mYf.d) {
                        W();
                    }
                    if (this.mUu.getDuration() > 60000) {
                        if (this.mUu.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.mUu.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.mUu.getDuration();
                    }
                } else {
                    a(false, true);
                }
                wo(false);
                return;
            }
            this.mYf.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.mYj) {
            wo(true);
            if (this.mXQ != null) {
                this.mXQ.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.mYh != null) {
                    this.mYh.Of(5);
                    this.mYh.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.mYj) {
            h(false);
        } else if (z) {
            if (z2) {
                wo(false);
                if (this.mXQ != null) {
                    this.mXQ.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.mXQ.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.mYh != null) {
                        this.mYh.removeMessages(5);
                    }
                }
            }
            if (this.mYh != null) {
                this.mYh.removeMessages(15);
                this.mYh.Of(15);
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
        if ("2".equals(this.ay) && h.dBU().a && this.mYf != null && !this.mYf.d) {
            n(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mYg != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.mYe.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.Om(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.mYf != null) {
                        if (z) {
                            if (this.mYf.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.mYf.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.mYf.c);
                                if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.mYf.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.Om(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.mYf.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.mYf.b);
                            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.mYg).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
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
            if (((VideoPlayer) this.mYg).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.mYg).d);
                ((VideoPlayer) this.mYg).a(((VideoPlayer) this.mYg).dCd());
                this.mUu = ((VideoPlayer) this.mYg).dCd();
                ((VideoPlayer) this.mYg).d = false;
                if (!h.dBU().a) {
                    RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mYf.d) {
                                    f.this.a(((VideoPlayer) f.this.mYg).dCd());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mYg).dCe().setDisplay(null);
                                ((VideoPlayer) f.this.mYg).dCe().stop();
                                ((VideoPlayer) f.this.mYg).dCe().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mYf.d) {
                        a(((VideoPlayer) this.mYg).dCd());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mYg).dCe().setDisplay(null);
                    ((VideoPlayer) this.mYg).dCe().stop();
                    ((VideoPlayer) this.mYg).dCe().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.mYg).d);
                ((VideoPlayer) this.mYg).a(((VideoPlayer) this.mYg).dCe());
                this.mUu = ((VideoPlayer) this.mYg).dCe();
                ((VideoPlayer) this.mYg).d = true;
                if (!h.dBU().a) {
                    RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mYf.d) {
                                    f.this.a(((VideoPlayer) f.this.mYg).dCe());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mYg).dCd().setDisplay(null);
                                ((VideoPlayer) f.this.mYg).dCd().stop();
                                ((VideoPlayer) f.this.mYg).dCd().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mYf.d) {
                        a(((VideoPlayer) this.mYg).dCe());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mYg).dCd().setDisplay(null);
                    ((VideoPlayer) this.mYg).dCd().stop();
                    ((VideoPlayer) this.mYg).dCd().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.mYl);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mYe != null) {
            this.mYe.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.mYg).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.mYg).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.mYg).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wn(boolean z) {
        if (this.mXQ == null) {
            return this.ak;
        }
        View findViewById = this.mXQ.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.mYb.setVisibility(0);
                this.mYc.setVisibility(0);
                this.mYc.setText(this.mYg.getString(a.i.str_get_video_info));
            }
            this.ak = true;
        }
        return this.ak;
    }

    protected void R() {
    }

    protected void cXu() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.mXS != null && this.mXU != null && this.mXR != null) {
            if (this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.mYf.dCE().mRoominfo.mCreatorAvatar)) {
                this.mXS.i(this.mYf.dCE().mRoominfo.mCreatorAvatar, 0, b.a.medium, b.a.medium);
                this.mXU.i(this.mYf.dCE().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.medium, b.a.medium);
            } else {
                this.mXS.xo(com.kascend.chushou.view.a.a(null));
                this.mXU.xo(com.kascend.chushou.view.a.a(null));
            }
            this.mXR.setVisibility(0);
            if (this.mXW != null) {
                this.mXW.setEnabled(false);
            }
            R();
            if (this.mXX != null) {
                this.mXX.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.mXR != null) {
            this.mXR.setVisibility(8);
        }
        V();
        if (this.mXW != null) {
            this.mXW.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.mXU != null) {
            this.mXU.clearAnimation();
        }
    }

    protected void W() {
        if (this.mXU != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.mXU.startAnimation(loadAnimation);
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
        if (this.mXQ == null) {
            return false;
        }
        if (this.mXZ != null && this.mXZ.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.mXQ.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.mXQ.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.mYb.setVisibility(0);
            if (this.mYf == null || !this.mYf.d()) {
                this.mYc.setText(this.mYg.getString(a.i.str_get_video_info));
                this.mYc.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dBU().a || this.mYf == null || this.mYf.d) {
            n(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.mUu.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.mYh != null) {
            this.mYh.removeMessages(15);
            this.mYh.Of(15);
        }
    }

    protected void n(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mXQ != null) {
            if (z) {
                if (!this.H && !this.mYj) {
                    this.mYd.setVisibility(0);
                    return;
                }
                return;
            }
            this.mYd.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.mYb != null) {
                this.mYb.setVisibility(0);
            }
            if (this.mYc != null) {
                this.mYc.setVisibility(0);
            }
            if (this.mYd != null) {
                this.mYd.setVisibility(0);
            }
            if (this.mYe != null) {
                this.mYe.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mYb != null) {
            this.mYb.setVisibility(8);
        }
        if (this.mYc != null) {
            this.mYc.setVisibility(8);
        }
        if (this.mYd != null) {
            this.mYd.setVisibility(8);
        }
        if (this.mYe != null) {
            this.mYe.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.mYa != null) {
            this.mYa.setVisibility(0);
            if (z) {
                this.mYa.setText(a.i.str_video_player_network_error);
            } else {
                this.mYa.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.mYh != null) {
            this.mYh.K(19, 2000L);
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
            this.mYe.setText(spannableStringBuilder);
            this.mYe.setVisibility(0);
        }
    }

    public void Z() {
        if (this.mUu != null && this.mUu.getPlayState() == 4) {
            this.mUu.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.mUu.getPlayState() == 4) {
                this.mUu.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.mYh != null) {
                this.mYh.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dDO() {
        return this.mYg == null || ((Activity) this.mYg).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ox() {
    }
}
