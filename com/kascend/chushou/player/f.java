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
    protected tv.chushou.zues.c mXC;
    protected RelativeLayout mXm;
    protected FrescoThumbnailView mXn;
    protected ImageView mXo;
    protected FrescoThumbnailView mXp;
    protected TextView mXq;
    protected ImageView mXu;
    protected ProgressBar mXw;
    protected TextView mXx;
    protected TextView mXy;
    protected TextView mXz;
    protected final io.reactivex.disposables.a mXk = new io.reactivex.disposables.a();
    protected View mXl = null;
    protected View N = null;
    protected ImageButton mXr = null;
    protected ImageButton mXs = null;
    protected ImageButton mXt = null;
    protected PlayerErrorView mXv = null;
    protected b mXA = null;
    protected Context mXB = null;
    protected AudioManager mXD = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean mXE = false;
    protected long kVw = 0;
    protected int ap = -1;
    protected int mXF = 0;
    protected int ar = 0;
    protected int Ps = 1;
    protected int at = 0;
    protected String au = "";
    protected String mXG = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mXk.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.mTO != null) {
            this.mTO.setDisplay(surfaceHolder);
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
        if (this.N != null && this.mTO != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.mTO.getWidth();
            int height = this.mTO.getHeight();
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
            tv.chushou.zues.utils.e.i("VideoPlayerLiveBaseFragment", String.format("width = %d,height = %d;mPlayAreaWidth=%d, mPlayAreaHeight=%d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(this.ar), Integer.valueOf(this.mXF)));
            int i7 = this.ar;
            int i8 = this.mXF;
            if (width <= 0 || height <= 0) {
                width = this.ar;
                height = this.mXF;
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
                i8 = this.mXF;
            }
            tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "SetVideoViewLayout out <<<< w:" + layoutParams.width + " h:" + layoutParams.height);
            if (this.mTO != null) {
                this.mTO.setDisplayRect(0, 0, i3, i);
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
        if (this.mXA != null) {
            this.mXA.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mXB != null) {
            if (((VideoPlayer) this.mXB).d) {
                b(((VideoPlayer) this.mXB).dAW());
                ((VideoPlayer) this.mXB).a(((VideoPlayer) this.mXB).dAW());
                this.mTO = ((VideoPlayer) this.mXB).dAW();
            } else {
                b(((VideoPlayer) this.mXB).dAV());
                ((VideoPlayer) this.mXB).a(((VideoPlayer) this.mXB).dAV());
                this.mTO = ((VideoPlayer) this.mXB).dAV();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mTO != null) {
            if (this.mXA != null) {
                this.mXA.b = 0;
                this.mXA.c = 0;
            }
            wj(false);
            this.mXA.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.mXA.d);
                if (this.mXA.d) {
                    T();
                    if (this.mXt != null) {
                        this.mXt.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    cWe();
                    if (this.mXs != null) {
                        this.mXs.setVisibility(0);
                    }
                    if (this.mXt != null) {
                        this.mXt.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.mXB).r != -1 && nL()) {
                    this.kVw = ((VideoPlayer) this.mXB).r;
                    ((VideoPlayer) this.mXB).r = -1L;
                }
                if (nL() && this.kVw > 0) {
                    this.mXC.removeMessages(14);
                    this.mTO.seekTo((int) this.kVw);
                }
                if (!this.ai) {
                    m(false);
                    if (this.mXA.d) {
                        W();
                    }
                    if (this.mTO.getDuration() > 60000) {
                        if (this.mTO.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.mTO.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.mTO.getDuration();
                    }
                } else {
                    a(false, true);
                }
                wk(false);
                return;
            }
            this.mXA.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.mXE) {
            wk(true);
            if (this.mXl != null) {
                this.mXl.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.mXC != null) {
                    this.mXC.Oc(5);
                    this.mXC.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.mXE) {
            h(false);
        } else if (z) {
            if (z2) {
                wk(false);
                if (this.mXl != null) {
                    this.mXl.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.mXl.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.mXC != null) {
                        this.mXC.removeMessages(5);
                    }
                }
            }
            if (this.mXC != null) {
                this.mXC.removeMessages(15);
                this.mXC.Oc(15);
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
        if ("2".equals(this.ay) && h.dAM().a && this.mXA != null && !this.mXA.d) {
            n(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mXB != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.mXz.setVisibility(8);
            switch (i) {
                case 501:
                    Toast.makeText(this.mXB, this.mXB.getString(a.i.str_storage_unenough_for_buffer), 1).show();
                    break;
                case 502:
                case 503:
                default:
                    if (this.mXA != null) {
                        if (z) {
                            if (this.mXA.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.mXA.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.mXA.c);
                                if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.mXA.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            Toast.makeText(this.mXB, this.mXB.getString(a.i.str_play_failed), 1).show();
                            if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.mXA.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.mXA.b);
                            if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.mXB).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    Toast.makeText(this.mXB, this.mXB.getString(a.i.str_unsupport_file), 1).show();
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
            if (((VideoPlayer) this.mXB).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.mXB).d);
                ((VideoPlayer) this.mXB).a(((VideoPlayer) this.mXB).dAV());
                this.mTO = ((VideoPlayer) this.mXB).dAV();
                ((VideoPlayer) this.mXB).d = false;
                if (!h.dAM().a) {
                    RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mXA.d) {
                                    f.this.a(((VideoPlayer) f.this.mXB).dAV());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mXB).dAW().setDisplay(null);
                                ((VideoPlayer) f.this.mXB).dAW().stop();
                                ((VideoPlayer) f.this.mXB).dAW().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mXA.d) {
                        a(((VideoPlayer) this.mXB).dAV());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mXB).dAW().setDisplay(null);
                    ((VideoPlayer) this.mXB).dAW().stop();
                    ((VideoPlayer) this.mXB).dAW().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.mXB).d);
                ((VideoPlayer) this.mXB).a(((VideoPlayer) this.mXB).dAW());
                this.mTO = ((VideoPlayer) this.mXB).dAW();
                ((VideoPlayer) this.mXB).d = true;
                if (!h.dAM().a) {
                    RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mXA.d) {
                                    f.this.a(((VideoPlayer) f.this.mXB).dAW());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mXB).dAV().setDisplay(null);
                                ((VideoPlayer) f.this.mXB).dAV().stop();
                                ((VideoPlayer) f.this.mXB).dAV().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mXA.d) {
                        a(((VideoPlayer) this.mXB).dAW());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mXB).dAV().setDisplay(null);
                    ((VideoPlayer) this.mXB).dAV().stop();
                    ((VideoPlayer) this.mXB).dAV().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.mXG);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mXz != null) {
            this.mXz.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.mXB).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.mXB).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.mXB).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wj(boolean z) {
        if (this.mXl == null) {
            return this.ak;
        }
        View findViewById = this.mXl.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.mXw.setVisibility(0);
                this.mXx.setVisibility(0);
                this.mXx.setText(this.mXB.getString(a.i.str_get_video_info));
            }
            this.ak = true;
        }
        return this.ak;
    }

    protected void R() {
    }

    protected void cWe() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.mXn != null && this.mXp != null && this.mXm != null) {
            if (this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.mXA.dBw().mRoominfo.mCreatorAvatar)) {
                this.mXn.i(this.mXA.dBw().mRoominfo.mCreatorAvatar, 0, b.a.medium, b.a.medium);
                this.mXp.i(this.mXA.dBw().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.medium, b.a.medium);
            } else {
                this.mXn.xi(com.kascend.chushou.view.a.a(null));
                this.mXp.xi(com.kascend.chushou.view.a.a(null));
            }
            this.mXm.setVisibility(0);
            if (this.mXr != null) {
                this.mXr.setEnabled(false);
            }
            R();
            if (this.mXs != null) {
                this.mXs.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.mXm != null) {
            this.mXm.setVisibility(8);
        }
        V();
        if (this.mXr != null) {
            this.mXr.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.mXp != null) {
            this.mXp.clearAnimation();
        }
    }

    protected void W() {
        if (this.mXp != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.mXp.startAnimation(loadAnimation);
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
        if (this.mXl == null) {
            return false;
        }
        if (this.mXu != null && this.mXu.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.mXl.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.mXl.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.mXw.setVisibility(0);
            if (this.mXA == null || !this.mXA.d()) {
                this.mXx.setText(this.mXB.getString(a.i.str_get_video_info));
                this.mXx.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dAM().a || this.mXA == null || this.mXA.d) {
            n(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.mTO.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.mXC != null) {
            this.mXC.removeMessages(15);
            this.mXC.Oc(15);
        }
    }

    protected void n(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mXl != null) {
            if (z) {
                if (!this.H && !this.mXE) {
                    this.mXy.setVisibility(0);
                    return;
                }
                return;
            }
            this.mXy.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.mXw != null) {
                this.mXw.setVisibility(0);
            }
            if (this.mXx != null) {
                this.mXx.setVisibility(0);
            }
            if (this.mXy != null) {
                this.mXy.setVisibility(0);
            }
            if (this.mXz != null) {
                this.mXz.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mXw != null) {
            this.mXw.setVisibility(8);
        }
        if (this.mXx != null) {
            this.mXx.setVisibility(8);
        }
        if (this.mXy != null) {
            this.mXy.setVisibility(8);
        }
        if (this.mXz != null) {
            this.mXz.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.mXv != null) {
            this.mXv.setVisibility(0);
            if (z) {
                this.mXv.setText(a.i.str_video_player_network_error);
            } else {
                this.mXv.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.mXC != null) {
            this.mXC.L(19, 2000L);
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
            this.mXz.setText(spannableStringBuilder);
            this.mXz.setVisibility(0);
        }
    }

    public void Z() {
        if (this.mTO != null && this.mTO.getPlayState() == 4) {
            this.mTO.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.mTO.getPlayState() == 4) {
                this.mTO.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.mXC != null) {
                this.mXC.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dCG() {
        return this.mXB == null || ((Activity) this.mXB).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nO() {
    }
}
