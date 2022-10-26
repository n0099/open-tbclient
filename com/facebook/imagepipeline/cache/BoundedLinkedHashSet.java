package com.facebook.imagepipeline.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashSet;
/* loaded from: classes7.dex */
public class BoundedLinkedHashSet {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashSet mLinkedHashSet;
    public int mMaxSize;

    public BoundedLinkedHashSet(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLinkedHashSet = new LinkedHashSet(i);
        this.mMaxSize = i;
    }

    public synchronized boolean add(Object obj) {
        InterceptResult invokeL;
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            synchronized (this) {
                if (this.mLinkedHashSet.size() == this.mMaxSize) {
                    this.mLinkedHashSet.remove(this.mLinkedHashSet.iterator().next());
                }
                this.mLinkedHashSet.remove(obj);
                add = this.mLinkedHashSet.add(obj);
            }
            return add;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean contains(Object obj) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            synchronized (this) {
                contains = this.mLinkedHashSet.contains(obj);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }
}
