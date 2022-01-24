package com.kuaishou.weapon.un;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class u {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f55305b = "plc001_cd_ie";

    /* renamed from: c  reason: collision with root package name */
    public static final String f55306c = "plc001_cd_ie_0";

    /* renamed from: d  reason: collision with root package name */
    public static final String f55307d = "plc001_cd_ie_1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f55308e = "plc001_cd_is";

    /* renamed from: f  reason: collision with root package name */
    public static final String f55309f = "plc001_cd_is_1";

    /* renamed from: g  reason: collision with root package name */
    public static final String f55310g = "plc001_cd_is_2";

    /* renamed from: h  reason: collision with root package name */
    public static final String f55311h = "plc001_cd_ic";

    /* renamed from: i  reason: collision with root package name */
    public static final String f55312i = "plc001_cd_ic_1";

    /* renamed from: j  reason: collision with root package name */
    public static final String f55313j = "plc001_cd_ic_2";
    public static final String k = "plc001_cd_mc";
    public static final String l = "plc001_cd_ai";
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    public u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dVar;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            try {
                String a = this.a.a(str, "", true);
                return TextUtils.isEmpty(a) ? str2 : a;
            } catch (Throwable th) {
                x0.a(th);
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                this.a.b(str, str2, true);
                return true;
            } catch (Throwable th) {
                x0.a(th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
