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
    protected RelativeLayout mQj;
    protected FrescoThumbnailView mQk;
    protected FrescoThumbnailView mQl;
    protected TextView mQm;
    protected TextView mQn;
    protected ImageView mQr;
    protected ProgressBar mQt;
    protected TextView mQu;
    protected TextView mQv;
    protected TextView mQw;
    protected tv.chushou.zues.c mQz;
    protected final io.reactivex.disposables.a mQh = new io.reactivex.disposables.a();
    protected View mQi = null;
    protected View N = null;
    protected ImageButton mQo = null;
    protected ImageButton mQp = null;
    protected ImageButton mQq = null;
    protected PlayerErrorView mQs = null;
    protected b mQx = null;
    protected Context mQy = null;
    protected AudioManager mQA = null;
    protected boolean ah = false;
    protected boolean ai = false;
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected boolean mQB = false;
    protected long mhQ = 0;
    protected int ap = -1;
    protected int aq = 0;
    protected int ar = 0;
    protected int mQC = 1;
    protected int at = 0;
    protected String au = "";
    protected String mQD = "";
    public String aw = "1";
    public String ax = "1";
    public String ay = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ab();

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mQh.dispose();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceChanged w=" + i2 + " h=" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "surfaceCreated");
        if (this.mMN != null) {
            this.mMN.setDisplay(surfaceHolder);
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
        if (this.N != null && this.mMN != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int width = this.mMN.getWidth();
            int height = this.mMN.getHeight();
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
            int i10 = this.mQC;
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
            if (this.mMN != null) {
                this.mMN.setDisplayRect(0, 0, i3, i);
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
        if (this.mQx != null) {
            this.mQx.a(false);
        }
        tv.chushou.zues.utils.e.i("lhh", "video complete");
        this.H = true;
        C();
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mQy != null) {
            if (((VideoPlayer) this.mQy).d) {
                b(((VideoPlayer) this.mQy).dEk());
                ((VideoPlayer) this.mQy).a(((VideoPlayer) this.mQy).dEk());
                this.mMN = ((VideoPlayer) this.mQy).dEk();
            } else {
                b(((VideoPlayer) this.mQy).dEj());
                ((VideoPlayer) this.mQy).a(((VideoPlayer) this.mQy).dEj());
                this.mMN = ((VideoPlayer) this.mQy).dEj();
            }
            U();
            A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mMN != null) {
            if (this.mQx != null) {
                this.mQx.b = 0;
                this.mQx.c = 0;
            }
            wB(false);
            this.mQx.a(true);
            if (this.ap < 0) {
                tv.chushou.zues.utils.e.d("VideoPlayer", "mPlayOnlyAudio=" + this.mQx.d);
                if (this.mQx.d) {
                    Nl();
                    if (this.mQq != null) {
                        this.mQq.setImageResource(a.e.ic_btn_room_video_n);
                    }
                } else {
                    U();
                    S();
                    if (this.mQp != null) {
                        this.mQp.setVisibility(0);
                    }
                    if (this.mQq != null) {
                        this.mQq.setImageResource(a.e.ic_btn_room_audio_n);
                    }
                    if (this.N != null) {
                        this.N.setVisibility(0);
                    }
                }
            }
            if (!this.ah) {
                if (((VideoPlayer) this.mQy).r != -1 && dFD()) {
                    this.mhQ = ((VideoPlayer) this.mQy).r;
                    ((VideoPlayer) this.mQy).r = -1L;
                }
                if (dFD() && this.mhQ > 0) {
                    this.mQz.removeMessages(14);
                    this.mMN.seekTo((int) this.mhQ);
                }
                if (!this.ai) {
                    n(false);
                    if (this.mQx.d) {
                        W();
                    }
                    if (this.mMN.getDuration() > 60000) {
                        if (this.mMN.getDuration() < 300000) {
                            this.at = 60000;
                        } else {
                            this.at = Math.min(this.mMN.getDuration(), 300000);
                        }
                    } else {
                        this.at = this.mMN.getDuration();
                    }
                } else {
                    a(false, true);
                }
                wC(false);
                return;
            }
            this.mQx.a(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (!this.H && !this.mQB) {
            wC(true);
            if (this.mQi != null) {
                this.mQi.findViewById(a.f.LoadingPercent).setVisibility(0);
                if (this.mQz != null) {
                    this.mQz.Kq(5);
                    this.mQz.removeMessages(15);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.H || this.mQB) {
            h(false);
        } else if (z) {
            if (z2) {
                wC(false);
                if (this.mQi != null) {
                    this.mQi.findViewById(a.f.LoadingPercent).setVisibility(8);
                    this.mQi.findViewById(a.f.LoadingBuffer).setVisibility(8);
                    if (this.mQz != null) {
                        this.mQz.removeMessages(5);
                    }
                }
            }
            if (this.mQz != null) {
                this.mQz.removeMessages(15);
                this.mQz.Kq(15);
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
        if ("2".equals(this.ay) && h.dDZ().a && this.mQx != null && !this.mQx.d) {
            o(false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mQy != null) {
            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "onErrorAppeared error=" + i);
            this.mQw.setVisibility(8);
            switch (i) {
                case 501:
                    tv.chushou.zues.utils.g.Kz(a.i.str_storage_unenough_for_buffer);
                    break;
                case 502:
                case 503:
                default:
                    if (this.mQx != null) {
                        if (z) {
                            if (this.mQx.c >= 3) {
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time out!");
                                if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                                    g(true);
                                    break;
                                }
                            } else {
                                this.mQx.c++;
                                tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retryn time=" + this.mQx.c);
                                if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                                    g(true);
                                    break;
                                }
                            }
                        } else if (this.mQx.b >= 3) {
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time out!");
                            tv.chushou.zues.utils.g.Kz(a.i.str_play_failed);
                            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                                g(true);
                                break;
                            } else {
                                g(false);
                                break;
                            }
                        } else {
                            this.mQx.b++;
                            tv.chushou.zues.utils.e.e("VideoPlayerLiveBaseFragment", "retry time=" + this.mQx.b);
                            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                                g(true);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ((VideoPlayer) this.mQy).a(true, (Uri) null, true);
                        return;
                    } else {
                        ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
                        return;
                    }
                case 504:
                    tv.chushou.zues.utils.g.Kz(a.i.str_unsupport_file);
                    break;
            }
            wB(false);
            wC(false);
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
            if (((VideoPlayer) this.mQy).d) {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines next: " + ((VideoPlayer) this.mQy).d);
                ((VideoPlayer) this.mQy).a(((VideoPlayer) this.mQy).dEj());
                this.mMN = ((VideoPlayer) this.mQy).dEj();
                ((VideoPlayer) this.mQy).d = false;
                if (!h.dDZ().a) {
                    RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mQx.d) {
                                    f.this.a(((VideoPlayer) f.this.mQy).dEj());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mQy).dEk().setDisplay(null);
                                ((VideoPlayer) f.this.mQy).dEk().stop();
                                ((VideoPlayer) f.this.mQy).dEk().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mQx.d) {
                        a(((VideoPlayer) this.mQy).dEj());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mQy).dEk().setDisplay(null);
                    ((VideoPlayer) this.mQy).dEk().stop();
                    ((VideoPlayer) this.mQy).dEk().release();
                } else {
                    return;
                }
            } else {
                tv.chushou.zues.utils.e.d("VideoPlayerLiveBaseFragment", "checkLines current: " + ((VideoPlayer) this.mQy).d);
                ((VideoPlayer) this.mQy).a(((VideoPlayer) this.mQy).dEk());
                this.mMN = ((VideoPlayer) this.mQy).dEk();
                ((VideoPlayer) this.mQy).d = true;
                if (!h.dDZ().a) {
                    RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.getActivity() == null || !f.this.getActivity().isFinishing()) {
                                if (!f.this.mQx.d) {
                                    f.this.a(((VideoPlayer) f.this.mQy).dEk());
                                } else if (f.this.N != null) {
                                    f.this.N.setVisibility(8);
                                }
                                ((VideoPlayer) f.this.mQy).dEj().setDisplay(null);
                                ((VideoPlayer) f.this.mQy).dEj().stop();
                                ((VideoPlayer) f.this.mQy).dEj().release();
                            }
                        }
                    });
                } else if (getActivity() == null || !getActivity().isFinishing()) {
                    if (!this.mQx.d) {
                        a(((VideoPlayer) this.mQy).dEk());
                    } else if (this.N != null) {
                        this.N.setVisibility(8);
                    }
                    ((VideoPlayer) this.mQy).dEj().setDisplay(null);
                    ((VideoPlayer) this.mQy).dEj().stop();
                    ((VideoPlayer) this.mQy).dEj().release();
                } else {
                    return;
                }
            }
        }
        b(this.au, this.mQD);
        A();
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mQw != null) {
            this.mQw.setVisibility(8);
        }
    }

    private void d(int i) {
        if (1 == i) {
            this.ap = i;
            ((VideoPlayer) this.mQy).setRequestedOrientation(1);
        } else if (Build.VERSION.SDK_INT > 8) {
            this.ap = 6;
            ((VideoPlayer) this.mQy).setRequestedOrientation(6);
        } else {
            this.ap = 0;
            ((VideoPlayer) this.mQy).setRequestedOrientation(0);
        }
    }

    protected void h(int i) {
    }

    public boolean wB(boolean z) {
        if (this.mQi == null) {
            return this.ak;
        }
        View findViewById = this.mQi.findViewById(a.f.loadingview);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            f(false);
        } else {
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                this.mQt.setVisibility(0);
                this.mQu.setVisibility(0);
                this.mQu.setText(this.mQy.getString(a.i.str_get_video_info));
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
    public void Nl() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "showAudioView");
        if (this.mQk != null && this.mQl != null && this.mQj != null) {
            if (this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null && !tv.chushou.zues.utils.h.isEmpty(this.mQx.dEL().mRoominfo.mCreatorAvatar)) {
                this.mQk.i(this.mQx.dEL().mRoominfo.mCreatorAvatar, 0, b.a.nOY, b.a.nOY);
                this.mQl.i(this.mQx.dEL().mRoominfo.mCreatorAvatar, com.kascend.chushou.view.a.a(null), b.a.nOY, b.a.nOY);
            } else {
                this.mQk.yE(com.kascend.chushou.view.a.a(null));
                this.mQl.yE(com.kascend.chushou.view.a.a(null));
            }
            this.mQj.setVisibility(0);
            if (this.mQo != null) {
                this.mQo.setEnabled(false);
            }
            R();
            if (this.mQp != null) {
                this.mQp.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        tv.chushou.zues.utils.e.d("VideoPlayer", "hideAudioView");
        if (this.mQj != null) {
            this.mQj.setVisibility(8);
        }
        V();
        if (this.mQo != null) {
            this.mQo.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.mQl != null) {
            this.mQl.clearAnimation();
        }
    }

    protected void W() {
        if (this.mQl != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.ani_room_audio);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.mQl.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dFD() {
        return "3".equals(this.aw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wC(boolean z) {
        if (this.mQi == null) {
            return false;
        }
        if (this.mQr != null && this.mQr.getVisibility() == 0) {
            z = false;
        }
        if (this.ap >= 0) {
            if (this.mQi.findViewById(a.f.loadingview) == null) {
                return false;
            }
            if (this.mQi.findViewById(a.f.loadingview).getVisibility() == 0) {
                return true;
            }
        }
        if (z) {
            this.mQt.setVisibility(0);
            if (this.mQx == null || !this.mQx.d()) {
                this.mQu.setText(this.mQy.getString(a.i.str_get_video_info));
                this.mQu.setVisibility(0);
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
        if (!"2".equals(this.ay) || !h.dDZ().a || this.mQx == null || this.mQx.d) {
            o(false);
        }
        if (this.ap < 0) {
            Y();
        }
        this.mMN.play();
        if (z) {
            this.ai = false;
        }
        a(true, false);
        if (this.mQz != null) {
            this.mQz.removeMessages(15);
            this.mQz.Kq(15);
        }
    }

    protected void o(boolean z) {
    }

    protected void Y() {
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mQi != null) {
            if (z) {
                if (!this.H && !this.mQB) {
                    this.mQv.setVisibility(0);
                    return;
                }
                return;
            }
            this.mQv.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (z) {
            if (this.mQt != null) {
                this.mQt.setVisibility(0);
            }
            if (this.mQu != null) {
                this.mQu.setVisibility(0);
            }
            if (this.mQv != null) {
                this.mQv.setVisibility(0);
            }
            if (this.mQw != null) {
                this.mQw.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mQt != null) {
            this.mQt.setVisibility(8);
        }
        if (this.mQu != null) {
            this.mQu.setVisibility(8);
        }
        if (this.mQv != null) {
            this.mQv.setVisibility(8);
        }
        if (this.mQw != null) {
            this.mQw.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        f(false);
        a(false, true);
        if (this.mQs != null) {
            this.mQs.setVisibility(0);
            if (z) {
                this.mQs.setText(a.i.str_video_player_network_error);
            } else {
                this.mQs.setText(a.i.str_video_player_other_error);
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, true);
        if (this.mQz != null) {
            this.mQz.A(19, 2000L);
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
            this.mQw.setText(spannableStringBuilder);
            this.mQw.setVisibility(0);
        }
    }

    public void Z() {
        if (this.mMN != null && this.mMN.getPlayState() == 4) {
            this.mMN.stop();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (!this.ai) {
            if (this.mMN.getPlayState() == 4) {
                this.mMN.pause();
            }
            if (z) {
                this.ai = true;
            }
            if (this.mQz != null) {
                this.mQz.removeMessages(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dFE() {
        return this.mQy == null || ((Activity) this.mQy).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dFi() {
    }
}
