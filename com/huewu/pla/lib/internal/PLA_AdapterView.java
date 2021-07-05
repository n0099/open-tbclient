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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class PLA_AdapterView<T extends Adapter> extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_POSITION = -1;
    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    public static final int SYNC_FIRST_POSITION = 1;
    public static final int SYNC_MAX_DURATION_MILLIS = 100;
    public static final int SYNC_SELECTED_POSITION = 0;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b implements ContextMenu.ContextMenuInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f33524a;

        public b(View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33524a = view;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Parcelable f33525a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PLA_AdapterView f33526b;

        public c(PLA_AdapterView pLA_AdapterView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AdapterView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33526b = pLA_AdapterView;
            this.f33525a = null;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Parcelable parcelable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.g.a.a.a.a("data changed by onChanged()");
                PLA_AdapterView pLA_AdapterView = this.f33526b;
                pLA_AdapterView.mDataChanged = true;
                pLA_AdapterView.mOldItemCount = pLA_AdapterView.mItemCount;
                pLA_AdapterView.mItemCount = pLA_AdapterView.getAdapter().getCount();
                if (this.f33526b.getAdapter().hasStableIds() && (parcelable = this.f33525a) != null) {
                    PLA_AdapterView pLA_AdapterView2 = this.f33526b;
                    if (pLA_AdapterView2.mOldItemCount == 0 && pLA_AdapterView2.mItemCount > 0) {
                        pLA_AdapterView2.onRestoreInstanceState(parcelable);
                        this.f33525a = null;
                        this.f33526b.requestLayout();
                    }
                }
                this.f33526b.rememberSyncState();
                this.f33526b.requestLayout();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.g.a.a.a.a("data changed by onInvalidated()");
                PLA_AdapterView pLA_AdapterView = this.f33526b;
                pLA_AdapterView.mDataChanged = true;
                if (pLA_AdapterView.getAdapter().hasStableIds()) {
                    this.f33525a = this.f33526b.onSaveInstanceState();
                }
                PLA_AdapterView pLA_AdapterView2 = this.f33526b;
                pLA_AdapterView2.mOldItemCount = pLA_AdapterView2.mItemCount;
                pLA_AdapterView2.mItemCount = 0;
                pLA_AdapterView2.mSelectedPosition = -1;
                pLA_AdapterView2.mSelectedRowId = Long.MIN_VALUE;
                pLA_AdapterView2.mNeedSync = false;
                pLA_AdapterView2.requestLayout();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i2, long j);
    }

    /* loaded from: classes7.dex */
    public interface e {
        boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i2, long j);
    }

    /* loaded from: classes7.dex */
    public interface f {
        void onItemSelected(PLA_AdapterView<?> pLA_AdapterView, View view, int i2, long j);

        void onNothingSelected(PLA_AdapterView<?> pLA_AdapterView);
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PLA_AdapterView f33527e;

        public g(PLA_AdapterView pLA_AdapterView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AdapterView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33527e = pLA_AdapterView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PLA_AdapterView pLA_AdapterView = this.f33527e;
                if (!pLA_AdapterView.mDataChanged) {
                    pLA_AdapterView.fireOnSelected();
                    this.f33527e.performAccessibilityActionsOnSelected();
                } else if (pLA_AdapterView.getAdapter() != null) {
                    this.f33527e.post(this);
                }
            }
        }

        public /* synthetic */ g(PLA_AdapterView pLA_AdapterView, a aVar) {
            this(pLA_AdapterView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PLA_AdapterView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.mOnItemSelectedListener == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || getSelectedItemPosition() < 0) {
            return;
        }
        sendAccessibilityEvent(4);
    }

    @SuppressLint({"WrongCall"})
    private void updateEmptyStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, this, z) == null) {
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
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.canAnimate() && this.mItemCount > 0 : invokeV.booleanValue;
    }

    public void checkSelectionChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.mSelectedPosition == this.mOldSelectedPosition && this.mSelectedRowId == this.mOldSelectedRowId) {
                return;
            }
            selectionChanged();
            this.mOldSelectedPosition = this.mSelectedPosition;
            this.mOldSelectedRowId = this.mSelectedRowId;
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, accessibilityEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sparseArray) == null) {
            dispatchThawSelfOnly(sparseArray);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sparseArray) == null) {
            dispatchFreezeSelfOnly(sparseArray);
        }
    }

    public int findSyncPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.mItemCount;
            if (i2 == 0) {
                return -1;
            }
            long j = this.mSyncRowId;
            int i3 = this.mSyncPosition;
            if (j == Long.MIN_VALUE) {
                return -1;
            }
            int i4 = i2 - 1;
            int min = Math.min(i4, Math.max(0, i3));
            long uptimeMillis = SystemClock.uptimeMillis() + 100;
            T adapter = getAdapter();
            if (adapter == null) {
                return -1;
            }
            int i5 = min;
            int i6 = i5;
            loop0: while (true) {
                boolean z = false;
                while (SystemClock.uptimeMillis() <= uptimeMillis) {
                    if (adapter.getItemId(min) != j) {
                        boolean z2 = i5 == i4;
                        boolean z3 = i6 == 0;
                        if (z2 && z3) {
                            break loop0;
                        } else if (z3 || (z && !z2)) {
                            i5++;
                            min = i5;
                        } else if (z2 || (!z && !z3)) {
                            i6--;
                            min = i6;
                            z = true;
                        }
                    } else {
                        return min;
                    }
                }
                break loop0;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public abstract T getAdapter();

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mItemCount : invokeV.intValue;
    }

    public View getEmptyView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mEmptyView : (View) invokeV.objValue;
    }

    public int getFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mFirstPosition : invokeV.intValue;
    }

    public Object getItemAtPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            T adapter = getAdapter();
            if (adapter == null || i2 < 0) {
                return null;
            }
            return adapter.getItem(i2);
        }
        return invokeI.objValue;
    }

    public long getItemIdAtPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            T adapter = getAdapter();
            if (adapter == null || i2 < 0) {
                return Long.MIN_VALUE;
            }
            return adapter.getItemId(i2);
        }
        return invokeI.longValue;
    }

    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.mFirstPosition + getChildCount()) - 1 : invokeV.intValue;
    }

    public final d getOnItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mOnItemClickListener : (d) invokeV.objValue;
    }

    public final e getOnItemLongClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mOnItemLongClickListener : (e) invokeV.objValue;
    }

    public final f getOnItemSelectedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mOnItemSelectedListener : (f) invokeV.objValue;
    }

    public int getPositionForView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, view)) == null) {
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
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).equals(view)) {
                    return this.mFirstPosition + i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public Object getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            T adapter = getAdapter();
            int selectedItemPosition = getSelectedItemPosition();
            if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
                return null;
            }
            return adapter.getItem(selectedItemPosition);
        }
        return invokeV.objValue;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public abstract View getSelectedView();

    public void handleDataChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.mItemCount > 0 && this.mNeedSync) {
            this.mNeedSync = false;
        }
    }

    public boolean isInFilterMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int lookForSelectablePosition(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? i2 : invokeCommon.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onDetachedFromWindow();
            removeCallbacks(this.mSelectionNotifier);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mLayoutHeight = getHeight();
        }
    }

    public boolean performItemClick(View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (this.mOnItemClickListener != null) {
                playSoundEffect(0);
                this.mOnItemClickListener.onItemClick(this, view, i2, j);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void rememberSyncState() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || getChildCount() <= 0) {
            return;
        }
        this.mNeedSync = true;
        this.mSyncHeight = this.mLayoutHeight;
        View childAt = getChildAt(0);
        T adapter = getAdapter();
        int i2 = this.mFirstPosition;
        if (i2 >= 0 && i2 < adapter.getCount()) {
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

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
            throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
        }
    }

    public void selectionChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.mOnItemSelectedListener == null) {
            return;
        }
        if (!this.mInLayout && !this.mBlockLayoutRequests) {
            fireOnSelected();
            performAccessibilityActionsOnSelected();
            return;
        }
        if (this.mSelectionNotifier == null) {
            this.mSelectionNotifier = new g(this, null);
        }
        post(this.mSelectionNotifier);
    }

    public abstract void setAdapter(T t);

    public void setEmptyView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view) == null) {
            this.mEmptyView = view;
            T adapter = getAdapter();
            updateEmptyStatus(adapter == null || adapter.isEmpty());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onClickListener) == null) {
            throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
        }
    }

    public void setOnItemClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, dVar) == null) {
            this.mOnItemClickListener = dVar;
        }
    }

    public void setOnItemLongClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, eVar) == null) {
            if (!isLongClickable()) {
                setLongClickable(true);
            }
            this.mOnItemLongClickListener = eVar;
        }
    }

    public void setOnItemSelectedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, fVar) == null) {
            this.mOnItemSelectedListener = fVar;
        }
    }

    public abstract void setSelection(int i2);

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, layoutParams) == null) {
            throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i2, layoutParams) == null) {
            throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PLA_AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PLA_AdapterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
