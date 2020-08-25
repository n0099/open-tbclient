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
    protected TextView T;
    protected int ao;
    protected TextView bJa;
    protected RelativeLayout nPY;
    protected FrescoThumbnailView nPZ;
    protected FrescoThumbnailView nQa;
    protected ImageView nQe;
    protected ProgressBar nQg;
    protected TextView nQh;
    protected TextView nQi;
    protected TextView nQj;
    protected tv.chushou.zues.c nQm;
    protected final io.reactivex.disposables.a nPV = new io.reactivex.disposables.a();
    protected View nPW = null;
    protected View nPX = null;
    protected ImageButton nQb = null;
    protected ImageButton nQc = null;
    protected ImageButton nQd = null;
    protected PlayerErrorView nQf = null;
    protected b nQk = null;
    protected Context nQl = null;
    protected AudioManager nQn = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean nQo = false;
    protected long nga = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int nQp = 1;
    protected int nQq = 0;
    protected String au = "";
    protected String nQr = "";
    public String nQs = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.nPV.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.nMD != null) {
            this.nMD.setDisplay(surfaceHolder);
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
        if (this.nPX != null && this.nMD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nPX.getLayoutParams();
            int width = this.nMD.getWidth();
            int height = this.nMD.getHeight();
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
            int i10 = this.nQp;
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
            if (this.nMD != null) {
                this.nMD.setDisplayRect(0, 0, i3, i);
            }
            if (layoutParams.width != i7 || layoutParams.height != i8) {
                layoutParams.width = i7;
                layoutParams.height = i8;
                this.nPX.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        this.ao = i;
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nQk != null) {
            this.nQk.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nQl != null) {
            if (((VideoPlayer) this.nQl).d) {
                b(((VideoPlayer) this.nQl).dYC());
                ((VideoPlayer) this.nQl).a(((VideoPlayer) this.nQl).dYC());
                this.nMD = ((VideoPlayer) this.nQl).dYC();
            } else {
                b(((VideoPlayer) this.nQl).dYB());
                ((VideoPlayer) this.nQl).a(((VideoPlayer) this.nQl).dYB());
                this.nMD = ((VideoPlayer) this.nQl).dYB();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nMD != null) {
            if (this.nQk != null) {
                this.nQk.b = 0;
                this.nQk.c = 0;
            }
            yv(false);
            this.nQk.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.nQk.d);
                if (this.nQk.d) {
                    T();
                    if (this.nQd != null) {
                        this.nQd.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.nQc != null) {
                        this.nQc.setVisibility(0);
                    }
                    if (this.nQd != null) {
                        this.nQd.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.nPX != null) {
                        this.nPX.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.nQl).r != -1 && dZZ()) {
                    this.nga = ((VideoPlayer) this.nQl).r;
                    ((VideoPlayer) this.nQl).r = -1L;
                }
                if (dZZ() && this.nga > 0) {
                    this.nQm.removeMessages(14);
                    this.nMD.seekTo((int) this.nga);
                }
                if (!this.ai) {
                    n(false);
                    if (this.nQk.d) {
                        W();
                    }
                    if (this.nMD.getDuration() > 60000) {
                        if (this.nMD.getDuration() < 300000) {
                            this.nQq = 60000;
                        } else {
                            this.nQq = Math.min(this.nMD.getDuration(), 300000);
                        }
                    } else {
                        this.nQq = this.nMD.getDuration();
                    }
                } else {
                    a(false, true);
                }
                yw(false);
                return;
            }
            this.nQk.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.nQo) {
            yw(true);
            if (this.nPW != null) {
                this.nPW.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.nQm != null) {
                    this.nQm.Ow(5);
                    this.nQm.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.nQo) {
            h(false);
        } else if (z) {
            if (z2) {
                yw(false);
                if (this.nPW != null) {
                    this.nPW.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.nPW.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.nQm != null) {
                        this.nQm.removeMessages(5);
                    }
                }
            }
            if (this.nQm != null) {
                this.nQm.removeMessages(15);
                this.nQm.Ow(15);
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
        if ("2".equals(this.ay) && h.dYr().a && this.nQk != null && !this.nQk.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nQl != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.nQj.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.OF(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.nQk != null) {
                        if (z) {
                            if (this.nQk.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.nQk.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.nQk.c);
                                if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.nQk.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.OF(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.nQk.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.nQk.b);
                            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.nQl).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.OF(a.i.str_unsupport_file);
                    break;
            }
            yv(false);
            yw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(tv.chushou.common.player.a aVar) {
        if (this.nPX != null) {
            this.nPX.setVisibility(0);
            if (aVar != null && (this.nPX instanceof SurfaceView)) {
                aVar.setDisplay(((SurfaceView) this.nPX).getHolder());
            }
        }
    }

    private void b(tv.chushou.common.player.a aVar) {
        if (this.nPX != null && (this.nPX instanceof SurfaceView)) {
            aVar.setDisplay(((SurfaceView) this.nPX).getHolder());
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nPX != null) {
            if (((VideoPlayer) this.nQl).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.nQl).d);
                ((VideoPlayer) this.nQl).a(((VideoPlayer) this.nQl).dYB());
                this.nMD = ((VideoPlayer) this.nQl).dYB();
                ((VideoPlayer) this.nQl).d = false;
                if (!h.dYr().a) {
                    RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.nQk.d) {
                                    f.this.a(((VideoPlayer) f.this.nQl).dYB());
                                } else if (f.this.nPX != null) {
                                    f.this.nPX.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nQl).dYC().setDisplay(null);
                                ((VideoPlayer) f.this.nQl).dYC().stop();
                                ((VideoPlayer) f.this.nQl).dYC().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.nQk.d) {
                        a(((VideoPlayer) this.nQl).dYB());
                    } else if (this.nPX != null) {
                        this.nPX.setVisibility(8);
                    }
                    ((VideoPlayer) this.nQl).dYC().setDisplay(null);
                    ((VideoPlayer) this.nQl).dYC().stop();
                    ((VideoPlayer) this.nQl).dYC().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.nQl).d);
                ((VideoPlayer) this.nQl).a(((VideoPlayer) this.nQl).dYC());
                this.nMD = ((VideoPlayer) this.nQl).dYC();
                ((VideoPlayer) this.nQl).d = true;
                if (!h.dYr().a) {
                    RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.nQk.d) {
                                    f.this.a(((VideoPlayer) f.this.nQl).dYC());
                                } else if (f.this.nPX != null) {
                                    f.this.nPX.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nQl).dYB().setDisplay(null);
                                ((VideoPlayer) f.this.nQl).dYB().stop();
                                ((VideoPlayer) f.this.nQl).dYB().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.nQk.d) {
                        a(((VideoPlayer) this.nQl).dYC());
                    } else if (this.nPX != null) {
                        this.nPX.setVisibility(8);
                    }
                    ((VideoPlayer) this.nQl).dYB().setDisplay(null);
                    ((VideoPlayer) this.nQl).dYB().stop();
                    ((VideoPlayer) this.nQl).dYB().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.nQr);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nQj != null) {
            this.nQj.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.nQl).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.nQl).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.nQl).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean yv(boolean z) {
        if (this.nPW == null) {
            return this.ak;
        }
        View findViewById = this.nPW.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.nQg.setVisibility(0);
                this.nQh.setVisibility(0);
                this.nQh.setText(this.nQl.getString(a.i.str_get_video_info));
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
        if (this.nPZ != null && this.nQa != null && this.nPY != null) {
            if (this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.nQk.dZc().mRoominfo.mCreatorAvatar)) {
                this.nPZ.i(this.nQk.dZc().mRoominfo.mCreatorAvatar, 0, b.a.oOy, b.a.oOy);
                this.nQa.i(this.nQk.dZc().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.oOy, b.a.oOy);
            } else {
                this.nPZ.Ck(com.kascend.chushou.view.a.a(null));
                this.nQa.Ck(com.kascend.chushou.view.a.a(null));
            }
            this.nPY.setVisibility(0);
            if (this.nQb != null) {
                this.nQb.setEnabled(false);
            }
            R();
            if (this.nQc != null) {
                this.nQc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.nPY != null) {
            this.nPY.setVisibility(8);
        }
        V();
        if (this.nQb != null) {
            this.nQb.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.nQa != null) {
            this.nQa.clearAnimation();
        }
    }

    protected void W() {
        if (this.nQa != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.nQa.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dZZ() {
        return "3".equals(this.nQs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yw(boolean z) {
        if (this.nPW == null) {
            return false;
        }
        if (this.nQe != null && this.nQe.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.nPW.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.nPW.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.nQg.setVisibility(0);
            if (this.nQk == null || !this.nQk.d()) {
                this.nQh.setText(this.nQl.getString(a.i.str_get_video_info));
                this.nQh.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dYr().a || this.nQk == null || this.nQk.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.nMD.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.nQm != null) {
            this.nQm.removeMessages(15);
            this.nQm.Ow(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nPW != null) {
            if (z) {
                if (!this.H && !this.nQo) {
                    this.nQi.setVisibility(0);
                    return;
                }
                return;
            }
            this.nQi.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.nQg != null) {
                this.nQg.setVisibility(0);
            }
            if (this.nQh != null) {
                this.nQh.setVisibility(0);
            }
            if (this.nQi != null) {
                this.nQi.setVisibility(0);
            }
            if (this.nQj != null) {
                this.nQj.setVisibility(0);
                return;
            }
            return;
        }
        if (this.nQg != null) {
            this.nQg.setVisibility(8);
        }
        if (this.nQh != null) {
            this.nQh.setVisibility(8);
        }
        if (this.nQi != null) {
            this.nQi.setVisibility(8);
        }
        if (this.nQj != null) {
            this.nQj.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.nQf != null) {
            this.nQf.setVisibility(0);
            if (z) {
                this.nQf.setText(a.i.str_video_player_network_error);
            } else {
                this.nQf.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.nQm != null) {
            this.nQm.B(19, 2000L);
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
            this.nQj.setText(spannableStringBuilder);
            this.nQj.setVisibility(0);
        }
    }

    public void Ut() {
        if (this.nMD != null && this.nMD.getPlayState() == 4) {
            this.nMD.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.nMD.getPlayState() == 4) {
                this.nMD.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.nQm != null) {
                this.nQm.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa() {
        return this.nQl == null || ((Activity) this.nQl).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac() {
    }
}
