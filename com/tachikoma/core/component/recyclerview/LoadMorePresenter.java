package com.tachikoma.core.component.recyclerview;

import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.library.widget.refresh.RefreshLayout;
import com.kwai.library.widget.refresh.e;
import com.tachikoma.core.component.recyclerview.export.ITKPageList;
/* loaded from: classes2.dex */
public class LoadMorePresenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e mLoadingView;
    public final ITKPageList mPageList;
    public final RecyclerView mRecyclerView;

    public LoadMorePresenter(RecyclerView recyclerView, ITKPageList iTKPageList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recyclerView, iTKPageList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRecyclerView = recyclerView;
        this.mPageList = iTKPageList;
    }

    public void addFooterView(RefreshLayout refreshLayout, RecyclerHeaderFooterAdapter recyclerHeaderFooterAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, refreshLayout, recyclerHeaderFooterAdapter) == null) {
            e eVar = new e(refreshLayout.getContext(), null);
            eVar.setVisibility(4);
            this.mLoadingView = eVar;
            LinearLayout linearLayout = new LinearLayout(refreshLayout.getContext());
            linearLayout.addView(this.mLoadingView, -1, -2);
            recyclerHeaderFooterAdapter.addFooterView(linearLayout);
        }
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mLoadingView.a(false, null);
        }
    }

    public void registerOnScrollListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.tachikoma.core.component.recyclerview.LoadMorePresenter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LoadMorePresenter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                public boolean isReadyLoadMore(ITKPageList iTKPageList) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, iTKPageList)) == null) ? iTKPageList != null && iTKPageList.hasMore() : invokeL.booleanValue;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) {
                        super.onScrollStateChanged(recyclerView, i2);
                        if (i2 == 1) {
                            tryToLoadMore(recyclerView);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i2, i3) == null) {
                        super.onScrolled(recyclerView, i2, i3);
                        if (i3 != 0) {
                            tryToLoadMore(recyclerView);
                        }
                    }
                }

                public void tryToLoadMore(RecyclerView recyclerView) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048579, this, recyclerView) == null) || recyclerView.getChildCount() <= 0 || !isReadyLoadMore(this.this$0.mPageList) || recyclerView.canScrollVertically(1)) {
                        return;
                    }
                    this.this$0.show();
                    this.this$0.mPageList.load();
                }
            });
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mLoadingView.a(true, null);
        }
    }
}
