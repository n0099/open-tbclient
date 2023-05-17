package com.huawei.hms.common.data;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.api.client.Result;
import java.util.Iterator;
/* loaded from: classes9.dex */
public abstract class AbstractDataBuffer<T> extends Result implements DataBuffer<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataHolder mDataHolder;

    @Override // com.huawei.hms.common.data.DataBuffer
    public abstract T get(int i);

    public AbstractDataBuffer(DataHolder dataHolder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataHolder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDataHolder = dataHolder;
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    @Deprecated
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            release();
        }
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            DataHolder dataHolder = this.mDataHolder;
            if (dataHolder == null) {
                return 0;
            }
            return dataHolder.getCount();
        }
        return invokeV.intValue;
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public Bundle getMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mDataHolder.getMetadata();
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    @Deprecated
    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            DataHolder dataHolder = this.mDataHolder;
            if (dataHolder == null) {
                return true;
            }
            return dataHolder.isClosed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.huawei.hms.common.data.DataBuffer, java.lang.Iterable
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new DBInnerIter(this);
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // com.huawei.hms.common.data.DataBuffer, com.huawei.hms.common.api.Releasable
    public void release() {
        DataHolder dataHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (dataHolder = this.mDataHolder) != null) {
            dataHolder.close();
        }
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public Iterator<T> singleRefIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new SingleRefDBInnerIter(this);
        }
        return (Iterator) invokeV.objValue;
    }
}
