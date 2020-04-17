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
    private static final Rect miw;
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
    private OrientationHelper miA;
    private SavedState miB;
    private SparseArray<View> miC;
    private int miD;
    private List<com.google.android.flexbox.b> mic;
    private int mif;
    private int mig;
    private int mih;
    private int mii;
    private int mik;
    private final c miu;
    private c.a miv;
    private boolean mix;
    private b miy;
    private a miz;

    static {
        $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        miw = new Rect();
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mif;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mig;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mii;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mik;
    }

    @Override // com.google.android.flexbox.a
    public int h(View view, int i, int i2) {
        return dvb() ? getLeftDecorationWidth(view) + getRightDecorationWidth(view) : getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    @Override // com.google.android.flexbox.a
    public int dj(View view) {
        return dvb() ? getTopDecorationHeight(view) + getBottomDecorationHeight(view) : getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    @Override // com.google.android.flexbox.a
    public void a(View view, int i, int i2, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, miw);
        if (dvb()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.mhM += leftDecorationWidth;
            bVar.mhN = leftDecorationWidth + bVar.mhN;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.mhM += topDecorationHeight;
        bVar.mhN = topDecorationHeight + bVar.mhN;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public View HE(int i) {
        View view = this.miC.get(i);
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
        if (this.mic.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.mic.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mic.get(i2).mhM);
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mic.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mic.get(i2).mhO;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.mic = list;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.mic;
    }

    @Override // com.google.android.flexbox.a
    public void l(int i, View view) {
        this.miC.put(i, view);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (dvb()) {
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
        if (this.miB != null) {
            return new SavedState(this.miB);
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
            this.miB = (SavedState) parcelable;
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
            this.miu.HK(childCount);
            this.miu.HJ(childCount);
            this.miu.HL(childCount);
            if (!$assertionsDisabled && this.miu.mhZ == null) {
                throw new AssertionError();
            }
            if (i < this.miu.mhZ.length) {
                this.miD = i;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
                        this.mPendingScrollPosition = getPosition(childClosestToStart);
                        if (!dvb() && this.mIsRtl) {
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
            dvl();
            dvn();
            ensureLayoutState();
            this.miu.HK(itemCount);
            this.miu.HJ(itemCount);
            this.miu.HL(itemCount);
            this.miy.miI = false;
            if (this.miB != null && this.miB.HX(itemCount)) {
                this.mPendingScrollPosition = this.miB.mAnchorPosition;
            }
            if (!this.miz.mValid || this.mPendingScrollPosition != -1 || this.miB != null) {
                this.miz.reset();
                a(state, this.miz);
                this.miz.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.miz.mLayoutFromEnd) {
                b(this.miz, false, true);
            } else {
                a(this.miz, false, true);
            }
            HS(itemCount);
            if (this.miz.mLayoutFromEnd) {
                a(recycler, state, this.miy);
                i2 = this.miy.mOffset;
                a(this.miz, true, false);
                a(recycler, state, this.miy);
                i = this.miy.mOffset;
            } else {
                a(recycler, state, this.miy);
                i = this.miy.mOffset;
                b(this.miz, true, false);
                a(recycler, state, this.miy);
                i2 = this.miy.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.miz.mLayoutFromEnd) {
                fixLayoutStartGap(fixLayoutEndGap(i, recycler, state, true) + i2, recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!dvb() && this.mIsRtl) {
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
        if (!dvb() && this.mIsRtl) {
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
        if (dvb()) {
            if (this.mLastWidth == Integer.MIN_VALUE || this.mLastWidth == width) {
                z = false;
            }
            if (this.miy.mInfinite) {
                i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i4 = this.miy.mAvailable;
            }
            i3 = i4;
        } else {
            if (this.mLastHeight == Integer.MIN_VALUE || this.mLastHeight == height) {
                z = false;
            }
            if (this.miy.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i2 = this.miy.mAvailable;
            }
            i3 = i2;
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.miD != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int min = this.miD != -1 ? Math.min(this.miD, this.miz.mPosition) : this.miz.mPosition;
            this.miv.reset();
            if (dvb()) {
                if (this.mic.size() > 0) {
                    this.miu.s(this.mic, min);
                    this.miu.a(this.miv, makeMeasureSpec, makeMeasureSpec2, i3, min, this.miz.mPosition, this.mic);
                } else {
                    this.miu.HL(i);
                    this.miu.a(this.miv, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mic);
                }
            } else if (this.mic.size() > 0) {
                this.miu.s(this.mic, min);
                this.miu.a(this.miv, makeMeasureSpec2, makeMeasureSpec, i3, min, this.miz.mPosition, this.mic);
            } else {
                this.miu.HL(i);
                this.miu.c(this.miv, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.mic);
            }
            this.mic = this.miv.mic;
            this.miu.ai(makeMeasureSpec, makeMeasureSpec2, min);
            this.miu.HI(min);
        } else if (!this.miz.mLayoutFromEnd) {
            this.mic.clear();
            if (!$assertionsDisabled && this.miu.mhZ == null) {
                throw new AssertionError();
            }
            this.miv.reset();
            if (dvb()) {
                this.miu.b(this.miv, makeMeasureSpec, makeMeasureSpec2, i3, this.miz.mPosition, this.mic);
            } else {
                this.miu.d(this.miv, makeMeasureSpec, makeMeasureSpec2, i3, this.miz.mPosition, this.mic);
            }
            this.mic = this.miv.mic;
            this.miu.m39do(makeMeasureSpec, makeMeasureSpec2);
            this.miu.dvj();
            this.miz.miE = this.miu.mhZ[this.miz.mPosition];
            this.miy.miE = this.miz.miE;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.miB = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.miD = -1;
        this.miz.reset();
        this.miC.clear();
    }

    private void dvl() {
        int layoutDirection = getLayoutDirection();
        switch (this.mif) {
            case 0:
                this.mIsRtl = layoutDirection == 1;
                this.mix = this.mig == 2;
                return;
            case 1:
                this.mIsRtl = layoutDirection != 1;
                this.mix = this.mig == 2;
                return;
            case 2:
                this.mIsRtl = layoutDirection == 1;
                if (this.mig == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mix = false;
                return;
            case 3:
                this.mIsRtl = layoutDirection == 1;
                if (this.mig == 2) {
                    this.mIsRtl = this.mIsRtl ? false : true;
                }
                this.mix = true;
                return;
            default:
                this.mIsRtl = false;
                this.mix = false;
                return;
        }
    }

    private void a(RecyclerView.State state, a aVar) {
        if (a(state, aVar, this.miB) || b(state, aVar)) {
            return;
        }
        aVar.assignCoordinateFromPadding();
        aVar.mPosition = 0;
        aVar.miE = 0;
    }

    private boolean a(RecyclerView.State state, a aVar, SavedState savedState) {
        int decoratedStart;
        if ($assertionsDisabled || this.miu.mhZ != null) {
            if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
                return false;
            }
            if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            aVar.mPosition = this.mPendingScrollPosition;
            aVar.miE = this.miu.mhZ[aVar.mPosition];
            if (this.miB == null || !this.miB.HX(state.getItemCount())) {
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
                } else if (dvb() || !this.mIsRtl) {
                    aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    return true;
                } else {
                    aVar.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    return true;
                }
            }
            aVar.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            aVar.miG = true;
            aVar.miE = -1;
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
        if ($assertionsDisabled || this.miu.mhZ != null) {
            View ak = ak(0, getChildCount(), i);
            if (ak == null) {
                return null;
            }
            int i2 = this.miu.mhZ[getPosition(ak)];
            if (i2 != -1) {
                return a(ak, this.mic.get(i2));
            }
            return null;
        }
        throw new AssertionError();
    }

    private View HU(int i) {
        if ($assertionsDisabled || this.miu.mhZ != null) {
            View ak = ak(getChildCount() - 1, -1, i);
            if (ak == null) {
                return null;
            }
            return b(ak, this.mic.get(this.miu.mhZ[getPosition(ak)]));
        }
        throw new AssertionError();
    }

    private View ak(int i, int i2, int i3) {
        View view;
        View view2 = null;
        dvn();
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
        boolean dvb = dvb();
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if ((i3 > 0 || this.miy.mInfinite) && bVar.a(state, this.mic)) {
                com.google.android.flexbox.b bVar2 = this.mic.get(bVar.miE);
                bVar.mPosition = bVar2.mhV;
                i4 += a(bVar2, bVar);
                if (dvb || !this.mIsRtl) {
                    bVar.mOffset += bVar2.dvh() * bVar.mLayoutDirection;
                } else {
                    bVar.mOffset -= bVar2.dvh() * bVar.mLayoutDirection;
                }
                i3 -= bVar2.dvh();
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
        if (!bVar.miI) {
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
            if (!$assertionsDisabled && this.miu.mhZ == null) {
                throw new AssertionError();
            }
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.miu.mhZ[getPosition(getChildAt(0))];
                if (i != -1) {
                    com.google.android.flexbox.b bVar2 = this.mic.get(i);
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
                        if (bVar2.mhW == getPosition(childAt)) {
                            if (i >= this.mic.size() - 1) {
                                i2 = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            i = i4;
                            bVar2 = this.mic.get(i4);
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
        return (dvb() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= i : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= i;
    }

    private void c(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.mScrollingOffset >= 0) {
            if (!$assertionsDisabled && this.miu.mhZ == null) {
                throw new AssertionError();
            }
            int end = this.mOrientationHelper.getEnd() - bVar.mScrollingOffset;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = this.miu.mhZ[getPosition(getChildAt(childCount - 1))];
                if (i != -1) {
                    int i2 = childCount - 1;
                    com.google.android.flexbox.b bVar2 = this.mic.get(i);
                    int i3 = childCount - 1;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (!A(childAt, bVar.mScrollingOffset)) {
                            break;
                        }
                        if (bVar2.mhV == getPosition(childAt)) {
                            if (i <= 0) {
                                childCount = i3;
                                break;
                            }
                            int i4 = i + bVar.mLayoutDirection;
                            bVar2 = this.mic.get(i4);
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
        return (dvb() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - i : this.mOrientationHelper.getDecoratedEnd(view) <= i;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int a(com.google.android.flexbox.b bVar, b bVar2) {
        return dvb() ? b(bVar, bVar2) : c(bVar, bVar2);
    }

    private int b(com.google.android.flexbox.b bVar, b bVar2) {
        float f;
        float f2;
        int i;
        LayoutParams layoutParams;
        float measuredWidth;
        float measuredWidth2;
        if ($assertionsDisabled || this.miu.mia != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int i2 = bVar2.mOffset;
            int i3 = bVar2.mLayoutDirection == -1 ? i2 - bVar.mhO : i2;
            int i4 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mih) {
                case 0:
                    f = paddingLeft;
                    f2 = width - paddingRight;
                    break;
                case 1:
                    f = (width - bVar.mhM) + paddingRight;
                    f2 = bVar.mhM - paddingLeft;
                    break;
                case 2:
                    f = ((width - bVar.mhM) / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - ((width - bVar.mhM) / 2.0f);
                    break;
                case 3:
                    f = paddingLeft;
                    f3 = (width - bVar.mhM) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = width - paddingRight;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mhM) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingLeft;
                    f2 = (width - paddingRight) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (width - bVar.mhM) / (bVar.mItemCount + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (width - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mih);
            }
            float f4 = f - this.miz.miF;
            float f5 = f2 - this.miz.miF;
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
                        calculateItemDecorationsForChild(HE, miw);
                        addView(HE);
                        i = i5;
                    } else {
                        calculateItemDecorationsForChild(HE, miw);
                        addView(HE, i5);
                        i = i5 + 1;
                    }
                    long j = this.miu.mia[i6];
                    int fS = this.miu.fS(j);
                    int fT = this.miu.fT(j);
                    if (shouldMeasureChild(HE, fS, fT, (LayoutParams) HE.getLayoutParams())) {
                        HE.measure(fS, fT);
                    }
                    float leftDecorationWidth = f4 + layoutParams.leftMargin + getLeftDecorationWidth(HE);
                    float rightDecorationWidth = f5 - (layoutParams.rightMargin + getRightDecorationWidth(HE));
                    int topDecorationHeight = i3 + getTopDecorationHeight(HE);
                    if (this.mIsRtl) {
                        this.miu.a(HE, bVar, Math.round(rightDecorationWidth) - HE.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + HE.getMeasuredHeight());
                    } else {
                        this.miu.a(HE, bVar, Math.round(leftDecorationWidth), topDecorationHeight, HE.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + HE.getMeasuredHeight());
                    }
                    measuredWidth = leftDecorationWidth + HE.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(HE) + max;
                    measuredWidth2 = rightDecorationWidth - (((HE.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(HE)) + max);
                    i5 = i;
                }
                i6++;
                f4 = measuredWidth;
                f5 = measuredWidth2;
            }
            bVar2.miE += this.miy.mLayoutDirection;
            return bVar.dvh();
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
        if ($assertionsDisabled || this.miu.mia != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = bVar2.mOffset;
            int i5 = bVar2.mOffset;
            if (bVar2.mLayoutDirection == -1) {
                int i6 = i4 - bVar.mhO;
                i = i5 + bVar.mhO;
                i2 = i6;
            } else {
                i = i5;
                i2 = i4;
            }
            int i7 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.mih) {
                case 0:
                    f = paddingTop;
                    f2 = height - paddingBottom;
                    break;
                case 1:
                    f = (height - bVar.mhM) + paddingBottom;
                    f2 = bVar.mhM - paddingTop;
                    break;
                case 2:
                    f = ((height - bVar.mhM) / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - ((height - bVar.mhM) / 2.0f);
                    break;
                case 3:
                    f = paddingTop;
                    f3 = (height - bVar.mhM) / (bVar.mItemCount != 1 ? bVar.mItemCount - 1 : 1.0f);
                    f2 = height - paddingBottom;
                    break;
                case 4:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mhM) / bVar.mItemCount;
                    }
                    f = (f3 / 2.0f) + paddingTop;
                    f2 = (height - paddingBottom) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.mItemCount != 0) {
                        f3 = (height - bVar.mhM) / (bVar.mItemCount + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (height - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mih);
            }
            float f4 = f - this.miz.miF;
            float f5 = f2 - this.miz.miF;
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
                    long j = this.miu.mia[i9];
                    int fS = this.miu.fS(j);
                    int fT = this.miu.fT(j);
                    if (shouldMeasureChild(HE, fS, fT, (LayoutParams) HE.getLayoutParams())) {
                        HE.measure(fS, fT);
                    }
                    float topDecorationHeight = f4 + layoutParams.topMargin + getTopDecorationHeight(HE);
                    float bottomDecorationHeight = f5 - (layoutParams.rightMargin + getBottomDecorationHeight(HE));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(HE, miw);
                        addView(HE);
                        i3 = i8;
                    } else {
                        calculateItemDecorationsForChild(HE, miw);
                        addView(HE, i8);
                        i3 = i8 + 1;
                    }
                    int leftDecorationWidth = i2 + getLeftDecorationWidth(HE);
                    int rightDecorationWidth = i - getRightDecorationWidth(HE);
                    if (this.mIsRtl) {
                        if (this.mix) {
                            this.miu.a(HE, bVar, this.mIsRtl, rightDecorationWidth - HE.getMeasuredWidth(), Math.round(bottomDecorationHeight) - HE.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.miu.a(HE, bVar, this.mIsRtl, rightDecorationWidth - HE.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, HE.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.mix) {
                        this.miu.a(HE, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - HE.getMeasuredHeight(), leftDecorationWidth + HE.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.miu.a(HE, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + HE.getMeasuredWidth(), HE.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    measuredHeight = bottomDecorationHeight - (((HE.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(HE)) + max);
                    measuredHeight2 = topDecorationHeight + HE.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(HE) + max;
                    i8 = i3;
                }
                i9++;
                f4 = measuredHeight2;
                f5 = measuredHeight;
            }
            bVar2.miE += this.miy.mLayoutDirection;
            return bVar.dvh();
        }
        throw new AssertionError();
    }

    @Override // com.google.android.flexbox.a
    public boolean dvb() {
        return this.mif == 0 || this.mif == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (z2) {
            dvm();
        } else {
            this.miy.mInfinite = false;
        }
        if (!dvb() && this.mIsRtl) {
            this.miy.mAvailable = aVar.mCoordinate - getPaddingRight();
        } else {
            this.miy.mAvailable = this.mOrientationHelper.getEndAfterPadding() - aVar.mCoordinate;
        }
        this.miy.mPosition = aVar.mPosition;
        this.miy.mItemDirection = 1;
        this.miy.mLayoutDirection = 1;
        this.miy.mOffset = aVar.mCoordinate;
        this.miy.mScrollingOffset = Integer.MIN_VALUE;
        this.miy.miE = aVar.miE;
        if (z && this.mic.size() > 1 && aVar.miE >= 0 && aVar.miE < this.mic.size() - 1) {
            b.i(this.miy);
            b bVar = this.miy;
            bVar.mPosition = this.mic.get(aVar.miE).getItemCount() + bVar.mPosition;
        }
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (z2) {
            dvm();
        } else {
            this.miy.mInfinite = false;
        }
        if (!dvb() && this.mIsRtl) {
            this.miy.mAvailable = (this.mParent.getWidth() - aVar.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.miy.mAvailable = aVar.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.miy.mPosition = aVar.mPosition;
        this.miy.mItemDirection = 1;
        this.miy.mLayoutDirection = -1;
        this.miy.mOffset = aVar.mCoordinate;
        this.miy.mScrollingOffset = Integer.MIN_VALUE;
        this.miy.miE = aVar.miE;
        if (z && aVar.miE > 0 && this.mic.size() > aVar.miE) {
            b.j(this.miy);
            this.miy.mPosition -= this.mic.get(aVar.miE).getItemCount();
        }
    }

    private void dvm() {
        int widthMode;
        if (dvb()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.miy.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void dvn() {
        if (this.mOrientationHelper == null) {
            if (dvb()) {
                if (this.mig == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.miA = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.miA = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mig == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.miA = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.miA = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.miy == null) {
            this.miy = new b();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.miB != null) {
            this.miB.invalidateAnchor();
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
        return !dvb() || getWidth() > this.mParent.getWidth();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return dvb() || getHeight() > this.mParent.getHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!dvb()) {
            int a2 = a(i, recycler, state);
            this.miC.clear();
            return a2;
        }
        int HV = HV(i);
        this.miz.miF += HV;
        this.miA.offsetChildren(-HV);
        return HV;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (dvb()) {
            int a2 = a(i, recycler, state);
            this.miC.clear();
            return a2;
        }
        int HV = HV(i);
        this.miz.miF += HV;
        this.miA.offsetChildren(-HV);
        return HV;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = 1;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dvn();
        this.miy.miI = true;
        boolean z = !dvb() && this.mIsRtl;
        if (z) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        ds(i2, abs);
        int a2 = this.miy.mScrollingOffset + a(recycler, state, this.miy);
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
        this.miy.mLastScrollDelta = i;
        return i;
    }

    private int HV(int i) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        dvn();
        boolean dvb = dvb();
        int width = dvb ? this.mParent.getWidth() : this.mParent.getHeight();
        int width2 = dvb ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.miz.miF) - width, abs);
            }
            if (this.miz.miF + i <= 0) {
                return i;
            }
            return -this.miz.miF;
        } else if (i > 0) {
            return Math.min((width2 - this.miz.miF) - width, i);
        } else {
            if (this.miz.miF + i >= 0) {
                return i;
            }
            return -this.miz.miF;
        }
    }

    private void ds(int i, int i2) {
        if (!$assertionsDisabled && this.miu.mhZ == null) {
            throw new AssertionError();
        }
        this.miy.mLayoutDirection = i;
        boolean dvb = dvb();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !dvb && this.mIsRtl;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.miy.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View b2 = b(childAt, this.mic.get(this.miu.mhZ[position]));
            this.miy.mItemDirection = 1;
            this.miy.mPosition = this.miy.mItemDirection + position;
            if (this.miu.mhZ.length <= this.miy.mPosition) {
                this.miy.miE = -1;
            } else {
                this.miy.miE = this.miu.mhZ[this.miy.mPosition];
            }
            if (z) {
                this.miy.mOffset = this.mOrientationHelper.getDecoratedStart(b2);
                this.miy.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(b2)) + this.mOrientationHelper.getStartAfterPadding();
                this.miy.mScrollingOffset = this.miy.mScrollingOffset >= 0 ? this.miy.mScrollingOffset : 0;
            } else {
                this.miy.mOffset = this.mOrientationHelper.getDecoratedEnd(b2);
                this.miy.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(b2) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.miy.miE == -1 || this.miy.miE > this.mic.size() - 1) && this.miy.mPosition <= getFlexItemCount()) {
                int i3 = i2 - this.miy.mScrollingOffset;
                this.miv.reset();
                if (i3 > 0) {
                    if (dvb) {
                        this.miu.a(this.miv, makeMeasureSpec, makeMeasureSpec2, i3, this.miy.mPosition, this.mic);
                    } else {
                        this.miu.c(this.miv, makeMeasureSpec, makeMeasureSpec2, i3, this.miy.mPosition, this.mic);
                    }
                    this.miu.ai(makeMeasureSpec, makeMeasureSpec2, this.miy.mPosition);
                    this.miu.HI(this.miy.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.miy.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View a2 = a(childAt2, this.mic.get(this.miu.mhZ[position2]));
            this.miy.mItemDirection = 1;
            int i4 = this.miu.mhZ[position2];
            int i5 = i4 == -1 ? 0 : i4;
            if (i5 > 0) {
                this.miy.mPosition = position2 - this.mic.get(i5 - 1).getItemCount();
            } else {
                this.miy.mPosition = -1;
            }
            this.miy.miE = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.miy.mOffset = this.mOrientationHelper.getDecoratedEnd(a2);
                this.miy.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(a2) - this.mOrientationHelper.getEndAfterPadding();
                this.miy.mScrollingOffset = this.miy.mScrollingOffset >= 0 ? this.miy.mScrollingOffset : 0;
            } else {
                this.miy.mOffset = this.mOrientationHelper.getDecoratedStart(a2);
                this.miy.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(a2)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.miy.mAvailable = i2 - this.miy.mScrollingOffset;
    }

    private View a(View view, com.google.android.flexbox.b bVar) {
        boolean dvb = dvb();
        int i = bVar.mItemCount;
        View view2 = view;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dvb) {
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
        boolean dvb = dvb();
        int childCount = (getChildCount() - bVar.mItemCount) - 1;
        View view2 = view;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !dvb) {
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
        dvn();
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
        if ($assertionsDisabled || this.miu.mhZ != null) {
            int position = getPosition(HT);
            int position2 = getPosition(HU);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(HU) - this.mOrientationHelper.getDecoratedStart(HT));
            int i = this.miu.mhZ[position];
            if (i == 0 || i == -1) {
                return 0;
            }
            return Math.round(((abs / ((this.miu.mhZ[position2] - i) + 1)) * i) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(HT)));
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
        if ($assertionsDisabled || this.miu.mhZ != null) {
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
        public int dvc() {
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
        public boolean dvd() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float dve() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dvf() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int dvg() {
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
        private int miE;
        private int miF;
        private boolean miG;
        final /* synthetic */ FlexboxLayoutManager miH;

        static {
            $assertionsDisabled = !FlexboxLayoutManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.miE = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.miG = false;
            if (this.miH.dvb()) {
                if (this.miH.mig == 0) {
                    this.mLayoutFromEnd = this.miH.mif == 1;
                } else {
                    this.mLayoutFromEnd = this.miH.mig == 2;
                }
            } else if (this.miH.mig == 0) {
                this.mLayoutFromEnd = this.miH.mif == 3;
            } else {
                this.mLayoutFromEnd = this.miH.mig == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!this.miH.dvb() && this.miH.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? this.miH.mOrientationHelper.getEndAfterPadding() : this.miH.getWidth() - this.miH.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? this.miH.mOrientationHelper.getEndAfterPadding() : this.miH.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: do  reason: not valid java name */
        public void m38do(View view) {
            if (!this.miH.dvb() && this.miH.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.miH.mOrientationHelper.getDecoratedStart(view) + this.miH.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.miH.mOrientationHelper.getDecoratedEnd(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = this.miH.mOrientationHelper.getDecoratedEnd(view) + this.miH.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.miH.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = this.miH.getPosition(view);
            this.miG = false;
            if (!$assertionsDisabled && this.miH.miu.mhZ == null) {
                throw new AssertionError();
            }
            int i = this.miH.miu.mhZ[this.mPosition != -1 ? this.mPosition : 0];
            this.miE = i != -1 ? i : 0;
            if (this.miH.mic.size() > this.miE) {
                this.mPosition = ((com.google.android.flexbox.b) this.miH.mic.get(this.miE)).mhV;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.miE + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.miF + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.miG + '}';
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
        private int miE;
        private boolean miI;

        private b() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int i(b bVar) {
            int i = bVar.miE;
            bVar.miE = i + 1;
            return i;
        }

        static /* synthetic */ int j(b bVar) {
            int i = bVar.miE;
            bVar.miE = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.miE >= 0 && this.miE < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.miE + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
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
