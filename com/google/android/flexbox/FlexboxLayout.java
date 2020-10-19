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
/* loaded from: classes9.dex */
public class FlexboxLayout extends ViewGroup implements a {
    private int huC;
    private List<b> oaU;
    private int oaW;
    private int oaX;
    private int oaY;
    private int oaZ;
    private int oba;
    @Nullable
    private Drawable obb;
    @Nullable
    private Drawable obc;
    private int obd;
    private int obe;
    private int obf;
    private int obg;
    private int[] obh;
    private SparseIntArray obi;
    private c obk;
    private c.a obl;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.huC = -1;
        this.obk = new c(this);
        this.oaU = new ArrayList();
        this.obl = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.oaW = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.oaX = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.oaY = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.oaZ = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.oba = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.huC = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.obe = i2;
            this.obd = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.obe = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.obd = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.obi == null) {
            this.obi = new SparseIntArray(getChildCount());
        }
        if (this.obk.d(this.obi)) {
            this.obh = this.obk.c(this.obi);
        }
        switch (this.oaW) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.oaW);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View NJ(int i) {
        return getChildAt(i);
    }

    public View NR(int i) {
        if (i < 0 || i >= this.obh.length) {
            return null;
        }
        return getChildAt(this.obh[i]);
    }

    @Override // com.google.android.flexbox.a
    public View NK(int i) {
        return NR(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.obi == null) {
            this.obi = new SparseIntArray(getChildCount());
        }
        this.obh = this.obk.a(view, i, layoutParams, this.obi);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.oaU.clear();
        this.obl.reset();
        this.obk.a(this.obl, i, i2);
        this.oaU = this.obl.oaU;
        this.obk.dQ(i, i2);
        if (this.oaZ == 3) {
            for (b bVar : this.oaU) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View NR = NR(bVar.oaN + i5);
                        if (NR != null && NR.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) NR.getLayoutParams();
                            if (this.oaX != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + NR.getMeasuredHeight() + Math.max(bVar.oaK - NR.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + NR.getMeasuredHeight() + Math.max((bVar.oaK - NR.getMeasuredHeight()) + NR.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.oaG = i4;
            }
        }
        this.obk.aj(i, i2, getPaddingTop() + getPaddingBottom());
        this.obk.eey();
        J(this.oaW, i, i2, this.obl.oaV);
    }

    private void measureVertical(int i, int i2) {
        this.oaU.clear();
        this.obl.reset();
        this.obk.b(this.obl, i, i2);
        this.oaU = this.obl.oaU;
        this.obk.dQ(i, i2);
        this.obk.aj(i, i2, getPaddingLeft() + getPaddingRight());
        this.obk.eey();
        J(this.oaW, i, i2, this.obl.oaV);
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
        Iterator<b> it = this.oaU.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().oaE);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.oaU.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.oaU.get(i2);
            if (NS(i2)) {
                if (eeq()) {
                    i += this.obf;
                } else {
                    i += this.obg;
                }
            }
            if (NU(i2)) {
                if (eeq()) {
                    i += this.obf;
                } else {
                    i += this.obg;
                }
            }
            i += bVar.oaG;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean eeq() {
        return this.oaW == 0 || this.oaW == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.oaW) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.oaX == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.oaX == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.oaW);
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int eex;
        float f;
        float f2;
        int eex2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.oaU.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.oaU.get(i7);
                if (NS(i7)) {
                    paddingBottom -= this.obf;
                    paddingTop += this.obf;
                }
                float f5 = 0.0f;
                switch (this.oaY) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.oaE) + paddingRight;
                        f2 = bVar.oaE - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.oaE) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.oaE) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.oaE) / (bVar.eex() != 1 ? eex2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int eex3 = bVar.eex();
                        if (eex3 != 0) {
                            f5 = (i5 - bVar.oaE) / eex3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.eex() != 0) {
                            f5 = (i5 - bVar.oaE) / (eex + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.oaY);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.oaN + i9;
                        View NR = NR(i10);
                        if (NR != null && NR.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) NR.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (dS(i10, i9)) {
                                i11 = this.obg;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.obe & 4) > 0) {
                                i12 = this.obg;
                            }
                            if (this.oaX == 2) {
                                if (z) {
                                    this.obk.a(NR, bVar, Math.round(f3) - NR.getMeasuredWidth(), paddingBottom - NR.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.obk.a(NR, bVar, Math.round(f4), paddingBottom - NR.getMeasuredHeight(), Math.round(f4) + NR.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.obk.a(NR, bVar, Math.round(f3) - NR.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + NR.getMeasuredHeight());
                            } else {
                                this.obk.a(NR, bVar, Math.round(f4), paddingTop, Math.round(f4) + NR.getMeasuredWidth(), paddingTop + NR.getMeasuredHeight());
                            }
                            f6 = f4 + NR.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((NR.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(NR, i12, 0, i11, 0);
                            } else {
                                bVar.g(NR, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.oaG;
                paddingBottom -= bVar.oaG;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int eex;
        float f;
        float f2;
        int eex2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.oaU.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.oaU.get(i8);
                if (NS(i8)) {
                    paddingLeft += this.obg;
                    i6 -= this.obg;
                }
                float f5 = 0.0f;
                switch (this.oaY) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.oaE) + paddingBottom;
                        f2 = bVar.oaE - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.oaE) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.oaE) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.oaE) / (bVar.eex() != 1 ? eex2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int eex3 = bVar.eex();
                        if (eex3 != 0) {
                            f5 = (i5 - bVar.oaE) / eex3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.eex() != 0) {
                            f5 = (i5 - bVar.oaE) / (eex + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.oaY);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.oaN + i10;
                        View NR = NR(i11);
                        if (NR != null && NR.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) NR.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (dS(i11, i10)) {
                                i12 = this.obf;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.obd & 4) > 0) {
                                i13 = this.obf;
                            }
                            if (z) {
                                if (z2) {
                                    this.obk.a(NR, bVar, true, i6 - NR.getMeasuredWidth(), Math.round(f3) - NR.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.obk.a(NR, bVar, true, i6 - NR.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + NR.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.obk.a(NR, bVar, false, paddingLeft, Math.round(f3) - NR.getMeasuredHeight(), paddingLeft + NR.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.obk.a(NR, bVar, false, paddingLeft, Math.round(f4), paddingLeft + NR.getMeasuredWidth(), Math.round(f4) + NR.getMeasuredHeight());
                            }
                            f6 = f4 + NR.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((NR.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(NR, 0, i13, 0, i12);
                            } else {
                                bVar.g(NR, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.oaG;
                i6 -= bVar.oaG;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.obc != null || this.obb != null) {
            if (this.obd != 0 || this.obe != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.oaW) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.oaX == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.oaX == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.oaX != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.oaX != 2) {
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
        int size = this.oaU.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.oaU.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.oaN + i4;
                View NR = NR(i5);
                if (NR != null && NR.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) NR.getLayoutParams();
                    if (dS(i5, i4)) {
                        if (z) {
                            left = NR.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (NR.getLeft() - layoutParams.leftMargin) - this.obg;
                        }
                        b(canvas, left, bVar.mTop, bVar.oaG);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.obe & 4) > 0) {
                        if (z) {
                            right = (NR.getLeft() - layoutParams.leftMargin) - this.obg;
                        } else {
                            right = layoutParams.rightMargin + NR.getRight();
                        }
                        b(canvas, right, bVar.mTop, bVar.oaG);
                    }
                }
            }
            if (NS(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.obf;
                }
                c(canvas, paddingLeft, i2, max);
            }
            if (NU(i3) && (this.obd & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.obf;
                } else {
                    i = bVar.mBottom;
                }
                c(canvas, paddingLeft, i, max);
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
        int size = this.oaU.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.oaU.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.oaN + i4;
                View NR = NR(i5);
                if (NR != null && NR.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) NR.getLayoutParams();
                    if (dS(i5, i4)) {
                        if (z2) {
                            top = NR.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (NR.getTop() - layoutParams.topMargin) - this.obf;
                        }
                        c(canvas, bVar.mLeft, top, bVar.oaG);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.obd & 4) > 0) {
                        if (z2) {
                            bottom = (NR.getTop() - layoutParams.topMargin) - this.obf;
                        } else {
                            bottom = layoutParams.bottomMargin + NR.getBottom();
                        }
                        c(canvas, bVar.mLeft, bottom, bVar.oaG);
                    }
                }
            }
            if (NS(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.obg;
                }
                b(canvas, i2, paddingTop, max);
            }
            if (NU(i3) && (this.obe & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.obg;
                } else {
                    i = bVar.mRight;
                }
                b(canvas, i, paddingTop, max);
            }
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.obc != null) {
            this.obc.setBounds(i, i2, this.obg + i, i2 + i3);
            this.obc.draw(canvas);
        }
    }

    private void c(Canvas canvas, int i, int i2, int i3) {
        if (this.obb != null) {
            this.obb.setBounds(i, i2, i + i3, this.obf + i2);
            this.obb.draw(canvas);
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
        return this.oaW;
    }

    public void setFlexDirection(int i) {
        if (this.oaW != i) {
            this.oaW = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.oaX;
    }

    public void setFlexWrap(int i) {
        if (this.oaX != i) {
            this.oaX = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.oaY;
    }

    public void setJustifyContent(int i) {
        if (this.oaY != i) {
            this.oaY = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.oaZ;
    }

    public void setAlignItems(int i) {
        if (this.oaZ != i) {
            this.oaZ = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.oba;
    }

    public void setAlignContent(int i) {
        if (this.oba != i) {
            this.oba = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.huC;
    }

    public void setMaxLine(int i) {
        if (this.huC != i) {
            this.huC = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.oaU.size());
        for (b bVar : this.oaU) {
            if (bVar.eex() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        int i3;
        if (eeq()) {
            i3 = dS(i, i2) ? 0 + this.obg : 0;
            if ((this.obe & 4) > 0) {
                return i3 + this.obg;
            }
            return i3;
        }
        i3 = dS(i, i2) ? 0 + this.obf : 0;
        if ((this.obd & 4) > 0) {
            return i3 + this.obf;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dI(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (eeq()) {
            if ((this.obe & 4) > 0) {
                bVar.oaE += this.obg;
                bVar.oaF += this.obg;
            }
        } else if ((this.obd & 4) > 0) {
            bVar.oaE += this.obf;
            bVar.oaF += this.obf;
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
            if (eeq()) {
                bVar.oaE += this.obg;
                bVar.oaF += this.obg;
                return;
            }
            bVar.oaE += this.obf;
            bVar.oaF += this.obf;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.oaU = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.oaU;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.obb;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.obc;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.obb) {
            this.obb = drawable;
            if (drawable != null) {
                this.obf = drawable.getIntrinsicHeight();
            } else {
                this.obf = 0;
            }
            eez();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.obc) {
            this.obc = drawable;
            if (drawable != null) {
                this.obg = drawable.getIntrinsicWidth();
            } else {
                this.obg = 0;
            }
            eez();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.obe;
    }

    public int getShowDividerHorizontal() {
        return this.obd;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.obe) {
            this.obe = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.obd) {
            this.obd = i;
            requestLayout();
        }
    }

    private void eez() {
        if (this.obb == null && this.obc == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean dS(int i, int i2) {
        return dT(i, i2) ? eeq() ? (this.obe & 1) != 0 : (this.obd & 1) != 0 : eeq() ? (this.obe & 2) != 0 : (this.obd & 2) != 0;
    }

    private boolean dT(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View NR = NR(i - i3);
            if (NR != null && NR.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean NS(int i) {
        if (i < 0 || i >= this.oaU.size()) {
            return false;
        }
        return NT(i) ? eeq() ? (this.obd & 1) != 0 : (this.obe & 1) != 0 : eeq() ? (this.obd & 2) != 0 : (this.obe & 2) != 0;
    }

    private boolean NT(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.oaU.get(i2).eex() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean NU(int i) {
        if (i < 0 || i >= this.oaU.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.oaU.size()) {
                if (this.oaU.get(i3).eex() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (eeq()) {
                return (this.obd & 4) != 0;
            } else {
                return (this.obe & 4) != 0;
            }
        }
    }

    /* loaded from: classes9.dex */
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
            /* renamed from: NV */
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
        public int eer() {
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
        public boolean ees() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float eet() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eeu() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eev() {
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
