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
    private static final Rect nBY;
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
    private List<com.google.android.flexbox.b> nBG;
    private int nBI;
    private int nBJ;
    private int nBK;
    private int nBL;
    private int nBN;
    private final c nBW;
    private c.a nBX;
    private boolean nBZ;
    private b nCa;
    private a nCb;
    private OrientationHelper nCc;
    private SavedState nCd;
    private SparseArray<View> nCe;
    private int nCf;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        nBY = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.nBI;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.nBJ;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.nBL;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.nBN;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        return dWH() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dv(View view) {
        return dWH() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, nBY);
        if (dWH()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.nBq += leftDecorationWidth;
            bVar.nBr = leftDecorationWidth + bVar.nBr;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.nBq += topDecorationHeight;
        bVar.nBr = topDecorationHeight + bVar.nBr;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View My(int i) {
        View view = this.nCe.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View Mz(int i) {
        return My(i);
    }

    @Override // com.google.android.flexbox.a
    public void a(com.google.android.flexbox.b bVar) {
    }

    @Override // com.google.android.flexbox.a
    public int ad(int i, int i2, int i3) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int ae(int i, int i2, int i3) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.nBG.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.nBG.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.nBG.get(i2).nBq);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.nBG.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.nBG.get(i2).nBs;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.nBG = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.nBG;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
        this.nCe.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dWH()) {
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
        if (this.nCd != null) {
            return new SavedState(this.nCd);
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
            this.nCd = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        ML(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        ML(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        ML(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        ML(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        ML(Math.min(i, i2));
    }

    private void ML(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.nBW.ME(childCount);
            this.nBW.MD(childCount);
            this.nBW.MF(childCount);
            if (!$assertionsDisabled && this.nBW.nBD == null) {
                throw new AssertionError();
            }
            if (i < this.nBW.nBD.length) {
                this.nCf = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dWH() && this.mIsRtl) {
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
            dWR();
            dWT();
            ensureLayoutState();
            this.nBW.ME(itemCount);
            this.nBW.MD(itemCount);
            this.nBW.MF(itemCount);
            this.nCa.nCk = false;
            if (this.nCd != null && this.nCd.MR(itemCount)) {
                this.mPendingScrollPosition = this.nCd.mAnchorPosition;
            }
            if (!this.nCb.mValid || this.mPendingScrollPosition != -1 || this.nCd != null) {
                this.nCb.reset();
                a(state, this.nCb);
                this.nCb.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.nCb.mLayoutFromEnd) {
                b(this.nCb, false, true);
            } else {
                a(this.nCb, false, true);
            }
            MM(itemCount);
            if (this.nCb.mLayoutFromEnd) {
                a(recycler, state, this.nCa);
                i2 = this.nCa.mOffset;
                a(this.nCb, true, false);
                a(recycler, state, this.nCa);
                i = this.nCa.mOffset;
            } else {
                a(recycler, state, this.nCa);
                i = this.nCa.mOffset;
                b(this.nCb, true, false);
                a(recycler, state, this.nCa);
                i2 = this.nCa.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.nCb.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dWH() && this.mIsRtl) {
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
        if (!dWH() && this.mIsRtl) {
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

    private void MM(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (dWH()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.nCa.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.nCa.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.nCa.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.nCa.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.nCf != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.nCf != -1 ? Math.min(this.nCf, this.nCb.mPosition) : this.nCb.mPosition;
            this.nBX.reset();
            if (dWH()) {
                if (this.nBG.size() > 0) {
                    this.nBW.y(this.nBG, min);
                    this.nBW.a(this.nBX, makeMeasureSpec, makeMeasureSpec2, i3, min, this.nCb.mPosition, this.nBG);
                } else {
                    this.nBW.MF(i);
                    this.nBW.a(this.nBX, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.nBG);
                }
            } else if (this.nBG.size() > 0) {
                this.nBW.y(this.nBG, min);
                this.nBW.a(this.nBX, makeMeasureSpec2, makeMeasureSpec, i3, min, this.nCb.mPosition, this.nBG);
            } else {
                this.nBW.MF(i);
                this.nBW.c(this.nBX, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.nBG);
            }
            this.nBG = this.nBX.nBG;
            this.nBW.af(makeMeasureSpec, makeMeasureSpec2, min);
            this.nBW.MC(min);
        } else if (!this.nCb.mLayoutFromEnd) {
            this.nBG.clear();
            if (!$assertionsDisabled && this.nBW.nBD == null) {
                throw new AssertionError();
            }
            this.nBX.reset();
            if (dWH()) {
                this.nBW.b(this.nBX, makeMeasureSpec, makeMeasureSpec2, i3, this.nCb.mPosition, this.nBG);
            } else {
                this.nBW.d(this.nBX, makeMeasureSpec, makeMeasureSpec2, i3, this.nCb.mPosition, this.nBG);
            }
            this.nBG = this.nBX.nBG;
            this.nBW.dM(makeMeasureSpec, makeMeasureSpec2);
            this.nBW.dWP();
            this.nCb.nCg = this.nBW.nBD[this.nCb.mPosition];
            this.nCa.nCg = this.nCb.nCg;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.nCd = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.nCf = -1;
        this.nCb.reset();
        this.nCe.clear();
    }

    private void dWR() {
        int layoutDirection = getLayoutDirection();
        switch (this.nBI) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.nBZ = this.nBJ == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.nBZ = this.nBJ == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.nBJ == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.nBZ = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.nBJ == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.nBZ = true;
                return;
            default:
                this.mIsRtl = false;
                this.nBZ = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.nCd) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.nCg = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.nBW.nBD != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.nCg = this.nBW.nBD[aVar.mPosition];
            if (this.nCd == null || !this.nCd.MR(state.getItemCount())) {
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
                } else if (dWH() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.nCi = true;
            aVar.nCg = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View MN;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            MN = MO(state.getItemCount());
        } else {
            MN = MN(state.getItemCount());
        }
        if (MN != null) {
            aVar.dA(MN);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(MN) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(MN) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View MN(int i) {
        if ($assertionsDisabled || this.nBW.nBD != null) {
            View ah = ah(0, getChildCount(), i);
            if (ah == null) {
                return null;
            }
            int i2 = this.nBW.nBD[getPosition(ah)];
            if (i2 != -1) {
                return a(ah, this.nBG.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View MO(int i) {
        if ($assertionsDisabled || this.nBW.nBD != null) {
            View ah = ah(getChildCount() - 1, -1, i);
            if (ah == null) {
                return null;
            }
            return b(ah, this.nBG.get(this.nBW.nBD[getPosition(ah)]));
        }
        throw new AssertionError();
    }

    private View ah(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dWT();
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
        boolean dWH = dWH();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.nCa.mInfinite) && bVar.a(state, this.nBG)) {
                com.google.android.flexbox.b bVar2 = this.nBG.get(bVar.nCg);
                bVar.mPosition = bVar2.nBz;
                i4 += a(bVar2, bVar);
                if (dWH || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dWN() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dWN() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dWN();
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
        if (!bVar.nCk) {
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
            if (!$assertionsDisabled && this.nBW.nBD == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.nBW.nBD[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.nBG.get(i);
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.nBA == getPosition(childAt)) {
                            if (i >= this.nBG.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.nBG.get(i4);
                            i2 = i3;
                        }
                        i3++;
                    }
                    recycleChildren(recycler, 0, i2);
                }
            }
        }
    }

    private boolean A(View view, int i) {
        return (dWH() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.nBW.nBD == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.nBW.nBD[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.nBG.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!B(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.nBz == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.nBG.get(i4);
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

    private boolean B(View view, int i) {
        return (dWH() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dWH() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.nBW.nBE != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.nBs : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.nBK) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.nBq) + paddingRight;
                    f2 = bVar.nBq - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.nBq) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.nBq) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.nBq) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.nBq) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.nBq) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.nBK);
            }
            float f4 = f - this.nCb.nCh;
            float f5 = f2 - this.nCb.nCh;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View My = My(i6);
                if (My == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(My, nBY);
                        addView(My);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(My, nBY);
                        addView(My, i5);
                        i = i5 + 1;
                    }
                    long j = this.nBW.nBE[i6];
                    int gz = this.nBW.gz(j);
                    int gA = this.nBW.gA(j);
                    if (shouldMeasureChild(My, gz, gA, (LayoutParams) My.getLayoutParams())) {
                        My.measure(gz, gA);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(My);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(My));
                    int topDecorationHeight = i3 + getTopDecorationHeight(My);
                    if (this.mIsRtl) {
                        this.nBW.a(My, bVar, Math.round(rightDecorationWidth) - My.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + My.getMeasuredHeight());
                    } else {
                        this.nBW.a(My, bVar, Math.round(leftDecorationWidth), topDecorationHeight, My.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + My.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + My.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(My) + max;
                    measuredWidth2 = rightDecorationWidth - (((My.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(My)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.nCg += this.nCa.mLayoutDirection;
            return bVar.dWN();
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
        if ($assertionsDisabled || this.nBW.nBE != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.nBs;
                i = i5 + bVar.nBs;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.nBK) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.nBq) + paddingBottom;
                    f2 = bVar.nBq - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.nBq) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.nBq) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.nBq) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.nBq) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.nBq) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.nBK);
            }
            float f4 = f - this.nCb.nCh;
            float f5 = f2 - this.nCb.nCh;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View My = My(i9);
                if (My == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.nBW.nBE[i9];
                    int gz = this.nBW.gz(j);
                    int gA = this.nBW.gA(j);
                    if (shouldMeasureChild(My, gz, gA, (LayoutParams) My.getLayoutParams())) {
                        My.measure(gz, gA);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(My);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(My));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(My, nBY);
                        addView(My);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(My, nBY);
                        addView(My, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(My);
                    int rightDecorationWidth = i - getRightDecorationWidth(My);
                    if (this.mIsRtl) {
                        if (this.nBZ) {
                            this.nBW.a(My, bVar, this.mIsRtl, rightDecorationWidth - My.getMeasuredWidth(), Math.round(bottomDecorationHeight) - My.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.nBW.a(My, bVar, this.mIsRtl, rightDecorationWidth - My.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, My.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.nBZ) {
                        this.nBW.a(My, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - My.getMeasuredHeight(), leftDecorationWidth + My.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.nBW.a(My, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + My.getMeasuredWidth(), My.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((My.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(My)) + max);
                    measuredHeight2 = topDecorationHeight + My.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(My) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.nCg += this.nCa.mLayoutDirection;
            return bVar.dWN();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dWH() {
        return this.nBI == 0 || this.nBI == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dWS();
        } else {
            this.nCa.mInfinite = false;
        }
        if (!dWH() && this.mIsRtl) {
            this.nCa.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.nCa.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.nCa.mPosition = aVar.mPosition;
        this.nCa.mItemDirection = 1;
        this.nCa.mLayoutDirection = 1;
        this.nCa.mOffset = aVar.mCoordinate;
        this.nCa.mScrollingOffset = Integer.MIN_VALUE;
        this.nCa.nCg = aVar.nCg;
        if (z && this.nBG.size() > 1 && aVar.nCg >= 0 && aVar.nCg < this.nBG.size() - 1) {
            b.i(this.nCa);
            b bVar = this.nCa;
            bVar.mPosition = this.nBG.get(aVar.nCg).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dWS();
        } else {
            this.nCa.mInfinite = false;
        }
        if (!dWH() && this.mIsRtl) {
            this.nCa.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.nCa.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.nCa.mPosition = aVar.mPosition;
        this.nCa.mItemDirection = 1;
        this.nCa.mLayoutDirection = -1;
        this.nCa.mOffset = aVar.mCoordinate;
        this.nCa.mScrollingOffset = Integer.MIN_VALUE;
        this.nCa.nCg = aVar.nCg;
        if (z && aVar.nCg > 0 && this.nBG.size() > aVar.nCg) {
            b.j(this.nCa);
            this.nCa.mPosition -= this.nBG.get(aVar.nCg).getItemCount();
        }
    }

    private void dWS() {
        int widthMode;
        if (dWH()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.nCa.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dWT() {
        if (this.mOrientationHelper == null) {
            if (dWH()) {
                if (this.nBJ == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.nCc = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.nCc = OrientationHelper.createHorizontalHelper(this);
            } else if (this.nBJ == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.nCc = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.nCc = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.nCa == null) {
            this.nCa = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.nCd != null) {
            this.nCd.invalidateAnchor();
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
        return !dWH() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dWH() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dWH()) {
            int a2 = a(i, recycler, state);
            this.nCe.clear();
            return a2;
        }
        int MP = MP(i);
        this.nCb.nCh += MP;
        this.nCc.offsetChildren(-MP);
        return MP;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dWH()) {
            int a2 = a(i, recycler, state);
            this.nCe.clear();
            return a2;
        }
        int MP = MP(i);
        this.nCb.nCh += MP;
        this.nCc.offsetChildren(-MP);
        return MP;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dWT();
        this.nCa.nCk = true;
        boolean z = !dWH() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        dQ(i2, abs);
        int a2 = this.nCa.mScrollingOffset + a(recycler, state, this.nCa);
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
        this.nCa.mLastScrollDelta = i;
        return i;
    }

    private int MP(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dWT();
        boolean dWH = dWH();
        int width = dWH ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dWH ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.nCb.nCh) - width, abs);
            }
            if (this.nCb.nCh + i <= 0) {
                return i;
            }
            return -this.nCb.nCh;
        } else if (i > 0) {
            return Math.min((width2 - this.nCb.nCh) - width, i);
        } else {
            if (this.nCb.nCh + i >= 0) {
                return i;
            }
            return -this.nCb.nCh;
        }
    }

    private void dQ(int i, int i2) {
        if (!$assertionsDisabled && this.nBW.nBD == null) {
            throw new AssertionError();
        }
        this.nCa.mLayoutDirection = i;
        boolean dWH = dWH();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dWH && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.nCa.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.nBG.get(this.nBW.nBD[position]));
            this.nCa.mItemDirection = 1;
            this.nCa.mPosition = this.nCa.mItemDirection + position;
            if (this.nBW.nBD.length <= this.nCa.mPosition) {
                this.nCa.nCg = -1;
            } else {
                this.nCa.nCg = this.nBW.nBD[this.nCa.mPosition];
            }
            if (z) {
                this.nCa.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.nCa.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.nCa.mScrollingOffset = this.nCa.mScrollingOffset >= 0 ? this.nCa.mScrollingOffset : 0;
            } else {
                this.nCa.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.nCa.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.nCa.nCg == -1 || this.nCa.nCg > this.nBG.size() - 1) && this.nCa.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.nCa.mScrollingOffset;
                this.nBX.reset();
                if (i3 > 0) {
                    if (dWH) {
                        this.nBW.a(this.nBX, makeMeasureSpec, makeMeasureSpec2, i3, this.nCa.mPosition, this.nBG);
                    } else {
                        this.nBW.c(this.nBX, makeMeasureSpec, makeMeasureSpec2, i3, this.nCa.mPosition, this.nBG);
                    }
                    this.nBW.af(makeMeasureSpec, makeMeasureSpec2, this.nCa.mPosition);
                    this.nBW.MC(this.nCa.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.nCa.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.nBG.get(this.nBW.nBD[position2]));
            this.nCa.mItemDirection = 1;
            int i4 = this.nBW.nBD[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.nCa.mPosition = position2 - this.nBG.get(i5 - 1).getItemCount();
            } else {
                this.nCa.mPosition = -1;
            }
            this.nCa.nCg = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.nCa.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.nCa.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.nCa.mScrollingOffset = this.nCa.mScrollingOffset >= 0 ? this.nCa.mScrollingOffset : 0;
            } else {
                this.nCa.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.nCa.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.nCa.mAvailable = i2 - this.nCa.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dWH = dWH();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dWH) {
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
        boolean dWH = dWH();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dWH) {
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
        dWT();
        View MN = MN(itemCount);
        View MO = MO(itemCount);
        if (state.getItemCount() == 0 || MN == null || MO == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(MO) - this.mOrientationHelper.getDecoratedStart(MN));
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
        View MN = MN(itemCount);
        View MO = MO(itemCount);
        if (state.getItemCount() == 0 || MN == null || MO == null) {
            return 0;
        }
        if ($assertionsDisabled || this.nBW.nBD != null) {
            int position = getPosition(MN);
            int position2 = getPosition(MO);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(MO) - this.mOrientationHelper.getDecoratedStart(MN));
            int i = this.nBW.nBD[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.nBW.nBD[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(MN)));
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
        View MN = MN(itemCount);
        View MO = MO(itemCount);
        if (state.getItemCount() == 0 || MN == null || MO == null) {
            return 0;
        }
        if ($assertionsDisabled || this.nBW.nBD != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(MO) - this.mOrientationHelper.getDecoratedStart(MN)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int dw(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int dx(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int dy(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int dz(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean o(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int dw = dw(view);
        int dy = dy(view);
        int dx = dx(view);
        int dz = dz(view);
        return z ? (paddingLeft <= dw && width >= dx) && (paddingTop <= dy && height >= dz) : (dw >= width || dx >= paddingLeft) && (dy >= height || dz >= paddingTop);
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
            if (o(childAt, z)) {
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
            /* renamed from: am */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: MQ */
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
        public int dWI() {
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
        public boolean dWJ() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dWK() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dWL() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dWM() {
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
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;
        private int nCg;
        private int nCh;
        private boolean nCi;
        final /* synthetic */ FlexboxLayoutManager nCj;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.nCg = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.nCi = false;
            if (this.nCj.dWH()) {
                if (this.nCj.nBJ == 0) {
                    this.mLayoutFromEnd = this.nCj.nBI == 1;
                } else {
                    this.mLayoutFromEnd = this.nCj.nBJ == 2;
                }
            } else if (this.nCj.nBJ == 0) {
                this.mLayoutFromEnd = this.nCj.nBI == 3;
            } else {
                this.mLayoutFromEnd = this.nCj.nBJ == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.nCj.dWH() && this.nCj.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.nCj.mOrientationHelper.getEndAfterPadding() : this.nCj.getWidth() - this.nCj.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.nCj.mOrientationHelper.getEndAfterPadding() : this.nCj.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dA(View view) {
            if (!this.nCj.dWH() && this.nCj.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.nCj.mOrientationHelper.getDecoratedStart(view) + this.nCj.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.nCj.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.nCj.mOrientationHelper.getDecoratedEnd(view) + this.nCj.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.nCj.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.nCj.getPosition(view);
            this.nCi = false;
            if (!$assertionsDisabled && this.nCj.nBW.nBD == null) {
                throw new AssertionError();
            }
            int i = this.nCj.nBW.nBD[this.mPosition != -1 ? this.mPosition : 0];
            this.nCg = i != -1 ? i : 0;
            if (this.nCj.nBG.size() > this.nCg) {
                this.mPosition = ((com.google.android.flexbox.b) this.nCj.nBG.get(this.nCg)).nBz;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.nCg + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.nCh + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.nCi + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        private int mAvailable;
        private boolean mInfinite;
        private int mItemDirection;
        private int mLastScrollDelta;
        private int mLayoutDirection;
        private int mOffset;
        private int mPosition;
        private int mScrollingOffset;
        private int nCg;
        private boolean nCk;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.nCg;
            bVar.nCg = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.nCg;
            bVar.nCg = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.nCg >= 0 && this.nCg < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.nCg + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: an */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: MS */
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
        public boolean MR(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
