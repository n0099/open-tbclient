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
/* loaded from: classes12.dex */
public class FlexboxLayout extends ViewGroup implements a {
    private int hfz;
    private List<b> nLD;
    private int nLF;
    private int nLG;
    private int nLH;
    private int nLI;
    private int nLJ;
    @Nullable
    private Drawable nLK;
    @Nullable
    private Drawable nLL;
    private int nLM;
    private int nLN;
    private int nLO;
    private int nLP;
    private int[] nLQ;
    private SparseIntArray nLR;
    private c nLS;
    private c.a nLT;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hfz = -1;
        this.nLS = new c(this);
        this.nLD = new ArrayList();
        this.nLT = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.nLF = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.nLG = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.nLH = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.nLI = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.nLJ = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.hfz = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.nLN = i2;
            this.nLM = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.nLN = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.nLM = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nLR == null) {
            this.nLR = new SparseIntArray(getChildCount());
        }
        if (this.nLS.d(this.nLR)) {
            this.nLQ = this.nLS.c(this.nLR);
        }
        switch (this.nLF) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.nLF);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View Nd(int i) {
        return getChildAt(i);
    }

    public View Nl(int i) {
        if (i < 0 || i >= this.nLQ.length) {
            return null;
        }
        return getChildAt(this.nLQ[i]);
    }

    @Override // com.google.android.flexbox.a
    public View Ne(int i) {
        return Nl(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.nLR == null) {
            this.nLR = new SparseIntArray(getChildCount());
        }
        this.nLQ = this.nLS.a(view, i, layoutParams, this.nLR);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.nLD.clear();
        this.nLT.reset();
        this.nLS.a(this.nLT, i, i2);
        this.nLD = this.nLT.nLD;
        this.nLS.dQ(i, i2);
        if (this.nLI == 3) {
            for (b bVar : this.nLD) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View Nl = Nl(bVar.nLw + i5);
                        if (Nl != null && Nl.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Nl.getLayoutParams();
                            if (this.nLG != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + Nl.getMeasuredHeight() + Math.max(bVar.nLt - Nl.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + Nl.getMeasuredHeight() + Math.max((bVar.nLt - Nl.getMeasuredHeight()) + Nl.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.nLp = i4;
            }
        }
        this.nLS.aj(i, i2, getPaddingTop() + getPaddingBottom());
        this.nLS.eaN();
        J(this.nLF, i, i2, this.nLT.nLE);
    }

    private void measureVertical(int i, int i2) {
        this.nLD.clear();
        this.nLT.reset();
        this.nLS.b(this.nLT, i, i2);
        this.nLD = this.nLT.nLD;
        this.nLS.dQ(i, i2);
        this.nLS.aj(i, i2, getPaddingLeft() + getPaddingRight());
        this.nLS.eaN();
        J(this.nLF, i, i2, this.nLT.nLE);
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
        Iterator<b> it = this.nLD.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().nLn);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.nLD.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.nLD.get(i2);
            if (Nm(i2)) {
                if (eaF()) {
                    i += this.nLO;
                } else {
                    i += this.nLP;
                }
            }
            if (No(i2)) {
                if (eaF()) {
                    i += this.nLO;
                } else {
                    i += this.nLP;
                }
            }
            i += bVar.nLp;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean eaF() {
        return this.nLF == 0 || this.nLF == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.nLF) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.nLG == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.nLG == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.nLF);
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int eaM;
        float f;
        float f2;
        int eaM2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.nLD.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.nLD.get(i7);
                if (Nm(i7)) {
                    paddingBottom -= this.nLO;
                    paddingTop += this.nLO;
                }
                float f5 = 0.0f;
                switch (this.nLH) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.nLn) + paddingRight;
                        f2 = bVar.nLn - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.nLn) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.nLn) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.nLn) / (bVar.eaM() != 1 ? eaM2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int eaM3 = bVar.eaM();
                        if (eaM3 != 0) {
                            f5 = (i5 - bVar.nLn) / eaM3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.eaM() != 0) {
                            f5 = (i5 - bVar.nLn) / (eaM + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.nLH);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.nLw + i9;
                        View Nl = Nl(i10);
                        if (Nl != null && Nl.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Nl.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (dS(i10, i9)) {
                                i11 = this.nLP;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.nLN & 4) > 0) {
                                i12 = this.nLP;
                            }
                            if (this.nLG == 2) {
                                if (z) {
                                    this.nLS.a(Nl, bVar, Math.round(f3) - Nl.getMeasuredWidth(), paddingBottom - Nl.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.nLS.a(Nl, bVar, Math.round(f4), paddingBottom - Nl.getMeasuredHeight(), Math.round(f4) + Nl.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.nLS.a(Nl, bVar, Math.round(f3) - Nl.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + Nl.getMeasuredHeight());
                            } else {
                                this.nLS.a(Nl, bVar, Math.round(f4), paddingTop, Math.round(f4) + Nl.getMeasuredWidth(), paddingTop + Nl.getMeasuredHeight());
                            }
                            f6 = f4 + Nl.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((Nl.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(Nl, i12, 0, i11, 0);
                            } else {
                                bVar.g(Nl, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.nLp;
                paddingBottom -= bVar.nLp;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int eaM;
        float f;
        float f2;
        int eaM2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.nLD.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.nLD.get(i8);
                if (Nm(i8)) {
                    paddingLeft += this.nLP;
                    i6 -= this.nLP;
                }
                float f5 = 0.0f;
                switch (this.nLH) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.nLn) + paddingBottom;
                        f2 = bVar.nLn - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.nLn) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.nLn) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.nLn) / (bVar.eaM() != 1 ? eaM2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int eaM3 = bVar.eaM();
                        if (eaM3 != 0) {
                            f5 = (i5 - bVar.nLn) / eaM3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.eaM() != 0) {
                            f5 = (i5 - bVar.nLn) / (eaM + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.nLH);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.nLw + i10;
                        View Nl = Nl(i11);
                        if (Nl != null && Nl.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Nl.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (dS(i11, i10)) {
                                i12 = this.nLO;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.nLM & 4) > 0) {
                                i13 = this.nLO;
                            }
                            if (z) {
                                if (z2) {
                                    this.nLS.a(Nl, bVar, true, i6 - Nl.getMeasuredWidth(), Math.round(f3) - Nl.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.nLS.a(Nl, bVar, true, i6 - Nl.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + Nl.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.nLS.a(Nl, bVar, false, paddingLeft, Math.round(f3) - Nl.getMeasuredHeight(), paddingLeft + Nl.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.nLS.a(Nl, bVar, false, paddingLeft, Math.round(f4), paddingLeft + Nl.getMeasuredWidth(), Math.round(f4) + Nl.getMeasuredHeight());
                            }
                            f6 = f4 + Nl.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((Nl.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(Nl, 0, i13, 0, i12);
                            } else {
                                bVar.g(Nl, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.nLp;
                i6 -= bVar.nLp;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.nLL != null || this.nLK != null) {
            if (this.nLM != 0 || this.nLN != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.nLF) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.nLG == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.nLG == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.nLG != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.nLG != 2) {
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
        int size = this.nLD.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.nLD.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.nLw + i4;
                View Nl = Nl(i5);
                if (Nl != null && Nl.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Nl.getLayoutParams();
                    if (dS(i5, i4)) {
                        if (z) {
                            left = Nl.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (Nl.getLeft() - layoutParams.leftMargin) - this.nLP;
                        }
                        a(canvas, left, bVar.mTop, bVar.nLp);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.nLN & 4) > 0) {
                        if (z) {
                            right = (Nl.getLeft() - layoutParams.leftMargin) - this.nLP;
                        } else {
                            right = layoutParams.rightMargin + Nl.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.nLp);
                    }
                }
            }
            if (Nm(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.nLO;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (No(i3) && (this.nLM & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.nLO;
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
        int size = this.nLD.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.nLD.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.nLw + i4;
                View Nl = Nl(i5);
                if (Nl != null && Nl.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Nl.getLayoutParams();
                    if (dS(i5, i4)) {
                        if (z2) {
                            top = Nl.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (Nl.getTop() - layoutParams.topMargin) - this.nLO;
                        }
                        b(canvas, bVar.mLeft, top, bVar.nLp);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.nLM & 4) > 0) {
                        if (z2) {
                            bottom = (Nl.getTop() - layoutParams.topMargin) - this.nLO;
                        } else {
                            bottom = layoutParams.bottomMargin + Nl.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.nLp);
                    }
                }
            }
            if (Nm(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.nLP;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (No(i3) && (this.nLN & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.nLP;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.nLL != null) {
            this.nLL.setBounds(i, i2, this.nLP + i, i2 + i3);
            this.nLL.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.nLK != null) {
            this.nLK.setBounds(i, i2, i + i3, this.nLO + i2);
            this.nLK.draw(canvas);
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
        return this.nLF;
    }

    public void setFlexDirection(int i) {
        if (this.nLF != i) {
            this.nLF = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.nLG;
    }

    public void setFlexWrap(int i) {
        if (this.nLG != i) {
            this.nLG = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.nLH;
    }

    public void setJustifyContent(int i) {
        if (this.nLH != i) {
            this.nLH = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.nLI;
    }

    public void setAlignItems(int i) {
        if (this.nLI != i) {
            this.nLI = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.nLJ;
    }

    public void setAlignContent(int i) {
        if (this.nLJ != i) {
            this.nLJ = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.hfz;
    }

    public void setMaxLine(int i) {
        if (this.hfz != i) {
            this.hfz = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.nLD.size());
        for (b bVar : this.nLD) {
            if (bVar.eaM() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        int i3;
        if (eaF()) {
            i3 = dS(i, i2) ? 0 + this.nLP : 0;
            if ((this.nLN & 4) > 0) {
                return i3 + this.nLP;
            }
            return i3;
        }
        i3 = dS(i, i2) ? 0 + this.nLO : 0;
        if ((this.nLM & 4) > 0) {
            return i3 + this.nLO;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dE(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (eaF()) {
            if ((this.nLN & 4) > 0) {
                bVar.nLn += this.nLP;
                bVar.nLo += this.nLP;
            }
        } else if ((this.nLM & 4) > 0) {
            bVar.nLn += this.nLO;
            bVar.nLo += this.nLO;
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
        if (dS(i, i2)) {
            if (eaF()) {
                bVar.nLn += this.nLP;
                bVar.nLo += this.nLP;
                return;
            }
            bVar.nLn += this.nLO;
            bVar.nLo += this.nLO;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.nLD = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.nLD;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.nLK;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.nLL;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.nLK) {
            this.nLK = drawable;
            if (drawable != null) {
                this.nLO = drawable.getIntrinsicHeight();
            } else {
                this.nLO = 0;
            }
            eaO();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.nLL) {
            this.nLL = drawable;
            if (drawable != null) {
                this.nLP = drawable.getIntrinsicWidth();
            } else {
                this.nLP = 0;
            }
            eaO();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.nLN;
    }

    public int getShowDividerHorizontal() {
        return this.nLM;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.nLN) {
            this.nLN = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.nLM) {
            this.nLM = i;
            requestLayout();
        }
    }

    private void eaO() {
        if (this.nLK == null && this.nLL == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean dS(int i, int i2) {
        return dT(i, i2) ? eaF() ? (this.nLN & 1) != 0 : (this.nLM & 1) != 0 : eaF() ? (this.nLN & 2) != 0 : (this.nLM & 2) != 0;
    }

    private boolean dT(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View Nl = Nl(i - i3);
            if (Nl != null && Nl.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean Nm(int i) {
        if (i < 0 || i >= this.nLD.size()) {
            return false;
        }
        return Nn(i) ? eaF() ? (this.nLM & 1) != 0 : (this.nLN & 1) != 0 : eaF() ? (this.nLM & 2) != 0 : (this.nLN & 2) != 0;
    }

    private boolean Nn(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.nLD.get(i2).eaM() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean No(int i) {
        if (i < 0 || i >= this.nLD.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.nLD.size()) {
                if (this.nLD.get(i3).eaM() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (eaF()) {
                return (this.nLM & 4) != 0;
            } else {
                return (this.nLN & 4) != 0;
            }
        }
    }

    /* loaded from: classes12.dex */
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
            /* renamed from: Np */
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
        public int eaG() {
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
        public boolean eaH() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float eaI() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eaJ() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eaK() {
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
