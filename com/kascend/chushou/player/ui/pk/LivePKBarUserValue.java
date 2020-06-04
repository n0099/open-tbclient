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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class LivePKBarUserValue extends RelativeLayout implements View.OnClickListener {
    private LinearLayout A;
    private TextView B;
    private long a;
    private long b;
    private double c;
    private double d;
    private float e;
    private View f;
    private View g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private LinearLayout k;
    private LinearLayout l;
    private ImageView m;
    private LinearLayout mWW;
    private FrescoThumbnailView mXA;
    private c mXB;
    private io.reactivex.disposables.b mXC;
    private AnimatorSet mXD;
    private a mXE;
    private RelativeLayout mXa;
    private LinearLayout mXy;
    private RelativeLayout mXz;
    private ImageView n;
    private ImageView o;
    private View r;
    private View s;
    private RelativeLayout t;
    private TextView u;
    private TextView w;
    private TextView x;
    private TextView y;

    /* loaded from: classes5.dex */
    public interface a {
        void A(long j, int i);

        void a();

        void b();
    }

    public LivePKBarUserValue(Context context) {
        super(context);
        this.a = 0L;
        this.b = 0L;
        this.c = 1.0d;
        this.d = 1.0d;
        this.e = 0.2f;
        a(context);
    }

    public LivePKBarUserValue(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0L;
        this.b = 0L;
        this.c = 1.0d;
        this.d = 1.0d;
        this.e = 0.2f;
        a(context);
    }

    public LivePKBarUserValue(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0L;
        this.b = 0L;
        this.c = 1.0d;
        this.d = 1.0d;
        this.e = 0.2f;
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        f();
        super.onDetachedFromWindow();
    }

    private void a(Context context) {
        inflate(context, a.h.layout_online_live_pk_bar_user_value, this);
        this.f = findViewById(a.f.view_pk_left);
        this.g = findViewById(a.f.view_pk_right);
        this.h = (ImageView) findViewById(a.f.live_pk_bar_crit_line);
        this.i = (TextView) findViewById(a.f.tv_pk_left_value);
        this.j = (TextView) findViewById(a.f.tv_pk_right_value);
        this.k = (LinearLayout) findViewById(a.f.ll_pk_left_users);
        this.l = (LinearLayout) findViewById(a.f.ll_pk_right_users);
        this.m = (ImageView) findViewById(a.f.iv_pk_left_fire_ball);
        this.n = (ImageView) findViewById(a.f.iv_pk_right_fire_ball);
        this.o = (ImageView) findViewById(a.f.iv_pk_fire_ball_bang);
        this.mXy = (LinearLayout) findViewById(a.f.ll_pk_energy_bar);
        this.mXz = (RelativeLayout) findViewById(a.f.ll_pk_energy_bar_animation);
        this.r = findViewById(a.f.view_pk_left_animation);
        this.s = findViewById(a.f.view_pk_right_animation);
        this.t = (RelativeLayout) findViewById(a.f.rl_live_pk_rule);
        this.u = (TextView) findViewById(a.f.tv_pk_rule);
        this.mWW = (LinearLayout) findViewById(a.f.ll_live_pk_addition_notice);
        this.w = (TextView) findViewById(a.f.tv_live_pk_addition_notice);
        this.x = (TextView) findViewById(a.f.tv_live_pk_addition_countdown);
        this.u.setVisibility(8);
        this.u.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.y = (TextView) findViewById(a.f.tv_combat_crunchies);
        this.mXa = (RelativeLayout) findViewById(a.f.rl_live_pk);
        this.A = (LinearLayout) findViewById(a.f.ll_live_destiny);
        this.B = (TextView) findViewById(a.f.tv_promotion);
        this.mXA = (FrescoThumbnailView) findViewById(a.f.iv_destiny);
        this.y.setVisibility(8);
        this.y.setOnClickListener(this);
        for (int i = 0; i < 4; i++) {
            inflate(getContext(), a.h.layout_pk_view_online_live_pk_bar_user_item, this.k);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            inflate(getContext(), a.h.layout_pk_view_online_live_pk_bar_user_item, this.l);
        }
        int childCount = this.k.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((TextView) this.k.getChildAt(i3).findViewById(a.f.tv_pk_ranking)).setText(String.valueOf(childCount - i3));
        }
        int childCount2 = this.l.getChildCount();
        for (int i4 = 0; i4 < childCount2; i4++) {
            ((TextView) this.l.getChildAt(i4).findViewById(a.f.tv_pk_ranking)).setText(String.valueOf(i4 + 1));
        }
        setLeftUserBg(false);
        setRightUserBg(false);
    }

    public void a() {
        f();
        setVisibility(8);
    }

    public void a(LinkedHashMap<Long, String> linkedHashMap, LinkedHashMap<Long, String> linkedHashMap2) {
        a(linkedHashMap);
        c(linkedHashMap2);
    }

    public void a(long j) {
        k();
        d(j);
    }

    public void b(long j) {
        l();
        c(j);
    }

    public void a(int i, String str, String str2) {
        if (i == 2) {
            this.m.setImageDrawable(getResources().getDrawable(a.e.pk_live_online_live_destiny_bar_fire_ball_left));
            this.n.setImageDrawable(getResources().getDrawable(a.e.pk_live_online_live_destiny_bar_fire_ball_right));
            this.f.setBackgroundResource(a.e.pk_live_online_live_destiny_bar_yellow);
            this.g.setBackgroundResource(a.e.pk_live_online_live_destiny_bar_green);
            this.r.setBackgroundResource(a.e.pk_live_online_live_destiny_bar_yellow);
            this.s.setBackgroundResource(a.e.pk_live_online_live_destiny_bar_green);
            this.B.setText(str2);
            this.mXA.bV(str, a.e.icon_live_destiny_promotion);
            this.A.setVisibility(0);
            this.mXa.setVisibility(8);
            return;
        }
        this.m.setImageDrawable(getResources().getDrawable(a.e.pk_live_online_live_pk_bar_fire_ball_left));
        this.n.setImageDrawable(getResources().getDrawable(a.e.pk_live_online_live_pk_bar_fire_ball_right));
        this.f.setBackgroundResource(a.e.pk_live_online_live_pk_bar_purple);
        this.g.setBackgroundResource(a.e.pk_live_online_live_pk_bar_blue);
        this.r.setBackgroundResource(a.e.pk_live_online_live_pk_bar_purple);
        this.s.setBackgroundResource(a.e.pk_live_online_live_pk_bar_blue);
        this.A.setVisibility(8);
        this.mXa.setVisibility(0);
    }

    private void f() {
        o();
        g();
        c();
        d();
    }

    public void a(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.e = f;
        }
    }

    private void g() {
        this.i.setText("0");
        this.j.setText("0");
        ((LinearLayout.LayoutParams) this.g.getLayoutParams()).weight = 1.0f;
        ((LinearLayout.LayoutParams) this.f.getLayoutParams()).weight = 1.0f;
        this.a = 0L;
        this.b = 0L;
        this.c = 1.0d;
        this.d = 1.0d;
    }

    public void a(long j, long j2) {
        if (j != this.a || j2 != this.b) {
            if (j == 0 && j2 == 0) {
                this.i.setText("0");
                this.j.setText("0");
                ((LinearLayout.LayoutParams) this.g.getLayoutParams()).weight = 1.0f;
                ((LinearLayout.LayoutParams) this.f.getLayoutParams()).weight = 1.0f;
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
            ((LinearLayout.LayoutParams) this.f.getLayoutParams()).weight = (float) this.c;
            ((LinearLayout.LayoutParams) this.g.getLayoutParams()).weight = (float) this.d;
            this.i.setText(String.valueOf(j));
            this.j.setText(String.valueOf(j2));
            this.a = j;
            this.b = j2;
            j();
        }
    }

    public void b() {
        this.m.clearAnimation();
        this.n.clearAnimation();
        this.o.clearAnimation();
        this.s.clearAnimation();
        this.r.clearAnimation();
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth <= 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        LivePKBarUserValue.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    LivePKBarUserValue.this.b();
                }
            });
            return;
        }
        float f = ((LinearLayout.LayoutParams) this.g.getLayoutParams()).weight;
        float f2 = ((LinearLayout.LayoutParams) this.f.getLayoutParams()).weight;
        float f3 = f + f2;
        float f4 = f / f3;
        this.o.setVisibility(4);
        final float f5 = (f2 / f3) * measuredWidth;
        final float f6 = measuredWidth - f5;
        this.m.setVisibility(0);
        final float measuredWidth2 = this.m.getMeasuredWidth();
        final float dip2px = (f5 - measuredWidth2) + tv.chushou.zues.utils.a.dip2px(getContext(), 15.0f);
        h();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.m, "translationX", -measuredWidth2, dip2px);
        ofFloat.setDuration(800L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = ((int) ((Float) valueAnimator.getAnimatedValue()).floatValue()) + ((int) (measuredWidth2 / 2.0f));
                if (floatValue < 0) {
                    floatValue = 0;
                }
                LivePKBarUserValue.this.r.getLayoutParams().width = floatValue;
                LivePKBarUserValue.this.r.requestLayout();
            }
        });
        ofFloat.addListener(new g() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.3
            @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                LivePKBarUserValue.this.n.setVisibility(0);
                final Animation loadAnimation = AnimationUtils.loadAnimation(LivePKBarUserValue.this.getContext(), a.C0795a.pk_live_online_live_fire_ball_bang_anim);
                LivePKBarUserValue.this.postDelayed(new Runnable() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LivePKBarUserValue.this.m.startAnimation(loadAnimation);
                        LivePKBarUserValue.this.n.startAnimation(loadAnimation);
                    }
                }, 440L);
                LivePKBarUserValue.this.postDelayed(new Runnable() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LivePKBarUserValue.this.i();
                        LivePKBarUserValue.this.mXy.setVisibility(0);
                        LivePKBarUserValue.this.mXz.setVisibility(4);
                    }
                }, 760L);
                LivePKBarUserValue.this.o.setVisibility(0);
                tv.chushou.zues.toolkit.d.b.setTranslationX(LivePKBarUserValue.this.o, dip2px);
                LivePKBarUserValue.this.postDelayed(new Runnable() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.3.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LivePKBarUserValue.this.o.startAnimation(loadAnimation);
                        LivePKBarUserValue.this.r.getLayoutParams().width = (int) f5;
                        LivePKBarUserValue.this.r.requestLayout();
                        LivePKBarUserValue.this.s.getLayoutParams().width = (int) f6;
                        LivePKBarUserValue.this.s.requestLayout();
                    }
                }, 440L);
            }
        });
        ofFloat.start();
        final float measuredWidth3 = this.n.getMeasuredWidth();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.n, "translationX", measuredWidth3, -((f6 - measuredWidth3) + tv.chushou.zues.utils.a.dip2px(getContext(), 15.0f)));
        ofFloat2.setDuration(800L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i = (-((int) ((Float) valueAnimator.getAnimatedValue()).floatValue())) + ((int) (measuredWidth3 / 2.0f));
                if (i < 0) {
                    i = 0;
                }
                LivePKBarUserValue.this.s.getLayoutParams().width = i;
                LivePKBarUserValue.this.s.requestLayout();
            }
        });
        ofFloat2.start();
    }

    private void h() {
        ((AnimationDrawable) this.m.getDrawable()).start();
        ((AnimationDrawable) this.n.getDrawable()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ((AnimationDrawable) this.m.getDrawable()).stop();
        ((AnimationDrawable) this.n.getDrawable()).stop();
    }

    public void c() {
        if (this.mXB != null) {
            e.dGh().c(this.mXB);
        }
        this.h.setVisibility(4);
    }

    private void j() {
        int width = getWidth();
        if (width <= 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        LivePKBarUserValue.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    if (LivePKBarUserValue.this.h != null) {
                        int width2 = (int) (((LivePKBarUserValue.this.getWidth() * LivePKBarUserValue.this.c) / (LivePKBarUserValue.this.c + LivePKBarUserValue.this.d)) - tv.chushou.widget.a.c.B(3.5f));
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) LivePKBarUserValue.this.h.getLayoutParams();
                        layoutParams.leftMargin = width2;
                        LivePKBarUserValue.this.h.setLayoutParams(layoutParams);
                    }
                }
            });
            return;
        }
        int B = (int) (((width * this.c) / (this.c + this.d)) - tv.chushou.widget.a.c.B(3.5f));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.leftMargin = B;
        this.h.setLayoutParams(layoutParams);
    }

    public void c(float f, final int i) {
        if (i > 0) {
            this.t.setVisibility(4);
            this.mWW.setVisibility(0);
            this.w.setText(((int) (100.0f * f)) + getContext().getResources().getString(a.i.str_live_across_pk_chat_notice_addition));
            this.mXC = io.reactivex.g.a(0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dKM()).b(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = i - l.longValue();
                    if (longValue > 0) {
                        LivePKBarUserValue.this.x.setText(longValue + "s");
                    } else {
                        LivePKBarUserValue.this.d();
                    }
                }
            });
            ValueAnimator ofInt = ValueAnimator.ofInt(0, tv.chushou.zues.utils.a.dip2px(getContext(), 52.0f));
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LivePKBarUserValue.this.mWW.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    LivePKBarUserValue.this.mWW.requestLayout();
                }
            });
            this.mXD = new AnimatorSet();
            this.mXD.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarUserValue.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }
            });
            this.mXD.playTogether(ofInt);
            this.mXD.setInterpolator(new LinearInterpolator());
            this.mXD.setDuration(1000L);
            this.mXD.start();
        }
    }

    public void d() {
        if (this.mXC != null) {
            this.mXC.dispose();
            this.mXC = null;
        }
        if (this.mXD != null) {
            this.mXD.cancel();
            this.mXD = null;
        }
        this.mWW.setVisibility(8);
        this.t.setVisibility(0);
    }

    public void e() {
        a(1);
    }

    public void a(int i) {
        if (i == 2) {
            this.u.setVisibility(8);
            this.y.setVisibility(0);
            return;
        }
        this.u.setVisibility(0);
        this.y.setVisibility(8);
    }

    private void k() {
        setLeftUserBg(true);
    }

    private void l() {
        setRightUserBg(true);
    }

    private void c(long j) {
        if (j >= 0) {
            int childCount = this.k.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.k.getChildAt(i);
                Long l = (Long) childAt.getTag();
                if (l != null && l.longValue() == j) {
                    ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setVisibility(8);
                    childAt.findViewById(a.f.iv_pk_mvp).setVisibility(0);
                    return;
                }
            }
        }
    }

    private void d(long j) {
        if (j >= 0) {
            int childCount = this.l.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.l.getChildAt(i);
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
            m();
            return;
        }
        Set<Long> keySet = linkedHashMap.keySet();
        Set set = (Set) this.k.getTag();
        if (set == null || !Arrays.equals(keySet.toArray(), set.toArray())) {
            int childCount = this.k.getChildCount();
            int size = keySet.size();
            Long[] lArr = new Long[size];
            keySet.toArray(lArr);
            this.k.setTag(keySet);
            for (int i = 0; i < size; i++) {
                int i2 = (childCount - i) - 1;
                if (i2 >= 0) {
                    long longValue = lArr[i].longValue();
                    View childAt = this.k.getChildAt(i2);
                    childAt.setTag(Long.valueOf(longValue));
                    ((FrescoThumbnailView) childAt.findViewById(a.f.iv_pk_icon)).bV(linkedHashMap.get(Long.valueOf(longValue)), tv.chushou.widget.a.c.dRP());
                } else {
                    return;
                }
            }
        }
    }

    private void c(LinkedHashMap<Long, String> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            n();
            return;
        }
        Set<Long> keySet = linkedHashMap.keySet();
        Set set = (Set) this.l.getTag();
        if (set == null || !Arrays.equals(keySet.toArray(), set.toArray())) {
            int childCount = this.l.getChildCount();
            this.l.setTag(keySet);
            int size = keySet.size();
            Long[] lArr = new Long[size];
            keySet.toArray(lArr);
            for (int i = 0; i < size; i++) {
                long longValue = lArr[i].longValue();
                String str = linkedHashMap.get(Long.valueOf(longValue));
                if (i < childCount) {
                    View childAt = this.l.getChildAt(i);
                    childAt.setTag(Long.valueOf(longValue));
                    ((FrescoThumbnailView) childAt.findViewById(a.f.iv_pk_icon)).bV(str, tv.chushou.widget.a.c.dRP());
                } else {
                    return;
                }
            }
        }
    }

    private void m() {
        int childCount = this.k.getChildCount();
        this.k.setTag(null);
        for (int i = 0; i < childCount; i++) {
            View childAt = this.k.getChildAt(i);
            childAt.setTag(null);
            ((FrescoThumbnailView) childAt.findViewById(a.f.iv_pk_icon)).yG(a.e.icon_live_pk_watcher_avatar_init);
            ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setVisibility(0);
            childAt.findViewById(a.f.iv_pk_mvp).setVisibility(8);
        }
    }

    private void n() {
        int childCount = this.l.getChildCount();
        this.l.setTag(null);
        for (int i = 0; i < childCount; i++) {
            View childAt = this.l.getChildAt(i);
            childAt.setTag(null);
            ((FrescoThumbnailView) childAt.findViewById(a.f.iv_pk_icon)).yG(a.e.icon_live_pk_watcher_avatar_init);
            ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setVisibility(0);
            childAt.findViewById(a.f.iv_pk_mvp).setVisibility(8);
        }
    }

    private void setLeftUserBg(boolean z) {
        int i = z ? a.e.pk_live_pk_watcher_bg_fail : a.e.pk_live_pk_watcher_bg_local;
        int i2 = z ? a.e.pk_live_pk_watcher_tag_bg_fail : a.e.pk_live_pk_watcher_tag_bg_local;
        int childCount = this.k.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.k.getChildAt(i3);
            childAt.findViewById(a.f.view_pk_border).setBackgroundResource(i);
            ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setBackgroundResource(i2);
        }
    }

    private void setRightUserBg(boolean z) {
        int i = z ? a.e.pk_live_pk_watcher_bg_fail : a.e.pk_live_pk_watcher_bg_remote;
        int i2 = z ? a.e.pk_live_pk_watcher_tag_bg_fail : a.e.pk_live_pk_watcher_tag_bg_remote;
        int childCount = this.l.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.l.getChildAt(i3);
            childAt.findViewById(a.f.view_pk_border).setBackgroundResource(i);
            ((TextView) childAt.findViewById(a.f.tv_pk_ranking)).setBackgroundResource(i2);
        }
    }

    private void o() {
        m();
        n();
        setLeftUserBg(false);
        setRightUserBg(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.u) {
            if (this.mXE != null) {
                this.mXE.a();
            }
        } else if (view == this.k) {
            if (this.mXE != null) {
                this.mXE.A(0L, 0);
            }
        } else if (view == this.l) {
            if (this.mXE != null) {
                this.mXE.A(0L, 1);
            }
        } else if (view == this.y && this.mXE != null) {
            this.mXE.b();
        }
    }

    public void setClickListener(a aVar) {
        this.mXE = aVar;
    }
}
