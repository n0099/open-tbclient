package com.kwad.sdk.internal.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SceneImpl implements KsScene, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 93865491903408451L;
    public transient /* synthetic */ FieldHolder $fh;
    public int action;
    public int adNum;
    public int adStyle;
    public long entryScene;
    public int height;
    public long posId;
    public transient URLPackage urlPackage;
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

    @Override // com.kwad.sdk.api.KsScene
    public int getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.action : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.adNum : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.adStyle : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.height : invokeV.intValue;
    }

    public int getPageScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.posId : invokeV.longValue;
    }

    public URLPackage getUrlPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.urlPackage : (URLPackage) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.width : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAction(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.action = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.adNum = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.adStyle = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.height = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPosId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.posId = j;
            this.entryScene = j;
        }
    }

    public void setUrlPackage(URLPackage uRLPackage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, uRLPackage) == null) {
            this.urlPackage = uRLPackage;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.width = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "posId", this.posId);
            o.a(jSONObject, "entryScene", this.entryScene);
            o.a(jSONObject, "adNum", this.adNum);
            o.a(jSONObject, "action", this.action);
            o.a(jSONObject, "width", this.width);
            o.a(jSONObject, "height", this.height);
            o.a(jSONObject, "adStyle", this.adStyle);
            o.a(jSONObject, "urlPackage", this.urlPackage);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
