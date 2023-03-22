package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class k extends a implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public static long pU = 300;
    public ImageView nC;
    public ViewGroup pV;
    public TextView pW;
    public boolean pX;
    public float pY;
    public WeakReference<View> pZ;
    public n qa;
    public boolean qb = false;
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.reward.presenter.k.1
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            k.this.hide();
        }
    };

    public k(n nVar) {
        this.qa = nVar;
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        int i;
        if (layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.pV.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                i = this.pV.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e8);
            } else {
                int dimensionPixelSize = this.pV.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e7);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.pZ;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    int i2 = marginLayoutParams2.height;
                    if (i2 <= 0 && view2 != null) {
                        i2 = view2.getHeight();
                    }
                    marginLayoutParams.bottomMargin = i2 + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                    this.pV.setLayoutParams(marginLayoutParams);
                }
                i = layoutParams.height + dimensionPixelSize;
            }
            marginLayoutParams.bottomMargin = i;
            this.pV.setLayoutParams(marginLayoutParams);
        }
    }

    private synchronized void gY() {
        if (this.qb) {
            return;
        }
        com.kwad.sdk.core.report.a.d(this.nM.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.f().aK(192).F(this.nM.eF.getPlayDuration()));
        this.qb = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator gZ() {
        ValueAnimator valueAnimator;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.pV, Key.TRANSLATION_X, getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703ea));
        Drawable background = this.nC.getBackground();
        if (background instanceof ColorDrawable) {
            final ColorDrawable colorDrawable = (ColorDrawable) background;
            valueAnimator = com.kwad.sdk.widget.a.ofArgb(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060621), getContext().getResources().getColor(R.color.obfuscated_res_0x7f060622));
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.k.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    colorDrawable.setColor(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        } else {
            valueAnimator = null;
        }
        animatorSet.playTogether(ofFloat, valueAnimator, ObjectAnimator.ofFloat(this.pW, Key.ALPHA, 0.0f, 1.0f));
        animatorSet.setDuration(pU);
        return animatorSet;
    }

    private void initView() {
        ViewGroup viewGroup = this.pV;
        if (viewGroup == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091297);
        this.nC = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060621));
        this.pW = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091298);
        this.pV.setOnClickListener(this);
    }

    public final void M(boolean z) {
        ViewGroup viewGroup = this.pV;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        gY();
        WeakReference<View> weakReference = this.pZ;
        if (weakReference != null && weakReference.get() != null) {
            a(this.pZ.get().getLayoutParams());
        }
        this.pV.setVisibility(0);
        if (z) {
            this.pV.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.k.2
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.gZ().start();
                }
            }, 2000L);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        this.pZ = new WeakReference<>(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        com.kwad.sdk.core.e.b.d("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
        a(layoutParams);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (this.pV == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f09129d);
            this.pV = (ViewGroup) (viewStub != null ? viewStub.inflate() : findViewById(R.id.obfuscated_res_0x7f09129c));
            initView();
        }
        if (!this.nM.fy()) {
            this.nM.ml.a(this);
        } else if (com.kwad.sdk.core.response.a.b.e(getContext(), this.nM.mAdTemplate)) {
            a(new ViewGroup.LayoutParams(-1, -1));
        } else {
            a(new ViewGroup.LayoutParams(-1, this.pV.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d1)));
        }
        this.nM.a(this.mPlayEndPageListener);
    }

    public final void hide() {
        ViewGroup viewGroup = this.pV;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        ViewGroup viewGroup = this.pV;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        com.kwad.components.ad.reward.b.eV().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
        com.kwad.sdk.core.report.a.a(this.nM.mAdTemplate, new com.kwad.sdk.core.report.f().aK(192).F(this.nM.eF.getPlayDuration()));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pY = com.kwad.components.ad.reward.kwai.b.gb();
        this.pX = !com.kwad.components.ad.reward.kwai.b.gd() && com.kwad.components.ad.reward.kwai.b.gc();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nM.b(this.mPlayEndPageListener);
        this.nM.ml.b(this);
    }
}
