package com.dxmpay.wallet.paysdk;

import android.content.Context;
import android.text.TextUtils;
import c.f.a.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.DebugConfig;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SDKInitBeanCallBack implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f70248f = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f70249e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1390622903, "Lcom/dxmpay/wallet/paysdk/SDKInitBeanCallBack;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1390622903, "Lcom/dxmpay/wallet/paysdk/SDKInitBeanCallBack;");
        }
    }

    public SDKInitBeanCallBack(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70249e = context;
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) && f70248f) {
            f70248f = false;
            if (obj instanceof SdkInitResponse) {
                SdkInitResponse sdkInitResponse = (SdkInitResponse) obj;
                if (!TextUtils.isEmpty(sdkInitResponse.domainConfig)) {
                    try {
                        new JSONObject(sdkInitResponse.domainConfig);
                        z = true;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        z = false;
                    }
                    if (z) {
                        if (DebugConfig.getInstance().isOnline()) {
                            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, sdkInitResponse.domainConfig);
                            SharedPreferencesUtils.setParam(this.f70249e.getApplicationContext(), BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, "wallet_sdk_domain_config_key", sdkInitResponse.domainConfig);
                        } else {
                            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, sdkInitResponse.domainConfig);
                            SharedPreferencesUtils.setParam(this.f70249e.getApplicationContext(), BeanConstants.DOMAIN_CONFIG_NAME_QA, "wallet_sdk_domain_config_key", sdkInitResponse.domainConfig);
                        }
                    }
                }
                if (!TextUtils.isEmpty(sdkInitResponse.domainSwitch)) {
                    if (TextUtils.equals("1", sdkInitResponse.domainSwitch)) {
                        if (DebugConfig.getInstance().isOnline()) {
                            SharedPreferencesUtils.setParam(this.f70249e.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.TRUE);
                        } else {
                            SharedPreferencesUtils.setParam(this.f70249e.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.TRUE);
                        }
                        a.i().h(true);
                    } else {
                        if (DebugConfig.getInstance().isOnline()) {
                            SharedPreferencesUtils.setParam(this.f70249e.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE);
                        } else {
                            SharedPreferencesUtils.setParam(this.f70249e.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE);
                        }
                        a.i().h(false);
                    }
                }
                EventBus eventBus = EventBus.getInstance();
                EventBus eventBus2 = EventBus.getInstance();
                eventBus2.getClass();
                eventBus.postStickyEvent(new EventBus.Event(eventBus2, BeanConstants.SDKINIT_EVENTBUS_EVENTKEY, null));
            }
        }
    }
}
