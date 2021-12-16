package com.facebook.datasource;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mDataSourceLazy;
    public final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    @ThreadSafe
    /* loaded from: classes2.dex */
    public class IncreasingQualityDataSource extends AbstractDataSource<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        public ArrayList<DataSource<T>> mDataSources;
        @Nullable
        public Throwable mDelayedError;
        public AtomicInteger mFinishedDataSources;
        @GuardedBy("IncreasingQualityDataSource.this")
        public int mIndexOfDataSourceWithResult;
        public int mNumberOfDataSources;
        public final /* synthetic */ IncreasingQualityDataSourceSupplier this$0;

        /* loaded from: classes2.dex */
        public class InternalDataSubscriber implements DataSubscriber<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int mIndex;
            public final /* synthetic */ IncreasingQualityDataSource this$1;

            public InternalDataSubscriber(IncreasingQualityDataSource increasingQualityDataSource, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {increasingQualityDataSource, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = increasingQualityDataSource;
                this.mIndex = i2;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                    this.this$1.onDataSourceFailed(this.mIndex, dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSource) == null) {
                    if (dataSource.hasResult()) {
                        this.this$1.onDataSourceNewResult(this.mIndex, dataSource);
                    } else if (dataSource.isFinished()) {
                        this.this$1.onDataSourceFailed(this.mIndex, dataSource);
                    }
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, dataSource) == null) && this.mIndex == 0) {
                    this.this$1.setProgress(dataSource.getProgress());
                }
            }
        }

        public IncreasingQualityDataSource(IncreasingQualityDataSourceSupplier increasingQualityDataSourceSupplier) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {increasingQualityDataSourceSupplier};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = increasingQualityDataSourceSupplier;
            if (increasingQualityDataSourceSupplier.mDataSourceLazy) {
                return;
            }
            ensureDataSourceInitialized();
        }

        private void closeSafely(DataSource<T> dataSource) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65539, this, dataSource) == null) || dataSource == null) {
                return;
            }
            dataSource.close();
        }

        private void ensureDataSourceInitialized() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.mFinishedDataSources == null) {
                synchronized (this) {
                    if (this.mFinishedDataSources == null) {
                        this.mFinishedDataSources = new AtomicInteger(0);
                        int size = this.this$0.mDataSourceSuppliers.size();
                        this.mNumberOfDataSources = size;
                        this.mIndexOfDataSourceWithResult = size;
                        this.mDataSources = new ArrayList<>(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            DataSource<T> dataSource = (DataSource) ((Supplier) this.this$0.mDataSourceSuppliers.get(i2)).get();
                            this.mDataSources.add(dataSource);
                            dataSource.subscribe(new InternalDataSubscriber(this, i2), CallerThreadExecutor.getInstance());
                            if (dataSource.hasResult()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized DataSource<T> getAndClearDataSource(int i2) {
            InterceptResult invokeI;
            DataSource<T> dataSource;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i2)) == null) {
                synchronized (this) {
                    dataSource = null;
                    if (this.mDataSources != null && i2 < this.mDataSources.size()) {
                        dataSource = this.mDataSources.set(i2, null);
                    }
                }
                return dataSource;
            }
            return (DataSource) invokeI.objValue;
        }

        @Nullable
        private synchronized DataSource<T> getDataSource(int i2) {
            InterceptResult invokeI;
            DataSource<T> dataSource;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i2)) == null) {
                synchronized (this) {
                    dataSource = (this.mDataSources == null || i2 >= this.mDataSources.size()) ? null : this.mDataSources.get(i2);
                }
                return dataSource;
            }
            return (DataSource) invokeI.objValue;
        }

        @Nullable
        private synchronized DataSource<T> getDataSourceWithResult() {
            InterceptResult invokeV;
            DataSource<T> dataSource;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
                synchronized (this) {
                    dataSource = getDataSource(this.mIndexOfDataSourceWithResult);
                }
                return dataSource;
            }
            return (DataSource) invokeV.objValue;
        }

        private void maybeSetFailure() {
            Throwable th;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65544, this) == null) && this.mFinishedDataSources.incrementAndGet() == this.mNumberOfDataSources && (th = this.mDelayedError) != null) {
                setFailure(th);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0028 A[LOOP:0: B:19:0x0026->B:20:0x0028, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void maybeSetIndexOfDataSourceWithResult(int i2, DataSource<T> dataSource, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i2), dataSource, Boolean.valueOf(z)}) == null) {
                synchronized (this) {
                    int i3 = this.mIndexOfDataSourceWithResult;
                    if (dataSource == getDataSource(i2) && i2 != this.mIndexOfDataSourceWithResult) {
                        if (getDataSourceWithResult() != null && (!z || i2 >= this.mIndexOfDataSourceWithResult)) {
                            i2 = i3;
                            for (int i4 = this.mIndexOfDataSourceWithResult; i4 > i2; i4--) {
                                closeSafely(getAndClearDataSource(i4));
                            }
                        }
                        this.mIndexOfDataSourceWithResult = i2;
                        while (i4 > i2) {
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceFailed(int i2, DataSource<T> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65546, this, i2, dataSource) == null) {
                closeSafely(tryGetAndClearDataSource(i2, dataSource));
                if (i2 == 0) {
                    this.mDelayedError = dataSource.getFailureCause();
                }
                maybeSetFailure();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceNewResult(int i2, DataSource<T> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65547, this, i2, dataSource) == null) {
                maybeSetIndexOfDataSourceWithResult(i2, dataSource, dataSource.isFinished());
                if (dataSource == getDataSourceWithResult()) {
                    setResult(null, i2 == 0 && dataSource.isFinished());
                }
                maybeSetFailure();
            }
        }

        @Nullable
        private synchronized DataSource<T> tryGetAndClearDataSource(int i2, DataSource<T> dataSource) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65548, this, i2, dataSource)) == null) {
                synchronized (this) {
                    if (dataSource == getDataSourceWithResult()) {
                        return null;
                    }
                    return dataSource == getDataSource(i2) ? getAndClearDataSource(i2) : dataSource;
                }
            }
            return (DataSource) invokeIL.objValue;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.this$0.mDataSourceLazy) {
                    ensureDataSourceInitialized();
                }
                synchronized (this) {
                    if (super.close()) {
                        ArrayList<DataSource<T>> arrayList = this.mDataSources;
                        this.mDataSources = null;
                        if (arrayList != null) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                closeSafely(arrayList.get(i2));
                            }
                            return true;
                        }
                        return true;
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            InterceptResult invokeV;
            T result;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    if (this.this$0.mDataSourceLazy) {
                        ensureDataSourceInitialized();
                    }
                    DataSource<T> dataSourceWithResult = getDataSourceWithResult();
                    result = dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
                }
                return result;
            }
            return (T) invokeV.objValue;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    if (this.this$0.mDataSourceLazy) {
                        ensureDataSourceInitialized();
                    }
                    DataSource<T> dataSourceWithResult = getDataSourceWithResult();
                    if (dataSourceWithResult != null) {
                        z = dataSourceWithResult.hasResult();
                    }
                }
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    public IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
        this.mDataSourceLazy = z;
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) ? create(list, false) : (IncreasingQualityDataSourceSupplier) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof IncreasingQualityDataSourceSupplier) {
                return Objects.equal(this.mDataSourceSuppliers, ((IncreasingQualityDataSourceSupplier) obj).mDataSourceSuppliers);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDataSourceSuppliers.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Objects.toStringHelper(this).add("list", this.mDataSourceSuppliers).toString() : (String) invokeV.objValue;
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) ? new IncreasingQualityDataSourceSupplier<>(list, z) : (IncreasingQualityDataSourceSupplier) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new IncreasingQualityDataSource(this) : (DataSource) invokeV.objValue;
    }
}
