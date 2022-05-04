package com.repackage;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public String d;

    public uv4() {
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
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            switch (i) {
                case 1:
                    return gj.a(R.string.obfuscated_res_0x7f0f1514);
                case 2:
                    return gj.a(R.string.obfuscated_res_0x7f0f1519);
                case 3:
                    return gj.a(R.string.obfuscated_res_0x7f0f0c17);
                case 4:
                    return gj.a(R.string.obfuscated_res_0x7f0f1517);
                case 5:
                    return gj.a(R.string.obfuscated_res_0x7f0f1515);
                case 6:
                    return gj.a(R.string.obfuscated_res_0x7f0f1518);
                case 7:
                    return gj.a(R.string.obfuscated_res_0x7f0f1516);
                default:
                    return "";
            }
        }
        return (String) invokeI.objValue;
    }
}
