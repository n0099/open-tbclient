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
    private List<b> mih;
    private int mij;
    private int mik;
    private int mil;
    private int mim;
    private int mio;
    private int mip;
    @Nullable
    private Drawable miq;
    @Nullable
    private Drawable mir;
    private int mis;
    private int mit;
    private int miu;
    private int miv;
    private int[] miw;
    private SparseIntArray mix;
    private c miy;
    private c.a miz;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mip = -1;
        this.miy = new c(this);
        this.mih = new ArrayList();
        this.miz = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.mij = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.mik = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.mil = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.mim = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.mio = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.mip = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.mit = i2;
            this.mis = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mit = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mis = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mix == null) {
            this.mix = new SparseIntArray(getChildCount());
        }
        if (this.miy.d(this.mix)) {
            this.miw = this.miy.c(this.mix);
        }
        switch (this.mij) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mij);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View HE(int i) {
        return getChildAt(i);
    }

    public View HM(int i) {
        if (i < 0 || i >= this.miw.length) {
            return null;
        }
        return getChildAt(this.miw[i]);
    }

    @Override // com.google.android.flexbox.a
    public View HF(int i) {
        return HM(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mix == null) {
            this.mix = new SparseIntArray(getChildCount());
        }
        this.miw = this.miy.a(view, i, layoutParams, this.mix);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.mih.clear();
        this.miz.reset();
        this.miy.a(this.miz, i, i2);
        this.mih = this.miz.mih;
        this.miy.m39do(i, i2);
        if (this.mim == 3) {
            for (b bVar : this.mih) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View HM = HM(bVar.mhZ + i5);
                        if (HM != null && HM.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) HM.getLayoutParams();
                            if (this.mik != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + HM.getMeasuredHeight() + Math.max(bVar.mhW - HM.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + HM.getMeasuredHeight() + Math.max((bVar.mhW - HM.getMeasuredHeight()) + HM.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.mhS = i4;
            }
        }
        this.miy.aj(i, i2, getPaddingTop() + getPaddingBottom());
        this.miy.dvh();
        H(this.mij, i, i2, this.miz.mii);
    }

    private void measureVertical(int i, int i2) {
        this.mih.clear();
        this.miz.reset();
        this.miy.b(this.miz, i, i2);
        this.mih = this.miz.mih;
        this.miy.m39do(i, i2);
        this.miy.aj(i, i2, getPaddingLeft() + getPaddingRight());
        this.miy.dvh();
        H(this.mij, i, i2, this.miz.mii);
    }

    private void H(int i, int i2, int i3, int i4) {
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
        Iterator<b> it = this.mih.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().mhQ);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mih.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.mih.get(i2);
            if (HN(i2)) {
                if (duZ()) {
                    i += this.miu;
                } else {
                    i += this.miv;
                }
            }
            if (HP(i2)) {
                if (duZ()) {
                    i += this.miu;
                } else {
                    i += this.miv;
                }
            }
            i += bVar.mhS;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean duZ() {
        return this.mij == 0 || this.mij == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.mij) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.mik == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.mik == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.mij);
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int dvg;
        float f;
        float f2;
        int dvg2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.mih.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.mih.get(i7);
                if (HN(i7)) {
                    paddingBottom -= this.miu;
                    paddingTop += this.miu;
                }
                float f5 = 0.0f;
                switch (this.mil) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.mhQ) + paddingRight;
                        f2 = bVar.mhQ - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.mhQ) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.mhQ) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.mhQ) / (bVar.dvg() != 1 ? dvg2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int dvg3 = bVar.dvg();
                        if (dvg3 != 0) {
                            f5 = (i5 - bVar.mhQ) / dvg3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dvg() != 0) {
                            f5 = (i5 - bVar.mhQ) / (dvg + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mil);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.mhZ + i9;
                        View HM = HM(i10);
                        if (HM != null && HM.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) HM.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (dq(i10, i9)) {
                                i11 = this.miv;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.mit & 4) > 0) {
                                i12 = this.miv;
                            }
                            if (this.mik == 2) {
                                if (z) {
                                    this.miy.a(HM, bVar, Math.round(f3) - HM.getMeasuredWidth(), paddingBottom - HM.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.miy.a(HM, bVar, Math.round(f4), paddingBottom - HM.getMeasuredHeight(), Math.round(f4) + HM.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.miy.a(HM, bVar, Math.round(f3) - HM.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + HM.getMeasuredHeight());
                            } else {
                                this.miy.a(HM, bVar, Math.round(f4), paddingTop, Math.round(f4) + HM.getMeasuredWidth(), paddingTop + HM.getMeasuredHeight());
                            }
                            f6 = f4 + HM.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((HM.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.h(HM, i12, 0, i11, 0);
                            } else {
                                bVar.h(HM, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.mhS;
                paddingBottom -= bVar.mhS;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int dvg;
        float f;
        float f2;
        int dvg2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.mih.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.mih.get(i8);
                if (HN(i8)) {
                    paddingLeft += this.miv;
                    i6 -= this.miv;
                }
                float f5 = 0.0f;
                switch (this.mil) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.mhQ) + paddingBottom;
                        f2 = bVar.mhQ - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.mhQ) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.mhQ) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.mhQ) / (bVar.dvg() != 1 ? dvg2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int dvg3 = bVar.dvg();
                        if (dvg3 != 0) {
                            f5 = (i5 - bVar.mhQ) / dvg3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dvg() != 0) {
                            f5 = (i5 - bVar.mhQ) / (dvg + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mil);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.mhZ + i10;
                        View HM = HM(i11);
                        if (HM != null && HM.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) HM.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (dq(i11, i10)) {
                                i12 = this.miu;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.mis & 4) > 0) {
                                i13 = this.miu;
                            }
                            if (z) {
                                if (z2) {
                                    this.miy.a(HM, bVar, true, i6 - HM.getMeasuredWidth(), Math.round(f3) - HM.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.miy.a(HM, bVar, true, i6 - HM.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + HM.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.miy.a(HM, bVar, false, paddingLeft, Math.round(f3) - HM.getMeasuredHeight(), paddingLeft + HM.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.miy.a(HM, bVar, false, paddingLeft, Math.round(f4), paddingLeft + HM.getMeasuredWidth(), Math.round(f4) + HM.getMeasuredHeight());
                            }
                            f6 = f4 + HM.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((HM.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.h(HM, 0, i13, 0, i12);
                            } else {
                                bVar.h(HM, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.mhS;
                i6 -= bVar.mhS;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.mir != null || this.miq != null) {
            if (this.mis != 0 || this.mit != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.mij) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.mik == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.mik == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.mik != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.mik != 2) {
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
        int size = this.mih.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mih.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mhZ + i4;
                View HM = HM(i5);
                if (HM != null && HM.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) HM.getLayoutParams();
                    if (dq(i5, i4)) {
                        if (z) {
                            left = HM.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (HM.getLeft() - layoutParams.leftMargin) - this.miv;
                        }
                        a(canvas, left, bVar.mTop, bVar.mhS);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mit & 4) > 0) {
                        if (z) {
                            right = (HM.getLeft() - layoutParams.leftMargin) - this.miv;
                        } else {
                            right = layoutParams.rightMargin + HM.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.mhS);
                    }
                }
            }
            if (HN(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.miu;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (HP(i3) && (this.mis & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.miu;
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
        int size = this.mih.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mih.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mhZ + i4;
                View HM = HM(i5);
                if (HM != null && HM.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) HM.getLayoutParams();
                    if (dq(i5, i4)) {
                        if (z2) {
                            top2 = HM.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top2 = (HM.getTop() - layoutParams.topMargin) - this.miu;
                        }
                        b(canvas, bVar.mLeft, top2, bVar.mhS);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mis & 4) > 0) {
                        if (z2) {
                            bottom = (HM.getTop() - layoutParams.topMargin) - this.miu;
                        } else {
                            bottom = layoutParams.bottomMargin + HM.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.mhS);
                    }
                }
            }
            if (HN(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.miv;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (HP(i3) && (this.mit & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.miv;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.mir != null) {
            this.mir.setBounds(i, i2, this.miv + i, i2 + i3);
            this.mir.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.miq != null) {
            this.miq.setBounds(i, i2, i + i3, this.miu + i2);
            this.miq.draw(canvas);
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
        return this.mij;
    }

    public void setFlexDirection(int i) {
        if (this.mij != i) {
            this.mij = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mik;
    }

    public void setFlexWrap(int i) {
        if (this.mik != i) {
            this.mik = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.mil;
    }

    public void setJustifyContent(int i) {
        if (this.mil != i) {
            this.mil = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mim;
    }

    public void setAlignItems(int i) {
        if (this.mim != i) {
            this.mim = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.mio;
    }

    public void setAlignContent(int i) {
        if (this.mio != i) {
            this.mio = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mip;
    }

    public void setMaxLine(int i) {
        if (this.mip != i) {
            this.mip = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mih.size());
        for (b bVar : this.mih) {
            if (bVar.dvg() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int h(View view, int i, int i2) {
        int i3;
        if (duZ()) {
            i3 = dq(i, i2) ? 0 + this.miv : 0;
            if ((this.mit & 4) > 0) {
                return i3 + this.miv;
            }
            return i3;
        }
        i3 = dq(i, i2) ? 0 + this.miu : 0;
        if ((this.mis & 4) > 0) {
            return i3 + this.miu;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dj(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (duZ()) {
            if ((this.mit & 4) > 0) {
                bVar.mhQ += this.miv;
                bVar.mhR += this.miv;
            }
        } else if ((this.mis & 4) > 0) {
            bVar.mhQ += this.miu;
            bVar.mhR += this.miu;
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
        if (dq(i, i2)) {
            if (duZ()) {
                bVar.mhQ += this.miv;
                bVar.mhR += this.miv;
                return;
            }
            bVar.mhQ += this.miu;
            bVar.mhR += this.miu;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.mih = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.mih;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.miq;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mir;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.miq) {
            this.miq = drawable;
            if (drawable != null) {
                this.miu = drawable.getIntrinsicHeight();
            } else {
                this.miu = 0;
            }
            dvi();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.mir) {
            this.mir = drawable;
            if (drawable != null) {
                this.miv = drawable.getIntrinsicWidth();
            } else {
                this.miv = 0;
            }
            dvi();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.mit;
    }

    public int getShowDividerHorizontal() {
        return this.mis;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mit) {
            this.mit = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mis) {
            this.mis = i;
            requestLayout();
        }
    }

    private void dvi() {
        if (this.miq == null && this.mir == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean dq(int i, int i2) {
        return dr(i, i2) ? duZ() ? (this.mit & 1) != 0 : (this.mis & 1) != 0 : duZ() ? (this.mit & 2) != 0 : (this.mis & 2) != 0;
    }

    private boolean dr(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View HM = HM(i - i3);
            if (HM != null && HM.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean HN(int i) {
        if (i < 0 || i >= this.mih.size()) {
            return false;
        }
        return HO(i) ? duZ() ? (this.mis & 1) != 0 : (this.mit & 1) != 0 : duZ() ? (this.mis & 2) != 0 : (this.mit & 2) != 0;
    }

    private boolean HO(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mih.get(i2).dvg() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean HP(int i) {
        if (i < 0 || i >= this.mih.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.mih.size()) {
                if (this.mih.get(i3).dvg() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (duZ()) {
                return (this.mis & 4) != 0;
            } else {
                return (this.mit & 4) != 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayout.LayoutParams.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: af */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: HQ */
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
        public int dva() {
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
        public boolean dvb() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dvc() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dvd() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dve() {
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
