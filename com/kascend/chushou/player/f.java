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
    protected TextView bJe;
    protected TextView nQA;
    protected TextView nQB;
    protected tv.chushou.zues.c nQE;
    protected RelativeLayout nQq;
    protected FrescoThumbnailView nQr;
    protected FrescoThumbnailView nQs;
    protected ImageView nQw;
    protected ProgressBar nQy;
    protected TextView nQz;
    protected final io.reactivex.disposables.a nQn = new io.reactivex.disposables.a();
    protected View nQo = null;
    protected View nQp = null;
    protected ImageButton nQt = null;
    protected ImageButton nQu = null;
    protected ImageButton nQv = null;
    protected PlayerErrorView nQx = null;
    protected b nQC = null;
    protected Context nQD = null;
    protected AudioManager nQF = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean nQG = false;
    protected long ngs = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int nQH = 1;
    protected int nQI = 0;
    protected String au = "";
    protected String nQJ = "";
    public String nQK = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.nQn.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.nMV != null) {
            this.nMV.setDisplay(surfaceHolder);
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
        if (this.nQp != null && this.nMV != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nQp.getLayoutParams();
            int width = this.nMV.getWidth();
            int height = this.nMV.getHeight();
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
            int i10 = this.nQH;
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
            if (this.nMV != null) {
                this.nMV.setDisplayRect(0, 0, i3, i);
            }
            if (layoutParams.width != i7 || layoutParams.height != i8) {
                layoutParams.width = i7;
                layoutParams.height = i8;
                this.nQp.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        this.ao = i;
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nQC != null) {
            this.nQC.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nQD != null) {
            if (((VideoPlayer) this.nQD).d) {
                b(((VideoPlayer) this.nQD).dYL());
                ((VideoPlayer) this.nQD).a(((VideoPlayer) this.nQD).dYL());
                this.nMV = ((VideoPlayer) this.nQD).dYL();
            } else {
                b(((VideoPlayer) this.nQD).dYK());
                ((VideoPlayer) this.nQD).a(((VideoPlayer) this.nQD).dYK());
                this.nMV = ((VideoPlayer) this.nQD).dYK();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nMV != null) {
            if (this.nQC != null) {
                this.nQC.b = 0;
                this.nQC.c = 0;
            }
            yx(false);
            this.nQC.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.nQC.d);
                if (this.nQC.d) {
                    T();
                    if (this.nQv != null) {
                        this.nQv.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.nQu != null) {
                        this.nQu.setVisibility(0);
                    }
                    if (this.nQv != null) {
                        this.nQv.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.nQp != null) {
                        this.nQp.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.nQD).r != -1 && eai()) {
                    this.ngs = ((VideoPlayer) this.nQD).r;
                    ((VideoPlayer) this.nQD).r = -1L;
                }
                if (eai() && this.ngs > 0) {
                    this.nQE.removeMessages(14);
                    this.nMV.seekTo((int) this.ngs);
                }
                if (!this.ai) {
                    n(false);
                    if (this.nQC.d) {
                        W();
                    }
                    if (this.nMV.getDuration() > 60000) {
                        if (this.nMV.getDuration() < 300000) {
                            this.nQI = 60000;
                        } else {
                            this.nQI = Math.min(this.nMV.getDuration(), 300000);
                        }
                    } else {
                        this.nQI = this.nMV.getDuration();
                    }
                } else {
                    a(false, true);
                }
                yy(false);
                return;
            }
            this.nQC.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.nQG) {
            yy(true);
            if (this.nQo != null) {
                this.nQo.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.nQE != null) {
                    this.nQE.Ow(5);
                    this.nQE.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.nQG) {
            h(false);
        } else if (z) {
            if (z2) {
                yy(false);
                if (this.nQo != null) {
                    this.nQo.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.nQo.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.nQE != null) {
                        this.nQE.removeMessages(5);
                    }
                }
            }
            if (this.nQE != null) {
                this.nQE.removeMessages(15);
                this.nQE.Ow(15);
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
        if ("2".equals(this.ay) && h.dYA().a && this.nQC != null && !this.nQC.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nQD != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.nQB.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.OF(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.nQC != null) {
                        if (z) {
                            if (this.nQC.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.nQC.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.nQC.c);
                                if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.nQC.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.OF(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.nQC.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.nQC.b);
                            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.nQD).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.nQD).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.OF(a.i.str_unsupport_file);
                    break;
            }
            yx(false);
            yy(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(tv.chushou.common.player.a aVar) {
        if (this.nQp != null) {
            this.nQp.setVisibility(0);
            if (aVar != null && (this.nQp instanceof SurfaceView)) {
                aVar.setDisplay(((SurfaceView) this.nQp).getHolder());
            }
        }
    }

    private void b(tv.chushou.common.player.a aVar) {
        if (this.nQp != null && (this.nQp instanceof SurfaceView)) {
            aVar.setDisplay(((SurfaceView) this.nQp).getHolder());
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nQp != null) {
            if (((VideoPlayer) this.nQD).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.nQD).d);
                ((VideoPlayer) this.nQD).a(((VideoPlayer) this.nQD).dYK());
                this.nMV = ((VideoPlayer) this.nQD).dYK();
                ((VideoPlayer) this.nQD).d = false;
                if (!h.dYA().a) {
                    RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.nQC.d) {
                                    f.this.a(((VideoPlayer) f.this.nQD).dYK());
                                } else if (f.this.nQp != null) {
                                    f.this.nQp.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nQD).dYL().setDisplay(null);
                                ((VideoPlayer) f.this.nQD).dYL().stop();
                                ((VideoPlayer) f.this.nQD).dYL().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.nQC.d) {
                        a(((VideoPlayer) this.nQD).dYK());
                    } else if (this.nQp != null) {
                        this.nQp.setVisibility(8);
                    }
                    ((VideoPlayer) this.nQD).dYL().setDisplay(null);
                    ((VideoPlayer) this.nQD).dYL().stop();
                    ((VideoPlayer) this.nQD).dYL().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.nQD).d);
                ((VideoPlayer) this.nQD).a(((VideoPlayer) this.nQD).dYL());
                this.nMV = ((VideoPlayer) this.nQD).dYL();
                ((VideoPlayer) this.nQD).d = true;
                if (!h.dYA().a) {
                    RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.nQC.d) {
                                    f.this.a(((VideoPlayer) f.this.nQD).dYL());
                                } else if (f.this.nQp != null) {
                                    f.this.nQp.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nQD).dYK().setDisplay(null);
                                ((VideoPlayer) f.this.nQD).dYK().stop();
                                ((VideoPlayer) f.this.nQD).dYK().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.nQC.d) {
                        a(((VideoPlayer) this.nQD).dYL());
                    } else if (this.nQp != null) {
                        this.nQp.setVisibility(8);
                    }
                    ((VideoPlayer) this.nQD).dYK().setDisplay(null);
                    ((VideoPlayer) this.nQD).dYK().stop();
                    ((VideoPlayer) this.nQD).dYK().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.nQJ);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nQB != null) {
            this.nQB.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.nQD).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.nQD).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.nQD).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean yx(boolean z) {
        if (this.nQo == null) {
            return this.ak;
        }
        View findViewById = this.nQo.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.nQy.setVisibility(0);
                this.nQz.setVisibility(0);
                this.nQz.setText(this.nQD.getString(a.i.str_get_video_info));
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
        if (this.nQr != null && this.nQs != null && this.nQq != null) {
            if (this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.nQC.dZl().mRoominfo.mCreatorAvatar)) {
                this.nQr.i(this.nQC.dZl().mRoominfo.mCreatorAvatar, 0, b.a.oOQ, b.a.oOQ);
                this.nQs.i(this.nQC.dZl().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.oOQ, b.a.oOQ);
            } else {
                this.nQr.Ck(com.kascend.chushou.view.a.a(null));
                this.nQs.Ck(com.kascend.chushou.view.a.a(null));
            }
            this.nQq.setVisibility(0);
            if (this.nQt != null) {
                this.nQt.setEnabled(false);
            }
            R();
            if (this.nQu != null) {
                this.nQu.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.nQq != null) {
            this.nQq.setVisibility(8);
        }
        V();
        if (this.nQt != null) {
            this.nQt.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.nQs != null) {
            this.nQs.clearAnimation();
        }
    }

    protected void W() {
        if (this.nQs != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.nQs.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eai() {
        return "3".equals(this.nQK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yy(boolean z) {
        if (this.nQo == null) {
            return false;
        }
        if (this.nQw != null && this.nQw.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.nQo.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.nQo.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.nQy.setVisibility(0);
            if (this.nQC == null || !this.nQC.d()) {
                this.nQz.setText(this.nQD.getString(a.i.str_get_video_info));
                this.nQz.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dYA().a || this.nQC == null || this.nQC.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.nMV.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.nQE != null) {
            this.nQE.removeMessages(15);
            this.nQE.Ow(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nQo != null) {
            if (z) {
                if (!this.H && !this.nQG) {
                    this.nQA.setVisibility(0);
                    return;
                }
                return;
            }
            this.nQA.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.nQy != null) {
                this.nQy.setVisibility(0);
            }
            if (this.nQz != null) {
                this.nQz.setVisibility(0);
            }
            if (this.nQA != null) {
                this.nQA.setVisibility(0);
            }
            if (this.nQB != null) {
                this.nQB.setVisibility(0);
                return;
            }
            return;
        }
        if (this.nQy != null) {
            this.nQy.setVisibility(8);
        }
        if (this.nQz != null) {
            this.nQz.setVisibility(8);
        }
        if (this.nQA != null) {
            this.nQA.setVisibility(8);
        }
        if (this.nQB != null) {
            this.nQB.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.nQx != null) {
            this.nQx.setVisibility(0);
            if (z) {
                this.nQx.setText(a.i.str_video_player_network_error);
            } else {
                this.nQx.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.nQE != null) {
            this.nQE.B(19, 2000L);
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
            this.nQB.setText(spannableStringBuilder);
            this.nQB.setVisibility(0);
        }
    }

    public void Ut() {
        if (this.nMV != null && this.nMV.getPlayState() == 4) {
            this.nMV.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.nMV.getPlayState() == 4) {
                this.nMV.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.nQE != null) {
                this.nQE.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa() {
        return this.nQD == null || ((Activity) this.nQD).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac() {
    }
}
