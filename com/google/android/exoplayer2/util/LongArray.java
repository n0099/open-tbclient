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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void add(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            int i2 = this.size;
            long[] jArr = this.values;
            if (i2 == jArr.length) {
                this.values = Arrays.copyOf(jArr, i2 * 2);
            }
            long[] jArr2 = this.values;
            int i3 = this.size;
            this.size = i3 + 1;
            jArr2[i3] = j2;
        }
    }

    public long get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 >= 0 && i2 < this.size) {
                return this.values[i2];
            }
            throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + this.size);
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

    public LongArray(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.values = new long[i2];
    }
}
