package com.google.common.collect;

import c.i.c.a.n;
import c.i.c.c.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class CartesianList$1 extends ImmutableList<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ l this$0;
    public final /* synthetic */ int val$index;

    public CartesianList$1(l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = lVar;
        this.val$index = i2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [E, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3, types: [E, java.lang.Object] */
    @Override // java.util.List
    public E get(int i2) {
        InterceptResult invokeI;
        int c2;
        ImmutableList immutableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            n.n(i2, size());
            c2 = this.this$0.c(this.val$index, i2);
            immutableList = this.this$0.f28686e;
            return ((List) immutableList.get(i2)).get(c2);
        }
        return invokeI.objValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        InterceptResult invokeV;
        ImmutableList immutableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            immutableList = this.this$0.f28686e;
            return immutableList.size();
        }
        return invokeV.intValue;
    }
}
