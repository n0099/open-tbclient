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
    private static final Rect mDE;
    private final Context mContext;
    private final c mDC;
    private c.a mDD;
    private boolean mDF;
    private b mDG;
    private a mDH;
    private OrientationHelper mDI;
    private SavedState mDJ;
    private SparseArray<View> mDK;
    private int mDL;
    private List<com.google.android.flexbox.b> mDk;
    private int mDm;
    private int mDn;
    private int mDo;
    private int mDp;
    private int mDr;
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
        mDE = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mDm;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mDn;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mDp;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mDr;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        return dCE() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dk(View view) {
        return dCE() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, mDE);
        if (dCE()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.mCT += leftDecorationWidth;
            bVar.mCU = leftDecorationWidth + bVar.mCU;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.mCT += topDecorationHeight;
        bVar.mCU = topDecorationHeight + bVar.mCU;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View Is(int i) {
        View view = this.mDK.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View It(int i) {
        return Is(i);
    }

    @Override // com.google.android.flexbox.a
    public void a(com.google.android.flexbox.b bVar) {
    }

    @Override // com.google.android.flexbox.a
    public int ag(int i, int i2, int i3) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int ah(int i, int i2, int i3) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.mDk.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.mDk.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mDk.get(i2).mCT);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mDk.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mDk.get(i2).mCV;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.mDk = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.mDk;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
        this.mDK.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dCE()) {
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
        if (this.mDJ != null) {
            return new SavedState(this.mDJ);
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
            this.mDJ = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        IF(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        IF(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        IF(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        IF(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        IF(Math.min(i, i2));
    }

    private void IF(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.mDC.Iy(childCount);
            this.mDC.Ix(childCount);
            this.mDC.Iz(childCount);
            if (!$assertionsDisabled && this.mDC.mDh == null) {
                throw new AssertionError();
            }
            if (i < this.mDC.mDh.length) {
                this.mDL = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dCE() && this.mIsRtl) {
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
            dCO();
            dCQ();
            ensureLayoutState();
            this.mDC.Iy(itemCount);
            this.mDC.Ix(itemCount);
            this.mDC.Iz(itemCount);
            this.mDG.mDQ = false;
            if (this.mDJ != null && this.mDJ.IL(itemCount)) {
                this.mPendingScrollPosition = this.mDJ.mAnchorPosition;
            }
            if (!this.mDH.mValid || this.mPendingScrollPosition != -1 || this.mDJ != null) {
                this.mDH.reset();
                a(state, this.mDH);
                this.mDH.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.mDH.mLayoutFromEnd) {
                b(this.mDH, false, true);
            } else {
                a(this.mDH, false, true);
            }
            IG(itemCount);
            if (this.mDH.mLayoutFromEnd) {
                a(recycler, state, this.mDG);
                i2 = this.mDG.mOffset;
                a(this.mDH, true, false);
                a(recycler, state, this.mDG);
                i = this.mDG.mOffset;
            } else {
                a(recycler, state, this.mDG);
                i = this.mDG.mOffset;
                b(this.mDH, true, false);
                a(recycler, state, this.mDG);
                i2 = this.mDG.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.mDH.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dCE() && this.mIsRtl) {
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
        if (!dCE() && this.mIsRtl) {
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

    private void IG(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (dCE()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.mDG.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.mDG.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.mDG.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.mDG.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.mDL != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.mDL != -1 ? Math.min(this.mDL, this.mDH.mPosition) : this.mDH.mPosition;
            this.mDD.reset();
            if (dCE()) {
                if (this.mDk.size() > 0) {
                    this.mDC.u(this.mDk, min);
                    this.mDC.a(this.mDD, makeMeasureSpec, makeMeasureSpec2, i3, min, this.mDH.mPosition, this.mDk);
                } else {
                    this.mDC.Iz(i);
                    this.mDC.a(this.mDD, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mDk);
                }
            } else if (this.mDk.size() > 0) {
                this.mDC.u(this.mDk, min);
                this.mDC.a(this.mDD, makeMeasureSpec2, makeMeasureSpec, i3, min, this.mDH.mPosition, this.mDk);
            } else {
                this.mDC.Iz(i);
                this.mDC.c(this.mDD, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mDk);
            }
            this.mDk = this.mDD.mDk;
            this.mDC.ai(makeMeasureSpec, makeMeasureSpec2, min);
            this.mDC.Iw(min);
        } else if (!this.mDH.mLayoutFromEnd) {
            this.mDk.clear();
            if (!$assertionsDisabled && this.mDC.mDh == null) {
                throw new AssertionError();
            }
            this.mDD.reset();
            if (dCE()) {
                this.mDC.b(this.mDD, makeMeasureSpec, makeMeasureSpec2, i3, this.mDH.mPosition, this.mDk);
            } else {
                this.mDC.d(this.mDD, makeMeasureSpec, makeMeasureSpec2, i3, this.mDH.mPosition, this.mDk);
            }
            this.mDk = this.mDD.mDk;
            this.mDC.dt(makeMeasureSpec, makeMeasureSpec2);
            this.mDC.dCM();
            this.mDH.mDM = this.mDC.mDh[this.mDH.mPosition];
            this.mDG.mDM = this.mDH.mDM;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mDJ = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mDL = -1;
        this.mDH.reset();
        this.mDK.clear();
    }

    private void dCO() {
        int layoutDirection = getLayoutDirection();
        switch (this.mDm) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.mDF = this.mDn == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.mDF = this.mDn == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.mDn == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mDF = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.mDn == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mDF = true;
                return;
            default:
                this.mIsRtl = false;
                this.mDF = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.mDJ) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.mDM = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.mDC.mDh != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.mDM = this.mDC.mDh[aVar.mPosition];
            if (this.mDJ == null || !this.mDJ.IL(state.getItemCount())) {
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
                } else if (dCE() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.mDO = true;
            aVar.mDM = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View IH;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            IH = II(state.getItemCount());
        } else {
            IH = IH(state.getItemCount());
        }
        if (IH != null) {
            aVar.dp(IH);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(IH) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(IH) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View IH(int i) {
        if ($assertionsDisabled || this.mDC.mDh != null) {
            View ak = ak(0, getChildCount(), i);
            if (ak == null) {
                return null;
            }
            int i2 = this.mDC.mDh[getPosition(ak)];
            if (i2 != -1) {
                return a(ak, this.mDk.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View II(int i) {
        if ($assertionsDisabled || this.mDC.mDh != null) {
            View ak = ak(getChildCount() - 1, -1, i);
            if (ak == null) {
                return null;
            }
            return b(ak, this.mDk.get(this.mDC.mDh[getPosition(ak)]));
        }
        throw new AssertionError();
    }

    private View ak(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dCQ();
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
        boolean dCE = dCE();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.mDG.mInfinite) && bVar.a(state, this.mDk)) {
                com.google.android.flexbox.b bVar2 = this.mDk.get(bVar.mDM);
                bVar.mPosition = bVar2.mDd;
                i4 += a(bVar2, bVar);
                if (dCE || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dCK() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dCK() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dCK();
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
        if (!bVar.mDQ) {
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
            if (!$assertionsDisabled && this.mDC.mDh == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mDC.mDh[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.mDk.get(i);
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
                        if (bVar2.mDe == getPosition(childAt)) {
                            if (i >= this.mDk.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.mDk.get(i4);
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
        return (dCE() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.mDC.mDh == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mDC.mDh[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.mDk.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mDd == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.mDk.get(i4);
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
        return (dCE() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dCE() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.mDC.mDi != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.mCV : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mDo) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.mCT) + paddingRight;
                    f2 = bVar.mCT - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.mCT) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.mCT) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.mCT) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mCT) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mCT) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mDo);
            }
            float f4 = f - this.mDH.mDN;
            float f5 = f2 - this.mDH.mDN;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View Is = Is(i6);
                if (Is == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Is, mDE);
                        addView(Is);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(Is, mDE);
                        addView(Is, i5);
                        i = i5 + 1;
                    }
                    long j = this.mDC.mDi[i6];
                    int fS = this.mDC.fS(j);
                    int fT = this.mDC.fT(j);
                    if (shouldMeasureChild(Is, fS, fT, (LayoutParams) Is.getLayoutParams())) {
                        Is.measure(fS, fT);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(Is);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(Is));
                    int topDecorationHeight = i3 + getTopDecorationHeight(Is);
                    if (this.mIsRtl) {
                        this.mDC.a(Is, bVar, Math.round(rightDecorationWidth) - Is.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + Is.getMeasuredHeight());
                    } else {
                        this.mDC.a(Is, bVar, Math.round(leftDecorationWidth), topDecorationHeight, Is.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + Is.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + Is.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(Is) + max;
                    measuredWidth2 = rightDecorationWidth - (((Is.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(Is)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.mDM += this.mDG.mLayoutDirection;
            return bVar.dCK();
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
        if ($assertionsDisabled || this.mDC.mDi != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.mCV;
                i = i5 + bVar.mCV;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mDo) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.mCT) + paddingBottom;
                    f2 = bVar.mCT - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.mCT) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.mCT) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.mCT) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mCT) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mCT) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mDo);
            }
            float f4 = f - this.mDH.mDN;
            float f5 = f2 - this.mDH.mDN;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View Is = Is(i9);
                if (Is == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.mDC.mDi[i9];
                    int fS = this.mDC.fS(j);
                    int fT = this.mDC.fT(j);
                    if (shouldMeasureChild(Is, fS, fT, (LayoutParams) Is.getLayoutParams())) {
                        Is.measure(fS, fT);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(Is);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(Is));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Is, mDE);
                        addView(Is);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(Is, mDE);
                        addView(Is, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(Is);
                    int rightDecorationWidth = i - getRightDecorationWidth(Is);
                    if (this.mIsRtl) {
                        if (this.mDF) {
                            this.mDC.a(Is, bVar, this.mIsRtl, rightDecorationWidth - Is.getMeasuredWidth(), Math.round(bottomDecorationHeight) - Is.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.mDC.a(Is, bVar, this.mIsRtl, rightDecorationWidth - Is.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Is.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.mDF) {
                        this.mDC.a(Is, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - Is.getMeasuredHeight(), leftDecorationWidth + Is.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.mDC.a(Is, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + Is.getMeasuredWidth(), Is.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((Is.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(Is)) + max);
                    measuredHeight2 = topDecorationHeight + Is.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(Is) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.mDM += this.mDG.mLayoutDirection;
            return bVar.dCK();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dCE() {
        return this.mDm == 0 || this.mDm == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dCP();
        } else {
            this.mDG.mInfinite = false;
        }
        if (!dCE() && this.mIsRtl) {
            this.mDG.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.mDG.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.mDG.mPosition = aVar.mPosition;
        this.mDG.mItemDirection = 1;
        this.mDG.mLayoutDirection = 1;
        this.mDG.mOffset = aVar.mCoordinate;
        this.mDG.mScrollingOffset = Integer.MIN_VALUE;
        this.mDG.mDM = aVar.mDM;
        if (z && this.mDk.size() > 1 && aVar.mDM >= 0 && aVar.mDM < this.mDk.size() - 1) {
            b.i(this.mDG);
            b bVar = this.mDG;
            bVar.mPosition = this.mDk.get(aVar.mDM).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dCP();
        } else {
            this.mDG.mInfinite = false;
        }
        if (!dCE() && this.mIsRtl) {
            this.mDG.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.mDG.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mDG.mPosition = aVar.mPosition;
        this.mDG.mItemDirection = 1;
        this.mDG.mLayoutDirection = -1;
        this.mDG.mOffset = aVar.mCoordinate;
        this.mDG.mScrollingOffset = Integer.MIN_VALUE;
        this.mDG.mDM = aVar.mDM;
        if (z && aVar.mDM > 0 && this.mDk.size() > aVar.mDM) {
            b.j(this.mDG);
            this.mDG.mPosition -= this.mDk.get(aVar.mDM).getItemCount();
        }
    }

    private void dCP() {
        int widthMode;
        if (dCE()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.mDG.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dCQ() {
        if (this.mOrientationHelper == null) {
            if (dCE()) {
                if (this.mDn == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.mDI = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mDI = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mDn == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mDI = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mDI = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.mDG == null) {
            this.mDG = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mDJ != null) {
            this.mDJ.invalidateAnchor();
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
        return !dCE() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dCE() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dCE()) {
            int a2 = a(i, recycler, state);
            this.mDK.clear();
            return a2;
        }
        int IJ = IJ(i);
        this.mDH.mDN += IJ;
        this.mDI.offsetChildren(-IJ);
        return IJ;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dCE()) {
            int a2 = a(i, recycler, state);
            this.mDK.clear();
            return a2;
        }
        int IJ = IJ(i);
        this.mDH.mDN += IJ;
        this.mDI.offsetChildren(-IJ);
        return IJ;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dCQ();
        this.mDG.mDQ = true;
        boolean z = !dCE() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        dx(i2, abs);
        int a2 = this.mDG.mScrollingOffset + a(recycler, state, this.mDG);
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
        this.mDG.mLastScrollDelta = i;
        return i;
    }

    private int IJ(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dCQ();
        boolean dCE = dCE();
        int width = dCE ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dCE ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.mDH.mDN) - width, abs);
            }
            if (this.mDH.mDN + i <= 0) {
                return i;
            }
            return -this.mDH.mDN;
        } else if (i > 0) {
            return Math.min((width2 - this.mDH.mDN) - width, i);
        } else {
            if (this.mDH.mDN + i >= 0) {
                return i;
            }
            return -this.mDH.mDN;
        }
    }

    private void dx(int i, int i2) {
        if (!$assertionsDisabled && this.mDC.mDh == null) {
            throw new AssertionError();
        }
        this.mDG.mLayoutDirection = i;
        boolean dCE = dCE();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dCE && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.mDG.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.mDk.get(this.mDC.mDh[position]));
            this.mDG.mItemDirection = 1;
            this.mDG.mPosition = this.mDG.mItemDirection + position;
            if (this.mDC.mDh.length <= this.mDG.mPosition) {
                this.mDG.mDM = -1;
            } else {
                this.mDG.mDM = this.mDC.mDh[this.mDG.mPosition];
            }
            if (z) {
                this.mDG.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.mDG.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.mDG.mScrollingOffset = this.mDG.mScrollingOffset >= 0 ? this.mDG.mScrollingOffset : 0;
            } else {
                this.mDG.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.mDG.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mDG.mDM == -1 || this.mDG.mDM > this.mDk.size() - 1) && this.mDG.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.mDG.mScrollingOffset;
                this.mDD.reset();
                if (i3 > 0) {
                    if (dCE) {
                        this.mDC.a(this.mDD, makeMeasureSpec, makeMeasureSpec2, i3, this.mDG.mPosition, this.mDk);
                    } else {
                        this.mDC.c(this.mDD, makeMeasureSpec, makeMeasureSpec2, i3, this.mDG.mPosition, this.mDk);
                    }
                    this.mDC.ai(makeMeasureSpec, makeMeasureSpec2, this.mDG.mPosition);
                    this.mDC.Iw(this.mDG.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.mDG.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.mDk.get(this.mDC.mDh[position2]));
            this.mDG.mItemDirection = 1;
            int i4 = this.mDC.mDh[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.mDG.mPosition = position2 - this.mDk.get(i5 - 1).getItemCount();
            } else {
                this.mDG.mPosition = -1;
            }
            this.mDG.mDM = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.mDG.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.mDG.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.mDG.mScrollingOffset = this.mDG.mScrollingOffset >= 0 ? this.mDG.mScrollingOffset : 0;
            } else {
                this.mDG.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.mDG.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.mDG.mAvailable = i2 - this.mDG.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dCE = dCE();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dCE) {
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
        boolean dCE = dCE();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dCE) {
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
        dCQ();
        View IH = IH(itemCount);
        View II = II(itemCount);
        if (state.getItemCount() == 0 || IH == null || II == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(II) - this.mOrientationHelper.getDecoratedStart(IH));
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
        View IH = IH(itemCount);
        View II = II(itemCount);
        if (state.getItemCount() == 0 || IH == null || II == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mDC.mDh != null) {
            int position = getPosition(IH);
            int position2 = getPosition(II);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(II) - this.mOrientationHelper.getDecoratedStart(IH));
            int i = this.mDC.mDh[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.mDC.mDh[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(IH)));
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
        View IH = IH(itemCount);
        View II = II(itemCount);
        if (state.getItemCount() == 0 || IH == null || II == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mDC.mDh != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(II) - this.mOrientationHelper.getDecoratedStart(IH)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int dl(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int dm(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int dn(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    /* renamed from: do  reason: not valid java name */
    private int m40do(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean p(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int dl = dl(view);
        int dn = dn(view);
        int dm = dm(view);
        int m40do = m40do(view);
        return z ? (paddingLeft <= dl && width >= dm) && (paddingTop <= dn && height >= m40do) : (dl >= width || dm >= paddingLeft) && (dn >= height || m40do >= paddingTop);
    }

    public int findFirstVisibleItemPosition() {
        View p = p(0, getChildCount(), false);
        if (p == null) {
            return -1;
        }
        return getPosition(p);
    }

    public int findLastVisibleItemPosition() {
        View p = p(getChildCount() - 1, -1, false);
        if (p == null) {
            return -1;
        }
        return getPosition(p);
    }

    private View p(int i, int i2, boolean z) {
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

    /* loaded from: classes5.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.LayoutParams.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ag */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: IK */
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
        public int dCF() {
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
        public boolean dCG() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dCH() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dCI() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dCJ() {
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
        private int mDM;
        private int mDN;
        private boolean mDO;
        final /* synthetic */ FlexboxLayoutManager mDP;
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mDM = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mDO = false;
            if (this.mDP.dCE()) {
                if (this.mDP.mDn == 0) {
                    this.mLayoutFromEnd = this.mDP.mDm == 1;
                } else {
                    this.mLayoutFromEnd = this.mDP.mDn == 2;
                }
            } else if (this.mDP.mDn == 0) {
                this.mLayoutFromEnd = this.mDP.mDm == 3;
            } else {
                this.mLayoutFromEnd = this.mDP.mDn == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.mDP.dCE() && this.mDP.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.mDP.mOrientationHelper.getEndAfterPadding() : this.mDP.getWidth() - this.mDP.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.mDP.mOrientationHelper.getEndAfterPadding() : this.mDP.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dp(View view) {
            if (!this.mDP.dCE() && this.mDP.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.mDP.mOrientationHelper.getDecoratedStart(view) + this.mDP.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.mDP.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mDP.mOrientationHelper.getDecoratedEnd(view) + this.mDP.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mDP.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.mDP.getPosition(view);
            this.mDO = false;
            if (!$assertionsDisabled && this.mDP.mDC.mDh == null) {
                throw new AssertionError();
            }
            int i = this.mDP.mDC.mDh[this.mPosition != -1 ? this.mPosition : 0];
            this.mDM = i != -1 ? i : 0;
            if (this.mDP.mDk.size() > this.mDM) {
                this.mPosition = ((com.google.android.flexbox.b) this.mDP.mDk.get(this.mDM)).mDd;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mDM + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mDN + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mDO + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {
        private int mAvailable;
        private int mDM;
        private boolean mDQ;
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
            int i = bVar.mDM;
            bVar.mDM = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.mDM;
            bVar.mDM = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.mDM >= 0 && this.mDM < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mDM + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ah */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: IM */
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
        public boolean IL(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
