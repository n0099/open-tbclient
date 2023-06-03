package com.sdk.y;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.p.f;
import org.json.JSONObject;
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes10.dex */
public class c<T> implements com.sdk.e.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;
    public final /* synthetic */ f b;

    public c(f fVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = fVar;
        this.a = i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0054 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.String] */
    @Override // com.sdk.e.a
    public void onSuccess(int i, String str, int i2, T t, String str2) {
        Context context;
        Context context2;
        Context unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), t, str2}) == null) {
            context = this.b.e;
            com.sdk.r.b.b(context);
            if (i == 0) {
                context2 = this.b.e;
                com.sdk.b.a.a(context2, this.a, com.sdk.b.a.a(t, str2), f.b.b.a());
                try {
                    unused = this.b.e;
                    t = (T) com.sdk.u.a.a(String.valueOf(t));
                    if (t == 0) {
                        this.b.a(1, "SDK解密异常", 302001, t, str2);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) t);
                    if (this.a == 1) {
                        jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                        t = (T) jSONObject.toString();
                    }
                } catch (Exception unused2) {
                }
            }
            this.b.a(i, str, i2, t, str2);
        }
    }

    @Override // com.sdk.e.a
    public void a(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
            this.b.a(i, i2, str);
            String str2 = f.a;
            Log.d(str2, "onFailure: " + i);
        }
    }
}
