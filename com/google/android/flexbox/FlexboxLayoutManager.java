package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.google.android.flexbox.c;
import java.util.List;
/* loaded from: classes9.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider, com.google.android.flexbox.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Rect oSD;
    private int hGZ;
    private final Context mContext;
    private boolean mIsRtl;
    private int mLastHeight;
    private int mLastWidth;
    private OrientationHelper mOrientationHelper;
    private View mParent;
    private int mPendingScrollPosition;
    private int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private RecyclerView.Recycler mRecycler;
    private RecyclerView.State mState;
    private final c oSB;
    private c.a oSC;
    private boolean oSE;
    private b oSF;
    private a oSG;
    private OrientationHelper oSH;
    private SavedState oSI;
    private SparseArray<View> oSJ;
    private int oSK;
    private List<com.google.android.flexbox.b> oSm;
    private int oSo;
    private int oSp;
    private int oSq;
    private int oSr;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        oSD = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.oSo;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.oSp;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.oSr;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.hGZ;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        return eoq() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dQ(View view) {
        return eoq() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, oSD);
        if (eoq()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.oRW += leftDecorationWidth;
            bVar.oRX = leftDecorationWidth + bVar.oRX;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.oRW += topDecorationHeight;
        bVar.oRX = topDecorationHeight + bVar.oRX;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View PA(int i) {
        View view = this.oSJ.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View PB(int i) {
        return PA(i);
    }

    @Override // com.google.android.flexbox.a
    public void a(com.google.android.flexbox.b bVar) {
    }

    @Override // com.google.android.flexbox.a
    public int ah(int i, int i2, int i3) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int ai(int i, int i2, int i3) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.oSm.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.oSm.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.oSm.get(i2).oRW);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.oSm.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.oSm.get(i2).oRY;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.oSm = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.oSm;
    }

    @Override // com.google.android.flexbox.a
    public void n(int i, View view) {
        this.oSJ.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (eoq()) {
            return new PointF(0.0f, i2);
        }
        return new PointF(i2, 0.0f);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.oSI != null) {
            return new SavedState(this.oSI);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
            return savedState;
        }
        savedState.invalidateAnchor();
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.oSI = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        PN(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        PN(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        PN(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        PN(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        PN(Math.min(i, i2));
    }

    private void PN(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.oSB.PG(childCount);
            this.oSB.PF(childCount);
            this.oSB.PH(childCount);
            if (!$assertionsDisabled && this.oSB.oSj == null) {
                throw new AssertionError();
            }
            if (i < this.oSB.oSj.length) {
                this.oSK = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!eoq() && this.mIsRtl) {
                            this.mPendingScrollPositionOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToStart) + this.mOrientationHelper.getEndPadding();
                        } else {
                            this.mPendingScrollPositionOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
                        }
                    }
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        this.mRecycler = recycler;
        this.mState = state;
        int itemCount = state.getItemCount();
        if (itemCount != 0 || !state.isPreLayout()) {
            eoA();
            eoC();
            ensureLayoutState();
            this.oSB.PG(itemCount);
            this.oSB.PF(itemCount);
            this.oSB.PH(itemCount);
            this.oSF.oSP = false;
            if (this.oSI != null && this.oSI.PT(itemCount)) {
                this.mPendingScrollPosition = this.oSI.mAnchorPosition;
            }
            if (!this.oSG.mValid || this.mPendingScrollPosition != -1 || this.oSI != null) {
                this.oSG.reset();
                a(state, this.oSG);
                this.oSG.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.oSG.mLayoutFromEnd) {
                b(this.oSG, false, true);
            } else {
                a(this.oSG, false, true);
            }
            PO(itemCount);
            if (this.oSG.mLayoutFromEnd) {
                a(recycler, state, this.oSF);
                i2 = this.oSF.mOffset;
                a(this.oSG, true, false);
                a(recycler, state, this.oSF);
                i = this.oSF.mOffset;
            } else {
                a(recycler, state, this.oSF);
                i = this.oSF.mOffset;
                b(this.oSG, true, false);
                a(recycler, state, this.oSF);
                i2 = this.oSF.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.oSG.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!eoq() && this.mIsRtl) {
            int endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i;
            if (endAfterPadding <= 0) {
                return 0;
            }
            i2 = a(-endAfterPadding, recycler, state);
        } else {
            int startAfterPadding2 = i - this.mOrientationHelper.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            i2 = -a(startAfterPadding2, recycler, state);
        }
        int i3 = i + i2;
        if (z && (startAfterPadding = i3 - this.mOrientationHelper.getStartAfterPadding()) > 0) {
            this.mOrientationHelper.offsetChildren(-startAfterPadding);
            return i2 - startAfterPadding;
        }
        return i2;
    }

    private int fixLayoutEndGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int endAfterPadding;
        if (!eoq() && this.mIsRtl) {
            int startAfterPadding = i - this.mOrientationHelper.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            i2 = a(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - i;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            i2 = -a(-endAfterPadding2, recycler, state);
        }
        int i3 = i + i2;
        if (z && (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i3) > 0) {
            this.mOrientationHelper.offsetChildren(endAfterPadding);
            return i2 + endAfterPadding;
        }
        return i2;
    }

    private void PO(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (eoq()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.oSF.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.oSF.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.oSF.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.oSF.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.oSK != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.oSK != -1 ? Math.min(this.oSK, this.oSG.mPosition) : this.oSG.mPosition;
            this.oSC.reset();
            if (eoq()) {
                if (this.oSm.size() > 0) {
                    this.oSB.B(this.oSm, min);
                    this.oSB.a(this.oSC, makeMeasureSpec, makeMeasureSpec2, i3, min, this.oSG.mPosition, this.oSm);
                } else {
                    this.oSB.PH(i);
                    this.oSB.a(this.oSC, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.oSm);
                }
            } else if (this.oSm.size() > 0) {
                this.oSB.B(this.oSm, min);
                this.oSB.a(this.oSC, makeMeasureSpec2, makeMeasureSpec, i3, min, this.oSG.mPosition, this.oSm);
            } else {
                this.oSB.PH(i);
                this.oSB.c(this.oSC, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.oSm);
            }
            this.oSm = this.oSC.oSm;
            this.oSB.aj(makeMeasureSpec, makeMeasureSpec2, min);
            this.oSB.PE(min);
        } else if (!this.oSG.mLayoutFromEnd) {
            this.oSm.clear();
            if (!$assertionsDisabled && this.oSB.oSj == null) {
                throw new AssertionError();
            }
            this.oSC.reset();
            if (eoq()) {
                this.oSB.b(this.oSC, makeMeasureSpec, makeMeasureSpec2, i3, this.oSG.mPosition, this.oSm);
            } else {
                this.oSB.d(this.oSC, makeMeasureSpec, makeMeasureSpec2, i3, this.oSG.mPosition, this.oSm);
            }
            this.oSm = this.oSC.oSm;
            this.oSB.dZ(makeMeasureSpec, makeMeasureSpec2);
            this.oSB.eoy();
            this.oSG.oSL = this.oSB.oSj[this.oSG.mPosition];
            this.oSF.oSL = this.oSG.oSL;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.oSI = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.oSK = -1;
        this.oSG.reset();
        this.oSJ.clear();
    }

    private void eoA() {
        int layoutDirection = getLayoutDirection();
        switch (this.oSo) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.oSE = this.oSp == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.oSE = this.oSp == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.oSp == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.oSE = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.oSp == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.oSE = true;
                return;
            default:
                this.mIsRtl = false;
                this.oSE = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.oSI) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.oSL = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.oSB.oSj != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.oSL = this.oSB.oSj[aVar.mPosition];
            if (this.oSI == null || !this.oSI.PT(state.getItemCount())) {
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mOrientationHelper.getDecoratedMeasurement(findViewByPosition) <= this.mOrientationHelper.getTotalSpace()) {
                            if (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding() >= 0) {
                                if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition) < 0) {
                                    aVar.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                                    aVar.mLayoutFromEnd = true;
                                    return true;
                                }
                                if (aVar.mLayoutFromEnd) {
                                    decoratedStart = this.mOrientationHelper.getDecoratedEnd(findViewByPosition) + this.mOrientationHelper.getTotalSpaceChange();
                                } else {
                                    decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition);
                                }
                                aVar.mCoordinate = decoratedStart;
                                return true;
                            }
                            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                            aVar.mLayoutFromEnd = false;
                            return true;
                        }
                        aVar.assignCoordinateFromPadding();
                        return true;
                    }
                    if (getChildCount() > 0) {
                        aVar.mLayoutFromEnd = this.mPendingScrollPosition < getPosition(getChildAt(0));
                    }
                    aVar.assignCoordinateFromPadding();
                    return true;
                } else if (eoq() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.oSN = true;
            aVar.oSL = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View PP;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            PP = PQ(state.getItemCount());
        } else {
            PP = PP(state.getItemCount());
        }
        if (PP != null) {
            aVar.dV(PP);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(PP) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(PP) < this.mOrientationHelper.getStartAfterPadding()) {
                    z = true;
                }
                if (z) {
                    if (aVar.mLayoutFromEnd) {
                        startAfterPadding = this.mOrientationHelper.getEndAfterPadding();
                    } else {
                        startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                    }
                    aVar.mCoordinate = startAfterPadding;
                }
            }
            return true;
        }
        return false;
    }

    private View PP(int i) {
        if ($assertionsDisabled || this.oSB.oSj != null) {
            View al = al(0, getChildCount(), i);
            if (al == null) {
                return null;
            }
            int i2 = this.oSB.oSj[getPosition(al)];
            if (i2 != -1) {
                return a(al, this.oSm.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View PQ(int i) {
        if ($assertionsDisabled || this.oSB.oSj != null) {
            View al = al(getChildCount() - 1, -1, i);
            if (al == null) {
                return null;
            }
            return b(al, this.oSm.get(this.oSB.oSj[getPosition(al)]));
        }
        throw new AssertionError();
    }

    private View al(int i, int i2, int i3) {
        View view;
        View view2 = null;
        eoC();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view3 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view3 == null) {
                        view = view2;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) >= startAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) <= endAfterPadding) {
                    return childAt;
                } else {
                    if (view2 == null) {
                        view = childAt;
                        childAt = view3;
                    }
                }
                i += i4;
                view2 = view;
                view3 = childAt;
            }
            view = view2;
            childAt = view3;
            i += i4;
            view2 = view;
            view3 = childAt;
        }
        if (view2 == null) {
            view2 = view3;
        }
        return view2;
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private int a(RecyclerView.Recycler recycler, RecyclerView.State state, b bVar) {
        if (bVar.mScrollingOffset != Integer.MIN_VALUE) {
            if (bVar.mAvailable < 0) {
                bVar.mScrollingOffset += bVar.mAvailable;
            }
            a(recycler, bVar);
        }
        int i = bVar.mAvailable;
        int i2 = bVar.mAvailable;
        boolean eoq = eoq();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.oSF.mInfinite) && bVar.a(state, this.oSm)) {
                com.google.android.flexbox.b bVar2 = this.oSm.get(bVar.oSL);
                bVar.mPosition = bVar2.oSf;
                i4 += a(bVar2, bVar);
                if (eoq || !this.mIsRtl) {
                    bVar.mOffset += bVar2.eow() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.eow() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.eow();
            }
        }
        bVar.mAvailable -= i4;
        if (bVar.mScrollingOffset != Integer.MIN_VALUE) {
            bVar.mScrollingOffset += i4;
            if (bVar.mAvailable < 0) {
                bVar.mScrollingOffset += bVar.mAvailable;
            }
            a(recycler, bVar);
        }
        return i - bVar.mAvailable;
    }

    private void a(RecyclerView.Recycler recycler, b bVar) {
        if (!bVar.oSP) {
            return;
        }
        if (bVar.mLayoutDirection == -1) {
            c(recycler, bVar);
        } else {
            b(recycler, bVar);
        }
    }

    private void b(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.oSB.oSj == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.oSB.oSj[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.oSm.get(i);
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!G(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.oSg == getPosition(childAt)) {
                            if (i >= this.oSm.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.oSm.get(i4);
                            i2 = i3;
                        }
                        i3++;
                    }
                    recycleChildren(recycler, 0, i2);
                }
            }
        }
    }

    private boolean G(View view, int i) {
        return (eoq() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.oSB.oSj == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.oSB.oSj[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.oSm.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!H(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.oSf == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.oSm.get(i4);
                            i = i4;
                            childCount = i3;
                        }
                        i3--;
                    }
                    recycleChildren(recycler, childCount, i2);
                }
            }
        }
    }

    private boolean H(View view, int i) {
        return (eoq() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return eoq() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.oSB.oSk != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.oRY : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.oSq) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.oRW) + paddingRight;
                    f2 = bVar.oRW - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.oRW) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.oRW) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.oRW) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.oRW) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.oRW) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.oSq);
            }
            float f4 = f - this.oSG.oSM;
            float f5 = f2 - this.oSG.oSM;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View PA = PA(i6);
                if (PA == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(PA, oSD);
                        addView(PA);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(PA, oSD);
                        addView(PA, i5);
                        i = i5 + 1;
                    }
                    long j = this.oSB.oSk[i6];
                    int hv = this.oSB.hv(j);
                    int hw = this.oSB.hw(j);
                    if (shouldMeasureChild(PA, hv, hw, (LayoutParams) PA.getLayoutParams())) {
                        PA.measure(hv, hw);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(PA);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(PA));
                    int topDecorationHeight = i3 + getTopDecorationHeight(PA);
                    if (this.mIsRtl) {
                        this.oSB.a(PA, bVar, Math.round(rightDecorationWidth) - PA.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + PA.getMeasuredHeight());
                    } else {
                        this.oSB.a(PA, bVar, Math.round(leftDecorationWidth), topDecorationHeight, PA.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + PA.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + PA.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(PA) + max;
                    measuredWidth2 = rightDecorationWidth - (((PA.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(PA)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.oSL += this.oSF.mLayoutDirection;
            return bVar.eow();
        }
        throw new AssertionError();
    }

    private int c(com.google.android.flexbox.b bVar, b bVar2) {
        int i;
        int i2;
        float f;
        float f2;
        LayoutParams layoutParams;
        int i3;
        float measuredHeight;
        float measuredHeight2;
        if ($assertionsDisabled || this.oSB.oSk != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.oRY;
                i = i5 + bVar.oRY;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.oSq) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.oRW) + paddingBottom;
                    f2 = bVar.oRW - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.oRW) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.oRW) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.oRW) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.oRW) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.oRW) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.oSq);
            }
            float f4 = f - this.oSG.oSM;
            float f5 = f2 - this.oSG.oSM;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View PA = PA(i9);
                if (PA == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.oSB.oSk[i9];
                    int hv = this.oSB.hv(j);
                    int hw = this.oSB.hw(j);
                    if (shouldMeasureChild(PA, hv, hw, (LayoutParams) PA.getLayoutParams())) {
                        PA.measure(hv, hw);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(PA);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(PA));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(PA, oSD);
                        addView(PA);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(PA, oSD);
                        addView(PA, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(PA);
                    int rightDecorationWidth = i - getRightDecorationWidth(PA);
                    if (this.mIsRtl) {
                        if (this.oSE) {
                            this.oSB.a(PA, bVar, this.mIsRtl, rightDecorationWidth - PA.getMeasuredWidth(), Math.round(bottomDecorationHeight) - PA.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.oSB.a(PA, bVar, this.mIsRtl, rightDecorationWidth - PA.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, PA.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.oSE) {
                        this.oSB.a(PA, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - PA.getMeasuredHeight(), leftDecorationWidth + PA.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.oSB.a(PA, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + PA.getMeasuredWidth(), PA.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((PA.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(PA)) + max);
                    measuredHeight2 = topDecorationHeight + PA.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(PA) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.oSL += this.oSF.mLayoutDirection;
            return bVar.eow();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean eoq() {
        return this.oSo == 0 || this.oSo == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            eoB();
        } else {
            this.oSF.mInfinite = false;
        }
        if (!eoq() && this.mIsRtl) {
            this.oSF.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.oSF.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.oSF.mPosition = aVar.mPosition;
        this.oSF.mItemDirection = 1;
        this.oSF.mLayoutDirection = 1;
        this.oSF.mOffset = aVar.mCoordinate;
        this.oSF.mScrollingOffset = Integer.MIN_VALUE;
        this.oSF.oSL = aVar.oSL;
        if (z && this.oSm.size() > 1 && aVar.oSL >= 0 && aVar.oSL < this.oSm.size() - 1) {
            b.i(this.oSF);
            b bVar = this.oSF;
            bVar.mPosition = this.oSm.get(aVar.oSL).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            eoB();
        } else {
            this.oSF.mInfinite = false;
        }
        if (!eoq() && this.mIsRtl) {
            this.oSF.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.oSF.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.oSF.mPosition = aVar.mPosition;
        this.oSF.mItemDirection = 1;
        this.oSF.mLayoutDirection = -1;
        this.oSF.mOffset = aVar.mCoordinate;
        this.oSF.mScrollingOffset = Integer.MIN_VALUE;
        this.oSF.oSL = aVar.oSL;
        if (z && aVar.oSL > 0 && this.oSm.size() > aVar.oSL) {
            b.j(this.oSF);
            this.oSF.mPosition -= this.oSm.get(aVar.oSL).getItemCount();
        }
    }

    private void eoB() {
        int widthMode;
        if (eoq()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.oSF.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void eoC() {
        if (this.mOrientationHelper == null) {
            if (eoq()) {
                if (this.oSp == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.oSH = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.oSH = OrientationHelper.createHorizontalHelper(this);
            } else if (this.oSp == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.oSH = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.oSH = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.oSF == null) {
            this.oSF = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.oSI != null) {
            this.oSI.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mParent = (View) recyclerView.getParent();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return !eoq() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return eoq() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!eoq()) {
            int a2 = a(i, recycler, state);
            this.oSJ.clear();
            return a2;
        }
        int PR = PR(i);
        this.oSG.oSM += PR;
        this.oSH.offsetChildren(-PR);
        return PR;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (eoq()) {
            int a2 = a(i, recycler, state);
            this.oSJ.clear();
            return a2;
        }
        int PR = PR(i);
        this.oSG.oSM += PR;
        this.oSH.offsetChildren(-PR);
        return PR;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        eoC();
        this.oSF.oSP = true;
        boolean z = !eoq() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        ed(i2, abs);
        int a2 = this.oSF.mScrollingOffset + a(recycler, state, this.oSF);
        if (a2 < 0) {
            return 0;
        }
        if (z) {
            if (abs > a2) {
                i = (-i2) * a2;
            }
        } else if (abs > a2) {
            i = i2 * a2;
        }
        this.mOrientationHelper.offsetChildren(-i);
        this.oSF.mLastScrollDelta = i;
        return i;
    }

    private int PR(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        eoC();
        boolean eoq = eoq();
        int width = eoq ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = eoq ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.oSG.oSM) - width, abs);
            }
            if (this.oSG.oSM + i <= 0) {
                return i;
            }
            return -this.oSG.oSM;
        } else if (i > 0) {
            return Math.min((width2 - this.oSG.oSM) - width, i);
        } else {
            if (this.oSG.oSM + i >= 0) {
                return i;
            }
            return -this.oSG.oSM;
        }
    }

    private void ed(int i, int i2) {
        if (!$assertionsDisabled && this.oSB.oSj == null) {
            throw new AssertionError();
        }
        this.oSF.mLayoutDirection = i;
        boolean eoq = eoq();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !eoq && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.oSF.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.oSm.get(this.oSB.oSj[position]));
            this.oSF.mItemDirection = 1;
            this.oSF.mPosition = this.oSF.mItemDirection + position;
            if (this.oSB.oSj.length <= this.oSF.mPosition) {
                this.oSF.oSL = -1;
            } else {
                this.oSF.oSL = this.oSB.oSj[this.oSF.mPosition];
            }
            if (z) {
                this.oSF.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.oSF.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.oSF.mScrollingOffset = this.oSF.mScrollingOffset >= 0 ? this.oSF.mScrollingOffset : 0;
            } else {
                this.oSF.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.oSF.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.oSF.oSL == -1 || this.oSF.oSL > this.oSm.size() - 1) && this.oSF.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.oSF.mScrollingOffset;
                this.oSC.reset();
                if (i3 > 0) {
                    if (eoq) {
                        this.oSB.a(this.oSC, makeMeasureSpec, makeMeasureSpec2, i3, this.oSF.mPosition, this.oSm);
                    } else {
                        this.oSB.c(this.oSC, makeMeasureSpec, makeMeasureSpec2, i3, this.oSF.mPosition, this.oSm);
                    }
                    this.oSB.aj(makeMeasureSpec, makeMeasureSpec2, this.oSF.mPosition);
                    this.oSB.PE(this.oSF.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.oSF.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.oSm.get(this.oSB.oSj[position2]));
            this.oSF.mItemDirection = 1;
            int i4 = this.oSB.oSj[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.oSF.mPosition = position2 - this.oSm.get(i5 - 1).getItemCount();
            } else {
                this.oSF.mPosition = -1;
            }
            this.oSF.oSL = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.oSF.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.oSF.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.oSF.mScrollingOffset = this.oSF.mScrollingOffset >= 0 ? this.oSF.mScrollingOffset : 0;
            } else {
                this.oSF.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.oSF.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.oSF.mAvailable = i2 - this.oSF.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean eoq = eoq();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !eoq) {
                    if (this.mOrientationHelper.getDecoratedEnd(view2) < this.mOrientationHelper.getDecoratedEnd(childAt)) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(view2) > this.mOrientationHelper.getDecoratedStart(childAt)) {
                    view2 = childAt;
                }
            }
        }
        return view2;
    }

    private View b(View view, com.google.android.flexbox.b bVar) {
        boolean eoq = eoq();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !eoq) {
                    if (this.mOrientationHelper.getDecoratedStart(view2) > this.mOrientationHelper.getDecoratedStart(childAt)) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedEnd(view2) < this.mOrientationHelper.getDecoratedEnd(childAt)) {
                    view2 = childAt;
                }
            }
        }
        return view2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        eoC();
        View PP = PP(itemCount);
        View PQ = PQ(itemCount);
        if (state.getItemCount() == 0 || PP == null || PQ == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(PQ) - this.mOrientationHelper.getDecoratedStart(PP));
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        computeScrollOffset(state);
        return computeScrollOffset(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View PP = PP(itemCount);
        View PQ = PQ(itemCount);
        if (state.getItemCount() == 0 || PP == null || PQ == null) {
            return 0;
        }
        if ($assertionsDisabled || this.oSB.oSj != null) {
            int position = getPosition(PP);
            int position2 = getPosition(PQ);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(PQ) - this.mOrientationHelper.getDecoratedStart(PP));
            int i = this.oSB.oSj[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.oSB.oSj[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(PP)));
        }
        throw new AssertionError();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View PP = PP(itemCount);
        View PQ = PQ(itemCount);
        if (state.getItemCount() == 0 || PP == null || PQ == null) {
            return 0;
        }
        if ($assertionsDisabled || this.oSB.oSj != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(PQ) - this.mOrientationHelper.getDecoratedStart(PP)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
        }
        throw new AssertionError();
    }

    private boolean shouldMeasureChild(View view, int i, int i2, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i, layoutParams.width) && isMeasurementUpToDate(view.getHeight(), i2, layoutParams.height)) ? false : true;
    }

    private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 <= 0 || i == i3) {
            switch (mode) {
                case Integer.MIN_VALUE:
                    return size >= i;
                case 0:
                    return true;
                case 1073741824:
                    return size == i;
                default:
                    return false;
            }
        }
        return false;
    }

    private int dR(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int dS(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int dT(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int dU(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean p(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int dR = dR(view);
        int dT = dT(view);
        int dS = dS(view);
        int dU = dU(view);
        return z ? (paddingLeft <= dR && width >= dS) && (paddingTop <= dT && height >= dU) : (dR >= width || dS >= paddingLeft) && (dT >= height || dU >= paddingTop);
    }

    public int findFirstVisibleItemPosition() {
        View n = n(0, getChildCount(), false);
        if (n == null) {
            return -1;
        }
        return getPosition(n);
    }

    public int findLastVisibleItemPosition() {
        View n = n(getChildCount() - 1, -1, false);
        if (n == null) {
            return -1;
        }
        return getPosition(n);
    }

    private View n(int i, int i2, boolean z) {
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = getChildAt(i);
            if (p(childAt, z)) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    /* loaded from: classes9.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.LayoutParams.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ao */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: PS */
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        };
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return this.width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return this.height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eor() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean eos() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float eot() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eou() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eov() {
            return this.bottomMargin;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int mCoordinate;
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;
        private int oSL;
        private int oSM;
        private boolean oSN;
        final /* synthetic */ FlexboxLayoutManager oSO;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.oSL = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.oSN = false;
            if (this.oSO.eoq()) {
                if (this.oSO.oSp == 0) {
                    this.mLayoutFromEnd = this.oSO.oSo == 1;
                } else {
                    this.mLayoutFromEnd = this.oSO.oSp == 2;
                }
            } else if (this.oSO.oSp == 0) {
                this.mLayoutFromEnd = this.oSO.oSo == 3;
            } else {
                this.mLayoutFromEnd = this.oSO.oSp == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.oSO.eoq() && this.oSO.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.oSO.mOrientationHelper.getEndAfterPadding() : this.oSO.getWidth() - this.oSO.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.oSO.mOrientationHelper.getEndAfterPadding() : this.oSO.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dV(View view) {
            if (!this.oSO.eoq() && this.oSO.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.oSO.mOrientationHelper.getDecoratedStart(view) + this.oSO.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.oSO.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.oSO.mOrientationHelper.getDecoratedEnd(view) + this.oSO.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.oSO.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.oSO.getPosition(view);
            this.oSN = false;
            if (!$assertionsDisabled && this.oSO.oSB.oSj == null) {
                throw new AssertionError();
            }
            int i = this.oSO.oSB.oSj[this.mPosition != -1 ? this.mPosition : 0];
            this.oSL = i != -1 ? i : 0;
            if (this.oSO.oSm.size() > this.oSL) {
                this.mPosition = ((com.google.android.flexbox.b) this.oSO.oSm.get(this.oSL)).oSf;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.oSL + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.oSM + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.oSN + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private int mAvailable;
        private boolean mInfinite;
        private int mItemDirection;
        private int mLastScrollDelta;
        private int mLayoutDirection;
        private int mOffset;
        private int mPosition;
        private int mScrollingOffset;
        private int oSL;
        private boolean oSP;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.oSL;
            bVar.oSL = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.oSL;
            bVar.oSL = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.oSL >= 0 && this.oSL < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.oSL + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ap */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: PU */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private int mAnchorOffset;
        private int mAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean PT(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
