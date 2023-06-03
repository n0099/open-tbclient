package com.huawei.hms.framework.network.grs.h.g;

import android.content.Context;
import android.content.res.AssetManager;
import com.baidu.tieba.nbb;
import com.baidu.tieba.pbb;
import com.baidu.tieba.qbb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.GrsApp;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final HostnameVerifier a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1434634321, "Lcom/huawei/hms/framework/network/grs/h/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1434634321, "Lcom/huawei/hms/framework/network/grs/h/g/a;");
                return;
            }
        }
        a = new qbb();
    }

    public static HostnameVerifier a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a : (HostnameVerifier) invokeV.objValue;
    }

    public static SSLSocketFactory a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                AssetManager assets = context.getAssets();
                return new nbb(new pbb(assets.open(GrsApp.getInstance().getBrand("/") + "grs_sp.bks"), ""));
            } catch (IOException | KeyManagementException | NoSuchAlgorithmException e) {
                throw new AssertionError(e);
            }
        }
        return (SSLSocketFactory) invokeL.objValue;
    }
}
