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
    protected TextView S;
    protected int ao;
    protected TextView mwA;
    protected TextView mwB;
    protected TextView mwC;
    protected tv.chushou.zues.c mwF;
    protected RelativeLayout mwp;
    protected FrescoThumbnailView mwq;
    protected ImageView mwr;
    protected FrescoThumbnailView mws;
    protected TextView mwt;
    protected ImageView mwx;
    protected ProgressBar mwz;
    protected final io.reactivex.disposables.a mwn = new io.reactivex.disposables.a();
    protected View mwo = null;
    protected View N = null;
    protected ImageButton mwu = null;
    protected ImageButton mwv = null;
    protected ImageButton mww = null;
    protected PlayerErrorView mwy = null;
    protected b mwD = null;
    protected Context mwE = null;
    protected AudioManager mwG = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean mwH = false;
    protected long lOB = 0;
    protected int ap = -1;
    protected int mwI = 0;
    protected int ar = 0;
    protected int mwJ = 1;
    protected int at = 0;
    protected String au = "";
    protected String mwK = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mwn.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.msU != null) {
            this.msU.setDisplay(surfaceHolder);
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
        if (this.N != null && this.msU != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.msU.getWidth();
            int height = this.msU.getHeight();
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
            tv.chushou.zues.utils.e.i("VideoPlayerLiveBaseFragment", String.format("width = %d,height = %d;mPlayAreaWidth=%d, mPlayAreaHeight=%d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(this.ar), Integer.valueOf(this.mwI)));
            int i7 = this.ar;
            int i8 = this.mwI;
            if (width <= 0 || height <= 0) {
                width = this.ar;
                height = this.mwI;
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
            int i10 = this.mwJ;
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
                i8 = this.mwI;
            }
            tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "SetVideoViewLayout out <<<< w:" + layoutParams.width + " h:" + layoutParams.height);
            if (this.msU != null) {
                this.msU.setDisplayRect(0, 0, i3, i);
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
        if (this.mwD != null) {
            this.mwD.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mwE != null) {
            if (((VideoPlayer) this.mwE).d) {
                b(((VideoPlayer) this.mwE).dwR());
                ((VideoPlayer) this.mwE).a(((VideoPlayer) this.mwE).dwR());
                this.msU = ((VideoPlayer) this.mwE).dwR();
            } else {
                b(((VideoPlayer) this.mwE).dwQ());
                ((VideoPlayer) this.mwE).a(((VideoPlayer) this.mwE).dwQ());
                this.msU = ((VideoPlayer) this.mwE).dwQ();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.msU != null) {
            if (this.mwD != null) {
                this.mwD.b = 0;
                this.mwD.c = 0;
            }
            wd(false);
            this.mwD.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.mwD.d);
                if (this.mwD.d) {
                    T();
                    if (this.mww != null) {
                        this.mww.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    dkZ();
                    if (this.mwv != null) {
                        this.mwv.setVisibility(0);
                    }
                    if (this.mww != null) {
                        this.mww.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.mwE).r != -1 && dyl()) {
                    this.lOB = ((VideoPlayer) this.mwE).r;
                    ((VideoPlayer) this.mwE).r = -1L;
                }
                if (dyl() && this.lOB > 0) {
                    this.mwF.removeMessages(14);
                    this.msU.seekTo((int) this.lOB);
                }
                if (!this.ai) {
                    n(false);
                    if (this.mwD.d) {
                        W();
                    }
                    if (this.msU.getDuration() > 60000) {
                        if (this.msU.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.msU.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.msU.getDuration();
                    }
                } else {
                    a(false, true);
                }
                we(false);
                return;
            }
            this.mwD.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.mwH) {
            we(true);
            if (this.mwo != null) {
                this.mwo.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.mwF != null) {
                    this.mwF.JF(5);
                    this.mwF.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.mwH) {
            h(false);
        } else if (z) {
            if (z2) {
                we(false);
                if (this.mwo != null) {
                    this.mwo.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.mwo.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.mwF != null) {
                        this.mwF.removeMessages(5);
                    }
                }
            }
            if (this.mwF != null) {
                this.mwF.removeMessages(15);
                this.mwF.JF(15);
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
        if ("2".equals(this.ay) && h.dwH().a && this.mwD != null && !this.mwD.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mwE != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.mwC.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.JO(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.mwD != null) {
                        if (z) {
                            if (this.mwD.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dwA().a && !com.kascend.chushou.b.dwA().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.mwD.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.mwD.c);
                                if (!com.kascend.chushou.b.dwA().a && !com.kascend.chushou.b.dwA().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.mwD.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.JO(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dwA().a && !com.kascend.chushou.b.dwA().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.mwD.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.mwD.b);
                            if (!com.kascend.chushou.b.dwA().a && !com.kascend.chushou.b.dwA().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.mwE).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.mwE).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.JO(a.i.str_unsupport_file);
                    break;
            }
            wd(false);
            we(false);
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
            if (((VideoPlayer) this.mwE).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.mwE).d);
                ((VideoPlayer) this.mwE).a(((VideoPlayer) this.mwE).dwQ());
                this.msU = ((VideoPlayer) this.mwE).dwQ();
                ((VideoPlayer) this.mwE).d = false;
                if (!h.dwH().a) {
                    RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mwD.d) {
                                    f.this.a(((VideoPlayer) f.this.mwE).dwQ());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mwE).dwR().setDisplay(null);
                                ((VideoPlayer) f.this.mwE).dwR().stop();
                                ((VideoPlayer) f.this.mwE).dwR().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mwD.d) {
                        a(((VideoPlayer) this.mwE).dwQ());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mwE).dwR().setDisplay(null);
                    ((VideoPlayer) this.mwE).dwR().stop();
                    ((VideoPlayer) this.mwE).dwR().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.mwE).d);
                ((VideoPlayer) this.mwE).a(((VideoPlayer) this.mwE).dwR());
                this.msU = ((VideoPlayer) this.mwE).dwR();
                ((VideoPlayer) this.mwE).d = true;
                if (!h.dwH().a) {
                    RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mwD.d) {
                                    f.this.a(((VideoPlayer) f.this.mwE).dwR());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mwE).dwQ().setDisplay(null);
                                ((VideoPlayer) f.this.mwE).dwQ().stop();
                                ((VideoPlayer) f.this.mwE).dwQ().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mwD.d) {
                        a(((VideoPlayer) this.mwE).dwR());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mwE).dwQ().setDisplay(null);
                    ((VideoPlayer) this.mwE).dwQ().stop();
                    ((VideoPlayer) this.mwE).dwQ().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.mwK);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mwC != null) {
            this.mwC.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.mwE).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.mwE).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.mwE).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wd(boolean z) {
        if (this.mwo == null) {
            return this.ak;
        }
        View findViewById = this.mwo.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.mwz.setVisibility(0);
                this.mwA.setVisibility(0);
                this.mwA.setText(this.mwE.getString(a.i.str_get_video_info));
            }
            this.ak = true;
        }
        return this.ak;
    }

    protected void R() {
    }

    protected void dkZ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.mwq != null && this.mws != null && this.mwp != null) {
            if (this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.mwD.dxs().mRoominfo.mCreatorAvatar)) {
                this.mwq.i(this.mwD.dxs().mRoominfo.mCreatorAvatar, 0, b.a.nub, b.a.nub);
                this.mws.i(this.mwD.dxs().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.nub, b.a.nub);
            } else {
                this.mwq.xW(com.kascend.chushou.view.a.a(null));
                this.mws.xW(com.kascend.chushou.view.a.a(null));
            }
            this.mwp.setVisibility(0);
            if (this.mwu != null) {
                this.mwu.setEnabled(false);
            }
            R();
            if (this.mwv != null) {
                this.mwv.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.mwp != null) {
            this.mwp.setVisibility(8);
        }
        V();
        if (this.mwu != null) {
            this.mwu.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.mws != null) {
            this.mws.clearAnimation();
        }
    }

    protected void W() {
        if (this.mws != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.mws.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dyl() {
        return "3".equals(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean we(boolean z) {
        if (this.mwo == null) {
            return false;
        }
        if (this.mwx != null && this.mwx.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.mwo.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.mwo.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.mwz.setVisibility(0);
            if (this.mwD == null || !this.mwD.d()) {
                this.mwA.setText(this.mwE.getString(a.i.str_get_video_info));
                this.mwA.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dwH().a || this.mwD == null || this.mwD.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.msU.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.mwF != null) {
            this.mwF.removeMessages(15);
            this.mwF.JF(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mwo != null) {
            if (z) {
                if (!this.H && !this.mwH) {
                    this.mwB.setVisibility(0);
                    return;
                }
                return;
            }
            this.mwB.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.mwz != null) {
                this.mwz.setVisibility(0);
            }
            if (this.mwA != null) {
                this.mwA.setVisibility(0);
            }
            if (this.mwB != null) {
                this.mwB.setVisibility(0);
            }
            if (this.mwC != null) {
                this.mwC.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mwz != null) {
            this.mwz.setVisibility(8);
        }
        if (this.mwA != null) {
            this.mwA.setVisibility(8);
        }
        if (this.mwB != null) {
            this.mwB.setVisibility(8);
        }
        if (this.mwC != null) {
            this.mwC.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.mwy != null) {
            this.mwy.setVisibility(0);
            if (z) {
                this.mwy.setText(a.i.str_video_player_network_error);
            } else {
                this.mwy.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.mwF != null) {
            this.mwF.A(19, 2000L);
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
            this.mwC.setText(spannableStringBuilder);
            this.mwC.setVisibility(0);
        }
    }

    public void Z() {
        if (this.msU != null && this.msU.getPlayState() == 4) {
            this.msU.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.msU.getPlayState() == 4) {
                this.msU.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.mwF != null) {
                this.mwF.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dym() {
        return this.mwE == null || ((Activity) this.mwE).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dxP() {
    }
}
