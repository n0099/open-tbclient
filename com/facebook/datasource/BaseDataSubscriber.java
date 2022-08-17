package com.facebook.datasource;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nonnull;
/* loaded from: classes4.dex */
public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseDataSubscriber() {
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
    public void onCancellation(@Nonnull DataSource<T> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(@Nonnull DataSource<T> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
            try {
                onFailureImpl(dataSource);
            } finally {
                dataSource.close();
            }
        }
    }

    public abstract void onFailureImpl(@Nonnull DataSource<T> dataSource);

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(@Nonnull DataSource<T> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dataSource) == null) {
            boolean isFinished = dataSource.isFinished();
            try {
                onNewResultImpl(dataSource);
            } finally {
                if (isFinished) {
                    dataSource.close();
                }
            }
        }
    }

    public abstract void onNewResultImpl(@Nonnull DataSource<T> dataSource);

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(@Nonnull DataSource<T> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dataSource) == null) {
        }
    }
}
