package com.google.android.flexbox;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final com.google.android.flexbox.a mET;
    private boolean[] mEU;
    @Nullable
    int[] mEV;
    @Nullable
    long[] mEW;
    @Nullable
    private long[] mEX;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.mET = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mET.getFlexItemCount();
        List<b> LS = LS(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.mET.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                LS.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        LS.add(bVar);
        return a(flexItemCount + 1, LS, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mET.getFlexItemCount();
        return a(flexItemCount, LS(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> LS(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.mET.LQ(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mET.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View LQ = this.mET.LQ(i);
            if (LQ != null && ((FlexItem) LQ.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] a(int i, List<b> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        Iterator<b> it = list.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                b next = it.next();
                iArr[i3] = next.index;
                sparseIntArray.append(next.index, next.order);
                i2 = i3 + 1;
            } else {
                return iArr;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar, int i, int i2) {
        a(aVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<com.google.android.flexbox.b>) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar, int i, int i2, int i3, int i4, @Nullable List<com.google.android.flexbox.b> list) {
        a(aVar, i, i2, i3, i4, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar, int i, int i2, int i3, int i4, List<com.google.android.flexbox.b> list) {
        a(aVar, i, i2, i3, 0, i4, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar, int i, int i2) {
        a(aVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<com.google.android.flexbox.b>) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a aVar, int i, int i2, int i3, int i4, @Nullable List<com.google.android.flexbox.b> list) {
        a(aVar, i2, i, i3, i4, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(a aVar, int i, int i2, int i3, int i4, List<com.google.android.flexbox.b> list) {
        a(aVar, i2, i, i3, 0, i4, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar, int i, int i2, int i3, int i4, int i5, @Nullable List<com.google.android.flexbox.b> list) {
        int i6;
        int i7;
        com.google.android.flexbox.b bVar;
        int i8;
        int i9;
        int i10;
        boolean z;
        int i11;
        int i12;
        boolean dxN = this.mET.dxN();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.mEY = list;
        boolean z2 = i5 == -1;
        int vI = vI(dxN);
        int vJ = vJ(dxN);
        int vK = vK(dxN);
        int vL = vL(dxN);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.mER = i4;
        bVar2.mEI = vI + vJ;
        int flexItemCount = this.mET.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View LR = this.mET.LR(i17);
            if (LR == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (LR.getVisibility() == 8) {
                bVar2.mEL++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) LR.getLayoutParams();
                if (flexItem.dxO() == 4) {
                    bVar2.mEQ.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, dxN);
                if (flexItem.dxR() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.dxR());
                }
                if (dxN) {
                    int am = this.mET.am(i, vI + vJ + c(flexItem, true) + d(flexItem, true), a2);
                    int an = this.mET.an(i2, vK + vL + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    LR.measure(am, an);
                    a(i17, am, an, LR);
                    i7 = am;
                } else {
                    int am2 = this.mET.am(i2, vK + vL + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int an2 = this.mET.an(i, vI + vJ + c(flexItem, false) + d(flexItem, false), a2);
                    LR.measure(am2, an2);
                    a(i17, am2, an2, LR);
                    i7 = an2;
                }
                this.mET.m(i17, LR);
                y(LR, i17);
                i6 = View.combineMeasuredStates(i13, LR.getMeasuredState());
                if (a(LR, mode, size, bVar2.mEI, d(flexItem, dxN) + l(LR, dxN) + c(flexItem, dxN), flexItem, i17, i16, list.size())) {
                    if (bVar2.dxV() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.mEK;
                    } else {
                        i12 = i15;
                    }
                    if (dxN) {
                        if (flexItem.getHeight() == -1) {
                            LR.measure(i7, this.mET.an(i2, this.mET.getPaddingTop() + this.mET.getPaddingBottom() + flexItem.dxS() + flexItem.dxT() + i12, flexItem.getHeight()));
                            y(LR, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        LR.measure(this.mET.am(i2, this.mET.getPaddingLeft() + this.mET.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        y(LR, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.mEI = vI + vJ;
                    bVar3.mER = i17;
                    i9 = Integer.MIN_VALUE;
                    i10 = i12;
                    i8 = 0;
                    bVar = bVar3;
                } else {
                    bVar2.mItemCount++;
                    bVar = bVar2;
                    i8 = i16 + 1;
                    i9 = i14;
                    i10 = i15;
                }
                if (this.mEV != null) {
                    this.mEV[i17] = list.size();
                }
                bVar.mEI += l(LR, dxN) + c(flexItem, dxN) + d(flexItem, dxN);
                bVar.mEM += flexItem.getFlexGrow();
                bVar.mEN += flexItem.getFlexShrink();
                this.mET.a(LR, i17, i8, bVar);
                i14 = Math.max(i9, m(LR, dxN) + e(flexItem, dxN) + f(flexItem, dxN) + this.mET.dg(LR));
                bVar.mEK = Math.max(bVar.mEK, i14);
                if (dxN) {
                    if (this.mET.getFlexWrap() != 2) {
                        bVar.mEO = Math.max(bVar.mEO, LR.getBaseline() + flexItem.dxS());
                    } else {
                        bVar.mEO = Math.max(bVar.mEO, (LR.getMeasuredHeight() - LR.getBaseline()) + flexItem.dxT());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.mEK;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).mES >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.dxU();
                        z = true;
                        if (i15 <= i3 && z) {
                            break;
                        }
                        bVar2 = bVar;
                        i16 = i8;
                        i11 = i6;
                    }
                }
                z = z3;
                if (i15 <= i3) {
                }
                bVar2 = bVar;
                i16 = i8;
                i11 = i6;
            }
            i17++;
            z3 = z;
            i13 = i11;
        }
        aVar.mEZ = i6;
    }

    private int vI(boolean z) {
        return z ? this.mET.getPaddingStart() : this.mET.getPaddingTop();
    }

    private int vJ(boolean z) {
        return z ? this.mET.getPaddingEnd() : this.mET.getPaddingBottom();
    }

    private int vK(boolean z) {
        return z ? this.mET.getPaddingTop() : this.mET.getPaddingStart();
    }

    private int vL(boolean z) {
        return z ? this.mET.getPaddingBottom() : this.mET.getPaddingEnd();
    }

    private int l(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int m(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int a(FlexItem flexItem, boolean z) {
        return z ? flexItem.getWidth() : flexItem.getHeight();
    }

    private int b(FlexItem flexItem, boolean z) {
        return z ? flexItem.getHeight() : flexItem.getWidth();
    }

    private int c(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginLeft() : flexItem.dxS();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.dxT();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.dxS() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.dxT() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.mET.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.dxQ()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.mET.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int g = this.mET.g(view, i5, i6);
                if (g > 0) {
                    i4 += g;
                }
                return i2 < i3 + i4;
            }
            return false;
        }
        return false;
    }

    private boolean a(int i, int i2, com.google.android.flexbox.b bVar) {
        return i == i2 + (-1) && bVar.dxV() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.mEP = i2;
        this.mET.a(bVar);
        bVar.mES = i;
        list.add(bVar);
    }

    private void y(View view, int i) {
        int i2;
        boolean z = true;
        boolean z2 = false;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth < flexItem.dxP()) {
            measuredWidth = flexItem.dxP();
            z2 = true;
        } else if (measuredWidth > flexItem.getMaxWidth()) {
            measuredWidth = flexItem.getMaxWidth();
            z2 = true;
        }
        if (measuredHeight < flexItem.getMinHeight()) {
            i2 = flexItem.getMinHeight();
        } else if (measuredHeight > flexItem.getMaxHeight()) {
            i2 = flexItem.getMaxHeight();
        } else {
            i2 = measuredHeight;
            z = z2;
        }
        if (z) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            a(i, makeMeasureSpec, makeMeasureSpec2, view);
            this.mET.m(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ea(int i, int i2) {
        ao(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ao(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        LT(this.mET.getFlexItemCount());
        if (i3 < this.mET.getFlexItemCount()) {
            int flexDirection = this.mET.getFlexDirection();
            switch (this.mET.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.mET.getLargestMainSize();
                    }
                    paddingTop = this.mET.getPaddingLeft() + this.mET.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.mET.getLargestMainSize();
                    }
                    paddingTop = this.mET.getPaddingTop() + this.mET.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.mEV != null ? this.mEV[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.mET.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.mEI < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void LT(int i) {
        if (this.mEU == null) {
            if (i < 10) {
                i = 10;
            }
            this.mEU = new boolean[i];
        } else if (this.mEU.length < i) {
            int length = this.mEU.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mEU = new boolean[i];
        } else {
            Arrays.fill(this.mEU, false);
        }
    }

    private void a(int i, int i2, com.google.android.flexbox.b bVar, int i3, int i4, boolean z) {
        int i5;
        float f;
        float f2;
        int i6;
        float f3;
        float f4;
        int i7;
        if (bVar.mEM > 0.0f && i3 >= bVar.mEI) {
            int i8 = bVar.mEI;
            float f5 = (i3 - bVar.mEI) / bVar.mEM;
            bVar.mEI = bVar.mEJ + i4;
            if (!z) {
                bVar.mEK = Integer.MIN_VALUE;
            }
            int i9 = 0;
            boolean z2 = false;
            int i10 = 0;
            float f6 = 0.0f;
            while (true) {
                int i11 = i9;
                if (i11 >= bVar.mItemCount) {
                    break;
                }
                int i12 = bVar.mER + i11;
                View LR = this.mET.LR(i12);
                if (LR != null && LR.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) LR.getLayoutParams();
                    int flexDirection = this.mET.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = LR.getMeasuredWidth();
                        if (this.mEX != null) {
                            measuredWidth = gL(this.mEX[i12]);
                        }
                        int measuredHeight = LR.getMeasuredHeight();
                        if (this.mEX != null) {
                            measuredHeight = gM(this.mEX[i12]);
                        }
                        if (!this.mEU[i12] && flexItem.getFlexGrow() > 0.0f) {
                            float flexGrow = measuredWidth + (flexItem.getFlexGrow() * f5);
                            if (i11 == bVar.mItemCount - 1) {
                                f2 = f6 + flexGrow;
                                f = 0.0f;
                            } else {
                                f = f6;
                                f2 = flexGrow;
                            }
                            int round = Math.round(f2);
                            if (round > flexItem.getMaxWidth()) {
                                z2 = true;
                                i6 = flexItem.getMaxWidth();
                                this.mEU[i12] = true;
                                bVar.mEM -= flexItem.getFlexGrow();
                            } else {
                                f += f2 - round;
                                if (f > 1.0d) {
                                    i6 = round + 1;
                                    f = (float) (f - 1.0d);
                                } else if (f < -1.0d) {
                                    i6 = round - 1;
                                    f = (float) (f + 1.0d);
                                } else {
                                    i6 = round;
                                }
                            }
                            int b2 = b(i2, flexItem, bVar.mEP);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            LR.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = LR.getMeasuredWidth();
                            measuredHeight = LR.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, LR);
                            this.mET.m(i12, LR);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dxS() + flexItem.dxT() + this.mET.dg(LR));
                        bVar.mEI = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mEI;
                        i5 = max;
                    } else {
                        int measuredHeight2 = LR.getMeasuredHeight();
                        if (this.mEX != null) {
                            measuredHeight2 = gM(this.mEX[i12]);
                        }
                        int measuredWidth3 = LR.getMeasuredWidth();
                        if (this.mEX != null) {
                            measuredWidth3 = gL(this.mEX[i12]);
                        }
                        if (!this.mEU[i12] && flexItem.getFlexGrow() > 0.0f) {
                            float flexGrow2 = measuredHeight2 + (flexItem.getFlexGrow() * f5);
                            if (i11 == bVar.mItemCount - 1) {
                                f4 = f6 + flexGrow2;
                                f3 = 0.0f;
                            } else {
                                f3 = f6;
                                f4 = flexGrow2;
                            }
                            int round2 = Math.round(f4);
                            if (round2 > flexItem.getMaxHeight()) {
                                z2 = true;
                                i7 = flexItem.getMaxHeight();
                                this.mEU[i12] = true;
                                bVar.mEM -= flexItem.getFlexGrow();
                            } else {
                                f3 += f4 - round2;
                                if (f3 > 1.0d) {
                                    i7 = round2 + 1;
                                    f3 = (float) (f3 - 1.0d);
                                } else if (f3 < -1.0d) {
                                    i7 = round2 - 1;
                                    f3 = (float) (f3 + 1.0d);
                                } else {
                                    i7 = round2;
                                }
                            }
                            int a2 = a(i, flexItem, bVar.mEP);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            LR.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = LR.getMeasuredWidth();
                            int measuredHeight3 = LR.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, LR);
                            this.mET.m(i12, LR);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mET.dg(LR));
                        bVar.mEI = flexItem.dxT() + measuredHeight2 + flexItem.dxS() + bVar.mEI;
                        i5 = max2;
                    }
                    bVar.mEK = Math.max(bVar.mEK, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mEI) {
                a(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private void b(int i, int i2, com.google.android.flexbox.b bVar, int i3, int i4, boolean z) {
        int i5;
        float f;
        float f2;
        int i6;
        float f3;
        float f4;
        int i7;
        int i8 = bVar.mEI;
        if (bVar.mEN > 0.0f && i3 <= bVar.mEI) {
            float f5 = (bVar.mEI - i3) / bVar.mEN;
            bVar.mEI = bVar.mEJ + i4;
            if (!z) {
                bVar.mEK = Integer.MIN_VALUE;
            }
            int i9 = 0;
            boolean z2 = false;
            float f6 = 0.0f;
            int i10 = 0;
            while (true) {
                int i11 = i9;
                if (i11 >= bVar.mItemCount) {
                    break;
                }
                int i12 = bVar.mER + i11;
                View LR = this.mET.LR(i12);
                if (LR != null && LR.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) LR.getLayoutParams();
                    int flexDirection = this.mET.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = LR.getMeasuredWidth();
                        if (this.mEX != null) {
                            measuredWidth = gL(this.mEX[i12]);
                        }
                        int measuredHeight = LR.getMeasuredHeight();
                        if (this.mEX != null) {
                            measuredHeight = gM(this.mEX[i12]);
                        }
                        if (!this.mEU[i12] && flexItem.getFlexShrink() > 0.0f) {
                            float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f5);
                            if (i11 == bVar.mItemCount - 1) {
                                f2 = f6 + flexShrink;
                                f = 0.0f;
                            } else {
                                f = f6;
                                f2 = flexShrink;
                            }
                            int round = Math.round(f2);
                            if (round < flexItem.dxP()) {
                                z2 = true;
                                i6 = flexItem.dxP();
                                this.mEU[i12] = true;
                                bVar.mEN -= flexItem.getFlexShrink();
                            } else {
                                f += f2 - round;
                                if (f > 1.0d) {
                                    i6 = round + 1;
                                    f -= 1.0f;
                                } else if (f < -1.0d) {
                                    i6 = round - 1;
                                    f += 1.0f;
                                } else {
                                    i6 = round;
                                }
                            }
                            int b2 = b(i2, flexItem, bVar.mEP);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            LR.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = LR.getMeasuredWidth();
                            measuredHeight = LR.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, LR);
                            this.mET.m(i12, LR);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dxS() + flexItem.dxT() + this.mET.dg(LR));
                        bVar.mEI = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mEI;
                        i5 = max;
                    } else {
                        int measuredHeight2 = LR.getMeasuredHeight();
                        if (this.mEX != null) {
                            measuredHeight2 = gM(this.mEX[i12]);
                        }
                        int measuredWidth3 = LR.getMeasuredWidth();
                        if (this.mEX != null) {
                            measuredWidth3 = gL(this.mEX[i12]);
                        }
                        if (!this.mEU[i12] && flexItem.getFlexShrink() > 0.0f) {
                            float flexShrink2 = measuredHeight2 - (flexItem.getFlexShrink() * f5);
                            if (i11 == bVar.mItemCount - 1) {
                                f4 = f6 + flexShrink2;
                                f3 = 0.0f;
                            } else {
                                f3 = f6;
                                f4 = flexShrink2;
                            }
                            int round2 = Math.round(f4);
                            if (round2 < flexItem.getMinHeight()) {
                                z2 = true;
                                i7 = flexItem.getMinHeight();
                                this.mEU[i12] = true;
                                bVar.mEN -= flexItem.getFlexShrink();
                            } else {
                                f3 += f4 - round2;
                                if (f3 > 1.0d) {
                                    i7 = round2 + 1;
                                    f3 -= 1.0f;
                                } else if (f3 < -1.0d) {
                                    i7 = round2 - 1;
                                    f3 += 1.0f;
                                } else {
                                    i7 = round2;
                                }
                            }
                            int a2 = a(i, flexItem, bVar.mEP);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            LR.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = LR.getMeasuredWidth();
                            int measuredHeight3 = LR.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, LR);
                            this.mET.m(i12, LR);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mET.dg(LR));
                        bVar.mEI = flexItem.dxT() + measuredHeight2 + flexItem.dxS() + bVar.mEI;
                        i5 = max2;
                    }
                    bVar.mEK = Math.max(bVar.mEK, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mEI) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int am = this.mET.am(i, this.mET.getPaddingLeft() + this.mET.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(am);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(am));
        }
        if (size < flexItem.dxP()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.dxP(), View.MeasureSpec.getMode(am));
        }
        return am;
    }

    private int b(int i, FlexItem flexItem, int i2) {
        int an = this.mET.an(i, this.mET.getPaddingTop() + this.mET.getPaddingBottom() + flexItem.dxS() + flexItem.dxT() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(an);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(an));
        }
        if (size < flexItem.getMinHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(an));
        }
        return an;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ap(int i, int i2, int i3) {
        int mode;
        int size;
        float f;
        float f2;
        int i4;
        int flexDirection = this.mET.getFlexDirection();
        switch (flexDirection) {
            case 0:
            case 1:
                mode = View.MeasureSpec.getMode(i2);
                size = View.MeasureSpec.getSize(i2);
                break;
            case 2:
            case 3:
                mode = View.MeasureSpec.getMode(i);
                size = View.MeasureSpec.getSize(i);
                break;
            default:
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        }
        List<com.google.android.flexbox.b> flexLinesInternal = this.mET.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mET.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mEK = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.mET.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.mEK = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.mET.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    case 3:
                        if (sumOfCrossSize < size) {
                            float size2 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                            float f3 = 0.0f;
                            ArrayList arrayList = new ArrayList();
                            int size3 = flexLinesInternal.size();
                            int i6 = 0;
                            while (i6 < size3) {
                                arrayList.add(flexLinesInternal.get(i6));
                                if (i6 != flexLinesInternal.size() - 1) {
                                    com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
                                    if (i6 == flexLinesInternal.size() - 2) {
                                        bVar2.mEK = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.mEK = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.mEK);
                                    if (f > 1.0f) {
                                        bVar2.mEK++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.mEK--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.mET.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.mET.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.mEK = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.mET.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.mEK + size5;
                                if (i7 == flexLinesInternal.size() - 1) {
                                    f5 += f4;
                                    f4 = 0.0f;
                                }
                                int round = Math.round(f5);
                                f4 += f5 - round;
                                if (f4 > 1.0f) {
                                    i4 = round + 1;
                                    f4 -= 1.0f;
                                } else if (f4 < -1.0f) {
                                    i4 = round - 1;
                                    f4 += 1.0f;
                                } else {
                                    i4 = round;
                                }
                                bVar5.mEK = i4;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private List<com.google.android.flexbox.b> g(List<com.google.android.flexbox.b> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
        bVar.mEK = (i - i2) / 2;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add(list.get(i3));
            if (i3 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dxW() {
        LU(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void LU(int i) {
        View LR;
        if (i < this.mET.getFlexItemCount()) {
            int flexDirection = this.mET.getFlexDirection();
            if (this.mET.getAlignItems() == 4) {
                int i2 = this.mEV != null ? this.mEV[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.mET.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.mER + i5;
                        if (i5 < this.mET.getFlexItemCount() && (LR = this.mET.LR(i6)) != null && LR.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) LR.getLayoutParams();
                            if (flexItem.dxO() == -1 || flexItem.dxO() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        h(LR, bVar.mEK, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        i(LR, bVar.mEK, i6);
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                            }
                        }
                    }
                }
                return;
            }
            for (com.google.android.flexbox.b bVar2 : this.mET.getFlexLinesInternal()) {
                for (Integer num : bVar2.mEQ) {
                    View LR2 = this.mET.LR(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            h(LR2, bVar2.mEK, num.intValue());
                            break;
                        case 2:
                        case 3:
                            i(LR2, bVar2.mEK, num.intValue());
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                }
            }
        }
    }

    private void h(View view, int i, int i2) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.dxS()) - flexItem.dxT()) - this.mET.dg(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.mEX != null) {
            measuredWidth = gL(this.mEX[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.mET.m(i2, view);
    }

    private void i(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mET.dg(view), flexItem.dxP()), flexItem.getMaxWidth());
        if (this.mEX != null) {
            measuredHeight = gM(this.mEX[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.mET.m(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mET.getAlignItems();
        if (flexItem.dxO() != -1) {
            alignItems = flexItem.dxO();
        }
        int i5 = bVar.mEK;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.mET.getFlexWrap() != 2) {
                    view.layout(i, flexItem.dxS() + i2, i3, flexItem.dxS() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.dxT(), i3, i4 - flexItem.dxT());
                    return;
                }
            case 1:
                if (this.mET.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.dxT(), i3, (i5 + i2) - flexItem.dxT());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.dxS(), i3, flexItem.dxS() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.dxS()) - flexItem.dxT()) / 2;
                if (this.mET.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.mET.getFlexWrap() != 2) {
                    int max = Math.max(bVar.mEO - view.getBaseline(), flexItem.dxS());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.mEO - view.getMeasuredHeight()) + view.getBaseline(), flexItem.dxT());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mET.getAlignItems();
        if (flexItem.dxO() != -1) {
            alignItems = flexItem.dxO();
        }
        int i5 = bVar.mEK;
        switch (alignItems) {
            case 0:
            case 3:
            case 4:
                if (!z) {
                    view.layout(flexItem.getMarginLeft() + i, i2, flexItem.getMarginLeft() + i3, i4);
                    return;
                } else {
                    view.layout(i - flexItem.getMarginRight(), i2, i3 - flexItem.getMarginRight(), i4);
                    return;
                }
            case 1:
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i2, ((i5 + i3) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i4);
                    return;
                }
                view.layout((i - i5) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i2, flexItem.getMarginLeft() + (i3 - i5) + view.getMeasuredWidth(), i4);
                return;
            case 2:
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, measuredWidth + i3, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void LV(int i) {
        if (this.mEX == null) {
            if (i < 10) {
                i = 10;
            }
            this.mEX = new long[i];
        } else if (this.mEX.length < i) {
            int length = this.mEX.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mEX = Arrays.copyOf(this.mEX, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void LW(int i) {
        if (this.mEW == null) {
            if (i < 10) {
                i = 10;
            }
            this.mEW = new long[i];
        } else if (this.mEW.length < i) {
            int length = this.mEW.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mEW = Arrays.copyOf(this.mEW, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gL(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gM(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long eb(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.mEW != null) {
            this.mEW[i] = eb(i2, i3);
        }
        if (this.mEX != null) {
            this.mEX[i] = eb(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void LX(int i) {
        if (this.mEV == null) {
            if (i < 10) {
                i = 10;
            }
            this.mEV = new int[i];
        } else if (this.mEV.length < i) {
            int length = this.mEV.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mEV = Arrays.copyOf(this.mEV, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.mEV == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.mEW == null) {
            throw new AssertionError();
        }
        int i2 = this.mEV[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.mEV.length - 1;
        if (i > length) {
            Arrays.fill(this.mEV, -1);
        } else {
            Arrays.fill(this.mEV, i, length, -1);
        }
        int length2 = this.mEW.length - 1;
        if (i > length2) {
            Arrays.fill(this.mEW, 0L);
        } else {
            Arrays.fill(this.mEW, i, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Comparable<b> {
        int index;
        int order;

        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull b bVar) {
            return this.order != bVar.order ? this.order - bVar.order : this.index - bVar.index;
        }

        public String toString() {
            return "Order{order=" + this.order + ", index=" + this.index + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        List<com.google.android.flexbox.b> mEY;
        int mEZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.mEY = null;
            this.mEZ = 0;
        }
    }
}
