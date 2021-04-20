package com.huewu.pla.lib.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ListAdapter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.R$styleable;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class PLA_ListView extends PLA_AbsListView {
    public static final float MAX_SCROLL_FACTOR = 0.33f;
    public static final int NO_POSITION = -1;
    public boolean mAreAllItemsSelectable;
    public boolean mClipDivider;
    public Paint mContentPaint;
    public Drawable mDivider;
    public int mDividerHeight;
    public boolean mDividerIsOpaque;
    public Paint mDividerPaint;
    public boolean mFooterDividersEnabled;
    public ArrayList<a> mFooterViewInfos;
    public boolean mHeaderDividersEnabled;
    public ArrayList<a> mHeaderViewInfos;
    public boolean mIsCacheColorOpaque;
    public boolean mItemsCanFocus;
    public Drawable mOverScrollFooter;
    public Drawable mOverScrollHeader;
    public final Rect mTempRect;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f31436a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31437b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f31438c;

        public a() {
        }
    }

    public PLA_ListView(Context context) {
        this(context, null);
    }

    private View addViewAbove(View view, int i) {
        int i2 = i - 1;
        d.i.a.a.a.c("addViewAbove:" + i);
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view.getTop() - this.mDividerHeight, false, this.mListPadding.left, false, this.mIsScrap[0]);
        return obtainView;
    }

    private View addViewBelow(View view, int i) {
        int i2 = i + 1;
        d.i.a.a.a.c("addViewBelow:" + i);
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view.getBottom() + this.mDividerHeight, true, this.mListPadding.left, false, this.mIsScrap[0]);
        return obtainView;
    }

    private void adjustViewsUpOrDown() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i = 0;
            if (!this.mStackFromBottom) {
                int scrollChildTop = getScrollChildTop() - this.mListPadding.top;
                if (this.mFirstPosition != 0) {
                    scrollChildTop -= this.mDividerHeight;
                }
                if (scrollChildTop >= 0) {
                    i = scrollChildTop;
                }
            } else {
                int scrollChildBottom = getScrollChildBottom() - (getHeight() - this.mListPadding.bottom);
                if (this.mFirstPosition + childCount < this.mItemCount) {
                    scrollChildBottom += this.mDividerHeight;
                }
                if (scrollChildBottom <= 0) {
                    i = scrollChildBottom;
                }
            }
            if (i != 0) {
                tryOffsetChildrenTopAndBottom(-i);
            }
        }
    }

    private void clearRecycledState(ArrayList<a> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) arrayList.get(i).f31436a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f31401c = false;
                }
            }
        }
    }

    private void correctTooHigh(int i) {
        if ((this.mFirstPosition + i) - 1 != this.mItemCount - 1 || i <= 0) {
            return;
        }
        int bottom = ((getBottom() - getTop()) - this.mListPadding.bottom) - getScrollChildBottom();
        int scrollChildTop = getScrollChildTop();
        if (bottom > 0) {
            if (this.mFirstPosition > 0 || scrollChildTop < this.mListPadding.top) {
                if (this.mFirstPosition == 0) {
                    bottom = Math.min(bottom, this.mListPadding.top - scrollChildTop);
                }
                tryOffsetChildrenTopAndBottom(bottom);
                if (this.mFirstPosition > 0) {
                    getScrollChildTop();
                    fillUp(this.mFirstPosition - 1, getFillChildTop());
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    private void correctTooLow(int i) {
        if (this.mFirstPosition != 0 || i <= 0) {
            return;
        }
        int scrollChildTop = getScrollChildTop();
        int i2 = this.mListPadding.top;
        int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
        int i3 = scrollChildTop - i2;
        int scrollChildBottom = getScrollChildBottom();
        int i4 = (this.mFirstPosition + i) - 1;
        if (i3 > 0) {
            int i5 = this.mItemCount;
            if (i4 >= i5 - 1 && scrollChildBottom <= bottom) {
                if (i4 == i5 - 1) {
                    adjustViewsUpOrDown();
                    return;
                }
                return;
            }
            if (i4 == this.mItemCount - 1) {
                i3 = Math.min(i3, scrollChildBottom - bottom);
            }
            tryOffsetChildrenTopAndBottom(-i3);
            if (i4 < this.mItemCount - 1) {
                fillDown(i4 + 1, getFillChildBottom() + this.mDividerHeight);
                adjustViewsUpOrDown();
            }
        }
    }

    private void drawContentBackground(Canvas canvas) {
        if (getHeaderViewsCount() > 0) {
            Rect rect = this.mTempRect;
            rect.left = getLeft();
            rect.right = getRight();
            if (isHeaderView(getChildAt(getFirstVisiblePosition()))) {
                ArrayList<a> arrayList = this.mHeaderViewInfos;
                rect.top = arrayList.get(arrayList.size() - 1).f31436a.getBottom();
            } else {
                rect.top = 0;
            }
            rect.bottom = getBottom();
            canvas.drawRect(rect, this.mContentPaint);
        }
    }

    private View fillDown(int i, int i2) {
        d.i.a.a.a.c("fill down: " + i);
        int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
        while (i2 < bottom && i < this.mItemCount) {
            makeAndAddView(i, getItemTop(i), true, false);
            i++;
            i2 = getFillChildBottom() + this.mDividerHeight;
        }
        return null;
    }

    private View fillFromTop(int i) {
        int min = Math.min(this.mFirstPosition, -1);
        this.mFirstPosition = min;
        int min2 = Math.min(min, this.mItemCount - 1);
        this.mFirstPosition = min2;
        if (min2 < 0) {
            this.mFirstPosition = 0;
        }
        return fillDown(this.mFirstPosition, i);
    }

    private View fillSpecific(int i, int i2) {
        if (this.mDataChanged) {
            d.i.a.a.a.c("fill specific: " + i + ":" + i2);
        }
        View makeAndAddView = makeAndAddView(i, i2, true, false);
        this.mFirstPosition = i;
        int i3 = this.mDividerHeight;
        if (!this.mStackFromBottom) {
            fillUp(i - 1, getFillChildTop());
            adjustViewsUpOrDown();
            fillDown(i + 1, getFillChildBottom() + this.mDividerHeight);
            int childCount = getChildCount();
            if (childCount > 0) {
                correctTooHigh(childCount);
                return null;
            }
            return null;
        }
        fillDown(i + 1, makeAndAddView.getBottom() + i3);
        adjustViewsUpOrDown();
        fillUp(i - 1, getFillChildTop());
        int childCount2 = getChildCount();
        if (childCount2 > 0) {
            correctTooLow(childCount2);
            return null;
        }
        return null;
    }

    private void fillSynced(int i, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            makeAndAddView(i + i2, iArr[i2], true, false);
            adjustViewsUpOrDown();
        }
        this.mFirstPosition = i;
    }

    private View fillUp(int i, int i2) {
        d.i.a.a.a.c("fill up: " + i);
        int i3 = this.mListPadding.top;
        while (i2 > i3 && i >= 0) {
            makeAndAddView(i, getItemBottom(i), false, false);
            i--;
            i2 = getItemBottom(i);
        }
        this.mFirstPosition = i + 1;
        return null;
    }

    private boolean isHeaderView(View view) {
        Iterator<a> it = this.mHeaderViewInfos.iterator();
        while (it.hasNext()) {
            if (it.next().f31436a == view) {
                return true;
            }
        }
        return false;
    }

    private View makeAndAddView(int i, int i2, boolean z, boolean z2) {
        View f2;
        if (!this.mDataChanged && (f2 = this.mRecycler.f(i)) != null) {
            setupChild(f2, i, i2, z, getItemLeft(i), z2, true);
            return f2;
        }
        onItemAddedToList(i, z);
        int itemLeft = getItemLeft(i);
        d.i.a.a.a.c("makeAndAddView:" + i);
        View obtainView = obtainView(i, this.mIsScrap);
        if (obtainView == null) {
            d.i.a.a.a.b("child is null:" + i);
        } else {
            setupChild(obtainView, i, i2, z, itemLeft, z2, this.mIsScrap[0]);
        }
        return obtainView;
    }

    private void measureScrapChild(View view, int i, int i2) {
        int makeMeasureSpec;
        PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new PLA_AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        layoutParams.f31399a = this.mAdapter.getItemViewType(i);
        layoutParams.f31402d = true;
        Rect rect = this.mListPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, rect.left + rect.right, ((ViewGroup.LayoutParams) layoutParams).width);
        int i3 = ((ViewGroup.LayoutParams) layoutParams).height;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void removeFixedViewInfo(View view, ArrayList<a> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).f31436a == view) {
                arrayList.remove(i);
                return;
            }
        }
    }

    private void scrollListItemsBy(int i) {
        int i2;
        int i3;
        tryOffsetChildrenTopAndBottom(i);
        int height = getHeight();
        Rect rect = this.mListPadding;
        int i4 = height - rect.bottom;
        int i5 = rect.top;
        PLA_AbsListView.h hVar = this.mRecycler;
        if (i < 0) {
            View lastChild = getLastChild();
            for (int childCount = getChildCount(); lastChild.getBottom() < i4 && (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1; childCount++) {
                addViewBelow(lastChild, i3);
                lastChild = getLastChild();
            }
            if (lastChild.getBottom() < i4) {
                tryOffsetChildrenTopAndBottom(i4 - lastChild.getBottom());
            }
            View childAt = getChildAt(0);
            while (childAt.getBottom() < i5) {
                if (hVar.n(((PLA_AbsListView.LayoutParams) childAt.getLayoutParams()).f31399a)) {
                    detachViewFromParent(childAt);
                    hVar.c(childAt);
                } else {
                    removeViewInLayout(childAt);
                }
                childAt = getChildAt(0);
                this.mFirstPosition++;
            }
            return;
        }
        View childAt2 = getChildAt(0);
        while (childAt2.getTop() > i5 && (i2 = this.mFirstPosition) > 0) {
            childAt2 = addViewAbove(childAt2, i2);
            this.mFirstPosition--;
        }
        if (childAt2.getTop() > i5) {
            tryOffsetChildrenTopAndBottom(i5 - childAt2.getTop());
        }
        int childCount2 = getChildCount() - 1;
        View childAt3 = getChildAt(childCount2);
        while (childAt3.getTop() > i4) {
            if (hVar.n(((PLA_AbsListView.LayoutParams) childAt3.getLayoutParams()).f31399a)) {
                detachViewFromParent(childAt3);
                hVar.c(childAt3);
            } else {
                removeViewInLayout(childAt3);
            }
            childCount2--;
            childAt3 = getChildAt(childCount2);
        }
    }

    private void setupChild(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        boolean z4 = z2 && shouldShowSelector();
        boolean z5 = z4 != view.isSelected();
        int i4 = this.mTouchMode;
        boolean z6 = i4 > 0 && i4 < 3 && this.mMotionPosition == i;
        boolean z7 = z6 != view.isPressed();
        boolean z8 = !z3 || z5 || view.isLayoutRequested();
        PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new PLA_AbsListView.LayoutParams(-1, -2, 0);
        }
        layoutParams.f31399a = this.mAdapter.getItemViewType(i);
        layoutParams.f31400b = i;
        if ((z3 && !layoutParams.f31402d) || (layoutParams.f31401c && layoutParams.f31399a == -2)) {
            attachViewToParent(view, z ? -1 : 0, layoutParams);
        } else {
            layoutParams.f31402d = false;
            if (layoutParams.f31399a == -2) {
                layoutParams.f31401c = true;
            }
            addViewInLayout(view, z ? -1 : 0, layoutParams, true);
        }
        if (z5) {
            view.setSelected(z4);
        }
        if (z7) {
            view.setPressed(z6);
        }
        if (z8) {
            int i5 = this.mWidthMeasureSpec;
            Rect rect = this.mListPadding;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, rect.left + rect.right, ((ViewGroup.LayoutParams) layoutParams).width);
            int i6 = ((ViewGroup.LayoutParams) layoutParams).height;
            if (i6 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            onMeasureChild(view, i, childMeasureSpec, makeMeasureSpec);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = z ? i2 : i2 - measuredHeight;
        if (z8) {
            onLayoutChild(view, i, i3, i7, i3 + measuredWidth, i7 + measuredHeight);
        } else {
            onOffsetChild(view, i, i3 - view.getLeft(), i7 - view.getTop());
        }
        if (!this.mCachingStarted || view.isDrawingCacheEnabled()) {
            return;
        }
        view.setDrawingCacheEnabled(true);
    }

    private boolean showingBottomFadingEdge() {
        int childCount = getChildCount();
        return (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1 || getChildAt(childCount + (-1)).getBottom() < (getScrollY() + getHeight()) - this.mListPadding.bottom;
    }

    private boolean showingTopFadingEdge() {
        return this.mFirstPosition > 0 || getChildAt(0).getTop() > getScrollY() + this.mListPadding.top;
    }

    public void addFooterView(View view, Object obj, boolean z) {
        addFooterView(view, obj, z, -1);
    }

    public void addHeaderView(View view, Object obj, boolean z, int i) {
        a aVar = new a();
        aVar.f31436a = view;
        aVar.f31437b = obj;
        aVar.f31438c = z;
        if (i >= 0 && i <= this.mHeaderViewInfos.size()) {
            this.mHeaderViewInfos.add(i, aVar);
        } else {
            this.mHeaderViewInfos.add(aVar);
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter instanceof d.i.a.a.b.a) {
            setAdapter(((d.i.a.a.b.a) listAdapter).getWrappedAdapter());
        } else if (listAdapter != null) {
            setAdapter(listAdapter);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    public void clearChoices() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x01c5, code lost:
        if (r8.isEnabled(r4 + 1) == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0118, code lost:
        if (r8.isEnabled(r7 + 1) == false) goto L65;
     */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        boolean z;
        ListAdapter listAdapter;
        int i;
        int i2;
        int i3;
        Paint paint;
        ListAdapter listAdapter2;
        int i4;
        Paint paint2;
        int i5 = this.mDividerHeight;
        Drawable drawable = this.mOverScrollHeader;
        Drawable drawable2 = this.mOverScrollFooter;
        int i6 = drawable != null ? 1 : 0;
        boolean z2 = drawable2 != null;
        boolean z3 = i5 > 0 && this.mDivider != null;
        drawContentBackground(canvas);
        if (z3 || i6 != 0 || z2) {
            Rect rect = this.mTempRect;
            rect.left = getPaddingLeft();
            rect.right = (getRight() - getLeft()) - getPaddingRight();
            int childCount = getChildCount();
            int size = this.mHeaderViewInfos.size();
            int i7 = this.mItemCount;
            int size2 = (i7 - this.mFooterViewInfos.size()) - 1;
            boolean z4 = this.mHeaderDividersEnabled;
            boolean z5 = this.mFooterDividersEnabled;
            int i8 = this.mFirstPosition;
            boolean z6 = this.mAreAllItemsSelectable;
            ListAdapter listAdapter3 = this.mAdapter;
            boolean z7 = z3 && isOpaque() && !super.isOpaque();
            if (z7) {
                listAdapter = listAdapter3;
                if (this.mDividerPaint == null && this.mIsCacheColorOpaque) {
                    Paint paint3 = new Paint();
                    this.mDividerPaint = paint3;
                    z = z6;
                    paint3.setColor(getCacheColorHint());
                } else {
                    z = z6;
                }
            } else {
                z = z6;
                listAdapter = listAdapter3;
            }
            Paint paint4 = this.mDividerPaint;
            int bottom = ((getBottom() - getTop()) - this.mListPadding.bottom) + getScrollY();
            boolean z8 = z2;
            if (!this.mStackFromBottom) {
                int scrollY = getScrollY();
                if (childCount > 0 && scrollY < 0) {
                    if (i6 != 0) {
                        rect.bottom = 0;
                        rect.top = scrollY;
                        drawOverscrollHeader(canvas, drawable, rect);
                    } else if (z3) {
                        rect.bottom = 0;
                        rect.top = -i5;
                        drawDivider(canvas, rect, -1);
                    }
                }
                int i9 = 0;
                int i10 = 0;
                while (i9 < childCount) {
                    if ((z4 || i8 + i9 >= size) && (z5 || i8 + i9 < size2)) {
                        i10 = getChildAt(i9).getBottom();
                        if (z3 && i10 < bottom && (!z8 || i9 != childCount - 1)) {
                            if (z) {
                                listAdapter2 = listAdapter;
                                i4 = bottom;
                            } else {
                                int i11 = i8 + i9;
                                listAdapter2 = listAdapter;
                                if (listAdapter2.isEnabled(i11)) {
                                    i4 = bottom;
                                    if (i9 != childCount - 1) {
                                    }
                                } else {
                                    i4 = bottom;
                                }
                                if (z7) {
                                    rect.top = i10;
                                    rect.bottom = i10 + i5;
                                    paint2 = paint4;
                                    canvas.drawRect(rect, paint2);
                                    i9++;
                                    paint4 = paint2;
                                    bottom = i4;
                                    listAdapter = listAdapter2;
                                }
                                paint2 = paint4;
                                i9++;
                                paint4 = paint2;
                                bottom = i4;
                                listAdapter = listAdapter2;
                            }
                            paint2 = paint4;
                            rect.top = i10;
                            rect.bottom = i10 + i5;
                            drawDivider(canvas, rect, i9);
                            i9++;
                            paint4 = paint2;
                            bottom = i4;
                            listAdapter = listAdapter2;
                        }
                    }
                    listAdapter2 = listAdapter;
                    i4 = bottom;
                    paint2 = paint4;
                    i9++;
                    paint4 = paint2;
                    bottom = i4;
                    listAdapter = listAdapter2;
                }
                int bottom2 = getBottom() + getScrollY();
                if (z8 && i8 + childCount == i7 && bottom2 > i10) {
                    rect.top = i10;
                    rect.bottom = bottom2;
                    drawOverscrollFooter(canvas, drawable2, rect);
                }
            } else {
                ListAdapter listAdapter4 = listAdapter;
                int i12 = this.mListPadding.top;
                int scrollY2 = getScrollY();
                if (childCount <= 0 || i6 == 0) {
                    i = i6;
                } else {
                    rect.top = scrollY2;
                    i = i6;
                    rect.bottom = getChildAt(0).getTop();
                    drawOverscrollHeader(canvas, drawable, rect);
                }
                int i13 = i;
                while (i13 < childCount) {
                    if ((z4 || i8 + i13 >= size) && (z5 || i8 + i13 < size2)) {
                        int top = getChildAt(i13).getTop();
                        if (z3 && top > i12) {
                            i2 = i12;
                            if (z) {
                                i3 = i8;
                            } else {
                                int i14 = i8 + i13;
                                if (listAdapter4.isEnabled(i14)) {
                                    i3 = i8;
                                    if (i13 != childCount - 1) {
                                    }
                                } else {
                                    i3 = i8;
                                }
                                if (z7) {
                                    rect.top = top - i5;
                                    rect.bottom = top;
                                    paint = paint4;
                                    canvas.drawRect(rect, paint);
                                    i13++;
                                    paint4 = paint;
                                    i12 = i2;
                                    i8 = i3;
                                }
                                paint = paint4;
                                i13++;
                                paint4 = paint;
                                i12 = i2;
                                i8 = i3;
                            }
                            paint = paint4;
                            rect.top = top - i5;
                            rect.bottom = top;
                            drawDivider(canvas, rect, i13 - 1);
                            i13++;
                            paint4 = paint;
                            i12 = i2;
                            i8 = i3;
                        }
                    }
                    i2 = i12;
                    i3 = i8;
                    paint = paint4;
                    i13++;
                    paint4 = paint;
                    i12 = i2;
                    i8 = i3;
                }
                if (childCount > 0 && scrollY2 > 0) {
                    if (z8) {
                        int bottom3 = getBottom();
                        rect.top = bottom3;
                        rect.bottom = bottom3 + scrollY2;
                        drawOverscrollFooter(canvas, drawable2, rect);
                    } else if (z3) {
                        rect.top = bottom;
                        rect.bottom = bottom + i5;
                        drawDivider(canvas, rect, -1);
                    }
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        if (!dispatchPopulateAccessibilityEvent) {
            int selectedItemPosition = getSelectedItemPosition();
            ListAdapter adapter = getAdapter();
            int i = 0;
            if (adapter != null) {
                int count = adapter.getCount();
                if (count < 15) {
                    int i2 = 0;
                    while (i < count) {
                        if (adapter.isEnabled(i)) {
                            i2++;
                        } else if (i <= selectedItemPosition) {
                            selectedItemPosition--;
                        }
                        i++;
                    }
                    i = i2;
                } else {
                    i = count;
                }
            }
            accessibilityEvent.setItemCount(i);
            accessibilityEvent.setCurrentItemIndex(selectedItemPosition);
        }
        return dispatchPopulateAccessibilityEvent;
    }

    public void drawDivider(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.mDivider;
        boolean z = this.mClipDivider;
        if (!z) {
            drawable.setBounds(rect);
        } else {
            canvas.save();
            canvas.clipRect(rect);
        }
        drawable.draw(canvas);
        if (z) {
            canvas.restore();
        }
    }

    public void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumHeight = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(rect);
        int i = rect.bottom;
        int i2 = rect.top;
        if (i - i2 < minimumHeight) {
            rect.bottom = i2 + minimumHeight;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    public void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumHeight = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(rect);
        int i = rect.bottom;
        if (i - rect.top < minimumHeight) {
            rect.top = i - minimumHeight;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void fillGap(boolean z) {
        int childCount = getChildCount();
        if (z) {
            fillDown(this.mFirstPosition + childCount, getFillChildBottom() + this.mDividerHeight);
        } else {
            fillUp(this.mFirstPosition - 1, getFillChildTop());
        }
        onAdjustChildViews(z);
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int findMotionRow(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mStackFromBottom) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getTop()) {
                        return this.mFirstPosition + i2;
                    }
                }
                return -1;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i <= getChildAt(i3).getBottom()) {
                    return this.mFirstPosition + i3;
                }
            }
            return -1;
        }
        return -1;
    }

    public boolean fullScroll(int i) {
        boolean z = false;
        if (i == 33) {
            if (lookForSelectablePosition(0, true) >= 0) {
                this.mLayoutMode = 1;
                invokeOnItemScrollListener();
                z = true;
            }
        } else if (i == 130) {
            if (lookForSelectablePosition(this.mItemCount - 1, true) >= 0) {
                this.mLayoutMode = 3;
                invokeOnItemScrollListener();
            }
            z = true;
        }
        if (z && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return z;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        ListAdapter listAdapter = this.mAdapter;
        return (listAdapter == null || !listAdapter.hasStableIds()) ? new long[0] : getCheckedItemIds();
    }

    public long[] getCheckedItemIds() {
        return new long[0];
    }

    public int getCheckedItemPosition() {
        return -1;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        return null;
    }

    public Drawable getDivider() {
        return this.mDivider;
    }

    public int getDividerHeight() {
        return this.mDividerHeight;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int getFirstVisiblePosition() {
        return Math.max(0, this.mFirstPosition - getHeaderViewsCount());
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFooterViewsCount() {
        return this.mFooterViewInfos.size();
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getHeaderViewsCount() {
        return this.mHeaderViewInfos.size();
    }

    public int getItemBottom(int i) {
        int height;
        int listPaddingBottom;
        if (getChildCount() > 0) {
            height = getChildAt(0).getTop();
            listPaddingBottom = this.mDividerHeight;
        } else {
            height = getHeight();
            listPaddingBottom = getListPaddingBottom();
        }
        return height - listPaddingBottom;
    }

    public int getItemLeft(int i) {
        return this.mListPadding.left;
    }

    public int getItemTop(int i) {
        int childCount = getChildCount();
        return childCount > 0 ? getChildAt(childCount - 1).getBottom() + this.mDividerHeight : getListPaddingTop();
    }

    public boolean getItemsCanFocus() {
        return this.mItemsCanFocus;
    }

    public View getLastChild() {
        return getChildAt(getChildCount() - 1);
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int getLastVisiblePosition() {
        return Math.min((this.mFirstPosition + getChildCount()) - 1, this.mAdapter.getCount() - 1);
    }

    public int getMaxScrollAmount() {
        return (int) ((getBottom() - getTop()) * 0.33f);
    }

    public Drawable getOverscrollFooter() {
        return this.mOverScrollFooter;
    }

    public Drawable getOverscrollHeader() {
        return this.mOverScrollHeader;
    }

    public boolean isFixedView(View view) {
        ArrayList<a> arrayList = this.mHeaderViewInfos;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).f31436a == view) {
                return true;
            }
        }
        ArrayList<a> arrayList2 = this.mFooterViewInfos;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (arrayList2.get(i2).f31436a == view) {
                return true;
            }
        }
        return false;
    }

    public boolean isItemChecked(int i) {
        return false;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        return (this.mCachingStarted && this.mIsCacheColorOpaque && this.mDividerIsOpaque) || super.isOpaque();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IPUT] complete} */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void layoutChildren() {
        boolean z = this.mBlockLayoutRequests;
        if (z) {
            return;
        }
        this.mBlockLayoutRequests = true;
        try {
            invalidate();
            if (this.mAdapter == null) {
                resetList();
                invokeOnItemScrollListener();
                if (z) {
                    return;
                }
                return;
            }
            int fillChildBottom = getFillChildBottom() + this.mDividerHeight;
            int fillChildTop = getFillChildTop();
            int childCount = getChildCount();
            int i = this.mLayoutMode;
            View childAt = (i == 1 || i == 3 || i == 4 || i == 5) ? null : getChildAt(0);
            boolean z2 = this.mDataChanged;
            if (z2) {
                handleDataChanged();
            }
            if (this.mItemCount == 0) {
                resetList();
                invokeOnItemScrollListener();
                if (z) {
                    return;
                }
                this.mBlockLayoutRequests = false;
            } else if (this.mItemCount == this.mAdapter.getCount()) {
                int i2 = this.mFirstPosition;
                PLA_AbsListView.h hVar = this.mRecycler;
                if (z2) {
                    for (int i3 = childCount - 1; i3 >= 0; i3--) {
                        hVar.c(getChildAt(i3));
                    }
                } else {
                    hVar.e(childCount, i2);
                }
                int i4 = this.mLayoutMode;
                if (i4 == 1) {
                    detachAllViewsFromParent();
                    this.mFirstPosition = 0;
                    fillFromTop(fillChildBottom);
                    adjustViewsUpOrDown();
                } else if (i4 == 3) {
                    detachAllViewsFromParent();
                    fillUp(this.mItemCount - 1, fillChildTop);
                    adjustViewsUpOrDown();
                } else if (i4 == 4) {
                    detachAllViewsFromParent();
                    fillSpecific(reconcileSelectedPosition(), this.mSpecificTop);
                } else if (i4 == 5) {
                    onLayoutSync(this.mSyncPosition);
                    detachAllViewsFromParent();
                    if (this.mSpecificTops != null) {
                        fillSynced(this.mSyncPosition, this.mSpecificTops);
                        this.mSpecificTops = null;
                    } else {
                        fillSpecific(this.mSyncPosition, this.mSpecificTop);
                    }
                    onLayoutSyncFinished(this.mSyncPosition);
                } else if (childCount == 0) {
                    detachAllViewsFromParent();
                    if (!this.mStackFromBottom) {
                        fillFromTop(fillChildBottom);
                    } else {
                        fillUp(this.mItemCount - 1, fillChildTop);
                    }
                } else if (this.mFirstPosition < this.mItemCount) {
                    onLayoutSync(this.mFirstPosition);
                    detachAllViewsFromParent();
                    int i5 = this.mFirstPosition;
                    if (childAt != null) {
                        fillChildBottom = childAt.getTop();
                    }
                    fillSpecific(i5, fillChildBottom);
                    onLayoutSyncFinished(this.mFirstPosition);
                } else {
                    onLayoutSync(0);
                    detachAllViewsFromParent();
                    fillSpecific(0, fillChildBottom);
                    onLayoutSyncFinished(0);
                }
                hVar.k();
                if (this.mTouchMode > 0 && this.mTouchMode < 3) {
                    View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                    if (childAt2 != null) {
                        positionSelector(childAt2);
                    }
                } else {
                    this.mSelectedTop = 0;
                    this.mSelectorRect.setEmpty();
                }
                this.mLayoutMode = 0;
                this.mDataChanged = false;
                this.mNeedSync = false;
                if (this.mItemCount > 0) {
                    checkSelectionChanged();
                }
                invokeOnItemScrollListener();
                if (z) {
                    return;
                }
                this.mBlockLayoutRequests = false;
            } else {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            }
        } finally {
            if (!z) {
                this.mBlockLayoutRequests = false;
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int lookForSelectablePosition(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && !isInTouchMode()) {
            int count = listAdapter.getCount();
            if (!this.mAreAllItemsSelectable) {
                if (z) {
                    min = Math.max(0, i);
                    while (min < count && !listAdapter.isEnabled(min)) {
                        min++;
                    }
                } else {
                    min = Math.min(i, count - 1);
                    while (min >= 0 && !listAdapter.isEnabled(min)) {
                        min--;
                    }
                }
                if (min < 0 || min >= count) {
                    return -1;
                }
                return min;
            } else if (i >= 0 && i < count) {
                return i;
            }
        }
        return -1;
    }

    public final int measureHeightOfChildren(int i, int i2, int i3, int i4, int i5) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            Rect rect = this.mListPadding;
            return rect.top + rect.bottom;
        }
        Rect rect2 = this.mListPadding;
        int i6 = rect2.top + rect2.bottom;
        int i7 = 0;
        int i8 = (this.mDividerHeight <= 0 || this.mDivider == null) ? 0 : 0;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        PLA_AbsListView.h hVar = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        while (i2 <= i3) {
            d.i.a.a.a.c("measureHeightOfChildren:" + i2);
            View obtainView = obtainView(i2, zArr);
            measureScrapChild(obtainView, i2, i);
            if (i2 > 0) {
                i6 += i8;
            }
            if (recycleOnMeasure && hVar.n(((PLA_AbsListView.LayoutParams) obtainView.getLayoutParams()).f31399a)) {
                d.i.a.a.a.c("measureHeightOfChildren");
                hVar.c(obtainView);
            }
            i6 += obtainView.getMeasuredHeight();
            if (i6 >= i4) {
                return (i5 < 0 || i2 <= i5 || i7 <= 0 || i6 == i4) ? i4 : i7;
            }
            if (i5 >= 0 && i2 >= i5) {
                i7 = i6;
            }
            i2++;
        }
        return i6;
    }

    public void onAdjustChildViews(boolean z) {
        if (z) {
            correctTooHigh(getChildCount());
        } else {
            correctTooLow(getChildCount());
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                addHeaderView(getChildAt(i));
            }
            removeAllViews();
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        int i2 = -1;
        if (z && rect != null) {
            rect.offset(getScrollX(), getScrollY());
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter.getCount() < getChildCount() + this.mFirstPosition) {
                this.mLayoutMode = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int i3 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i4 = this.mFirstPosition;
            for (int i5 = 0; i5 < childCount; i5++) {
                if (listAdapter.isEnabled(i4 + i5)) {
                    View childAt = getChildAt(i5);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int distance = PLA_AbsListView.getDistance(rect, rect2, i);
                    if (distance < i3) {
                        i2 = i5;
                        i3 = distance;
                    }
                }
            }
        }
        if (i2 >= 0) {
            setSelection(i2 + this.mFirstPosition);
        } else {
            requestLayout();
        }
    }

    public void onItemAddedToList(int i, boolean z) {
    }

    public void onLayoutChild(View view, int i, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4, i5);
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        ListAdapter listAdapter = this.mAdapter;
        int i4 = 0;
        int count = listAdapter == null ? 0 : listAdapter.getCount();
        this.mItemCount = count;
        if (count <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
        } else {
            View obtainView = obtainView(0, this.mIsScrap);
            measureScrapChild(obtainView, 0, i);
            i4 = obtainView.getMeasuredWidth();
            i3 = obtainView.getMeasuredHeight();
            if (recycleOnMeasure() && this.mRecycler.n(((PLA_AbsListView.LayoutParams) obtainView.getLayoutParams()).f31399a)) {
                this.mRecycler.c(obtainView);
            }
        }
        if (mode == 0) {
            Rect rect = this.mListPadding;
            size = rect.left + rect.right + i4 + getVerticalScrollbarWidth();
        }
        if (mode2 == 0) {
            Rect rect2 = this.mListPadding;
            size2 = (getVerticalFadingEdgeLength() * 2) + rect2.top + rect2.bottom + i3;
        }
        int i5 = size2;
        if (mode2 == Integer.MIN_VALUE) {
            i5 = measureHeightOfChildren(i, 0, -1, i5, -1);
        }
        setMeasuredDimension(size, i5);
        this.mWidthMeasureSpec = i;
    }

    public void onMeasureChild(View view, int i, int i2, int i3) {
        view.measure(i2, i3);
    }

    public void onOffsetChild(View view, int i, int i2, int i3) {
        view.offsetLeftAndRight(i2);
        view.offsetTopAndBottom(i3);
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mItemsCanFocus && motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public boolean performItemClick(View view, int i, long j) {
        return super.performItemClick(view, i, j) | false;
    }

    @ViewDebug.ExportedProperty(category = "list")
    public boolean recycleOnMeasure() {
        return true;
    }

    public boolean removeFooterView(View view) {
        boolean z = false;
        if (this.mFooterViewInfos.size() > 0) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && ((d.i.a.a.b.a) listAdapter).d(view)) {
                this.mDataSetObserver.onChanged();
                z = true;
            }
            removeFixedViewInfo(view, this.mFooterViewInfos);
        }
        return z;
    }

    public boolean removeHeaderView(View view) {
        boolean z = false;
        if (this.mHeaderViewInfos.size() > 0) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && ((d.i.a.a.b.a) listAdapter).e(view)) {
                this.mDataSetObserver.onChanged();
                z = true;
            }
            removeFixedViewInfo(view, this.mHeaderViewInfos);
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int i;
        int i2;
        int i3;
        int i4 = rect.top;
        rect.offset(view.getLeft(), view.getTop());
        rect.offset(-view.getScrollX(), -view.getScrollY());
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (showingTopFadingEdge() && i4 > verticalFadingEdgeLength) {
            scrollY += verticalFadingEdgeLength;
        }
        int bottom = getChildAt(getChildCount() - 1).getBottom();
        if (showingBottomFadingEdge() && rect.bottom < bottom - verticalFadingEdgeLength) {
            i5 -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i5 && rect.top > scrollY) {
            if (rect.height() > height) {
                i3 = rect.top - scrollY;
            } else {
                i3 = rect.bottom - i5;
            }
            i = Math.min(i3 + 0, bottom - i5);
        } else if (rect.top >= scrollY || rect.bottom >= i5) {
            i = 0;
        } else {
            if (rect.height() > height) {
                i2 = 0 - (i5 - rect.bottom);
            } else {
                i2 = 0 - (scrollY - rect.top);
            }
            i = Math.max(i2, getChildAt(0).getTop() - scrollY);
        }
        boolean z2 = i != 0;
        if (z2) {
            scrollListItemsBy(-i);
            positionSelector(view);
            this.mSelectedTop = view.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void resetList() {
        clearRecycledState(this.mHeaderViewInfos);
        clearRecycledState(this.mFooterViewInfos);
        super.resetList();
        this.mLayoutMode = 0;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void setCacheColorHint(int i) {
        boolean z = (i >>> 24) == 255;
        this.mIsCacheColorOpaque = z;
        if (z) {
            if (this.mDividerPaint == null) {
                this.mDividerPaint = new Paint();
            }
            this.mDividerPaint.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    public void setContentBackgroundColor(int i) {
        Paint paint = new Paint();
        this.mContentPaint = paint;
        paint.setColor(i);
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.mDividerHeight = drawable.getIntrinsicHeight();
            this.mClipDivider = drawable instanceof ColorDrawable;
        } else {
            this.mDividerHeight = 0;
            this.mClipDivider = false;
        }
        this.mDivider = drawable;
        this.mDividerIsOpaque = (drawable == null || drawable.getOpacity() == -1) ? true : true;
        requestLayoutIfNecessary();
    }

    public void setDividerHeight(int i) {
        this.mDividerHeight = i;
        requestLayoutIfNecessary();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.mFooterDividersEnabled = z;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.mHeaderDividersEnabled = z;
        invalidate();
    }

    public void setItemChecked(int i, boolean z) {
    }

    public void setItemsCanFocus(boolean z) {
        this.mItemsCanFocus = z;
        if (z) {
            return;
        }
        setDescendantFocusability(393216);
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.mOverScrollFooter = drawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.mOverScrollHeader = drawable;
        if (getScrollY() < 0) {
            invalidate();
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setSelection(int i) {
    }

    public void setSelectionFromTop(int i, int i2) {
        this.mLayoutMode = 4;
        this.mSpecificTop = this.mListPadding.top + i2;
        if (this.mNeedSync) {
            this.mSyncPosition = i;
            this.mSyncRowId = this.mAdapter.getItemId(i);
        }
        PLA_AbsListView.g gVar = this.mPositionScroller;
        if (gVar != null) {
            gVar.c();
        }
        requestLayout();
    }

    public PLA_ListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        a aVar = new a();
        aVar.f31436a = view;
        aVar.f31437b = obj;
        aVar.f31438c = z;
        if (i >= 0 && i <= this.mFooterViewInfos.size()) {
            this.mFooterViewInfos.add(i, aVar);
        } else {
            this.mFooterViewInfos.add(aVar);
        }
        PLA_AdapterView<ListAdapter>.c cVar = this.mDataSetObserver;
        if (cVar != null) {
            cVar.onChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.mDataSetObserver);
        }
        resetList();
        this.mRecycler.d();
        if (this.mHeaderViewInfos.size() <= 0 && this.mFooterViewInfos.size() <= 0) {
            this.mAdapter = listAdapter;
        } else {
            this.mAdapter = new d.i.a.a.b.a(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        }
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        ListAdapter listAdapter3 = this.mAdapter;
        if (listAdapter3 != null) {
            this.mAreAllItemsSelectable = listAdapter3.areAllItemsEnabled();
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            PLA_AdapterView<ListAdapter>.c cVar = new PLA_AdapterView.c();
            this.mDataSetObserver = cVar;
            this.mAdapter.registerDataSetObserver(cVar);
            this.mRecycler.m(this.mAdapter.getViewTypeCount());
        } else {
            this.mAreAllItemsSelectable = true;
        }
        requestLayout();
    }

    public PLA_ListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mAreAllItemsSelectable = true;
        this.mItemsCanFocus = false;
        this.mTempRect = new Rect();
        this.mContentPaint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListView, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ListView_overScrollHeader);
        if (drawable != null) {
            setOverscrollHeader(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.ListView_overScrollFooter);
        if (drawable2 != null) {
            setOverscrollFooter(drawable2);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ListView_dividerHeight, 0);
        if (dimensionPixelSize != 0) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mHeaderDividersEnabled = obtainStyledAttributes.getBoolean(R$styleable.ListView_headerDividersEnabled, true);
        this.mFooterDividersEnabled = obtainStyledAttributes.getBoolean(R$styleable.ListView_footerDividersEnabled, true);
        if (obtainStyledAttributes.hasValue(R$styleable.ListView_plaContentBackground)) {
            int color = obtainStyledAttributes.getColor(R$styleable.ListView_plaContentBackground, 0);
            Paint paint = new Paint();
            this.mContentPaint = paint;
            paint.setColor(color);
        }
        obtainStyledAttributes.recycle();
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true);
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        addHeaderView(view, obj, z, -1);
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }
}
