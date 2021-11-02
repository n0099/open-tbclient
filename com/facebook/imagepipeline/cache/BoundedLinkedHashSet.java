package com.facebook.imagepipeline.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashSet;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes11.dex */
public class BoundedLinkedHashSet<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashSet<E> mLinkedHashSet;
    public int mMaxSize;

    public BoundedLinkedHashSet(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLinkedHashSet = new LinkedHashSet<>(i2);
        this.mMaxSize = i2;
    }

    public synchronized boolean add(E e2) {
        InterceptResult invokeL;
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            synchronized (this) {
                if (this.mLinkedHashSet.size() == this.mMaxSize) {
                    this.mLinkedHashSet.remove(this.mLinkedHashSet.iterator().next());
                }
                this.mLinkedHashSet.remove(e2);
                add = this.mLinkedHashSet.add(e2);
            }
            return add;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean contains(E e2) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) {
            synchronized (this) {
                contains = this.mLinkedHashSet.contains(e2);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }
}
