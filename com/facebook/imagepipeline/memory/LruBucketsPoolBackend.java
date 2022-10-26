package com.facebook.imagepipeline.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public abstract class LruBucketsPoolBackend implements PoolBackend {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set mCurrentItems;
    public final BucketMap mMap;

    public LruBucketsPoolBackend() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentItems = new HashSet();
        this.mMap = new BucketMap();
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    @Nullable
    public Object pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return maybeRemoveFromCurrentItems(this.mMap.removeFromEnd());
        }
        return invokeV.objValue;
    }

    public int valueCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mMap.valueCount();
        }
        return invokeV.intValue;
    }

    private Object maybeRemoveFromCurrentItems(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, obj)) == null) {
            if (obj != null) {
                synchronized (this) {
                    this.mCurrentItems.remove(obj);
                }
            }
            return obj;
        }
        return invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    @Nullable
    public Object get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return maybeRemoveFromCurrentItems(this.mMap.acquire(i));
        }
        return invokeI.objValue;
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public void put(Object obj) {
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            synchronized (this) {
                add = this.mCurrentItems.add(obj);
            }
            if (add) {
                this.mMap.release(getSize(obj), obj);
            }
        }
    }
}
