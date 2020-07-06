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
/* loaded from: classes5.dex */
public class FlexboxLayout extends ViewGroup implements a {
    @Nullable
    private Drawable mZA;
    @Nullable
    private Drawable mZB;
    private int mZC;
    private int mZD;
    private int mZE;
    private int mZF;
    private int[] mZG;
    private SparseIntArray mZH;
    private c mZI;
    private c.a mZJ;
    private List<b> mZs;
    private int mZu;
    private int mZv;
    private int mZw;
    private int mZx;
    private int mZy;
    private int mZz;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mZz = -1;
        this.mZI = new c(this);
        this.mZs = new ArrayList();
        this.mZJ = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.mZu = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.mZv = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.mZw = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.mZx = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.mZy = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.mZz = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.mZD = i2;
            this.mZC = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mZD = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mZC = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mZH == null) {
            this.mZH = new SparseIntArray(getChildCount());
        }
        if (this.mZI.d(this.mZH)) {
            this.mZG = this.mZI.c(this.mZH);
        }
        switch (this.mZu) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mZu);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View Jz(int i) {
        return getChildAt(i);
    }

    public View JH(int i) {
        if (i < 0 || i >= this.mZG.length) {
            return null;
        }
        return getChildAt(this.mZG[i]);
    }

    @Override // com.google.android.flexbox.a
    public View JA(int i) {
        return JH(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mZH == null) {
            this.mZH = new SparseIntArray(getChildCount());
        }
        this.mZG = this.mZI.a(view, i, layoutParams, this.mZH);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.mZs.clear();
        this.mZJ.reset();
        this.mZI.a(this.mZJ, i, i2);
        this.mZs = this.mZJ.mZs;
        this.mZI.dC(i, i2);
        if (this.mZx == 3) {
            for (b bVar : this.mZs) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View JH = JH(bVar.mZl + i5);
                        if (JH != null && JH.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) JH.getLayoutParams();
                            if (this.mZv != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + JH.getMeasuredHeight() + Math.max(bVar.mZi - JH.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + JH.getMeasuredHeight() + Math.max((bVar.mZi - JH.getMeasuredHeight()) + JH.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.mZe = i4;
            }
        }
        this.mZI.aj(i, i2, getPaddingTop() + getPaddingBottom());
        this.mZI.dHs();
        I(this.mZu, i, i2, this.mZJ.mZt);
    }

    private void measureVertical(int i, int i2) {
        this.mZs.clear();
        this.mZJ.reset();
        this.mZI.b(this.mZJ, i, i2);
        this.mZs = this.mZJ.mZs;
        this.mZI.dC(i, i2);
        this.mZI.aj(i, i2, getPaddingLeft() + getPaddingRight());
        this.mZI.dHs();
        I(this.mZu, i, i2, this.mZJ.mZt);
    }

    private void I(int i, int i2, int i3, int i4) {
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
        Iterator<b> it = this.mZs.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().mZc);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mZs.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.mZs.get(i2);
            if (JI(i2)) {
                if (dHk()) {
                    i += this.mZE;
                } else {
                    i += this.mZF;
                }
            }
            if (JK(i2)) {
                if (dHk()) {
                    i += this.mZE;
                } else {
                    i += this.mZF;
                }
            }
            i += bVar.mZe;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean dHk() {
        return this.mZu == 0 || this.mZu == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.mZu) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.mZv == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.mZv == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.mZu);
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int dHr;
        float f;
        float f2;
        int dHr2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.mZs.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.mZs.get(i7);
                if (JI(i7)) {
                    paddingBottom -= this.mZE;
                    paddingTop += this.mZE;
                }
                float f5 = 0.0f;
                switch (this.mZw) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.mZc) + paddingRight;
                        f2 = bVar.mZc - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.mZc) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.mZc) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.mZc) / (bVar.dHr() != 1 ? dHr2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int dHr3 = bVar.dHr();
                        if (dHr3 != 0) {
                            f5 = (i5 - bVar.mZc) / dHr3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dHr() != 0) {
                            f5 = (i5 - bVar.mZc) / (dHr + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mZw);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.mZl + i9;
                        View JH = JH(i10);
                        if (JH != null && JH.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) JH.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (dE(i10, i9)) {
                                i11 = this.mZF;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.mZD & 4) > 0) {
                                i12 = this.mZF;
                            }
                            if (this.mZv == 2) {
                                if (z) {
                                    this.mZI.a(JH, bVar, Math.round(f3) - JH.getMeasuredWidth(), paddingBottom - JH.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.mZI.a(JH, bVar, Math.round(f4), paddingBottom - JH.getMeasuredHeight(), Math.round(f4) + JH.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.mZI.a(JH, bVar, Math.round(f3) - JH.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + JH.getMeasuredHeight());
                            } else {
                                this.mZI.a(JH, bVar, Math.round(f4), paddingTop, Math.round(f4) + JH.getMeasuredWidth(), paddingTop + JH.getMeasuredHeight());
                            }
                            f6 = f4 + JH.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((JH.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(JH, i12, 0, i11, 0);
                            } else {
                                bVar.g(JH, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.mZe;
                paddingBottom -= bVar.mZe;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int dHr;
        float f;
        float f2;
        int dHr2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.mZs.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.mZs.get(i8);
                if (JI(i8)) {
                    paddingLeft += this.mZF;
                    i6 -= this.mZF;
                }
                float f5 = 0.0f;
                switch (this.mZw) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.mZc) + paddingBottom;
                        f2 = bVar.mZc - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.mZc) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.mZc) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.mZc) / (bVar.dHr() != 1 ? dHr2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int dHr3 = bVar.dHr();
                        if (dHr3 != 0) {
                            f5 = (i5 - bVar.mZc) / dHr3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dHr() != 0) {
                            f5 = (i5 - bVar.mZc) / (dHr + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mZw);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.mZl + i10;
                        View JH = JH(i11);
                        if (JH != null && JH.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) JH.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (dE(i11, i10)) {
                                i12 = this.mZE;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.mZC & 4) > 0) {
                                i13 = this.mZE;
                            }
                            if (z) {
                                if (z2) {
                                    this.mZI.a(JH, bVar, true, i6 - JH.getMeasuredWidth(), Math.round(f3) - JH.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.mZI.a(JH, bVar, true, i6 - JH.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + JH.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.mZI.a(JH, bVar, false, paddingLeft, Math.round(f3) - JH.getMeasuredHeight(), paddingLeft + JH.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.mZI.a(JH, bVar, false, paddingLeft, Math.round(f4), paddingLeft + JH.getMeasuredWidth(), Math.round(f4) + JH.getMeasuredHeight());
                            }
                            f6 = f4 + JH.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((JH.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(JH, 0, i13, 0, i12);
                            } else {
                                bVar.g(JH, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.mZe;
                i6 -= bVar.mZe;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.mZB != null || this.mZA != null) {
            if (this.mZC != 0 || this.mZD != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.mZu) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.mZv == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.mZv == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.mZv != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.mZv != 2) {
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
        int size = this.mZs.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mZs.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mZl + i4;
                View JH = JH(i5);
                if (JH != null && JH.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) JH.getLayoutParams();
                    if (dE(i5, i4)) {
                        if (z) {
                            left = JH.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (JH.getLeft() - layoutParams.leftMargin) - this.mZF;
                        }
                        a(canvas, left, bVar.mTop, bVar.mZe);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mZD & 4) > 0) {
                        if (z) {
                            right = (JH.getLeft() - layoutParams.leftMargin) - this.mZF;
                        } else {
                            right = layoutParams.rightMargin + JH.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.mZe);
                    }
                }
            }
            if (JI(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.mZE;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (JK(i3) && (this.mZC & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.mZE;
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
        int top2;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.mZs.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mZs.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mZl + i4;
                View JH = JH(i5);
                if (JH != null && JH.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) JH.getLayoutParams();
                    if (dE(i5, i4)) {
                        if (z2) {
                            top2 = JH.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top2 = (JH.getTop() - layoutParams.topMargin) - this.mZE;
                        }
                        b(canvas, bVar.mLeft, top2, bVar.mZe);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mZC & 4) > 0) {
                        if (z2) {
                            bottom = (JH.getTop() - layoutParams.topMargin) - this.mZE;
                        } else {
                            bottom = layoutParams.bottomMargin + JH.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.mZe);
                    }
                }
            }
            if (JI(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.mZF;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (JK(i3) && (this.mZD & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.mZF;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.mZB != null) {
            this.mZB.setBounds(i, i2, this.mZF + i, i2 + i3);
            this.mZB.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.mZA != null) {
            this.mZA.setBounds(i, i2, i + i3, this.mZE + i2);
            this.mZA.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: i */
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
        return this.mZu;
    }

    public void setFlexDirection(int i) {
        if (this.mZu != i) {
            this.mZu = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mZv;
    }

    public void setFlexWrap(int i) {
        if (this.mZv != i) {
            this.mZv = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.mZw;
    }

    public void setJustifyContent(int i) {
        if (this.mZw != i) {
            this.mZw = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mZx;
    }

    public void setAlignItems(int i) {
        if (this.mZx != i) {
            this.mZx = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.mZy;
    }

    public void setAlignContent(int i) {
        if (this.mZy != i) {
            this.mZy = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mZz;
    }

    public void setMaxLine(int i) {
        if (this.mZz != i) {
            this.mZz = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mZs.size());
        for (b bVar : this.mZs) {
            if (bVar.dHr() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int i(View view, int i, int i2) {
        int i3;
        if (dHk()) {
            i3 = dE(i, i2) ? 0 + this.mZF : 0;
            if ((this.mZD & 4) > 0) {
                return i3 + this.mZF;
            }
            return i3;
        }
        i3 = dE(i, i2) ? 0 + this.mZE : 0;
        if ((this.mZC & 4) > 0) {
            return i3 + this.mZE;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dl(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (dHk()) {
            if ((this.mZD & 4) > 0) {
                bVar.mZc += this.mZF;
                bVar.mZd += this.mZF;
            }
        } else if ((this.mZC & 4) > 0) {
            bVar.mZc += this.mZE;
            bVar.mZd += this.mZE;
        }
    }

    @Override // com.google.android.flexbox.a
    public int ag(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public int ah(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, b bVar) {
        if (dE(i, i2)) {
            if (dHk()) {
                bVar.mZc += this.mZF;
                bVar.mZd += this.mZF;
                return;
            }
            bVar.mZc += this.mZE;
            bVar.mZd += this.mZE;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.mZs = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.mZs;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.mZA;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mZB;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.mZA) {
            this.mZA = drawable;
            if (drawable != null) {
                this.mZE = drawable.getIntrinsicHeight();
            } else {
                this.mZE = 0;
            }
            dHt();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.mZB) {
            this.mZB = drawable;
            if (drawable != null) {
                this.mZF = drawable.getIntrinsicWidth();
            } else {
                this.mZF = 0;
            }
            dHt();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.mZD;
    }

    public int getShowDividerHorizontal() {
        return this.mZC;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mZD) {
            this.mZD = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mZC) {
            this.mZC = i;
            requestLayout();
        }
    }

    private void dHt() {
        if (this.mZA == null && this.mZB == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean dE(int i, int i2) {
        return dF(i, i2) ? dHk() ? (this.mZD & 1) != 0 : (this.mZC & 1) != 0 : dHk() ? (this.mZD & 2) != 0 : (this.mZC & 2) != 0;
    }

    private boolean dF(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View JH = JH(i - i3);
            if (JH != null && JH.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean JI(int i) {
        if (i < 0 || i >= this.mZs.size()) {
            return false;
        }
        return JJ(i) ? dHk() ? (this.mZC & 1) != 0 : (this.mZD & 1) != 0 : dHk() ? (this.mZC & 2) != 0 : (this.mZD & 2) != 0;
    }

    private boolean JJ(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mZs.get(i2).dHr() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean JK(int i) {
        if (i < 0 || i >= this.mZs.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.mZs.size()) {
                if (this.mZs.get(i3).dHr() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (dHk()) {
                return (this.mZC & 4) != 0;
            } else {
                return (this.mZD & 4) != 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayout.LayoutParams.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ai */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: JL */
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

        public LayoutParams(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
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

        public void setFlexShrink(float f) {
            this.mFlexShrink = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dHl() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        public void setMinWidth(int i) {
            this.mMinWidth = i;
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
        public boolean dHm() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dHn() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dHo() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dHp() {
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
