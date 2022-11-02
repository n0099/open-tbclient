package com.sdk.w;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.o.f;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements com.sdk.e.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;
    public final /* synthetic */ d b;

    public a(d dVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = dVar;
        this.a = i;
    }

    @Override // com.sdk.e.a
    public void a(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
            this.b.a(i, i2, str);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x006a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.String] */
    @Override // com.sdk.e.a
    public void onSuccess(int i, String str, int i2, T t, String str2) {
        Context context;
        long longValue;
        Context context2;
        Context unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), t, str2}) == null) {
            context = this.b.d;
            Long b = com.sdk.j.a.b(context, "access_limit_count");
            if (b == null) {
                longValue = 0;
            } else {
                longValue = b.longValue() + 1;
            }
            com.sdk.j.a.a(context, "access_limit_count", Long.valueOf(longValue));
            if (i == 0) {
                context2 = this.b.d;
                com.sdk.b.a.a(context2, this.a, com.sdk.b.a.a(t, str2), f.b.b.a());
                try {
                    unused = this.b.d;
                    t = com.sdk.t.a.a(String.valueOf(t));
                    if (t == 0) {
                        this.b.a(1, "SDK解密异常", 302001, t, str2);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) t);
                    if (this.a == 1) {
                        jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                        t = jSONObject.toString();
                    }
                } catch (Exception unused2) {
                }
            }
            this.b.a(i, str, i2, t, str2);
        }
    }
}
