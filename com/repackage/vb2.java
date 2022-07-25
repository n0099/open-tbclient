package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class vb2 extends ub2<pb2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vb2() {
        super(new pb2());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rb2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            ix1.k("ExtCore-SwanAppPresetControl", "isExtensionFileAvailable extensionPath:" + str);
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str, "extension.js");
            if (file.exists() && file.length() > 0) {
                z = true;
            }
            ix1.k("ExtCore-SwanAppPresetControl", "isExtensionFileAvailable: " + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ub2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !r(h().extensionCorePath) || super.k() : invokeV.booleanValue;
    }
}
