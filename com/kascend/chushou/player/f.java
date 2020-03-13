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
    protected RelativeLayout mYc;
    protected FrescoThumbnailView mYd;
    protected ImageView mYe;
    protected FrescoThumbnailView mYf;
    protected TextView mYg;
    protected ImageView mYk;
    protected ProgressBar mYm;
    protected TextView mYn;
    protected TextView mYo;
    protected TextView mYp;
    protected tv.chushou.zues.c mYs;
    protected final io.reactivex.disposables.a mYa = new io.reactivex.disposables.a();
    protected View mYb = null;
    protected View N = null;
    protected ImageButton mYh = null;
    protected ImageButton mYi = null;
    protected ImageButton mYj = null;
    protected PlayerErrorView mYl = null;
    protected b mYq = null;
    protected Context mYr = null;
    protected AudioManager mYt = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean mYu = false;
    protected long kWq = 0;
    protected int ap = -1;
    protected int mYv = 0;
    protected int ar = 0;
    protected int Rb = 1;
    protected int at = 0;
    protected String au = "";
    protected String mYw = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mYa.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.mUF != null) {
            this.mUF.setDisplay(surfaceHolder);
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
        if (this.N != null && this.mUF != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.mUF.getWidth();
            int height = this.mUF.getHeight();
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
            tv.chushou.zues.utils.e.i("VideoPlayerLiveBaseFragment", String.format("width = %d,height = %d;mPlayAreaWidth=%d, mPlayAreaHeight=%d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(this.ar), Integer.valueOf(this.mYv)));
            int i7 = this.ar;
            int i8 = this.mYv;
            if (width <= 0 || height <= 0) {
                width = this.ar;
                height = this.mYv;
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
                i8 = this.mYv;
            }
            tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "SetVideoViewLayout out <<<< w:" + layoutParams.width + " h:" + layoutParams.height);
            if (this.mUF != null) {
                this.mUF.setDisplayRect(0, 0, i3, i);
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
        if (this.mYq != null) {
            this.mYq.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mYr != null) {
            if (((VideoPlayer) this.mYr).d) {
                b(((VideoPlayer) this.mYr).dCf());
                ((VideoPlayer) this.mYr).a(((VideoPlayer) this.mYr).dCf());
                this.mUF = ((VideoPlayer) this.mYr).dCf();
            } else {
                b(((VideoPlayer) this.mYr).dCe());
                ((VideoPlayer) this.mYr).a(((VideoPlayer) this.mYr).dCe());
                this.mUF = ((VideoPlayer) this.mYr).dCe();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mUF != null) {
            if (this.mYq != null) {
                this.mYq.b = 0;
                this.mYq.c = 0;
            }
            wn(false);
            this.mYq.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.mYq.d);
                if (this.mYq.d) {
                    T();
                    if (this.mYj != null) {
                        this.mYj.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    cXv();
                    if (this.mYi != null) {
                        this.mYi.setVisibility(0);
                    }
                    if (this.mYj != null) {
                        this.mYj.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.mYr).r != -1 && ou()) {
                    this.kWq = ((VideoPlayer) this.mYr).r;
                    ((VideoPlayer) this.mYr).r = -1L;
                }
                if (ou() && this.kWq > 0) {
                    this.mYs.removeMessages(14);
                    this.mUF.seekTo((int) this.kWq);
                }
                if (!this.ai) {
                    m(false);
                    if (this.mYq.d) {
                        W();
                    }
                    if (this.mUF.getDuration() > 60000) {
                        if (this.mUF.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.mUF.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.mUF.getDuration();
                    }
                } else {
                    a(false, true);
                }
                wo(false);
                return;
            }
            this.mYq.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.mYu) {
            wo(true);
            if (this.mYb != null) {
                this.mYb.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.mYs != null) {
                    this.mYs.Of(5);
                    this.mYs.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.mYu) {
            h(false);
        } else if (z) {
            if (z2) {
                wo(false);
                if (this.mYb != null) {
                    this.mYb.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.mYb.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.mYs != null) {
                        this.mYs.removeMessages(5);
                    }
                }
            }
            if (this.mYs != null) {
                this.mYs.removeMessages(15);
                this.mYs.Of(15);
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
        if ("2".equals(this.ay) && h.dBV().a && this.mYq != null && !this.mYq.d) {
            n(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mYr != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.mYp.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.Om(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.mYq != null) {
                        if (z) {
                            if (this.mYq.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.mYq.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.mYq.c);
                                if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.mYq.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.Om(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.mYq.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.mYq.b);
                            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.mYr).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.mYr).a(true, (Uri) null, false);
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
            if (((VideoPlayer) this.mYr).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.mYr).d);
                ((VideoPlayer) this.mYr).a(((VideoPlayer) this.mYr).dCe());
                this.mUF = ((VideoPlayer) this.mYr).dCe();
                ((VideoPlayer) this.mYr).d = false;
                if (!h.dBV().a) {
                    RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mYq.d) {
                                    f.this.a(((VideoPlayer) f.this.mYr).dCe());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mYr).dCf().setDisplay(null);
                                ((VideoPlayer) f.this.mYr).dCf().stop();
                                ((VideoPlayer) f.this.mYr).dCf().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mYq.d) {
                        a(((VideoPlayer) this.mYr).dCe());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mYr).dCf().setDisplay(null);
                    ((VideoPlayer) this.mYr).dCf().stop();
                    ((VideoPlayer) this.mYr).dCf().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.mYr).d);
                ((VideoPlayer) this.mYr).a(((VideoPlayer) this.mYr).dCf());
                this.mUF = ((VideoPlayer) this.mYr).dCf();
                ((VideoPlayer) this.mYr).d = true;
                if (!h.dBV().a) {
                    RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mYq.d) {
                                    f.this.a(((VideoPlayer) f.this.mYr).dCf());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mYr).dCe().setDisplay(null);
                                ((VideoPlayer) f.this.mYr).dCe().stop();
                                ((VideoPlayer) f.this.mYr).dCe().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mYq.d) {
                        a(((VideoPlayer) this.mYr).dCf());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mYr).dCe().setDisplay(null);
                    ((VideoPlayer) this.mYr).dCe().stop();
                    ((VideoPlayer) this.mYr).dCe().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.mYw);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mYp != null) {
            this.mYp.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.mYr).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.mYr).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.mYr).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wn(boolean z) {
        if (this.mYb == null) {
            return this.ak;
        }
        View findViewById = this.mYb.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.mYm.setVisibility(0);
                this.mYn.setVisibility(0);
                this.mYn.setText(this.mYr.getString(a.i.str_get_video_info));
            }
            this.ak = true;
        }
        return this.ak;
    }

    protected void R() {
    }

    protected void cXv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.mYd != null && this.mYf != null && this.mYc != null) {
            if (this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.mYq.dCF().mRoominfo.mCreatorAvatar)) {
                this.mYd.i(this.mYq.dCF().mRoominfo.mCreatorAvatar, 0, b.a.medium, b.a.medium);
                this.mYf.i(this.mYq.dCF().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.medium, b.a.medium);
            } else {
                this.mYd.xo(com.kascend.chushou.view.a.a(null));
                this.mYf.xo(com.kascend.chushou.view.a.a(null));
            }
            this.mYc.setVisibility(0);
            if (this.mYh != null) {
                this.mYh.setEnabled(false);
            }
            R();
            if (this.mYi != null) {
                this.mYi.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.mYc != null) {
            this.mYc.setVisibility(8);
        }
        V();
        if (this.mYh != null) {
            this.mYh.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.mYf != null) {
            this.mYf.clearAnimation();
        }
    }

    protected void W() {
        if (this.mYf != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.mYf.startAnimation(loadAnimation);
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
        if (this.mYb == null) {
            return false;
        }
        if (this.mYk != null && this.mYk.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.mYb.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.mYb.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.mYm.setVisibility(0);
            if (this.mYq == null || !this.mYq.d()) {
                this.mYn.setText(this.mYr.getString(a.i.str_get_video_info));
                this.mYn.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dBV().a || this.mYq == null || this.mYq.d) {
            n(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.mUF.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.mYs != null) {
            this.mYs.removeMessages(15);
            this.mYs.Of(15);
        }
    }

    protected void n(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mYb != null) {
            if (z) {
                if (!this.H && !this.mYu) {
                    this.mYo.setVisibility(0);
                    return;
                }
                return;
            }
            this.mYo.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.mYm != null) {
                this.mYm.setVisibility(0);
            }
            if (this.mYn != null) {
                this.mYn.setVisibility(0);
            }
            if (this.mYo != null) {
                this.mYo.setVisibility(0);
            }
            if (this.mYp != null) {
                this.mYp.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mYm != null) {
            this.mYm.setVisibility(8);
        }
        if (this.mYn != null) {
            this.mYn.setVisibility(8);
        }
        if (this.mYo != null) {
            this.mYo.setVisibility(8);
        }
        if (this.mYp != null) {
            this.mYp.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.mYl != null) {
            this.mYl.setVisibility(0);
            if (z) {
                this.mYl.setText(a.i.str_video_player_network_error);
            } else {
                this.mYl.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.mYs != null) {
            this.mYs.K(19, 2000L);
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
            this.mYp.setText(spannableStringBuilder);
            this.mYp.setVisibility(0);
        }
    }

    public void Z() {
        if (this.mUF != null && this.mUF.getPlayState() == 4) {
            this.mUF.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.mUF.getPlayState() == 4) {
                this.mUF.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.mYs != null) {
                this.mYs.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dDP() {
        return this.mYr == null || ((Activity) this.mYr).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ox() {
    }
}
