package com.kascend.chushou.player.ui.pk;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kascend.chushou.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class LivePKResultView extends LinearLayout {
    private FrameLayout a;
    private ImageView b;
    private View c;
    private ImageView d;
    private LinearLayout e;
    private ImageView g;
    private View h;
    private ImageView i;
    private LinearLayout j;
    private FrameLayout k;
    private ImageView l;
    private ImageView m;
    private LinearLayout n;
    private FrameLayout nCu;
    private Set<AnimatorSet> nCv;
    private Set<c> nCw;
    private a nCx;
    private float o;
    private float p;
    private float q;
    private float r;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public LivePKResultView(Context context) {
        super(context);
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = -1.0f;
        this.nCv = new HashSet();
        this.nCw = new HashSet();
        a(context);
    }

    public LivePKResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = -1.0f;
        this.nCv = new HashSet();
        this.nCw = new HashSet();
        a(context);
    }

    public LivePKResultView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = -1.0f;
        this.nCv = new HashSet();
        this.nCw = new HashSet();
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        clearAnimation();
        super.onDetachedFromWindow();
    }

    private void a(Context context) {
        inflate(context, a.h.layout_live_view_online_live_pk_result, this);
        this.a = (FrameLayout) findViewById(a.f.fl_live_pk_result_left);
        this.nCu = (FrameLayout) findViewById(a.f.fl_live_pk_result_right);
        this.k = (FrameLayout) findViewById(a.f.fl_live_pk_result_mid);
        this.b = (ImageView) findViewById(a.f.iv_pk_left_icon);
        this.c = findViewById(a.f.iv_pk_left_anchor);
        this.g = (ImageView) findViewById(a.f.iv_pk_right_icon);
        this.h = findViewById(a.f.iv_pk_right_anchor);
        this.d = (ImageView) findViewById(a.f.iv_pk_left_bg);
        this.i = (ImageView) findViewById(a.f.iv_pk_right_bg);
        this.e = (LinearLayout) findViewById(a.f.ll_pk_left_cloud_bg);
        this.j = (LinearLayout) findViewById(a.f.ll_pk_right_cloud_bg);
        this.l = (ImageView) findViewById(a.f.iv_pk_mid_icon);
        this.m = (ImageView) findViewById(a.f.iv_pk_mid_bg);
        this.n = (LinearLayout) findViewById(a.f.ll_pk_mid_cloud_bg);
    }

    public void a(boolean z) {
        a(z, true);
    }

    public void a(final boolean z, final boolean z2) {
        Animator animator;
        setVisibility(0);
        this.a.setVisibility(0);
        this.nCu.setVisibility(0);
        this.k.setVisibility(8);
        c();
        if (getWidth() <= 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKResultView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        LivePKResultView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    LivePKResultView.this.a(z, z2);
                }
            });
            return;
        }
        if (z) {
            Animator a2 = a(this.b, this.d, this.e, this.c, z2);
            b(this.g, this.i, this.j, this.h, z2);
            animator = a2;
        } else {
            Animator a3 = a(this.g, this.i, this.j, this.h, z2);
            b(this.b, this.d, this.e, this.c, z2);
            animator = a3;
        }
        if (animator != null) {
            animator.addListener(new g() { // from class: com.kascend.chushou.player.ui.pk.LivePKResultView.2
                @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (LivePKResultView.this.nCx != null) {
                        LivePKResultView.this.nCx.a();
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    if (LivePKResultView.this.nCx != null) {
                        LivePKResultView.this.nCx.a();
                    }
                }
            });
        } else if (this.nCx != null) {
            this.nCx.a();
        }
    }

    public void a() {
        b(true);
    }

    public void b(final boolean z) {
        setVisibility(0);
        this.a.setVisibility(0);
        this.nCu.setVisibility(0);
        this.k.setVisibility(8);
        c();
        if (getWidth() <= 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKResultView.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        LivePKResultView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    LivePKResultView.this.b(z);
                }
            });
            return;
        }
        Animator a2 = a(this.b, a.e.icon_live_view_pk_result_tie, this.d, this.e, this.c, z);
        a(this.g, a.e.icon_live_view_pk_result_tie, this.i, this.j, this.h, z);
        if (a2 != null) {
            a2.addListener(new g() { // from class: com.kascend.chushou.player.ui.pk.LivePKResultView.4
                @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (LivePKResultView.this.nCx != null) {
                        LivePKResultView.this.nCx.a();
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    if (LivePKResultView.this.nCx != null) {
                        LivePKResultView.this.nCx.a();
                    }
                }
            });
        } else if (this.nCx != null) {
            this.nCx.a();
        }
    }

    public void b() {
        c();
        this.a.setVisibility(8);
        this.nCu.setVisibility(8);
        this.k.setVisibility(8);
        setVisibility(8);
    }

    private Animator a(ImageView imageView, ImageView imageView2, LinearLayout linearLayout, View view, boolean z) {
        return a(imageView, a.e.icon_live_view_pk_result_victory, imageView2, linearLayout, view, z);
    }

    private Animator a(ImageView imageView, int i, ImageView imageView2, LinearLayout linearLayout, View view, boolean z) {
        imageView.setImageResource(i);
        linearLayout.setVisibility(4);
        imageView2.setVisibility(4);
        Animator a2 = a(imageView, view, z);
        if (z) {
            c cVar = new c(imageView2, new int[]{a.e.icon_live_view_pk_result_victory_star_bg_0, a.e.icon_live_view_pk_result_victory_star_bg_1, a.e.icon_live_view_pk_result_victory_star_bg_2, a.e.icon_live_view_pk_result_victory_star_bg_3, a.e.icon_live_view_pk_result_victory_star_bg_4, a.e.icon_live_view_pk_result_victory_star_bg_5, a.e.icon_live_view_pk_result_victory_star_bg_6, a.e.icon_live_view_pk_result_victory_star_bg_7, a.e.icon_live_view_pk_result_victory_star_bg_8, a.e.icon_live_view_pk_result_victory_star_bg_9, a.e.icon_live_view_pk_result_victory_star_bg_10, a.e.icon_live_view_pk_result_victory_star_bg_11, a.e.icon_live_view_pk_result_victory_star_bg_12}, 1, 240L);
            cVar.a(new d() { // from class: com.kascend.chushou.player.ui.pk.LivePKResultView.5
                @Override // com.kascend.chushou.player.ui.pk.d
                public void a(c cVar2) {
                }

                @Override // com.kascend.chushou.player.ui.pk.d
                public void b(c cVar2) {
                }

                @Override // com.kascend.chushou.player.ui.pk.d
                public void c(c cVar2) {
                    cVar2.b();
                }
            });
            e.dOn().a(cVar, 840L);
            this.nCw.add(cVar);
        }
        return a2;
    }

    private Animator b(ImageView imageView, ImageView imageView2, LinearLayout linearLayout, View view, boolean z) {
        imageView.setImageResource(a.e.icon_live_view_pk_result_defeat);
        linearLayout.setVisibility(4);
        imageView2.setVisibility(4);
        Animator a2 = a(imageView, view, z);
        if (z) {
            linearLayout.setVisibility(0);
            int childCount = linearLayout.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(i);
                if (childAt instanceof ImageView) {
                    childAt.setVisibility(0);
                    childAt.setAlpha(0.0f);
                    arrayList.add(childAt);
                }
            }
            a((View) arrayList.get(0), 0.7f, 720L);
            a((View) arrayList.get(1), 0.5f, 800L);
            a((View) arrayList.get(2), 0.6f, 760L, false);
        }
        return a2;
    }

    public void c() {
        if (this.o <= 0.0f) {
            this.o = this.b.getX();
        }
        if (this.p <= 0.0f) {
            this.p = this.b.getY();
        }
        if (this.q <= 0.0f) {
            this.q = this.g.getX();
        }
        if (this.r <= 0.0f) {
            this.r = this.g.getY();
        }
        clearAnimation();
        this.d.setVisibility(4);
        this.i.setVisibility(4);
        this.e.setVisibility(4);
        this.j.setVisibility(4);
        tv.chushou.zues.toolkit.d.b.setScaleX(this.b, 1.0f);
        tv.chushou.zues.toolkit.d.b.setScaleY(this.b, 1.0f);
        tv.chushou.zues.toolkit.d.b.setScaleX(this.g, 1.0f);
        tv.chushou.zues.toolkit.d.b.setScaleY(this.g, 1.0f);
        tv.chushou.zues.toolkit.d.b.setX(this.b, this.o);
        tv.chushou.zues.toolkit.d.b.setY(this.b, this.p);
        tv.chushou.zues.toolkit.d.b.setX(this.g, this.q);
        tv.chushou.zues.toolkit.d.b.setY(this.g, this.r);
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        for (c cVar : this.nCw) {
            e.dOn().c(cVar);
        }
        this.nCw.clear();
        for (AnimatorSet animatorSet : this.nCv) {
            animatorSet.cancel();
        }
        this.nCv.clear();
    }

    private Animator a(ImageView imageView, View view, boolean z) {
        float x = (view.getX() - imageView.getX()) - ((imageView.getMeasuredWidth() * 0.5f) / 2.0f);
        float y = (view.getY() - imageView.getY()) - ((imageView.getMeasuredHeight() * 0.5f) / 2.0f);
        if (z) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("scaleX", 0.3f, 1.2f), PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1.2f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            ofPropertyValuesHolder.setDuration(400L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("scaleX", 1.2f, 1.0f, 1.1f, 1.0f, 1.02f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.2f, 1.0f, 1.1f, 1.0f, 1.02f, 1.0f));
            ofPropertyValuesHolder2.setInterpolator(new LinearInterpolator());
            ofPropertyValuesHolder2.setDuration(600L);
            ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f), PropertyValuesHolder.ofFloat("translationX", 0.0f, x), PropertyValuesHolder.ofFloat("translationY", 0.0f, y));
            ofPropertyValuesHolder3.setInterpolator(new LinearInterpolator());
            ofPropertyValuesHolder3.setDuration(400L);
            ofPropertyValuesHolder3.setStartDelay(1480L);
            ObjectAnimator ofPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("scaleX", 0.5f, 0.55f, 0.5f, 0.52f, 0.5f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 0.55f, 0.5f, 0.52f, 0.5f));
            ofPropertyValuesHolder4.setInterpolator(new LinearInterpolator());
            ofPropertyValuesHolder4.setDuration(320L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder4);
            animatorSet.start();
            this.nCv.add(animatorSet);
            return animatorSet;
        }
        tv.chushou.zues.toolkit.d.b.setScaleX(imageView, 0.5f);
        tv.chushou.zues.toolkit.d.b.setScaleY(imageView, 0.5f);
        tv.chushou.zues.toolkit.d.b.setTranslationX(imageView, x);
        tv.chushou.zues.toolkit.d.b.setTranslationY(imageView, y);
        return null;
    }

    private AnimatorSet a(View view, float f, long j) {
        return a(view, f, j, true);
    }

    private AnimatorSet a(View view, float f, long j, boolean z) {
        float measuredWidth = view.getMeasuredWidth() * f;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        float[] fArr = new float[2];
        fArr[0] = 0.0f;
        fArr[1] = z ? measuredWidth : -measuredWidth;
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat("translationX", fArr);
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat("alpha", 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
        ofPropertyValuesHolder.setStartDelay(j);
        ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder.setDuration(600L);
        float[] fArr2 = new float[2];
        if (!z) {
            measuredWidth = -measuredWidth;
        }
        fArr2[0] = measuredWidth;
        fArr2[1] = 0.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", fArr2);
        ofFloat.setStartDelay(240L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(600L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setDuration(80L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofPropertyValuesHolder, ofFloat, ofFloat2);
        animatorSet.start();
        this.nCv.add(animatorSet);
        return animatorSet;
    }

    public void d() {
        a(0);
    }

    public void c(boolean z) {
        a(z ? 1 : -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        setVisibility(0);
        this.a.setVisibility(8);
        this.nCu.setVisibility(8);
        this.k.setVisibility(0);
        e();
        if (getWidth() <= 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKResultView.6
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        LivePKResultView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    LivePKResultView.this.a(i);
                }
            });
        } else {
            a(i, this.l, this.m, this.n);
        }
    }

    private void e() {
        clearAnimation();
        this.m.setVisibility(4);
        this.n.setVisibility(4);
        tv.chushou.zues.toolkit.d.b.setScaleX(this.l, 1.0f);
        tv.chushou.zues.toolkit.d.b.setScaleY(this.l, 1.0f);
    }

    private void a(int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout) {
        if (i == 1 || i == 0) {
            if (i == 1) {
                imageView.setImageResource(a.e.icon_live_view_pk_result_victory);
            } else {
                imageView.setImageResource(a.e.icon_live_view_pk_result_tie);
            }
            linearLayout.setVisibility(4);
            imageView2.setVisibility(4);
            d(imageView);
            c cVar = new c(imageView2, new int[]{a.e.icon_live_view_pk_result_victory_star_bg_0, a.e.icon_live_view_pk_result_victory_star_bg_1, a.e.icon_live_view_pk_result_victory_star_bg_2, a.e.icon_live_view_pk_result_victory_star_bg_3, a.e.icon_live_view_pk_result_victory_star_bg_4, a.e.icon_live_view_pk_result_victory_star_bg_5, a.e.icon_live_view_pk_result_victory_star_bg_6, a.e.icon_live_view_pk_result_victory_star_bg_7, a.e.icon_live_view_pk_result_victory_star_bg_8, a.e.icon_live_view_pk_result_victory_star_bg_9, a.e.icon_live_view_pk_result_victory_star_bg_10, a.e.icon_live_view_pk_result_victory_star_bg_11, a.e.icon_live_view_pk_result_victory_star_bg_12}, 1, 240L);
            cVar.a(new d() { // from class: com.kascend.chushou.player.ui.pk.LivePKResultView.7
                @Override // com.kascend.chushou.player.ui.pk.d
                public void a(c cVar2) {
                }

                @Override // com.kascend.chushou.player.ui.pk.d
                public void b(c cVar2) {
                }

                @Override // com.kascend.chushou.player.ui.pk.d
                public void c(c cVar2) {
                    cVar2.b();
                    LivePKResultView.this.setVisibility(8);
                    if (LivePKResultView.this.nCx != null) {
                        LivePKResultView.this.nCx.a();
                    }
                }
            });
            e.dOn().a(cVar, 840L);
            this.nCw.add(cVar);
            return;
        }
        imageView.setImageResource(a.e.icon_live_view_pk_result_defeat);
        linearLayout.setVisibility(4);
        imageView2.setVisibility(4);
        d(imageView);
        linearLayout.setVisibility(0);
        int childCount = linearLayout.getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = linearLayout.getChildAt(i2);
            if (childAt instanceof ImageView) {
                childAt.setVisibility(0);
                childAt.setAlpha(0.0f);
                arrayList.add(childAt);
            }
        }
        a((View) arrayList.get(0), 0.7f, 720L);
        AnimatorSet a2 = a((View) arrayList.get(1), 0.5f, 800L);
        a((View) arrayList.get(2), 0.6f, 760L, false);
        if (a2 != null) {
            a2.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.ui.pk.LivePKResultView.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    LivePKResultView.this.setVisibility(8);
                    if (LivePKResultView.this.nCx != null) {
                        LivePKResultView.this.nCx.a();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    LivePKResultView.this.setVisibility(8);
                    if (LivePKResultView.this.nCx != null) {
                        LivePKResultView.this.nCx.a();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
        } else if (this.nCx != null) {
            this.nCx.a();
        }
    }

    private Animator d(ImageView imageView) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("scaleX", 0.3f, 1.2f), PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1.2f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder.setDuration(400L);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("scaleX", 1.2f, 1.0f, 1.1f, 1.0f, 1.02f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.2f, 1.0f, 1.1f, 1.0f, 1.02f, 1.0f));
        ofPropertyValuesHolder2.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder2.setDuration(600L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
        animatorSet.start();
        this.nCv.add(animatorSet);
        return animatorSet;
    }

    public void setCallback(a aVar) {
        this.nCx = aVar;
    }
}
