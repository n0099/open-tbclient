package com.sdk.f;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.module.config.BaseConfig;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static String b = "";
    public static String c = "";
    public transient /* synthetic */ FieldHolder $fh;

    public static AInfo a(Context context) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            AInfo aInfo = new AInfo();
            aInfo.setN(com.sdk.j.a.a(context));
            aInfo.setC(com.sdk.j.a.d(context));
            aInfo.setV(com.sdk.j.a.e(context));
            if (a) {
                aInfo.setPk(c);
                b2 = b;
            } else {
                aInfo.setPk(com.sdk.j.a.c(context));
                b2 = com.sdk.j.a.b(context);
            }
            aInfo.setMd5(b2);
            return aInfo;
        }
        return (AInfo) invokeL.objValue;
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/content/Context;)Ljava/util/ArrayList<Lcom/sdk/base/framework/bean/KInfo;>; */
    public static ArrayList a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new ArrayList() : (ArrayList) invokeV.objValue;
    }

    public static PInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            PInfo pInfo = new PInfo();
            pInfo.setOs("Android");
            return pInfo;
        }
        return (PInfo) invokeV.objValue;
    }

    public static SInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            SInfo sInfo = new SInfo();
            sInfo.setN(BaseConfig.n);
            sInfo.setC(BaseConfig.c);
            sInfo.setV(BaseConfig.v);
            sInfo.setCm(BaseConfig.cm);
            return sInfo;
        }
        return (SInfo) invokeV.objValue;
    }
}
