package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;
/* loaded from: classes8.dex */
public class GrsBaseInfo implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public String androidVersion;
    public String appName;
    public String countrySource;
    public String deviceModel;
    public String issueCountry;
    public String regCountry;
    public String romVersion;
    public String serCountry;
    public String uid;
    public String versionName;

    /* loaded from: classes8.dex */
    public @interface CountryCodeSource {
        public static final String APP = "APP";
        public static final String LOCALE_INFO = "LOCALE_INFO";
        public static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
        public static final String SIM_COUNTRY = "SIM_COUNTRY";
        public static final String UNKNOWN = "UNKNOWN";
        public static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-124897412, "Lcom/huawei/hms/framework/network/grs/GrsBaseInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-124897412, "Lcom/huawei/hms/framework/network/grs/GrsBaseInfo;");
                return;
            }
        }
        TAG = GrsBaseInfo.class.getSimpleName();
    }

    public GrsBaseInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public GrsBaseInfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.issueCountry = GrsApp.getInstance().getIssueCountryCode(context);
    }

    private StringBuffer getStringBuffer(StringBuffer stringBuffer, boolean z, Context context) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{stringBuffer, Boolean.valueOf(z), context})) == null) {
            String androidVersion = getAndroidVersion();
            if (!TextUtils.isEmpty(androidVersion)) {
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append("&");
                }
                stringBuffer.append("android_version");
                stringBuffer.append("=");
                stringBuffer.append(androidVersion);
            }
            String romVersion = getRomVersion();
            if (!TextUtils.isEmpty(romVersion)) {
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append("&");
                }
                stringBuffer.append("rom_version");
                stringBuffer.append("=");
                stringBuffer.append(romVersion);
            }
            String deviceModel = getDeviceModel();
            if (!TextUtils.isEmpty(deviceModel)) {
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append("&");
                }
                stringBuffer.append("device_model");
                stringBuffer.append("=");
                stringBuffer.append(deviceModel);
            }
            String countrySource = getCountrySource();
            if (!TextUtils.isEmpty(countrySource)) {
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append("&");
                }
                stringBuffer.append("country_source");
                stringBuffer.append("=");
                stringBuffer.append(countrySource);
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append("package_name");
            stringBuffer.append("=");
            stringBuffer.append(context.getPackageName());
            return stringBuffer;
        }
        return (StringBuffer) invokeCommon.objValue;
    }

    private boolean isEqual(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            if (str == null && str2 == null) {
                return true;
            }
            if (str == null || str2 == null) {
                return false;
            }
            return str.equals(str2);
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public GrsBaseInfo m88clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (GrsBaseInfo) super.clone() : (GrsBaseInfo) invokeV.objValue;
    }

    public boolean compare(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && GrsBaseInfo.class == obj.getClass() && (obj instanceof GrsBaseInfo)) {
                GrsBaseInfo grsBaseInfo = (GrsBaseInfo) obj;
                return isEqual(this.serCountry, grsBaseInfo.serCountry) && isEqual(this.versionName, grsBaseInfo.versionName) && isEqual(this.appName, grsBaseInfo.appName) && isEqual(this.uid, grsBaseInfo.uid) && isEqual(this.regCountry, grsBaseInfo.regCountry) && isEqual(this.issueCountry, grsBaseInfo.issueCountry) && isEqual(this.androidVersion, grsBaseInfo.androidVersion) && isEqual(this.romVersion, grsBaseInfo.romVersion) && isEqual(this.deviceModel, grsBaseInfo.deviceModel) && isEqual(this.countrySource, grsBaseInfo.countrySource);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public GrsBaseInfo copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            grsBaseInfo.setAppName(this.appName);
            grsBaseInfo.setSerCountry(this.serCountry);
            grsBaseInfo.setRegCountry(this.regCountry);
            grsBaseInfo.setIssueCountry(this.issueCountry);
            grsBaseInfo.setCountrySource(this.countrySource);
            grsBaseInfo.setAndroidVersion(this.androidVersion);
            grsBaseInfo.setDeviceModel(this.deviceModel);
            grsBaseInfo.setRomVersion(this.romVersion);
            grsBaseInfo.setUid(this.uid);
            grsBaseInfo.setVersionName(this.versionName);
            return grsBaseInfo;
        }
        return (GrsBaseInfo) invokeV.objValue;
    }

    public String getAndroidVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.androidVersion : (String) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.appName : (String) invokeV.objValue;
    }

    public String getCountrySource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.countrySource : (String) invokeV.objValue;
    }

    public String getDeviceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.deviceModel : (String) invokeV.objValue;
    }

    public String getGrsParasKey(boolean z, boolean z2, Context context) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), context})) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            com.huawei.hms.framework.network.grs.f.b a = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this);
            com.huawei.hms.framework.network.grs.local.model.a a2 = a != null ? a.a() : null;
            String grsReqParamJoint = getGrsReqParamJoint(z, z2, a2 != null ? a2.b() : "", context);
            if (!TextUtils.isEmpty(grsReqParamJoint)) {
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append("&");
                }
                stringBuffer.append(grsReqParamJoint);
            }
            return stringBuffer.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public String getGrsReqParamJoint(boolean z, boolean z2, String str, Context context) {
        InterceptResult invokeCommon;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, context})) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if ("1.0".equals(str)) {
                Logger.v(TAG, "1.0 interface has no query param appname");
            } else {
                if (!TextUtils.isEmpty(str)) {
                    stringBuffer.append("app_name");
                    stringBuffer.append("=");
                } else if (!TextUtils.isEmpty(getAppName())) {
                    stringBuffer.append("app_name");
                    stringBuffer.append("=");
                    str = getAppName();
                }
                stringBuffer.append(str);
            }
            String versionName = getVersionName();
            if (!TextUtils.isEmpty(versionName)) {
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append("&");
                }
                stringBuffer.append("app_version");
                stringBuffer.append("=");
                stringBuffer.append(versionName);
            }
            String uid = getUid();
            if (!TextUtils.isEmpty(uid)) {
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append("&");
                }
                stringBuffer.append("uid");
                stringBuffer.append("=");
                if (z) {
                    a = com.huawei.hms.framework.network.grs.h.b.b(uid);
                } else if (z2) {
                    a = com.huawei.hms.framework.network.grs.h.b.a(uid);
                } else {
                    stringBuffer.append(uid);
                }
                stringBuffer.append(a);
            }
            String regCountry = getRegCountry();
            if (!TextUtils.isEmpty(regCountry) && !"UNKNOWN".equals(regCountry)) {
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append("&");
                }
                stringBuffer.append("reg_country");
                stringBuffer.append("=");
                stringBuffer.append(regCountry);
            }
            String serCountry = getSerCountry();
            if (!TextUtils.isEmpty(serCountry) && !"UNKNOWN".equals(serCountry)) {
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append("&");
                }
                stringBuffer.append("ser_country");
                stringBuffer.append("=");
                stringBuffer.append(serCountry);
            }
            String issueCountry = getIssueCountry();
            if (!TextUtils.isEmpty(issueCountry) && !"UNKNOWN".equals(issueCountry)) {
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append("&");
                }
                stringBuffer.append("issue_country");
                stringBuffer.append("=");
                stringBuffer.append(issueCountry);
            }
            return getStringBuffer(stringBuffer, z2, context).toString();
        }
        return (String) invokeCommon.objValue;
    }

    public String getIssueCountry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.issueCountry : (String) invokeV.objValue;
    }

    public String getRegCountry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.regCountry : (String) invokeV.objValue;
    }

    public String getRomVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.romVersion : (String) invokeV.objValue;
    }

    public String getSerCountry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.serCountry : (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.uid : (String) invokeV.objValue;
    }

    public String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.versionName : (String) invokeV.objValue;
    }

    public void setAndroidVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.androidVersion = str;
        }
    }

    public void setAppName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.appName = str;
        }
    }

    public void setCountrySource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.countrySource = str;
        }
    }

    public void setDeviceModel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.deviceModel = str;
        }
    }

    @Deprecated
    public void setIssueCountry(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.issueCountry = str != null ? str.toUpperCase(Locale.ENGLISH) : "";
        }
    }

    public void setRegCountry(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.regCountry = str != null ? str.toUpperCase(Locale.ENGLISH) : "";
        }
    }

    public void setRomVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.romVersion = str;
        }
    }

    public void setSerCountry(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.serCountry = str != null ? str.toUpperCase(Locale.ENGLISH) : "";
        }
    }

    @Deprecated
    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.uid = str;
        }
    }

    public void setVersionName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.versionName = str;
        }
    }

    public int uniqueCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (this.appName + "#" + this.serCountry + "#" + this.regCountry + "#" + this.issueCountry).hashCode();
        }
        return invokeV.intValue;
    }
}
