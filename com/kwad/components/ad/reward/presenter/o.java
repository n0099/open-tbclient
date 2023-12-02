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
/* loaded from: classes10.dex */
public final class o extends b implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public static long sx = 300;
    public ImageView fq;
    public boolean sA;
    public float sB;
    public WeakReference<View> sC;
    public r sD;
    public ViewGroup sy;
    public TextView sz;
    public boolean sE = false;
    public com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.o.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            o.this.hide();
        }
    };

    public o(r rVar) {
        this.sD = rVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        ViewGroup viewGroup = this.sy;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        com.kwad.components.ad.reward.a.eW().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
        com.kwad.sdk.core.report.a.e(this.qn.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.j().cC(192).ai(this.qn.oI.getPlayDuration()));
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.sy.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                marginLayoutParams.bottomMargin = this.sy.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07053f);
            } else {
                int dimensionPixelSize = this.sy.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07053e);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    View view2 = null;
                    WeakReference<View> weakReference = this.sC;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    }
                    int i = marginLayoutParams2.height;
                    if (i <= 0 && view2 != null) {
                        i = view2.getHeight();
                    }
                    marginLayoutParams.bottomMargin = i + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                } else {
                    marginLayoutParams.bottomMargin = layoutParams.height + dimensionPixelSize;
                }
            }
            this.sy.setLayoutParams(marginLayoutParams);
        }
    }

    private synchronized void hv() {
        if (this.sE) {
            return;
        }
        com.kwad.sdk.core.report.a.d(this.qn.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.j().cC(192).ai(this.qn.oI.getPlayDuration()));
        this.sE = true;
    }

    public final void hide() {
        ViewGroup viewGroup = this.sy;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        boolean z;
        super.onCreate();
        this.sB = com.kwad.components.ad.reward.a.b.gt();
        if (!com.kwad.components.ad.reward.a.b.gv() && com.kwad.components.ad.reward.a.b.gu()) {
            z = true;
        } else {
            z = false;
        }
        this.sA = z;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.c(this.mPlayEndPageListener);
        this.qn.oL.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator hw() {
        ValueAnimator valueAnimator;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.sy, Key.TRANSLATION_X, getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070541));
        Drawable background = this.fq.getBackground();
        if (background instanceof ColorDrawable) {
            final ColorDrawable colorDrawable = (ColorDrawable) background;
            valueAnimator = com.kwad.sdk.widget.a.ofArgb(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0607a5), getContext().getResources().getColor(R.color.obfuscated_res_0x7f0607a6));
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.o.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    colorDrawable.setColor(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        } else {
            valueAnimator = null;
        }
        animatorSet.playTogether(ofFloat, valueAnimator, ObjectAnimator.ofFloat(this.sz, Key.ALPHA, 0.0f, 1.0f));
        animatorSet.setDuration(sx);
        return animatorSet;
    }

    private void initView() {
        ViewGroup viewGroup = this.sy;
        if (viewGroup == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913f8);
        this.fq = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0607a5));
        this.sz = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913f9);
        this.sy.setOnClickListener(this);
    }

    public final void H(boolean z) {
        ViewGroup viewGroup = this.sy;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        hv();
        WeakReference<View> weakReference = this.sC;
        if (weakReference != null && weakReference.get() != null) {
            a(this.sC.get().getLayoutParams());
        }
        this.sy.setVisibility(0);
        if (z) {
            this.sy.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.o.2
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.hw().start();
                }
            }, 2000L);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        this.sC = new WeakReference<>(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        com.kwad.sdk.core.e.c.d("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
        a(layoutParams);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.sy == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f0913fe);
            if (viewStub != null) {
                this.sy = (ViewGroup) viewStub.inflate();
            } else {
                this.sy = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0913fd);
            }
            initView();
        }
        if (this.qn.fE()) {
            a(new ViewGroup.LayoutParams(-1, this.sy.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070528)));
        } else {
            this.qn.oL.a(this);
        }
        this.qn.b(this.mPlayEndPageListener);
    }
}
