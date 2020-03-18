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
/* loaded from: classes5.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider, com.google.android.flexbox.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Rect mLL;
    private final Context mContext;
    private boolean mIsRtl;
    private int mLA;
    private final c mLJ;
    private c.a mLK;
    private boolean mLM;
    private b mLN;
    private a mLO;
    private OrientationHelper mLP;
    private SavedState mLQ;
    private SparseArray<View> mLR;
    private int mLS;
    private int mLastHeight;
    private int mLastWidth;
    private List<com.google.android.flexbox.b> mLt;
    private int mLv;
    private int mLw;
    private int mLx;
    private int mLy;
    private OrientationHelper mOrientationHelper;
    private View mParent;
    private int mPendingScrollPosition;
    private int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private RecyclerView.Recycler mRecycler;
    private RecyclerView.State mState;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        mLL = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mLv;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mLw;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mLy;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mLA;
    }

    @Override // com.google.android.flexbox.a
    public int h(View view, int i, int i2) {
        return dAJ() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int ds(View view) {
        return dAJ() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, mLL);
        if (dAJ()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.mLd += leftDecorationWidth;
            bVar.mLe = leftDecorationWidth + bVar.mLe;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.mLd += topDecorationHeight;
        bVar.mLe = topDecorationHeight + bVar.mLe;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View Mk(int i) {
        View view = this.mLR.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View Ml(int i) {
        return Mk(i);
    }

    @Override // com.google.android.flexbox.a
    public void a(com.google.android.flexbox.b bVar) {
    }

    @Override // com.google.android.flexbox.a
    public int an(int i, int i2, int i3) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int ao(int i, int i2, int i3) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.mLt.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.mLt.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mLt.get(i2).mLd);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mLt.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mLt.get(i2).mLf;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.mLt = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.mLt;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i, View view) {
        this.mLR.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dAJ()) {
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
        if (this.mLQ != null) {
            return new SavedState(this.mLQ);
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
            this.mLQ = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        Mx(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        Mx(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        Mx(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        Mx(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        Mx(Math.min(i, i2));
    }

    private void Mx(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.mLJ.Mq(childCount);
            this.mLJ.Mp(childCount);
            this.mLJ.Mr(childCount);
            if (!$assertionsDisabled && this.mLJ.mLq == null) {
                throw new AssertionError();
            }
            if (i < this.mLJ.mLq.length) {
                this.mLS = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dAJ() && this.mIsRtl) {
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
            dAT();
            dAV();
            ensureLayoutState();
            this.mLJ.Mq(itemCount);
            this.mLJ.Mp(itemCount);
            this.mLJ.Mr(itemCount);
            this.mLN.mLX = false;
            if (this.mLQ != null && this.mLQ.MD(itemCount)) {
                this.mPendingScrollPosition = this.mLQ.mAnchorPosition;
            }
            if (!this.mLO.mValid || this.mPendingScrollPosition != -1 || this.mLQ != null) {
                this.mLO.reset();
                a(state, this.mLO);
                this.mLO.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.mLO.mLayoutFromEnd) {
                b(this.mLO, false, true);
            } else {
                a(this.mLO, false, true);
            }
            My(itemCount);
            if (this.mLO.mLayoutFromEnd) {
                a(recycler, state, this.mLN);
                i2 = this.mLN.mOffset;
                a(this.mLO, true, false);
                a(recycler, state, this.mLN);
                i = this.mLN.mOffset;
            } else {
                a(recycler, state, this.mLN);
                i = this.mLN.mOffset;
                b(this.mLO, true, false);
                a(recycler, state, this.mLN);
                i2 = this.mLN.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.mLO.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dAJ() && this.mIsRtl) {
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
        if (!dAJ() && this.mIsRtl) {
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

    private void My(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (dAJ()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.mLN.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.mLN.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.mLN.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.mLN.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.mLS != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.mLS != -1 ? Math.min(this.mLS, this.mLO.mPosition) : this.mLO.mPosition;
            this.mLK.reset();
            if (dAJ()) {
                if (this.mLt.size() > 0) {
                    this.mLJ.q(this.mLt, min);
                    this.mLJ.a(this.mLK, makeMeasureSpec, makeMeasureSpec2, i3, min, this.mLO.mPosition, this.mLt);
                } else {
                    this.mLJ.Mr(i);
                    this.mLJ.a(this.mLK, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mLt);
                }
            } else if (this.mLt.size() > 0) {
                this.mLJ.q(this.mLt, min);
                this.mLJ.a(this.mLK, makeMeasureSpec2, makeMeasureSpec, i3, min, this.mLO.mPosition, this.mLt);
            } else {
                this.mLJ.Mr(i);
                this.mLJ.c(this.mLK, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mLt);
            }
            this.mLt = this.mLK.mLt;
            this.mLJ.ap(makeMeasureSpec, makeMeasureSpec2, min);
            this.mLJ.Mo(min);
        } else if (!this.mLO.mLayoutFromEnd) {
            this.mLt.clear();
            if (!$assertionsDisabled && this.mLJ.mLq == null) {
                throw new AssertionError();
            }
            this.mLK.reset();
            if (dAJ()) {
                this.mLJ.b(this.mLK, makeMeasureSpec, makeMeasureSpec2, i3, this.mLO.mPosition, this.mLt);
            } else {
                this.mLJ.d(this.mLK, makeMeasureSpec, makeMeasureSpec2, i3, this.mLO.mPosition, this.mLt);
            }
            this.mLt = this.mLK.mLt;
            this.mLJ.ec(makeMeasureSpec, makeMeasureSpec2);
            this.mLJ.dAR();
            this.mLO.mLT = this.mLJ.mLq[this.mLO.mPosition];
            this.mLN.mLT = this.mLO.mLT;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mLQ = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLS = -1;
        this.mLO.reset();
        this.mLR.clear();
    }

    private void dAT() {
        int layoutDirection = getLayoutDirection();
        switch (this.mLv) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.mLM = this.mLw == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.mLM = this.mLw == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.mLw == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mLM = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.mLw == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mLM = true;
                return;
            default:
                this.mIsRtl = false;
                this.mLM = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.mLQ) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.mLT = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.mLJ.mLq != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.mLT = this.mLJ.mLq[aVar.mPosition];
            if (this.mLQ == null || !this.mLQ.MD(state.getItemCount())) {
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
                } else if (dAJ() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.mLV = true;
            aVar.mLT = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View Mz;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            Mz = MA(state.getItemCount());
        } else {
            Mz = Mz(state.getItemCount());
        }
        if (Mz != null) {
            aVar.dx(Mz);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(Mz) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(Mz) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View Mz(int i) {
        if ($assertionsDisabled || this.mLJ.mLq != null) {
            View ar = ar(0, getChildCount(), i);
            if (ar == null) {
                return null;
            }
            int i2 = this.mLJ.mLq[getPosition(ar)];
            if (i2 != -1) {
                return a(ar, this.mLt.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View MA(int i) {
        if ($assertionsDisabled || this.mLJ.mLq != null) {
            View ar = ar(getChildCount() - 1, -1, i);
            if (ar == null) {
                return null;
            }
            return b(ar, this.mLt.get(this.mLJ.mLq[getPosition(ar)]));
        }
        throw new AssertionError();
    }

    private View ar(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dAV();
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
        boolean dAJ = dAJ();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.mLN.mInfinite) && bVar.a(state, this.mLt)) {
                com.google.android.flexbox.b bVar2 = this.mLt.get(bVar.mLT);
                bVar.mPosition = bVar2.mLm;
                i4 += a(bVar2, bVar);
                if (dAJ || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dAP() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dAP() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dAP();
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
        if (!bVar.mLX) {
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
            if (!$assertionsDisabled && this.mLJ.mLq == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mLJ.mLq[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.mLt.get(i);
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!z(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mLn == getPosition(childAt)) {
                            if (i >= this.mLt.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.mLt.get(i4);
                            i2 = i3;
                        }
                        i3++;
                    }
                    recycleChildren(recycler, 0, i2);
                }
            }
        }
    }

    private boolean z(View view, int i) {
        return (dAJ() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.mLJ.mLq == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mLJ.mLq[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.mLt.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mLm == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.mLt.get(i4);
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

    private boolean A(View view, int i) {
        return (dAJ() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dAJ() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.mLJ.mLr != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.mLf : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mLx) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.mLd) + paddingRight;
                    f2 = bVar.mLd - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.mLd) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.mLd) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.mLd) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mLd) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mLd) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mLx);
            }
            float f4 = f - this.mLO.mLU;
            float f5 = f2 - this.mLO.mLU;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View Mk = Mk(i6);
                if (Mk == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Mk, mLL);
                        addView(Mk);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(Mk, mLL);
                        addView(Mk, i5);
                        i = i5 + 1;
                    }
                    long j = this.mLJ.mLr[i6];
                    int gP = this.mLJ.gP(j);
                    int gQ = this.mLJ.gQ(j);
                    if (shouldMeasureChild(Mk, gP, gQ, (LayoutParams) Mk.getLayoutParams())) {
                        Mk.measure(gP, gQ);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(Mk);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(Mk));
                    int topDecorationHeight = i3 + getTopDecorationHeight(Mk);
                    if (this.mIsRtl) {
                        this.mLJ.a(Mk, bVar, Math.round(rightDecorationWidth) - Mk.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + Mk.getMeasuredHeight());
                    } else {
                        this.mLJ.a(Mk, bVar, Math.round(leftDecorationWidth), topDecorationHeight, Mk.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + Mk.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + Mk.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(Mk) + max;
                    measuredWidth2 = rightDecorationWidth - (((Mk.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(Mk)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.mLT += this.mLN.mLayoutDirection;
            return bVar.dAP();
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
        if ($assertionsDisabled || this.mLJ.mLr != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.mLf;
                i = i5 + bVar.mLf;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mLx) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.mLd) + paddingBottom;
                    f2 = bVar.mLd - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.mLd) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.mLd) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.mLd) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mLd) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mLd) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mLx);
            }
            float f4 = f - this.mLO.mLU;
            float f5 = f2 - this.mLO.mLU;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View Mk = Mk(i9);
                if (Mk == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.mLJ.mLr[i9];
                    int gP = this.mLJ.gP(j);
                    int gQ = this.mLJ.gQ(j);
                    if (shouldMeasureChild(Mk, gP, gQ, (LayoutParams) Mk.getLayoutParams())) {
                        Mk.measure(gP, gQ);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(Mk);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(Mk));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Mk, mLL);
                        addView(Mk);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(Mk, mLL);
                        addView(Mk, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(Mk);
                    int rightDecorationWidth = i - getRightDecorationWidth(Mk);
                    if (this.mIsRtl) {
                        if (this.mLM) {
                            this.mLJ.a(Mk, bVar, this.mIsRtl, rightDecorationWidth - Mk.getMeasuredWidth(), Math.round(bottomDecorationHeight) - Mk.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.mLJ.a(Mk, bVar, this.mIsRtl, rightDecorationWidth - Mk.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Mk.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.mLM) {
                        this.mLJ.a(Mk, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - Mk.getMeasuredHeight(), leftDecorationWidth + Mk.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.mLJ.a(Mk, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + Mk.getMeasuredWidth(), Mk.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((Mk.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(Mk)) + max);
                    measuredHeight2 = topDecorationHeight + Mk.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(Mk) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.mLT += this.mLN.mLayoutDirection;
            return bVar.dAP();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dAJ() {
        return this.mLv == 0 || this.mLv == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dAU();
        } else {
            this.mLN.mInfinite = false;
        }
        if (!dAJ() && this.mIsRtl) {
            this.mLN.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.mLN.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.mLN.mPosition = aVar.mPosition;
        this.mLN.mItemDirection = 1;
        this.mLN.mLayoutDirection = 1;
        this.mLN.mOffset = aVar.mCoordinate;
        this.mLN.mScrollingOffset = Integer.MIN_VALUE;
        this.mLN.mLT = aVar.mLT;
        if (z && this.mLt.size() > 1 && aVar.mLT >= 0 && aVar.mLT < this.mLt.size() - 1) {
            b.i(this.mLN);
            b bVar = this.mLN;
            bVar.mPosition = this.mLt.get(aVar.mLT).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dAU();
        } else {
            this.mLN.mInfinite = false;
        }
        if (!dAJ() && this.mIsRtl) {
            this.mLN.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.mLN.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mLN.mPosition = aVar.mPosition;
        this.mLN.mItemDirection = 1;
        this.mLN.mLayoutDirection = -1;
        this.mLN.mOffset = aVar.mCoordinate;
        this.mLN.mScrollingOffset = Integer.MIN_VALUE;
        this.mLN.mLT = aVar.mLT;
        if (z && aVar.mLT > 0 && this.mLt.size() > aVar.mLT) {
            b.j(this.mLN);
            this.mLN.mPosition -= this.mLt.get(aVar.mLT).getItemCount();
        }
    }

    private void dAU() {
        int widthMode;
        if (dAJ()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.mLN.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dAV() {
        if (this.mOrientationHelper == null) {
            if (dAJ()) {
                if (this.mLw == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.mLP = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mLP = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mLw == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mLP = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mLP = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.mLN == null) {
            this.mLN = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mLQ != null) {
            this.mLQ.invalidateAnchor();
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
        return !dAJ() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dAJ() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dAJ()) {
            int a2 = a(i, recycler, state);
            this.mLR.clear();
            return a2;
        }
        int MB = MB(i);
        this.mLO.mLU += MB;
        this.mLP.offsetChildren(-MB);
        return MB;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dAJ()) {
            int a2 = a(i, recycler, state);
            this.mLR.clear();
            return a2;
        }
        int MB = MB(i);
        this.mLO.mLU += MB;
        this.mLP.offsetChildren(-MB);
        return MB;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dAV();
        this.mLN.mLX = true;
        boolean z = !dAJ() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        eg(i2, abs);
        int a2 = this.mLN.mScrollingOffset + a(recycler, state, this.mLN);
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
        this.mLN.mLastScrollDelta = i;
        return i;
    }

    private int MB(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dAV();
        boolean dAJ = dAJ();
        int width = dAJ ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dAJ ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.mLO.mLU) - width, abs);
            }
            if (this.mLO.mLU + i <= 0) {
                return i;
            }
            return -this.mLO.mLU;
        } else if (i > 0) {
            return Math.min((width2 - this.mLO.mLU) - width, i);
        } else {
            if (this.mLO.mLU + i >= 0) {
                return i;
            }
            return -this.mLO.mLU;
        }
    }

    private void eg(int i, int i2) {
        if (!$assertionsDisabled && this.mLJ.mLq == null) {
            throw new AssertionError();
        }
        this.mLN.mLayoutDirection = i;
        boolean dAJ = dAJ();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dAJ && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.mLN.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.mLt.get(this.mLJ.mLq[position]));
            this.mLN.mItemDirection = 1;
            this.mLN.mPosition = this.mLN.mItemDirection + position;
            if (this.mLJ.mLq.length <= this.mLN.mPosition) {
                this.mLN.mLT = -1;
            } else {
                this.mLN.mLT = this.mLJ.mLq[this.mLN.mPosition];
            }
            if (z) {
                this.mLN.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.mLN.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.mLN.mScrollingOffset = this.mLN.mScrollingOffset >= 0 ? this.mLN.mScrollingOffset : 0;
            } else {
                this.mLN.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.mLN.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mLN.mLT == -1 || this.mLN.mLT > this.mLt.size() - 1) && this.mLN.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.mLN.mScrollingOffset;
                this.mLK.reset();
                if (i3 > 0) {
                    if (dAJ) {
                        this.mLJ.a(this.mLK, makeMeasureSpec, makeMeasureSpec2, i3, this.mLN.mPosition, this.mLt);
                    } else {
                        this.mLJ.c(this.mLK, makeMeasureSpec, makeMeasureSpec2, i3, this.mLN.mPosition, this.mLt);
                    }
                    this.mLJ.ap(makeMeasureSpec, makeMeasureSpec2, this.mLN.mPosition);
                    this.mLJ.Mo(this.mLN.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.mLN.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.mLt.get(this.mLJ.mLq[position2]));
            this.mLN.mItemDirection = 1;
            int i4 = this.mLJ.mLq[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.mLN.mPosition = position2 - this.mLt.get(i5 - 1).getItemCount();
            } else {
                this.mLN.mPosition = -1;
            }
            this.mLN.mLT = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.mLN.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.mLN.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.mLN.mScrollingOffset = this.mLN.mScrollingOffset >= 0 ? this.mLN.mScrollingOffset : 0;
            } else {
                this.mLN.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.mLN.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.mLN.mAvailable = i2 - this.mLN.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dAJ = dAJ();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dAJ) {
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
        boolean dAJ = dAJ();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dAJ) {
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
        dAV();
        View Mz = Mz(itemCount);
        View MA = MA(itemCount);
        if (state.getItemCount() == 0 || Mz == null || MA == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(MA) - this.mOrientationHelper.getDecoratedStart(Mz));
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
        View Mz = Mz(itemCount);
        View MA = MA(itemCount);
        if (state.getItemCount() == 0 || Mz == null || MA == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mLJ.mLq != null) {
            int position = getPosition(Mz);
            int position2 = getPosition(MA);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(MA) - this.mOrientationHelper.getDecoratedStart(Mz));
            int i = this.mLJ.mLq[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.mLJ.mLq[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(Mz)));
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
        View Mz = Mz(itemCount);
        View MA = MA(itemCount);
        if (state.getItemCount() == 0 || Mz == null || MA == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mLJ.mLq != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(MA) - this.mOrientationHelper.getDecoratedStart(Mz)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int dt(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int du(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int dv(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int dw(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean n(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int dt = dt(view);
        int dv = dv(view);
        int du = du(view);
        int dw = dw(view);
        return z ? (paddingLeft <= dt && width >= du) && (paddingTop <= dv && height >= dw) : (dt >= width || du >= paddingLeft) && (dv >= height || dw >= paddingTop);
    }

    public int findFirstVisibleItemPosition() {
        View t = t(0, getChildCount(), false);
        if (t == null) {
            return -1;
        }
        return getPosition(t);
    }

    public int findLastVisibleItemPosition() {
        View t = t(getChildCount() - 1, -1, false);
        if (t == null) {
            return -1;
        }
        return getPosition(t);
    }

    private View t(int i, int i2, boolean z) {
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = getChildAt(i);
            if (n(childAt, z)) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    /* loaded from: classes5.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.LayoutParams.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: aP */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: MC */
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
        public int dAK() {
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
        public boolean dAL() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dAM() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dAN() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dAO() {
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
    /* loaded from: classes5.dex */
    public class a {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int mCoordinate;
        private int mLT;
        private int mLU;
        private boolean mLV;
        final /* synthetic */ FlexboxLayoutManager mLW;
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mLT = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mLV = false;
            if (this.mLW.dAJ()) {
                if (this.mLW.mLw == 0) {
                    this.mLayoutFromEnd = this.mLW.mLv == 1;
                } else {
                    this.mLayoutFromEnd = this.mLW.mLw == 2;
                }
            } else if (this.mLW.mLw == 0) {
                this.mLayoutFromEnd = this.mLW.mLv == 3;
            } else {
                this.mLayoutFromEnd = this.mLW.mLw == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.mLW.dAJ() && this.mLW.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.mLW.mOrientationHelper.getEndAfterPadding() : this.mLW.getWidth() - this.mLW.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.mLW.mOrientationHelper.getEndAfterPadding() : this.mLW.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dx(View view) {
            if (!this.mLW.dAJ() && this.mLW.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.mLW.mOrientationHelper.getDecoratedStart(view) + this.mLW.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.mLW.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mLW.mOrientationHelper.getDecoratedEnd(view) + this.mLW.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mLW.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.mLW.getPosition(view);
            this.mLV = false;
            if (!$assertionsDisabled && this.mLW.mLJ.mLq == null) {
                throw new AssertionError();
            }
            int i = this.mLW.mLJ.mLq[this.mPosition != -1 ? this.mPosition : 0];
            this.mLT = i != -1 ? i : 0;
            if (this.mLW.mLt.size() > this.mLT) {
                this.mPosition = ((com.google.android.flexbox.b) this.mLW.mLt.get(this.mLT)).mLm;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mLT + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mLU + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mLV + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {
        private int mAvailable;
        private boolean mInfinite;
        private int mItemDirection;
        private int mLT;
        private boolean mLX;
        private int mLastScrollDelta;
        private int mLayoutDirection;
        private int mOffset;
        private int mPosition;
        private int mScrollingOffset;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.mLT;
            bVar.mLT = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.mLT;
            bVar.mLT = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.mLT >= 0 && this.mLT < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mLT + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: aQ */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ME */
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
        public boolean MD(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
