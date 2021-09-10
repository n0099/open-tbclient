package com.bytedance.sdk.openadsdk.h.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.w;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends com.bytedance.sdk.component.a.e<JSONObject, JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<w> f67906a;

    public e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67906a = new WeakReference<>(wVar);
    }

    public JSONObject c() {
        InterceptResult invokeV;
        w wVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f67906a == null || (wVar = this.f67906a.get()) == null) {
                    return jSONObject;
                }
                jSONObject = wVar.o();
                com.bytedance.sdk.component.utils.k.b("GetAppManageModelMethod", "GetAppManageModelMethod analysisJson resultJsonObject " + jSONObject.toString());
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void a(r rVar, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, rVar, wVar) == null) {
            rVar.a("getAppManage", (com.bytedance.sdk.component.a.e<?, ?>) new e(wVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.a.f fVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, fVar)) == null) ? c() : (JSONObject) invokeLL.objValue;
    }
}
