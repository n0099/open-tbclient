package com.kwad.sdk.emotion.model;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EmotionResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_EMOTION_RESPONSE_LIST = "emotionPackageList";
    public static final long serialVersionUID = -5365732599060399342L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<EmotionPackage> mEmotionPackageList;

    public EmotionResponse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEmotionPackageList = new ArrayList();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_EMOTION_RESPONSE_LIST);
            this.mEmotionPackageList.clear();
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    EmotionPackage emotionPackage = new EmotionPackage();
                    emotionPackage.parseJson(optJSONObject);
                    this.mEmotionPackageList.add(emotionPackage);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject json = super.toJson();
            o.a(json, KEY_EMOTION_RESPONSE_LIST, this.mEmotionPackageList);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
