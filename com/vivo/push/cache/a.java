package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.g;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class a extends d<com.vivo.push.model.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.cache.d
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "com.vivo.pushservice.back_up" : (String) invokeV.objValue;
    }

    @Override // com.vivo.push.cache.d
    public final List<com.vivo.push.model.a> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.trim().split(com.vivo.push.cache.impl.a.SPILTE_TAG)) {
                    String trim = str2.trim();
                    String[] split = trim.trim().split(",");
                    if (split.length >= 2) {
                        try {
                            arrayList.add(new com.vivo.push.model.a(split[0], trim.substring(split[0].length() + 1)));
                        } catch (Exception e2) {
                            p.d("AppConfigSettings", "str2Clients E: " + e2);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.vivo.push.cache.d
    public final String b(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? new String(g.a(g.a(d.f70295a), g.a(d.f70296b), Base64.decode(str, 2)), "utf-8") : (String) invokeL.objValue;
    }

    public final com.vivo.push.model.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (d.f70297c) {
                for (T t : this.f70298d) {
                    if (!TextUtils.isEmpty(t.a()) && t.a().equals(str)) {
                        return t;
                    }
                }
                return null;
            }
        }
        return (com.vivo.push.model.a) invokeL.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.vivo.push.model.a c2 = c("push_mode");
            if (c2 != null && !TextUtils.isEmpty(c2.b())) {
                try {
                    return Integer.parseInt(c2.b());
                } catch (Exception unused) {
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 != -1) {
                return (i2 & 1) != 0;
            }
            return z.b("persist.sys.log.ctrl", "no").equals("yes");
        }
        return invokeI.booleanValue;
    }
}
