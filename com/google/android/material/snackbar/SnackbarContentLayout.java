package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.baidu.tieba.R;
import com.google.android.material.color.MaterialColors;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes9.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    public Button actionView;
    public int maxInlineActionWidth;
    public int maxWidth;
    public TextView messageView;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }

    public void setMaxInlineActionWidth(int i) {
        this.maxInlineActionWidth = i;
    }

    public void updateActionTextColorAlphaIfNeeded(float f) {
        if (f != 1.0f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, R.attr.obfuscated_res_0x7f040190), this.actionView.getCurrentTextColor(), f));
        }
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.SnackbarLayout);
        this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.maxInlineActionWidth = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        obtainStyledAttributes.recycle();
    }

    public static void updateTopBottomPadding(@NonNull View view2, int i, int i2) {
        if (ViewCompat.isPaddingRelative(view2)) {
            ViewCompat.setPaddingRelative(view2, ViewCompat.getPaddingStart(view2), i, ViewCompat.getPaddingEnd(view2), i2);
        } else {
            view2.setPadding(view2.getPaddingLeft(), i, view2.getPaddingRight(), i2);
        }
    }

    private boolean updateViewsWithinLayout(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.messageView.getPaddingTop() == i2 && this.messageView.getPaddingBottom() == i3) {
            return z;
        }
        updateTopBottomPadding(this.messageView, i2, i3);
        return true;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i, int i2) {
        this.messageView.setAlpha(0.0f);
        long j = i2;
        long j2 = i;
        this.messageView.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i, int i2) {
        this.messageView.setAlpha(1.0f);
        long j = i2;
        long j2 = i;
        this.messageView.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.obfuscated_res_0x7f092235);
        this.actionView = (Button) findViewById(R.id.obfuscated_res_0x7f092234);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (updateViewsWithinLayout(1, r0, r0 - r1) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (updateViewsWithinLayout(0, r0, r0) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
        r3 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        if (this.maxWidth > 0) {
            int measuredWidth = getMeasuredWidth();
            int i3 = this.maxWidth;
            if (measuredWidth > i3) {
                i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                super.onMeasure(i, i2);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d0);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702cf);
        boolean z2 = false;
        if (this.messageView.getLayout().getLineCount() > 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) {
            if (!z) {
                dimensionPixelSize = dimensionPixelSize2;
            }
        }
        if (z2) {
            super.onMeasure(i, i2);
        }
    }
}
