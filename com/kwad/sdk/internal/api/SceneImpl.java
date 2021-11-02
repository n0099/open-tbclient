package com.kwad.sdk.internal.api;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.q;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SceneImpl extends com.kwad.sdk.core.response.a.a implements KsScene, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 93865491903408451L;
    public transient /* synthetic */ FieldHolder $fh;
    public int action;
    public int adNum;
    public int adStyle;
    public long entryScene;
    public int height;
    public int industryFirstLevelId;
    public boolean needShowMiniWindow;
    public long posId;
    public Map<String, String> rewardCallbackExtraData;
    public int screenOrientation;
    public URLPackage urlPackage;
    public int width;

    public SceneImpl() {
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
        this.adNum = 1;
        this.screenOrientation = 0;
        this.needShowMiniWindow = false;
    }

    public SceneImpl(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.adNum = 1;
        this.screenOrientation = 0;
        this.needShowMiniWindow = false;
        this.posId = j;
        this.entryScene = j;
    }

    public SceneImpl(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.adNum = 1;
        this.screenOrientation = 0;
        this.needShowMiniWindow = false;
        this.posId = ksScene.getPosId();
        this.entryScene = ksScene.getPosId();
        this.adNum = ksScene.getAdNum();
        this.action = ksScene.getAction();
        this.width = ksScene.getWidth();
        this.height = ksScene.getHeight();
        this.adStyle = ksScene.getAdStyle();
    }

    public static long getSerialVersionUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? serialVersionUID : invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterParseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            this.rewardCallbackExtraData = q.b(jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            q.a(jSONObject, PrefetchEvent.EVENT_DATA_EXTRA_DATA, q.a(this.rewardCallbackExtraData));
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.action : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.adNum : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.adStyle : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.height : invokeV.intValue;
    }

    public int getPageScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            URLPackage uRLPackage = this.urlPackage;
            if (uRLPackage == null) {
                return 0;
            }
            return uRLPackage.page;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getPosId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.posId : invokeV.longValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public Map<String, String> getRewardCallbackExtraData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.rewardCallbackExtraData : (Map) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getScreenOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.screenOrientation : invokeV.intValue;
    }

    public URLPackage getUrlPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.urlPackage : (URLPackage) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.width : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void needShowMiniWindow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.needShowMiniWindow = z;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAction(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.action = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.adNum = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.adStyle = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.height = i2;
        }
    }

    public void setIndustryFirstLevelId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.industryFirstLevelId = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPosId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.posId = j;
            this.entryScene = j;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setRewardCallbackExtraData(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, map) == null) {
            this.rewardCallbackExtraData = map;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setScreenOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.screenOrientation = i2;
        }
    }

    public void setUrlPackage(URLPackage uRLPackage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, uRLPackage) == null) {
            this.urlPackage = uRLPackage;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.width = i2;
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            q.a(jSONObject, "posId", this.posId);
            q.a(jSONObject, "entryScene", this.entryScene);
            q.a(jSONObject, "adNum", this.adNum);
            q.a(jSONObject, "action", this.action);
            q.a(jSONObject, "width", this.width);
            q.a(jSONObject, "height", this.height);
            q.a(jSONObject, "adStyle", this.adStyle);
            q.a(jSONObject, "urlPackage", this.urlPackage);
            q.a(jSONObject, "screenOrientation", this.screenOrientation);
            q.a(jSONObject, "industryFirstLevelId", this.industryFirstLevelId);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
