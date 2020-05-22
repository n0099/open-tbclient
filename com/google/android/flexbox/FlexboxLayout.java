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
    private List<b> mBY;
    private int mCa;
    private int mCb;
    private int mCc;
    private int mCd;
    private int mCe;
    private int mCf;
    @Nullable
    private Drawable mCg;
    @Nullable
    private Drawable mCh;
    private int mCi;
    private int mCj;
    private int mCk;
    private int mCl;
    private int[] mCm;
    private SparseIntArray mCn;
    private c mCo;
    private c.a mCp;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCf = -1;
        this.mCo = new c(this);
        this.mBY = new ArrayList();
        this.mCp = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i, 0);
        this.mCa = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexDirection, 0);
        this.mCb = obtainStyledAttributes.getInt(d.a.FlexboxLayout_flexWrap, 0);
        this.mCc = obtainStyledAttributes.getInt(d.a.FlexboxLayout_justifyContent, 0);
        this.mCd = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignItems, 4);
        this.mCe = obtainStyledAttributes.getInt(d.a.FlexboxLayout_alignContent, 5);
        this.mCf = obtainStyledAttributes.getInt(d.a.FlexboxLayout_maxLine, -1);
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
            this.mCj = i2;
            this.mCi = i2;
        }
        int i3 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mCj = i3;
        }
        int i4 = obtainStyledAttributes.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mCi = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mCn == null) {
            this.mCn = new SparseIntArray(getChildCount());
        }
        if (this.mCo.d(this.mCn)) {
            this.mCm = this.mCo.c(this.mCn);
        }
        switch (this.mCa) {
            case 0:
            case 1:
                measureHorizontal(i, i2);
                return;
            case 2:
            case 3:
                measureVertical(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mCa);
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public View Iq(int i) {
        return getChildAt(i);
    }

    public View Iy(int i) {
        if (i < 0 || i >= this.mCm.length) {
            return null;
        }
        return getChildAt(this.mCm[i]);
    }

    @Override // com.google.android.flexbox.a
    public View Ir(int i) {
        return Iy(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mCn == null) {
            this.mCn = new SparseIntArray(getChildCount());
        }
        this.mCm = this.mCo.a(view, i, layoutParams, this.mCn);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.mBY.clear();
        this.mCp.reset();
        this.mCo.a(this.mCp, i, i2);
        this.mBY = this.mCp.mBY;
        this.mCo.dt(i, i2);
        if (this.mCd == 3) {
            for (b bVar : this.mBY) {
                int i3 = 0;
                int i4 = Integer.MIN_VALUE;
                while (true) {
                    int i5 = i3;
                    if (i5 < bVar.mItemCount) {
                        View Iy = Iy(bVar.mBR + i5);
                        if (Iy != null && Iy.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Iy.getLayoutParams();
                            if (this.mCb != 2) {
                                i4 = Math.max(i4, layoutParams.bottomMargin + Iy.getMeasuredHeight() + Math.max(bVar.mBO - Iy.getBaseline(), layoutParams.topMargin));
                            } else {
                                i4 = Math.max(i4, layoutParams.topMargin + Iy.getMeasuredHeight() + Math.max((bVar.mBO - Iy.getMeasuredHeight()) + Iy.getBaseline(), layoutParams.bottomMargin));
                            }
                        }
                        i3 = i5 + 1;
                    }
                }
                bVar.mBK = i4;
            }
        }
        this.mCo.aj(i, i2, getPaddingTop() + getPaddingBottom());
        this.mCo.dCy();
        I(this.mCa, i, i2, this.mCp.mBZ);
    }

    private void measureVertical(int i, int i2) {
        this.mBY.clear();
        this.mCp.reset();
        this.mCo.b(this.mCp, i, i2);
        this.mBY = this.mCp.mBY;
        this.mCo.dt(i, i2);
        this.mCo.aj(i, i2, getPaddingLeft() + getPaddingRight());
        this.mCo.dCy();
        I(this.mCa, i, i2, this.mCp.mBZ);
    }

    private void I(int i, int i2, int i3, int i4) {
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
        Iterator<b> it = this.mBY.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, it.next().mBI);
            } else {
                return i2;
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mBY.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.mBY.get(i2);
            if (Iz(i2)) {
                if (dCq()) {
                    i += this.mCk;
                } else {
                    i += this.mCl;
                }
            }
            if (IB(i2)) {
                if (dCq()) {
                    i += this.mCk;
                } else {
                    i += this.mCl;
                }
            }
            i += bVar.mBK;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean dCq() {
        return this.mCa == 0 || this.mCa == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (this.mCa) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                boolean z4 = layoutDirection == 1;
                if (this.mCb == 2) {
                    z3 = z4 ? false : true;
                } else {
                    z3 = z4;
                }
                a(z3, false, i, i2, i3, i4);
                return;
            case 3:
                boolean z5 = layoutDirection == 1;
                if (this.mCb == 2) {
                    z2 = z5 ? false : true;
                } else {
                    z2 = z5;
                }
                a(z2, true, i, i2, i3, i4);
                return;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.mCa);
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int dCx;
        float f;
        float f2;
        int dCx2;
        float f3;
        float f4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.mBY.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                b bVar = this.mBY.get(i7);
                if (Iz(i7)) {
                    paddingBottom -= this.mCk;
                    paddingTop += this.mCk;
                }
                float f5 = 0.0f;
                switch (this.mCc) {
                    case 0:
                        f = paddingLeft;
                        f2 = i5 - paddingRight;
                        break;
                    case 1:
                        f = (i5 - bVar.mBI) + paddingRight;
                        f2 = bVar.mBI - paddingLeft;
                        break;
                    case 2:
                        f = ((i5 - bVar.mBI) / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - ((i5 - bVar.mBI) / 2.0f);
                        break;
                    case 3:
                        f = paddingLeft;
                        f5 = (i5 - bVar.mBI) / (bVar.dCx() != 1 ? dCx2 - 1 : 1.0f);
                        f2 = i5 - paddingRight;
                        break;
                    case 4:
                        int dCx3 = bVar.dCx();
                        if (dCx3 != 0) {
                            f5 = (i5 - bVar.mBI) / dCx3;
                        }
                        f = (f5 / 2.0f) + paddingLeft;
                        f2 = (i5 - paddingRight) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dCx() != 0) {
                            f5 = (i5 - bVar.mBI) / (dCx + 1);
                        }
                        f = paddingLeft + f5;
                        f2 = (i5 - paddingRight) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mCc);
                }
                float max = Math.max(f5, 0.0f);
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    float f6 = f;
                    float f7 = f2;
                    if (i9 < bVar.mItemCount) {
                        int i10 = bVar.mBR + i9;
                        View Iy = Iy(i10);
                        if (Iy != null && Iy.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Iy.getLayoutParams();
                            float f8 = f6 + layoutParams.leftMargin;
                            float f9 = f7 - layoutParams.rightMargin;
                            int i11 = 0;
                            int i12 = 0;
                            if (dv(i10, i9)) {
                                i11 = this.mCl;
                                f3 = f9 - i11;
                                f4 = i11 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i9 == bVar.mItemCount - 1 && (this.mCj & 4) > 0) {
                                i12 = this.mCl;
                            }
                            if (this.mCb == 2) {
                                if (z) {
                                    this.mCo.a(Iy, bVar, Math.round(f3) - Iy.getMeasuredWidth(), paddingBottom - Iy.getMeasuredHeight(), Math.round(f3), paddingBottom);
                                } else {
                                    this.mCo.a(Iy, bVar, Math.round(f4), paddingBottom - Iy.getMeasuredHeight(), Math.round(f4) + Iy.getMeasuredWidth(), paddingBottom);
                                }
                            } else if (z) {
                                this.mCo.a(Iy, bVar, Math.round(f3) - Iy.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + Iy.getMeasuredHeight());
                            } else {
                                this.mCo.a(Iy, bVar, Math.round(f4), paddingTop, Math.round(f4) + Iy.getMeasuredWidth(), paddingTop + Iy.getMeasuredHeight());
                            }
                            f6 = f4 + Iy.getMeasuredWidth() + max + layoutParams.rightMargin;
                            f7 = f3 - ((Iy.getMeasuredWidth() + max) + layoutParams.leftMargin);
                            if (z) {
                                bVar.h(Iy, i12, 0, i11, 0);
                            } else {
                                bVar.h(Iy, i11, 0, i12, 0);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i8 = i9 + 1;
                    }
                }
                paddingTop += bVar.mBK;
                paddingBottom -= bVar.mBK;
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int dCx;
        float f;
        float f2;
        int dCx2;
        float f3;
        float f4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        int i7 = 0;
        int size = this.mBY.size();
        while (true) {
            int i8 = i7;
            if (i8 < size) {
                b bVar = this.mBY.get(i8);
                if (Iz(i8)) {
                    paddingLeft += this.mCl;
                    i6 -= this.mCl;
                }
                float f5 = 0.0f;
                switch (this.mCc) {
                    case 0:
                        f = paddingTop;
                        f2 = i5 - paddingBottom;
                        break;
                    case 1:
                        f = (i5 - bVar.mBI) + paddingBottom;
                        f2 = bVar.mBI - paddingTop;
                        break;
                    case 2:
                        f = ((i5 - bVar.mBI) / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - ((i5 - bVar.mBI) / 2.0f);
                        break;
                    case 3:
                        f = paddingTop;
                        f5 = (i5 - bVar.mBI) / (bVar.dCx() != 1 ? dCx2 - 1 : 1.0f);
                        f2 = i5 - paddingBottom;
                        break;
                    case 4:
                        int dCx3 = bVar.dCx();
                        if (dCx3 != 0) {
                            f5 = (i5 - bVar.mBI) / dCx3;
                        }
                        f = (f5 / 2.0f) + paddingTop;
                        f2 = (i5 - paddingBottom) - (f5 / 2.0f);
                        break;
                    case 5:
                        if (bVar.dCx() != 0) {
                            f5 = (i5 - bVar.mBI) / (dCx + 1);
                        }
                        f = paddingTop + f5;
                        f2 = (i5 - paddingBottom) - f5;
                        break;
                    default:
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mCc);
                }
                float max = Math.max(f5, 0.0f);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    float f6 = f;
                    float f7 = f2;
                    if (i10 < bVar.mItemCount) {
                        int i11 = bVar.mBR + i10;
                        View Iy = Iy(i11);
                        if (Iy != null && Iy.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) Iy.getLayoutParams();
                            float f8 = f6 + layoutParams.topMargin;
                            float f9 = f7 - layoutParams.bottomMargin;
                            int i12 = 0;
                            int i13 = 0;
                            if (dv(i11, i10)) {
                                i12 = this.mCk;
                                f3 = f9 - i12;
                                f4 = i12 + f8;
                            } else {
                                f3 = f9;
                                f4 = f8;
                            }
                            if (i10 == bVar.mItemCount - 1 && (this.mCi & 4) > 0) {
                                i13 = this.mCk;
                            }
                            if (z) {
                                if (z2) {
                                    this.mCo.a(Iy, bVar, true, i6 - Iy.getMeasuredWidth(), Math.round(f3) - Iy.getMeasuredHeight(), i6, Math.round(f3));
                                } else {
                                    this.mCo.a(Iy, bVar, true, i6 - Iy.getMeasuredWidth(), Math.round(f4), i6, Math.round(f4) + Iy.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.mCo.a(Iy, bVar, false, paddingLeft, Math.round(f3) - Iy.getMeasuredHeight(), paddingLeft + Iy.getMeasuredWidth(), Math.round(f3));
                            } else {
                                this.mCo.a(Iy, bVar, false, paddingLeft, Math.round(f4), paddingLeft + Iy.getMeasuredWidth(), Math.round(f4) + Iy.getMeasuredHeight());
                            }
                            f6 = f4 + Iy.getMeasuredHeight() + max + layoutParams.bottomMargin;
                            f7 = f3 - ((Iy.getMeasuredHeight() + max) + layoutParams.topMargin);
                            if (z2) {
                                bVar.h(Iy, 0, i13, 0, i12);
                            } else {
                                bVar.h(Iy, 0, i12, 0, i13);
                            }
                        }
                        f2 = f7;
                        f = f6;
                        i9 = i10 + 1;
                    }
                }
                paddingLeft += bVar.mBK;
                i6 -= bVar.mBK;
                i7 = i8 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        if (this.mCh != null || this.mCg != null) {
            if (this.mCi != 0 || this.mCj != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                switch (this.mCa) {
                    case 0:
                        a(canvas, layoutDirection == 1, this.mCb == 2);
                        return;
                    case 1:
                        a(canvas, layoutDirection != 1, this.mCb == 2);
                        return;
                    case 2:
                        boolean z2 = layoutDirection == 1;
                        if (this.mCb != 2) {
                            r1 = z2;
                        } else if (z2) {
                            r1 = false;
                        }
                        b(canvas, r1, false);
                        return;
                    case 3:
                        boolean z3 = layoutDirection == 1;
                        if (this.mCb != 2) {
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
        int size = this.mBY.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mBY.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mBR + i4;
                View Iy = Iy(i5);
                if (Iy != null && Iy.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Iy.getLayoutParams();
                    if (dv(i5, i4)) {
                        if (z) {
                            left = Iy.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (Iy.getLeft() - layoutParams.leftMargin) - this.mCl;
                        }
                        a(canvas, left, bVar.mTop, bVar.mBK);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mCj & 4) > 0) {
                        if (z) {
                            right = (Iy.getLeft() - layoutParams.leftMargin) - this.mCl;
                        } else {
                            right = layoutParams.rightMargin + Iy.getRight();
                        }
                        a(canvas, right, bVar.mTop, bVar.mBK);
                    }
                }
            }
            if (Iz(i3)) {
                if (z2) {
                    i2 = bVar.mBottom;
                } else {
                    i2 = bVar.mTop - this.mCk;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (IB(i3) && (this.mCi & 4) > 0) {
                if (z2) {
                    i = bVar.mTop - this.mCk;
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
        int size = this.mBY.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mBY.get(i3);
            for (int i4 = 0; i4 < bVar.mItemCount; i4++) {
                int i5 = bVar.mBR + i4;
                View Iy = Iy(i5);
                if (Iy != null && Iy.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) Iy.getLayoutParams();
                    if (dv(i5, i4)) {
                        if (z2) {
                            top2 = Iy.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top2 = (Iy.getTop() - layoutParams.topMargin) - this.mCk;
                        }
                        b(canvas, bVar.mLeft, top2, bVar.mBK);
                    }
                    if (i4 == bVar.mItemCount - 1 && (this.mCi & 4) > 0) {
                        if (z2) {
                            bottom = (Iy.getTop() - layoutParams.topMargin) - this.mCk;
                        } else {
                            bottom = layoutParams.bottomMargin + Iy.getBottom();
                        }
                        b(canvas, bVar.mLeft, bottom, bVar.mBK);
                    }
                }
            }
            if (Iz(i3)) {
                if (z) {
                    i2 = bVar.mRight;
                } else {
                    i2 = bVar.mLeft - this.mCl;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (IB(i3) && (this.mCj & 4) > 0) {
                if (z) {
                    i = bVar.mLeft - this.mCl;
                } else {
                    i = bVar.mRight;
                }
                a(canvas, i, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.mCh != null) {
            this.mCh.setBounds(i, i2, this.mCl + i, i2 + i3);
            this.mCh.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.mCg != null) {
            this.mCg.setBounds(i, i2, i + i3, this.mCk + i2);
            this.mCg.draw(canvas);
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
        return this.mCa;
    }

    public void setFlexDirection(int i) {
        if (this.mCa != i) {
            this.mCa = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mCb;
    }

    public void setFlexWrap(int i) {
        if (this.mCb != i) {
            this.mCb = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.mCc;
    }

    public void setJustifyContent(int i) {
        if (this.mCc != i) {
            this.mCc = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mCd;
    }

    public void setAlignItems(int i) {
        if (this.mCd != i) {
            this.mCd = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.mCe;
    }

    public void setAlignContent(int i) {
        if (this.mCe != i) {
            this.mCe = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mCf;
    }

    public void setMaxLine(int i) {
        if (this.mCf != i) {
            this.mCf = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mBY.size());
        for (b bVar : this.mBY) {
            if (bVar.dCx() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        int i3;
        if (dCq()) {
            i3 = dv(i, i2) ? 0 + this.mCl : 0;
            if ((this.mCj & 4) > 0) {
                return i3 + this.mCl;
            }
            return i3;
        }
        i3 = dv(i, i2) ? 0 + this.mCk : 0;
        if ((this.mCi & 4) > 0) {
            return i3 + this.mCk;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int dk(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public void a(b bVar) {
        if (dCq()) {
            if ((this.mCj & 4) > 0) {
                bVar.mBI += this.mCl;
                bVar.mBJ += this.mCl;
            }
        } else if ((this.mCi & 4) > 0) {
            bVar.mBI += this.mCk;
            bVar.mBJ += this.mCk;
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
        if (dv(i, i2)) {
            if (dCq()) {
                bVar.mBI += this.mCl;
                bVar.mBJ += this.mCl;
                return;
            }
            bVar.mBI += this.mCk;
            bVar.mBJ += this.mCk;
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.mBY = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.mBY;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.mCg;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mCh;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.mCg) {
            this.mCg = drawable;
            if (drawable != null) {
                this.mCk = drawable.getIntrinsicHeight();
            } else {
                this.mCk = 0;
            }
            dCz();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.mCh) {
            this.mCh = drawable;
            if (drawable != null) {
                this.mCl = drawable.getIntrinsicWidth();
            } else {
                this.mCl = 0;
            }
            dCz();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.mCj;
    }

    public int getShowDividerHorizontal() {
        return this.mCi;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mCj) {
            this.mCj = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mCi) {
            this.mCi = i;
            requestLayout();
        }
    }

    private void dCz() {
        if (this.mCg == null && this.mCh == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean dv(int i, int i2) {
        return dw(i, i2) ? dCq() ? (this.mCj & 1) != 0 : (this.mCi & 1) != 0 : dCq() ? (this.mCj & 2) != 0 : (this.mCi & 2) != 0;
    }

    private boolean dw(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View Iy = Iy(i - i3);
            if (Iy != null && Iy.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean Iz(int i) {
        if (i < 0 || i >= this.mBY.size()) {
            return false;
        }
        return IA(i) ? dCq() ? (this.mCi & 1) != 0 : (this.mCj & 1) != 0 : dCq() ? (this.mCi & 2) != 0 : (this.mCj & 2) != 0;
    }

    private boolean IA(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mBY.get(i2).dCx() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean IB(int i) {
        if (i < 0 || i >= this.mBY.size()) {
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.mBY.size()) {
                if (this.mBY.get(i3).dCx() > 0) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (dCq()) {
                return (this.mCi & 4) != 0;
            } else {
                return (this.mCj & 4) != 0;
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
            /* renamed from: IC */
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
        public int dCr() {
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
        public boolean dCs() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dCt() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dCu() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dCv() {
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
