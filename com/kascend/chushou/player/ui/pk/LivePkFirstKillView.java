package com.kascend.chushou.player.ui.pk;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class LivePkFirstKillView extends RelativeLayout {
    private ImageView a;
    private ImageView b;
    private TextView d;
    private TextView e;
    private TextView f;
    private ObjectAnimator i;
    private boolean l;
    private FrameLayout mTe;
    private AnimatorSet mWL;
    private ObjectAnimator mWN;
    private ObjectAnimator mWO;
    private Set<Animator> mWP;

    public LivePkFirstKillView(Context context) {
        this(context, null);
    }

    public LivePkFirstKillView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePkFirstKillView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = false;
        b();
    }

    private void b() {
        inflate(getContext(), a.h.layout_pk_first_kill_anim, this);
        setClickable(false);
        this.a = (ImageView) findViewById(a.f.iv_notice);
        this.b = (ImageView) findViewById(a.f.iv_addition);
        this.mTe = (FrameLayout) findViewById(a.f.fl_addition);
        this.d = (TextView) findViewById(a.f.tv_addition);
        this.e = (TextView) findViewById(a.f.anchor_left);
        this.f = (TextView) findViewById(a.f.anchor_right);
    }

    public void a() {
        clearAnimation();
        c();
        this.l = false;
        setVisibility(8);
    }

    public void a(final boolean z, float f) {
        if (!this.l) {
            this.l = true;
            clearAnimation();
            c();
            setVisibility(0);
            this.a.setVisibility(0);
            this.mTe.setVisibility(4);
            this.d.setText(getContext().getResources().getString(a.i.str_live_pk_txt_first_blood_addition) + ((int) (100.0f * f)) + "%");
            this.mWL = new AnimatorSet();
            this.mWP = new HashSet();
            post(new Runnable() { // from class: com.kascend.chushou.player.ui.pk.LivePkFirstKillView.1
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe("scaleX", Keyframe.ofFloat(0.0f, 0.3f), Keyframe.ofFloat(0.22222222f, 1.2f), Keyframe.ofFloat(0.31111112f, 1.0f), Keyframe.ofFloat(0.4f, 1.1f), Keyframe.ofFloat(0.4888889f, 1.0f), Keyframe.ofFloat(0.5777778f, 1.0f), Keyframe.ofFloat(1.0f, 0.3f));
                    PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe("scaleY", Keyframe.ofFloat(0.0f, 0.3f), Keyframe.ofFloat(0.22222222f, 1.2f), Keyframe.ofFloat(0.31111112f, 1.0f), Keyframe.ofFloat(0.4f, 1.1f), Keyframe.ofFloat(0.4888889f, 1.0f), Keyframe.ofFloat(0.5777778f, 1.0f), Keyframe.ofFloat(1.0f, 0.3f));
                    LivePkFirstKillView.this.mWN = ObjectAnimator.ofPropertyValuesHolder(LivePkFirstKillView.this.a, PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.22222222f, 1.0f), Keyframe.ofFloat(0.5777778f, 1.0f), Keyframe.ofFloat(1.0f, 0.3f)), ofKeyframe, ofKeyframe2);
                    LivePkFirstKillView.this.mWN.setDuration(1800L);
                    LivePkFirstKillView.this.mWN.setInterpolator(new LinearInterpolator());
                    LivePkFirstKillView.this.mWN.addListener(new g() { // from class: com.kascend.chushou.player.ui.pk.LivePkFirstKillView.1.1
                        @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            LivePkFirstKillView.this.a.setVisibility(4);
                            LivePkFirstKillView.this.mTe.setVisibility(0);
                        }
                    });
                    LivePkFirstKillView.this.mWP.add(LivePkFirstKillView.this.mWN);
                    PropertyValuesHolder ofKeyframe3 = PropertyValuesHolder.ofKeyframe("scaleX", Keyframe.ofFloat(0.0f, 0.3f), Keyframe.ofFloat(1.0f, 1.0f));
                    PropertyValuesHolder ofKeyframe4 = PropertyValuesHolder.ofKeyframe("scaleY", Keyframe.ofFloat(0.0f, 0.3f), Keyframe.ofFloat(1.0f, 1.0f));
                    LivePkFirstKillView.this.i = ObjectAnimator.ofPropertyValuesHolder(LivePkFirstKillView.this.mTe, PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(1.0f, 1.0f)), ofKeyframe3, ofKeyframe4);
                    LivePkFirstKillView.this.i.setDuration(560L);
                    LivePkFirstKillView.this.i.setInterpolator(new LinearInterpolator());
                    LivePkFirstKillView.this.mWP.add(LivePkFirstKillView.this.i);
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    int[] iArr3 = new int[2];
                    LivePkFirstKillView.this.e.getLocationOnScreen(iArr);
                    LivePkFirstKillView.this.f.getLocationOnScreen(iArr2);
                    LivePkFirstKillView.this.a.getLocationOnScreen(iArr3);
                    if (z) {
                        i = iArr[0] - iArr3[0];
                        i2 = iArr[1] - iArr3[1];
                    } else {
                        i = iArr2[0] - iArr3[0];
                        i2 = iArr2[1] - iArr3[1];
                    }
                    LivePkFirstKillView.this.mWO = ObjectAnimator.ofPropertyValuesHolder(LivePkFirstKillView.this.mTe, PropertyValuesHolder.ofKeyframe("translationX", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.86206895f, i), Keyframe.ofFloat(1.0f, i)), PropertyValuesHolder.ofKeyframe("translationY", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.86206895f, i2), Keyframe.ofFloat(1.0f, i2)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.86206895f, 1.0f), Keyframe.ofFloat(1.0f, 0.0f)), PropertyValuesHolder.ofKeyframe("scaleX", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.86206895f, 0.4f), Keyframe.ofFloat(1.0f, 0.4f)), PropertyValuesHolder.ofKeyframe("scaleY", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.86206895f, 0.4f), Keyframe.ofFloat(1.0f, 0.4f)));
                    LivePkFirstKillView.this.mWO.setDuration(1160L);
                    LivePkFirstKillView.this.mWO.setInterpolator(new LinearInterpolator());
                    LivePkFirstKillView.this.mWP.add(LivePkFirstKillView.this.mWO);
                    LivePkFirstKillView.this.mWL.playSequentially(LivePkFirstKillView.this.mWN, LivePkFirstKillView.this.i, LivePkFirstKillView.this.mWO);
                    LivePkFirstKillView.this.mWL.addListener(new g() { // from class: com.kascend.chushou.player.ui.pk.LivePkFirstKillView.1.2
                        @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            LivePkFirstKillView.this.setVisibility(8);
                            LivePkFirstKillView.this.c();
                            LivePkFirstKillView.this.l = false;
                        }
                    });
                    LivePkFirstKillView.this.mWL.start();
                }
            });
        }
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        if (this.mWL != null) {
            this.mWL.cancel();
        }
        if (this.mWP != null) {
            for (Animator animator : this.mWP) {
                animator.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.a != null) {
            this.a.setAlpha(1.0f);
            this.a.setTranslationY(0.0f);
            this.a.setTranslationX(0.0f);
            this.a.setScaleX(1.0f);
            this.a.setScaleY(1.0f);
        }
        if (this.mTe != null) {
            this.mTe.setAlpha(1.0f);
            this.mTe.setTranslationX(0.0f);
            this.mTe.setTranslationY(0.0f);
            this.mTe.setScaleX(1.0f);
            this.mTe.setScaleY(1.0f);
        }
    }
}
