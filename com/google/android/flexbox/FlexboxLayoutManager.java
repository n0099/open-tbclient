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
/* loaded from: classes12.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider, com.google.android.flexbox.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Rect nLU;
    private int hfz;
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
    private List<com.google.android.flexbox.b> nLD;
    private int nLF;
    private int nLG;
    private int nLH;
    private int nLI;
    private final c nLS;
    private c.a nLT;
    private boolean nLV;
    private b nLW;
    private a nLX;
    private OrientationHelper nLY;
    private SavedState nLZ;
    private SparseArray<View> nMa;
    private int nMb;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        nLU = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.nLF;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.nLG;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.nLI;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.hfz;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        return eaF() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dE(View view) {
        return eaF() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, nLU);
        if (eaF()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.nLn += leftDecorationWidth;
            bVar.nLo = leftDecorationWidth + bVar.nLo;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.nLn += topDecorationHeight;
        bVar.nLo = topDecorationHeight + bVar.nLo;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View Nd(int i) {
        View view = this.nMa.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View Ne(int i) {
        return Nd(i);
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
        if (this.nLD.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.nLD.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.nLD.get(i2).nLn);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.nLD.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.nLD.get(i2).nLp;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.nLD = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.nLD;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
        this.nMa.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (eaF()) {
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
        if (this.nLZ != null) {
            return new SavedState(this.nLZ);
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
            this.nLZ = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        Nq(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        Nq(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        Nq(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        Nq(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        Nq(Math.min(i, i2));
    }

    private void Nq(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.nLS.Nj(childCount);
            this.nLS.Ni(childCount);
            this.nLS.Nk(childCount);
            if (!$assertionsDisabled && this.nLS.nLA == null) {
                throw new AssertionError();
            }
            if (i < this.nLS.nLA.length) {
                this.nMb = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!eaF() && this.mIsRtl) {
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
            eaP();
            eaR();
            ensureLayoutState();
            this.nLS.Nj(itemCount);
            this.nLS.Ni(itemCount);
            this.nLS.Nk(itemCount);
            this.nLW.nMg = false;
            if (this.nLZ != null && this.nLZ.Nw(itemCount)) {
                this.mPendingScrollPosition = this.nLZ.mAnchorPosition;
            }
            if (!this.nLX.mValid || this.mPendingScrollPosition != -1 || this.nLZ != null) {
                this.nLX.reset();
                a(state, this.nLX);
                this.nLX.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.nLX.mLayoutFromEnd) {
                b(this.nLX, false, true);
            } else {
                a(this.nLX, false, true);
            }
            Nr(itemCount);
            if (this.nLX.mLayoutFromEnd) {
                a(recycler, state, this.nLW);
                i2 = this.nLW.mOffset;
                a(this.nLX, true, false);
                a(recycler, state, this.nLW);
                i = this.nLW.mOffset;
            } else {
                a(recycler, state, this.nLW);
                i = this.nLW.mOffset;
                b(this.nLX, true, false);
                a(recycler, state, this.nLW);
                i2 = this.nLW.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.nLX.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!eaF() && this.mIsRtl) {
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
        if (!eaF() && this.mIsRtl) {
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

    private void Nr(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (eaF()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.nLW.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.nLW.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.nLW.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.nLW.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.nMb != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.nMb != -1 ? Math.min(this.nMb, this.nLX.mPosition) : this.nLX.mPosition;
            this.nLT.reset();
            if (eaF()) {
                if (this.nLD.size() > 0) {
                    this.nLS.y(this.nLD, min);
                    this.nLS.a(this.nLT, makeMeasureSpec, makeMeasureSpec2, i3, min, this.nLX.mPosition, this.nLD);
                } else {
                    this.nLS.Nk(i);
                    this.nLS.a(this.nLT, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.nLD);
                }
            } else if (this.nLD.size() > 0) {
                this.nLS.y(this.nLD, min);
                this.nLS.a(this.nLT, makeMeasureSpec2, makeMeasureSpec, i3, min, this.nLX.mPosition, this.nLD);
            } else {
                this.nLS.Nk(i);
                this.nLS.c(this.nLT, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.nLD);
            }
            this.nLD = this.nLT.nLD;
            this.nLS.ai(makeMeasureSpec, makeMeasureSpec2, min);
            this.nLS.Nh(min);
        } else if (!this.nLX.mLayoutFromEnd) {
            this.nLD.clear();
            if (!$assertionsDisabled && this.nLS.nLA == null) {
                throw new AssertionError();
            }
            this.nLT.reset();
            if (eaF()) {
                this.nLS.b(this.nLT, makeMeasureSpec, makeMeasureSpec2, i3, this.nLX.mPosition, this.nLD);
            } else {
                this.nLS.d(this.nLT, makeMeasureSpec, makeMeasureSpec2, i3, this.nLX.mPosition, this.nLD);
            }
            this.nLD = this.nLT.nLD;
            this.nLS.dQ(makeMeasureSpec, makeMeasureSpec2);
            this.nLS.eaN();
            this.nLX.nMc = this.nLS.nLA[this.nLX.mPosition];
            this.nLW.nMc = this.nLX.nMc;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.nLZ = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.nMb = -1;
        this.nLX.reset();
        this.nMa.clear();
    }

    private void eaP() {
        int layoutDirection = getLayoutDirection();
        switch (this.nLF) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.nLV = this.nLG == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.nLV = this.nLG == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.nLG == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.nLV = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.nLG == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.nLV = true;
                return;
            default:
                this.mIsRtl = false;
                this.nLV = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.nLZ) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.nMc = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.nLS.nLA != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.nMc = this.nLS.nLA[aVar.mPosition];
            if (this.nLZ == null || !this.nLZ.Nw(state.getItemCount())) {
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
                } else if (eaF() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.nMe = true;
            aVar.nMc = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View Ns;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            Ns = Nt(state.getItemCount());
        } else {
            Ns = Ns(state.getItemCount());
        }
        if (Ns != null) {
            aVar.dJ(Ns);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(Ns) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(Ns) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View Ns(int i) {
        if ($assertionsDisabled || this.nLS.nLA != null) {
            View ak = ak(0, getChildCount(), i);
            if (ak == null) {
                return null;
            }
            int i2 = this.nLS.nLA[getPosition(ak)];
            if (i2 != -1) {
                return a(ak, this.nLD.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View Nt(int i) {
        if ($assertionsDisabled || this.nLS.nLA != null) {
            View ak = ak(getChildCount() - 1, -1, i);
            if (ak == null) {
                return null;
            }
            return b(ak, this.nLD.get(this.nLS.nLA[getPosition(ak)]));
        }
        throw new AssertionError();
    }

    private View ak(int i, int i2, int i3) {
        View view;
        View view2 = null;
        eaR();
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
        boolean eaF = eaF();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.nLW.mInfinite) && bVar.a(state, this.nLD)) {
                com.google.android.flexbox.b bVar2 = this.nLD.get(bVar.nMc);
                bVar.mPosition = bVar2.nLw;
                i4 += a(bVar2, bVar);
                if (eaF || !this.mIsRtl) {
                    bVar.mOffset += bVar2.eaL() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.eaL() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.eaL();
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
        if (!bVar.nMg) {
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
            if (!$assertionsDisabled && this.nLS.nLA == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.nLS.nLA[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.nLD.get(i);
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!B(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.nLx == getPosition(childAt)) {
                            if (i >= this.nLD.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.nLD.get(i4);
                            i2 = i3;
                        }
                        i3++;
                    }
                    recycleChildren(recycler, 0, i2);
                }
            }
        }
    }

    private boolean B(View view, int i) {
        return (eaF() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.nLS.nLA == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.nLS.nLA[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.nLD.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!C(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.nLw == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.nLD.get(i4);
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

    private boolean C(View view, int i) {
        return (eaF() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return eaF() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.nLS.nLB != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.nLp : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.nLH) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.nLn) + paddingRight;
                    f2 = bVar.nLn - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.nLn) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.nLn) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.nLn) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.nLn) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.nLn) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.nLH);
            }
            float f4 = f - this.nLX.nMd;
            float f5 = f2 - this.nLX.nMd;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View Nd = Nd(i6);
                if (Nd == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Nd, nLU);
                        addView(Nd);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(Nd, nLU);
                        addView(Nd, i5);
                        i = i5 + 1;
                    }
                    long j = this.nLS.nLB[i6];
                    int gN = this.nLS.gN(j);
                    int gO = this.nLS.gO(j);
                    if (shouldMeasureChild(Nd, gN, gO, (LayoutParams) Nd.getLayoutParams())) {
                        Nd.measure(gN, gO);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(Nd);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(Nd));
                    int topDecorationHeight = i3 + getTopDecorationHeight(Nd);
                    if (this.mIsRtl) {
                        this.nLS.a(Nd, bVar, Math.round(rightDecorationWidth) - Nd.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + Nd.getMeasuredHeight());
                    } else {
                        this.nLS.a(Nd, bVar, Math.round(leftDecorationWidth), topDecorationHeight, Nd.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + Nd.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + Nd.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(Nd) + max;
                    measuredWidth2 = rightDecorationWidth - (((Nd.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(Nd)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.nMc += this.nLW.mLayoutDirection;
            return bVar.eaL();
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
        if ($assertionsDisabled || this.nLS.nLB != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.nLp;
                i = i5 + bVar.nLp;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.nLH) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.nLn) + paddingBottom;
                    f2 = bVar.nLn - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.nLn) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.nLn) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.nLn) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.nLn) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.nLn) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.nLH);
            }
            float f4 = f - this.nLX.nMd;
            float f5 = f2 - this.nLX.nMd;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View Nd = Nd(i9);
                if (Nd == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.nLS.nLB[i9];
                    int gN = this.nLS.gN(j);
                    int gO = this.nLS.gO(j);
                    if (shouldMeasureChild(Nd, gN, gO, (LayoutParams) Nd.getLayoutParams())) {
                        Nd.measure(gN, gO);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(Nd);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(Nd));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(Nd, nLU);
                        addView(Nd);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(Nd, nLU);
                        addView(Nd, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(Nd);
                    int rightDecorationWidth = i - getRightDecorationWidth(Nd);
                    if (this.mIsRtl) {
                        if (this.nLV) {
                            this.nLS.a(Nd, bVar, this.mIsRtl, rightDecorationWidth - Nd.getMeasuredWidth(), Math.round(bottomDecorationHeight) - Nd.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.nLS.a(Nd, bVar, this.mIsRtl, rightDecorationWidth - Nd.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Nd.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.nLV) {
                        this.nLS.a(Nd, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - Nd.getMeasuredHeight(), leftDecorationWidth + Nd.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.nLS.a(Nd, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + Nd.getMeasuredWidth(), Nd.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((Nd.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(Nd)) + max);
                    measuredHeight2 = topDecorationHeight + Nd.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(Nd) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.nMc += this.nLW.mLayoutDirection;
            return bVar.eaL();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean eaF() {
        return this.nLF == 0 || this.nLF == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            eaQ();
        } else {
            this.nLW.mInfinite = false;
        }
        if (!eaF() && this.mIsRtl) {
            this.nLW.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.nLW.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.nLW.mPosition = aVar.mPosition;
        this.nLW.mItemDirection = 1;
        this.nLW.mLayoutDirection = 1;
        this.nLW.mOffset = aVar.mCoordinate;
        this.nLW.mScrollingOffset = Integer.MIN_VALUE;
        this.nLW.nMc = aVar.nMc;
        if (z && this.nLD.size() > 1 && aVar.nMc >= 0 && aVar.nMc < this.nLD.size() - 1) {
            b.i(this.nLW);
            b bVar = this.nLW;
            bVar.mPosition = this.nLD.get(aVar.nMc).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            eaQ();
        } else {
            this.nLW.mInfinite = false;
        }
        if (!eaF() && this.mIsRtl) {
            this.nLW.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.nLW.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.nLW.mPosition = aVar.mPosition;
        this.nLW.mItemDirection = 1;
        this.nLW.mLayoutDirection = -1;
        this.nLW.mOffset = aVar.mCoordinate;
        this.nLW.mScrollingOffset = Integer.MIN_VALUE;
        this.nLW.nMc = aVar.nMc;
        if (z && aVar.nMc > 0 && this.nLD.size() > aVar.nMc) {
            b.j(this.nLW);
            this.nLW.mPosition -= this.nLD.get(aVar.nMc).getItemCount();
        }
    }

    private void eaQ() {
        int widthMode;
        if (eaF()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.nLW.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void eaR() {
        if (this.mOrientationHelper == null) {
            if (eaF()) {
                if (this.nLG == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.nLY = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.nLY = OrientationHelper.createHorizontalHelper(this);
            } else if (this.nLG == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.nLY = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.nLY = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.nLW == null) {
            this.nLW = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.nLZ != null) {
            this.nLZ.invalidateAnchor();
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
        return !eaF() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return eaF() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!eaF()) {
            int a2 = a(i, recycler, state);
            this.nMa.clear();
            return a2;
        }
        int Nu = Nu(i);
        this.nLX.nMd += Nu;
        this.nLY.offsetChildren(-Nu);
        return Nu;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (eaF()) {
            int a2 = a(i, recycler, state);
            this.nMa.clear();
            return a2;
        }
        int Nu = Nu(i);
        this.nLX.nMd += Nu;
        this.nLY.offsetChildren(-Nu);
        return Nu;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        eaR();
        this.nLW.nMg = true;
        boolean z = !eaF() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        dU(i2, abs);
        int a2 = this.nLW.mScrollingOffset + a(recycler, state, this.nLW);
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
        this.nLW.mLastScrollDelta = i;
        return i;
    }

    private int Nu(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        eaR();
        boolean eaF = eaF();
        int width = eaF ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = eaF ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.nLX.nMd) - width, abs);
            }
            if (this.nLX.nMd + i <= 0) {
                return i;
            }
            return -this.nLX.nMd;
        } else if (i > 0) {
            return Math.min((width2 - this.nLX.nMd) - width, i);
        } else {
            if (this.nLX.nMd + i >= 0) {
                return i;
            }
            return -this.nLX.nMd;
        }
    }

    private void dU(int i, int i2) {
        if (!$assertionsDisabled && this.nLS.nLA == null) {
            throw new AssertionError();
        }
        this.nLW.mLayoutDirection = i;
        boolean eaF = eaF();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !eaF && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.nLW.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.nLD.get(this.nLS.nLA[position]));
            this.nLW.mItemDirection = 1;
            this.nLW.mPosition = this.nLW.mItemDirection + position;
            if (this.nLS.nLA.length <= this.nLW.mPosition) {
                this.nLW.nMc = -1;
            } else {
                this.nLW.nMc = this.nLS.nLA[this.nLW.mPosition];
            }
            if (z) {
                this.nLW.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.nLW.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.nLW.mScrollingOffset = this.nLW.mScrollingOffset >= 0 ? this.nLW.mScrollingOffset : 0;
            } else {
                this.nLW.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.nLW.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.nLW.nMc == -1 || this.nLW.nMc > this.nLD.size() - 1) && this.nLW.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.nLW.mScrollingOffset;
                this.nLT.reset();
                if (i3 > 0) {
                    if (eaF) {
                        this.nLS.a(this.nLT, makeMeasureSpec, makeMeasureSpec2, i3, this.nLW.mPosition, this.nLD);
                    } else {
                        this.nLS.c(this.nLT, makeMeasureSpec, makeMeasureSpec2, i3, this.nLW.mPosition, this.nLD);
                    }
                    this.nLS.ai(makeMeasureSpec, makeMeasureSpec2, this.nLW.mPosition);
                    this.nLS.Nh(this.nLW.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.nLW.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.nLD.get(this.nLS.nLA[position2]));
            this.nLW.mItemDirection = 1;
            int i4 = this.nLS.nLA[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.nLW.mPosition = position2 - this.nLD.get(i5 - 1).getItemCount();
            } else {
                this.nLW.mPosition = -1;
            }
            this.nLW.nMc = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.nLW.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.nLW.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.nLW.mScrollingOffset = this.nLW.mScrollingOffset >= 0 ? this.nLW.mScrollingOffset : 0;
            } else {
                this.nLW.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.nLW.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.nLW.mAvailable = i2 - this.nLW.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean eaF = eaF();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !eaF) {
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
        boolean eaF = eaF();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !eaF) {
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
        eaR();
        View Ns = Ns(itemCount);
        View Nt = Nt(itemCount);
        if (state.getItemCount() == 0 || Ns == null || Nt == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(Nt) - this.mOrientationHelper.getDecoratedStart(Ns));
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
        View Ns = Ns(itemCount);
        View Nt = Nt(itemCount);
        if (state.getItemCount() == 0 || Ns == null || Nt == null) {
            return 0;
        }
        if ($assertionsDisabled || this.nLS.nLA != null) {
            int position = getPosition(Ns);
            int position2 = getPosition(Nt);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(Nt) - this.mOrientationHelper.getDecoratedStart(Ns));
            int i = this.nLS.nLA[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.nLS.nLA[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(Ns)));
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
        View Ns = Ns(itemCount);
        View Nt = Nt(itemCount);
        if (state.getItemCount() == 0 || Ns == null || Nt == null) {
            return 0;
        }
        if ($assertionsDisabled || this.nLS.nLA != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(Nt) - this.mOrientationHelper.getDecoratedStart(Ns)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int dF(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int dG(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int dH(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int dI(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean o(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int dF = dF(view);
        int dH = dH(view);
        int dG = dG(view);
        int dI = dI(view);
        return z ? (paddingLeft <= dF && width >= dG) && (paddingTop <= dH && height >= dI) : (dF >= width || dG >= paddingLeft) && (dH >= height || dI >= paddingTop);
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

    /* loaded from: classes12.dex */
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
            /* renamed from: Nv */
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
        public int eaG() {
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
        public boolean eaH() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float eaI() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eaJ() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int eaK() {
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
    /* loaded from: classes12.dex */
    public class a {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int mCoordinate;
        private boolean mLayoutFromEnd;
        private int mPosition;
        private boolean mValid;
        private int nMc;
        private int nMd;
        private boolean nMe;
        final /* synthetic */ FlexboxLayoutManager nMf;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.nMc = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.nMe = false;
            if (this.nMf.eaF()) {
                if (this.nMf.nLG == 0) {
                    this.mLayoutFromEnd = this.nMf.nLF == 1;
                } else {
                    this.mLayoutFromEnd = this.nMf.nLG == 2;
                }
            } else if (this.nMf.nLG == 0) {
                this.mLayoutFromEnd = this.nMf.nLF == 3;
            } else {
                this.mLayoutFromEnd = this.nMf.nLG == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.nMf.eaF() && this.nMf.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.nMf.mOrientationHelper.getEndAfterPadding() : this.nMf.getWidth() - this.nMf.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.nMf.mOrientationHelper.getEndAfterPadding() : this.nMf.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJ(View view) {
            if (!this.nMf.eaF() && this.nMf.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.nMf.mOrientationHelper.getDecoratedStart(view) + this.nMf.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.nMf.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.nMf.mOrientationHelper.getDecoratedEnd(view) + this.nMf.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.nMf.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.nMf.getPosition(view);
            this.nMe = false;
            if (!$assertionsDisabled && this.nMf.nLS.nLA == null) {
                throw new AssertionError();
            }
            int i = this.nMf.nLS.nLA[this.mPosition != -1 ? this.mPosition : 0];
            this.nMc = i != -1 ? i : 0;
            if (this.nMf.nLD.size() > this.nMc) {
                this.mPosition = ((com.google.android.flexbox.b) this.nMf.nLD.get(this.nMc)).nLw;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.nMc + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.nMd + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.nMe + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class b {
        private int mAvailable;
        private boolean mInfinite;
        private int mItemDirection;
        private int mLastScrollDelta;
        private int mLayoutDirection;
        private int mOffset;
        private int mPosition;
        private int mScrollingOffset;
        private int nMc;
        private boolean nMg;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.nMc;
            bVar.nMc = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.nMc;
            bVar.nMc = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.nMc >= 0 && this.nMc < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.nMc + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
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
            /* renamed from: Nx */
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
        public boolean Nw(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
