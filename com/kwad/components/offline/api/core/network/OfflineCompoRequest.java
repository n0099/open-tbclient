package com.kwad.components.offline.api.core.network;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.b;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class OfflineCompoRequest implements IOfflineCompoRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final JSONObject mBodyParams;
    public final Map mHeader;
    public d mHostRequest;

    public OfflineCompoRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHeader = new HashMap();
        this.mBodyParams = new JSONObject();
        this.mHostRequest = new d(this) { // from class: com.kwad.components.offline.api.core.network.OfflineCompoRequest.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ OfflineCompoRequest this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public SceneImpl getScene() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return null;
                }
                return (SceneImpl) invokeV.objValue;
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public String getUrl() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.getUrl() : (String) invokeV.objValue;
            }
        };
    }

    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHeader.put(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public boolean encryptDisable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHostRequest.encryptDisable() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public JSONObject getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JsonHelper.merge(this.mHostRequest.mBodyParams, this.mBodyParams);
            return this.mHostRequest.getBody();
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public Map getBodyMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public Map getHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.mHostRequest.getHeader().putAll(this.mHeader);
            return this.mHostRequest.getHeader();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public String getRequestHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? b.qJ() : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public final KsScene getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (KsScene) invokeV.objValue;
    }

    public void putBody(String str, byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Byte.valueOf(b)}) == null) {
            JsonHelper.putValue(this.mBodyParams, str, b);
        }
    }

    public void putBody(String str, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Double.valueOf(d)}) == null) {
            JsonHelper.putValue(this.mBodyParams, str, d);
        }
    }

    public void putBody(String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048585, this, str, f) == null) {
            JsonHelper.putValue(this.mBodyParams, str, f);
        }
    }

    public void putBody(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i) == null) {
            JsonHelper.putValue(this.mBodyParams, str, i);
        }
    }

    public void putBody(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j) == null) {
            JsonHelper.putValue(this.mBodyParams, str, j);
        }
    }

    public void putBody(String str, IOfflineCompoJsonParse iOfflineCompoJsonParse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, iOfflineCompoJsonParse) == null) {
            JsonHelper.putValue(this.mBodyParams, str, iOfflineCompoJsonParse);
        }
    }

    public void putBody(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            JsonHelper.putValue(this.mBodyParams, str, str2);
        }
    }

    public void putBody(String str, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, list) == null) {
            JsonHelper.putValue(this.mBodyParams, str, list);
        }
    }

    public void putBody(String str, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, jSONArray) == null) {
            JsonHelper.putValue(this.mBodyParams, str, jSONArray);
        }
    }

    public void putBody(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, jSONObject) == null) {
            JsonHelper.putValue(this.mBodyParams, str, jSONObject);
        }
    }

    public void putBody(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) {
            JsonHelper.putValue(this.mBodyParams, str, z);
        }
    }
}
