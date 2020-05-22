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
/* loaded from: classes5.dex */
public class c {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final com.google.android.flexbox.a mBT;
    private boolean[] mBU;
    @Nullable
    int[] mBV;
    @Nullable
    long[] mBW;
    @Nullable
    private long[] mBX;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.mBT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mBT.getFlexItemCount();
        List<b> Is = Is(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.mBT.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                Is.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        Is.add(bVar);
        return a(flexItemCount + 1, Is, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mBT.getFlexItemCount();
        return a(flexItemCount, Is(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> Is(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.mBT.Iq(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mBT.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View Iq = this.mBT.Iq(i);
            if (Iq != null && ((FlexItem) Iq.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean dCq = this.mBT.dCq();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.mBY = list;
        boolean z2 = i5 == -1;
        int wp = wp(dCq);
        int wq = wq(dCq);
        int wr = wr(dCq);
        int ws = ws(dCq);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.mBR = i4;
        bVar2.mBI = wp + wq;
        int flexItemCount = this.mBT.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View Ir = this.mBT.Ir(i17);
            if (Ir == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (Ir.getVisibility() == 8) {
                bVar2.mBL++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) Ir.getLayoutParams();
                if (flexItem.dCr() == 4) {
                    bVar2.mBQ.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, dCq);
                if (flexItem.dCt() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.dCt());
                }
                if (dCq) {
                    int ag = this.mBT.ag(i, wp + wq + c(flexItem, true) + d(flexItem, true), a2);
                    int ah = this.mBT.ah(i2, wr + ws + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    Ir.measure(ag, ah);
                    a(i17, ag, ah, Ir);
                    i7 = ag;
                } else {
                    int ag2 = this.mBT.ag(i2, wr + ws + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ah2 = this.mBT.ah(i, wp + wq + c(flexItem, false) + d(flexItem, false), a2);
                    Ir.measure(ag2, ah2);
                    a(i17, ag2, ah2, Ir);
                    i7 = ah2;
                }
                this.mBT.l(i17, Ir);
                y(Ir, i17);
                i6 = View.combineMeasuredStates(i13, Ir.getMeasuredState());
                if (a(Ir, mode, size, bVar2.mBI, d(flexItem, dCq) + n(Ir, dCq) + c(flexItem, dCq), flexItem, i17, i16, list.size())) {
                    if (bVar2.dCx() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.mBK;
                    } else {
                        i12 = i15;
                    }
                    if (dCq) {
                        if (flexItem.getHeight() == -1) {
                            Ir.measure(i7, this.mBT.ah(i2, this.mBT.getPaddingTop() + this.mBT.getPaddingBottom() + flexItem.dCu() + flexItem.dCv() + i12, flexItem.getHeight()));
                            y(Ir, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        Ir.measure(this.mBT.ag(i2, this.mBT.getPaddingLeft() + this.mBT.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        y(Ir, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.mBI = wp + wq;
                    bVar3.mBR = i17;
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
                if (this.mBV != null) {
                    this.mBV[i17] = list.size();
                }
                bVar.mBI += n(Ir, dCq) + c(flexItem, dCq) + d(flexItem, dCq);
                bVar.mBM += flexItem.getFlexGrow();
                bVar.mBN += flexItem.getFlexShrink();
                this.mBT.a(Ir, i17, i8, bVar);
                i14 = Math.max(i9, o(Ir, dCq) + e(flexItem, dCq) + f(flexItem, dCq) + this.mBT.dk(Ir));
                bVar.mBK = Math.max(bVar.mBK, i14);
                if (dCq) {
                    if (this.mBT.getFlexWrap() != 2) {
                        bVar.mBO = Math.max(bVar.mBO, Ir.getBaseline() + flexItem.dCu());
                    } else {
                        bVar.mBO = Math.max(bVar.mBO, (Ir.getMeasuredHeight() - Ir.getBaseline()) + flexItem.dCv());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.mBK;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).mBS >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.dCw();
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
        aVar.mBZ = i6;
    }

    private int wp(boolean z) {
        return z ? this.mBT.getPaddingStart() : this.mBT.getPaddingTop();
    }

    private int wq(boolean z) {
        return z ? this.mBT.getPaddingEnd() : this.mBT.getPaddingBottom();
    }

    private int wr(boolean z) {
        return z ? this.mBT.getPaddingTop() : this.mBT.getPaddingStart();
    }

    private int ws(boolean z) {
        return z ? this.mBT.getPaddingBottom() : this.mBT.getPaddingEnd();
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
        return z ? flexItem.getMarginLeft() : flexItem.dCu();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.dCv();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.dCu() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.dCv() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.mBT.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.dCs()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.mBT.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int j = this.mBT.j(view, i5, i6);
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
        return i == i2 + (-1) && bVar.dCx() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.mBP = i2;
        this.mBT.a(bVar);
        bVar.mBS = i;
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
            this.mBT.l(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dt(int i, int i2) {
        ai(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        It(this.mBT.getFlexItemCount());
        if (i3 < this.mBT.getFlexItemCount()) {
            int flexDirection = this.mBT.getFlexDirection();
            switch (this.mBT.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.mBT.getLargestMainSize();
                    }
                    paddingTop = this.mBT.getPaddingLeft() + this.mBT.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.mBT.getLargestMainSize();
                    }
                    paddingTop = this.mBT.getPaddingTop() + this.mBT.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.mBV != null ? this.mBV[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.mBT.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.mBI < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void It(int i) {
        if (this.mBU == null) {
            if (i < 10) {
                i = 10;
            }
            this.mBU = new boolean[i];
        } else if (this.mBU.length < i) {
            int length = this.mBU.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mBU = new boolean[i];
        } else {
            Arrays.fill(this.mBU, false);
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
        if (bVar.mBM > 0.0f && i3 >= bVar.mBI) {
            int i8 = bVar.mBI;
            float f5 = (i3 - bVar.mBI) / bVar.mBM;
            bVar.mBI = bVar.mBJ + i4;
            if (!z) {
                bVar.mBK = Integer.MIN_VALUE;
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
                int i12 = bVar.mBR + i11;
                View Ir = this.mBT.Ir(i12);
                if (Ir != null && Ir.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Ir.getLayoutParams();
                    int flexDirection = this.mBT.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Ir.getMeasuredWidth();
                        if (this.mBX != null) {
                            measuredWidth = fS(this.mBX[i12]);
                        }
                        int measuredHeight = Ir.getMeasuredHeight();
                        if (this.mBX != null) {
                            measuredHeight = fT(this.mBX[i12]);
                        }
                        if (!this.mBU[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mBU[i12] = true;
                                bVar.mBM -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.mBP);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Ir.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Ir.getMeasuredWidth();
                            measuredHeight = Ir.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Ir);
                            this.mBT.l(i12, Ir);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dCu() + flexItem.dCv() + this.mBT.dk(Ir));
                        bVar.mBI = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mBI;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Ir.getMeasuredHeight();
                        if (this.mBX != null) {
                            measuredHeight2 = fT(this.mBX[i12]);
                        }
                        int measuredWidth3 = Ir.getMeasuredWidth();
                        if (this.mBX != null) {
                            measuredWidth3 = fS(this.mBX[i12]);
                        }
                        if (!this.mBU[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mBU[i12] = true;
                                bVar.mBM -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.mBP);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Ir.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Ir.getMeasuredWidth();
                            int measuredHeight3 = Ir.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Ir);
                            this.mBT.l(i12, Ir);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mBT.dk(Ir));
                        bVar.mBI = flexItem.dCv() + measuredHeight2 + flexItem.dCu() + bVar.mBI;
                        i5 = max2;
                    }
                    bVar.mBK = Math.max(bVar.mBK, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mBI) {
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
        int i8 = bVar.mBI;
        if (bVar.mBN > 0.0f && i3 <= bVar.mBI) {
            float f5 = (bVar.mBI - i3) / bVar.mBN;
            bVar.mBI = bVar.mBJ + i4;
            if (!z) {
                bVar.mBK = Integer.MIN_VALUE;
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
                int i12 = bVar.mBR + i11;
                View Ir = this.mBT.Ir(i12);
                if (Ir != null && Ir.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Ir.getLayoutParams();
                    int flexDirection = this.mBT.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Ir.getMeasuredWidth();
                        if (this.mBX != null) {
                            measuredWidth = fS(this.mBX[i12]);
                        }
                        int measuredHeight = Ir.getMeasuredHeight();
                        if (this.mBX != null) {
                            measuredHeight = fT(this.mBX[i12]);
                        }
                        if (!this.mBU[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mBU[i12] = true;
                                bVar.mBN -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.mBP);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Ir.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Ir.getMeasuredWidth();
                            measuredHeight = Ir.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Ir);
                            this.mBT.l(i12, Ir);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dCu() + flexItem.dCv() + this.mBT.dk(Ir));
                        bVar.mBI = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mBI;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Ir.getMeasuredHeight();
                        if (this.mBX != null) {
                            measuredHeight2 = fT(this.mBX[i12]);
                        }
                        int measuredWidth3 = Ir.getMeasuredWidth();
                        if (this.mBX != null) {
                            measuredWidth3 = fS(this.mBX[i12]);
                        }
                        if (!this.mBU[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mBU[i12] = true;
                                bVar.mBN -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.mBP);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Ir.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Ir.getMeasuredWidth();
                            int measuredHeight3 = Ir.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Ir);
                            this.mBT.l(i12, Ir);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mBT.dk(Ir));
                        bVar.mBI = flexItem.dCv() + measuredHeight2 + flexItem.dCu() + bVar.mBI;
                        i5 = max2;
                    }
                    bVar.mBK = Math.max(bVar.mBK, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mBI) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int ag = this.mBT.ag(i, this.mBT.getPaddingLeft() + this.mBT.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(ag);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(ag));
        }
        if (size < flexItem.getMinWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(ag));
        }
        return ag;
    }

    private int b(int i, FlexItem flexItem, int i2) {
        int ah = this.mBT.ah(i, this.mBT.getPaddingTop() + this.mBT.getPaddingBottom() + flexItem.dCu() + flexItem.dCv() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(ah);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(ah));
        }
        if (size < flexItem.getMinHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(ah));
        }
        return ah;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(int i, int i2, int i3) {
        int mode;
        int size;
        float f;
        float f2;
        int i4;
        int flexDirection = this.mBT.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.mBT.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mBT.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mBK = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.mBT.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.mBK = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.mBT.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.mBK = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.mBK = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.mBK);
                                    if (f > 1.0f) {
                                        bVar2.mBK++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.mBK--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.mBT.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.mBT.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.mBK = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.mBT.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.mBK + size5;
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
                                bVar5.mBK = i4;
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
        bVar.mBK = (i - i2) / 2;
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
    public void dCy() {
        Iu(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Iu(int i) {
        View Ir;
        if (i < this.mBT.getFlexItemCount()) {
            int flexDirection = this.mBT.getFlexDirection();
            if (this.mBT.getAlignItems() == 4) {
                int i2 = this.mBV != null ? this.mBV[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.mBT.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.mBR + i5;
                        if (i5 < this.mBT.getFlexItemCount() && (Ir = this.mBT.Ir(i6)) != null && Ir.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) Ir.getLayoutParams();
                            if (flexItem.dCr() == -1 || flexItem.dCr() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        k(Ir, bVar.mBK, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        l(Ir, bVar.mBK, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.mBT.getFlexLinesInternal()) {
                for (Integer num : bVar2.mBQ) {
                    View Ir2 = this.mBT.Ir(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            k(Ir2, bVar2.mBK, num.intValue());
                            break;
                        case 2:
                        case 3:
                            l(Ir2, bVar2.mBK, num.intValue());
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
        int min = Math.min(Math.max(((i - flexItem.dCu()) - flexItem.dCv()) - this.mBT.dk(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.mBX != null) {
            measuredWidth = fS(this.mBX[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.mBT.l(i2, view);
    }

    private void l(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mBT.dk(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.mBX != null) {
            measuredHeight = fT(this.mBX[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.mBT.l(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mBT.getAlignItems();
        if (flexItem.dCr() != -1) {
            alignItems = flexItem.dCr();
        }
        int i5 = bVar.mBK;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.mBT.getFlexWrap() != 2) {
                    view.layout(i, flexItem.dCu() + i2, i3, flexItem.dCu() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.dCv(), i3, i4 - flexItem.dCv());
                    return;
                }
            case 1:
                if (this.mBT.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.dCv(), i3, (i5 + i2) - flexItem.dCv());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.dCu(), i3, flexItem.dCu() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.dCu()) - flexItem.dCv()) / 2;
                if (this.mBT.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.mBT.getFlexWrap() != 2) {
                    int max = Math.max(bVar.mBO - view.getBaseline(), flexItem.dCu());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.mBO - view.getMeasuredHeight()) + view.getBaseline(), flexItem.dCv());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mBT.getAlignItems();
        if (flexItem.dCr() != -1) {
            alignItems = flexItem.dCr();
        }
        int i5 = bVar.mBK;
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
    public void Iv(int i) {
        if (this.mBX == null) {
            if (i < 10) {
                i = 10;
            }
            this.mBX = new long[i];
        } else if (this.mBX.length < i) {
            int length = this.mBX.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mBX = Arrays.copyOf(this.mBX, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Iw(int i) {
        if (this.mBW == null) {
            if (i < 10) {
                i = 10;
            }
            this.mBW = new long[i];
        } else if (this.mBW.length < i) {
            int length = this.mBW.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mBW = Arrays.copyOf(this.mBW, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int fS(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int fT(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long du(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.mBW != null) {
            this.mBW[i] = du(i2, i3);
        }
        if (this.mBX != null) {
            this.mBX[i] = du(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ix(int i) {
        if (this.mBV == null) {
            if (i < 10) {
                i = 10;
            }
            this.mBV = new int[i];
        } else if (this.mBV.length < i) {
            int length = this.mBV.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mBV = Arrays.copyOf(this.mBV, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.mBV == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.mBW == null) {
            throw new AssertionError();
        }
        int i2 = this.mBV[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.mBV.length - 1;
        if (i > length) {
            Arrays.fill(this.mBV, -1);
        } else {
            Arrays.fill(this.mBV, i, length, -1);
        }
        int length2 = this.mBW.length - 1;
        if (i > length2) {
            Arrays.fill(this.mBW, 0L);
        } else {
            Arrays.fill(this.mBW, i, length2, 0L);
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
        List<com.google.android.flexbox.b> mBY;
        int mBZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.mBY = null;
            this.mBZ = 0;
        }
    }
}
