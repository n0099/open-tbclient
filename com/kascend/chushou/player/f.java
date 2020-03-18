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
    protected RelativeLayout mZM;
    protected FrescoThumbnailView mZN;
    protected ImageView mZO;
    protected FrescoThumbnailView mZP;
    protected TextView mZQ;
    protected ImageView mZU;
    protected ProgressBar mZW;
    protected TextView mZX;
    protected TextView mZY;
    protected TextView mZZ;
    protected tv.chushou.zues.c nac;
    protected final io.reactivex.disposables.a mZK = new io.reactivex.disposables.a();
    protected View mZL = null;
    protected View N = null;
    protected ImageButton mZR = null;
    protected ImageButton mZS = null;
    protected ImageButton mZT = null;
    protected PlayerErrorView mZV = null;
    protected b naa = null;
    protected Context nab = null;
    protected AudioManager nad = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean nae = false;
    protected long kXT = 0;
    protected int ap = -1;
    protected int naf = 0;
    protected int ar = 0;
    protected int nag = 1;
    protected int at = 0;
    protected String au = "";
    protected String nah = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mZK.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.mWp != null) {
            this.mWp.setDisplay(surfaceHolder);
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
        if (this.N != null && this.mWp != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.mWp.getWidth();
            int height = this.mWp.getHeight();
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
            tv.chushou.zues.utils.e.i("VideoPlayerLiveBaseFragment", String.format("width = %d,height = %d;mPlayAreaWidth=%d, mPlayAreaHeight=%d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(this.ar), Integer.valueOf(this.naf)));
            int i7 = this.ar;
            int i8 = this.naf;
            if (width <= 0 || height <= 0) {
                width = this.ar;
                height = this.naf;
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
            int i10 = this.nag;
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
                i8 = this.naf;
            }
            tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "SetVideoViewLayout out <<<< w:" + layoutParams.width + " h:" + layoutParams.height);
            if (this.mWp != null) {
                this.mWp.setDisplayRect(0, 0, i3, i);
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
        if (this.naa != null) {
            this.naa.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nab != null) {
            if (((VideoPlayer) this.nab).d) {
                b(((VideoPlayer) this.nab).dCC());
                ((VideoPlayer) this.nab).a(((VideoPlayer) this.nab).dCC());
                this.mWp = ((VideoPlayer) this.nab).dCC();
            } else {
                b(((VideoPlayer) this.nab).dCB());
                ((VideoPlayer) this.nab).a(((VideoPlayer) this.nab).dCB());
                this.mWp = ((VideoPlayer) this.nab).dCB();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mWp != null) {
            if (this.naa != null) {
                this.naa.b = 0;
                this.naa.c = 0;
            }
            wv(false);
            this.naa.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.naa.d);
                if (this.naa.d) {
                    T();
                    if (this.mZT != null) {
                        this.mZT.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    cXT();
                    if (this.mZS != null) {
                        this.mZS.setVisibility(0);
                    }
                    if (this.mZT != null) {
                        this.mZT.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.nab).r != -1 && dEo()) {
                    this.kXT = ((VideoPlayer) this.nab).r;
                    ((VideoPlayer) this.nab).r = -1L;
                }
                if (dEo() && this.kXT > 0) {
                    this.nac.removeMessages(14);
                    this.mWp.seekTo((int) this.kXT);
                }
                if (!this.ai) {
                    n(false);
                    if (this.naa.d) {
                        W();
                    }
                    if (this.mWp.getDuration() > 60000) {
                        if (this.mWp.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.mWp.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.mWp.getDuration();
                    }
                } else {
                    a(false, true);
                }
                ww(false);
                return;
            }
            this.naa.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.nae) {
            ww(true);
            if (this.mZL != null) {
                this.mZL.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.nac != null) {
                    this.nac.Ol(5);
                    this.nac.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.nae) {
            h(false);
        } else if (z) {
            if (z2) {
                ww(false);
                if (this.mZL != null) {
                    this.mZL.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.mZL.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.nac != null) {
                        this.nac.removeMessages(5);
                    }
                }
            }
            if (this.nac != null) {
                this.nac.removeMessages(15);
                this.nac.Ol(15);
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
        if ("2".equals(this.ay) && h.dCs().a && this.naa != null && !this.naa.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nab != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.mZZ.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.Os(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.naa != null) {
                        if (z) {
                            if (this.naa.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.naa.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.naa.c);
                                if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.naa.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.Os(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.naa.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.naa.b);
                            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.nab).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.Os(a.i.str_unsupport_file);
                    break;
            }
            wv(false);
            ww(false);
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
            if (((VideoPlayer) this.nab).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.nab).d);
                ((VideoPlayer) this.nab).a(((VideoPlayer) this.nab).dCB());
                this.mWp = ((VideoPlayer) this.nab).dCB();
                ((VideoPlayer) this.nab).d = false;
                if (!h.dCs().a) {
                    RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.naa.d) {
                                    f.this.a(((VideoPlayer) f.this.nab).dCB());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nab).dCC().setDisplay(null);
                                ((VideoPlayer) f.this.nab).dCC().stop();
                                ((VideoPlayer) f.this.nab).dCC().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.naa.d) {
                        a(((VideoPlayer) this.nab).dCB());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.nab).dCC().setDisplay(null);
                    ((VideoPlayer) this.nab).dCC().stop();
                    ((VideoPlayer) this.nab).dCC().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.nab).d);
                ((VideoPlayer) this.nab).a(((VideoPlayer) this.nab).dCC());
                this.mWp = ((VideoPlayer) this.nab).dCC();
                ((VideoPlayer) this.nab).d = true;
                if (!h.dCs().a) {
                    RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.naa.d) {
                                    f.this.a(((VideoPlayer) f.this.nab).dCC());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nab).dCB().setDisplay(null);
                                ((VideoPlayer) f.this.nab).dCB().stop();
                                ((VideoPlayer) f.this.nab).dCB().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.naa.d) {
                        a(((VideoPlayer) this.nab).dCC());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.nab).dCB().setDisplay(null);
                    ((VideoPlayer) this.nab).dCB().stop();
                    ((VideoPlayer) this.nab).dCB().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.nah);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mZZ != null) {
            this.mZZ.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.nab).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.nab).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.nab).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wv(boolean z) {
        if (this.mZL == null) {
            return this.ak;
        }
        View findViewById = this.mZL.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.mZW.setVisibility(0);
                this.mZX.setVisibility(0);
                this.mZX.setText(this.nab.getString(a.i.str_get_video_info));
            }
            this.ak = true;
        }
        return this.ak;
    }

    protected void R() {
    }

    protected void cXT() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.mZN != null && this.mZP != null && this.mZM != null) {
            if (this.naa.dDd() != null && this.naa.dDd().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.naa.dDd().mRoominfo.mCreatorAvatar)) {
                this.mZN.i(this.naa.dDd().mRoominfo.mCreatorAvatar, 0, b.a.medium, b.a.medium);
                this.mZP.i(this.naa.dDd().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.medium, b.a.medium);
            } else {
                this.mZN.xw(com.kascend.chushou.view.a.a(null));
                this.mZP.xw(com.kascend.chushou.view.a.a(null));
            }
            this.mZM.setVisibility(0);
            if (this.mZR != null) {
                this.mZR.setEnabled(false);
            }
            R();
            if (this.mZS != null) {
                this.mZS.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.mZM != null) {
            this.mZM.setVisibility(8);
        }
        V();
        if (this.mZR != null) {
            this.mZR.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.mZP != null) {
            this.mZP.clearAnimation();
        }
    }

    protected void W() {
        if (this.mZP != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.mZP.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dEo() {
        return "3".equals(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ww(boolean z) {
        if (this.mZL == null) {
            return false;
        }
        if (this.mZU != null && this.mZU.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.mZL.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.mZL.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.mZW.setVisibility(0);
            if (this.naa == null || !this.naa.d()) {
                this.mZX.setText(this.nab.getString(a.i.str_get_video_info));
                this.mZX.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dCs().a || this.naa == null || this.naa.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.mWp.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.nac != null) {
            this.nac.removeMessages(15);
            this.nac.Ol(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mZL != null) {
            if (z) {
                if (!this.H && !this.nae) {
                    this.mZY.setVisibility(0);
                    return;
                }
                return;
            }
            this.mZY.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.mZW != null) {
                this.mZW.setVisibility(0);
            }
            if (this.mZX != null) {
                this.mZX.setVisibility(0);
            }
            if (this.mZY != null) {
                this.mZY.setVisibility(0);
            }
            if (this.mZZ != null) {
                this.mZZ.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mZW != null) {
            this.mZW.setVisibility(8);
        }
        if (this.mZX != null) {
            this.mZX.setVisibility(8);
        }
        if (this.mZY != null) {
            this.mZY.setVisibility(8);
        }
        if (this.mZZ != null) {
            this.mZZ.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.mZV != null) {
            this.mZV.setVisibility(0);
            if (z) {
                this.mZV.setText(a.i.str_video_player_network_error);
            } else {
                this.mZV.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.nac != null) {
            this.nac.K(19, 2000L);
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
            this.mZZ.setText(spannableStringBuilder);
            this.mZZ.setVisibility(0);
        }
    }

    public void Z() {
        if (this.mWp != null && this.mWp.getPlayState() == 4) {
            this.mWp.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.mWp.getPlayState() == 4) {
                this.mWp.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.nac != null) {
                this.nac.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dEp() {
        return this.nab == null || ((Activity) this.nab).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dDH() {
    }
}
