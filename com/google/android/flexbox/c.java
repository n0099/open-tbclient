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
/* loaded from: classes9.dex */
public class c {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final com.google.android.flexbox.a nhr;
    private boolean[] nhs;
    @Nullable
    int[] nht;
    @Nullable
    long[] nhu;
    @Nullable
    private long[] nhv;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.nhr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.nhr.getFlexItemCount();
        List<b> JW = JW(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.nhr.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                JW.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        JW.add(bVar);
        return a(flexItemCount + 1, JW, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.nhr.getFlexItemCount();
        return a(flexItemCount, JW(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> JW(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.nhr.JU(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.nhr.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View JU = this.nhr.JU(i);
            if (JU != null && ((FlexItem) JU.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean dKx = this.nhr.dKx();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.nhw = list;
        boolean z2 = i5 == -1;
        int xs = xs(dKx);
        int xt = xt(dKx);
        int xu = xu(dKx);
        int xv = xv(dKx);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.nhp = i4;
        bVar2.nhg = xs + xt;
        int flexItemCount = this.nhr.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View JV = this.nhr.JV(i17);
            if (JV == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (JV.getVisibility() == 8) {
                bVar2.nhj++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) JV.getLayoutParams();
                if (flexItem.dKy() == 4) {
                    bVar2.nho.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, dKx);
                if (flexItem.dKA() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.dKA());
                }
                if (dKx) {
                    int ad = this.nhr.ad(i, xs + xt + c(flexItem, true) + d(flexItem, true), a2);
                    int ae = this.nhr.ae(i2, xu + xv + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    JV.measure(ad, ae);
                    a(i17, ad, ae, JV);
                    i7 = ad;
                } else {
                    int ad2 = this.nhr.ad(i2, xu + xv + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ae2 = this.nhr.ae(i, xs + xt + c(flexItem, false) + d(flexItem, false), a2);
                    JV.measure(ad2, ae2);
                    a(i17, ad2, ae2, JV);
                    i7 = ae2;
                }
                this.nhr.l(i17, JV);
                z(JV, i17);
                i6 = View.combineMeasuredStates(i13, JV.getMeasuredState());
                if (a(JV, mode, size, bVar2.nhg, d(flexItem, dKx) + n(JV, dKx) + c(flexItem, dKx), flexItem, i17, i16, list.size())) {
                    if (bVar2.dKE() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.nhi;
                    } else {
                        i12 = i15;
                    }
                    if (dKx) {
                        if (flexItem.getHeight() == -1) {
                            JV.measure(i7, this.nhr.ae(i2, this.nhr.getPaddingTop() + this.nhr.getPaddingBottom() + flexItem.dKB() + flexItem.dKC() + i12, flexItem.getHeight()));
                            z(JV, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        JV.measure(this.nhr.ad(i2, this.nhr.getPaddingLeft() + this.nhr.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        z(JV, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.nhg = xs + xt;
                    bVar3.nhp = i17;
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
                if (this.nht != null) {
                    this.nht[i17] = list.size();
                }
                bVar.nhg += n(JV, dKx) + c(flexItem, dKx) + d(flexItem, dKx);
                bVar.nhk += flexItem.getFlexGrow();
                bVar.nhl += flexItem.getFlexShrink();
                this.nhr.a(JV, i17, i8, bVar);
                i14 = Math.max(i9, o(JV, dKx) + e(flexItem, dKx) + f(flexItem, dKx) + this.nhr.dr(JV));
                bVar.nhi = Math.max(bVar.nhi, i14);
                if (dKx) {
                    if (this.nhr.getFlexWrap() != 2) {
                        bVar.nhm = Math.max(bVar.nhm, JV.getBaseline() + flexItem.dKB());
                    } else {
                        bVar.nhm = Math.max(bVar.nhm, (JV.getMeasuredHeight() - JV.getBaseline()) + flexItem.dKC());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.nhi;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).nhq >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.dKD();
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
        aVar.nhx = i6;
    }

    private int xs(boolean z) {
        return z ? this.nhr.getPaddingStart() : this.nhr.getPaddingTop();
    }

    private int xt(boolean z) {
        return z ? this.nhr.getPaddingEnd() : this.nhr.getPaddingBottom();
    }

    private int xu(boolean z) {
        return z ? this.nhr.getPaddingTop() : this.nhr.getPaddingStart();
    }

    private int xv(boolean z) {
        return z ? this.nhr.getPaddingBottom() : this.nhr.getPaddingEnd();
    }

    private int n(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int o(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int a(FlexItem flexItem, boolean z) {
        return z ? flexItem.getWidth() : flexItem.getHeight();
    }

    private int b(FlexItem flexItem, boolean z) {
        return z ? flexItem.getHeight() : flexItem.getWidth();
    }

    private int c(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginLeft() : flexItem.dKB();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.dKC();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.dKB() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.dKC() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.nhr.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.dKz()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.nhr.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int k = this.nhr.k(view, i5, i6);
                if (k > 0) {
                    i4 += k;
                }
                return i2 < i3 + i4;
            }
            return false;
        }
        return false;
    }

    private boolean a(int i, int i2, com.google.android.flexbox.b bVar) {
        return i == i2 + (-1) && bVar.dKE() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.nhn = i2;
        this.nhr.a(bVar);
        bVar.nhq = i;
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
            this.nhr.l(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dE(int i, int i2) {
        af(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        JX(this.nhr.getFlexItemCount());
        if (i3 < this.nhr.getFlexItemCount()) {
            int flexDirection = this.nhr.getFlexDirection();
            switch (this.nhr.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.nhr.getLargestMainSize();
                    }
                    paddingTop = this.nhr.getPaddingLeft() + this.nhr.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.nhr.getLargestMainSize();
                    }
                    paddingTop = this.nhr.getPaddingTop() + this.nhr.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.nht != null ? this.nht[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.nhr.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.nhg < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void JX(int i) {
        if (this.nhs == null) {
            if (i < 10) {
                i = 10;
            }
            this.nhs = new boolean[i];
        } else if (this.nhs.length < i) {
            int length = this.nhs.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nhs = new boolean[i];
        } else {
            Arrays.fill(this.nhs, false);
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
        if (bVar.nhk > 0.0f && i3 >= bVar.nhg) {
            int i8 = bVar.nhg;
            float f5 = (i3 - bVar.nhg) / bVar.nhk;
            bVar.nhg = bVar.nhh + i4;
            if (!z) {
                bVar.nhi = Integer.MIN_VALUE;
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
                int i12 = bVar.nhp + i11;
                View JV = this.nhr.JV(i12);
                if (JV != null && JV.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) JV.getLayoutParams();
                    int flexDirection = this.nhr.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = JV.getMeasuredWidth();
                        if (this.nhv != null) {
                            measuredWidth = gk(this.nhv[i12]);
                        }
                        int measuredHeight = JV.getMeasuredHeight();
                        if (this.nhv != null) {
                            measuredHeight = gl(this.nhv[i12]);
                        }
                        if (!this.nhs[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.nhs[i12] = true;
                                bVar.nhk -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.nhn);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            JV.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = JV.getMeasuredWidth();
                            measuredHeight = JV.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, JV);
                            this.nhr.l(i12, JV);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dKB() + flexItem.dKC() + this.nhr.dr(JV));
                        bVar.nhg = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.nhg;
                        i5 = max;
                    } else {
                        int measuredHeight2 = JV.getMeasuredHeight();
                        if (this.nhv != null) {
                            measuredHeight2 = gl(this.nhv[i12]);
                        }
                        int measuredWidth3 = JV.getMeasuredWidth();
                        if (this.nhv != null) {
                            measuredWidth3 = gk(this.nhv[i12]);
                        }
                        if (!this.nhs[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.nhs[i12] = true;
                                bVar.nhk -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.nhn);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            JV.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = JV.getMeasuredWidth();
                            int measuredHeight3 = JV.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, JV);
                            this.nhr.l(i12, JV);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.nhr.dr(JV));
                        bVar.nhg = flexItem.dKC() + measuredHeight2 + flexItem.dKB() + bVar.nhg;
                        i5 = max2;
                    }
                    bVar.nhi = Math.max(bVar.nhi, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.nhg) {
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
        int i8 = bVar.nhg;
        if (bVar.nhl > 0.0f && i3 <= bVar.nhg) {
            float f5 = (bVar.nhg - i3) / bVar.nhl;
            bVar.nhg = bVar.nhh + i4;
            if (!z) {
                bVar.nhi = Integer.MIN_VALUE;
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
                int i12 = bVar.nhp + i11;
                View JV = this.nhr.JV(i12);
                if (JV != null && JV.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) JV.getLayoutParams();
                    int flexDirection = this.nhr.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = JV.getMeasuredWidth();
                        if (this.nhv != null) {
                            measuredWidth = gk(this.nhv[i12]);
                        }
                        int measuredHeight = JV.getMeasuredHeight();
                        if (this.nhv != null) {
                            measuredHeight = gl(this.nhv[i12]);
                        }
                        if (!this.nhs[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.nhs[i12] = true;
                                bVar.nhl -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.nhn);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            JV.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = JV.getMeasuredWidth();
                            measuredHeight = JV.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, JV);
                            this.nhr.l(i12, JV);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dKB() + flexItem.dKC() + this.nhr.dr(JV));
                        bVar.nhg = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.nhg;
                        i5 = max;
                    } else {
                        int measuredHeight2 = JV.getMeasuredHeight();
                        if (this.nhv != null) {
                            measuredHeight2 = gl(this.nhv[i12]);
                        }
                        int measuredWidth3 = JV.getMeasuredWidth();
                        if (this.nhv != null) {
                            measuredWidth3 = gk(this.nhv[i12]);
                        }
                        if (!this.nhs[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.nhs[i12] = true;
                                bVar.nhl -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.nhn);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            JV.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = JV.getMeasuredWidth();
                            int measuredHeight3 = JV.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, JV);
                            this.nhr.l(i12, JV);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.nhr.dr(JV));
                        bVar.nhg = flexItem.dKC() + measuredHeight2 + flexItem.dKB() + bVar.nhg;
                        i5 = max2;
                    }
                    bVar.nhi = Math.max(bVar.nhi, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.nhg) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int ad = this.nhr.ad(i, this.nhr.getPaddingLeft() + this.nhr.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
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
        int ae = this.nhr.ae(i, this.nhr.getPaddingTop() + this.nhr.getPaddingBottom() + flexItem.dKB() + flexItem.dKC() + i2, flexItem.getHeight());
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
        int flexDirection = this.nhr.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.nhr.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.nhr.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).nhi = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.nhr.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.nhi = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.nhr.setFlexLines(i(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.nhi = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.nhi = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.nhi);
                                    if (f > 1.0f) {
                                        bVar2.nhi++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.nhi--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.nhr.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.nhr.setFlexLines(i(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.nhi = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.nhr.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.nhi + size5;
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
                                bVar5.nhi = i4;
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
        bVar.nhi = (i - i2) / 2;
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
    public void dKF() {
        JY(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void JY(int i) {
        View JV;
        if (i < this.nhr.getFlexItemCount()) {
            int flexDirection = this.nhr.getFlexDirection();
            if (this.nhr.getAlignItems() == 4) {
                int i2 = this.nht != null ? this.nht[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.nhr.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.nhp + i5;
                        if (i5 < this.nhr.getFlexItemCount() && (JV = this.nhr.JV(i6)) != null && JV.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) JV.getLayoutParams();
                            if (flexItem.dKy() == -1 || flexItem.dKy() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        l(JV, bVar.nhi, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        m(JV, bVar.nhi, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.nhr.getFlexLinesInternal()) {
                for (Integer num : bVar2.nho) {
                    View JV2 = this.nhr.JV(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            l(JV2, bVar2.nhi, num.intValue());
                            break;
                        case 2:
                        case 3:
                            m(JV2, bVar2.nhi, num.intValue());
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                }
            }
        }
    }

    private void l(View view, int i, int i2) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.dKB()) - flexItem.dKC()) - this.nhr.dr(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.nhv != null) {
            measuredWidth = gk(this.nhv[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.nhr.l(i2, view);
    }

    private void m(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.nhr.dr(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.nhv != null) {
            measuredHeight = gl(this.nhv[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.nhr.l(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.nhr.getAlignItems();
        if (flexItem.dKy() != -1) {
            alignItems = flexItem.dKy();
        }
        int i5 = bVar.nhi;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.nhr.getFlexWrap() != 2) {
                    view.layout(i, flexItem.dKB() + i2, i3, flexItem.dKB() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.dKC(), i3, i4 - flexItem.dKC());
                    return;
                }
            case 1:
                if (this.nhr.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.dKC(), i3, (i5 + i2) - flexItem.dKC());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.dKB(), i3, flexItem.dKB() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.dKB()) - flexItem.dKC()) / 2;
                if (this.nhr.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.nhr.getFlexWrap() != 2) {
                    int max = Math.max(bVar.nhm - view.getBaseline(), flexItem.dKB());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.nhm - view.getMeasuredHeight()) + view.getBaseline(), flexItem.dKC());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.nhr.getAlignItems();
        if (flexItem.dKy() != -1) {
            alignItems = flexItem.dKy();
        }
        int i5 = bVar.nhi;
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
    public void JZ(int i) {
        if (this.nhv == null) {
            if (i < 10) {
                i = 10;
            }
            this.nhv = new long[i];
        } else if (this.nhv.length < i) {
            int length = this.nhv.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nhv = Arrays.copyOf(this.nhv, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ka(int i) {
        if (this.nhu == null) {
            if (i < 10) {
                i = 10;
            }
            this.nhu = new long[i];
        } else if (this.nhu.length < i) {
            int length = this.nhu.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nhu = Arrays.copyOf(this.nhu, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gk(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gl(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long dF(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.nhu != null) {
            this.nhu[i] = dF(i2, i3);
        }
        if (this.nhv != null) {
            this.nhv[i] = dF(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Kb(int i) {
        if (this.nht == null) {
            if (i < 10) {
                i = 10;
            }
            this.nht = new int[i];
        } else if (this.nht.length < i) {
            int length = this.nht.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nht = Arrays.copyOf(this.nht, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.nht == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.nhu == null) {
            throw new AssertionError();
        }
        int i2 = this.nht[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.nht.length - 1;
        if (i > length) {
            Arrays.fill(this.nht, -1);
        } else {
            Arrays.fill(this.nht, i, length, -1);
        }
        int length2 = this.nhu.length - 1;
        if (i > length2) {
            Arrays.fill(this.nhu, 0L);
        } else {
            Arrays.fill(this.nhu, i, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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
    /* loaded from: classes9.dex */
    public static class a {
        List<com.google.android.flexbox.b> nhw;
        int nhx;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.nhw = null;
            this.nhx = 0;
        }
    }
}
