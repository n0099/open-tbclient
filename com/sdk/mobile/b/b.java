package com.sdk.mobile.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.f.g.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b implements com.sdk.base.framework.b.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f61622b;

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
        this.f61622b = aVar;
        this.a = i2;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            this.f61622b.a(i2, i3, str);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0059 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.String] */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, String str, int i3, T t, String str2) {
        Context context;
        Context context2;
        Context context3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), t, str2}) == null) {
            context = this.f61622b.f61608d;
            com.sdk.base.framework.f.i.b.b(context);
            if (i2 == 0) {
                context2 = this.f61622b.f61608d;
                com.sdk.base.framework.a.a.a.a(context2, this.a, com.sdk.base.framework.a.a.a.a(t, str2), g.a.a());
                try {
                    context3 = this.f61622b.f61608d;
                    t = com.sdk.base.framework.f.k.a.a(context3, String.valueOf(t));
                    if (t == 0) {
                        this.f61622b.a(1, "SDK解密异常", 302001, t, str2);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(String.valueOf((Object) t));
                    if (this.a == 1) {
                        jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                        t = jSONObject.toString();
                    }
                } catch (Exception unused) {
                }
            }
            this.f61622b.a(i2, str, i3, t, str2);
        }
    }
}
