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
    private int mZA;
    private int mZB;
    private int mZC;
    private int[] mZD;
    private SparseIntArray mZE;
    private c mZF;
    private c.a mZG;
    private List<b> mZp;
    private int mZr;
    private int mZs;
    private int mZt;
    private int mZu;
    private int mZv;
    private int mZw;
    @Nullable
    private Drawable mZx;
    @Nullable
    private Drawable mZy;
    private int mZz;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mZw = -1;
        this.mZF = new c(this);
        this.mZp = new ArrayList();
        this.mZG = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.mZr = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.mZs = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.mZt = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.mZu = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.mZv = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.mZw = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.mZA = i2;
            this.mZz = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mZA = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mZz = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mZE == null) {
            this.mZE = new SparseIntArray(getChildCount());
        }
        if (this.mZF.d(this.mZE)) {
            this.mZD = this.mZF.c(this.mZE);
        }
        switch (this.mZr) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mZr);
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
        if (i < 0 || i >= this.mZD.length) {
            return null;
        }
        return getChildAt(this.mZD[i]);
    }

    @Override // com.google.android.flexbox.a
    public View JA(int i) {
        return JH(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mZE == null) {
            this.mZE = new SparseIntArray(getChildCount());
        }
        this.mZD = this.mZF.a(view, i, layoutParams, this.mZE);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.mZp.clear();
        this.mZG.reset();
        this.mZF.a(this.mZG, i, i2);
        this.mZp = this.mZG.mZp;
        this.mZF.dC(i, i2);
        if (this.mZu == 3) {
            for (b bVar : this.mZp) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View JH = JH(bVar.mZi + i5);
                        if (JH != null && JH.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) JH.getLayoutParams();
                            if (this.mZs != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + JH.getMeasuredHeight() + Math.max(bVar.mZf - JH.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + JH.getMeasuredHeight() + Math.max((bVar.mZf - JH.getMeasuredHeight()) + JH.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.mZb = i4;
            }
        }
        this.mZF.aj(i, i2, getPaddingTop() + getPaddingBottom());
        this.mZF.dHo();
        I(this.mZr, i, i2, this.mZG.mZq);
    }

    private void measureVertical(int i, int i2) {
        this.mZp.clear();
        this.mZG.reset();
        this.mZF.b(this.mZG, i, i2);
        this.mZp = this.mZG.mZp;
        this.mZF.dC(i, i2);
        this.mZF.aj(i, i2, getPaddingLeft() + getPaddingRight());
        this.mZF.dHo();
        I(this.mZr, i, i2, this.mZG.mZq);
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
        Iterator<b> it = this.mZp.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().mYZ);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mZp.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.mZp.get(i2);
            if (JI(i2)) {
                if (dHg()) {
                    i += this.mZB;
                } else {
                    i += this.mZC;
                }
            }
            if (JK(i2)) {
                if (dHg()) {
                    i += this.mZB;
                } else {
                    i += this.mZC;
                }
            }
            i += bVar.mZb;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean dHg() {
        return this.mZr == 0 || this.mZr == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.mZr) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.mZs == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.mZs == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.mZr);
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int dHn;
        float f;
        float f2;
        int dHn2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.mZp.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.mZp.get(i7);
                if (JI(i7)) {
                    paddingBottom -= this.mZB;
                    paddingTop += this.mZB;
                }
                float f5 = 0.0f;
                switch (this.mZt) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.mYZ) + paddingRight;
                        f2 = bVar.mYZ - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.mYZ) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.mYZ) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.mYZ) / (bVar.dHn() != 1 ? dHn2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int dHn3 = bVar.dHn();
                        if (dHn3 != 0) {
                            f5 = (i5 - bVar.mYZ) / dHn3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dHn() != 0) {
                            f5 = (i5 - bVar.mYZ) / (dHn + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mZt);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.mZi + i9;
                        View JH = JH(i10);
                        if (JH != null && JH.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) JH.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (dE(i10, i9)) {
                                i11 = this.mZC;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.mZA & 4) > 0) {
                                i12 = this.mZC;
                            }
                            if (this.mZs == 2) {
                                if (z) {
                                    this.mZF.a(JH, bVar, Math.round(f3) - JH.getMeasuredWidth(), paddingBottom - JH.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.mZF.a(JH, bVar, Math.round(f4), paddingBottom - JH.getMeasuredHeight(), Math.round(f4) + JH.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.mZF.a(JH, bVar, Math.round(f3) - JH.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + JH.getMeasuredHeight());
                            } else {
                                this.mZF.a(JH, bVar, Math.round(f4), paddingTop, Math.round(f4) + JH.getMeasuredWidth(), paddingTop + JH.getMeasuredHeight());
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
                paddingTop += bVar.mZb;
                paddingBottom -= bVar.mZb;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int dHn;
        float f;
        float f2;
        int dHn2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.mZp.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.mZp.get(i8);
                if (JI(i8)) {
                    paddingLeft += this.mZC;
                    i6 -= this.mZC;
                }
                float f5 = 0.0f;
                switch (this.mZt) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.mYZ) + paddingBottom;
                        f2 = bVar.mYZ - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.mYZ) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.mYZ) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.mYZ) / (bVar.dHn() != 1 ? dHn2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int dHn3 = bVar.dHn();
                        if (dHn3 != 0) {
                            f5 = (i5 - bVar.mYZ) / dHn3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dHn() != 0) {
                            f5 = (i5 - bVar.mYZ) / (dHn + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mZt);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.mZi + i10;
                        View JH = JH(i11);
                        if (JH != null && JH.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) JH.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (dE(i11, i10)) {
                                i12 = this.mZB;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.mZz & 4) > 0) {
                                i13 = this.mZB;
                            }
                            if (z) {
                                if (z2) {
                                    this.mZF.a(JH, bVar, true, i6 - JH.getMeasuredWidth(), Math.round(f3) - JH.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.mZF.a(JH, bVar, true, i6 - JH.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + JH.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.mZF.a(JH, bVar, false, paddingLeft, Math.round(f3) - JH.getMeasuredHeight(), paddingLeft + JH.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.mZF.a(JH, bVar, false, paddingLeft, Math.round(f4), paddingLeft + JH.getMeasuredWidth(), Math.round(f4) + JH.getMeasuredHeight());
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
                paddingLeft += bVar.mZb;
                i6 -= bVar.mZb;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.mZy != null || this.mZx != null) {
            if (this.mZz != 0 || this.mZA != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.mZr) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.mZs == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.mZs == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.mZs != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.mZs != 2) {
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
        int size = this.mZp.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mZp.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mZi + i4;
                View JH = JH(i5);
                if (JH != null && JH.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) JH.getLayoutParams();
                    if (dE(i5, i4)) {
                        if (z) {
                            left = JH.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (JH.getLeft() - layoutParams.leftMargin) - this.mZC;
                        }
                        a(canvas, left, bVar.mTop, bVar.mZb);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mZA & 4) > 0) {
                        if (z) {
                            right = (JH.getLeft() - layoutParams.leftMargin) - this.mZC;
                        } else {
                            right = layoutParams.rightMargin + JH.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.mZb);
                    }
                }
            }
            if (JI(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.mZB;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (JK(i3) && (this.mZz & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.mZB;
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
        int size = this.mZp.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mZp.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mZi + i4;
                View JH = JH(i5);
                if (JH != null && JH.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) JH.getLayoutParams();
                    if (dE(i5, i4)) {
                        if (z2) {
                            top2 = JH.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top2 = (JH.getTop() - layoutParams.topMargin) - this.mZB;
                        }
                        b(canvas, bVar.mLeft, top2, bVar.mZb);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mZz & 4) > 0) {
                        if (z2) {
                            bottom = (JH.getTop() - layoutParams.topMargin) - this.mZB;
                        } else {
                            bottom = layoutParams.bottomMargin + JH.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.mZb);
                    }
                }
            }
            if (JI(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.mZC;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (JK(i3) && (this.mZA & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.mZC;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.mZy != null) {
            this.mZy.setBounds(i, i2, this.mZC + i, i2 + i3);
            this.mZy.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.mZx != null) {
            this.mZx.setBounds(i, i2, i + i3, this.mZB + i2);
            this.mZx.draw(canvas);
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
        return this.mZr;
    }

    public void setFlexDirection(int i) {
        if (this.mZr != i) {
            this.mZr = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mZs;
    }

    public void setFlexWrap(int i) {
        if (this.mZs != i) {
            this.mZs = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.mZt;
    }

    public void setJustifyContent(int i) {
        if (this.mZt != i) {
            this.mZt = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mZu;
    }

    public void setAlignItems(int i) {
        if (this.mZu != i) {
            this.mZu = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.mZv;
    }

    public void setAlignContent(int i) {
        if (this.mZv != i) {
            this.mZv = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mZw;
    }

    public void setMaxLine(int i) {
        if (this.mZw != i) {
            this.mZw = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mZp.size());
        for (b bVar : this.mZp) {
            if (bVar.dHn() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int i(View view, int i, int i2) {
        int i3;
        if (dHg()) {
            i3 = dE(i, i2) ? 0 + this.mZC : 0;
            if ((this.mZA & 4) > 0) {
                return i3 + this.mZC;
            }
            return i3;
        }
        i3 = dE(i, i2) ? 0 + this.mZB : 0;
        if ((this.mZz & 4) > 0) {
            return i3 + this.mZB;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dl(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (dHg()) {
            if ((this.mZA & 4) > 0) {
                bVar.mYZ += this.mZC;
                bVar.mZa += this.mZC;
            }
        } else if ((this.mZz & 4) > 0) {
            bVar.mYZ += this.mZB;
            bVar.mZa += this.mZB;
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
            if (dHg()) {
                bVar.mYZ += this.mZC;
                bVar.mZa += this.mZC;
                return;
            }
            bVar.mYZ += this.mZB;
            bVar.mZa += this.mZB;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.mZp = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.mZp;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.mZx;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mZy;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.mZx) {
            this.mZx = drawable;
            if (drawable != null) {
                this.mZB = drawable.getIntrinsicHeight();
            } else {
                this.mZB = 0;
            }
            dHp();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.mZy) {
            this.mZy = drawable;
            if (drawable != null) {
                this.mZC = drawable.getIntrinsicWidth();
            } else {
                this.mZC = 0;
            }
            dHp();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.mZA;
    }

    public int getShowDividerHorizontal() {
        return this.mZz;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mZA) {
            this.mZA = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mZz) {
            this.mZz = i;
            requestLayout();
        }
    }

    private void dHp() {
        if (this.mZx == null && this.mZy == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean dE(int i, int i2) {
        return dF(i, i2) ? dHg() ? (this.mZA & 1) != 0 : (this.mZz & 1) != 0 : dHg() ? (this.mZA & 2) != 0 : (this.mZz & 2) != 0;
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
        if (i < 0 || i >= this.mZp.size()) {
            return false;
        }
        return JJ(i) ? dHg() ? (this.mZz & 1) != 0 : (this.mZA & 1) != 0 : dHg() ? (this.mZz & 2) != 0 : (this.mZA & 2) != 0;
    }

    private boolean JJ(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mZp.get(i2).dHn() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean JK(int i) {
        if (i < 0 || i >= this.mZp.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.mZp.size()) {
                if (this.mZp.get(i3).dHn() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (dHg()) {
                return (this.mZz & 4) != 0;
            } else {
                return (this.mZA & 4) != 0;
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
        public int dHh() {
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
        public boolean dHi() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dHj() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dHk() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dHl() {
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
