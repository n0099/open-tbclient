package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes3.dex */
public class LetterIndexBar extends View {
    public static final int INDEX_COUNT_DEFAULT = 27;
    public static final String SEARCH_ICON_LETTER = "";
    private int count;
    private int mIndex;
    private String[] mIndexLetter;
    private int mItemHeight;
    private int mItemPadding;
    private OnIndexChangeListener mListener;
    private boolean[] mNeedIndex;
    private int mOrgTextSzie;
    private Paint mPaint;
    private RectF mRect;
    private Drawable mSeatchIcon;
    private boolean mTouching;

    /* loaded from: classes3.dex */
    public interface OnIndexChangeListener {
        void onIndexChange(int i);
    }

    public LetterIndexBar(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.count = 27;
        init();
    }

    public LetterIndexBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.count = 27;
        init();
    }

    public LetterIndexBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.count = 27;
        init();
    }

    private void init() {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-10658467);
        this.mOrgTextSzie = ResourceManager.dp2px(getContext(), 13);
    }

    public void setIndexMark(boolean[] zArr) {
        if (zArr != null) {
            this.mNeedIndex = zArr;
            invalidate();
        }
    }

    public void setIndexLetter(String[] strArr) {
        if (strArr != null) {
            this.mIndexLetter = strArr;
            this.count = this.mIndexLetter.length;
            this.mIndex = -1;
            invalidate();
        }
    }

    public void setIndexChangeListener(OnIndexChangeListener onIndexChangeListener) {
        this.mListener = onIndexChangeListener;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        String valueOf;
        int i2 = 0;
        super.onDraw(canvas);
        if (this.mTouching) {
            int color = this.mPaint.getColor();
            this.mPaint.setColor(-2005436536);
            canvas.drawRoundRect(this.mRect, getMeasuredWidth() / 2, getMeasuredWidth() / 2, this.mPaint);
            this.mPaint.setColor(color);
        }
        if (this.mOrgTextSzie > this.mItemHeight) {
            i = this.mItemHeight;
        } else {
            i = this.mOrgTextSzie;
        }
        this.mPaint.setTextSize(i);
        if (this.mIndexLetter == null) {
            char c = 'A';
            while (i2 < this.count) {
                int paddingTop = this.mItemPadding + (this.mItemHeight * i2) + getPaddingTop() + i;
                if (this.mNeedIndex == null || this.mNeedIndex[i2]) {
                    if (i2 == this.count - 1) {
                        valueOf = "#";
                    } else {
                        valueOf = String.valueOf(c);
                        c = (char) (c + 1);
                    }
                    canvas.drawText(valueOf, (getMeasuredWidth() - ((int) this.mPaint.measureText(valueOf))) / 2, paddingTop, this.mPaint);
                }
                i2++;
            }
            return;
        }
        while (i2 < this.count) {
            int paddingTop2 = (this.mItemHeight * i2) + getPaddingTop() + i + this.mItemPadding;
            if (this.mNeedIndex == null || this.mNeedIndex[i2]) {
                String str = this.mIndexLetter[i2];
                if (str.equals("")) {
                    int measureText = (int) this.mPaint.measureText("M");
                    int measuredWidth = (getMeasuredWidth() - measureText) / 2;
                    this.mSeatchIcon.setBounds(measuredWidth, paddingTop2 - measuredWidth, measureText + measuredWidth, (paddingTop2 + measureText) - measuredWidth);
                    this.mSeatchIcon.draw(canvas);
                } else {
                    canvas.drawText(str, (getMeasuredWidth() - ((int) this.mPaint.measureText(str))) / 2, paddingTop2, this.mPaint);
                }
            }
            i2++;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        this.mItemHeight = ((size - getPaddingTop()) - getPaddingBottom()) / this.count;
        this.mItemPadding = (int) ((this.mItemHeight - this.mPaint.getTextSize()) / 2.0f);
        setMeasuredDimension(this.mOrgTextSzie + getPaddingLeft() + getPaddingRight(), i2);
        this.mRect = new RectF(0.0f, getPaddingTop(), getMeasuredWidth(), (size - getPaddingTop()) - getPaddingBottom());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.mTouching = true;
                int y = (((int) motionEvent.getY()) - getPaddingTop()) / this.mItemHeight;
                if (y != this.mIndex && ((this.mNeedIndex == null || this.mNeedIndex[y]) && y < this.count && y >= 0)) {
                    this.mIndex = y;
                    if (this.mListener != null) {
                        this.mListener.onIndexChange(this.mIndex);
                        break;
                    }
                }
                break;
            case 1:
            case 3:
            case 4:
                this.mTouching = false;
                break;
        }
        invalidate();
        return true;
    }
}
