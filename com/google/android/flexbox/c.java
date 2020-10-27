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
    private final com.google.android.flexbox.a oSh;
    private boolean[] oSi;
    @Nullable
    int[] oSj;
    @Nullable
    long[] oSk;
    @Nullable
    private long[] oSl;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.oSh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.oSh.getFlexItemCount();
        List<b> PC = PC(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.oSh.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                PC.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        PC.add(bVar);
        return a(flexItemCount + 1, PC, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.oSh.getFlexItemCount();
        return a(flexItemCount, PC(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> PC(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.oSh.PA(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.oSh.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View PA = this.oSh.PA(i);
            if (PA != null && ((FlexItem) PA.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean eoq = this.oSh.eoq();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.oSm = list;
        boolean z2 = i5 == -1;
        int Aj = Aj(eoq);
        int Ak = Ak(eoq);
        int Al = Al(eoq);
        int Am = Am(eoq);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.oSf = i4;
        bVar2.oRW = Aj + Ak;
        int flexItemCount = this.oSh.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View PB = this.oSh.PB(i17);
            if (PB == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (PB.getVisibility() == 8) {
                bVar2.oRZ++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) PB.getLayoutParams();
                if (flexItem.eor() == 4) {
                    bVar2.oSe.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, eoq);
                if (flexItem.eot() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.eot());
                }
                if (eoq) {
                    int ah = this.oSh.ah(i, Aj + Ak + c(flexItem, true) + d(flexItem, true), a2);
                    int ai = this.oSh.ai(i2, Al + Am + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    PB.measure(ah, ai);
                    a(i17, ah, ai, PB);
                    i7 = ah;
                } else {
                    int ah2 = this.oSh.ah(i2, Al + Am + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ai2 = this.oSh.ai(i, Aj + Ak + c(flexItem, false) + d(flexItem, false), a2);
                    PB.measure(ah2, ai2);
                    a(i17, ah2, ai2, PB);
                    i7 = ai2;
                }
                this.oSh.n(i17, PB);
                F(PB, i17);
                i6 = View.combineMeasuredStates(i13, PB.getMeasuredState());
                if (a(PB, mode, size, bVar2.oRW, d(flexItem, eoq) + n(PB, eoq) + c(flexItem, eoq), flexItem, i17, i16, list.size())) {
                    if (bVar2.eox() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.oRY;
                    } else {
                        i12 = i15;
                    }
                    if (eoq) {
                        if (flexItem.getHeight() == -1) {
                            PB.measure(i7, this.oSh.ai(i2, this.oSh.getPaddingTop() + this.oSh.getPaddingBottom() + flexItem.eou() + flexItem.eov() + i12, flexItem.getHeight()));
                            F(PB, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        PB.measure(this.oSh.ah(i2, this.oSh.getPaddingLeft() + this.oSh.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        F(PB, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.oRW = Aj + Ak;
                    bVar3.oSf = i17;
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
                if (this.oSj != null) {
                    this.oSj[i17] = list.size();
                }
                bVar.oRW += n(PB, eoq) + c(flexItem, eoq) + d(flexItem, eoq);
                bVar.oSa += flexItem.getFlexGrow();
                bVar.oSb += flexItem.getFlexShrink();
                this.oSh.a(PB, i17, i8, bVar);
                i14 = Math.max(i9, o(PB, eoq) + e(flexItem, eoq) + f(flexItem, eoq) + this.oSh.dQ(PB));
                bVar.oRY = Math.max(bVar.oRY, i14);
                if (eoq) {
                    if (this.oSh.getFlexWrap() != 2) {
                        bVar.oSc = Math.max(bVar.oSc, PB.getBaseline() + flexItem.eou());
                    } else {
                        bVar.oSc = Math.max(bVar.oSc, (PB.getMeasuredHeight() - PB.getBaseline()) + flexItem.eov());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.oRY;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).oSg >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.eow();
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
        aVar.oSn = i6;
    }

    private int Aj(boolean z) {
        return z ? this.oSh.getPaddingStart() : this.oSh.getPaddingTop();
    }

    private int Ak(boolean z) {
        return z ? this.oSh.getPaddingEnd() : this.oSh.getPaddingBottom();
    }

    private int Al(boolean z) {
        return z ? this.oSh.getPaddingTop() : this.oSh.getPaddingStart();
    }

    private int Am(boolean z) {
        return z ? this.oSh.getPaddingBottom() : this.oSh.getPaddingEnd();
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
        return z ? flexItem.getMarginLeft() : flexItem.eou();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.eov();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.eou() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.eov() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.oSh.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.eos()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.oSh.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int j = this.oSh.j(view, i5, i6);
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
        return i == i2 + (-1) && bVar.eox() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.oSd = i2;
        this.oSh.a(bVar);
        bVar.oSg = i;
        list.add(bVar);
    }

    private void F(View view, int i) {
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
            this.oSh.n(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZ(int i, int i2) {
        aj(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        PD(this.oSh.getFlexItemCount());
        if (i3 < this.oSh.getFlexItemCount()) {
            int flexDirection = this.oSh.getFlexDirection();
            switch (this.oSh.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.oSh.getLargestMainSize();
                    }
                    paddingTop = this.oSh.getPaddingLeft() + this.oSh.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.oSh.getLargestMainSize();
                    }
                    paddingTop = this.oSh.getPaddingTop() + this.oSh.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.oSj != null ? this.oSj[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.oSh.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.oRW < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void PD(int i) {
        if (this.oSi == null) {
            if (i < 10) {
                i = 10;
            }
            this.oSi = new boolean[i];
        } else if (this.oSi.length < i) {
            int length = this.oSi.length * 2;
            if (length >= i) {
                i = length;
            }
            this.oSi = new boolean[i];
        } else {
            Arrays.fill(this.oSi, false);
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
        if (bVar.oSa > 0.0f && i3 >= bVar.oRW) {
            int i8 = bVar.oRW;
            float f5 = (i3 - bVar.oRW) / bVar.oSa;
            bVar.oRW = bVar.oRX + i4;
            if (!z) {
                bVar.oRY = Integer.MIN_VALUE;
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
                int i12 = bVar.oSf + i11;
                View PB = this.oSh.PB(i12);
                if (PB != null && PB.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) PB.getLayoutParams();
                    int flexDirection = this.oSh.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = PB.getMeasuredWidth();
                        if (this.oSl != null) {
                            measuredWidth = hv(this.oSl[i12]);
                        }
                        int measuredHeight = PB.getMeasuredHeight();
                        if (this.oSl != null) {
                            measuredHeight = hw(this.oSl[i12]);
                        }
                        if (!this.oSi[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.oSi[i12] = true;
                                bVar.oSa -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.oSd);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            PB.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = PB.getMeasuredWidth();
                            measuredHeight = PB.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, PB);
                            this.oSh.n(i12, PB);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.eou() + flexItem.eov() + this.oSh.dQ(PB));
                        bVar.oRW = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.oRW;
                        i5 = max;
                    } else {
                        int measuredHeight2 = PB.getMeasuredHeight();
                        if (this.oSl != null) {
                            measuredHeight2 = hw(this.oSl[i12]);
                        }
                        int measuredWidth3 = PB.getMeasuredWidth();
                        if (this.oSl != null) {
                            measuredWidth3 = hv(this.oSl[i12]);
                        }
                        if (!this.oSi[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.oSi[i12] = true;
                                bVar.oSa -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.oSd);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            PB.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = PB.getMeasuredWidth();
                            int measuredHeight3 = PB.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, PB);
                            this.oSh.n(i12, PB);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.oSh.dQ(PB));
                        bVar.oRW = flexItem.eov() + measuredHeight2 + flexItem.eou() + bVar.oRW;
                        i5 = max2;
                    }
                    bVar.oRY = Math.max(bVar.oRY, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.oRW) {
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
        int i8 = bVar.oRW;
        if (bVar.oSb > 0.0f && i3 <= bVar.oRW) {
            float f5 = (bVar.oRW - i3) / bVar.oSb;
            bVar.oRW = bVar.oRX + i4;
            if (!z) {
                bVar.oRY = Integer.MIN_VALUE;
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
                int i12 = bVar.oSf + i11;
                View PB = this.oSh.PB(i12);
                if (PB != null && PB.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) PB.getLayoutParams();
                    int flexDirection = this.oSh.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = PB.getMeasuredWidth();
                        if (this.oSl != null) {
                            measuredWidth = hv(this.oSl[i12]);
                        }
                        int measuredHeight = PB.getMeasuredHeight();
                        if (this.oSl != null) {
                            measuredHeight = hw(this.oSl[i12]);
                        }
                        if (!this.oSi[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.oSi[i12] = true;
                                bVar.oSb -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.oSd);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            PB.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = PB.getMeasuredWidth();
                            measuredHeight = PB.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, PB);
                            this.oSh.n(i12, PB);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.eou() + flexItem.eov() + this.oSh.dQ(PB));
                        bVar.oRW = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.oRW;
                        i5 = max;
                    } else {
                        int measuredHeight2 = PB.getMeasuredHeight();
                        if (this.oSl != null) {
                            measuredHeight2 = hw(this.oSl[i12]);
                        }
                        int measuredWidth3 = PB.getMeasuredWidth();
                        if (this.oSl != null) {
                            measuredWidth3 = hv(this.oSl[i12]);
                        }
                        if (!this.oSi[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.oSi[i12] = true;
                                bVar.oSb -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.oSd);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            PB.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = PB.getMeasuredWidth();
                            int measuredHeight3 = PB.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, PB);
                            this.oSh.n(i12, PB);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.oSh.dQ(PB));
                        bVar.oRW = flexItem.eov() + measuredHeight2 + flexItem.eou() + bVar.oRW;
                        i5 = max2;
                    }
                    bVar.oRY = Math.max(bVar.oRY, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.oRW) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int ah = this.oSh.ah(i, this.oSh.getPaddingLeft() + this.oSh.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(ah);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(ah));
        }
        if (size < flexItem.getMinWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(ah));
        }
        return ah;
    }

    private int b(int i, FlexItem flexItem, int i2) {
        int ai = this.oSh.ai(i, this.oSh.getPaddingTop() + this.oSh.getPaddingBottom() + flexItem.eou() + flexItem.eov() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(ai);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(ai));
        }
        if (size < flexItem.getMinHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(ai));
        }
        return ai;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ak(int i, int i2, int i3) {
        int mode;
        int size;
        float f;
        float f2;
        int i4;
        int flexDirection = this.oSh.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.oSh.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.oSh.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).oRY = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.oSh.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.oRY = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.oSh.setFlexLines(j(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.oRY = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.oRY = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.oRY);
                                    if (f > 1.0f) {
                                        bVar2.oRY++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.oRY--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.oSh.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.oSh.setFlexLines(j(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.oRY = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.oSh.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.oRY + size5;
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
                                bVar5.oRY = i4;
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

    private List<com.google.android.flexbox.b> j(List<com.google.android.flexbox.b> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
        bVar.oRY = (i - i2) / 2;
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
    public void eoy() {
        PE(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PE(int i) {
        View PB;
        if (i < this.oSh.getFlexItemCount()) {
            int flexDirection = this.oSh.getFlexDirection();
            if (this.oSh.getAlignItems() == 4) {
                int i2 = this.oSj != null ? this.oSj[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.oSh.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.oSf + i5;
                        if (i5 < this.oSh.getFlexItemCount() && (PB = this.oSh.PB(i6)) != null && PB.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) PB.getLayoutParams();
                            if (flexItem.eor() == -1 || flexItem.eor() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        k(PB, bVar.oRY, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        l(PB, bVar.oRY, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.oSh.getFlexLinesInternal()) {
                for (Integer num : bVar2.oSe) {
                    View PB2 = this.oSh.PB(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            k(PB2, bVar2.oRY, num.intValue());
                            break;
                        case 2:
                        case 3:
                            l(PB2, bVar2.oRY, num.intValue());
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
        int min = Math.min(Math.max(((i - flexItem.eou()) - flexItem.eov()) - this.oSh.dQ(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.oSl != null) {
            measuredWidth = hv(this.oSl[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.oSh.n(i2, view);
    }

    private void l(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.oSh.dQ(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.oSl != null) {
            measuredHeight = hw(this.oSl[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.oSh.n(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.oSh.getAlignItems();
        if (flexItem.eor() != -1) {
            alignItems = flexItem.eor();
        }
        int i5 = bVar.oRY;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.oSh.getFlexWrap() != 2) {
                    view.layout(i, flexItem.eou() + i2, i3, flexItem.eou() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.eov(), i3, i4 - flexItem.eov());
                    return;
                }
            case 1:
                if (this.oSh.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.eov(), i3, (i5 + i2) - flexItem.eov());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.eou(), i3, flexItem.eou() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.eou()) - flexItem.eov()) / 2;
                if (this.oSh.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.oSh.getFlexWrap() != 2) {
                    int max = Math.max(bVar.oSc - view.getBaseline(), flexItem.eou());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.oSc - view.getMeasuredHeight()) + view.getBaseline(), flexItem.eov());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.oSh.getAlignItems();
        if (flexItem.eor() != -1) {
            alignItems = flexItem.eor();
        }
        int i5 = bVar.oRY;
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
    public void PF(int i) {
        if (this.oSl == null) {
            if (i < 10) {
                i = 10;
            }
            this.oSl = new long[i];
        } else if (this.oSl.length < i) {
            int length = this.oSl.length * 2;
            if (length >= i) {
                i = length;
            }
            this.oSl = Arrays.copyOf(this.oSl, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PG(int i) {
        if (this.oSk == null) {
            if (i < 10) {
                i = 10;
            }
            this.oSk = new long[i];
        } else if (this.oSk.length < i) {
            int length = this.oSk.length * 2;
            if (length >= i) {
                i = length;
            }
            this.oSk = Arrays.copyOf(this.oSk, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int hv(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int hw(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long ea(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.oSk != null) {
            this.oSk[i] = ea(i2, i3);
        }
        if (this.oSl != null) {
            this.oSl[i] = ea(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PH(int i) {
        if (this.oSj == null) {
            if (i < 10) {
                i = 10;
            }
            this.oSj = new int[i];
        } else if (this.oSj.length < i) {
            int length = this.oSj.length * 2;
            if (length >= i) {
                i = length;
            }
            this.oSj = Arrays.copyOf(this.oSj, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.oSj == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.oSk == null) {
            throw new AssertionError();
        }
        int i2 = this.oSj[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.oSj.length - 1;
        if (i > length) {
            Arrays.fill(this.oSj, -1);
        } else {
            Arrays.fill(this.oSj, i, length, -1);
        }
        int length2 = this.oSk.length - 1;
        if (i > length2) {
            Arrays.fill(this.oSk, 0L);
        } else {
            Arrays.fill(this.oSk, i, length2, 0L);
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
        List<com.google.android.flexbox.b> oSm;
        int oSn;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.oSm = null;
            this.oSn = 0;
        }
    }
}
