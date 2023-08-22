package com.huawei.hms.hatool;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class m1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k a;
    public k b;
    public Context c;
    public String d;

    public m1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        this.a = new k();
        this.b = new k();
    }

    public m1 a(int i, String str) {
        InterceptResult invokeIL;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) {
            y.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i);
            if (!v0.b(str)) {
                str = "";
            }
            if (i == 0) {
                kVar = this.a;
            } else if (i != 1) {
                y.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            } else {
                kVar = this.b;
            }
            kVar.b(str);
            return this;
        }
        return (m1) invokeIL.objValue;
    }

    public m1 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            y.c("hmsSdk", "Builder.setAppID is execute");
            this.d = str;
            return this;
        }
        return (m1) invokeL.objValue;
    }

    @Deprecated
    public m1 a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            y.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
            this.a.j().a(z);
            this.b.j().a(z);
            return this;
        }
        return (m1) invokeZ.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.c == null) {
                y.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
                return;
            }
            y.c("hmsSdk", "Builder.create() is execute.");
            j1 j1Var = new j1("_hms_config_tag");
            j1Var.b(new k(this.a));
            j1Var.a(new k(this.b));
            h1.a().a(this.c);
            i1.a().a(this.c);
            o1.c().a(j1Var);
            h1.a().a(this.d);
        }
    }

    @Deprecated
    public m1 b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            y.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
            this.a.j().b(z);
            this.b.j().b(z);
            return this;
        }
        return (m1) invokeZ.objValue;
    }

    @Deprecated
    public m1 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            y.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
            this.a.j().c(z);
            this.b.j().c(z);
            return this;
        }
        return (m1) invokeZ.objValue;
    }
}
