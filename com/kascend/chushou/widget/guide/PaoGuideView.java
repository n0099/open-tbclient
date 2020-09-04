package com.kascend.chushou.widget.guide;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
/* loaded from: classes6.dex */
public class PaoGuideView extends RelativeLayout implements View.OnClickListener, Animation.AnimationListener {
    private Context b;
    private View c;
    private View d;
    private boolean e;
    private boolean f;
    private a ocF;

    public PaoGuideView(Context context) {
        super(context);
        this.e = false;
        this.f = false;
    }

    public PaoGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.f = false;
    }

    public PaoGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        this.f = false;
    }

    public void a() {
        this.b = null;
        this.e = false;
        this.f = false;
        this.ocF = null;
        this.c = null;
        this.d = null;
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.e;
    }

    public boolean b() {
        return this.f;
    }

    public void a(Context context, int i, String str) {
        this.b = context;
        this.f = true;
        if (this.d == null) {
            this.d = LayoutInflater.from(context).inflate(a.h.pao_guide_view, (ViewGroup) null, false);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(context).inflate(a.h.web_guide_view, (ViewGroup) null, false);
        }
        removeAllViews();
        this.ocF = new a();
        Bundle bundle = new Bundle();
        bundle.putString("mH5Url", (tv.chushou.common.a.cvE() + "play-help/bang-guide.htm?") + "roomId=" + str);
        this.ocF.setArguments(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -1);
        layoutParams.addRule(11);
        this.d.setOnClickListener(this);
        this.d.setBackgroundColor(Color.argb(0, 150, 150, 150));
        ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(layoutParams2);
        addView(this.d, layoutParams2);
        addView(this.c, layoutParams);
        FragmentTransaction beginTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        beginTransaction.add(a.f.guide_fragment, this.ocF);
        beginTransaction.commitAllowingStateLoss();
    }

    public void c() {
        if (this.ocF != null && this.ocF.isAdded()) {
            this.ocF.a();
        }
    }

    public void d() {
        this.e = false;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, a.C0882a.commonres_activity_exit_right);
        loadAnimation.setAnimationListener(this);
        if (this.c != null) {
            this.c.startAnimation(loadAnimation);
            if (this.d != null) {
                this.d.setVisibility(8);
            }
        }
    }

    public void e() {
        setVisibility(0);
        this.e = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, a.C0882a.commonres_activity_enter_right);
        if (this.c != null) {
            this.c.startAnimation(loadAnimation);
            if (this.d != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f);
                ofFloat.setDuration(440L);
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.widget.guide.PaoGuideView.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        PaoGuideView.this.d.setVisibility(0);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                ofFloat.start();
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (!this.e) {
            setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (isShown()) {
            d();
        }
    }
}
