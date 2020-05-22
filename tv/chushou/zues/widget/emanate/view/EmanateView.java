package tv.chushou.zues.widget.emanate.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Random;
import tv.chushou.zues.b;
import tv.chushou.zues.utils.e;
/* loaded from: classes5.dex */
public class EmanateView extends RelativeLayout {
    private RelativeLayout.LayoutParams fHF;
    private Context mContext;
    private Drawable mDrawable;
    private int mHeight;
    private Random mRandom;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mWidth;
    private float mX;
    private float mY;
    private Interpolator[] nOE;
    private int nOF;
    private int nOG;

    public EmanateView(Context context) {
        this(context, null);
    }

    public EmanateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRandom = new Random();
        this.mContext = context;
        init();
    }

    private void init() {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        setDrawable(null);
        this.nOE = new Interpolator[4];
        this.nOE[0] = linearInterpolator;
        this.nOE[1] = accelerateInterpolator;
        this.nOE[2] = decelerateInterpolator;
        this.nOE[3] = accelerateDecelerateInterpolator;
    }

    public void setEmanateStartLoc(int i, int i2) {
        this.mX = i;
        this.mY = i2;
        dRZ();
    }

    private void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        this.mScreenWidth = windowManager.getDefaultDisplay().getWidth();
        this.mScreenHeight = windowManager.getDefaultDisplay().getHeight();
    }

    protected void dRZ() {
        getScreenSize();
        this.mX = this.mWidth - (this.mScreenWidth - this.mX);
        this.mY = this.mHeight - (this.mScreenHeight - this.mY);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mDrawable = drawable.getConstantState().newDrawable();
        } else {
            this.mDrawable = getResources().getDrawable(b.d.zues_default_gift_color);
        }
        this.nOF = this.mDrawable.getIntrinsicHeight();
        this.nOG = this.mDrawable.getIntrinsicWidth();
        this.fHF = new RelativeLayout.LayoutParams(this.nOG, this.nOF);
    }

    public void setDrawable(Drawable drawable, int i, int i2) {
        if (drawable != null) {
            this.mDrawable = drawable.getConstantState().newDrawable();
        } else {
            this.mDrawable = getResources().getDrawable(b.d.zues_default_gift_color);
        }
        this.nOF = (int) tv.chushou.zues.utils.a.a(0, i2, getContext());
        this.nOG = (int) tv.chushou.zues.utils.a.a(0, i, getContext());
        this.fHF = new RelativeLayout.LayoutParams(this.nOG, this.nOF);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
    }

    public void dSa() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(this.mDrawable);
        if (this.mX == 0.0f || this.mY == 0.0f) {
            this.fHF.addRule(14, -1);
            this.fHF.addRule(12, -1);
        }
        imageView.setLayoutParams(this.fHF);
        tv.chushou.zues.toolkit.d.b.setX(imageView, this.mX);
        tv.chushou.zues.toolkit.d.b.setY(imageView, this.mY);
        addView(imageView);
        e.v("FavorLayout", "lhh - add child count" + getChildCount());
        Animator P = P(imageView);
        P.addListener(new a(imageView));
        P.start();
    }

    private Animator P(View view) {
        AnimatorSet dz = dz(view);
        ValueAnimator dA = dA(view);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(dz);
        animatorSet.playSequentially(dz, dA);
        animatorSet.setInterpolator(this.nOE[this.mRandom.nextInt(4)]);
        animatorSet.setTarget(view);
        return animatorSet;
    }

    private AnimatorSet dz(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 0.2f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 0.2f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setTarget(view);
        return animatorSet;
    }

    private ValueAnimator dA(View view) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new tv.chushou.zues.widget.emanate.a.a(KH(2), KH(1)), new PointF(this.mX, this.mY), new PointF(this.mRandom.nextInt(getWidth()), 0.0f));
        ofObject.addUpdateListener(new b(view));
        ofObject.setTarget(view);
        ofObject.setDuration(3000L);
        return ofObject;
    }

    private PointF KH(int i) {
        PointF pointF = new PointF();
        pointF.x = this.mRandom.nextInt(this.mWidth - 100);
        pointF.y = this.mRandom.nextInt(this.mHeight - 100) / i;
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        private View nOH;

        public b(View view) {
            this.nOH = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PointF pointF = (PointF) valueAnimator.getAnimatedValue();
            tv.chushou.zues.toolkit.d.b.setX(this.nOH, pointF.x);
            tv.chushou.zues.toolkit.d.b.setY(this.nOH, pointF.y);
            tv.chushou.zues.toolkit.d.b.setAlpha(this.nOH, 1.0f - valueAnimator.getAnimatedFraction());
        }
    }

    /* loaded from: classes5.dex */
    private class a extends AnimatorListenerAdapter {
        private View nOH;

        public a(View view) {
            this.nOH = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            EmanateView.this.removeView(this.nOH);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.nOE = null;
        this.mContext = null;
        this.fHF = null;
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
            this.mDrawable = null;
        }
        this.mRandom = null;
    }
}
