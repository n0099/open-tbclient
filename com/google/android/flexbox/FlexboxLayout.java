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
    private List<b> mJC;
    private int mJE;
    private int mJF;
    private int mJG;
    private int mJH;
    private int mJI;
    private int mJJ;
    @Nullable
    private Drawable mJK;
    @Nullable
    private Drawable mJL;
    private int mJM;
    private int mJN;
    private int mJO;
    private int mJP;
    private int[] mJQ;
    private SparseIntArray mJR;
    private c mJS;
    private c.a mJT;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mJJ = -1;
        this.mJS = new c(this);
        this.mJC = new ArrayList();
        this.mJT = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.mJE = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.mJF = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.mJG = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.mJH = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.mJI = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.mJJ = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.mJN = i2;
            this.mJM = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mJN = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mJM = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mJR == null) {
            this.mJR = new SparseIntArray(getChildCount());
        }
        if (this.mJS.d(this.mJR)) {
            this.mJQ = this.mJS.c(this.mJR);
        }
        switch (this.mJE) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mJE);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View Me(int i) {
        return getChildAt(i);
    }

    public View Mm(int i) {
        if (i < 0 || i >= this.mJQ.length) {
            return null;
        }
        return getChildAt(this.mJQ[i]);
    }

    @Override // com.google.android.flexbox.a
    public View Mf(int i) {
        return Mm(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mJR == null) {
            this.mJR = new SparseIntArray(getChildCount());
        }
        this.mJQ = this.mJS.a(view, i, layoutParams, this.mJR);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.mJC.clear();
        this.mJT.reset();
        this.mJS.a(this.mJT, i, i2);
        this.mJC = this.mJT.mJC;
        this.mJS.eb(i, i2);
        if (this.mJH == 3) {
            for (b bVar : this.mJC) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View Mm = Mm(bVar.mJv + i5);
                        if (Mm != null && Mm.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Mm.getLayoutParams();
                            if (this.mJF != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + Mm.getMeasuredHeight() + Math.max(bVar.mJs - Mm.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + Mm.getMeasuredHeight() + Math.max((bVar.mJs - Mm.getMeasuredHeight()) + Mm.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.mJo = i4;
            }
        }
        this.mJS.aq(i, i2, getPaddingTop() + getPaddingBottom());
        this.mJS.dAt();
        N(this.mJE, i, i2, this.mJT.mJD);
    }

    private void measureVertical(int i, int i2) {
        this.mJC.clear();
        this.mJT.reset();
        this.mJS.b(this.mJT, i, i2);
        this.mJC = this.mJT.mJC;
        this.mJS.eb(i, i2);
        this.mJS.aq(i, i2, getPaddingLeft() + getPaddingRight());
        this.mJS.dAt();
        N(this.mJE, i, i2, this.mJT.mJD);
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
        Iterator<b> it = this.mJC.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().mJm);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mJC.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.mJC.get(i2);
            if (Mn(i2)) {
                if (dAl()) {
                    i += this.mJO;
                } else {
                    i += this.mJP;
                }
            }
            if (Mp(i2)) {
                if (dAl()) {
                    i += this.mJO;
                } else {
                    i += this.mJP;
                }
            }
            i += bVar.mJo;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean dAl() {
        return this.mJE == 0 || this.mJE == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.mJE) {
            case 0:
                b(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                b(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.mJF == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.mJF == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.mJE);
        }
    }

    private void b(boolean z, int i, int i2, int i3, int i4) {
        int dAs;
        float f;
        float f2;
        int dAs2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.mJC.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.mJC.get(i7);
                if (Mn(i7)) {
                    paddingBottom -= this.mJO;
                    paddingTop += this.mJO;
                }
                float f5 = 0.0f;
                switch (this.mJG) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.mJm) + paddingRight;
                        f2 = bVar.mJm - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.mJm) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.mJm) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.mJm) / (bVar.dAs() != 1 ? dAs2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int dAs3 = bVar.dAs();
                        if (dAs3 != 0) {
                            f5 = (i5 - bVar.mJm) / dAs3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dAs() != 0) {
                            f5 = (i5 - bVar.mJm) / (dAs + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mJG);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.mJv + i9;
                        View Mm = Mm(i10);
                        if (Mm != null && Mm.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Mm.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (ed(i10, i9)) {
                                i11 = this.mJP;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.mJN & 4) > 0) {
                                i12 = this.mJP;
                            }
                            if (this.mJF == 2) {
                                if (z) {
                                    this.mJS.a(Mm, bVar, Math.round(f3) - Mm.getMeasuredWidth(), paddingBottom - Mm.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.mJS.a(Mm, bVar, Math.round(f4), paddingBottom - Mm.getMeasuredHeight(), Math.round(f4) + Mm.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.mJS.a(Mm, bVar, Math.round(f3) - Mm.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + Mm.getMeasuredHeight());
                            } else {
                                this.mJS.a(Mm, bVar, Math.round(f4), paddingTop, Math.round(f4) + Mm.getMeasuredWidth(), paddingTop + Mm.getMeasuredHeight());
                            }
                            f6 = f4 + Mm.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((Mm.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(Mm, i12, 0, i11, 0);
                            } else {
                                bVar.g(Mm, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.mJo;
                paddingBottom -= bVar.mJo;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int dAs;
        float f;
        float f2;
        int dAs2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.mJC.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.mJC.get(i8);
                if (Mn(i8)) {
                    paddingLeft += this.mJP;
                    i6 -= this.mJP;
                }
                float f5 = 0.0f;
                switch (this.mJG) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.mJm) + paddingBottom;
                        f2 = bVar.mJm - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.mJm) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.mJm) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.mJm) / (bVar.dAs() != 1 ? dAs2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int dAs3 = bVar.dAs();
                        if (dAs3 != 0) {
                            f5 = (i5 - bVar.mJm) / dAs3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dAs() != 0) {
                            f5 = (i5 - bVar.mJm) / (dAs + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mJG);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.mJv + i10;
                        View Mm = Mm(i11);
                        if (Mm != null && Mm.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Mm.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (ed(i11, i10)) {
                                i12 = this.mJO;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.mJM & 4) > 0) {
                                i13 = this.mJO;
                            }
                            if (z) {
                                if (z2) {
                                    this.mJS.a(Mm, bVar, true, i6 - Mm.getMeasuredWidth(), Math.round(f3) - Mm.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.mJS.a(Mm, bVar, true, i6 - Mm.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + Mm.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.mJS.a(Mm, bVar, false, paddingLeft, Math.round(f3) - Mm.getMeasuredHeight(), paddingLeft + Mm.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.mJS.a(Mm, bVar, false, paddingLeft, Math.round(f4), paddingLeft + Mm.getMeasuredWidth(), Math.round(f4) + Mm.getMeasuredHeight());
                            }
                            f6 = f4 + Mm.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((Mm.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(Mm, 0, i13, 0, i12);
                            } else {
                                bVar.g(Mm, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.mJo;
                i6 -= bVar.mJo;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.mJL != null || this.mJK != null) {
            if (this.mJM != 0 || this.mJN != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.mJE) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.mJF == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.mJF == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.mJF != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.mJF != 2) {
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
        int size = this.mJC.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mJC.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mJv + i4;
                View Mm = Mm(i5);
                if (Mm != null && Mm.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Mm.getLayoutParams();
                    if (ed(i5, i4)) {
                        if (z) {
                            left = Mm.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (Mm.getLeft() - layoutParams.leftMargin) - this.mJP;
                        }
                        a(canvas, left, bVar.mTop, bVar.mJo);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mJN & 4) > 0) {
                        if (z) {
                            right = (Mm.getLeft() - layoutParams.leftMargin) - this.mJP;
                        } else {
                            right = layoutParams.rightMargin + Mm.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.mJo);
                    }
                }
            }
            if (Mn(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.mJO;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (Mp(i3) && (this.mJM & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.mJO;
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
        int size = this.mJC.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mJC.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mJv + i4;
                View Mm = Mm(i5);
                if (Mm != null && Mm.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Mm.getLayoutParams();
                    if (ed(i5, i4)) {
                        if (z2) {
                            top2 = Mm.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top2 = (Mm.getTop() - layoutParams.topMargin) - this.mJO;
                        }
                        b(canvas, bVar.mLeft, top2, bVar.mJo);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mJM & 4) > 0) {
                        if (z2) {
                            bottom = (Mm.getTop() - layoutParams.topMargin) - this.mJO;
                        } else {
                            bottom = layoutParams.bottomMargin + Mm.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.mJo);
                    }
                }
            }
            if (Mn(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.mJP;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (Mp(i3) && (this.mJN & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.mJP;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.mJL != null) {
            this.mJL.setBounds(i, i2, this.mJP + i, i2 + i3);
            this.mJL.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.mJK != null) {
            this.mJK.setBounds(i, i2, i + i3, this.mJO + i2);
            this.mJK.draw(canvas);
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
        return this.mJE;
    }

    public void setFlexDirection(int i) {
        if (this.mJE != i) {
            this.mJE = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mJF;
    }

    public void setFlexWrap(int i) {
        if (this.mJF != i) {
            this.mJF = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.mJG;
    }

    public void setJustifyContent(int i) {
        if (this.mJG != i) {
            this.mJG = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mJH;
    }

    public void setAlignItems(int i) {
        if (this.mJH != i) {
            this.mJH = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.mJI;
    }

    public void setAlignContent(int i) {
        if (this.mJI != i) {
            this.mJI = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mJJ;
    }

    public void setMaxLine(int i) {
        if (this.mJJ != i) {
            this.mJJ = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mJC.size());
        for (b bVar : this.mJC) {
            if (bVar.dAs() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int g(View view, int i, int i2) {
        int i3;
        if (dAl()) {
            i3 = ed(i, i2) ? 0 + this.mJP : 0;
            if ((this.mJN & 4) > 0) {
                return i3 + this.mJP;
            }
            return i3;
        }
        i3 = ed(i, i2) ? 0 + this.mJO : 0;
        if ((this.mJM & 4) > 0) {
            return i3 + this.mJO;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int ds(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (dAl()) {
            if ((this.mJN & 4) > 0) {
                bVar.mJm += this.mJP;
                bVar.mJn += this.mJP;
            }
        } else if ((this.mJM & 4) > 0) {
            bVar.mJm += this.mJO;
            bVar.mJn += this.mJO;
        }
    }

    @Override // com.google.android.flexbox.a
    public int an(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public int ao(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, b bVar) {
        if (ed(i, i2)) {
            if (dAl()) {
                bVar.mJm += this.mJP;
                bVar.mJn += this.mJP;
                return;
            }
            bVar.mJm += this.mJO;
            bVar.mJn += this.mJO;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.mJC = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.mJC;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.mJK;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mJL;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.mJK) {
            this.mJK = drawable;
            if (drawable != null) {
                this.mJO = drawable.getIntrinsicHeight();
            } else {
                this.mJO = 0;
            }
            dAu();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.mJL) {
            this.mJL = drawable;
            if (drawable != null) {
                this.mJP = drawable.getIntrinsicWidth();
            } else {
                this.mJP = 0;
            }
            dAu();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.mJN;
    }

    public int getShowDividerHorizontal() {
        return this.mJM;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mJN) {
            this.mJN = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mJM) {
            this.mJM = i;
            requestLayout();
        }
    }

    private void dAu() {
        if (this.mJK == null && this.mJL == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean ed(int i, int i2) {
        return ee(i, i2) ? dAl() ? (this.mJN & 1) != 0 : (this.mJM & 1) != 0 : dAl() ? (this.mJN & 2) != 0 : (this.mJM & 2) != 0;
    }

    private boolean ee(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View Mm = Mm(i - i3);
            if (Mm != null && Mm.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean Mn(int i) {
        if (i < 0 || i >= this.mJC.size()) {
            return false;
        }
        return Mo(i) ? dAl() ? (this.mJM & 1) != 0 : (this.mJN & 1) != 0 : dAl() ? (this.mJM & 2) != 0 : (this.mJN & 2) != 0;
    }

    private boolean Mo(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mJC.get(i2).dAs() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean Mp(int i) {
        if (i < 0 || i >= this.mJC.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.mJC.size()) {
                if (this.mJC.get(i3).dAs() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (dAl()) {
                return (this.mJM & 4) != 0;
            } else {
                return (this.mJN & 4) != 0;
            }
        }
    }

    /* loaded from: classes5.dex */
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
            /* renamed from: Mq */
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
        public int dAm() {
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
        public boolean dAn() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dAo() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dAp() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dAq() {
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
