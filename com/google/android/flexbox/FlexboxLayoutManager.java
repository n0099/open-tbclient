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
    private static final Rect nBG;
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
    private final c nBE;
    private c.a nBF;
    private boolean nBH;
    private b nBI;
    private a nBJ;
    private OrientationHelper nBK;
    private SavedState nBL;
    private SparseArray<View> nBM;
    private int nBN;
    private List<com.google.android.flexbox.b> nBo;
    private int nBq;
    private int nBr;
    private int nBs;
    private int nBt;
    private int nBv;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        nBG = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.nBq;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.nBr;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.nBt;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.nBv;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        return dWy() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dv(View view) {
        return dWy() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, nBG);
        if (dWy()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.nAY += leftDecorationWidth;
            bVar.nAZ = leftDecorationWidth + bVar.nAZ;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.nAY += topDecorationHeight;
        bVar.nAZ = topDecorationHeight + bVar.nAZ;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View My(int i) {
        View view = this.nBM.get(i);
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
        if (this.nBo.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.nBo.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.nBo.get(i2).nAY);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.nBo.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.nBo.get(i2).nBa;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.nBo = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.nBo;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
        this.nBM.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dWy()) {
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
        if (this.nBL != null) {
            return new SavedState(this.nBL);
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
            this.nBL = (SavedState) parcelable;
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
            this.nBE.ME(childCount);
            this.nBE.MD(childCount);
            this.nBE.MF(childCount);
            if (!$assertionsDisabled && this.nBE.nBl == null) {
                throw new AssertionError();
            }
            if (i < this.nBE.nBl.length) {
                this.nBN = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dWy() && this.mIsRtl) {
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
            dWI();
            dWK();
            ensureLayoutState();
            this.nBE.ME(itemCount);
            this.nBE.MD(itemCount);
            this.nBE.MF(itemCount);
            this.nBI.nBS = false;
            if (this.nBL != null && this.nBL.MR(itemCount)) {
                this.mPendingScrollPosition = this.nBL.mAnchorPosition;
            }
            if (!this.nBJ.mValid || this.mPendingScrollPosition != -1 || this.nBL != null) {
                this.nBJ.reset();
                a(state, this.nBJ);
                this.nBJ.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.nBJ.mLayoutFromEnd) {
                b(this.nBJ, false, true);
            } else {
                a(this.nBJ, false, true);
            }
            MM(itemCount);
            if (this.nBJ.mLayoutFromEnd) {
                a(recycler, state, this.nBI);
                i2 = this.nBI.mOffset;
                a(this.nBJ, true, false);
                a(recycler, state, this.nBI);
                i = this.nBI.mOffset;
            } else {
                a(recycler, state, this.nBI);
                i = this.nBI.mOffset;
                b(this.nBJ, true, false);
                a(recycler, state, this.nBI);
                i2 = this.nBI.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.nBJ.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dWy() && this.mIsRtl) {
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
        if (!dWy() && this.mIsRtl) {
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
        if (dWy()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.nBI.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.nBI.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.nBI.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.nBI.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.nBN != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.nBN != -1 ? Math.min(this.nBN, this.nBJ.mPosition) : this.nBJ.mPosition;
            this.nBF.reset();
            if (dWy()) {
                if (this.nBo.size() > 0) {
                    this.nBE.y(this.nBo, min);
                    this.nBE.a(this.nBF, makeMeasureSpec, makeMeasureSpec2, i3, min, this.nBJ.mPosition, this.nBo);
                } else {
                    this.nBE.MF(i);
                    this.nBE.a(this.nBF, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.nBo);
                }
            } else if (this.nBo.size() > 0) {
                this.nBE.y(this.nBo, min);
                this.nBE.a(this.nBF, makeMeasureSpec2, makeMeasureSpec, i3, min, this.nBJ.mPosition, this.nBo);
            } else {
                this.nBE.MF(i);
                this.nBE.c(this.nBF, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.nBo);
            }
            this.nBo = this.nBF.nBo;
            this.nBE.af(makeMeasureSpec, makeMeasureSpec2, min);
            this.nBE.MC(min);
        } else if (!this.nBJ.mLayoutFromEnd) {
            this.nBo.clear();
            if (!$assertionsDisabled && this.nBE.nBl == null) {
                throw new AssertionError();
            }
            this.nBF.reset();
            if (dWy()) {
                this.nBE.b(this.nBF, makeMeasureSpec, makeMeasureSpec2, i3, this.nBJ.mPosition, this.nBo);
            } else {
                this.nBE.d(this.nBF, makeMeasureSpec, makeMeasureSpec2, i3, this.nBJ.mPosition, this.nBo);
            }
            this.nBo = this.nBF.nBo;
            this.nBE.dM(makeMeasureSpec, makeMeasureSpec2);
            this.nBE.dWG();
            this.nBJ.nBO = this.nBE.nBl[this.nBJ.mPosition];
            this.nBI.nBO = this.nBJ.nBO;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.nBL = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.nBN = -1;
        this.nBJ.reset();
        this.nBM.clear();
    }

    private void dWI() {
        int layoutDirection = getLayoutDirection();
        switch (this.nBq) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.nBH = this.nBr == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.nBH = this.nBr == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.nBr == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.nBH = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.nBr == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.nBH = true;
                return;
            default:
                this.mIsRtl = false;
                this.nBH = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.nBL) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.nBO = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.nBE.nBl != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.nBO = this.nBE.nBl[aVar.mPosition];
            if (this.nBL == null || !this.nBL.MR(state.getItemCount())) {
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
                } else if (dWy() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.nBQ = true;
            aVar.nBO = -1;
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
        if ($assertionsDisabled || this.nBE.nBl != null) {
            View ah = ah(0, getChildCount(), i);
            if (ah == null) {
                return null;
            }
            int i2 = this.nBE.nBl[getPosition(ah)];
            if (i2 != -1) {
                return a(ah, this.nBo.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View MO(int i) {
        if ($assertionsDisabled || this.nBE.nBl != null) {
            View ah = ah(getChildCount() - 1, -1, i);
            if (ah == null) {
                return null;
            }
            return b(ah, this.nBo.get(this.nBE.nBl[getPosition(ah)]));
        }
        throw new AssertionError();
    }

    private View ah(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dWK();
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
        boolean dWy = dWy();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.nBI.mInfinite) && bVar.a(state, this.nBo)) {
                com.google.android.flexbox.b bVar2 = this.nBo.get(bVar.nBO);
                bVar.mPosition = bVar2.nBh;
                i4 += a(bVar2, bVar);
                if (dWy || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dWE() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dWE() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dWE();
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
        if (!bVar.nBS) {
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
            if (!$assertionsDisabled && this.nBE.nBl == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.nBE.nBl[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.nBo.get(i);
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
                        if (bVar2.nBi == getPosition(childAt)) {
                            if (i >= this.nBo.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.nBo.get(i4);
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
        return (dWy() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.nBE.nBl == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.nBE.nBl[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.nBo.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!B(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.nBh == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.nBo.get(i4);
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
        return (dWy() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dWy() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.nBE.nBm != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.nBa : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.nBs) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.nAY) + paddingRight;
                    f2 = bVar.nAY - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.nAY) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.nAY) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.nAY) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.nAY) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.nAY) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.nBs);
            }
            float f4 = f - this.nBJ.nBP;
            float f5 = f2 - this.nBJ.nBP;
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
                        calculateItemDecorationsForChild(My, nBG);
                        addView(My);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(My, nBG);
                        addView(My, i5);
                        i = i5 + 1;
                    }
                    long j = this.nBE.nBm[i6];
                    int gx = this.nBE.gx(j);
                    int gy = this.nBE.gy(j);
                    if (shouldMeasureChild(My, gx, gy, (LayoutParams) My.getLayoutParams())) {
                        My.measure(gx, gy);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(My);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(My));
                    int topDecorationHeight = i3 + getTopDecorationHeight(My);
                    if (this.mIsRtl) {
                        this.nBE.a(My, bVar, Math.round(rightDecorationWidth) - My.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + My.getMeasuredHeight());
                    } else {
                        this.nBE.a(My, bVar, Math.round(leftDecorationWidth), topDecorationHeight, My.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + My.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + My.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(My) + max;
                    measuredWidth2 = rightDecorationWidth - (((My.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(My)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.nBO += this.nBI.mLayoutDirection;
            return bVar.dWE();
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
        if ($assertionsDisabled || this.nBE.nBm != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.nBa;
                i = i5 + bVar.nBa;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.nBs) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.nAY) + paddingBottom;
                    f2 = bVar.nAY - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.nAY) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.nAY) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.nAY) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.nAY) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.nAY) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.nBs);
            }
            float f4 = f - this.nBJ.nBP;
            float f5 = f2 - this.nBJ.nBP;
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
                    long j = this.nBE.nBm[i9];
                    int gx = this.nBE.gx(j);
                    int gy = this.nBE.gy(j);
                    if (shouldMeasureChild(My, gx, gy, (LayoutParams) My.getLayoutParams())) {
                        My.measure(gx, gy);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(My);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(My));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(My, nBG);
                        addView(My);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(My, nBG);
                        addView(My, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(My);
                    int rightDecorationWidth = i - getRightDecorationWidth(My);
                    if (this.mIsRtl) {
                        if (this.nBH) {
                            this.nBE.a(My, bVar, this.mIsRtl, rightDecorationWidth - My.getMeasuredWidth(), Math.round(bottomDecorationHeight) - My.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.nBE.a(My, bVar, this.mIsRtl, rightDecorationWidth - My.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, My.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.nBH) {
                        this.nBE.a(My, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - My.getMeasuredHeight(), leftDecorationWidth + My.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.nBE.a(My, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + My.getMeasuredWidth(), My.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((My.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(My)) + max);
                    measuredHeight2 = topDecorationHeight + My.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(My) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.nBO += this.nBI.mLayoutDirection;
            return bVar.dWE();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dWy() {
        return this.nBq == 0 || this.nBq == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dWJ();
        } else {
            this.nBI.mInfinite = false;
        }
        if (!dWy() && this.mIsRtl) {
            this.nBI.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.nBI.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.nBI.mPosition = aVar.mPosition;
        this.nBI.mItemDirection = 1;
        this.nBI.mLayoutDirection = 1;
        this.nBI.mOffset = aVar.mCoordinate;
        this.nBI.mScrollingOffset = Integer.MIN_VALUE;
        this.nBI.nBO = aVar.nBO;
        if (z && this.nBo.size() > 1 && aVar.nBO >= 0 && aVar.nBO < this.nBo.size() - 1) {
            b.i(this.nBI);
            b bVar = this.nBI;
            bVar.mPosition = this.nBo.get(aVar.nBO).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dWJ();
        } else {
            this.nBI.mInfinite = false;
        }
        if (!dWy() && this.mIsRtl) {
            this.nBI.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.nBI.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.nBI.mPosition = aVar.mPosition;
        this.nBI.mItemDirection = 1;
        this.nBI.mLayoutDirection = -1;
        this.nBI.mOffset = aVar.mCoordinate;
        this.nBI.mScrollingOffset = Integer.MIN_VALUE;
        this.nBI.nBO = aVar.nBO;
        if (z && aVar.nBO > 0 && this.nBo.size() > aVar.nBO) {
            b.j(this.nBI);
            this.nBI.mPosition -= this.nBo.get(aVar.nBO).getItemCount();
        }
    }

    private void dWJ() {
        int widthMode;
        if (dWy()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.nBI.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dWK() {
        if (this.mOrientationHelper == null) {
            if (dWy()) {
                if (this.nBr == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.nBK = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.nBK = OrientationHelper.createHorizontalHelper(this);
            } else if (this.nBr == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.nBK = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.nBK = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.nBI == null) {
            this.nBI = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.nBL != null) {
            this.nBL.invalidateAnchor();
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
        return !dWy() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dWy() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dWy()) {
            int a2 = a(i, recycler, state);
            this.nBM.clear();
            return a2;
        }
        int MP = MP(i);
        this.nBJ.nBP += MP;
        this.nBK.offsetChildren(-MP);
        return MP;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dWy()) {
            int a2 = a(i, recycler, state);
            this.nBM.clear();
            return a2;
        }
        int MP = MP(i);
        this.nBJ.nBP += MP;
        this.nBK.offsetChildren(-MP);
        return MP;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dWK();
        this.nBI.nBS = true;
        boolean z = !dWy() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        dQ(i2, abs);
        int a2 = this.nBI.mScrollingOffset + a(recycler, state, this.nBI);
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
        this.nBI.mLastScrollDelta = i;
        return i;
    }

    private int MP(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dWK();
        boolean dWy = dWy();
        int width = dWy ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dWy ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.nBJ.nBP) - width, abs);
            }
            if (this.nBJ.nBP + i <= 0) {
                return i;
            }
            return -this.nBJ.nBP;
        } else if (i > 0) {
            return Math.min((width2 - this.nBJ.nBP) - width, i);
        } else {
            if (this.nBJ.nBP + i >= 0) {
                return i;
            }
            return -this.nBJ.nBP;
        }
    }

    private void dQ(int i, int i2) {
        if (!$assertionsDisabled && this.nBE.nBl == null) {
            throw new AssertionError();
        }
        this.nBI.mLayoutDirection = i;
        boolean dWy = dWy();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dWy && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.nBI.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.nBo.get(this.nBE.nBl[position]));
            this.nBI.mItemDirection = 1;
            this.nBI.mPosition = this.nBI.mItemDirection + position;
            if (this.nBE.nBl.length <= this.nBI.mPosition) {
                this.nBI.nBO = -1;
            } else {
                this.nBI.nBO = this.nBE.nBl[this.nBI.mPosition];
            }
            if (z) {
                this.nBI.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.nBI.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.nBI.mScrollingOffset = this.nBI.mScrollingOffset >= 0 ? this.nBI.mScrollingOffset : 0;
            } else {
                this.nBI.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.nBI.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.nBI.nBO == -1 || this.nBI.nBO > this.nBo.size() - 1) && this.nBI.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.nBI.mScrollingOffset;
                this.nBF.reset();
                if (i3 > 0) {
                    if (dWy) {
                        this.nBE.a(this.nBF, makeMeasureSpec, makeMeasureSpec2, i3, this.nBI.mPosition, this.nBo);
                    } else {
                        this.nBE.c(this.nBF, makeMeasureSpec, makeMeasureSpec2, i3, this.nBI.mPosition, this.nBo);
                    }
                    this.nBE.af(makeMeasureSpec, makeMeasureSpec2, this.nBI.mPosition);
                    this.nBE.MC(this.nBI.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.nBI.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.nBo.get(this.nBE.nBl[position2]));
            this.nBI.mItemDirection = 1;
            int i4 = this.nBE.nBl[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.nBI.mPosition = position2 - this.nBo.get(i5 - 1).getItemCount();
            } else {
                this.nBI.mPosition = -1;
            }
            this.nBI.nBO = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.nBI.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.nBI.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.nBI.mScrollingOffset = this.nBI.mScrollingOffset >= 0 ? this.nBI.mScrollingOffset : 0;
            } else {
                this.nBI.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.nBI.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.nBI.mAvailable = i2 - this.nBI.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dWy = dWy();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dWy) {
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
        boolean dWy = dWy();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dWy) {
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
        dWK();
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
        if ($assertionsDisabled || this.nBE.nBl != null) {
            int position = getPosition(MN);
            int position2 = getPosition(MO);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(MO) - this.mOrientationHelper.getDecoratedStart(MN));
            int i = this.nBE.nBl[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.nBE.nBl[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(MN)));
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
        if ($assertionsDisabled || this.nBE.nBl != null) {
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
        public int dWz() {
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
        public boolean dWA() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dWB() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dWC() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dWD() {
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
        private int nBO;
        private int nBP;
        private boolean nBQ;
        final /* synthetic */ FlexboxLayoutManager nBR;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.nBO = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.nBQ = false;
            if (this.nBR.dWy()) {
                if (this.nBR.nBr == 0) {
                    this.mLayoutFromEnd = this.nBR.nBq == 1;
                } else {
                    this.mLayoutFromEnd = this.nBR.nBr == 2;
                }
            } else if (this.nBR.nBr == 0) {
                this.mLayoutFromEnd = this.nBR.nBq == 3;
            } else {
                this.mLayoutFromEnd = this.nBR.nBr == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.nBR.dWy() && this.nBR.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.nBR.mOrientationHelper.getEndAfterPadding() : this.nBR.getWidth() - this.nBR.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.nBR.mOrientationHelper.getEndAfterPadding() : this.nBR.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dA(View view) {
            if (!this.nBR.dWy() && this.nBR.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.nBR.mOrientationHelper.getDecoratedStart(view) + this.nBR.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.nBR.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.nBR.mOrientationHelper.getDecoratedEnd(view) + this.nBR.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.nBR.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.nBR.getPosition(view);
            this.nBQ = false;
            if (!$assertionsDisabled && this.nBR.nBE.nBl == null) {
                throw new AssertionError();
            }
            int i = this.nBR.nBE.nBl[this.mPosition != -1 ? this.mPosition : 0];
            this.nBO = i != -1 ? i : 0;
            if (this.nBR.nBo.size() > this.nBO) {
                this.mPosition = ((com.google.android.flexbox.b) this.nBR.nBo.get(this.nBO)).nBh;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.nBO + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.nBP + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.nBQ + '}';
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
        private int nBO;
        private boolean nBS;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.nBO;
            bVar.nBO = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.nBO;
            bVar.nBO = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.nBO >= 0 && this.nBO < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.nBO + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
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
