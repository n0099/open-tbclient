package com.sdk.base.framework.d;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.l;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends com.sdk.base.framework.b.b<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ a f68220a;

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68220a = aVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v0 java.lang.Object)] */
    @Override // com.sdk.base.framework.b.b
    public final void a(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, obj) == null) {
            a aVar = this.f68220a;
            StringBuilder sb = new StringBuilder();
            sb.append(obj);
            aVar.a(i2, 302002, sb.toString());
            Context context = this.f68220a.f68213a;
            com.sdk.base.framework.f.g.a.a();
        }
    }

    @Override // com.sdk.base.framework.b.b
    public final void a(l<String> lVar) {
        int i2;
        String str;
        boolean z;
        String str2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) != null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(lVar == null ? "" : lVar.b());
            int optInt = jSONObject.optInt("code");
            try {
                String optString = jSONObject.optString("msg");
                int optInt2 = jSONObject.optInt("status");
                String optString2 = jSONObject.optString("obj");
                String optString3 = jSONObject.optString(IAdRequestParam.SEQ);
                if (!c.a(optString).booleanValue() || !c.a(optString3).booleanValue() || !c.a(optString2).booleanValue()) {
                    this.f68220a.a(optInt, optString, optInt2, optString2, optString3);
                    Context context = this.f68220a.f68213a;
                    com.sdk.base.framework.f.g.a.a();
                    return;
                }
                this.f68220a.a(1, "服务端数据格式出错", 302003, null, com.sdk.base.framework.f.f.a.b().a());
                str2 = a.f68211d;
                z2 = a.f68212e;
                c.b(str2, "返回数据为空", Boolean.valueOf(z2));
            } catch (Throwable th) {
                th = th;
                i2 = optInt;
                com.sdk.base.framework.f.f.a.c(th.toString());
                this.f68220a.a(i2, "服务端数据格式出错", 302003, null, com.sdk.base.framework.f.f.a.b().a());
                str = a.f68211d;
                z = a.f68212e;
                c.b(str, "返回数据解析异常：" + th.toString(), Boolean.valueOf(z));
            }
        } catch (Throwable th2) {
            th = th2;
            i2 = 1;
        }
    }
}
