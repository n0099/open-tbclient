package com.kwad.sdk.emotion.model;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EmotionInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_EMOTION_INFO_EXTRA_INFO = "extraInfo";
    public static final long serialVersionUID = 8005337986172532989L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<EmotionCode> emotionCodes;
    public List<CDNUrl> emotionImageBigUrl;
    public List<CDNUrl> emotionImageSmallUrl;
    public Map<String, String> extraInfo;
    public int height;
    public String id;
    public int mIndex;
    public int mPageIndex;
    public String name;
    public String packageId;
    public int type;
    public int width;

    public EmotionInfo() {
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
        this.emotionCodes = new ArrayList();
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterParseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            this.extraInfo = o.b(jSONObject.optString("extraInfo"));
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            o.a(jSONObject, "extraInfo", o.a(this.extraInfo));
        }
    }
}
