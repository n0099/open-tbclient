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
    private static final Rect mJi;
    private final Context mContext;
    private List<com.google.android.flexbox.b> mIQ;
    private int mIS;
    private int mIT;
    private int mIU;
    private int mIV;
    private int mIX;
    private boolean mIsRtl;
    private final c mJg;
    private c.a mJh;
    private boolean mJj;
    private b mJk;
    private a mJl;
    private OrientationHelper mJm;
    private SavedState mJn;
    private SparseArray<View> mJo;
    private int mJp;
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
        mJi = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mIS;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mIT;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mIV;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mIX;
    }

    @Override // com.google.android.flexbox.a
    public int g(View view, int i, int i2) {
        return dyX() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dq(View view) {
        return dyX() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, mJi);
        if (dyX()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.mIz += leftDecorationWidth;
            bVar.mIA = leftDecorationWidth + bVar.mIA;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.mIz += topDecorationHeight;
        bVar.mIA = topDecorationHeight + bVar.mIA;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View LZ(int i) {
        View view = this.mJo.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View Ma(int i) {
        return LZ(i);
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
        if (this.mIQ.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.mIQ.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mIQ.get(i2).mIz);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mIQ.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mIQ.get(i2).mIB;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.mIQ = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.mIQ;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i, View view) {
        this.mJo.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dyX()) {
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
        if (this.mJn != null) {
            return new SavedState(this.mJn);
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
            this.mJn = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        Mm(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        Mm(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        Mm(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        Mm(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        Mm(Math.min(i, i2));
    }

    private void Mm(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.mJg.Mf(childCount);
            this.mJg.Me(childCount);
            this.mJg.Mg(childCount);
            if (!$assertionsDisabled && this.mJg.mIN == null) {
                throw new AssertionError();
            }
            if (i < this.mJg.mIN.length) {
                this.mJp = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dyX() && this.mIsRtl) {
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
            dzh();
            dzj();
            ensureLayoutState();
            this.mJg.Mf(itemCount);
            this.mJg.Me(itemCount);
            this.mJg.Mg(itemCount);
            this.mJk.mJu = false;
            if (this.mJn != null && this.mJn.Ms(itemCount)) {
                this.mPendingScrollPosition = this.mJn.mAnchorPosition;
            }
            if (!this.mJl.mValid || this.mPendingScrollPosition != -1 || this.mJn != null) {
                this.mJl.reset();
                a(state, this.mJl);
                this.mJl.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.mJl.mLayoutFromEnd) {
                b(this.mJl, false, true);
            } else {
                a(this.mJl, false, true);
            }
            Mn(itemCount);
            if (this.mJl.mLayoutFromEnd) {
                a(recycler, state, this.mJk);
                i2 = this.mJk.mOffset;
                a(this.mJl, true, false);
                a(recycler, state, this.mJk);
                i = this.mJk.mOffset;
            } else {
                a(recycler, state, this.mJk);
                i = this.mJk.mOffset;
                b(this.mJl, true, false);
                a(recycler, state, this.mJk);
                i2 = this.mJk.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.mJl.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dyX() && this.mIsRtl) {
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
        if (!dyX() && this.mIsRtl) {
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

    private void Mn(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (dyX()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.mJk.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.mJk.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.mJk.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.mJk.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.mJp != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.mJp != -1 ? Math.min(this.mJp, this.mJl.mPosition) : this.mJl.mPosition;
            this.mJh.reset();
            if (dyX()) {
                if (this.mIQ.size() > 0) {
                    this.mJg.r(this.mIQ, min);
                    this.mJg.a(this.mJh, makeMeasureSpec, makeMeasureSpec2, i3, min, this.mJl.mPosition, this.mIQ);
                } else {
                    this.mJg.Mg(i);
                    this.mJg.a(this.mJh, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mIQ);
                }
            } else if (this.mIQ.size() > 0) {
                this.mJg.r(this.mIQ, min);
                this.mJg.a(this.mJh, makeMeasureSpec2, makeMeasureSpec, i3, min, this.mJl.mPosition, this.mIQ);
            } else {
                this.mJg.Mg(i);
                this.mJg.c(this.mJh, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mIQ);
            }
            this.mIQ = this.mJh.mIQ;
            this.mJg.ao(makeMeasureSpec, makeMeasureSpec2, min);
            this.mJg.Md(min);
        } else if (!this.mJl.mLayoutFromEnd) {
            this.mIQ.clear();
            if (!$assertionsDisabled && this.mJg.mIN == null) {
                throw new AssertionError();
            }
            this.mJh.reset();
            if (dyX()) {
                this.mJg.b(this.mJh, makeMeasureSpec, makeMeasureSpec2, i3, this.mJl.mPosition, this.mIQ);
            } else {
                this.mJg.d(this.mJh, makeMeasureSpec, makeMeasureSpec2, i3, this.mJl.mPosition, this.mIQ);
            }
            this.mIQ = this.mJh.mIQ;
            this.mJg.dY(makeMeasureSpec, makeMeasureSpec2);
            this.mJg.dzf();
            this.mJl.mJq = this.mJg.mIN[this.mJl.mPosition];
            this.mJk.mJq = this.mJl.mJq;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mJn = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mJp = -1;
        this.mJl.reset();
        this.mJo.clear();
    }

    private void dzh() {
        int layoutDirection = getLayoutDirection();
        switch (this.mIS) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.mJj = this.mIT == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.mJj = this.mIT == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.mIT == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mJj = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.mIT == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mJj = true;
                return;
            default:
                this.mIsRtl = false;
                this.mJj = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.mJn) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.mJq = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.mJg.mIN != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.mJq = this.mJg.mIN[aVar.mPosition];
            if (this.mJn == null || !this.mJn.Ms(state.getItemCount())) {
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
                } else if (dyX() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.mJs = true;
            aVar.mJq = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View Mo;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            Mo = Mp(state.getItemCount());
        } else {
            Mo = Mo(state.getItemCount());
        }
        if (Mo != null) {
            aVar.dv(Mo);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(Mo) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(Mo) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View Mo(int i) {
        if ($assertionsDisabled || this.mJg.mIN != null) {
            View aq = aq(0, getChildCount(), i);
            if (aq == null) {
                return null;
            }
            int i2 = this.mJg.mIN[getPosition(aq)];
            if (i2 != -1) {
                return a(aq, this.mIQ.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View Mp(int i) {
        if ($assertionsDisabled || this.mJg.mIN != null) {
            View aq = aq(getChildCount() - 1, -1, i);
            if (aq == null) {
                return null;
            }
            return b(aq, this.mIQ.get(this.mJg.mIN[getPosition(aq)]));
        }
        throw new AssertionError();
    }

    private View aq(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dzj();
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
        boolean dyX = dyX();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.mJk.mInfinite) && bVar.a(state, this.mIQ)) {
                com.google.android.flexbox.b bVar2 = this.mIQ.get(bVar.mJq);
                bVar.mPosition = bVar2.mIJ;
                i4 += a(bVar2, bVar);
                if (dyX || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dzd() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dzd() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dzd();
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
        if (!bVar.mJu) {
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
            if (!$assertionsDisabled && this.mJg.mIN == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mJg.mIN[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.mIQ.get(i);
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
                        if (bVar2.mIK == getPosition(childAt)) {
                            if (i >= this.mIQ.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.mIQ.get(i4);
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
        return (dyX() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.mJg.mIN == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mJg.mIN[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.mIQ.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mIJ == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.mIQ.get(i4);
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
        return (dyX() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dyX() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.mJg.mIO != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.mIB : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mIU) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.mIz) + paddingRight;
                    f2 = bVar.mIz - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.mIz) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.mIz) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.mIz) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mIz) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mIz) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mIU);
            }
            float f4 = f - this.mJl.mJr;
            float f5 = f2 - this.mJl.mJr;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View LZ = LZ(i6);
                if (LZ == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(LZ, mJi);
                        addView(LZ);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(LZ, mJi);
                        addView(LZ, i5);
                        i = i5 + 1;
                    }
                    long j = this.mJg.mIO[i6];
                    int gQ = this.mJg.gQ(j);
                    int gR = this.mJg.gR(j);
                    if (shouldMeasureChild(LZ, gQ, gR, (LayoutParams) LZ.getLayoutParams())) {
                        LZ.measure(gQ, gR);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(LZ);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(LZ));
                    int topDecorationHeight = i3 + getTopDecorationHeight(LZ);
                    if (this.mIsRtl) {
                        this.mJg.a(LZ, bVar, Math.round(rightDecorationWidth) - LZ.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + LZ.getMeasuredHeight());
                    } else {
                        this.mJg.a(LZ, bVar, Math.round(leftDecorationWidth), topDecorationHeight, LZ.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + LZ.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + LZ.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(LZ) + max;
                    measuredWidth2 = rightDecorationWidth - (((LZ.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(LZ)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.mJq += this.mJk.mLayoutDirection;
            return bVar.dzd();
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
        if ($assertionsDisabled || this.mJg.mIO != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.mIB;
                i = i5 + bVar.mIB;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mIU) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.mIz) + paddingBottom;
                    f2 = bVar.mIz - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.mIz) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.mIz) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.mIz) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mIz) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mIz) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mIU);
            }
            float f4 = f - this.mJl.mJr;
            float f5 = f2 - this.mJl.mJr;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View LZ = LZ(i9);
                if (LZ == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.mJg.mIO[i9];
                    int gQ = this.mJg.gQ(j);
                    int gR = this.mJg.gR(j);
                    if (shouldMeasureChild(LZ, gQ, gR, (LayoutParams) LZ.getLayoutParams())) {
                        LZ.measure(gQ, gR);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(LZ);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(LZ));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(LZ, mJi);
                        addView(LZ);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(LZ, mJi);
                        addView(LZ, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(LZ);
                    int rightDecorationWidth = i - getRightDecorationWidth(LZ);
                    if (this.mIsRtl) {
                        if (this.mJj) {
                            this.mJg.a(LZ, bVar, this.mIsRtl, rightDecorationWidth - LZ.getMeasuredWidth(), Math.round(bottomDecorationHeight) - LZ.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.mJg.a(LZ, bVar, this.mIsRtl, rightDecorationWidth - LZ.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, LZ.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.mJj) {
                        this.mJg.a(LZ, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - LZ.getMeasuredHeight(), leftDecorationWidth + LZ.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.mJg.a(LZ, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + LZ.getMeasuredWidth(), LZ.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((LZ.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(LZ)) + max);
                    measuredHeight2 = topDecorationHeight + LZ.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(LZ) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.mJq += this.mJk.mLayoutDirection;
            return bVar.dzd();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dyX() {
        return this.mIS == 0 || this.mIS == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dzi();
        } else {
            this.mJk.mInfinite = false;
        }
        if (!dyX() && this.mIsRtl) {
            this.mJk.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.mJk.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.mJk.mPosition = aVar.mPosition;
        this.mJk.mItemDirection = 1;
        this.mJk.mLayoutDirection = 1;
        this.mJk.mOffset = aVar.mCoordinate;
        this.mJk.mScrollingOffset = Integer.MIN_VALUE;
        this.mJk.mJq = aVar.mJq;
        if (z && this.mIQ.size() > 1 && aVar.mJq >= 0 && aVar.mJq < this.mIQ.size() - 1) {
            b.i(this.mJk);
            b bVar = this.mJk;
            bVar.mPosition = this.mIQ.get(aVar.mJq).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dzi();
        } else {
            this.mJk.mInfinite = false;
        }
        if (!dyX() && this.mIsRtl) {
            this.mJk.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.mJk.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mJk.mPosition = aVar.mPosition;
        this.mJk.mItemDirection = 1;
        this.mJk.mLayoutDirection = -1;
        this.mJk.mOffset = aVar.mCoordinate;
        this.mJk.mScrollingOffset = Integer.MIN_VALUE;
        this.mJk.mJq = aVar.mJq;
        if (z && aVar.mJq > 0 && this.mIQ.size() > aVar.mJq) {
            b.j(this.mJk);
            this.mJk.mPosition -= this.mIQ.get(aVar.mJq).getItemCount();
        }
    }

    private void dzi() {
        int widthMode;
        if (dyX()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.mJk.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dzj() {
        if (this.mOrientationHelper == null) {
            if (dyX()) {
                if (this.mIT == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.mJm = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mJm = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mIT == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mJm = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mJm = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.mJk == null) {
            this.mJk = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mJn != null) {
            this.mJn.invalidateAnchor();
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
        return !dyX() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dyX() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dyX()) {
            int a2 = a(i, recycler, state);
            this.mJo.clear();
            return a2;
        }
        int Mq = Mq(i);
        this.mJl.mJr += Mq;
        this.mJm.offsetChildren(-Mq);
        return Mq;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dyX()) {
            int a2 = a(i, recycler, state);
            this.mJo.clear();
            return a2;
        }
        int Mq = Mq(i);
        this.mJl.mJr += Mq;
        this.mJm.offsetChildren(-Mq);
        return Mq;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dzj();
        this.mJk.mJu = true;
        boolean z = !dyX() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        ec(i2, abs);
        int a2 = this.mJk.mScrollingOffset + a(recycler, state, this.mJk);
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
        this.mJk.mLastScrollDelta = i;
        return i;
    }

    private int Mq(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dzj();
        boolean dyX = dyX();
        int width = dyX ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dyX ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.mJl.mJr) - width, abs);
            }
            if (this.mJl.mJr + i <= 0) {
                return i;
            }
            return -this.mJl.mJr;
        } else if (i > 0) {
            return Math.min((width2 - this.mJl.mJr) - width, i);
        } else {
            if (this.mJl.mJr + i >= 0) {
                return i;
            }
            return -this.mJl.mJr;
        }
    }

    private void ec(int i, int i2) {
        if (!$assertionsDisabled && this.mJg.mIN == null) {
            throw new AssertionError();
        }
        this.mJk.mLayoutDirection = i;
        boolean dyX = dyX();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dyX && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.mJk.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.mIQ.get(this.mJg.mIN[position]));
            this.mJk.mItemDirection = 1;
            this.mJk.mPosition = this.mJk.mItemDirection + position;
            if (this.mJg.mIN.length <= this.mJk.mPosition) {
                this.mJk.mJq = -1;
            } else {
                this.mJk.mJq = this.mJg.mIN[this.mJk.mPosition];
            }
            if (z) {
                this.mJk.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.mJk.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.mJk.mScrollingOffset = this.mJk.mScrollingOffset >= 0 ? this.mJk.mScrollingOffset : 0;
            } else {
                this.mJk.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.mJk.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mJk.mJq == -1 || this.mJk.mJq > this.mIQ.size() - 1) && this.mJk.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.mJk.mScrollingOffset;
                this.mJh.reset();
                if (i3 > 0) {
                    if (dyX) {
                        this.mJg.a(this.mJh, makeMeasureSpec, makeMeasureSpec2, i3, this.mJk.mPosition, this.mIQ);
                    } else {
                        this.mJg.c(this.mJh, makeMeasureSpec, makeMeasureSpec2, i3, this.mJk.mPosition, this.mIQ);
                    }
                    this.mJg.ao(makeMeasureSpec, makeMeasureSpec2, this.mJk.mPosition);
                    this.mJg.Md(this.mJk.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.mJk.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.mIQ.get(this.mJg.mIN[position2]));
            this.mJk.mItemDirection = 1;
            int i4 = this.mJg.mIN[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.mJk.mPosition = position2 - this.mIQ.get(i5 - 1).getItemCount();
            } else {
                this.mJk.mPosition = -1;
            }
            this.mJk.mJq = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.mJk.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.mJk.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.mJk.mScrollingOffset = this.mJk.mScrollingOffset >= 0 ? this.mJk.mScrollingOffset : 0;
            } else {
                this.mJk.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.mJk.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.mJk.mAvailable = i2 - this.mJk.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dyX = dyX();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dyX) {
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
        boolean dyX = dyX();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dyX) {
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
        dzj();
        View Mo = Mo(itemCount);
        View Mp = Mp(itemCount);
        if (state.getItemCount() == 0 || Mo == null || Mp == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(Mp) - this.mOrientationHelper.getDecoratedStart(Mo));
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
        View Mo = Mo(itemCount);
        View Mp = Mp(itemCount);
        if (state.getItemCount() == 0 || Mo == null || Mp == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mJg.mIN != null) {
            int position = getPosition(Mo);
            int position2 = getPosition(Mp);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(Mp) - this.mOrientationHelper.getDecoratedStart(Mo));
            int i = this.mJg.mIN[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.mJg.mIN[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(Mo)));
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
        View Mo = Mo(itemCount);
        View Mp = Mp(itemCount);
        if (state.getItemCount() == 0 || Mo == null || Mp == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mJg.mIN != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(Mp) - this.mOrientationHelper.getDecoratedStart(Mo)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int dr(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int ds(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int dt(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int du(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean n(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int dr = dr(view);
        int dt = dt(view);
        int ds = ds(view);
        int du = du(view);
        return z ? (paddingLeft <= dr && width >= ds) && (paddingTop <= dt && height >= du) : (dr >= width || ds >= paddingLeft) && (dt >= height || du >= paddingTop);
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
            /* renamed from: Mr */
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
        public int dyY() {
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
        public boolean dyZ() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dza() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dzb() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dzc() {
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
        private int mJq;
        private int mJr;
        private boolean mJs;
        final /* synthetic */ FlexboxLayoutManager mJt;
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mJq = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mJs = false;
            if (this.mJt.dyX()) {
                if (this.mJt.mIT == 0) {
                    this.mLayoutFromEnd = this.mJt.mIS == 1;
                } else {
                    this.mLayoutFromEnd = this.mJt.mIT == 2;
                }
            } else if (this.mJt.mIT == 0) {
                this.mLayoutFromEnd = this.mJt.mIS == 3;
            } else {
                this.mLayoutFromEnd = this.mJt.mIT == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.mJt.dyX() && this.mJt.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.mJt.mOrientationHelper.getEndAfterPadding() : this.mJt.getWidth() - this.mJt.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.mJt.mOrientationHelper.getEndAfterPadding() : this.mJt.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dv(View view) {
            if (!this.mJt.dyX() && this.mJt.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.mJt.mOrientationHelper.getDecoratedStart(view) + this.mJt.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.mJt.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mJt.mOrientationHelper.getDecoratedEnd(view) + this.mJt.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mJt.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.mJt.getPosition(view);
            this.mJs = false;
            if (!$assertionsDisabled && this.mJt.mJg.mIN == null) {
                throw new AssertionError();
            }
            int i = this.mJt.mJg.mIN[this.mPosition != -1 ? this.mPosition : 0];
            this.mJq = i != -1 ? i : 0;
            if (this.mJt.mIQ.size() > this.mJq) {
                this.mPosition = ((com.google.android.flexbox.b) this.mJt.mIQ.get(this.mJq)).mIJ;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mJq + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mJr + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mJs + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        private int mAvailable;
        private boolean mInfinite;
        private int mItemDirection;
        private int mJq;
        private boolean mJu;
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
            int i = bVar.mJq;
            bVar.mJq = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.mJq;
            bVar.mJq = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.mJq >= 0 && this.mJq < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mJq + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
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
            /* renamed from: Mt */
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
        public boolean Ms(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
