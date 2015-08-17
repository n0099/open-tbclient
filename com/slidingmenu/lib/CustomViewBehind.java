package com.slidingmenu.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class CustomViewBehind extends ViewGroup {
    private boolean mChildrenEnabled;
    private View mContent;
    private float mFadeDegree;
    private boolean mFadeEnabled;
    private final Paint mFadePaint;
    private int mFadeType;
    private int mMarginThreshold;
    private int mMode;
    private float mScrollScale;
    private View mSecondaryContent;
    private Drawable mSecondaryShadowDrawable;
    private View mSelectedView;
    private Bitmap mSelectorDrawable;
    private boolean mSelectorEnabled;
    private Drawable mShadowDrawable;
    private int mShadowWidth;
    private int mTouchMode;
    private SlidingMenu.CanvasTransformer mTransformer;
    private CustomViewAbove mViewAbove;
    private int mWidthOffset;

    public CustomViewBehind(Context context) {
        this(context, null);
    }

    public CustomViewBehind(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchMode = 0;
        this.mFadePaint = new Paint();
        this.mSelectorEnabled = true;
        this.mMarginThreshold = (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics());
    }

    public void setCustomViewAbove(CustomViewAbove customViewAbove) {
        this.mViewAbove = customViewAbove;
    }

    public void setCanvasTransformer(SlidingMenu.CanvasTransformer canvasTransformer) {
        this.mTransformer = canvasTransformer;
    }

    public void setWidthOffset(int i) {
        this.mWidthOffset = i;
        requestLayout();
    }

    public void setMarginThreshold(int i) {
        this.mMarginThreshold = i;
    }

    public int getMarginThreshold() {
        return this.mMarginThreshold;
    }

    public int getBehindWidth() {
        return this.mContent.getWidth();
    }

    public void setContent(View view) {
        if (this.mContent != null) {
            removeView(this.mContent);
        }
        this.mContent = view;
        addView(this.mContent);
    }

    public View getContent() {
        return this.mContent;
    }

    public void setSecondaryContent(View view) {
        if (this.mSecondaryContent != null) {
            removeView(this.mSecondaryContent);
        }
        this.mSecondaryContent = view;
        addView(this.mSecondaryContent);
    }

    public View getSecondaryContent() {
        return this.mSecondaryContent;
    }

    public void setChildrenEnabled(boolean z) {
        this.mChildrenEnabled = z;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        if (this.mTransformer != null) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.mChildrenEnabled;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !this.mChildrenEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mTransformer != null) {
            canvas.save();
            this.mTransformer.transformCanvas(canvas, this.mViewAbove.getPercentOpen());
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.mContent.layout(0, 0, i5 - this.mWidthOffset, i6);
        if (this.mSecondaryContent != null) {
            this.mSecondaryContent.layout(0, 0, i5 - this.mWidthOffset, i6);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        int childMeasureSpec = getChildMeasureSpec(i, 0, defaultSize - this.mWidthOffset);
        int childMeasureSpec2 = getChildMeasureSpec(i2, 0, defaultSize2);
        this.mContent.measure(childMeasureSpec, childMeasureSpec2);
        if (this.mSecondaryContent != null) {
            this.mSecondaryContent.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public void setMode(int i) {
        if (i == 0 || i == 1) {
            if (this.mContent != null) {
                this.mContent.setVisibility(0);
            }
            if (this.mSecondaryContent != null) {
                this.mSecondaryContent.setVisibility(4);
            }
        }
        this.mMode = i;
    }

    public int getMode() {
        return this.mMode;
    }

    public void setScrollScale(float f) {
        this.mScrollScale = f;
    }

    public float getScrollScale() {
        return this.mScrollScale;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.mShadowDrawable = drawable;
        invalidate();
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.mSecondaryShadowDrawable = drawable;
        invalidate();
    }

    public void setShadowWidth(int i) {
        this.mShadowWidth = i;
        invalidate();
    }

    public void setFadeEnabled(boolean z) {
        this.mFadeEnabled = z;
    }

    public void setFadeType(int i) {
        this.mFadeType = i;
    }

    public void setFadeDegree(float f) {
        if (f > 1.0f || f < 0.0f) {
            throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
        }
        this.mFadeDegree = f;
    }

    public int getMenuPage(int i) {
        if (i > 1) {
            i = 2;
        } else if (i < 1) {
            i = 0;
        }
        if (this.mMode != 0 || i <= 1) {
            if (this.mMode != 1 || i >= 1) {
                return i;
            }
            return 2;
        }
        return 0;
    }

    public void scrollBehindTo(View view, int i, int i2) {
        if (this.mMode == 0) {
            r0 = i >= view.getLeft() ? 4 : 0;
            scrollTo((int) ((getBehindWidth() + i) * this.mScrollScale), i2);
        } else if (this.mMode == 1) {
            r0 = i <= view.getLeft() ? 4 : 0;
            scrollTo((int) ((getBehindWidth() - getWidth()) + ((i - getBehindWidth()) * this.mScrollScale)), i2);
        } else if (this.mMode == 2) {
            this.mContent.setVisibility(i >= view.getLeft() ? 4 : 0);
            this.mSecondaryContent.setVisibility(i <= view.getLeft() ? 4 : 0);
            r0 = i == 0 ? 4 : 0;
            if (i <= view.getLeft()) {
                scrollTo((int) ((getBehindWidth() + i) * this.mScrollScale), i2);
            } else {
                scrollTo((int) ((getBehindWidth() - getWidth()) + ((i - getBehindWidth()) * this.mScrollScale)), i2);
            }
        }
        if (r0 == 4) {
            Log.v("CustomViewBehind", "behind INVISIBLE");
        }
        setVisibility(r0);
    }

    public int getMenuLeft(View view, int i) {
        if (this.mMode == 0) {
            switch (i) {
                case 0:
                    return view.getLeft() - getBehindWidth();
                case 2:
                    return view.getLeft();
            }
        } else if (this.mMode == 1) {
            switch (i) {
                case 0:
                    return view.getLeft();
                case 2:
                    return view.getLeft() + getBehindWidth();
            }
        } else if (this.mMode == 2) {
            switch (i) {
                case 0:
                    return view.getLeft() - getBehindWidth();
                case 2:
                    return view.getLeft() + getBehindWidth();
            }
        }
        return view.getLeft();
    }

    public int getAbsLeftBound(View view) {
        if (this.mMode == 0 || this.mMode == 2) {
            return view.getLeft() - getBehindWidth();
        }
        if (this.mMode == 1) {
            return view.getLeft();
        }
        return 0;
    }

    public int getAbsRightBound(View view) {
        if (this.mMode == 0) {
            return view.getLeft();
        }
        if (this.mMode == 1 || this.mMode == 2) {
            return view.getLeft() + getBehindWidth();
        }
        return 0;
    }

    public boolean marginTouchAllowed(View view, int i) {
        int left = view.getLeft();
        int right = view.getRight();
        if (this.mMode == 0) {
            return i >= left && i <= left + this.mMarginThreshold;
        } else if (this.mMode == 1) {
            return i <= right && i >= right - this.mMarginThreshold;
        } else if (this.mMode == 2) {
            if (i < left || i > left + this.mMarginThreshold) {
                return i <= right && i >= right - this.mMarginThreshold;
            }
            return true;
        } else {
            return false;
        }
    }

    public void setTouchMode(int i) {
        this.mTouchMode = i;
    }

    public boolean menuOpenTouchAllowed(View view, int i, float f) {
        switch (this.mTouchMode) {
            case 0:
                return menuTouchInQuickReturn(view, i, f);
            case 1:
                return true;
            default:
                return false;
        }
    }

    public boolean menuTouchInQuickReturn(View view, int i, float f) {
        return (this.mMode == 0 || (this.mMode == 2 && i == 0)) ? f >= ((float) view.getLeft()) : (this.mMode == 1 || (this.mMode == 2 && i == 2)) && f <= ((float) view.getRight());
    }

    public boolean menuClosedSlideAllowed(float f) {
        return this.mMode == 0 ? f > 0.0f : this.mMode == 1 ? f < 0.0f : this.mMode == 2;
    }

    public boolean menuOpenSlideAllowed(float f) {
        return this.mMode == 0 ? f < 0.0f : this.mMode == 1 ? f > 0.0f : this.mMode == 2;
    }

    public void drawShadow(View view, Canvas canvas) {
        int i;
        if (this.mShadowDrawable != null && this.mShadowWidth > 0) {
            if (this.mMode == 0) {
                i = view.getLeft() - this.mShadowWidth;
            } else if (this.mMode == 1) {
                i = view.getRight();
            } else if (this.mMode == 2) {
                if (this.mSecondaryShadowDrawable != null) {
                    int right = view.getRight();
                    this.mSecondaryShadowDrawable.setBounds(right, 0, this.mShadowWidth + right, getHeight());
                    this.mSecondaryShadowDrawable.draw(canvas);
                }
                i = view.getLeft() - this.mShadowWidth;
            } else {
                i = 0;
            }
            this.mShadowDrawable.setBounds(i, 0, this.mShadowWidth + i, getHeight());
            this.mShadowDrawable.draw(canvas);
        }
    }

    public void drawFade(View view, Canvas canvas, float f) {
        int left;
        int i = 0;
        if (this.mFadeEnabled) {
            this.mFadePaint.setColor(Color.argb((int) (this.mFadeDegree * 255.0f * Math.abs(1.0f - f)), 0, 0, 0));
            if (this.mFadeType == 1) {
                if (this.mMode == 0) {
                    left = view.getLeft() - getBehindWidth();
                    i = view.getLeft();
                } else if (this.mMode == 1) {
                    left = view.getRight();
                    i = view.getRight() + getBehindWidth();
                } else if (this.mMode == 2) {
                    canvas.drawRect(view.getLeft() - getBehindWidth(), 0.0f, view.getLeft(), getHeight(), this.mFadePaint);
                    left = view.getRight();
                    i = view.getRight() + getBehindWidth();
                } else {
                    left = 0;
                }
            } else {
                left = view.getLeft() - getBehindWidth();
                i = view.getRight() + getBehindWidth();
            }
            canvas.drawRect(left, 0.0f, i, getHeight(), this.mFadePaint);
        }
    }

    public void drawSelector(View view, Canvas canvas, float f) {
        if (this.mSelectorEnabled && this.mSelectorDrawable != null && this.mSelectedView != null && ((String) this.mSelectedView.getTag(R.id.selected_view)).equals("CustomViewBehindSelectedView")) {
            canvas.save();
            int width = (int) (this.mSelectorDrawable.getWidth() * f);
            if (this.mMode == 0) {
                int left = view.getLeft();
                int i = left - width;
                canvas.clipRect(i, 0, left, getHeight());
                canvas.drawBitmap(this.mSelectorDrawable, i, getSelectorTop(), (Paint) null);
            } else if (this.mMode == 1) {
                int right = view.getRight();
                int i2 = width + right;
                canvas.clipRect(right, 0, i2, getHeight());
                canvas.drawBitmap(this.mSelectorDrawable, i2 - this.mSelectorDrawable.getWidth(), getSelectorTop(), (Paint) null);
            }
            canvas.restore();
        }
    }

    public void setSelectorEnabled(boolean z) {
        this.mSelectorEnabled = z;
    }

    public void setSelectedView(View view) {
        if (this.mSelectedView != null) {
            this.mSelectedView.setTag(R.id.selected_view, null);
            this.mSelectedView = null;
        }
        if (view != null && view.getParent() != null) {
            this.mSelectedView = view;
            this.mSelectedView.setTag(R.id.selected_view, "CustomViewBehindSelectedView");
            invalidate();
        }
    }

    private int getSelectorTop() {
        return this.mSelectedView.getTop() + ((this.mSelectedView.getHeight() - this.mSelectorDrawable.getHeight()) / 2);
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.mSelectorDrawable = bitmap;
        refreshDrawableState();
    }
}
