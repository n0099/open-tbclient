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
    private static final Rect mJn;
    private final Context mContext;
    private List<com.google.android.flexbox.b> mIV;
    private int mIX;
    private int mIY;
    private int mIZ;
    private boolean mIsRtl;
    private int mJa;
    private int mJc;
    private final c mJl;
    private c.a mJm;
    private boolean mJo;
    private b mJp;
    private a mJq;
    private OrientationHelper mJr;
    private SavedState mJs;
    private SparseArray<View> mJt;
    private int mJu;
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
        mJn = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mIX;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mIY;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mJa;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mJc;
    }

    @Override // com.google.android.flexbox.a
    public int g(View view, int i, int i2) {
        return dyZ() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dq(View view) {
        return dyZ() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, mJn);
        if (dyZ()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.mIF += leftDecorationWidth;
            bVar.mIG = leftDecorationWidth + bVar.mIG;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.mIF += topDecorationHeight;
        bVar.mIG = topDecorationHeight + bVar.mIG;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View LZ(int i) {
        View view = this.mJt.get(i);
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
        if (this.mIV.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.mIV.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mIV.get(i2).mIF);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mIV.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mIV.get(i2).mIH;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.mIV = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.mIV;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i, View view) {
        this.mJt.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dyZ()) {
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
        if (this.mJs != null) {
            return new SavedState(this.mJs);
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
            this.mJs = (SavedState) parcelable;
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
            this.mJl.Mf(childCount);
            this.mJl.Me(childCount);
            this.mJl.Mg(childCount);
            if (!$assertionsDisabled && this.mJl.mIS == null) {
                throw new AssertionError();
            }
            if (i < this.mJl.mIS.length) {
                this.mJu = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dyZ() && this.mIsRtl) {
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
            dzj();
            dzl();
            ensureLayoutState();
            this.mJl.Mf(itemCount);
            this.mJl.Me(itemCount);
            this.mJl.Mg(itemCount);
            this.mJp.mJz = false;
            if (this.mJs != null && this.mJs.Ms(itemCount)) {
                this.mPendingScrollPosition = this.mJs.mAnchorPosition;
            }
            if (!this.mJq.mValid || this.mPendingScrollPosition != -1 || this.mJs != null) {
                this.mJq.reset();
                a(state, this.mJq);
                this.mJq.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.mJq.mLayoutFromEnd) {
                b(this.mJq, false, true);
            } else {
                a(this.mJq, false, true);
            }
            Mn(itemCount);
            if (this.mJq.mLayoutFromEnd) {
                a(recycler, state, this.mJp);
                i2 = this.mJp.mOffset;
                a(this.mJq, true, false);
                a(recycler, state, this.mJp);
                i = this.mJp.mOffset;
            } else {
                a(recycler, state, this.mJp);
                i = this.mJp.mOffset;
                b(this.mJq, true, false);
                a(recycler, state, this.mJp);
                i2 = this.mJp.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.mJq.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dyZ() && this.mIsRtl) {
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
        if (!dyZ() && this.mIsRtl) {
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
        if (dyZ()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.mJp.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.mJp.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.mJp.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.mJp.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.mJu != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.mJu != -1 ? Math.min(this.mJu, this.mJq.mPosition) : this.mJq.mPosition;
            this.mJm.reset();
            if (dyZ()) {
                if (this.mIV.size() > 0) {
                    this.mJl.r(this.mIV, min);
                    this.mJl.a(this.mJm, makeMeasureSpec, makeMeasureSpec2, i3, min, this.mJq.mPosition, this.mIV);
                } else {
                    this.mJl.Mg(i);
                    this.mJl.a(this.mJm, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mIV);
                }
            } else if (this.mIV.size() > 0) {
                this.mJl.r(this.mIV, min);
                this.mJl.a(this.mJm, makeMeasureSpec2, makeMeasureSpec, i3, min, this.mJq.mPosition, this.mIV);
            } else {
                this.mJl.Mg(i);
                this.mJl.c(this.mJm, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mIV);
            }
            this.mIV = this.mJm.mIV;
            this.mJl.ao(makeMeasureSpec, makeMeasureSpec2, min);
            this.mJl.Md(min);
        } else if (!this.mJq.mLayoutFromEnd) {
            this.mIV.clear();
            if (!$assertionsDisabled && this.mJl.mIS == null) {
                throw new AssertionError();
            }
            this.mJm.reset();
            if (dyZ()) {
                this.mJl.b(this.mJm, makeMeasureSpec, makeMeasureSpec2, i3, this.mJq.mPosition, this.mIV);
            } else {
                this.mJl.d(this.mJm, makeMeasureSpec, makeMeasureSpec2, i3, this.mJq.mPosition, this.mIV);
            }
            this.mIV = this.mJm.mIV;
            this.mJl.dY(makeMeasureSpec, makeMeasureSpec2);
            this.mJl.dzh();
            this.mJq.mJv = this.mJl.mIS[this.mJq.mPosition];
            this.mJp.mJv = this.mJq.mJv;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mJs = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mJu = -1;
        this.mJq.reset();
        this.mJt.clear();
    }

    private void dzj() {
        int layoutDirection = getLayoutDirection();
        switch (this.mIX) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.mJo = this.mIY == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.mJo = this.mIY == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.mIY == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mJo = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.mIY == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mJo = true;
                return;
            default:
                this.mIsRtl = false;
                this.mJo = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.mJs) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.mJv = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.mJl.mIS != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.mJv = this.mJl.mIS[aVar.mPosition];
            if (this.mJs == null || !this.mJs.Ms(state.getItemCount())) {
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
                } else if (dyZ() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.mJx = true;
            aVar.mJv = -1;
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
        if ($assertionsDisabled || this.mJl.mIS != null) {
            View aq = aq(0, getChildCount(), i);
            if (aq == null) {
                return null;
            }
            int i2 = this.mJl.mIS[getPosition(aq)];
            if (i2 != -1) {
                return a(aq, this.mIV.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View Mp(int i) {
        if ($assertionsDisabled || this.mJl.mIS != null) {
            View aq = aq(getChildCount() - 1, -1, i);
            if (aq == null) {
                return null;
            }
            return b(aq, this.mIV.get(this.mJl.mIS[getPosition(aq)]));
        }
        throw new AssertionError();
    }

    private View aq(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dzl();
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
        boolean dyZ = dyZ();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.mJp.mInfinite) && bVar.a(state, this.mIV)) {
                com.google.android.flexbox.b bVar2 = this.mIV.get(bVar.mJv);
                bVar.mPosition = bVar2.mIO;
                i4 += a(bVar2, bVar);
                if (dyZ || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dzf() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dzf() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dzf();
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
        if (!bVar.mJz) {
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
            if (!$assertionsDisabled && this.mJl.mIS == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mJl.mIS[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.mIV.get(i);
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
                        if (bVar2.mIP == getPosition(childAt)) {
                            if (i >= this.mIV.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.mIV.get(i4);
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
        return (dyZ() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.mJl.mIS == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mJl.mIS[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.mIV.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mIO == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.mIV.get(i4);
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
        return (dyZ() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dyZ() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.mJl.mIT != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.mIH : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mIZ) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.mIF) + paddingRight;
                    f2 = bVar.mIF - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.mIF) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.mIF) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.mIF) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mIF) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mIF) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mIZ);
            }
            float f4 = f - this.mJq.mJw;
            float f5 = f2 - this.mJq.mJw;
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
                        calculateItemDecorationsForChild(LZ, mJn);
                        addView(LZ);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(LZ, mJn);
                        addView(LZ, i5);
                        i = i5 + 1;
                    }
                    long j = this.mJl.mIT[i6];
                    int gQ = this.mJl.gQ(j);
                    int gR = this.mJl.gR(j);
                    if (shouldMeasureChild(LZ, gQ, gR, (LayoutParams) LZ.getLayoutParams())) {
                        LZ.measure(gQ, gR);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(LZ);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(LZ));
                    int topDecorationHeight = i3 + getTopDecorationHeight(LZ);
                    if (this.mIsRtl) {
                        this.mJl.a(LZ, bVar, Math.round(rightDecorationWidth) - LZ.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + LZ.getMeasuredHeight());
                    } else {
                        this.mJl.a(LZ, bVar, Math.round(leftDecorationWidth), topDecorationHeight, LZ.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + LZ.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + LZ.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(LZ) + max;
                    measuredWidth2 = rightDecorationWidth - (((LZ.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(LZ)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.mJv += this.mJp.mLayoutDirection;
            return bVar.dzf();
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
        if ($assertionsDisabled || this.mJl.mIT != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.mIH;
                i = i5 + bVar.mIH;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mIZ) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.mIF) + paddingBottom;
                    f2 = bVar.mIF - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.mIF) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.mIF) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.mIF) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mIF) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mIF) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mIZ);
            }
            float f4 = f - this.mJq.mJw;
            float f5 = f2 - this.mJq.mJw;
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
                    long j = this.mJl.mIT[i9];
                    int gQ = this.mJl.gQ(j);
                    int gR = this.mJl.gR(j);
                    if (shouldMeasureChild(LZ, gQ, gR, (LayoutParams) LZ.getLayoutParams())) {
                        LZ.measure(gQ, gR);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(LZ);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(LZ));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(LZ, mJn);
                        addView(LZ);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(LZ, mJn);
                        addView(LZ, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(LZ);
                    int rightDecorationWidth = i - getRightDecorationWidth(LZ);
                    if (this.mIsRtl) {
                        if (this.mJo) {
                            this.mJl.a(LZ, bVar, this.mIsRtl, rightDecorationWidth - LZ.getMeasuredWidth(), Math.round(bottomDecorationHeight) - LZ.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.mJl.a(LZ, bVar, this.mIsRtl, rightDecorationWidth - LZ.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, LZ.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.mJo) {
                        this.mJl.a(LZ, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - LZ.getMeasuredHeight(), leftDecorationWidth + LZ.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.mJl.a(LZ, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + LZ.getMeasuredWidth(), LZ.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((LZ.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(LZ)) + max);
                    measuredHeight2 = topDecorationHeight + LZ.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(LZ) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.mJv += this.mJp.mLayoutDirection;
            return bVar.dzf();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dyZ() {
        return this.mIX == 0 || this.mIX == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dzk();
        } else {
            this.mJp.mInfinite = false;
        }
        if (!dyZ() && this.mIsRtl) {
            this.mJp.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.mJp.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.mJp.mPosition = aVar.mPosition;
        this.mJp.mItemDirection = 1;
        this.mJp.mLayoutDirection = 1;
        this.mJp.mOffset = aVar.mCoordinate;
        this.mJp.mScrollingOffset = Integer.MIN_VALUE;
        this.mJp.mJv = aVar.mJv;
        if (z && this.mIV.size() > 1 && aVar.mJv >= 0 && aVar.mJv < this.mIV.size() - 1) {
            b.i(this.mJp);
            b bVar = this.mJp;
            bVar.mPosition = this.mIV.get(aVar.mJv).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dzk();
        } else {
            this.mJp.mInfinite = false;
        }
        if (!dyZ() && this.mIsRtl) {
            this.mJp.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.mJp.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mJp.mPosition = aVar.mPosition;
        this.mJp.mItemDirection = 1;
        this.mJp.mLayoutDirection = -1;
        this.mJp.mOffset = aVar.mCoordinate;
        this.mJp.mScrollingOffset = Integer.MIN_VALUE;
        this.mJp.mJv = aVar.mJv;
        if (z && aVar.mJv > 0 && this.mIV.size() > aVar.mJv) {
            b.j(this.mJp);
            this.mJp.mPosition -= this.mIV.get(aVar.mJv).getItemCount();
        }
    }

    private void dzk() {
        int widthMode;
        if (dyZ()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.mJp.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dzl() {
        if (this.mOrientationHelper == null) {
            if (dyZ()) {
                if (this.mIY == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.mJr = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mJr = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mIY == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mJr = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mJr = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.mJp == null) {
            this.mJp = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mJs != null) {
            this.mJs.invalidateAnchor();
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
        return !dyZ() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dyZ() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dyZ()) {
            int a2 = a(i, recycler, state);
            this.mJt.clear();
            return a2;
        }
        int Mq = Mq(i);
        this.mJq.mJw += Mq;
        this.mJr.offsetChildren(-Mq);
        return Mq;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dyZ()) {
            int a2 = a(i, recycler, state);
            this.mJt.clear();
            return a2;
        }
        int Mq = Mq(i);
        this.mJq.mJw += Mq;
        this.mJr.offsetChildren(-Mq);
        return Mq;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dzl();
        this.mJp.mJz = true;
        boolean z = !dyZ() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        ec(i2, abs);
        int a2 = this.mJp.mScrollingOffset + a(recycler, state, this.mJp);
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
        this.mJp.mLastScrollDelta = i;
        return i;
    }

    private int Mq(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dzl();
        boolean dyZ = dyZ();
        int width = dyZ ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dyZ ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.mJq.mJw) - width, abs);
            }
            if (this.mJq.mJw + i <= 0) {
                return i;
            }
            return -this.mJq.mJw;
        } else if (i > 0) {
            return Math.min((width2 - this.mJq.mJw) - width, i);
        } else {
            if (this.mJq.mJw + i >= 0) {
                return i;
            }
            return -this.mJq.mJw;
        }
    }

    private void ec(int i, int i2) {
        if (!$assertionsDisabled && this.mJl.mIS == null) {
            throw new AssertionError();
        }
        this.mJp.mLayoutDirection = i;
        boolean dyZ = dyZ();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dyZ && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.mJp.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.mIV.get(this.mJl.mIS[position]));
            this.mJp.mItemDirection = 1;
            this.mJp.mPosition = this.mJp.mItemDirection + position;
            if (this.mJl.mIS.length <= this.mJp.mPosition) {
                this.mJp.mJv = -1;
            } else {
                this.mJp.mJv = this.mJl.mIS[this.mJp.mPosition];
            }
            if (z) {
                this.mJp.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.mJp.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.mJp.mScrollingOffset = this.mJp.mScrollingOffset >= 0 ? this.mJp.mScrollingOffset : 0;
            } else {
                this.mJp.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.mJp.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mJp.mJv == -1 || this.mJp.mJv > this.mIV.size() - 1) && this.mJp.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.mJp.mScrollingOffset;
                this.mJm.reset();
                if (i3 > 0) {
                    if (dyZ) {
                        this.mJl.a(this.mJm, makeMeasureSpec, makeMeasureSpec2, i3, this.mJp.mPosition, this.mIV);
                    } else {
                        this.mJl.c(this.mJm, makeMeasureSpec, makeMeasureSpec2, i3, this.mJp.mPosition, this.mIV);
                    }
                    this.mJl.ao(makeMeasureSpec, makeMeasureSpec2, this.mJp.mPosition);
                    this.mJl.Md(this.mJp.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.mJp.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.mIV.get(this.mJl.mIS[position2]));
            this.mJp.mItemDirection = 1;
            int i4 = this.mJl.mIS[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.mJp.mPosition = position2 - this.mIV.get(i5 - 1).getItemCount();
            } else {
                this.mJp.mPosition = -1;
            }
            this.mJp.mJv = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.mJp.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.mJp.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.mJp.mScrollingOffset = this.mJp.mScrollingOffset >= 0 ? this.mJp.mScrollingOffset : 0;
            } else {
                this.mJp.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.mJp.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.mJp.mAvailable = i2 - this.mJp.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dyZ = dyZ();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dyZ) {
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
        boolean dyZ = dyZ();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dyZ) {
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
        dzl();
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
        if ($assertionsDisabled || this.mJl.mIS != null) {
            int position = getPosition(Mo);
            int position2 = getPosition(Mp);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(Mp) - this.mOrientationHelper.getDecoratedStart(Mo));
            int i = this.mJl.mIS[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.mJl.mIS[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(Mo)));
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
        if ($assertionsDisabled || this.mJl.mIS != null) {
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
        public int dza() {
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
        public boolean dzb() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dzc() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dzd() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dze() {
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
        private int mJv;
        private int mJw;
        private boolean mJx;
        final /* synthetic */ FlexboxLayoutManager mJy;
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mJv = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mJx = false;
            if (this.mJy.dyZ()) {
                if (this.mJy.mIY == 0) {
                    this.mLayoutFromEnd = this.mJy.mIX == 1;
                } else {
                    this.mLayoutFromEnd = this.mJy.mIY == 2;
                }
            } else if (this.mJy.mIY == 0) {
                this.mLayoutFromEnd = this.mJy.mIX == 3;
            } else {
                this.mLayoutFromEnd = this.mJy.mIY == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.mJy.dyZ() && this.mJy.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.mJy.mOrientationHelper.getEndAfterPadding() : this.mJy.getWidth() - this.mJy.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.mJy.mOrientationHelper.getEndAfterPadding() : this.mJy.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dv(View view) {
            if (!this.mJy.dyZ() && this.mJy.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.mJy.mOrientationHelper.getDecoratedStart(view) + this.mJy.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.mJy.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mJy.mOrientationHelper.getDecoratedEnd(view) + this.mJy.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mJy.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.mJy.getPosition(view);
            this.mJx = false;
            if (!$assertionsDisabled && this.mJy.mJl.mIS == null) {
                throw new AssertionError();
            }
            int i = this.mJy.mJl.mIS[this.mPosition != -1 ? this.mPosition : 0];
            this.mJv = i != -1 ? i : 0;
            if (this.mJy.mIV.size() > this.mJv) {
                this.mPosition = ((com.google.android.flexbox.b) this.mJy.mIV.get(this.mJv)).mIO;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mJv + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mJw + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mJx + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        private int mAvailable;
        private boolean mInfinite;
        private int mItemDirection;
        private int mJv;
        private boolean mJz;
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
            int i = bVar.mJv;
            bVar.mJv = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.mJv;
            bVar.mJv = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.mJv >= 0 && this.mJv < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mJv + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
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
