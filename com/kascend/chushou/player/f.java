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
    protected RelativeLayout oal;
    protected FrescoThumbnailView oam;
    protected FrescoThumbnailView oan;
    protected ImageView oar;
    protected ProgressBar oat;
    protected TextView oau;
    protected TextView oav;
    protected TextView oaw;
    protected tv.chushou.zues.c oaz;
    protected final io.reactivex.disposables.a oai = new io.reactivex.disposables.a();
    protected View oaj = null;
    protected View oak = null;
    protected ImageButton oao = null;
    protected ImageButton oap = null;
    protected ImageButton oaq = null;
    protected PlayerErrorView oas = null;
    protected b oax = null;
    protected Context oay = null;
    protected AudioManager oaA = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean oaB = false;
    protected long nqu = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int as = 1;
    protected int oaC = 0;
    protected String au = "";
    protected String oaD = "";
    public String oaE = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.oai.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.nWQ != null) {
            this.nWQ.setDisplay(surfaceHolder);
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
        if (this.oak != null && this.nWQ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.oak.getLayoutParams();
            int width = this.nWQ.getWidth();
            int height = this.nWQ.getHeight();
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
            if (this.nWQ != null) {
                this.nWQ.setDisplayRect(0, 0, i3, i);
            }
            if (layoutParams.width != i7 || layoutParams.height != i8) {
                layoutParams.width = i7;
                layoutParams.height = i8;
                this.oak.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        this.ao = i;
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.oax != null) {
            this.oax.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.oay != null) {
            if (((VideoPlayer) this.oay).d) {
                b(((VideoPlayer) this.oay).ecJ());
                ((VideoPlayer) this.oay).a(((VideoPlayer) this.oay).ecJ());
                this.nWQ = ((VideoPlayer) this.oay).ecJ();
            } else {
                b(((VideoPlayer) this.oay).ecI());
                ((VideoPlayer) this.oay).a(((VideoPlayer) this.oay).ecI());
                this.nWQ = ((VideoPlayer) this.oay).ecI();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nWQ != null) {
            if (this.oax != null) {
                this.oax.b = 0;
                this.oax.c = 0;
            }
            yF(false);
            this.oax.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.oax.d);
                if (this.oax.d) {
                    T();
                    if (this.oaq != null) {
                        this.oaq.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.oap != null) {
                        this.oap.setVisibility(0);
                    }
                    if (this.oaq != null) {
                        this.oaq.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.oak != null) {
                        this.oak.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.oay).r != -1 && eeg()) {
                    this.nqu = ((VideoPlayer) this.oay).r;
                    ((VideoPlayer) this.oay).r = -1L;
                }
                if (eeg() && this.nqu > 0) {
                    this.oaz.removeMessages(14);
                    this.nWQ.seekTo((int) this.nqu);
                }
                if (!this.ai) {
                    n(false);
                    if (this.oax.d) {
                        W();
                    }
                    if (this.nWQ.getDuration() > 60000) {
                        if (this.nWQ.getDuration() < 300000) {
                            this.oaC = 60000;
                        } else {
                            this.oaC = Math.min(this.nWQ.getDuration(), 300000);
                        }
                    } else {
                        this.oaC = this.nWQ.getDuration();
                    }
                } else {
                    a(false, true);
                }
                yG(false);
                return;
            }
            this.oax.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.oaB) {
            yG(true);
            if (this.oaj != null) {
                this.oaj.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.oaz != null) {
                    this.oaz.Pb(5);
                    this.oaz.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.oaB) {
            h(false);
        } else if (z) {
            if (z2) {
                yG(false);
                if (this.oaj != null) {
                    this.oaj.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.oaj.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.oaz != null) {
                        this.oaz.removeMessages(5);
                    }
                }
            }
            if (this.oaz != null) {
                this.oaz.removeMessages(15);
                this.oaz.Pb(15);
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
        if ("2".equals(this.ay) && h.ecy().a && this.oax != null && !this.oax.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.oay != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.oaw.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.Pk(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.oax != null) {
                        if (z) {
                            if (this.oax.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.oax.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.oax.c);
                                if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.oax.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.Pk(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.oax.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.oax.b);
                            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.oay).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.oay).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.Pk(a.i.str_unsupport_file);
                    break;
            }
            yF(false);
            yG(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(tv.chushou.common.player.a aVar) {
        if (this.oak != null) {
            this.oak.setVisibility(0);
            if (aVar != null && (this.oak instanceof SurfaceView)) {
                aVar.setDisplay(((SurfaceView) this.oak).getHolder());
            }
        }
    }

    private void b(tv.chushou.common.player.a aVar) {
        if (this.oak != null && (this.oak instanceof SurfaceView)) {
            aVar.setDisplay(((SurfaceView) this.oak).getHolder());
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.oak != null) {
            if (((VideoPlayer) this.oay).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.oay).d);
                ((VideoPlayer) this.oay).a(((VideoPlayer) this.oay).ecI());
                this.nWQ = ((VideoPlayer) this.oay).ecI();
                ((VideoPlayer) this.oay).d = false;
                if (!h.ecy().a) {
                    RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.oax.d) {
                                    f.this.a(((VideoPlayer) f.this.oay).ecI());
                                } else if (f.this.oak != null) {
                                    f.this.oak.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.oay).ecJ().setDisplay(null);
                                ((VideoPlayer) f.this.oay).ecJ().stop();
                                ((VideoPlayer) f.this.oay).ecJ().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.oax.d) {
                        a(((VideoPlayer) this.oay).ecI());
                    } else if (this.oak != null) {
                        this.oak.setVisibility(8);
                    }
                    ((VideoPlayer) this.oay).ecJ().setDisplay(null);
                    ((VideoPlayer) this.oay).ecJ().stop();
                    ((VideoPlayer) this.oay).ecJ().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.oay).d);
                ((VideoPlayer) this.oay).a(((VideoPlayer) this.oay).ecJ());
                this.nWQ = ((VideoPlayer) this.oay).ecJ();
                ((VideoPlayer) this.oay).d = true;
                if (!h.ecy().a) {
                    RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.oax.d) {
                                    f.this.a(((VideoPlayer) f.this.oay).ecJ());
                                } else if (f.this.oak != null) {
                                    f.this.oak.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.oay).ecI().setDisplay(null);
                                ((VideoPlayer) f.this.oay).ecI().stop();
                                ((VideoPlayer) f.this.oay).ecI().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.oax.d) {
                        a(((VideoPlayer) this.oay).ecJ());
                    } else if (this.oak != null) {
                        this.oak.setVisibility(8);
                    }
                    ((VideoPlayer) this.oay).ecI().setDisplay(null);
                    ((VideoPlayer) this.oay).ecI().stop();
                    ((VideoPlayer) this.oay).ecI().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.oaD);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.oaw != null) {
            this.oaw.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.oay).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.oay).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.oay).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean yF(boolean z) {
        if (this.oaj == null) {
            return this.ak;
        }
        View findViewById = this.oaj.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.oat.setVisibility(0);
                this.oau.setVisibility(0);
                this.oau.setText(this.oay.getString(a.i.str_get_video_info));
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
        if (this.oam != null && this.oan != null && this.oal != null) {
            if (this.oax.edj() != null && this.oax.edj().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.oax.edj().mRoominfo.mCreatorAvatar)) {
                this.oam.i(this.oax.edj().mRoominfo.mCreatorAvatar, 0, b.a.oYs, b.a.oYs);
                this.oan.i(this.oax.edj().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.oYs, b.a.oYs);
            } else {
                this.oam.CL(com.kascend.chushou.view.a.a(null));
                this.oan.CL(com.kascend.chushou.view.a.a(null));
            }
            this.oal.setVisibility(0);
            if (this.oao != null) {
                this.oao.setEnabled(false);
            }
            R();
            if (this.oap != null) {
                this.oap.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.oal != null) {
            this.oal.setVisibility(8);
        }
        V();
        if (this.oao != null) {
            this.oao.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.oan != null) {
            this.oan.clearAnimation();
        }
    }

    protected void W() {
        if (this.oan != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.oan.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eeg() {
        return "3".equals(this.oaE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yG(boolean z) {
        if (this.oaj == null) {
            return false;
        }
        if (this.oar != null && this.oar.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.oaj.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.oaj.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.oat.setVisibility(0);
            if (this.oax == null || !this.oax.d()) {
                this.oau.setText(this.oay.getString(a.i.str_get_video_info));
                this.oau.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.ecy().a || this.oax == null || this.oax.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.nWQ.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.oaz != null) {
            this.oaz.removeMessages(15);
            this.oaz.Pb(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.oaj != null) {
            if (z) {
                if (!this.H && !this.oaB) {
                    this.oav.setVisibility(0);
                    return;
                }
                return;
            }
            this.oav.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.oat != null) {
                this.oat.setVisibility(0);
            }
            if (this.oau != null) {
                this.oau.setVisibility(0);
            }
            if (this.oav != null) {
                this.oav.setVisibility(0);
            }
            if (this.oaw != null) {
                this.oaw.setVisibility(0);
                return;
            }
            return;
        }
        if (this.oat != null) {
            this.oat.setVisibility(8);
        }
        if (this.oau != null) {
            this.oau.setVisibility(8);
        }
        if (this.oav != null) {
            this.oav.setVisibility(8);
        }
        if (this.oaw != null) {
            this.oaw.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.oas != null) {
            this.oas.setVisibility(0);
            if (z) {
                this.oas.setText(a.i.str_video_player_network_error);
            } else {
                this.oas.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.oaz != null) {
            this.oaz.C(19, 2000L);
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
            this.oaw.setText(spannableStringBuilder);
            this.oaw.setVisibility(0);
        }
    }

    public void Vc() {
        if (this.nWQ != null && this.nWQ.getPlayState() == 4) {
            this.nWQ.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.nWQ.getPlayState() == 4) {
                this.nWQ.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.oaz != null) {
                this.oaz.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa() {
        return this.oay == null || ((Activity) this.oay).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac() {
    }
}
