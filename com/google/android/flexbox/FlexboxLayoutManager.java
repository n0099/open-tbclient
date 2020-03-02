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
    private static final Rect mJU;
    private final Context mContext;
    private boolean mIsRtl;
    private List<com.google.android.flexbox.b> mJC;
    private int mJE;
    private int mJF;
    private int mJG;
    private int mJH;
    private int mJJ;
    private final c mJS;
    private c.a mJT;
    private boolean mJV;
    private b mJW;
    private a mJX;
    private OrientationHelper mJY;
    private SavedState mJZ;
    private SparseArray<View> mKa;
    private int mKb;
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
        mJU = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mJE;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mJF;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mJH;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mJJ;
    }

    @Override // com.google.android.flexbox.a
    public int g(View view, int i, int i2) {
        return dAl() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int ds(View view) {
        return dAl() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, mJU);
        if (dAl()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.mJm += leftDecorationWidth;
            bVar.mJn = leftDecorationWidth + bVar.mJn;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.mJm += topDecorationHeight;
        bVar.mJn = topDecorationHeight + bVar.mJn;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View Me(int i) {
        View view = this.mKa.get(i);
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
        if (this.mJC.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.mJC.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mJC.get(i2).mJm);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mJC.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mJC.get(i2).mJo;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.mJC = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.mJC;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i, View view) {
        this.mKa.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dAl()) {
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
        if (this.mJZ != null) {
            return new SavedState(this.mJZ);
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
            this.mJZ = (SavedState) parcelable;
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
            this.mJS.Mk(childCount);
            this.mJS.Mj(childCount);
            this.mJS.Ml(childCount);
            if (!$assertionsDisabled && this.mJS.mJz == null) {
                throw new AssertionError();
            }
            if (i < this.mJS.mJz.length) {
                this.mKb = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dAl() && this.mIsRtl) {
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
            dAv();
            dAx();
            ensureLayoutState();
            this.mJS.Mk(itemCount);
            this.mJS.Mj(itemCount);
            this.mJS.Ml(itemCount);
            this.mJW.mKg = false;
            if (this.mJZ != null && this.mJZ.Mx(itemCount)) {
                this.mPendingScrollPosition = this.mJZ.mAnchorPosition;
            }
            if (!this.mJX.mValid || this.mPendingScrollPosition != -1 || this.mJZ != null) {
                this.mJX.reset();
                a(state, this.mJX);
                this.mJX.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.mJX.mLayoutFromEnd) {
                b(this.mJX, false, true);
            } else {
                a(this.mJX, false, true);
            }
            Ms(itemCount);
            if (this.mJX.mLayoutFromEnd) {
                a(recycler, state, this.mJW);
                i2 = this.mJW.mOffset;
                a(this.mJX, true, false);
                a(recycler, state, this.mJW);
                i = this.mJW.mOffset;
            } else {
                a(recycler, state, this.mJW);
                i = this.mJW.mOffset;
                b(this.mJX, true, false);
                a(recycler, state, this.mJW);
                i2 = this.mJW.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.mJX.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dAl() && this.mIsRtl) {
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
        if (!dAl() && this.mIsRtl) {
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
        if (dAl()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.mJW.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.mJW.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.mJW.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.mJW.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.mKb != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.mKb != -1 ? Math.min(this.mKb, this.mJX.mPosition) : this.mJX.mPosition;
            this.mJT.reset();
            if (dAl()) {
                if (this.mJC.size() > 0) {
                    this.mJS.r(this.mJC, min);
                    this.mJS.a(this.mJT, makeMeasureSpec, makeMeasureSpec2, i3, min, this.mJX.mPosition, this.mJC);
                } else {
                    this.mJS.Ml(i);
                    this.mJS.a(this.mJT, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mJC);
                }
            } else if (this.mJC.size() > 0) {
                this.mJS.r(this.mJC, min);
                this.mJS.a(this.mJT, makeMeasureSpec2, makeMeasureSpec, i3, min, this.mJX.mPosition, this.mJC);
            } else {
                this.mJS.Ml(i);
                this.mJS.c(this.mJT, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mJC);
            }
            this.mJC = this.mJT.mJC;
            this.mJS.ap(makeMeasureSpec, makeMeasureSpec2, min);
            this.mJS.Mi(min);
        } else if (!this.mJX.mLayoutFromEnd) {
            this.mJC.clear();
            if (!$assertionsDisabled && this.mJS.mJz == null) {
                throw new AssertionError();
            }
            this.mJT.reset();
            if (dAl()) {
                this.mJS.b(this.mJT, makeMeasureSpec, makeMeasureSpec2, i3, this.mJX.mPosition, this.mJC);
            } else {
                this.mJS.d(this.mJT, makeMeasureSpec, makeMeasureSpec2, i3, this.mJX.mPosition, this.mJC);
            }
            this.mJC = this.mJT.mJC;
            this.mJS.eb(makeMeasureSpec, makeMeasureSpec2);
            this.mJS.dAt();
            this.mJX.mKc = this.mJS.mJz[this.mJX.mPosition];
            this.mJW.mKc = this.mJX.mKc;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mJZ = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mKb = -1;
        this.mJX.reset();
        this.mKa.clear();
    }

    private void dAv() {
        int layoutDirection = getLayoutDirection();
        switch (this.mJE) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.mJV = this.mJF == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.mJV = this.mJF == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.mJF == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mJV = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.mJF == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mJV = true;
                return;
            default:
                this.mIsRtl = false;
                this.mJV = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.mJZ) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.mKc = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.mJS.mJz != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.mKc = this.mJS.mJz[aVar.mPosition];
            if (this.mJZ == null || !this.mJZ.Mx(state.getItemCount())) {
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
                } else if (dAl() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.mKe = true;
            aVar.mKc = -1;
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
        if ($assertionsDisabled || this.mJS.mJz != null) {
            View ar = ar(0, getChildCount(), i);
            if (ar == null) {
                return null;
            }
            int i2 = this.mJS.mJz[getPosition(ar)];
            if (i2 != -1) {
                return a(ar, this.mJC.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View Mu(int i) {
        if ($assertionsDisabled || this.mJS.mJz != null) {
            View ar = ar(getChildCount() - 1, -1, i);
            if (ar == null) {
                return null;
            }
            return b(ar, this.mJC.get(this.mJS.mJz[getPosition(ar)]));
        }
        throw new AssertionError();
    }

    private View ar(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dAx();
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
        boolean dAl = dAl();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.mJW.mInfinite) && bVar.a(state, this.mJC)) {
                com.google.android.flexbox.b bVar2 = this.mJC.get(bVar.mKc);
                bVar.mPosition = bVar2.mJv;
                i4 += a(bVar2, bVar);
                if (dAl || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dAr() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dAr() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dAr();
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
        if (!bVar.mKg) {
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
            if (!$assertionsDisabled && this.mJS.mJz == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mJS.mJz[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.mJC.get(i);
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
                        if (bVar2.mJw == getPosition(childAt)) {
                            if (i >= this.mJC.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.mJC.get(i4);
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
        return (dAl() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.mJS.mJz == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mJS.mJz[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.mJC.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mJv == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.mJC.get(i4);
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
        return (dAl() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dAl() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.mJS.mJA != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.mJo : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mJG) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.mJm) + paddingRight;
                    f2 = bVar.mJm - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.mJm) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.mJm) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.mJm) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mJm) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mJm) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJG);
            }
            float f4 = f - this.mJX.mKd;
            float f5 = f2 - this.mJX.mKd;
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
                        calculateItemDecorationsForChild(Me, mJU);
                        addView(Me);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(Me, mJU);
                        addView(Me, i5);
                        i = i5 + 1;
                    }
                    long j = this.mJS.mJA[i6];
                    int gO = this.mJS.gO(j);
                    int gP = this.mJS.gP(j);
                    if (shouldMeasureChild(Me, gO, gP, (LayoutParams) Me.getLayoutParams())) {
                        Me.measure(gO, gP);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(Me);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(Me));
                    int topDecorationHeight = i3 + getTopDecorationHeight(Me);
                    if (this.mIsRtl) {
                        this.mJS.a(Me, bVar, Math.round(rightDecorationWidth) - Me.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + Me.getMeasuredHeight());
                    } else {
                        this.mJS.a(Me, bVar, Math.round(leftDecorationWidth), topDecorationHeight, Me.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + Me.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + Me.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(Me) + max;
                    measuredWidth2 = rightDecorationWidth - (((Me.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(Me)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.mKc += this.mJW.mLayoutDirection;
            return bVar.dAr();
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
        if ($assertionsDisabled || this.mJS.mJA != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.mJo;
                i = i5 + bVar.mJo;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mJG) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.mJm) + paddingBottom;
                    f2 = bVar.mJm - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.mJm) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.mJm) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.mJm) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mJm) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mJm) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJG);
            }
            float f4 = f - this.mJX.mKd;
            float f5 = f2 - this.mJX.mKd;
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
                    long j = this.mJS.mJA[i9];
                    int gO = this.mJS.gO(j);
                    int gP = this.mJS.gP(j);
                    if (shouldMeasureChild(Me, gO, gP, (LayoutParams) Me.getLayoutParams())) {
                        Me.measure(gO, gP);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(Me);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(Me));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Me, mJU);
                        addView(Me);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(Me, mJU);
                        addView(Me, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(Me);
                    int rightDecorationWidth = i - getRightDecorationWidth(Me);
                    if (this.mIsRtl) {
                        if (this.mJV) {
                            this.mJS.a(Me, bVar, this.mIsRtl, rightDecorationWidth - Me.getMeasuredWidth(), Math.round(bottomDecorationHeight) - Me.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.mJS.a(Me, bVar, this.mIsRtl, rightDecorationWidth - Me.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Me.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.mJV) {
                        this.mJS.a(Me, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - Me.getMeasuredHeight(), leftDecorationWidth + Me.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.mJS.a(Me, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + Me.getMeasuredWidth(), Me.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((Me.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(Me)) + max);
                    measuredHeight2 = topDecorationHeight + Me.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(Me) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.mKc += this.mJW.mLayoutDirection;
            return bVar.dAr();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dAl() {
        return this.mJE == 0 || this.mJE == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dAw();
        } else {
            this.mJW.mInfinite = false;
        }
        if (!dAl() && this.mIsRtl) {
            this.mJW.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.mJW.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.mJW.mPosition = aVar.mPosition;
        this.mJW.mItemDirection = 1;
        this.mJW.mLayoutDirection = 1;
        this.mJW.mOffset = aVar.mCoordinate;
        this.mJW.mScrollingOffset = Integer.MIN_VALUE;
        this.mJW.mKc = aVar.mKc;
        if (z && this.mJC.size() > 1 && aVar.mKc >= 0 && aVar.mKc < this.mJC.size() - 1) {
            b.i(this.mJW);
            b bVar = this.mJW;
            bVar.mPosition = this.mJC.get(aVar.mKc).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dAw();
        } else {
            this.mJW.mInfinite = false;
        }
        if (!dAl() && this.mIsRtl) {
            this.mJW.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.mJW.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mJW.mPosition = aVar.mPosition;
        this.mJW.mItemDirection = 1;
        this.mJW.mLayoutDirection = -1;
        this.mJW.mOffset = aVar.mCoordinate;
        this.mJW.mScrollingOffset = Integer.MIN_VALUE;
        this.mJW.mKc = aVar.mKc;
        if (z && aVar.mKc > 0 && this.mJC.size() > aVar.mKc) {
            b.j(this.mJW);
            this.mJW.mPosition -= this.mJC.get(aVar.mKc).getItemCount();
        }
    }

    private void dAw() {
        int widthMode;
        if (dAl()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.mJW.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dAx() {
        if (this.mOrientationHelper == null) {
            if (dAl()) {
                if (this.mJF == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.mJY = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mJY = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mJF == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mJY = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mJY = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.mJW == null) {
            this.mJW = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mJZ != null) {
            this.mJZ.invalidateAnchor();
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
        return !dAl() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dAl() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dAl()) {
            int a2 = a(i, recycler, state);
            this.mKa.clear();
            return a2;
        }
        int Mv = Mv(i);
        this.mJX.mKd += Mv;
        this.mJY.offsetChildren(-Mv);
        return Mv;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dAl()) {
            int a2 = a(i, recycler, state);
            this.mKa.clear();
            return a2;
        }
        int Mv = Mv(i);
        this.mJX.mKd += Mv;
        this.mJY.offsetChildren(-Mv);
        return Mv;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dAx();
        this.mJW.mKg = true;
        boolean z = !dAl() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        ef(i2, abs);
        int a2 = this.mJW.mScrollingOffset + a(recycler, state, this.mJW);
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
        this.mJW.mLastScrollDelta = i;
        return i;
    }

    private int Mv(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dAx();
        boolean dAl = dAl();
        int width = dAl ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dAl ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.mJX.mKd) - width, abs);
            }
            if (this.mJX.mKd + i <= 0) {
                return i;
            }
            return -this.mJX.mKd;
        } else if (i > 0) {
            return Math.min((width2 - this.mJX.mKd) - width, i);
        } else {
            if (this.mJX.mKd + i >= 0) {
                return i;
            }
            return -this.mJX.mKd;
        }
    }

    private void ef(int i, int i2) {
        if (!$assertionsDisabled && this.mJS.mJz == null) {
            throw new AssertionError();
        }
        this.mJW.mLayoutDirection = i;
        boolean dAl = dAl();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dAl && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.mJW.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.mJC.get(this.mJS.mJz[position]));
            this.mJW.mItemDirection = 1;
            this.mJW.mPosition = this.mJW.mItemDirection + position;
            if (this.mJS.mJz.length <= this.mJW.mPosition) {
                this.mJW.mKc = -1;
            } else {
                this.mJW.mKc = this.mJS.mJz[this.mJW.mPosition];
            }
            if (z) {
                this.mJW.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.mJW.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.mJW.mScrollingOffset = this.mJW.mScrollingOffset >= 0 ? this.mJW.mScrollingOffset : 0;
            } else {
                this.mJW.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.mJW.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mJW.mKc == -1 || this.mJW.mKc > this.mJC.size() - 1) && this.mJW.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.mJW.mScrollingOffset;
                this.mJT.reset();
                if (i3 > 0) {
                    if (dAl) {
                        this.mJS.a(this.mJT, makeMeasureSpec, makeMeasureSpec2, i3, this.mJW.mPosition, this.mJC);
                    } else {
                        this.mJS.c(this.mJT, makeMeasureSpec, makeMeasureSpec2, i3, this.mJW.mPosition, this.mJC);
                    }
                    this.mJS.ap(makeMeasureSpec, makeMeasureSpec2, this.mJW.mPosition);
                    this.mJS.Mi(this.mJW.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.mJW.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.mJC.get(this.mJS.mJz[position2]));
            this.mJW.mItemDirection = 1;
            int i4 = this.mJS.mJz[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.mJW.mPosition = position2 - this.mJC.get(i5 - 1).getItemCount();
            } else {
                this.mJW.mPosition = -1;
            }
            this.mJW.mKc = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.mJW.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.mJW.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.mJW.mScrollingOffset = this.mJW.mScrollingOffset >= 0 ? this.mJW.mScrollingOffset : 0;
            } else {
                this.mJW.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.mJW.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.mJW.mAvailable = i2 - this.mJW.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dAl = dAl();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dAl) {
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
        boolean dAl = dAl();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dAl) {
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
        dAx();
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
        if ($assertionsDisabled || this.mJS.mJz != null) {
            int position = getPosition(Mt);
            int position2 = getPosition(Mu);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(Mu) - this.mOrientationHelper.getDecoratedStart(Mt));
            int i = this.mJS.mJz[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.mJS.mJz[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(Mt)));
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
        if ($assertionsDisabled || this.mJS.mJz != null) {
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
        public int dAm() {
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
        public boolean dAn() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dAo() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dAp() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dAq() {
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
        private int mKc;
        private int mKd;
        private boolean mKe;
        final /* synthetic */ FlexboxLayoutManager mKf;
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mKc = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mKe = false;
            if (this.mKf.dAl()) {
                if (this.mKf.mJF == 0) {
                    this.mLayoutFromEnd = this.mKf.mJE == 1;
                } else {
                    this.mLayoutFromEnd = this.mKf.mJF == 2;
                }
            } else if (this.mKf.mJF == 0) {
                this.mLayoutFromEnd = this.mKf.mJE == 3;
            } else {
                this.mLayoutFromEnd = this.mKf.mJF == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.mKf.dAl() && this.mKf.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.mKf.mOrientationHelper.getEndAfterPadding() : this.mKf.getWidth() - this.mKf.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.mKf.mOrientationHelper.getEndAfterPadding() : this.mKf.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dx(View view) {
            if (!this.mKf.dAl() && this.mKf.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.mKf.mOrientationHelper.getDecoratedStart(view) + this.mKf.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.mKf.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mKf.mOrientationHelper.getDecoratedEnd(view) + this.mKf.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mKf.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.mKf.getPosition(view);
            this.mKe = false;
            if (!$assertionsDisabled && this.mKf.mJS.mJz == null) {
                throw new AssertionError();
            }
            int i = this.mKf.mJS.mJz[this.mPosition != -1 ? this.mPosition : 0];
            this.mKc = i != -1 ? i : 0;
            if (this.mKf.mJC.size() > this.mKc) {
                this.mPosition = ((com.google.android.flexbox.b) this.mKf.mJC.get(this.mKc)).mJv;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mKc + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mKd + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mKe + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {
        private int mAvailable;
        private boolean mInfinite;
        private int mItemDirection;
        private int mKc;
        private boolean mKg;
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
            int i = bVar.mKc;
            bVar.mKc = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.mKc;
            bVar.mKc = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.mKc >= 0 && this.mKc < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mKc + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
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
