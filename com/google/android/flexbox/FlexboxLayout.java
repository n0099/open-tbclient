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
    private List<b> nBG;
    private int nBI;
    private int nBJ;
    private int nBK;
    private int nBL;
    private int nBM;
    private int nBN;
    @Nullable
    private Drawable nBO;
    @Nullable
    private Drawable nBP;
    private int nBQ;
    private int nBR;
    private int nBS;
    private int nBT;
    private int[] nBU;
    private SparseIntArray nBV;
    private c nBW;
    private c.a nBX;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nBN = -1;
        this.nBW = new c(this);
        this.nBG = new ArrayList();
        this.nBX = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.nBI = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.nBJ = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.nBK = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.nBL = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.nBM = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.nBN = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.nBR = i2;
            this.nBQ = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.nBR = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.nBQ = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nBV == null) {
            this.nBV = new SparseIntArray(getChildCount());
        }
        if (this.nBW.d(this.nBV)) {
            this.nBU = this.nBW.c(this.nBV);
        }
        switch (this.nBI) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.nBI);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View My(int i) {
        return getChildAt(i);
    }

    public View MG(int i) {
        if (i < 0 || i >= this.nBU.length) {
            return null;
        }
        return getChildAt(this.nBU[i]);
    }

    @Override // com.google.android.flexbox.a
    public View Mz(int i) {
        return MG(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.nBV == null) {
            this.nBV = new SparseIntArray(getChildCount());
        }
        this.nBU = this.nBW.a(view, i, layoutParams, this.nBV);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.nBG.clear();
        this.nBX.reset();
        this.nBW.a(this.nBX, i, i2);
        this.nBG = this.nBX.nBG;
        this.nBW.dM(i, i2);
        if (this.nBL == 3) {
            for (b bVar : this.nBG) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View MG = MG(bVar.nBz + i5);
                        if (MG != null && MG.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) MG.getLayoutParams();
                            if (this.nBJ != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + MG.getMeasuredHeight() + Math.max(bVar.nBw - MG.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + MG.getMeasuredHeight() + Math.max((bVar.nBw - MG.getMeasuredHeight()) + MG.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.nBs = i4;
            }
        }
        this.nBW.ag(i, i2, getPaddingTop() + getPaddingBottom());
        this.nBW.dWP();
        J(this.nBI, i, i2, this.nBX.nBH);
    }

    private void measureVertical(int i, int i2) {
        this.nBG.clear();
        this.nBX.reset();
        this.nBW.b(this.nBX, i, i2);
        this.nBG = this.nBX.nBG;
        this.nBW.dM(i, i2);
        this.nBW.ag(i, i2, getPaddingLeft() + getPaddingRight());
        this.nBW.dWP();
        J(this.nBI, i, i2, this.nBX.nBH);
    }

    private void J(int i, int i2, int i3, int i4) {
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
        Iterator<b> it = this.nBG.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().nBq);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.nBG.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.nBG.get(i2);
            if (MH(i2)) {
                if (dWH()) {
                    i += this.nBS;
                } else {
                    i += this.nBT;
                }
            }
            if (MJ(i2)) {
                if (dWH()) {
                    i += this.nBS;
                } else {
                    i += this.nBT;
                }
            }
            i += bVar.nBs;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean dWH() {
        return this.nBI == 0 || this.nBI == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.nBI) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.nBJ == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.nBJ == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.nBI);
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int dWO;
        float f;
        float f2;
        int dWO2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.nBG.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.nBG.get(i7);
                if (MH(i7)) {
                    paddingBottom -= this.nBS;
                    paddingTop += this.nBS;
                }
                float f5 = 0.0f;
                switch (this.nBK) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.nBq) + paddingRight;
                        f2 = bVar.nBq - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.nBq) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.nBq) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.nBq) / (bVar.dWO() != 1 ? dWO2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int dWO3 = bVar.dWO();
                        if (dWO3 != 0) {
                            f5 = (i5 - bVar.nBq) / dWO3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dWO() != 0) {
                            f5 = (i5 - bVar.nBq) / (dWO + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.nBK);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.nBz + i9;
                        View MG = MG(i10);
                        if (MG != null && MG.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) MG.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (dO(i10, i9)) {
                                i11 = this.nBT;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.nBR & 4) > 0) {
                                i12 = this.nBT;
                            }
                            if (this.nBJ == 2) {
                                if (z) {
                                    this.nBW.a(MG, bVar, Math.round(f3) - MG.getMeasuredWidth(), paddingBottom - MG.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.nBW.a(MG, bVar, Math.round(f4), paddingBottom - MG.getMeasuredHeight(), Math.round(f4) + MG.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.nBW.a(MG, bVar, Math.round(f3) - MG.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + MG.getMeasuredHeight());
                            } else {
                                this.nBW.a(MG, bVar, Math.round(f4), paddingTop, Math.round(f4) + MG.getMeasuredWidth(), paddingTop + MG.getMeasuredHeight());
                            }
                            f6 = f4 + MG.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((MG.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(MG, i12, 0, i11, 0);
                            } else {
                                bVar.g(MG, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.nBs;
                paddingBottom -= bVar.nBs;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int dWO;
        float f;
        float f2;
        int dWO2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.nBG.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.nBG.get(i8);
                if (MH(i8)) {
                    paddingLeft += this.nBT;
                    i6 -= this.nBT;
                }
                float f5 = 0.0f;
                switch (this.nBK) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.nBq) + paddingBottom;
                        f2 = bVar.nBq - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.nBq) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.nBq) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.nBq) / (bVar.dWO() != 1 ? dWO2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int dWO3 = bVar.dWO();
                        if (dWO3 != 0) {
                            f5 = (i5 - bVar.nBq) / dWO3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dWO() != 0) {
                            f5 = (i5 - bVar.nBq) / (dWO + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.nBK);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.nBz + i10;
                        View MG = MG(i11);
                        if (MG != null && MG.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) MG.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (dO(i11, i10)) {
                                i12 = this.nBS;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.nBQ & 4) > 0) {
                                i13 = this.nBS;
                            }
                            if (z) {
                                if (z2) {
                                    this.nBW.a(MG, bVar, true, i6 - MG.getMeasuredWidth(), Math.round(f3) - MG.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.nBW.a(MG, bVar, true, i6 - MG.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + MG.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.nBW.a(MG, bVar, false, paddingLeft, Math.round(f3) - MG.getMeasuredHeight(), paddingLeft + MG.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.nBW.a(MG, bVar, false, paddingLeft, Math.round(f4), paddingLeft + MG.getMeasuredWidth(), Math.round(f4) + MG.getMeasuredHeight());
                            }
                            f6 = f4 + MG.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((MG.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(MG, 0, i13, 0, i12);
                            } else {
                                bVar.g(MG, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.nBs;
                i6 -= bVar.nBs;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.nBP != null || this.nBO != null) {
            if (this.nBQ != 0 || this.nBR != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.nBI) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.nBJ == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.nBJ == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.nBJ != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.nBJ != 2) {
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
        int size = this.nBG.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.nBG.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.nBz + i4;
                View MG = MG(i5);
                if (MG != null && MG.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) MG.getLayoutParams();
                    if (dO(i5, i4)) {
                        if (z) {
                            left = MG.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (MG.getLeft() - layoutParams.leftMargin) - this.nBT;
                        }
                        a(canvas, left, bVar.mTop, bVar.nBs);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.nBR & 4) > 0) {
                        if (z) {
                            right = (MG.getLeft() - layoutParams.leftMargin) - this.nBT;
                        } else {
                            right = layoutParams.rightMargin + MG.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.nBs);
                    }
                }
            }
            if (MH(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.nBS;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (MJ(i3) && (this.nBQ & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.nBS;
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
        int size = this.nBG.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.nBG.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.nBz + i4;
                View MG = MG(i5);
                if (MG != null && MG.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) MG.getLayoutParams();
                    if (dO(i5, i4)) {
                        if (z2) {
                            top = MG.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (MG.getTop() - layoutParams.topMargin) - this.nBS;
                        }
                        b(canvas, bVar.mLeft, top, bVar.nBs);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.nBQ & 4) > 0) {
                        if (z2) {
                            bottom = (MG.getTop() - layoutParams.topMargin) - this.nBS;
                        } else {
                            bottom = layoutParams.bottomMargin + MG.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.nBs);
                    }
                }
            }
            if (MH(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.nBT;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (MJ(i3) && (this.nBR & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.nBT;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.nBP != null) {
            this.nBP.setBounds(i, i2, this.nBT + i, i2 + i3);
            this.nBP.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.nBO != null) {
            this.nBO.setBounds(i, i2, i + i3, this.nBS + i2);
            this.nBO.draw(canvas);
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
        return this.nBI;
    }

    public void setFlexDirection(int i) {
        if (this.nBI != i) {
            this.nBI = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.nBJ;
    }

    public void setFlexWrap(int i) {
        if (this.nBJ != i) {
            this.nBJ = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.nBK;
    }

    public void setJustifyContent(int i) {
        if (this.nBK != i) {
            this.nBK = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.nBL;
    }

    public void setAlignItems(int i) {
        if (this.nBL != i) {
            this.nBL = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.nBM;
    }

    public void setAlignContent(int i) {
        if (this.nBM != i) {
            this.nBM = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.nBN;
    }

    public void setMaxLine(int i) {
        if (this.nBN != i) {
            this.nBN = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.nBG.size());
        for (b bVar : this.nBG) {
            if (bVar.dWO() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        int i3;
        if (dWH()) {
            i3 = dO(i, i2) ? 0 + this.nBT : 0;
            if ((this.nBR & 4) > 0) {
                return i3 + this.nBT;
            }
            return i3;
        }
        i3 = dO(i, i2) ? 0 + this.nBS : 0;
        if ((this.nBQ & 4) > 0) {
            return i3 + this.nBS;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dv(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (dWH()) {
            if ((this.nBR & 4) > 0) {
                bVar.nBq += this.nBT;
                bVar.nBr += this.nBT;
            }
        } else if ((this.nBQ & 4) > 0) {
            bVar.nBq += this.nBS;
            bVar.nBr += this.nBS;
        }
    }

    @Override // com.google.android.flexbox.a
    public int ad(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public int ae(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, b bVar) {
        if (dO(i, i2)) {
            if (dWH()) {
                bVar.nBq += this.nBT;
                bVar.nBr += this.nBT;
                return;
            }
            bVar.nBq += this.nBS;
            bVar.nBr += this.nBS;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.nBG = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.nBG;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.nBO;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.nBP;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.nBO) {
            this.nBO = drawable;
            if (drawable != null) {
                this.nBS = drawable.getIntrinsicHeight();
            } else {
                this.nBS = 0;
            }
            dWQ();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.nBP) {
            this.nBP = drawable;
            if (drawable != null) {
                this.nBT = drawable.getIntrinsicWidth();
            } else {
                this.nBT = 0;
            }
            dWQ();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.nBR;
    }

    public int getShowDividerHorizontal() {
        return this.nBQ;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.nBR) {
            this.nBR = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.nBQ) {
            this.nBQ = i;
            requestLayout();
        }
    }

    private void dWQ() {
        if (this.nBO == null && this.nBP == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean dO(int i, int i2) {
        return dP(i, i2) ? dWH() ? (this.nBR & 1) != 0 : (this.nBQ & 1) != 0 : dWH() ? (this.nBR & 2) != 0 : (this.nBQ & 2) != 0;
    }

    private boolean dP(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View MG = MG(i - i3);
            if (MG != null && MG.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean MH(int i) {
        if (i < 0 || i >= this.nBG.size()) {
            return false;
        }
        return MI(i) ? dWH() ? (this.nBQ & 1) != 0 : (this.nBR & 1) != 0 : dWH() ? (this.nBQ & 2) != 0 : (this.nBR & 2) != 0;
    }

    private boolean MI(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.nBG.get(i2).dWO() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean MJ(int i) {
        if (i < 0 || i >= this.nBG.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.nBG.size()) {
                if (this.nBG.get(i3).dWO() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (dWH()) {
                return (this.nBQ & 4) != 0;
            } else {
                return (this.nBR & 4) != 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayout.LayoutParams.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: al */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: MK */
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
        public int dWI() {
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
        public boolean dWJ() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dWK() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dWL() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dWM() {
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
