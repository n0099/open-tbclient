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
/* loaded from: classes12.dex */
public class c {
    static final /* synthetic */ boolean $assertionsDisabled;
    @Nullable
    int[] nLA;
    @Nullable
    long[] nLB;
    @Nullable
    private long[] nLC;
    private final com.google.android.flexbox.a nLy;
    private boolean[] nLz;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.nLy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.nLy.getFlexItemCount();
        List<b> Nf = Nf(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.nLy.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                Nf.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        Nf.add(bVar);
        return a(flexItemCount + 1, Nf, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.nLy.getFlexItemCount();
        return a(flexItemCount, Nf(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> Nf(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.nLy.Nd(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.nLy.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View Nd = this.nLy.Nd(i);
            if (Nd != null && ((FlexItem) Nd.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean eaF = this.nLy.eaF();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.nLD = list;
        boolean z2 = i5 == -1;
        int yu = yu(eaF);
        int yv = yv(eaF);
        int yw = yw(eaF);
        int yx = yx(eaF);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.nLw = i4;
        bVar2.nLn = yu + yv;
        int flexItemCount = this.nLy.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View Ne = this.nLy.Ne(i17);
            if (Ne == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (Ne.getVisibility() == 8) {
                bVar2.nLq++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) Ne.getLayoutParams();
                if (flexItem.eaG() == 4) {
                    bVar2.nLv.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, eaF);
                if (flexItem.eaI() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.eaI());
                }
                if (eaF) {
                    int ag = this.nLy.ag(i, yu + yv + c(flexItem, true) + d(flexItem, true), a2);
                    int ah = this.nLy.ah(i2, yw + yx + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    Ne.measure(ag, ah);
                    a(i17, ag, ah, Ne);
                    i7 = ag;
                } else {
                    int ag2 = this.nLy.ag(i2, yw + yx + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ah2 = this.nLy.ah(i, yu + yv + c(flexItem, false) + d(flexItem, false), a2);
                    Ne.measure(ag2, ah2);
                    a(i17, ag2, ah2, Ne);
                    i7 = ah2;
                }
                this.nLy.l(i17, Ne);
                A(Ne, i17);
                i6 = View.combineMeasuredStates(i13, Ne.getMeasuredState());
                if (a(Ne, mode, size, bVar2.nLn, d(flexItem, eaF) + m(Ne, eaF) + c(flexItem, eaF), flexItem, i17, i16, list.size())) {
                    if (bVar2.eaM() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.nLp;
                    } else {
                        i12 = i15;
                    }
                    if (eaF) {
                        if (flexItem.getHeight() == -1) {
                            Ne.measure(i7, this.nLy.ah(i2, this.nLy.getPaddingTop() + this.nLy.getPaddingBottom() + flexItem.eaJ() + flexItem.eaK() + i12, flexItem.getHeight()));
                            A(Ne, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        Ne.measure(this.nLy.ag(i2, this.nLy.getPaddingLeft() + this.nLy.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        A(Ne, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.nLn = yu + yv;
                    bVar3.nLw = i17;
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
                if (this.nLA != null) {
                    this.nLA[i17] = list.size();
                }
                bVar.nLn += m(Ne, eaF) + c(flexItem, eaF) + d(flexItem, eaF);
                bVar.nLr += flexItem.getFlexGrow();
                bVar.nLs += flexItem.getFlexShrink();
                this.nLy.a(Ne, i17, i8, bVar);
                i14 = Math.max(i9, n(Ne, eaF) + e(flexItem, eaF) + f(flexItem, eaF) + this.nLy.dE(Ne));
                bVar.nLp = Math.max(bVar.nLp, i14);
                if (eaF) {
                    if (this.nLy.getFlexWrap() != 2) {
                        bVar.nLt = Math.max(bVar.nLt, Ne.getBaseline() + flexItem.eaJ());
                    } else {
                        bVar.nLt = Math.max(bVar.nLt, (Ne.getMeasuredHeight() - Ne.getBaseline()) + flexItem.eaK());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.nLp;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).nLx >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.eaL();
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
        aVar.nLE = i6;
    }

    private int yu(boolean z) {
        return z ? this.nLy.getPaddingStart() : this.nLy.getPaddingTop();
    }

    private int yv(boolean z) {
        return z ? this.nLy.getPaddingEnd() : this.nLy.getPaddingBottom();
    }

    private int yw(boolean z) {
        return z ? this.nLy.getPaddingTop() : this.nLy.getPaddingStart();
    }

    private int yx(boolean z) {
        return z ? this.nLy.getPaddingBottom() : this.nLy.getPaddingEnd();
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
        return z ? flexItem.getMarginLeft() : flexItem.eaJ();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.eaK();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.eaJ() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.eaK() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.nLy.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.eaH()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.nLy.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int j = this.nLy.j(view, i5, i6);
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
        return i == i2 + (-1) && bVar.eaM() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.nLu = i2;
        this.nLy.a(bVar);
        bVar.nLx = i;
        list.add(bVar);
    }

    private void A(View view, int i) {
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
            this.nLy.l(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dQ(int i, int i2) {
        ai(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        Ng(this.nLy.getFlexItemCount());
        if (i3 < this.nLy.getFlexItemCount()) {
            int flexDirection = this.nLy.getFlexDirection();
            switch (this.nLy.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.nLy.getLargestMainSize();
                    }
                    paddingTop = this.nLy.getPaddingLeft() + this.nLy.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.nLy.getLargestMainSize();
                    }
                    paddingTop = this.nLy.getPaddingTop() + this.nLy.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.nLA != null ? this.nLA[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.nLy.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.nLn < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void Ng(int i) {
        if (this.nLz == null) {
            if (i < 10) {
                i = 10;
            }
            this.nLz = new boolean[i];
        } else if (this.nLz.length < i) {
            int length = this.nLz.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nLz = new boolean[i];
        } else {
            Arrays.fill(this.nLz, false);
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
        if (bVar.nLr > 0.0f && i3 >= bVar.nLn) {
            int i8 = bVar.nLn;
            float f5 = (i3 - bVar.nLn) / bVar.nLr;
            bVar.nLn = bVar.nLo + i4;
            if (!z) {
                bVar.nLp = Integer.MIN_VALUE;
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
                int i12 = bVar.nLw + i11;
                View Ne = this.nLy.Ne(i12);
                if (Ne != null && Ne.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Ne.getLayoutParams();
                    int flexDirection = this.nLy.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Ne.getMeasuredWidth();
                        if (this.nLC != null) {
                            measuredWidth = gN(this.nLC[i12]);
                        }
                        int measuredHeight = Ne.getMeasuredHeight();
                        if (this.nLC != null) {
                            measuredHeight = gO(this.nLC[i12]);
                        }
                        if (!this.nLz[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.nLz[i12] = true;
                                bVar.nLr -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.nLu);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Ne.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Ne.getMeasuredWidth();
                            measuredHeight = Ne.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Ne);
                            this.nLy.l(i12, Ne);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.eaJ() + flexItem.eaK() + this.nLy.dE(Ne));
                        bVar.nLn = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.nLn;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Ne.getMeasuredHeight();
                        if (this.nLC != null) {
                            measuredHeight2 = gO(this.nLC[i12]);
                        }
                        int measuredWidth3 = Ne.getMeasuredWidth();
                        if (this.nLC != null) {
                            measuredWidth3 = gN(this.nLC[i12]);
                        }
                        if (!this.nLz[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.nLz[i12] = true;
                                bVar.nLr -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.nLu);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Ne.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Ne.getMeasuredWidth();
                            int measuredHeight3 = Ne.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Ne);
                            this.nLy.l(i12, Ne);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.nLy.dE(Ne));
                        bVar.nLn = flexItem.eaK() + measuredHeight2 + flexItem.eaJ() + bVar.nLn;
                        i5 = max2;
                    }
                    bVar.nLp = Math.max(bVar.nLp, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.nLn) {
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
        int i8 = bVar.nLn;
        if (bVar.nLs > 0.0f && i3 <= bVar.nLn) {
            float f5 = (bVar.nLn - i3) / bVar.nLs;
            bVar.nLn = bVar.nLo + i4;
            if (!z) {
                bVar.nLp = Integer.MIN_VALUE;
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
                int i12 = bVar.nLw + i11;
                View Ne = this.nLy.Ne(i12);
                if (Ne != null && Ne.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) Ne.getLayoutParams();
                    int flexDirection = this.nLy.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = Ne.getMeasuredWidth();
                        if (this.nLC != null) {
                            measuredWidth = gN(this.nLC[i12]);
                        }
                        int measuredHeight = Ne.getMeasuredHeight();
                        if (this.nLC != null) {
                            measuredHeight = gO(this.nLC[i12]);
                        }
                        if (!this.nLz[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.nLz[i12] = true;
                                bVar.nLs -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.nLu);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            Ne.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = Ne.getMeasuredWidth();
                            measuredHeight = Ne.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, Ne);
                            this.nLy.l(i12, Ne);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.eaJ() + flexItem.eaK() + this.nLy.dE(Ne));
                        bVar.nLn = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.nLn;
                        i5 = max;
                    } else {
                        int measuredHeight2 = Ne.getMeasuredHeight();
                        if (this.nLC != null) {
                            measuredHeight2 = gO(this.nLC[i12]);
                        }
                        int measuredWidth3 = Ne.getMeasuredWidth();
                        if (this.nLC != null) {
                            measuredWidth3 = gN(this.nLC[i12]);
                        }
                        if (!this.nLz[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.nLz[i12] = true;
                                bVar.nLs -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.nLu);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            Ne.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = Ne.getMeasuredWidth();
                            int measuredHeight3 = Ne.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, Ne);
                            this.nLy.l(i12, Ne);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.nLy.dE(Ne));
                        bVar.nLn = flexItem.eaK() + measuredHeight2 + flexItem.eaJ() + bVar.nLn;
                        i5 = max2;
                    }
                    bVar.nLp = Math.max(bVar.nLp, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.nLn) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int ag = this.nLy.ag(i, this.nLy.getPaddingLeft() + this.nLy.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
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
        int ah = this.nLy.ah(i, this.nLy.getPaddingTop() + this.nLy.getPaddingBottom() + flexItem.eaJ() + flexItem.eaK() + i2, flexItem.getHeight());
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
        int flexDirection = this.nLy.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.nLy.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.nLy.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).nLp = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.nLy.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.nLp = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.nLy.setFlexLines(i(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.nLp = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.nLp = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.nLp);
                                    if (f > 1.0f) {
                                        bVar2.nLp++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.nLp--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.nLy.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.nLy.setFlexLines(i(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.nLp = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.nLy.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.nLp + size5;
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
                                bVar5.nLp = i4;
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
        bVar.nLp = (i - i2) / 2;
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
    public void eaN() {
        Nh(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nh(int i) {
        View Ne;
        if (i < this.nLy.getFlexItemCount()) {
            int flexDirection = this.nLy.getFlexDirection();
            if (this.nLy.getAlignItems() == 4) {
                int i2 = this.nLA != null ? this.nLA[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.nLy.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.nLw + i5;
                        if (i5 < this.nLy.getFlexItemCount() && (Ne = this.nLy.Ne(i6)) != null && Ne.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) Ne.getLayoutParams();
                            if (flexItem.eaG() == -1 || flexItem.eaG() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        k(Ne, bVar.nLp, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        l(Ne, bVar.nLp, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.nLy.getFlexLinesInternal()) {
                for (Integer num : bVar2.nLv) {
                    View Ne2 = this.nLy.Ne(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            k(Ne2, bVar2.nLp, num.intValue());
                            break;
                        case 2:
                        case 3:
                            l(Ne2, bVar2.nLp, num.intValue());
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
        int min = Math.min(Math.max(((i - flexItem.eaJ()) - flexItem.eaK()) - this.nLy.dE(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.nLC != null) {
            measuredWidth = gN(this.nLC[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.nLy.l(i2, view);
    }

    private void l(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.nLy.dE(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.nLC != null) {
            measuredHeight = gO(this.nLC[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.nLy.l(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.nLy.getAlignItems();
        if (flexItem.eaG() != -1) {
            alignItems = flexItem.eaG();
        }
        int i5 = bVar.nLp;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.nLy.getFlexWrap() != 2) {
                    view.layout(i, flexItem.eaJ() + i2, i3, flexItem.eaJ() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.eaK(), i3, i4 - flexItem.eaK());
                    return;
                }
            case 1:
                if (this.nLy.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.eaK(), i3, (i5 + i2) - flexItem.eaK());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.eaJ(), i3, flexItem.eaJ() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.eaJ()) - flexItem.eaK()) / 2;
                if (this.nLy.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.nLy.getFlexWrap() != 2) {
                    int max = Math.max(bVar.nLt - view.getBaseline(), flexItem.eaJ());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.nLt - view.getMeasuredHeight()) + view.getBaseline(), flexItem.eaK());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.nLy.getAlignItems();
        if (flexItem.eaG() != -1) {
            alignItems = flexItem.eaG();
        }
        int i5 = bVar.nLp;
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
    public void Ni(int i) {
        if (this.nLC == null) {
            if (i < 10) {
                i = 10;
            }
            this.nLC = new long[i];
        } else if (this.nLC.length < i) {
            int length = this.nLC.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nLC = Arrays.copyOf(this.nLC, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nj(int i) {
        if (this.nLB == null) {
            if (i < 10) {
                i = 10;
            }
            this.nLB = new long[i];
        } else if (this.nLB.length < i) {
            int length = this.nLB.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nLB = Arrays.copyOf(this.nLB, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gN(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int gO(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long dR(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.nLB != null) {
            this.nLB[i] = dR(i2, i3);
        }
        if (this.nLC != null) {
            this.nLC[i] = dR(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nk(int i) {
        if (this.nLA == null) {
            if (i < 10) {
                i = 10;
            }
            this.nLA = new int[i];
        } else if (this.nLA.length < i) {
            int length = this.nLA.length * 2;
            if (length >= i) {
                i = length;
            }
            this.nLA = Arrays.copyOf(this.nLA, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.nLA == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.nLB == null) {
            throw new AssertionError();
        }
        int i2 = this.nLA[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.nLA.length - 1;
        if (i > length) {
            Arrays.fill(this.nLA, -1);
        } else {
            Arrays.fill(this.nLA, i, length, -1);
        }
        int length2 = this.nLB.length - 1;
        if (i > length2) {
            Arrays.fill(this.nLB, 0L);
        } else {
            Arrays.fill(this.nLB, i, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
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
    /* loaded from: classes12.dex */
    public static class a {
        List<com.google.android.flexbox.b> nLD;
        int nLE;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.nLD = null;
            this.nLE = 0;
        }
    }
}
