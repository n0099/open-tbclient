package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ej implements com.kwad.sdk.core.d<PhotoInfo.TubeEpisode> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ej() {
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
    public void a(PhotoInfo.TubeEpisode tubeEpisode, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tubeEpisode, jSONObject) == null) || jSONObject == null) {
            return;
        }
        tubeEpisode.tubeId = jSONObject.optLong(URLPackage.KEY_TUBE_ID, new Long("-1").longValue());
        tubeEpisode.tubeName = jSONObject.optString("tubeName");
        if (jSONObject.opt("tubeName") == JSONObject.NULL) {
            tubeEpisode.tubeName = "";
        }
        tubeEpisode.episodeName = jSONObject.optString("episodeName");
        if (jSONObject.opt("episodeName") == JSONObject.NULL) {
            tubeEpisode.episodeName = "";
        }
        tubeEpisode.playCount = jSONObject.optLong("playCount");
        tubeEpisode.hasTube = jSONObject.optBoolean("hasTube");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.TubeEpisode tubeEpisode, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tubeEpisode, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, URLPackage.KEY_TUBE_ID, tubeEpisode.tubeId);
            com.kwad.sdk.utils.t.a(jSONObject, "tubeName", tubeEpisode.tubeName);
            com.kwad.sdk.utils.t.a(jSONObject, "episodeName", tubeEpisode.episodeName);
            com.kwad.sdk.utils.t.a(jSONObject, "playCount", tubeEpisode.playCount);
            com.kwad.sdk.utils.t.a(jSONObject, "hasTube", tubeEpisode.hasTube);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
