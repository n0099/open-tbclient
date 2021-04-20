package d.b.i0.j2.q;

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
import d.b.c.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.z0.m0;
import d.b.i0.j2.f;
import d.b.i0.j2.o;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes3.dex */
public class d implements d.b.i0.j2.q.a {
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
    public d.b.i0.j2.j Z;
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
    public d.b.u.c u0;
    public TbImageView v;
    public McnAdInfo v0;
    public View w;
    public TBLottieAnimationView x;
    public k x0;
    public ImageView y;
    public ImageView z;

    /* renamed from: e  reason: collision with root package name */
    public int f57634e = 3000;

    /* renamed from: f  reason: collision with root package name */
    public int f57635f = 8211;

    /* renamed from: g  reason: collision with root package name */
    public int f57636g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f57637h = 4;
    public int i = 232;
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
    public View.OnClickListener s0 = null;
    public View.OnClickListener t0 = null;
    public boolean w0 = false;
    public long y0 = -1;
    public f.c z0 = new c();
    public SeekBar.OnSeekBarChangeListener A0 = new g();
    public GestureDetector.SimpleOnGestureListener B0 = new h();
    public View.OnTouchListener C0 = new i();
    public TbVideoViewSet.b D0 = new j();
    public final CustomMessageListener E0 = new a(2000994);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.r0(dVar.f57636g);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f.c {
        public c() {
        }

        @Override // d.b.i0.j2.f.c
        public void a(int i, int i2) {
            if (d.this.y0 <= 0) {
                d.this.y0 = i2;
            }
            if (d.this.j0()) {
                d dVar = d.this;
                if (!dVar.U && !dVar.a0 && dVar.w0) {
                    if (d.b.u.b.b().a(d.this.v0.jump_url)) {
                        return;
                    }
                    long j = i2;
                    boolean z = j >= d.this.v0.ad_start_time.longValue() * 1000 && j < d.this.v0.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.y0 >= (d.this.v0.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.u0.c()) {
                            d.b.u.a aVar = new d.b.u.a();
                            aVar.f65485b = d.this.v0.card_title;
                            aVar.f65486c = d.this.v0.button_title;
                            aVar.f65487d = d.this.v0.jump_url;
                            aVar.f65484a = d.this.v0.pic_url;
                            aVar.f65489f = String.valueOf(d.this.Y);
                            d dVar2 = d.this;
                            aVar.f65488e = dVar2.W;
                            aVar.f65490g = dVar2.d0();
                            if (z2) {
                                d.this.u0.f(aVar, (ViewGroup) d.this.Q);
                            } else {
                                d.this.u0.e(aVar, (ViewGroup) d.this.Q);
                            }
                        }
                    } else if (d.this.u0.c()) {
                        d.this.u0.a();
                    }
                }
            }
            if (d.this.x0 != null) {
                d.this.x0.a(i, i2);
            }
        }
    }

    /* renamed from: d.b.i0.j2.q.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1368d implements Animator.AnimatorListener {
        public C1368d() {
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

    /* loaded from: classes3.dex */
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
            d.this.P();
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

    /* loaded from: classes3.dex */
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
            d.this.V();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements SeekBar.OnSeekBarChangeListener {
        public g() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d dVar = d.this;
            dVar.r0(dVar.i);
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
                dVar.u.T(dVar.D0);
            }
            d.this.T();
            if (d.this.e0) {
                TiebaStatic.log(new StatisticItem("c13355").param("tid", d.this.W).param("fid", d.this.Y).param("obj_type", d.this.U ? 1 : 2).param("obj_locate", d.this.a0 ? 1 : 2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends GestureDetector.SimpleOnGestureListener {
        public h() {
        }

        public final void a(int i, int i2) {
            if (d.this.o0 == i2 && d.this.p0 == i) {
                return;
            }
            d dVar = d.this;
            dVar.n0 = dVar.o0 - i2 > 0 || ((float) i2) < d.this.h0 / 6.0f;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.R.getLayoutParams();
            if (i2 != d.this.o0) {
                int i3 = d.this.m0 - i2;
                int i4 = (int) (i3 * d.this.q0);
                if (i4 < d.this.r0) {
                    i4 = d.this.r0;
                    i3 = (int) (i4 / d.this.q0);
                }
                if (i4 != d.this.r0) {
                    layoutParams.height = i3;
                    layoutParams.width = i4;
                    d.this.R.setLayoutParams(layoutParams);
                }
                d.this.o0 = i2;
                d dVar2 = d.this;
                dVar2.R.setTranslationY(dVar2.o0);
            }
            if (i != d.this.o0) {
                d.this.p0 = i;
                d dVar3 = d.this;
                dVar3.R.setTranslationX(dVar3.p0 + ((d.this.i0 - layoutParams.width) / 2.0f));
            }
            d.this.M.setAlpha((layoutParams.width - d.this.r0) / (d.this.i0 - d.this.r0));
            if (d.this.I.getVisibility() == 0) {
                float f2 = d.this.h0 / 6.0f;
                float f3 = (f2 - i2) / f2;
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
                if (dVar.q == dVar.i) {
                    dVar.r0(dVar.j);
                } else {
                    dVar.r0(dVar.k);
                }
                d.this.w0(R.id.video_pause);
                return true;
            }
            d dVar2 = d.this;
            int i = dVar2.q;
            int i2 = dVar2.j;
            if (i != i2 && i != (i2 | 1)) {
                int i3 = dVar2.k;
                if (i == i3 || i == (i3 | 1)) {
                    d dVar3 = d.this;
                    dVar3.r0(dVar3.f57636g);
                    d dVar4 = d.this;
                    dVar4.u.T(dVar4.D0);
                    d.this.w0(R.id.video_play);
                    return true;
                }
                return true;
            }
            d dVar5 = d.this;
            dVar5.r0(dVar5.i);
            d.this.T();
            d dVar6 = d.this;
            dVar6.u.T(dVar6.D0);
            d.this.w0(R.id.video_play);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.r = 0;
            d dVar = d.this;
            if (dVar.a0) {
                dVar.S((Activity) dVar.P, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            int i;
            int i2;
            if (!d.this.h0(motionEvent)) {
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
            if (dVar.U && dVar.i0()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                int i3 = d.this.r;
                if (i3 != 0) {
                    if (i3 == 4) {
                        a(rawX, rawY);
                    }
                } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                    if (d.this.u.isPlaying()) {
                        d.this.u.pause();
                        d dVar2 = d.this;
                        dVar2.r0(dVar2.o);
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
                int i4 = dVar7.q;
                if (i4 == dVar7.f57636g || i4 == dVar7.i || i4 == (i = dVar7.j) || i4 == (i2 = dVar7.k) || i4 == dVar7.n || i4 == (i | 1) || i4 == (i2 | 1)) {
                    int i5 = d.this.r;
                    if (i5 == 0) {
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
                        int i6 = dVar11.q;
                        int i7 = dVar11.n;
                        if (i6 != i7) {
                            if ((i6 & 1) > 0) {
                                dVar11.n = i7 | 1;
                            } else {
                                dVar11.n = i7 & (-2);
                            }
                            d dVar12 = d.this;
                            dVar12.r0(dVar12.n);
                        }
                    } else if (i5 == 1) {
                        d dVar13 = d.this;
                        int i8 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                        dVar13.L.c(dVar13.P, i8 > 0);
                        if (i8 > 0) {
                            d.this.N();
                        }
                    } else if (i5 == 2) {
                        d dVar14 = d.this;
                        dVar14.L.a(dVar14.P, f3 > 0.0f);
                    } else if (i5 == 3) {
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
                int i = dVar.q;
                int i2 = dVar.f57636g;
                if (i != i2 && i != dVar.f57637h) {
                    if (i == dVar.i) {
                        dVar.r0(i2);
                    }
                } else {
                    d dVar2 = d.this;
                    dVar2.r0(dVar2.i);
                    d.this.T();
                }
            } else {
                d dVar3 = d.this;
                int i3 = dVar3.q;
                int i4 = dVar3.j;
                if (i3 == i4) {
                    dVar3.r0(dVar3.k);
                } else if (i3 == (i4 | 1)) {
                    dVar3.r0(dVar3.k | 1);
                } else {
                    int i5 = dVar3.k;
                    if (i3 == i5) {
                        dVar3.r0(i4);
                    } else if (i3 == (i5 | 1)) {
                        dVar3.r0(i4 | 1);
                    } else {
                        dVar3.r0(dVar3.f57635f);
                        d.this.startPlay();
                        d.this.o0();
                    }
                }
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnTouchListener {
        public i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                d dVar = d.this;
                if (dVar.q == dVar.n) {
                    if (dVar.r == 4) {
                        d.this.U();
                        d.this.o0 = 0;
                        d.this.p0 = 0;
                    } else {
                        d dVar2 = d.this;
                        dVar2.q = -1;
                        if (dVar2.r != 3) {
                            if (d.this.s != -1) {
                                d dVar3 = d.this;
                                dVar3.r0(dVar3.s);
                                d.this.s = -1;
                            } else if (d.this.u.isPlaying()) {
                                d dVar4 = d.this;
                                dVar4.r0(dVar4.f57636g);
                            } else {
                                d dVar5 = d.this;
                                dVar5.r0(dVar5.j);
                            }
                        } else {
                            d dVar6 = d.this;
                            dVar6.G.setCurrentDuration(dVar6.k0, true);
                            if (d.this.k0 <= d.this.u.getDuration()) {
                                if (!d.this.u.isPlaying()) {
                                    d dVar7 = d.this;
                                    dVar7.u.T(dVar7.D0);
                                }
                                d dVar8 = d.this;
                                dVar8.r0(dVar8.f57636g);
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
                        if (!d.b.c.e.p.k.isEmpty(str)) {
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

    /* loaded from: classes3.dex */
    public class j implements TbVideoViewSet.b {
        public j() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            d.this.u.G();
            d.this.t0();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            d dVar = d.this;
            dVar.r0(dVar.f57635f);
            d.this.v0();
        }
    }

    /* loaded from: classes3.dex */
    public interface k {
        void a(int i, int i2);
    }

    public d(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        this.P = context;
        this.Q = view;
        this.h0 = l.i(context);
        this.i0 = l.k(this.P);
        f0();
    }

    @Override // d.b.i0.j2.q.a
    public View C() {
        return this.R;
    }

    @Override // d.b.i0.j2.q.a
    public boolean D() {
        return this.a0;
    }

    @Override // d.b.i0.j2.q.a
    public boolean H() {
        if (this.a0) {
            U();
            return true;
        }
        return false;
    }

    @Override // d.b.i0.j2.q.a
    public boolean N() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.u.isPlaying() && !m0.c()) {
            this.u.setVolume(1.0f, 1.0f);
            this.E.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
            return false;
        }
        return false;
    }

    public void P() {
        if (this.q == this.f57637h) {
            r0(this.f57636g);
        }
    }

    public void Q() {
        if (this.U) {
            this.i = 104;
            this.j = 8290;
        } else {
            this.i = 232;
            this.j = 8418;
        }
        if (this.a0) {
            this.f57635f |= 1024;
            this.f57636g |= 1024;
            this.f57637h |= 1024;
            this.i |= 1024;
            this.j |= 1024;
            this.k |= 1024;
            this.l |= 1024;
            this.m |= 1024;
            this.q |= 1024;
            return;
        }
        this.f57635f &= -1025;
        this.f57636g &= -1025;
        this.f57637h &= -1025;
        this.i &= -1025;
        this.j &= -1025;
        this.k &= -1025;
        this.l &= -1025;
        this.m &= -1025;
        this.q &= -1025;
    }

    public void R() {
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
        this.B.setPadding(0, 0, i2, 0);
        SwitchImageView switchImageView = this.F;
        switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i2, 0);
        this.E.setPadding(i2, 0, 0, 0);
    }

    public final void S(Activity activity, boolean z) {
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
            s0();
        } else {
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.R.setSystemUiVisibility(0);
        }
    }

    public void T() {
        d.b.c.e.m.e.a().removeCallbacks(this.t);
        d.b.c.e.m.e.a().postDelayed(this.t, this.f57634e);
    }

    public final void U() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        if (!this.U) {
            V();
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
                if (i2 == this.o || i2 == this.i || i2 == this.f57636g) {
                    this.u.T(this.D0);
                    r0(this.f57636g);
                }
            }
        } else {
            V();
        }
    }

    public void V() {
        W(true);
    }

    public void W(boolean z) {
        View view = this.Q;
        if (view == null || this.R == null || this.u == null) {
            return;
        }
        Context context = this.P;
        if (context != null) {
            l.w(context, view);
        }
        if (this.Z == null) {
            this.Z = new d.b.i0.j2.j((Activity) this.P);
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
                S((Activity) this.P, this.a0);
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
                            S((Activity) this.P, true);
                            d.b.u.c cVar = this.u0;
                            if (cVar != null && cVar.c()) {
                                this.u0.a();
                            }
                        }
                    }
                }
            }
            if (this.e0) {
                TiebaStatic.log(new StatisticItem("c13360").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2));
            }
        }
        Q();
        R();
        if (this.u.isPlaying()) {
            r0(this.f57636g);
        } else {
            r0(this.q);
        }
        this.F.b();
        m0(this.a0);
    }

    public void X() {
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

    public void Y(boolean z) {
        if (this.Z == null) {
            this.Z = new d.b.i0.j2.j((Activity) this.P);
        }
        if (z) {
            this.Z.j();
            this.Z.i(true);
            return;
        }
        this.Z.k();
        this.Z.i(false);
    }

    @Override // d.b.i0.j2.q.a
    public void Z(o oVar) {
        TbCyberVideoView tbCyberVideoView = this.u;
        if (tbCyberVideoView != null) {
            this.b0 = oVar;
            tbCyberVideoView.setVideoStatData(oVar);
        }
    }

    @Override // d.b.i0.j2.q.a
    public void a0() {
    }

    public final void b0() {
        r0(this.f57637h);
        this.G.s();
        TBLottieAnimationView tBLottieAnimationView = this.x;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.clearAnimation();
            this.x.animate().alpha(0.0f).setDuration(200L).setListener(new e()).start();
        }
    }

    public int c0() {
        return R.layout.operable_video_container;
    }

    public int d0() {
        return 2;
    }

    @Override // d.b.i0.j2.q.a
    public boolean e0(boolean z) {
        if (z) {
            this.x.cancelAnimation();
            int i2 = this.q;
            if (i2 == this.f57636g || i2 == this.f57637h || i2 == this.i || i2 == this.f57635f) {
                stopPlay();
            }
            int i3 = this.q | 1;
            this.q = i3;
            r0(i3);
        } else if (this.q == this.f57635f) {
            return false;
        }
        return true;
    }

    public void f0() {
        Context context = this.P;
        if (context == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(c0(), (ViewGroup) null);
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
        this.x.addAnimatorListener(new C1368d());
        this.x.setAnimation(R.raw.lotti_video_loading);
        this.y.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.y.setOnClickListener(this);
        this.E.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
        this.E.setState(1);
        this.E.setOnClickListener(this);
        this.v.B();
        this.v.setDrawCorner(false);
        this.v.setPlaceHolder(3);
        d.b.h0.b.g.b.f(this.w, R.color.CAM_X0607);
        this.G.setOnSeekBarChangeListener(this.A0);
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
        t0();
        this.H.setPlayViewOnClickListener(this);
        this.R.setOnClickListener(null);
        this.R.setOnTouchListener(this.C0);
        this.I.setOnTouchListener(this.C0);
        this.N.setOutOnClickListener(this);
        this.j0 = new GestureDetector(this.P, this.B0);
        r0(this.f57635f);
        this.u0 = new d.b.u.c(this.P);
    }

    public void g0() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.u.setVolume(0.0f, 0.0f);
            this.E.setState(1);
            return;
        }
        this.u.setVolume(1.0f, 1.0f);
        this.E.setState(0);
    }

    @Override // d.b.i0.j2.q.a
    public int getCurrentPosition() {
        return this.u.getCurrentPosition();
    }

    public String getVideoUrl() {
        return this.V;
    }

    public boolean h0(MotionEvent motionEvent) {
        return this.a0;
    }

    public boolean i0() {
        return this.U && this.a0;
    }

    @Override // d.b.i0.j2.q.a
    public boolean isPlaying() {
        return this.T || this.u.isPlaying();
    }

    public boolean j0() {
        return this.v0 != null;
    }

    @Override // d.b.i0.j2.q.a
    public void k0(View.OnClickListener onClickListener) {
        this.t0 = onClickListener;
    }

    public boolean l0() {
        OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.H;
        return operableVideoNetworkStateTipView != null && operableVideoNetworkStateTipView.d();
    }

    public void m0(boolean z) {
    }

    public void n0() {
        d.b.c.e.m.e.a().removeCallbacks(this.t);
    }

    public final void o0() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.V);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.S);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        w0(id);
        if (id == R.id.video_mute) {
            X();
        } else if (id != R.id.video_full_screen && id != R.id.video_full_screen_back) {
            if (id == R.id.video_replay) {
                r0(this.f57635f);
                startPlay();
                if (this.e0) {
                    TiebaStatic.log(new StatisticItem("c13345").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_locate", this.a0 ? 1 : 2));
                }
                o0();
            } else if (id == R.id.video_play) {
                if (this.q == this.f57635f) {
                    startPlay();
                } else {
                    r0(this.i);
                    T();
                    this.u.T(this.D0);
                }
                if (this.e0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", this.a0 ? 1 : 2).param("obj_locate", 1));
                }
                o0();
            } else if (id == R.id.video_pause) {
                r0(this.j);
                n0();
                this.u.pause();
                if (this.e0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", this.a0 ? 1 : 2).param("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                r0(this.f57635f);
                startPlay();
            } else if (id == R.id.retry) {
                r0(this.f57635f);
                startPlay();
            }
        } else {
            U();
        }
    }

    public void onCompletion() {
        r0(this.l);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        r0(this.p);
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        if (i2 == 3 || i2 == 904) {
            u0();
        }
        if (i2 == 701) {
            v0();
            return false;
        } else if (i2 == 702) {
            u0();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        g0();
        if (this.T) {
            if (this.a0) {
                Context context = this.P;
                if (context instanceof Activity) {
                    S((Activity) context, true);
                }
            }
            this.u.T(this.D0);
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
                y0();
                r0(this.l);
                return;
            }
            y0();
            return;
        }
        y0();
        r0(this.j);
    }

    public void p0(boolean z) {
        this.w0 = z;
    }

    public void q0(k kVar) {
        this.x0 = kVar;
    }

    public void r0(int i2) {
        n0();
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

    public final void s0() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16) {
            this.R.setSystemUiVisibility(2);
        } else if (i2 >= 16 && i2 <= 18) {
            this.R.setSystemUiVisibility(4);
        } else {
            this.R.setSystemUiVisibility(5894);
        }
    }

    @Override // d.b.i0.j2.q.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.s0 = onClickListener;
    }

    @Override // d.b.i0.j2.q.a
    public void setData(a2 a2Var) {
        if (a2Var == null || a2Var.u1() == null) {
            return;
        }
        this.y0 = -1L;
        d.b.u.c cVar = this.u0;
        if (cVar != null) {
            cVar.d();
        }
        if (StringHelper.equals(this.V, a2Var.u1().video_url)) {
            return;
        }
        stopPlay();
        this.U = a2Var.u1().is_vertical.intValue() == 1;
        this.V = a2Var.u1().video_url;
        this.W = a2Var.w1();
        a2Var.u1().video_length.intValue();
        this.X = a2Var.u1().video_duration.intValue();
        this.Y = a2Var.c0();
        this.v0 = a2Var.u1().mcn_ad_card;
        Q();
        R();
        r0(this.f57635f);
        int intValue = a2Var.u1().video_duration.intValue() * 1000;
        this.G.p(intValue);
        this.G.setPlayer(this.u);
        this.D.setText(StringHelper.stringForVideoTime(intValue));
        this.B.setText(String.format(this.P.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(a2Var.u1().play_count.intValue())));
        this.H.setVideoLength(a2Var.u1().video_length.intValue());
        this.H.setVideoDuration(a2Var.u1().video_duration.intValue());
        this.H.setTid(this.W);
        this.c0 = a2Var;
        this.u.setThreadDataForStatistic(a2Var);
        this.C.setVisibility(8);
        this.v.setPlaceHolder(3);
        this.v.W(a2Var.u1().thumbnail_url, 10, false);
        this.I.setShareData(a2Var);
    }

    @Override // d.b.i0.j2.q.a
    public void setFrom(String str) {
        this.d0 = str;
    }

    @Override // d.b.i0.j2.q.a
    public void setStageType(String str) {
        this.g0 = str;
    }

    @Override // d.b.i0.j2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.S = bdUniqueId;
    }

    @Override // d.b.i0.j2.q.a
    public void startPlay() {
        if (StringUtils.isNull(this.V)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.E0);
        if (l0()) {
            r0(this.m);
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
            t0();
            if (d.b.c.e.p.j.z()) {
                this.u.setVideoDuration(this.X);
                this.u.setVideoPath(this.V, this.W);
                this.u.setStageType(this.g0);
                v0();
                if (this.e0) {
                    x0();
                }
            }
        } else {
            TbCyberVideoView tbCyberVideoView2 = this.u;
            if (tbCyberVideoView2 == e2) {
                if (tbCyberVideoView2.getParent() == null || this.u.getParent() != e2.getParent()) {
                    this.u.G();
                    t0();
                }
            } else {
                tbCyberVideoView2.G();
                e2.G();
                this.u = e2;
                e2.setTryUseViewInSet(true);
                t0();
            }
            this.u.O();
            onPrepared();
            u0();
            if (this.e0) {
                x0();
            }
        }
        if (this.e0) {
            TiebaStatic.log(new StatisticItem("c13357").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // d.b.i0.j2.q.a
    public void stopPlay() {
        this.T = false;
        TBLottieAnimationView tBLottieAnimationView = this.x;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
        this.u.U();
        this.u.G();
        this.G.q();
        r0(this.f57635f);
        MessageManager.getInstance().unRegisterListener(this.E0);
    }

    @Override // d.b.i0.j2.q.a
    public void t(int i2) {
        this.u.getRenderView().setDisplayMode(i2);
    }

    public void t0() {
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
        this.u.getMediaProgressObserver().j(this.z0);
    }

    public final void u0() {
        r0(this.f57637h);
        this.G.s();
        b0();
    }

    public final void v0() {
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

    public void w0(int i2) {
    }

    public void x0() {
        o oVar = this.b0;
        if (oVar != null) {
            o b2 = oVar.b();
            b2.f57611a = this.d0;
            d.b.i0.j2.h.e(b2.m, "", "1", b2, this.u.getPcdnState());
        }
    }

    public final void y0() {
        this.T = false;
        TBLottieAnimationView tBLottieAnimationView = this.x;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
        this.u.U();
        this.G.q();
        r0(this.f57635f);
        MessageManager.getInstance().unRegisterListener(this.E0);
    }
}
