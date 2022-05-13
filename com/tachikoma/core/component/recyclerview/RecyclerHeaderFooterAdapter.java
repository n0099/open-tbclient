package com.tachikoma.core.component.recyclerview;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.listview.TKRecyclerAdapter;
import com.tachikoma.core.yoga.layout.YogaLayout;
import java.util.List;
/* loaded from: classes8.dex */
public class RecyclerHeaderFooterAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BASE_FOOTER_VIEW_TYPE = -2048;
    public static final int BASE_HEADER_VIEW_TYPE = -1024;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.Adapter mAdapter;
    public final RecyclerView.AdapterDataObserver mAdapterDataObserverProxy;
    public RecyclerView.Adapter mFooterAdapter;
    public final HeaderFooterViewGroup mFooterGroup;
    public RecyclerView.AdapterDataObserver mFooterObserverProxy;
    public boolean mForceNotifyAll;
    public RecyclerView.Adapter mHeaderAdapter;
    public final HeaderFooterViewGroup mHeaderGroup;
    public RecyclerView.AdapterDataObserver mHeaderObserverProxy;
    public boolean mHeaderOrFooterDirty;
    public boolean mIsOverrideLayoutParams;
    public boolean mIsStaggeredGrid;
    public int mLastAdapterContentCount;
    public int mMaxFooterViewType;
    public int mMaxHeaderViewType;
    public boolean mSmoothNotifyChange;

    /* loaded from: classes7.dex */
    public static class HeaderFooterViewGroup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mIndex;
        public final SparseArray<View> mViews;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public HeaderFooterViewGroup() {
            this(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this((List) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public HeaderFooterViewGroup(List<View> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mViews = new SparseArray<>();
            this.mIndex = 0;
            if (list != null) {
                for (View view2 : list) {
                    SparseArray<View> sparseArray = this.mViews;
                    int i3 = this.mIndex;
                    this.mIndex = i3 + 1;
                    sparseArray.put(i3, view2);
                }
            }
        }

        public boolean addView(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (containsView(view2)) {
                    return false;
                }
                SparseArray<View> sparseArray = this.mViews;
                int i = this.mIndex;
                this.mIndex = i + 1;
                sparseArray.put(i, view2);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean containsView(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) ? this.mViews.indexOfValue(view2) >= 0 : invokeL.booleanValue;
        }

        public View getViewAtPos(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i < 0 || i >= this.mViews.size()) {
                    return null;
                }
                return this.mViews.valueAt(i);
            }
            return (View) invokeI.objValue;
        }

        public int getViewTypeAtPos(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                if (i < 0 || i >= this.mViews.size()) {
                    return -1;
                }
                return this.mViews.keyAt(i);
            }
            return invokeI.intValue;
        }

        public View getViewWithType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.mViews.get(i) : (View) invokeI.objValue;
        }

        public int maxIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIndex : invokeV.intValue;
        }

        public boolean removeView(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
                int indexOfValue = this.mViews.indexOfValue(view2);
                if (indexOfValue < 0) {
                    return false;
                }
                this.mViews.removeAt(indexOfValue);
                return true;
            }
            return invokeL.booleanValue;
        }

        public int viewCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mViews.size() : invokeV.intValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecyclerHeaderFooterAdapter(RecyclerView.Adapter adapter) {
        this(adapter, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((RecyclerView.Adapter) objArr2[0], (List) objArr2[1], (List) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public RecyclerHeaderFooterAdapter(RecyclerView.Adapter adapter, List<View> list, List<View> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adapter, list, list2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMaxFooterViewType = BASE_FOOTER_VIEW_TYPE;
        this.mMaxHeaderViewType = BASE_HEADER_VIEW_TYPE;
        this.mLastAdapterContentCount = -1;
        this.mForceNotifyAll = false;
        this.mIsOverrideLayoutParams = true;
        this.mHeaderOrFooterDirty = false;
        this.mAdapter = adapter;
        this.mHeaderGroup = new HeaderFooterViewGroup(list);
        this.mFooterGroup = new HeaderFooterViewGroup(list2);
        RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver(this) { // from class: com.tachikoma.core.component.recyclerview.RecyclerHeaderFooterAdapter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecyclerHeaderFooterAdapter this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private void smoothChange(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(65537, this, i3) == null) {
                    try {
                        int i4 = this.this$0.mLastAdapterContentCount;
                        int headerCount = this.this$0.getHeaderCount();
                        if (i4 == -1) {
                            this.this$0.notifyDataSetChanged();
                        } else if (i3 == i4) {
                            this.this$0.notifyItemRangeChanged(headerCount, i3);
                        } else if (i3 > i4) {
                            this.this$0.notifyItemRangeChanged(headerCount, i4);
                            this.this$0.notifyItemRangeInserted(headerCount + i4, i3 - i4);
                        } else {
                            this.this$0.notifyItemRangeChanged(headerCount, i3);
                            this.this$0.notifyItemRangeRemoved(headerCount + i3, i4 - i3);
                        }
                    } catch (Exception unused) {
                    }
                    this.this$0.mLastAdapterContentCount = i3;
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.mForceNotifyAll) {
                        this.this$0.notifyDataSetChanged();
                    } else if (this.this$0.mSmoothNotifyChange) {
                        smoothChange(this.this$0.mAdapter.getItemCount());
                    } else {
                        int itemCount = this.this$0.mAdapter.getItemCount();
                        try {
                            if (this.this$0.mLastAdapterContentCount == -1 || (itemCount != 0 && itemCount == this.this$0.mLastAdapterContentCount)) {
                                this.this$0.notifyItemRangeChanged(this.this$0.getHeaderCount(), itemCount);
                            } else {
                                this.this$0.notifyDataSetChanged();
                            }
                        } catch (Exception unused) {
                        }
                        this.this$0.mLastAdapterContentCount = itemCount;
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) {
                    RecyclerHeaderFooterAdapter recyclerHeaderFooterAdapter = this.this$0;
                    recyclerHeaderFooterAdapter.mLastAdapterContentCount = recyclerHeaderFooterAdapter.mAdapter.getItemCount();
                    try {
                        this.this$0.notifyItemRangeChanged(i3 + this.this$0.getHeaderCount(), i4);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i3, int i4, Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i3, i4, obj) == null) {
                    RecyclerHeaderFooterAdapter recyclerHeaderFooterAdapter = this.this$0;
                    recyclerHeaderFooterAdapter.mLastAdapterContentCount = recyclerHeaderFooterAdapter.mAdapter.getItemCount();
                    try {
                        this.this$0.notifyItemRangeChanged(i3 + this.this$0.getHeaderCount(), i4, obj);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048579, this, i3, i4) == null) {
                    RecyclerHeaderFooterAdapter recyclerHeaderFooterAdapter = this.this$0;
                    recyclerHeaderFooterAdapter.mLastAdapterContentCount = recyclerHeaderFooterAdapter.mAdapter.getItemCount();
                    try {
                        this.this$0.notifyItemRangeInserted(i3 + this.this$0.getHeaderCount(), i4);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i3, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIII(1048580, this, i3, i4, i5) == null) {
                    try {
                        this.this$0.notifyItemMoved(i3 + this.this$0.getHeaderCount(), i4 + this.this$0.getHeaderCount());
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048581, this, i3, i4) == null) {
                    try {
                        this.this$0.notifyItemRangeRemoved(i3 + this.this$0.getHeaderCount(), i4);
                    } catch (Exception unused) {
                    }
                }
            }
        };
        this.mAdapterDataObserverProxy = adapterDataObserver;
        this.mHeaderObserverProxy = adapterDataObserver;
        this.mFooterObserverProxy = adapterDataObserver;
        this.mAdapter.registerAdapterDataObserver(adapterDataObserver);
    }

    private void adjustHeaderFooterView(RecyclerView.ViewHolder viewHolder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, this, viewHolder, z) == null) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(z);
            }
        }
    }

    private void adjustHeaderFooterView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, recyclerView) == null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this, gridLayoutManager) { // from class: com.tachikoma.core.component.recyclerview.RecyclerHeaderFooterAdapter.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RecyclerHeaderFooterAdapter this$0;
                    public final /* synthetic */ GridLayoutManager val$gridManager;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, gridLayoutManager};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$gridManager = gridLayoutManager;
                    }

                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int i) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i)) == null) {
                            if (this.this$0.isHeaderPosition(i) || this.this$0.isFooterPosition(i)) {
                                return this.val$gridManager.getSpanCount();
                            }
                            return 1;
                        }
                        return invokeI.intValue;
                    }
                });
            }
        }
    }

    private RecyclerView.ViewHolder createHeaderFooterViewHolder(View view2) {
        InterceptResult invokeL;
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, view2)) == null) {
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            int i = layoutParams2 == null ? -1 : layoutParams2.width;
            int i2 = layoutParams2 == null ? -2 : layoutParams2.height;
            if (this.mIsOverrideLayoutParams) {
                if (this.mIsStaggeredGrid) {
                    StaggeredGridLayoutManager.LayoutParams layoutParams3 = new StaggeredGridLayoutManager.LayoutParams(i, i2);
                    layoutParams3.setFullSpan(true);
                    layoutParams = layoutParams3;
                } else {
                    layoutParams = new RecyclerView.LayoutParams(i, i2);
                }
                view2.setLayoutParams(layoutParams);
            }
            if (view2 instanceof YogaLayout) {
                YogaLayout yogaLayout = (YogaLayout) view2;
                return new HeaderFooterViewHolder(view2, yogaLayout.getYogaNode().getWidth(), yogaLayout.getYogaNode().getHeight());
            }
            return new RecyclerView.ViewHolder(this, view2) { // from class: com.tachikoma.core.component.recyclerview.RecyclerHeaderFooterAdapter.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecyclerHeaderFooterAdapter this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(view2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((View) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }
            };
        }
        return (RecyclerView.ViewHolder) invokeL.objValue;
    }

    private void notifyDataSetChangedCatchException() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                notifyDataSetChanged();
            } catch (Exception unused) {
            }
        }
    }

    public void addFooterAdapter(RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adapter) == null) {
            addFooterAdapter(adapter, this.mAdapterDataObserverProxy);
        }
    }

    public void addFooterAdapter(@NonNull RecyclerView.Adapter adapter, @Nullable RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adapter, adapterDataObserver) == null) {
            this.mFooterAdapter = adapter;
            RecyclerView.AdapterDataObserver recyclerFooterObserver = adapterDataObserver == null ? new RecyclerFooterObserver(this) : this.mAdapterDataObserverProxy;
            this.mFooterObserverProxy = recyclerFooterObserver;
            try {
                this.mFooterAdapter.registerAdapterDataObserver(recyclerFooterObserver);
            } catch (Exception unused) {
            }
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            addFooterView(view2, null);
        }
    }

    public void addFooterView(View view2, @Nullable ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, layoutParams) == null) {
            if (view2 == null) {
                throw new IllegalArgumentException("the view to add must not be null!");
            }
            if ((view2.getParent() instanceof ViewGroup) && view2.getParent() != this.mFooterGroup) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            if (layoutParams != null) {
                view2.setLayoutParams(layoutParams);
            }
            if (this.mFooterGroup.addView(view2)) {
                notifyDataSetChangedCatchException();
            }
        }
    }

    public void addHeaderAdapter(RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adapter) == null) {
            addHeaderAdapter(adapter, this.mAdapterDataObserverProxy);
        }
    }

    public void addHeaderAdapter(@NonNull RecyclerView.Adapter adapter, @Nullable RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, adapter, adapterDataObserver) == null) {
            this.mHeaderAdapter = adapter;
            RecyclerView.AdapterDataObserver recyclerHeaderObserver = adapterDataObserver == null ? new RecyclerHeaderObserver(this) : this.mAdapterDataObserverProxy;
            this.mHeaderObserverProxy = recyclerHeaderObserver;
            try {
                this.mHeaderAdapter.registerAdapterDataObserver(recyclerHeaderObserver);
            } catch (Exception unused) {
            }
            notifyDataSetChanged();
        }
    }

    public void addHeaderView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            addHeaderView(view2, null);
        }
    }

    public void addHeaderView(View view2, @Nullable ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, layoutParams) == null) {
            if (view2 == null) {
                throw new IllegalArgumentException("the view to add must not be null");
            }
            if (layoutParams != null) {
                view2.setLayoutParams(layoutParams);
            }
            if (this.mHeaderGroup.addView(view2)) {
                notifyDataSetChangedCatchException();
            }
        }
    }

    public int addHeaderViewWithoutNotify(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2)) == null) {
            if (view2 != null) {
                if (this.mHeaderGroup.addView(view2)) {
                    return getHeaderCount() - 1;
                }
                return -1;
            }
            throw new IllegalArgumentException("the view to add must not be null");
        }
        return invokeL.intValue;
    }

    public void adjustSpanSizeForHeaderFooter(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, recyclerView) == null) {
            adjustSpanSizeForHeaderFooter(recyclerView, null);
        }
    }

    public void adjustSpanSizeForHeaderFooter(RecyclerView recyclerView, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, recyclerView, spanSizeLookup) == null) {
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this, gridLayoutManager, spanSizeLookup) { // from class: com.tachikoma.core.component.recyclerview.RecyclerHeaderFooterAdapter.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RecyclerHeaderFooterAdapter this$0;
                    public final /* synthetic */ GridLayoutManager val$layoutManager;
                    public final /* synthetic */ GridLayoutManager.SpanSizeLookup val$spanSizeLookup;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, gridLayoutManager, spanSizeLookup};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$layoutManager = gridLayoutManager;
                        this.val$spanSizeLookup = spanSizeLookup;
                    }

                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int i) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i)) == null) {
                            if (this.this$0.isHeaderPosition(i) || this.this$0.isFooterPosition(i)) {
                                return this.val$layoutManager.getSpanCount();
                            }
                            GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.val$spanSizeLookup;
                            if (spanSizeLookup2 != null) {
                                return spanSizeLookup2.getSpanSize(i);
                            }
                            return 1;
                        }
                        return invokeI.intValue;
                    }
                });
            }
            if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                this.mIsStaggeredGrid = true;
            }
        }
    }

    public boolean containsFooterView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, view2)) == null) ? this.mFooterGroup.containsView(view2) : invokeL.booleanValue;
    }

    public boolean containsHeaderView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, view2)) == null) ? this.mHeaderGroup.containsView(view2) : invokeL.booleanValue;
    }

    public RecyclerView.Adapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mAdapter : (RecyclerView.Adapter) invokeV.objValue;
    }

    public int getBodyCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mAdapter.getItemCount() : invokeV.intValue;
    }

    public RecyclerView.Adapter getFooterAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mFooterAdapter : (RecyclerView.Adapter) invokeV.objValue;
    }

    public int getFooterCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            RecyclerView.Adapter adapter = this.mFooterAdapter;
            return adapter != null ? adapter.getItemCount() : this.mFooterGroup.viewCount();
        }
        return invokeV.intValue;
    }

    public RecyclerView.Adapter getHeaderAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mHeaderAdapter : (RecyclerView.Adapter) invokeV.objValue;
    }

    public int getHeaderCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RecyclerView.Adapter adapter = this.mHeaderAdapter;
            return adapter != null ? adapter.getItemCount() : this.mHeaderGroup.viewCount();
        }
        return invokeV.intValue;
    }

    public HeaderFooterViewGroup getHeaderGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mHeaderGroup : (HeaderFooterViewGroup) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getFooterCount() + getHeaderCount() + this.mAdapter.getItemCount() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            if (!isHeaderPosition(i)) {
                return isFooterPosition(i) ? this.mFooterAdapter != null ? this.mFooterAdapter.getItemId((i - getHeaderCount()) - this.mAdapter.getItemCount()) : getItemViewType(i) : this.mAdapter.getItemId(i - getHeaderCount());
            }
            RecyclerView.Adapter adapter = this.mHeaderAdapter;
            return adapter != null ? adapter.getItemId(i) : getItemViewType(i);
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            if (isHeaderPosition(i)) {
                RecyclerView.Adapter adapter = this.mHeaderAdapter;
                int itemViewType = (adapter != null ? adapter.getItemViewType(i) : this.mHeaderGroup.getViewTypeAtPos(i)) + BASE_HEADER_VIEW_TYPE;
                this.mMaxHeaderViewType = Math.max(itemViewType, this.mMaxHeaderViewType);
                return itemViewType;
            } else if (isFooterPosition(i)) {
                int itemCount = (i - this.mAdapter.getItemCount()) - getHeaderCount();
                RecyclerView.Adapter adapter2 = this.mFooterAdapter;
                int itemViewType2 = (adapter2 != null ? adapter2.getItemViewType(itemCount) : this.mFooterGroup.getViewTypeAtPos(itemCount)) + BASE_FOOTER_VIEW_TYPE;
                this.mMaxFooterViewType = Math.max(itemViewType2, this.mMaxFooterViewType);
                return itemViewType2;
            } else {
                return this.mAdapter.getItemViewType(i - getHeaderCount());
            }
        }
        return invokeI.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            RecyclerView.Adapter adapter = this.mAdapter;
            return adapter == null || adapter.getItemCount() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isFooterPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) ? i >= getHeaderCount() + this.mAdapter.getItemCount() : invokeI.booleanValue;
    }

    public boolean isFooterViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) ? i >= -2048 && i <= this.mMaxFooterViewType : invokeI.booleanValue;
    }

    public boolean isHeaderPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) ? i < getHeaderCount() : invokeI.booleanValue;
    }

    public boolean isHeaderViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) ? i >= -1024 && i <= this.mMaxHeaderViewType : invokeI.booleanValue;
    }

    public int map2FooterViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) ? i + 2048 : invokeI.intValue;
    }

    public int map2HeaderViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) ? i + 1024 : invokeI.intValue;
    }

    public void markHeaderOrFooterDirty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.mHeaderOrFooterDirty = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, recyclerView) == null) {
            super.onAttachedToRecyclerView(recyclerView);
            if (this.mAdapter.hasObservers()) {
                this.mAdapter.unregisterAdapterDataObserver(this.mAdapterDataObserverProxy);
            }
            this.mAdapter.registerAdapterDataObserver(this.mAdapterDataObserverProxy);
            this.mAdapter.onAttachedToRecyclerView(recyclerView);
            RecyclerView.Adapter adapter = this.mHeaderAdapter;
            if (adapter != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
                this.mHeaderAdapter.unregisterAdapterDataObserver(this.mHeaderObserverProxy);
                this.mHeaderAdapter.registerAdapterDataObserver(this.mHeaderObserverProxy);
            }
            RecyclerView.Adapter adapter2 = this.mFooterAdapter;
            if (adapter2 != null) {
                adapter2.onAttachedToRecyclerView(recyclerView);
                this.mFooterAdapter.unregisterAdapterDataObserver(this.mFooterObserverProxy);
                this.mFooterAdapter.registerAdapterDataObserver(this.mFooterObserverProxy);
            }
            adjustHeaderFooterView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, viewHolder, i) == null) {
            if (i >= getHeaderCount() && i < getHeaderCount() + this.mAdapter.getItemCount()) {
                this.mAdapter.onBindViewHolder(viewHolder, i - getHeaderCount());
                return;
            }
            if (i >= getHeaderCount() || (adapter = this.mHeaderAdapter) == null) {
                if (i >= getHeaderCount() + this.mAdapter.getItemCount() && (adapter = this.mFooterAdapter) != null) {
                    i = (i - getHeaderCount()) - this.mAdapter.getItemCount();
                }
                if ((viewHolder instanceof HeaderFooterViewHolder) || !this.mHeaderOrFooterDirty) {
                }
                ((HeaderFooterViewHolder) viewHolder).maybeReset();
                this.mHeaderOrFooterDirty = false;
                return;
            }
            adapter.onBindViewHolder(viewHolder, i);
            if (viewHolder instanceof HeaderFooterViewHolder) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048609, this, viewHolder, i, list) == null) {
            if (list.isEmpty()) {
                onBindViewHolder(viewHolder, i);
            } else if (i >= getHeaderCount() && i < getHeaderCount() + this.mAdapter.getItemCount()) {
                this.mAdapter.onBindViewHolder(viewHolder, i - getHeaderCount(), list);
            } else {
                if (i >= getHeaderCount() || (adapter = this.mHeaderAdapter) == null) {
                    if (i < getHeaderCount() + this.mAdapter.getItemCount() || (adapter = this.mFooterAdapter) == null) {
                        return;
                    }
                    i = (i - getHeaderCount()) - this.mAdapter.getItemCount();
                }
                adapter.onBindViewHolder(viewHolder, i, list);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, viewGroup, i)) == null) {
            if (isHeaderViewType(i)) {
                int map2HeaderViewType = map2HeaderViewType(i);
                RecyclerView.Adapter adapter = this.mHeaderAdapter;
                if (adapter == null) {
                    View viewWithType = this.mHeaderGroup.getViewWithType(map2HeaderViewType);
                    if (viewWithType != null && (viewWithType.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) viewWithType.getParent()).removeView(viewWithType);
                    }
                    return createHeaderFooterViewHolder(viewWithType);
                }
                return adapter.onCreateViewHolder(viewGroup, map2HeaderViewType);
            } else if (isFooterViewType(i)) {
                int map2FooterViewType = map2FooterViewType(i);
                RecyclerView.Adapter adapter2 = this.mFooterAdapter;
                if (adapter2 == null) {
                    View viewWithType2 = this.mFooterGroup.getViewWithType(map2FooterViewType);
                    if (viewWithType2 != null && (viewWithType2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) viewWithType2.getParent()).removeView(viewWithType2);
                    }
                    return createHeaderFooterViewHolder(viewWithType2);
                }
                return adapter2.onCreateViewHolder(viewGroup, map2FooterViewType);
            } else {
                return this.mAdapter.onCreateViewHolder(viewGroup, i);
            }
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, recyclerView) == null) {
            super.onDetachedFromRecyclerView(recyclerView);
            if (this.mAdapter.hasObservers()) {
                this.mAdapter.unregisterAdapterDataObserver(this.mAdapterDataObserverProxy);
            }
            this.mAdapter.onDetachedFromRecyclerView(recyclerView);
            RecyclerView.Adapter adapter = this.mHeaderAdapter;
            if (adapter != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
                this.mHeaderAdapter.unregisterAdapterDataObserver(this.mHeaderObserverProxy);
            }
            RecyclerView.Adapter adapter2 = this.mFooterAdapter;
            if (adapter2 != null) {
                adapter2.onDetachedFromRecyclerView(recyclerView);
                this.mFooterAdapter.unregisterAdapterDataObserver(this.mFooterObserverProxy);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r0 != null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r0 != null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        r0.onViewAttachedToWindow(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        adjustHeaderFooterView(r5, true);
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048612, this, viewHolder) != null) {
            return;
        }
        super.onViewAttachedToWindow(viewHolder);
        int itemViewType = viewHolder.getItemViewType();
        if (isHeaderViewType(itemViewType)) {
            adapter = this.mHeaderAdapter;
        } else if (!isFooterViewType(itemViewType)) {
            this.mAdapter.onViewAttachedToWindow(viewHolder);
            RecyclerView.Adapter adapter2 = this.mAdapter;
            adjustHeaderFooterView(viewHolder, adapter2 instanceof TKRecyclerAdapter ? ((TKRecyclerAdapter) adapter2).isFullWidgetForView(viewHolder.getLayoutPosition() - getHeaderCount()) : false);
        } else {
            adapter = this.mFooterAdapter;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, viewHolder) == null) {
            super.onViewDetachedFromWindow(viewHolder);
            int itemViewType = viewHolder.getItemViewType();
            if (isHeaderViewType(itemViewType)) {
                adapter = this.mHeaderAdapter;
                if (adapter == null) {
                    return;
                }
            } else if (isFooterViewType(itemViewType)) {
                adapter = this.mFooterAdapter;
                if (adapter == null) {
                    return;
                }
            } else {
                adapter = this.mAdapter;
            }
            adapter.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, adapterDataObserver) == null) {
            super.registerAdapterDataObserver(adapterDataObserver);
        }
    }

    public boolean removeFooterView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, view2)) == null) {
            boolean removeView = this.mFooterGroup.removeView(view2);
            if (removeView) {
                notifyDataSetChangedCatchException();
            }
            return removeView;
        }
        return invokeL.booleanValue;
    }

    public boolean removeFooterView(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048616, this, view2, z)) == null) {
            boolean removeView = this.mFooterGroup.removeView(view2);
            if (removeView && z) {
                notifyDataSetChangedCatchException();
            }
            return removeView;
        }
        return invokeLZ.booleanValue;
    }

    public boolean removeHeaderView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, view2)) == null) {
            boolean removeView = this.mHeaderGroup.removeView(view2);
            if (removeView) {
                notifyDataSetChangedCatchException();
            }
            return removeView;
        }
        return invokeL.booleanValue;
    }

    public void setFootersVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            for (int i = 0; i < this.mFooterGroup.viewCount(); i++) {
                this.mFooterGroup.getViewAtPos(i).setVisibility(z ? 0 : 8);
            }
            try {
                notifyItemRangeChanged(getHeaderCount() + this.mAdapter.getItemCount(), getFooterCount());
            } catch (Exception unused) {
            }
        }
    }

    public void setForceNotifyAll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.mForceNotifyAll = z;
        }
    }

    public void setHeadersVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            for (int i = 0; i < this.mHeaderGroup.viewCount(); i++) {
                this.mHeaderGroup.getViewAtPos(i).setVisibility(z ? 0 : 8);
            }
            try {
                notifyItemRangeChanged(0, getHeaderCount());
            } catch (Exception unused) {
            }
        }
    }

    public void setIsStaggeredGrid(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.mIsStaggeredGrid = z;
        }
    }

    public void setOverrideLayoutParams(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.mIsOverrideLayoutParams = z;
        }
    }

    public void setSmoothNotifyChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.mSmoothNotifyChange = z;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return "RecyclerHeaderFooterAdapter{mAdapter=" + this.mAdapter + ", mHeaderAdapter=" + this.mHeaderAdapter + ", mFooterAdapter=" + this.mFooterAdapter + '}';
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, adapterDataObserver) == null) {
            super.unregisterAdapterDataObserver(adapterDataObserver);
        }
    }

    public void updateAdapter(RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, adapter) == null) {
            this.mAdapter = adapter;
            try {
                adapter.registerAdapterDataObserver(this.mAdapterDataObserverProxy);
            } catch (Exception unused) {
            }
        }
    }
}
