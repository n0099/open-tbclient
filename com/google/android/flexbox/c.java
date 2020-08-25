package com.google.android.flexbox;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v7.widget.ActivityChooserView;
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
    private final com.google.android.flexbox.a nBj;
    private boolean[] nBk;
    @Nullable
    int[] nBl;
    @Nullable
    long[] nBm;
    @Nullable
    private long[] nBn;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.nBj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.nBj.getFlexItemCount();
        List<b> MA = MA(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.nBj.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                MA.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        MA.add(bVar);
        return a(flexItemCount + 1, MA, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.nBj.getFlexItemCount();
        return a(flexItemCount, MA(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> MA(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.nBj.My(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.nBj.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View My = this.nBj.My(i);
            if (My != null && ((FlexItem) My.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        a(aVar, i, i2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, -1, (List<com.google.android.flexbox.b>) null);
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
        a(aVar, i2, i, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, -1, (List<com.google.android.flexbox.b>) null);
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
        boolean dWy = this.nBj.dWy();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.nBo = list;
        boolean z2 = i5 == -1;
        int yj = yj(dWy);
        int yk = yk(dWy);
        int yl = yl(dWy);
        int ym = ym(dWy);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.nBh = i4;
        bVar2.nAY = yj + yk;
        int flexItemCount = this.nBj.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View Mz = this.nBj.Mz(i17);
            if (Mz == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (Mz.getVisibility() == 8) {
                bVar2.nBb++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) Mz.getLayoutParams();
                if (flexItem.dWz() == 4) {
                    bVar2.nBg.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, dWy);
                if (flexItem.dWB() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.dWB());
                }
                if (dWy) {
                    int ad = this.nBj.ad(i, yj + yk + c(flexItem, true) + d(flexItem, true), a2);
                    int ae = this.nBj.ae(i2, yl + ym + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    Mz.measure(ad, ae);
                    a(i17, ad, ae, Mz);
                    i7 = ad;
                } else {
                    int ad2 = this.nBj.ad(i2, yl + ym + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ae2 = this.nBj.ae(i, yj + yk + c(flexItem, false) + d(flexItem, false), a2);
                    Mz.measure(ad2, ae2);
                    a(i17, ad2, ae2, Mz);
                    i7 = ae2;
                }
                this.nBj.l(i17, Mz);
                z(Mz, i17);
                i6 = View.combineMeasuredStates(i13, Mz.getMeasuredState());
                if (a(Mz, mode, size, bVar2.nAY, d(flexItem, dWy) + m(Mz, dWy) + c(flexItem, dWy), flexItem, i17, i16, list.size())) {
                    if (bVar2.dWF() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.nBa;
                    } else {
                        i12 = i15;
                    }
                    if (dWy) {
                        if (flexItem.getHeight() == -1) {
                            Mz.measure(i7, this.nBj.ae(i2, this.nBj.getPaddingTop() + this.nBj.getPaddingBottom() + flexItem.dWC() + flexItem.dWD() + i12, flexItem.getHeight()));
                            z(Mz, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        Mz.measure(this.nBj.ad(i2, this.nBj.getPaddingLeft() + this.nBj.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        z(Mz, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.nAY = yj + yk;
                    bVar3.nBh = i17;
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
                if (this.nBl != null) {
                    this.nBl[i17] = list.size();
                }
                bVar.nAY += m(Mz, dWy) + c(flexItem, dWy) + d(flexItem, dWy);
                bVar.nBc += flexItem.getFlexGrow();
                bVar.nBd += flexItem.getFlexShrink();
                this.nBj.a(Mz, i17, i8, bVar);
                i14 = Math.max(i9, n(Mz, dWy) + e(flexItem, dWy) + f(flexItem, dWy) + this.nBj.dv(Mz));
                bVar.nBa = Math.max(bVar.nBa, i14);
                if (dWy) {
                    if (this.nBj.getFlexWrap() != 2) {
                        bVar.nBe = Math.max(bVar.nBe, Mz.getBaseline() + flexItem.dWC());
                    } else {
                        bVar.nBe = Math.max(bVar.nBe, (Mz.getMeasuredHeight() - Mz.getBaseline()) + flexItem.dWD());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.nBa;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).nBi >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.dWE();
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
        aVar.nBp = i6;
    }

    private int yj(boolean z) {
        return z ? this.nBj.getPaddingStart() : this.nBj.getPaddingTop();
    }

    private int yk(boolean z) {
        return z ? this.nBj.getPaddingEnd() : this.nBj.getPaddingBottom();
    }

    private int yl(boolean z) {
        return z ? this.nBj.getPaddingTop() : this.nBj.getPaddingStart();
    }

    private int ym(boolean z) {
        return z ? this.nBj.getPaddingBottom() : this.nBj.getPaddingEnd();
    }

    private int m(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int n(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int a(FlexItem flexItem, boolean z) {
        return z ? flexItem.getWidth() : flexItem.getHeight();
    }

    private int b(FlexItem flexItem, boolean z) {
        return z ? flexItem.getHeight() : flexItem.getWidth();
    }

    private int c(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginLeft() : flexItem.dWC();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.dWD();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.dWC() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.dWD() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.nBj.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.dWA()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.nBj.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int j = this.nBj.j(view, i5, i6);
                if (j > 0) {
                    i4 += j;
                }
                return i2 < i3 + i4;
            }
            return false;
        }
        return false;
    }

    private boolean a(int i, int i2, com.google.android.flexbox.b bVar) {
        return i == i2 + (-1) && bVar.dWF() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.nBf = i2;
        this.nBj.a(bVar);
        bVar.nBi = i;
        list.add(bVar);
    }

    private void z(View view, int i) {
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
            this.nBj.l(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dM(int i, int i2) {
        af(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        MB(this.nBj.getFlexItemCount());
        if (i3 < this.nBj.getFlexItemCount()) {
            int flexDirection = this.nBj.getFlexDirection();
            switch (this.nBj.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.nBj.getLargestMainSize();
                    }
                    paddingTop = this.nBj.getPaddingLeft() + this.nBj.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.nBj.getLargestMainSize();
                    }
                    paddingTop = this.nBj.getPaddingTop() + this.nBj.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.nBl != null ? this.nBl[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.nBj.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.nAY < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void MB(int i) {
        if (this.nBk == null) {
            if (i < 10) {
                i = 10;
            }
            this.nBk = new boolean[i];
        } else if (this.nBk.length < i) {
            int length = this.nBk.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nBk = new boolean[i];
        } else {
            Arrays.fill(this.nBk, false);
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
        if (bVar.nBc > 0.0f && i3 >= bVar.nAY) {
            int i8 = bVar.nAY;
            float f5 = (i3 - bVar.nAY) / bVar.nBc;
            bVar.nAY = bVar.nAZ + i4;
            if (!z) {
                bVar.nBa = Integer.MIN_VALUE;
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
                int i12 = bVar.nBh + i11;
                View Mz = this.nBj.Mz(i12);
                if (Mz != null && Mz.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Mz.getLayoutParams();
                    int flexDirection = this.nBj.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Mz.getMeasuredWidth();
                        if (this.nBn != null) {
                            measuredWidth = gx(this.nBn[i12]);
                        }
                        int measuredHeight = Mz.getMeasuredHeight();
                        if (this.nBn != null) {
                            measuredHeight = gy(this.nBn[i12]);
                        }
                        if (!this.nBk[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.nBk[i12] = true;
                                bVar.nBc -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.nBf);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Mz.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Mz.getMeasuredWidth();
                            measuredHeight = Mz.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Mz);
                            this.nBj.l(i12, Mz);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dWC() + flexItem.dWD() + this.nBj.dv(Mz));
                        bVar.nAY = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.nAY;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Mz.getMeasuredHeight();
                        if (this.nBn != null) {
                            measuredHeight2 = gy(this.nBn[i12]);
                        }
                        int measuredWidth3 = Mz.getMeasuredWidth();
                        if (this.nBn != null) {
                            measuredWidth3 = gx(this.nBn[i12]);
                        }
                        if (!this.nBk[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.nBk[i12] = true;
                                bVar.nBc -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.nBf);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Mz.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Mz.getMeasuredWidth();
                            int measuredHeight3 = Mz.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Mz);
                            this.nBj.l(i12, Mz);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.nBj.dv(Mz));
                        bVar.nAY = flexItem.dWD() + measuredHeight2 + flexItem.dWC() + bVar.nAY;
                        i5 = max2;
                    }
                    bVar.nBa = Math.max(bVar.nBa, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.nAY) {
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
        int i8 = bVar.nAY;
        if (bVar.nBd > 0.0f && i3 <= bVar.nAY) {
            float f5 = (bVar.nAY - i3) / bVar.nBd;
            bVar.nAY = bVar.nAZ + i4;
            if (!z) {
                bVar.nBa = Integer.MIN_VALUE;
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
                int i12 = bVar.nBh + i11;
                View Mz = this.nBj.Mz(i12);
                if (Mz != null && Mz.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Mz.getLayoutParams();
                    int flexDirection = this.nBj.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Mz.getMeasuredWidth();
                        if (this.nBn != null) {
                            measuredWidth = gx(this.nBn[i12]);
                        }
                        int measuredHeight = Mz.getMeasuredHeight();
                        if (this.nBn != null) {
                            measuredHeight = gy(this.nBn[i12]);
                        }
                        if (!this.nBk[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.nBk[i12] = true;
                                bVar.nBd -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.nBf);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Mz.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Mz.getMeasuredWidth();
                            measuredHeight = Mz.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Mz);
                            this.nBj.l(i12, Mz);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dWC() + flexItem.dWD() + this.nBj.dv(Mz));
                        bVar.nAY = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.nAY;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Mz.getMeasuredHeight();
                        if (this.nBn != null) {
                            measuredHeight2 = gy(this.nBn[i12]);
                        }
                        int measuredWidth3 = Mz.getMeasuredWidth();
                        if (this.nBn != null) {
                            measuredWidth3 = gx(this.nBn[i12]);
                        }
                        if (!this.nBk[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.nBk[i12] = true;
                                bVar.nBd -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.nBf);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Mz.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Mz.getMeasuredWidth();
                            int measuredHeight3 = Mz.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Mz);
                            this.nBj.l(i12, Mz);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.nBj.dv(Mz));
                        bVar.nAY = flexItem.dWD() + measuredHeight2 + flexItem.dWC() + bVar.nAY;
                        i5 = max2;
                    }
                    bVar.nBa = Math.max(bVar.nBa, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.nAY) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int ad = this.nBj.ad(i, this.nBj.getPaddingLeft() + this.nBj.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(ad);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(ad));
        }
        if (size < flexItem.getMinWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(ad));
        }
        return ad;
    }

    private int b(int i, FlexItem flexItem, int i2) {
        int ae = this.nBj.ae(i, this.nBj.getPaddingTop() + this.nBj.getPaddingBottom() + flexItem.dWC() + flexItem.dWD() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(ae);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(ae));
        }
        if (size < flexItem.getMinHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(ae));
        }
        return ae;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ag(int i, int i2, int i3) {
        int mode;
        int size;
        float f;
        float f2;
        int i4;
        int flexDirection = this.nBj.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.nBj.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.nBj.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).nBa = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.nBj.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.nBa = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.nBj.setFlexLines(i(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.nBa = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.nBa = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.nBa);
                                    if (f > 1.0f) {
                                        bVar2.nBa++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.nBa--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.nBj.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.nBj.setFlexLines(i(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.nBa = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.nBj.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.nBa + size5;
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
                                bVar5.nBa = i4;
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

    private List<com.google.android.flexbox.b> i(List<com.google.android.flexbox.b> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
        bVar.nBa = (i - i2) / 2;
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
    public void dWG() {
        MC(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MC(int i) {
        View Mz;
        if (i < this.nBj.getFlexItemCount()) {
            int flexDirection = this.nBj.getFlexDirection();
            if (this.nBj.getAlignItems() == 4) {
                int i2 = this.nBl != null ? this.nBl[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.nBj.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.nBh + i5;
                        if (i5 < this.nBj.getFlexItemCount() && (Mz = this.nBj.Mz(i6)) != null && Mz.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) Mz.getLayoutParams();
                            if (flexItem.dWz() == -1 || flexItem.dWz() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        k(Mz, bVar.nBa, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        l(Mz, bVar.nBa, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.nBj.getFlexLinesInternal()) {
                for (Integer num : bVar2.nBg) {
                    View Mz2 = this.nBj.Mz(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            k(Mz2, bVar2.nBa, num.intValue());
                            break;
                        case 2:
                        case 3:
                            l(Mz2, bVar2.nBa, num.intValue());
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                }
            }
        }
    }

    private void k(View view, int i, int i2) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.dWC()) - flexItem.dWD()) - this.nBj.dv(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.nBn != null) {
            measuredWidth = gx(this.nBn[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.nBj.l(i2, view);
    }

    private void l(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.nBj.dv(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.nBn != null) {
            measuredHeight = gy(this.nBn[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.nBj.l(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.nBj.getAlignItems();
        if (flexItem.dWz() != -1) {
            alignItems = flexItem.dWz();
        }
        int i5 = bVar.nBa;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.nBj.getFlexWrap() != 2) {
                    view.layout(i, flexItem.dWC() + i2, i3, flexItem.dWC() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.dWD(), i3, i4 - flexItem.dWD());
                    return;
                }
            case 1:
                if (this.nBj.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.dWD(), i3, (i5 + i2) - flexItem.dWD());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.dWC(), i3, flexItem.dWC() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.dWC()) - flexItem.dWD()) / 2;
                if (this.nBj.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.nBj.getFlexWrap() != 2) {
                    int max = Math.max(bVar.nBe - view.getBaseline(), flexItem.dWC());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.nBe - view.getMeasuredHeight()) + view.getBaseline(), flexItem.dWD());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.nBj.getAlignItems();
        if (flexItem.dWz() != -1) {
            alignItems = flexItem.dWz();
        }
        int i5 = bVar.nBa;
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
    public void MD(int i) {
        if (this.nBn == null) {
            if (i < 10) {
                i = 10;
            }
            this.nBn = new long[i];
        } else if (this.nBn.length < i) {
            int length = this.nBn.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nBn = Arrays.copyOf(this.nBn, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ME(int i) {
        if (this.nBm == null) {
            if (i < 10) {
                i = 10;
            }
            this.nBm = new long[i];
        } else if (this.nBm.length < i) {
            int length = this.nBm.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nBm = Arrays.copyOf(this.nBm, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gx(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gy(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long dN(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.nBm != null) {
            this.nBm[i] = dN(i2, i3);
        }
        if (this.nBn != null) {
            this.nBn[i] = dN(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MF(int i) {
        if (this.nBl == null) {
            if (i < 10) {
                i = 10;
            }
            this.nBl = new int[i];
        } else if (this.nBl.length < i) {
            int length = this.nBl.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nBl = Arrays.copyOf(this.nBl, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.nBl == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.nBm == null) {
            throw new AssertionError();
        }
        int i2 = this.nBl[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.nBl.length - 1;
        if (i > length) {
            Arrays.fill(this.nBl, -1);
        } else {
            Arrays.fill(this.nBl, i, length, -1);
        }
        int length2 = this.nBm.length - 1;
        if (i > length2) {
            Arrays.fill(this.nBm, 0L);
        } else {
            Arrays.fill(this.nBm, i, length2, 0L);
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
        List<com.google.android.flexbox.b> nBo;
        int nBp;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.nBo = null;
            this.nBp = 0;
        }
    }
}
