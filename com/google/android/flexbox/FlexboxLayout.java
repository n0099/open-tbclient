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
/* loaded from: classes8.dex */
public class FlexboxLayout extends ViewGroup implements a {
    private int hMD;
    private c.a pdA;
    private List<b> pdk;
    private int pdm;
    private int pdn;
    private int pdo;
    private int pdp;
    private int pdq;
    @Nullable
    private Drawable pdr;
    @Nullable
    private Drawable pds;
    private int pdt;
    private int pdu;
    private int pdv;
    private int pdw;
    private int[] pdx;
    private SparseIntArray pdy;
    private c pdz;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hMD = -1;
        this.pdz = new c(this);
        this.pdk = new ArrayList();
        this.pdA = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.pdm = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.pdn = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.pdo = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.pdp = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.pdq = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.hMD = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.pdu = i2;
            this.pdt = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.pdu = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.pdt = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.pdy == null) {
            this.pdy = new SparseIntArray(getChildCount());
        }
        if (this.pdz.d(this.pdy)) {
            this.pdx = this.pdz.c(this.pdy);
        }
        switch (this.pdm) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.pdm);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View Qy(int i) {
        return getChildAt(i);
    }

    public View QG(int i) {
        if (i < 0 || i >= this.pdx.length) {
            return null;
        }
        return getChildAt(this.pdx[i]);
    }

    @Override // com.google.android.flexbox.a
    public View Qz(int i) {
        return QG(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.pdy == null) {
            this.pdy = new SparseIntArray(getChildCount());
        }
        this.pdx = this.pdz.a(view, i, layoutParams, this.pdy);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.pdk.clear();
        this.pdA.reset();
        this.pdz.a(this.pdA, i, i2);
        this.pdk = this.pdA.pdk;
        this.pdz.ed(i, i2);
        if (this.pdp == 3) {
            for (b bVar : this.pdk) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View QG = QG(bVar.pdd + i5);
                        if (QG != null && QG.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) QG.getLayoutParams();
                            if (this.pdn != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + QG.getMeasuredHeight() + Math.max(bVar.pda - QG.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + QG.getMeasuredHeight() + Math.max((bVar.pda - QG.getMeasuredHeight()) + QG.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.pcW = i4;
            }
        }
        this.pdz.an(i, i2, getPaddingTop() + getPaddingBottom());
        this.pdz.esn();
        O(this.pdm, i, i2, this.pdA.pdl);
    }

    private void measureVertical(int i, int i2) {
        this.pdk.clear();
        this.pdA.reset();
        this.pdz.b(this.pdA, i, i2);
        this.pdk = this.pdA.pdk;
        this.pdz.ed(i, i2);
        this.pdz.an(i, i2, getPaddingLeft() + getPaddingRight());
        this.pdz.esn();
        O(this.pdm, i, i2, this.pdA.pdl);
    }

    private void O(int i, int i2, int i3, int i4) {
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
        Iterator<b> it = this.pdk.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().pcU);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.pdk.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.pdk.get(i2);
            if (QH(i2)) {
                if (esd()) {
                    i += this.pdv;
                } else {
                    i += this.pdw;
                }
            }
            if (QJ(i2)) {
                if (esd()) {
                    i += this.pdv;
                } else {
                    i += this.pdw;
                }
            }
            i += bVar.pcW;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean esd() {
        return this.pdm == 0 || this.pdm == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.pdm) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.pdn == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.pdn == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.pdm);
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
        int size = this.pdk.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.pdk.get(i7);
                if (QH(i7)) {
                    paddingBottom -= this.pdv;
                    paddingTop += this.pdv;
                }
                float f5 = 0.0f;
                switch (this.pdo) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.pcU) + paddingRight;
                        f2 = bVar.pcU - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.pcU) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.pcU) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.pcU) / (bVar.esm() != 1 ? esm2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int esm3 = bVar.esm();
                        if (esm3 != 0) {
                            f5 = (i5 - bVar.pcU) / esm3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.esm() != 0) {
                            f5 = (i5 - bVar.pcU) / (esm + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.pdo);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.pdd + i9;
                        View QG = QG(i10);
                        if (QG != null && QG.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) QG.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (ef(i10, i9)) {
                                i11 = this.pdw;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.pdu & 4) > 0) {
                                i12 = this.pdw;
                            }
                            if (this.pdn == 2) {
                                if (z) {
                                    this.pdz.a(QG, bVar, Math.round(f3) - QG.getMeasuredWidth(), paddingBottom - QG.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.pdz.a(QG, bVar, Math.round(f4), paddingBottom - QG.getMeasuredHeight(), Math.round(f4) + QG.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.pdz.a(QG, bVar, Math.round(f3) - QG.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + QG.getMeasuredHeight());
                            } else {
                                this.pdz.a(QG, bVar, Math.round(f4), paddingTop, Math.round(f4) + QG.getMeasuredWidth(), paddingTop + QG.getMeasuredHeight());
                            }
                            f6 = f4 + QG.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((QG.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(QG, i12, 0, i11, 0);
                            } else {
                                bVar.g(QG, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.pcW;
                paddingBottom -= bVar.pcW;
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
        int size = this.pdk.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.pdk.get(i8);
                if (QH(i8)) {
                    paddingLeft += this.pdw;
                    i6 -= this.pdw;
                }
                float f5 = 0.0f;
                switch (this.pdo) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.pcU) + paddingBottom;
                        f2 = bVar.pcU - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.pcU) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.pcU) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.pcU) / (bVar.esm() != 1 ? esm2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int esm3 = bVar.esm();
                        if (esm3 != 0) {
                            f5 = (i5 - bVar.pcU) / esm3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.esm() != 0) {
                            f5 = (i5 - bVar.pcU) / (esm + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.pdo);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.pdd + i10;
                        View QG = QG(i11);
                        if (QG != null && QG.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) QG.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (ef(i11, i10)) {
                                i12 = this.pdv;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.pdt & 4) > 0) {
                                i13 = this.pdv;
                            }
                            if (z) {
                                if (z2) {
                                    this.pdz.a(QG, bVar, true, i6 - QG.getMeasuredWidth(), Math.round(f3) - QG.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.pdz.a(QG, bVar, true, i6 - QG.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + QG.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.pdz.a(QG, bVar, false, paddingLeft, Math.round(f3) - QG.getMeasuredHeight(), paddingLeft + QG.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.pdz.a(QG, bVar, false, paddingLeft, Math.round(f4), paddingLeft + QG.getMeasuredWidth(), Math.round(f4) + QG.getMeasuredHeight());
                            }
                            f6 = f4 + QG.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((QG.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(QG, 0, i13, 0, i12);
                            } else {
                                bVar.g(QG, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.pcW;
                i6 -= bVar.pcW;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.pds != null || this.pdr != null) {
            if (this.pdt != 0 || this.pdu != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.pdm) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.pdn == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.pdn == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.pdn != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.pdn != 2) {
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
        int size = this.pdk.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.pdk.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.pdd + i4;
                View QG = QG(i5);
                if (QG != null && QG.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) QG.getLayoutParams();
                    if (ef(i5, i4)) {
                        if (z) {
                            left = QG.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (QG.getLeft() - layoutParams.leftMargin) - this.pdw;
                        }
                        b(canvas, left, bVar.mTop, bVar.pcW);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.pdu & 4) > 0) {
                        if (z) {
                            right = (QG.getLeft() - layoutParams.leftMargin) - this.pdw;
                        } else {
                            right = layoutParams.rightMargin + QG.getRight();
                        }
                        b(canvas, right, bVar.mTop, bVar.pcW);
                    }
                }
            }
            if (QH(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.pdv;
                }
                c(canvas, paddingLeft, i2, max);
            }
            if (QJ(i3) && (this.pdt & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.pdv;
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
        int size = this.pdk.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.pdk.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.pdd + i4;
                View QG = QG(i5);
                if (QG != null && QG.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) QG.getLayoutParams();
                    if (ef(i5, i4)) {
                        if (z2) {
                            top = QG.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (QG.getTop() - layoutParams.topMargin) - this.pdv;
                        }
                        c(canvas, bVar.mLeft, top, bVar.pcW);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.pdt & 4) > 0) {
                        if (z2) {
                            bottom = (QG.getTop() - layoutParams.topMargin) - this.pdv;
                        } else {
                            bottom = layoutParams.bottomMargin + QG.getBottom();
                        }
                        c(canvas, bVar.mLeft, bottom, bVar.pcW);
                    }
                }
            }
            if (QH(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.pdw;
                }
                b(canvas, i2, paddingTop, max);
            }
            if (QJ(i3) && (this.pdu & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.pdw;
                } else {
                    i = bVar.mRight;
                }
                b(canvas, i, paddingTop, max);
            }
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.pds != null) {
            this.pds.setBounds(i, i2, this.pdw + i, i2 + i3);
            this.pds.draw(canvas);
        }
    }

    private void c(Canvas canvas, int i, int i2, int i3) {
        if (this.pdr != null) {
            this.pdr.setBounds(i, i2, i + i3, this.pdv + i2);
            this.pdr.draw(canvas);
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
        return this.pdm;
    }

    public void setFlexDirection(int i) {
        if (this.pdm != i) {
            this.pdm = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.pdn;
    }

    public void setFlexWrap(int i) {
        if (this.pdn != i) {
            this.pdn = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.pdo;
    }

    public void setJustifyContent(int i) {
        if (this.pdo != i) {
            this.pdo = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.pdp;
    }

    public void setAlignItems(int i) {
        if (this.pdp != i) {
            this.pdp = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.pdq;
    }

    public void setAlignContent(int i) {
        if (this.pdq != i) {
            this.pdq = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.hMD;
    }

    public void setMaxLine(int i) {
        if (this.hMD != i) {
            this.hMD = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.pdk.size());
        for (b bVar : this.pdk) {
            if (bVar.esm() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int k(View view, int i, int i2) {
        int i3;
        if (esd()) {
            i3 = ef(i, i2) ? 0 + this.pdw : 0;
            if ((this.pdu & 4) > 0) {
                return i3 + this.pdw;
            }
            return i3;
        }
        i3 = ef(i, i2) ? 0 + this.pdv : 0;
        if ((this.pdt & 4) > 0) {
            return i3 + this.pdv;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int ef(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (esd()) {
            if ((this.pdu & 4) > 0) {
                bVar.pcU += this.pdw;
                bVar.pcV += this.pdw;
            }
        } else if ((this.pdt & 4) > 0) {
            bVar.pcU += this.pdv;
            bVar.pcV += this.pdv;
        }
    }

    @Override // com.google.android.flexbox.a
    public int ak(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public int al(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, b bVar) {
        if (ef(i, i2)) {
            if (esd()) {
                bVar.pcU += this.pdw;
                bVar.pcV += this.pdw;
                return;
            }
            bVar.pcU += this.pdv;
            bVar.pcV += this.pdv;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.pdk = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.pdk;
    }

    @Override // com.google.android.flexbox.a
    public void n(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.pdr;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.pds;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.pdr) {
            this.pdr = drawable;
            if (drawable != null) {
                this.pdv = drawable.getIntrinsicHeight();
            } else {
                this.pdv = 0;
            }
            eso();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.pds) {
            this.pds = drawable;
            if (drawable != null) {
                this.pdw = drawable.getIntrinsicWidth();
            } else {
                this.pdw = 0;
            }
            eso();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.pdu;
    }

    public int getShowDividerHorizontal() {
        return this.pdt;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.pdu) {
            this.pdu = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.pdt) {
            this.pdt = i;
            requestLayout();
        }
    }

    private void eso() {
        if (this.pdr == null && this.pds == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean ef(int i, int i2) {
        return eg(i, i2) ? esd() ? (this.pdu & 1) != 0 : (this.pdt & 1) != 0 : esd() ? (this.pdu & 2) != 0 : (this.pdt & 2) != 0;
    }

    private boolean eg(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View QG = QG(i - i3);
            if (QG != null && QG.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean QH(int i) {
        if (i < 0 || i >= this.pdk.size()) {
            return false;
        }
        return QI(i) ? esd() ? (this.pdt & 1) != 0 : (this.pdu & 1) != 0 : esd() ? (this.pdt & 2) != 0 : (this.pdu & 2) != 0;
    }

    private boolean QI(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.pdk.get(i2).esm() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean QJ(int i) {
        if (i < 0 || i >= this.pdk.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.pdk.size()) {
                if (this.pdk.get(i3).esm() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (esd()) {
                return (this.pdt & 4) != 0;
            } else {
                return (this.pdu & 4) != 0;
            }
        }
    }

    /* loaded from: classes8.dex */
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
            /* renamed from: QK */
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
        public float ese() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float esf() {
            return this.mFlexShrink;
        }

        public void bB(float f) {
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
