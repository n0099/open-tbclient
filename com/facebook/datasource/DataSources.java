package com.facebook.datasource;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Supplier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class DataSources {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class ValueHolder<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public T value;

        public ValueHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = null;
        }
    }

    public DataSources() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, th)) == null) ? new Supplier<DataSource<T>>(th) { // from class: com.facebook.datasource.DataSources.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable val$failure;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {th};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$failure = th;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<T> get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? DataSources.immediateFailedDataSource(this.val$failure) : (DataSource) invokeV.objValue;
            }
        } : (Supplier) invokeL.objValue;
    }

    public static <T> DataSource<T> immediateDataSource(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, t)) == null) {
            SimpleDataSource create = SimpleDataSource.create();
            create.setResult(t);
            return create;
        }
        return (DataSource) invokeL.objValue;
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
            SimpleDataSource create = SimpleDataSource.create();
            create.setFailure(th);
            return create;
        }
        return (DataSource) invokeL.objValue;
    }

    @Nullable
    public static <T> T waitForFinalResult(DataSource<T> dataSource) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dataSource)) == null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ValueHolder valueHolder = new ValueHolder();
            ValueHolder valueHolder2 = new ValueHolder();
            dataSource.subscribe(new DataSubscriber<T>(valueHolder, countDownLatch, valueHolder2) { // from class: com.facebook.datasource.DataSources.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CountDownLatch val$latch;
                public final /* synthetic */ ValueHolder val$pendingException;
                public final /* synthetic */ ValueHolder val$resultHolder;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {valueHolder, countDownLatch, valueHolder2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$resultHolder = valueHolder;
                    this.val$latch = countDownLatch;
                    this.val$pendingException = valueHolder2;
                }

                @Override // com.facebook.datasource.DataSubscriber
                public void onCancellation(DataSource<T> dataSource2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dataSource2) == null) {
                        this.val$latch.countDown();
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable, T] */
                @Override // com.facebook.datasource.DataSubscriber
                public void onFailure(DataSource<T> dataSource2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource2) == null) {
                        try {
                            this.val$pendingException.value = dataSource2.getFailureCause();
                        } finally {
                            this.val$latch.countDown();
                        }
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.Object] */
                @Override // com.facebook.datasource.DataSubscriber
                public void onNewResult(DataSource<T> dataSource2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSource2) == null) && dataSource2.isFinished()) {
                        try {
                            this.val$resultHolder.value = dataSource2.getResult();
                        } finally {
                            this.val$latch.countDown();
                        }
                    }
                }

                @Override // com.facebook.datasource.DataSubscriber
                public void onProgressUpdate(DataSource<T> dataSource2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, dataSource2) == null) {
                    }
                }
            }, new Executor() { // from class: com.facebook.datasource.DataSources.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, runnable) == null) {
                        runnable.run();
                    }
                }
            });
            countDownLatch.await();
            T t = valueHolder2.value;
            if (t == null) {
                return valueHolder.value;
            }
            throw ((Throwable) t);
        }
        return (T) invokeL.objValue;
    }
}
