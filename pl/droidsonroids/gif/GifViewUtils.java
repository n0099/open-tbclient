package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.RawRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
final class GifViewUtils {
    static final String ANDROID_NS = "http://schemas.android.com/apk/res/android";
    static final List<String> SUPPORTED_RESOURCE_TYPE_NAMES = Arrays.asList("raw", "drawable", "mipmap");

    private GifViewUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InitResult initImageView(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        return (attributeSet == null || imageView.isInEditMode()) ? new InitResult(0, 0, false) : new InitResult(getResourceId(imageView, attributeSet, true), getResourceId(imageView, attributeSet, false), isFreezingAnimation(imageView, attributeSet, i, i2));
    }

    private static int getResourceId(ImageView imageView, AttributeSet attributeSet, boolean z) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue(ANDROID_NS, z ? UserAccountActionItem.KEY_SRC : "background", 0);
        if (attributeResourceValue > 0) {
            if (SUPPORTED_RESOURCE_TYPE_NAMES.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !setResource(imageView, z, attributeResourceValue)) {
                return attributeResourceValue;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean setResource(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                GifDrawable gifDrawable = new GifDrawable(resources, i);
                if (z) {
                    imageView.setImageDrawable(gifDrawable);
                } else if (Build.VERSION.SDK_INT >= 16) {
                    imageView.setBackground(gifDrawable);
                } else {
                    imageView.setBackgroundDrawable(gifDrawable);
                }
                return true;
            } catch (Resources.NotFoundException e) {
            } catch (IOException e2) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isFreezingAnimation(View view, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.GifView, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.GifView_freezesAnimation, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean setGifImageUri(ImageView imageView, Uri uri) {
        if (uri != null) {
            try {
                imageView.setImageDrawable(new GifDrawable(imageView.getContext().getContentResolver(), uri));
                return true;
            } catch (IOException e) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float getDensityScale(@NonNull Resources resources, @RawRes @DrawableRes int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.density;
        if (i2 == 0) {
            i2 = 160;
        } else if (i2 == 65535) {
            i2 = 0;
        }
        int i3 = resources.getDisplayMetrics().densityDpi;
        if (i2 > 0 && i3 > 0) {
            return i3 / i2;
        }
        return 1.0f;
    }

    /* loaded from: classes4.dex */
    static class InitResult {
        final int mBackgroundResId;
        final boolean mFreezesAnimation;
        final int mSourceResId;

        InitResult(int i, int i2, boolean z) {
            this.mSourceResId = i;
            this.mBackgroundResId = i2;
            this.mFreezesAnimation = z;
        }
    }
}
