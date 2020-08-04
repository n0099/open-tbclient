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
    protected int ao;
    protected TextView bDz;
    protected RelativeLayout nwj;
    protected FrescoThumbnailView nwk;
    protected FrescoThumbnailView nwl;
    protected TextView nwm;
    protected ImageView nwq;
    protected ProgressBar nws;
    protected TextView nwt;
    protected TextView nwu;
    protected TextView nwv;
    protected tv.chushou.zues.c nwy;
    protected final io.reactivex.disposables.a nwh = new io.reactivex.disposables.a();
    protected View nwi = null;
    protected View N = null;
    protected ImageButton nwn = null;
    protected ImageButton nwo = null;
    protected ImageButton nwp = null;
    protected PlayerErrorView nwr = null;
    protected b nww = null;
    protected Context nwx = null;
    protected AudioManager nwz = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean nwA = false;
    protected long mNe = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int nwB = 1;
    protected int at = 0;
    protected String au = "";
    protected String nwC = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.nwh.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.nsS != null) {
            this.nsS.setDisplay(surfaceHolder);
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
        if (this.N != null && this.nsS != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.nsS.getWidth();
            int height = this.nsS.getHeight();
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
            int i10 = this.nwB;
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
            if (this.nsS != null) {
                this.nsS.setDisplayRect(0, 0, i3, i);
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
        if (this.nww != null) {
            this.nww.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nwx != null) {
            if (((VideoPlayer) this.nwx).d) {
                b(((VideoPlayer) this.nwx).dMA());
                ((VideoPlayer) this.nwx).a(((VideoPlayer) this.nwx).dMA());
                this.nsS = ((VideoPlayer) this.nwx).dMA();
            } else {
                b(((VideoPlayer) this.nwx).dMz());
                ((VideoPlayer) this.nwx).a(((VideoPlayer) this.nwx).dMz());
                this.nsS = ((VideoPlayer) this.nwx).dMz();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nsS != null) {
            if (this.nww != null) {
                this.nww.b = 0;
                this.nww.c = 0;
            }
            xE(false);
            this.nww.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.nww.d);
                if (this.nww.d) {
                    T();
                    if (this.nwp != null) {
                        this.nwp.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.nwo != null) {
                        this.nwo.setVisibility(0);
                    }
                    if (this.nwp != null) {
                        this.nwp.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.nwx).r != -1 && dNZ()) {
                    this.mNe = ((VideoPlayer) this.nwx).r;
                    ((VideoPlayer) this.nwx).r = -1L;
                }
                if (dNZ() && this.mNe > 0) {
                    this.nwy.removeMessages(14);
                    this.nsS.seekTo((int) this.mNe);
                }
                if (!this.ai) {
                    n(false);
                    if (this.nww.d) {
                        W();
                    }
                    if (this.nsS.getDuration() > 60000) {
                        if (this.nsS.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.nsS.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.nsS.getDuration();
                    }
                } else {
                    a(false, true);
                }
                m(false);
                return;
            }
            this.nww.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.nwA) {
            m(true);
            if (this.nwi != null) {
                this.nwi.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.nwy != null) {
                    this.nwy.LT(5);
                    this.nwy.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.nwA) {
            h(false);
        } else if (z) {
            if (z2) {
                m(false);
                if (this.nwi != null) {
                    this.nwi.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.nwi.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.nwy != null) {
                        this.nwy.removeMessages(5);
                    }
                }
            }
            if (this.nwy != null) {
                this.nwy.removeMessages(15);
                this.nwy.LT(15);
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
        if ("2".equals(this.ay) && h.dMp().a && this.nww != null && !this.nww.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nwx != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.nwv.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.Mc(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.nww != null) {
                        if (z) {
                            if (this.nww.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.nww.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.nww.c);
                                if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.nww.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.Mc(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.nww.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.nww.b);
                            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.nwx).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.Mc(a.i.str_unsupport_file);
                    break;
            }
            xE(false);
            m(false);
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
            if (((VideoPlayer) this.nwx).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.nwx).d);
                ((VideoPlayer) this.nwx).a(((VideoPlayer) this.nwx).dMz());
                this.nsS = ((VideoPlayer) this.nwx).dMz();
                ((VideoPlayer) this.nwx).d = false;
                if (!h.dMp().a) {
                    RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.nww.d) {
                                    f.this.a(((VideoPlayer) f.this.nwx).dMz());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nwx).dMA().setDisplay(null);
                                ((VideoPlayer) f.this.nwx).dMA().stop();
                                ((VideoPlayer) f.this.nwx).dMA().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.nww.d) {
                        a(((VideoPlayer) this.nwx).dMz());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.nwx).dMA().setDisplay(null);
                    ((VideoPlayer) this.nwx).dMA().stop();
                    ((VideoPlayer) this.nwx).dMA().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.nwx).d);
                ((VideoPlayer) this.nwx).a(((VideoPlayer) this.nwx).dMA());
                this.nsS = ((VideoPlayer) this.nwx).dMA();
                ((VideoPlayer) this.nwx).d = true;
                if (!h.dMp().a) {
                    RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.nww.d) {
                                    f.this.a(((VideoPlayer) f.this.nwx).dMA());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nwx).dMz().setDisplay(null);
                                ((VideoPlayer) f.this.nwx).dMz().stop();
                                ((VideoPlayer) f.this.nwx).dMz().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.nww.d) {
                        a(((VideoPlayer) this.nwx).dMA());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.nwx).dMz().setDisplay(null);
                    ((VideoPlayer) this.nwx).dMz().stop();
                    ((VideoPlayer) this.nwx).dMz().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.nwC);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nwv != null) {
            this.nwv.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.nwx).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.nwx).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.nwx).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean xE(boolean z) {
        if (this.nwi == null) {
            return this.ak;
        }
        View findViewById = this.nwi.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.nws.setVisibility(0);
                this.nwt.setVisibility(0);
                this.nwt.setText(this.nwx.getString(a.i.str_get_video_info));
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
        if (this.nwk != null && this.nwl != null && this.nwj != null) {
            if (this.nww.dNb() != null && this.nww.dNb().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.nww.dNb().mRoominfo.mCreatorAvatar)) {
                this.nwk.i(this.nww.dNb().mRoominfo.mCreatorAvatar, 0, b.a.ouH, b.a.ouH);
                this.nwl.i(this.nww.dNb().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.ouH, b.a.ouH);
            } else {
                this.nwk.zR(com.kascend.chushou.view.a.a(null));
                this.nwl.zR(com.kascend.chushou.view.a.a(null));
            }
            this.nwj.setVisibility(0);
            if (this.nwn != null) {
                this.nwn.setEnabled(false);
            }
            R();
            if (this.nwo != null) {
                this.nwo.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.nwj != null) {
            this.nwj.setVisibility(8);
        }
        V();
        if (this.nwn != null) {
            this.nwn.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.nwl != null) {
            this.nwl.clearAnimation();
        }
    }

    protected void W() {
        if (this.nwl != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.nwl.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dNZ() {
        return "3".equals(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(boolean z) {
        if (this.nwi == null) {
            return false;
        }
        if (this.nwq != null && this.nwq.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.nwi.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.nwi.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.nws.setVisibility(0);
            if (this.nww == null || !this.nww.d()) {
                this.nwt.setText(this.nwx.getString(a.i.str_get_video_info));
                this.nwt.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dMp().a || this.nww == null || this.nww.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.nsS.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.nwy != null) {
            this.nwy.removeMessages(15);
            this.nwy.LT(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nwi != null) {
            if (z) {
                if (!this.H && !this.nwA) {
                    this.nwu.setVisibility(0);
                    return;
                }
                return;
            }
            this.nwu.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.nws != null) {
                this.nws.setVisibility(0);
            }
            if (this.nwt != null) {
                this.nwt.setVisibility(0);
            }
            if (this.nwu != null) {
                this.nwu.setVisibility(0);
            }
            if (this.nwv != null) {
                this.nwv.setVisibility(0);
                return;
            }
            return;
        }
        if (this.nws != null) {
            this.nws.setVisibility(8);
        }
        if (this.nwt != null) {
            this.nwt.setVisibility(8);
        }
        if (this.nwu != null) {
            this.nwu.setVisibility(8);
        }
        if (this.nwv != null) {
            this.nwv.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.nwr != null) {
            this.nwr.setVisibility(0);
            if (z) {
                this.nwr.setText(a.i.str_video_player_network_error);
            } else {
                this.nwr.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.nwy != null) {
            this.nwy.B(19, 2000L);
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
            this.nwv.setText(spannableStringBuilder);
            this.nwv.setVisibility(0);
        }
    }

    public void Z() {
        if (this.nsS != null && this.nsS.getPlayState() == 4) {
            this.nsS.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.nsS.getPlayState() == 4) {
                this.nsS.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.nwy != null) {
                this.nwy.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa() {
        return this.nwx == null || ((Activity) this.nwx).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dNC() {
    }
}
