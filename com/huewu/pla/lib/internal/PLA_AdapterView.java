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
/* loaded from: classes6.dex */
public abstract class PLA_AdapterView<T extends Adapter> extends ViewGroup {
    public static final int INVALID_POSITION = -1;
    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    public static final int SYNC_FIRST_POSITION = 1;
    public static final int SYNC_MAX_DURATION_MILLIS = 100;
    public static final int SYNC_SELECTED_POSITION = 0;
    public boolean mBlockLayoutRequests;
    public boolean mDataChanged;
    public View mEmptyView;
    @ViewDebug.ExportedProperty
    public int mFirstPosition;
    public boolean mInLayout;
    @ViewDebug.ExportedProperty
    public int mItemCount;
    public int mLayoutHeight;
    public boolean mNeedSync;
    public int mOldItemCount;
    public int mOldSelectedPosition;
    public long mOldSelectedRowId;
    public d mOnItemClickListener;
    public e mOnItemLongClickListener;
    public f mOnItemSelectedListener;
    @ViewDebug.ExportedProperty(category = "list")
    public int mSelectedPosition;
    public long mSelectedRowId;
    public PLA_AdapterView<T>.g mSelectionNotifier;
    public int mSpecificTop;
    public int[] mSpecificTops;
    public long mSyncHeight;
    public int mSyncMode;
    public int mSyncPosition;
    public long mSyncRowId;

    /* loaded from: classes6.dex */
    public static class b implements ContextMenu.ContextMenuInfo {

        /* renamed from: a  reason: collision with root package name */
        public View f31143a;

        public b(View view, int i, long j) {
            this.f31143a = view;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends DataSetObserver {

        /* renamed from: a  reason: collision with root package name */
        public Parcelable f31144a = null;

        public c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Parcelable parcelable;
            d.i.a.a.a.a("data changed by onChanged()");
            PLA_AdapterView pLA_AdapterView = PLA_AdapterView.this;
            pLA_AdapterView.mDataChanged = true;
            pLA_AdapterView.mOldItemCount = pLA_AdapterView.mItemCount;
            pLA_AdapterView.mItemCount = pLA_AdapterView.getAdapter().getCount();
            if (PLA_AdapterView.this.getAdapter().hasStableIds() && (parcelable = this.f31144a) != null) {
                PLA_AdapterView pLA_AdapterView2 = PLA_AdapterView.this;
                if (pLA_AdapterView2.mOldItemCount == 0 && pLA_AdapterView2.mItemCount > 0) {
                    pLA_AdapterView2.onRestoreInstanceState(parcelable);
                    this.f31144a = null;
                    PLA_AdapterView.this.requestLayout();
                }
            }
            PLA_AdapterView.this.rememberSyncState();
            PLA_AdapterView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            d.i.a.a.a.a("data changed by onInvalidated()");
            PLA_AdapterView pLA_AdapterView = PLA_AdapterView.this;
            pLA_AdapterView.mDataChanged = true;
            if (pLA_AdapterView.getAdapter().hasStableIds()) {
                this.f31144a = PLA_AdapterView.this.onSaveInstanceState();
            }
            PLA_AdapterView pLA_AdapterView2 = PLA_AdapterView.this;
            pLA_AdapterView2.mOldItemCount = pLA_AdapterView2.mItemCount;
            pLA_AdapterView2.mItemCount = 0;
            pLA_AdapterView2.mSelectedPosition = -1;
            pLA_AdapterView2.mSelectedRowId = Long.MIN_VALUE;
            pLA_AdapterView2.mNeedSync = false;
            pLA_AdapterView2.requestLayout();
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j);
    }

    /* loaded from: classes6.dex */
    public interface e {
        boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void onItemSelected(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j);

        void onNothingSelected(PLA_AdapterView<?> pLA_AdapterView);
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PLA_AdapterView pLA_AdapterView = PLA_AdapterView.this;
            if (!pLA_AdapterView.mDataChanged) {
                pLA_AdapterView.fireOnSelected();
                PLA_AdapterView.this.performAccessibilityActionsOnSelected();
            } else if (pLA_AdapterView.getAdapter() != null) {
                PLA_AdapterView.this.post(this);
            }
        }
    }

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

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        if (this.mOnItemSelectedListener == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0) {
            this.mOnItemSelectedListener.onItemSelected(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
            return;
        }
        this.mOnItemSelectedListener.onNothingSelected(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAccessibilityActionsOnSelected() {
        if (getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    @SuppressLint({"WrongCall"})
    private void updateEmptyStatus(boolean z) {
        if (isInFilterMode()) {
            z = false;
        }
        if (z) {
            View view = this.mEmptyView;
            if (view != null) {
                view.setVisibility(0);
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
        View view2 = this.mEmptyView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    public void checkSelectionChanged() {
        if (this.mSelectedPosition == this.mOldSelectedPosition && this.mSelectedRowId == this.mOldSelectedRowId) {
            return;
        }
        selectionChanged();
        this.mOldSelectedPosition = this.mSelectedPosition;
        this.mOldSelectedRowId = this.mSelectedRowId;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 8) {
            accessibilityEvent.setEventType(4);
        }
        View selectedView = getSelectedView();
        boolean dispatchPopulateAccessibilityEvent = selectedView != null ? selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent) : false;
        if (!dispatchPopulateAccessibilityEvent) {
            if (selectedView != null) {
                accessibilityEvent.setEnabled(selectedView.isEnabled());
            }
            accessibilityEvent.setItemCount(getCount());
            accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        }
        return dispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int findSyncPosition() {
        int i = this.mItemCount;
        if (i != 0) {
            long j = this.mSyncRowId;
            int i2 = this.mSyncPosition;
            if (j != Long.MIN_VALUE) {
                int i3 = i - 1;
                int min = Math.min(i3, Math.max(0, i2));
                long uptimeMillis = SystemClock.uptimeMillis() + 100;
                T adapter = getAdapter();
                if (adapter != null) {
                    int i4 = min;
                    int i5 = i4;
                    loop0: while (true) {
                        boolean z = false;
                        while (SystemClock.uptimeMillis() <= uptimeMillis) {
                            if (adapter.getItemId(min) != j) {
                                boolean z2 = i4 == i3;
                                boolean z3 = i5 == 0;
                                if (z2 && z3) {
                                    break loop0;
                                } else if (z3 || (z && !z2)) {
                                    i4++;
                                    min = i4;
                                } else if (z2 || (!z && !z3)) {
                                    i5--;
                                    min = i5;
                                    z = true;
                                }
                            } else {
                                return min;
                            }
                        }
                        break loop0;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public abstract T getAdapter();

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.mItemCount;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstPosition;
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

    public int getLastVisiblePosition() {
        return (this.mFirstPosition + getChildCount()) - 1;
    }

    public final d getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final e getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public final f getOnItemSelectedListener() {
        return this.mOnItemSelectedListener;
    }

    public int getPositionForView(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException unused) {
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return this.mFirstPosition + i;
            }
        }
        return -1;
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
    public long getSelectedItemId() {
        return Long.MIN_VALUE;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return -1;
    }

    public abstract View getSelectedView();

    public void handleDataChanged() {
        if (this.mItemCount <= 0 || !this.mNeedSync) {
            return;
        }
        this.mNeedSync = false;
    }

    public boolean isInFilterMode() {
        return false;
    }

    public int lookForSelectablePosition(int i, boolean z) {
        return i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mSelectionNotifier);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mLayoutHeight = getHeight();
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.mOnItemClickListener != null) {
            playSoundEffect(0);
            this.mOnItemClickListener.onItemClick(this, view, i, j);
            return true;
        }
        return false;
    }

    public void rememberSyncState() {
        if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.mSyncHeight = this.mLayoutHeight;
            View childAt = getChildAt(0);
            T adapter = getAdapter();
            int i = this.mFirstPosition;
            if (i >= 0 && i < adapter.getCount()) {
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

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public void selectionChanged() {
        if (this.mOnItemSelectedListener != null) {
            if (!this.mInLayout && !this.mBlockLayoutRequests) {
                fireOnSelected();
                performAccessibilityActionsOnSelected();
                return;
            }
            if (this.mSelectionNotifier == null) {
                this.mSelectionNotifier = new g();
            }
            post(this.mSelectionNotifier);
        }
    }

    public abstract void setAdapter(T t);

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        updateEmptyStatus(adapter == null || adapter.isEmpty());
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(d dVar) {
        this.mOnItemClickListener = dVar;
    }

    public void setOnItemLongClickListener(e eVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnItemLongClickListener = eVar;
    }

    public void setOnItemSelectedListener(f fVar) {
        this.mOnItemSelectedListener = fVar;
    }

    public abstract void setSelection(int i);

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
}
