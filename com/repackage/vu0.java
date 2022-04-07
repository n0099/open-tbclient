package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vu0 implements yu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vu0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.yu0
    @NonNull
    public ru0 create(@NonNull String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -812096555) {
                if (hashCode == 26276517 && str.equals("CyberNetPlayer")) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals("CyberSysPlayer")) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                return new bv0();
            }
            return new tu0();
        }
        return (ru0) invokeL.objValue;
    }
}
