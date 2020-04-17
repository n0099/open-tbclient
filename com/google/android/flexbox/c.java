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
    private final com.google.android.flexbox.a mhX;
    private boolean[] mhY;
    @Nullable
    int[] mhZ;
    @Nullable
    long[] mia;
    @Nullable
    private long[] mib;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.mhX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mhX.getFlexItemCount();
        List<b> HG = HG(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.mhX.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                HG.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        HG.add(bVar);
        return a(flexItemCount + 1, HG, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mhX.getFlexItemCount();
        return a(flexItemCount, HG(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> HG(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.mhX.HE(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mhX.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View HE = this.mhX.HE(i);
            if (HE != null && ((FlexItem) HE.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean dvb = this.mhX.dvb();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.mic = list;
        boolean z2 = i5 == -1;
        int vR = vR(dvb);
        int vS = vS(dvb);
        int vT = vT(dvb);
        int vU = vU(dvb);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.mhV = i4;
        bVar2.mhM = vR + vS;
        int flexItemCount = this.mhX.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View HF = this.mhX.HF(i17);
            if (HF == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (HF.getVisibility() == 8) {
                bVar2.mhP++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) HF.getLayoutParams();
                if (flexItem.dvc() == 4) {
                    bVar2.mhU.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, dvb);
                if (flexItem.dve() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.dve());
                }
                if (dvb) {
                    int ag = this.mhX.ag(i, vR + vS + c(flexItem, true) + d(flexItem, true), a2);
                    int ah = this.mhX.ah(i2, vT + vU + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    HF.measure(ag, ah);
                    a(i17, ag, ah, HF);
                    i7 = ag;
                } else {
                    int ag2 = this.mhX.ag(i2, vT + vU + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ah2 = this.mhX.ah(i, vR + vS + c(flexItem, false) + d(flexItem, false), a2);
                    HF.measure(ag2, ah2);
                    a(i17, ag2, ah2, HF);
                    i7 = ah2;
                }
                this.mhX.l(i17, HF);
                y(HF, i17);
                i6 = View.combineMeasuredStates(i13, HF.getMeasuredState());
                if (a(HF, mode, size, bVar2.mhM, d(flexItem, dvb) + k(HF, dvb) + c(flexItem, dvb), flexItem, i17, i16, list.size())) {
                    if (bVar2.dvi() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.mhO;
                    } else {
                        i12 = i15;
                    }
                    if (dvb) {
                        if (flexItem.getHeight() == -1) {
                            HF.measure(i7, this.mhX.ah(i2, this.mhX.getPaddingTop() + this.mhX.getPaddingBottom() + flexItem.dvf() + flexItem.dvg() + i12, flexItem.getHeight()));
                            y(HF, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        HF.measure(this.mhX.ag(i2, this.mhX.getPaddingLeft() + this.mhX.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        y(HF, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.mhM = vR + vS;
                    bVar3.mhV = i17;
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
                if (this.mhZ != null) {
                    this.mhZ[i17] = list.size();
                }
                bVar.mhM += k(HF, dvb) + c(flexItem, dvb) + d(flexItem, dvb);
                bVar.mhQ += flexItem.getFlexGrow();
                bVar.mhR += flexItem.getFlexShrink();
                this.mhX.a(HF, i17, i8, bVar);
                i14 = Math.max(i9, l(HF, dvb) + e(flexItem, dvb) + f(flexItem, dvb) + this.mhX.dj(HF));
                bVar.mhO = Math.max(bVar.mhO, i14);
                if (dvb) {
                    if (this.mhX.getFlexWrap() != 2) {
                        bVar.mhS = Math.max(bVar.mhS, HF.getBaseline() + flexItem.dvf());
                    } else {
                        bVar.mhS = Math.max(bVar.mhS, (HF.getMeasuredHeight() - HF.getBaseline()) + flexItem.dvg());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.mhO;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).mhW >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.dvh();
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
        aVar.mie = i6;
    }

    private int vR(boolean z) {
        return z ? this.mhX.getPaddingStart() : this.mhX.getPaddingTop();
    }

    private int vS(boolean z) {
        return z ? this.mhX.getPaddingEnd() : this.mhX.getPaddingBottom();
    }

    private int vT(boolean z) {
        return z ? this.mhX.getPaddingTop() : this.mhX.getPaddingStart();
    }

    private int vU(boolean z) {
        return z ? this.mhX.getPaddingBottom() : this.mhX.getPaddingEnd();
    }

    private int k(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int l(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int a(FlexItem flexItem, boolean z) {
        return z ? flexItem.getWidth() : flexItem.getHeight();
    }

    private int b(FlexItem flexItem, boolean z) {
        return z ? flexItem.getHeight() : flexItem.getWidth();
    }

    private int c(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginLeft() : flexItem.dvf();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.dvg();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.dvf() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.dvg() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.mhX.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.dvd()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.mhX.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int h = this.mhX.h(view, i5, i6);
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
        return i == i2 + (-1) && bVar.dvi() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.mhT = i2;
        this.mhX.a(bVar);
        bVar.mhW = i;
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
            this.mhX.l(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public void m39do(int i, int i2) {
        ai(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(int i, int i2, int i3) {
        int paddingTop;
        int i4;
        HH(this.mhX.getFlexItemCount());
        if (i3 < this.mhX.getFlexItemCount()) {
            int flexDirection = this.mhX.getFlexDirection();
            switch (this.mhX.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.mhX.getLargestMainSize();
                    }
                    paddingTop = this.mhX.getPaddingLeft() + this.mhX.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.mhX.getLargestMainSize();
                    }
                    paddingTop = this.mhX.getPaddingTop() + this.mhX.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.mhZ != null ? this.mhZ[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.mhX.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.mhM < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void HH(int i) {
        if (this.mhY == null) {
            if (i < 10) {
                i = 10;
            }
            this.mhY = new boolean[i];
        } else if (this.mhY.length < i) {
            int length = this.mhY.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mhY = new boolean[i];
        } else {
            Arrays.fill(this.mhY, false);
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
        if (bVar.mhQ > 0.0f && i3 >= bVar.mhM) {
            int i8 = bVar.mhM;
            float f5 = (i3 - bVar.mhM) / bVar.mhQ;
            bVar.mhM = bVar.mhN + i4;
            if (!z) {
                bVar.mhO = Integer.MIN_VALUE;
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
                int i12 = bVar.mhV + i11;
                View HF = this.mhX.HF(i12);
                if (HF != null && HF.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) HF.getLayoutParams();
                    int flexDirection = this.mhX.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = HF.getMeasuredWidth();
                        if (this.mib != null) {
                            measuredWidth = fS(this.mib[i12]);
                        }
                        int measuredHeight = HF.getMeasuredHeight();
                        if (this.mib != null) {
                            measuredHeight = fT(this.mib[i12]);
                        }
                        if (!this.mhY[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mhY[i12] = true;
                                bVar.mhQ -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.mhT);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            HF.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = HF.getMeasuredWidth();
                            measuredHeight = HF.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, HF);
                            this.mhX.l(i12, HF);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dvf() + flexItem.dvg() + this.mhX.dj(HF));
                        bVar.mhM = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mhM;
                        i5 = max;
                    } else {
                        int measuredHeight2 = HF.getMeasuredHeight();
                        if (this.mib != null) {
                            measuredHeight2 = fT(this.mib[i12]);
                        }
                        int measuredWidth3 = HF.getMeasuredWidth();
                        if (this.mib != null) {
                            measuredWidth3 = fS(this.mib[i12]);
                        }
                        if (!this.mhY[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.mhY[i12] = true;
                                bVar.mhQ -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.mhT);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            HF.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = HF.getMeasuredWidth();
                            int measuredHeight3 = HF.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, HF);
                            this.mhX.l(i12, HF);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mhX.dj(HF));
                        bVar.mhM = flexItem.dvg() + measuredHeight2 + flexItem.dvf() + bVar.mhM;
                        i5 = max2;
                    }
                    bVar.mhO = Math.max(bVar.mhO, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mhM) {
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
        int i8 = bVar.mhM;
        if (bVar.mhR > 0.0f && i3 <= bVar.mhM) {
            float f5 = (bVar.mhM - i3) / bVar.mhR;
            bVar.mhM = bVar.mhN + i4;
            if (!z) {
                bVar.mhO = Integer.MIN_VALUE;
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
                int i12 = bVar.mhV + i11;
                View HF = this.mhX.HF(i12);
                if (HF != null && HF.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) HF.getLayoutParams();
                    int flexDirection = this.mhX.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = HF.getMeasuredWidth();
                        if (this.mib != null) {
                            measuredWidth = fS(this.mib[i12]);
                        }
                        int measuredHeight = HF.getMeasuredHeight();
                        if (this.mib != null) {
                            measuredHeight = fT(this.mib[i12]);
                        }
                        if (!this.mhY[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mhY[i12] = true;
                                bVar.mhR -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.mhT);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            HF.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = HF.getMeasuredWidth();
                            measuredHeight = HF.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, HF);
                            this.mhX.l(i12, HF);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.dvf() + flexItem.dvg() + this.mhX.dj(HF));
                        bVar.mhM = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.mhM;
                        i5 = max;
                    } else {
                        int measuredHeight2 = HF.getMeasuredHeight();
                        if (this.mib != null) {
                            measuredHeight2 = fT(this.mib[i12]);
                        }
                        int measuredWidth3 = HF.getMeasuredWidth();
                        if (this.mib != null) {
                            measuredWidth3 = fS(this.mib[i12]);
                        }
                        if (!this.mhY[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.mhY[i12] = true;
                                bVar.mhR -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.mhT);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            HF.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = HF.getMeasuredWidth();
                            int measuredHeight3 = HF.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, HF);
                            this.mhX.l(i12, HF);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mhX.dj(HF));
                        bVar.mhM = flexItem.dvg() + measuredHeight2 + flexItem.dvf() + bVar.mhM;
                        i5 = max2;
                    }
                    bVar.mhO = Math.max(bVar.mhO, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.mhM) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int ag = this.mhX.ag(i, this.mhX.getPaddingLeft() + this.mhX.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
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
        int ah = this.mhX.ah(i, this.mhX.getPaddingTop() + this.mhX.getPaddingBottom() + flexItem.dvf() + flexItem.dvg() + i2, flexItem.getHeight());
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
        int flexDirection = this.mhX.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.mhX.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mhX.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mhO = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.mhX.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.mhO = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.mhX.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.mhO = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.mhO = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.mhO);
                                    if (f > 1.0f) {
                                        bVar2.mhO++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.mhO--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.mhX.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.mhX.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.mhO = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.mhX.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.mhO + size5;
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
                                bVar5.mhO = i4;
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
        bVar.mhO = (i - i2) / 2;
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
    public void dvj() {
        HI(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HI(int i) {
        View HF;
        if (i < this.mhX.getFlexItemCount()) {
            int flexDirection = this.mhX.getFlexDirection();
            if (this.mhX.getAlignItems() == 4) {
                int i2 = this.mhZ != null ? this.mhZ[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.mhX.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.mhV + i5;
                        if (i5 < this.mhX.getFlexItemCount() && (HF = this.mhX.HF(i6)) != null && HF.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) HF.getLayoutParams();
                            if (flexItem.dvc() == -1 || flexItem.dvc() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        i(HF, bVar.mhO, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        j(HF, bVar.mhO, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.mhX.getFlexLinesInternal()) {
                for (Integer num : bVar2.mhU) {
                    View HF2 = this.mhX.HF(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            i(HF2, bVar2.mhO, num.intValue());
                            break;
                        case 2:
                        case 3:
                            j(HF2, bVar2.mhO, num.intValue());
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
        int min = Math.min(Math.max(((i - flexItem.dvf()) - flexItem.dvg()) - this.mhX.dj(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.mib != null) {
            measuredWidth = fS(this.mib[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.mhX.l(i2, view);
    }

    private void j(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mhX.dj(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.mib != null) {
            measuredHeight = fT(this.mib[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.mhX.l(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mhX.getAlignItems();
        if (flexItem.dvc() != -1) {
            alignItems = flexItem.dvc();
        }
        int i5 = bVar.mhO;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.mhX.getFlexWrap() != 2) {
                    view.layout(i, flexItem.dvf() + i2, i3, flexItem.dvf() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.dvg(), i3, i4 - flexItem.dvg());
                    return;
                }
            case 1:
                if (this.mhX.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.dvg(), i3, (i5 + i2) - flexItem.dvg());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.dvf(), i3, flexItem.dvf() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.dvf()) - flexItem.dvg()) / 2;
                if (this.mhX.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.mhX.getFlexWrap() != 2) {
                    int max = Math.max(bVar.mhS - view.getBaseline(), flexItem.dvf());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.mhS - view.getMeasuredHeight()) + view.getBaseline(), flexItem.dvg());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mhX.getAlignItems();
        if (flexItem.dvc() != -1) {
            alignItems = flexItem.dvc();
        }
        int i5 = bVar.mhO;
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
    public void HJ(int i) {
        if (this.mib == null) {
            if (i < 10) {
                i = 10;
            }
            this.mib = new long[i];
        } else if (this.mib.length < i) {
            int length = this.mib.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mib = Arrays.copyOf(this.mib, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HK(int i) {
        if (this.mia == null) {
            if (i < 10) {
                i = 10;
            }
            this.mia = new long[i];
        } else if (this.mia.length < i) {
            int length = this.mia.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mia = Arrays.copyOf(this.mia, i);
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
    long dp(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.mia != null) {
            this.mia[i] = dp(i2, i3);
        }
        if (this.mib != null) {
            this.mib[i] = dp(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HL(int i) {
        if (this.mhZ == null) {
            if (i < 10) {
                i = 10;
            }
            this.mhZ = new int[i];
        } else if (this.mhZ.length < i) {
            int length = this.mhZ.length * 2;
            if (length >= i) {
                i = length;
            }
            this.mhZ = Arrays.copyOf(this.mhZ, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.mhZ == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.mia == null) {
            throw new AssertionError();
        }
        int i2 = this.mhZ[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.mhZ.length - 1;
        if (i > length) {
            Arrays.fill(this.mhZ, -1);
        } else {
            Arrays.fill(this.mhZ, i, length, -1);
        }
        int length2 = this.mia.length - 1;
        if (i > length2) {
            Arrays.fill(this.mia, 0L);
        } else {
            Arrays.fill(this.mia, i, length2, 0L);
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
        List<com.google.android.flexbox.b> mic;
        int mie;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.mic = null;
            this.mie = 0;
        }
    }
}
