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
    private final com.google.android.flexbox.a mIQ;
    private boolean[] mIR;
    @Nullable
    int[] mIS;
    @Nullable
    long[] mIT;
    @Nullable
    private long[] mIU;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.mIQ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mIQ.getFlexItemCount();
        List<b> Mb = Mb(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.mIQ.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                Mb.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        Mb.add(bVar);
        return a(flexItemCount + 1, Mb, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mIQ.getFlexItemCount();
        return a(flexItemCount, Mb(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> Mb(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.mIQ.LZ(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mIQ.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View LZ = this.mIQ.LZ(i);
            if (LZ != null && ((FlexItem) LZ.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean dyZ = this.mIQ.dyZ();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.mIV = list;
        boolean z2 = i5 == -1;
        int vU = vU(dyZ);
        int vV = vV(dyZ);
        int vW = vW(dyZ);
        int vX = vX(dyZ);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.mIO = i4;
        bVar2.mIF = vU + vV;
        int flexItemCount = this.mIQ.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View Ma = this.mIQ.Ma(i17);
            if (Ma == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (Ma.getVisibility() == 8) {
                bVar2.mII++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) Ma.getLayoutParams();
                if (flexItem.dza() == 4) {
                    bVar2.mIN.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, dyZ);
                if (flexItem.dzc() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.dzc());
                }
                if (dyZ) {
                    int am = this.mIQ.am(i, vU + vV + c(flexItem, true) + d(flexItem, true), a2);
                    int an = this.mIQ.an(i2, vW + vX + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    Ma.measure(am, an);
                    a(i17, am, an, Ma);
                    i7 = am;
                } else {
                    int am2 = this.mIQ.am(i2, vW + vX + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int an2 = this.mIQ.an(i, vU + vV + c(flexItem, false) + d(flexItem, false), a2);
                    Ma.measure(am2, an2);
                    a(i17, am2, an2, Ma);
                    i7 = an2;
                }
                this.mIQ.m(i17, Ma);
                y(Ma, i17);
                i6 = View.combineMeasuredStates(i13, Ma.getMeasuredState());
                if (a(Ma, mode, size, bVar2.mIF, d(flexItem, dyZ) + l(Ma, dyZ) + c(flexItem, dyZ), flexItem, i17, i16, list.size())) {
                    if (bVar2.dzg() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.mIH;
                    } else {
                        i12 = i15;
                    }
                    if (dyZ) {
                        if (flexItem.getHeight() == -1) {
                            Ma.measure(i7, this.mIQ.an(i2, this.mIQ.getPaddingTop() + this.mIQ.getPaddingBottom() + flexItem.dzd() + flexItem.dze() + i12, flexItem.getHeight()));
                            y(Ma, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        Ma.measure(this.mIQ.am(i2, this.mIQ.getPaddingLeft() + this.mIQ.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        y(Ma, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.mIF = vU + vV;
                    bVar3.mIO = i17;
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
                if (this.mIS != null) {
                    this.mIS[i17] = list.size();
                }
                bVar.mIF += l(Ma, dyZ) + c(flexItem, dyZ) + d(flexItem, dyZ);
                bVar.mIJ += flexItem.getFlexGrow();
                bVar.mIK += flexItem.getFlexShrink();
                this.mIQ.a(Ma, i17, i8, bVar);
                i14 = Math.max(i9, m(Ma, dyZ) + e(flexItem, dyZ) + f(flexItem, dyZ) + this.mIQ.dq(Ma));
                bVar.mIH = Math.max(bVar.mIH, i14);
                if (dyZ) {
                    if (this.mIQ.getFlexWrap() != 2) {
                        bVar.mIL = Math.max(bVar.mIL, Ma.getBaseline() + flexItem.dzd());
                    } else {
                        bVar.mIL = Math.max(bVar.mIL, (Ma.getMeasuredHeight() - Ma.getBaseline()) + flexItem.dze());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.mIH;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).mIP >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.dzf();
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
        aVar.mIW = i6;
    }

    private int vU(boolean z) {
        return z ? this.mIQ.getPaddingStart() : this.mIQ.getPaddingTop();
    }

    private int vV(boolean z) {
        return z ? this.mIQ.getPaddingEnd() : this.mIQ.getPaddingBottom();
    }

    private int vW(boolean z) {
        return z ? this.mIQ.getPaddingTop() : this.mIQ.getPaddingStart();
    }

    private int vX(boolean z) {
        return z ? this.mIQ.getPaddingBottom() : this.mIQ.getPaddingEnd();
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
        return z ? flexItem.getMarginLeft() : flexItem.dzd();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.dze();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.dzd() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.dze() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.mIQ.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.dzb()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.mIQ.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int g = this.mIQ.g(view, i5, i6);
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
        return i == i2 + (-1) && bVar.dzg() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.mIM = i2;
        this.mIQ.a(bVar);
        bVar.mIP = i;
        list.add(bVar);
    }

    private void y(View view, int i) {
        int i2;
        boolean z = true;
        boolean z2 = false;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth < flexItem.getMinWidth()) {
            measuredWidth = flexItem.getMinWidth();
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
            this.mIQ.m(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dY(int i, int i2) {
        ao(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ao(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        Mc(this.mIQ.getFlexItemCount());
        if (i3 < this.mIQ.getFlexItemCount()) {
            int flexDirection = this.mIQ.getFlexDirection();
            switch (this.mIQ.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.mIQ.getLargestMainSize();
                    }
                    paddingTop = this.mIQ.getPaddingLeft() + this.mIQ.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.mIQ.getLargestMainSize();
                    }
                    paddingTop = this.mIQ.getPaddingTop() + this.mIQ.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.mIS != null ? this.mIS[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.mIQ.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.mIF < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void Mc(int i) {
        if (this.mIR == null) {
            if (i < 10) {
                i = 10;
            }
            this.mIR = new boolean[i];
        } else if (this.mIR.length < i) {
            int length = this.mIR.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mIR = new boolean[i];
        } else {
            Arrays.fill(this.mIR, false);
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
        if (bVar.mIJ > 0.0f && i3 >= bVar.mIF) {
            int i8 = bVar.mIF;
            float f5 = (i3 - bVar.mIF) / bVar.mIJ;
            bVar.mIF = bVar.mIG + i4;
            if (!z) {
                bVar.mIH = Integer.MIN_VALUE;
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
                int i12 = bVar.mIO + i11;
                View Ma = this.mIQ.Ma(i12);
                if (Ma != null && Ma.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Ma.getLayoutParams();
                    int flexDirection = this.mIQ.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Ma.getMeasuredWidth();
                        if (this.mIU != null) {
                            measuredWidth = gQ(this.mIU[i12]);
                        }
                        int measuredHeight = Ma.getMeasuredHeight();
                        if (this.mIU != null) {
                            measuredHeight = gR(this.mIU[i12]);
                        }
                        if (!this.mIR[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mIR[i12] = true;
                                bVar.mIJ -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.mIM);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Ma.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Ma.getMeasuredWidth();
                            measuredHeight = Ma.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Ma);
                            this.mIQ.m(i12, Ma);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dzd() + flexItem.dze() + this.mIQ.dq(Ma));
                        bVar.mIF = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mIF;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Ma.getMeasuredHeight();
                        if (this.mIU != null) {
                            measuredHeight2 = gR(this.mIU[i12]);
                        }
                        int measuredWidth3 = Ma.getMeasuredWidth();
                        if (this.mIU != null) {
                            measuredWidth3 = gQ(this.mIU[i12]);
                        }
                        if (!this.mIR[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mIR[i12] = true;
                                bVar.mIJ -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.mIM);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Ma.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Ma.getMeasuredWidth();
                            int measuredHeight3 = Ma.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Ma);
                            this.mIQ.m(i12, Ma);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mIQ.dq(Ma));
                        bVar.mIF = flexItem.dze() + measuredHeight2 + flexItem.dzd() + bVar.mIF;
                        i5 = max2;
                    }
                    bVar.mIH = Math.max(bVar.mIH, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mIF) {
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
        int i8 = bVar.mIF;
        if (bVar.mIK > 0.0f && i3 <= bVar.mIF) {
            float f5 = (bVar.mIF - i3) / bVar.mIK;
            bVar.mIF = bVar.mIG + i4;
            if (!z) {
                bVar.mIH = Integer.MIN_VALUE;
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
                int i12 = bVar.mIO + i11;
                View Ma = this.mIQ.Ma(i12);
                if (Ma != null && Ma.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Ma.getLayoutParams();
                    int flexDirection = this.mIQ.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Ma.getMeasuredWidth();
                        if (this.mIU != null) {
                            measuredWidth = gQ(this.mIU[i12]);
                        }
                        int measuredHeight = Ma.getMeasuredHeight();
                        if (this.mIU != null) {
                            measuredHeight = gR(this.mIU[i12]);
                        }
                        if (!this.mIR[i12] && flexItem.getFlexShrink() > 0.0f) {
                            float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f5);
                            if (i11 == bVar.mItemCount - 1) {
                                f2 = f6 + flexShrink;
                                f = 0.0f;
                            } else {
                                f = f6;
                                f2 = flexShrink;
                            }
                            int round = Math.round(f2);
                            if (round < flexItem.getMinWidth()) {
                                z2 = true;
                                i6 = flexItem.getMinWidth();
                                this.mIR[i12] = true;
                                bVar.mIK -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.mIM);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Ma.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Ma.getMeasuredWidth();
                            measuredHeight = Ma.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Ma);
                            this.mIQ.m(i12, Ma);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dzd() + flexItem.dze() + this.mIQ.dq(Ma));
                        bVar.mIF = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mIF;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Ma.getMeasuredHeight();
                        if (this.mIU != null) {
                            measuredHeight2 = gR(this.mIU[i12]);
                        }
                        int measuredWidth3 = Ma.getMeasuredWidth();
                        if (this.mIU != null) {
                            measuredWidth3 = gQ(this.mIU[i12]);
                        }
                        if (!this.mIR[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mIR[i12] = true;
                                bVar.mIK -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.mIM);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Ma.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Ma.getMeasuredWidth();
                            int measuredHeight3 = Ma.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Ma);
                            this.mIQ.m(i12, Ma);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mIQ.dq(Ma));
                        bVar.mIF = flexItem.dze() + measuredHeight2 + flexItem.dzd() + bVar.mIF;
                        i5 = max2;
                    }
                    bVar.mIH = Math.max(bVar.mIH, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mIF) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int am = this.mIQ.am(i, this.mIQ.getPaddingLeft() + this.mIQ.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(am);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(am));
        }
        if (size < flexItem.getMinWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(am));
        }
        return am;
    }

    private int b(int i, FlexItem flexItem, int i2) {
        int an = this.mIQ.an(i, this.mIQ.getPaddingTop() + this.mIQ.getPaddingBottom() + flexItem.dzd() + flexItem.dze() + i2, flexItem.getHeight());
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
        int flexDirection = this.mIQ.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.mIQ.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mIQ.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mIH = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.mIQ.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.mIH = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.mIQ.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.mIH = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.mIH = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.mIH);
                                    if (f > 1.0f) {
                                        bVar2.mIH++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.mIH--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.mIQ.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.mIQ.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.mIH = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.mIQ.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.mIH + size5;
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
                                bVar5.mIH = i4;
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
        bVar.mIH = (i - i2) / 2;
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
    public void dzh() {
        Md(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Md(int i) {
        View Ma;
        if (i < this.mIQ.getFlexItemCount()) {
            int flexDirection = this.mIQ.getFlexDirection();
            if (this.mIQ.getAlignItems() == 4) {
                int i2 = this.mIS != null ? this.mIS[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.mIQ.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.mIO + i5;
                        if (i5 < this.mIQ.getFlexItemCount() && (Ma = this.mIQ.Ma(i6)) != null && Ma.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) Ma.getLayoutParams();
                            if (flexItem.dza() == -1 || flexItem.dza() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        h(Ma, bVar.mIH, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        i(Ma, bVar.mIH, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.mIQ.getFlexLinesInternal()) {
                for (Integer num : bVar2.mIN) {
                    View Ma2 = this.mIQ.Ma(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            h(Ma2, bVar2.mIH, num.intValue());
                            break;
                        case 2:
                        case 3:
                            i(Ma2, bVar2.mIH, num.intValue());
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
        int min = Math.min(Math.max(((i - flexItem.dzd()) - flexItem.dze()) - this.mIQ.dq(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.mIU != null) {
            measuredWidth = gQ(this.mIU[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.mIQ.m(i2, view);
    }

    private void i(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mIQ.dq(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.mIU != null) {
            measuredHeight = gR(this.mIU[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.mIQ.m(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mIQ.getAlignItems();
        if (flexItem.dza() != -1) {
            alignItems = flexItem.dza();
        }
        int i5 = bVar.mIH;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.mIQ.getFlexWrap() != 2) {
                    view.layout(i, flexItem.dzd() + i2, i3, flexItem.dzd() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.dze(), i3, i4 - flexItem.dze());
                    return;
                }
            case 1:
                if (this.mIQ.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.dze(), i3, (i5 + i2) - flexItem.dze());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.dzd(), i3, flexItem.dzd() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.dzd()) - flexItem.dze()) / 2;
                if (this.mIQ.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.mIQ.getFlexWrap() != 2) {
                    int max = Math.max(bVar.mIL - view.getBaseline(), flexItem.dzd());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.mIL - view.getMeasuredHeight()) + view.getBaseline(), flexItem.dze());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mIQ.getAlignItems();
        if (flexItem.dza() != -1) {
            alignItems = flexItem.dza();
        }
        int i5 = bVar.mIH;
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
    public void Me(int i) {
        if (this.mIU == null) {
            if (i < 10) {
                i = 10;
            }
            this.mIU = new long[i];
        } else if (this.mIU.length < i) {
            int length = this.mIU.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mIU = Arrays.copyOf(this.mIU, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mf(int i) {
        if (this.mIT == null) {
            if (i < 10) {
                i = 10;
            }
            this.mIT = new long[i];
        } else if (this.mIT.length < i) {
            int length = this.mIT.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mIT = Arrays.copyOf(this.mIT, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gQ(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gR(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long dZ(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.mIT != null) {
            this.mIT[i] = dZ(i2, i3);
        }
        if (this.mIU != null) {
            this.mIU[i] = dZ(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mg(int i) {
        if (this.mIS == null) {
            if (i < 10) {
                i = 10;
            }
            this.mIS = new int[i];
        } else if (this.mIS.length < i) {
            int length = this.mIS.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mIS = Arrays.copyOf(this.mIS, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.mIS == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.mIT == null) {
            throw new AssertionError();
        }
        int i2 = this.mIS[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.mIS.length - 1;
        if (i > length) {
            Arrays.fill(this.mIS, -1);
        } else {
            Arrays.fill(this.mIS, i, length, -1);
        }
        int length2 = this.mIT.length - 1;
        if (i > length2) {
            Arrays.fill(this.mIT, 0L);
        } else {
            Arrays.fill(this.mIT, i, length2, 0L);
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
        List<com.google.android.flexbox.b> mIV;
        int mIW;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.mIV = null;
            this.mIW = 0;
        }
    }
}
