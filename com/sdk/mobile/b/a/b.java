package com.sdk.mobile.b.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.f.g.g;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b implements com.sdk.base.framework.b.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public /* synthetic */ int a;
    public /* synthetic */ a b;

    public b(a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = aVar;
        this.a = i;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
            this.b.a(i, i2, str);
        }
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i, String str, int i2, T t, String str2) {
        Context context;
        String str3;
        Boolean bool;
        Context context2;
        Context context3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), t, str2}) == null) {
            context = this.b.d;
            com.sdk.base.framework.f.i.b.b(context);
            Object obj = t;
            if (i == 0) {
                try {
                    context2 = this.b.d;
                    com.sdk.base.framework.a.a.a.a(context2, this.a, com.sdk.base.framework.a.a.a.a(t, str2), g.b.a());
                    context3 = this.b.d;
                    String a = com.sdk.base.framework.f.k.a.a(context3, String.valueOf(t));
                    if (a == null) {
                        this.b.a(1, "SDK解密异常", 302001, a, str2);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(String.valueOf(a));
                    obj = a;
                    if (this.a == 1) {
                        jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                        obj = jSONObject.toString();
                    }
                } catch (Exception e) {
                    str3 = a.a;
                    String exc = e.toString();
                    bool = a.b;
                    com.sdk.base.framework.a.a.c.b(str3, exc, bool);
                    obj = t;
                }
            }
            this.b.a(i, str, i2, obj, str2);
        }
    }
}
