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
import android.widget.Toast;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.kascend.chushou.a;
import com.kascend.chushou.d.h;
import com.kascend.chushou.player.ui.PlayerErrorView;
import java.util.concurrent.TimeUnit;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes4.dex */
public abstract class f extends e implements SurfaceHolder.Callback {
    protected TextView S;
    protected int ao;
    protected RelativeLayout mXh;
    protected FrescoThumbnailView mXi;
    protected ImageView mXj;
    protected FrescoThumbnailView mXk;
    protected TextView mXl;
    protected ImageView mXp;
    protected ProgressBar mXr;
    protected TextView mXs;
    protected TextView mXt;
    protected TextView mXu;
    protected tv.chushou.zues.c mXx;
    protected final io.reactivex.disposables.a mXf = new io.reactivex.disposables.a();
    protected View mXg = null;
    protected View N = null;
    protected ImageButton mXm = null;
    protected ImageButton mXn = null;
    protected ImageButton mXo = null;
    protected PlayerErrorView mXq = null;
    protected b mXv = null;
    protected Context mXw = null;
    protected AudioManager mXy = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean mXz = false;
    protected long kVr = 0;
    protected int ap = -1;
    protected int mXA = 0;
    protected int ar = 0;
    protected int Ps = 1;
    protected int at = 0;
    protected String au = "";
    protected String mXB = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mXf.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.mTJ != null) {
            this.mTJ.setDisplay(surfaceHolder);
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
        if (this.N != null && this.mTJ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.mTJ.getWidth();
            int height = this.mTJ.getHeight();
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
            tv.chushou.zues.utils.e.i("VideoPlayerLiveBaseFragment", String.format("width = %d,height = %d;mPlayAreaWidth=%d, mPlayAreaHeight=%d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(this.ar), Integer.valueOf(this.mXA)));
            int i7 = this.ar;
            int i8 = this.mXA;
            if (width <= 0 || height <= 0) {
                width = this.ar;
                height = this.mXA;
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
            int i10 = this.Ps;
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
                i8 = this.mXA;
            }
            tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "SetVideoViewLayout out <<<< w:" + layoutParams.width + " h:" + layoutParams.height);
            if (this.mTJ != null) {
                this.mTJ.setDisplayRect(0, 0, i3, i);
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
        if (this.mXv != null) {
            this.mXv.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mXw != null) {
            if (((VideoPlayer) this.mXw).d) {
                b(((VideoPlayer) this.mXw).dAU());
                ((VideoPlayer) this.mXw).a(((VideoPlayer) this.mXw).dAU());
                this.mTJ = ((VideoPlayer) this.mXw).dAU();
            } else {
                b(((VideoPlayer) this.mXw).dAT());
                ((VideoPlayer) this.mXw).a(((VideoPlayer) this.mXw).dAT());
                this.mTJ = ((VideoPlayer) this.mXw).dAT();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mTJ != null) {
            if (this.mXv != null) {
                this.mXv.b = 0;
                this.mXv.c = 0;
            }
            wj(false);
            this.mXv.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.mXv.d);
                if (this.mXv.d) {
                    T();
                    if (this.mXo != null) {
                        this.mXo.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    cWc();
                    if (this.mXn != null) {
                        this.mXn.setVisibility(0);
                    }
                    if (this.mXo != null) {
                        this.mXo.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.mXw).r != -1 && nL()) {
                    this.kVr = ((VideoPlayer) this.mXw).r;
                    ((VideoPlayer) this.mXw).r = -1L;
                }
                if (nL() && this.kVr > 0) {
                    this.mXx.removeMessages(14);
                    this.mTJ.seekTo((int) this.kVr);
                }
                if (!this.ai) {
                    m(false);
                    if (this.mXv.d) {
                        W();
                    }
                    if (this.mTJ.getDuration() > 60000) {
                        if (this.mTJ.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.mTJ.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.mTJ.getDuration();
                    }
                } else {
                    a(false, true);
                }
                wk(false);
                return;
            }
            this.mXv.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.mXz) {
            wk(true);
            if (this.mXg != null) {
                this.mXg.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.mXx != null) {
                    this.mXx.Oc(5);
                    this.mXx.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.mXz) {
            h(false);
        } else if (z) {
            if (z2) {
                wk(false);
                if (this.mXg != null) {
                    this.mXg.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.mXg.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.mXx != null) {
                        this.mXx.removeMessages(5);
                    }
                }
            }
            if (this.mXx != null) {
                this.mXx.removeMessages(15);
                this.mXx.Oc(15);
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
        if ("2".equals(this.ay) && h.dAK().a && this.mXv != null && !this.mXv.d) {
            n(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mXw != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.mXu.setVisibility(8);
            switch (i) {
                case 501:
                    Toast.makeText(this.mXw, this.mXw.getString(a.i.str_storage_unenough_for_buffer), 1).show();
                    break;
                case 502:
                case 503:
                default:
                    if (this.mXv != null) {
                        if (z) {
                            if (this.mXv.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.mXv.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.mXv.c);
                                if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.mXv.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            Toast.makeText(this.mXw, this.mXw.getString(a.i.str_play_failed), 1).show();
                            if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.mXv.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.mXv.b);
                            if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.mXw).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.mXw).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    Toast.makeText(this.mXw, this.mXw.getString(a.i.str_unsupport_file), 1).show();
                    break;
            }
            wj(false);
            wk(false);
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
            if (((VideoPlayer) this.mXw).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.mXw).d);
                ((VideoPlayer) this.mXw).a(((VideoPlayer) this.mXw).dAT());
                this.mTJ = ((VideoPlayer) this.mXw).dAT();
                ((VideoPlayer) this.mXw).d = false;
                if (!h.dAK().a) {
                    RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mXv.d) {
                                    f.this.a(((VideoPlayer) f.this.mXw).dAT());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mXw).dAU().setDisplay(null);
                                ((VideoPlayer) f.this.mXw).dAU().stop();
                                ((VideoPlayer) f.this.mXw).dAU().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mXv.d) {
                        a(((VideoPlayer) this.mXw).dAT());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mXw).dAU().setDisplay(null);
                    ((VideoPlayer) this.mXw).dAU().stop();
                    ((VideoPlayer) this.mXw).dAU().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.mXw).d);
                ((VideoPlayer) this.mXw).a(((VideoPlayer) this.mXw).dAU());
                this.mTJ = ((VideoPlayer) this.mXw).dAU();
                ((VideoPlayer) this.mXw).d = true;
                if (!h.dAK().a) {
                    RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mXv.d) {
                                    f.this.a(((VideoPlayer) f.this.mXw).dAU());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mXw).dAT().setDisplay(null);
                                ((VideoPlayer) f.this.mXw).dAT().stop();
                                ((VideoPlayer) f.this.mXw).dAT().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mXv.d) {
                        a(((VideoPlayer) this.mXw).dAU());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mXw).dAT().setDisplay(null);
                    ((VideoPlayer) this.mXw).dAT().stop();
                    ((VideoPlayer) this.mXw).dAT().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.mXB);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mXu != null) {
            this.mXu.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.mXw).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.mXw).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.mXw).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wj(boolean z) {
        if (this.mXg == null) {
            return this.ak;
        }
        View findViewById = this.mXg.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.mXr.setVisibility(0);
                this.mXs.setVisibility(0);
                this.mXs.setText(this.mXw.getString(a.i.str_get_video_info));
            }
            this.ak = true;
        }
        return this.ak;
    }

    protected void R() {
    }

    protected void cWc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.mXi != null && this.mXk != null && this.mXh != null) {
            if (this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.mXv.dBu().mRoominfo.mCreatorAvatar)) {
                this.mXi.i(this.mXv.dBu().mRoominfo.mCreatorAvatar, 0, b.a.medium, b.a.medium);
                this.mXk.i(this.mXv.dBu().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.medium, b.a.medium);
            } else {
                this.mXi.xi(com.kascend.chushou.view.a.a(null));
                this.mXk.xi(com.kascend.chushou.view.a.a(null));
            }
            this.mXh.setVisibility(0);
            if (this.mXm != null) {
                this.mXm.setEnabled(false);
            }
            R();
            if (this.mXn != null) {
                this.mXn.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.mXh != null) {
            this.mXh.setVisibility(8);
        }
        V();
        if (this.mXm != null) {
            this.mXm.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.mXk != null) {
            this.mXk.clearAnimation();
        }
    }

    protected void W() {
        if (this.mXk != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.mXk.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean nL() {
        return "3".equals(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wk(boolean z) {
        if (this.mXg == null) {
            return false;
        }
        if (this.mXp != null && this.mXp.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.mXg.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.mXg.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.mXr.setVisibility(0);
            if (this.mXv == null || !this.mXv.d()) {
                this.mXs.setText(this.mXw.getString(a.i.str_get_video_info));
                this.mXs.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dAK().a || this.mXv == null || this.mXv.d) {
            n(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.mTJ.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.mXx != null) {
            this.mXx.removeMessages(15);
            this.mXx.Oc(15);
        }
    }

    protected void n(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mXg != null) {
            if (z) {
                if (!this.H && !this.mXz) {
                    this.mXt.setVisibility(0);
                    return;
                }
                return;
            }
            this.mXt.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.mXr != null) {
                this.mXr.setVisibility(0);
            }
            if (this.mXs != null) {
                this.mXs.setVisibility(0);
            }
            if (this.mXt != null) {
                this.mXt.setVisibility(0);
            }
            if (this.mXu != null) {
                this.mXu.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mXr != null) {
            this.mXr.setVisibility(8);
        }
        if (this.mXs != null) {
            this.mXs.setVisibility(8);
        }
        if (this.mXt != null) {
            this.mXt.setVisibility(8);
        }
        if (this.mXu != null) {
            this.mXu.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.mXq != null) {
            this.mXq.setVisibility(0);
            if (z) {
                this.mXq.setText(a.i.str_video_player_network_error);
            } else {
                this.mXq.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.mXx != null) {
            this.mXx.L(19, 2000L);
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
            this.mXu.setText(spannableStringBuilder);
            this.mXu.setVisibility(0);
        }
    }

    public void Z() {
        if (this.mTJ != null && this.mTJ.getPlayState() == 4) {
            this.mTJ.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.mTJ.getPlayState() == 4) {
                this.mTJ.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.mXx != null) {
                this.mXx.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dCE() {
        return this.mXw == null || ((Activity) this.mXw).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nO() {
    }
}
