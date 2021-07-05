package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.emotion.model.CDNUrl;
import com.kwad.sdk.emotion.model.EmotionAuthor;
import com.kwad.sdk.emotion.model.EmotionInfo;
import com.kwad.sdk.emotion.model.EmotionPackage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q implements com.kwad.sdk.core.c<EmotionPackage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q() {
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
    public JSONObject a(EmotionPackage emotionPackage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionPackage)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "id", emotionPackage.id);
            com.kwad.sdk.utils.o.a(jSONObject, "name", emotionPackage.name);
            com.kwad.sdk.utils.o.a(jSONObject, "introduction", emotionPackage.introduction);
            com.kwad.sdk.utils.o.a(jSONObject, "description", emotionPackage.description);
            com.kwad.sdk.utils.o.a(jSONObject, "type", emotionPackage.type);
            com.kwad.sdk.utils.o.a(jSONObject, "style", emotionPackage.style);
            com.kwad.sdk.utils.o.a(jSONObject, "packageImageSmallUrl", emotionPackage.packageImageSmallUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "packageImageMiddleUrl", emotionPackage.packageImageMiddleUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "packageBannerUrl", emotionPackage.packageBannerUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "packageImageBigUrl", emotionPackage.packageImageBigUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "packageDownloadUrl", emotionPackage.packageDownloadUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "emotionAuthor", emotionPackage.emotionAuthor);
            com.kwad.sdk.utils.o.a(jSONObject, "emotions", emotionPackage.emotions);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(EmotionPackage emotionPackage, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, emotionPackage, jSONObject) == null) || jSONObject == null) {
            return;
        }
        emotionPackage.id = jSONObject.optString("id");
        emotionPackage.name = jSONObject.optString("name");
        emotionPackage.introduction = jSONObject.optString("introduction");
        emotionPackage.description = jSONObject.optString("description");
        emotionPackage.type = jSONObject.optInt("type");
        emotionPackage.style = jSONObject.optString("style");
        emotionPackage.packageImageSmallUrl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("packageImageSmallUrl");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                CDNUrl cDNUrl = new CDNUrl();
                cDNUrl.parseJson(optJSONArray.optJSONObject(i2));
                emotionPackage.packageImageSmallUrl.add(cDNUrl);
            }
        }
        emotionPackage.packageImageMiddleUrl = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("packageImageMiddleUrl");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                CDNUrl cDNUrl2 = new CDNUrl();
                cDNUrl2.parseJson(optJSONArray2.optJSONObject(i3));
                emotionPackage.packageImageMiddleUrl.add(cDNUrl2);
            }
        }
        emotionPackage.packageBannerUrl = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("packageBannerUrl");
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                CDNUrl cDNUrl3 = new CDNUrl();
                cDNUrl3.parseJson(optJSONArray3.optJSONObject(i4));
                emotionPackage.packageBannerUrl.add(cDNUrl3);
            }
        }
        emotionPackage.packageImageBigUrl = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("packageImageBigUrl");
        if (optJSONArray4 != null) {
            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                CDNUrl cDNUrl4 = new CDNUrl();
                cDNUrl4.parseJson(optJSONArray4.optJSONObject(i5));
                emotionPackage.packageImageBigUrl.add(cDNUrl4);
            }
        }
        emotionPackage.packageDownloadUrl = new ArrayList();
        JSONArray optJSONArray5 = jSONObject.optJSONArray("packageDownloadUrl");
        if (optJSONArray5 != null) {
            for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                CDNUrl cDNUrl5 = new CDNUrl();
                cDNUrl5.parseJson(optJSONArray5.optJSONObject(i6));
                emotionPackage.packageDownloadUrl.add(cDNUrl5);
            }
        }
        EmotionAuthor emotionAuthor = new EmotionAuthor();
        emotionPackage.emotionAuthor = emotionAuthor;
        emotionAuthor.parseJson(jSONObject.optJSONObject("emotionAuthor"));
        emotionPackage.emotions = new ArrayList();
        JSONArray optJSONArray6 = jSONObject.optJSONArray("emotions");
        if (optJSONArray6 != null) {
            for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                EmotionInfo emotionInfo = new EmotionInfo();
                emotionInfo.parseJson(optJSONArray6.optJSONObject(i7));
                emotionPackage.emotions.add(emotionInfo);
            }
        }
    }
}
