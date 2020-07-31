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
    private final com.google.android.flexbox.a nhp;
    private boolean[] nhq;
    @Nullable
    int[] nhr;
    @Nullable
    long[] nhs;
    @Nullable
    private long[] nht;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.nhp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.nhp.getFlexItemCount();
        List<b> JW = JW(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.nhp.getFlexItemCount()) {
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
        int flexItemCount = this.nhp.getFlexItemCount();
        return a(flexItemCount, JW(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> JW(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.nhp.JU(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.nhp.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View JU = this.nhp.JU(i);
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
        boolean dKw = this.nhp.dKw();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.nhu = list;
        boolean z2 = i5 == -1;
        int xs = xs(dKw);
        int xt = xt(dKw);
        int xu = xu(dKw);
        int xv = xv(dKw);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.nhn = i4;
        bVar2.nhe = xs + xt;
        int flexItemCount = this.nhp.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View JV = this.nhp.JV(i17);
            if (JV == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (JV.getVisibility() == 8) {
                bVar2.nhh++;
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
                if (flexItem.dKx() == 4) {
                    bVar2.nhm.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, dKw);
                if (flexItem.dKz() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.dKz());
                }
                if (dKw) {
                    int ad = this.nhp.ad(i, xs + xt + c(flexItem, true) + d(flexItem, true), a2);
                    int ae = this.nhp.ae(i2, xu + xv + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    JV.measure(ad, ae);
                    a(i17, ad, ae, JV);
                    i7 = ad;
                } else {
                    int ad2 = this.nhp.ad(i2, xu + xv + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ae2 = this.nhp.ae(i, xs + xt + c(flexItem, false) + d(flexItem, false), a2);
                    JV.measure(ad2, ae2);
                    a(i17, ad2, ae2, JV);
                    i7 = ae2;
                }
                this.nhp.l(i17, JV);
                z(JV, i17);
                i6 = View.combineMeasuredStates(i13, JV.getMeasuredState());
                if (a(JV, mode, size, bVar2.nhe, d(flexItem, dKw) + n(JV, dKw) + c(flexItem, dKw), flexItem, i17, i16, list.size())) {
                    if (bVar2.dKD() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.nhg;
                    } else {
                        i12 = i15;
                    }
                    if (dKw) {
                        if (flexItem.getHeight() == -1) {
                            JV.measure(i7, this.nhp.ae(i2, this.nhp.getPaddingTop() + this.nhp.getPaddingBottom() + flexItem.dKA() + flexItem.dKB() + i12, flexItem.getHeight()));
                            z(JV, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        JV.measure(this.nhp.ad(i2, this.nhp.getPaddingLeft() + this.nhp.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        z(JV, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.nhe = xs + xt;
                    bVar3.nhn = i17;
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
                if (this.nhr != null) {
                    this.nhr[i17] = list.size();
                }
                bVar.nhe += n(JV, dKw) + c(flexItem, dKw) + d(flexItem, dKw);
                bVar.nhi += flexItem.getFlexGrow();
                bVar.nhj += flexItem.getFlexShrink();
                this.nhp.a(JV, i17, i8, bVar);
                i14 = Math.max(i9, o(JV, dKw) + e(flexItem, dKw) + f(flexItem, dKw) + this.nhp.dr(JV));
                bVar.nhg = Math.max(bVar.nhg, i14);
                if (dKw) {
                    if (this.nhp.getFlexWrap() != 2) {
                        bVar.nhk = Math.max(bVar.nhk, JV.getBaseline() + flexItem.dKA());
                    } else {
                        bVar.nhk = Math.max(bVar.nhk, (JV.getMeasuredHeight() - JV.getBaseline()) + flexItem.dKB());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.nhg;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).nho >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.dKC();
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
        aVar.nhv = i6;
    }

    private int xs(boolean z) {
        return z ? this.nhp.getPaddingStart() : this.nhp.getPaddingTop();
    }

    private int xt(boolean z) {
        return z ? this.nhp.getPaddingEnd() : this.nhp.getPaddingBottom();
    }

    private int xu(boolean z) {
        return z ? this.nhp.getPaddingTop() : this.nhp.getPaddingStart();
    }

    private int xv(boolean z) {
        return z ? this.nhp.getPaddingBottom() : this.nhp.getPaddingEnd();
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
        return z ? flexItem.getMarginLeft() : flexItem.dKA();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.dKB();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.dKA() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.dKB() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.nhp.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.dKy()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.nhp.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int k = this.nhp.k(view, i5, i6);
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
        return i == i2 + (-1) && bVar.dKD() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.nhl = i2;
        this.nhp.a(bVar);
        bVar.nho = i;
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
            this.nhp.l(i, view);
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
        JX(this.nhp.getFlexItemCount());
        if (i3 < this.nhp.getFlexItemCount()) {
            int flexDirection = this.nhp.getFlexDirection();
            switch (this.nhp.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.nhp.getLargestMainSize();
                    }
                    paddingTop = this.nhp.getPaddingLeft() + this.nhp.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.nhp.getLargestMainSize();
                    }
                    paddingTop = this.nhp.getPaddingTop() + this.nhp.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.nhr != null ? this.nhr[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.nhp.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.nhe < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void JX(int i) {
        if (this.nhq == null) {
            if (i < 10) {
                i = 10;
            }
            this.nhq = new boolean[i];
        } else if (this.nhq.length < i) {
            int length = this.nhq.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nhq = new boolean[i];
        } else {
            Arrays.fill(this.nhq, false);
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
        if (bVar.nhi > 0.0f && i3 >= bVar.nhe) {
            int i8 = bVar.nhe;
            float f5 = (i3 - bVar.nhe) / bVar.nhi;
            bVar.nhe = bVar.nhf + i4;
            if (!z) {
                bVar.nhg = Integer.MIN_VALUE;
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
                int i12 = bVar.nhn + i11;
                View JV = this.nhp.JV(i12);
                if (JV != null && JV.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) JV.getLayoutParams();
                    int flexDirection = this.nhp.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = JV.getMeasuredWidth();
                        if (this.nht != null) {
                            measuredWidth = gk(this.nht[i12]);
                        }
                        int measuredHeight = JV.getMeasuredHeight();
                        if (this.nht != null) {
                            measuredHeight = gl(this.nht[i12]);
                        }
                        if (!this.nhq[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.nhq[i12] = true;
                                bVar.nhi -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.nhl);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            JV.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = JV.getMeasuredWidth();
                            measuredHeight = JV.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, JV);
                            this.nhp.l(i12, JV);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dKA() + flexItem.dKB() + this.nhp.dr(JV));
                        bVar.nhe = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.nhe;
                        i5 = max;
                    } else {
                        int measuredHeight2 = JV.getMeasuredHeight();
                        if (this.nht != null) {
                            measuredHeight2 = gl(this.nht[i12]);
                        }
                        int measuredWidth3 = JV.getMeasuredWidth();
                        if (this.nht != null) {
                            measuredWidth3 = gk(this.nht[i12]);
                        }
                        if (!this.nhq[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.nhq[i12] = true;
                                bVar.nhi -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.nhl);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            JV.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = JV.getMeasuredWidth();
                            int measuredHeight3 = JV.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, JV);
                            this.nhp.l(i12, JV);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.nhp.dr(JV));
                        bVar.nhe = flexItem.dKB() + measuredHeight2 + flexItem.dKA() + bVar.nhe;
                        i5 = max2;
                    }
                    bVar.nhg = Math.max(bVar.nhg, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.nhe) {
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
        int i8 = bVar.nhe;
        if (bVar.nhj > 0.0f && i3 <= bVar.nhe) {
            float f5 = (bVar.nhe - i3) / bVar.nhj;
            bVar.nhe = bVar.nhf + i4;
            if (!z) {
                bVar.nhg = Integer.MIN_VALUE;
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
                int i12 = bVar.nhn + i11;
                View JV = this.nhp.JV(i12);
                if (JV != null && JV.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) JV.getLayoutParams();
                    int flexDirection = this.nhp.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = JV.getMeasuredWidth();
                        if (this.nht != null) {
                            measuredWidth = gk(this.nht[i12]);
                        }
                        int measuredHeight = JV.getMeasuredHeight();
                        if (this.nht != null) {
                            measuredHeight = gl(this.nht[i12]);
                        }
                        if (!this.nhq[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.nhq[i12] = true;
                                bVar.nhj -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.nhl);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            JV.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = JV.getMeasuredWidth();
                            measuredHeight = JV.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, JV);
                            this.nhp.l(i12, JV);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dKA() + flexItem.dKB() + this.nhp.dr(JV));
                        bVar.nhe = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.nhe;
                        i5 = max;
                    } else {
                        int measuredHeight2 = JV.getMeasuredHeight();
                        if (this.nht != null) {
                            measuredHeight2 = gl(this.nht[i12]);
                        }
                        int measuredWidth3 = JV.getMeasuredWidth();
                        if (this.nht != null) {
                            measuredWidth3 = gk(this.nht[i12]);
                        }
                        if (!this.nhq[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.nhq[i12] = true;
                                bVar.nhj -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.nhl);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            JV.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = JV.getMeasuredWidth();
                            int measuredHeight3 = JV.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, JV);
                            this.nhp.l(i12, JV);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.nhp.dr(JV));
                        bVar.nhe = flexItem.dKB() + measuredHeight2 + flexItem.dKA() + bVar.nhe;
                        i5 = max2;
                    }
                    bVar.nhg = Math.max(bVar.nhg, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.nhe) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int ad = this.nhp.ad(i, this.nhp.getPaddingLeft() + this.nhp.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
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
        int ae = this.nhp.ae(i, this.nhp.getPaddingTop() + this.nhp.getPaddingBottom() + flexItem.dKA() + flexItem.dKB() + i2, flexItem.getHeight());
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
        int flexDirection = this.nhp.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.nhp.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.nhp.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).nhg = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.nhp.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.nhg = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.nhp.setFlexLines(i(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.nhg = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.nhg = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.nhg);
                                    if (f > 1.0f) {
                                        bVar2.nhg++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.nhg--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.nhp.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.nhp.setFlexLines(i(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.nhg = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.nhp.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.nhg + size5;
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
                                bVar5.nhg = i4;
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
        bVar.nhg = (i - i2) / 2;
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
    public void dKE() {
        JY(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void JY(int i) {
        View JV;
        if (i < this.nhp.getFlexItemCount()) {
            int flexDirection = this.nhp.getFlexDirection();
            if (this.nhp.getAlignItems() == 4) {
                int i2 = this.nhr != null ? this.nhr[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.nhp.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.nhn + i5;
                        if (i5 < this.nhp.getFlexItemCount() && (JV = this.nhp.JV(i6)) != null && JV.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) JV.getLayoutParams();
                            if (flexItem.dKx() == -1 || flexItem.dKx() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        l(JV, bVar.nhg, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        m(JV, bVar.nhg, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.nhp.getFlexLinesInternal()) {
                for (Integer num : bVar2.nhm) {
                    View JV2 = this.nhp.JV(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            l(JV2, bVar2.nhg, num.intValue());
                            break;
                        case 2:
                        case 3:
                            m(JV2, bVar2.nhg, num.intValue());
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
        int min = Math.min(Math.max(((i - flexItem.dKA()) - flexItem.dKB()) - this.nhp.dr(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.nht != null) {
            measuredWidth = gk(this.nht[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.nhp.l(i2, view);
    }

    private void m(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.nhp.dr(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.nht != null) {
            measuredHeight = gl(this.nht[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.nhp.l(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.nhp.getAlignItems();
        if (flexItem.dKx() != -1) {
            alignItems = flexItem.dKx();
        }
        int i5 = bVar.nhg;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.nhp.getFlexWrap() != 2) {
                    view.layout(i, flexItem.dKA() + i2, i3, flexItem.dKA() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.dKB(), i3, i4 - flexItem.dKB());
                    return;
                }
            case 1:
                if (this.nhp.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.dKB(), i3, (i5 + i2) - flexItem.dKB());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.dKA(), i3, flexItem.dKA() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.dKA()) - flexItem.dKB()) / 2;
                if (this.nhp.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.nhp.getFlexWrap() != 2) {
                    int max = Math.max(bVar.nhk - view.getBaseline(), flexItem.dKA());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.nhk - view.getMeasuredHeight()) + view.getBaseline(), flexItem.dKB());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.nhp.getAlignItems();
        if (flexItem.dKx() != -1) {
            alignItems = flexItem.dKx();
        }
        int i5 = bVar.nhg;
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
        if (this.nht == null) {
            if (i < 10) {
                i = 10;
            }
            this.nht = new long[i];
        } else if (this.nht.length < i) {
            int length = this.nht.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nht = Arrays.copyOf(this.nht, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ka(int i) {
        if (this.nhs == null) {
            if (i < 10) {
                i = 10;
            }
            this.nhs = new long[i];
        } else if (this.nhs.length < i) {
            int length = this.nhs.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nhs = Arrays.copyOf(this.nhs, i);
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
        if (this.nhs != null) {
            this.nhs[i] = dF(i2, i3);
        }
        if (this.nht != null) {
            this.nht[i] = dF(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Kb(int i) {
        if (this.nhr == null) {
            if (i < 10) {
                i = 10;
            }
            this.nhr = new int[i];
        } else if (this.nhr.length < i) {
            int length = this.nhr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nhr = Arrays.copyOf(this.nhr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.nhr == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.nhs == null) {
            throw new AssertionError();
        }
        int i2 = this.nhr[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.nhr.length - 1;
        if (i > length) {
            Arrays.fill(this.nhr, -1);
        } else {
            Arrays.fill(this.nhr, i, length, -1);
        }
        int length2 = this.nhs.length - 1;
        if (i > length2) {
            Arrays.fill(this.nhs, 0L);
        } else {
            Arrays.fill(this.nhs, i, length2, 0L);
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
        List<com.google.android.flexbox.b> nhu;
        int nhv;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.nhu = null;
            this.nhv = 0;
        }
    }
}
