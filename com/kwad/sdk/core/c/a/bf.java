package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.live.mode.LiveInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bf implements com.kwad.sdk.core.d<LiveInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bf() {
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
    @Override // com.kwad.sdk.core.d
    public void a(LiveInfo liveInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        liveInfo.liveStreamId = jSONObject.optString("liveStreamId");
        LiveInfo.User user = new LiveInfo.User();
        liveInfo.user = user;
        user.parseJson(jSONObject.optJSONObject("user"));
        liveInfo.playInfo = jSONObject.optString("playInfo");
        liveInfo.audienceCount = jSONObject.optString("audienceCount");
        liveInfo.caption = jSONObject.optString("caption");
        liveInfo.cover_thumbnail_urls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("cover_thumbnail_urls");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                LiveInfo.CoverThumbnailUrl coverThumbnailUrl = new LiveInfo.CoverThumbnailUrl();
                coverThumbnailUrl.parseJson(optJSONArray.optJSONObject(i2));
                liveInfo.cover_thumbnail_urls.add(coverThumbnailUrl);
            }
        }
        liveInfo.exp_tag = jSONObject.optString("exp_tag");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(LiveInfo liveInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, liveInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "liveStreamId", liveInfo.liveStreamId);
            com.kwad.sdk.utils.q.a(jSONObject, "user", liveInfo.user);
            com.kwad.sdk.utils.q.a(jSONObject, "playInfo", liveInfo.playInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "audienceCount", liveInfo.audienceCount);
            com.kwad.sdk.utils.q.a(jSONObject, "caption", liveInfo.caption);
            com.kwad.sdk.utils.q.a(jSONObject, "cover_thumbnail_urls", liveInfo.cover_thumbnail_urls);
            com.kwad.sdk.utils.q.a(jSONObject, "exp_tag", liveInfo.exp_tag);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
