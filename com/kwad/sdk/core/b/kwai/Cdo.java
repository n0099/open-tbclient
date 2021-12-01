package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONObject;
/* renamed from: com.kwad.sdk.core.b.kwai.do  reason: invalid class name */
/* loaded from: classes2.dex */
public class Cdo implements com.kwad.sdk.core.d<SceneImpl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Cdo() {
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
    public void a(SceneImpl sceneImpl, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sceneImpl, jSONObject) == null) || jSONObject == null) {
            return;
        }
        URLPackage uRLPackage = new URLPackage();
        sceneImpl.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        sceneImpl.posId = jSONObject.optLong("posId");
        sceneImpl.entryScene = jSONObject.optLong("entryScene");
        sceneImpl.adNum = jSONObject.optInt("adNum");
        sceneImpl.action = jSONObject.optInt("action");
        sceneImpl.width = jSONObject.optInt("width");
        sceneImpl.height = jSONObject.optInt("height");
        sceneImpl.adStyle = jSONObject.optInt("adStyle");
        sceneImpl.screenOrientation = jSONObject.optInt("screenOrientation");
        sceneImpl.needShowMiniWindow = jSONObject.optBoolean("needShowMiniWindow");
        sceneImpl.backUrl = jSONObject.optString("backUrl");
        if (jSONObject.opt("backUrl") == JSONObject.NULL) {
            sceneImpl.backUrl = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(SceneImpl sceneImpl, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sceneImpl, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", sceneImpl.urlPackage);
            com.kwad.sdk.utils.t.a(jSONObject, "posId", sceneImpl.posId);
            com.kwad.sdk.utils.t.a(jSONObject, "entryScene", sceneImpl.entryScene);
            com.kwad.sdk.utils.t.a(jSONObject, "adNum", sceneImpl.adNum);
            com.kwad.sdk.utils.t.a(jSONObject, "action", sceneImpl.action);
            com.kwad.sdk.utils.t.a(jSONObject, "width", sceneImpl.width);
            com.kwad.sdk.utils.t.a(jSONObject, "height", sceneImpl.height);
            com.kwad.sdk.utils.t.a(jSONObject, "adStyle", sceneImpl.adStyle);
            com.kwad.sdk.utils.t.a(jSONObject, "screenOrientation", sceneImpl.screenOrientation);
            com.kwad.sdk.utils.t.a(jSONObject, "needShowMiniWindow", sceneImpl.needShowMiniWindow);
            com.kwad.sdk.utils.t.a(jSONObject, "backUrl", sceneImpl.backUrl);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
