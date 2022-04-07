package com.tachikoma.core.component.recyclerview;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.library.widget.refresh.RefreshLayout;
import com.tachikoma.core.component.recyclerview.export.TKRefreshControl;
/* loaded from: classes8.dex */
public class RefreshLayoutPresenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TKRefreshControl mRefreshControl;
    public RefreshLayout mRefreshLayout;

    public RefreshLayoutPresenter(RefreshLayout refreshLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {refreshLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRefreshLayout = refreshLayout;
    }

    public void registerRefreshControl(TKRefreshControl tKRefreshControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tKRefreshControl) == null) {
            this.mRefreshControl = tKRefreshControl;
        }
    }

    public void registerRefreshListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mRefreshLayout.setOnRefreshListener(new RefreshLayout.b(this) { // from class: com.tachikoma.core.component.recyclerview.RefreshLayoutPresenter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RefreshLayoutPresenter this$0;

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

                @Override // com.kwai.library.widget.refresh.RefreshLayout.b
                public void onRefresh() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mRefreshControl.onRefresh();
                    }
                }
            });
        }
    }
}
