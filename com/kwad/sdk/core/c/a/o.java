package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.emotion.model.EmotionCode;
import com.kwai.video.player.KsMediaMeta;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o implements com.kwad.sdk.core.c<EmotionCode> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o() {
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
    public JSONObject a(EmotionCode emotionCode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionCode)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, KsMediaMeta.KSM_KEY_LANGUAGE, emotionCode.language);
            com.kwad.sdk.utils.o.a(jSONObject, "codes", emotionCode.codes);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(EmotionCode emotionCode, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, emotionCode, jSONObject) == null) || jSONObject == null) {
            return;
        }
        emotionCode.language = jSONObject.optString(KsMediaMeta.KSM_KEY_LANGUAGE);
        emotionCode.codes = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("codes");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                emotionCode.codes.add((String) optJSONArray.opt(i2));
            }
        }
    }
}
