package com.facebook.imagepipeline.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.references.OOMSoftReference;
import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes6.dex */
public class OOMSoftReferenceBucket<V> extends Bucket<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<OOMSoftReference<V>> mSpareReferences;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OOMSoftReferenceBucket(int i2, int i3, int i4) {
        super(i2, i3, i4, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSpareReferences = new LinkedList<>();
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public void addToFreeList(V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
            OOMSoftReference<V> poll = this.mSpareReferences.poll();
            if (poll == null) {
                poll = new OOMSoftReference<>();
            }
            poll.set(v);
            this.mFreeList.add(poll);
        }
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public V pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            OOMSoftReference<V> oOMSoftReference = (OOMSoftReference) this.mFreeList.poll();
            V v = oOMSoftReference.get();
            oOMSoftReference.clear();
            this.mSpareReferences.add(oOMSoftReference);
            return v;
        }
        return (V) invokeV.objValue;
    }
}
