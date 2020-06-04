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
/* loaded from: classes5.dex */
public abstract class f extends e implements SurfaceHolder.Callback {
    protected ImageView Q;
    protected int ao;
    protected ImageView mRC;
    protected ProgressBar mRE;
    protected TextView mRF;
    protected TextView mRG;
    protected TextView mRH;
    protected tv.chushou.zues.c mRK;
    protected RelativeLayout mRu;
    protected FrescoThumbnailView mRv;
    protected FrescoThumbnailView mRw;
    protected TextView mRx;
    protected TextView mRy;
    protected final io.reactivex.disposables.a mRs = new io.reactivex.disposables.a();
    protected View mRt = null;
    protected View N = null;
    protected ImageButton mRz = null;
    protected ImageButton mRA = null;
    protected ImageButton mRB = null;
    protected PlayerErrorView mRD = null;
    protected b mRI = null;
    protected Context mRJ = null;
    protected AudioManager mRL = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean mRM = false;
    protected long mjc = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int mRN = 1;
    protected int at = 0;
    protected String au = "";
    protected String mRO = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mRs.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.mNX != null) {
            this.mNX.setDisplay(surfaceHolder);
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
        if (this.N != null && this.mNX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.mNX.getWidth();
            int height = this.mNX.getHeight();
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
            int i10 = this.mRN;
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
            if (this.mNX != null) {
                this.mNX.setDisplayRect(0, 0, i3, i);
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
        if (this.mRI != null) {
            this.mRI.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mRJ != null) {
            if (((VideoPlayer) this.mRJ).d) {
                b(((VideoPlayer) this.mRJ).dEy());
                ((VideoPlayer) this.mRJ).a(((VideoPlayer) this.mRJ).dEy());
                this.mNX = ((VideoPlayer) this.mRJ).dEy();
            } else {
                b(((VideoPlayer) this.mRJ).dEx());
                ((VideoPlayer) this.mRJ).a(((VideoPlayer) this.mRJ).dEx());
                this.mNX = ((VideoPlayer) this.mRJ).dEx();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mNX != null) {
            if (this.mRI != null) {
                this.mRI.b = 0;
                this.mRI.c = 0;
            }
            wD(false);
            this.mRI.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.mRI.d);
                if (this.mRI.d) {
                    Nl();
                    if (this.mRB != null) {
                        this.mRB.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.mRA != null) {
                        this.mRA.setVisibility(0);
                    }
                    if (this.mRB != null) {
                        this.mRB.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.mRJ).r != -1 && dFR()) {
                    this.mjc = ((VideoPlayer) this.mRJ).r;
                    ((VideoPlayer) this.mRJ).r = -1L;
                }
                if (dFR() && this.mjc > 0) {
                    this.mRK.removeMessages(14);
                    this.mNX.seekTo((int) this.mjc);
                }
                if (!this.ai) {
                    n(false);
                    if (this.mRI.d) {
                        W();
                    }
                    if (this.mNX.getDuration() > 60000) {
                        if (this.mNX.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.mNX.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.mNX.getDuration();
                    }
                } else {
                    a(false, true);
                }
                wE(false);
                return;
            }
            this.mRI.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.mRM) {
            wE(true);
            if (this.mRt != null) {
                this.mRt.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.mRK != null) {
                    this.mRK.Ks(5);
                    this.mRK.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.mRM) {
            h(false);
        } else if (z) {
            if (z2) {
                wE(false);
                if (this.mRt != null) {
                    this.mRt.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.mRt.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.mRK != null) {
                        this.mRK.removeMessages(5);
                    }
                }
            }
            if (this.mRK != null) {
                this.mRK.removeMessages(15);
                this.mRK.Ks(15);
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
        if ("2".equals(this.ay) && h.dEn().a && this.mRI != null && !this.mRI.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mRJ != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.mRH.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.KB(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.mRI != null) {
                        if (z) {
                            if (this.mRI.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.mRI.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.mRI.c);
                                if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.mRI.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.KB(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.mRI.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.mRI.b);
                            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.mRJ).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.KB(a.i.str_unsupport_file);
                    break;
            }
            wD(false);
            wE(false);
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
            if (((VideoPlayer) this.mRJ).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.mRJ).d);
                ((VideoPlayer) this.mRJ).a(((VideoPlayer) this.mRJ).dEx());
                this.mNX = ((VideoPlayer) this.mRJ).dEx();
                ((VideoPlayer) this.mRJ).d = false;
                if (!h.dEn().a) {
                    RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mRI.d) {
                                    f.this.a(((VideoPlayer) f.this.mRJ).dEx());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mRJ).dEy().setDisplay(null);
                                ((VideoPlayer) f.this.mRJ).dEy().stop();
                                ((VideoPlayer) f.this.mRJ).dEy().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mRI.d) {
                        a(((VideoPlayer) this.mRJ).dEx());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mRJ).dEy().setDisplay(null);
                    ((VideoPlayer) this.mRJ).dEy().stop();
                    ((VideoPlayer) this.mRJ).dEy().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.mRJ).d);
                ((VideoPlayer) this.mRJ).a(((VideoPlayer) this.mRJ).dEy());
                this.mNX = ((VideoPlayer) this.mRJ).dEy();
                ((VideoPlayer) this.mRJ).d = true;
                if (!h.dEn().a) {
                    RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mRI.d) {
                                    f.this.a(((VideoPlayer) f.this.mRJ).dEy());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mRJ).dEx().setDisplay(null);
                                ((VideoPlayer) f.this.mRJ).dEx().stop();
                                ((VideoPlayer) f.this.mRJ).dEx().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mRI.d) {
                        a(((VideoPlayer) this.mRJ).dEy());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mRJ).dEx().setDisplay(null);
                    ((VideoPlayer) this.mRJ).dEx().stop();
                    ((VideoPlayer) this.mRJ).dEx().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.mRO);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mRH != null) {
            this.mRH.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.mRJ).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.mRJ).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.mRJ).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wD(boolean z) {
        if (this.mRt == null) {
            return this.ak;
        }
        View findViewById = this.mRt.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.mRE.setVisibility(0);
                this.mRF.setVisibility(0);
                this.mRF.setText(this.mRJ.getString(a.i.str_get_video_info));
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
    public void Nl() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.mRv != null && this.mRw != null && this.mRu != null) {
            if (this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.mRI.dEZ().mRoominfo.mCreatorAvatar)) {
                this.mRv.i(this.mRI.dEZ().mRoominfo.mCreatorAvatar, 0, b.a.nQi, b.a.nQi);
                this.mRw.i(this.mRI.dEZ().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.nQi, b.a.nQi);
            } else {
                this.mRv.yG(com.kascend.chushou.view.a.a(null));
                this.mRw.yG(com.kascend.chushou.view.a.a(null));
            }
            this.mRu.setVisibility(0);
            if (this.mRz != null) {
                this.mRz.setEnabled(false);
            }
            R();
            if (this.mRA != null) {
                this.mRA.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.mRu != null) {
            this.mRu.setVisibility(8);
        }
        V();
        if (this.mRz != null) {
            this.mRz.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.mRw != null) {
            this.mRw.clearAnimation();
        }
    }

    protected void W() {
        if (this.mRw != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.mRw.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dFR() {
        return "3".equals(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wE(boolean z) {
        if (this.mRt == null) {
            return false;
        }
        if (this.mRC != null && this.mRC.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.mRt.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.mRt.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.mRE.setVisibility(0);
            if (this.mRI == null || !this.mRI.d()) {
                this.mRF.setText(this.mRJ.getString(a.i.str_get_video_info));
                this.mRF.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dEn().a || this.mRI == null || this.mRI.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.mNX.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.mRK != null) {
            this.mRK.removeMessages(15);
            this.mRK.Ks(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mRt != null) {
            if (z) {
                if (!this.H && !this.mRM) {
                    this.mRG.setVisibility(0);
                    return;
                }
                return;
            }
            this.mRG.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.mRE != null) {
                this.mRE.setVisibility(0);
            }
            if (this.mRF != null) {
                this.mRF.setVisibility(0);
            }
            if (this.mRG != null) {
                this.mRG.setVisibility(0);
            }
            if (this.mRH != null) {
                this.mRH.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mRE != null) {
            this.mRE.setVisibility(8);
        }
        if (this.mRF != null) {
            this.mRF.setVisibility(8);
        }
        if (this.mRG != null) {
            this.mRG.setVisibility(8);
        }
        if (this.mRH != null) {
            this.mRH.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.mRD != null) {
            this.mRD.setVisibility(0);
            if (z) {
                this.mRD.setText(a.i.str_video_player_network_error);
            } else {
                this.mRD.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.mRK != null) {
            this.mRK.A(19, 2000L);
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
            this.mRH.setText(spannableStringBuilder);
            this.mRH.setVisibility(0);
        }
    }

    public void Z() {
        if (this.mNX != null && this.mNX.getPlayState() == 4) {
            this.mNX.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.mNX.getPlayState() == 4) {
                this.mNX.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.mRK != null) {
                this.mRK.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dFS() {
        return this.mRJ == null || ((Activity) this.mRJ).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dFw() {
    }
}
