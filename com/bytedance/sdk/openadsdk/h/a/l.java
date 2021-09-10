package com.bytedance.sdk.openadsdk.h.a;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.w;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class l extends com.bytedance.sdk.component.a.d<JSONObject, JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<w> f67913a;

    public l(w wVar) {
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
        this.f67913a = new WeakReference<>(wVar);
    }

    @Override // com.bytedance.sdk.component.a.d
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public static void a(r rVar, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, rVar, wVar) == null) {
            rVar.a("showAppDetailOrPrivacyDialog", new d.b(wVar) { // from class: com.bytedance.sdk.openadsdk.h.a.l.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ w f67914a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {wVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67914a = wVar;
                }

                @Override // com.bytedance.sdk.component.a.d.b
                public com.bytedance.sdk.component.a.d a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new l(this.f67914a) : (com.bytedance.sdk.component.a.d) invokeV.objValue;
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.a.d
    public void a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.a.f fVar) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, fVar) == null) {
            if (com.bytedance.sdk.openadsdk.core.h.d().x()) {
                StringBuilder sb = new StringBuilder();
                sb.append("[JSB-REQ] version: 3 data=");
                sb.append(jSONObject != null ? jSONObject.toString() : "");
                com.bytedance.sdk.component.utils.k.b("ShowAppDetailOrPrivacyDialogMethod", sb.toString());
            }
            WeakReference<w> weakReference = this.f67913a;
            if (weakReference == null) {
                return;
            }
            w wVar = weakReference.get();
            if (wVar == null) {
                c();
            } else if (jSONObject == null) {
            } else {
                int optInt = jSONObject.optInt("show_dialog_style");
                if (optInt == 1) {
                    wVar.n();
                    com.bytedance.sdk.component.utils.k.b("ShowAppDetailOrPrivacyDialogMethod", "ShowAppDetailOrPrivacyDialogMethod showAppDetailDialog ");
                } else if (optInt == 2) {
                    wVar.m();
                    com.bytedance.sdk.component.utils.k.b("ShowAppDetailOrPrivacyDialogMethod", "ShowAppDetailOrPrivacyDialogMethod showAppPrivacyDialog ");
                }
            }
        }
    }
}
