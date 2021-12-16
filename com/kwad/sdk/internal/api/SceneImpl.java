package com.kwad.sdk.internal.api;

import androidx.annotation.NonNull;
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
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SceneImpl extends com.kwad.sdk.core.response.kwai.a implements KsScene, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 93865491903408451L;
    public transient /* synthetic */ FieldHolder $fh;
    public int action;
    public int adNum;
    public int adStyle;
    public String backUrl;
    public long entryScene;
    public int height;
    public final EcAttribute mEcAttribute;
    public transient a mKsAdLabel;
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
        this.mEcAttribute = new EcAttribute();
    }

    public SceneImpl(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
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
        this.mEcAttribute = new EcAttribute();
        this.posId = j2;
        this.entryScene = j2;
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
        this.mEcAttribute = new EcAttribute();
        this.posId = ksScene.getPosId();
        this.entryScene = ksScene.getPosId();
        this.adNum = ksScene.getAdNum();
        this.action = ksScene.getAction();
        this.width = ksScene.getWidth();
        this.height = ksScene.getHeight();
        this.adStyle = ksScene.getAdStyle();
        this.mEcAttribute.setPromoteId(getPromoteId(ksScene));
        this.mEcAttribute.setComment(getComment(ksScene));
        this.backUrl = getBackUrl(ksScene);
        this.mEcAttribute.setUserCommRateBuying(getUserCommRateBuying(ksScene));
        this.mEcAttribute.setUserCommRateSharing(getUserCommRateSharing(ksScene));
    }

    private String getComment(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, ksScene)) == null) {
            if (ksScene == null) {
                return "";
            }
            try {
                return ksScene.getComment();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private String getPromoteId(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, ksScene)) == null) {
            if (ksScene == null) {
                return "";
            }
            try {
                return ksScene.getPromoteId();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static long getSerialVersionUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? serialVersionUID : invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterParseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            this.rewardCallbackExtraData = t.b(jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            t.a(jSONObject, PrefetchEvent.EVENT_DATA_EXTRA_DATA, t.a(this.rewardCallbackExtraData));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: clone */
    public SceneImpl m110clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String jSONObject = toJson().toString();
            try {
                SceneImpl sceneImpl = new SceneImpl();
                sceneImpl.parseJson(new JSONObject(jSONObject));
                return sceneImpl;
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.b(e2);
                return null;
            }
        }
        return (SceneImpl) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.action : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.adNum : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.adStyle : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBackUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.backUrl : (String) invokeV.objValue;
    }

    public String getBackUrl(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksScene)) == null) {
            if (ksScene == null) {
                return "";
            }
            try {
                return ksScene.getBackUrl();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getComment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mEcAttribute.getComment() : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.height : invokeV.intValue;
    }

    public int getPageScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.posId : invokeV.longValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getPromoteId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mEcAttribute.getPromoteId() : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public Map<String, String> getRewardCallbackExtraData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.rewardCallbackExtraData : (Map) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getScreenOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.screenOrientation : invokeV.intValue;
    }

    public URLPackage getUrlPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.urlPackage : (URLPackage) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getUserCommRateBuying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mEcAttribute.getUserCommRateBuying() : invokeV.longValue;
    }

    public long getUserCommRateBuying(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, ksScene)) == null) {
            if (ksScene == null) {
                return 0L;
            }
            try {
                return ksScene.getUserCommRateBuying();
            } catch (Throwable unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getUserCommRateSharing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mEcAttribute.getUserCommRateSharing() : invokeV.longValue;
    }

    public long getUserCommRateSharing(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, ksScene)) == null) {
            if (ksScene == null) {
                return 0L;
            }
            try {
                return ksScene.getUserCommRateSharing();
            } catch (Throwable unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.width : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void needShowMiniWindow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.needShowMiniWindow = z;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAction(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.action = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.adNum = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.adStyle = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBackUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.backUrl = str;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setComment(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.mEcAttribute.setComment(str);
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.height = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setKsAdLabel(com.kwad.sdk.api.model.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, aVar) == null) || aVar == null) {
            return;
        }
        a aVar2 = new a();
        this.mKsAdLabel = aVar2;
        aVar2.a = aVar.a();
        this.mKsAdLabel.f59224b = aVar.b();
        this.mKsAdLabel.f59225c = aVar.c();
        this.mKsAdLabel.f59226d = aVar.d();
        this.mKsAdLabel.f59227e = aVar.e();
        this.mKsAdLabel.f59228f = aVar.f();
        this.mKsAdLabel.f59229g = aVar.g();
        this.mKsAdLabel.f59230h = aVar.h();
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPosId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j2) == null) {
            this.posId = j2;
            this.entryScene = j2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPromoteId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.mEcAttribute.setPromoteId(str);
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setRewardCallbackExtraData(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, map) == null) {
            this.rewardCallbackExtraData = map;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setScreenOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.screenOrientation = i2;
        }
    }

    public void setUrlPackage(URLPackage uRLPackage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, uRLPackage) == null) {
            this.urlPackage = uRLPackage;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateBuying(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.mEcAttribute.setUserCommRateBuying(i2);
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateSharing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.mEcAttribute.setUserCommRateSharing(i2);
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.width = i2;
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "posId", this.posId);
            t.a(jSONObject, "entryScene", this.entryScene);
            t.a(jSONObject, "adNum", this.adNum);
            t.a(jSONObject, "action", this.action);
            t.a(jSONObject, "width", this.width);
            t.a(jSONObject, "height", this.height);
            a aVar = this.mKsAdLabel;
            if (aVar != null) {
                long j2 = aVar.f59230h;
                if (j2 != 0) {
                    t.a(jSONObject, "cpmBidFloor", j2);
                }
            }
            t.a(jSONObject, "adStyle", this.adStyle);
            t.a(jSONObject, "urlPackage", this.urlPackage);
            t.a(jSONObject, "promoteId", this.mEcAttribute.getPromoteId());
            t.a(jSONObject, "comment", this.mEcAttribute.getComment());
            t.a(jSONObject, "backUrl", this.backUrl);
            t.a(jSONObject, "userCommRateBuying", this.mEcAttribute.getUserCommRateBuying());
            t.a(jSONObject, "userCommRateSharing", this.mEcAttribute.getUserCommRateSharing());
            t.a(jSONObject, "screenOrientation", this.screenOrientation);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
