package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private int maxInlineActionWidth;
    private int maxWidth;
    private TextView messageView;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.maxInlineActionWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    public Button getActionView() {
        return this.actionView;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        if (this.maxWidth > 0 && getMeasuredWidth() > this.maxWidth) {
            i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        boolean z2 = this.messageView.getLayout().getLineCount() > 1;
        if (z2 && this.maxInlineActionWidth > 0 && this.actionView.getMeasuredWidth() > this.maxInlineActionWidth) {
            if (updateViewsWithinLayout(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                z = true;
            }
            z = false;
        } else {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (updateViewsWithinLayout(0, dimensionPixelSize, dimensionPixelSize)) {
                z = true;
            }
            z = false;
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    private boolean updateViewsWithinLayout(int i, int i2, int i3) {
        boolean z = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        }
        if (this.messageView.getPaddingTop() != i2 || this.messageView.getPaddingBottom() != i3) {
            updateTopBottomPadding(this.messageView, i2, i3);
            return true;
        }
        return z;
    }

    private static void updateTopBottomPadding(View view, int i, int i2) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i, ViewCompat.getPaddingEnd(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i, int i2) {
        this.messageView.setAlpha(0.0f);
        this.messageView.animate().alpha(1.0f).setDuration(i2).setStartDelay(i).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(i2).setStartDelay(i).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i, int i2) {
        this.messageView.setAlpha(1.0f);
        this.messageView.animate().alpha(0.0f).setDuration(i2).setStartDelay(i).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(i2).setStartDelay(i).start();
        }
    }
}
