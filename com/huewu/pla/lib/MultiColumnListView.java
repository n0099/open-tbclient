package com.huewu.pla.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R$styleable;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_ListView;
/* loaded from: classes6.dex */
public class MultiColumnListView extends PLA_ListView {
    public static final int DEFAULT_COLUMN_NUMBER = 2;
    public static final String TAG = "MultiColumnListView";
    public d loadMoreListener;
    public boolean loadingMoreComplete;
    public int mColumnDiv;
    public int mColumnNumber;
    public int mColumnPaddingLeft;
    public int mColumnPaddingRight;
    public b[] mColumns;
    public b mFixedColumn;
    public Rect mFrameRect;
    public ParcelableSparseIntArray mItems;
    public PLA_AbsListView.e scroller;

    /* loaded from: classes6.dex */
    public class a implements PLA_AbsListView.e {

        /* renamed from: a  reason: collision with root package name */
        public int f31717a = 0;

        public a() {
        }

        @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
        public void onScroll(PLA_AbsListView pLA_AbsListView, int i2, int i3, int i4) {
            this.f31717a = (i2 + i3) - 2;
        }

        @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
        public void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i2) {
            int count = MultiColumnListView.this.getAdapter().getCount() - 2;
            if (i2 == 0 && this.f31717a == count && MultiColumnListView.this.loadingMoreComplete) {
                MultiColumnListView.this.loadMoreListener.a();
                MultiColumnListView.this.loadingMoreComplete = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f31719a;

        /* renamed from: b  reason: collision with root package name */
        public int f31720b;

        /* renamed from: c  reason: collision with root package name */
        public int f31721c;

        /* renamed from: d  reason: collision with root package name */
        public int f31722d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f31723e = 0;

        public b(int i2) {
            this.f31719a = i2;
        }

        public void c() {
            this.f31722d = 0;
            this.f31723e = 0;
        }

        public int d() {
            int childCount = MultiColumnListView.this.getChildCount();
            int i2 = Integer.MIN_VALUE;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = MultiColumnListView.this.getChildAt(i3);
                if ((childAt.getLeft() == this.f31721c || MultiColumnListView.this.isFixedView(childAt)) && i2 < childAt.getBottom()) {
                    i2 = childAt.getBottom();
                }
            }
            return i2 == Integer.MIN_VALUE ? this.f31723e : i2;
        }

        public int e() {
            return this.f31721c;
        }

        public int f() {
            return this.f31720b;
        }

        public int g() {
            return this.f31719a;
        }

        public int h() {
            int childCount = MultiColumnListView.this.getChildCount();
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = MultiColumnListView.this.getChildAt(i3);
                if (childAt.getLeft() == this.f31721c || MultiColumnListView.this.isFixedView(childAt)) {
                    i2 = Math.min(i2, childAt.getTop());
                }
            }
            return i2 == Integer.MAX_VALUE ? this.f31722d : i2;
        }

        public void i(int i2) {
            if (i2 == 0) {
                return;
            }
            int childCount = MultiColumnListView.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = MultiColumnListView.this.getChildAt(i3);
                if (childAt.getLeft() == this.f31721c || MultiColumnListView.this.isFixedView(childAt)) {
                    childAt.offsetTopAndBottom(i2);
                }
            }
        }

        public void j() {
            this.f31722d = 0;
            this.f31723e = h();
        }
    }

    /* loaded from: classes6.dex */
    public class c extends b {
        public c() {
            super(Integer.MAX_VALUE);
        }

        @Override // com.huewu.pla.lib.MultiColumnListView.b
        public int d() {
            return MultiColumnListView.this.getScrollChildBottom();
        }

        @Override // com.huewu.pla.lib.MultiColumnListView.b
        public int h() {
            return MultiColumnListView.this.getScrollChildTop();
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a();
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
        this.scroller = new a();
        init(null);
    }

    private int getColumnLeft(int i2) {
        int i3 = this.mItems.get(i2, -1);
        if (i3 == -1) {
            return 0;
        }
        return this.mColumns[i3].e();
    }

    private int getColumnWidth(int i2) {
        int i3 = this.mItems.get(i2, -1);
        if (i3 == -1) {
            return 0;
        }
        return this.mColumns[i3].f();
    }

    private b getNextColumn(boolean z, int i2) {
        int i3 = this.mItems.get(i2, -1);
        if (i3 != -1) {
            return this.mColumns[i3];
        }
        int max = Math.max(0, Math.max(0, i2 - getHeaderViewsCount()));
        if (max < this.mColumnNumber) {
            return this.mColumns[max];
        }
        if (z) {
            return gettBottomColumn();
        }
        return getTopColumn();
    }

    private b getTopColumn() {
        b[] bVarArr = this.mColumns;
        b bVar = bVarArr[0];
        for (b bVar2 : bVarArr) {
            if (bVar.h() > bVar2.h()) {
                bVar = bVar2;
            }
        }
        return bVar;
    }

    private b gettBottomColumn() {
        b[] bVarArr = this.mColumns;
        b bVar = bVarArr[0];
        for (b bVar2 : bVarArr) {
            if (bVar.d() > bVar2.d()) {
                bVar = bVar2;
            }
        }
        return bVar;
    }

    private void init(AttributeSet attributeSet) {
        getWindowVisibleDisplayFrame(this.mFrameRect);
        if (attributeSet == null) {
            this.mColumnNumber = 2;
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MultiColumnListView);
            int integer = obtainStyledAttributes.getInteger(R$styleable.MultiColumnListView_plaLandscapeColumnNumber, -1);
            int integer2 = obtainStyledAttributes.getInteger(R$styleable.MultiColumnListView_plaColumnNumber, -1);
            if (this.mFrameRect.width() > this.mFrameRect.height() && integer != -1) {
                this.mColumnNumber = integer;
            } else if (integer2 != -1) {
                this.mColumnNumber = integer2;
            } else {
                this.mColumnNumber = 2;
            }
            this.mColumnPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColumnListView_plaColumnPaddingLeft, 0);
            this.mColumnPaddingRight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColumnListView_plaColumnPaddingRight, 0);
            obtainStyledAttributes.recycle();
        }
        this.mColumns = new b[this.mColumnNumber];
        for (int i2 = 0; i2 < this.mColumnNumber; i2++) {
            this.mColumns[i2] = new b(i2);
        }
        this.mFixedColumn = new c();
    }

    private boolean isHeaderOrFooterPosition(int i2) {
        return this.mAdapter.getItemViewType(i2) == -2;
    }

    public void clearItems() {
        this.mItems.clear();
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFillChildBottom() {
        int i2 = Integer.MAX_VALUE;
        for (b bVar : this.mColumns) {
            int d2 = bVar.d();
            if (i2 > d2) {
                i2 = d2;
            }
        }
        return i2;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFillChildTop() {
        int i2 = Integer.MIN_VALUE;
        for (b bVar : this.mColumns) {
            i2 = Math.max(i2, bVar.h());
        }
        return i2;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public int getItemBottom(int i2) {
        if (isHeaderOrFooterPosition(i2)) {
            return this.mFixedColumn.h();
        }
        int i3 = this.mItems.get(i2, -1);
        if (i3 == -1) {
            return getFillChildTop();
        }
        return this.mColumns[i3].h();
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public int getItemLeft(int i2) {
        if (isHeaderOrFooterPosition(i2)) {
            return this.mFixedColumn.e();
        }
        return getColumnLeft(i2);
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public int getItemTop(int i2) {
        if (isHeaderOrFooterPosition(i2)) {
            return this.mFixedColumn.d();
        }
        int i3 = this.mItems.get(i2, -1);
        if (i3 == -1) {
            return getFillChildBottom();
        }
        return this.mColumns[i3].d();
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getScrollChildBottom() {
        int i2 = Integer.MIN_VALUE;
        for (b bVar : this.mColumns) {
            int d2 = bVar.d();
            if (i2 < d2) {
                i2 = d2;
            }
        }
        return i2;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getScrollChildTop() {
        int i2 = Integer.MAX_VALUE;
        for (b bVar : this.mColumns) {
            int h2 = bVar.h();
            if (i2 > h2) {
                i2 = h2;
            }
        }
        return i2;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int modifyFlingInitialVelocity(int i2) {
        return i2;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onAdjustChildViews(boolean z) {
        b[] bVarArr;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (!z && firstVisiblePosition == 0) {
            int h2 = this.mColumns[0].h();
            for (b bVar : this.mColumns) {
                bVar.i(h2 - bVar.h());
            }
        }
        super.onAdjustChildViews(z);
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onItemAddedToList(int i2, boolean z) {
        super.onItemAddedToList(i2, z);
        if (isHeaderOrFooterPosition(i2)) {
            return;
        }
        this.mItems.append(i2, getNextColumn(z, i2).g());
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void onLayoutSync(int i2) {
        for (b bVar : this.mColumns) {
            bVar.j();
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void onLayoutSyncFinished(int i2) {
        for (b bVar : this.mColumns) {
            bVar.c();
        }
    }

    public void onLoadMoreComplete() {
        this.loadingMoreComplete = true;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        Rect rect = this.mListPadding;
        int i4 = (((((measuredWidth - rect.left) - rect.right) - this.mColumnPaddingLeft) - this.mColumnPaddingRight) - this.mColumnDiv) / this.mColumnNumber;
        for (int i5 = 0; i5 < this.mColumnNumber; i5++) {
            this.mColumns[i5].f31720b = i4;
            if (i5 == 0) {
                this.mColumns[i5].f31721c = this.mListPadding.left + this.mColumnPaddingLeft + (i4 * i5);
            } else {
                this.mColumns[i5].f31721c = this.mListPadding.left + this.mColumnPaddingLeft + this.mColumnDiv + (i4 * i5);
            }
        }
        this.mFixedColumn.f31721c = this.mListPadding.left;
        this.mFixedColumn.f31720b = getMeasuredWidth();
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onMeasureChild(View view, int i2, int i3, int i4) {
        if (isFixedView(view)) {
            view.measure(i3, i4);
        } else {
            view.measure(getColumnWidth(i2) | 1073741824, i4);
        }
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

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("items", this.mItems);
        return bundle;
    }

    public void setColumnDiv(int i2) {
        this.mColumnDiv = i2;
    }

    public void setColumnPaddingLeft(int i2) {
        this.mColumnPaddingLeft = i2;
    }

    public void setColumnPaddingRight(int i2) {
        this.mColumnPaddingRight = i2;
    }

    public void setOnLoadMoreListener(d dVar) {
        if (dVar != null) {
            this.loadMoreListener = dVar;
            setOnScrollListener(this.scroller);
        }
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
        this.scroller = new a();
        init(attributeSet);
    }

    public MultiColumnListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mColumnNumber = 2;
        this.mColumns = null;
        this.mFixedColumn = null;
        this.mItems = new ParcelableSparseIntArray();
        this.mColumnPaddingLeft = 0;
        this.mColumnPaddingRight = 0;
        this.mColumnDiv = 0;
        this.mFrameRect = new Rect();
        this.loadingMoreComplete = true;
        this.scroller = new a();
        init(attributeSet);
    }
}
