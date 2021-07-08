package com.bytedance.sdk.openadsdk.i.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.q;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i extends com.bytedance.sdk.component.a.e<JSONObject, JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<SSWebView> f31348a;

    public i(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sSWebView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31348a = new WeakReference<>(sSWebView);
    }

    public static void a(q qVar, SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qVar, sSWebView) == null) {
            qVar.a("preventTouchEvent", (com.bytedance.sdk.component.a.e<?, ?>) new i(sSWebView));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.a.f fVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, fVar)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                boolean optBoolean = jSONObject.optBoolean("isPrevent", false);
                SSWebView sSWebView = this.f31348a.get();
                if (sSWebView != null) {
                    sSWebView.setIsPreventTouchEvent(optBoolean);
                    jSONObject2.put("success", true);
                } else {
                    jSONObject2.put("success", false);
                }
            } catch (Throwable th) {
                Log.e("PreventTouchEventMethod", "invoke error", th);
                jSONObject2.put("success", false);
            }
            return jSONObject2;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
