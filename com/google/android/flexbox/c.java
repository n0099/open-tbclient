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
    private final com.google.android.flexbox.a mZn;
    private boolean[] mZo;
    @Nullable
    int[] mZp;
    @Nullable
    long[] mZq;
    @Nullable
    private long[] mZr;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.mZn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mZn.getFlexItemCount();
        List<b> JB = JB(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.mZn.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                JB.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        JB.add(bVar);
        return a(flexItemCount + 1, JB, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mZn.getFlexItemCount();
        return a(flexItemCount, JB(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> JB(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.mZn.Jz(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mZn.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View Jz = this.mZn.Jz(i);
            if (Jz != null && ((FlexItem) Jz.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean dHk = this.mZn.dHk();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.mZs = list;
        boolean z2 = i5 == -1;
        int wN = wN(dHk);
        int wO = wO(dHk);
        int wP = wP(dHk);
        int wQ = wQ(dHk);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.mZl = i4;
        bVar2.mZc = wN + wO;
        int flexItemCount = this.mZn.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View JA = this.mZn.JA(i17);
            if (JA == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (JA.getVisibility() == 8) {
                bVar2.mZf++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) JA.getLayoutParams();
                if (flexItem.dHl() == 4) {
                    bVar2.mZk.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, dHk);
                if (flexItem.dHn() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.dHn());
                }
                if (dHk) {
                    int ag = this.mZn.ag(i, wN + wO + c(flexItem, true) + d(flexItem, true), a2);
                    int ah = this.mZn.ah(i2, wP + wQ + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    JA.measure(ag, ah);
                    a(i17, ag, ah, JA);
                    i7 = ag;
                } else {
                    int ag2 = this.mZn.ag(i2, wP + wQ + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ah2 = this.mZn.ah(i, wN + wO + c(flexItem, false) + d(flexItem, false), a2);
                    JA.measure(ag2, ah2);
                    a(i17, ag2, ah2, JA);
                    i7 = ah2;
                }
                this.mZn.l(i17, JA);
                y(JA, i17);
                i6 = View.combineMeasuredStates(i13, JA.getMeasuredState());
                if (a(JA, mode, size, bVar2.mZc, d(flexItem, dHk) + n(JA, dHk) + c(flexItem, dHk), flexItem, i17, i16, list.size())) {
                    if (bVar2.dHr() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.mZe;
                    } else {
                        i12 = i15;
                    }
                    if (dHk) {
                        if (flexItem.getHeight() == -1) {
                            JA.measure(i7, this.mZn.ah(i2, this.mZn.getPaddingTop() + this.mZn.getPaddingBottom() + flexItem.dHo() + flexItem.dHp() + i12, flexItem.getHeight()));
                            y(JA, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        JA.measure(this.mZn.ag(i2, this.mZn.getPaddingLeft() + this.mZn.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        y(JA, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.mZc = wN + wO;
                    bVar3.mZl = i17;
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
                if (this.mZp != null) {
                    this.mZp[i17] = list.size();
                }
                bVar.mZc += n(JA, dHk) + c(flexItem, dHk) + d(flexItem, dHk);
                bVar.mZg += flexItem.getFlexGrow();
                bVar.mZh += flexItem.getFlexShrink();
                this.mZn.a(JA, i17, i8, bVar);
                i14 = Math.max(i9, o(JA, dHk) + e(flexItem, dHk) + f(flexItem, dHk) + this.mZn.dl(JA));
                bVar.mZe = Math.max(bVar.mZe, i14);
                if (dHk) {
                    if (this.mZn.getFlexWrap() != 2) {
                        bVar.mZi = Math.max(bVar.mZi, JA.getBaseline() + flexItem.dHo());
                    } else {
                        bVar.mZi = Math.max(bVar.mZi, (JA.getMeasuredHeight() - JA.getBaseline()) + flexItem.dHp());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.mZe;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).mZm >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.dHq();
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
        aVar.mZt = i6;
    }

    private int wN(boolean z) {
        return z ? this.mZn.getPaddingStart() : this.mZn.getPaddingTop();
    }

    private int wO(boolean z) {
        return z ? this.mZn.getPaddingEnd() : this.mZn.getPaddingBottom();
    }

    private int wP(boolean z) {
        return z ? this.mZn.getPaddingTop() : this.mZn.getPaddingStart();
    }

    private int wQ(boolean z) {
        return z ? this.mZn.getPaddingBottom() : this.mZn.getPaddingEnd();
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
        return z ? flexItem.getMarginLeft() : flexItem.dHo();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.dHp();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.dHo() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.dHp() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.mZn.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.dHm()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.mZn.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int i8 = this.mZn.i(view, i5, i6);
                if (i8 > 0) {
                    i4 += i8;
                }
                return i2 < i3 + i4;
            }
            return false;
        }
        return false;
    }

    private boolean a(int i, int i2, com.google.android.flexbox.b bVar) {
        return i == i2 + (-1) && bVar.dHr() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.mZj = i2;
        this.mZn.a(bVar);
        bVar.mZm = i;
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
            this.mZn.l(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dC(int i, int i2) {
        ai(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        JC(this.mZn.getFlexItemCount());
        if (i3 < this.mZn.getFlexItemCount()) {
            int flexDirection = this.mZn.getFlexDirection();
            switch (this.mZn.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.mZn.getLargestMainSize();
                    }
                    paddingTop = this.mZn.getPaddingLeft() + this.mZn.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.mZn.getLargestMainSize();
                    }
                    paddingTop = this.mZn.getPaddingTop() + this.mZn.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.mZp != null ? this.mZp[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.mZn.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.mZc < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void JC(int i) {
        if (this.mZo == null) {
            if (i < 10) {
                i = 10;
            }
            this.mZo = new boolean[i];
        } else if (this.mZo.length < i) {
            int length = this.mZo.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mZo = new boolean[i];
        } else {
            Arrays.fill(this.mZo, false);
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
        if (bVar.mZg > 0.0f && i3 >= bVar.mZc) {
            int i8 = bVar.mZc;
            float f5 = (i3 - bVar.mZc) / bVar.mZg;
            bVar.mZc = bVar.mZd + i4;
            if (!z) {
                bVar.mZe = Integer.MIN_VALUE;
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
                int i12 = bVar.mZl + i11;
                View JA = this.mZn.JA(i12);
                if (JA != null && JA.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) JA.getLayoutParams();
                    int flexDirection = this.mZn.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = JA.getMeasuredWidth();
                        if (this.mZr != null) {
                            measuredWidth = fX(this.mZr[i12]);
                        }
                        int measuredHeight = JA.getMeasuredHeight();
                        if (this.mZr != null) {
                            measuredHeight = fY(this.mZr[i12]);
                        }
                        if (!this.mZo[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mZo[i12] = true;
                                bVar.mZg -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.mZj);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            JA.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = JA.getMeasuredWidth();
                            measuredHeight = JA.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, JA);
                            this.mZn.l(i12, JA);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dHo() + flexItem.dHp() + this.mZn.dl(JA));
                        bVar.mZc = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mZc;
                        i5 = max;
                    } else {
                        int measuredHeight2 = JA.getMeasuredHeight();
                        if (this.mZr != null) {
                            measuredHeight2 = fY(this.mZr[i12]);
                        }
                        int measuredWidth3 = JA.getMeasuredWidth();
                        if (this.mZr != null) {
                            measuredWidth3 = fX(this.mZr[i12]);
                        }
                        if (!this.mZo[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mZo[i12] = true;
                                bVar.mZg -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.mZj);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            JA.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = JA.getMeasuredWidth();
                            int measuredHeight3 = JA.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, JA);
                            this.mZn.l(i12, JA);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mZn.dl(JA));
                        bVar.mZc = flexItem.dHp() + measuredHeight2 + flexItem.dHo() + bVar.mZc;
                        i5 = max2;
                    }
                    bVar.mZe = Math.max(bVar.mZe, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mZc) {
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
        int i8 = bVar.mZc;
        if (bVar.mZh > 0.0f && i3 <= bVar.mZc) {
            float f5 = (bVar.mZc - i3) / bVar.mZh;
            bVar.mZc = bVar.mZd + i4;
            if (!z) {
                bVar.mZe = Integer.MIN_VALUE;
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
                int i12 = bVar.mZl + i11;
                View JA = this.mZn.JA(i12);
                if (JA != null && JA.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) JA.getLayoutParams();
                    int flexDirection = this.mZn.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = JA.getMeasuredWidth();
                        if (this.mZr != null) {
                            measuredWidth = fX(this.mZr[i12]);
                        }
                        int measuredHeight = JA.getMeasuredHeight();
                        if (this.mZr != null) {
                            measuredHeight = fY(this.mZr[i12]);
                        }
                        if (!this.mZo[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mZo[i12] = true;
                                bVar.mZh -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.mZj);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            JA.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = JA.getMeasuredWidth();
                            measuredHeight = JA.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, JA);
                            this.mZn.l(i12, JA);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dHo() + flexItem.dHp() + this.mZn.dl(JA));
                        bVar.mZc = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mZc;
                        i5 = max;
                    } else {
                        int measuredHeight2 = JA.getMeasuredHeight();
                        if (this.mZr != null) {
                            measuredHeight2 = fY(this.mZr[i12]);
                        }
                        int measuredWidth3 = JA.getMeasuredWidth();
                        if (this.mZr != null) {
                            measuredWidth3 = fX(this.mZr[i12]);
                        }
                        if (!this.mZo[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mZo[i12] = true;
                                bVar.mZh -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.mZj);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            JA.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = JA.getMeasuredWidth();
                            int measuredHeight3 = JA.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, JA);
                            this.mZn.l(i12, JA);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mZn.dl(JA));
                        bVar.mZc = flexItem.dHp() + measuredHeight2 + flexItem.dHo() + bVar.mZc;
                        i5 = max2;
                    }
                    bVar.mZe = Math.max(bVar.mZe, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mZc) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int ag = this.mZn.ag(i, this.mZn.getPaddingLeft() + this.mZn.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
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
        int ah = this.mZn.ah(i, this.mZn.getPaddingTop() + this.mZn.getPaddingBottom() + flexItem.dHo() + flexItem.dHp() + i2, flexItem.getHeight());
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
        int flexDirection = this.mZn.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.mZn.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mZn.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mZe = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.mZn.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.mZe = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.mZn.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.mZe = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.mZe = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.mZe);
                                    if (f > 1.0f) {
                                        bVar2.mZe++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.mZe--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.mZn.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.mZn.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.mZe = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.mZn.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.mZe + size5;
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
                                bVar5.mZe = i4;
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
        bVar.mZe = (i - i2) / 2;
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
    public void dHs() {
        JD(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void JD(int i) {
        View JA;
        if (i < this.mZn.getFlexItemCount()) {
            int flexDirection = this.mZn.getFlexDirection();
            if (this.mZn.getAlignItems() == 4) {
                int i2 = this.mZp != null ? this.mZp[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.mZn.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.mZl + i5;
                        if (i5 < this.mZn.getFlexItemCount() && (JA = this.mZn.JA(i6)) != null && JA.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) JA.getLayoutParams();
                            if (flexItem.dHl() == -1 || flexItem.dHl() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        j(JA, bVar.mZe, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        k(JA, bVar.mZe, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.mZn.getFlexLinesInternal()) {
                for (Integer num : bVar2.mZk) {
                    View JA2 = this.mZn.JA(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            j(JA2, bVar2.mZe, num.intValue());
                            break;
                        case 2:
                        case 3:
                            k(JA2, bVar2.mZe, num.intValue());
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                }
            }
        }
    }

    private void j(View view, int i, int i2) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.dHo()) - flexItem.dHp()) - this.mZn.dl(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.mZr != null) {
            measuredWidth = fX(this.mZr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.mZn.l(i2, view);
    }

    private void k(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mZn.dl(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.mZr != null) {
            measuredHeight = fY(this.mZr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.mZn.l(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mZn.getAlignItems();
        if (flexItem.dHl() != -1) {
            alignItems = flexItem.dHl();
        }
        int i5 = bVar.mZe;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.mZn.getFlexWrap() != 2) {
                    view.layout(i, flexItem.dHo() + i2, i3, flexItem.dHo() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.dHp(), i3, i4 - flexItem.dHp());
                    return;
                }
            case 1:
                if (this.mZn.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.dHp(), i3, (i5 + i2) - flexItem.dHp());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.dHo(), i3, flexItem.dHo() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.dHo()) - flexItem.dHp()) / 2;
                if (this.mZn.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.mZn.getFlexWrap() != 2) {
                    int max = Math.max(bVar.mZi - view.getBaseline(), flexItem.dHo());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.mZi - view.getMeasuredHeight()) + view.getBaseline(), flexItem.dHp());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mZn.getAlignItems();
        if (flexItem.dHl() != -1) {
            alignItems = flexItem.dHl();
        }
        int i5 = bVar.mZe;
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
    public void JE(int i) {
        if (this.mZr == null) {
            if (i < 10) {
                i = 10;
            }
            this.mZr = new long[i];
        } else if (this.mZr.length < i) {
            int length = this.mZr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mZr = Arrays.copyOf(this.mZr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void JF(int i) {
        if (this.mZq == null) {
            if (i < 10) {
                i = 10;
            }
            this.mZq = new long[i];
        } else if (this.mZq.length < i) {
            int length = this.mZq.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mZq = Arrays.copyOf(this.mZq, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int fX(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int fY(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long dD(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.mZq != null) {
            this.mZq[i] = dD(i2, i3);
        }
        if (this.mZr != null) {
            this.mZr[i] = dD(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void JG(int i) {
        if (this.mZp == null) {
            if (i < 10) {
                i = 10;
            }
            this.mZp = new int[i];
        } else if (this.mZp.length < i) {
            int length = this.mZp.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mZp = Arrays.copyOf(this.mZp, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.mZp == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.mZq == null) {
            throw new AssertionError();
        }
        int i2 = this.mZp[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.mZp.length - 1;
        if (i > length) {
            Arrays.fill(this.mZp, -1);
        } else {
            Arrays.fill(this.mZp, i, length, -1);
        }
        int length2 = this.mZq.length - 1;
        if (i > length2) {
            Arrays.fill(this.mZq, 0L);
        } else {
            Arrays.fill(this.mZq, i, length2, 0L);
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
        List<com.google.android.flexbox.b> mZs;
        int mZt;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.mZs = null;
            this.mZt = 0;
        }
    }
}
