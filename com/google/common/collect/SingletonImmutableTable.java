package com.google.common.collect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableTable;
import d.f.d.a.n;
import d.f.d.c.k1;
import java.util.Map;
/* loaded from: classes6.dex */
public class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final C singleColumnKey;
    public final R singleRowKey;
    public final V singleValue;

    public SingletonImmutableTable(R r, C c2, V v) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r, c2, v};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n.p(r);
        this.singleRowKey = r;
        n.p(c2);
        this.singleColumnKey = c2;
        n.p(v);
        this.singleValue = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableTable, d.f.d.c.k1
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return column((SingletonImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0}) : (ImmutableTable.SerializedForm) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableTable, d.f.d.c.k1
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.google.common.collect.ImmutableTable, d.f.d.c.k1
    public ImmutableMap<R, V> column(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c2)) == null) {
            n.p(c2);
            if (containsColumn(c2)) {
                return ImmutableMap.of(this.singleRowKey, (Object) this.singleValue);
            }
            return ImmutableMap.of();
        }
        return (ImmutableMap) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.f.d.c.k1
    public ImmutableMap<C, Map<R, V>> columnMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, (Object) this.singleValue)) : (ImmutableMap) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.f.d.c.i
    public ImmutableSet<k1.a<R, C, V>> createCellSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ImmutableSet.of(ImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue)) : (ImmutableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.f.d.c.i
    public ImmutableCollection<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ImmutableSet.of(this.singleValue) : (ImmutableCollection) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.f.d.c.k1
    public ImmutableMap<R, Map<C, V>> rowMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, (Object) this.singleValue)) : (ImmutableMap) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingletonImmutableTable(k1.a<R, C, V> aVar) {
        this(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(objArr2[0], objArr2[1], objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
