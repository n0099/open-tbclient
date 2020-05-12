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
    private static final Rect miA;
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
    private boolean miB;
    private b miC;
    private a miD;
    private OrientationHelper miE;
    private SavedState miF;
    private SparseArray<View> miG;
    private int miH;
    private List<com.google.android.flexbox.b> mih;
    private int mij;
    private int mik;
    private int mil;
    private int mim;
    private int mip;
    private final c miy;
    private c.a miz;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        miA = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mij;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mik;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mim;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mip;
    }

    @Override // com.google.android.flexbox.a
    public int h(View view, int i, int i2) {
        return duZ() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dj(View view) {
        return duZ() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, miA);
        if (duZ()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.mhQ += leftDecorationWidth;
            bVar.mhR = leftDecorationWidth + bVar.mhR;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.mhQ += topDecorationHeight;
        bVar.mhR = topDecorationHeight + bVar.mhR;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View HE(int i) {
        View view = this.miG.get(i);
        return view != null ? view : this.mRecycler.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.a
    public View HF(int i) {
        return HE(i);
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
        if (this.mih.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.mih.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mih.get(i2).mhQ);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mih.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mih.get(i2).mhS;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.mih = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.mih;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
        this.miG.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (duZ()) {
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
        if (this.miF != null) {
            return new SavedState(this.miF);
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
            this.miF = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        HR(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        HR(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        HR(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        HR(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        HR(Math.min(i, i2));
    }

    private void HR(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.miy.HK(childCount);
            this.miy.HJ(childCount);
            this.miy.HL(childCount);
            if (!$assertionsDisabled && this.miy.mie == null) {
                throw new AssertionError();
            }
            if (i < this.miy.mie.length) {
                this.miH = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!duZ() && this.mIsRtl) {
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
            dvj();
            dvl();
            ensureLayoutState();
            this.miy.HK(itemCount);
            this.miy.HJ(itemCount);
            this.miy.HL(itemCount);
            this.miC.miM = false;
            if (this.miF != null && this.miF.HX(itemCount)) {
                this.mPendingScrollPosition = this.miF.mAnchorPosition;
            }
            if (!this.miD.mValid || this.mPendingScrollPosition != -1 || this.miF != null) {
                this.miD.reset();
                a(state, this.miD);
                this.miD.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.miD.mLayoutFromEnd) {
                b(this.miD, false, true);
            } else {
                a(this.miD, false, true);
            }
            HS(itemCount);
            if (this.miD.mLayoutFromEnd) {
                a(recycler, state, this.miC);
                i2 = this.miC.mOffset;
                a(this.miD, true, false);
                a(recycler, state, this.miC);
                i = this.miC.mOffset;
            } else {
                a(recycler, state, this.miC);
                i = this.miC.mOffset;
                b(this.miD, true, false);
                a(recycler, state, this.miC);
                i2 = this.miC.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.miD.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!duZ() && this.mIsRtl) {
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
        if (!duZ() && this.mIsRtl) {
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

    private void HS(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (duZ()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.miC.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.miC.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.miC.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.miC.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.miH != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.miH != -1 ? Math.min(this.miH, this.miD.mPosition) : this.miD.mPosition;
            this.miz.reset();
            if (duZ()) {
                if (this.mih.size() > 0) {
                    this.miy.s(this.mih, min);
                    this.miy.a(this.miz, makeMeasureSpec, makeMeasureSpec2, i3, min, this.miD.mPosition, this.mih);
                } else {
                    this.miy.HL(i);
                    this.miy.a(this.miz, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mih);
                }
            } else if (this.mih.size() > 0) {
                this.miy.s(this.mih, min);
                this.miy.a(this.miz, makeMeasureSpec2, makeMeasureSpec, i3, min, this.miD.mPosition, this.mih);
            } else {
                this.miy.HL(i);
                this.miy.c(this.miz, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mih);
            }
            this.mih = this.miz.mih;
            this.miy.ai(makeMeasureSpec, makeMeasureSpec2, min);
            this.miy.HI(min);
        } else if (!this.miD.mLayoutFromEnd) {
            this.mih.clear();
            if (!$assertionsDisabled && this.miy.mie == null) {
                throw new AssertionError();
            }
            this.miz.reset();
            if (duZ()) {
                this.miy.b(this.miz, makeMeasureSpec, makeMeasureSpec2, i3, this.miD.mPosition, this.mih);
            } else {
                this.miy.d(this.miz, makeMeasureSpec, makeMeasureSpec2, i3, this.miD.mPosition, this.mih);
            }
            this.mih = this.miz.mih;
            this.miy.m39do(makeMeasureSpec, makeMeasureSpec2);
            this.miy.dvh();
            this.miD.miI = this.miy.mie[this.miD.mPosition];
            this.miC.miI = this.miD.miI;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.miF = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.miH = -1;
        this.miD.reset();
        this.miG.clear();
    }

    private void dvj() {
        int layoutDirection = getLayoutDirection();
        switch (this.mij) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.miB = this.mik == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.miB = this.mik == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.mik == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.miB = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.mik == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.miB = true;
                return;
            default:
                this.mIsRtl = false;
                this.miB = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.miF) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.miI = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.miy.mie != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.miI = this.miy.mie[aVar.mPosition];
            if (this.miF == null || !this.miF.HX(state.getItemCount())) {
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
                } else if (duZ() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.miK = true;
            aVar.miI = -1;
            return true;
        }
        throw new AssertionError();
    }

    private boolean b(RecyclerView.State state, a aVar) {
        View HT;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.mLayoutFromEnd) {
            HT = HU(state.getItemCount());
        } else {
            HT = HT(state.getItemCount());
        }
        if (HT != null) {
            aVar.m38do(HT);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(HT) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(HT) < this.mOrientationHelper.getStartAfterPadding()) {
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

    private View HT(int i) {
        if ($assertionsDisabled || this.miy.mie != null) {
            View ak = ak(0, getChildCount(), i);
            if (ak == null) {
                return null;
            }
            int i2 = this.miy.mie[getPosition(ak)];
            if (i2 != -1) {
                return a(ak, this.mih.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View HU(int i) {
        if ($assertionsDisabled || this.miy.mie != null) {
            View ak = ak(getChildCount() - 1, -1, i);
            if (ak == null) {
                return null;
            }
            return b(ak, this.mih.get(this.miy.mie[getPosition(ak)]));
        }
        throw new AssertionError();
    }

    private View ak(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dvl();
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
        boolean duZ = duZ();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.miC.mInfinite) && bVar.a(state, this.mih)) {
                com.google.android.flexbox.b bVar2 = this.mih.get(bVar.miI);
                bVar.mPosition = bVar2.mhZ;
                i4 += a(bVar2, bVar);
                if (duZ || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dvf() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dvf() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dvf();
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
        if (!bVar.miM) {
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
            if (!$assertionsDisabled && this.miy.mie == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.miy.mie[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.mih.get(i);
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
                        if (bVar2.mia == getPosition(childAt)) {
                            if (i >= this.mih.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.mih.get(i4);
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
        return (duZ() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.miy.mie == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.miy.mie[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.mih.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mhZ == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.mih.get(i4);
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
        return (duZ() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return duZ() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.miy.mif != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.mhS : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mil) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.mhQ) + paddingRight;
                    f2 = bVar.mhQ - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.mhQ) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.mhQ) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.mhQ) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mhQ) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mhQ) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mil);
            }
            float f4 = f - this.miD.miJ;
            float f5 = f2 - this.miD.miJ;
            float max = Math.max(f3, 0.0f);
            int i5 = 0;
            int itemCount = bVar.getItemCount();
            int i6 = i4;
            while (i6 < i4 + itemCount) {
                View HE = HE(i6);
                if (HE == null) {
                    measuredWidth2 = f5;
                    measuredWidth = f4;
                } else {
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(HE, miA);
                        addView(HE);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(HE, miA);
                        addView(HE, i5);
                        i = i5 + 1;
                    }
                    long j = this.miy.mif[i6];
                    int fS = this.miy.fS(j);
                    int fT = this.miy.fT(j);
                    if (shouldMeasureChild(HE, fS, fT, (LayoutParams) HE.getLayoutParams())) {
                        HE.measure(fS, fT);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(HE);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(HE));
                    int topDecorationHeight = i3 + getTopDecorationHeight(HE);
                    if (this.mIsRtl) {
                        this.miy.a(HE, bVar, Math.round(rightDecorationWidth) - HE.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + HE.getMeasuredHeight());
                    } else {
                        this.miy.a(HE, bVar, Math.round(leftDecorationWidth), topDecorationHeight, HE.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + HE.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + HE.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(HE) + max;
                    measuredWidth2 = rightDecorationWidth - (((HE.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(HE)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.miI += this.miC.mLayoutDirection;
            return bVar.dvf();
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
        if ($assertionsDisabled || this.miy.mif != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.mhS;
                i = i5 + bVar.mhS;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mil) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.mhQ) + paddingBottom;
                    f2 = bVar.mhQ - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.mhQ) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.mhQ) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.mhQ) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mhQ) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mhQ) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mil);
            }
            float f4 = f - this.miD.miJ;
            float f5 = f2 - this.miD.miJ;
            float max = Math.max(f3, 0.0f);
            int i8 = 0;
            int itemCount = bVar.getItemCount();
            int i9 = i7;
            while (i9 < i7 + itemCount) {
                View HE = HE(i9);
                if (HE == null) {
                    measuredHeight = f5;
                    measuredHeight2 = f4;
                } else {
                    long j = this.miy.mif[i9];
                    int fS = this.miy.fS(j);
                    int fT = this.miy.fT(j);
                    if (shouldMeasureChild(HE, fS, fT, (LayoutParams) HE.getLayoutParams())) {
                        HE.measure(fS, fT);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(HE);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(HE));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(HE, miA);
                        addView(HE);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(HE, miA);
                        addView(HE, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(HE);
                    int rightDecorationWidth = i - getRightDecorationWidth(HE);
                    if (this.mIsRtl) {
                        if (this.miB) {
                            this.miy.a(HE, bVar, this.mIsRtl, rightDecorationWidth - HE.getMeasuredWidth(), Math.round(bottomDecorationHeight) - HE.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.miy.a(HE, bVar, this.mIsRtl, rightDecorationWidth - HE.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, HE.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.miB) {
                        this.miy.a(HE, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - HE.getMeasuredHeight(), leftDecorationWidth + HE.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.miy.a(HE, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + HE.getMeasuredWidth(), HE.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((HE.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(HE)) + max);
                    measuredHeight2 = topDecorationHeight + HE.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(HE) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.miI += this.miC.mLayoutDirection;
            return bVar.dvf();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean duZ() {
        return this.mij == 0 || this.mij == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dvk();
        } else {
            this.miC.mInfinite = false;
        }
        if (!duZ() && this.mIsRtl) {
            this.miC.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.miC.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.miC.mPosition = aVar.mPosition;
        this.miC.mItemDirection = 1;
        this.miC.mLayoutDirection = 1;
        this.miC.mOffset = aVar.mCoordinate;
        this.miC.mScrollingOffset = Integer.MIN_VALUE;
        this.miC.miI = aVar.miI;
        if (z && this.mih.size() > 1 && aVar.miI >= 0 && aVar.miI < this.mih.size() - 1) {
            b.i(this.miC);
            b bVar = this.miC;
            bVar.mPosition = this.mih.get(aVar.miI).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dvk();
        } else {
            this.miC.mInfinite = false;
        }
        if (!duZ() && this.mIsRtl) {
            this.miC.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.miC.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.miC.mPosition = aVar.mPosition;
        this.miC.mItemDirection = 1;
        this.miC.mLayoutDirection = -1;
        this.miC.mOffset = aVar.mCoordinate;
        this.miC.mScrollingOffset = Integer.MIN_VALUE;
        this.miC.miI = aVar.miI;
        if (z && aVar.miI > 0 && this.mih.size() > aVar.miI) {
            b.j(this.miC);
            this.miC.mPosition -= this.mih.get(aVar.miI).getItemCount();
        }
    }

    private void dvk() {
        int widthMode;
        if (duZ()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.miC.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dvl() {
        if (this.mOrientationHelper == null) {
            if (duZ()) {
                if (this.mik == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.miE = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.miE = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mik == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.miE = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.miE = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.miC == null) {
            this.miC = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.miF != null) {
            this.miF.invalidateAnchor();
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
        return !duZ() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return duZ() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!duZ()) {
            int a2 = a(i, recycler, state);
            this.miG.clear();
            return a2;
        }
        int HV = HV(i);
        this.miD.miJ += HV;
        this.miE.offsetChildren(-HV);
        return HV;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (duZ()) {
            int a2 = a(i, recycler, state);
            this.miG.clear();
            return a2;
        }
        int HV = HV(i);
        this.miD.miJ += HV;
        this.miE.offsetChildren(-HV);
        return HV;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dvl();
        this.miC.miM = true;
        boolean z = !duZ() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        ds(i2, abs);
        int a2 = this.miC.mScrollingOffset + a(recycler, state, this.miC);
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
        this.miC.mLastScrollDelta = i;
        return i;
    }

    private int HV(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dvl();
        boolean duZ = duZ();
        int width = duZ ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = duZ ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.miD.miJ) - width, abs);
            }
            if (this.miD.miJ + i <= 0) {
                return i;
            }
            return -this.miD.miJ;
        } else if (i > 0) {
            return Math.min((width2 - this.miD.miJ) - width, i);
        } else {
            if (this.miD.miJ + i >= 0) {
                return i;
            }
            return -this.miD.miJ;
        }
    }

    private void ds(int i, int i2) {
        if (!$assertionsDisabled && this.miy.mie == null) {
            throw new AssertionError();
        }
        this.miC.mLayoutDirection = i;
        boolean duZ = duZ();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !duZ && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.miC.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.mih.get(this.miy.mie[position]));
            this.miC.mItemDirection = 1;
            this.miC.mPosition = this.miC.mItemDirection + position;
            if (this.miy.mie.length <= this.miC.mPosition) {
                this.miC.miI = -1;
            } else {
                this.miC.miI = this.miy.mie[this.miC.mPosition];
            }
            if (z) {
                this.miC.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.miC.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.miC.mScrollingOffset = this.miC.mScrollingOffset >= 0 ? this.miC.mScrollingOffset : 0;
            } else {
                this.miC.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.miC.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.miC.miI == -1 || this.miC.miI > this.mih.size() - 1) && this.miC.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.miC.mScrollingOffset;
                this.miz.reset();
                if (i3 > 0) {
                    if (duZ) {
                        this.miy.a(this.miz, makeMeasureSpec, makeMeasureSpec2, i3, this.miC.mPosition, this.mih);
                    } else {
                        this.miy.c(this.miz, makeMeasureSpec, makeMeasureSpec2, i3, this.miC.mPosition, this.mih);
                    }
                    this.miy.ai(makeMeasureSpec, makeMeasureSpec2, this.miC.mPosition);
                    this.miy.HI(this.miC.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.miC.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.mih.get(this.miy.mie[position2]));
            this.miC.mItemDirection = 1;
            int i4 = this.miy.mie[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.miC.mPosition = position2 - this.mih.get(i5 - 1).getItemCount();
            } else {
                this.miC.mPosition = -1;
            }
            this.miC.miI = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.miC.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.miC.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.miC.mScrollingOffset = this.miC.mScrollingOffset >= 0 ? this.miC.mScrollingOffset : 0;
            } else {
                this.miC.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.miC.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.miC.mAvailable = i2 - this.miC.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean duZ = duZ();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !duZ) {
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
        boolean duZ = duZ();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !duZ) {
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
        dvl();
        View HT = HT(itemCount);
        View HU = HU(itemCount);
        if (state.getItemCount() == 0 || HT == null || HU == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(HU) - this.mOrientationHelper.getDecoratedStart(HT));
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
        View HT = HT(itemCount);
        View HU = HU(itemCount);
        if (state.getItemCount() == 0 || HT == null || HU == null) {
            return 0;
        }
        if ($assertionsDisabled || this.miy.mie != null) {
            int position = getPosition(HT);
            int position2 = getPosition(HU);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(HU) - this.mOrientationHelper.getDecoratedStart(HT));
            int i = this.miy.mie[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.miy.mie[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(HT)));
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
        View HT = HT(itemCount);
        View HU = HU(itemCount);
        if (state.getItemCount() == 0 || HT == null || HU == null) {
            return 0;
        }
        if ($assertionsDisabled || this.miy.mie != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(HU) - this.mOrientationHelper.getDecoratedStart(HT)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
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

    private int dk(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int dl(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + getDecoratedRight(view);
    }

    private int dm(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int dn(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
    }

    private boolean m(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int dk = dk(view);
        int dm = dm(view);
        int dl = dl(view);
        int dn = dn(view);
        return z ? (paddingLeft <= dk && width >= dl) && (paddingTop <= dm && height >= dn) : (dk >= width || dl >= paddingLeft) && (dm >= height || dn >= paddingTop);
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
            if (m(childAt, z)) {
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
            /* renamed from: HW */
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
        public int dva() {
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
        public boolean dvb() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dvc() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dvd() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dve() {
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
        private int miI;
        private int miJ;
        private boolean miK;
        final /* synthetic */ FlexboxLayoutManager miL;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.miI = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.miK = false;
            if (this.miL.duZ()) {
                if (this.miL.mik == 0) {
                    this.mLayoutFromEnd = this.miL.mij == 1;
                } else {
                    this.mLayoutFromEnd = this.miL.mik == 2;
                }
            } else if (this.miL.mik == 0) {
                this.mLayoutFromEnd = this.miL.mij == 3;
            } else {
                this.mLayoutFromEnd = this.miL.mik == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.miL.duZ() && this.miL.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.miL.mOrientationHelper.getEndAfterPadding() : this.miL.getWidth() - this.miL.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.miL.mOrientationHelper.getEndAfterPadding() : this.miL.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: do  reason: not valid java name */
        public void m38do(View view) {
            if (!this.miL.duZ() && this.miL.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.miL.mOrientationHelper.getDecoratedStart(view) + this.miL.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.miL.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.miL.mOrientationHelper.getDecoratedEnd(view) + this.miL.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.miL.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.miL.getPosition(view);
            this.miK = false;
            if (!$assertionsDisabled && this.miL.miy.mie == null) {
                throw new AssertionError();
            }
            int i = this.miL.miy.mie[this.mPosition != -1 ? this.mPosition : 0];
            this.miI = i != -1 ? i : 0;
            if (this.miL.mih.size() > this.miI) {
                this.mPosition = ((com.google.android.flexbox.b) this.miL.mih.get(this.miI)).mhZ;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.miI + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.miJ + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.miK + '}';
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
        private int miI;
        private boolean miM;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.miI;
            bVar.miI = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.miI;
            bVar.miI = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.miI >= 0 && this.miI < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.miI + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
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
            /* renamed from: HY */
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
        public boolean HX(int i) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < i;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
