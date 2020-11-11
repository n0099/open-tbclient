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
    private int hMW;
    private List<b> pbH;
    private int pbJ;
    private int pbK;
    private int pbL;
    private int pbM;
    private int pbN;
    @Nullable
    private Drawable pbO;
    @Nullable
    private Drawable pbP;
    private int pbQ;
    private int pbR;
    private int pbS;
    private int pbT;
    private int[] pbU;
    private SparseIntArray pbV;
    private c pbW;
    private c.a pbX;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hMW = -1;
        this.pbW = new c(this);
        this.pbH = new ArrayList();
        this.pbX = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.pbJ = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.pbK = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.pbL = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.pbM = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.pbN = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.hMW = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.pbR = i2;
            this.pbQ = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.pbR = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.pbQ = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.pbV == null) {
            this.pbV = new SparseIntArray(getChildCount());
        }
        if (this.pbW.d(this.pbV)) {
            this.pbU = this.pbW.c(this.pbV);
        }
        switch (this.pbJ) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.pbJ);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View PV(int i) {
        return getChildAt(i);
    }

    public View Qd(int i) {
        if (i < 0 || i >= this.pbU.length) {
            return null;
        }
        return getChildAt(this.pbU[i]);
    }

    @Override // com.google.android.flexbox.a
    public View PW(int i) {
        return Qd(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.pbV == null) {
            this.pbV = new SparseIntArray(getChildCount());
        }
        this.pbU = this.pbW.a(view, i, layoutParams, this.pbV);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.pbH.clear();
        this.pbX.reset();
        this.pbW.a(this.pbX, i, i2);
        this.pbH = this.pbX.pbH;
        this.pbW.ec(i, i2);
        if (this.pbM == 3) {
            for (b bVar : this.pbH) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View Qd = Qd(bVar.pbA + i5);
                        if (Qd != null && Qd.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Qd.getLayoutParams();
                            if (this.pbK != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + Qd.getMeasuredHeight() + Math.max(bVar.pbx - Qd.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + Qd.getMeasuredHeight() + Math.max((bVar.pbx - Qd.getMeasuredHeight()) + Qd.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.pbt = i4;
            }
        }
        this.pbW.ak(i, i2, getPaddingTop() + getPaddingBottom());
        this.pbW.esn();
        N(this.pbJ, i, i2, this.pbX.pbI);
    }

    private void measureVertical(int i, int i2) {
        this.pbH.clear();
        this.pbX.reset();
        this.pbW.b(this.pbX, i, i2);
        this.pbH = this.pbX.pbH;
        this.pbW.ec(i, i2);
        this.pbW.ak(i, i2, getPaddingLeft() + getPaddingRight());
        this.pbW.esn();
        N(this.pbJ, i, i2, this.pbX.pbI);
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
        Iterator<b> it = this.pbH.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().pbr);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.pbH.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.pbH.get(i2);
            if (Qe(i2)) {
                if (esf()) {
                    i += this.pbS;
                } else {
                    i += this.pbT;
                }
            }
            if (Qg(i2)) {
                if (esf()) {
                    i += this.pbS;
                } else {
                    i += this.pbT;
                }
            }
            i += bVar.pbt;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean esf() {
        return this.pbJ == 0 || this.pbJ == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.pbJ) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.pbK == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.pbK == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.pbJ);
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int esm;
        float f;
        float f2;
        int esm2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.pbH.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.pbH.get(i7);
                if (Qe(i7)) {
                    paddingBottom -= this.pbS;
                    paddingTop += this.pbS;
                }
                float f5 = 0.0f;
                switch (this.pbL) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.pbr) + paddingRight;
                        f2 = bVar.pbr - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.pbr) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.pbr) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.pbr) / (bVar.esm() != 1 ? esm2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int esm3 = bVar.esm();
                        if (esm3 != 0) {
                            f5 = (i5 - bVar.pbr) / esm3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.esm() != 0) {
                            f5 = (i5 - bVar.pbr) / (esm + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.pbL);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.pbA + i9;
                        View Qd = Qd(i10);
                        if (Qd != null && Qd.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Qd.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (ee(i10, i9)) {
                                i11 = this.pbT;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.pbR & 4) > 0) {
                                i12 = this.pbT;
                            }
                            if (this.pbK == 2) {
                                if (z) {
                                    this.pbW.a(Qd, bVar, Math.round(f3) - Qd.getMeasuredWidth(), paddingBottom - Qd.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.pbW.a(Qd, bVar, Math.round(f4), paddingBottom - Qd.getMeasuredHeight(), Math.round(f4) + Qd.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.pbW.a(Qd, bVar, Math.round(f3) - Qd.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + Qd.getMeasuredHeight());
                            } else {
                                this.pbW.a(Qd, bVar, Math.round(f4), paddingTop, Math.round(f4) + Qd.getMeasuredWidth(), paddingTop + Qd.getMeasuredHeight());
                            }
                            f6 = f4 + Qd.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((Qd.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(Qd, i12, 0, i11, 0);
                            } else {
                                bVar.g(Qd, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.pbt;
                paddingBottom -= bVar.pbt;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int esm;
        float f;
        float f2;
        int esm2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.pbH.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.pbH.get(i8);
                if (Qe(i8)) {
                    paddingLeft += this.pbT;
                    i6 -= this.pbT;
                }
                float f5 = 0.0f;
                switch (this.pbL) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.pbr) + paddingBottom;
                        f2 = bVar.pbr - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.pbr) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.pbr) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.pbr) / (bVar.esm() != 1 ? esm2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int esm3 = bVar.esm();
                        if (esm3 != 0) {
                            f5 = (i5 - bVar.pbr) / esm3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.esm() != 0) {
                            f5 = (i5 - bVar.pbr) / (esm + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.pbL);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.pbA + i10;
                        View Qd = Qd(i11);
                        if (Qd != null && Qd.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Qd.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (ee(i11, i10)) {
                                i12 = this.pbS;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.pbQ & 4) > 0) {
                                i13 = this.pbS;
                            }
                            if (z) {
                                if (z2) {
                                    this.pbW.a(Qd, bVar, true, i6 - Qd.getMeasuredWidth(), Math.round(f3) - Qd.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.pbW.a(Qd, bVar, true, i6 - Qd.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + Qd.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.pbW.a(Qd, bVar, false, paddingLeft, Math.round(f3) - Qd.getMeasuredHeight(), paddingLeft + Qd.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.pbW.a(Qd, bVar, false, paddingLeft, Math.round(f4), paddingLeft + Qd.getMeasuredWidth(), Math.round(f4) + Qd.getMeasuredHeight());
                            }
                            f6 = f4 + Qd.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((Qd.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(Qd, 0, i13, 0, i12);
                            } else {
                                bVar.g(Qd, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.pbt;
                i6 -= bVar.pbt;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.pbP != null || this.pbO != null) {
            if (this.pbQ != 0 || this.pbR != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.pbJ) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.pbK == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.pbK == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.pbK != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.pbK != 2) {
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
        int size = this.pbH.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.pbH.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.pbA + i4;
                View Qd = Qd(i5);
                if (Qd != null && Qd.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Qd.getLayoutParams();
                    if (ee(i5, i4)) {
                        if (z) {
                            left = Qd.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (Qd.getLeft() - layoutParams.leftMargin) - this.pbT;
                        }
                        b(canvas, left, bVar.mTop, bVar.pbt);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.pbR & 4) > 0) {
                        if (z) {
                            right = (Qd.getLeft() - layoutParams.leftMargin) - this.pbT;
                        } else {
                            right = layoutParams.rightMargin + Qd.getRight();
                        }
                        b(canvas, right, bVar.mTop, bVar.pbt);
                    }
                }
            }
            if (Qe(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.pbS;
                }
                c(canvas, paddingLeft, i2, max);
            }
            if (Qg(i3) && (this.pbQ & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.pbS;
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
        int size = this.pbH.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.pbH.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.pbA + i4;
                View Qd = Qd(i5);
                if (Qd != null && Qd.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Qd.getLayoutParams();
                    if (ee(i5, i4)) {
                        if (z2) {
                            top = Qd.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (Qd.getTop() - layoutParams.topMargin) - this.pbS;
                        }
                        c(canvas, bVar.mLeft, top, bVar.pbt);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.pbQ & 4) > 0) {
                        if (z2) {
                            bottom = (Qd.getTop() - layoutParams.topMargin) - this.pbS;
                        } else {
                            bottom = layoutParams.bottomMargin + Qd.getBottom();
                        }
                        c(canvas, bVar.mLeft, bottom, bVar.pbt);
                    }
                }
            }
            if (Qe(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.pbT;
                }
                b(canvas, i2, paddingTop, max);
            }
            if (Qg(i3) && (this.pbR & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.pbT;
                } else {
                    i = bVar.mRight;
                }
                b(canvas, i, paddingTop, max);
            }
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.pbP != null) {
            this.pbP.setBounds(i, i2, this.pbT + i, i2 + i3);
            this.pbP.draw(canvas);
        }
    }

    private void c(Canvas canvas, int i, int i2, int i3) {
        if (this.pbO != null) {
            this.pbO.setBounds(i, i2, i + i3, this.pbS + i2);
            this.pbO.draw(canvas);
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
        return this.pbJ;
    }

    public void setFlexDirection(int i) {
        if (this.pbJ != i) {
            this.pbJ = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.pbK;
    }

    public void setFlexWrap(int i) {
        if (this.pbK != i) {
            this.pbK = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.pbL;
    }

    public void setJustifyContent(int i) {
        if (this.pbL != i) {
            this.pbL = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.pbM;
    }

    public void setAlignItems(int i) {
        if (this.pbM != i) {
            this.pbM = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.pbN;
    }

    public void setAlignContent(int i) {
        if (this.pbN != i) {
            this.pbN = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.hMW;
    }

    public void setMaxLine(int i) {
        if (this.hMW != i) {
            this.hMW = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.pbH.size());
        for (b bVar : this.pbH) {
            if (bVar.esm() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        int i3;
        if (esf()) {
            i3 = ee(i, i2) ? 0 + this.pbT : 0;
            if ((this.pbR & 4) > 0) {
                return i3 + this.pbT;
            }
            return i3;
        }
        i3 = ee(i, i2) ? 0 + this.pbS : 0;
        if ((this.pbQ & 4) > 0) {
            return i3 + this.pbS;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dY(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (esf()) {
            if ((this.pbR & 4) > 0) {
                bVar.pbr += this.pbT;
                bVar.pbs += this.pbT;
            }
        } else if ((this.pbQ & 4) > 0) {
            bVar.pbr += this.pbS;
            bVar.pbs += this.pbS;
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
        if (ee(i, i2)) {
            if (esf()) {
                bVar.pbr += this.pbT;
                bVar.pbs += this.pbT;
                return;
            }
            bVar.pbr += this.pbS;
            bVar.pbs += this.pbS;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.pbH = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.pbH;
    }

    @Override // com.google.android.flexbox.a
    public void n(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.pbO;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.pbP;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.pbO) {
            this.pbO = drawable;
            if (drawable != null) {
                this.pbS = drawable.getIntrinsicHeight();
            } else {
                this.pbS = 0;
            }
            eso();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.pbP) {
            this.pbP = drawable;
            if (drawable != null) {
                this.pbT = drawable.getIntrinsicWidth();
            } else {
                this.pbT = 0;
            }
            eso();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.pbR;
    }

    public int getShowDividerHorizontal() {
        return this.pbQ;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.pbR) {
            this.pbR = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.pbQ) {
            this.pbQ = i;
            requestLayout();
        }
    }

    private void eso() {
        if (this.pbO == null && this.pbP == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean ee(int i, int i2) {
        return ef(i, i2) ? esf() ? (this.pbR & 1) != 0 : (this.pbQ & 1) != 0 : esf() ? (this.pbR & 2) != 0 : (this.pbQ & 2) != 0;
    }

    private boolean ef(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View Qd = Qd(i - i3);
            if (Qd != null && Qd.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean Qe(int i) {
        if (i < 0 || i >= this.pbH.size()) {
            return false;
        }
        return Qf(i) ? esf() ? (this.pbQ & 1) != 0 : (this.pbR & 1) != 0 : esf() ? (this.pbQ & 2) != 0 : (this.pbR & 2) != 0;
    }

    private boolean Qf(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.pbH.get(i2).esm() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean Qg(int i) {
        if (i < 0 || i >= this.pbH.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.pbH.size()) {
                if (this.pbH.get(i3).esm() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (esf()) {
                return (this.pbQ & 4) != 0;
            } else {
                return (this.pbR & 4) != 0;
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
            /* renamed from: Qh */
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
        public int esg() {
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
        public boolean esh() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float esi() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int esj() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int esk() {
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
