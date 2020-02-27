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
    private static final Rect mJS;
    private final Context mContext;
    private boolean mIsRtl;
    private List<com.google.android.flexbox.b> mJA;
    private int mJC;
    private int mJD;
    private int mJE;
    private int mJF;
    private int mJH;
    private final c mJQ;
    private c.a mJR;
    private boolean mJT;
    private b mJU;
    private a mJV;
    private OrientationHelper mJW;
    private SavedState mJX;
    private SparseArray<View> mJY;
    private int mJZ;
    private int mLastHeight;
    private int mLastWidth;
    private OrientationHelper mOrientationHelper;
    private View mParent;
    private int mPendingScrollPosition;
    private int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private RecyclerView.Recycler mRecycler;
    private RecyclerView.State mState;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        mJS = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mJC;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mJD;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mJF;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mJH;
    }

    @Override // com.google.android.flexbox.a
    public int g(View view, int i, int i2) {
        return dAj() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int ds(View view) {
        return dAj() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, mJS);
        if (dAj()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.mJk += leftDecorationWidth;
            bVar.mJl = leftDecorationWidth + bVar.mJl;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.mJk += topDecorationHeight;
        bVar.mJl = topDecorationHeight + bVar.mJl;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View Me(int i) {
        View view = this.mJY.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View Mf(int i) {
        return Me(i);
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
        if (this.mJA.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.mJA.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mJA.get(i2).mJk);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mJA.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mJA.get(i2).mJm;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.mJA = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.mJA;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i, View view) {
        this.mJY.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dAj()) {
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
        if (this.mJX != null) {
            return new SavedState(this.mJX);
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
            this.mJX = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        Mr(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        Mr(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        Mr(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        Mr(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        Mr(Math.min(i, i2));
    }

    private void Mr(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.mJQ.Mk(childCount);
            this.mJQ.Mj(childCount);
            this.mJQ.Ml(childCount);
            if (!$assertionsDisabled && this.mJQ.mJx == null) {
                throw new AssertionError();
            }
            if (i < this.mJQ.mJx.length) {
                this.mJZ = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dAj() && this.mIsRtl) {
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
            dAt();
            dAv();
            ensureLayoutState();
            this.mJQ.Mk(itemCount);
            this.mJQ.Mj(itemCount);
            this.mJQ.Ml(itemCount);
            this.mJU.mKe = false;
            if (this.mJX != null && this.mJX.Mx(itemCount)) {
                this.mPendingScrollPosition = this.mJX.mAnchorPosition;
            }
            if (!this.mJV.mValid || this.mPendingScrollPosition != -1 || this.mJX != null) {
                this.mJV.reset();
                a(state, this.mJV);
                this.mJV.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.mJV.mLayoutFromEnd) {
                b(this.mJV, false, true);
            } else {
                a(this.mJV, false, true);
            }
            Ms(itemCount);
            if (this.mJV.mLayoutFromEnd) {
                a(recycler, state, this.mJU);
                i2 = this.mJU.mOffset;
                a(this.mJV, true, false);
                a(recycler, state, this.mJU);
                i = this.mJU.mOffset;
            } else {
                a(recycler, state, this.mJU);
                i = this.mJU.mOffset;
                b(this.mJV, true, false);
                a(recycler, state, this.mJU);
                i2 = this.mJU.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.mJV.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dAj() && this.mIsRtl) {
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
        if (!dAj() && this.mIsRtl) {
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

    private void Ms(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (dAj()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.mJU.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.mJU.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.mJU.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.mJU.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.mJZ != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.mJZ != -1 ? Math.min(this.mJZ, this.mJV.mPosition) : this.mJV.mPosition;
            this.mJR.reset();
            if (dAj()) {
                if (this.mJA.size() > 0) {
                    this.mJQ.r(this.mJA, min);
                    this.mJQ.a(this.mJR, makeMeasureSpec, makeMeasureSpec2, i3, min, this.mJV.mPosition, this.mJA);
                } else {
                    this.mJQ.Ml(i);
                    this.mJQ.a(this.mJR, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mJA);
                }
            } else if (this.mJA.size() > 0) {
                this.mJQ.r(this.mJA, min);
                this.mJQ.a(this.mJR, makeMeasureSpec2, makeMeasureSpec, i3, min, this.mJV.mPosition, this.mJA);
            } else {
                this.mJQ.Ml(i);
                this.mJQ.c(this.mJR, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mJA);
            }
            this.mJA = this.mJR.mJA;
            this.mJQ.ap(makeMeasureSpec, makeMeasureSpec2, min);
            this.mJQ.Mi(min);
        } else if (!this.mJV.mLayoutFromEnd) {
            this.mJA.clear();
            if (!$assertionsDisabled && this.mJQ.mJx == null) {
                throw new AssertionError();
            }
            this.mJR.reset();
            if (dAj()) {
                this.mJQ.b(this.mJR, makeMeasureSpec, makeMeasureSpec2, i3, this.mJV.mPosition, this.mJA);
            } else {
                this.mJQ.d(this.mJR, makeMeasureSpec, makeMeasureSpec2, i3, this.mJV.mPosition, this.mJA);
            }
            this.mJA = this.mJR.mJA;
            this.mJQ.eb(makeMeasureSpec, makeMeasureSpec2);
            this.mJQ.dAr();
            this.mJV.mKa = this.mJQ.mJx[this.mJV.mPosition];
            this.mJU.mKa = this.mJV.mKa;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mJX = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mJZ = -1;
        this.mJV.reset();
        this.mJY.clear();
    }

    private void dAt() {
        int layoutDirection = getLayoutDirection();
        switch (this.mJC) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.mJT = this.mJD == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.mJT = this.mJD == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.mJD == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mJT = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.mJD == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mJT = true;
                return;
            default:
                this.mIsRtl = false;
                this.mJT = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.mJX) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.mKa = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.mJQ.mJx != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.mKa = this.mJQ.mJx[aVar.mPosition];
            if (this.mJX == null || !this.mJX.Mx(state.getItemCount())) {
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
                } else if (dAj() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.mKc = true;
            aVar.mKa = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View Mt;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            Mt = Mu(state.getItemCount());
        } else {
            Mt = Mt(state.getItemCount());
        }
        if (Mt != null) {
            aVar.dx(Mt);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(Mt) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(Mt) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View Mt(int i) {
        if ($assertionsDisabled || this.mJQ.mJx != null) {
            View ar = ar(0, getChildCount(), i);
            if (ar == null) {
                return null;
            }
            int i2 = this.mJQ.mJx[getPosition(ar)];
            if (i2 != -1) {
                return a(ar, this.mJA.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View Mu(int i) {
        if ($assertionsDisabled || this.mJQ.mJx != null) {
            View ar = ar(getChildCount() - 1, -1, i);
            if (ar == null) {
                return null;
            }
            return b(ar, this.mJA.get(this.mJQ.mJx[getPosition(ar)]));
        }
        throw new AssertionError();
    }

    private View ar(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dAv();
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
        boolean dAj = dAj();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.mJU.mInfinite) && bVar.a(state, this.mJA)) {
                com.google.android.flexbox.b bVar2 = this.mJA.get(bVar.mKa);
                bVar.mPosition = bVar2.mJt;
                i4 += a(bVar2, bVar);
                if (dAj || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dAp() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dAp() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dAp();
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
        if (!bVar.mKe) {
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
            if (!$assertionsDisabled && this.mJQ.mJx == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mJQ.mJx[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.mJA.get(i);
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
                        if (bVar2.mJu == getPosition(childAt)) {
                            if (i >= this.mJA.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.mJA.get(i4);
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
        return (dAj() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.mJQ.mJx == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mJQ.mJx[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.mJA.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mJt == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.mJA.get(i4);
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
        return (dAj() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dAj() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.mJQ.mJy != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.mJm : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mJE) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.mJk) + paddingRight;
                    f2 = bVar.mJk - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.mJk) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.mJk) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.mJk) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mJk) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mJk) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJE);
            }
            float f4 = f - this.mJV.mKb;
            float f5 = f2 - this.mJV.mKb;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View Me = Me(i6);
                if (Me == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Me, mJS);
                        addView(Me);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(Me, mJS);
                        addView(Me, i5);
                        i = i5 + 1;
                    }
                    long j = this.mJQ.mJy[i6];
                    int gO = this.mJQ.gO(j);
                    int gP = this.mJQ.gP(j);
                    if (shouldMeasureChild(Me, gO, gP, (LayoutParams) Me.getLayoutParams())) {
                        Me.measure(gO, gP);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(Me);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(Me));
                    int topDecorationHeight = i3 + getTopDecorationHeight(Me);
                    if (this.mIsRtl) {
                        this.mJQ.a(Me, bVar, Math.round(rightDecorationWidth) - Me.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + Me.getMeasuredHeight());
                    } else {
                        this.mJQ.a(Me, bVar, Math.round(leftDecorationWidth), topDecorationHeight, Me.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + Me.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + Me.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(Me) + max;
                    measuredWidth2 = rightDecorationWidth - (((Me.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(Me)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.mKa += this.mJU.mLayoutDirection;
            return bVar.dAp();
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
        if ($assertionsDisabled || this.mJQ.mJy != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.mJm;
                i = i5 + bVar.mJm;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mJE) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.mJk) + paddingBottom;
                    f2 = bVar.mJk - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.mJk) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.mJk) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.mJk) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mJk) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mJk) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJE);
            }
            float f4 = f - this.mJV.mKb;
            float f5 = f2 - this.mJV.mKb;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View Me = Me(i9);
                if (Me == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.mJQ.mJy[i9];
                    int gO = this.mJQ.gO(j);
                    int gP = this.mJQ.gP(j);
                    if (shouldMeasureChild(Me, gO, gP, (LayoutParams) Me.getLayoutParams())) {
                        Me.measure(gO, gP);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(Me);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(Me));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Me, mJS);
                        addView(Me);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(Me, mJS);
                        addView(Me, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(Me);
                    int rightDecorationWidth = i - getRightDecorationWidth(Me);
                    if (this.mIsRtl) {
                        if (this.mJT) {
                            this.mJQ.a(Me, bVar, this.mIsRtl, rightDecorationWidth - Me.getMeasuredWidth(), Math.round(bottomDecorationHeight) - Me.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.mJQ.a(Me, bVar, this.mIsRtl, rightDecorationWidth - Me.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Me.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.mJT) {
                        this.mJQ.a(Me, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - Me.getMeasuredHeight(), leftDecorationWidth + Me.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.mJQ.a(Me, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + Me.getMeasuredWidth(), Me.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((Me.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(Me)) + max);
                    measuredHeight2 = topDecorationHeight + Me.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(Me) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.mKa += this.mJU.mLayoutDirection;
            return bVar.dAp();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dAj() {
        return this.mJC == 0 || this.mJC == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dAu();
        } else {
            this.mJU.mInfinite = false;
        }
        if (!dAj() && this.mIsRtl) {
            this.mJU.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.mJU.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.mJU.mPosition = aVar.mPosition;
        this.mJU.mItemDirection = 1;
        this.mJU.mLayoutDirection = 1;
        this.mJU.mOffset = aVar.mCoordinate;
        this.mJU.mScrollingOffset = Integer.MIN_VALUE;
        this.mJU.mKa = aVar.mKa;
        if (z && this.mJA.size() > 1 && aVar.mKa >= 0 && aVar.mKa < this.mJA.size() - 1) {
            b.i(this.mJU);
            b bVar = this.mJU;
            bVar.mPosition = this.mJA.get(aVar.mKa).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dAu();
        } else {
            this.mJU.mInfinite = false;
        }
        if (!dAj() && this.mIsRtl) {
            this.mJU.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.mJU.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mJU.mPosition = aVar.mPosition;
        this.mJU.mItemDirection = 1;
        this.mJU.mLayoutDirection = -1;
        this.mJU.mOffset = aVar.mCoordinate;
        this.mJU.mScrollingOffset = Integer.MIN_VALUE;
        this.mJU.mKa = aVar.mKa;
        if (z && aVar.mKa > 0 && this.mJA.size() > aVar.mKa) {
            b.j(this.mJU);
            this.mJU.mPosition -= this.mJA.get(aVar.mKa).getItemCount();
        }
    }

    private void dAu() {
        int widthMode;
        if (dAj()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.mJU.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dAv() {
        if (this.mOrientationHelper == null) {
            if (dAj()) {
                if (this.mJD == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.mJW = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mJW = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mJD == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mJW = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mJW = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.mJU == null) {
            this.mJU = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mJX != null) {
            this.mJX.invalidateAnchor();
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
        return !dAj() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dAj() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dAj()) {
            int a2 = a(i, recycler, state);
            this.mJY.clear();
            return a2;
        }
        int Mv = Mv(i);
        this.mJV.mKb += Mv;
        this.mJW.offsetChildren(-Mv);
        return Mv;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dAj()) {
            int a2 = a(i, recycler, state);
            this.mJY.clear();
            return a2;
        }
        int Mv = Mv(i);
        this.mJV.mKb += Mv;
        this.mJW.offsetChildren(-Mv);
        return Mv;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dAv();
        this.mJU.mKe = true;
        boolean z = !dAj() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        ef(i2, abs);
        int a2 = this.mJU.mScrollingOffset + a(recycler, state, this.mJU);
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
        this.mJU.mLastScrollDelta = i;
        return i;
    }

    private int Mv(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dAv();
        boolean dAj = dAj();
        int width = dAj ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dAj ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.mJV.mKb) - width, abs);
            }
            if (this.mJV.mKb + i <= 0) {
                return i;
            }
            return -this.mJV.mKb;
        } else if (i > 0) {
            return Math.min((width2 - this.mJV.mKb) - width, i);
        } else {
            if (this.mJV.mKb + i >= 0) {
                return i;
            }
            return -this.mJV.mKb;
        }
    }

    private void ef(int i, int i2) {
        if (!$assertionsDisabled && this.mJQ.mJx == null) {
            throw new AssertionError();
        }
        this.mJU.mLayoutDirection = i;
        boolean dAj = dAj();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dAj && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.mJU.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.mJA.get(this.mJQ.mJx[position]));
            this.mJU.mItemDirection = 1;
            this.mJU.mPosition = this.mJU.mItemDirection + position;
            if (this.mJQ.mJx.length <= this.mJU.mPosition) {
                this.mJU.mKa = -1;
            } else {
                this.mJU.mKa = this.mJQ.mJx[this.mJU.mPosition];
            }
            if (z) {
                this.mJU.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.mJU.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.mJU.mScrollingOffset = this.mJU.mScrollingOffset >= 0 ? this.mJU.mScrollingOffset : 0;
            } else {
                this.mJU.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.mJU.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mJU.mKa == -1 || this.mJU.mKa > this.mJA.size() - 1) && this.mJU.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.mJU.mScrollingOffset;
                this.mJR.reset();
                if (i3 > 0) {
                    if (dAj) {
                        this.mJQ.a(this.mJR, makeMeasureSpec, makeMeasureSpec2, i3, this.mJU.mPosition, this.mJA);
                    } else {
                        this.mJQ.c(this.mJR, makeMeasureSpec, makeMeasureSpec2, i3, this.mJU.mPosition, this.mJA);
                    }
                    this.mJQ.ap(makeMeasureSpec, makeMeasureSpec2, this.mJU.mPosition);
                    this.mJQ.Mi(this.mJU.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.mJU.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.mJA.get(this.mJQ.mJx[position2]));
            this.mJU.mItemDirection = 1;
            int i4 = this.mJQ.mJx[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.mJU.mPosition = position2 - this.mJA.get(i5 - 1).getItemCount();
            } else {
                this.mJU.mPosition = -1;
            }
            this.mJU.mKa = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.mJU.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.mJU.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.mJU.mScrollingOffset = this.mJU.mScrollingOffset >= 0 ? this.mJU.mScrollingOffset : 0;
            } else {
                this.mJU.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.mJU.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.mJU.mAvailable = i2 - this.mJU.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dAj = dAj();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dAj) {
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
        boolean dAj = dAj();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dAj) {
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
        dAv();
        View Mt = Mt(itemCount);
        View Mu = Mu(itemCount);
        if (state.getItemCount() == 0 || Mt == null || Mu == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(Mu) - this.mOrientationHelper.getDecoratedStart(Mt));
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
        View Mt = Mt(itemCount);
        View Mu = Mu(itemCount);
        if (state.getItemCount() == 0 || Mt == null || Mu == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mJQ.mJx != null) {
            int position = getPosition(Mt);
            int position2 = getPosition(Mu);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(Mu) - this.mOrientationHelper.getDecoratedStart(Mt));
            int i = this.mJQ.mJx[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.mJQ.mJx[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(Mt)));
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
        View Mt = Mt(itemCount);
        View Mu = Mu(itemCount);
        if (state.getItemCount() == 0 || Mt == null || Mu == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mJQ.mJx != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(Mu) - this.mOrientationHelper.getDecoratedStart(Mt)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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
            /* renamed from: Mw */
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
        public int dAk() {
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
        public boolean dAl() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dAm() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dAn() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dAo() {
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
        private int mKa;
        private int mKb;
        private boolean mKc;
        final /* synthetic */ FlexboxLayoutManager mKd;
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mKa = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mKc = false;
            if (this.mKd.dAj()) {
                if (this.mKd.mJD == 0) {
                    this.mLayoutFromEnd = this.mKd.mJC == 1;
                } else {
                    this.mLayoutFromEnd = this.mKd.mJD == 2;
                }
            } else if (this.mKd.mJD == 0) {
                this.mLayoutFromEnd = this.mKd.mJC == 3;
            } else {
                this.mLayoutFromEnd = this.mKd.mJD == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.mKd.dAj() && this.mKd.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.mKd.mOrientationHelper.getEndAfterPadding() : this.mKd.getWidth() - this.mKd.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.mKd.mOrientationHelper.getEndAfterPadding() : this.mKd.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dx(View view) {
            if (!this.mKd.dAj() && this.mKd.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.mKd.mOrientationHelper.getDecoratedStart(view) + this.mKd.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.mKd.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mKd.mOrientationHelper.getDecoratedEnd(view) + this.mKd.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mKd.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.mKd.getPosition(view);
            this.mKc = false;
            if (!$assertionsDisabled && this.mKd.mJQ.mJx == null) {
                throw new AssertionError();
            }
            int i = this.mKd.mJQ.mJx[this.mPosition != -1 ? this.mPosition : 0];
            this.mKa = i != -1 ? i : 0;
            if (this.mKd.mJA.size() > this.mKa) {
                this.mPosition = ((com.google.android.flexbox.b) this.mKd.mJA.get(this.mKa)).mJt;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mKa + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mKb + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mKc + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {
        private int mAvailable;
        private boolean mInfinite;
        private int mItemDirection;
        private int mKa;
        private boolean mKe;
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
            int i = bVar.mKa;
            bVar.mKa = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.mKa;
            bVar.mKa = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.mKa >= 0 && this.mKa < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mKa + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
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
            /* renamed from: My */
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
        public boolean Mx(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
