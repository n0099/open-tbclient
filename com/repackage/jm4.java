package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes6.dex */
public class jm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public long d;
    public int e;
    public long f;
    public long g;

    public jm4() {
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (StringUtils.isNULL(this.a) || this.d <= 0) {
                return false;
            }
            int i = this.e;
            if (i == 1 || i == 3) {
                long j = this.f;
                if (j > 0) {
                    long j2 = this.g;
                    return j2 > 0 && j2 > j;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b(BigdayInfo bigdayInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bigdayInfo) == null) || bigdayInfo == null || StringUtils.isNULL(bigdayInfo.img_url) || bigdayInfo.id.longValue() <= 0) {
            return;
        }
        if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
            this.a = bigdayInfo.img_url;
            this.b = bigdayInfo.jump_url;
            this.c = bigdayInfo.img_colour.intValue();
            this.d = bigdayInfo.id.longValue();
            this.e = bigdayInfo.position.intValue();
            this.f = bigdayInfo.start_time.longValue();
            this.g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof jm4) {
                jm4 jm4Var = (jm4) obj;
                return jm4Var.a() && a() && this.d == jm4Var.d && StringHelper.equals(this.a, jm4Var.a) && ((this.b == null && jm4Var.b == null) || StringHelper.equals(this.b, jm4Var.b)) && this.c == jm4Var.c && this.e == jm4Var.e && this.f == jm4Var.f && this.g == jm4Var.g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
