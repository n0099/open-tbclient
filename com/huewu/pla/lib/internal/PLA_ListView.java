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
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.tieba.R;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class PLA_ListView extends PLA_AbsListView {
    private static final float MAX_SCROLL_FACTOR = 0.33f;
    static final int NO_POSITION = -1;
    private boolean mAreAllItemsSelectable;
    private boolean mClipDivider;
    private Paint mContentPaint;
    Drawable mDivider;
    int mDividerHeight;
    private boolean mDividerIsOpaque;
    private Paint mDividerPaint;
    private boolean mFooterDividersEnabled;
    private ArrayList<a> mFooterViewInfos;
    private boolean mHeaderDividersEnabled;
    private ArrayList<a> mHeaderViewInfos;
    private boolean mIsCacheColorOpaque;
    private boolean mItemsCanFocus;
    Drawable mOverScrollFooter;
    Drawable mOverScrollHeader;
    private final Rect mTempRect;

    /* loaded from: classes9.dex */
    public class a {
        public Object data;
        public boolean isSelectable;
        public View view;

        public a() {
        }
    }

    public PLA_ListView(Context context) {
        this(context, null);
    }

    public PLA_ListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public PLA_ListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mAreAllItemsSelectable = true;
        this.mItemsCanFocus = false;
        this.mTempRect = new Rect();
        this.mContentPaint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListView, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ListView_overScrollHeader);
        if (drawable != null) {
            setOverscrollHeader(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ListView_overScrollFooter);
        if (drawable2 != null) {
            setOverscrollFooter(drawable2);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ListView_dividerHeight, 0);
        if (dimensionPixelSize != 0) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mHeaderDividersEnabled = obtainStyledAttributes.getBoolean(R.styleable.ListView_headerDividersEnabled, true);
        this.mFooterDividersEnabled = obtainStyledAttributes.getBoolean(R.styleable.ListView_footerDividersEnabled, true);
        if (obtainStyledAttributes.hasValue(R.styleable.ListView_plaContentBackground)) {
            int color = obtainStyledAttributes.getColor(R.styleable.ListView_plaContentBackground, 0);
            this.mContentPaint = new Paint();
            this.mContentPaint.setColor(color);
        }
        obtainStyledAttributes.recycle();
    }

    public int getMaxScrollAmount() {
        return (int) (MAX_SCROLL_FACTOR * (getBottom() - getTop()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r1 <= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r1 < 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void adjustViewsUpOrDown() {
        int scrollChildBottom;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.mStackFromBottom) {
                scrollChildBottom = getScrollChildTop() - this.mListPadding.top;
                if (this.mFirstPosition != 0) {
                    scrollChildBottom -= this.mDividerHeight;
                }
            } else {
                scrollChildBottom = getScrollChildBottom() - (getHeight() - this.mListPadding.bottom);
                if (childCount + this.mFirstPosition < this.mItemCount) {
                    scrollChildBottom += this.mDividerHeight;
                }
            }
            if (i != 0) {
                tryOffsetChildrenTopAndBottom(-i);
            }
        }
    }

    public void addHeaderView(View view, Object obj, boolean z, int i) {
        a aVar = new a();
        aVar.view = view;
        aVar.data = obj;
        aVar.isSelectable = z;
        if (i < 0 || i > this.mHeaderViewInfos.size()) {
            this.mHeaderViewInfos.add(aVar);
        } else {
            this.mHeaderViewInfos.add(i, aVar);
        }
        if (this.mAdapter instanceof com.huewu.pla.lib.internal.a) {
            setAdapter(((com.huewu.pla.lib.internal.a) this.mAdapter).getWrappedAdapter());
        } else if (this.mAdapter != null) {
            setAdapter(this.mAdapter);
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        addHeaderView(view, obj, z, -1);
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getHeaderViewsCount() {
        return this.mHeaderViewInfos.size();
    }

    public boolean isFixedView(View view) {
        ArrayList<a> arrayList = this.mHeaderViewInfos;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).view == view) {
                return true;
            }
        }
        ArrayList<a> arrayList2 = this.mFooterViewInfos;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (arrayList2.get(i2).view == view) {
                return true;
            }
        }
        return false;
    }

    public boolean removeHeaderView(View view) {
        boolean z;
        if (this.mHeaderViewInfos.size() > 0) {
            if (this.mAdapter == null || !((com.huewu.pla.lib.internal.a) this.mAdapter).removeHeader(view)) {
                z = false;
            } else {
                this.mDataSetObserver.onChanged();
                z = true;
            }
            removeFixedViewInfo(view, this.mHeaderViewInfos);
            return z;
        }
        return false;
    }

    private void removeFixedViewInfo(View view, ArrayList<a> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).view == view) {
                arrayList.remove(i);
                return;
            }
        }
    }

    public void addFooterView(View view, Object obj, boolean z) {
        addFooterView(view, obj, z, -1);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        a aVar = new a();
        aVar.view = view;
        aVar.data = obj;
        aVar.isSelectable = z;
        if (i < 0 || i > this.mFooterViewInfos.size()) {
            this.mFooterViewInfos.add(aVar);
        } else {
            this.mFooterViewInfos.add(i, aVar);
        }
        if (this.mDataSetObserver != null) {
            this.mDataSetObserver.onChanged();
        }
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true);
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFooterViewsCount() {
        return this.mFooterViewInfos.size();
    }

    public boolean removeFooterView(View view) {
        boolean z;
        if (this.mFooterViewInfos.size() > 0) {
            if (this.mAdapter == null || !((com.huewu.pla.lib.internal.a) this.mAdapter).removeFooter(view)) {
                z = false;
            } else {
                this.mDataSetObserver.onChanged();
                z = true;
            }
            removeFixedViewInfo(view, this.mFooterViewInfos);
            return z;
        }
        return false;
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
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        resetList();
        this.mRecycler.clear();
        if (this.mHeaderViewInfos.size() > 0 || this.mFooterViewInfos.size() > 0) {
            this.mAdapter = new com.huewu.pla.lib.internal.a(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        if (this.mAdapter != null) {
            this.mAreAllItemsSelectable = this.mAdapter.areAllItemsEnabled();
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            this.mDataSetObserver = new PLA_AdapterView.b();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            this.mRecycler.en(this.mAdapter.getViewTypeCount());
        } else {
            this.mAreAllItemsSelectable = true;
        }
        requestLayout();
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int getFirstVisiblePosition() {
        return Math.max(0, this.mFirstPosition - getHeaderViewsCount());
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int getLastVisiblePosition() {
        return Math.min((this.mFirstPosition + getChildCount()) - 1, this.mAdapter.getCount() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void resetList() {
        clearRecycledState(this.mHeaderViewInfos);
        clearRecycledState(this.mFooterViewInfos);
        super.resetList();
        this.mLayoutMode = 0;
    }

    private void clearRecycledState(ArrayList<a> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) arrayList.get(i).view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.bDK = false;
                }
            }
        }
    }

    private boolean showingTopFadingEdge() {
        return this.mFirstPosition > 0 || getChildAt(0).getTop() > getScrollY() + this.mListPadding.top;
    }

    private boolean showingBottomFadingEdge() {
        int childCount = getChildCount();
        return (childCount + this.mFirstPosition) + (-1) < this.mItemCount + (-1) || getChildAt(childCount + (-1)).getBottom() < (getScrollY() + getHeight()) - this.mListPadding.bottom;
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
                i3 = (rect.top - scrollY) + 0;
            } else {
                i3 = (rect.bottom - i5) + 0;
            }
            i = Math.min(i3, bottom - i5);
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

    protected int getItemLeft(int i) {
        return this.mListPadding.left;
    }

    protected int getItemTop(int i) {
        int childCount = getChildCount();
        return childCount > 0 ? getChildAt(childCount - 1).getBottom() + this.mDividerHeight : getListPaddingTop();
    }

    protected int getItemBottom(int i) {
        return getChildCount() > 0 ? getChildAt(0).getTop() - this.mDividerHeight : getHeight() - getListPaddingBottom();
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    protected void fillGap(boolean z) {
        int childCount = getChildCount();
        if (z) {
            fillDown(childCount + this.mFirstPosition, getFillChildBottom() + this.mDividerHeight);
        } else {
            fillUp(this.mFirstPosition - 1, getFillChildTop());
        }
        onAdjustChildViews(z);
    }

    private View fillDown(int i, int i2) {
        com.huewu.pla.lib.a.i("fill down: " + i);
        int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
        while (i2 < bottom && i < this.mItemCount) {
            makeAndAddView(i, getItemTop(i), true, false);
            i++;
            i2 = getFillChildBottom() + this.mDividerHeight;
        }
        return null;
    }

    private View fillUp(int i, int i2) {
        com.huewu.pla.lib.a.i("fill up: " + i);
        int i3 = this.mListPadding.top;
        while (i2 > i3 && i >= 0) {
            makeAndAddView(i, getItemBottom(i), false, false);
            i--;
            i2 = getItemBottom(i);
        }
        this.mFirstPosition = i + 1;
        return null;
    }

    private View fillFromTop(int i) {
        this.mFirstPosition = Math.min(this.mFirstPosition, -1);
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mItemCount - 1);
        if (this.mFirstPosition < 0) {
            this.mFirstPosition = 0;
        }
        return fillDown(this.mFirstPosition, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mItemCount = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View obtainView = obtainView(0, this.mIsScrap);
            measureScrapChild(obtainView, 0, i);
            int measuredWidth = obtainView.getMeasuredWidth();
            i3 = obtainView.getMeasuredHeight();
            if (recycleOnMeasure() && this.mRecycler.eo(((PLA_AbsListView.LayoutParams) obtainView.getLayoutParams()).bDJ)) {
                this.mRecycler.ex(obtainView);
            }
            i4 = measuredWidth;
        }
        int verticalScrollbarWidth = mode == 0 ? i4 + this.mListPadding.left + this.mListPadding.right + getVerticalScrollbarWidth() : size;
        if (mode2 == 0) {
            size2 = this.mListPadding.top + this.mListPadding.bottom + i3 + (getVerticalFadingEdgeLength() * 2);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = measureHeightOfChildren(i, 0, -1, size2, -1);
        }
        setMeasuredDimension(verticalScrollbarWidth, size2);
        this.mWidthMeasureSpec = i;
    }

    private void measureScrapChild(View view, int i, int i2) {
        int makeMeasureSpec;
        PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new PLA_AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        layoutParams.bDJ = this.mAdapter.getItemViewType(i);
        layoutParams.bDL = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.mListPadding.left + this.mListPadding.right, layoutParams.width);
        int i3 = layoutParams.height;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    @ViewDebug.ExportedProperty(category = "list")
    protected boolean recycleOnMeasure() {
        return true;
    }

    final int measureHeightOfChildren(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.mListPadding.top + this.mListPadding.bottom;
        }
        int i7 = this.mListPadding.top + this.mListPadding.bottom;
        int i8 = (this.mDividerHeight <= 0 || this.mDivider == null) ? 0 : this.mDividerHeight;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        PLA_AbsListView.f fVar = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        while (i2 <= i3) {
            com.huewu.pla.lib.a.i("measureHeightOfChildren:" + i2);
            View obtainView = obtainView(i2, zArr);
            measureScrapChild(obtainView, i2, i);
            int i9 = i2 > 0 ? i7 + i8 : i7;
            if (recycleOnMeasure && fVar.eo(((PLA_AbsListView.LayoutParams) obtainView.getLayoutParams()).bDJ)) {
                com.huewu.pla.lib.a.i("measureHeightOfChildren");
                fVar.ex(obtainView);
            }
            i7 = obtainView.getMeasuredHeight() + i9;
            if (i7 >= i4) {
                return (i5 < 0 || i2 <= i5 || i6 <= 0 || i7 == i4) ? i4 : i6;
            }
            if (i5 >= 0 && i2 >= i5) {
                i6 = i7;
            }
            i2++;
        }
        return i7;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    int findMotionRow(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mStackFromBottom) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getTop()) {
                        return i2 + this.mFirstPosition;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getBottom()) {
                        return i3 + this.mFirstPosition;
                    }
                }
            }
        }
        return -1;
    }

    private View fillSpecific(int i, int i2) {
        if (this.mDataChanged) {
            com.huewu.pla.lib.a.i("fill specific: " + i + ":" + i2);
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

    private void correctTooHigh(int i) {
        if ((this.mFirstPosition + i) - 1 == this.mItemCount - 1 && i > 0) {
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
    }

    private void correctTooLow(int i) {
        if (this.mFirstPosition == 0 && i > 0) {
            int scrollChildTop = getScrollChildTop();
            int i2 = this.mListPadding.top;
            int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
            int i3 = scrollChildTop - i2;
            int scrollChildBottom = getScrollChildBottom();
            int i4 = (this.mFirstPosition + i) - 1;
            if (i3 > 0) {
                if (i4 < this.mItemCount - 1 || scrollChildBottom > bottom) {
                    if (i4 == this.mItemCount - 1) {
                        i3 = Math.min(i3, scrollChildBottom - bottom);
                    }
                    tryOffsetChildrenTopAndBottom(-i3);
                    if (i4 < this.mItemCount - 1) {
                        fillDown(i4 + 1, getFillChildBottom() + this.mDividerHeight);
                        adjustViewsUpOrDown();
                    }
                } else if (i4 == this.mItemCount - 1) {
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IPUT] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1275=4, 1276=4] */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    protected void layoutChildren() {
        View view;
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
            switch (this.mLayoutMode) {
                case 1:
                case 3:
                case 4:
                case 5:
                    view = null;
                    break;
                case 2:
                default:
                    view = getChildAt(0);
                    break;
            }
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
            } else if (this.mItemCount != this.mAdapter.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            } else {
                int i = this.mFirstPosition;
                PLA_AbsListView.f fVar = this.mRecycler;
                if (z2) {
                    for (int i2 = childCount - 1; i2 >= 0; i2--) {
                        fVar.ex(getChildAt(i2));
                    }
                } else {
                    fVar.K(childCount, i);
                }
                switch (this.mLayoutMode) {
                    case 1:
                        detachAllViewsFromParent();
                        this.mFirstPosition = 0;
                        fillFromTop(fillChildBottom);
                        adjustViewsUpOrDown();
                        break;
                    case 2:
                    default:
                        if (childCount == 0) {
                            detachAllViewsFromParent();
                            if (this.mStackFromBottom) {
                                fillUp(this.mItemCount - 1, fillChildTop);
                                break;
                            } else {
                                fillFromTop(fillChildBottom);
                                break;
                            }
                        } else if (this.mFirstPosition < this.mItemCount) {
                            onLayoutSync(this.mFirstPosition);
                            detachAllViewsFromParent();
                            int i3 = this.mFirstPosition;
                            if (view != null) {
                                fillChildBottom = view.getTop();
                            }
                            fillSpecific(i3, fillChildBottom);
                            onLayoutSyncFinished(this.mFirstPosition);
                            break;
                        } else {
                            onLayoutSync(0);
                            detachAllViewsFromParent();
                            fillSpecific(0, fillChildBottom);
                            onLayoutSyncFinished(0);
                            break;
                        }
                    case 3:
                        detachAllViewsFromParent();
                        fillUp(this.mItemCount - 1, fillChildTop);
                        adjustViewsUpOrDown();
                        break;
                    case 4:
                        detachAllViewsFromParent();
                        fillSpecific(reconcileSelectedPosition(), this.mSpecificTop);
                        break;
                    case 5:
                        onLayoutSync(this.mSyncPosition);
                        detachAllViewsFromParent();
                        if (this.mSpecificTops != null) {
                            fillSynced(this.mSyncPosition, this.mSpecificTops);
                            this.mSpecificTops = null;
                        } else {
                            fillSpecific(this.mSyncPosition, this.mSpecificTop);
                        }
                        onLayoutSyncFinished(this.mSyncPosition);
                        break;
                }
                fVar.Sc();
                if (this.mTouchMode <= 0 || this.mTouchMode >= 3) {
                    this.mSelectedTop = 0;
                    this.mSelectorRect.setEmpty();
                } else {
                    View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
                    if (childAt != null) {
                        positionSelector(childAt);
                    }
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
            }
        } finally {
            if (!z) {
                this.mBlockLayoutRequests = false;
            }
        }
    }

    private void fillSynced(int i, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            makeAndAddView(i + i2, iArr[i2], true, false);
            adjustViewsUpOrDown();
        }
        this.mFirstPosition = i;
    }

    private View makeAndAddView(int i, int i2, boolean z, boolean z2) {
        View obtainView;
        if (!this.mDataChanged && (obtainView = this.mRecycler.ep(i)) != null) {
            setupChild(obtainView, i, i2, z, getItemLeft(i), z2, true);
        } else {
            onItemAddedToList(i, z);
            int itemLeft = getItemLeft(i);
            com.huewu.pla.lib.a.i("makeAndAddView:" + i);
            obtainView = obtainView(i, this.mIsScrap);
            if (obtainView == null) {
                com.huewu.pla.lib.a.YN("child is null:" + i);
            } else {
                setupChild(obtainView, i, i2, z, itemLeft, z2, this.mIsScrap[0]);
            }
        }
        return obtainView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onItemAddedToList(int i, boolean z) {
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
        layoutParams.bDJ = this.mAdapter.getItemViewType(i);
        layoutParams.bDM = i;
        if ((z3 && !layoutParams.bDL) || (layoutParams.bDK && layoutParams.bDJ == -2)) {
            attachViewToParent(view, z ? -1 : 0, layoutParams);
        } else {
            layoutParams.bDL = false;
            if (layoutParams.bDJ == -2) {
                layoutParams.bDK = true;
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
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListPadding.left + this.mListPadding.right, layoutParams.width);
            int i5 = layoutParams.height;
            if (i5 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            onMeasureChild(view, i, childMeasureSpec, makeMeasureSpec);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = z ? i2 : i2 - measuredHeight;
        if (z8) {
            onLayoutChild(view, i, i3, i6, i3 + measuredWidth, i6 + measuredHeight);
        } else {
            onOffsetChild(view, i, i3 - view.getLeft(), i6 - view.getTop());
        }
        if (this.mCachingStarted && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
    }

    protected void onOffsetChild(View view, int i, int i2, int i3) {
        view.offsetLeftAndRight(i2);
        view.offsetTopAndBottom(i3);
    }

    protected void onLayoutChild(View view, int i, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4, i5);
    }

    protected void onMeasureChild(View view, int i, int i2, int i3) {
        view.measure(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAdjustChildViews(boolean z) {
        if (z) {
            correctTooHigh(getChildCount());
        } else {
            correctTooLow(getChildCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
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
        if (this.mPositionScroller != null) {
            this.mPositionScroller.stop();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int lookForSelectablePosition(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
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
        } else if (i < 0 || i >= count) {
            return -1;
        } else {
            return i;
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i;
        boolean dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        if (!dispatchPopulateAccessibilityEvent) {
            int selectedItemPosition = getSelectedItemPosition();
            ListAdapter adapter = getAdapter();
            if (adapter != null) {
                int count = adapter.getCount();
                if (count < 15) {
                    i = 0;
                    for (int i2 = 0; i2 < count; i2++) {
                        if (adapter.isEnabled(i2)) {
                            i++;
                        } else if (i2 <= selectedItemPosition) {
                            selectedItemPosition--;
                        }
                    }
                } else {
                    i = count;
                }
            } else {
                i = 0;
            }
            accessibilityEvent.setItemCount(i);
            accessibilityEvent.setCurrentItemIndex(selectedItemPosition);
        }
        return dispatchPopulateAccessibilityEvent;
    }

    public boolean fullScroll(int i) {
        boolean z = true;
        if (i == 33) {
            if (lookForSelectablePosition(0, true) >= 0) {
                this.mLayoutMode = 1;
                invokeOnItemScrollListener();
            }
            z = false;
        } else {
            if (i == 130) {
                if (lookForSelectablePosition(this.mItemCount - 1, true) >= 0) {
                    this.mLayoutMode = 3;
                    invokeOnItemScrollListener();
                }
            }
            z = false;
        }
        if (z && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return z;
    }

    private void scrollListItemsBy(int i) {
        int i2;
        tryOffsetChildrenTopAndBottom(i);
        int height = getHeight() - this.mListPadding.bottom;
        int i3 = this.mListPadding.top;
        PLA_AbsListView.f fVar = this.mRecycler;
        if (i < 0) {
            View lastChild = getLastChild();
            for (int childCount = getChildCount(); lastChild.getBottom() < height && (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1; childCount++) {
                addViewBelow(lastChild, i2);
                lastChild = getLastChild();
            }
            if (lastChild.getBottom() < height) {
                tryOffsetChildrenTopAndBottom(height - lastChild.getBottom());
            }
            View childAt = getChildAt(0);
            while (true) {
                View view = childAt;
                if (view.getBottom() < i3) {
                    if (fVar.eo(((PLA_AbsListView.LayoutParams) view.getLayoutParams()).bDJ)) {
                        detachViewFromParent(view);
                        fVar.ex(view);
                    } else {
                        removeViewInLayout(view);
                    }
                    childAt = getChildAt(0);
                    this.mFirstPosition++;
                } else {
                    return;
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            while (childAt2.getTop() > i3 && this.mFirstPosition > 0) {
                childAt2 = addViewAbove(childAt2, this.mFirstPosition);
                this.mFirstPosition--;
            }
            if (childAt2.getTop() > i3) {
                tryOffsetChildrenTopAndBottom(i3 - childAt2.getTop());
            }
            int childCount2 = getChildCount() - 1;
            View childAt3 = getChildAt(childCount2);
            while (true) {
                View view2 = childAt3;
                if (view2.getTop() > height) {
                    if (fVar.eo(((PLA_AbsListView.LayoutParams) view2.getLayoutParams()).bDJ)) {
                        detachViewFromParent(view2);
                        fVar.ex(view2);
                    } else {
                        removeViewInLayout(view2);
                    }
                    childCount2--;
                    childAt3 = getChildAt(childCount2);
                } else {
                    return;
                }
            }
        }
    }

    protected View getLastChild() {
        return getChildAt(getChildCount() - 1);
    }

    private View addViewAbove(View view, int i) {
        int i2 = i - 1;
        com.huewu.pla.lib.a.i("addViewAbove:" + i);
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view.getTop() - this.mDividerHeight, false, this.mListPadding.left, false, this.mIsScrap[0]);
        return obtainView;
    }

    private View addViewBelow(View view, int i) {
        int i2 = i + 1;
        com.huewu.pla.lib.a.i("addViewBelow:" + i);
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, this.mDividerHeight + view.getBottom(), true, this.mListPadding.left, false, this.mIsScrap[0]);
        return obtainView;
    }

    public void setItemsCanFocus(boolean z) {
        this.mItemsCanFocus = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public boolean getItemsCanFocus() {
        return this.mItemsCanFocus;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        return (this.mCachingStarted && this.mIsCacheColorOpaque && this.mDividerIsOpaque) || super.isOpaque();
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

    void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumHeight = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.bottom - rect.top < minimumHeight) {
            rect.top = rect.bottom - minimumHeight;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumHeight = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.bottom - rect.top < minimumHeight) {
            rect.bottom = minimumHeight + rect.top;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i = this.mDividerHeight;
        Drawable drawable = this.mOverScrollHeader;
        Drawable drawable2 = this.mOverScrollFooter;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i > 0 && this.mDivider != null;
        drawContentBackground(canvas);
        if (z3 || z || z2) {
            Rect rect = this.mTempRect;
            rect.left = getPaddingLeft();
            rect.right = (getRight() - getLeft()) - getPaddingRight();
            int childCount = getChildCount();
            int size = this.mHeaderViewInfos.size();
            int i2 = this.mItemCount;
            int size2 = (i2 - this.mFooterViewInfos.size()) - 1;
            boolean z4 = this.mHeaderDividersEnabled;
            boolean z5 = this.mFooterDividersEnabled;
            int i3 = this.mFirstPosition;
            boolean z6 = this.mAreAllItemsSelectable;
            ListAdapter listAdapter = this.mAdapter;
            boolean z7 = z3 && isOpaque() && !super.isOpaque();
            if (z7 && this.mDividerPaint == null && this.mIsCacheColorOpaque) {
                this.mDividerPaint = new Paint();
                this.mDividerPaint.setColor(getCacheColorHint());
            }
            Paint paint = this.mDividerPaint;
            int scrollY = getScrollY() + ((getBottom() - getTop()) - this.mListPadding.bottom);
            if (!this.mStackFromBottom) {
                int i4 = 0;
                int scrollY2 = getScrollY();
                if (childCount > 0 && scrollY2 < 0) {
                    if (z) {
                        rect.bottom = 0;
                        rect.top = scrollY2;
                        drawOverscrollHeader(canvas, drawable, rect);
                    } else if (z3) {
                        rect.bottom = 0;
                        rect.top = -i;
                        drawDivider(canvas, rect, -1);
                    }
                }
                for (int i5 = 0; i5 < childCount; i5++) {
                    if ((z4 || i3 + i5 >= size) && (z5 || i3 + i5 < size2)) {
                        i4 = getChildAt(i5).getBottom();
                        if (z3 && i4 < scrollY && (!z2 || i5 != childCount - 1)) {
                            if (z6 || (listAdapter.isEnabled(i3 + i5) && (i5 == childCount - 1 || listAdapter.isEnabled(i3 + i5 + 1)))) {
                                rect.top = i4;
                                rect.bottom = i4 + i;
                                drawDivider(canvas, rect, i5);
                            } else if (z7) {
                                rect.top = i4;
                                rect.bottom = i4 + i;
                                canvas.drawRect(rect, paint);
                            }
                        }
                    }
                }
                int bottom = getBottom() + getScrollY();
                if (z2 && i3 + childCount == i2 && bottom > i4) {
                    rect.top = i4;
                    rect.bottom = bottom;
                    drawOverscrollFooter(canvas, drawable2, rect);
                }
            } else {
                int i6 = this.mListPadding.top;
                int scrollY3 = getScrollY();
                if (childCount > 0 && z) {
                    rect.top = scrollY3;
                    rect.bottom = getChildAt(0).getTop();
                    drawOverscrollHeader(canvas, drawable, rect);
                }
                for (int i7 = z ? 1 : 0; i7 < childCount; i7++) {
                    if ((z4 || i3 + i7 >= size) && (z5 || i3 + i7 < size2)) {
                        int top = getChildAt(i7).getTop();
                        if (z3 && top > i6) {
                            if (z6 || (listAdapter.isEnabled(i3 + i7) && (i7 == childCount - 1 || listAdapter.isEnabled(i3 + i7 + 1)))) {
                                rect.top = top - i;
                                rect.bottom = top;
                                drawDivider(canvas, rect, i7 - 1);
                            } else if (z7) {
                                rect.top = top - i;
                                rect.bottom = top;
                                canvas.drawRect(rect, paint);
                            }
                        }
                    }
                }
                if (childCount > 0 && scrollY3 > 0) {
                    if (z2) {
                        int bottom2 = getBottom();
                        rect.top = bottom2;
                        rect.bottom = bottom2 + scrollY3;
                        drawOverscrollFooter(canvas, drawable2, rect);
                    } else if (z3) {
                        rect.top = scrollY;
                        rect.bottom = scrollY + i;
                        drawDivider(canvas, rect, -1);
                    }
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    private void drawContentBackground(Canvas canvas) {
        if (getHeaderViewsCount() > 0) {
            Rect rect = this.mTempRect;
            rect.left = getLeft();
            rect.right = getRight();
            if (isHeaderView(getChildAt(getFirstVisiblePosition()))) {
                rect.top = this.mHeaderViewInfos.get(this.mHeaderViewInfos.size() - 1).view.getBottom();
            } else {
                rect.top = 0;
            }
            rect.bottom = getBottom();
            canvas.drawRect(rect, this.mContentPaint);
        }
    }

    private boolean isHeaderView(View view) {
        Iterator<a> it = this.mHeaderViewInfos.iterator();
        while (it.hasNext()) {
            if (it.next().view == view) {
                return true;
            }
        }
        return false;
    }

    void drawDivider(Canvas canvas, Rect rect, int i) {
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

    public Drawable getDivider() {
        return this.mDivider;
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

    public int getDividerHeight() {
        return this.mDividerHeight;
    }

    public void setDividerHeight(int i) {
        this.mDividerHeight = i;
        requestLayoutIfNecessary();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.mHeaderDividersEnabled = z;
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.mFooterDividersEnabled = z;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.mOverScrollHeader = drawable;
        if (getScrollY() < 0) {
            invalidate();
        }
    }

    public Drawable getOverscrollHeader() {
        return this.mOverScrollHeader;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.mOverScrollFooter = drawable;
        invalidate();
    }

    public Drawable getOverscrollFooter() {
        return this.mOverScrollFooter;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
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
            int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int childCount = getChildCount();
            int i4 = this.mFirstPosition;
            for (int i5 = 0; i5 < childCount; i5++) {
                if (listAdapter.isEnabled(i4 + i5)) {
                    View childAt = getChildAt(i5);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int distance = getDistance(rect, rect2, i);
                    if (distance < i3) {
                        i3 = distance;
                        i2 = i5;
                    }
                }
            }
        }
        if (i2 >= 0) {
            setSelection(this.mFirstPosition + i2);
        } else {
            requestLayout();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                addHeaderView(getChildAt(i));
            }
            removeAllViews();
        }
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
        return false | super.performItemClick(view, i, j);
    }

    public void setItemChecked(int i, boolean z) {
    }

    public boolean isItemChecked(int i) {
        return false;
    }

    public int getCheckedItemPosition() {
        return -1;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        return null;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        return (this.mAdapter == null || !this.mAdapter.hasStableIds()) ? new long[0] : getCheckedItemIds();
    }

    public long[] getCheckedItemIds() {
        return new long[0];
    }

    public void clearChoices() {
    }

    public void setContentBackgroundColor(int i) {
        this.mContentPaint = new Paint();
        this.mContentPaint.setColor(i);
    }
}
