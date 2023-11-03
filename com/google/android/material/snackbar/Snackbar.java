package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.tieba.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
/* loaded from: classes10.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] SNACKBAR_BUTTON_STYLE_ATTR = {R.attr.obfuscated_res_0x7f0406a6};
    public static final int[] SNACKBAR_CONTENT_STYLE_ATTRS = {R.attr.obfuscated_res_0x7f0406a6, R.attr.obfuscated_res_0x7f0406a8};
    @Nullable
    public final AccessibilityManager accessibilityManager;
    @Nullable
    public BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    public boolean hasAction;

    /* loaded from: classes10.dex */
    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onDismissed(Snackbar snackbar, int i) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onShown(Snackbar snackbar) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes10.dex */
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        int i;
        int duration = super.getDuration();
        if (duration == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.hasAction) {
                i = 4;
            } else {
                i = 0;
            }
            return this.accessibilityManager.getRecommendedTimeoutMillis(duration, i | 1 | 2);
        } else if (this.hasAction && this.accessibilityManager.isTouchExplorationEnabled()) {
            return -2;
        } else {
            return duration;
        }
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }

    public Snackbar(@NonNull ViewGroup viewGroup, @NonNull View view2, @NonNull ContentViewCallback contentViewCallback) {
        super(viewGroup, view2, contentViewCallback);
        this.accessibilityManager = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @NonNull
    public static Snackbar make(@NonNull View view2, @StringRes int i, int i2) {
        return make(view2, view2.getResources().getText(i), i2);
    }

    @Nullable
    public static ViewGroup findSuitableParent(View view2) {
        ViewGroup viewGroup = null;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    @Deprecated
    public static boolean hasSnackbarButtonStyleAttr(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            return false;
        }
        return true;
    }

    public static boolean hasSnackbarContentStyleAttrs(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        if (resourceId == -1 || resourceId2 == -1) {
            return false;
        }
        return true;
    }

    @NonNull
    public Snackbar setActionTextColor(@ColorInt int i) {
        ((SnackbarContentLayout) this.f1205view.getChildAt(0)).getActionView().setTextColor(i);
        return this;
    }

    @NonNull
    public Snackbar setBackgroundTint(@ColorInt int i) {
        return setBackgroundTintList(ColorStateList.valueOf(i));
    }

    @NonNull
    public Snackbar setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.f1205view.setBackgroundTintList(colorStateList);
        return this;
    }

    @NonNull
    public Snackbar setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1205view.setBackgroundTintMode(mode);
        return this;
    }

    @NonNull
    @Deprecated
    public Snackbar setCallback(@Nullable Callback callback) {
        BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback = this.callback;
        if (baseCallback != null) {
            removeCallback(baseCallback);
        }
        if (callback != null) {
            addCallback(callback);
        }
        this.callback = callback;
        return this;
    }

    @NonNull
    public Snackbar setMaxInlineActionWidth(@Dimension int i) {
        ((SnackbarContentLayout) this.f1205view.getChildAt(0)).setMaxInlineActionWidth(i);
        return this;
    }

    @NonNull
    public Snackbar setText(@StringRes int i) {
        return setText(getContext().getText(i));
    }

    @NonNull
    public Snackbar setTextColor(@ColorInt int i) {
        ((SnackbarContentLayout) this.f1205view.getChildAt(0)).getMessageView().setTextColor(i);
        return this;
    }

    @NonNull
    public static Snackbar make(@NonNull View view2, @NonNull CharSequence charSequence, int i) {
        int i2;
        ViewGroup findSuitableParent = findSuitableParent(view2);
        if (findSuitableParent != null) {
            LayoutInflater from = LayoutInflater.from(findSuitableParent.getContext());
            if (hasSnackbarContentStyleAttrs(findSuitableParent.getContext())) {
                i2 = R.layout.obfuscated_res_0x7f0d0673;
            } else {
                i2 = R.layout.obfuscated_res_0x7f0d0258;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(i2, findSuitableParent, false);
            Snackbar snackbar = new Snackbar(findSuitableParent, snackbarContentLayout, snackbarContentLayout);
            snackbar.setText(charSequence);
            snackbar.setDuration(i);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @NonNull
    public Snackbar setAction(@StringRes int i, View.OnClickListener onClickListener) {
        return setAction(getContext().getText(i), onClickListener);
    }

    @NonNull
    public Snackbar setAction(@Nullable CharSequence charSequence, @Nullable final View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f1205view.getChildAt(0)).getActionView();
        if (!TextUtils.isEmpty(charSequence) && onClickListener != null) {
            this.hasAction = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.snackbar.Snackbar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    onClickListener.onClick(view2);
                    Snackbar.this.dispatchDismiss(1);
                }
            });
        } else {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.hasAction = false;
        }
        return this;
    }

    @NonNull
    public Snackbar setActionTextColor(ColorStateList colorStateList) {
        ((SnackbarContentLayout) this.f1205view.getChildAt(0)).getActionView().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    public Snackbar setText(@NonNull CharSequence charSequence) {
        ((SnackbarContentLayout) this.f1205view.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    @NonNull
    public Snackbar setTextColor(ColorStateList colorStateList) {
        ((SnackbarContentLayout) this.f1205view.getChildAt(0)).getMessageView().setTextColor(colorStateList);
        return this;
    }
}
