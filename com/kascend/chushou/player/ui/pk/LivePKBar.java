package com.kascend.chushou.player.ui.pk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class LivePKBar extends RelativeLayout implements View.OnClickListener {
    private View A;
    private View B;
    private ImageView C;
    private RelativeLayout D;
    private TextView E;
    private TextView G;
    private TextView H;
    private long a;
    private long b;
    private double c;
    private double d;
    private float e;
    private long g;
    private int h;
    private long j;
    private TextView k;
    private LinearLayout l;
    private TextView m;
    private io.reactivex.disposables.b mTb;
    private io.reactivex.disposables.b mVJ;
    private TextView mVK;
    private LinearLayout mVL;
    private LinearLayout mVM;
    private ImageView mVN;
    private ImageView mVO;
    private RelativeLayout mVP;
    private LinearLayout mVQ;
    private LinearLayout mVR;
    private LinearLayout mVS;
    private RelativeLayout mVT;
    private FrameLayout mVU;
    private TextView mVV;
    private RelativeLayout mVW;
    private LinearLayout mVX;
    private TextView mVY;
    private FrescoThumbnailView mVZ;
    private c mWa;
    private io.reactivex.disposables.b mWb;
    private AnimatorSet mWc;
    private a mWd;
    private b mWe;
    private TextView n;
    private TextView o;
    private View p;
    private View q;
    private ImageView r;
    private TextView s;
    private LinearLayout u;

    /* loaded from: classes5.dex */
    public interface a {
        void A(long j, int i);

        void a();

        void b();

        void c();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(long j);

        void b(long j);
    }

    public LivePKBar(Context context) {
        super(context);
        this.a = 0L;
        this.b = 0L;
        this.c = 1.0d;
        this.d = 1.0d;
        this.e = 0.2f;
        this.h = 30;
        a(context);
    }

    public LivePKBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0L;
        this.b = 0L;
        this.c = 1.0d;
        this.d = 1.0d;
        this.e = 0.2f;
        this.h = 30;
        a(context);
    }

    public LivePKBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0L;
        this.b = 0L;
        this.c = 1.0d;
        this.d = 1.0d;
        this.e = 0.2f;
        this.h = 30;
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        h();
        super.onDetachedFromWindow();
    }

    private void a(Context context) {
        inflate(context, a.h.layout_online_live_pk_bar, this);
        this.k = (TextView) findViewById(a.f.tv_pk_last_seconds);
        this.l = (LinearLayout) findViewById(a.f.ll_pk_counter);
        this.m = (TextView) findViewById(a.f.tv_pk_counter_tip);
        this.n = (TextView) findViewById(a.f.tv_pk_counter_time);
        this.o = (TextView) findViewById(a.f.tv_pk_stop_pk);
        this.p = findViewById(a.f.view_pk_left);
        this.q = findViewById(a.f.view_pk_right);
        this.A = findViewById(a.f.view_pk_left_animation);
        this.B = findViewById(a.f.view_pk_right_animation);
        this.mVP = (RelativeLayout) findViewById(a.f.ll_pk_energy_bar_animation);
        this.r = (ImageView) findViewById(a.f.live_pk_bar_crit_line);
        this.s = (TextView) findViewById(a.f.tv_pk_left_value);
        this.mVK = (TextView) findViewById(a.f.tv_pk_right_value);
        this.u = (LinearLayout) findViewById(a.f.ll_pk_left_users);
        this.mVL = (LinearLayout) findViewById(a.f.ll_pk_right_users);
        this.mVM = (LinearLayout) findViewById(a.f.ll_pk_energy_bar);
        this.mVN = (ImageView) findViewById(a.f.iv_pk_left_fire_ball);
        this.mVO = (ImageView) findViewById(a.f.iv_pk_right_fire_ball);
        this.C = (ImageView) findViewById(a.f.iv_pk_fire_ball_bang);
        this.D = (RelativeLayout) findViewById(a.f.rl_live_pk_rule);
        this.E = (TextView) findViewById(a.f.tv_pk_rule);
        this.mVQ = (LinearLayout) findViewById(a.f.ll_live_pk_addition_notice);
        this.G = (TextView) findViewById(a.f.tv_live_pk_addition_notice);
        this.H = (TextView) findViewById(a.f.tv_live_pk_addition_countdown);
        this.E.setVisibility(8);
        this.o.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.mVL.setOnClickListener(this);
        this.mVR = (LinearLayout) findViewById(a.f.ll_pk_users);
        this.mVS = (LinearLayout) findViewById(a.f.ll_live_pk_bar_bg_alpha);
        this.mVT = (RelativeLayout) findViewById(a.f.rl_live_pk_fire_anim);
        this.mVU = (FrameLayout) findViewById(a.f.fl_pk_counter_inner);
        this.mVV = (TextView) findViewById(a.f.tv_combat_crunchies);
        this.mVW = (RelativeLayout) findViewById(a.f.rl_live_pk);
        this.mVX = (LinearLayout) findViewById(a.f.ll_live_destiny);
        this.mVY = (TextView) findViewById(a.f.tv_promotion);
        this.mVZ = (FrescoThumbnailView) findViewById(a.f.iv_destiny);
        this.mVV.setVisibility(8);
        this.mVV.setOnClickListener(this);
        for (int i = 0; i < 4; i++) {
            inflate(getContext(), a.h.layout_pk_view_online_live_pk_bar_user_item, this.u);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            inflate(getContext(), a.h.layout_pk_view_online_live_pk_bar_user_item, this.mVL);
        }
        int childCount = this.u.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((TextView) this.u.getChildAt(i3).findViewById(a.f.tv_pk_ranking)).setText(String.valueOf(childCount - i3));
        }
        int childCount2 = this.mVL.getChildCount();
        for (int i4 = 0; i4 < childCount2; i4++) {
            ((TextView) this.mVL.getChildAt(i4).findViewById(a.f.tv_pk_ranking)).setText(String.valueOf(i4 + 1));
        }
        setLeftUserBg(false);
        setRightUserBg(false);
    }

    public void a() {
        h();
        setVisibility(8);
    }

    public void a(LinkedHashMap<Long, String> linkedHashMap, LinkedHashMap<Long, String> linkedHashMap2) {
        a(linkedHashMap);
        c(linkedHashMap2);
    }

    public void a(long j) {
        setVisibility(0);
        i();
        this.j = j;
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.m.setVisibility(8);
        this.n.setVisibility(0);
        this.mVJ = io.reactivex.g.a(0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dKy()).b(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Long l) throws Exception {
                long longValue = LivePKBar.this.j - l.longValue();
                LivePKBar.this.n.setText(LivePKBar.this.d(longValue));
                if (longValue <= 0) {
                    LivePKBar.this.k();
                }
                if (LivePKBar.this.mWe != null) {
                    LivePKBar.this.mWe.b(longValue);
                }
            }
        });
    }

    public void b() {
        this.k.setVisibility(8);
    }

    public void a(int i, long j, boolean z) {
        p();
        f(j);
        a(i, z);
    }

    public void b(int i, long j, boolean z) {
        q();
        e(j);
        a(i, z);
    }

    private void h() {
        i();
        t();
        l();
        f();
        g();
    }

    public void a(int i, String str, String str2) {
        if (i == 2) {
            this.mVN.setImageDrawable(getResources().getDrawable(a.e.pk_live_online_live_destiny_bar_fire_ball_left));
            this.mVO.setImageDrawable(getResources().getDrawable(a.e.pk_live_online_live_destiny_bar_fire_ball_right));
            this.p.setBackgroundResource(a.e.pk_live_online_live_destiny_bar_yellow);
            this.q.setBackgroundResource(a.e.pk_live_online_live_destiny_bar_green);
            this.A.setBackgroundResource(a.e.pk_live_online_live_destiny_bar_yellow);
            this.B.setBackgroundResource(a.e.pk_live_online_live_destiny_bar_green);
            this.mVY.setText(str2);
            this.mVZ.bV(str, a.e.icon_live_destiny_promotion);
            this.mVX.setVisibility(0);
            this.mVW.setVisibility(8);
            return;
        }
        this.mVN.setImageDrawable(getResources().getDrawable(a.e.pk_live_online_live_pk_bar_fire_ball_left));
        this.mVO.setImageDrawable(getResources().getDrawable(a.e.pk_live_online_live_pk_bar_fire_ball_right));
        this.p.setBackgroundResource(a.e.pk_live_online_live_pk_bar_purple);
        this.q.setBackgroundResource(a.e.pk_live_online_live_pk_bar_blue);
        this.A.setBackgroundResource(a.e.pk_live_online_live_pk_bar_purple);
        this.B.setBackgroundResource(a.e.pk_live_online_live_pk_bar_blue);
        this.mVX.setVisibility(8);
        this.mVW.setVisibility(0);
    }

    public void c() {
        setVisibility(0);
        h();
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.m.setVisibility(0);
        this.m.setText(a.i.str_live_online_live_pk_wait);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.mVN.setVisibility(4);
        this.mVO.setVisibility(4);
        this.C.setVisibility(4);
    }

    public void b(long j) {
        setVisibility(0);
        i();
        this.g = j;
        this.mTb = io.reactivex.g.a(0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dKy()).b(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Long l) throws Exception {
                LivePKBar.this.c(LivePKBar.this.g - l.longValue());
            }
        });
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(int i, boolean z) {
        this.m.setVisibility(0);
        this.m.setText(i == 2 ? a.i.str_live_online_live_pk_in_stopping : a.i.str_live_online_live_pk_loss);
        this.o.setVisibility(z ? 0 : 8);
    }

    public void b(int i, boolean z) {
        if (i == 2) {
            this.m.setVisibility(0);
            this.m.setText(a.i.str_live_online_live_pk_in_stopping);
        } else {
            this.m.setVisibility(8);
        }
        this.o.setVisibility(z ? 0 : 8);
    }

    public void d() {
        b(1);
    }

    public void b(int i) {
        if (i == 2) {
            this.E.setVisibility(8);
            this.mVV.setVisibility(0);
            return;
        }
        this.E.setVisibility(0);
        this.mVV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        if (j <= this.h) {
            this.l.setVisibility(8);
            this.k.setVisibility(0);
            this.k.setText(String.valueOf(j));
        } else {
            this.l.setVisibility(0);
            this.k.setVisibility(8);
            this.m.setVisibility(0);
            this.m.setText(a.i.str_live_online_live_pk_ing);
            this.n.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setText(d(j));
        }
        if (j <= 0) {
            j();
        }
        if (this.mWe != null) {
            this.mWe.a(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(long j) {
        if (j <= 0) {
            return "00:00";
        }
        long minutes = TimeUnit.SECONDS.toMinutes(j);
        return String.format(Locale.CHINA, "%02d:%02d", Long.valueOf(minutes), Long.valueOf(TimeUnit.SECONDS.toSeconds(j - TimeUnit.MINUTES.toSeconds(minutes))));
    }

    private void i() {
        j();
        k();
    }

    private void j() {
        if (this.mTb != null) {
            this.mTb.dispose();
            this.mTb = null;
            this.g = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.mVJ != null) {
            this.mVJ.dispose();
            this.mVJ = null;
            this.j = 0L;
        }
    }

    public void a(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.e = f;
        }
    }

    private void l() {
        this.s.setText("0");
        this.mVK.setText("0");
        ((LinearLayout.LayoutParams) this.q.getLayoutParams()).weight = 1.0f;
        ((LinearLayout.LayoutParams) this.p.getLayoutParams()).weight = 1.0f;
        this.a = 0L;
        this.b = 0L;
        this.c = 1.0d;
        this.d = 1.0d;
    }

    public void a(long j, long j2) {
        if (j != this.a || j2 != this.b) {
            if (j == 0 && j2 == 0) {
                this.s.setText("0");
                this.mVK.setText("0");
                ((LinearLayout.LayoutParams) this.q.getLayoutParams()).weight = 1.0f;
                ((LinearLayout.LayoutParams) this.p.getLayoutParams()).weight = 1.0f;
                return;
            }
            long j3 = j + j2;
            this.c = j / j3;
            this.d = j2 / j3;
            if (this.c < this.e) {
                this.c = this.e;
                this.d = 1.0f - this.e;
            } else if (this.d < this.e) {
                this.d = this.e;
                this.c = 1.0f - this.e;
            }
            ((LinearLayout.LayoutParams) this.p.getLayoutParams()).weight = (float) this.c;
            ((LinearLayout.LayoutParams) this.q.getLayoutParams()).weight = (float) this.d;
            this.s.setText(String.valueOf(j));
            this.mVK.setText(String.valueOf(j2));
            this.a = j;
            this.b = j2;
            o();
        }
    }

    public void e() {
        this.mVN.clearAnimation();
        this.mVO.clearAnimation();
        this.C.clearAnimation();
        this.B.clearAnimation();
        this.A.clearAnimation();
        this.mVM.setVisibility(4);
        this.mVP.setVisibility(0);
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth <= 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.6
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        LivePKBar.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    LivePKBar.this.e();
                }
            });
            return;
        }
        float f = ((LinearLayout.LayoutParams) this.q.getLayoutParams()).weight;
        float f2 = ((LinearLayout.LayoutParams) this.p.getLayoutParams()).weight;
        float f3 = f + f2;
        float f4 = f / f3;
        this.C.setVisibility(4);
        final float f5 = (f2 / f3) * measuredWidth;
        final float f6 = measuredWidth - f5;
        this.mVN.setVisibility(0);
        final float measuredWidth2 = this.mVN.getMeasuredWidth();
        final float dip2px = (f5 - measuredWidth2) + tv.chushou.zues.utils.a.dip2px(getContext(), 15.0f);
        m();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mVN, "translationX", -measuredWidth2, dip2px);
        ofFloat.setDuration(800L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new g() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.7
            @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                final Animation loadAnimation = AnimationUtils.loadAnimation(LivePKBar.this.getContext(), a.C0794a.pk_live_online_live_fire_ball_bang_anim);
                LivePKBar.this.postDelayed(new Runnable() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LivePKBar.this.mVN.startAnimation(loadAnimation);
                        LivePKBar.this.mVO.startAnimation(loadAnimation);
                    }
                }, 440L);
                LivePKBar.this.postDelayed(new Runnable() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LivePKBar.this.n();
                        LivePKBar.this.mVM.setVisibility(0);
                        LivePKBar.this.mVP.setVisibility(4);
                    }
                }, 760L);
                LivePKBar.this.C.setVisibility(0);
                tv.chushou.zues.toolkit.d.b.setTranslationX(LivePKBar.this.C, dip2px);
                LivePKBar.this.postDelayed(new Runnable() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.7.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LivePKBar.this.C.startAnimation(loadAnimation);
                        LivePKBar.this.A.getLayoutParams().width = (int) f5;
                        LivePKBar.this.A.requestLayout();
                        LivePKBar.this.B.getLayoutParams().width = (int) f6;
                        LivePKBar.this.B.requestLayout();
                    }
                }, 440L);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = ((int) ((Float) valueAnimator.getAnimatedValue()).floatValue()) + ((int) (measuredWidth2 / 2.0f));
                if (floatValue < 0) {
                    floatValue = 0;
                }
                LivePKBar.this.A.getLayoutParams().width = floatValue;
                LivePKBar.this.A.requestLayout();
            }
        });
        ofFloat.start();
        this.mVO.setVisibility(0);
        final float measuredWidth3 = this.mVO.getMeasuredWidth();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mVO, "translationX", measuredWidth3, -((f6 - measuredWidth3) + tv.chushou.zues.utils.a.dip2px(getContext(), 17.0f)));
        ofFloat2.setDuration(800L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i = (-((int) ((Float) valueAnimator.getAnimatedValue()).floatValue())) + ((int) (measuredWidth3 / 2.0f));
                if (i < 0) {
                    i = 0;
                }
                LivePKBar.this.B.getLayoutParams().width = i;
                LivePKBar.this.B.requestLayout();
            }
        });
        ofFloat2.start();
    }

    private void m() {
        ((AnimationDrawable) this.mVN.getDrawable()).start();
        ((AnimationDrawable) this.mVO.getDrawable()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ((AnimationDrawable) this.mVN.getDrawable()).stop();
        ((AnimationDrawable) this.mVO.getDrawable()).stop();
    }

    public void f() {
        if (this.mWa != null) {
            e.dFT().c(this.mWa);
        }
        this.r.setVisibility(4);
    }

    private void o() {
        int width = getWidth();
        if (width <= 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.10
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        LivePKBar.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    if (LivePKBar.this.r != null) {
                        int width2 = (int) (((LivePKBar.this.getWidth() * LivePKBar.this.c) / (LivePKBar.this.c + LivePKBar.this.d)) - tv.chushou.widget.a.c.B(3.5f));
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) LivePKBar.this.r.getLayoutParams();
                        layoutParams.leftMargin = width2;
                        LivePKBar.this.r.setLayoutParams(layoutParams);
                    }
                }
            });
            return;
        }
        int B = (int) (((width * this.c) / (this.c + this.d)) - tv.chushou.widget.a.c.B(3.5f));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams.leftMargin = B;
        this.r.setLayoutParams(layoutParams);
    }

    public void c(float f, final int i) {
        if (i > 0) {
            this.D.setVisibility(4);
            this.mVQ.setVisibility(0);
            this.G.setText(((int) (100.0f * f)) + getContext().getResources().getString(a.i.str_live_across_pk_chat_notice_addition));
            this.mWb = io.reactivex.g.a(0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dKy()).b(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = i - l.longValue();
                    if (longValue > 0) {
                        LivePKBar.this.H.setText(longValue + "s");
                    } else {
                        LivePKBar.this.g();
                    }
                }
            });
            ValueAnimator ofInt = ValueAnimator.ofInt(0, tv.chushou.zues.utils.a.dip2px(getContext(), 52.0f));
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LivePKBar.this.mVQ.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    LivePKBar.this.mVQ.requestLayout();
                }
            });
            this.mWc = new AnimatorSet();
            this.mWc.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.pk.LivePKBar.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }
            });
            this.mWc.playTogether(ofInt);
            this.mWc.setInterpolator(new LinearInterpolator());
            this.mWc.setDuration(1000L);
            this.mWc.start();
        }
    }

    public void g() {
        if (this.mWb != null) {
            this.mWb.dispose();
            this.mWb = null;
        }
        if (this.mWc != null) {
            this.mWc.cancel();
            this.mWc = null;
        }
        this.mVQ.setVisibility(8);
        this.D.setVisibility(0);
    }

    private void p() {
        setLeftUserBg(true);
    }

    private void q() {
        setRightUserBg(true);
    }

    private void e(long j) {
        if (j >= 0) {
            int childCount = this.u.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.u.getChildAt(i);
                Long l = (Long) childAt.getTag();
                if (l != null && l.longValue() == j) {
                    ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setVisibility(8);
                    childAt.findViewById(a.f.iv_pk_mvp).setVisibility(0);
                    return;
                }
            }
        }
    }

    private void f(long j) {
        if (j >= 0) {
            int childCount = this.mVL.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.mVL.getChildAt(i);
                Long l = (Long) childAt.getTag();
                if (l != null && l.longValue() == j) {
                    ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setVisibility(8);
                    childAt.findViewById(a.f.iv_pk_mvp).setVisibility(0);
                    return;
                }
            }
        }
    }

    private void a(LinkedHashMap<Long, String> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            r();
            return;
        }
        Set<Long> keySet = linkedHashMap.keySet();
        Set set = (Set) this.u.getTag();
        if (set == null || !Arrays.equals(keySet.toArray(), set.toArray())) {
            int childCount = this.u.getChildCount();
            int size = keySet.size();
            Long[] lArr = new Long[size];
            keySet.toArray(lArr);
            this.u.setTag(keySet);
            for (int i = 0; i < size; i++) {
                int i2 = (childCount - i) - 1;
                if (i2 >= 0) {
                    long longValue = lArr[i].longValue();
                    View childAt = this.u.getChildAt(i2);
                    childAt.setTag(Long.valueOf(longValue));
                    ((FrescoThumbnailView) childAt.findViewById(a.f.iv_pk_icon)).bV(linkedHashMap.get(Long.valueOf(longValue)), tv.chushou.widget.a.c.dRB());
                } else {
                    return;
                }
            }
        }
    }

    private void c(LinkedHashMap<Long, String> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            s();
            return;
        }
        Set<Long> keySet = linkedHashMap.keySet();
        Set set = (Set) this.mVL.getTag();
        if (set == null || !Arrays.equals(keySet.toArray(), set.toArray())) {
            int childCount = this.mVL.getChildCount();
            this.mVL.setTag(keySet);
            int size = keySet.size();
            Long[] lArr = new Long[size];
            keySet.toArray(lArr);
            for (int i = 0; i < size; i++) {
                long longValue = lArr[i].longValue();
                String str = linkedHashMap.get(Long.valueOf(longValue));
                if (i < childCount) {
                    View childAt = this.mVL.getChildAt(i);
                    childAt.setTag(Long.valueOf(longValue));
                    ((FrescoThumbnailView) childAt.findViewById(a.f.iv_pk_icon)).bV(str, tv.chushou.widget.a.c.dRB());
                } else {
                    return;
                }
            }
        }
    }

    private void r() {
        int childCount = this.u.getChildCount();
        this.u.setTag(null);
        for (int i = 0; i < childCount; i++) {
            View childAt = this.u.getChildAt(i);
            childAt.setTag(null);
            ((FrescoThumbnailView) childAt.findViewById(a.f.iv_pk_icon)).yE(a.e.icon_live_pk_watcher_avatar_init);
            ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setVisibility(0);
            childAt.findViewById(a.f.iv_pk_mvp).setVisibility(8);
        }
    }

    private void s() {
        int childCount = this.mVL.getChildCount();
        this.mVL.setTag(null);
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mVL.getChildAt(i);
            childAt.setTag(null);
            ((FrescoThumbnailView) childAt.findViewById(a.f.iv_pk_icon)).yE(a.e.icon_live_pk_watcher_avatar_init);
            ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setVisibility(0);
            childAt.findViewById(a.f.iv_pk_mvp).setVisibility(8);
        }
    }

    private void setLeftUserBg(boolean z) {
        int i = z ? a.e.pk_live_pk_watcher_bg_fail : a.e.pk_live_pk_watcher_bg_local;
        int i2 = z ? a.e.pk_live_pk_watcher_tag_bg_fail : a.e.pk_live_pk_watcher_tag_bg_local;
        int childCount = this.u.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.u.getChildAt(i3);
            childAt.findViewById(a.f.view_pk_border).setBackgroundResource(i);
            ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setBackgroundResource(i2);
        }
    }

    private void setRightUserBg(boolean z) {
        int i = z ? a.e.pk_live_pk_watcher_bg_fail : a.e.pk_live_pk_watcher_bg_remote;
        int i2 = z ? a.e.pk_live_pk_watcher_tag_bg_fail : a.e.pk_live_pk_watcher_tag_bg_remote;
        int childCount = this.mVL.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mVL.getChildAt(i3);
            childAt.findViewById(a.f.view_pk_border).setBackgroundResource(i);
            ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setBackgroundResource(i2);
        }
    }

    private void t() {
        r();
        s();
        setLeftUserBg(false);
        setRightUserBg(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.o) {
            if (this.mWd != null) {
                this.mWd.a();
            }
        } else if (view == this.E) {
            if (this.mWd != null) {
                this.mWd.b();
            }
        } else if (view == this.u) {
            if (this.mWd != null) {
                this.mWd.A(0L, 0);
            }
        } else if (view == this.mVL) {
            if (this.mWd != null) {
                this.mWd.A(0L, 1);
            }
        } else if (view == this.mVV && this.mWd != null) {
            this.mWd.c();
        }
    }

    public void setClickListener(a aVar) {
        this.mWd = aVar;
    }

    public void setCounterListener(b bVar) {
        this.mWe = bVar;
    }
}
