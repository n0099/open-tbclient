package com.google.common.collect;

import b.h.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class RegularImmutableList<E> extends ImmutableList<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final ImmutableList<Object> EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient Object[] array;
    public final transient int size;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-212730358, "Lcom/google/common/collect/RegularImmutableList;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-212730358, "Lcom/google/common/collect/RegularImmutableList;");
                return;
            }
        }
        EMPTY = new RegularImmutableList(new Object[0], 0);
    }

    public RegularImmutableList(Object[] objArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {objArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.array = objArr;
        this.size = i2;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, objArr, i2)) == null) {
            System.arraycopy(this.array, 0, objArr, i2, this.size);
            return i2 + this.size;
        }
        return invokeLI.intValue;
    }

    @Override // java.util.List
    public E get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            n.n(i2, this.size);
            return (E) this.array[i2];
        }
        return (E) invokeI.objValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.array : (Object[]) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.size : invokeV.intValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.size : invokeV.intValue;
    }
}
