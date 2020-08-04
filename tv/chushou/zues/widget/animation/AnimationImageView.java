package tv.chushou.zues.widget.animation;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes6.dex */
public class AnimationImageView extends AppCompatImageView {
    private AnimationDrawable nFs;

    public AnimationImageView(Context context) {
        this(context, null, 0);
    }

    public AnimationImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimationImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlay();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        stopPlay();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        Drawable background = getBackground();
        if (background instanceof AnimationDrawable) {
            ((AnimationDrawable) background).setVisible(i == 0, true);
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        stopPlay();
        super.onStartTemporaryDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        startPlay();
    }

    public void setAnimationDrawable(@DrawableRes int i) {
        if (i != 0) {
            setBackgroundResource(i);
            startPlay();
        }
    }

    public int getTotalDuration() {
        if (this.nFs != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.nFs.getNumberOfFrames(); i2++) {
                i += this.nFs.getDuration(i2);
            }
            return i;
        }
        return 0;
    }

    private void startPlay() {
        if (getBackground() instanceof AnimationDrawable) {
            this.nFs = (AnimationDrawable) getBackground();
            post(new Runnable() { // from class: tv.chushou.zues.widget.animation.AnimationImageView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AnimationImageView.this.nFs != null) {
                        AnimationImageView.this.nFs.start();
                        if (AnimationImageView.this.nFs.isOneShot()) {
                            AnimationImageView.this.postDelayed(new Runnable() { // from class: tv.chushou.zues.widget.animation.AnimationImageView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                }
                            }, AnimationImageView.this.getTotalDuration());
                        }
                    }
                }
            });
        }
    }

    private void stopPlay() {
        Drawable background = getBackground();
        if (background instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) background;
            if (animationDrawable.isRunning()) {
                animationDrawable.stop();
            }
        }
    }
}
