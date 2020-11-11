package com.kascend.chushou.widget.dispalymenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kascend.chushou.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EggacheDisplayView extends ViewGroup {
    private boolean A;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Animator> f4264a;
    private ArrayList<Animator> b;
    private int e;
    private ImageView g;
    private ImageView h;
    private boolean i;
    private int j;
    private AnimatorListenerAdapter pAS;
    private AnimatorListenerAdapter pAT;
    private b pAU;
    private c pAV;
    private d pAW;
    private com.kascend.chushou.widget.dispalymenu.b pAX;
    private AnimatorSet pAY;
    private AnimatorSet pAZ;
    private AnimatorSet pBa;
    private List<View> pBb;
    private List<View> pBc;
    private a pBd;
    private AnimatorSet pzW;
    private int r;
    private int s;
    private boolean t;
    private View u;
    private View v;
    private View w;
    private int x;
    private int y;
    private View z;

    /* loaded from: classes6.dex */
    public enum b {
        LIST,
        LOOP
    }

    /* loaded from: classes6.dex */
    public enum c {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    /* loaded from: classes6.dex */
    public enum d {
        RIGHT_TO_LEFT,
        BOTTOM_TO_TOP
    }

    public EggacheDisplayView(@NonNull Context context) {
        this(context, null);
    }

    public EggacheDisplayView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EggacheDisplayView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pAU = b.LIST;
        this.pAV = c.BOTTOM;
        this.pAW = d.RIGHT_TO_LEFT;
        this.pAY = new AnimatorSet().setDuration(250L);
        this.pAZ = new AnimatorSet().setDuration(250L);
        this.pBa = new AnimatorSet();
        this.r = 2000;
        this.s = 250;
        this.A = true;
        this.pBb = new ArrayList();
        this.pBc = new ArrayList();
        this.pBd = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.EggacheDisplayView, 0, 0);
        this.x = obtainStyledAttributes.getDimensionPixelSize(a.k.EggacheDisplayView_btn_spacing, a(context, 12.0f));
        int resourceId = obtainStyledAttributes.getResourceId(a.k.EggacheDisplayView_collapse_layout, a.h.layout_collapse_button);
        int resourceId2 = obtainStyledAttributes.getResourceId(a.k.EggacheDisplayView_expand_layout, a.h.layout_expand_button);
        this.i = obtainStyledAttributes.getBoolean(a.k.EggacheDisplayView_click_loop_to_expand, false);
        this.y = a(getContext(), 4.0f);
        if (obtainStyledAttributes.getInt(a.k.EggacheDisplayView_list_direction, 0) == 0) {
            this.pAV = c.BOTTOM;
        } else {
            this.pAV = c.TOP;
        }
        obtainStyledAttributes.recycle();
        d(context, resourceId, resourceId2);
    }

    private void d(Context context, int i, int i2) {
        LayoutInflater from = LayoutInflater.from(context);
        this.w = from.inflate(i, (ViewGroup) this, false);
        this.z = from.inflate(i2, (ViewGroup) this, false);
        this.z.setVisibility(8);
        this.g = (ImageView) this.z.findViewById(a.f.iv_arrow_down);
        this.h = (ImageView) this.w.findViewById(a.f.iv_arrow_up);
        addView(this.w);
        addView(this.z);
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.widget.dispalymenu.EggacheDisplayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EggacheDisplayView.this.b();
            }
        });
        this.z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.widget.dispalymenu.EggacheDisplayView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EggacheDisplayView.this.a();
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.widget.dispalymenu.EggacheDisplayView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EggacheDisplayView.this.i && EggacheDisplayView.this.pAU == b.LOOP) {
                    EggacheDisplayView.this.a();
                }
            }
        });
        g();
    }

    public void setListDirection(c cVar) {
        this.pAV = cVar;
        g();
        requestLayout();
    }

    public void setListStrategy(com.kascend.chushou.widget.dispalymenu.b bVar) {
        if (bVar != null) {
            this.pAX = bVar;
            this.pAX.a(this, this.z, this.w, this.x, this.y);
            requestLayout();
        }
    }

    private void g() {
        if (this.pAV == c.TOP) {
            this.pAX = new com.kascend.chushou.widget.dispalymenu.c();
        } else {
            this.pAX = new com.kascend.chushou.widget.dispalymenu.a();
        }
        this.pAX.a(this, this.z, this.w, this.x, this.y);
    }

    public void setMenuViews(List<View> list) {
        if (list != null && !list.isEmpty()) {
            d();
            this.pBb.clear();
            this.pBb.addAll(list);
            removeAllViews();
            addView(this.w);
            addView(this.z);
            for (View view : list) {
                addView(view);
            }
        }
    }

    public void a(List<View> list, int i) {
        if (list != null && !list.isEmpty()) {
            d();
            if (getChildCount() - 2 >= i) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(this.pBb.get(i2));
                }
                this.pBb.clear();
                this.pBb.addAll(arrayList);
                this.pBb.addAll(list);
                int i3 = i + 2;
                removeViews(i3, getChildCount() - i3);
                for (View view : list) {
                    addView(view);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.pBb.clear();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != this.w && childAt != this.z) {
                this.pBb.add(childAt);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        this.e = 0;
        this.j = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                this.e = Math.max(this.e, childAt.getMeasuredWidth());
                this.j = Math.max(this.j, childAt.getMeasuredHeight());
            }
        }
        if (this.pAU == b.LIST) {
            i4 = this.pAX.a(this.j, this.e);
            i3 = this.pAX.b(this.j, this.e);
        } else if (this.pAU == b.LOOP) {
            i4 = this.pAX.c(this.j, this.e);
            i3 = this.pAX.ej(this.j, this.e);
        } else {
            i3 = 0;
        }
        int paddingLeft = i3 + getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom() + i4;
        if (getLayoutParams().width == -1) {
            paddingLeft = getDefaultSize(getSuggestedMinimumWidth(), i);
        }
        if (getLayoutParams().height == -1) {
            paddingTop = getDefaultSize(getSuggestedMinimumHeight(), i2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.pAU == b.LIST) {
            this.pAX.b(z, i, i2, i3, i4);
        } else if (this.pAU == b.LOOP) {
            this.pAX.a(this.j, this.e, z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        h();
    }

    private void h() {
        if (this.pAU == b.LIST) {
            i();
        } else if (this.pAU == b.LOOP) {
            j();
        }
    }

    private void i() {
        this.f4264a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.pAX.a(this.f4264a, this.b, this.pBa, this.j, this.e);
        if (this.pAS == null) {
            this.pAS = new AnimatorListenerAdapter() { // from class: com.kascend.chushou.widget.dispalymenu.EggacheDisplayView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    EggacheDisplayView.this.pAU = b.LIST;
                    if (EggacheDisplayView.this.z != null) {
                        EggacheDisplayView.this.z.setVisibility(8);
                    }
                    if (EggacheDisplayView.this.w != null) {
                        EggacheDisplayView.this.w.setVisibility(0);
                    }
                }
            };
            this.pAY.addListener(this.pAS);
        }
        if (this.pAT == null) {
            this.pAT = new AnimatorListenerAdapter() { // from class: com.kascend.chushou.widget.dispalymenu.EggacheDisplayView.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (EggacheDisplayView.this.z != null) {
                        EggacheDisplayView.this.z.setAlpha(0.0f);
                    }
                    EggacheDisplayView.this.pAU = b.LOOP;
                    if (EggacheDisplayView.this.z != null) {
                        EggacheDisplayView.this.z.setVisibility(0);
                    }
                    if (EggacheDisplayView.this.w != null) {
                        EggacheDisplayView.this.w.setVisibility(4);
                    }
                    if (EggacheDisplayView.this.pBa != null) {
                        EggacheDisplayView.this.pBa.start();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                }
            };
            this.pAZ.addListener(this.pAT);
        }
    }

    private void j() {
        a(this.r + 870 + 330);
    }

    public void a() {
        if (!this.A) {
            this.A = true;
            d();
            this.pAZ.cancel();
            this.pAY.playTogether(this.f4264a);
            this.pAY.start();
        }
    }

    public void b() {
        if (this.A) {
            this.A = false;
            this.pAY.cancel();
            this.pAZ.playTogether(this.b);
            this.pAZ.start();
        }
    }

    public void a(int i) {
        if (!this.t) {
            l();
            if (this.pBc.size() > 1 && this.pAU == b.LOOP) {
                this.t = true;
                this.u = this.pBc.get(0);
                this.v = this.pBc.get(1);
                postDelayed(this.pBd, i);
            }
        }
    }

    public void c() {
        a(this.r);
    }

    public void d() {
        this.t = false;
        removeCallbacks(this.pBd);
        if (this.pzW != null) {
            this.pzW.cancel();
        }
    }

    public void e() {
        View view;
        if (this.pAU == b.LOOP) {
            d();
            if (this.pBb.size() > 1 && (view = this.pBb.get(0)) != null && view != this.u) {
                if (this.u != null) {
                    this.u.setTranslationX(this.e);
                }
                view.setTranslationX(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.t) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.u, "translationX", -this.e);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.v, "translationX", 0.0f);
            this.pzW = new AnimatorSet();
            this.pzW.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.widget.dispalymenu.EggacheDisplayView.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (EggacheDisplayView.this.u != null) {
                        EggacheDisplayView.this.u.setTranslationX(0.0f);
                    }
                    if (EggacheDisplayView.this.v != null) {
                        EggacheDisplayView.this.v.setTranslationX(EggacheDisplayView.this.e);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (EggacheDisplayView.this.u != null) {
                        EggacheDisplayView.this.u.setTranslationX(EggacheDisplayView.this.e);
                    }
                    EggacheDisplayView.this.u = EggacheDisplayView.this.v;
                    int indexOf = EggacheDisplayView.this.pBc.indexOf(EggacheDisplayView.this.u);
                    EggacheDisplayView.this.v = indexOf == EggacheDisplayView.this.pBc.size() + (-1) ? (View) EggacheDisplayView.this.pBc.get(0) : (View) EggacheDisplayView.this.pBc.get(indexOf + 1);
                }
            });
            this.pzW.setDuration(this.s);
            this.pzW.playTogether(ofFloat, ofFloat2);
            this.pzW.start();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (this.i && this.pAU == b.LOOP) || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EggacheDisplayView.this.k();
            EggacheDisplayView.this.postDelayed(EggacheDisplayView.this.pBd, EggacheDisplayView.this.r + EggacheDisplayView.this.s);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.pBd);
        super.onDetachedFromWindow();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: l */
    public ViewGroup.MarginLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: g */
    public ViewGroup.MarginLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: ewv */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    static int a(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().density * f);
    }

    private void l() {
        this.pBc.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pBb.size()) {
                View view = this.pBb.get(i2);
                if (view.getVisibility() == 0) {
                    this.pBc.add(view);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setDownRes(@DrawableRes int i) {
        if (this.g != null) {
            this.g.setImageResource(i);
        }
    }

    public void setUpRes(@DrawableRes int i) {
        if (this.h != null) {
            this.h.setImageResource(i);
        }
    }
}
