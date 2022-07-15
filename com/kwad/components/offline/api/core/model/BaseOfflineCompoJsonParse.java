package com.kwad.components.offline.api.core.model;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class BaseOfflineCompoJsonParse<T extends IOfflineCompoJsonParse> implements IOfflineCompoJsonParse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseOfflineCompoJsonParse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void parseJson(T t, JSONObject jSONObject);

    @Override // com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            parseJson(this, jSONObject);
        }
    }

    @Override // com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? toJson(this) : (JSONObject) invokeV.objValue;
    }

    public abstract JSONObject toJson(T t);

    public abstract JSONObject toJson(T t, JSONObject jSONObject);
}
