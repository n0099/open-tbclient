package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.emotion.model.EmotionAuthor;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n implements com.kwad.sdk.core.c<EmotionAuthor> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(EmotionAuthor emotionAuthor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionAuthor)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "id", emotionAuthor.id);
            com.kwad.sdk.utils.o.a(jSONObject, "name", emotionAuthor.name);
            com.kwad.sdk.utils.o.a(jSONObject, "userHead", emotionAuthor.userHead);
            com.kwad.sdk.utils.o.a(jSONObject, "userDesc", emotionAuthor.userDesc);
            com.kwad.sdk.utils.o.a(jSONObject, "followed", emotionAuthor.followed);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(EmotionAuthor emotionAuthor, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, emotionAuthor, jSONObject) == null) || jSONObject == null) {
            return;
        }
        emotionAuthor.id = jSONObject.optString("id");
        emotionAuthor.name = jSONObject.optString("name");
        emotionAuthor.userHead = jSONObject.optString("userHead");
        emotionAuthor.userDesc = jSONObject.optString("userDesc");
        emotionAuthor.followed = jSONObject.optString("followed");
    }
}
