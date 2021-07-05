package com.google.common.cache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.cache.Striped64;
import d.f.d.b.g;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/* loaded from: classes7.dex */
public final class LongAdder extends Striped64 implements Serializable, g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 7249069246863182397L;
    public transient /* synthetic */ FieldHolder $fh;

    public LongAdder() {
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

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            this.busy = 0;
            this.cells = null;
            this.base = objectInputStream.readLong();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeLong(sum());
        }
    }

    @Override // d.f.d.b.g
    public void add(long j) {
        int length;
        Striped64.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            Striped64.b[] bVarArr = this.cells;
            if (bVarArr == null) {
                long j2 = this.base;
                if (casBase(j2, j2 + j)) {
                    return;
                }
            }
            int[] iArr = Striped64.threadHashCode.get();
            boolean z = true;
            if (iArr != null && bVarArr != null && (length = bVarArr.length) >= 1 && (bVar = bVarArr[(length - 1) & iArr[0]]) != null) {
                long j3 = bVar.f32976a;
                z = bVar.a(j3, j3 + j);
                if (z) {
                    return;
                }
            }
            retryUpdate(j, iArr, z);
        }
    }

    public void decrement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            add(-1L);
        }
    }

    @Override // java.lang.Number
    public double doubleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? sum() : invokeV.doubleValue;
    }

    @Override // java.lang.Number
    public float floatValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (float) sum() : invokeV.floatValue;
    }

    @Override // com.google.common.cache.Striped64
    public final long fn(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? j + j2 : invokeCommon.longValue;
    }

    @Override // d.f.d.b.g
    public void increment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            add(1L);
        }
    }

    @Override // java.lang.Number
    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (int) sum() : invokeV.intValue;
    }

    @Override // java.lang.Number
    public long longValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? sum() : invokeV.longValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            internalReset(0L);
        }
    }

    @Override // d.f.d.b.g
    public long sum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long j = this.base;
            Striped64.b[] bVarArr = this.cells;
            if (bVarArr != null) {
                for (Striped64.b bVar : bVarArr) {
                    if (bVar != null) {
                        j += bVar.f32976a;
                    }
                }
            }
            return j;
        }
        return invokeV.longValue;
    }

    public long sumThenReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            long j = this.base;
            Striped64.b[] bVarArr = this.cells;
            this.base = 0L;
            if (bVarArr != null) {
                for (Striped64.b bVar : bVarArr) {
                    if (bVar != null) {
                        j += bVar.f32976a;
                        bVar.f32976a = 0L;
                    }
                }
            }
            return j;
        }
        return invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Long.toString(sum()) : (String) invokeV.objValue;
    }
}
