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
    protected ImageView nnC;
    protected ProgressBar nnE;
    protected TextView nnF;
    protected TextView nnG;
    protected TextView nnH;
    protected tv.chushou.zues.c nnK;
    protected RelativeLayout nnu;
    protected FrescoThumbnailView nnv;
    protected FrescoThumbnailView nnw;
    protected TextView nnx;
    protected TextView nny;
    protected final io.reactivex.disposables.a nns = new io.reactivex.disposables.a();
    protected View nnt = null;
    protected View N = null;
    protected ImageButton nnz = null;
    protected ImageButton nnA = null;
    protected ImageButton nnB = null;
    protected PlayerErrorView nnD = null;
    protected b nnI = null;
    protected Context nnJ = null;
    protected AudioManager nnL = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean nnM = false;
    protected long mEY = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int nnN = 1;
    protected int at = 0;
    protected String au = "";
    protected String nnO = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.nns.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.nke != null) {
            this.nke.setDisplay(surfaceHolder);
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
        if (this.N != null && this.nke != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.nke.getWidth();
            int height = this.nke.getHeight();
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
            int i10 = this.nnN;
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
            if (this.nke != null) {
                this.nke.setDisplayRect(0, 0, i3, i);
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
        if (this.nnI != null) {
            this.nnI.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nnJ != null) {
            if (((VideoPlayer) this.nnJ).d) {
                b(((VideoPlayer) this.nnJ).dJe());
                ((VideoPlayer) this.nnJ).a(((VideoPlayer) this.nnJ).dJe());
                this.nke = ((VideoPlayer) this.nnJ).dJe();
            } else {
                b(((VideoPlayer) this.nnJ).dJd());
                ((VideoPlayer) this.nnJ).a(((VideoPlayer) this.nnJ).dJd());
                this.nke = ((VideoPlayer) this.nnJ).dJd();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nke != null) {
            if (this.nnI != null) {
                this.nnI.b = 0;
                this.nnI.c = 0;
            }
            wZ(false);
            this.nnI.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.nnI.d);
                if (this.nnI.d) {
                    T();
                    if (this.nnB != null) {
                        this.nnB.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.nnA != null) {
                        this.nnA.setVisibility(0);
                    }
                    if (this.nnB != null) {
                        this.nnB.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.nnJ).r != -1 && dKD()) {
                    this.mEY = ((VideoPlayer) this.nnJ).r;
                    ((VideoPlayer) this.nnJ).r = -1L;
                }
                if (dKD() && this.mEY > 0) {
                    this.nnK.removeMessages(14);
                    this.nke.seekTo((int) this.mEY);
                }
                if (!this.ai) {
                    n(false);
                    if (this.nnI.d) {
                        W();
                    }
                    if (this.nke.getDuration() > 60000) {
                        if (this.nke.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.nke.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.nke.getDuration();
                    }
                } else {
                    a(false, true);
                }
                m(false);
                return;
            }
            this.nnI.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.nnM) {
            m(true);
            if (this.nnt != null) {
                this.nnt.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.nnK != null) {
                    this.nnK.Lz(5);
                    this.nnK.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.nnM) {
            h(false);
        } else if (z) {
            if (z2) {
                m(false);
                if (this.nnt != null) {
                    this.nnt.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.nnt.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.nnK != null) {
                        this.nnK.removeMessages(5);
                    }
                }
            }
            if (this.nnK != null) {
                this.nnK.removeMessages(15);
                this.nnK.Lz(15);
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
        if ("2".equals(this.ay) && h.dIT().a && this.nnI != null && !this.nnI.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nnJ != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.nnH.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.LI(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.nnI != null) {
                        if (z) {
                            if (this.nnI.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.nnI.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.nnI.c);
                                if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.nnI.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.LI(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.nnI.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.nnI.b);
                            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.nnJ).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
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
            if (((VideoPlayer) this.nnJ).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.nnJ).d);
                ((VideoPlayer) this.nnJ).a(((VideoPlayer) this.nnJ).dJd());
                this.nke = ((VideoPlayer) this.nnJ).dJd();
                ((VideoPlayer) this.nnJ).d = false;
                if (!h.dIT().a) {
                    RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.nnI.d) {
                                    f.this.a(((VideoPlayer) f.this.nnJ).dJd());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nnJ).dJe().setDisplay(null);
                                ((VideoPlayer) f.this.nnJ).dJe().stop();
                                ((VideoPlayer) f.this.nnJ).dJe().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.nnI.d) {
                        a(((VideoPlayer) this.nnJ).dJd());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.nnJ).dJe().setDisplay(null);
                    ((VideoPlayer) this.nnJ).dJe().stop();
                    ((VideoPlayer) this.nnJ).dJe().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.nnJ).d);
                ((VideoPlayer) this.nnJ).a(((VideoPlayer) this.nnJ).dJe());
                this.nke = ((VideoPlayer) this.nnJ).dJe();
                ((VideoPlayer) this.nnJ).d = true;
                if (!h.dIT().a) {
                    RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.nnI.d) {
                                    f.this.a(((VideoPlayer) f.this.nnJ).dJe());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.nnJ).dJd().setDisplay(null);
                                ((VideoPlayer) f.this.nnJ).dJd().stop();
                                ((VideoPlayer) f.this.nnJ).dJd().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.nnI.d) {
                        a(((VideoPlayer) this.nnJ).dJe());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.nnJ).dJd().setDisplay(null);
                    ((VideoPlayer) this.nnJ).dJd().stop();
                    ((VideoPlayer) this.nnJ).dJd().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.nnO);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nnH != null) {
            this.nnH.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.nnJ).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.nnJ).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.nnJ).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wZ(boolean z) {
        if (this.nnt == null) {
            return this.ak;
        }
        View findViewById = this.nnt.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.nnE.setVisibility(0);
                this.nnF.setVisibility(0);
                this.nnF.setText(this.nnJ.getString(a.i.str_get_video_info));
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
        if (this.nnv != null && this.nnw != null && this.nnu != null) {
            if (this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.nnI.dJF().mRoominfo.mCreatorAvatar)) {
                this.nnv.i(this.nnI.dJF().mRoominfo.mCreatorAvatar, 0, b.a.olZ, b.a.olZ);
                this.nnw.i(this.nnI.dJF().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.olZ, b.a.olZ);
            } else {
                this.nnv.zs(com.kascend.chushou.view.a.a(null));
                this.nnw.zs(com.kascend.chushou.view.a.a(null));
            }
            this.nnu.setVisibility(0);
            if (this.nnz != null) {
                this.nnz.setEnabled(false);
            }
            R();
            if (this.nnA != null) {
                this.nnA.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.nnu != null) {
            this.nnu.setVisibility(8);
        }
        V();
        if (this.nnz != null) {
            this.nnz.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.nnw != null) {
            this.nnw.clearAnimation();
        }
    }

    protected void W() {
        if (this.nnw != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.nnw.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dKD() {
        return "3".equals(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(boolean z) {
        if (this.nnt == null) {
            return false;
        }
        if (this.nnC != null && this.nnC.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.nnt.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.nnt.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.nnE.setVisibility(0);
            if (this.nnI == null || !this.nnI.d()) {
                this.nnF.setText(this.nnJ.getString(a.i.str_get_video_info));
                this.nnF.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dIT().a || this.nnI == null || this.nnI.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.nke.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.nnK != null) {
            this.nnK.removeMessages(15);
            this.nnK.Lz(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nnt != null) {
            if (z) {
                if (!this.H && !this.nnM) {
                    this.nnG.setVisibility(0);
                    return;
                }
                return;
            }
            this.nnG.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.nnE != null) {
                this.nnE.setVisibility(0);
            }
            if (this.nnF != null) {
                this.nnF.setVisibility(0);
            }
            if (this.nnG != null) {
                this.nnG.setVisibility(0);
            }
            if (this.nnH != null) {
                this.nnH.setVisibility(0);
                return;
            }
            return;
        }
        if (this.nnE != null) {
            this.nnE.setVisibility(8);
        }
        if (this.nnF != null) {
            this.nnF.setVisibility(8);
        }
        if (this.nnG != null) {
            this.nnG.setVisibility(8);
        }
        if (this.nnH != null) {
            this.nnH.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.nnD != null) {
            this.nnD.setVisibility(0);
            if (z) {
                this.nnD.setText(a.i.str_video_player_network_error);
            } else {
                this.nnD.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.nnK != null) {
            this.nnK.B(19, 2000L);
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
            this.nnH.setText(spannableStringBuilder);
            this.nnH.setVisibility(0);
        }
    }

    public void Z() {
        if (this.nke != null && this.nke.getPlayState() == 4) {
            this.nke.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.nke.getPlayState() == 4) {
                this.nke.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.nnK != null) {
                this.nnK.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa() {
        return this.nnJ == null || ((Activity) this.nnJ).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dKg() {
    }
}
