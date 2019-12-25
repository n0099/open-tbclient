package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.flexbox.c;
import com.google.android.flexbox.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FlexboxLayout extends ViewGroup implements a {
    private List<b> mEY;
    private int mFa;
    private int mFb;
    private int mFc;
    private int mFd;
    private int mFe;
    private int mFf;
    @Nullable
    private Drawable mFg;
    @Nullable
    private Drawable mFh;
    private int mFi;
    private int mFj;
    private int mFk;
    private int mFl;
    private int[] mFm;
    private SparseIntArray mFn;
    private c mFo;
    private c.a mFp;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFf = -1;
        this.mFo = new c(this);
        this.mEY = new ArrayList();
        this.mFp = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.mFa = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.mFb = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.mFc = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.mFd = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.mFe = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.mFf = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(d.a.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(d.a.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(d.a.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i2 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDivider, 0);
        if (i2 != 0) {
            this.mFj = i2;
            this.mFi = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mFj = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mFi = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mFn == null) {
            this.mFn = new SparseIntArray(getChildCount());
        }
        if (this.mFo.d(this.mFn)) {
            this.mFm = this.mFo.c(this.mFn);
        }
        switch (this.mFa) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFa);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View LQ(int i) {
        return getChildAt(i);
    }

    public View LY(int i) {
        if (i < 0 || i >= this.mFm.length) {
            return null;
        }
        return getChildAt(this.mFm[i]);
    }

    @Override // com.google.android.flexbox.a
    public View LR(int i) {
        return LY(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mFn == null) {
            this.mFn = new SparseIntArray(getChildCount());
        }
        this.mFm = this.mFo.a(view, i, layoutParams, this.mFn);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.mEY.clear();
        this.mFp.reset();
        this.mFo.a(this.mFp, i, i2);
        this.mEY = this.mFp.mEY;
        this.mFo.ea(i, i2);
        if (this.mFd == 3) {
            for (b bVar : this.mEY) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View LY = LY(bVar.mER + i5);
                        if (LY != null && LY.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) LY.getLayoutParams();
                            if (this.mFb != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + LY.getMeasuredHeight() + Math.max(bVar.mEO - LY.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + LY.getMeasuredHeight() + Math.max((bVar.mEO - LY.getMeasuredHeight()) + LY.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.mEK = i4;
            }
        }
        this.mFo.ap(i, i2, getPaddingTop() + getPaddingBottom());
        this.mFo.dxW();
        N(this.mFa, i, i2, this.mFp.mEZ);
    }

    private void measureVertical(int i, int i2) {
        this.mEY.clear();
        this.mFp.reset();
        this.mFo.b(this.mFp, i, i2);
        this.mEY = this.mFp.mEY;
        this.mFo.ea(i, i2);
        this.mFo.ap(i, i2, getPaddingLeft() + getPaddingRight());
        this.mFo.dxW();
        N(this.mFa, i, i2, this.mFp.mEZ);
    }

    private void N(int i, int i2, int i3, int i4) {
        int largestMainSize;
        int sumOfCrossSize;
        int resolveSizeAndState;
        int i5;
        int resolveSizeAndState2;
        int i6;
        int i7;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        switch (i) {
            case 0:
            case 1:
                largestMainSize = getPaddingBottom() + getSumOfCrossSize() + getPaddingTop();
                sumOfCrossSize = getLargestMainSize();
                break;
            case 2:
            case 3:
                largestMainSize = getLargestMainSize();
                sumOfCrossSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
                break;
            default:
                throw new IllegalArgumentException("Invalid flex direction: " + i);
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size < sumOfCrossSize) {
                    i4 = View.combineMeasuredStates(i4, 16777216);
                } else {
                    size = sumOfCrossSize;
                }
                resolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
                i5 = i4;
                break;
            case 0:
                resolveSizeAndState = View.resolveSizeAndState(sumOfCrossSize, i2, i4);
                i5 = i4;
                break;
            case 1073741824:
                if (size < sumOfCrossSize) {
                    i4 = View.combineMeasuredStates(i4, 16777216);
                }
                resolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
                i5 = i4;
                break;
            default:
                throw new IllegalStateException("Unknown width mode is set: " + mode);
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                if (size2 < largestMainSize) {
                    i6 = View.combineMeasuredStates(i5, 256);
                    i7 = size2;
                } else {
                    i6 = i5;
                    i7 = largestMainSize;
                }
                resolveSizeAndState2 = View.resolveSizeAndState(i7, i3, i6);
                break;
            case 0:
                resolveSizeAndState2 = View.resolveSizeAndState(largestMainSize, i3, i5);
                break;
            case 1073741824:
                if (size2 < largestMainSize) {
                    i5 = View.combineMeasuredStates(i5, 256);
                }
                resolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i5);
                break;
            default:
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        int i = Integer.MIN_VALUE;
        Iterator<b> it = this.mEY.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().mEI);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mEY.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.mEY.get(i2);
            if (LZ(i2)) {
                if (dxN()) {
                    i += this.mFk;
                } else {
                    i += this.mFl;
                }
            }
            if (Mb(i2)) {
                if (dxN()) {
                    i += this.mFk;
                } else {
                    i += this.mFl;
                }
            }
            i += bVar.mEK;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean dxN() {
        return this.mFa == 0 || this.mFa == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.mFa) {
            case 0:
                b(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                b(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.mFb == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.mFb == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.mFa);
        }
    }

    private void b(boolean z, int i, int i2, int i3, int i4) {
        int dxV;
        float f;
        float f2;
        int dxV2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.mEY.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.mEY.get(i7);
                if (LZ(i7)) {
                    paddingBottom -= this.mFk;
                    paddingTop += this.mFk;
                }
                float f5 = 0.0f;
                switch (this.mFc) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.mEI) + paddingRight;
                        f2 = bVar.mEI - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.mEI) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.mEI) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.mEI) / (bVar.dxV() != 1 ? dxV2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int dxV3 = bVar.dxV();
                        if (dxV3 != 0) {
                            f5 = (i5 - bVar.mEI) / dxV3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dxV() != 0) {
                            f5 = (i5 - bVar.mEI) / (dxV + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mFc);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.mER + i9;
                        View LY = LY(i10);
                        if (LY != null && LY.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) LY.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (ec(i10, i9)) {
                                i11 = this.mFl;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.mFj & 4) > 0) {
                                i12 = this.mFl;
                            }
                            if (this.mFb == 2) {
                                if (z) {
                                    this.mFo.a(LY, bVar, Math.round(f3) - LY.getMeasuredWidth(), paddingBottom - LY.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.mFo.a(LY, bVar, Math.round(f4), paddingBottom - LY.getMeasuredHeight(), Math.round(f4) + LY.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.mFo.a(LY, bVar, Math.round(f3) - LY.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + LY.getMeasuredHeight());
                            } else {
                                this.mFo.a(LY, bVar, Math.round(f4), paddingTop, Math.round(f4) + LY.getMeasuredWidth(), paddingTop + LY.getMeasuredHeight());
                            }
                            f6 = f4 + LY.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((LY.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(LY, i12, 0, i11, 0);
                            } else {
                                bVar.g(LY, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.mEK;
                paddingBottom -= bVar.mEK;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int dxV;
        float f;
        float f2;
        int dxV2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.mEY.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.mEY.get(i8);
                if (LZ(i8)) {
                    paddingLeft += this.mFl;
                    i6 -= this.mFl;
                }
                float f5 = 0.0f;
                switch (this.mFc) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.mEI) + paddingBottom;
                        f2 = bVar.mEI - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.mEI) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.mEI) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.mEI) / (bVar.dxV() != 1 ? dxV2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int dxV3 = bVar.dxV();
                        if (dxV3 != 0) {
                            f5 = (i5 - bVar.mEI) / dxV3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dxV() != 0) {
                            f5 = (i5 - bVar.mEI) / (dxV + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mFc);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.mER + i10;
                        View LY = LY(i11);
                        if (LY != null && LY.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) LY.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (ec(i11, i10)) {
                                i12 = this.mFk;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.mFi & 4) > 0) {
                                i13 = this.mFk;
                            }
                            if (z) {
                                if (z2) {
                                    this.mFo.a(LY, bVar, true, i6 - LY.getMeasuredWidth(), Math.round(f3) - LY.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.mFo.a(LY, bVar, true, i6 - LY.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + LY.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.mFo.a(LY, bVar, false, paddingLeft, Math.round(f3) - LY.getMeasuredHeight(), paddingLeft + LY.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.mFo.a(LY, bVar, false, paddingLeft, Math.round(f4), paddingLeft + LY.getMeasuredWidth(), Math.round(f4) + LY.getMeasuredHeight());
                            }
                            f6 = f4 + LY.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((LY.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(LY, 0, i13, 0, i12);
                            } else {
                                bVar.g(LY, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.mEK;
                i6 -= bVar.mEK;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.mFh != null || this.mFg != null) {
            if (this.mFi != 0 || this.mFj != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.mFa) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.mFb == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.mFb == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.mFb != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.mFb != 2) {
                            z = z3;
                        } else if (!z3) {
                            z = true;
                        }
                        b(canvas, z, true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void a(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.mEY.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mEY.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mER + i4;
                View LY = LY(i5);
                if (LY != null && LY.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) LY.getLayoutParams();
                    if (ec(i5, i4)) {
                        if (z) {
                            left = LY.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (LY.getLeft() - layoutParams.leftMargin) - this.mFl;
                        }
                        a(canvas, left, bVar.mTop, bVar.mEK);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mFj & 4) > 0) {
                        if (z) {
                            right = (LY.getLeft() - layoutParams.leftMargin) - this.mFl;
                        } else {
                            right = layoutParams.rightMargin + LY.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.mEK);
                    }
                }
            }
            if (LZ(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.mFk;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (Mb(i3) && (this.mFi & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.mFk;
                } else {
                    i = bVar.mBottom;
                }
                b(canvas, paddingLeft, i, max);
            }
        }
    }

    private void b(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.mEY.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mEY.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mER + i4;
                View LY = LY(i5);
                if (LY != null && LY.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) LY.getLayoutParams();
                    if (ec(i5, i4)) {
                        if (z2) {
                            top = LY.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (LY.getTop() - layoutParams.topMargin) - this.mFk;
                        }
                        b(canvas, bVar.mLeft, top, bVar.mEK);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mFi & 4) > 0) {
                        if (z2) {
                            bottom = (LY.getTop() - layoutParams.topMargin) - this.mFk;
                        } else {
                            bottom = layoutParams.bottomMargin + LY.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.mEK);
                    }
                }
            }
            if (LZ(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.mFl;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (Mb(i3) && (this.mFj & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.mFl;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.mFh != null) {
            this.mFh.setBounds(i, i2, this.mFl + i, i2 + i3);
            this.mFh.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.mFg != null) {
            this.mFg.setBounds(i, i2, i + i3, this.mFk + i2);
            this.mFg.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: h */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mFa;
    }

    public void setFlexDirection(int i) {
        if (this.mFa != i) {
            this.mFa = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mFb;
    }

    public void setFlexWrap(int i) {
        if (this.mFb != i) {
            this.mFb = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.mFc;
    }

    public void setJustifyContent(int i) {
        if (this.mFc != i) {
            this.mFc = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mFd;
    }

    public void setAlignItems(int i) {
        if (this.mFd != i) {
            this.mFd = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.mFe;
    }

    public void setAlignContent(int i) {
        if (this.mFe != i) {
            this.mFe = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mFf;
    }

    public void setMaxLine(int i) {
        if (this.mFf != i) {
            this.mFf = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mEY.size());
        for (b bVar : this.mEY) {
            if (bVar.dxV() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int g(View view, int i, int i2) {
        int i3;
        if (dxN()) {
            i3 = ec(i, i2) ? 0 + this.mFl : 0;
            if ((this.mFj & 4) > 0) {
                return i3 + this.mFl;
            }
            return i3;
        }
        i3 = ec(i, i2) ? 0 + this.mFk : 0;
        if ((this.mFi & 4) > 0) {
            return i3 + this.mFk;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dg(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (dxN()) {
            if ((this.mFj & 4) > 0) {
                bVar.mEI += this.mFl;
                bVar.mEJ += this.mFl;
            }
        } else if ((this.mFi & 4) > 0) {
            bVar.mEI += this.mFk;
            bVar.mEJ += this.mFk;
        }
    }

    @Override // com.google.android.flexbox.a
    public int am(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public int an(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, b bVar) {
        if (ec(i, i2)) {
            if (dxN()) {
                bVar.mEI += this.mFl;
                bVar.mEJ += this.mFl;
                return;
            }
            bVar.mEI += this.mFk;
            bVar.mEJ += this.mFk;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.mEY = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.mEY;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.mFg;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mFh;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.mFg) {
            this.mFg = drawable;
            if (drawable != null) {
                this.mFk = drawable.getIntrinsicHeight();
            } else {
                this.mFk = 0;
            }
            dxX();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.mFh) {
            this.mFh = drawable;
            if (drawable != null) {
                this.mFl = drawable.getIntrinsicWidth();
            } else {
                this.mFl = 0;
            }
            dxX();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.mFj;
    }

    public int getShowDividerHorizontal() {
        return this.mFi;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mFj) {
            this.mFj = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mFi) {
            this.mFi = i;
            requestLayout();
        }
    }

    private void dxX() {
        if (this.mFg == null && this.mFh == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean ec(int i, int i2) {
        return ed(i, i2) ? dxN() ? (this.mFj & 1) != 0 : (this.mFi & 1) != 0 : dxN() ? (this.mFj & 2) != 0 : (this.mFi & 2) != 0;
    }

    private boolean ed(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View LY = LY(i - i3);
            if (LY != null && LY.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean LZ(int i) {
        if (i < 0 || i >= this.mEY.size()) {
            return false;
        }
        return Ma(i) ? dxN() ? (this.mFi & 1) != 0 : (this.mFj & 1) != 0 : dxN() ? (this.mFi & 2) != 0 : (this.mFj & 2) != 0;
    }

    private boolean Ma(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mEY.get(i2).dxV() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean Mb(int i) {
        if (i < 0 || i >= this.mEY.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.mEY.size()) {
                if (this.mEY.get(i3).dxV() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (dxN()) {
                return (this.mFi & 4) != 0;
            } else {
                return (this.mFj & 4) != 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayout.LayoutParams.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: aO */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Mc */
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        };
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private int mOrder;
        private boolean mWrapBefore;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout_Layout);
            this.mOrder = obtainStyledAttributes.getInt(d.a.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = obtainStyledAttributes.getFloat(d.a.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = obtainStyledAttributes.getFloat(d.a.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = obtainStyledAttributes.getInt(d.a.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = obtainStyledAttributes.getFraction(d.a.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(d.a.FlexboxLayout_Layout_layout_minWidth, 0);
            this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(d.a.FlexboxLayout_Layout_layout_minHeight, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(d.a.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(d.a.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = obtainStyledAttributes.getBoolean(d.a.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = layoutParams.mOrder;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return this.width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return this.height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.mOrder;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dxO() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dxP() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean dxQ() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dxR() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dxS() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dxT() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mOrder);
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = parcel.readInt();
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }
}
