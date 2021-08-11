package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bn implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bn() {
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
    public void a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, patchAdInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        patchAdInfo.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        patchAdInfo.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        patchAdInfo.weakStyleDownloadingTitle = jSONObject.optString("weakStyleDownloadingTitle");
        patchAdInfo.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        patchAdInfo.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
        patchAdInfo.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.typePortrait = jSONObject.optInt("typePortrait");
        patchAdInfo.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        patchAdInfo.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
        patchAdInfo.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        patchAdInfo.strongStyleSubTitle = jSONObject.optString("strongStyleSubTitle");
        patchAdInfo.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        patchAdInfo.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose", new Boolean("true").booleanValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, patchAdInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "weakStyleIcon", patchAdInfo.weakStyleIcon);
            com.kwad.sdk.utils.q.a(jSONObject, "weakStyleTitle", patchAdInfo.weakStyleTitle);
            com.kwad.sdk.utils.q.a(jSONObject, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
            com.kwad.sdk.utils.q.a(jSONObject, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
            com.kwad.sdk.utils.q.a(jSONObject, "weakStyleAppearTime", patchAdInfo.weakStyleAppearTime);
            com.kwad.sdk.utils.q.a(jSONObject, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
            com.kwad.sdk.utils.q.a(jSONObject, "typePortrait", patchAdInfo.typePortrait);
            com.kwad.sdk.utils.q.a(jSONObject, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "strongStyleAppearTime", patchAdInfo.strongStyleAppearTime);
            com.kwad.sdk.utils.q.a(jSONObject, "strongStyleTitle", patchAdInfo.strongStyleTitle);
            com.kwad.sdk.utils.q.a(jSONObject, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
            com.kwad.sdk.utils.q.a(jSONObject, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
            com.kwad.sdk.utils.q.a(jSONObject, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
