package com.repackage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k57() {
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

    public String a(String str) {
        InterceptResult invokeL;
        xv4 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null) {
                try {
                    bv4 bv4Var = new bv4(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                    String storeFile = FileHelper.getStoreFile(str, 1);
                    bv4Var.a("type", 2);
                    yv4 d = bv4Var.d(storeFile);
                    if (d == null || !d.d() || (a = d.a()) == null) {
                        return null;
                    }
                    String b = a.b();
                    yu4.b(str, b);
                    return b;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
