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
    private static final Rect pbY;
    private int hMW;
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
    private List<com.google.android.flexbox.b> pbH;
    private int pbJ;
    private int pbK;
    private int pbL;
    private int pbM;
    private final c pbW;
    private c.a pbX;
    private boolean pbZ;
    private b pca;
    private a pcb;
    private OrientationHelper pcc;
    private SavedState pcd;
    private SparseArray<View> pce;
    private int pcf;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        pbY = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.pbJ;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.pbK;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.pbM;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.hMW;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view, int i, int i2) {
        return esf() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dY(View view) {
        return esf() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, pbY);
        if (esf()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.pbr += leftDecorationWidth;
            bVar.pbs = leftDecorationWidth + bVar.pbs;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.pbr += topDecorationHeight;
        bVar.pbs = topDecorationHeight + bVar.pbs;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View PV(int i) {
        View view = this.pce.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View PW(int i) {
        return PV(i);
    }

    @Override // com.google.android.flexbox.a
    public void a(com.google.android.flexbox.b bVar) {
    }

    @Override // com.google.android.flexbox.a
    public int ah(int i, int i2, int i3) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int ai(int i, int i2, int i3) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.pbH.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.pbH.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.pbH.get(i2).pbr);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.pbH.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.pbH.get(i2).pbt;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.pbH = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.pbH;
    }

    @Override // com.google.android.flexbox.a
    public void n(int i, View view) {
        this.pce.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (esf()) {
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
        if (this.pcd != null) {
            return new SavedState(this.pcd);
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
            this.pcd = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        Qi(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        Qi(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        Qi(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        Qi(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        Qi(Math.min(i, i2));
    }

    private void Qi(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.pbW.Qb(childCount);
            this.pbW.Qa(childCount);
            this.pbW.Qc(childCount);
            if (!$assertionsDisabled && this.pbW.pbE == null) {
                throw new AssertionError();
            }
            if (i < this.pbW.pbE.length) {
                this.pcf = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!esf() && this.mIsRtl) {
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
            esp();
            esr();
            ensureLayoutState();
            this.pbW.Qb(itemCount);
            this.pbW.Qa(itemCount);
            this.pbW.Qc(itemCount);
            this.pca.pck = false;
            if (this.pcd != null && this.pcd.Qo(itemCount)) {
                this.mPendingScrollPosition = this.pcd.mAnchorPosition;
            }
            if (!this.pcb.mValid || this.mPendingScrollPosition != -1 || this.pcd != null) {
                this.pcb.reset();
                a(state, this.pcb);
                this.pcb.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.pcb.mLayoutFromEnd) {
                b(this.pcb, false, true);
            } else {
                a(this.pcb, false, true);
            }
            Qj(itemCount);
            if (this.pcb.mLayoutFromEnd) {
                a(recycler, state, this.pca);
                i2 = this.pca.mOffset;
                a(this.pcb, true, false);
                a(recycler, state, this.pca);
                i = this.pca.mOffset;
            } else {
                a(recycler, state, this.pca);
                i = this.pca.mOffset;
                b(this.pcb, true, false);
                a(recycler, state, this.pca);
                i2 = this.pca.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.pcb.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!esf() && this.mIsRtl) {
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
        if (!esf() && this.mIsRtl) {
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

    private void Qj(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (esf()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.pca.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.pca.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.pca.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.pca.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.pcf != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.pcf != -1 ? Math.min(this.pcf, this.pcb.mPosition) : this.pcb.mPosition;
            this.pbX.reset();
            if (esf()) {
                if (this.pbH.size() > 0) {
                    this.pbW.B(this.pbH, min);
                    this.pbW.a(this.pbX, makeMeasureSpec, makeMeasureSpec2, i3, min, this.pcb.mPosition, this.pbH);
                } else {
                    this.pbW.Qc(i);
                    this.pbW.a(this.pbX, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.pbH);
                }
            } else if (this.pbH.size() > 0) {
                this.pbW.B(this.pbH, min);
                this.pbW.a(this.pbX, makeMeasureSpec2, makeMeasureSpec, i3, min, this.pcb.mPosition, this.pbH);
            } else {
                this.pbW.Qc(i);
                this.pbW.c(this.pbX, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.pbH);
            }
            this.pbH = this.pbX.pbH;
            this.pbW.aj(makeMeasureSpec, makeMeasureSpec2, min);
            this.pbW.PZ(min);
        } else if (!this.pcb.mLayoutFromEnd) {
            this.pbH.clear();
            if (!$assertionsDisabled && this.pbW.pbE == null) {
                throw new AssertionError();
            }
            this.pbX.reset();
            if (esf()) {
                this.pbW.b(this.pbX, makeMeasureSpec, makeMeasureSpec2, i3, this.pcb.mPosition, this.pbH);
            } else {
                this.pbW.d(this.pbX, makeMeasureSpec, makeMeasureSpec2, i3, this.pcb.mPosition, this.pbH);
            }
            this.pbH = this.pbX.pbH;
            this.pbW.ec(makeMeasureSpec, makeMeasureSpec2);
            this.pbW.esn();
            this.pcb.pcg = this.pbW.pbE[this.pcb.mPosition];
            this.pca.pcg = this.pcb.pcg;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.pcd = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.pcf = -1;
        this.pcb.reset();
        this.pce.clear();
    }

    private void esp() {
        int layoutDirection = getLayoutDirection();
        switch (this.pbJ) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.pbZ = this.pbK == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.pbZ = this.pbK == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.pbK == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.pbZ = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.pbK == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.pbZ = true;
                return;
            default:
                this.mIsRtl = false;
                this.pbZ = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.pcd) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.pcg = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.pbW.pbE != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.pcg = this.pbW.pbE[aVar.mPosition];
            if (this.pcd == null || !this.pcd.Qo(state.getItemCount())) {
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
                } else if (esf() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.pci = true;
            aVar.pcg = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View Qk;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            Qk = Ql(state.getItemCount());
        } else {
            Qk = Qk(state.getItemCount());
        }
        if (Qk != null) {
            aVar.ed(Qk);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(Qk) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(Qk) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View Qk(int i) {
        if ($assertionsDisabled || this.pbW.pbE != null) {
            View al = al(0, getChildCount(), i);
            if (al == null) {
                return null;
            }
            int i2 = this.pbW.pbE[getPosition(al)];
            if (i2 != -1) {
                return a(al, this.pbH.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View Ql(int i) {
        if ($assertionsDisabled || this.pbW.pbE != null) {
            View al = al(getChildCount() - 1, -1, i);
            if (al == null) {
                return null;
            }
            return b(al, this.pbH.get(this.pbW.pbE[getPosition(al)]));
        }
        throw new AssertionError();
    }

    private View al(int i, int i2, int i3) {
        View view;
        View view2 = null;
        esr();
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
        boolean esf = esf();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.pca.mInfinite) && bVar.a(state, this.pbH)) {
                com.google.android.flexbox.b bVar2 = this.pbH.get(bVar.pcg);
                bVar.mPosition = bVar2.pbA;
                i4 += a(bVar2, bVar);
                if (esf || !this.mIsRtl) {
                    bVar.mOffset += bVar2.esl() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.esl() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.esl();
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
        if (!bVar.pck) {
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
            if (!$assertionsDisabled && this.pbW.pbE == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.pbW.pbE[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.pbH.get(i);
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!G(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.pbB == getPosition(childAt)) {
                            if (i >= this.pbH.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.pbH.get(i4);
                            i2 = i3;
                        }
                        i3++;
                    }
                    recycleChildren(recycler, 0, i2);
                }
            }
        }
    }

    private boolean G(View view, int i) {
        return (esf() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.pbW.pbE == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.pbW.pbE[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.pbH.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!H(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.pbA == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.pbH.get(i4);
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

    private boolean H(View view, int i) {
        return (esf() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return esf() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.pbW.pbF != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.pbt : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.pbL) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.pbr) + paddingRight;
                    f2 = bVar.pbr - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.pbr) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.pbr) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.pbr) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.pbr) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.pbr) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.pbL);
            }
            float f4 = f - this.pcb.pch;
            float f5 = f2 - this.pcb.pch;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View PV = PV(i6);
                if (PV == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(PV, pbY);
                        addView(PV);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(PV, pbY);
                        addView(PV, i5);
                        i = i5 + 1;
                    }
                    long j = this.pbW.pbF[i6];
                    int hR = this.pbW.hR(j);
                    int hS = this.pbW.hS(j);
                    if (shouldMeasureChild(PV, hR, hS, (LayoutParams) PV.getLayoutParams())) {
                        PV.measure(hR, hS);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(PV);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(PV));
                    int topDecorationHeight = i3 + getTopDecorationHeight(PV);
                    if (this.mIsRtl) {
                        this.pbW.a(PV, bVar, Math.round(rightDecorationWidth) - PV.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + PV.getMeasuredHeight());
                    } else {
                        this.pbW.a(PV, bVar, Math.round(leftDecorationWidth), topDecorationHeight, PV.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + PV.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + PV.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(PV) + max;
                    measuredWidth2 = rightDecorationWidth - (((PV.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(PV)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.pcg += this.pca.mLayoutDirection;
            return bVar.esl();
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
        if ($assertionsDisabled || this.pbW.pbF != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.pbt;
                i = i5 + bVar.pbt;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.pbL) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.pbr) + paddingBottom;
                    f2 = bVar.pbr - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.pbr) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.pbr) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.pbr) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.pbr) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.pbr) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.pbL);
            }
            float f4 = f - this.pcb.pch;
            float f5 = f2 - this.pcb.pch;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View PV = PV(i9);
                if (PV == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.pbW.pbF[i9];
                    int hR = this.pbW.hR(j);
                    int hS = this.pbW.hS(j);
                    if (shouldMeasureChild(PV, hR, hS, (LayoutParams) PV.getLayoutParams())) {
                        PV.measure(hR, hS);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(PV);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(PV));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(PV, pbY);
                        addView(PV);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(PV, pbY);
                        addView(PV, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(PV);
                    int rightDecorationWidth = i - getRightDecorationWidth(PV);
                    if (this.mIsRtl) {
                        if (this.pbZ) {
                            this.pbW.a(PV, bVar, this.mIsRtl, rightDecorationWidth - PV.getMeasuredWidth(), Math.round(bottomDecorationHeight) - PV.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.pbW.a(PV, bVar, this.mIsRtl, rightDecorationWidth - PV.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, PV.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.pbZ) {
                        this.pbW.a(PV, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - PV.getMeasuredHeight(), leftDecorationWidth + PV.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.pbW.a(PV, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + PV.getMeasuredWidth(), PV.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((PV.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(PV)) + max);
                    measuredHeight2 = topDecorationHeight + PV.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(PV) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.pcg += this.pca.mLayoutDirection;
            return bVar.esl();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean esf() {
        return this.pbJ == 0 || this.pbJ == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            esq();
        } else {
            this.pca.mInfinite = false;
        }
        if (!esf() && this.mIsRtl) {
            this.pca.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.pca.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.pca.mPosition = aVar.mPosition;
        this.pca.mItemDirection = 1;
        this.pca.mLayoutDirection = 1;
        this.pca.mOffset = aVar.mCoordinate;
        this.pca.mScrollingOffset = Integer.MIN_VALUE;
        this.pca.pcg = aVar.pcg;
        if (z && this.pbH.size() > 1 && aVar.pcg >= 0 && aVar.pcg < this.pbH.size() - 1) {
            b.i(this.pca);
            b bVar = this.pca;
            bVar.mPosition = this.pbH.get(aVar.pcg).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            esq();
        } else {
            this.pca.mInfinite = false;
        }
        if (!esf() && this.mIsRtl) {
            this.pca.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.pca.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.pca.mPosition = aVar.mPosition;
        this.pca.mItemDirection = 1;
        this.pca.mLayoutDirection = -1;
        this.pca.mOffset = aVar.mCoordinate;
        this.pca.mScrollingOffset = Integer.MIN_VALUE;
        this.pca.pcg = aVar.pcg;
        if (z && aVar.pcg > 0 && this.pbH.size() > aVar.pcg) {
            b.j(this.pca);
            this.pca.mPosition -= this.pbH.get(aVar.pcg).getItemCount();
        }
    }

    private void esq() {
        int widthMode;
        if (esf()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.pca.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void esr() {
        if (this.mOrientationHelper == null) {
            if (esf()) {
                if (this.pbK == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.pcc = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.pcc = OrientationHelper.createHorizontalHelper(this);
            } else if (this.pbK == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.pcc = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.pcc = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.pca == null) {
            this.pca = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.pcd != null) {
            this.pcd.invalidateAnchor();
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
        return !esf() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return esf() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!esf()) {
            int a2 = a(i, recycler, state);
            this.pce.clear();
            return a2;
        }
        int Qm = Qm(i);
        this.pcb.pch += Qm;
        this.pcc.offsetChildren(-Qm);
        return Qm;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (esf()) {
            int a2 = a(i, recycler, state);
            this.pce.clear();
            return a2;
        }
        int Qm = Qm(i);
        this.pcb.pch += Qm;
        this.pcc.offsetChildren(-Qm);
        return Qm;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        esr();
        this.pca.pck = true;
        boolean z = !esf() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        eg(i2, abs);
        int a2 = this.pca.mScrollingOffset + a(recycler, state, this.pca);
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
        this.pca.mLastScrollDelta = i;
        return i;
    }

    private int Qm(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        esr();
        boolean esf = esf();
        int width = esf ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = esf ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.pcb.pch) - width, abs);
            }
            if (this.pcb.pch + i <= 0) {
                return i;
            }
            return -this.pcb.pch;
        } else if (i > 0) {
            return Math.min((width2 - this.pcb.pch) - width, i);
        } else {
            if (this.pcb.pch + i >= 0) {
                return i;
            }
            return -this.pcb.pch;
        }
    }

    private void eg(int i, int i2) {
        if (!$assertionsDisabled && this.pbW.pbE == null) {
            throw new AssertionError();
        }
        this.pca.mLayoutDirection = i;
        boolean esf = esf();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !esf && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.pca.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.pbH.get(this.pbW.pbE[position]));
            this.pca.mItemDirection = 1;
            this.pca.mPosition = this.pca.mItemDirection + position;
            if (this.pbW.pbE.length <= this.pca.mPosition) {
                this.pca.pcg = -1;
            } else {
                this.pca.pcg = this.pbW.pbE[this.pca.mPosition];
            }
            if (z) {
                this.pca.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.pca.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.pca.mScrollingOffset = this.pca.mScrollingOffset >= 0 ? this.pca.mScrollingOffset : 0;
            } else {
                this.pca.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.pca.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.pca.pcg == -1 || this.pca.pcg > this.pbH.size() - 1) && this.pca.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.pca.mScrollingOffset;
                this.pbX.reset();
                if (i3 > 0) {
                    if (esf) {
                        this.pbW.a(this.pbX, makeMeasureSpec, makeMeasureSpec2, i3, this.pca.mPosition, this.pbH);
                    } else {
                        this.pbW.c(this.pbX, makeMeasureSpec, makeMeasureSpec2, i3, this.pca.mPosition, this.pbH);
                    }
                    this.pbW.aj(makeMeasureSpec, makeMeasureSpec2, this.pca.mPosition);
                    this.pbW.PZ(this.pca.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.pca.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.pbH.get(this.pbW.pbE[position2]));
            this.pca.mItemDirection = 1;
            int i4 = this.pbW.pbE[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.pca.mPosition = position2 - this.pbH.get(i5 - 1).getItemCount();
            } else {
                this.pca.mPosition = -1;
            }
            this.pca.pcg = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.pca.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.pca.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.pca.mScrollingOffset = this.pca.mScrollingOffset >= 0 ? this.pca.mScrollingOffset : 0;
            } else {
                this.pca.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.pca.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.pca.mAvailable = i2 - this.pca.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean esf = esf();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !esf) {
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
        boolean esf = esf();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !esf) {
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
        esr();
        View Qk = Qk(itemCount);
        View Ql = Ql(itemCount);
        if (state.getItemCount() == 0 || Qk == null || Ql == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(Ql) - this.mOrientationHelper.getDecoratedStart(Qk));
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
        View Qk = Qk(itemCount);
        View Ql = Ql(itemCount);
        if (state.getItemCount() == 0 || Qk == null || Ql == null) {
            return 0;
        }
        if ($assertionsDisabled || this.pbW.pbE != null) {
            int position = getPosition(Qk);
            int position2 = getPosition(Ql);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(Ql) - this.mOrientationHelper.getDecoratedStart(Qk));
            int i = this.pbW.pbE[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.pbW.pbE[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(Qk)));
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
        View Qk = Qk(itemCount);
        View Ql = Ql(itemCount);
        if (state.getItemCount() == 0 || Qk == null || Ql == null) {
            return 0;
        }
        if ($assertionsDisabled || this.pbW.pbE != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(Ql) - this.mOrientationHelper.getDecoratedStart(Qk)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int dZ(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int ea(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int eb(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int ec(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean q(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int dZ = dZ(view);
        int eb = eb(view);
        int ea = ea(view);
        int ec = ec(view);
        return z ? (paddingLeft <= dZ && width >= ea) && (paddingTop <= eb && height >= ec) : (dZ >= width || ea >= paddingLeft) && (eb >= height || ec >= paddingTop);
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
            if (q(childAt, z)) {
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
            /* renamed from: ao */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Qn */
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
        public int esg() {
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
        public boolean esh() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float esi() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int esj() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int esk() {
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
        private int pcg;
        private int pch;
        private boolean pci;
        final /* synthetic */ FlexboxLayoutManager pcj;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.pcg = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.pci = false;
            if (this.pcj.esf()) {
                if (this.pcj.pbK == 0) {
                    this.mLayoutFromEnd = this.pcj.pbJ == 1;
                } else {
                    this.mLayoutFromEnd = this.pcj.pbK == 2;
                }
            } else if (this.pcj.pbK == 0) {
                this.mLayoutFromEnd = this.pcj.pbJ == 3;
            } else {
                this.mLayoutFromEnd = this.pcj.pbK == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.pcj.esf() && this.pcj.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.pcj.mOrientationHelper.getEndAfterPadding() : this.pcj.getWidth() - this.pcj.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.pcj.mOrientationHelper.getEndAfterPadding() : this.pcj.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ed(View view) {
            if (!this.pcj.esf() && this.pcj.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.pcj.mOrientationHelper.getDecoratedStart(view) + this.pcj.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.pcj.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.pcj.mOrientationHelper.getDecoratedEnd(view) + this.pcj.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.pcj.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.pcj.getPosition(view);
            this.pci = false;
            if (!$assertionsDisabled && this.pcj.pbW.pbE == null) {
                throw new AssertionError();
            }
            int i = this.pcj.pbW.pbE[this.mPosition != -1 ? this.mPosition : 0];
            this.pcg = i != -1 ? i : 0;
            if (this.pcj.pbH.size() > this.pcg) {
                this.mPosition = ((com.google.android.flexbox.b) this.pcj.pbH.get(this.pcg)).pbA;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.pcg + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.pch + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.pci + '}';
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
        private int pcg;
        private boolean pck;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.pcg;
            bVar.pcg = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.pcg;
            bVar.pcg = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.pcg >= 0 && this.pcg < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.pcg + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ap */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Qp */
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
        public boolean Qo(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
