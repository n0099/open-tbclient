package com.kuaishou.tachikoma.api.model;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.e.f;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TKCDNUrl extends BaseJsonApiParse implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CDN = "cdn";
    public static final String IP = "ip";
    public static final String URL = "url";
    public static final String URL_PATTERN = "urlPattern";
    public static final String URL_TYPE = "urlType";
    public static final long serialVersionUID = 8253139331705520143L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCdn;
    public Set<Integer> mFeature;
    public Map<String, String> mHeaders;
    public String mIp;
    public boolean mIsFreeTrafficCdn;
    public String mPushCdn;
    public String mUrl;
    public String mUrlPattern;
    public String mUrlType;

    public TKCDNUrl() {
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

    public TKCDNUrl(TKCDNUrl tKCDNUrl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tKCDNUrl};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (tKCDNUrl != null) {
            this.mCdn = tKCDNUrl.mCdn;
            this.mUrl = tKCDNUrl.mUrl;
            this.mUrlType = tKCDNUrl.mUrlType;
            this.mIsFreeTrafficCdn = tKCDNUrl.mIsFreeTrafficCdn;
            if (tKCDNUrl.mFeature != null) {
                this.mFeature = new HashSet(tKCDNUrl.mFeature);
            }
            this.mPushCdn = tKCDNUrl.mPushCdn;
            if (tKCDNUrl.mHeaders != null) {
                this.mHeaders = new HashMap(tKCDNUrl.mHeaders);
            }
            this.mIp = tKCDNUrl.mIp;
            this.mUrlPattern = tKCDNUrl.mUrlPattern;
        }
    }

    public TKCDNUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mCdn = str;
        this.mUrl = str2;
    }

    public TKCDNUrl(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mCdn = str;
        this.mUrl = str2;
        this.mIp = str3;
        this.mUrlPattern = str4;
    }

    public TKCDNUrl(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mCdn = str;
        this.mUrl = str2;
        this.mIp = str3;
        this.mUrlPattern = str4;
        this.mUrlType = str5;
    }

    public TKCDNUrl(String str, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.mCdn = str;
        this.mUrl = str2;
        this.mIp = str3;
        this.mUrlPattern = str4;
        this.mIsFreeTrafficCdn = z;
    }

    public TKCDNUrl(String str, String str2, String str3, String str4, boolean z, Set<Integer> set, String str5, String str6, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Boolean.valueOf(z), set, str5, str6, map};
            interceptable.invokeUnInit(65542, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        this.mCdn = str;
        this.mUrl = str2;
        this.mUrlType = str5;
        this.mIsFreeTrafficCdn = z;
        this.mFeature = set;
        this.mPushCdn = str6;
        this.mHeaders = map;
        this.mIp = str3;
        this.mUrlPattern = str4;
    }

    public TKCDNUrl(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        this.mCdn = str;
        this.mUrl = str2;
        this.mIsFreeTrafficCdn = z;
    }

    @Override // com.kwad.sdk.e.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterParseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("feature");
                if (optJSONArray != null) {
                    this.mFeature = new HashSet();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        this.mFeature.add(Integer.valueOf(optJSONArray.getInt(i2)));
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("headers");
                if (optJSONObject != null) {
                    this.mHeaders = new HashMap();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.mHeaders.put(next, optJSONObject.optString(next));
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.e.a
    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            Set<Integer> set = this.mFeature;
            if (set != null) {
                f.a(jSONObject, "feature", f.a(set));
            }
            Map<String, String> map = this.mHeaders;
            if (map != null) {
                f.a(jSONObject, "headers", f.a(map));
            }
        }
    }

    public String getCdn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCdn : (String) invokeV.objValue;
    }

    public Set<Integer> getFeature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFeature : (Set) invokeV.objValue;
    }

    public Set<Integer> getFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFeature : (Set) invokeV.objValue;
    }

    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mHeaders : (Map) invokeV.objValue;
    }

    public String getIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIp : (String) invokeV.objValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return new URL(this.mUrl).getPath();
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                return this.mUrl;
            }
        }
        return (String) invokeV.objValue;
    }

    public String getPushCdn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPushCdn : (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    public String getUrlPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mUrlPattern : (String) invokeV.objValue;
    }

    public String getUrlType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mUrlType : (String) invokeV.objValue;
    }

    public boolean isFreeTrafficCdn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIsFreeTrafficCdn : invokeV.booleanValue;
    }

    public void setFeature(Set<Integer> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, set) == null) {
            this.mFeature = set;
        }
    }
}
