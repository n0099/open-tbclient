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
    private int nhA;
    private int nhB;
    @Nullable
    private Drawable nhC;
    @Nullable
    private Drawable nhD;
    private int nhE;
    private int nhF;
    private int nhG;
    private int nhH;
    private int[] nhI;
    private SparseIntArray nhJ;
    private c nhK;
    private c.a nhL;
    private List<b> nhu;
    private int nhw;
    private int nhx;
    private int nhy;
    private int nhz;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nhB = -1;
        this.nhK = new c(this);
        this.nhu = new ArrayList();
        this.nhL = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.nhw = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.nhx = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.nhy = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.nhz = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.nhA = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.nhB = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.nhF = i2;
            this.nhE = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.nhF = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.nhE = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nhJ == null) {
            this.nhJ = new SparseIntArray(getChildCount());
        }
        if (this.nhK.d(this.nhJ)) {
            this.nhI = this.nhK.c(this.nhJ);
        }
        switch (this.nhw) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.nhw);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View JU(int i) {
        return getChildAt(i);
    }

    public View Kc(int i) {
        if (i < 0 || i >= this.nhI.length) {
            return null;
        }
        return getChildAt(this.nhI[i]);
    }

    @Override // com.google.android.flexbox.a
    public View JV(int i) {
        return Kc(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.nhJ == null) {
            this.nhJ = new SparseIntArray(getChildCount());
        }
        this.nhI = this.nhK.a(view, i, layoutParams, this.nhJ);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.nhu.clear();
        this.nhL.reset();
        this.nhK.a(this.nhL, i, i2);
        this.nhu = this.nhL.nhu;
        this.nhK.dE(i, i2);
        if (this.nhz == 3) {
            for (b bVar : this.nhu) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View Kc = Kc(bVar.nhn + i5);
                        if (Kc != null && Kc.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Kc.getLayoutParams();
                            if (this.nhx != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + Kc.getMeasuredHeight() + Math.max(bVar.nhk - Kc.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + Kc.getMeasuredHeight() + Math.max((bVar.nhk - Kc.getMeasuredHeight()) + Kc.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.nhg = i4;
            }
        }
        this.nhK.ag(i, i2, getPaddingTop() + getPaddingBottom());
        this.nhK.dKE();
        J(this.nhw, i, i2, this.nhL.nhv);
    }

    private void measureVertical(int i, int i2) {
        this.nhu.clear();
        this.nhL.reset();
        this.nhK.b(this.nhL, i, i2);
        this.nhu = this.nhL.nhu;
        this.nhK.dE(i, i2);
        this.nhK.ag(i, i2, getPaddingLeft() + getPaddingRight());
        this.nhK.dKE();
        J(this.nhw, i, i2, this.nhL.nhv);
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
        Iterator<b> it = this.nhu.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().nhe);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.nhu.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.nhu.get(i2);
            if (Kd(i2)) {
                if (dKw()) {
                    i += this.nhG;
                } else {
                    i += this.nhH;
                }
            }
            if (Kf(i2)) {
                if (dKw()) {
                    i += this.nhG;
                } else {
                    i += this.nhH;
                }
            }
            i += bVar.nhg;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean dKw() {
        return this.nhw == 0 || this.nhw == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.nhw) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.nhx == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.nhx == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.nhw);
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int dKD;
        float f;
        float f2;
        int dKD2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.nhu.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.nhu.get(i7);
                if (Kd(i7)) {
                    paddingBottom -= this.nhG;
                    paddingTop += this.nhG;
                }
                float f5 = 0.0f;
                switch (this.nhy) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.nhe) + paddingRight;
                        f2 = bVar.nhe - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.nhe) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.nhe) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.nhe) / (bVar.dKD() != 1 ? dKD2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int dKD3 = bVar.dKD();
                        if (dKD3 != 0) {
                            f5 = (i5 - bVar.nhe) / dKD3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dKD() != 0) {
                            f5 = (i5 - bVar.nhe) / (dKD + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.nhy);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.nhn + i9;
                        View Kc = Kc(i10);
                        if (Kc != null && Kc.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Kc.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (dG(i10, i9)) {
                                i11 = this.nhH;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.nhF & 4) > 0) {
                                i12 = this.nhH;
                            }
                            if (this.nhx == 2) {
                                if (z) {
                                    this.nhK.a(Kc, bVar, Math.round(f3) - Kc.getMeasuredWidth(), paddingBottom - Kc.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.nhK.a(Kc, bVar, Math.round(f4), paddingBottom - Kc.getMeasuredHeight(), Math.round(f4) + Kc.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.nhK.a(Kc, bVar, Math.round(f3) - Kc.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + Kc.getMeasuredHeight());
                            } else {
                                this.nhK.a(Kc, bVar, Math.round(f4), paddingTop, Math.round(f4) + Kc.getMeasuredWidth(), paddingTop + Kc.getMeasuredHeight());
                            }
                            f6 = f4 + Kc.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((Kc.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(Kc, i12, 0, i11, 0);
                            } else {
                                bVar.g(Kc, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.nhg;
                paddingBottom -= bVar.nhg;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int dKD;
        float f;
        float f2;
        int dKD2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.nhu.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.nhu.get(i8);
                if (Kd(i8)) {
                    paddingLeft += this.nhH;
                    i6 -= this.nhH;
                }
                float f5 = 0.0f;
                switch (this.nhy) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.nhe) + paddingBottom;
                        f2 = bVar.nhe - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.nhe) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.nhe) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.nhe) / (bVar.dKD() != 1 ? dKD2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int dKD3 = bVar.dKD();
                        if (dKD3 != 0) {
                            f5 = (i5 - bVar.nhe) / dKD3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dKD() != 0) {
                            f5 = (i5 - bVar.nhe) / (dKD + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.nhy);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.nhn + i10;
                        View Kc = Kc(i11);
                        if (Kc != null && Kc.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Kc.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (dG(i11, i10)) {
                                i12 = this.nhG;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.nhE & 4) > 0) {
                                i13 = this.nhG;
                            }
                            if (z) {
                                if (z2) {
                                    this.nhK.a(Kc, bVar, true, i6 - Kc.getMeasuredWidth(), Math.round(f3) - Kc.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.nhK.a(Kc, bVar, true, i6 - Kc.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + Kc.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.nhK.a(Kc, bVar, false, paddingLeft, Math.round(f3) - Kc.getMeasuredHeight(), paddingLeft + Kc.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.nhK.a(Kc, bVar, false, paddingLeft, Math.round(f4), paddingLeft + Kc.getMeasuredWidth(), Math.round(f4) + Kc.getMeasuredHeight());
                            }
                            f6 = f4 + Kc.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((Kc.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(Kc, 0, i13, 0, i12);
                            } else {
                                bVar.g(Kc, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.nhg;
                i6 -= bVar.nhg;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.nhD != null || this.nhC != null) {
            if (this.nhE != 0 || this.nhF != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.nhw) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.nhx == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.nhx == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.nhx != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.nhx != 2) {
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
        int size = this.nhu.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.nhu.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.nhn + i4;
                View Kc = Kc(i5);
                if (Kc != null && Kc.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Kc.getLayoutParams();
                    if (dG(i5, i4)) {
                        if (z) {
                            left = Kc.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (Kc.getLeft() - layoutParams.leftMargin) - this.nhH;
                        }
                        a(canvas, left, bVar.mTop, bVar.nhg);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.nhF & 4) > 0) {
                        if (z) {
                            right = (Kc.getLeft() - layoutParams.leftMargin) - this.nhH;
                        } else {
                            right = layoutParams.rightMargin + Kc.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.nhg);
                    }
                }
            }
            if (Kd(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.nhG;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (Kf(i3) && (this.nhE & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.nhG;
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
        int size = this.nhu.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.nhu.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.nhn + i4;
                View Kc = Kc(i5);
                if (Kc != null && Kc.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Kc.getLayoutParams();
                    if (dG(i5, i4)) {
                        if (z2) {
                            top = Kc.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (Kc.getTop() - layoutParams.topMargin) - this.nhG;
                        }
                        b(canvas, bVar.mLeft, top, bVar.nhg);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.nhE & 4) > 0) {
                        if (z2) {
                            bottom = (Kc.getTop() - layoutParams.topMargin) - this.nhG;
                        } else {
                            bottom = layoutParams.bottomMargin + Kc.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.nhg);
                    }
                }
            }
            if (Kd(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.nhH;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (Kf(i3) && (this.nhF & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.nhH;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.nhD != null) {
            this.nhD.setBounds(i, i2, this.nhH + i, i2 + i3);
            this.nhD.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.nhC != null) {
            this.nhC.setBounds(i, i2, i + i3, this.nhG + i2);
            this.nhC.draw(canvas);
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
        return this.nhw;
    }

    public void setFlexDirection(int i) {
        if (this.nhw != i) {
            this.nhw = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.nhx;
    }

    public void setFlexWrap(int i) {
        if (this.nhx != i) {
            this.nhx = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.nhy;
    }

    public void setJustifyContent(int i) {
        if (this.nhy != i) {
            this.nhy = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.nhz;
    }

    public void setAlignItems(int i) {
        if (this.nhz != i) {
            this.nhz = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.nhA;
    }

    public void setAlignContent(int i) {
        if (this.nhA != i) {
            this.nhA = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.nhB;
    }

    public void setMaxLine(int i) {
        if (this.nhB != i) {
            this.nhB = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.nhu.size());
        for (b bVar : this.nhu) {
            if (bVar.dKD() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int k(View view, int i, int i2) {
        int i3;
        if (dKw()) {
            i3 = dG(i, i2) ? 0 + this.nhH : 0;
            if ((this.nhF & 4) > 0) {
                return i3 + this.nhH;
            }
            return i3;
        }
        i3 = dG(i, i2) ? 0 + this.nhG : 0;
        if ((this.nhE & 4) > 0) {
            return i3 + this.nhG;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dr(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (dKw()) {
            if ((this.nhF & 4) > 0) {
                bVar.nhe += this.nhH;
                bVar.nhf += this.nhH;
            }
        } else if ((this.nhE & 4) > 0) {
            bVar.nhe += this.nhG;
            bVar.nhf += this.nhG;
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
        if (dG(i, i2)) {
            if (dKw()) {
                bVar.nhe += this.nhH;
                bVar.nhf += this.nhH;
                return;
            }
            bVar.nhe += this.nhG;
            bVar.nhf += this.nhG;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.nhu = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.nhu;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.nhC;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.nhD;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.nhC) {
            this.nhC = drawable;
            if (drawable != null) {
                this.nhG = drawable.getIntrinsicHeight();
            } else {
                this.nhG = 0;
            }
            dKF();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.nhD) {
            this.nhD = drawable;
            if (drawable != null) {
                this.nhH = drawable.getIntrinsicWidth();
            } else {
                this.nhH = 0;
            }
            dKF();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.nhF;
    }

    public int getShowDividerHorizontal() {
        return this.nhE;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.nhF) {
            this.nhF = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.nhE) {
            this.nhE = i;
            requestLayout();
        }
    }

    private void dKF() {
        if (this.nhC == null && this.nhD == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean dG(int i, int i2) {
        return dH(i, i2) ? dKw() ? (this.nhF & 1) != 0 : (this.nhE & 1) != 0 : dKw() ? (this.nhF & 2) != 0 : (this.nhE & 2) != 0;
    }

    private boolean dH(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View Kc = Kc(i - i3);
            if (Kc != null && Kc.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean Kd(int i) {
        if (i < 0 || i >= this.nhu.size()) {
            return false;
        }
        return Ke(i) ? dKw() ? (this.nhE & 1) != 0 : (this.nhF & 1) != 0 : dKw() ? (this.nhE & 2) != 0 : (this.nhF & 2) != 0;
    }

    private boolean Ke(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.nhu.get(i2).dKD() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean Kf(int i) {
        if (i < 0 || i >= this.nhu.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.nhu.size()) {
                if (this.nhu.get(i3).dKD() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (dKw()) {
                return (this.nhE & 4) != 0;
            } else {
                return (this.nhF & 4) != 0;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayout.LayoutParams.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ak */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Kg */
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
        public int dKx() {
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
        public boolean dKy() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dKz() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dKA() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dKB() {
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
