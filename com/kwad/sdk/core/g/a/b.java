package com.kwad.sdk.core.g.a;

import android.content.Context;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f36119a;

    /* renamed from: b  reason: collision with root package name */
    public String f36120b;

    /* renamed from: c  reason: collision with root package name */
    public String f36121c;

    /* renamed from: d  reason: collision with root package name */
    public String f36122d;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            b bVar = new b();
            bVar.f36119a = KsAdSDKImpl.get().getAppId();
            bVar.f36120b = KsAdSDKImpl.get().getAppName();
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                bVar.f36121c = context.getPackageName();
                bVar.f36122d = ah.l(context);
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f36119a);
            o.a(jSONObject, "name", this.f36120b);
            o.a(jSONObject, "packageName", this.f36121c);
            o.a(jSONObject, "version", this.f36122d);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
