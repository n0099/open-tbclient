package com.kascend.chushou.player.ui.pk;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import java.util.HashSet;
import java.util.Set;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes6.dex */
public class LivePKMvpView extends RelativeLayout implements Runnable {
    private RelativeLayout a;
    private ImageView b;
    private ImageView c;
    private ImageView e;
    private TextView f;
    private ImageView g;
    private Set<Animator> nCn;
    private a nCo;
    private FrescoThumbnailView npn;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public LivePKMvpView(Context context) {
        super(context);
        this.nCn = new HashSet();
        a(context);
    }

    public LivePKMvpView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nCn = new HashSet();
        a(context);
    }

    public LivePKMvpView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nCn = new HashSet();
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
    }

    private void a(Context context) {
        inflate(context, a.h.layout_live_view_online_live_pk_mvp, this);
        this.a = (RelativeLayout) findViewById(a.f.rl_pk_icon);
        this.b = (ImageView) findViewById(a.f.iv_pk_left);
        this.c = (ImageView) findViewById(a.f.iv_pk_right);
        this.npn = (FrescoThumbnailView) findViewById(a.f.iv_pk_icon);
        this.e = (ImageView) findViewById(a.f.iv_pk_water);
        this.f = (TextView) findViewById(a.f.tv_pk_nickname);
        this.g = (ImageView) findViewById(a.f.iv_pk_mvp_tag);
    }

    public void a(String str, String str2) {
        clearAnimation();
        setVisibility(0);
        this.f.setText(str2);
        this.npn.bS(str, tv.chushou.widget.a.c.dZV());
        this.e.setVisibility(0);
        this.e.setAlpha(0.0f);
        this.g.setVisibility(0);
        this.g.setAlpha(0.0f);
        this.a.setVisibility(0);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.a, PropertyValuesHolder.ofFloat("scaleX", 0.3f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1.0f));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "rotation", 20.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.c, "rotation", -20.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofPropertyValuesHolder, ofFloat, ofFloat2);
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.a, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.1f, 1.0f, 1.05f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 1.1f, 1.0f, 1.05f, 1.0f));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.b, "rotation", 0.0f, 20.0f, 0.0f, 20.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.c, "rotation", 0.0f, -20.0f, 0.0f, -20.0f, 0.0f);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(this.e, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f, 1.0f, 1.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleX", 0.3f, 1.1f, 1.0f, 1.05f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1.1f, 1.0f, 1.05f, 1.0f));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ofPropertyValuesHolder2, ofFloat3, ofFloat4, ofPropertyValuesHolder3);
        animatorSet2.setInterpolator(new LinearInterpolator());
        animatorSet2.setDuration(480L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.start();
        ObjectAnimator ofPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(this.g, PropertyValuesHolder.ofFloat("alpha", 0.2f, 1.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.65f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.65f));
        ofPropertyValuesHolder4.setDuration(320L);
        ofPropertyValuesHolder4.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder4.setStartDelay(1600L);
        ofPropertyValuesHolder4.start();
        this.nCn.add(animatorSet3);
        this.nCn.add(ofPropertyValuesHolder4);
        postDelayed(this, 2600L);
    }

    public void a() {
        removeCallbacks(this);
        clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        for (Animator animator : this.nCn) {
            animator.cancel();
        }
        this.nCn.clear();
        removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        if (this.nCo != null) {
            this.nCo.a();
        }
    }

    public void setCallback(a aVar) {
        this.nCo = aVar;
    }
}
