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
/* loaded from: classes5.dex */
public class c {
    static final /* synthetic */ boolean $assertionsDisabled;
    @Nullable
    long[] mJA;
    @Nullable
    private long[] mJB;
    private final com.google.android.flexbox.a mJx;
    private boolean[] mJy;
    @Nullable
    int[] mJz;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.mJx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mJx.getFlexItemCount();
        List<b> Mg = Mg(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.mJx.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                Mg.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        Mg.add(bVar);
        return a(flexItemCount + 1, Mg, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mJx.getFlexItemCount();
        return a(flexItemCount, Mg(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> Mg(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.mJx.Me(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mJx.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View Me = this.mJx.Me(i);
            if (Me != null && ((FlexItem) Me.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean dAl = this.mJx.dAl();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.mJC = list;
        boolean z2 = i5 == -1;
        int vY = vY(dAl);
        int vZ = vZ(dAl);
        int wa = wa(dAl);
        int wb = wb(dAl);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.mJv = i4;
        bVar2.mJm = vY + vZ;
        int flexItemCount = this.mJx.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View Mf = this.mJx.Mf(i17);
            if (Mf == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (Mf.getVisibility() == 8) {
                bVar2.mJp++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) Mf.getLayoutParams();
                if (flexItem.dAm() == 4) {
                    bVar2.mJu.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, dAl);
                if (flexItem.dAo() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.dAo());
                }
                if (dAl) {
                    int an = this.mJx.an(i, vY + vZ + c(flexItem, true) + d(flexItem, true), a2);
                    int ao = this.mJx.ao(i2, wa + wb + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    Mf.measure(an, ao);
                    a(i17, an, ao, Mf);
                    i7 = an;
                } else {
                    int an2 = this.mJx.an(i2, wa + wb + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ao2 = this.mJx.ao(i, vY + vZ + c(flexItem, false) + d(flexItem, false), a2);
                    Mf.measure(an2, ao2);
                    a(i17, an2, ao2, Mf);
                    i7 = ao2;
                }
                this.mJx.m(i17, Mf);
                y(Mf, i17);
                i6 = View.combineMeasuredStates(i13, Mf.getMeasuredState());
                if (a(Mf, mode, size, bVar2.mJm, d(flexItem, dAl) + l(Mf, dAl) + c(flexItem, dAl), flexItem, i17, i16, list.size())) {
                    if (bVar2.dAs() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.mJo;
                    } else {
                        i12 = i15;
                    }
                    if (dAl) {
                        if (flexItem.getHeight() == -1) {
                            Mf.measure(i7, this.mJx.ao(i2, this.mJx.getPaddingTop() + this.mJx.getPaddingBottom() + flexItem.dAp() + flexItem.dAq() + i12, flexItem.getHeight()));
                            y(Mf, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        Mf.measure(this.mJx.an(i2, this.mJx.getPaddingLeft() + this.mJx.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        y(Mf, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.mJm = vY + vZ;
                    bVar3.mJv = i17;
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
                if (this.mJz != null) {
                    this.mJz[i17] = list.size();
                }
                bVar.mJm += l(Mf, dAl) + c(flexItem, dAl) + d(flexItem, dAl);
                bVar.mJq += flexItem.getFlexGrow();
                bVar.mJr += flexItem.getFlexShrink();
                this.mJx.a(Mf, i17, i8, bVar);
                i14 = Math.max(i9, m(Mf, dAl) + e(flexItem, dAl) + f(flexItem, dAl) + this.mJx.ds(Mf));
                bVar.mJo = Math.max(bVar.mJo, i14);
                if (dAl) {
                    if (this.mJx.getFlexWrap() != 2) {
                        bVar.mJs = Math.max(bVar.mJs, Mf.getBaseline() + flexItem.dAp());
                    } else {
                        bVar.mJs = Math.max(bVar.mJs, (Mf.getMeasuredHeight() - Mf.getBaseline()) + flexItem.dAq());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.mJo;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).mJw >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.dAr();
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
        aVar.mJD = i6;
    }

    private int vY(boolean z) {
        return z ? this.mJx.getPaddingStart() : this.mJx.getPaddingTop();
    }

    private int vZ(boolean z) {
        return z ? this.mJx.getPaddingEnd() : this.mJx.getPaddingBottom();
    }

    private int wa(boolean z) {
        return z ? this.mJx.getPaddingTop() : this.mJx.getPaddingStart();
    }

    private int wb(boolean z) {
        return z ? this.mJx.getPaddingBottom() : this.mJx.getPaddingEnd();
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
        return z ? flexItem.getMarginLeft() : flexItem.dAp();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.dAq();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.dAp() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.dAq() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.mJx.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.dAn()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.mJx.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int g = this.mJx.g(view, i5, i6);
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
        return i == i2 + (-1) && bVar.dAs() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.mJt = i2;
        this.mJx.a(bVar);
        bVar.mJw = i;
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
            this.mJx.m(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eb(int i, int i2) {
        ap(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ap(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        Mh(this.mJx.getFlexItemCount());
        if (i3 < this.mJx.getFlexItemCount()) {
            int flexDirection = this.mJx.getFlexDirection();
            switch (this.mJx.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.mJx.getLargestMainSize();
                    }
                    paddingTop = this.mJx.getPaddingLeft() + this.mJx.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.mJx.getLargestMainSize();
                    }
                    paddingTop = this.mJx.getPaddingTop() + this.mJx.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.mJz != null ? this.mJz[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.mJx.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.mJm < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void Mh(int i) {
        if (this.mJy == null) {
            if (i < 10) {
                i = 10;
            }
            this.mJy = new boolean[i];
        } else if (this.mJy.length < i) {
            int length = this.mJy.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mJy = new boolean[i];
        } else {
            Arrays.fill(this.mJy, false);
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
        if (bVar.mJq > 0.0f && i3 >= bVar.mJm) {
            int i8 = bVar.mJm;
            float f5 = (i3 - bVar.mJm) / bVar.mJq;
            bVar.mJm = bVar.mJn + i4;
            if (!z) {
                bVar.mJo = Integer.MIN_VALUE;
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
                int i12 = bVar.mJv + i11;
                View Mf = this.mJx.Mf(i12);
                if (Mf != null && Mf.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Mf.getLayoutParams();
                    int flexDirection = this.mJx.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Mf.getMeasuredWidth();
                        if (this.mJB != null) {
                            measuredWidth = gO(this.mJB[i12]);
                        }
                        int measuredHeight = Mf.getMeasuredHeight();
                        if (this.mJB != null) {
                            measuredHeight = gP(this.mJB[i12]);
                        }
                        if (!this.mJy[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mJy[i12] = true;
                                bVar.mJq -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.mJt);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Mf.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Mf.getMeasuredWidth();
                            measuredHeight = Mf.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Mf);
                            this.mJx.m(i12, Mf);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dAp() + flexItem.dAq() + this.mJx.ds(Mf));
                        bVar.mJm = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mJm;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Mf.getMeasuredHeight();
                        if (this.mJB != null) {
                            measuredHeight2 = gP(this.mJB[i12]);
                        }
                        int measuredWidth3 = Mf.getMeasuredWidth();
                        if (this.mJB != null) {
                            measuredWidth3 = gO(this.mJB[i12]);
                        }
                        if (!this.mJy[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mJy[i12] = true;
                                bVar.mJq -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.mJt);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Mf.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Mf.getMeasuredWidth();
                            int measuredHeight3 = Mf.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Mf);
                            this.mJx.m(i12, Mf);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mJx.ds(Mf));
                        bVar.mJm = flexItem.dAq() + measuredHeight2 + flexItem.dAp() + bVar.mJm;
                        i5 = max2;
                    }
                    bVar.mJo = Math.max(bVar.mJo, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mJm) {
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
        int i8 = bVar.mJm;
        if (bVar.mJr > 0.0f && i3 <= bVar.mJm) {
            float f5 = (bVar.mJm - i3) / bVar.mJr;
            bVar.mJm = bVar.mJn + i4;
            if (!z) {
                bVar.mJo = Integer.MIN_VALUE;
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
                int i12 = bVar.mJv + i11;
                View Mf = this.mJx.Mf(i12);
                if (Mf != null && Mf.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Mf.getLayoutParams();
                    int flexDirection = this.mJx.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Mf.getMeasuredWidth();
                        if (this.mJB != null) {
                            measuredWidth = gO(this.mJB[i12]);
                        }
                        int measuredHeight = Mf.getMeasuredHeight();
                        if (this.mJB != null) {
                            measuredHeight = gP(this.mJB[i12]);
                        }
                        if (!this.mJy[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mJy[i12] = true;
                                bVar.mJr -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.mJt);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Mf.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Mf.getMeasuredWidth();
                            measuredHeight = Mf.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Mf);
                            this.mJx.m(i12, Mf);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dAp() + flexItem.dAq() + this.mJx.ds(Mf));
                        bVar.mJm = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mJm;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Mf.getMeasuredHeight();
                        if (this.mJB != null) {
                            measuredHeight2 = gP(this.mJB[i12]);
                        }
                        int measuredWidth3 = Mf.getMeasuredWidth();
                        if (this.mJB != null) {
                            measuredWidth3 = gO(this.mJB[i12]);
                        }
                        if (!this.mJy[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mJy[i12] = true;
                                bVar.mJr -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.mJt);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Mf.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Mf.getMeasuredWidth();
                            int measuredHeight3 = Mf.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Mf);
                            this.mJx.m(i12, Mf);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mJx.ds(Mf));
                        bVar.mJm = flexItem.dAq() + measuredHeight2 + flexItem.dAp() + bVar.mJm;
                        i5 = max2;
                    }
                    bVar.mJo = Math.max(bVar.mJo, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mJm) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int an = this.mJx.an(i, this.mJx.getPaddingLeft() + this.mJx.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(an);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(an));
        }
        if (size < flexItem.getMinWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(an));
        }
        return an;
    }

    private int b(int i, FlexItem flexItem, int i2) {
        int ao = this.mJx.ao(i, this.mJx.getPaddingTop() + this.mJx.getPaddingBottom() + flexItem.dAp() + flexItem.dAq() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(ao);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(ao));
        }
        if (size < flexItem.getMinHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(ao));
        }
        return ao;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aq(int i, int i2, int i3) {
        int mode;
        int size;
        float f;
        float f2;
        int i4;
        int flexDirection = this.mJx.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.mJx.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mJx.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mJo = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.mJx.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.mJo = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.mJx.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.mJo = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.mJo = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.mJo);
                                    if (f > 1.0f) {
                                        bVar2.mJo++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.mJo--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.mJx.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.mJx.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.mJo = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.mJx.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.mJo + size5;
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
                                bVar5.mJo = i4;
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
        bVar.mJo = (i - i2) / 2;
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
    public void dAt() {
        Mi(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mi(int i) {
        View Mf;
        if (i < this.mJx.getFlexItemCount()) {
            int flexDirection = this.mJx.getFlexDirection();
            if (this.mJx.getAlignItems() == 4) {
                int i2 = this.mJz != null ? this.mJz[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.mJx.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.mJv + i5;
                        if (i5 < this.mJx.getFlexItemCount() && (Mf = this.mJx.Mf(i6)) != null && Mf.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) Mf.getLayoutParams();
                            if (flexItem.dAm() == -1 || flexItem.dAm() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        h(Mf, bVar.mJo, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        i(Mf, bVar.mJo, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.mJx.getFlexLinesInternal()) {
                for (Integer num : bVar2.mJu) {
                    View Mf2 = this.mJx.Mf(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            h(Mf2, bVar2.mJo, num.intValue());
                            break;
                        case 2:
                        case 3:
                            i(Mf2, bVar2.mJo, num.intValue());
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
        int min = Math.min(Math.max(((i - flexItem.dAp()) - flexItem.dAq()) - this.mJx.ds(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.mJB != null) {
            measuredWidth = gO(this.mJB[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.mJx.m(i2, view);
    }

    private void i(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mJx.ds(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.mJB != null) {
            measuredHeight = gP(this.mJB[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.mJx.m(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mJx.getAlignItems();
        if (flexItem.dAm() != -1) {
            alignItems = flexItem.dAm();
        }
        int i5 = bVar.mJo;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.mJx.getFlexWrap() != 2) {
                    view.layout(i, flexItem.dAp() + i2, i3, flexItem.dAp() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.dAq(), i3, i4 - flexItem.dAq());
                    return;
                }
            case 1:
                if (this.mJx.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.dAq(), i3, (i5 + i2) - flexItem.dAq());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.dAp(), i3, flexItem.dAp() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.dAp()) - flexItem.dAq()) / 2;
                if (this.mJx.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.mJx.getFlexWrap() != 2) {
                    int max = Math.max(bVar.mJs - view.getBaseline(), flexItem.dAp());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.mJs - view.getMeasuredHeight()) + view.getBaseline(), flexItem.dAq());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mJx.getAlignItems();
        if (flexItem.dAm() != -1) {
            alignItems = flexItem.dAm();
        }
        int i5 = bVar.mJo;
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
    public void Mj(int i) {
        if (this.mJB == null) {
            if (i < 10) {
                i = 10;
            }
            this.mJB = new long[i];
        } else if (this.mJB.length < i) {
            int length = this.mJB.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mJB = Arrays.copyOf(this.mJB, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mk(int i) {
        if (this.mJA == null) {
            if (i < 10) {
                i = 10;
            }
            this.mJA = new long[i];
        } else if (this.mJA.length < i) {
            int length = this.mJA.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mJA = Arrays.copyOf(this.mJA, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gO(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gP(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long ec(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.mJA != null) {
            this.mJA[i] = ec(i2, i3);
        }
        if (this.mJB != null) {
            this.mJB[i] = ec(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ml(int i) {
        if (this.mJz == null) {
            if (i < 10) {
                i = 10;
            }
            this.mJz = new int[i];
        } else if (this.mJz.length < i) {
            int length = this.mJz.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mJz = Arrays.copyOf(this.mJz, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.mJz == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.mJA == null) {
            throw new AssertionError();
        }
        int i2 = this.mJz[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.mJz.length - 1;
        if (i > length) {
            Arrays.fill(this.mJz, -1);
        } else {
            Arrays.fill(this.mJz, i, length, -1);
        }
        int length2 = this.mJA.length - 1;
        if (i > length2) {
            Arrays.fill(this.mJA, 0L);
        } else {
            Arrays.fill(this.mJA, i, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
    public static class a {
        List<com.google.android.flexbox.b> mJC;
        int mJD;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.mJC = null;
            this.mJD = 0;
        }
    }
}
