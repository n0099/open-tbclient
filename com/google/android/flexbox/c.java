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
    private final com.google.android.flexbox.a oaP;
    private boolean[] oaQ;
    @Nullable
    int[] oaR;
    @Nullable
    long[] oaS;
    @Nullable
    private long[] oaT;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.oaP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.oaP.getFlexItemCount();
        List<b> NL = NL(flexItemCount);
        b bVar = new b();
        if (view != null && (layoutParams instanceof FlexItem)) {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        } else {
            bVar.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.oaP.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                NL.get(i).index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        NL.add(bVar);
        return a(flexItemCount + 1, NL, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.oaP.getFlexItemCount();
        return a(flexItemCount, NL(flexItemCount), sparseIntArray);
    }

    @NonNull
    private List<b> NL(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.order = ((FlexItem) this.oaP.NJ(i2).getLayoutParams()).getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.oaP.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View NJ = this.oaP.NJ(i);
            if (NJ != null && ((FlexItem) NJ.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
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
        boolean eeq = this.oaP.eeq();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.oaU = list;
        boolean z2 = i5 == -1;
        int zb = zb(eeq);
        int zc = zc(eeq);
        int zd = zd(eeq);
        int ze = ze(eeq);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        bVar2.oaN = i4;
        bVar2.oaE = zb + zc;
        int flexItemCount = this.oaP.getFlexItemCount();
        int i17 = i4;
        boolean z3 = z2;
        while (true) {
            if (i17 >= flexItemCount) {
                i6 = i13;
                break;
            }
            View NK = this.oaP.NK(i17);
            if (NK == null) {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else if (NK.getVisibility() == 8) {
                bVar2.oaH++;
                bVar2.mItemCount++;
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i11 = i13;
                }
                z = z3;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) NK.getLayoutParams();
                if (flexItem.eer() == 4) {
                    bVar2.oaM.add(Integer.valueOf(i17));
                }
                int a2 = a(flexItem, eeq);
                if (flexItem.eet() != -1.0f && mode == 1073741824) {
                    a2 = Math.round(size * flexItem.eet());
                }
                if (eeq) {
                    int ag = this.oaP.ag(i, zb + zc + c(flexItem, true) + d(flexItem, true), a2);
                    int ah = this.oaP.ah(i2, zd + ze + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                    NK.measure(ag, ah);
                    a(i17, ag, ah, NK);
                    i7 = ag;
                } else {
                    int ag2 = this.oaP.ag(i2, zd + ze + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                    int ah2 = this.oaP.ah(i, zb + zc + c(flexItem, false) + d(flexItem, false), a2);
                    NK.measure(ag2, ah2);
                    a(i17, ag2, ah2, NK);
                    i7 = ah2;
                }
                this.oaP.l(i17, NK);
                B(NK, i17);
                i6 = View.combineMeasuredStates(i13, NK.getMeasuredState());
                if (a(NK, mode, size, bVar2.oaE, d(flexItem, eeq) + m(NK, eeq) + c(flexItem, eeq), flexItem, i17, i16, list.size())) {
                    if (bVar2.eex() > 0) {
                        a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                        i12 = i15 + bVar2.oaG;
                    } else {
                        i12 = i15;
                    }
                    if (eeq) {
                        if (flexItem.getHeight() == -1) {
                            NK.measure(i7, this.oaP.ah(i2, this.oaP.getPaddingTop() + this.oaP.getPaddingBottom() + flexItem.eeu() + flexItem.eev() + i12, flexItem.getHeight()));
                            B(NK, i17);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        NK.measure(this.oaP.ag(i2, this.oaP.getPaddingLeft() + this.oaP.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth()), i7);
                        B(NK, i17);
                    }
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.mItemCount = 1;
                    bVar3.oaE = zb + zc;
                    bVar3.oaN = i17;
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
                if (this.oaR != null) {
                    this.oaR[i17] = list.size();
                }
                bVar.oaE += m(NK, eeq) + c(flexItem, eeq) + d(flexItem, eeq);
                bVar.oaI += flexItem.getFlexGrow();
                bVar.oaJ += flexItem.getFlexShrink();
                this.oaP.a(NK, i17, i8, bVar);
                i14 = Math.max(i9, n(NK, eeq) + e(flexItem, eeq) + f(flexItem, eeq) + this.oaP.dI(NK));
                bVar.oaG = Math.max(bVar.oaG, i14);
                if (eeq) {
                    if (this.oaP.getFlexWrap() != 2) {
                        bVar.oaK = Math.max(bVar.oaK, NK.getBaseline() + flexItem.eeu());
                    } else {
                        bVar.oaK = Math.max(bVar.oaK, (NK.getMeasuredHeight() - NK.getBaseline()) + flexItem.eev());
                    }
                }
                if (a(i17, flexItemCount, bVar)) {
                    a(list, bVar, i17, i10);
                    i15 = i10 + bVar.oaG;
                } else {
                    i15 = i10;
                }
                if (i5 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).oaO >= i5 && i17 >= i5 && !z3) {
                        i15 = -bVar.eew();
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
        aVar.oaV = i6;
    }

    private int zb(boolean z) {
        return z ? this.oaP.getPaddingStart() : this.oaP.getPaddingTop();
    }

    private int zc(boolean z) {
        return z ? this.oaP.getPaddingEnd() : this.oaP.getPaddingBottom();
    }

    private int zd(boolean z) {
        return z ? this.oaP.getPaddingTop() : this.oaP.getPaddingStart();
    }

    private int ze(boolean z) {
        return z ? this.oaP.getPaddingBottom() : this.oaP.getPaddingEnd();
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
        return z ? flexItem.getMarginLeft() : flexItem.eeu();
    }

    private int d(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.eev();
    }

    private int e(FlexItem flexItem, boolean z) {
        return z ? flexItem.eeu() : flexItem.getMarginLeft();
    }

    private int f(FlexItem flexItem, boolean z) {
        return z ? flexItem.eev() : flexItem.getMarginRight();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.oaP.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.ees()) {
            return true;
        }
        if (i != 0) {
            int maxLine = this.oaP.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                int j = this.oaP.j(view, i5, i6);
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
        return i == i2 + (-1) && bVar.eex() != 0;
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i, int i2) {
        bVar.oaL = i2;
        this.oaP.a(bVar);
        bVar.oaO = i;
        list.add(bVar);
    }

    private void B(View view, int i) {
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
            this.oaP.l(i, view);
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
        NM(this.oaP.getFlexItemCount());
        if (i3 < this.oaP.getFlexItemCount()) {
            int flexDirection = this.oaP.getFlexDirection();
            switch (this.oaP.getFlexDirection()) {
                case 0:
                case 1:
                    int mode = View.MeasureSpec.getMode(i);
                    int size = View.MeasureSpec.getSize(i);
                    if (mode != 1073741824) {
                        size = this.oaP.getLargestMainSize();
                    }
                    paddingTop = this.oaP.getPaddingLeft() + this.oaP.getPaddingRight();
                    i4 = size;
                    break;
                case 2:
                case 3:
                    int mode2 = View.MeasureSpec.getMode(i2);
                    int size2 = View.MeasureSpec.getSize(i2);
                    if (mode2 != 1073741824) {
                        size2 = this.oaP.getLargestMainSize();
                    }
                    paddingTop = this.oaP.getPaddingTop() + this.oaP.getPaddingBottom();
                    i4 = size2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i5 = this.oaR != null ? this.oaR[i3] : 0;
            List<com.google.android.flexbox.b> flexLinesInternal = this.oaP.getFlexLinesInternal();
            int size3 = flexLinesInternal.size();
            for (int i6 = i5; i6 < size3; i6++) {
                com.google.android.flexbox.b bVar = flexLinesInternal.get(i6);
                if (bVar.oaE < i4) {
                    a(i, i2, bVar, i4, paddingTop, false);
                } else {
                    b(i, i2, bVar, i4, paddingTop, false);
                }
            }
        }
    }

    private void NM(int i) {
        if (this.oaQ == null) {
            if (i < 10) {
                i = 10;
            }
            this.oaQ = new boolean[i];
        } else if (this.oaQ.length < i) {
            int length = this.oaQ.length * 2;
            if (length >= i) {
                i = length;
            }
            this.oaQ = new boolean[i];
        } else {
            Arrays.fill(this.oaQ, false);
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
        if (bVar.oaI > 0.0f && i3 >= bVar.oaE) {
            int i8 = bVar.oaE;
            float f5 = (i3 - bVar.oaE) / bVar.oaI;
            bVar.oaE = bVar.oaF + i4;
            if (!z) {
                bVar.oaG = Integer.MIN_VALUE;
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
                int i12 = bVar.oaN + i11;
                View NK = this.oaP.NK(i12);
                if (NK != null && NK.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) NK.getLayoutParams();
                    int flexDirection = this.oaP.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = NK.getMeasuredWidth();
                        if (this.oaT != null) {
                            measuredWidth = hf(this.oaT[i12]);
                        }
                        int measuredHeight = NK.getMeasuredHeight();
                        if (this.oaT != null) {
                            measuredHeight = hg(this.oaT[i12]);
                        }
                        if (!this.oaQ[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.oaQ[i12] = true;
                                bVar.oaI -= flexItem.getFlexGrow();
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
                            int b2 = b(i2, flexItem, bVar.oaL);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            NK.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = NK.getMeasuredWidth();
                            measuredHeight = NK.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, NK);
                            this.oaP.l(i12, NK);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.eeu() + flexItem.eev() + this.oaP.dI(NK));
                        bVar.oaE = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.oaE;
                        i5 = max;
                    } else {
                        int measuredHeight2 = NK.getMeasuredHeight();
                        if (this.oaT != null) {
                            measuredHeight2 = hg(this.oaT[i12]);
                        }
                        int measuredWidth3 = NK.getMeasuredWidth();
                        if (this.oaT != null) {
                            measuredWidth3 = hf(this.oaT[i12]);
                        }
                        if (!this.oaQ[i12] && flexItem.getFlexGrow() > 0.0f) {
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
                                this.oaQ[i12] = true;
                                bVar.oaI -= flexItem.getFlexGrow();
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
                            int a2 = a(i, flexItem, bVar.oaL);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            NK.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = NK.getMeasuredWidth();
                            int measuredHeight3 = NK.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, NK);
                            this.oaP.l(i12, NK);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.oaP.dI(NK));
                        bVar.oaE = flexItem.eev() + measuredHeight2 + flexItem.eeu() + bVar.oaE;
                        i5 = max2;
                    }
                    bVar.oaG = Math.max(bVar.oaG, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.oaE) {
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
        int i8 = bVar.oaE;
        if (bVar.oaJ > 0.0f && i3 <= bVar.oaE) {
            float f5 = (bVar.oaE - i3) / bVar.oaJ;
            bVar.oaE = bVar.oaF + i4;
            if (!z) {
                bVar.oaG = Integer.MIN_VALUE;
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
                int i12 = bVar.oaN + i11;
                View NK = this.oaP.NK(i12);
                if (NK != null && NK.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) NK.getLayoutParams();
                    int flexDirection = this.oaP.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = NK.getMeasuredWidth();
                        if (this.oaT != null) {
                            measuredWidth = hf(this.oaT[i12]);
                        }
                        int measuredHeight = NK.getMeasuredHeight();
                        if (this.oaT != null) {
                            measuredHeight = hg(this.oaT[i12]);
                        }
                        if (!this.oaQ[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.oaQ[i12] = true;
                                bVar.oaJ -= flexItem.getFlexShrink();
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
                            int b2 = b(i2, flexItem, bVar.oaL);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                            NK.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = NK.getMeasuredWidth();
                            measuredHeight = NK.getMeasuredHeight();
                            a(i12, makeMeasureSpec, b2, NK);
                            this.oaP.l(i12, NK);
                            f6 = f;
                            measuredWidth = measuredWidth2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.eeu() + flexItem.eev() + this.oaP.dI(NK));
                        bVar.oaE = flexItem.getMarginRight() + measuredWidth + flexItem.getMarginLeft() + bVar.oaE;
                        i5 = max;
                    } else {
                        int measuredHeight2 = NK.getMeasuredHeight();
                        if (this.oaT != null) {
                            measuredHeight2 = hg(this.oaT[i12]);
                        }
                        int measuredWidth3 = NK.getMeasuredWidth();
                        if (this.oaT != null) {
                            measuredWidth3 = hf(this.oaT[i12]);
                        }
                        if (!this.oaQ[i12] && flexItem.getFlexShrink() > 0.0f) {
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
                                this.oaQ[i12] = true;
                                bVar.oaJ -= flexItem.getFlexShrink();
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
                            int a2 = a(i, flexItem, bVar.oaL);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                            NK.measure(a2, makeMeasureSpec2);
                            measuredWidth3 = NK.getMeasuredWidth();
                            int measuredHeight3 = NK.getMeasuredHeight();
                            a(i12, a2, makeMeasureSpec2, NK);
                            this.oaP.l(i12, NK);
                            f6 = f3;
                            measuredHeight2 = measuredHeight3;
                        }
                        int max2 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.oaP.dI(NK));
                        bVar.oaE = flexItem.eev() + measuredHeight2 + flexItem.eeu() + bVar.oaE;
                        i5 = max2;
                    }
                    bVar.oaG = Math.max(bVar.oaG, i5);
                    i10 = i5;
                }
                i9 = i11 + 1;
            }
            if (z2 && i8 != bVar.oaE) {
                b(i, i2, bVar, i3, i4, true);
            }
        }
    }

    private int a(int i, FlexItem flexItem, int i2) {
        int ag = this.oaP.ag(i, this.oaP.getPaddingLeft() + this.oaP.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
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
        int ah = this.oaP.ah(i, this.oaP.getPaddingTop() + this.oaP.getPaddingBottom() + flexItem.eeu() + flexItem.eev() + i2, flexItem.getHeight());
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
        int flexDirection = this.oaP.getFlexDirection();
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
        List<com.google.android.flexbox.b> flexLinesInternal = this.oaP.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.oaP.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).oaG = size - i3;
            } else if (flexLinesInternal.size() >= 2) {
                switch (this.oaP.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                        bVar.oaG = i5;
                        flexLinesInternal.add(0, bVar);
                        return;
                    case 2:
                        this.oaP.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
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
                                        bVar2.oaG = Math.round(size2 + f3);
                                        f2 = 0.0f;
                                    } else {
                                        bVar2.oaG = Math.round(size2);
                                        f2 = f3;
                                    }
                                    f = f2 + (size2 - bVar2.oaG);
                                    if (f > 1.0f) {
                                        bVar2.oaG++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        bVar2.oaG--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(bVar2);
                                } else {
                                    f = f3;
                                }
                                i6++;
                                f3 = f;
                            }
                            this.oaP.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.oaP.setFlexLines(g(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                        bVar3.oaG = size4;
                        for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                            arrayList2.add(bVar3);
                            arrayList2.add(bVar4);
                            arrayList2.add(bVar3);
                        }
                        this.oaP.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            float f4 = 0.0f;
                            int size6 = flexLinesInternal.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i7);
                                float f5 = bVar5.oaG + size5;
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
                                bVar5.oaG = i4;
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
        bVar.oaG = (i - i2) / 2;
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
    public void eey() {
        NN(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void NN(int i) {
        View NK;
        if (i < this.oaP.getFlexItemCount()) {
            int flexDirection = this.oaP.getFlexDirection();
            if (this.oaP.getAlignItems() == 4) {
                int i2 = this.oaR != null ? this.oaR[i] : 0;
                List<com.google.android.flexbox.b> flexLinesInternal = this.oaP.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i3 = i2; i3 < size; i3++) {
                    com.google.android.flexbox.b bVar = flexLinesInternal.get(i3);
                    int i4 = bVar.mItemCount;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = bVar.oaN + i5;
                        if (i5 < this.oaP.getFlexItemCount() && (NK = this.oaP.NK(i6)) != null && NK.getVisibility() != 8) {
                            FlexItem flexItem = (FlexItem) NK.getLayoutParams();
                            if (flexItem.eer() == -1 || flexItem.eer() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        k(NK, bVar.oaG, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        l(NK, bVar.oaG, i6);
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
            for (com.google.android.flexbox.b bVar2 : this.oaP.getFlexLinesInternal()) {
                for (Integer num : bVar2.oaM) {
                    View NK2 = this.oaP.NK(num.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            k(NK2, bVar2.oaG, num.intValue());
                            break;
                        case 2:
                        case 3:
                            l(NK2, bVar2.oaG, num.intValue());
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
        int min = Math.min(Math.max(((i - flexItem.eeu()) - flexItem.eev()) - this.oaP.dI(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.oaT != null) {
            measuredWidth = hf(this.oaT[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.oaP.l(i2, view);
    }

    private void l(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.oaP.dI(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.oaT != null) {
            measuredHeight = hg(this.oaT[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.oaP.l(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.oaP.getAlignItems();
        if (flexItem.eer() != -1) {
            alignItems = flexItem.eer();
        }
        int i5 = bVar.oaG;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.oaP.getFlexWrap() != 2) {
                    view.layout(i, flexItem.eeu() + i2, i3, flexItem.eeu() + i4);
                    return;
                } else {
                    view.layout(i, i2 - flexItem.eev(), i3, i4 - flexItem.eev());
                    return;
                }
            case 1:
                if (this.oaP.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.eev(), i3, (i5 + i2) - flexItem.eev());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.eeu(), i3, flexItem.eeu() + (i4 - i5) + view.getMeasuredHeight());
                return;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.eeu()) - flexItem.eev()) / 2;
                if (this.oaP.getFlexWrap() != 2) {
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i2 + view.getMeasuredHeight());
                    return;
                } else {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    return;
                }
            case 3:
                if (this.oaP.getFlexWrap() != 2) {
                    int max = Math.max(bVar.oaK - view.getBaseline(), flexItem.eeu());
                    view.layout(i, i2 + max, i3, max + i4);
                    return;
                }
                int max2 = Math.max((bVar.oaK - view.getMeasuredHeight()) + view.getBaseline(), flexItem.eev());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, com.google.android.flexbox.b bVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.oaP.getAlignItems();
        if (flexItem.eer() != -1) {
            alignItems = flexItem.eer();
        }
        int i5 = bVar.oaG;
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
    public void NO(int i) {
        if (this.oaT == null) {
            if (i < 10) {
                i = 10;
            }
            this.oaT = new long[i];
        } else if (this.oaT.length < i) {
            int length = this.oaT.length * 2;
            if (length >= i) {
                i = length;
            }
            this.oaT = Arrays.copyOf(this.oaT, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void NP(int i) {
        if (this.oaS == null) {
            if (i < 10) {
                i = 10;
            }
            this.oaS = new long[i];
        } else if (this.oaS.length < i) {
            int length = this.oaS.length * 2;
            if (length >= i) {
                i = length;
            }
            this.oaS = Arrays.copyOf(this.oaS, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int hf(long j) {
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int hg(long j) {
        return (int) (j >> 32);
    }

    @VisibleForTesting
    long dR(int i, int i2) {
        return (i2 << 32) | (i & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        if (this.oaS != null) {
            this.oaS[i] = dR(i2, i3);
        }
        if (this.oaT != null) {
            this.oaT[i] = dR(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void NQ(int i) {
        if (this.oaR == null) {
            if (i < 10) {
                i = 10;
            }
            this.oaR = new int[i];
        } else if (this.oaR.length < i) {
            int length = this.oaR.length * 2;
            if (length >= i) {
                i = length;
            }
            this.oaR = Arrays.copyOf(this.oaR, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(List<com.google.android.flexbox.b> list, int i) {
        if (!$assertionsDisabled && this.oaR == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.oaS == null) {
            throw new AssertionError();
        }
        int i2 = this.oaR[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int length = this.oaR.length - 1;
        if (i > length) {
            Arrays.fill(this.oaR, -1);
        } else {
            Arrays.fill(this.oaR, i, length, -1);
        }
        int length2 = this.oaS.length - 1;
        if (i > length2) {
            Arrays.fill(this.oaS, 0L);
        } else {
            Arrays.fill(this.oaS, i, length2, 0L);
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
        List<com.google.android.flexbox.b> oaU;
        int oaV;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.oaU = null;
            this.oaV = 0;
        }
    }
}
