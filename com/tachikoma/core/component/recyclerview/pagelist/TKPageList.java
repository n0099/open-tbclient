package com.tachikoma.core.component.recyclerview.pagelist;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.tachikoma.core.component.recyclerview.export.ITKPageList;
/* loaded from: classes8.dex */
public class TKPageList implements ITKPageList {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final V8Object mAssociateV8Obj;

    public TKPageList(@Nullable V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Object};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAssociateV8Obj = v8Object;
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKPageList
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.mAssociateV8Obj == null) {
                    return false;
                }
                return ((Boolean) this.mAssociateV8Obj.executeJSFunction("hasMore")).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKPageList
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.mAssociateV8Obj == null) {
                    return;
                }
                this.mAssociateV8Obj.executeJSFunction("load");
            } catch (Exception unused) {
            }
        }
    }
}
