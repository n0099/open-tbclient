package pl.droidsonroids.gif;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import pl.droidsonroids.gif.GifViewUtils;
/* loaded from: classes9.dex */
public class GifImageButton extends ImageButton {
    private boolean mFreezesAnimation;

    public GifImageButton(Context context) {
        super(context);
    }

    public GifImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        postInit(GifViewUtils.initImageView(this, attributeSet, 0, 0));
    }

    public GifImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        postInit(GifViewUtils.initImageView(this, attributeSet, i, 0));
    }

    @TargetApi(21)
    public GifImageButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        postInit(GifViewUtils.initImageView(this, attributeSet, i, i2));
    }

    private void postInit(GifViewUtils.InitResult initResult) {
        this.mFreezesAnimation = initResult.mFreezesAnimation;
        if (initResult.mSourceResId > 0) {
            super.setImageResource(initResult.mSourceResId);
        }
        if (initResult.mBackgroundResId > 0) {
            super.setBackgroundResource(initResult.mBackgroundResId);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (!GifViewUtils.setGifImageUri(this, uri)) {
            super.setImageURI(uri);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (!GifViewUtils.setResource(this, true, i)) {
            super.setImageResource(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (!GifViewUtils.setResource(this, false, i)) {
            super.setBackgroundResource(i);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new GifViewSavedState(super.onSaveInstanceState(), this.mFreezesAnimation ? getDrawable() : null, this.mFreezesAnimation ? getBackground() : null);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.restoreState(getDrawable(), 0);
        gifViewSavedState.restoreState(getBackground(), 1);
    }

    public void setFreezesAnimation(boolean z) {
        this.mFreezesAnimation = z;
    }
}
