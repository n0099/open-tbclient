package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.d;
import com.kwad.sdk.utils.q;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
@Keep
/* loaded from: classes2.dex */
public class RulesTargetNative extends NativeObject implements d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4726982809581153390L;
    public transient /* synthetic */ FieldHolder $fh;

    public RulesTargetNative() {
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
        this.mPtr = AppStatusNative.nativeCreateRulesTarget();
    }

    public RulesTargetNative(long j) {
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
        this.mPtr = j;
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j = this.mPtr;
            if (j != 0) {
                AppStatusNative.nativeDeleteRulesTarget(j);
                this.mPtr = 0L;
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            AppStatusNative.rulesTargetSetPackageName(this, jSONObject.optString("packageName"));
            JSONArray optJSONArray = jSONObject.optJSONArray("paths");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                String[] strArr = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    strArr[i2] = optJSONArray.getString(i2);
                }
                AppStatusNative.rulesTargetSetPaths(this, strArr);
            }
        } catch (Exception e2) {
            com.kwad.sdk.crash.a.a(e2);
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            q.a(jSONObject, "packageName", AppStatusNative.rulesTargetGetPackageName(this));
            q.a(jSONObject, "paths", Arrays.asList(AppStatusNative.rulesTargetGetPaths(this)));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
