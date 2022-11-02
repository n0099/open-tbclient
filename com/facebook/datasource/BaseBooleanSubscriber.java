package com.facebook.datasource;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class BaseBooleanSubscriber implements DataSubscriber<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.facebook.datasource.DataSubscriber
    public void onCancellation(DataSource<Boolean> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
        }
    }

    public abstract void onFailureImpl(DataSource<Boolean> dataSource);

    public abstract void onNewResultImpl(boolean z);

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(DataSource<Boolean> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dataSource) == null) {
        }
    }

    public BaseBooleanSubscriber() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(DataSource<Boolean> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
            try {
                onFailureImpl(dataSource);
            } finally {
                dataSource.close();
            }
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(DataSource<Boolean> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dataSource) == null) {
            try {
                onNewResultImpl(dataSource.getResult().booleanValue());
            } finally {
                dataSource.close();
            }
        }
    }
}
