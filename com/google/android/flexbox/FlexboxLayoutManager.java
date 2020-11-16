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
/* loaded from: classes8.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider, com.google.android.flexbox.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Rect pdB;
    private int hMD;
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
    private c.a pdA;
    private boolean pdC;
    private b pdD;
    private a pdE;
    private OrientationHelper pdF;
    private SavedState pdG;
    private SparseArray<View> pdH;
    private int pdI;
    private List<com.google.android.flexbox.b> pdk;
    private int pdm;
    private int pdn;
    private int pdo;
    private int pdp;
    private final c pdz;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        pdB = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.pdm;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.pdn;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.pdp;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.hMD;
    }

    @Override // com.google.android.flexbox.a
    public int k(View view, int i, int i2) {
        return esd() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int ef(View view) {
        return esd() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, pdB);
        if (esd()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.pcU += leftDecorationWidth;
            bVar.pcV = leftDecorationWidth + bVar.pcV;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.pcU += topDecorationHeight;
        bVar.pcV = topDecorationHeight + bVar.pcV;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View Qy(int i) {
        View view = this.pdH.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View Qz(int i) {
        return Qy(i);
    }

    @Override // com.google.android.flexbox.a
    public void a(com.google.android.flexbox.b bVar) {
    }

    @Override // com.google.android.flexbox.a
    public int ak(int i, int i2, int i3) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int al(int i, int i2, int i3) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.pdk.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.pdk.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.pdk.get(i2).pcU);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.pdk.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.pdk.get(i2).pcW;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.pdk = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.pdk;
    }

    @Override // com.google.android.flexbox.a
    public void n(int i, View view) {
        this.pdH.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (esd()) {
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
        if (this.pdG != null) {
            return new SavedState(this.pdG);
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
            this.pdG = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        QL(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        QL(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        QL(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        QL(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        QL(Math.min(i, i2));
    }

    private void QL(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.pdz.QE(childCount);
            this.pdz.QD(childCount);
            this.pdz.QF(childCount);
            if (!$assertionsDisabled && this.pdz.pdh == null) {
                throw new AssertionError();
            }
            if (i < this.pdz.pdh.length) {
                this.pdI = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!esd() && this.mIsRtl) {
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
            esp();
            esr();
            ensureLayoutState();
            this.pdz.QE(itemCount);
            this.pdz.QD(itemCount);
            this.pdz.QF(itemCount);
            this.pdD.pdN = false;
            if (this.pdG != null && this.pdG.QR(itemCount)) {
                this.mPendingScrollPosition = this.pdG.mAnchorPosition;
            }
            if (!this.pdE.mValid || this.mPendingScrollPosition != -1 || this.pdG != null) {
                this.pdE.reset();
                a(state, this.pdE);
                this.pdE.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.pdE.mLayoutFromEnd) {
                b(this.pdE, false, true);
            } else {
                a(this.pdE, false, true);
            }
            QM(itemCount);
            if (this.pdE.mLayoutFromEnd) {
                a(recycler, state, this.pdD);
                i2 = this.pdD.mOffset;
                a(this.pdE, true, false);
                a(recycler, state, this.pdD);
                i = this.pdD.mOffset;
            } else {
                a(recycler, state, this.pdD);
                i = this.pdD.mOffset;
                b(this.pdE, true, false);
                a(recycler, state, this.pdD);
                i2 = this.pdD.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.pdE.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!esd() && this.mIsRtl) {
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
        if (!esd() && this.mIsRtl) {
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

    private void QM(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (esd()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.pdD.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.pdD.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.pdD.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.pdD.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.pdI != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.pdI != -1 ? Math.min(this.pdI, this.pdE.mPosition) : this.pdE.mPosition;
            this.pdA.reset();
            if (esd()) {
                if (this.pdk.size() > 0) {
                    this.pdz.B(this.pdk, min);
                    this.pdz.a(this.pdA, makeMeasureSpec, makeMeasureSpec2, i3, min, this.pdE.mPosition, this.pdk);
                } else {
                    this.pdz.QF(i);
                    this.pdz.a(this.pdA, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.pdk);
                }
            } else if (this.pdk.size() > 0) {
                this.pdz.B(this.pdk, min);
                this.pdz.a(this.pdA, makeMeasureSpec2, makeMeasureSpec, i3, min, this.pdE.mPosition, this.pdk);
            } else {
                this.pdz.QF(i);
                this.pdz.c(this.pdA, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.pdk);
            }
            this.pdk = this.pdA.pdk;
            this.pdz.am(makeMeasureSpec, makeMeasureSpec2, min);
            this.pdz.QC(min);
        } else if (!this.pdE.mLayoutFromEnd) {
            this.pdk.clear();
            if (!$assertionsDisabled && this.pdz.pdh == null) {
                throw new AssertionError();
            }
            this.pdA.reset();
            if (esd()) {
                this.pdz.b(this.pdA, makeMeasureSpec, makeMeasureSpec2, i3, this.pdE.mPosition, this.pdk);
            } else {
                this.pdz.d(this.pdA, makeMeasureSpec, makeMeasureSpec2, i3, this.pdE.mPosition, this.pdk);
            }
            this.pdk = this.pdA.pdk;
            this.pdz.ed(makeMeasureSpec, makeMeasureSpec2);
            this.pdz.esn();
            this.pdE.pdJ = this.pdz.pdh[this.pdE.mPosition];
            this.pdD.pdJ = this.pdE.pdJ;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.pdG = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.pdI = -1;
        this.pdE.reset();
        this.pdH.clear();
    }

    private void esp() {
        int layoutDirection = getLayoutDirection();
        switch (this.pdm) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.pdC = this.pdn == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.pdC = this.pdn == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.pdn == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.pdC = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.pdn == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.pdC = true;
                return;
            default:
                this.mIsRtl = false;
                this.pdC = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.pdG) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.pdJ = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.pdz.pdh != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.pdJ = this.pdz.pdh[aVar.mPosition];
            if (this.pdG == null || !this.pdG.QR(state.getItemCount())) {
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
                } else if (esd() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.pdL = true;
            aVar.pdJ = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View QN;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            QN = QO(state.getItemCount());
        } else {
            QN = QN(state.getItemCount());
        }
        if (QN != null) {
            aVar.ek(QN);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(QN) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(QN) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View QN(int i) {
        if ($assertionsDisabled || this.pdz.pdh != null) {
            View ao = ao(0, getChildCount(), i);
            if (ao == null) {
                return null;
            }
            int i2 = this.pdz.pdh[getPosition(ao)];
            if (i2 != -1) {
                return a(ao, this.pdk.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View QO(int i) {
        if ($assertionsDisabled || this.pdz.pdh != null) {
            View ao = ao(getChildCount() - 1, -1, i);
            if (ao == null) {
                return null;
            }
            return b(ao, this.pdk.get(this.pdz.pdh[getPosition(ao)]));
        }
        throw new AssertionError();
    }

    private View ao(int i, int i2, int i3) {
        View view;
        View view2 = null;
        esr();
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
        boolean esd = esd();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.pdD.mInfinite) && bVar.a(state, this.pdk)) {
                com.google.android.flexbox.b bVar2 = this.pdk.get(bVar.pdJ);
                bVar.mPosition = bVar2.pdd;
                i4 += a(bVar2, bVar);
                if (esd || !this.mIsRtl) {
                    bVar.mOffset += bVar2.esl() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.esl() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.esl();
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
        if (!bVar.pdN) {
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
            if (!$assertionsDisabled && this.pdz.pdh == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.pdz.pdh[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.pdk.get(i);
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!I(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.pde == getPosition(childAt)) {
                            if (i >= this.pdk.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.pdk.get(i4);
                            i2 = i3;
                        }
                        i3++;
                    }
                    recycleChildren(recycler, 0, i2);
                }
            }
        }
    }

    private boolean I(View view, int i) {
        return (esd() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.pdz.pdh == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.pdz.pdh[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.pdk.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!J(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.pdd == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.pdk.get(i4);
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

    private boolean J(View view, int i) {
        return (esd() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return esd() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.pdz.pdi != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.pcW : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.pdo) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.pcU) + paddingRight;
                    f2 = bVar.pcU - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.pcU) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.pcU) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.pcU) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.pcU) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.pcU) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.pdo);
            }
            float f4 = f - this.pdE.pdK;
            float f5 = f2 - this.pdE.pdK;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View Qy = Qy(i6);
                if (Qy == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Qy, pdB);
                        addView(Qy);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(Qy, pdB);
                        addView(Qy, i5);
                        i = i5 + 1;
                    }
                    long j = this.pdz.pdi[i6];
                    int hU = this.pdz.hU(j);
                    int hV = this.pdz.hV(j);
                    if (shouldMeasureChild(Qy, hU, hV, (LayoutParams) Qy.getLayoutParams())) {
                        Qy.measure(hU, hV);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(Qy);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(Qy));
                    int topDecorationHeight = i3 + getTopDecorationHeight(Qy);
                    if (this.mIsRtl) {
                        this.pdz.a(Qy, bVar, Math.round(rightDecorationWidth) - Qy.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + Qy.getMeasuredHeight());
                    } else {
                        this.pdz.a(Qy, bVar, Math.round(leftDecorationWidth), topDecorationHeight, Qy.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + Qy.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + Qy.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(Qy) + max;
                    measuredWidth2 = rightDecorationWidth - (((Qy.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(Qy)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.pdJ += this.pdD.mLayoutDirection;
            return bVar.esl();
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
        if ($assertionsDisabled || this.pdz.pdi != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.pcW;
                i = i5 + bVar.pcW;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.pdo) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.pcU) + paddingBottom;
                    f2 = bVar.pcU - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.pcU) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.pcU) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.pcU) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.pcU) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.pcU) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.pdo);
            }
            float f4 = f - this.pdE.pdK;
            float f5 = f2 - this.pdE.pdK;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View Qy = Qy(i9);
                if (Qy == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.pdz.pdi[i9];
                    int hU = this.pdz.hU(j);
                    int hV = this.pdz.hV(j);
                    if (shouldMeasureChild(Qy, hU, hV, (LayoutParams) Qy.getLayoutParams())) {
                        Qy.measure(hU, hV);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(Qy);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(Qy));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Qy, pdB);
                        addView(Qy);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(Qy, pdB);
                        addView(Qy, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(Qy);
                    int rightDecorationWidth = i - getRightDecorationWidth(Qy);
                    if (this.mIsRtl) {
                        if (this.pdC) {
                            this.pdz.a(Qy, bVar, this.mIsRtl, rightDecorationWidth - Qy.getMeasuredWidth(), Math.round(bottomDecorationHeight) - Qy.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.pdz.a(Qy, bVar, this.mIsRtl, rightDecorationWidth - Qy.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Qy.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.pdC) {
                        this.pdz.a(Qy, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - Qy.getMeasuredHeight(), leftDecorationWidth + Qy.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.pdz.a(Qy, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + Qy.getMeasuredWidth(), Qy.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((Qy.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(Qy)) + max);
                    measuredHeight2 = topDecorationHeight + Qy.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(Qy) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.pdJ += this.pdD.mLayoutDirection;
            return bVar.esl();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean esd() {
        return this.pdm == 0 || this.pdm == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            esq();
        } else {
            this.pdD.mInfinite = false;
        }
        if (!esd() && this.mIsRtl) {
            this.pdD.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.pdD.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.pdD.mPosition = aVar.mPosition;
        this.pdD.mItemDirection = 1;
        this.pdD.mLayoutDirection = 1;
        this.pdD.mOffset = aVar.mCoordinate;
        this.pdD.mScrollingOffset = Integer.MIN_VALUE;
        this.pdD.pdJ = aVar.pdJ;
        if (z && this.pdk.size() > 1 && aVar.pdJ >= 0 && aVar.pdJ < this.pdk.size() - 1) {
            b.i(this.pdD);
            b bVar = this.pdD;
            bVar.mPosition = this.pdk.get(aVar.pdJ).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            esq();
        } else {
            this.pdD.mInfinite = false;
        }
        if (!esd() && this.mIsRtl) {
            this.pdD.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.pdD.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.pdD.mPosition = aVar.mPosition;
        this.pdD.mItemDirection = 1;
        this.pdD.mLayoutDirection = -1;
        this.pdD.mOffset = aVar.mCoordinate;
        this.pdD.mScrollingOffset = Integer.MIN_VALUE;
        this.pdD.pdJ = aVar.pdJ;
        if (z && aVar.pdJ > 0 && this.pdk.size() > aVar.pdJ) {
            b.j(this.pdD);
            this.pdD.mPosition -= this.pdk.get(aVar.pdJ).getItemCount();
        }
    }

    private void esq() {
        int widthMode;
        if (esd()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.pdD.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void esr() {
        if (this.mOrientationHelper == null) {
            if (esd()) {
                if (this.pdn == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.pdF = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.pdF = OrientationHelper.createHorizontalHelper(this);
            } else if (this.pdn == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.pdF = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.pdF = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.pdD == null) {
            this.pdD = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.pdG != null) {
            this.pdG.invalidateAnchor();
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
        return !esd() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return esd() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!esd()) {
            int a2 = a(i, recycler, state);
            this.pdH.clear();
            return a2;
        }
        int QP = QP(i);
        this.pdE.pdK += QP;
        this.pdF.offsetChildren(-QP);
        return QP;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (esd()) {
            int a2 = a(i, recycler, state);
            this.pdH.clear();
            return a2;
        }
        int QP = QP(i);
        this.pdE.pdK += QP;
        this.pdF.offsetChildren(-QP);
        return QP;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        esr();
        this.pdD.pdN = true;
        boolean z = !esd() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        eh(i2, abs);
        int a2 = this.pdD.mScrollingOffset + a(recycler, state, this.pdD);
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
        this.pdD.mLastScrollDelta = i;
        return i;
    }

    private int QP(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        esr();
        boolean esd = esd();
        int width = esd ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = esd ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.pdE.pdK) - width, abs);
            }
            if (this.pdE.pdK + i <= 0) {
                return i;
            }
            return -this.pdE.pdK;
        } else if (i > 0) {
            return Math.min((width2 - this.pdE.pdK) - width, i);
        } else {
            if (this.pdE.pdK + i >= 0) {
                return i;
            }
            return -this.pdE.pdK;
        }
    }

    private void eh(int i, int i2) {
        if (!$assertionsDisabled && this.pdz.pdh == null) {
            throw new AssertionError();
        }
        this.pdD.mLayoutDirection = i;
        boolean esd = esd();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !esd && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.pdD.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.pdk.get(this.pdz.pdh[position]));
            this.pdD.mItemDirection = 1;
            this.pdD.mPosition = this.pdD.mItemDirection + position;
            if (this.pdz.pdh.length <= this.pdD.mPosition) {
                this.pdD.pdJ = -1;
            } else {
                this.pdD.pdJ = this.pdz.pdh[this.pdD.mPosition];
            }
            if (z) {
                this.pdD.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.pdD.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.pdD.mScrollingOffset = this.pdD.mScrollingOffset >= 0 ? this.pdD.mScrollingOffset : 0;
            } else {
                this.pdD.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.pdD.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.pdD.pdJ == -1 || this.pdD.pdJ > this.pdk.size() - 1) && this.pdD.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.pdD.mScrollingOffset;
                this.pdA.reset();
                if (i3 > 0) {
                    if (esd) {
                        this.pdz.a(this.pdA, makeMeasureSpec, makeMeasureSpec2, i3, this.pdD.mPosition, this.pdk);
                    } else {
                        this.pdz.c(this.pdA, makeMeasureSpec, makeMeasureSpec2, i3, this.pdD.mPosition, this.pdk);
                    }
                    this.pdz.am(makeMeasureSpec, makeMeasureSpec2, this.pdD.mPosition);
                    this.pdz.QC(this.pdD.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.pdD.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.pdk.get(this.pdz.pdh[position2]));
            this.pdD.mItemDirection = 1;
            int i4 = this.pdz.pdh[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.pdD.mPosition = position2 - this.pdk.get(i5 - 1).getItemCount();
            } else {
                this.pdD.mPosition = -1;
            }
            this.pdD.pdJ = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.pdD.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.pdD.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.pdD.mScrollingOffset = this.pdD.mScrollingOffset >= 0 ? this.pdD.mScrollingOffset : 0;
            } else {
                this.pdD.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.pdD.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.pdD.mAvailable = i2 - this.pdD.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean esd = esd();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !esd) {
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
        boolean esd = esd();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !esd) {
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
        esr();
        View QN = QN(itemCount);
        View QO = QO(itemCount);
        if (state.getItemCount() == 0 || QN == null || QO == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(QO) - this.mOrientationHelper.getDecoratedStart(QN));
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
        View QN = QN(itemCount);
        View QO = QO(itemCount);
        if (state.getItemCount() == 0 || QN == null || QO == null) {
            return 0;
        }
        if ($assertionsDisabled || this.pdz.pdh != null) {
            int position = getPosition(QN);
            int position2 = getPosition(QO);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(QO) - this.mOrientationHelper.getDecoratedStart(QN));
            int i = this.pdz.pdh[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.pdz.pdh[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(QN)));
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
        View QN = QN(itemCount);
        View QO = QO(itemCount);
        if (state.getItemCount() == 0 || QN == null || QO == null) {
            return 0;
        }
        if ($assertionsDisabled || this.pdz.pdh != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(QO) - this.mOrientationHelper.getDecoratedStart(QN)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int eg(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int eh(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int ei(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int ej(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean r(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int eg = eg(view);
        int ei = ei(view);
        int eh = eh(view);
        int ej = ej(view);
        return z ? (paddingLeft <= eg && width >= eh) && (paddingTop <= ei && height >= ej) : (eg >= width || eh >= paddingLeft) && (ei >= height || ej >= paddingTop);
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
            if (r(childAt, z)) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    /* loaded from: classes8.dex */
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
            /* renamed from: QQ */
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
        public float ese() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float esf() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int esg() {
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
        public boolean esh() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float esi() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int esj() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int esk() {
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
    /* loaded from: classes8.dex */
    public class a {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int mCoordinate;
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;
        private int pdJ;
        private int pdK;
        private boolean pdL;
        final /* synthetic */ FlexboxLayoutManager pdM;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.pdJ = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.pdL = false;
            if (this.pdM.esd()) {
                if (this.pdM.pdn == 0) {
                    this.mLayoutFromEnd = this.pdM.pdm == 1;
                } else {
                    this.mLayoutFromEnd = this.pdM.pdn == 2;
                }
            } else if (this.pdM.pdn == 0) {
                this.mLayoutFromEnd = this.pdM.pdm == 3;
            } else {
                this.mLayoutFromEnd = this.pdM.pdn == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.pdM.esd() && this.pdM.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.pdM.mOrientationHelper.getEndAfterPadding() : this.pdM.getWidth() - this.pdM.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.pdM.mOrientationHelper.getEndAfterPadding() : this.pdM.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ek(View view) {
            if (!this.pdM.esd() && this.pdM.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.pdM.mOrientationHelper.getDecoratedStart(view) + this.pdM.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.pdM.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.pdM.mOrientationHelper.getDecoratedEnd(view) + this.pdM.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.pdM.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.pdM.getPosition(view);
            this.pdL = false;
            if (!$assertionsDisabled && this.pdM.pdz.pdh == null) {
                throw new AssertionError();
            }
            int i = this.pdM.pdz.pdh[this.mPosition != -1 ? this.mPosition : 0];
            this.pdJ = i != -1 ? i : 0;
            if (this.pdM.pdk.size() > this.pdJ) {
                this.mPosition = ((com.google.android.flexbox.b) this.pdM.pdk.get(this.pdJ)).pdd;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.pdJ + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.pdK + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.pdL + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private int mAvailable;
        private boolean mInfinite;
        private int mItemDirection;
        private int mLastScrollDelta;
        private int mLayoutDirection;
        private int mOffset;
        private int mPosition;
        private int mScrollingOffset;
        private int pdJ;
        private boolean pdN;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.pdJ;
            bVar.pdJ = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.pdJ;
            bVar.pdJ = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.pdJ >= 0 && this.pdJ < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.pdJ + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            /* renamed from: QS */
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
        public boolean QR(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
