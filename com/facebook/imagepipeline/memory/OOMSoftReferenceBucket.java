package com.facebook.imagepipeline.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.references.OOMSoftReference;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class OOMSoftReferenceBucket extends Bucket {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList mSpareReferences;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OOMSoftReferenceBucket(int i, int i2, int i3) {
        super(i, i2, i3, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSpareReferences = new LinkedList();
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public void addToFreeList(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            OOMSoftReference oOMSoftReference = (OOMSoftReference) this.mSpareReferences.poll();
            if (oOMSoftReference == null) {
                oOMSoftReference = new OOMSoftReference();
            }
            oOMSoftReference.set(obj);
            this.mFreeList.add(oOMSoftReference);
        }
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public Object pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            OOMSoftReference oOMSoftReference = (OOMSoftReference) this.mFreeList.poll();
            Object obj = oOMSoftReference.get();
            oOMSoftReference.clear();
            this.mSpareReferences.add(oOMSoftReference);
            return obj;
        }
        return invokeV.objValue;
    }
}
