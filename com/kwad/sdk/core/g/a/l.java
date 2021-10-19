package com.kwad.sdk.core.g.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.q;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class l implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f72162a;

    /* renamed from: b  reason: collision with root package name */
    public long f72163b;

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            q.a(jSONObject, "photoId", this.f72162a);
            q.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.f72163b);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
