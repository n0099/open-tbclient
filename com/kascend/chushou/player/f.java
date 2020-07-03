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
    protected ProgressBar nnB;
    protected TextView nnC;
    protected TextView nnD;
    protected TextView nnE;
    protected tv.chushou.zues.c nnH;
    protected RelativeLayout nnr;
    protected FrescoThumbnailView nns;
    protected FrescoThumbnailView nnt;
    protected TextView nnu;
    protected TextView nnv;
    protected ImageView nnz;
    protected final io.reactivex.disposables.a nnp = new io.reactivex.disposables.a();
    protected View nnq = null;
    protected View N = null;
    protected ImageButton nnw = null;
    protected ImageButton nnx = null;
    protected ImageButton nny = null;
    protected PlayerErrorView nnA = null;
    protected b nnF = null;
    protected Context nnG = null;
    protected AudioManager nnI = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean nnJ = false;
    protected long mEV = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int nnK = 1;
    protected int at = 0;
    protected String au = "";
    protected String nnL = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.nnp.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.nkb != null) {
            this.nkb.setDisplay(surfaceHolder);
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
        if (this.N != null && this.nkb != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.nkb.getWidth();
            int height = this.nkb.getHeight();
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
            int i10 = this.nnK;
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
            if (this.nkb != null) {
                this.nkb.setDisplayRect(0, 0, i3, i);
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
        if (this.nnF != null) {
            this.nnF.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nnG != null) {
            if (((VideoPlayer) this.nnG).d) {
                b(((VideoPlayer) this.nnG).dJa());
                ((VideoPlayer) this.nnG).a(((VideoPlayer) this.nnG).dJa());
                this.nkb = ((VideoPlayer) this.nnG).dJa();
            } else {
                b(((VideoPlayer) this.nnG).dIZ());
                ((VideoPlayer) this.nnG).a(((VideoPlayer) this.nnG).dIZ());
                this.nkb = ((VideoPlayer) this.nnG).dIZ();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nkb != null) {
            if (this.nnF != null) {
                this.nnF.b = 0;
                this.nnF.c = 0;
            }
            wZ(false);
            this.nnF.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.nnF.d);
                if (this.nnF.d) {
                    T();
                    if (this.nny != null) {
                        this.nny.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.nnx != null) {
                        this.nnx.setVisibility(0);
                    }
                    if (this.nny != null) {
                        this.nny.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.nnG).r != -1 && dKz()) {
                    this.mEV = ((VideoPlayer) this.nnG).r;
                    ((VideoPlayer) this.nnG).r = -1L;
                }
                if (dKz() && this.mEV > 0) {
                    this.nnH.removeMessages(14);
                    this.nkb.seekTo((int) this.mEV);
                }
                if (!this.ai) {
                    n(false);
                    if (this.nnF.d) {
                        W();
                    }
                    if (this.nkb.getDuration() > 60000) {
                        if (this.nkb.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.nkb.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.nkb.getDuration();
                    }
                } else {
                    a(false, true);
                }
                m(false);
                return;
            }
            this.nnF.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.nnJ) {
            m(true);
            if (this.nnq != null) {
                this.nnq.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.nnH != null) {
                    this.nnH.Lz(5);
                    this.nnH.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.nnJ) {
            h(false);
        } else if (z) {
            if (z2) {
                m(false);
                if (this.nnq != null) {
                    this.nnq.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.nnq.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.nnH != null) {
                        this.nnH.removeMessages(5);
                    }
                }
            }
            if (this.nnH != null) {
                this.nnH.removeMessages(15);
                this.nnH.Lz(15);
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
        if ("2".equals(this.ay) && h.dIP().a && this.nnF != null && !this.nnF.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nnG != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.nnE.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.LI(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.nnF != null) {
                        if (z) {
                            if (this.nnF.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.nnF.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.nnF.c);
                                if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.nnF.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.LI(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.nnF.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.nnF.b);
                            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.nnG).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.LI(a.i.str_unsupport_file);
                    break;
            }
            wZ(false);
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
            if (((VideoPlayer) this.nnG).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.nnG).d);
                ((VideoPlayer) this.nnG).a(((VideoPlayer) this.nnG).dIZ());
                this.nkb = ((VideoPlayer) this.nnG).dIZ();
                ((VideoPlayer) this.nnG).d = false;
                if (!h.dIP().a) {
                    RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.nnF.d) {
                                    f.this.a(((VideoPlayer) f.this.nnG).dIZ());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nnG).dJa().setDisplay(null);
                                ((VideoPlayer) f.this.nnG).dJa().stop();
                                ((VideoPlayer) f.this.nnG).dJa().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.nnF.d) {
                        a(((VideoPlayer) this.nnG).dIZ());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.nnG).dJa().setDisplay(null);
                    ((VideoPlayer) this.nnG).dJa().stop();
                    ((VideoPlayer) this.nnG).dJa().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.nnG).d);
                ((VideoPlayer) this.nnG).a(((VideoPlayer) this.nnG).dJa());
                this.nkb = ((VideoPlayer) this.nnG).dJa();
                ((VideoPlayer) this.nnG).d = true;
                if (!h.dIP().a) {
                    RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.nnF.d) {
                                    f.this.a(((VideoPlayer) f.this.nnG).dJa());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nnG).dIZ().setDisplay(null);
                                ((VideoPlayer) f.this.nnG).dIZ().stop();
                                ((VideoPlayer) f.this.nnG).dIZ().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.nnF.d) {
                        a(((VideoPlayer) this.nnG).dJa());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.nnG).dIZ().setDisplay(null);
                    ((VideoPlayer) this.nnG).dIZ().stop();
                    ((VideoPlayer) this.nnG).dIZ().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.nnL);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nnE != null) {
            this.nnE.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.nnG).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.nnG).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.nnG).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wZ(boolean z) {
        if (this.nnq == null) {
            return this.ak;
        }
        View findViewById = this.nnq.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.nnB.setVisibility(0);
                this.nnC.setVisibility(0);
                this.nnC.setText(this.nnG.getString(a.i.str_get_video_info));
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
        if (this.nns != null && this.nnt != null && this.nnr != null) {
            if (this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.nnF.dJB().mRoominfo.mCreatorAvatar)) {
                this.nns.i(this.nnF.dJB().mRoominfo.mCreatorAvatar, 0, b.a.olW, b.a.olW);
                this.nnt.i(this.nnF.dJB().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.olW, b.a.olW);
            } else {
                this.nns.zs(com.kascend.chushou.view.a.a(null));
                this.nnt.zs(com.kascend.chushou.view.a.a(null));
            }
            this.nnr.setVisibility(0);
            if (this.nnw != null) {
                this.nnw.setEnabled(false);
            }
            R();
            if (this.nnx != null) {
                this.nnx.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.nnr != null) {
            this.nnr.setVisibility(8);
        }
        V();
        if (this.nnw != null) {
            this.nnw.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.nnt != null) {
            this.nnt.clearAnimation();
        }
    }

    protected void W() {
        if (this.nnt != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.nnt.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dKz() {
        return "3".equals(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(boolean z) {
        if (this.nnq == null) {
            return false;
        }
        if (this.nnz != null && this.nnz.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.nnq.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.nnq.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.nnB.setVisibility(0);
            if (this.nnF == null || !this.nnF.d()) {
                this.nnC.setText(this.nnG.getString(a.i.str_get_video_info));
                this.nnC.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dIP().a || this.nnF == null || this.nnF.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.nkb.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.nnH != null) {
            this.nnH.removeMessages(15);
            this.nnH.Lz(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nnq != null) {
            if (z) {
                if (!this.H && !this.nnJ) {
                    this.nnD.setVisibility(0);
                    return;
                }
                return;
            }
            this.nnD.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.nnB != null) {
                this.nnB.setVisibility(0);
            }
            if (this.nnC != null) {
                this.nnC.setVisibility(0);
            }
            if (this.nnD != null) {
                this.nnD.setVisibility(0);
            }
            if (this.nnE != null) {
                this.nnE.setVisibility(0);
                return;
            }
            return;
        }
        if (this.nnB != null) {
            this.nnB.setVisibility(8);
        }
        if (this.nnC != null) {
            this.nnC.setVisibility(8);
        }
        if (this.nnD != null) {
            this.nnD.setVisibility(8);
        }
        if (this.nnE != null) {
            this.nnE.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.nnA != null) {
            this.nnA.setVisibility(0);
            if (z) {
                this.nnA.setText(a.i.str_video_player_network_error);
            } else {
                this.nnA.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.nnH != null) {
            this.nnH.B(19, 2000L);
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
            this.nnE.setText(spannableStringBuilder);
            this.nnE.setVisibility(0);
        }
    }

    public void Z() {
        if (this.nkb != null && this.nkb.getPlayState() == 4) {
            this.nkb.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.nkb.getPlayState() == 4) {
                this.nkb.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.nnH != null) {
                this.nnH.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa() {
        return this.nnG == null || ((Activity) this.nnG).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dKc() {
    }
}
