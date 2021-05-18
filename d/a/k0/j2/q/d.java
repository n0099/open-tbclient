package d.a.k0.j2.q;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.operableVideoView.OperableVideoErrorView;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import com.baidu.tieba.play.operableVideoView.OperableVideoShareView;
import com.baidu.tieba.play.operableVideoView.PercentSizeView;
import com.baidu.tieba.play.operableVideoView.VideoGestureView;
import com.baidu.tieba.view.SwitchImageView;
import d.a.c.e.p.l;
import d.a.j0.r.q.a2;
import d.a.j0.z0.m0;
import d.a.k0.j2.f;
import d.a.k0.j2.o;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes5.dex */
public class d implements d.a.k0.j2.q.a {
    public PercentSizeView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public SwitchImageView E;
    public SwitchImageView F;
    public OperableVideoMediaControllerView G;
    public OperableVideoNetworkStateTipView H;
    public OperableVideoShareView I;
    public ImageView J;
    public View K;
    public VideoGestureView L;
    public View M;
    public OperableVideoErrorView N;
    public Context P;
    public View Q;
    public ViewGroup R;
    public BdUniqueId S;
    public boolean T;
    public boolean U;
    public String V;
    public String W;
    public int X;
    public long Y;
    public d.a.k0.j2.j Z;
    public o b0;
    public a2 c0;
    public String d0;
    public String g0;
    public float h0;
    public float i0;
    public GestureDetector j0;
    public int k0;
    public int m0;
    public boolean n0;
    public float q0;
    public int r0;
    public TbCyberVideoView u;
    public TbImageView v;
    public d.a.v.c v0;
    public View w;
    public McnAdInfo w0;
    public TBLottieAnimationView x;
    public ImageView y;
    public k y0;
    public ImageView z;

    /* renamed from: e  reason: collision with root package name */
    public int f56742e = 3000;

    /* renamed from: f  reason: collision with root package name */
    public int f56743f = 8211;

    /* renamed from: g  reason: collision with root package name */
    public int f56744g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f56745h = 4;

    /* renamed from: i  reason: collision with root package name */
    public int f56746i = 232;
    public int j = 8416;
    public int k = 0;
    public int l = 513;
    public int m = 259;
    public int n = 2048;
    public int o = 0;
    public int p = 4099;
    public int q = 8211;
    public int r = 0;
    public int s = -1;
    public Runnable t = new b();
    public WeakReference<Context> O = null;
    public boolean a0 = false;
    public boolean e0 = true;
    public boolean f0 = false;
    public int[] l0 = new int[2];
    public int o0 = 0;
    public int p0 = 0;
    public boolean s0 = false;
    public View.OnClickListener t0 = null;
    public View.OnClickListener u0 = null;
    public boolean x0 = false;
    public long z0 = -1;
    public f.c A0 = new c();
    public SeekBar.OnSeekBarChangeListener B0 = new g();
    public GestureDetector.SimpleOnGestureListener C0 = new h();
    public View.OnTouchListener D0 = new i();
    public TbVideoViewSet.b E0 = new j();
    public final CustomMessageListener K0 = new a(2000994);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.s0(dVar.f56744g);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f.c {
        public c() {
        }

        @Override // d.a.k0.j2.f.c
        public void a(int i2, int i3) {
            if (d.this.z0 <= 0) {
                d.this.z0 = i3;
            }
            if (d.this.h0()) {
                d dVar = d.this;
                if (!dVar.U && !dVar.a0 && dVar.x0) {
                    if (d.a.v.b.b().a(d.this.w0.jump_url)) {
                        return;
                    }
                    long j = i3;
                    boolean z = j >= d.this.w0.ad_start_time.longValue() * 1000 && j < d.this.w0.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.z0 >= (d.this.w0.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.v0.c()) {
                            d.a.v.a aVar = new d.a.v.a();
                            aVar.f64790b = d.this.w0.card_title;
                            aVar.f64791c = d.this.w0.button_title;
                            aVar.f64792d = d.this.w0.jump_url;
                            aVar.f64789a = d.this.w0.pic_url;
                            aVar.f64794f = String.valueOf(d.this.Y);
                            d dVar2 = d.this;
                            aVar.f64793e = dVar2.W;
                            aVar.f64795g = dVar2.a0();
                            if (z2) {
                                d.this.v0.f(aVar, (ViewGroup) d.this.Q);
                            } else {
                                d.this.v0.e(aVar, (ViewGroup) d.this.Q);
                            }
                        }
                    } else if (d.this.v0.c()) {
                        d.this.v0.a();
                    }
                }
            }
            if (d.this.y0 != null) {
                d.this.y0.a(i2, i3);
            }
        }
    }

    /* renamed from: d.a.k0.j2.q.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1402d implements Animator.AnimatorListener {
        public C1402d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            d.this.x.setVisibility(8);
            d.this.y.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            d.this.x.setVisibility(8);
            d.this.y.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.N();
            if (!d.this.T) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Animator.AnimatorListener {
        public f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.R.setScaleX(1.0f);
            d.this.R.setScaleY(1.0f);
            d.this.R.setTranslationX(0.0f);
            d.this.R.setTranslationY(0.0f);
            d.this.I.setScaleX(1.0f);
            d.this.I.setScaleY(1.0f);
            d.this.R.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (d.this.n0) {
                return;
            }
            d.this.T();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class g implements SeekBar.OnSeekBarChangeListener {
        public g() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d dVar = d.this;
            dVar.s0(dVar.f56746i);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar == null || seekBar.getProgress() >= seekBar.getMax()) {
                return;
            }
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
            if (!d.this.u.isPlaying()) {
                d dVar = d.this;
                dVar.u.R(dVar.E0);
            }
            d.this.R();
            if (d.this.e0) {
                TiebaStatic.log(new StatisticItem("c13355").param("tid", d.this.W).param("fid", d.this.Y).param("obj_type", d.this.U ? 1 : 2).param("obj_locate", d.this.a0 ? 1 : 2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends GestureDetector.SimpleOnGestureListener {
        public h() {
        }

        public final void a(int i2, int i3) {
            if (d.this.o0 == i3 && d.this.p0 == i2) {
                return;
            }
            d dVar = d.this;
            dVar.n0 = dVar.o0 - i3 > 0 || ((float) i3) < d.this.h0 / 6.0f;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.R.getLayoutParams();
            if (i3 != d.this.o0) {
                int i4 = d.this.m0 - i3;
                int i5 = (int) (i4 * d.this.q0);
                if (i5 < d.this.r0) {
                    i5 = d.this.r0;
                    i4 = (int) (i5 / d.this.q0);
                }
                if (i5 != d.this.r0) {
                    layoutParams.height = i4;
                    layoutParams.width = i5;
                    d.this.R.setLayoutParams(layoutParams);
                }
                d.this.o0 = i3;
                d dVar2 = d.this;
                dVar2.R.setTranslationY(dVar2.o0);
            }
            if (i2 != d.this.o0) {
                d.this.p0 = i2;
                d dVar3 = d.this;
                dVar3.R.setTranslationX(dVar3.p0 + ((d.this.i0 - layoutParams.width) / 2.0f));
            }
            d.this.M.setAlpha((layoutParams.width - d.this.r0) / (d.this.i0 - d.this.r0));
            if (d.this.I.getVisibility() == 0) {
                float f2 = d.this.h0 / 6.0f;
                float f3 = (f2 - i3) / f2;
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
                d.this.I.setAlpha(f3);
            }
        }

        public final void b(float f2) {
            boolean z;
            if (f2 > 0.0f) {
                d dVar = d.this;
                dVar.k0 -= 1000;
                z = true;
            } else {
                d.this.k0 += 1000;
                z = false;
            }
            int duration = d.this.u.getDuration();
            if (d.this.k0 < 0) {
                d.this.k0 = 0;
            } else if (d.this.k0 > duration) {
                d.this.k0 = duration;
            }
            String str = StringHelper.stringForVideoTime(d.this.k0) + " / " + StringHelper.stringForVideoTime(duration);
            VideoGestureView videoGestureView = d.this.L;
            if (videoGestureView != null) {
                videoGestureView.b(z, str);
            }
            d dVar2 = d.this;
            dVar2.G.setCurrentDuration(dVar2.k0, false);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.u.isPlaying()) {
                d.this.u.pause();
                d dVar = d.this;
                if (dVar.q == dVar.f56746i) {
                    dVar.s0(dVar.j);
                } else {
                    dVar.s0(dVar.k);
                }
                d.this.x0(R.id.video_pause);
                return true;
            }
            d dVar2 = d.this;
            int i2 = dVar2.q;
            int i3 = dVar2.j;
            if (i2 != i3 && i2 != (i3 | 1)) {
                int i4 = dVar2.k;
                if (i2 == i4 || i2 == (i4 | 1)) {
                    d dVar3 = d.this;
                    dVar3.s0(dVar3.f56744g);
                    d dVar4 = d.this;
                    dVar4.u.R(dVar4.E0);
                    d.this.x0(R.id.video_play);
                    return true;
                }
                return true;
            }
            d dVar5 = d.this;
            dVar5.s0(dVar5.f56746i);
            d.this.R();
            d dVar6 = d.this;
            dVar6.u.R(dVar6.E0);
            d.this.x0(R.id.video_play);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.r = 0;
            d dVar = d.this;
            if (dVar.a0) {
                dVar.Q((Activity) dVar.P, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            int i2;
            int i3;
            if (!d.this.f0(motionEvent)) {
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            Context context = d.this.P;
            if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) d.this.P).disableSwipeJustOnce();
            } else {
                Context context2 = d.this.P;
                if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                    ((BaseActivity) d.this.P).disableSwipeJustOnce();
                }
            }
            d dVar = d.this;
            if (dVar.U && dVar.g0()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                int i4 = d.this.r;
                if (i4 != 0) {
                    if (i4 == 4) {
                        a(rawX, rawY);
                    }
                } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                    if (d.this.u.isPlaying()) {
                        d.this.u.pause();
                        d dVar2 = d.this;
                        dVar2.s0(dVar2.o);
                    }
                    d.this.r = 4;
                    d dVar3 = d.this;
                    dVar3.s = dVar3.q;
                    d dVar4 = d.this;
                    dVar4.q = dVar4.n;
                    dVar4.m0 = dVar4.R.getMeasuredHeight();
                    d dVar5 = d.this;
                    dVar5.q0 = dVar5.i0 / d.this.m0;
                    d dVar6 = d.this;
                    dVar6.r0 = (int) (dVar6.Q.getWidth() * 1.2f);
                    a(rawX, rawY);
                }
            } else {
                d dVar7 = d.this;
                int i5 = dVar7.q;
                if (i5 == dVar7.f56744g || i5 == dVar7.f56746i || i5 == (i2 = dVar7.j) || i5 == (i3 = dVar7.k) || i5 == dVar7.n || i5 == (i2 | 1) || i5 == (i3 | 1)) {
                    int i6 = d.this.r;
                    if (i6 == 0) {
                        if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                            d.this.r = 3;
                            d dVar8 = d.this;
                            dVar8.k0 = dVar8.u.getCurrentPosition();
                            b(f2);
                        } else if (motionEvent.getX() < d.this.R.getWidth() / 2) {
                            d.this.r = 2;
                            d dVar9 = d.this;
                            dVar9.L.a(dVar9.P, f3 > 0.0f);
                        } else {
                            d.this.r = 1;
                            d dVar10 = d.this;
                            dVar10.L.c(dVar10.P, f3 > 0.0f);
                        }
                        d dVar11 = d.this;
                        int i7 = dVar11.q;
                        int i8 = dVar11.n;
                        if (i7 != i8) {
                            if ((i7 & 1) > 0) {
                                dVar11.n = i8 | 1;
                            } else {
                                dVar11.n = i8 & (-2);
                            }
                            d dVar12 = d.this;
                            dVar12.s0(dVar12.n);
                        }
                    } else if (i6 == 1) {
                        d dVar13 = d.this;
                        int i9 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                        dVar13.L.c(dVar13.P, i9 > 0);
                        if (i9 > 0) {
                            d.this.c0();
                        }
                    } else if (i6 == 2) {
                        d dVar14 = d.this;
                        dVar14.L.a(dVar14.P, f3 > 0.0f);
                    } else if (i6 == 3) {
                        b(f2);
                    }
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.u.isPlaying()) {
                d dVar = d.this;
                int i2 = dVar.q;
                int i3 = dVar.f56744g;
                if (i2 != i3 && i2 != dVar.f56745h) {
                    if (i2 == dVar.f56746i) {
                        dVar.s0(i3);
                    }
                } else {
                    d dVar2 = d.this;
                    dVar2.s0(dVar2.f56746i);
                    d.this.R();
                }
            } else {
                d dVar3 = d.this;
                int i4 = dVar3.q;
                int i5 = dVar3.j;
                if (i4 == i5) {
                    dVar3.s0(dVar3.k);
                } else if (i4 == (i5 | 1)) {
                    dVar3.s0(dVar3.k | 1);
                } else {
                    int i6 = dVar3.k;
                    if (i4 == i6) {
                        dVar3.s0(i5);
                    } else if (i4 == (i6 | 1)) {
                        dVar3.s0(i5 | 1);
                    } else {
                        dVar3.s0(dVar3.f56743f);
                        d.this.startPlay();
                        d.this.n0();
                    }
                }
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnTouchListener {
        public i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                d dVar = d.this;
                if (dVar.q == dVar.n) {
                    if (dVar.r == 4) {
                        d.this.S();
                        d.this.o0 = 0;
                        d.this.p0 = 0;
                    } else {
                        d dVar2 = d.this;
                        dVar2.q = -1;
                        if (dVar2.r != 3) {
                            if (d.this.s != -1) {
                                d dVar3 = d.this;
                                dVar3.s0(dVar3.s);
                                d.this.s = -1;
                            } else if (d.this.u.isPlaying()) {
                                d dVar4 = d.this;
                                dVar4.s0(dVar4.f56744g);
                            } else {
                                d dVar5 = d.this;
                                dVar5.s0(dVar5.j);
                            }
                        } else {
                            d dVar6 = d.this;
                            dVar6.G.setCurrentDuration(dVar6.k0, true);
                            if (d.this.k0 <= d.this.u.getDuration()) {
                                if (!d.this.u.isPlaying()) {
                                    d dVar7 = d.this;
                                    dVar7.u.R(dVar7.E0);
                                }
                                d dVar8 = d.this;
                                dVar8.s0(dVar8.f56744g);
                            }
                        }
                    }
                    d dVar9 = d.this;
                    if (dVar9.e0) {
                        String str = null;
                        if (dVar9.r == 1) {
                            str = "c13361";
                        } else if (d.this.r == 2) {
                            str = "c13346";
                        } else if (d.this.r == 3) {
                            str = "c13362";
                        }
                        if (!d.a.c.e.p.k.isEmpty(str)) {
                            TiebaStatic.log(new StatisticItem(str).param("tid", d.this.W).param("fid", d.this.Y));
                        }
                    }
                    d.this.r = 0;
                    return true;
                }
            }
            return d.this.j0.onTouchEvent(motionEvent);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements TbVideoViewSet.b {
        public j() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            d dVar = d.this;
            dVar.s0(dVar.f56743f);
            d.this.w0();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            d.this.u.G();
            d.this.u0();
        }
    }

    /* loaded from: classes5.dex */
    public interface k {
        void a(int i2, int i3);
    }

    public d(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        this.P = context;
        this.Q = view;
        this.h0 = l.i(context);
        this.i0 = l.k(this.P);
        d0();
    }

    @Override // d.a.k0.j2.q.a
    public boolean C() {
        return this.a0;
    }

    @Override // d.a.k0.j2.q.a
    public boolean D() {
        if (this.a0) {
            S();
            return true;
        }
        return false;
    }

    @Override // d.a.k0.j2.q.a
    public View E() {
        return this.R;
    }

    public void N() {
        if (this.q == this.f56745h) {
            s0(this.f56744g);
        }
    }

    public void O() {
        if (this.U && !"video_tab".equals(this.d0)) {
            this.f56746i = 104;
            this.j = 8290;
        } else {
            this.f56746i = 232;
            this.j = 8418;
        }
        if (this.a0) {
            this.f56743f |= 1024;
            this.f56744g |= 1024;
            this.f56745h |= 1024;
            this.f56746i |= 1024;
            this.j |= 1024;
            this.k |= 1024;
            this.l |= 1024;
            this.m |= 1024;
            this.q |= 1024;
            return;
        }
        this.f56743f &= -1025;
        this.f56744g &= -1025;
        this.f56745h &= -1025;
        this.f56746i &= -1025;
        this.j &= -1025;
        this.k &= -1025;
        this.l &= -1025;
        this.m &= -1025;
        this.q &= -1025;
    }

    public void P() {
        float dimension;
        this.H.a(this.U, this.a0);
        this.I.e(this.U, this.a0);
        Context context = this.P;
        if (context == null || context.getResources() == null) {
            return;
        }
        if (this.U) {
            dimension = this.P.getResources().getDimension(R.dimen.tbds44);
        } else if (this.a0) {
            dimension = this.P.getResources().getDimension(R.dimen.tbds78);
        } else {
            dimension = this.P.getResources().getDimension(R.dimen.tbds44);
        }
        int i2 = (int) dimension;
        this.B.setPadding(0, 0, "video_tab".equals(this.d0) ? 0 : i2, 0);
        SwitchImageView switchImageView = this.F;
        switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i2, 0);
        this.E.setPadding(i2, 0, 0, 0);
    }

    public final void Q(Activity activity, boolean z) {
        if (activity == null || activity.getWindow() == null) {
            return;
        }
        if (this.U && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
            ViewGroup viewGroup = this.R;
            if (viewGroup == null) {
                return;
            }
            if (z) {
                viewGroup.setPadding(0, l.r((Activity) this.P), 0, 0);
            } else {
                viewGroup.setPadding(0, 0, 0, 0);
            }
        } else if (z) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags |= 1024;
            activity.getWindow().setAttributes(attributes);
            t0();
        } else {
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.R.setSystemUiVisibility(0);
        }
    }

    public void R() {
        d.a.c.e.m.e.a().removeCallbacks(this.t);
        d.a.c.e.m.e.a().postDelayed(this.t, this.f56742e);
    }

    public final void S() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        if (!this.U) {
            T();
        } else if (this.q == this.n) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new f());
            if (!this.n0) {
                float width = this.Q.getWidth() / this.R.getWidth();
                float height = this.Q.getHeight() / this.R.getHeight();
                this.R.setPivotX(0.0f);
                this.R.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.R, "ScaleX", 1.0f, width);
                objectAnimator = ObjectAnimator.ofFloat(this.R, "ScaleY", 1.0f, height);
                ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.I, "ScaleX", 1.0f, 1.0f / width);
                ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.I, "ScaleY", 1.0f, 1.0f / height);
                ViewGroup viewGroup = this.R;
                ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.l0[0]);
                ViewGroup viewGroup2 = this.R;
                ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.l0[1]);
                View view = this.M;
                ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), 0.0f);
                OperableVideoShareView operableVideoShareView = this.I;
                ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, "alpha", operableVideoShareView.getAlpha(), 0.0f);
                ofFloat2 = ofFloat7;
                objectAnimator2 = ofFloat9;
                ofFloat3 = ofFloat8;
            } else {
                float width2 = this.i0 / this.R.getWidth();
                float height2 = this.m0 / this.R.getHeight();
                this.R.setPivotX(0.0f);
                this.R.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.R, "ScaleX", 1.0f, width2);
                ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.R, "ScaleY", 1.0f, height2);
                ofFloat2 = ObjectAnimator.ofFloat(this.I, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat3 = ObjectAnimator.ofFloat(this.I, "ScaleY", 1.0f, 1.0f / height2);
                ViewGroup viewGroup3 = this.R;
                ofFloat4 = ObjectAnimator.ofFloat(viewGroup3, "TranslationX", viewGroup3.getTranslationX(), 0.0f);
                ViewGroup viewGroup4 = this.R;
                ofFloat5 = ObjectAnimator.ofFloat(viewGroup4, "TranslationY", viewGroup4.getTranslationY(), 0.0f);
                OperableVideoShareView operableVideoShareView2 = this.I;
                ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView2, "alpha", operableVideoShareView2.getAlpha(), 1.0f);
                objectAnimator = ofFloat10;
                objectAnimator2 = null;
            }
            if (objectAnimator2 != null) {
                animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(objectAnimator2).with(ofFloat6).with(ofFloat2).with(ofFloat3);
            } else {
                animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(ofFloat6).with(ofFloat2).with(ofFloat3);
            }
            animatorSet.start();
            int i2 = this.s;
            if (i2 != -1) {
                this.q = i2;
                this.s = -1;
                if (i2 == this.o || i2 == this.f56746i || i2 == this.f56744g) {
                    this.u.R(this.E0);
                    s0(this.f56744g);
                }
            }
        } else {
            T();
        }
    }

    public void T() {
        V(true);
    }

    @Override // d.a.k0.j2.q.a
    public void U(int i2) {
        this.u.getRenderView().setDisplayMode(i2);
    }

    public void V(boolean z) {
        View view = this.Q;
        if (view == null || this.R == null || this.u == null) {
            return;
        }
        Context context = this.P;
        if (context != null) {
            l.x(context, view);
        }
        if (this.Z == null) {
            this.Z = new d.a.k0.j2.j((Activity) this.P);
        }
        if (this.a0) {
            if (this.M.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.M.getParent()).removeView(this.M);
            }
            if ((this.R.getParent() instanceof ViewGroup) && (this.Q instanceof ViewGroup)) {
                this.a0 = false;
                this.f0 = true;
                ((ViewGroup) this.R.getParent()).removeView(this.R);
                ((ViewGroup) this.Q).addView(this.R);
                this.f0 = false;
                Q((Activity) this.P, this.a0);
            }
            if (!this.U && z) {
                this.Z.l();
            }
        } else {
            if (this.P != null) {
                if (!this.U && z) {
                    this.Z.l();
                }
                if (this.P instanceof Activity) {
                    this.R.getLocationOnScreen(this.l0);
                    View findViewById = ((Activity) this.P).findViewById(16908290);
                    if (findViewById instanceof ViewGroup) {
                        View childAt = ((ViewGroup) findViewById).getChildAt(0);
                        if (childAt instanceof ViewGroup) {
                            this.f0 = true;
                            ((ViewGroup) this.Q).removeAllViews();
                            if (this.M == null) {
                                View view2 = new View(this.P);
                                this.M = view2;
                                view2.setClickable(true);
                                this.M.setBackgroundColor(SkinManager.getColor(R.color.black_alpha100));
                                this.M.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            }
                            if (this.M.getParent() instanceof ViewGroup) {
                                ((ViewGroup) this.M.getParent()).removeView(this.M);
                            }
                            this.M.setAlpha(1.0f);
                            ViewGroup viewGroup = (ViewGroup) childAt;
                            viewGroup.addView(this.M);
                            viewGroup.addView(this.R);
                            this.f0 = false;
                            this.a0 = true;
                            Q((Activity) this.P, true);
                            d.a.v.c cVar = this.v0;
                            if (cVar != null && cVar.c()) {
                                this.v0.a();
                            }
                        }
                    }
                }
            }
            if (this.e0) {
                TiebaStatic.log(new StatisticItem("c13360").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2));
            }
        }
        O();
        P();
        if (this.u.isPlaying()) {
            s0(this.f56744g);
        } else {
            s0(this.q);
        }
        this.F.b();
        j0(this.a0);
    }

    public void W() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.u.setVolume(1.0f, 1.0f);
            m0.e(this.O, true);
            this.E.setState(0);
        } else {
            this.u.setVolume(0.0f, 0.0f);
            this.E.setState(1);
            m0.e(this.O, false);
        }
        TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
    }

    public void X(boolean z) {
        if (this.Z == null) {
            this.Z = new d.a.k0.j2.j((Activity) this.P);
        }
        if (z) {
            this.Z.j();
            this.Z.i(true);
            return;
        }
        this.Z.k();
        this.Z.i(false);
    }

    public final void Y() {
        s0(this.f56745h);
        this.G.s();
        TBLottieAnimationView tBLottieAnimationView = this.x;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.clearAnimation();
            this.x.animate().alpha(0.0f).setDuration(200L).setListener(new e()).start();
        }
    }

    public int Z() {
        return R.layout.operable_video_container;
    }

    public int a0() {
        return 2;
    }

    public String b0() {
        return this.V;
    }

    @Override // d.a.k0.j2.q.a
    public boolean c0() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.u.isPlaying() && !m0.c()) {
            this.u.setVolume(1.0f, 1.0f);
            this.E.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
            return false;
        }
        return false;
    }

    public void d0() {
        Context context = this.P;
        if (context == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(Z(), (ViewGroup) null);
        this.R = viewGroup;
        View view = this.Q;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).addView(viewGroup);
        }
        this.O = new WeakReference<>(TbadkCoreApplication.getInst());
        this.v = (TbImageView) this.R.findViewById(R.id.video_thumbnail);
        this.w = this.R.findViewById(R.id.black_mask);
        this.x = (TBLottieAnimationView) this.R.findViewById(R.id.video_loading);
        this.y = (ImageView) this.R.findViewById(R.id.video_play);
        this.A = (PercentSizeView) this.R.findViewById(R.id.video_media_controller_mask);
        this.z = (ImageView) this.R.findViewById(R.id.video_pause);
        this.B = (TextView) this.R.findViewById(R.id.video_play_count);
        this.C = (TextView) this.R.findViewById(R.id.video_play_flag);
        this.D = (TextView) this.R.findViewById(R.id.video_duration);
        this.E = (SwitchImageView) this.R.findViewById(R.id.video_mute);
        this.F = (SwitchImageView) this.R.findViewById(R.id.video_full_screen);
        this.G = (OperableVideoMediaControllerView) this.R.findViewById(R.id.video_media_controller);
        this.H = (OperableVideoNetworkStateTipView) this.R.findViewById(R.id.video_network_state_tip);
        this.I = (OperableVideoShareView) this.R.findViewById(R.id.video_share_view);
        this.K = this.R.findViewById(R.id.video_back_btn_mask);
        this.J = (ImageView) this.R.findViewById(R.id.video_full_screen_back);
        this.L = (VideoGestureView) this.R.findViewById(R.id.video_gesture);
        this.N = (OperableVideoErrorView) this.R.findViewById(R.id.video_error_layout);
        this.I.setVideoContainer(this);
        this.x.addAnimatorListener(new C1402d());
        this.x.setAnimation(R.raw.lotti_video_loading);
        this.y.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.y.setOnClickListener(this);
        this.E.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
        this.E.setState(1);
        this.E.setOnClickListener(this);
        this.v.A();
        this.v.setDrawCorner(false);
        this.v.setPlaceHolder(3);
        d.a.j0.b.g.b.f(this.w, R.color.CAM_X0601);
        this.G.setOnSeekBarChangeListener(this.B0);
        this.A.setHeightPercent(0.583f);
        this.A.setBackgroundResource(R.drawable.video_mask_bg);
        this.F.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
        this.F.setState(0);
        this.F.setOnClickListener(this);
        this.z.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.z.setOnClickListener(this);
        this.J.setOnClickListener(this);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(this.P);
        this.u = tbCyberVideoView;
        tbCyberVideoView.setTryUseViewInSet(true);
        u0();
        this.H.setPlayViewOnClickListener(this);
        this.R.setOnClickListener(null);
        this.R.setOnTouchListener(this.D0);
        this.I.setOnTouchListener(this.D0);
        this.N.setOutOnClickListener(this);
        this.j0 = new GestureDetector(this.P, this.C0);
        s0(this.f56743f);
        this.v0 = new d.a.v.c(this.P);
        d.a.j0.r.u.c.d(this.w).o(R.array.Mask_X003);
        d.a.j0.r.u.c.d(this.B).t(R.array.S_O_X001);
        d.a.j0.r.u.c.d(this.D).t(R.array.S_O_X001);
    }

    public void e0() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.u.setVolume(0.0f, 0.0f);
            this.E.setState(1);
            return;
        }
        this.u.setVolume(1.0f, 1.0f);
        this.E.setState(0);
    }

    public boolean f0(MotionEvent motionEvent) {
        return this.a0;
    }

    public boolean g0() {
        return this.U && this.a0;
    }

    @Override // d.a.k0.j2.q.a
    public int getCurrentPosition() {
        return this.u.getCurrentPosition();
    }

    public boolean h0() {
        return this.w0 != null;
    }

    public boolean i0() {
        if (d.a.j0.b.d.Q() && "video_tab".equals(this.d0)) {
            return d.a.c.e.p.j.x();
        }
        OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.H;
        return operableVideoNetworkStateTipView != null && operableVideoNetworkStateTipView.d();
    }

    @Override // d.a.k0.j2.q.a
    public boolean isPlaying() {
        return this.T || this.u.isPlaying();
    }

    public void j0(boolean z) {
    }

    @Override // d.a.k0.j2.q.a
    public void k0(o oVar) {
        TbCyberVideoView tbCyberVideoView = this.u;
        if (tbCyberVideoView != null) {
            this.b0 = oVar;
            tbCyberVideoView.setVideoStatData(oVar);
        }
    }

    @Override // d.a.k0.j2.q.a
    public void l0() {
    }

    public void m0() {
        d.a.c.e.m.e.a().removeCallbacks(this.t);
    }

    public final void n0() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.V);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.S);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    @Override // d.a.k0.j2.q.a
    public boolean o0(boolean z) {
        if (z) {
            this.s0 = isPlaying();
            this.x.cancelAnimation();
            int i2 = this.q;
            if (i2 == this.f56744g || i2 == this.f56745h || i2 == this.f56746i || i2 == this.f56743f) {
                stopPlay();
            }
            int i3 = this.q | 1;
            this.q = i3;
            s0(i3);
        } else if (this.q == this.f56743f) {
            if (this.s0) {
                startPlay();
                n0();
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        x0(id);
        if (id == R.id.video_mute) {
            W();
        } else if (id != R.id.video_full_screen && id != R.id.video_full_screen_back) {
            if (id == R.id.video_replay) {
                s0(this.f56743f);
                startPlay();
                if (this.e0) {
                    TiebaStatic.log(new StatisticItem("c13345").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_locate", this.a0 ? 1 : 2));
                }
                n0();
            } else if (id == R.id.video_play) {
                if (this.q == this.f56743f) {
                    startPlay();
                } else {
                    s0(this.f56746i);
                    R();
                    this.u.R(this.E0);
                }
                if (this.e0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", this.a0 ? 1 : 2).param("obj_locate", 1));
                }
                n0();
            } else if (id == R.id.video_pause) {
                s0(this.j);
                m0();
                this.u.pause();
                if (this.e0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", this.a0 ? 1 : 2).param("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                s0(this.f56743f);
                startPlay();
            } else if (id == R.id.retry) {
                s0(this.f56743f);
                startPlay();
            }
        } else {
            S();
        }
    }

    public void onCompletion() {
        s0(this.l);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        s0(this.p);
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        if (i2 == 3 || i2 == 904) {
            v0();
        }
        if (i2 == 701) {
            w0();
            return false;
        } else if (i2 == 702) {
            v0();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        e0();
        if (this.T) {
            if (this.a0) {
                Context context = this.P;
                if (context instanceof Activity) {
                    Q((Activity) context, true);
                }
            }
            this.u.R(this.E0);
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void onSurfaceDestroyed() {
        if (this.f0) {
            return;
        }
        int i2 = this.q;
        if (i2 != this.j && (i2 != this.k || this.u.isPlaying())) {
            if (this.q == this.l) {
                z0();
                s0(this.l);
                return;
            } else if (this.s0) {
                return;
            } else {
                z0();
                return;
            }
        }
        z0();
        s0(this.j);
    }

    public void p0(boolean z) {
        this.x0 = z;
    }

    public void q0(k kVar) {
        this.y0 = kVar;
    }

    @Override // d.a.k0.j2.q.a
    public void r0(View.OnClickListener onClickListener) {
        this.u0 = onClickListener;
    }

    public void s0(int i2) {
        m0();
        if (this.q == this.n) {
            this.s = i2;
            return;
        }
        this.q = i2;
        this.v.setVisibility((i2 & 1) > 0 ? 0 : 8);
        this.w.setVisibility((i2 & 2) > 0 ? 0 : 8);
        boolean z = (i2 & 4) > 0;
        this.x.clearAnimation();
        this.x.setVisibility(z ? 0 : 8);
        if (!z) {
            this.x.cancelAnimation();
        } else {
            this.x.setAlpha(1.0f);
        }
        this.y.setVisibility((i2 & 8192) > 0 ? 0 : 8);
        this.z.setVisibility((i2 & 8) > 0 ? 0 : 8);
        int i3 = i2 & 16;
        this.B.setVisibility(i3 > 0 ? 0 : 8);
        this.D.setVisibility(i3 > 0 ? 0 : 8);
        this.E.setVisibility((i2 & 32) > 0 ? 0 : 8);
        this.F.setVisibility((i2 & 64) > 0 ? 0 : 8);
        int i4 = i2 & 128;
        this.G.setVisibility(i4 > 0 ? 0 : 8);
        this.A.setVisibility(i4 > 0 ? 0 : 8);
        if (this.G.getVisibility() == 0) {
            this.G.s();
        }
        this.H.setVisibility((i2 & 256) > 0 ? 0 : 8);
        this.I.setVisibility((i2 & 512) > 0 ? 0 : 8);
        if (this.I.getVisibility() == 0) {
            this.I.setAlpha(1.0f);
        }
        int i5 = i2 & 1024;
        this.J.setVisibility(i5 > 0 ? 0 : 8);
        this.K.setVisibility(i5 > 0 ? 0 : 8);
        this.L.setVisibility((i2 & 2048) > 0 ? 0 : 8);
        this.N.setVisibility((i2 & 4096) <= 0 ? 8 : 0);
    }

    @Override // d.a.k0.j2.q.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.t0 = onClickListener;
    }

    @Override // d.a.k0.j2.q.a
    public void setData(a2 a2Var) {
        if (a2Var == null || a2Var.v1() == null) {
            return;
        }
        this.z0 = -1L;
        d.a.v.c cVar = this.v0;
        if (cVar != null) {
            cVar.d();
        }
        if (StringHelper.equals(this.V, a2Var.v1().video_url)) {
            return;
        }
        stopPlay();
        this.U = a2Var.v1().is_vertical.intValue() == 1;
        this.V = a2Var.v1().video_url;
        this.W = a2Var.x1();
        a2Var.v1().video_length.intValue();
        this.X = a2Var.v1().video_duration.intValue();
        this.Y = a2Var.c0();
        this.w0 = a2Var.v1().mcn_ad_card;
        O();
        P();
        s0(this.f56743f);
        int intValue = a2Var.v1().video_duration.intValue() * 1000;
        this.G.p(intValue);
        this.G.setPlayer(this.u);
        this.D.setText(StringHelper.stringForVideoTime(intValue));
        this.B.setText(String.format(this.P.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(a2Var.v1().play_count.intValue())));
        this.H.setVideoLength(a2Var.v1().video_length.intValue());
        this.H.setVideoDuration(a2Var.v1().video_duration.intValue());
        this.H.setTid(this.W);
        this.c0 = a2Var;
        this.u.setThreadDataForStatistic(a2Var);
        this.C.setVisibility(8);
        this.v.setPlaceHolder(3);
        this.v.V(a2Var.v1().thumbnail_url, 10, false);
        this.I.setShareData(a2Var);
    }

    @Override // d.a.k0.j2.q.a
    public void setFrom(String str) {
        this.d0 = str;
    }

    @Override // d.a.k0.j2.q.a
    public void setStageType(String str) {
        this.g0 = str;
    }

    @Override // d.a.k0.j2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.S = bdUniqueId;
    }

    @Override // d.a.k0.j2.q.a
    public void startPlay() {
        if (StringUtils.isNull(this.V)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.K0);
        if (i0()) {
            s0(this.m);
            return;
        }
        this.T = true;
        if (this.u.isPlaying()) {
            return;
        }
        TbCyberVideoView e2 = TbVideoViewSet.d().e(this.V);
        if (e2 == null) {
            this.u.G();
            if (!StringUtils.isNull(this.u.getOriginUrl())) {
                TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(this.P);
                this.u = tbCyberVideoView;
                tbCyberVideoView.setTryUseViewInSet(true);
            }
            u0();
            if (d.a.c.e.p.j.z()) {
                this.u.setVideoDuration(this.X);
                this.u.setVideoPath(this.V, this.W);
                this.u.setStageType(this.g0);
                w0();
                if (this.e0) {
                    y0();
                }
            }
        } else {
            TbCyberVideoView tbCyberVideoView2 = this.u;
            if (tbCyberVideoView2 == e2) {
                if (tbCyberVideoView2.getParent() == null || this.u.getParent() != e2.getParent()) {
                    this.u.G();
                    u0();
                }
            } else {
                tbCyberVideoView2.G();
                e2.G();
                this.u = e2;
                e2.setTryUseViewInSet(true);
                u0();
            }
            this.u.M();
            onPrepared();
            v0();
            if (this.e0) {
                y0();
            }
        }
        if (this.e0) {
            TiebaStatic.log(new StatisticItem("c13357").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // d.a.k0.j2.q.a
    public void stopPlay() {
        this.T = false;
        TBLottieAnimationView tBLottieAnimationView = this.x;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
        this.u.S();
        this.u.G();
        this.G.q();
        s0(this.f56743f);
        MessageManager.getInstance().unRegisterListener(this.K0);
    }

    public final void t0() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16) {
            this.R.setSystemUiVisibility(2);
        } else if (i2 >= 16 && i2 <= 18) {
            this.R.setSystemUiVisibility(4);
        } else {
            this.R.setSystemUiVisibility(5894);
        }
    }

    public void u0() {
        TbCyberVideoView tbCyberVideoView = this.u;
        if (tbCyberVideoView == null || tbCyberVideoView.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.R.addView(this.u.getView(), 0);
        this.u.getView().setLayoutParams(layoutParams);
        this.G.setPlayer(this.u);
        this.u.setContinuePlayEnable(true);
        this.u.setOnPreparedListener(this);
        this.u.setOnCompletionListener(this);
        this.u.setOnErrorListener(this);
        this.u.setOnSurfaceDestroyedListener(this);
        this.u.setOnInfoListener(this);
        this.u.setVideoStatData(this.b0);
        this.u.setThreadDataForStatistic(this.c0);
        this.u.getMediaProgressObserver().j(this.A0);
    }

    public final void v0() {
        s0(this.f56745h);
        this.G.s();
        Y();
    }

    public final void w0() {
        this.x.setAlpha(1.0f);
        this.x.setVisibility(0);
        this.y.setVisibility(8);
        TBLottieAnimationView tBLottieAnimationView = this.x;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.loop(true);
            this.x.setMinAndMaxFrame(14, 80);
            this.x.playAnimation();
        }
    }

    public void x0(int i2) {
    }

    public void y0() {
        o oVar = this.b0;
        if (oVar != null) {
            o b2 = oVar.b();
            b2.f56718a = this.d0;
            d.a.k0.j2.h.e(b2.m, "", "1", b2, this.u.getPcdnState());
        }
    }

    public final void z0() {
        this.T = false;
        TBLottieAnimationView tBLottieAnimationView = this.x;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
        this.u.S();
        this.G.q();
        s0(this.f56743f);
        MessageManager.getInstance().unRegisterListener(this.K0);
    }
}
