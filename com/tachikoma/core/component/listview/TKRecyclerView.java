package com.tachikoma.core.component.listview;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
import com.kwai.library.widget.refresh.RefreshLayout;
import com.kwai.library.widget.refresh.b;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.recyclerview.LoadMorePresenter;
import com.tachikoma.core.component.recyclerview.RecyclerHeaderFooterAdapter;
import com.tachikoma.core.component.recyclerview.RefreshLayoutPresenter;
import com.tachikoma.core.component.recyclerview.export.TKRefreshControl;
import com.tachikoma.core.component.recyclerview.export.TKWaterLayoutConfiguration;
import com.tachikoma.core.component.recyclerview.pagelist.TKPageList;
import com.tachikoma.core.component.recyclerview.view.NestedRecyclerView;
import com.tachikoma.core.event.TKEventProcess;
import com.tachikoma.core.event.base.IBaseEvent;
import com.tachikoma.core.event.view.TKScrollEvent;
import com.tachikoma.core.utility.ObjectUtils;
import com.tachikoma.core.utility.SizeUtil;
import com.tachikoma.core.utility.V8Proxy;
import java.util.ArrayList;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes8.dex */
public class TKRecyclerView extends TKBase<b> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_GRID = "grid";
    public static final String TYPE_STAGGER = "stagger";
    public transient /* synthetic */ FieldHolder $fh;
    public TKRecyclerAdapter mAdapter;
    public int mDirection;
    public boolean mEnableLoadMore;
    public List<JSContext.V8AssociateReference> mFooterAssociateRefList;
    public List<View> mFooterViewList;
    public List<JSContext.V8AssociateReference> mHeaderAssociateRefList;
    public RecyclerHeaderFooterAdapter mHeaderFooterAdapter;
    public List<View> mHeaderViewList;
    public TKWaterLayoutConfiguration mItemDecoration;
    public String mLayoutType;
    public LoadMorePresenter mLoadMorePresenter;
    public int mOnEndReachedThreshold;
    public NestedRecyclerView mRecyclerView;
    public JSContext.V8AssociateReference mRefreshAssociateRef;
    public RefreshLayoutPresenter mRefreshListener;
    public int mSpanCount;
    public V8Object mV8AssociatedObject;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKRecyclerView(Context context, List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDirection = 1;
        this.mLayoutType = TYPE_GRID;
        this.mHeaderAssociateRefList = new ArrayList();
        this.mFooterAssociateRefList = new ArrayList();
        this.mV8AssociatedObject = ((V8Object) ObjectUtils.requireNonNull(V8Proxy.getAssociateJsObject(list))).twin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (V8Proxy.isV8Valid(this.mV8AssociatedObject)) {
                return ((Boolean) this.mV8AssociatedObject.executeJSFunction("hasMore")).booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEndReached() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && V8Proxy.isV8Valid(this.mV8AssociatedObject)) {
            this.mV8AssociatedObject.executeJSFunction("onEndReached", Integer.valueOf(this.mOnEndReachedThreshold));
        }
    }

    private void setAdapterIfNeed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (this.mAdapter == null) {
                Object obj = this.mV8AssociatedObject.get("dataSource");
                if ((obj instanceof V8Object) && V8Proxy.isV8Valid((V8Object) obj)) {
                    setAdapter(obj);
                }
                if (obj instanceof V8Value) {
                    V8Proxy.release((V8Value) obj);
                }
            }
            if (this.mAdapter != null) {
                V8Object v8Object = (V8Object) this.mV8AssociatedObject.get("delegate");
                this.mAdapter.setV8Delegate(v8Object);
                V8Proxy.release(v8Object);
            }
        }
    }

    public void addFooterView(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, v8Object) == null) && V8Proxy.isV8Valid(v8Object)) {
            if (this.mFooterViewList == null) {
                this.mFooterViewList = new ArrayList();
            }
            JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
            Object obj = associateReference.nativeObject;
            if (!(obj instanceof TKBase)) {
                associateReference.close();
                return;
            }
            this.mFooterViewList.add(((TKBase) obj).getView());
            this.mFooterAssociateRefList.add(associateReference);
        }
    }

    public void addHeaderView(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8Object) == null) && V8Proxy.isV8Valid(v8Object)) {
            if (this.mHeaderViewList == null) {
                this.mHeaderViewList = new ArrayList();
            }
            JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
            Object obj = associateReference.nativeObject;
            if (!(obj instanceof TKBase)) {
                associateReference.close();
                return;
            }
            this.mHeaderViewList.add(((TKBase) obj).getView());
            this.mHeaderAssociateRefList.add(associateReference);
        }
    }

    public RecyclerView.LayoutManager createLayoutManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TYPE_STAGGER.equals(this.mLayoutType)) {
                Context context = getContext();
                int i = this.mSpanCount;
                return new GridLayoutManager(context, i > 0 ? i : 1, this.mDirection, false);
            }
            this.mAdapter.setNeedFixHeight(true);
            this.mAdapter.setSupportForFullSpan(true);
            this.mHeaderFooterAdapter.setIsStaggeredGrid(true);
            int i2 = this.mSpanCount;
            return new StaggeredGridLayoutManager(i2 > 0 ? i2 : 1, this.mDirection);
        }
        return (RecyclerView.LayoutManager) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.component.TKBase
    public b createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            b bVar = new b(context);
            NestedRecyclerView nestedRecyclerView = new NestedRecyclerView(context);
            this.mRecyclerView = nestedRecyclerView;
            nestedRecyclerView.setOverScrollMode(2);
            bVar.addView(this.mRecyclerView);
            initRefreshController(bVar);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public RecyclerView getRecyclerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRecyclerView : (RecyclerView) invokeV.objValue;
    }

    public void hideLoadMore() {
        LoadMorePresenter loadMorePresenter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (loadMorePresenter = this.mLoadMorePresenter) == null) {
            return;
        }
        loadMorePresenter.hide();
    }

    public void initHeaderAndFooterView() {
        List<View> list;
        List<View> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.mHeaderFooterAdapter != null && (list2 = this.mHeaderViewList) != null && !list2.isEmpty()) {
                for (View view2 : this.mHeaderViewList) {
                    this.mHeaderFooterAdapter.addHeaderView(view2);
                }
            }
            if (this.mHeaderFooterAdapter == null || (list = this.mFooterViewList) == null || list.isEmpty()) {
                return;
            }
            for (View view3 : this.mFooterViewList) {
                this.mHeaderFooterAdapter.addFooterView(view3);
            }
        }
    }

    public void initLoadMore(RecyclerHeaderFooterAdapter recyclerHeaderFooterAdapter) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, recyclerHeaderFooterAdapter) == null) && this.mEnableLoadMore) {
            LoadMorePresenter loadMorePresenter = new LoadMorePresenter(getRecyclerView(), new TKPageList(this, null) { // from class: com.tachikoma.core.component.listview.TKRecyclerView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKRecyclerView this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((V8Object) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.tachikoma.core.component.recyclerview.pagelist.TKPageList, com.tachikoma.core.component.recyclerview.export.ITKPageList
                public boolean hasMore() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.hasMore() : invokeV.booleanValue;
                }
            });
            this.mLoadMorePresenter = loadMorePresenter;
            loadMorePresenter.addFooterView(getView(), recyclerHeaderFooterAdapter);
            this.mLoadMorePresenter.registerOnScrollListener();
        }
    }

    public void initRefreshControl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Object obj = this.mV8AssociatedObject.get("refreshControl");
            try {
                if ((obj instanceof V8Object) && V8Proxy.isV8Valid((V8Object) obj)) {
                    JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference((V8Object) obj);
                    TKRefreshControl tKRefreshControl = (TKRefreshControl) associateReference.nativeObject;
                    tKRefreshControl.setRefreshLayout(getView());
                    tKRefreshControl.setAssociateObject((V8Object) obj);
                    if (this.mRefreshListener != null) {
                        this.mRefreshListener.registerRefreshControl(tKRefreshControl);
                        if (this.mRefreshAssociateRef != null) {
                            this.mRefreshAssociateRef.close();
                        }
                        this.mRefreshAssociateRef = associateReference;
                    } else {
                        associateReference.close();
                    }
                }
            } finally {
                if (obj instanceof V8Value) {
                    V8Proxy.release((V8Value) obj);
                }
            }
        }
    }

    public void initRefreshController(RefreshLayout refreshLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, refreshLayout) == null) {
            RefreshLayoutPresenter refreshLayoutPresenter = new RefreshLayoutPresenter(refreshLayout);
            this.mRefreshListener = refreshLayoutPresenter;
            refreshLayoutPresenter.registerRefreshListener();
        }
    }

    public void notifyHeaderViewChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mHeaderFooterAdapter.markHeaderOrFooterDirty();
            this.mHeaderFooterAdapter.notifyDataSetChanged();
        }
    }

    public void notifyItemRangeChanged(int i, int i2) {
        TKRecyclerAdapter tKRecyclerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) || (tKRecyclerAdapter = this.mAdapter) == null) {
            return;
        }
        tKRecyclerAdapter.notifyItemRangeChanged(i, i2);
    }

    public void notifyItemRangeInserted(int i, int i2) {
        TKRecyclerAdapter tKRecyclerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) || (tKRecyclerAdapter = this.mAdapter) == null) {
            return;
        }
        tKRecyclerAdapter.notifyItemRangeInserted(i, i2);
    }

    public void notifyItemRangeRemoved(int i, int i2) {
        TKRecyclerAdapter tKRecyclerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) || (tKRecyclerAdapter = this.mAdapter) == null) {
            return;
        }
        tKRecyclerAdapter.notifyItemRangeRemoved(i, i2);
    }

    @Override // com.tachikoma.core.component.TKBase
    public void onAttach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            setAdapterIfNeed();
            getRecyclerView().setLayoutManager(createLayoutManager());
            getRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.tachikoma.core.component.listview.TKRecyclerView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKRecyclerView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(1048576, this, recyclerView, i, i2) == null) {
                        super.onScrolled(recyclerView, i, i2);
                        this.this$0.dispatchEvent("scroll", new TKEventProcess.EventInterface(this, recyclerView, i, i2) { // from class: com.tachikoma.core.component.listview.TKRecyclerView.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 this$1;
                            public final /* synthetic */ int val$dx;
                            public final /* synthetic */ int val$dy;
                            public final /* synthetic */ RecyclerView val$recyclerView;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$recyclerView = recyclerView;
                                this.val$dx = i;
                                this.val$dy = i2;
                            }

                            @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                            public void callBackEvent(IBaseEvent iBaseEvent) {
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) && (iBaseEvent instanceof TKScrollEvent)) {
                                    TKScrollEvent tKScrollEvent = (TKScrollEvent) iBaseEvent;
                                    tKScrollEvent.setState(this.val$recyclerView.getScrollState());
                                    tKScrollEvent.setDx(SizeUtil.px2DpAsFloat(this.val$dx));
                                    tKScrollEvent.setDy(SizeUtil.px2DpAsFloat(this.val$dy));
                                    tKScrollEvent.setScrollOffsetX(SizeUtil.px2DpAsFloat(this.val$recyclerView.computeHorizontalScrollOffset()));
                                    tKScrollEvent.setScrollOffsetY(SizeUtil.px2DpAsFloat(this.val$recyclerView.computeVerticalScrollOffset()));
                                }
                            }
                        });
                    }
                }
            });
            TKWaterLayoutConfiguration tKWaterLayoutConfiguration = this.mItemDecoration;
            if (tKWaterLayoutConfiguration != null && tKWaterLayoutConfiguration.isValid()) {
                getRecyclerView().addItemDecoration(new TKCustomItemDecoration(this.mItemDecoration));
            }
            initRefreshControl();
            registerScrollListener();
            initHeaderAndFooterView();
        }
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            TKRecyclerAdapter tKRecyclerAdapter = this.mAdapter;
            if (tKRecyclerAdapter != null) {
                tKRecyclerAdapter.onDestroy();
            }
            JSContext.V8AssociateReference.closeAllReference(this.mHeaderAssociateRefList.iterator());
            this.mHeaderAssociateRefList.clear();
            JSContext.V8AssociateReference.closeAllReference(this.mFooterAssociateRefList.iterator());
            this.mFooterAssociateRefList.clear();
            JSContext.V8AssociateReference v8AssociateReference = this.mRefreshAssociateRef;
            if (v8AssociateReference != null) {
                v8AssociateReference.close();
                this.mRefreshAssociateRef = null;
            }
            V8Object v8Object = this.mV8AssociatedObject;
            if (v8Object != null) {
                v8Object.close();
                this.mV8AssociatedObject = null;
            }
        }
    }

    public void registerScrollListener() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.tachikoma.core.component.listview.TKRecyclerView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean isScrollDown;
            public final /* synthetic */ TKRecyclerView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
                this.isScrollDown = false;
            }

            private int getLastVisibleItem(int[] iArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, iArr)) == null) {
                    int i = -1;
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        if (i2 == 0) {
                            i = iArr[i2];
                        } else if (iArr[i2] > i) {
                            i = iArr[i2];
                        }
                    }
                    return i;
                }
                return invokeL.intValue;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                int i2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i) == null) {
                    super.onScrollStateChanged(recyclerView, i);
                    int itemCount = this.this$0.mAdapter.getItemCount();
                    if (i == 0 && this.isScrollDown) {
                        TKRecyclerView tKRecyclerView = this.this$0;
                        if (tKRecyclerView.mOnEndReachedThreshold > 0) {
                            if (tKRecyclerView.mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                                i2 = ((LinearLayoutManager) this.this$0.mRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                                if (i2 == -1) {
                                    i2 = ((LinearLayoutManager) this.this$0.mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                                }
                            } else {
                                i2 = -1;
                            }
                            if (this.this$0.mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                                int[] findLastCompletelyVisibleItemPositions = ((StaggeredGridLayoutManager) this.this$0.mRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPositions(null);
                                int lastVisibleItem = getLastVisibleItem(findLastCompletelyVisibleItemPositions);
                                if (lastVisibleItem == -1) {
                                    ((StaggeredGridLayoutManager) this.this$0.mRecyclerView.getLayoutManager()).findLastVisibleItemPositions(findLastCompletelyVisibleItemPositions);
                                    i2 = getLastVisibleItem(findLastCompletelyVisibleItemPositions);
                                } else {
                                    i2 = lastVisibleItem;
                                }
                            }
                            if (i2 != -1) {
                                int headerCount = (itemCount - i2) - this.this$0.mHeaderFooterAdapter.getHeaderCount();
                                TKRecyclerView tKRecyclerView2 = this.this$0;
                                if (headerCount <= tKRecyclerView2.mOnEndReachedThreshold) {
                                    tKRecyclerView2.onEndReached();
                                }
                            }
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                    super.onScrolled(recyclerView, i, i2);
                    this.isScrollDown = i2 >= 0 && Math.abs(i2) >= Math.abs(i);
                }
            }
        });
    }

    public void reloadData() {
        RecyclerHeaderFooterAdapter recyclerHeaderFooterAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (recyclerHeaderFooterAdapter = this.mHeaderFooterAdapter) == null) {
            return;
        }
        recyclerHeaderFooterAdapter.notifyDataSetChanged();
    }

    public void scrollToPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            getRecyclerView().scrollToPosition(i);
        }
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) && (getRecyclerView().getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) getRecyclerView().getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    public void setAdapter(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, obj) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mTKJSContext);
            arrayList.add(obj);
            TKRecyclerAdapter tKRecyclerAdapter = new TKRecyclerAdapter(getContext(), arrayList);
            this.mAdapter = tKRecyclerAdapter;
            RecyclerHeaderFooterAdapter recyclerHeaderFooterAdapter = new RecyclerHeaderFooterAdapter(tKRecyclerAdapter);
            this.mHeaderFooterAdapter = recyclerHeaderFooterAdapter;
            this.mRecyclerView.setAdapter(recyclerHeaderFooterAdapter);
            initLoadMore(this.mHeaderFooterAdapter);
        }
    }

    public void setCanPullToRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            getView().setEnabled(z);
            NestedRecyclerView nestedRecyclerView = this.mRecyclerView;
            if (nestedRecyclerView != null) {
                nestedRecyclerView.setCanPullToRefresh(z);
            }
        }
    }

    public void setDirection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.mDirection = i == 0 ? 0 : 1;
        }
    }

    public void setEnableLoadMore(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.mEnableLoadMore = z;
        }
    }

    public void setFixScrollConflictDirection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.mRecyclerView.setFixScrollConflictDirection(i);
        }
    }

    public void setLayoutType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.mLayoutType = str;
        }
    }

    public void setSpanCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.mSpanCount = i;
        }
    }

    public void setWaterLayout(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, v8Object) == null) && V8Proxy.isV8Valid(v8Object)) {
            TKWaterLayoutConfiguration tKWaterLayoutConfiguration = new TKWaterLayoutConfiguration();
            this.mItemDecoration = tKWaterLayoutConfiguration;
            tKWaterLayoutConfiguration.edgePadding = SizeUtil.dp2Px(V8Proxy.getV8IntValueSafely(v8Object, "edgePadding", 0));
            this.mItemDecoration.centerPadding = SizeUtil.dp2Px(V8Proxy.getV8IntValueSafely(v8Object, "centerPadding", 0));
            this.mItemDecoration.rowPadding = SizeUtil.dp2Px(V8Proxy.getV8IntValueSafely(v8Object, "rowPadding", 0));
        }
    }

    public void showLoadMore() {
        LoadMorePresenter loadMorePresenter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (loadMorePresenter = this.mLoadMorePresenter) == null) {
            return;
        }
        loadMorePresenter.show();
    }

    public void smoothScrollToPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            getRecyclerView().smoothScrollToPosition(i);
        }
    }
}
