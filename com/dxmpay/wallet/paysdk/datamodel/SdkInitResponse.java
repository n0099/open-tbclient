package com.dxmpay.wallet.paysdk.datamodel;

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
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SdkInitResponse implements IBeanResponse {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f62667e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public String balanceHomeUrl;
    public String balanceSchemeUrl;
    public String bankCardListUrl;
    public String bankCardSchemeUrl;
    public String certWhiteList;
    public String cookiesSyncDomainList;
    public String domainConfig;
    public String domainSwitch;
    public String download_file;
    public String findPayPwdUrl;
    public String fp;
    public String h5bindCardUrl;
    public boolean jumpSwanApp;
    public String kefuPhoneNum;
    public String langbridge_permission_dialog;
    public String loadingDurationInterval;
    public JSONObject loginUrl;
    public String needShowLoadingInterval;
    public String passAuthUrl;
    public String payConfigUrl;
    public String payHost;
    public String paymentCodeUrl;
    public String permission_dialog_audio;
    public String permission_dialog_camera;
    public String permission_dialog_contacts;
    public String permission_dialog_info;
    public String permission_dialog_location;
    public String permission_dialog_storage;
    public String polymerHost;
    public String quickBindCardUrl;
    public String sdk_permission_dialog;
    public String securityCenterUrl;
    public String setPayPwdUrl;
    public String takePicWaitTime;
    public String transactionRecordsUrl;
    public String transactionSchemeUrl;
    public String useH5BindCard;

    /* loaded from: classes11.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SdkInitResponse f62668a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2032074064, "Lcom/dxmpay/wallet/paysdk/datamodel/SdkInitResponse$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2032074064, "Lcom/dxmpay/wallet/paysdk/datamodel/SdkInitResponse$a;");
                    return;
                }
            }
            f62668a = new SdkInitResponse();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-654627763, "Lcom/dxmpay/wallet/paysdk/datamodel/SdkInitResponse;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-654627763, "Lcom/dxmpay/wallet/paysdk/datamodel/SdkInitResponse;");
        }
    }

    public SdkInitResponse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.jumpSwanApp = false;
        this.bankCardSchemeUrl = BeanConstants.SWAN_APP_BANK_CARD_SCHEME_URL;
        this.transactionSchemeUrl = BeanConstants.SWAN_APP_TRANSACTION_SCHEME_URL;
        this.balanceSchemeUrl = BeanConstants.SWAN_APP_BALANCE_SCHEME_URL;
        this.fp = "";
        this.kefuPhoneNum = "";
        this.passAuthUrl = "";
        this.takePicWaitTime = "";
        this.securityCenterUrl = "";
        this.payConfigUrl = "";
        this.setPayPwdUrl = "";
        this.findPayPwdUrl = "";
        this.bankCardListUrl = "";
        this.payHost = "";
        this.polymerHost = "";
        this.quickBindCardUrl = "";
        this.h5bindCardUrl = "";
        this.useH5BindCard = "";
        this.certWhiteList = "";
        this.domainSwitch = "";
        this.domainConfig = "";
        this.paymentCodeUrl = "";
        this.balanceHomeUrl = "";
        this.transactionRecordsUrl = "";
        this.cookiesSyncDomainList = "";
        this.needShowLoadingInterval = "";
        this.sdk_permission_dialog = "";
        this.langbridge_permission_dialog = "";
        this.permission_dialog_info = "";
        this.permission_dialog_contacts = "";
        this.permission_dialog_location = "";
        this.permission_dialog_camera = "";
        this.permission_dialog_audio = "";
        this.permission_dialog_storage = "";
        this.download_file = "";
        this.loadingDurationInterval = "";
    }

    public static SdkInitResponse getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f62668a : (SdkInitResponse) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public String getAppPayHost(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (TextUtils.isEmpty(this.payHost)) {
                this.payHost = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_app_pay_host", "");
            }
            return this.payHost;
        }
        return (String) invokeL.objValue;
    }

    public String getBalanceHomeUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (TextUtils.isEmpty(this.balanceHomeUrl)) {
                this.balanceHomeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59649d, "");
            }
            return this.balanceHomeUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getBankCardListUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (TextUtils.isEmpty(this.bankCardListUrl)) {
                this.bankCardListUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_bank_card_list_url", "");
            }
            return this.bankCardListUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getCookiesSyncDomainList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (TextUtils.isEmpty(this.cookiesSyncDomainList)) {
                this.cookiesSyncDomainList = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59650e, "");
            }
            return this.cookiesSyncDomainList;
        }
        return (String) invokeL.objValue;
    }

    public String getFindPayPwdUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (TextUtils.isEmpty(this.findPayPwdUrl)) {
                this.findPayPwdUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_find_pay_pwd_url", "");
            }
            return this.findPayPwdUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getH5BindCardUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            if (TextUtils.isEmpty(this.h5bindCardUrl)) {
                this.h5bindCardUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_h5_bind_card_url", "");
            }
            return this.h5bindCardUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getLoadingDurationInterval(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (TextUtils.isEmpty(this.loadingDurationInterval) && context != null) {
                this.loadingDurationInterval = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59652g, "");
            }
            return this.loadingDurationInterval;
        }
        return (String) invokeL.objValue;
    }

    public String getLoginUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            StatisticManager.onEvent("event_get_bindurl");
            JSONObject jSONObject = this.loginUrl;
            if (jSONObject == null) {
                return "";
            }
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String getPassAuthUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            String str = DomainConfig.getInstance().getAppPayHost() + "/content/resource/pass_normal/index.html";
            if (!TextUtils.isEmpty(a.f62668a.passAuthUrl)) {
                return a.f62668a.passAuthUrl;
            }
            String str2 = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59647b, "");
            return !TextUtils.isEmpty(str2) ? str2 : str;
        }
        return (String) invokeL.objValue;
    }

    public String getPayCodeUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            if (TextUtils.isEmpty(this.paymentCodeUrl)) {
                this.paymentCodeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59648c, "");
            }
            return this.paymentCodeUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getPayPwdSettingUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            if (TextUtils.isEmpty(this.setPayPwdUrl)) {
                this.setPayPwdUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_pwd_setting_url", "");
            }
            return this.setPayPwdUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getPaySecurityCenterUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            if (TextUtils.isEmpty(this.securityCenterUrl)) {
                this.securityCenterUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_security_center_url", "");
            }
            return this.securityCenterUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getPaySettingUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            if (TextUtils.isEmpty(this.payConfigUrl)) {
                this.payConfigUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_setting_url", "");
            }
            return this.payConfigUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getPolymerHost(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            if (TextUtils.isEmpty(this.polymerHost)) {
                this.polymerHost = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_polymer_host", "");
            }
            return this.polymerHost;
        }
        return (String) invokeL.objValue;
    }

    public String getQuickBindCardUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            if (TextUtils.isEmpty(this.quickBindCardUrl)) {
                this.quickBindCardUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_quick_bind_card_url", "");
            }
            return this.quickBindCardUrl;
        }
        return (String) invokeL.objValue;
    }

    public int getTakePicWaitTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (TextUtils.isEmpty(a.f62668a.takePicWaitTime)) {
                return 2000;
            }
            return Integer.valueOf(a.f62668a.takePicWaitTime).intValue();
        }
        return invokeV.intValue;
    }

    public String getTransactionRecordsUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, context)) == null) {
            if (TextUtils.isEmpty(this.transactionRecordsUrl)) {
                this.transactionRecordsUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59653h, "");
            }
            return this.transactionRecordsUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getUseH5BindCard(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) {
            if (TextUtils.isEmpty(this.useH5BindCard)) {
                this.useH5BindCard = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_use_h5_bind_card", "");
            }
            return this.useH5BindCard;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, context) == null) && f62667e) {
            f62667e = false;
            if (!TextUtils.isEmpty(this.fp)) {
                String decrypt = SecurePay.getInstance().decrypt(this.fp);
                if (!TextUtils.isEmpty(decrypt) && !decrypt.equals(BdWalletUtils.getDeviceFP(context))) {
                    BdWalletUtils.setDeviceFP(context, decrypt);
                }
            }
            if (!TextUtils.isEmpty(this.kefuPhoneNum)) {
                BdWalletUtils.setKefuPhoneNumToSP(context, this.kefuPhoneNum);
            }
            if (!TextUtils.isEmpty(this.passAuthUrl)) {
                a.f62668a.passAuthUrl = this.passAuthUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59647b, this.passAuthUrl);
            }
            a.f62668a.paymentCodeUrl = this.paymentCodeUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59648c, this.paymentCodeUrl);
            a.f62668a.transactionRecordsUrl = this.transactionRecordsUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59653h, this.transactionRecordsUrl);
            a.f62668a.balanceHomeUrl = this.balanceHomeUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59649d, this.balanceHomeUrl);
            a.f62668a.securityCenterUrl = this.securityCenterUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_security_center_url", this.securityCenterUrl);
            a.f62668a.payConfigUrl = this.payConfigUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_setting_url", this.payConfigUrl);
            a.f62668a.setPayPwdUrl = this.setPayPwdUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_pwd_setting_url", this.setPayPwdUrl);
            a.f62668a.findPayPwdUrl = this.findPayPwdUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_find_pay_pwd_url", this.findPayPwdUrl);
            a.f62668a.bankCardListUrl = this.bankCardListUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_bank_card_list_url", this.bankCardListUrl);
            a.f62668a.payHost = this.payHost;
            if (!TextUtils.isEmpty(this.payHost)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_app_pay_host", this.payHost);
            }
            a.f62668a.polymerHost = this.polymerHost;
            if (!TextUtils.isEmpty(this.polymerHost)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_polymer_host", this.polymerHost);
            }
            a.f62668a.quickBindCardUrl = this.quickBindCardUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_quick_bind_card_url", this.quickBindCardUrl);
            a.f62668a.useH5BindCard = this.useH5BindCard;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_use_h5_bind_card", this.useH5BindCard);
            a.f62668a.h5bindCardUrl = this.h5bindCardUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_h5_bind_card_url", this.h5bindCardUrl);
            a.f62668a.fp = this.fp;
            a.f62668a.kefuPhoneNum = this.kefuPhoneNum;
            a.f62668a.loginUrl = this.loginUrl;
            a.f62668a.certWhiteList = this.certWhiteList;
            a.f62668a.passAuthUrl = this.passAuthUrl;
            a.f62668a.domainSwitch = this.domainSwitch;
            a.f62668a.domainConfig = this.domainConfig;
            a.f62668a.paymentCodeUrl = this.paymentCodeUrl;
            a.f62668a.balanceHomeUrl = this.balanceHomeUrl;
            a.f62668a.transactionRecordsUrl = this.transactionRecordsUrl;
            a.f62668a.takePicWaitTime = this.takePicWaitTime;
            a.f62668a.cookiesSyncDomainList = this.cookiesSyncDomainList;
            a.f62668a.sdk_permission_dialog = this.sdk_permission_dialog;
            a.f62668a.langbridge_permission_dialog = this.langbridge_permission_dialog;
            a.f62668a.permission_dialog_info = this.permission_dialog_info;
            a.f62668a.permission_dialog_contacts = this.permission_dialog_contacts;
            a.f62668a.permission_dialog_location = this.permission_dialog_location;
            a.f62668a.permission_dialog_camera = this.permission_dialog_camera;
            a.f62668a.permission_dialog_audio = this.permission_dialog_audio;
            a.f62668a.permission_dialog_storage = this.permission_dialog_storage;
            a.f62668a.securityCenterUrl = this.securityCenterUrl;
            a.f62668a.payConfigUrl = this.payConfigUrl;
            a.f62668a.setPayPwdUrl = this.setPayPwdUrl;
            a.f62668a.findPayPwdUrl = this.findPayPwdUrl;
            a.f62668a.bankCardListUrl = this.bankCardListUrl;
            a.f62668a.download_file = this.download_file;
            a.f62668a.quickBindCardUrl = this.quickBindCardUrl;
            a.f62668a.useH5BindCard = this.useH5BindCard;
            a.f62668a.h5bindCardUrl = this.h5bindCardUrl;
            if (!TextUtils.isEmpty(this.cookiesSyncDomainList)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59650e, this.cookiesSyncDomainList);
            }
            a.f62668a.needShowLoadingInterval = this.needShowLoadingInterval;
            a.f62668a.loadingDurationInterval = this.loadingDurationInterval;
            if (TextUtils.isEmpty(this.loadingDurationInterval)) {
                return;
            }
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.f59652g, this.loadingDurationInterval);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "sdk-init:\n\tfp:" + this.fp + "\n\tkefuPhoneNum:" + this.kefuPhoneNum + "\n\tcertWhiteList:" + this.certWhiteList + "\n\tloginUrl:" + this.loginUrl + "\n\tpassAuthUrl:" + this.passAuthUrl + "\n\tdomainSwitch:" + this.domainSwitch + "\n\tdomainConfig:" + this.domainConfig + "\n\tpaymentCodeUrl:" + this.paymentCodeUrl + "\n\tbalanceHomeUrl:" + this.balanceHomeUrl + "\n\ttransactionRecordsUrl:" + this.transactionRecordsUrl + "\n\tcookiesSyncDomainList:" + this.cookiesSyncDomainList + "\n\tneedShowLoadingInterval:" + this.needShowLoadingInterval + "\n\tloadingDurationInterval:" + this.loadingDurationInterval + "\n\tsecurityCenterUrl:" + this.securityCenterUrl + "\n\tpayConfigUrl:" + this.payConfigUrl + "\n\tsetPayPwdUrl:" + this.setPayPwdUrl + "\n\tfindPayPwdUrl:" + this.findPayPwdUrl + "\n\tbankCardListUrl:" + this.bankCardListUrl + "\n\tquickBindCardUrl:" + this.quickBindCardUrl + "\n\tuseH5BindCard:" + this.useH5BindCard + "\n\th5bindCardUrl:" + this.h5bindCardUrl;
        }
        return (String) invokeV.objValue;
    }
}
