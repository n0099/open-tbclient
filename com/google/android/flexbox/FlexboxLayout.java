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
    private List<b> mIV;
    private int mIX;
    private int mIY;
    private int mIZ;
    private int mJa;
    private int mJb;
    private int mJc;
    @Nullable
    private Drawable mJd;
    @Nullable
    private Drawable mJe;
    private int mJf;
    private int mJg;
    private int mJh;
    private int mJi;
    private int[] mJj;
    private SparseIntArray mJk;
    private c mJl;
    private c.a mJm;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mJc = -1;
        this.mJl = new c(this);
        this.mIV = new ArrayList();
        this.mJm = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.mIX = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.mIY = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.mIZ = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.mJa = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.mJb = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.mJc = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.mJg = i2;
            this.mJf = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mJg = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mJf = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mJk == null) {
            this.mJk = new SparseIntArray(getChildCount());
        }
        if (this.mJl.d(this.mJk)) {
            this.mJj = this.mJl.c(this.mJk);
        }
        switch (this.mIX) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mIX);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View LZ(int i) {
        return getChildAt(i);
    }

    public View Mh(int i) {
        if (i < 0 || i >= this.mJj.length) {
            return null;
        }
        return getChildAt(this.mJj[i]);
    }

    @Override // com.google.android.flexbox.a
    public View Ma(int i) {
        return Mh(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mJk == null) {
            this.mJk = new SparseIntArray(getChildCount());
        }
        this.mJj = this.mJl.a(view, i, layoutParams, this.mJk);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.mIV.clear();
        this.mJm.reset();
        this.mJl.a(this.mJm, i, i2);
        this.mIV = this.mJm.mIV;
        this.mJl.dY(i, i2);
        if (this.mJa == 3) {
            for (b bVar : this.mIV) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View Mh = Mh(bVar.mIO + i5);
                        if (Mh != null && Mh.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Mh.getLayoutParams();
                            if (this.mIY != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + Mh.getMeasuredHeight() + Math.max(bVar.mIL - Mh.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + Mh.getMeasuredHeight() + Math.max((bVar.mIL - Mh.getMeasuredHeight()) + Mh.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.mIH = i4;
            }
        }
        this.mJl.ap(i, i2, getPaddingTop() + getPaddingBottom());
        this.mJl.dzh();
        N(this.mIX, i, i2, this.mJm.mIW);
    }

    private void measureVertical(int i, int i2) {
        this.mIV.clear();
        this.mJm.reset();
        this.mJl.b(this.mJm, i, i2);
        this.mIV = this.mJm.mIV;
        this.mJl.dY(i, i2);
        this.mJl.ap(i, i2, getPaddingLeft() + getPaddingRight());
        this.mJl.dzh();
        N(this.mIX, i, i2, this.mJm.mIW);
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
        Iterator<b> it = this.mIV.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().mIF);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mIV.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.mIV.get(i2);
            if (Mi(i2)) {
                if (dyZ()) {
                    i += this.mJh;
                } else {
                    i += this.mJi;
                }
            }
            if (Mk(i2)) {
                if (dyZ()) {
                    i += this.mJh;
                } else {
                    i += this.mJi;
                }
            }
            i += bVar.mIH;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean dyZ() {
        return this.mIX == 0 || this.mIX == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.mIX) {
            case 0:
                b(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                b(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.mIY == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.mIY == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.mIX);
        }
    }

    private void b(boolean z, int i, int i2, int i3, int i4) {
        int dzg;
        float f;
        float f2;
        int dzg2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.mIV.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.mIV.get(i7);
                if (Mi(i7)) {
                    paddingBottom -= this.mJh;
                    paddingTop += this.mJh;
                }
                float f5 = 0.0f;
                switch (this.mIZ) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.mIF) + paddingRight;
                        f2 = bVar.mIF - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.mIF) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.mIF) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.mIF) / (bVar.dzg() != 1 ? dzg2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int dzg3 = bVar.dzg();
                        if (dzg3 != 0) {
                            f5 = (i5 - bVar.mIF) / dzg3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dzg() != 0) {
                            f5 = (i5 - bVar.mIF) / (dzg + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mIZ);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.mIO + i9;
                        View Mh = Mh(i10);
                        if (Mh != null && Mh.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Mh.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (ea(i10, i9)) {
                                i11 = this.mJi;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.mJg & 4) > 0) {
                                i12 = this.mJi;
                            }
                            if (this.mIY == 2) {
                                if (z) {
                                    this.mJl.a(Mh, bVar, Math.round(f3) - Mh.getMeasuredWidth(), paddingBottom - Mh.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.mJl.a(Mh, bVar, Math.round(f4), paddingBottom - Mh.getMeasuredHeight(), Math.round(f4) + Mh.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.mJl.a(Mh, bVar, Math.round(f3) - Mh.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + Mh.getMeasuredHeight());
                            } else {
                                this.mJl.a(Mh, bVar, Math.round(f4), paddingTop, Math.round(f4) + Mh.getMeasuredWidth(), paddingTop + Mh.getMeasuredHeight());
                            }
                            f6 = f4 + Mh.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((Mh.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(Mh, i12, 0, i11, 0);
                            } else {
                                bVar.g(Mh, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.mIH;
                paddingBottom -= bVar.mIH;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int dzg;
        float f;
        float f2;
        int dzg2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.mIV.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.mIV.get(i8);
                if (Mi(i8)) {
                    paddingLeft += this.mJi;
                    i6 -= this.mJi;
                }
                float f5 = 0.0f;
                switch (this.mIZ) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.mIF) + paddingBottom;
                        f2 = bVar.mIF - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.mIF) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.mIF) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.mIF) / (bVar.dzg() != 1 ? dzg2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int dzg3 = bVar.dzg();
                        if (dzg3 != 0) {
                            f5 = (i5 - bVar.mIF) / dzg3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dzg() != 0) {
                            f5 = (i5 - bVar.mIF) / (dzg + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mIZ);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.mIO + i10;
                        View Mh = Mh(i11);
                        if (Mh != null && Mh.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Mh.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (ea(i11, i10)) {
                                i12 = this.mJh;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.mJf & 4) > 0) {
                                i13 = this.mJh;
                            }
                            if (z) {
                                if (z2) {
                                    this.mJl.a(Mh, bVar, true, i6 - Mh.getMeasuredWidth(), Math.round(f3) - Mh.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.mJl.a(Mh, bVar, true, i6 - Mh.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + Mh.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.mJl.a(Mh, bVar, false, paddingLeft, Math.round(f3) - Mh.getMeasuredHeight(), paddingLeft + Mh.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.mJl.a(Mh, bVar, false, paddingLeft, Math.round(f4), paddingLeft + Mh.getMeasuredWidth(), Math.round(f4) + Mh.getMeasuredHeight());
                            }
                            f6 = f4 + Mh.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((Mh.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(Mh, 0, i13, 0, i12);
                            } else {
                                bVar.g(Mh, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.mIH;
                i6 -= bVar.mIH;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.mJe != null || this.mJd != null) {
            if (this.mJf != 0 || this.mJg != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.mIX) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.mIY == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.mIY == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.mIY != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.mIY != 2) {
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
        int size = this.mIV.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mIV.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mIO + i4;
                View Mh = Mh(i5);
                if (Mh != null && Mh.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Mh.getLayoutParams();
                    if (ea(i5, i4)) {
                        if (z) {
                            left = Mh.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (Mh.getLeft() - layoutParams.leftMargin) - this.mJi;
                        }
                        a(canvas, left, bVar.mTop, bVar.mIH);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mJg & 4) > 0) {
                        if (z) {
                            right = (Mh.getLeft() - layoutParams.leftMargin) - this.mJi;
                        } else {
                            right = layoutParams.rightMargin + Mh.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.mIH);
                    }
                }
            }
            if (Mi(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.mJh;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (Mk(i3) && (this.mJf & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.mJh;
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
        int size = this.mIV.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mIV.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mIO + i4;
                View Mh = Mh(i5);
                if (Mh != null && Mh.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Mh.getLayoutParams();
                    if (ea(i5, i4)) {
                        if (z2) {
                            top = Mh.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (Mh.getTop() - layoutParams.topMargin) - this.mJh;
                        }
                        b(canvas, bVar.mLeft, top, bVar.mIH);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mJf & 4) > 0) {
                        if (z2) {
                            bottom = (Mh.getTop() - layoutParams.topMargin) - this.mJh;
                        } else {
                            bottom = layoutParams.bottomMargin + Mh.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.mIH);
                    }
                }
            }
            if (Mi(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.mJi;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (Mk(i3) && (this.mJg & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.mJi;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.mJe != null) {
            this.mJe.setBounds(i, i2, this.mJi + i, i2 + i3);
            this.mJe.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.mJd != null) {
            this.mJd.setBounds(i, i2, i + i3, this.mJh + i2);
            this.mJd.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: h */
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
        return this.mIX;
    }

    public void setFlexDirection(int i) {
        if (this.mIX != i) {
            this.mIX = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mIY;
    }

    public void setFlexWrap(int i) {
        if (this.mIY != i) {
            this.mIY = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.mIZ;
    }

    public void setJustifyContent(int i) {
        if (this.mIZ != i) {
            this.mIZ = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mJa;
    }

    public void setAlignItems(int i) {
        if (this.mJa != i) {
            this.mJa = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.mJb;
    }

    public void setAlignContent(int i) {
        if (this.mJb != i) {
            this.mJb = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mJc;
    }

    public void setMaxLine(int i) {
        if (this.mJc != i) {
            this.mJc = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mIV.size());
        for (b bVar : this.mIV) {
            if (bVar.dzg() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int g(View view, int i, int i2) {
        int i3;
        if (dyZ()) {
            i3 = ea(i, i2) ? 0 + this.mJi : 0;
            if ((this.mJg & 4) > 0) {
                return i3 + this.mJi;
            }
            return i3;
        }
        i3 = ea(i, i2) ? 0 + this.mJh : 0;
        if ((this.mJf & 4) > 0) {
            return i3 + this.mJh;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dq(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (dyZ()) {
            if ((this.mJg & 4) > 0) {
                bVar.mIF += this.mJi;
                bVar.mIG += this.mJi;
            }
        } else if ((this.mJf & 4) > 0) {
            bVar.mIF += this.mJh;
            bVar.mIG += this.mJh;
        }
    }

    @Override // com.google.android.flexbox.a
    public int am(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public int an(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, b bVar) {
        if (ea(i, i2)) {
            if (dyZ()) {
                bVar.mIF += this.mJi;
                bVar.mIG += this.mJi;
                return;
            }
            bVar.mIF += this.mJh;
            bVar.mIG += this.mJh;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.mIV = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.mIV;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.mJd;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mJe;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.mJd) {
            this.mJd = drawable;
            if (drawable != null) {
                this.mJh = drawable.getIntrinsicHeight();
            } else {
                this.mJh = 0;
            }
            dzi();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.mJe) {
            this.mJe = drawable;
            if (drawable != null) {
                this.mJi = drawable.getIntrinsicWidth();
            } else {
                this.mJi = 0;
            }
            dzi();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.mJg;
    }

    public int getShowDividerHorizontal() {
        return this.mJf;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mJg) {
            this.mJg = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mJf) {
            this.mJf = i;
            requestLayout();
        }
    }

    private void dzi() {
        if (this.mJd == null && this.mJe == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean ea(int i, int i2) {
        return eb(i, i2) ? dyZ() ? (this.mJg & 1) != 0 : (this.mJf & 1) != 0 : dyZ() ? (this.mJg & 2) != 0 : (this.mJf & 2) != 0;
    }

    private boolean eb(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View Mh = Mh(i - i3);
            if (Mh != null && Mh.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean Mi(int i) {
        if (i < 0 || i >= this.mIV.size()) {
            return false;
        }
        return Mj(i) ? dyZ() ? (this.mJf & 1) != 0 : (this.mJg & 1) != 0 : dyZ() ? (this.mJf & 2) != 0 : (this.mJg & 2) != 0;
    }

    private boolean Mj(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mIV.get(i2).dzg() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean Mk(int i) {
        if (i < 0 || i >= this.mIV.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.mIV.size()) {
                if (this.mIV.get(i3).dzg() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (dyZ()) {
                return (this.mJf & 4) != 0;
            } else {
                return (this.mJg & 4) != 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayout.LayoutParams.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: aO */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Ml */
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
        public int dza() {
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
        public boolean dzb() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dzc() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dzd() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dze() {
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
