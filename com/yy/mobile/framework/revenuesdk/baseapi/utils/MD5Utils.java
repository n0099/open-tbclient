package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class MD5Utils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MD5Utils() {
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

    public static synchronized String md5(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (MD5Utils.class) {
                str2 = "";
                try {
                    for (byte b2 : MessageDigest.getInstance(PackageTable.MD5).digest(str.getBytes())) {
                        String hexString = Integer.toHexString(b2 & 255);
                        if (hexString.length() == 1) {
                            hexString = "0" + hexString;
                        }
                        str2 = str2 + hexString;
                    }
                } catch (NoSuchAlgorithmException unused) {
                    if (Env.instance().isTestEnv()) {
                        throw new RuntimeException("没有md5这个算法！");
                    }
                    return str2;
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
