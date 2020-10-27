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
    private int hGZ;
    private SparseIntArray oSA;
    private c oSB;
    private c.a oSC;
    private List<b> oSm;
    private int oSo;
    private int oSp;
    private int oSq;
    private int oSr;
    private int oSs;
    @Nullable
    private Drawable oSt;
    @Nullable
    private Drawable oSu;
    private int oSv;
    private int oSw;
    private int oSx;
    private int oSy;
    private int[] oSz;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hGZ = -1;
        this.oSB = new c(this);
        this.oSm = new ArrayList();
        this.oSC = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.oSo = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.oSp = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.oSq = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.oSr = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.oSs = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.hGZ = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.oSw = i2;
            this.oSv = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.oSw = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.oSv = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.oSA == null) {
            this.oSA = new SparseIntArray(getChildCount());
        }
        if (this.oSB.d(this.oSA)) {
            this.oSz = this.oSB.c(this.oSA);
        }
        switch (this.oSo) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.oSo);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View PA(int i) {
        return getChildAt(i);
    }

    public View PI(int i) {
        if (i < 0 || i >= this.oSz.length) {
            return null;
        }
        return getChildAt(this.oSz[i]);
    }

    @Override // com.google.android.flexbox.a
    public View PB(int i) {
        return PI(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.oSA == null) {
            this.oSA = new SparseIntArray(getChildCount());
        }
        this.oSz = this.oSB.a(view, i, layoutParams, this.oSA);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.oSm.clear();
        this.oSC.reset();
        this.oSB.a(this.oSC, i, i2);
        this.oSm = this.oSC.oSm;
        this.oSB.dZ(i, i2);
        if (this.oSr == 3) {
            for (b bVar : this.oSm) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View PI = PI(bVar.oSf + i5);
                        if (PI != null && PI.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) PI.getLayoutParams();
                            if (this.oSp != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + PI.getMeasuredHeight() + Math.max(bVar.oSc - PI.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + PI.getMeasuredHeight() + Math.max((bVar.oSc - PI.getMeasuredHeight()) + PI.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.oRY = i4;
            }
        }
        this.oSB.ak(i, i2, getPaddingTop() + getPaddingBottom());
        this.oSB.eoy();
        N(this.oSo, i, i2, this.oSC.oSn);
    }

    private void measureVertical(int i, int i2) {
        this.oSm.clear();
        this.oSC.reset();
        this.oSB.b(this.oSC, i, i2);
        this.oSm = this.oSC.oSm;
        this.oSB.dZ(i, i2);
        this.oSB.ak(i, i2, getPaddingLeft() + getPaddingRight());
        this.oSB.eoy();
        N(this.oSo, i, i2, this.oSC.oSn);
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
        Iterator<b> it = this.oSm.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().oRW);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.oSm.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.oSm.get(i2);
            if (PJ(i2)) {
                if (eoq()) {
                    i += this.oSx;
                } else {
                    i += this.oSy;
                }
            }
            if (PL(i2)) {
                if (eoq()) {
                    i += this.oSx;
                } else {
                    i += this.oSy;
                }
            }
            i += bVar.oRY;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean eoq() {
        return this.oSo == 0 || this.oSo == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.oSo) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.oSp == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.oSp == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.oSo);
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int eox;
        float f;
        float f2;
        int eox2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.oSm.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.oSm.get(i7);
                if (PJ(i7)) {
                    paddingBottom -= this.oSx;
                    paddingTop += this.oSx;
                }
                float f5 = 0.0f;
                switch (this.oSq) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.oRW) + paddingRight;
                        f2 = bVar.oRW - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.oRW) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.oRW) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.oRW) / (bVar.eox() != 1 ? eox2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int eox3 = bVar.eox();
                        if (eox3 != 0) {
                            f5 = (i5 - bVar.oRW) / eox3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.eox() != 0) {
                            f5 = (i5 - bVar.oRW) / (eox + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.oSq);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.oSf + i9;
                        View PI = PI(i10);
                        if (PI != null && PI.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) PI.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (eb(i10, i9)) {
                                i11 = this.oSy;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.oSw & 4) > 0) {
                                i12 = this.oSy;
                            }
                            if (this.oSp == 2) {
                                if (z) {
                                    this.oSB.a(PI, bVar, Math.round(f3) - PI.getMeasuredWidth(), paddingBottom - PI.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.oSB.a(PI, bVar, Math.round(f4), paddingBottom - PI.getMeasuredHeight(), Math.round(f4) + PI.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.oSB.a(PI, bVar, Math.round(f3) - PI.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + PI.getMeasuredHeight());
                            } else {
                                this.oSB.a(PI, bVar, Math.round(f4), paddingTop, Math.round(f4) + PI.getMeasuredWidth(), paddingTop + PI.getMeasuredHeight());
                            }
                            f6 = f4 + PI.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((PI.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(PI, i12, 0, i11, 0);
                            } else {
                                bVar.g(PI, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.oRY;
                paddingBottom -= bVar.oRY;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int eox;
        float f;
        float f2;
        int eox2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.oSm.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.oSm.get(i8);
                if (PJ(i8)) {
                    paddingLeft += this.oSy;
                    i6 -= this.oSy;
                }
                float f5 = 0.0f;
                switch (this.oSq) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.oRW) + paddingBottom;
                        f2 = bVar.oRW - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.oRW) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.oRW) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.oRW) / (bVar.eox() != 1 ? eox2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int eox3 = bVar.eox();
                        if (eox3 != 0) {
                            f5 = (i5 - bVar.oRW) / eox3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.eox() != 0) {
                            f5 = (i5 - bVar.oRW) / (eox + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.oSq);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.oSf + i10;
                        View PI = PI(i11);
                        if (PI != null && PI.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) PI.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (eb(i11, i10)) {
                                i12 = this.oSx;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.oSv & 4) > 0) {
                                i13 = this.oSx;
                            }
                            if (z) {
                                if (z2) {
                                    this.oSB.a(PI, bVar, true, i6 - PI.getMeasuredWidth(), Math.round(f3) - PI.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.oSB.a(PI, bVar, true, i6 - PI.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + PI.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.oSB.a(PI, bVar, false, paddingLeft, Math.round(f3) - PI.getMeasuredHeight(), paddingLeft + PI.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.oSB.a(PI, bVar, false, paddingLeft, Math.round(f4), paddingLeft + PI.getMeasuredWidth(), Math.round(f4) + PI.getMeasuredHeight());
                            }
                            f6 = f4 + PI.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((PI.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(PI, 0, i13, 0, i12);
                            } else {
                                bVar.g(PI, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.oRY;
                i6 -= bVar.oRY;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.oSu != null || this.oSt != null) {
            if (this.oSv != 0 || this.oSw != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.oSo) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.oSp == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.oSp == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.oSp != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.oSp != 2) {
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
        int size = this.oSm.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.oSm.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.oSf + i4;
                View PI = PI(i5);
                if (PI != null && PI.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) PI.getLayoutParams();
                    if (eb(i5, i4)) {
                        if (z) {
                            left = PI.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (PI.getLeft() - layoutParams.leftMargin) - this.oSy;
                        }
                        b(canvas, left, bVar.mTop, bVar.oRY);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.oSw & 4) > 0) {
                        if (z) {
                            right = (PI.getLeft() - layoutParams.leftMargin) - this.oSy;
                        } else {
                            right = layoutParams.rightMargin + PI.getRight();
                        }
                        b(canvas, right, bVar.mTop, bVar.oRY);
                    }
                }
            }
            if (PJ(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.oSx;
                }
                c(canvas, paddingLeft, i2, max);
            }
            if (PL(i3) && (this.oSv & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.oSx;
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
        int size = this.oSm.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.oSm.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.oSf + i4;
                View PI = PI(i5);
                if (PI != null && PI.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) PI.getLayoutParams();
                    if (eb(i5, i4)) {
                        if (z2) {
                            top = PI.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (PI.getTop() - layoutParams.topMargin) - this.oSx;
                        }
                        c(canvas, bVar.mLeft, top, bVar.oRY);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.oSv & 4) > 0) {
                        if (z2) {
                            bottom = (PI.getTop() - layoutParams.topMargin) - this.oSx;
                        } else {
                            bottom = layoutParams.bottomMargin + PI.getBottom();
                        }
                        c(canvas, bVar.mLeft, bottom, bVar.oRY);
                    }
                }
            }
            if (PJ(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.oSy;
                }
                b(canvas, i2, paddingTop, max);
            }
            if (PL(i3) && (this.oSw & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.oSy;
                } else {
                    i = bVar.mRight;
                }
                b(canvas, i, paddingTop, max);
            }
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.oSu != null) {
            this.oSu.setBounds(i, i2, this.oSy + i, i2 + i3);
            this.oSu.draw(canvas);
        }
    }

    private void c(Canvas canvas, int i, int i2, int i3) {
        if (this.oSt != null) {
            this.oSt.setBounds(i, i2, i + i3, this.oSx + i2);
            this.oSt.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: k */
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
        return this.oSo;
    }

    public void setFlexDirection(int i) {
        if (this.oSo != i) {
            this.oSo = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.oSp;
    }

    public void setFlexWrap(int i) {
        if (this.oSp != i) {
            this.oSp = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.oSq;
    }

    public void setJustifyContent(int i) {
        if (this.oSq != i) {
            this.oSq = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.oSr;
    }

    public void setAlignItems(int i) {
        if (this.oSr != i) {
            this.oSr = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.oSs;
    }

    public void setAlignContent(int i) {
        if (this.oSs != i) {
            this.oSs = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.hGZ;
    }

    public void setMaxLine(int i) {
        if (this.hGZ != i) {
            this.hGZ = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.oSm.size());
        for (b bVar : this.oSm) {
            if (bVar.eox() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        int i3;
        if (eoq()) {
            i3 = eb(i, i2) ? 0 + this.oSy : 0;
            if ((this.oSw & 4) > 0) {
                return i3 + this.oSy;
            }
            return i3;
        }
        i3 = eb(i, i2) ? 0 + this.oSx : 0;
        if ((this.oSv & 4) > 0) {
            return i3 + this.oSx;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dQ(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (eoq()) {
            if ((this.oSw & 4) > 0) {
                bVar.oRW += this.oSy;
                bVar.oRX += this.oSy;
            }
        } else if ((this.oSv & 4) > 0) {
            bVar.oRW += this.oSx;
            bVar.oRX += this.oSx;
        }
    }

    @Override // com.google.android.flexbox.a
    public int ah(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public int ai(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, b bVar) {
        if (eb(i, i2)) {
            if (eoq()) {
                bVar.oRW += this.oSy;
                bVar.oRX += this.oSy;
                return;
            }
            bVar.oRW += this.oSx;
            bVar.oRX += this.oSx;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.oSm = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.oSm;
    }

    @Override // com.google.android.flexbox.a
    public void n(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.oSt;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.oSu;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.oSt) {
            this.oSt = drawable;
            if (drawable != null) {
                this.oSx = drawable.getIntrinsicHeight();
            } else {
                this.oSx = 0;
            }
            eoz();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.oSu) {
            this.oSu = drawable;
            if (drawable != null) {
                this.oSy = drawable.getIntrinsicWidth();
            } else {
                this.oSy = 0;
            }
            eoz();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.oSw;
    }

    public int getShowDividerHorizontal() {
        return this.oSv;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.oSw) {
            this.oSw = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.oSv) {
            this.oSv = i;
            requestLayout();
        }
    }

    private void eoz() {
        if (this.oSt == null && this.oSu == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean eb(int i, int i2) {
        return ec(i, i2) ? eoq() ? (this.oSw & 1) != 0 : (this.oSv & 1) != 0 : eoq() ? (this.oSw & 2) != 0 : (this.oSv & 2) != 0;
    }

    private boolean ec(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View PI = PI(i - i3);
            if (PI != null && PI.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean PJ(int i) {
        if (i < 0 || i >= this.oSm.size()) {
            return false;
        }
        return PK(i) ? eoq() ? (this.oSv & 1) != 0 : (this.oSw & 1) != 0 : eoq() ? (this.oSv & 2) != 0 : (this.oSw & 2) != 0;
    }

    private boolean PK(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.oSm.get(i2).eox() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean PL(int i) {
        if (i < 0 || i >= this.oSm.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.oSm.size()) {
                if (this.oSm.get(i3).eox() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (eoq()) {
                return (this.oSv & 4) != 0;
            } else {
                return (this.oSw & 4) != 0;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayout.LayoutParams.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: an */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: PM */
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
        public int eor() {
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
        public boolean eos() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float eot() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eou() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eov() {
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
