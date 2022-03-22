package com.squareup.wire2.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes7.dex */
public final class MutableOnWriteList<T> extends AbstractList<T> implements RandomAccess, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<T> immutableList;
    public List<T> mutableList;

    public MutableOnWriteList(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.immutableList = list;
        this.mutableList = list;
    }

    private Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? new ArrayList(this.mutableList) : invokeV.objValue;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, t) == null) {
            if (this.mutableList == this.immutableList) {
                this.mutableList = new ArrayList(this.immutableList);
            }
            this.mutableList.add(i, t);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.mutableList.get(i) : (T) invokeI.objValue;
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.mutableList == this.immutableList) {
                this.mutableList = new ArrayList(this.immutableList);
            }
            return this.mutableList.remove(i);
        }
        return (T) invokeI.objValue;
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, t)) == null) {
            if (this.mutableList == this.immutableList) {
                this.mutableList = new ArrayList(this.immutableList);
            }
            return this.mutableList.set(i, t);
        }
        return (T) invokeIL.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mutableList.size() : invokeV.intValue;
    }
}
