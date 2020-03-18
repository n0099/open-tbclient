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
    private int mLA;
    @Nullable
    private Drawable mLB;
    @Nullable
    private Drawable mLC;
    private int mLD;
    private int mLE;
    private int mLF;
    private int mLG;
    private int[] mLH;
    private SparseIntArray mLI;
    private c mLJ;
    private c.a mLK;
    private List<b> mLt;
    private int mLv;
    private int mLw;
    private int mLx;
    private int mLy;
    private int mLz;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLA = -1;
        this.mLJ = new c(this);
        this.mLt = new ArrayList();
        this.mLK = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.mLv = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.mLw = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.mLx = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.mLy = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.mLz = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.mLA = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.mLE = i2;
            this.mLD = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mLE = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mLD = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mLI == null) {
            this.mLI = new SparseIntArray(getChildCount());
        }
        if (this.mLJ.d(this.mLI)) {
            this.mLH = this.mLJ.c(this.mLI);
        }
        switch (this.mLv) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mLv);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View Mk(int i) {
        return getChildAt(i);
    }

    public View Ms(int i) {
        if (i < 0 || i >= this.mLH.length) {
            return null;
        }
        return getChildAt(this.mLH[i]);
    }

    @Override // com.google.android.flexbox.a
    public View Ml(int i) {
        return Ms(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mLI == null) {
            this.mLI = new SparseIntArray(getChildCount());
        }
        this.mLH = this.mLJ.a(view, i, layoutParams, this.mLI);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.mLt.clear();
        this.mLK.reset();
        this.mLJ.a(this.mLK, i, i2);
        this.mLt = this.mLK.mLt;
        this.mLJ.ec(i, i2);
        if (this.mLy == 3) {
            for (b bVar : this.mLt) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View Ms = Ms(bVar.mLm + i5);
                        if (Ms != null && Ms.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Ms.getLayoutParams();
                            if (this.mLw != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + Ms.getMeasuredHeight() + Math.max(bVar.mLj - Ms.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + Ms.getMeasuredHeight() + Math.max((bVar.mLj - Ms.getMeasuredHeight()) + Ms.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.mLf = i4;
            }
        }
        this.mLJ.aq(i, i2, getPaddingTop() + getPaddingBottom());
        this.mLJ.dAR();
        N(this.mLv, i, i2, this.mLK.mLu);
    }

    private void measureVertical(int i, int i2) {
        this.mLt.clear();
        this.mLK.reset();
        this.mLJ.b(this.mLK, i, i2);
        this.mLt = this.mLK.mLt;
        this.mLJ.ec(i, i2);
        this.mLJ.aq(i, i2, getPaddingLeft() + getPaddingRight());
        this.mLJ.dAR();
        N(this.mLv, i, i2, this.mLK.mLu);
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
        Iterator<b> it = this.mLt.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().mLd);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mLt.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.mLt.get(i2);
            if (Mt(i2)) {
                if (dAJ()) {
                    i += this.mLF;
                } else {
                    i += this.mLG;
                }
            }
            if (Mv(i2)) {
                if (dAJ()) {
                    i += this.mLF;
                } else {
                    i += this.mLG;
                }
            }
            i += bVar.mLf;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean dAJ() {
        return this.mLv == 0 || this.mLv == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.mLv) {
            case 0:
                b(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                b(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.mLw == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.mLw == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.mLv);
        }
    }

    private void b(boolean z, int i, int i2, int i3, int i4) {
        int dAQ;
        float f;
        float f2;
        int dAQ2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.mLt.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.mLt.get(i7);
                if (Mt(i7)) {
                    paddingBottom -= this.mLF;
                    paddingTop += this.mLF;
                }
                float f5 = 0.0f;
                switch (this.mLx) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.mLd) + paddingRight;
                        f2 = bVar.mLd - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.mLd) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.mLd) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.mLd) / (bVar.dAQ() != 1 ? dAQ2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int dAQ3 = bVar.dAQ();
                        if (dAQ3 != 0) {
                            f5 = (i5 - bVar.mLd) / dAQ3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dAQ() != 0) {
                            f5 = (i5 - bVar.mLd) / (dAQ + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mLx);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.mLm + i9;
                        View Ms = Ms(i10);
                        if (Ms != null && Ms.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Ms.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (ee(i10, i9)) {
                                i11 = this.mLG;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.mLE & 4) > 0) {
                                i12 = this.mLG;
                            }
                            if (this.mLw == 2) {
                                if (z) {
                                    this.mLJ.a(Ms, bVar, Math.round(f3) - Ms.getMeasuredWidth(), paddingBottom - Ms.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.mLJ.a(Ms, bVar, Math.round(f4), paddingBottom - Ms.getMeasuredHeight(), Math.round(f4) + Ms.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.mLJ.a(Ms, bVar, Math.round(f3) - Ms.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + Ms.getMeasuredHeight());
                            } else {
                                this.mLJ.a(Ms, bVar, Math.round(f4), paddingTop, Math.round(f4) + Ms.getMeasuredWidth(), paddingTop + Ms.getMeasuredHeight());
                            }
                            f6 = f4 + Ms.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((Ms.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.g(Ms, i12, 0, i11, 0);
                            } else {
                                bVar.g(Ms, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.mLf;
                paddingBottom -= bVar.mLf;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int dAQ;
        float f;
        float f2;
        int dAQ2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.mLt.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.mLt.get(i8);
                if (Mt(i8)) {
                    paddingLeft += this.mLG;
                    i6 -= this.mLG;
                }
                float f5 = 0.0f;
                switch (this.mLx) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.mLd) + paddingBottom;
                        f2 = bVar.mLd - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.mLd) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.mLd) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.mLd) / (bVar.dAQ() != 1 ? dAQ2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int dAQ3 = bVar.dAQ();
                        if (dAQ3 != 0) {
                            f5 = (i5 - bVar.mLd) / dAQ3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dAQ() != 0) {
                            f5 = (i5 - bVar.mLd) / (dAQ + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mLx);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.mLm + i10;
                        View Ms = Ms(i11);
                        if (Ms != null && Ms.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Ms.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (ee(i11, i10)) {
                                i12 = this.mLF;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.mLD & 4) > 0) {
                                i13 = this.mLF;
                            }
                            if (z) {
                                if (z2) {
                                    this.mLJ.a(Ms, bVar, true, i6 - Ms.getMeasuredWidth(), Math.round(f3) - Ms.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.mLJ.a(Ms, bVar, true, i6 - Ms.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + Ms.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.mLJ.a(Ms, bVar, false, paddingLeft, Math.round(f3) - Ms.getMeasuredHeight(), paddingLeft + Ms.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.mLJ.a(Ms, bVar, false, paddingLeft, Math.round(f4), paddingLeft + Ms.getMeasuredWidth(), Math.round(f4) + Ms.getMeasuredHeight());
                            }
                            f6 = f4 + Ms.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((Ms.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.g(Ms, 0, i13, 0, i12);
                            } else {
                                bVar.g(Ms, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.mLf;
                i6 -= bVar.mLf;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.mLC != null || this.mLB != null) {
            if (this.mLD != 0 || this.mLE != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.mLv) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.mLw == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.mLw == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.mLw != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.mLw != 2) {
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
        int size = this.mLt.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mLt.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mLm + i4;
                View Ms = Ms(i5);
                if (Ms != null && Ms.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Ms.getLayoutParams();
                    if (ee(i5, i4)) {
                        if (z) {
                            left = Ms.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (Ms.getLeft() - layoutParams.leftMargin) - this.mLG;
                        }
                        a(canvas, left, bVar.mTop, bVar.mLf);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mLE & 4) > 0) {
                        if (z) {
                            right = (Ms.getLeft() - layoutParams.leftMargin) - this.mLG;
                        } else {
                            right = layoutParams.rightMargin + Ms.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.mLf);
                    }
                }
            }
            if (Mt(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.mLF;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (Mv(i3) && (this.mLD & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.mLF;
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
        int size = this.mLt.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mLt.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mLm + i4;
                View Ms = Ms(i5);
                if (Ms != null && Ms.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Ms.getLayoutParams();
                    if (ee(i5, i4)) {
                        if (z2) {
                            top2 = Ms.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top2 = (Ms.getTop() - layoutParams.topMargin) - this.mLF;
                        }
                        b(canvas, bVar.mLeft, top2, bVar.mLf);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mLD & 4) > 0) {
                        if (z2) {
                            bottom = (Ms.getTop() - layoutParams.topMargin) - this.mLF;
                        } else {
                            bottom = layoutParams.bottomMargin + Ms.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.mLf);
                    }
                }
            }
            if (Mt(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.mLG;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (Mv(i3) && (this.mLE & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.mLG;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.mLC != null) {
            this.mLC.setBounds(i, i2, this.mLG + i, i2 + i3);
            this.mLC.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.mLB != null) {
            this.mLB.setBounds(i, i2, i + i3, this.mLF + i2);
            this.mLB.draw(canvas);
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
        return this.mLv;
    }

    public void setFlexDirection(int i) {
        if (this.mLv != i) {
            this.mLv = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mLw;
    }

    public void setFlexWrap(int i) {
        if (this.mLw != i) {
            this.mLw = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.mLx;
    }

    public void setJustifyContent(int i) {
        if (this.mLx != i) {
            this.mLx = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mLy;
    }

    public void setAlignItems(int i) {
        if (this.mLy != i) {
            this.mLy = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.mLz;
    }

    public void setAlignContent(int i) {
        if (this.mLz != i) {
            this.mLz = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mLA;
    }

    public void setMaxLine(int i) {
        if (this.mLA != i) {
            this.mLA = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mLt.size());
        for (b bVar : this.mLt) {
            if (bVar.dAQ() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int h(View view, int i, int i2) {
        int i3;
        if (dAJ()) {
            i3 = ee(i, i2) ? 0 + this.mLG : 0;
            if ((this.mLE & 4) > 0) {
                return i3 + this.mLG;
            }
            return i3;
        }
        i3 = ee(i, i2) ? 0 + this.mLF : 0;
        if ((this.mLD & 4) > 0) {
            return i3 + this.mLF;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int ds(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (dAJ()) {
            if ((this.mLE & 4) > 0) {
                bVar.mLd += this.mLG;
                bVar.mLe += this.mLG;
            }
        } else if ((this.mLD & 4) > 0) {
            bVar.mLd += this.mLF;
            bVar.mLe += this.mLF;
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
        if (ee(i, i2)) {
            if (dAJ()) {
                bVar.mLd += this.mLG;
                bVar.mLe += this.mLG;
                return;
            }
            bVar.mLd += this.mLF;
            bVar.mLe += this.mLF;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.mLt = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.mLt;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.mLB;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mLC;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.mLB) {
            this.mLB = drawable;
            if (drawable != null) {
                this.mLF = drawable.getIntrinsicHeight();
            } else {
                this.mLF = 0;
            }
            dAS();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.mLC) {
            this.mLC = drawable;
            if (drawable != null) {
                this.mLG = drawable.getIntrinsicWidth();
            } else {
                this.mLG = 0;
            }
            dAS();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.mLE;
    }

    public int getShowDividerHorizontal() {
        return this.mLD;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mLE) {
            this.mLE = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mLD) {
            this.mLD = i;
            requestLayout();
        }
    }

    private void dAS() {
        if (this.mLB == null && this.mLC == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean ee(int i, int i2) {
        return ef(i, i2) ? dAJ() ? (this.mLE & 1) != 0 : (this.mLD & 1) != 0 : dAJ() ? (this.mLE & 2) != 0 : (this.mLD & 2) != 0;
    }

    private boolean ef(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View Ms = Ms(i - i3);
            if (Ms != null && Ms.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean Mt(int i) {
        if (i < 0 || i >= this.mLt.size()) {
            return false;
        }
        return Mu(i) ? dAJ() ? (this.mLD & 1) != 0 : (this.mLE & 1) != 0 : dAJ() ? (this.mLD & 2) != 0 : (this.mLE & 2) != 0;
    }

    private boolean Mu(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mLt.get(i2).dAQ() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean Mv(int i) {
        if (i < 0 || i >= this.mLt.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.mLt.size()) {
                if (this.mLt.get(i3).dAQ() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (dAJ()) {
                return (this.mLD & 4) != 0;
            } else {
                return (this.mLE & 4) != 0;
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
            /* renamed from: Mw */
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
        public int dAK() {
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
        public boolean dAL() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dAM() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dAN() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dAO() {
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
