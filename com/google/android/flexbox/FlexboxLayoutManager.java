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
/* loaded from: classes4.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider, com.google.android.flexbox.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Rect mFq;
    private final Context mContext;
    private List<com.google.android.flexbox.b> mEY;
    private int mFa;
    private int mFb;
    private int mFc;
    private int mFd;
    private int mFf;
    private final c mFo;
    private c.a mFp;
    private boolean mFr;
    private b mFs;
    private a mFt;
    private OrientationHelper mFu;
    private SavedState mFv;
    private SparseArray<View> mFw;
    private int mFx;
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

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        mFq = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mFa;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mFb;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mFd;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mFf;
    }

    @Override // com.google.android.flexbox.a
    public int g(View view, int i, int i2) {
        return dxN() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dg(View view) {
        return dxN() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, mFq);
        if (dxN()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.mEI += leftDecorationWidth;
            bVar.mEJ = leftDecorationWidth + bVar.mEJ;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.mEI += topDecorationHeight;
        bVar.mEJ = topDecorationHeight + bVar.mEJ;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View LQ(int i) {
        View view = this.mFw.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View LR(int i) {
        return LQ(i);
    }

    @Override // com.google.android.flexbox.a
    public void a(com.google.android.flexbox.b bVar) {
    }

    @Override // com.google.android.flexbox.a
    public int am(int i, int i2, int i3) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int an(int i, int i2, int i3) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.mEY.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.mEY.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mEY.get(i2).mEI);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mEY.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mEY.get(i2).mEK;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.mEY = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.mEY;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i, View view) {
        this.mFw.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dxN()) {
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
        if (this.mFv != null) {
            return new SavedState(this.mFv);
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
            this.mFv = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        Md(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        Md(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        Md(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        Md(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        Md(Math.min(i, i2));
    }

    private void Md(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.mFo.LW(childCount);
            this.mFo.LV(childCount);
            this.mFo.LX(childCount);
            if (!$assertionsDisabled && this.mFo.mEV == null) {
                throw new AssertionError();
            }
            if (i < this.mFo.mEV.length) {
                this.mFx = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dxN() && this.mIsRtl) {
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
            dxY();
            dya();
            ensureLayoutState();
            this.mFo.LW(itemCount);
            this.mFo.LV(itemCount);
            this.mFo.LX(itemCount);
            this.mFs.mFC = false;
            if (this.mFv != null && this.mFv.Mj(itemCount)) {
                this.mPendingScrollPosition = this.mFv.mAnchorPosition;
            }
            if (!this.mFt.mValid || this.mPendingScrollPosition != -1 || this.mFv != null) {
                this.mFt.reset();
                a(state, this.mFt);
                this.mFt.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.mFt.mLayoutFromEnd) {
                b(this.mFt, false, true);
            } else {
                a(this.mFt, false, true);
            }
            Me(itemCount);
            if (this.mFt.mLayoutFromEnd) {
                a(recycler, state, this.mFs);
                i2 = this.mFs.mOffset;
                a(this.mFt, true, false);
                a(recycler, state, this.mFs);
                i = this.mFs.mOffset;
            } else {
                a(recycler, state, this.mFs);
                i = this.mFs.mOffset;
                b(this.mFt, true, false);
                a(recycler, state, this.mFs);
                i2 = this.mFs.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.mFt.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dxN() && this.mIsRtl) {
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
        if (!dxN() && this.mIsRtl) {
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

    private void Me(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (dxN()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.mFs.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.mFs.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.mFs.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.mFs.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.mFx != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.mFx != -1 ? Math.min(this.mFx, this.mFt.mPosition) : this.mFt.mPosition;
            this.mFp.reset();
            if (dxN()) {
                if (this.mEY.size() > 0) {
                    this.mFo.q(this.mEY, min);
                    this.mFo.a(this.mFp, makeMeasureSpec, makeMeasureSpec2, i3, min, this.mFt.mPosition, this.mEY);
                } else {
                    this.mFo.LX(i);
                    this.mFo.a(this.mFp, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mEY);
                }
            } else if (this.mEY.size() > 0) {
                this.mFo.q(this.mEY, min);
                this.mFo.a(this.mFp, makeMeasureSpec2, makeMeasureSpec, i3, min, this.mFt.mPosition, this.mEY);
            } else {
                this.mFo.LX(i);
                this.mFo.c(this.mFp, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mEY);
            }
            this.mEY = this.mFp.mEY;
            this.mFo.ao(makeMeasureSpec, makeMeasureSpec2, min);
            this.mFo.LU(min);
        } else if (!this.mFt.mLayoutFromEnd) {
            this.mEY.clear();
            if (!$assertionsDisabled && this.mFo.mEV == null) {
                throw new AssertionError();
            }
            this.mFp.reset();
            if (dxN()) {
                this.mFo.b(this.mFp, makeMeasureSpec, makeMeasureSpec2, i3, this.mFt.mPosition, this.mEY);
            } else {
                this.mFo.d(this.mFp, makeMeasureSpec, makeMeasureSpec2, i3, this.mFt.mPosition, this.mEY);
            }
            this.mEY = this.mFp.mEY;
            this.mFo.ea(makeMeasureSpec, makeMeasureSpec2);
            this.mFo.dxW();
            this.mFt.mFy = this.mFo.mEV[this.mFt.mPosition];
            this.mFs.mFy = this.mFt.mFy;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mFv = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mFx = -1;
        this.mFt.reset();
        this.mFw.clear();
    }

    private void dxY() {
        int layoutDirection = getLayoutDirection();
        switch (this.mFa) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.mFr = this.mFb == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.mFr = this.mFb == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.mFb == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mFr = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.mFb == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mFr = true;
                return;
            default:
                this.mIsRtl = false;
                this.mFr = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.mFv) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.mFy = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.mFo.mEV != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.mFy = this.mFo.mEV[aVar.mPosition];
            if (this.mFv == null || !this.mFv.Mj(state.getItemCount())) {
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
                } else if (dxN() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.mFA = true;
            aVar.mFy = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View Mf;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            Mf = Mg(state.getItemCount());
        } else {
            Mf = Mf(state.getItemCount());
        }
        if (Mf != null) {
            aVar.dl(Mf);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(Mf) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(Mf) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View Mf(int i) {
        if ($assertionsDisabled || this.mFo.mEV != null) {
            View aq = aq(0, getChildCount(), i);
            if (aq == null) {
                return null;
            }
            int i2 = this.mFo.mEV[getPosition(aq)];
            if (i2 != -1) {
                return a(aq, this.mEY.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View Mg(int i) {
        if ($assertionsDisabled || this.mFo.mEV != null) {
            View aq = aq(getChildCount() - 1, -1, i);
            if (aq == null) {
                return null;
            }
            return b(aq, this.mEY.get(this.mFo.mEV[getPosition(aq)]));
        }
        throw new AssertionError();
    }

    private View aq(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dya();
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
        boolean dxN = dxN();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.mFs.mInfinite) && bVar.a(state, this.mEY)) {
                com.google.android.flexbox.b bVar2 = this.mEY.get(bVar.mFy);
                bVar.mPosition = bVar2.mER;
                i4 += a(bVar2, bVar);
                if (dxN || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dxU() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dxU() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dxU();
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
        if (!bVar.mFC) {
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
            if (!$assertionsDisabled && this.mFo.mEV == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mFo.mEV[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.mEY.get(i);
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
                        if (bVar2.mES == getPosition(childAt)) {
                            if (i >= this.mEY.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.mEY.get(i4);
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
        return (dxN() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.mFo.mEV == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mFo.mEV[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.mEY.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mER == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.mEY.get(i4);
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
        return (dxN() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dxN() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.mFo.mEW != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.mEK : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mFc) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.mEI) + paddingRight;
                    f2 = bVar.mEI - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.mEI) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.mEI) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.mEI) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mEI) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mEI) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mFc);
            }
            float f4 = f - this.mFt.mFz;
            float f5 = f2 - this.mFt.mFz;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View LQ = LQ(i6);
                if (LQ == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(LQ, mFq);
                        addView(LQ);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(LQ, mFq);
                        addView(LQ, i5);
                        i = i5 + 1;
                    }
                    long j = this.mFo.mEW[i6];
                    int gL = this.mFo.gL(j);
                    int gM = this.mFo.gM(j);
                    if (shouldMeasureChild(LQ, gL, gM, (LayoutParams) LQ.getLayoutParams())) {
                        LQ.measure(gL, gM);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(LQ);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(LQ));
                    int topDecorationHeight = i3 + getTopDecorationHeight(LQ);
                    if (this.mIsRtl) {
                        this.mFo.a(LQ, bVar, Math.round(rightDecorationWidth) - LQ.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + LQ.getMeasuredHeight());
                    } else {
                        this.mFo.a(LQ, bVar, Math.round(leftDecorationWidth), topDecorationHeight, LQ.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + LQ.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + LQ.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(LQ) + max;
                    measuredWidth2 = rightDecorationWidth - (((LQ.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(LQ)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.mFy += this.mFs.mLayoutDirection;
            return bVar.dxU();
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
        if ($assertionsDisabled || this.mFo.mEW != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.mEK;
                i = i5 + bVar.mEK;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mFc) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.mEI) + paddingBottom;
                    f2 = bVar.mEI - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.mEI) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.mEI) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.mEI) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mEI) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mEI) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mFc);
            }
            float f4 = f - this.mFt.mFz;
            float f5 = f2 - this.mFt.mFz;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View LQ = LQ(i9);
                if (LQ == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.mFo.mEW[i9];
                    int gL = this.mFo.gL(j);
                    int gM = this.mFo.gM(j);
                    if (shouldMeasureChild(LQ, gL, gM, (LayoutParams) LQ.getLayoutParams())) {
                        LQ.measure(gL, gM);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(LQ);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(LQ));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(LQ, mFq);
                        addView(LQ);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(LQ, mFq);
                        addView(LQ, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(LQ);
                    int rightDecorationWidth = i - getRightDecorationWidth(LQ);
                    if (this.mIsRtl) {
                        if (this.mFr) {
                            this.mFo.a(LQ, bVar, this.mIsRtl, rightDecorationWidth - LQ.getMeasuredWidth(), Math.round(bottomDecorationHeight) - LQ.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.mFo.a(LQ, bVar, this.mIsRtl, rightDecorationWidth - LQ.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, LQ.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.mFr) {
                        this.mFo.a(LQ, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - LQ.getMeasuredHeight(), leftDecorationWidth + LQ.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.mFo.a(LQ, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + LQ.getMeasuredWidth(), LQ.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((LQ.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(LQ)) + max);
                    measuredHeight2 = topDecorationHeight + LQ.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(LQ) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.mFy += this.mFs.mLayoutDirection;
            return bVar.dxU();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dxN() {
        return this.mFa == 0 || this.mFa == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dxZ();
        } else {
            this.mFs.mInfinite = false;
        }
        if (!dxN() && this.mIsRtl) {
            this.mFs.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.mFs.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.mFs.mPosition = aVar.mPosition;
        this.mFs.mItemDirection = 1;
        this.mFs.mLayoutDirection = 1;
        this.mFs.mOffset = aVar.mCoordinate;
        this.mFs.mScrollingOffset = Integer.MIN_VALUE;
        this.mFs.mFy = aVar.mFy;
        if (z && this.mEY.size() > 1 && aVar.mFy >= 0 && aVar.mFy < this.mEY.size() - 1) {
            b.i(this.mFs);
            b bVar = this.mFs;
            bVar.mPosition = this.mEY.get(aVar.mFy).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dxZ();
        } else {
            this.mFs.mInfinite = false;
        }
        if (!dxN() && this.mIsRtl) {
            this.mFs.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.mFs.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mFs.mPosition = aVar.mPosition;
        this.mFs.mItemDirection = 1;
        this.mFs.mLayoutDirection = -1;
        this.mFs.mOffset = aVar.mCoordinate;
        this.mFs.mScrollingOffset = Integer.MIN_VALUE;
        this.mFs.mFy = aVar.mFy;
        if (z && aVar.mFy > 0 && this.mEY.size() > aVar.mFy) {
            b.j(this.mFs);
            this.mFs.mPosition -= this.mEY.get(aVar.mFy).getItemCount();
        }
    }

    private void dxZ() {
        int widthMode;
        if (dxN()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.mFs.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dya() {
        if (this.mOrientationHelper == null) {
            if (dxN()) {
                if (this.mFb == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.mFu = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mFu = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mFb == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mFu = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mFu = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.mFs == null) {
            this.mFs = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mFv != null) {
            this.mFv.invalidateAnchor();
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
        return !dxN() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dxN() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dxN()) {
            int a2 = a(i, recycler, state);
            this.mFw.clear();
            return a2;
        }
        int Mh = Mh(i);
        this.mFt.mFz += Mh;
        this.mFu.offsetChildren(-Mh);
        return Mh;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dxN()) {
            int a2 = a(i, recycler, state);
            this.mFw.clear();
            return a2;
        }
        int Mh = Mh(i);
        this.mFt.mFz += Mh;
        this.mFu.offsetChildren(-Mh);
        return Mh;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dya();
        this.mFs.mFC = true;
        boolean z = !dxN() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        ee(i2, abs);
        int a2 = this.mFs.mScrollingOffset + a(recycler, state, this.mFs);
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
        this.mFs.mLastScrollDelta = i;
        return i;
    }

    private int Mh(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dya();
        boolean dxN = dxN();
        int width = dxN ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dxN ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.mFt.mFz) - width, abs);
            }
            if (this.mFt.mFz + i <= 0) {
                return i;
            }
            return -this.mFt.mFz;
        } else if (i > 0) {
            return Math.min((width2 - this.mFt.mFz) - width, i);
        } else {
            if (this.mFt.mFz + i >= 0) {
                return i;
            }
            return -this.mFt.mFz;
        }
    }

    private void ee(int i, int i2) {
        if (!$assertionsDisabled && this.mFo.mEV == null) {
            throw new AssertionError();
        }
        this.mFs.mLayoutDirection = i;
        boolean dxN = dxN();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dxN && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.mFs.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.mEY.get(this.mFo.mEV[position]));
            this.mFs.mItemDirection = 1;
            this.mFs.mPosition = this.mFs.mItemDirection + position;
            if (this.mFo.mEV.length <= this.mFs.mPosition) {
                this.mFs.mFy = -1;
            } else {
                this.mFs.mFy = this.mFo.mEV[this.mFs.mPosition];
            }
            if (z) {
                this.mFs.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.mFs.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.mFs.mScrollingOffset = this.mFs.mScrollingOffset >= 0 ? this.mFs.mScrollingOffset : 0;
            } else {
                this.mFs.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.mFs.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mFs.mFy == -1 || this.mFs.mFy > this.mEY.size() - 1) && this.mFs.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.mFs.mScrollingOffset;
                this.mFp.reset();
                if (i3 > 0) {
                    if (dxN) {
                        this.mFo.a(this.mFp, makeMeasureSpec, makeMeasureSpec2, i3, this.mFs.mPosition, this.mEY);
                    } else {
                        this.mFo.c(this.mFp, makeMeasureSpec, makeMeasureSpec2, i3, this.mFs.mPosition, this.mEY);
                    }
                    this.mFo.ao(makeMeasureSpec, makeMeasureSpec2, this.mFs.mPosition);
                    this.mFo.LU(this.mFs.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.mFs.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.mEY.get(this.mFo.mEV[position2]));
            this.mFs.mItemDirection = 1;
            int i4 = this.mFo.mEV[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.mFs.mPosition = position2 - this.mEY.get(i5 - 1).getItemCount();
            } else {
                this.mFs.mPosition = -1;
            }
            this.mFs.mFy = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.mFs.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.mFs.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.mFs.mScrollingOffset = this.mFs.mScrollingOffset >= 0 ? this.mFs.mScrollingOffset : 0;
            } else {
                this.mFs.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.mFs.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.mFs.mAvailable = i2 - this.mFs.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dxN = dxN();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dxN) {
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
        boolean dxN = dxN();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dxN) {
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
        dya();
        View Mf = Mf(itemCount);
        View Mg = Mg(itemCount);
        if (state.getItemCount() == 0 || Mf == null || Mg == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(Mg) - this.mOrientationHelper.getDecoratedStart(Mf));
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
        View Mf = Mf(itemCount);
        View Mg = Mg(itemCount);
        if (state.getItemCount() == 0 || Mf == null || Mg == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mFo.mEV != null) {
            int position = getPosition(Mf);
            int position2 = getPosition(Mg);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(Mg) - this.mOrientationHelper.getDecoratedStart(Mf));
            int i = this.mFo.mEV[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.mFo.mEV[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(Mf)));
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
        View Mf = Mf(itemCount);
        View Mg = Mg(itemCount);
        if (state.getItemCount() == 0 || Mf == null || Mg == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mFo.mEV != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(Mg) - this.mOrientationHelper.getDecoratedStart(Mf)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int dh(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int di(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int dj(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int dk(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean n(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int dh = dh(view);
        int dj = dj(view);
        int di = di(view);
        int dk = dk(view);
        return z ? (paddingLeft <= dh && width >= di) && (paddingTop <= dj && height >= dk) : (dh >= width || di >= paddingLeft) && (dj >= height || dk >= paddingTop);
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

    /* loaded from: classes4.dex */
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
            /* renamed from: Mi */
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
        public int dxO() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dxP() {
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
        public boolean dxQ() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dxR() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dxS() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dxT() {
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
    /* loaded from: classes4.dex */
    public class a {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int mCoordinate;
        private boolean mFA;
        final /* synthetic */ FlexboxLayoutManager mFB;
        private int mFy;
        private int mFz;
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mFy = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mFA = false;
            if (this.mFB.dxN()) {
                if (this.mFB.mFb == 0) {
                    this.mLayoutFromEnd = this.mFB.mFa == 1;
                } else {
                    this.mLayoutFromEnd = this.mFB.mFb == 2;
                }
            } else if (this.mFB.mFb == 0) {
                this.mLayoutFromEnd = this.mFB.mFa == 3;
            } else {
                this.mLayoutFromEnd = this.mFB.mFb == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.mFB.dxN() && this.mFB.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.mFB.mOrientationHelper.getEndAfterPadding() : this.mFB.getWidth() - this.mFB.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.mFB.mOrientationHelper.getEndAfterPadding() : this.mFB.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dl(View view) {
            if (!this.mFB.dxN() && this.mFB.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.mFB.mOrientationHelper.getDecoratedStart(view) + this.mFB.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.mFB.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mFB.mOrientationHelper.getDecoratedEnd(view) + this.mFB.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mFB.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.mFB.getPosition(view);
            this.mFA = false;
            if (!$assertionsDisabled && this.mFB.mFo.mEV == null) {
                throw new AssertionError();
            }
            int i = this.mFB.mFo.mEV[this.mPosition != -1 ? this.mPosition : 0];
            this.mFy = i != -1 ? i : 0;
            if (this.mFB.mEY.size() > this.mFy) {
                this.mPosition = ((com.google.android.flexbox.b) this.mFB.mEY.get(this.mFy)).mER;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mFy + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mFz + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mFA + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        private int mAvailable;
        private boolean mFC;
        private int mFy;
        private boolean mInfinite;
        private int mItemDirection;
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
            int i = bVar.mFy;
            bVar.mFy = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.mFy;
            bVar.mFy = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.mFy >= 0 && this.mFy < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mFy + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
            /* renamed from: Mk */
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
        public boolean Mj(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
