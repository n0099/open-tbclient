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
    private static final Rect mZK;
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
    private final c mZI;
    private c.a mZJ;
    private boolean mZL;
    private b mZM;
    private a mZN;
    private OrientationHelper mZO;
    private SavedState mZP;
    private SparseArray<View> mZQ;
    private int mZR;
    private List<com.google.android.flexbox.b> mZs;
    private int mZu;
    private int mZv;
    private int mZw;
    private int mZx;
    private int mZz;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        mZK = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mZu;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mZv;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mZx;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mZz;
    }

    @Override // com.google.android.flexbox.a
    public int i(View view, int i, int i2) {
        return dHk() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dl(View view) {
        return dHk() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, mZK);
        if (dHk()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.mZc += leftDecorationWidth;
            bVar.mZd = leftDecorationWidth + bVar.mZd;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.mZc += topDecorationHeight;
        bVar.mZd = topDecorationHeight + bVar.mZd;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View Jz(int i) {
        View view = this.mZQ.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View JA(int i) {
        return Jz(i);
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
        if (this.mZs.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.mZs.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mZs.get(i2).mZc);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mZs.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mZs.get(i2).mZe;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.mZs = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.mZs;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
        this.mZQ.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dHk()) {
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
        if (this.mZP != null) {
            return new SavedState(this.mZP);
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
            this.mZP = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        JM(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        JM(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        JM(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        JM(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        JM(Math.min(i, i2));
    }

    private void JM(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.mZI.JF(childCount);
            this.mZI.JE(childCount);
            this.mZI.JG(childCount);
            if (!$assertionsDisabled && this.mZI.mZp == null) {
                throw new AssertionError();
            }
            if (i < this.mZI.mZp.length) {
                this.mZR = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dHk() && this.mIsRtl) {
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
            dHu();
            dHw();
            ensureLayoutState();
            this.mZI.JF(itemCount);
            this.mZI.JE(itemCount);
            this.mZI.JG(itemCount);
            this.mZM.mZW = false;
            if (this.mZP != null && this.mZP.JS(itemCount)) {
                this.mPendingScrollPosition = this.mZP.mAnchorPosition;
            }
            if (!this.mZN.mValid || this.mPendingScrollPosition != -1 || this.mZP != null) {
                this.mZN.reset();
                a(state, this.mZN);
                this.mZN.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.mZN.mLayoutFromEnd) {
                b(this.mZN, false, true);
            } else {
                a(this.mZN, false, true);
            }
            JN(itemCount);
            if (this.mZN.mLayoutFromEnd) {
                a(recycler, state, this.mZM);
                i2 = this.mZM.mOffset;
                a(this.mZN, true, false);
                a(recycler, state, this.mZM);
                i = this.mZM.mOffset;
            } else {
                a(recycler, state, this.mZM);
                i = this.mZM.mOffset;
                b(this.mZN, true, false);
                a(recycler, state, this.mZM);
                i2 = this.mZM.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.mZN.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dHk() && this.mIsRtl) {
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
        if (!dHk() && this.mIsRtl) {
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

    private void JN(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (dHk()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.mZM.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.mZM.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.mZM.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.mZM.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.mZR != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.mZR != -1 ? Math.min(this.mZR, this.mZN.mPosition) : this.mZN.mPosition;
            this.mZJ.reset();
            if (dHk()) {
                if (this.mZs.size() > 0) {
                    this.mZI.v(this.mZs, min);
                    this.mZI.a(this.mZJ, makeMeasureSpec, makeMeasureSpec2, i3, min, this.mZN.mPosition, this.mZs);
                } else {
                    this.mZI.JG(i);
                    this.mZI.a(this.mZJ, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mZs);
                }
            } else if (this.mZs.size() > 0) {
                this.mZI.v(this.mZs, min);
                this.mZI.a(this.mZJ, makeMeasureSpec2, makeMeasureSpec, i3, min, this.mZN.mPosition, this.mZs);
            } else {
                this.mZI.JG(i);
                this.mZI.c(this.mZJ, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mZs);
            }
            this.mZs = this.mZJ.mZs;
            this.mZI.ai(makeMeasureSpec, makeMeasureSpec2, min);
            this.mZI.JD(min);
        } else if (!this.mZN.mLayoutFromEnd) {
            this.mZs.clear();
            if (!$assertionsDisabled && this.mZI.mZp == null) {
                throw new AssertionError();
            }
            this.mZJ.reset();
            if (dHk()) {
                this.mZI.b(this.mZJ, makeMeasureSpec, makeMeasureSpec2, i3, this.mZN.mPosition, this.mZs);
            } else {
                this.mZI.d(this.mZJ, makeMeasureSpec, makeMeasureSpec2, i3, this.mZN.mPosition, this.mZs);
            }
            this.mZs = this.mZJ.mZs;
            this.mZI.dC(makeMeasureSpec, makeMeasureSpec2);
            this.mZI.dHs();
            this.mZN.mZS = this.mZI.mZp[this.mZN.mPosition];
            this.mZM.mZS = this.mZN.mZS;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mZP = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mZR = -1;
        this.mZN.reset();
        this.mZQ.clear();
    }

    private void dHu() {
        int layoutDirection = getLayoutDirection();
        switch (this.mZu) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.mZL = this.mZv == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.mZL = this.mZv == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.mZv == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mZL = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.mZv == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mZL = true;
                return;
            default:
                this.mIsRtl = false;
                this.mZL = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.mZP) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.mZS = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.mZI.mZp != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.mZS = this.mZI.mZp[aVar.mPosition];
            if (this.mZP == null || !this.mZP.JS(state.getItemCount())) {
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
                } else if (dHk() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.mZU = true;
            aVar.mZS = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View JO;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            JO = JP(state.getItemCount());
        } else {
            JO = JO(state.getItemCount());
        }
        if (JO != null) {
            aVar.dq(JO);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(JO) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(JO) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View JO(int i) {
        if ($assertionsDisabled || this.mZI.mZp != null) {
            View ak = ak(0, getChildCount(), i);
            if (ak == null) {
                return null;
            }
            int i2 = this.mZI.mZp[getPosition(ak)];
            if (i2 != -1) {
                return a(ak, this.mZs.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View JP(int i) {
        if ($assertionsDisabled || this.mZI.mZp != null) {
            View ak = ak(getChildCount() - 1, -1, i);
            if (ak == null) {
                return null;
            }
            return b(ak, this.mZs.get(this.mZI.mZp[getPosition(ak)]));
        }
        throw new AssertionError();
    }

    private View ak(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dHw();
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
        boolean dHk = dHk();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.mZM.mInfinite) && bVar.a(state, this.mZs)) {
                com.google.android.flexbox.b bVar2 = this.mZs.get(bVar.mZS);
                bVar.mPosition = bVar2.mZl;
                i4 += a(bVar2, bVar);
                if (dHk || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dHq() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dHq() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dHq();
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
        if (!bVar.mZW) {
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
            if (!$assertionsDisabled && this.mZI.mZp == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mZI.mZp[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.mZs.get(i);
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
                        if (bVar2.mZm == getPosition(childAt)) {
                            if (i >= this.mZs.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.mZs.get(i4);
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
        return (dHk() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.mZI.mZp == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.mZI.mZp[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.mZs.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mZl == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.mZs.get(i4);
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
        return (dHk() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dHk() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.mZI.mZq != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.mZe : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mZw) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.mZc) + paddingRight;
                    f2 = bVar.mZc - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.mZc) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.mZc) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.mZc) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mZc) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mZc) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mZw);
            }
            float f4 = f - this.mZN.mZT;
            float f5 = f2 - this.mZN.mZT;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View Jz = Jz(i6);
                if (Jz == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Jz, mZK);
                        addView(Jz);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(Jz, mZK);
                        addView(Jz, i5);
                        i = i5 + 1;
                    }
                    long j = this.mZI.mZq[i6];
                    int fX = this.mZI.fX(j);
                    int fY = this.mZI.fY(j);
                    if (shouldMeasureChild(Jz, fX, fY, (LayoutParams) Jz.getLayoutParams())) {
                        Jz.measure(fX, fY);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(Jz);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(Jz));
                    int topDecorationHeight = i3 + getTopDecorationHeight(Jz);
                    if (this.mIsRtl) {
                        this.mZI.a(Jz, bVar, Math.round(rightDecorationWidth) - Jz.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + Jz.getMeasuredHeight());
                    } else {
                        this.mZI.a(Jz, bVar, Math.round(leftDecorationWidth), topDecorationHeight, Jz.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + Jz.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + Jz.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(Jz) + max;
                    measuredWidth2 = rightDecorationWidth - (((Jz.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(Jz)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.mZS += this.mZM.mLayoutDirection;
            return bVar.dHq();
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
        if ($assertionsDisabled || this.mZI.mZq != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.mZe;
                i = i5 + bVar.mZe;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mZw) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.mZc) + paddingBottom;
                    f2 = bVar.mZc - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.mZc) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.mZc) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.mZc) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mZc) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mZc) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mZw);
            }
            float f4 = f - this.mZN.mZT;
            float f5 = f2 - this.mZN.mZT;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View Jz = Jz(i9);
                if (Jz == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.mZI.mZq[i9];
                    int fX = this.mZI.fX(j);
                    int fY = this.mZI.fY(j);
                    if (shouldMeasureChild(Jz, fX, fY, (LayoutParams) Jz.getLayoutParams())) {
                        Jz.measure(fX, fY);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(Jz);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(Jz));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Jz, mZK);
                        addView(Jz);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(Jz, mZK);
                        addView(Jz, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(Jz);
                    int rightDecorationWidth = i - getRightDecorationWidth(Jz);
                    if (this.mIsRtl) {
                        if (this.mZL) {
                            this.mZI.a(Jz, bVar, this.mIsRtl, rightDecorationWidth - Jz.getMeasuredWidth(), Math.round(bottomDecorationHeight) - Jz.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.mZI.a(Jz, bVar, this.mIsRtl, rightDecorationWidth - Jz.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Jz.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.mZL) {
                        this.mZI.a(Jz, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - Jz.getMeasuredHeight(), leftDecorationWidth + Jz.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.mZI.a(Jz, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + Jz.getMeasuredWidth(), Jz.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((Jz.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(Jz)) + max);
                    measuredHeight2 = topDecorationHeight + Jz.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(Jz) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.mZS += this.mZM.mLayoutDirection;
            return bVar.dHq();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dHk() {
        return this.mZu == 0 || this.mZu == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dHv();
        } else {
            this.mZM.mInfinite = false;
        }
        if (!dHk() && this.mIsRtl) {
            this.mZM.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.mZM.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.mZM.mPosition = aVar.mPosition;
        this.mZM.mItemDirection = 1;
        this.mZM.mLayoutDirection = 1;
        this.mZM.mOffset = aVar.mCoordinate;
        this.mZM.mScrollingOffset = Integer.MIN_VALUE;
        this.mZM.mZS = aVar.mZS;
        if (z && this.mZs.size() > 1 && aVar.mZS >= 0 && aVar.mZS < this.mZs.size() - 1) {
            b.i(this.mZM);
            b bVar = this.mZM;
            bVar.mPosition = this.mZs.get(aVar.mZS).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dHv();
        } else {
            this.mZM.mInfinite = false;
        }
        if (!dHk() && this.mIsRtl) {
            this.mZM.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.mZM.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mZM.mPosition = aVar.mPosition;
        this.mZM.mItemDirection = 1;
        this.mZM.mLayoutDirection = -1;
        this.mZM.mOffset = aVar.mCoordinate;
        this.mZM.mScrollingOffset = Integer.MIN_VALUE;
        this.mZM.mZS = aVar.mZS;
        if (z && aVar.mZS > 0 && this.mZs.size() > aVar.mZS) {
            b.j(this.mZM);
            this.mZM.mPosition -= this.mZs.get(aVar.mZS).getItemCount();
        }
    }

    private void dHv() {
        int widthMode;
        if (dHk()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.mZM.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dHw() {
        if (this.mOrientationHelper == null) {
            if (dHk()) {
                if (this.mZv == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.mZO = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mZO = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mZv == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mZO = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mZO = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.mZM == null) {
            this.mZM = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mZP != null) {
            this.mZP.invalidateAnchor();
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
        return !dHk() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dHk() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dHk()) {
            int a2 = a(i, recycler, state);
            this.mZQ.clear();
            return a2;
        }
        int JQ = JQ(i);
        this.mZN.mZT += JQ;
        this.mZO.offsetChildren(-JQ);
        return JQ;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dHk()) {
            int a2 = a(i, recycler, state);
            this.mZQ.clear();
            return a2;
        }
        int JQ = JQ(i);
        this.mZN.mZT += JQ;
        this.mZO.offsetChildren(-JQ);
        return JQ;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dHw();
        this.mZM.mZW = true;
        boolean z = !dHk() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        dG(i2, abs);
        int a2 = this.mZM.mScrollingOffset + a(recycler, state, this.mZM);
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
        this.mZM.mLastScrollDelta = i;
        return i;
    }

    private int JQ(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dHw();
        boolean dHk = dHk();
        int width = dHk ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dHk ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.mZN.mZT) - width, abs);
            }
            if (this.mZN.mZT + i <= 0) {
                return i;
            }
            return -this.mZN.mZT;
        } else if (i > 0) {
            return Math.min((width2 - this.mZN.mZT) - width, i);
        } else {
            if (this.mZN.mZT + i >= 0) {
                return i;
            }
            return -this.mZN.mZT;
        }
    }

    private void dG(int i, int i2) {
        if (!$assertionsDisabled && this.mZI.mZp == null) {
            throw new AssertionError();
        }
        this.mZM.mLayoutDirection = i;
        boolean dHk = dHk();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dHk && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.mZM.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.mZs.get(this.mZI.mZp[position]));
            this.mZM.mItemDirection = 1;
            this.mZM.mPosition = this.mZM.mItemDirection + position;
            if (this.mZI.mZp.length <= this.mZM.mPosition) {
                this.mZM.mZS = -1;
            } else {
                this.mZM.mZS = this.mZI.mZp[this.mZM.mPosition];
            }
            if (z) {
                this.mZM.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.mZM.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.mZM.mScrollingOffset = this.mZM.mScrollingOffset >= 0 ? this.mZM.mScrollingOffset : 0;
            } else {
                this.mZM.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.mZM.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mZM.mZS == -1 || this.mZM.mZS > this.mZs.size() - 1) && this.mZM.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.mZM.mScrollingOffset;
                this.mZJ.reset();
                if (i3 > 0) {
                    if (dHk) {
                        this.mZI.a(this.mZJ, makeMeasureSpec, makeMeasureSpec2, i3, this.mZM.mPosition, this.mZs);
                    } else {
                        this.mZI.c(this.mZJ, makeMeasureSpec, makeMeasureSpec2, i3, this.mZM.mPosition, this.mZs);
                    }
                    this.mZI.ai(makeMeasureSpec, makeMeasureSpec2, this.mZM.mPosition);
                    this.mZI.JD(this.mZM.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.mZM.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.mZs.get(this.mZI.mZp[position2]));
            this.mZM.mItemDirection = 1;
            int i4 = this.mZI.mZp[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.mZM.mPosition = position2 - this.mZs.get(i5 - 1).getItemCount();
            } else {
                this.mZM.mPosition = -1;
            }
            this.mZM.mZS = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.mZM.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.mZM.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.mZM.mScrollingOffset = this.mZM.mScrollingOffset >= 0 ? this.mZM.mScrollingOffset : 0;
            } else {
                this.mZM.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.mZM.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.mZM.mAvailable = i2 - this.mZM.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dHk = dHk();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dHk) {
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
        boolean dHk = dHk();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dHk) {
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
        dHw();
        View JO = JO(itemCount);
        View JP = JP(itemCount);
        if (state.getItemCount() == 0 || JO == null || JP == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(JP) - this.mOrientationHelper.getDecoratedStart(JO));
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
        View JO = JO(itemCount);
        View JP = JP(itemCount);
        if (state.getItemCount() == 0 || JO == null || JP == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mZI.mZp != null) {
            int position = getPosition(JO);
            int position2 = getPosition(JP);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(JP) - this.mOrientationHelper.getDecoratedStart(JO));
            int i = this.mZI.mZp[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.mZI.mZp[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(JO)));
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
        View JO = JO(itemCount);
        View JP = JP(itemCount);
        if (state.getItemCount() == 0 || JO == null || JP == null) {
            return 0;
        }
        if ($assertionsDisabled || this.mZI.mZp != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(JP) - this.mOrientationHelper.getDecoratedStart(JO)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int dm(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int dn(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    /* renamed from: do  reason: not valid java name */
    private int m39do(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int dp(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean p(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int dm = dm(view);
        int m39do = m39do(view);
        int dn = dn(view);
        int dp = dp(view);
        return z ? (paddingLeft <= dm && width >= dn) && (paddingTop <= m39do && height >= dp) : (dm >= width || dn >= paddingLeft) && (m39do >= height || dp >= paddingTop);
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
            /* renamed from: aj */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: JR */
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
        public int dHl() {
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
        public boolean dHm() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dHn() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dHo() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dHp() {
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
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;
        private int mZS;
        private int mZT;
        private boolean mZU;
        final /* synthetic */ FlexboxLayoutManager mZV;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mZS = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mZU = false;
            if (this.mZV.dHk()) {
                if (this.mZV.mZv == 0) {
                    this.mLayoutFromEnd = this.mZV.mZu == 1;
                } else {
                    this.mLayoutFromEnd = this.mZV.mZv == 2;
                }
            } else if (this.mZV.mZv == 0) {
                this.mLayoutFromEnd = this.mZV.mZu == 3;
            } else {
                this.mLayoutFromEnd = this.mZV.mZv == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.mZV.dHk() && this.mZV.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.mZV.mOrientationHelper.getEndAfterPadding() : this.mZV.getWidth() - this.mZV.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.mZV.mOrientationHelper.getEndAfterPadding() : this.mZV.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dq(View view) {
            if (!this.mZV.dHk() && this.mZV.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.mZV.mOrientationHelper.getDecoratedStart(view) + this.mZV.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.mZV.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mZV.mOrientationHelper.getDecoratedEnd(view) + this.mZV.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mZV.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.mZV.getPosition(view);
            this.mZU = false;
            if (!$assertionsDisabled && this.mZV.mZI.mZp == null) {
                throw new AssertionError();
            }
            int i = this.mZV.mZI.mZp[this.mPosition != -1 ? this.mPosition : 0];
            this.mZS = i != -1 ? i : 0;
            if (this.mZV.mZs.size() > this.mZS) {
                this.mPosition = ((com.google.android.flexbox.b) this.mZV.mZs.get(this.mZS)).mZl;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mZS + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mZT + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mZU + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {
        private int mAvailable;
        private boolean mInfinite;
        private int mItemDirection;
        private int mLastScrollDelta;
        private int mLayoutDirection;
        private int mOffset;
        private int mPosition;
        private int mScrollingOffset;
        private int mZS;
        private boolean mZW;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.mZS;
            bVar.mZS = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.mZS;
            bVar.mZS = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.mZS >= 0 && this.mZS < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mZS + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ak */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: JT */
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
        public boolean JS(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
