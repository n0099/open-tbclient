package com.yy.hiidostatis.defs.obj;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.yy.hiidostatis.inner.util.log.L;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class RecentAppInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long lastModified;
    public String name;
    public String pkg;
    public int type;

    public RecentAppInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static RecentAppInfo fromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                String string = jSONObject.getString("name");
                String string2 = jSONObject.getString("pkg");
                Long valueOf = Long.valueOf(jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING));
                int i = jSONObject.getInt("type");
                if (string2 == null || string2.isEmpty() || valueOf == null) {
                    return null;
                }
                RecentAppInfo recentAppInfo = new RecentAppInfo();
                recentAppInfo.setLastModified(valueOf.longValue());
                recentAppInfo.setPkg(string2);
                recentAppInfo.setName(string);
                recentAppInfo.setType(i);
                return recentAppInfo;
            } catch (Throwable th) {
                L.debug("RecentAppInfo", th.getMessage(), new Object[0]);
                return null;
            }
        }
        return (RecentAppInfo) invokeL.objValue;
    }

    public long getLastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.lastModified : invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public String getPkg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.pkg : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.type : invokeV.intValue;
    }

    public void setLastModified(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.lastModified = j;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.name = str;
        }
    }

    public void setPkg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.pkg = str;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.type = i;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.name != null) {
                    jSONObject.put("name", this.name);
                }
                jSONObject.put("pkg", this.pkg);
                jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.lastModified);
                jSONObject.put("type", this.type);
                return jSONObject;
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
