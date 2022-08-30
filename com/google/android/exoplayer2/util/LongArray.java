package com.google.android.exoplayer2.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class LongArray {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_INITIAL_CAPACITY = 32;
    public transient /* synthetic */ FieldHolder $fh;
    public int size;
    public long[] values;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LongArray() {
        this(32);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void add(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = this.size;
            long[] jArr = this.values;
            if (i == jArr.length) {
                this.values = Arrays.copyOf(jArr, i * 2);
            }
            long[] jArr2 = this.values;
            int i2 = this.size;
            this.size = i2 + 1;
            jArr2[i2] = j;
        }
    }

    public long get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 0 && i < this.size) {
                return this.values[i];
            }
            throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.size);
        }
        return invokeI.longValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.size : invokeV.intValue;
    }

    public long[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Arrays.copyOf(this.values, this.size) : (long[]) invokeV.objValue;
    }

    public LongArray(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.values = new long[i];
    }
}
