package com.huawei.hms.common.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.Preconditions;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class DBInnerIter<O> implements Iterator<O> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataBuffer<O> dataBuffer;
    public int index;

    public DBInnerIter(DataBuffer<O> dataBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataBuffer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.index = -1;
        Preconditions.checkNotNull(dataBuffer, "dataBuffer cannot be null");
        this.dataBuffer = dataBuffer;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.index + 1 < this.dataBuffer.getCount()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.Iterator
    public O next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (hasNext()) {
                DataBuffer<O> dataBuffer = this.dataBuffer;
                int i = this.index + 1;
                this.index = i;
                return dataBuffer.get(i);
            }
            return null;
        }
        return (O) invokeV.objValue;
    }
}
