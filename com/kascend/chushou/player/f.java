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
    protected tv.chushou.zues.c mwA;
    protected RelativeLayout mwk;
    protected FrescoThumbnailView mwl;
    protected ImageView mwm;
    protected FrescoThumbnailView mwn;
    protected TextView mwo;
    protected ImageView mws;
    protected ProgressBar mwu;
    protected TextView mwv;
    protected TextView mww;
    protected TextView mwx;
    protected final io.reactivex.disposables.a mwi = new io.reactivex.disposables.a();
    protected View mwj = null;
    protected View N = null;
    protected ImageButton mwp = null;
    protected ImageButton mwq = null;
    protected ImageButton mwr = null;
    protected PlayerErrorView mwt = null;
    protected b mwy = null;
    protected Context mwz = null;
    protected AudioManager mwB = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean mwC = false;
    protected long lOx = 0;
    protected int ap = -1;
    protected int mwD = 0;
    protected int ar = 0;
    protected int mwE = 1;
    protected int at = 0;
    protected String au = "";
    protected String mwF = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mwi.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.msP != null) {
            this.msP.setDisplay(surfaceHolder);
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
        if (this.N != null && this.msP != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.msP.getWidth();
            int height = this.msP.getHeight();
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
            tv.chushou.zues.utils.e.i("VideoPlayerLiveBaseFragment", String.format("width = %d,height = %d;mPlayAreaWidth=%d, mPlayAreaHeight=%d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(this.ar), Integer.valueOf(this.mwD)));
            int i7 = this.ar;
            int i8 = this.mwD;
            if (width <= 0 || height <= 0) {
                width = this.ar;
                height = this.mwD;
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
            int i10 = this.mwE;
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
                i8 = this.mwD;
            }
            tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "SetVideoViewLayout out <<<< w:" + layoutParams.width + " h:" + layoutParams.height);
            if (this.msP != null) {
                this.msP.setDisplayRect(0, 0, i3, i);
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
        if (this.mwy != null) {
            this.mwy.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mwz != null) {
            if (((VideoPlayer) this.mwz).d) {
                b(((VideoPlayer) this.mwz).dwU());
                ((VideoPlayer) this.mwz).a(((VideoPlayer) this.mwz).dwU());
                this.msP = ((VideoPlayer) this.mwz).dwU();
            } else {
                b(((VideoPlayer) this.mwz).dwT());
                ((VideoPlayer) this.mwz).a(((VideoPlayer) this.mwz).dwT());
                this.msP = ((VideoPlayer) this.mwz).dwT();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.msP != null) {
            if (this.mwy != null) {
                this.mwy.b = 0;
                this.mwy.c = 0;
            }
            wd(false);
            this.mwy.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.mwy.d);
                if (this.mwy.d) {
                    T();
                    if (this.mwr != null) {
                        this.mwr.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    dlc();
                    if (this.mwq != null) {
                        this.mwq.setVisibility(0);
                    }
                    if (this.mwr != null) {
                        this.mwr.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.mwz).r != -1 && dyp()) {
                    this.lOx = ((VideoPlayer) this.mwz).r;
                    ((VideoPlayer) this.mwz).r = -1L;
                }
                if (dyp() && this.lOx > 0) {
                    this.mwA.removeMessages(14);
                    this.msP.seekTo((int) this.lOx);
                }
                if (!this.ai) {
                    n(false);
                    if (this.mwy.d) {
                        W();
                    }
                    if (this.msP.getDuration() > 60000) {
                        if (this.msP.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.msP.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.msP.getDuration();
                    }
                } else {
                    a(false, true);
                }
                we(false);
                return;
            }
            this.mwy.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.mwC) {
            we(true);
            if (this.mwj != null) {
                this.mwj.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.mwA != null) {
                    this.mwA.JF(5);
                    this.mwA.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.mwC) {
            h(false);
        } else if (z) {
            if (z2) {
                we(false);
                if (this.mwj != null) {
                    this.mwj.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.mwj.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.mwA != null) {
                        this.mwA.removeMessages(5);
                    }
                }
            }
            if (this.mwA != null) {
                this.mwA.removeMessages(15);
                this.mwA.JF(15);
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
        if ("2".equals(this.ay) && h.dwK().a && this.mwy != null && !this.mwy.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mwz != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.mwx.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.JO(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.mwy != null) {
                        if (z) {
                            if (this.mwy.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.mwy.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.mwy.c);
                                if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.mwy.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.JO(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.mwy.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.mwy.b);
                            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.mwz).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.mwz).a(true, (Uri) null, false);
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
            if (((VideoPlayer) this.mwz).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.mwz).d);
                ((VideoPlayer) this.mwz).a(((VideoPlayer) this.mwz).dwT());
                this.msP = ((VideoPlayer) this.mwz).dwT();
                ((VideoPlayer) this.mwz).d = false;
                if (!h.dwK().a) {
                    RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mwy.d) {
                                    f.this.a(((VideoPlayer) f.this.mwz).dwT());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mwz).dwU().setDisplay(null);
                                ((VideoPlayer) f.this.mwz).dwU().stop();
                                ((VideoPlayer) f.this.mwz).dwU().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mwy.d) {
                        a(((VideoPlayer) this.mwz).dwT());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mwz).dwU().setDisplay(null);
                    ((VideoPlayer) this.mwz).dwU().stop();
                    ((VideoPlayer) this.mwz).dwU().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.mwz).d);
                ((VideoPlayer) this.mwz).a(((VideoPlayer) this.mwz).dwU());
                this.msP = ((VideoPlayer) this.mwz).dwU();
                ((VideoPlayer) this.mwz).d = true;
                if (!h.dwK().a) {
                    RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mwy.d) {
                                    f.this.a(((VideoPlayer) f.this.mwz).dwU());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mwz).dwT().setDisplay(null);
                                ((VideoPlayer) f.this.mwz).dwT().stop();
                                ((VideoPlayer) f.this.mwz).dwT().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mwy.d) {
                        a(((VideoPlayer) this.mwz).dwU());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mwz).dwT().setDisplay(null);
                    ((VideoPlayer) this.mwz).dwT().stop();
                    ((VideoPlayer) this.mwz).dwT().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.mwF);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mwx != null) {
            this.mwx.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.mwz).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.mwz).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.mwz).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wd(boolean z) {
        if (this.mwj == null) {
            return this.ak;
        }
        View findViewById = this.mwj.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.mwu.setVisibility(0);
                this.mwv.setVisibility(0);
                this.mwv.setText(this.mwz.getString(a.i.str_get_video_info));
            }
            this.ak = true;
        }
        return this.ak;
    }

    protected void R() {
    }

    protected void dlc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.mwl != null && this.mwn != null && this.mwk != null) {
            if (this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.mwy.dxv().mRoominfo.mCreatorAvatar)) {
                this.mwl.i(this.mwy.dxv().mRoominfo.mCreatorAvatar, 0, b.a.ntY, b.a.ntY);
                this.mwn.i(this.mwy.dxv().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.ntY, b.a.ntY);
            } else {
                this.mwl.xW(com.kascend.chushou.view.a.a(null));
                this.mwn.xW(com.kascend.chushou.view.a.a(null));
            }
            this.mwk.setVisibility(0);
            if (this.mwp != null) {
                this.mwp.setEnabled(false);
            }
            R();
            if (this.mwq != null) {
                this.mwq.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.mwk != null) {
            this.mwk.setVisibility(8);
        }
        V();
        if (this.mwp != null) {
            this.mwp.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.mwn != null) {
            this.mwn.clearAnimation();
        }
    }

    protected void W() {
        if (this.mwn != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.mwn.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dyp() {
        return "3".equals(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean we(boolean z) {
        if (this.mwj == null) {
            return false;
        }
        if (this.mws != null && this.mws.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.mwj.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.mwj.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.mwu.setVisibility(0);
            if (this.mwy == null || !this.mwy.d()) {
                this.mwv.setText(this.mwz.getString(a.i.str_get_video_info));
                this.mwv.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dwK().a || this.mwy == null || this.mwy.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.msP.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.mwA != null) {
            this.mwA.removeMessages(15);
            this.mwA.JF(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mwj != null) {
            if (z) {
                if (!this.H && !this.mwC) {
                    this.mww.setVisibility(0);
                    return;
                }
                return;
            }
            this.mww.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.mwu != null) {
                this.mwu.setVisibility(0);
            }
            if (this.mwv != null) {
                this.mwv.setVisibility(0);
            }
            if (this.mww != null) {
                this.mww.setVisibility(0);
            }
            if (this.mwx != null) {
                this.mwx.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mwu != null) {
            this.mwu.setVisibility(8);
        }
        if (this.mwv != null) {
            this.mwv.setVisibility(8);
        }
        if (this.mww != null) {
            this.mww.setVisibility(8);
        }
        if (this.mwx != null) {
            this.mwx.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.mwt != null) {
            this.mwt.setVisibility(0);
            if (z) {
                this.mwt.setText(a.i.str_video_player_network_error);
            } else {
                this.mwt.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.mwA != null) {
            this.mwA.A(19, 2000L);
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
            this.mwx.setText(spannableStringBuilder);
            this.mwx.setVisibility(0);
        }
    }

    public void Z() {
        if (this.msP != null && this.msP.getPlayState() == 4) {
            this.msP.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.msP.getPlayState() == 4) {
                this.msP.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.mwA != null) {
                this.mwA.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dyq() {
        return this.mwz == null || ((Activity) this.mwz).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dxT() {
    }
}
