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
import com.baidu.tieba.vdc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public interface d {
        void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view2, int i, long j);
    }

    /* loaded from: classes10.dex */
    public interface e {
        boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view2, int i, long j);
    }

    /* loaded from: classes10.dex */
    public interface f {
        void onItemSelected(PLA_AdapterView<?> pLA_AdapterView, View view2, int i, long j);

        void onNothingSelected(PLA_AdapterView<?> pLA_AdapterView);
    }

    public abstract T getAdapter();

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

    public boolean isInFilterMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int lookForSelectablePosition(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? i : invokeCommon.intValue;
    }

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    /* loaded from: classes10.dex */
    public static class b implements ContextMenu.ContextMenuInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public b(View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }
    }

    /* loaded from: classes10.dex */
    public class c extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Parcelable a;
        public final /* synthetic */ PLA_AdapterView b;

        public c(PLA_AdapterView pLA_AdapterView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AdapterView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pLA_AdapterView;
            this.a = null;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Parcelable parcelable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vdc.a("data changed by onChanged()");
                PLA_AdapterView pLA_AdapterView = this.b;
                pLA_AdapterView.mDataChanged = true;
                pLA_AdapterView.mOldItemCount = pLA_AdapterView.mItemCount;
                pLA_AdapterView.mItemCount = pLA_AdapterView.getAdapter().getCount();
                if (this.b.getAdapter().hasStableIds() && (parcelable = this.a) != null) {
                    PLA_AdapterView pLA_AdapterView2 = this.b;
                    if (pLA_AdapterView2.mOldItemCount == 0 && pLA_AdapterView2.mItemCount > 0) {
                        pLA_AdapterView2.onRestoreInstanceState(parcelable);
                        this.a = null;
                        this.b.requestLayout();
                    }
                }
                this.b.rememberSyncState();
                this.b.requestLayout();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                vdc.a("data changed by onInvalidated()");
                PLA_AdapterView pLA_AdapterView = this.b;
                pLA_AdapterView.mDataChanged = true;
                if (pLA_AdapterView.getAdapter().hasStableIds()) {
                    this.a = this.b.onSaveInstanceState();
                }
                PLA_AdapterView pLA_AdapterView2 = this.b;
                pLA_AdapterView2.mOldItemCount = pLA_AdapterView2.mItemCount;
                pLA_AdapterView2.mItemCount = 0;
                pLA_AdapterView2.mSelectedPosition = -1;
                pLA_AdapterView2.mSelectedRowId = Long.MIN_VALUE;
                pLA_AdapterView2.mNeedSync = false;
                pLA_AdapterView2.requestLayout();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PLA_AdapterView a;

        public g(PLA_AdapterView pLA_AdapterView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AdapterView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pLA_AdapterView;
        }

        public /* synthetic */ g(PLA_AdapterView pLA_AdapterView, a aVar) {
            this(pLA_AdapterView);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PLA_AdapterView pLA_AdapterView = this.a;
                if (pLA_AdapterView.mDataChanged) {
                    if (pLA_AdapterView.getAdapter() != null) {
                        this.a.post(this);
                        return;
                    }
                    return;
                }
                pLA_AdapterView.fireOnSelected();
                this.a.performAccessibilityActionsOnSelected();
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    @SuppressLint({"WrongCall"})
    private void updateEmptyStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, this, z) == null) {
            if (isInFilterMode()) {
                z = false;
            }
            if (z) {
                View view2 = this.mEmptyView;
                if (view2 != null) {
                    view2.setVisibility(0);
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
            View view3 = this.mEmptyView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            setVisibility(0);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public PLA_AdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    @Override // android.view.ViewGroup
    public void addView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
        }
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

    public Object getItemAtPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            T adapter = getAdapter();
            if (adapter != null && i >= 0) {
                return adapter.getItem(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    public long getItemIdAtPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            T adapter = getAdapter();
            if (adapter != null && i >= 0) {
                return adapter.getItemId(i);
            }
            return Long.MIN_VALUE;
        }
        return invokeI.longValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view2) == null) {
            throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
        }
    }

    public void setEmptyView(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
            this.mEmptyView = view2;
            T adapter = getAdapter();
            if (adapter != null && !adapter.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            updateEmptyStatus(z);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, this) != null) || this.mOnItemSelectedListener == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0) {
            this.mOnItemSelectedListener.onItemSelected(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
            return;
        }
        this.mOnItemSelectedListener.onNothingSelected(this);
    }

    public void selectionChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.mOnItemSelectedListener != null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAccessibilityActionsOnSelected() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (super.canAnimate() && this.mItemCount > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void checkSelectionChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.mSelectedPosition != this.mOldSelectedPosition || this.mSelectedRowId != this.mOldSelectedRowId) {
                selectionChanged();
                this.mOldSelectedPosition = this.mSelectedPosition;
                this.mOldSelectedRowId = this.mSelectedRowId;
            }
        }
    }

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mItemCount;
        }
        return invokeV.intValue;
    }

    public View getEmptyView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mEmptyView;
        }
        return (View) invokeV.objValue;
    }

    public int getFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mFirstPosition;
        }
        return invokeV.intValue;
    }

    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (this.mFirstPosition + getChildCount()) - 1;
        }
        return invokeV.intValue;
    }

    public final d getOnItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mOnItemClickListener;
        }
        return (d) invokeV.objValue;
    }

    public final e getOnItemLongClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mOnItemLongClickListener;
        }
        return (e) invokeV.objValue;
    }

    public final f getOnItemSelectedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mOnItemSelectedListener;
        }
        return (f) invokeV.objValue;
    }

    public Object getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            T adapter = getAdapter();
            int selectedItemPosition = getSelectedItemPosition();
            if (adapter != null && adapter.getCount() > 0 && selectedItemPosition >= 0) {
                return adapter.getItem(selectedItemPosition);
            }
            return null;
        }
        return invokeV.objValue;
    }

    public void handleDataChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.mItemCount > 0 && this.mNeedSync) {
            this.mNeedSync = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onDetachedFromWindow();
            removeCallbacks(this.mSelectionNotifier);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view2, i, layoutParams) == null) {
            throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, layoutParams) == null) {
            throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, accessibilityEvent)) == null) {
            if (accessibilityEvent.getEventType() == 8) {
                accessibilityEvent.setEventType(4);
            }
            View selectedView = getSelectedView();
            if (selectedView != null) {
                z = selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            } else {
                z = false;
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
        return invokeL.booleanValue;
    }

    public int getPositionForView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, view2)) == null) {
            while (true) {
                try {
                    View view3 = (View) view2.getParent();
                    if (view3.equals(this)) {
                        break;
                    }
                    view2 = view3;
                } catch (ClassCastException unused) {
                }
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).equals(view2)) {
                    return this.mFirstPosition + i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int findSyncPosition() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.mItemCount;
            if (i == 0) {
                return -1;
            }
            long j = this.mSyncRowId;
            int i2 = this.mSyncPosition;
            if (j == Long.MIN_VALUE) {
                return -1;
            }
            int i3 = i - 1;
            int min = Math.min(i3, Math.max(0, i2));
            long uptimeMillis = SystemClock.uptimeMillis() + 100;
            T adapter = getAdapter();
            if (adapter == null) {
                return -1;
            }
            int i4 = min;
            int i5 = i4;
            loop0: while (true) {
                boolean z3 = false;
                while (SystemClock.uptimeMillis() <= uptimeMillis) {
                    if (adapter.getItemId(min) == j) {
                        return min;
                    }
                    if (i4 == i3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (i5 == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && z2) {
                        break loop0;
                    } else if (!z2 && (!z3 || z)) {
                        if (z || (!z3 && !z2)) {
                            i5--;
                            min = i5;
                            z3 = true;
                        }
                    } else {
                        i4++;
                        min = i4;
                    }
                }
                break loop0;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mLayoutHeight = getHeight();
        }
    }

    public boolean performItemClick(View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.mOnItemClickListener == null) {
                return false;
            }
            playSoundEffect(0);
            this.mOnItemClickListener.onItemClick(this, view2, i, j);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void rememberSyncState() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && getChildCount() > 0) {
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
}
