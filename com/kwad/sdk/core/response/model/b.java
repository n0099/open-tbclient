package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f36571a;

    /* renamed from: b  reason: collision with root package name */
    public int f36572b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36573c;

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

    public void a(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f36571a = jSONObject.optLong("posId");
        this.f36572b = jSONObject.optInt("adPhotoCountForMedia");
        this.f36573c = jSONObject.optBoolean("enablePreload");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "posId", this.f36571a);
            o.a(jSONObject, "adPhotoCountForMedia", this.f36572b);
            o.a(jSONObject, "enablePreload", this.f36573c);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
