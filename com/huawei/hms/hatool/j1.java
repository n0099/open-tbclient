package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import java.util.LinkedHashMap;
/* loaded from: classes9.dex */
public class j1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public m b;

    public j1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = new m(str);
        i.c().a(this.a, this.b);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            y.d("hmsSdk", "onReport. TAG: " + this.a + ", TYPE: " + i);
            i1.a().a(this.a, i);
        }
    }

    public void a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, linkedHashMap) == null) {
            y.d("hmsSdk", "onEvent. TAG: " + this.a + ", TYPE: " + i + ", eventId : " + str);
            if (s0.a(str) || !c(i)) {
                y.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a + ", TYPE: " + i);
                return;
            }
            if (!s0.a(linkedHashMap)) {
                y.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.a + ", TYPE: " + i);
                linkedHashMap = null;
            }
            i1.a().a(this.a, i, str, linkedHashMap);
        }
    }

    public void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2) == null) {
            y.d("hmsSdk", "onEvent(context). TAG: " + this.a + ", eventId : " + str);
            if (context == null) {
                y.e("hmsSdk", "context is null in onevent ");
            } else if (s0.a(str) || !c(0)) {
                y.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a);
            } else {
                if (!s0.a("value", str2, 65536)) {
                    y.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.a);
                    str2 = "";
                }
                i1.a().a(this.a, context, str, str2);
            }
        }
    }

    public void a(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            y.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.a);
            if (kVar != null) {
                this.b.a(kVar);
                return;
            }
            y.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.b.a((k) null);
        }
    }

    public final k b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return this.b.a();
                    }
                    return this.b.d();
                }
                return this.b.b();
            }
            return this.b.c();
        }
        return (k) invokeI.objValue;
    }

    public void b(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            y.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.a);
            if (kVar != null) {
                this.b.b(kVar);
                return;
            }
            this.b.b(null);
            y.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
        }
    }

    public final boolean c(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i != 2) {
                k b = b(i);
                if (b != null && !TextUtils.isEmpty(b.h())) {
                    return true;
                }
                str = "verifyURL(): URL check failed. type: " + i;
            } else if (HianalyticsHelper.DEAULT_HA_SERVICE_TAG.equals(this.a)) {
                return true;
            } else {
                str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
            }
            y.e("hmsSdk", str);
            return false;
        }
        return invokeI.booleanValue;
    }
}
