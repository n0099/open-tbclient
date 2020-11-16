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
/* loaded from: classes8.dex */
public class c {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final com.google.android.flexbox.a pdf;
    private boolean[] pdg;
    @Nullable
    int[] pdh;
    @Nullable
    long[] pdi;
    @Nullable
    private long[] pdj;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.pdf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.pdf.getFlexItemCount();
        List<b> QA = QA(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.pdf.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                QA.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        QA.add(bVar);
        return a(flexItemCount + 1, QA, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.pdf.getFlexItemCount();
        return a(flexItemCount, QA(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> QA(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.pdf.Qy(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.pdf.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View Qy = this.pdf.Qy(i);
            if (Qy != null && ((FlexItem) Qy.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean esd = this.pdf.esd();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.pdk = list;
        boolean z2 = i5 == -1;
        int AB = AB(esd);
        int AC = AC(esd);
        int AD = AD(esd);
        int AE = AE(esd);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.pdd = i4;
        bVar2.pcU = AB + AC;
        int flexItemCount = this.pdf.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View Qz = this.pdf.Qz(i17);
            if (Qz == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (Qz.getVisibility() == 8) {
                bVar2.pcX++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) Qz.getLayoutParams();
                if (flexItem.esg() == 4) {
                    bVar2.pdc.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, esd);
                if (flexItem.esi() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.esi());
                }
                if (esd) {
                    int ak = this.pdf.ak(i, AB + AC + c(flexItem, true) + d(flexItem, true), a2);
                    int al = this.pdf.al(i2, AD + AE + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    Qz.measure(ak, al);
                    a(i17, ak, al, Qz);
                    i7 = ak;
                } else {
                    int ak2 = this.pdf.ak(i2, AD + AE + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int al2 = this.pdf.al(i, AB + AC + c(flexItem, false) + d(flexItem, false), a2);
                    Qz.measure(ak2, al2);
                    a(i17, ak2, al2, Qz);
                    i7 = al2;
                }
                this.pdf.n(i17, Qz);
                H(Qz, i17);
                i6 = View.combineMeasuredStates(i13, Qz.getMeasuredState());
                if (a(Qz, mode, size, bVar2.pcU, d(flexItem, esd) + p(Qz, esd) + c(flexItem, esd), flexItem, i17, i16, list.size())) {
                    if (bVar2.esm() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.pcW;
                    } else {
                        i12 = i15;
                    }
                    if (esd) {
                        if (flexItem.getHeight() == -1) {
                            Qz.measure(i7, this.pdf.al(i2, this.pdf.getPaddingTop() + this.pdf.getPaddingBottom() + flexItem.esj() + flexItem.esk() + i12, flexItem.getHeight()));
                            H(Qz, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        Qz.measure(this.pdf.ak(i2, this.pdf.getPaddingLeft() + this.pdf.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        H(Qz, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.pcU = AB + AC;
                    bVar3.pdd = i17;
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
                if (this.pdh != null) {
                    this.pdh[i17] = list.size();
                }
                bVar.pcU += p(Qz, esd) + c(flexItem, esd) + d(flexItem, esd);
                bVar.pcY += flexItem.ese();
                bVar.pcZ += flexItem.esf();
                this.pdf.a(Qz, i17, i8, bVar);
                i14 = Math.max(i9, q(Qz, esd) + e(flexItem, esd) + f(flexItem, esd) + this.pdf.ef(Qz));
                bVar.pcW = Math.max(bVar.pcW, i14);
                if (esd) {
                    if (this.pdf.getFlexWrap() != 2) {
                        bVar.pda = Math.max(bVar.pda, Qz.getBaseline() + flexItem.esj());
                    } else {
                        bVar.pda = Math.max(bVar.pda, (Qz.getMeasuredHeight() - Qz.getBaseline()) + flexItem.esk());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.pcW;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).pde >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.esl();
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
        aVar.pdl = i6;
    }

    private int AB(boolean z) {
        return z ? this.pdf.getPaddingStart() : this.pdf.getPaddingTop();
    }

    private int AC(boolean z) {
        return z ? this.pdf.getPaddingEnd() : this.pdf.getPaddingBottom();
    }

    private int AD(boolean z) {
        return z ? this.pdf.getPaddingTop() : this.pdf.getPaddingStart();
    }

    private int AE(boolean z) {
        return z ? this.pdf.getPaddingBottom() : this.pdf.getPaddingEnd();
    }

    private int p(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int q(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int a(FlexItem flexItem, boolean z) {
        return z ? flexItem.getWidth() : flexItem.getHeight();
    }

    private int b(FlexItem flexItem, boolean z) {
        return z ? flexItem.getHeight() : flexItem.getWidth();
    }

    private int c(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginLeft() : flexItem.esj();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.esk();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.esj() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.esk() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.pdf.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.esh()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.pdf.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int k = this.pdf.k(view, i5, i6);
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
        return i == i2 + (-1) && bVar.esm() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.pdb = i2;
        this.pdf.a(bVar);
        bVar.pde = i;
        list.add(bVar);
    }

    private void H(View view, int i) {
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
            this.pdf.n(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ed(int i, int i2) {
        am(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void am(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        QB(this.pdf.getFlexItemCount());
        if (i3 < this.pdf.getFlexItemCount()) {
            int flexDirection = this.pdf.getFlexDirection();
            switch (this.pdf.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.pdf.getLargestMainSize();
                    }
                    paddingTop = this.pdf.getPaddingLeft() + this.pdf.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.pdf.getLargestMainSize();
                    }
                    paddingTop = this.pdf.getPaddingTop() + this.pdf.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.pdh != null ? this.pdh[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.pdf.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.pcU < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void QB(int i) {
        if (this.pdg == null) {
            if (i < 10) {
                i = 10;
            }
            this.pdg = new boolean[i];
        } else if (this.pdg.length < i) {
            int length = this.pdg.length * 2;
            if (length >= i) {
                i = length;
            }
            this.pdg = new boolean[i];
        } else {
            Arrays.fill(this.pdg, false);
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
        if (bVar.pcY > 0.0f && i3 >= bVar.pcU) {
            int i8 = bVar.pcU;
            float f5 = (i3 - bVar.pcU) / bVar.pcY;
            bVar.pcU = bVar.pcV + i4;
            if (!z) {
                bVar.pcW = Integer.MIN_VALUE;
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
                int i12 = bVar.pdd + i11;
                View Qz = this.pdf.Qz(i12);
                if (Qz != null && Qz.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Qz.getLayoutParams();
                    int flexDirection = this.pdf.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Qz.getMeasuredWidth();
                        if (this.pdj != null) {
                            measuredWidth = hU(this.pdj[i12]);
                        }
                        int measuredHeight = Qz.getMeasuredHeight();
                        if (this.pdj != null) {
                            measuredHeight = hV(this.pdj[i12]);
                        }
                        if (!this.pdg[i12] && flexItem.ese() > 0.0f) {
                            float ese = measuredWidth + (flexItem.ese() * f5);
                            if (i11 == bVar.mItemCount - 1) {
                                f2 = f6 + ese;
                                f = 0.0f;
                            } else {
                                f = f6;
                                f2 = ese;
                            }
                            int round = Math.round(f2);
                            if (round > flexItem.getMaxWidth()) {
                                z2 = true;
                                i6 = flexItem.getMaxWidth();
                                this.pdg[i12] = true;
                                bVar.pcY -= flexItem.ese();
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
                            int b2 = b(i2, flexItem, bVar.pdb);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Qz.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Qz.getMeasuredWidth();
                            measuredHeight = Qz.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Qz);
                            this.pdf.n(i12, Qz);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.esj() + flexItem.esk() + this.pdf.ef(Qz));
                        bVar.pcU = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.pcU;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Qz.getMeasuredHeight();
                        if (this.pdj != null) {
                            measuredHeight2 = hV(this.pdj[i12]);
                        }
                        int measuredWidth3 = Qz.getMeasuredWidth();
                        if (this.pdj != null) {
                            measuredWidth3 = hU(this.pdj[i12]);
                        }
                        if (!this.pdg[i12] && flexItem.ese() > 0.0f) {
                            float ese2 = measuredHeight2 + (flexItem.ese() * f5);
                            if (i11 == bVar.mItemCount - 1) {
                                f4 = f6 + ese2;
                                f3 = 0.0f;
                            } else {
                                f3 = f6;
                                f4 = ese2;
                            }
                            int round2 = Math.round(f4);
                            if (round2 > flexItem.getMaxHeight()) {
                                z2 = true;
                                i7 = flexItem.getMaxHeight();
                                this.pdg[i12] = true;
                                bVar.pcY -= flexItem.ese();
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
                            int a2 = a(i, flexItem, bVar.pdb);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Qz.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Qz.getMeasuredWidth();
                            int measuredHeight3 = Qz.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Qz);
                            this.pdf.n(i12, Qz);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.pdf.ef(Qz));
                        bVar.pcU = flexItem.esk() + measuredHeight2 + flexItem.esj() + bVar.pcU;
                        i5 = max2;
                    }
                    bVar.pcW = Math.max(bVar.pcW, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.pcU) {
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
        int i8 = bVar.pcU;
        if (bVar.pcZ > 0.0f && i3 <= bVar.pcU) {
            float f5 = (bVar.pcU - i3) / bVar.pcZ;
            bVar.pcU = bVar.pcV + i4;
            if (!z) {
                bVar.pcW = Integer.MIN_VALUE;
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
                int i12 = bVar.pdd + i11;
                View Qz = this.pdf.Qz(i12);
                if (Qz != null && Qz.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Qz.getLayoutParams();
                    int flexDirection = this.pdf.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Qz.getMeasuredWidth();
                        if (this.pdj != null) {
                            measuredWidth = hU(this.pdj[i12]);
                        }
                        int measuredHeight = Qz.getMeasuredHeight();
                        if (this.pdj != null) {
                            measuredHeight = hV(this.pdj[i12]);
                        }
                        if (!this.pdg[i12] && flexItem.esf() > 0.0f) {
                            float esf = measuredWidth - (flexItem.esf() * f5);
                            if (i11 == bVar.mItemCount - 1) {
                                f2 = f6 + esf;
                                f = 0.0f;
                            } else {
                                f = f6;
                                f2 = esf;
                            }
                            int round = Math.round(f2);
                            if (round < flexItem.getMinWidth()) {
                                z2 = true;
                                i6 = flexItem.getMinWidth();
                                this.pdg[i12] = true;
                                bVar.pcZ -= flexItem.esf();
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
                            int b2 = b(i2, flexItem, bVar.pdb);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Qz.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Qz.getMeasuredWidth();
                            measuredHeight = Qz.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Qz);
                            this.pdf.n(i12, Qz);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.esj() + flexItem.esk() + this.pdf.ef(Qz));
                        bVar.pcU = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.pcU;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Qz.getMeasuredHeight();
                        if (this.pdj != null) {
                            measuredHeight2 = hV(this.pdj[i12]);
                        }
                        int measuredWidth3 = Qz.getMeasuredWidth();
                        if (this.pdj != null) {
                            measuredWidth3 = hU(this.pdj[i12]);
                        }
                        if (!this.pdg[i12] && flexItem.esf() > 0.0f) {
                            float esf2 = measuredHeight2 - (flexItem.esf() * f5);
                            if (i11 == bVar.mItemCount - 1) {
                                f4 = f6 + esf2;
                                f3 = 0.0f;
                            } else {
                                f3 = f6;
                                f4 = esf2;
                            }
                            int round2 = Math.round(f4);
                            if (round2 < flexItem.getMinHeight()) {
                                z2 = true;
                                i7 = flexItem.getMinHeight();
                                this.pdg[i12] = true;
                                bVar.pcZ -= flexItem.esf();
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
                            int a2 = a(i, flexItem, bVar.pdb);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Qz.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Qz.getMeasuredWidth();
                            int measuredHeight3 = Qz.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Qz);
                            this.pdf.n(i12, Qz);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.pdf.ef(Qz));
                        bVar.pcU = flexItem.esk() + measuredHeight2 + flexItem.esj() + bVar.pcU;
                        i5 = max2;
                    }
                    bVar.pcW = Math.max(bVar.pcW, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.pcU) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int ak = this.pdf.ak(i, this.pdf.getPaddingLeft() + this.pdf.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(ak);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(ak));
        }
        if (size < flexItem.getMinWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(ak));
        }
        return ak;
    }

    private int b(int i, FlexItem flexItem, int i2) {
        int al = this.pdf.al(i, this.pdf.getPaddingTop() + this.pdf.getPaddingBottom() + flexItem.esj() + flexItem.esk() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(al);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(al));
        }
        if (size < flexItem.getMinHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(al));
        }
        return al;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void an(int i, int i2, int i3) {
        int mode;
        int size;
        float f;
        float f2;
        int i4;
        int flexDirection = this.pdf.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.pdf.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.pdf.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).pcW = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.pdf.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.pcW = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.pdf.setFlexLines(j(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.pcW = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.pcW = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.pcW);
                                    if (f > 1.0f) {
                                        bVar2.pcW++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.pcW--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.pdf.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.pdf.setFlexLines(j(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.pcW = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.pdf.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.pcW + size5;
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
                                bVar5.pcW = i4;
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
        bVar.pcW = (i - i2) / 2;
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
    public void esn() {
        QC(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void QC(int i) {
        View Qz;
        if (i < this.pdf.getFlexItemCount()) {
            int flexDirection = this.pdf.getFlexDirection();
            if (this.pdf.getAlignItems() == 4) {
                int i2 = this.pdh != null ? this.pdh[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.pdf.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.pdd + i5;
                        if (i5 < this.pdf.getFlexItemCount() && (Qz = this.pdf.Qz(i6)) != null && Qz.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) Qz.getLayoutParams();
                            if (flexItem.esg() == -1 || flexItem.esg() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        l(Qz, bVar.pcW, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        m(Qz, bVar.pcW, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.pdf.getFlexLinesInternal()) {
                for (Integer num : bVar2.pdc) {
                    View Qz2 = this.pdf.Qz(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            l(Qz2, bVar2.pcW, num.intValue());
                            break;
                        case 2:
                        case 3:
                            m(Qz2, bVar2.pcW, num.intValue());
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
        int min = Math.min(Math.max(((i - flexItem.esj()) - flexItem.esk()) - this.pdf.ef(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.pdj != null) {
            measuredWidth = hU(this.pdj[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.pdf.n(i2, view);
    }

    private void m(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.pdf.ef(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.pdj != null) {
            measuredHeight = hV(this.pdj[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.pdf.n(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.pdf.getAlignItems();
        if (flexItem.esg() != -1) {
            alignItems = flexItem.esg();
        }
        int i5 = bVar.pcW;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.pdf.getFlexWrap() != 2) {
                    view.layout(i, flexItem.esj() + i2, i3, flexItem.esj() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.esk(), i3, i4 - flexItem.esk());
                    return;
                }
            case 1:
                if (this.pdf.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.esk(), i3, (i5 + i2) - flexItem.esk());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.esj(), i3, flexItem.esj() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.esj()) - flexItem.esk()) / 2;
                if (this.pdf.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.pdf.getFlexWrap() != 2) {
                    int max = Math.max(bVar.pda - view.getBaseline(), flexItem.esj());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.pda - view.getMeasuredHeight()) + view.getBaseline(), flexItem.esk());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.pdf.getAlignItems();
        if (flexItem.esg() != -1) {
            alignItems = flexItem.esg();
        }
        int i5 = bVar.pcW;
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
    public void QD(int i) {
        if (this.pdj == null) {
            if (i < 10) {
                i = 10;
            }
            this.pdj = new long[i];
        } else if (this.pdj.length < i) {
            int length = this.pdj.length * 2;
            if (length >= i) {
                i = length;
            }
            this.pdj = Arrays.copyOf(this.pdj, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void QE(int i) {
        if (this.pdi == null) {
            if (i < 10) {
                i = 10;
            }
            this.pdi = new long[i];
        } else if (this.pdi.length < i) {
            int length = this.pdi.length * 2;
            if (length >= i) {
                i = length;
            }
            this.pdi = Arrays.copyOf(this.pdi, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int hU(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int hV(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long ee(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.pdi != null) {
            this.pdi[i] = ee(i2, i3);
        }
        if (this.pdj != null) {
            this.pdj[i] = ee(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void QF(int i) {
        if (this.pdh == null) {
            if (i < 10) {
                i = 10;
            }
            this.pdh = new int[i];
        } else if (this.pdh.length < i) {
            int length = this.pdh.length * 2;
            if (length >= i) {
                i = length;
            }
            this.pdh = Arrays.copyOf(this.pdh, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.pdh == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.pdi == null) {
            throw new AssertionError();
        }
        int i2 = this.pdh[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.pdh.length - 1;
        if (i > length) {
            Arrays.fill(this.pdh, -1);
        } else {
            Arrays.fill(this.pdh, i, length, -1);
        }
        int length2 = this.pdi.length - 1;
        if (i > length2) {
            Arrays.fill(this.pdi, 0L);
        } else {
            Arrays.fill(this.pdi, i, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
    public static class a {
        List<com.google.android.flexbox.b> pdk;
        int pdl;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.pdk = null;
            this.pdl = 0;
        }
    }
}
