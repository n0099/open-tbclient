package com.kascend.chushou.widget.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.MicMemberInfo;
/* loaded from: classes6.dex */
public abstract class KasBaseMenuView extends RelativeLayout implements View.OnClickListener, Animation.AnimationListener {
    protected Context e;
    protected View f;
    protected View g;
    protected boolean h;
    protected boolean i;
    private a omt;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public KasBaseMenuView(Context context) {
        super(context);
        this.h = false;
        this.i = false;
    }

    public KasBaseMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.i = false;
    }

    public KasBaseMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = false;
        this.i = false;
    }

    public void e() {
        this.h = false;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.C0879a.slide_out_bottom_anim);
        loadAnimation.setAnimationListener(this);
        this.f.startAnimation(loadAnimation);
        this.f.postDelayed(new Runnable() { // from class: com.kascend.chushou.widget.menu.KasBaseMenuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!KasBaseMenuView.this.h && KasBaseMenuView.this.omt != null) {
                    KasBaseMenuView.this.omt.a();
                }
            }
        }, 200L);
    }

    protected void setMicMemberInfo(MicMemberInfo micMemberInfo) {
    }

    public void c() {
        setVisibility(0);
        this.h = true;
        this.f.startAnimation(AnimationUtils.loadAnimation(getContext(), a.C0879a.slide_in_bottom_anim));
        if (this.omt != null) {
            this.omt.b();
        }
        this.f.postDelayed(new Runnable() { // from class: com.kascend.chushou.widget.menu.KasBaseMenuView.2
            @Override // java.lang.Runnable
            public void run() {
                if (KasBaseMenuView.this.h) {
                    KasBaseMenuView.this.d();
                }
            }
        }, 200L);
    }

    protected void d() {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (!this.h) {
            setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    public void onClick(View view) {
        if (isShown()) {
            e();
        }
    }

    public void setVisibilityListener(a aVar) {
        this.omt = aVar;
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.omt = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }
}
