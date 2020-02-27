package com.huewu.pla.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_ListView;
/* loaded from: classes3.dex */
public class MultiColumnListView extends PLA_ListView {
    private static final int DEFAULT_COLUMN_NUMBER = 2;
    private static final String TAG = "MultiColumnListView";
    c loadMoreListener;
    private boolean loadingMoreComplete;
    private int mColumnDiv;
    private int mColumnNumber;
    private int mColumnPaddingLeft;
    private int mColumnPaddingRight;
    private a[] mColumns;
    private a mFixedColumn;
    private Rect mFrameRect;
    private ParcelableSparseIntArray mItems;
    public PLA_AbsListView.c scroller;

    /* loaded from: classes3.dex */
    public interface c {
        void bfH();
    }

    public MultiColumnListView(Context context) {
        super(context);
        this.mColumnNumber = 2;
        this.mColumns = null;
        this.mFixedColumn = null;
        this.mItems = new ParcelableSparseIntArray();
        this.mColumnPaddingLeft = 0;
        this.mColumnPaddingRight = 0;
        this.mColumnDiv = 0;
        this.mFrameRect = new Rect();
        this.loadingMoreComplete = true;
        this.scroller = new PLA_AbsListView.c() { // from class: com.huewu.pla.lib.MultiColumnListView.1
            private int mOm = 0;

            @Override // com.huewu.pla.lib.internal.PLA_AbsListView.c
            public void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i) {
                int count = MultiColumnListView.this.getAdapter().getCount() - 2;
                if (i == 0 && this.mOm == count && MultiColumnListView.this.loadingMoreComplete) {
                    MultiColumnListView.this.loadMoreListener.bfH();
                    MultiColumnListView.this.loadingMoreComplete = false;
                }
            }

            @Override // com.huewu.pla.lib.internal.PLA_AbsListView.c
            public void onScroll(PLA_AbsListView pLA_AbsListView, int i, int i2, int i3) {
                this.mOm = (i + i2) - 2;
            }
        };
        init(null);
    }

    public MultiColumnListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mColumnNumber = 2;
        this.mColumns = null;
        this.mFixedColumn = null;
        this.mItems = new ParcelableSparseIntArray();
        this.mColumnPaddingLeft = 0;
        this.mColumnPaddingRight = 0;
        this.mColumnDiv = 0;
        this.mFrameRect = new Rect();
        this.loadingMoreComplete = true;
        this.scroller = new PLA_AbsListView.c() { // from class: com.huewu.pla.lib.MultiColumnListView.1
            private int mOm = 0;

            @Override // com.huewu.pla.lib.internal.PLA_AbsListView.c
            public void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i) {
                int count = MultiColumnListView.this.getAdapter().getCount() - 2;
                if (i == 0 && this.mOm == count && MultiColumnListView.this.loadingMoreComplete) {
                    MultiColumnListView.this.loadMoreListener.bfH();
                    MultiColumnListView.this.loadingMoreComplete = false;
                }
            }

            @Override // com.huewu.pla.lib.internal.PLA_AbsListView.c
            public void onScroll(PLA_AbsListView pLA_AbsListView, int i, int i2, int i3) {
                this.mOm = (i + i2) - 2;
            }
        };
        init(attributeSet);
    }

    public MultiColumnListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mColumnNumber = 2;
        this.mColumns = null;
        this.mFixedColumn = null;
        this.mItems = new ParcelableSparseIntArray();
        this.mColumnPaddingLeft = 0;
        this.mColumnPaddingRight = 0;
        this.mColumnDiv = 0;
        this.mFrameRect = new Rect();
        this.loadingMoreComplete = true;
        this.scroller = new PLA_AbsListView.c() { // from class: com.huewu.pla.lib.MultiColumnListView.1
            private int mOm = 0;

            @Override // com.huewu.pla.lib.internal.PLA_AbsListView.c
            public void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i2) {
                int count = MultiColumnListView.this.getAdapter().getCount() - 2;
                if (i2 == 0 && this.mOm == count && MultiColumnListView.this.loadingMoreComplete) {
                    MultiColumnListView.this.loadMoreListener.bfH();
                    MultiColumnListView.this.loadingMoreComplete = false;
                }
            }

            @Override // com.huewu.pla.lib.internal.PLA_AbsListView.c
            public void onScroll(PLA_AbsListView pLA_AbsListView, int i2, int i22, int i3) {
                this.mOm = (i2 + i22) - 2;
            }
        };
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        getWindowVisibleDisplayFrame(this.mFrameRect);
        if (attributeSet == null) {
            this.mColumnNumber = 2;
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MultiColumnListView);
            int integer = obtainStyledAttributes.getInteger(1, -1);
            int integer2 = obtainStyledAttributes.getInteger(0, -1);
            if (this.mFrameRect.width() > this.mFrameRect.height() && integer != -1) {
                this.mColumnNumber = integer;
            } else if (integer2 != -1) {
                this.mColumnNumber = integer2;
            } else {
                this.mColumnNumber = 2;
            }
            this.mColumnPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.mColumnPaddingRight = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            obtainStyledAttributes.recycle();
        }
        this.mColumns = new a[this.mColumnNumber];
        for (int i = 0; i < this.mColumnNumber; i++) {
            this.mColumns[i] = new a(i);
        }
        this.mFixedColumn = new b();
    }

    public void setColumnPaddingLeft(int i) {
        this.mColumnPaddingLeft = i;
    }

    public void setColumnPaddingRight(int i) {
        this.mColumnPaddingRight = i;
    }

    public void setColumnDiv(int i) {
        this.mColumnDiv = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = (((((getMeasuredWidth() - this.mListPadding.left) - this.mListPadding.right) - this.mColumnPaddingLeft) - this.mColumnPaddingRight) - this.mColumnDiv) / this.mColumnNumber;
        for (int i3 = 0; i3 < this.mColumnNumber; i3++) {
            this.mColumns[i3].mOo = measuredWidth;
            if (i3 == 0) {
                this.mColumns[i3].mOp = this.mListPadding.left + this.mColumnPaddingLeft + (measuredWidth * i3);
            } else {
                this.mColumns[i3].mOp = this.mListPadding.left + this.mColumnPaddingLeft + this.mColumnDiv + (measuredWidth * i3);
            }
        }
        this.mFixedColumn.mOp = this.mListPadding.left;
        this.mFixedColumn.mOo = getMeasuredWidth();
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    protected void onMeasureChild(View view, int i, int i2, int i3) {
        if (isFixedView(view)) {
            view.measure(i2, i3);
        } else {
            view.measure(1073741824 | getColumnWidth(i), i3);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    protected int modifyFlingInitialVelocity(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onItemAddedToList(int i, boolean z) {
        super.onItemAddedToList(i, z);
        if (!isHeaderOrFooterPosition(i)) {
            this.mItems.append(i, getNextColumn(z, i).getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void onLayoutSync(int i) {
        for (a aVar : this.mColumns) {
            aVar.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void onLayoutSyncFinished(int i) {
        for (a aVar : this.mColumns) {
            aVar.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onAdjustChildViews(boolean z) {
        a[] aVarArr;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (!z && firstVisiblePosition == 0) {
            int top2 = this.mColumns[0].getTop();
            for (a aVar : this.mColumns) {
                aVar.MG(top2 - aVar.getTop());
            }
        }
        super.onAdjustChildViews(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFillChildBottom() {
        int i = Integer.MAX_VALUE;
        a[] aVarArr = this.mColumns;
        int length = aVarArr.length;
        int i2 = 0;
        while (i2 < length) {
            int bottom = aVarArr[i2].getBottom();
            if (i <= bottom) {
                bottom = i;
            }
            i2++;
            i = bottom;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFillChildTop() {
        int i = Integer.MIN_VALUE;
        for (a aVar : this.mColumns) {
            i = Math.max(i, aVar.getTop());
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getScrollChildBottom() {
        int i = Integer.MIN_VALUE;
        a[] aVarArr = this.mColumns;
        int length = aVarArr.length;
        int i2 = 0;
        while (i2 < length) {
            int bottom = aVarArr[i2].getBottom();
            if (i >= bottom) {
                bottom = i;
            }
            i2++;
            i = bottom;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getScrollChildTop() {
        int i = Integer.MAX_VALUE;
        a[] aVarArr = this.mColumns;
        int length = aVarArr.length;
        int i2 = 0;
        while (i2 < length) {
            int top2 = aVarArr[i2].getTop();
            if (i <= top2) {
                top2 = i;
            }
            i2++;
            i = top2;
        }
        return i;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    protected int getItemLeft(int i) {
        return isHeaderOrFooterPosition(i) ? this.mFixedColumn.dBI() : getColumnLeft(i);
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    protected int getItemTop(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return this.mFixedColumn.getBottom();
        }
        int i2 = this.mItems.get(i, -1);
        if (i2 == -1) {
            return getFillChildBottom();
        }
        return this.mColumns[i2].getBottom();
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    protected int getItemBottom(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return this.mFixedColumn.getTop();
        }
        int i2 = this.mItems.get(i, -1);
        if (i2 == -1) {
            return getFillChildTop();
        }
        return this.mColumns[i2].getTop();
    }

    private a getNextColumn(boolean z, int i) {
        int i2 = this.mItems.get(i, -1);
        if (i2 != -1) {
            return this.mColumns[i2];
        }
        int max = Math.max(0, Math.max(0, i - getHeaderViewsCount()));
        if (max < this.mColumnNumber) {
            return this.mColumns[max];
        }
        if (z) {
            return gettBottomColumn();
        }
        return getTopColumn();
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return this.mAdapter.getItemViewType(i) == -2;
    }

    private a getTopColumn() {
        a aVar = this.mColumns[0];
        a[] aVarArr = this.mColumns;
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            a aVar2 = aVarArr[i];
            if (aVar.getTop() <= aVar2.getTop()) {
                aVar2 = aVar;
            }
            i++;
            aVar = aVar2;
        }
        return aVar;
    }

    private a gettBottomColumn() {
        a aVar = this.mColumns[0];
        a[] aVarArr = this.mColumns;
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            a aVar2 = aVarArr[i];
            if (aVar.getBottom() <= aVar2.getBottom()) {
                aVar2 = aVar;
            }
            i++;
            aVar = aVar2;
        }
        return aVar;
    }

    private int getColumnLeft(int i) {
        int i2 = this.mItems.get(i, -1);
        if (i2 == -1) {
            return 0;
        }
        return this.mColumns[i2].dBI();
    }

    private int getColumnWidth(int i) {
        int i2 = this.mItems.get(i, -1);
        if (i2 == -1) {
            return 0;
        }
        return this.mColumns[i2].dBJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private int mIndex;
        private int mOo;
        private int mOp;
        private int mOq = 0;
        private int mOr = 0;

        public a(int i) {
            this.mIndex = i;
        }

        public int dBI() {
            return this.mOp;
        }

        public int dBJ() {
            return this.mOo;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public int getBottom() {
            int childCount = MultiColumnListView.this.getChildCount();
            int i = Integer.MIN_VALUE;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = MultiColumnListView.this.getChildAt(i2);
                if ((childAt.getLeft() == this.mOp || MultiColumnListView.this.isFixedView(childAt)) && i < childAt.getBottom()) {
                    i = childAt.getBottom();
                }
            }
            if (i == Integer.MIN_VALUE) {
                return this.mOr;
            }
            return i;
        }

        public void MG(int i) {
            if (i != 0) {
                int childCount = MultiColumnListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiColumnListView.this.getChildAt(i2);
                    if (childAt.getLeft() == this.mOp || MultiColumnListView.this.isFixedView(childAt)) {
                        childAt.offsetTopAndBottom(i);
                    }
                }
            }
        }

        public int getTop() {
            int childCount = MultiColumnListView.this.getChildCount();
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = MultiColumnListView.this.getChildAt(i2);
                if (childAt.getLeft() == this.mOp || MultiColumnListView.this.isFixedView(childAt)) {
                    i = Math.min(i, childAt.getTop());
                }
            }
            if (i == Integer.MAX_VALUE) {
                return this.mOq;
            }
            return i;
        }

        public void save() {
            this.mOq = 0;
            this.mOr = getTop();
        }

        public void clear() {
            this.mOq = 0;
            this.mOr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends a {
        public b() {
            super(Integer.MAX_VALUE);
        }

        @Override // com.huewu.pla.lib.MultiColumnListView.a
        public int getBottom() {
            return MultiColumnListView.this.getScrollChildBottom();
        }

        @Override // com.huewu.pla.lib.MultiColumnListView.a
        public int getTop() {
            return MultiColumnListView.this.getScrollChildTop();
        }
    }

    public void onLoadMoreComplete() {
        this.loadingMoreComplete = true;
    }

    public void setOnLoadMoreListener(c cVar) {
        if (cVar != null) {
            this.loadMoreListener = cVar;
            setOnScrollListener(this.scroller);
        }
    }

    public void clearItems() {
        this.mItems.clear();
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("items", this.mItems);
        return bundle;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mItems = (ParcelableSparseIntArray) bundle.getParcelable("items");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }
}
