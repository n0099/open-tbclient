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
/* loaded from: classes10.dex */
public final class b implements com.sdk.base.framework.b.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ int f75242a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f75243b;

    public b(a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75243b = aVar;
        this.f75242a = i2;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            this.f75243b.a(i2, i3, str);
        }
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, String str, int i3, T t, String str2) {
        Context context;
        String str3;
        Boolean bool;
        Context context2;
        Context context3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), t, str2}) == null) {
            context = this.f75243b.f75238d;
            com.sdk.base.framework.f.i.b.b(context);
            Object obj = t;
            if (i2 == 0) {
                try {
                    context2 = this.f75243b.f75238d;
                    com.sdk.base.framework.a.a.a.a(context2, this.f75242a, com.sdk.base.framework.a.a.a.a(t, str2), g.f75206b.a());
                    context3 = this.f75243b.f75238d;
                    String a2 = com.sdk.base.framework.f.k.a.a(context3, String.valueOf(t));
                    if (a2 == null) {
                        this.f75243b.a(1, "SDK解密异常", 302001, a2, str2);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(String.valueOf(a2));
                    obj = a2;
                    if (this.f75242a == 1) {
                        jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                        obj = jSONObject.toString();
                    }
                } catch (Exception e2) {
                    str3 = a.f75235a;
                    String exc = e2.toString();
                    bool = a.f75236b;
                    com.sdk.base.framework.a.a.c.b(str3, exc, bool);
                    obj = t;
                }
            }
            this.f75243b.a(i2, str, i3, obj, str2);
        }
    }
}
