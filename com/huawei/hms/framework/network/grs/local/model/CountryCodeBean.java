package com.huawei.hms.framework.network.grs.local.model;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Locale;
/* loaded from: classes10.dex */
public class CountryCodeBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
    public static final int ANDROID_9_API_LEVEL = 28;
    public static final int COUNTRYCODE_SIZE = 2;
    public static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    public static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale";
    public static final String LOCALE_REGION_COUNTRYSYSTEMPROP = "ro.product.locale.region";
    public static final String SPECIAL_COUNTRYCODE_CN = "cn";
    public static final String SPECIAL_COUNTRYCODE_EU = "eu";
    public static final String SPECIAL_COUNTRYCODE_GB = "gb";
    public static final String SPECIAL_COUNTRYCODE_LA = "la";
    public static final String SPECIAL_COUNTRYCODE_UK = "uk";
    public static final String TAG = "CountryCodeBean";
    public static final String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
    public transient /* synthetic */ FieldHolder $fh;
    public String countryCode;
    public String countrySource;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(534333818, "Lcom/huawei/hms/framework/network/grs/local/model/CountryCodeBean;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(534333818, "Lcom/huawei/hms/framework/network/grs/local/model/CountryCodeBean;");
        }
    }

    public CountryCodeBean(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.countrySource = "UNKNOWN";
        this.countryCode = "UNKNOWN";
        init(context, z);
        this.countryCode = this.countryCode.toUpperCase(Locale.ENGLISH);
    }

    private void checkCodeLenth() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            String str = this.countryCode;
            if (str == null || str.length() != 2) {
                this.countryCode = "UNKNOWN";
                this.countrySource = "UNKNOWN";
            }
        }
    }

    private void getLocaleCountryCode() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (SystemPropUtils.getProperty(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "ro.build.version.emui", ANDRIOD_SYSTEMPROP, "").isEmpty()) {
                if (Build.VERSION.SDK_INT >= 28 || Build.VERSION.RELEASE.charAt(0) >= '9') {
                    getRegionSettingCountryCode();
                    str = TAG;
                    str2 = "other Android 9.0 upper， get countryCode form Locale.getDefault().getCountry()";
                } else {
                    getProductCountryCode();
                    str = TAG;
                    str2 = "other Android 9.0 lower, get countryCode form ro.product.locale.region or locale";
                }
            } else if (EmuiUtil.isUpPVersion()) {
                getRegionSettingCountryCode();
                str = TAG;
                str2 = "EMUI 9.0 upper System, get countryCode form Locale.getDefault().getCountry()";
            } else {
                getProductCountryCode();
                str = TAG;
                str2 = "EMUI 9.0 lower System, get countryCode form ro.product.locale.region or locale";
            }
            Logger.i(str, str2);
            this.countrySource = GrsBaseInfo.CountryCodeSource.LOCALE_INFO;
        }
    }

    private void getProductCountryCode() {
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.countryCode = SystemPropUtils.getProperty(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, LOCALE_REGION_COUNTRYSYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
            String str = TAG;
            Logger.i(str, "countryCode by ro.product.locale.region is:" + this.countryCode);
            if (TextUtils.isEmpty(this.countryCode) || "UNKNOWN".equals(this.countryCode)) {
                String property = SystemPropUtils.getProperty(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, LOCALE_COUNTRYSYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
                if (!TextUtils.isEmpty(property) && (lastIndexOf = property.lastIndexOf("-")) != -1) {
                    this.countryCode = property.substring(lastIndexOf + 1);
                    String str2 = TAG;
                    Logger.i(str2, "countryCode by ro.product.locale is:" + this.countryCode);
                }
            }
            if ("cn".equalsIgnoreCase(this.countryCode)) {
                return;
            }
            this.countryCode = "UNKNOWN";
        }
    }

    private void getRegionSettingCountryCode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.countryCode = Locale.getDefault().getCountry();
            String str = TAG;
            Logger.i(str, "countryCode by system's region setting is: " + this.countryCode);
            if (TextUtils.isEmpty(this.countryCode)) {
                this.countryCode = "UNKNOWN";
            }
        }
    }

    private void getSimCountryCode(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            getSimCountryCode(context, false);
        }
    }

    private void getSimCountryCode(Context context, boolean z) {
        String str;
        StringBuilder sb;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, this, context, z) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            if (telephonyManager != null) {
                if (!z || telephonyManager.getPhoneType() == 2) {
                    this.countryCode = telephonyManager.getSimCountryIso();
                    this.countrySource = GrsBaseInfo.CountryCodeSource.SIM_COUNTRY;
                    str = TAG;
                    sb = new StringBuilder();
                    str2 = "countryCode by SimCountryIso is: ";
                } else {
                    this.countryCode = telephonyManager.getNetworkCountryIso();
                    this.countrySource = GrsBaseInfo.CountryCodeSource.NETWORK_COUNTRY;
                    str = TAG;
                    sb = new StringBuilder();
                    str2 = "countryCode by NetworkCountryIso is: ";
                }
                sb.append(str2);
                sb.append(this.countryCode);
                Logger.i(str, sb.toString());
            }
            checkCodeLenth();
        }
    }

    private void getVendorCountryCode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.countrySource = GrsBaseInfo.CountryCodeSource.VENDOR_COUNTRY;
            this.countryCode = SystemPropUtils.getProperty(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, VENDORCOUNTRY_SYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
            String str = TAG;
            Logger.i(str, "countryCode by ro.hw.country is: " + this.countryCode);
            if (SPECIAL_COUNTRYCODE_EU.equalsIgnoreCase(this.countryCode) || "la".equalsIgnoreCase(this.countryCode)) {
                this.countryCode = "UNKNOWN";
                this.countrySource = "UNKNOWN";
            } else if (!"uk".equalsIgnoreCase(this.countryCode)) {
                checkCodeLenth();
            } else {
                Logger.i(TAG, "special country of UK to map GB.");
                this.countryCode = SPECIAL_COUNTRYCODE_GB;
                this.countrySource = GrsBaseInfo.CountryCodeSource.VENDOR_COUNTRY;
            }
        }
    }

    private void init(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, this, context, z) == null) {
            if (context == null) {
                throw new NullPointerException("context must be not null.Please provide app's Context");
            }
            try {
                getVendorCountryCode();
                if (isCodeValidate()) {
                    Logger.i(TAG, "get issue_country code from VENDOR_COUNTRY");
                    return;
                }
                getSimCountryCode(context);
                if (isCodeValidate()) {
                    Logger.i(TAG, "get issue_country code from SIM_COUNTRY");
                    return;
                }
                getLocaleCountryCode();
                if (isCodeValidate()) {
                    Logger.i(TAG, "get issue_country code from LOCALE_INFO");
                }
            } catch (Exception unused) {
                Logger.w(TAG, "get CountryCode error");
            }
        }
    }

    private boolean isCodeValidate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? !"UNKNOWN".equals(this.countryCode) : invokeV.booleanValue;
    }

    public String getCountryCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.countryCode : (String) invokeV.objValue;
    }

    public String getCountrySource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.countrySource : (String) invokeV.objValue;
    }
}
