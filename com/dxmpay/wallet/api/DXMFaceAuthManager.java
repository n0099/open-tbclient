package com.dxmpay.wallet.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.f.a.d.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.dxmpay.statistics.StatApi;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.ChannelUtils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.DebugConfig;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.statistics.impl.SensorsSyncHttpImpl;
import com.dxmpay.wallet.statistics.impl.StatConfig;
/* loaded from: classes3.dex */
public class DXMFaceAuthManager implements IFaceAuthAPI {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final DXMFaceAuthManager instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1741742804, "Lcom/dxmpay/wallet/api/DXMFaceAuthManager$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1741742804, "Lcom/dxmpay/wallet/api/DXMFaceAuthManager$SingletonHolder;");
                    return;
                }
            }
            instance = new DXMFaceAuthManager();
        }

        public SingletonHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public static DXMFaceAuthManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? SingletonHolder.instance : (DXMFaceAuthManager) invokeV.objValue;
    }

    private void initDomain(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            if (DebugConfig.getInstance().isOnline()) {
                DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, "wallet_sdk_domain_config_key", ""));
                if (((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE)).booleanValue()) {
                    a.i().h(true);
                    return;
                }
                return;
            }
            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_QA, "wallet_sdk_domain_config_key", ""));
            if (((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE)).booleanValue()) {
                a.i().h(true);
            }
        }
    }

    private void initStatAndLoadFp(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            new Thread(new Runnable(this, context) { // from class: com.dxmpay.wallet.api.DXMFaceAuthManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DXMFaceAuthManager this$0;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && SecurePay.getInstance().prepareCompleted()) {
                        StatApi.init(this.val$context.getApplicationContext(), StatConfig.getInstance(this.val$context.getApplicationContext()));
                        StatApi.setSyncHttpImpl(new SensorsSyncHttpImpl());
                    }
                }
            }, "DxmPaySDK").start();
        }
    }

    private void initUA(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            BeanConstants.CHANNEL_ID = str;
            String str2 = "BaiduWallet-" + BeanConstants.VERSION_NO + "-Android-" + BeanConstants.CHANNEL_ID;
            BeanConstants.SDK_VERSION = str2;
            ChannelUtils.initBussinessParams(str2, false);
        }
    }

    @Override // com.dxmpay.wallet.api.IFaceAuthAPI
    public void initFaceAuth(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("The channel ID can not be empty.");
            }
            if (context != null) {
                initUA(str);
                initDomain(context);
                initStatAndLoadFp(context);
                return;
            }
            throw new IllegalArgumentException("The context can not be empty.");
        }
    }

    public void setDebugOn(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, z) == null) {
            if (z) {
                DebugConfig.getInstance(context).changeQA();
            } else {
                DebugConfig.getInstance(context).changeOnline();
            }
        }
    }

    public DXMFaceAuthManager() {
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
}
