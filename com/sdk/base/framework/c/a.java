package com.sdk.base.framework.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.module.config.BaseConfig;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41181a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f41182b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f41183c = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1040320026, "Lcom/sdk/base/framework/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1040320026, "Lcom/sdk/base/framework/c/a;");
        }
    }

    public static AInfo a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            AInfo aInfo = new AInfo();
            aInfo.setN(com.sdk.base.framework.f.a.a.d(context));
            aInfo.setC(com.sdk.base.framework.f.a.a.b(context));
            aInfo.setV(com.sdk.base.framework.f.a.a.a(context));
            aInfo.setPk(com.sdk.base.framework.f.a.a.c(context));
            aInfo.setMd5(com.sdk.base.framework.f.a.a.e(context));
            return aInfo;
        }
        return (AInfo) invokeL.objValue;
    }

    public static ArrayList<KInfo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new ArrayList<>() : (ArrayList) invokeV.objValue;
    }

    public static SInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            SInfo sInfo = new SInfo();
            sInfo.setN(BaseConfig.n);
            sInfo.setC(BaseConfig.f41252c);
            sInfo.setV(BaseConfig.v);
            sInfo.setCm(BaseConfig.cm);
            return sInfo;
        }
        return (SInfo) invokeV.objValue;
    }

    public static PInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            PInfo pInfo = new PInfo();
            pInfo.setOs("Android");
            return pInfo;
        }
        return (PInfo) invokeV.objValue;
    }
}
