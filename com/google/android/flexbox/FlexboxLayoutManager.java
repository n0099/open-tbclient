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
    private static final Rect nhM;
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
    private int nhB;
    private final c nhK;
    private c.a nhL;
    private boolean nhN;
    private b nhO;
    private a nhP;
    private OrientationHelper nhQ;
    private SavedState nhR;
    private SparseArray<View> nhS;
    private int nhT;
    private List<com.google.android.flexbox.b> nhu;
    private int nhw;
    private int nhx;
    private int nhy;
    private int nhz;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        nhM = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.nhw;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.nhx;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.nhz;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.nhB;
    }

    @Override // com.google.android.flexbox.a
    public int k(View view, int i, int i2) {
        return dKw() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dr(View view) {
        return dKw() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, nhM);
        if (dKw()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.nhe += leftDecorationWidth;
            bVar.nhf = leftDecorationWidth + bVar.nhf;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.nhe += topDecorationHeight;
        bVar.nhf = topDecorationHeight + bVar.nhf;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View JU(int i) {
        View view = this.nhS.get(i);
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
        if (this.nhu.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.nhu.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.nhu.get(i2).nhe);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.nhu.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.nhu.get(i2).nhg;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.nhu = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.nhu;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
        this.nhS.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dKw()) {
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
        if (this.nhR != null) {
            return new SavedState(this.nhR);
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
            this.nhR = (SavedState) parcelable;
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
            this.nhK.Ka(childCount);
            this.nhK.JZ(childCount);
            this.nhK.Kb(childCount);
            if (!$assertionsDisabled && this.nhK.nhr == null) {
                throw new AssertionError();
            }
            if (i < this.nhK.nhr.length) {
                this.nhT = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dKw() && this.mIsRtl) {
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
            dKG();
            dKI();
            ensureLayoutState();
            this.nhK.Ka(itemCount);
            this.nhK.JZ(itemCount);
            this.nhK.Kb(itemCount);
            this.nhO.nhY = false;
            if (this.nhR != null && this.nhR.Kn(itemCount)) {
                this.mPendingScrollPosition = this.nhR.mAnchorPosition;
            }
            if (!this.nhP.mValid || this.mPendingScrollPosition != -1 || this.nhR != null) {
                this.nhP.reset();
                a(state, this.nhP);
                this.nhP.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.nhP.mLayoutFromEnd) {
                b(this.nhP, false, true);
            } else {
                a(this.nhP, false, true);
            }
            Ki(itemCount);
            if (this.nhP.mLayoutFromEnd) {
                a(recycler, state, this.nhO);
                i2 = this.nhO.mOffset;
                a(this.nhP, true, false);
                a(recycler, state, this.nhO);
                i = this.nhO.mOffset;
            } else {
                a(recycler, state, this.nhO);
                i = this.nhO.mOffset;
                b(this.nhP, true, false);
                a(recycler, state, this.nhO);
                i2 = this.nhO.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.nhP.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dKw() && this.mIsRtl) {
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
        if (!dKw() && this.mIsRtl) {
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
        if (dKw()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.nhO.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.nhO.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.nhO.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.nhO.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.nhT != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.nhT != -1 ? Math.min(this.nhT, this.nhP.mPosition) : this.nhP.mPosition;
            this.nhL.reset();
            if (dKw()) {
                if (this.nhu.size() > 0) {
                    this.nhK.u(this.nhu, min);
                    this.nhK.a(this.nhL, makeMeasureSpec, makeMeasureSpec2, i3, min, this.nhP.mPosition, this.nhu);
                } else {
                    this.nhK.Kb(i);
                    this.nhK.a(this.nhL, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.nhu);
                }
            } else if (this.nhu.size() > 0) {
                this.nhK.u(this.nhu, min);
                this.nhK.a(this.nhL, makeMeasureSpec2, makeMeasureSpec, i3, min, this.nhP.mPosition, this.nhu);
            } else {
                this.nhK.Kb(i);
                this.nhK.c(this.nhL, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.nhu);
            }
            this.nhu = this.nhL.nhu;
            this.nhK.af(makeMeasureSpec, makeMeasureSpec2, min);
            this.nhK.JY(min);
        } else if (!this.nhP.mLayoutFromEnd) {
            this.nhu.clear();
            if (!$assertionsDisabled && this.nhK.nhr == null) {
                throw new AssertionError();
            }
            this.nhL.reset();
            if (dKw()) {
                this.nhK.b(this.nhL, makeMeasureSpec, makeMeasureSpec2, i3, this.nhP.mPosition, this.nhu);
            } else {
                this.nhK.d(this.nhL, makeMeasureSpec, makeMeasureSpec2, i3, this.nhP.mPosition, this.nhu);
            }
            this.nhu = this.nhL.nhu;
            this.nhK.dE(makeMeasureSpec, makeMeasureSpec2);
            this.nhK.dKE();
            this.nhP.nhU = this.nhK.nhr[this.nhP.mPosition];
            this.nhO.nhU = this.nhP.nhU;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.nhR = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.nhT = -1;
        this.nhP.reset();
        this.nhS.clear();
    }

    private void dKG() {
        int layoutDirection = getLayoutDirection();
        switch (this.nhw) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.nhN = this.nhx == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.nhN = this.nhx == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.nhx == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.nhN = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.nhx == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.nhN = true;
                return;
            default:
                this.mIsRtl = false;
                this.nhN = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.nhR) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.nhU = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.nhK.nhr != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.nhU = this.nhK.nhr[aVar.mPosition];
            if (this.nhR == null || !this.nhR.Kn(state.getItemCount())) {
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
                } else if (dKw() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.nhW = true;
            aVar.nhU = -1;
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
        if ($assertionsDisabled || this.nhK.nhr != null) {
            View ah = ah(0, getChildCount(), i);
            if (ah == null) {
                return null;
            }
            int i2 = this.nhK.nhr[getPosition(ah)];
            if (i2 != -1) {
                return a(ah, this.nhu.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View Kk(int i) {
        if ($assertionsDisabled || this.nhK.nhr != null) {
            View ah = ah(getChildCount() - 1, -1, i);
            if (ah == null) {
                return null;
            }
            return b(ah, this.nhu.get(this.nhK.nhr[getPosition(ah)]));
        }
        throw new AssertionError();
    }

    private View ah(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dKI();
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
        boolean dKw = dKw();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.nhO.mInfinite) && bVar.a(state, this.nhu)) {
                com.google.android.flexbox.b bVar2 = this.nhu.get(bVar.nhU);
                bVar.mPosition = bVar2.nhn;
                i4 += a(bVar2, bVar);
                if (dKw || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dKC() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dKC() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dKC();
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
        if (!bVar.nhY) {
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
            if (!$assertionsDisabled && this.nhK.nhr == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.nhK.nhr[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.nhu.get(i);
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
                        if (bVar2.nho == getPosition(childAt)) {
                            if (i >= this.nhu.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.nhu.get(i4);
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
        return (dKw() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.nhK.nhr == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.nhK.nhr[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.nhu.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!B(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.nhn == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.nhu.get(i4);
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
        return (dKw() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dKw() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.nhK.nhs != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.nhg : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.nhy) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.nhe) + paddingRight;
                    f2 = bVar.nhe - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.nhe) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.nhe) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.nhe) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.nhe) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.nhe) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.nhy);
            }
            float f4 = f - this.nhP.nhV;
            float f5 = f2 - this.nhP.nhV;
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
                        calculateItemDecorationsForChild(JU, nhM);
                        addView(JU);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(JU, nhM);
                        addView(JU, i5);
                        i = i5 + 1;
                    }
                    long j = this.nhK.nhs[i6];
                    int gk = this.nhK.gk(j);
                    int gl = this.nhK.gl(j);
                    if (shouldMeasureChild(JU, gk, gl, (LayoutParams) JU.getLayoutParams())) {
                        JU.measure(gk, gl);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(JU);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(JU));
                    int topDecorationHeight = i3 + getTopDecorationHeight(JU);
                    if (this.mIsRtl) {
                        this.nhK.a(JU, bVar, Math.round(rightDecorationWidth) - JU.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + JU.getMeasuredHeight());
                    } else {
                        this.nhK.a(JU, bVar, Math.round(leftDecorationWidth), topDecorationHeight, JU.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + JU.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + JU.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(JU) + max;
                    measuredWidth2 = rightDecorationWidth - (((JU.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(JU)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.nhU += this.nhO.mLayoutDirection;
            return bVar.dKC();
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
        if ($assertionsDisabled || this.nhK.nhs != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.nhg;
                i = i5 + bVar.nhg;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.nhy) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.nhe) + paddingBottom;
                    f2 = bVar.nhe - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.nhe) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.nhe) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.nhe) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.nhe) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.nhe) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.nhy);
            }
            float f4 = f - this.nhP.nhV;
            float f5 = f2 - this.nhP.nhV;
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
                    long j = this.nhK.nhs[i9];
                    int gk = this.nhK.gk(j);
                    int gl = this.nhK.gl(j);
                    if (shouldMeasureChild(JU, gk, gl, (LayoutParams) JU.getLayoutParams())) {
                        JU.measure(gk, gl);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(JU);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(JU));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(JU, nhM);
                        addView(JU);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(JU, nhM);
                        addView(JU, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(JU);
                    int rightDecorationWidth = i - getRightDecorationWidth(JU);
                    if (this.mIsRtl) {
                        if (this.nhN) {
                            this.nhK.a(JU, bVar, this.mIsRtl, rightDecorationWidth - JU.getMeasuredWidth(), Math.round(bottomDecorationHeight) - JU.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.nhK.a(JU, bVar, this.mIsRtl, rightDecorationWidth - JU.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, JU.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.nhN) {
                        this.nhK.a(JU, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - JU.getMeasuredHeight(), leftDecorationWidth + JU.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.nhK.a(JU, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + JU.getMeasuredWidth(), JU.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((JU.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(JU)) + max);
                    measuredHeight2 = topDecorationHeight + JU.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(JU) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.nhU += this.nhO.mLayoutDirection;
            return bVar.dKC();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dKw() {
        return this.nhw == 0 || this.nhw == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dKH();
        } else {
            this.nhO.mInfinite = false;
        }
        if (!dKw() && this.mIsRtl) {
            this.nhO.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.nhO.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.nhO.mPosition = aVar.mPosition;
        this.nhO.mItemDirection = 1;
        this.nhO.mLayoutDirection = 1;
        this.nhO.mOffset = aVar.mCoordinate;
        this.nhO.mScrollingOffset = Integer.MIN_VALUE;
        this.nhO.nhU = aVar.nhU;
        if (z && this.nhu.size() > 1 && aVar.nhU >= 0 && aVar.nhU < this.nhu.size() - 1) {
            b.i(this.nhO);
            b bVar = this.nhO;
            bVar.mPosition = this.nhu.get(aVar.nhU).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dKH();
        } else {
            this.nhO.mInfinite = false;
        }
        if (!dKw() && this.mIsRtl) {
            this.nhO.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.nhO.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.nhO.mPosition = aVar.mPosition;
        this.nhO.mItemDirection = 1;
        this.nhO.mLayoutDirection = -1;
        this.nhO.mOffset = aVar.mCoordinate;
        this.nhO.mScrollingOffset = Integer.MIN_VALUE;
        this.nhO.nhU = aVar.nhU;
        if (z && aVar.nhU > 0 && this.nhu.size() > aVar.nhU) {
            b.j(this.nhO);
            this.nhO.mPosition -= this.nhu.get(aVar.nhU).getItemCount();
        }
    }

    private void dKH() {
        int widthMode;
        if (dKw()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.nhO.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dKI() {
        if (this.mOrientationHelper == null) {
            if (dKw()) {
                if (this.nhx == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.nhQ = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.nhQ = OrientationHelper.createHorizontalHelper(this);
            } else if (this.nhx == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.nhQ = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.nhQ = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.nhO == null) {
            this.nhO = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.nhR != null) {
            this.nhR.invalidateAnchor();
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
        return !dKw() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dKw() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dKw()) {
            int a2 = a(i, recycler, state);
            this.nhS.clear();
            return a2;
        }
        int Kl = Kl(i);
        this.nhP.nhV += Kl;
        this.nhQ.offsetChildren(-Kl);
        return Kl;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dKw()) {
            int a2 = a(i, recycler, state);
            this.nhS.clear();
            return a2;
        }
        int Kl = Kl(i);
        this.nhP.nhV += Kl;
        this.nhQ.offsetChildren(-Kl);
        return Kl;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dKI();
        this.nhO.nhY = true;
        boolean z = !dKw() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        dI(i2, abs);
        int a2 = this.nhO.mScrollingOffset + a(recycler, state, this.nhO);
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
        this.nhO.mLastScrollDelta = i;
        return i;
    }

    private int Kl(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dKI();
        boolean dKw = dKw();
        int width = dKw ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dKw ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.nhP.nhV) - width, abs);
            }
            if (this.nhP.nhV + i <= 0) {
                return i;
            }
            return -this.nhP.nhV;
        } else if (i > 0) {
            return Math.min((width2 - this.nhP.nhV) - width, i);
        } else {
            if (this.nhP.nhV + i >= 0) {
                return i;
            }
            return -this.nhP.nhV;
        }
    }

    private void dI(int i, int i2) {
        if (!$assertionsDisabled && this.nhK.nhr == null) {
            throw new AssertionError();
        }
        this.nhO.mLayoutDirection = i;
        boolean dKw = dKw();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dKw && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.nhO.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.nhu.get(this.nhK.nhr[position]));
            this.nhO.mItemDirection = 1;
            this.nhO.mPosition = this.nhO.mItemDirection + position;
            if (this.nhK.nhr.length <= this.nhO.mPosition) {
                this.nhO.nhU = -1;
            } else {
                this.nhO.nhU = this.nhK.nhr[this.nhO.mPosition];
            }
            if (z) {
                this.nhO.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.nhO.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.nhO.mScrollingOffset = this.nhO.mScrollingOffset >= 0 ? this.nhO.mScrollingOffset : 0;
            } else {
                this.nhO.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.nhO.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.nhO.nhU == -1 || this.nhO.nhU > this.nhu.size() - 1) && this.nhO.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.nhO.mScrollingOffset;
                this.nhL.reset();
                if (i3 > 0) {
                    if (dKw) {
                        this.nhK.a(this.nhL, makeMeasureSpec, makeMeasureSpec2, i3, this.nhO.mPosition, this.nhu);
                    } else {
                        this.nhK.c(this.nhL, makeMeasureSpec, makeMeasureSpec2, i3, this.nhO.mPosition, this.nhu);
                    }
                    this.nhK.af(makeMeasureSpec, makeMeasureSpec2, this.nhO.mPosition);
                    this.nhK.JY(this.nhO.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.nhO.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.nhu.get(this.nhK.nhr[position2]));
            this.nhO.mItemDirection = 1;
            int i4 = this.nhK.nhr[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.nhO.mPosition = position2 - this.nhu.get(i5 - 1).getItemCount();
            } else {
                this.nhO.mPosition = -1;
            }
            this.nhO.nhU = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.nhO.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.nhO.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.nhO.mScrollingOffset = this.nhO.mScrollingOffset >= 0 ? this.nhO.mScrollingOffset : 0;
            } else {
                this.nhO.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.nhO.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.nhO.mAvailable = i2 - this.nhO.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dKw = dKw();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dKw) {
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
        boolean dKw = dKw();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dKw) {
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
        dKI();
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
        if ($assertionsDisabled || this.nhK.nhr != null) {
            int position = getPosition(Kj);
            int position2 = getPosition(Kk);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(Kk) - this.mOrientationHelper.getDecoratedStart(Kj));
            int i = this.nhK.nhr[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.nhK.nhr[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(Kj)));
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
        if ($assertionsDisabled || this.nhK.nhr != null) {
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
        public int dKx() {
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
        public boolean dKy() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dKz() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dKA() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dKB() {
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
        private int nhU;
        private int nhV;
        private boolean nhW;
        final /* synthetic */ FlexboxLayoutManager nhX;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.nhU = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.nhW = false;
            if (this.nhX.dKw()) {
                if (this.nhX.nhx == 0) {
                    this.mLayoutFromEnd = this.nhX.nhw == 1;
                } else {
                    this.mLayoutFromEnd = this.nhX.nhx == 2;
                }
            } else if (this.nhX.nhx == 0) {
                this.mLayoutFromEnd = this.nhX.nhw == 3;
            } else {
                this.mLayoutFromEnd = this.nhX.nhx == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.nhX.dKw() && this.nhX.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.nhX.mOrientationHelper.getEndAfterPadding() : this.nhX.getWidth() - this.nhX.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.nhX.mOrientationHelper.getEndAfterPadding() : this.nhX.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dw(View view) {
            if (!this.nhX.dKw() && this.nhX.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.nhX.mOrientationHelper.getDecoratedStart(view) + this.nhX.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.nhX.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.nhX.mOrientationHelper.getDecoratedEnd(view) + this.nhX.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.nhX.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.nhX.getPosition(view);
            this.nhW = false;
            if (!$assertionsDisabled && this.nhX.nhK.nhr == null) {
                throw new AssertionError();
            }
            int i = this.nhX.nhK.nhr[this.mPosition != -1 ? this.mPosition : 0];
            this.nhU = i != -1 ? i : 0;
            if (this.nhX.nhu.size() > this.nhU) {
                this.mPosition = ((com.google.android.flexbox.b) this.nhX.nhu.get(this.nhU)).nhn;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.nhU + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.nhV + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.nhW + '}';
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
        private int nhU;
        private boolean nhY;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.nhU;
            bVar.nhU = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.nhU;
            bVar.nhU = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.nhU >= 0 && this.nhU < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.nhU + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
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
