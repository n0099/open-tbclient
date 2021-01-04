package com.huewu.pla.lib.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
/* loaded from: classes10.dex */
public abstract class PLA_AdapterView<T extends Adapter> extends ViewGroup {
    public static final int INVALID_POSITION = -1;
    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    static final int SYNC_FIRST_POSITION = 1;
    static final int SYNC_MAX_DURATION_MILLIS = 100;
    static final int SYNC_SELECTED_POSITION = 0;
    boolean mBlockLayoutRequests;
    boolean mDataChanged;
    private View mEmptyView;
    @ViewDebug.ExportedProperty
    int mFirstPosition;
    boolean mInLayout;
    @ViewDebug.ExportedProperty
    int mItemCount;
    private int mLayoutHeight;
    boolean mNeedSync;
    int mOldItemCount;
    int mOldSelectedPosition;
    long mOldSelectedRowId;
    c mOnItemClickListener;
    d mOnItemLongClickListener;
    e mOnItemSelectedListener;
    @ViewDebug.ExportedProperty(category = "list")
    int mSelectedPosition;
    long mSelectedRowId;
    private PLA_AdapterView<T>.f mSelectionNotifier;
    int mSpecificTop;
    int[] mSpecificTops;
    long mSyncHeight;
    int mSyncMode;
    int mSyncPosition;
    long mSyncRowId;

    /* loaded from: classes10.dex */
    public interface c {
        void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j);
    }

    /* loaded from: classes10.dex */
    public interface d {
        boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j);
    }

    /* loaded from: classes10.dex */
    public interface e {
        void onItemSelected(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j);

        void onNothingSelected(PLA_AdapterView<?> pLA_AdapterView);
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    public PLA_AdapterView(Context context) {
        super(context);
        this.mFirstPosition = 0;
        this.mSyncRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    public PLA_AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFirstPosition = 0;
        this.mSyncRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    public PLA_AdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFirstPosition = 0;
        this.mSyncRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    public void setOnItemClickListener(c cVar) {
        this.mOnItemClickListener = cVar;
    }

    public final c getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.mOnItemClickListener != null) {
            playSoundEffect(0);
            this.mOnItemClickListener.onItemClick(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnItemLongClickListener = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.mOnItemSelectedListener = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.mOnItemSelectedListener;
    }

    /* loaded from: classes10.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long id;
        public int position;
        public View targetView;

        public a(View view, int i, long j) {
            this.targetView = view;
            this.position = i;
            this.id = j;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mLayoutHeight = getHeight();
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return -1;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return Long.MIN_VALUE;
    }

    public Object getSelectedItem() {
        T adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.mItemCount;
    }

    public int getPositionForView(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException e2) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return i + this.mFirstPosition;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstPosition;
    }

    public int getLastVisiblePosition() {
        return (this.mFirstPosition + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        updateEmptyStatus(adapter == null || adapter.isEmpty());
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    boolean isInFilterMode() {
        return false;
    }

    @SuppressLint({"WrongCall"})
    private void updateEmptyStatus(boolean z) {
        if (isInFilterMode()) {
            z = false;
        }
        if (z) {
            if (this.mEmptyView != null) {
                this.mEmptyView.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.mDataChanged) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.mEmptyView != null) {
            this.mEmptyView.setVisibility(8);
        }
        setVisibility(0);
    }

    public Object getItemAtPosition(int i) {
        T adapter = getAdapter();
        if (adapter == null || i < 0) {
            return null;
        }
        return adapter.getItem(i);
    }

    public long getItemIdAtPosition(int i) {
        T adapter = getAdapter();
        if (adapter == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* loaded from: classes10.dex */
    class b extends DataSetObserver {
        private Parcelable bJe = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            com.huewu.pla.lib.a.ZV("data changed by onChanged()");
            PLA_AdapterView.this.mDataChanged = true;
            PLA_AdapterView.this.mOldItemCount = PLA_AdapterView.this.mItemCount;
            PLA_AdapterView.this.mItemCount = PLA_AdapterView.this.getAdapter().getCount();
            if (PLA_AdapterView.this.getAdapter().hasStableIds() && this.bJe != null && PLA_AdapterView.this.mOldItemCount == 0 && PLA_AdapterView.this.mItemCount > 0) {
                PLA_AdapterView.this.onRestoreInstanceState(this.bJe);
                this.bJe = null;
            } else {
                PLA_AdapterView.this.rememberSyncState();
            }
            PLA_AdapterView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            com.huewu.pla.lib.a.ZV("data changed by onInvalidated()");
            PLA_AdapterView.this.mDataChanged = true;
            if (PLA_AdapterView.this.getAdapter().hasStableIds()) {
                this.bJe = PLA_AdapterView.this.onSaveInstanceState();
            }
            PLA_AdapterView.this.mOldItemCount = PLA_AdapterView.this.mItemCount;
            PLA_AdapterView.this.mItemCount = 0;
            PLA_AdapterView.this.mSelectedPosition = -1;
            PLA_AdapterView.this.mSelectedRowId = Long.MIN_VALUE;
            PLA_AdapterView.this.mNeedSync = false;
            PLA_AdapterView.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mSelectionNotifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!PLA_AdapterView.this.mDataChanged) {
                PLA_AdapterView.this.fireOnSelected();
                PLA_AdapterView.this.performAccessibilityActionsOnSelected();
            } else if (PLA_AdapterView.this.getAdapter() != null) {
                PLA_AdapterView.this.post(this);
            }
        }
    }

    void selectionChanged() {
        if (this.mOnItemSelectedListener != null) {
            if (this.mInLayout || this.mBlockLayoutRequests) {
                if (this.mSelectionNotifier == null) {
                    this.mSelectionNotifier = new f();
                }
                post(this.mSelectionNotifier);
                return;
            }
            fireOnSelected();
            performAccessibilityActionsOnSelected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        if (this.mOnItemSelectedListener != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.mOnItemSelectedListener.onItemSelected(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.mOnItemSelectedListener.onNothingSelected(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAccessibilityActionsOnSelected() {
        if (getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean z = false;
        if (accessibilityEvent.getEventType() == 8) {
            accessibilityEvent.setEventType(4);
        }
        View selectedView = getSelectedView();
        if (selectedView != null) {
            z = selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        if (!z) {
            if (selectedView != null) {
                accessibilityEvent.setEnabled(selectedView.isEnabled());
            }
            accessibilityEvent.setItemCount(getCount());
            accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    void handleDataChanged() {
        if (this.mItemCount > 0 && this.mNeedSync) {
            this.mNeedSync = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkSelectionChanged() {
        if (this.mSelectedPosition != this.mOldSelectedPosition || this.mSelectedRowId != this.mOldSelectedRowId) {
            selectionChanged();
            this.mOldSelectedPosition = this.mSelectedPosition;
            this.mOldSelectedRowId = this.mSelectedRowId;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findSyncPosition() {
        int i = this.mItemCount;
        if (i == 0) {
            return -1;
        }
        long j = this.mSyncRowId;
        int i2 = this.mSyncPosition;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(i - 1, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        T adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i3 = min;
        int i4 = min;
        int i5 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(i5) != j) {
                boolean z2 = i3 == i + (-1);
                boolean z3 = i4 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    int i6 = i3 + 1;
                    z = false;
                    i3 = i6;
                    i5 = i6;
                } else if (z2 || (!z && !z3)) {
                    int i7 = i4 - 1;
                    z = true;
                    i4 = i7;
                    i5 = i7;
                }
            } else {
                return i5;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int lookForSelectablePosition(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rememberSyncState() {
        if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.mSyncHeight = this.mLayoutHeight;
            View childAt = getChildAt(0);
            T adapter = getAdapter();
            if (this.mFirstPosition >= 0 && this.mFirstPosition < adapter.getCount()) {
                this.mSyncRowId = adapter.getItemId(this.mFirstPosition);
            } else {
                this.mSyncRowId = -1L;
            }
            this.mSyncPosition = this.mFirstPosition;
            if (childAt != null) {
                this.mSpecificTop = childAt.getTop();
            }
            this.mSyncMode = 1;
        }
    }
}
