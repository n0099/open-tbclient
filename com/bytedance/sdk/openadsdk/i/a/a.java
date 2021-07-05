package com.bytedance.sdk.openadsdk.i.a;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.q;
import com.bytedance.sdk.openadsdk.core.w;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.bytedance.sdk.component.a.d<JSONObject, JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<w> f31225a;

    public a(w wVar) {
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
        this.f31225a = new WeakReference<>(wVar);
    }

    @Override // com.bytedance.sdk.component.a.d
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public static void a(q qVar, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qVar, wVar) == null) {
            qVar.a("immersiveVideoPageBack", new d.b(wVar) { // from class: com.bytedance.sdk.openadsdk.i.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ w f31226a;

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
                    this.f31226a = wVar;
                }

                @Override // com.bytedance.sdk.component.a.d.b
                public com.bytedance.sdk.component.a.d a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new a(this.f31226a) : (com.bytedance.sdk.component.a.d) invokeV.objValue;
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.a.d
    public void a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.a.f fVar) throws Exception {
        WeakReference<w> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, fVar) == null) || (weakReference = this.f31225a) == null || weakReference.get() == null) {
            return;
        }
        w wVar = this.f31225a.get();
        if (wVar == null) {
            c();
        } else {
            wVar.c();
        }
    }
}
