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
    protected ImageView pqB;
    protected ProgressBar pqD;
    protected TextView pqE;
    protected TextView pqF;
    protected TextView pqG;
    protected tv.chushou.zues.c pqJ;
    protected RelativeLayout pqv;
    protected FrescoThumbnailView pqw;
    protected FrescoThumbnailView pqx;
    protected final io.reactivex.disposables.a pqs = new io.reactivex.disposables.a();
    protected View pqt = null;
    protected View pqu = null;
    protected ImageButton pqy = null;
    protected ImageButton pqz = null;
    protected ImageButton pqA = null;
    protected PlayerErrorView pqC = null;
    protected b pqH = null;
    protected Context pqI = null;
    protected AudioManager pqK = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean pqL = false;
    protected long orw = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int as = 1;
    protected int pqM = 0;
    protected String au = "";
    protected String pqN = "";
    public String pqO = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.pqs.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.pmW != null) {
            this.pmW.setDisplay(surfaceHolder);
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
        if (this.pqu != null && this.pmW != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pqu.getLayoutParams();
            int width = this.pmW.getWidth();
            int height = this.pmW.getHeight();
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
            if (this.pmW != null) {
                this.pmW.setDisplayRect(0, 0, i3, i);
            }
            if (layoutParams.width != i7 || layoutParams.height != i8) {
                layoutParams.width = i7;
                layoutParams.height = i8;
                this.pqu.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        this.ao = i;
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.pqH != null) {
            this.pqH.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.pqI != null) {
            if (((VideoPlayer) this.pqI).d) {
                b(((VideoPlayer) this.pqI).euj());
                ((VideoPlayer) this.pqI).a(((VideoPlayer) this.pqI).euj());
                this.pmW = ((VideoPlayer) this.pqI).euj();
            } else {
                b(((VideoPlayer) this.pqI).eui());
                ((VideoPlayer) this.pqI).a(((VideoPlayer) this.pqI).eui());
                this.pmW = ((VideoPlayer) this.pqI).eui();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.pmW != null) {
            if (this.pqH != null) {
                this.pqH.b = 0;
                this.pqH.c = 0;
            }
            AF(false);
            this.pqH.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.pqH.d);
                if (this.pqH.d) {
                    T();
                    if (this.pqA != null) {
                        this.pqA.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.pqz != null) {
                        this.pqz.setVisibility(0);
                    }
                    if (this.pqA != null) {
                        this.pqA.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.pqu != null) {
                        this.pqu.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.pqI).r != -1 && evG()) {
                    this.orw = ((VideoPlayer) this.pqI).r;
                    ((VideoPlayer) this.pqI).r = -1L;
                }
                if (evG() && this.orw > 0) {
                    this.pqJ.removeMessages(14);
                    this.pmW.seekTo((int) this.orw);
                }
                if (!this.ai) {
                    n(false);
                    if (this.pqH.d) {
                        W();
                    }
                    if (this.pmW.getDuration() > 60000) {
                        if (this.pmW.getDuration() < 300000) {
                            this.pqM = 60000;
                        } else {
                            this.pqM = Math.min(this.pmW.getDuration(), 300000);
                        }
                    } else {
                        this.pqM = this.pmW.getDuration();
                    }
                } else {
                    a(false, true);
                }
                AG(false);
                return;
            }
            this.pqH.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.pqL) {
            AG(true);
            if (this.pqt != null) {
                this.pqt.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.pqJ != null) {
                    this.pqJ.RT(5);
                    this.pqJ.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.pqL) {
            h(false);
        } else if (z) {
            if (z2) {
                AG(false);
                if (this.pqt != null) {
                    this.pqt.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.pqt.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.pqJ != null) {
                        this.pqJ.removeMessages(5);
                    }
                }
            }
            if (this.pqJ != null) {
                this.pqJ.removeMessages(15);
                this.pqJ.RT(15);
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
        if ("2".equals(this.ay) && h.etY().f4087a && this.pqH != null && !this.pqH.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.pqI != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.pqG.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.Sc(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.pqH != null) {
                        if (z) {
                            if (this.pqH.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.pqH.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.pqH.c);
                                if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.pqH.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.Sc(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.pqH.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.pqH.b);
                            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.pqI).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.Sc(a.i.str_unsupport_file);
                    break;
            }
            AF(false);
            AG(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(tv.chushou.common.player.a aVar) {
        if (this.pqu != null) {
            this.pqu.setVisibility(0);
            if (aVar != null && (this.pqu instanceof SurfaceView)) {
                aVar.setDisplay(((SurfaceView) this.pqu).getHolder());
            }
        }
    }

    private void b(tv.chushou.common.player.a aVar) {
        if (this.pqu != null && (this.pqu instanceof SurfaceView)) {
            aVar.setDisplay(((SurfaceView) this.pqu).getHolder());
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.pqu != null) {
            if (((VideoPlayer) this.pqI).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.pqI).d);
                ((VideoPlayer) this.pqI).a(((VideoPlayer) this.pqI).eui());
                this.pmW = ((VideoPlayer) this.pqI).eui();
                ((VideoPlayer) this.pqI).d = false;
                if (!h.etY().f4087a) {
                    RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.pqH.d) {
                                    f.this.a(((VideoPlayer) f.this.pqI).eui());
                                } else if (f.this.pqu != null) {
                                    f.this.pqu.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.pqI).euj().setDisplay(null);
                                ((VideoPlayer) f.this.pqI).euj().stop();
                                ((VideoPlayer) f.this.pqI).euj().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.pqH.d) {
                        a(((VideoPlayer) this.pqI).eui());
                    } else if (this.pqu != null) {
                        this.pqu.setVisibility(8);
                    }
                    ((VideoPlayer) this.pqI).euj().setDisplay(null);
                    ((VideoPlayer) this.pqI).euj().stop();
                    ((VideoPlayer) this.pqI).euj().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.pqI).d);
                ((VideoPlayer) this.pqI).a(((VideoPlayer) this.pqI).euj());
                this.pmW = ((VideoPlayer) this.pqI).euj();
                ((VideoPlayer) this.pqI).d = true;
                if (!h.etY().f4087a) {
                    RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.pqH.d) {
                                    f.this.a(((VideoPlayer) f.this.pqI).euj());
                                } else if (f.this.pqu != null) {
                                    f.this.pqu.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.pqI).eui().setDisplay(null);
                                ((VideoPlayer) f.this.pqI).eui().stop();
                                ((VideoPlayer) f.this.pqI).eui().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.pqH.d) {
                        a(((VideoPlayer) this.pqI).euj());
                    } else if (this.pqu != null) {
                        this.pqu.setVisibility(8);
                    }
                    ((VideoPlayer) this.pqI).eui().setDisplay(null);
                    ((VideoPlayer) this.pqI).eui().stop();
                    ((VideoPlayer) this.pqI).eui().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.pqN);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.pqG != null) {
            this.pqG.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.pqI).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.pqI).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.pqI).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean AF(boolean z) {
        if (this.pqt == null) {
            return this.ak;
        }
        View findViewById = this.pqt.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.pqD.setVisibility(0);
                this.pqE.setVisibility(0);
                this.pqE.setText(this.pqI.getString(a.i.str_get_video_info));
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
        if (this.pqw != null && this.pqx != null && this.pqv != null) {
            if (this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.pqH.euJ().mRoominfo.mCreatorAvatar)) {
                this.pqw.i(this.pqH.euJ().mRoominfo.mCreatorAvatar, 0, b.a.qov, b.a.qov);
                this.pqx.i(this.pqH.euJ().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.qov, b.a.qov);
            } else {
                this.pqw.DX(com.kascend.chushou.view.a.a(null));
                this.pqx.DX(com.kascend.chushou.view.a.a(null));
            }
            this.pqv.setVisibility(0);
            if (this.pqy != null) {
                this.pqy.setEnabled(false);
            }
            R();
            if (this.pqz != null) {
                this.pqz.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.pqv != null) {
            this.pqv.setVisibility(8);
        }
        V();
        if (this.pqy != null) {
            this.pqy.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.pqx != null) {
            this.pqx.clearAnimation();
        }
    }

    protected void W() {
        if (this.pqx != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.pqx.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean evG() {
        return "3".equals(this.pqO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean AG(boolean z) {
        if (this.pqt == null) {
            return false;
        }
        if (this.pqB != null && this.pqB.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.pqt.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.pqt.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.pqD.setVisibility(0);
            if (this.pqH == null || !this.pqH.d()) {
                this.pqE.setText(this.pqI.getString(a.i.str_get_video_info));
                this.pqE.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.etY().f4087a || this.pqH == null || this.pqH.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.pmW.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.pqJ != null) {
            this.pqJ.removeMessages(15);
            this.pqJ.RT(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.pqt != null) {
            if (z) {
                if (!this.H && !this.pqL) {
                    this.pqF.setVisibility(0);
                    return;
                }
                return;
            }
            this.pqF.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.pqD != null) {
                this.pqD.setVisibility(0);
            }
            if (this.pqE != null) {
                this.pqE.setVisibility(0);
            }
            if (this.pqF != null) {
                this.pqF.setVisibility(0);
            }
            if (this.pqG != null) {
                this.pqG.setVisibility(0);
                return;
            }
            return;
        }
        if (this.pqD != null) {
            this.pqD.setVisibility(8);
        }
        if (this.pqE != null) {
            this.pqE.setVisibility(8);
        }
        if (this.pqF != null) {
            this.pqF.setVisibility(8);
        }
        if (this.pqG != null) {
            this.pqG.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.pqC != null) {
            this.pqC.setVisibility(0);
            if (z) {
                this.pqC.setText(a.i.str_video_player_network_error);
            } else {
                this.pqC.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.pqJ != null) {
            this.pqJ.D(19, 2000L);
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
            this.pqG.setText(spannableStringBuilder);
            this.pqG.setVisibility(0);
        }
    }

    public void abs() {
        if (this.pmW != null && this.pmW.getPlayState() == 4) {
            this.pmW.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.pmW.getPlayState() == 4) {
                this.pmW.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.pqJ != null) {
                this.pqJ.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa() {
        return this.pqI == null || ((Activity) this.pqI).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac() {
    }
}
