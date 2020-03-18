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
    private final com.google.android.flexbox.a mLo;
    private boolean[] mLp;
    @Nullable
    int[] mLq;
    @Nullable
    long[] mLr;
    @Nullable
    private long[] mLs;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.mLo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mLo.getFlexItemCount();
        List<b> Mm = Mm(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.mLo.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                Mm.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        Mm.add(bVar);
        return a(flexItemCount + 1, Mm, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mLo.getFlexItemCount();
        return a(flexItemCount, Mm(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> Mm(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.mLo.Mk(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mLo.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View Mk = this.mLo.Mk(i);
            if (Mk != null && ((FlexItem) Mk.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean dAJ = this.mLo.dAJ();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.mLt = list;
        boolean z2 = i5 == -1;
        int wf = wf(dAJ);
        int wg = wg(dAJ);
        int wh = wh(dAJ);
        int wi = wi(dAJ);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.mLm = i4;
        bVar2.mLd = wf + wg;
        int flexItemCount = this.mLo.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View Ml = this.mLo.Ml(i17);
            if (Ml == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (Ml.getVisibility() == 8) {
                bVar2.mLg++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) Ml.getLayoutParams();
                if (flexItem.dAK() == 4) {
                    bVar2.mLl.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, dAJ);
                if (flexItem.dAM() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.dAM());
                }
                if (dAJ) {
                    int an = this.mLo.an(i, wf + wg + c(flexItem, true) + d(flexItem, true), a2);
                    int ao = this.mLo.ao(i2, wh + wi + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    Ml.measure(an, ao);
                    a(i17, an, ao, Ml);
                    i7 = an;
                } else {
                    int an2 = this.mLo.an(i2, wh + wi + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ao2 = this.mLo.ao(i, wf + wg + c(flexItem, false) + d(flexItem, false), a2);
                    Ml.measure(an2, ao2);
                    a(i17, an2, ao2, Ml);
                    i7 = ao2;
                }
                this.mLo.m(i17, Ml);
                y(Ml, i17);
                i6 = View.combineMeasuredStates(i13, Ml.getMeasuredState());
                if (a(Ml, mode, size, bVar2.mLd, d(flexItem, dAJ) + l(Ml, dAJ) + c(flexItem, dAJ), flexItem, i17, i16, list.size())) {
                    if (bVar2.dAQ() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.mLf;
                    } else {
                        i12 = i15;
                    }
                    if (dAJ) {
                        if (flexItem.getHeight() == -1) {
                            Ml.measure(i7, this.mLo.ao(i2, this.mLo.getPaddingTop() + this.mLo.getPaddingBottom() + flexItem.dAN() + flexItem.dAO() + i12, flexItem.getHeight()));
                            y(Ml, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        Ml.measure(this.mLo.an(i2, this.mLo.getPaddingLeft() + this.mLo.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        y(Ml, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.mLd = wf + wg;
                    bVar3.mLm = i17;
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
                if (this.mLq != null) {
                    this.mLq[i17] = list.size();
                }
                bVar.mLd += l(Ml, dAJ) + c(flexItem, dAJ) + d(flexItem, dAJ);
                bVar.mLh += flexItem.getFlexGrow();
                bVar.mLi += flexItem.getFlexShrink();
                this.mLo.a(Ml, i17, i8, bVar);
                i14 = Math.max(i9, m(Ml, dAJ) + e(flexItem, dAJ) + f(flexItem, dAJ) + this.mLo.ds(Ml));
                bVar.mLf = Math.max(bVar.mLf, i14);
                if (dAJ) {
                    if (this.mLo.getFlexWrap() != 2) {
                        bVar.mLj = Math.max(bVar.mLj, Ml.getBaseline() + flexItem.dAN());
                    } else {
                        bVar.mLj = Math.max(bVar.mLj, (Ml.getMeasuredHeight() - Ml.getBaseline()) + flexItem.dAO());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.mLf;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).mLn >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.dAP();
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
        aVar.mLu = i6;
    }

    private int wf(boolean z) {
        return z ? this.mLo.getPaddingStart() : this.mLo.getPaddingTop();
    }

    private int wg(boolean z) {
        return z ? this.mLo.getPaddingEnd() : this.mLo.getPaddingBottom();
    }

    private int wh(boolean z) {
        return z ? this.mLo.getPaddingTop() : this.mLo.getPaddingStart();
    }

    private int wi(boolean z) {
        return z ? this.mLo.getPaddingBottom() : this.mLo.getPaddingEnd();
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
        return z ? flexItem.getMarginLeft() : flexItem.dAN();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.dAO();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.dAN() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.dAO() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.mLo.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.dAL()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.mLo.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int h = this.mLo.h(view, i5, i6);
                if (h > 0) {
                    i4 += h;
                }
                return i2 < i3 + i4;
            }
            return false;
        }
        return false;
    }

    private boolean a(int i, int i2, com.google.android.flexbox.b bVar) {
        return i == i2 + (-1) && bVar.dAQ() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.mLk = i2;
        this.mLo.a(bVar);
        bVar.mLn = i;
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
            this.mLo.m(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ec(int i, int i2) {
        ap(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ap(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        Mn(this.mLo.getFlexItemCount());
        if (i3 < this.mLo.getFlexItemCount()) {
            int flexDirection = this.mLo.getFlexDirection();
            switch (this.mLo.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.mLo.getLargestMainSize();
                    }
                    paddingTop = this.mLo.getPaddingLeft() + this.mLo.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.mLo.getLargestMainSize();
                    }
                    paddingTop = this.mLo.getPaddingTop() + this.mLo.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.mLq != null ? this.mLq[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.mLo.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.mLd < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void Mn(int i) {
        if (this.mLp == null) {
            if (i < 10) {
                i = 10;
            }
            this.mLp = new boolean[i];
        } else if (this.mLp.length < i) {
            int length = this.mLp.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mLp = new boolean[i];
        } else {
            Arrays.fill(this.mLp, false);
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
        if (bVar.mLh > 0.0f && i3 >= bVar.mLd) {
            int i8 = bVar.mLd;
            float f5 = (i3 - bVar.mLd) / bVar.mLh;
            bVar.mLd = bVar.mLe + i4;
            if (!z) {
                bVar.mLf = Integer.MIN_VALUE;
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
                int i12 = bVar.mLm + i11;
                View Ml = this.mLo.Ml(i12);
                if (Ml != null && Ml.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Ml.getLayoutParams();
                    int flexDirection = this.mLo.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Ml.getMeasuredWidth();
                        if (this.mLs != null) {
                            measuredWidth = gP(this.mLs[i12]);
                        }
                        int measuredHeight = Ml.getMeasuredHeight();
                        if (this.mLs != null) {
                            measuredHeight = gQ(this.mLs[i12]);
                        }
                        if (!this.mLp[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mLp[i12] = true;
                                bVar.mLh -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.mLk);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Ml.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Ml.getMeasuredWidth();
                            measuredHeight = Ml.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Ml);
                            this.mLo.m(i12, Ml);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dAN() + flexItem.dAO() + this.mLo.ds(Ml));
                        bVar.mLd = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mLd;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Ml.getMeasuredHeight();
                        if (this.mLs != null) {
                            measuredHeight2 = gQ(this.mLs[i12]);
                        }
                        int measuredWidth3 = Ml.getMeasuredWidth();
                        if (this.mLs != null) {
                            measuredWidth3 = gP(this.mLs[i12]);
                        }
                        if (!this.mLp[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mLp[i12] = true;
                                bVar.mLh -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.mLk);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Ml.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Ml.getMeasuredWidth();
                            int measuredHeight3 = Ml.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Ml);
                            this.mLo.m(i12, Ml);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mLo.ds(Ml));
                        bVar.mLd = flexItem.dAO() + measuredHeight2 + flexItem.dAN() + bVar.mLd;
                        i5 = max2;
                    }
                    bVar.mLf = Math.max(bVar.mLf, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mLd) {
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
        int i8 = bVar.mLd;
        if (bVar.mLi > 0.0f && i3 <= bVar.mLd) {
            float f5 = (bVar.mLd - i3) / bVar.mLi;
            bVar.mLd = bVar.mLe + i4;
            if (!z) {
                bVar.mLf = Integer.MIN_VALUE;
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
                int i12 = bVar.mLm + i11;
                View Ml = this.mLo.Ml(i12);
                if (Ml != null && Ml.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Ml.getLayoutParams();
                    int flexDirection = this.mLo.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Ml.getMeasuredWidth();
                        if (this.mLs != null) {
                            measuredWidth = gP(this.mLs[i12]);
                        }
                        int measuredHeight = Ml.getMeasuredHeight();
                        if (this.mLs != null) {
                            measuredHeight = gQ(this.mLs[i12]);
                        }
                        if (!this.mLp[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mLp[i12] = true;
                                bVar.mLi -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.mLk);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Ml.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Ml.getMeasuredWidth();
                            measuredHeight = Ml.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Ml);
                            this.mLo.m(i12, Ml);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dAN() + flexItem.dAO() + this.mLo.ds(Ml));
                        bVar.mLd = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mLd;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Ml.getMeasuredHeight();
                        if (this.mLs != null) {
                            measuredHeight2 = gQ(this.mLs[i12]);
                        }
                        int measuredWidth3 = Ml.getMeasuredWidth();
                        if (this.mLs != null) {
                            measuredWidth3 = gP(this.mLs[i12]);
                        }
                        if (!this.mLp[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mLp[i12] = true;
                                bVar.mLi -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.mLk);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Ml.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Ml.getMeasuredWidth();
                            int measuredHeight3 = Ml.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Ml);
                            this.mLo.m(i12, Ml);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mLo.ds(Ml));
                        bVar.mLd = flexItem.dAO() + measuredHeight2 + flexItem.dAN() + bVar.mLd;
                        i5 = max2;
                    }
                    bVar.mLf = Math.max(bVar.mLf, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mLd) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int an = this.mLo.an(i, this.mLo.getPaddingLeft() + this.mLo.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
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
        int ao = this.mLo.ao(i, this.mLo.getPaddingTop() + this.mLo.getPaddingBottom() + flexItem.dAN() + flexItem.dAO() + i2, flexItem.getHeight());
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
        int flexDirection = this.mLo.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.mLo.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mLo.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mLf = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.mLo.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.mLf = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.mLo.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.mLf = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.mLf = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.mLf);
                                    if (f > 1.0f) {
                                        bVar2.mLf++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.mLf--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.mLo.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.mLo.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.mLf = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.mLo.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.mLf + size5;
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
                                bVar5.mLf = i4;
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
        bVar.mLf = (i - i2) / 2;
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
    public void dAR() {
        Mo(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mo(int i) {
        View Ml;
        if (i < this.mLo.getFlexItemCount()) {
            int flexDirection = this.mLo.getFlexDirection();
            if (this.mLo.getAlignItems() == 4) {
                int i2 = this.mLq != null ? this.mLq[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.mLo.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.mLm + i5;
                        if (i5 < this.mLo.getFlexItemCount() && (Ml = this.mLo.Ml(i6)) != null && Ml.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) Ml.getLayoutParams();
                            if (flexItem.dAK() == -1 || flexItem.dAK() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        i(Ml, bVar.mLf, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        j(Ml, bVar.mLf, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.mLo.getFlexLinesInternal()) {
                for (Integer num : bVar2.mLl) {
                    View Ml2 = this.mLo.Ml(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            i(Ml2, bVar2.mLf, num.intValue());
                            break;
                        case 2:
                        case 3:
                            j(Ml2, bVar2.mLf, num.intValue());
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                }
            }
        }
    }

    private void i(View view, int i, int i2) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.dAN()) - flexItem.dAO()) - this.mLo.ds(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.mLs != null) {
            measuredWidth = gP(this.mLs[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.mLo.m(i2, view);
    }

    private void j(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mLo.ds(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.mLs != null) {
            measuredHeight = gQ(this.mLs[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.mLo.m(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mLo.getAlignItems();
        if (flexItem.dAK() != -1) {
            alignItems = flexItem.dAK();
        }
        int i5 = bVar.mLf;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.mLo.getFlexWrap() != 2) {
                    view.layout(i, flexItem.dAN() + i2, i3, flexItem.dAN() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.dAO(), i3, i4 - flexItem.dAO());
                    return;
                }
            case 1:
                if (this.mLo.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.dAO(), i3, (i5 + i2) - flexItem.dAO());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.dAN(), i3, flexItem.dAN() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.dAN()) - flexItem.dAO()) / 2;
                if (this.mLo.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.mLo.getFlexWrap() != 2) {
                    int max = Math.max(bVar.mLj - view.getBaseline(), flexItem.dAN());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.mLj - view.getMeasuredHeight()) + view.getBaseline(), flexItem.dAO());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mLo.getAlignItems();
        if (flexItem.dAK() != -1) {
            alignItems = flexItem.dAK();
        }
        int i5 = bVar.mLf;
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
    public void Mp(int i) {
        if (this.mLs == null) {
            if (i < 10) {
                i = 10;
            }
            this.mLs = new long[i];
        } else if (this.mLs.length < i) {
            int length = this.mLs.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mLs = Arrays.copyOf(this.mLs, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mq(int i) {
        if (this.mLr == null) {
            if (i < 10) {
                i = 10;
            }
            this.mLr = new long[i];
        } else if (this.mLr.length < i) {
            int length = this.mLr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mLr = Arrays.copyOf(this.mLr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gP(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gQ(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long ed(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.mLr != null) {
            this.mLr[i] = ed(i2, i3);
        }
        if (this.mLs != null) {
            this.mLs[i] = ed(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mr(int i) {
        if (this.mLq == null) {
            if (i < 10) {
                i = 10;
            }
            this.mLq = new int[i];
        } else if (this.mLq.length < i) {
            int length = this.mLq.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mLq = Arrays.copyOf(this.mLq, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.mLq == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.mLr == null) {
            throw new AssertionError();
        }
        int i2 = this.mLq[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.mLq.length - 1;
        if (i > length) {
            Arrays.fill(this.mLq, -1);
        } else {
            Arrays.fill(this.mLq, i, length, -1);
        }
        int length2 = this.mLr.length - 1;
        if (i > length2) {
            Arrays.fill(this.mLr, 0L);
        } else {
            Arrays.fill(this.mLr, i, length2, 0L);
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
        List<com.google.android.flexbox.b> mLt;
        int mLu;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.mLt = null;
            this.mLu = 0;
        }
    }
}
