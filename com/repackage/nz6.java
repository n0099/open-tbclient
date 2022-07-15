package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.switchs.VideoCardLazyInitSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nz6 extends ww {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x68 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nz6(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.ww, com.repackage.ky
    public x68 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.k) && this.k.equals("index") && VideoCardLazyInitSwitch.getIsOn()) {
                this.z = new pz6(this.b, this.i);
            } else {
                this.z = new oz6(this.b, this.i);
            }
            this.z.setStageType("2001");
            return this.z;
        }
        return (x68) invokeV.objValue;
    }
}
