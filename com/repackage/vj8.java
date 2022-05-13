package com.repackage;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Timgs;
/* loaded from: classes7.dex */
public class vj8 implements ls4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public int d;

    public vj8(Timgs timgs) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {timgs};
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
        this.c = 1;
        this.d = 1;
        if (timgs == null) {
            return;
        }
        this.a = timgs.img_url;
        timgs.flag.intValue();
        this.b = timgs.url;
        String str = timgs.big_cdn_url;
        String str2 = timgs.des_main;
        String str3 = timgs.des_sub;
        String str4 = timgs.bsize;
        if (str4 != null) {
            try {
                String[] split = str4.split(",");
                this.c = kg.e(split[0], 1);
                this.d = kg.e(split[1], 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.c <= 0) {
            this.c = 1;
        }
        if (this.d <= 0) {
            this.d = 1;
        }
    }

    @Override // com.repackage.ls4
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.repackage.ls4
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
    }
}
