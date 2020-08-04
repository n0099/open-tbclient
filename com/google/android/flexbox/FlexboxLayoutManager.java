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
    private static final Rect nhO;
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
    private int nhA;
    private int nhB;
    private int nhD;
    private final c nhM;
    private c.a nhN;
    private boolean nhP;
    private b nhQ;
    private a nhR;
    private OrientationHelper nhS;
    private SavedState nhT;
    private SparseArray<View> nhU;
    private int nhV;
    private List<com.google.android.flexbox.b> nhw;
    private int nhy;
    private int nhz;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        nhO = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.nhy;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.nhz;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.nhB;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.nhD;
    }

    @Override // com.google.android.flexbox.a
    public int k(View view, int i, int i2) {
        return dKx() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dr(View view) {
        return dKx() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, nhO);
        if (dKx()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.nhg += leftDecorationWidth;
            bVar.nhh = leftDecorationWidth + bVar.nhh;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.nhg += topDecorationHeight;
        bVar.nhh = topDecorationHeight + bVar.nhh;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View JU(int i) {
        View view = this.nhU.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View JV(int i) {
        return JU(i);
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
        if (this.nhw.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.nhw.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.nhw.get(i2).nhg);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.nhw.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.nhw.get(i2).nhi;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.nhw = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.nhw;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
        this.nhU.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dKx()) {
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
        if (this.nhT != null) {
            return new SavedState(this.nhT);
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
            this.nhT = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        Kh(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        Kh(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        Kh(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        Kh(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        Kh(Math.min(i, i2));
    }

    private void Kh(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.nhM.Ka(childCount);
            this.nhM.JZ(childCount);
            this.nhM.Kb(childCount);
            if (!$assertionsDisabled && this.nhM.nht == null) {
                throw new AssertionError();
            }
            if (i < this.nhM.nht.length) {
                this.nhV = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dKx() && this.mIsRtl) {
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
            dKH();
            dKJ();
            ensureLayoutState();
            this.nhM.Ka(itemCount);
            this.nhM.JZ(itemCount);
            this.nhM.Kb(itemCount);
            this.nhQ.nia = false;
            if (this.nhT != null && this.nhT.Kn(itemCount)) {
                this.mPendingScrollPosition = this.nhT.mAnchorPosition;
            }
            if (!this.nhR.mValid || this.mPendingScrollPosition != -1 || this.nhT != null) {
                this.nhR.reset();
                a(state, this.nhR);
                this.nhR.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.nhR.mLayoutFromEnd) {
                b(this.nhR, false, true);
            } else {
                a(this.nhR, false, true);
            }
            Ki(itemCount);
            if (this.nhR.mLayoutFromEnd) {
                a(recycler, state, this.nhQ);
                i2 = this.nhQ.mOffset;
                a(this.nhR, true, false);
                a(recycler, state, this.nhQ);
                i = this.nhQ.mOffset;
            } else {
                a(recycler, state, this.nhQ);
                i = this.nhQ.mOffset;
                b(this.nhR, true, false);
                a(recycler, state, this.nhQ);
                i2 = this.nhQ.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.nhR.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dKx() && this.mIsRtl) {
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
        if (!dKx() && this.mIsRtl) {
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

    private void Ki(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (dKx()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.nhQ.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.nhQ.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.nhQ.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.nhQ.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.nhV != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.nhV != -1 ? Math.min(this.nhV, this.nhR.mPosition) : this.nhR.mPosition;
            this.nhN.reset();
            if (dKx()) {
                if (this.nhw.size() > 0) {
                    this.nhM.u(this.nhw, min);
                    this.nhM.a(this.nhN, makeMeasureSpec, makeMeasureSpec2, i3, min, this.nhR.mPosition, this.nhw);
                } else {
                    this.nhM.Kb(i);
                    this.nhM.a(this.nhN, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.nhw);
                }
            } else if (this.nhw.size() > 0) {
                this.nhM.u(this.nhw, min);
                this.nhM.a(this.nhN, makeMeasureSpec2, makeMeasureSpec, i3, min, this.nhR.mPosition, this.nhw);
            } else {
                this.nhM.Kb(i);
                this.nhM.c(this.nhN, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.nhw);
            }
            this.nhw = this.nhN.nhw;
            this.nhM.af(makeMeasureSpec, makeMeasureSpec2, min);
            this.nhM.JY(min);
        } else if (!this.nhR.mLayoutFromEnd) {
            this.nhw.clear();
            if (!$assertionsDisabled && this.nhM.nht == null) {
                throw new AssertionError();
            }
            this.nhN.reset();
            if (dKx()) {
                this.nhM.b(this.nhN, makeMeasureSpec, makeMeasureSpec2, i3, this.nhR.mPosition, this.nhw);
            } else {
                this.nhM.d(this.nhN, makeMeasureSpec, makeMeasureSpec2, i3, this.nhR.mPosition, this.nhw);
            }
            this.nhw = this.nhN.nhw;
            this.nhM.dE(makeMeasureSpec, makeMeasureSpec2);
            this.nhM.dKF();
            this.nhR.nhW = this.nhM.nht[this.nhR.mPosition];
            this.nhQ.nhW = this.nhR.nhW;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.nhT = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.nhV = -1;
        this.nhR.reset();
        this.nhU.clear();
    }

    private void dKH() {
        int layoutDirection = getLayoutDirection();
        switch (this.nhy) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.nhP = this.nhz == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.nhP = this.nhz == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.nhz == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.nhP = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.nhz == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.nhP = true;
                return;
            default:
                this.mIsRtl = false;
                this.nhP = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.nhT) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.nhW = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.nhM.nht != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.nhW = this.nhM.nht[aVar.mPosition];
            if (this.nhT == null || !this.nhT.Kn(state.getItemCount())) {
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
                } else if (dKx() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.nhY = true;
            aVar.nhW = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View Kj;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            Kj = Kk(state.getItemCount());
        } else {
            Kj = Kj(state.getItemCount());
        }
        if (Kj != null) {
            aVar.dw(Kj);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(Kj) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(Kj) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View Kj(int i) {
        if ($assertionsDisabled || this.nhM.nht != null) {
            View ah = ah(0, getChildCount(), i);
            if (ah == null) {
                return null;
            }
            int i2 = this.nhM.nht[getPosition(ah)];
            if (i2 != -1) {
                return a(ah, this.nhw.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View Kk(int i) {
        if ($assertionsDisabled || this.nhM.nht != null) {
            View ah = ah(getChildCount() - 1, -1, i);
            if (ah == null) {
                return null;
            }
            return b(ah, this.nhw.get(this.nhM.nht[getPosition(ah)]));
        }
        throw new AssertionError();
    }

    private View ah(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dKJ();
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
        boolean dKx = dKx();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.nhQ.mInfinite) && bVar.a(state, this.nhw)) {
                com.google.android.flexbox.b bVar2 = this.nhw.get(bVar.nhW);
                bVar.mPosition = bVar2.nhp;
                i4 += a(bVar2, bVar);
                if (dKx || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dKD() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dKD() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dKD();
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
        if (!bVar.nia) {
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
            if (!$assertionsDisabled && this.nhM.nht == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.nhM.nht[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.nhw.get(i);
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
                        if (bVar2.nhq == getPosition(childAt)) {
                            if (i >= this.nhw.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.nhw.get(i4);
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
        return (dKx() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.nhM.nht == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.nhM.nht[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.nhw.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!B(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.nhp == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.nhw.get(i4);
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
        return (dKx() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dKx() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.nhM.nhu != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.nhi : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.nhA) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.nhg) + paddingRight;
                    f2 = bVar.nhg - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.nhg) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.nhg) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.nhg) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.nhg) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.nhg) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.nhA);
            }
            float f4 = f - this.nhR.nhX;
            float f5 = f2 - this.nhR.nhX;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View JU = JU(i6);
                if (JU == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(JU, nhO);
                        addView(JU);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(JU, nhO);
                        addView(JU, i5);
                        i = i5 + 1;
                    }
                    long j = this.nhM.nhu[i6];
                    int gk = this.nhM.gk(j);
                    int gl = this.nhM.gl(j);
                    if (shouldMeasureChild(JU, gk, gl, (LayoutParams) JU.getLayoutParams())) {
                        JU.measure(gk, gl);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(JU);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(JU));
                    int topDecorationHeight = i3 + getTopDecorationHeight(JU);
                    if (this.mIsRtl) {
                        this.nhM.a(JU, bVar, Math.round(rightDecorationWidth) - JU.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + JU.getMeasuredHeight());
                    } else {
                        this.nhM.a(JU, bVar, Math.round(leftDecorationWidth), topDecorationHeight, JU.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + JU.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + JU.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(JU) + max;
                    measuredWidth2 = rightDecorationWidth - (((JU.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(JU)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.nhW += this.nhQ.mLayoutDirection;
            return bVar.dKD();
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
        if ($assertionsDisabled || this.nhM.nhu != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.nhi;
                i = i5 + bVar.nhi;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.nhA) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.nhg) + paddingBottom;
                    f2 = bVar.nhg - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.nhg) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.nhg) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.nhg) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.nhg) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.nhg) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.nhA);
            }
            float f4 = f - this.nhR.nhX;
            float f5 = f2 - this.nhR.nhX;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View JU = JU(i9);
                if (JU == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.nhM.nhu[i9];
                    int gk = this.nhM.gk(j);
                    int gl = this.nhM.gl(j);
                    if (shouldMeasureChild(JU, gk, gl, (LayoutParams) JU.getLayoutParams())) {
                        JU.measure(gk, gl);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(JU);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(JU));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(JU, nhO);
                        addView(JU);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(JU, nhO);
                        addView(JU, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(JU);
                    int rightDecorationWidth = i - getRightDecorationWidth(JU);
                    if (this.mIsRtl) {
                        if (this.nhP) {
                            this.nhM.a(JU, bVar, this.mIsRtl, rightDecorationWidth - JU.getMeasuredWidth(), Math.round(bottomDecorationHeight) - JU.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.nhM.a(JU, bVar, this.mIsRtl, rightDecorationWidth - JU.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, JU.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.nhP) {
                        this.nhM.a(JU, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - JU.getMeasuredHeight(), leftDecorationWidth + JU.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.nhM.a(JU, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + JU.getMeasuredWidth(), JU.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((JU.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(JU)) + max);
                    measuredHeight2 = topDecorationHeight + JU.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(JU) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.nhW += this.nhQ.mLayoutDirection;
            return bVar.dKD();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dKx() {
        return this.nhy == 0 || this.nhy == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dKI();
        } else {
            this.nhQ.mInfinite = false;
        }
        if (!dKx() && this.mIsRtl) {
            this.nhQ.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.nhQ.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.nhQ.mPosition = aVar.mPosition;
        this.nhQ.mItemDirection = 1;
        this.nhQ.mLayoutDirection = 1;
        this.nhQ.mOffset = aVar.mCoordinate;
        this.nhQ.mScrollingOffset = Integer.MIN_VALUE;
        this.nhQ.nhW = aVar.nhW;
        if (z && this.nhw.size() > 1 && aVar.nhW >= 0 && aVar.nhW < this.nhw.size() - 1) {
            b.i(this.nhQ);
            b bVar = this.nhQ;
            bVar.mPosition = this.nhw.get(aVar.nhW).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dKI();
        } else {
            this.nhQ.mInfinite = false;
        }
        if (!dKx() && this.mIsRtl) {
            this.nhQ.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.nhQ.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.nhQ.mPosition = aVar.mPosition;
        this.nhQ.mItemDirection = 1;
        this.nhQ.mLayoutDirection = -1;
        this.nhQ.mOffset = aVar.mCoordinate;
        this.nhQ.mScrollingOffset = Integer.MIN_VALUE;
        this.nhQ.nhW = aVar.nhW;
        if (z && aVar.nhW > 0 && this.nhw.size() > aVar.nhW) {
            b.j(this.nhQ);
            this.nhQ.mPosition -= this.nhw.get(aVar.nhW).getItemCount();
        }
    }

    private void dKI() {
        int widthMode;
        if (dKx()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.nhQ.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dKJ() {
        if (this.mOrientationHelper == null) {
            if (dKx()) {
                if (this.nhz == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.nhS = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.nhS = OrientationHelper.createHorizontalHelper(this);
            } else if (this.nhz == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.nhS = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.nhS = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.nhQ == null) {
            this.nhQ = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.nhT != null) {
            this.nhT.invalidateAnchor();
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
        return !dKx() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dKx() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dKx()) {
            int a2 = a(i, recycler, state);
            this.nhU.clear();
            return a2;
        }
        int Kl = Kl(i);
        this.nhR.nhX += Kl;
        this.nhS.offsetChildren(-Kl);
        return Kl;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dKx()) {
            int a2 = a(i, recycler, state);
            this.nhU.clear();
            return a2;
        }
        int Kl = Kl(i);
        this.nhR.nhX += Kl;
        this.nhS.offsetChildren(-Kl);
        return Kl;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dKJ();
        this.nhQ.nia = true;
        boolean z = !dKx() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        dI(i2, abs);
        int a2 = this.nhQ.mScrollingOffset + a(recycler, state, this.nhQ);
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
        this.nhQ.mLastScrollDelta = i;
        return i;
    }

    private int Kl(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dKJ();
        boolean dKx = dKx();
        int width = dKx ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dKx ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.nhR.nhX) - width, abs);
            }
            if (this.nhR.nhX + i <= 0) {
                return i;
            }
            return -this.nhR.nhX;
        } else if (i > 0) {
            return Math.min((width2 - this.nhR.nhX) - width, i);
        } else {
            if (this.nhR.nhX + i >= 0) {
                return i;
            }
            return -this.nhR.nhX;
        }
    }

    private void dI(int i, int i2) {
        if (!$assertionsDisabled && this.nhM.nht == null) {
            throw new AssertionError();
        }
        this.nhQ.mLayoutDirection = i;
        boolean dKx = dKx();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dKx && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.nhQ.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.nhw.get(this.nhM.nht[position]));
            this.nhQ.mItemDirection = 1;
            this.nhQ.mPosition = this.nhQ.mItemDirection + position;
            if (this.nhM.nht.length <= this.nhQ.mPosition) {
                this.nhQ.nhW = -1;
            } else {
                this.nhQ.nhW = this.nhM.nht[this.nhQ.mPosition];
            }
            if (z) {
                this.nhQ.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.nhQ.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.nhQ.mScrollingOffset = this.nhQ.mScrollingOffset >= 0 ? this.nhQ.mScrollingOffset : 0;
            } else {
                this.nhQ.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.nhQ.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.nhQ.nhW == -1 || this.nhQ.nhW > this.nhw.size() - 1) && this.nhQ.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.nhQ.mScrollingOffset;
                this.nhN.reset();
                if (i3 > 0) {
                    if (dKx) {
                        this.nhM.a(this.nhN, makeMeasureSpec, makeMeasureSpec2, i3, this.nhQ.mPosition, this.nhw);
                    } else {
                        this.nhM.c(this.nhN, makeMeasureSpec, makeMeasureSpec2, i3, this.nhQ.mPosition, this.nhw);
                    }
                    this.nhM.af(makeMeasureSpec, makeMeasureSpec2, this.nhQ.mPosition);
                    this.nhM.JY(this.nhQ.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.nhQ.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.nhw.get(this.nhM.nht[position2]));
            this.nhQ.mItemDirection = 1;
            int i4 = this.nhM.nht[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.nhQ.mPosition = position2 - this.nhw.get(i5 - 1).getItemCount();
            } else {
                this.nhQ.mPosition = -1;
            }
            this.nhQ.nhW = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.nhQ.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.nhQ.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.nhQ.mScrollingOffset = this.nhQ.mScrollingOffset >= 0 ? this.nhQ.mScrollingOffset : 0;
            } else {
                this.nhQ.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.nhQ.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.nhQ.mAvailable = i2 - this.nhQ.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dKx = dKx();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dKx) {
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
        boolean dKx = dKx();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dKx) {
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
        dKJ();
        View Kj = Kj(itemCount);
        View Kk = Kk(itemCount);
        if (state.getItemCount() == 0 || Kj == null || Kk == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(Kk) - this.mOrientationHelper.getDecoratedStart(Kj));
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
        View Kj = Kj(itemCount);
        View Kk = Kk(itemCount);
        if (state.getItemCount() == 0 || Kj == null || Kk == null) {
            return 0;
        }
        if ($assertionsDisabled || this.nhM.nht != null) {
            int position = getPosition(Kj);
            int position2 = getPosition(Kk);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(Kk) - this.mOrientationHelper.getDecoratedStart(Kj));
            int i = this.nhM.nht[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.nhM.nht[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(Kj)));
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
        View Kj = Kj(itemCount);
        View Kk = Kk(itemCount);
        if (state.getItemCount() == 0 || Kj == null || Kk == null) {
            return 0;
        }
        if ($assertionsDisabled || this.nhM.nht != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(Kk) - this.mOrientationHelper.getDecoratedStart(Kj)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int ds(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int dt(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int du(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int dv(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean p(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int ds = ds(view);
        int du = du(view);
        int dt = dt(view);
        int dv = dv(view);
        return z ? (paddingLeft <= ds && width >= dt) && (paddingTop <= du && height >= dv) : (ds >= width || dt >= paddingLeft) && (du >= height || dv >= paddingTop);
    }

    public int findFirstVisibleItemPosition() {
        View o = o(0, getChildCount(), false);
        if (o == null) {
            return -1;
        }
        return getPosition(o);
    }

    public int findLastVisibleItemPosition() {
        View o = o(getChildCount() - 1, -1, false);
        if (o == null) {
            return -1;
        }
        return getPosition(o);
    }

    private View o(int i, int i2, boolean z) {
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
            /* renamed from: al */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Km */
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
        public int dKy() {
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
        public boolean dKz() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dKA() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dKB() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dKC() {
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
        private int nhW;
        private int nhX;
        private boolean nhY;
        final /* synthetic */ FlexboxLayoutManager nhZ;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.nhW = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.nhY = false;
            if (this.nhZ.dKx()) {
                if (this.nhZ.nhz == 0) {
                    this.mLayoutFromEnd = this.nhZ.nhy == 1;
                } else {
                    this.mLayoutFromEnd = this.nhZ.nhz == 2;
                }
            } else if (this.nhZ.nhz == 0) {
                this.mLayoutFromEnd = this.nhZ.nhy == 3;
            } else {
                this.mLayoutFromEnd = this.nhZ.nhz == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.nhZ.dKx() && this.nhZ.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.nhZ.mOrientationHelper.getEndAfterPadding() : this.nhZ.getWidth() - this.nhZ.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.nhZ.mOrientationHelper.getEndAfterPadding() : this.nhZ.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dw(View view) {
            if (!this.nhZ.dKx() && this.nhZ.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.nhZ.mOrientationHelper.getDecoratedStart(view) + this.nhZ.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.nhZ.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.nhZ.mOrientationHelper.getDecoratedEnd(view) + this.nhZ.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.nhZ.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.nhZ.getPosition(view);
            this.nhY = false;
            if (!$assertionsDisabled && this.nhZ.nhM.nht == null) {
                throw new AssertionError();
            }
            int i = this.nhZ.nhM.nht[this.mPosition != -1 ? this.mPosition : 0];
            this.nhW = i != -1 ? i : 0;
            if (this.nhZ.nhw.size() > this.nhW) {
                this.mPosition = ((com.google.android.flexbox.b) this.nhZ.nhw.get(this.nhW)).nhp;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.nhW + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.nhX + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.nhY + '}';
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
        private int nhW;
        private boolean nia;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.nhW;
            bVar.nhW = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.nhW;
            bVar.nhW = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.nhW >= 0 && this.nhW < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.nhW + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: am */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Ko */
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
        public boolean Kn(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
