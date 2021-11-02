package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class br implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public br() {
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
    public void a(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playDetailInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        playDetailInfo.type = jSONObject.optInt("type");
        AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo = new AdStyleInfo.PlayDetailInfo.DetailWebCardInfo();
        playDetailInfo.detailWebCardInfo = detailWebCardInfo;
        detailWebCardInfo.parseJson(jSONObject.optJSONObject("detailWebCardInfo"));
        AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo = new AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo();
        playDetailInfo.detailTopToolBarInfo = detailTopToolBarInfo;
        detailTopToolBarInfo.parseJson(jSONObject.optJSONObject("detailTopToolBarInfo"));
        AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo = new AdStyleInfo.PlayDetailInfo.ActionBarInfo();
        playDetailInfo.actionBarInfo = actionBarInfo;
        actionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo = new AdStyleInfo.PlayDetailInfo.PatchAdInfo();
        playDetailInfo.patchAdInfo = patchAdInfo;
        patchAdInfo.parseJson(jSONObject.optJSONObject("patchAdInfo"));
        AdStyleInfo.PlayDetailInfo.WidgetAdInfo widgetAdInfo = new AdStyleInfo.PlayDetailInfo.WidgetAdInfo();
        playDetailInfo.widgetAdInfo = widgetAdInfo;
        widgetAdInfo.parseJson(jSONObject.optJSONObject("widgetAdInfo"));
        AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo = new AdStyleInfo.PlayDetailInfo.DetailCommonInfo();
        playDetailInfo.detailCommonInfo = detailCommonInfo;
        detailCommonInfo.parseJson(jSONObject.optJSONObject("detailCommonInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, playDetailInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "type", playDetailInfo.type);
            com.kwad.sdk.utils.q.a(jSONObject, "detailWebCardInfo", playDetailInfo.detailWebCardInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "detailTopToolBarInfo", playDetailInfo.detailTopToolBarInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "actionBarInfo", playDetailInfo.actionBarInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "patchAdInfo", playDetailInfo.patchAdInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "widgetAdInfo", playDetailInfo.widgetAdInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "detailCommonInfo", playDetailInfo.detailCommonInfo);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
