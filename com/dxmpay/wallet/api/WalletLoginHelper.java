package com.dxmpay.wallet.api;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletListener;
import com.baidu.wallet.api.IWalletListener2;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.api.IWalletStoken;
import com.baidu.wallet.api.WalletApiExtListener;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.passport.LoginImpl;
import com.dxmpay.wallet.passport.PassLoginUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class WalletLoginHelper implements IWalletLoginListener, IWalletStoken, WalletApiExtListener.LoginstatuSyncListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DYNAMIC_CALL_PASS_TYPE_ALL = 28;
    public static final int DYNAMIC_CALL_PASS_TYPE_BDUSS = 27;
    public static final int DYNAMIC_CALL_PASS_TYPE_UID = 26;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f69340e;

    /* renamed from: f  reason: collision with root package name */
    public IWalletLoginListener f69341f;

    /* renamed from: g  reason: collision with root package name */
    public Context f69342g;

    /* renamed from: h  reason: collision with root package name */
    public IWalletListener f69343h;

    /* renamed from: i  reason: collision with root package name */
    public WalletApiExtListener.LoginstatuSyncListener f69344i;

    /* loaded from: classes9.dex */
    public class a extends PASSMethodCallTransfer.DynamicCallbak {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(WalletLoginHelper walletLoginHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {walletLoginHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.sapi2.openbduss.PASSMethodCallTransfer.DynamicCallbak
        public void onFailure(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                LogUtil.errord("PASS", "DYNAMIC CALL PASS FAILED ERROR MSG: " + i2 + " , " + str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends PASSMethodCallTransfer.DynamicCallbak {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(WalletLoginHelper walletLoginHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {walletLoginHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.sapi2.openbduss.PASSMethodCallTransfer.DynamicCallbak
        public void onFailure(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                LogUtil.errord("PASS", "DYNAMIC CALL PASS FAILED ERROR MSG: " + i2 + " , " + str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements WalletApiExtListener.SyncLoginStatusCb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WalletLoginHelper f69345a;

        public c(WalletLoginHelper walletLoginHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {walletLoginHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69345a = walletLoginHelper;
        }

        @Override // com.baidu.wallet.api.WalletApiExtListener.SyncLoginStatusCb
        public void onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult syncResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, syncResult) == null) {
                String unused = this.f69345a.f69340e;
                String str = "syncH5login onResult code = " + syncResult;
                StatisticManager.onEventWithValue("DXMSyncH5LoginState", String.valueOf(syncResult.getVal()));
                if (syncResult == WalletApiExtListener.SyncLoginStatusCb.SyncResult.SUCCESS) {
                    WalletLoginHelper.getInstance().getOpenBduss(false, null);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final WalletLoginHelper f69346a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(417405314, "Lcom/dxmpay/wallet/api/WalletLoginHelper$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(417405314, "Lcom/dxmpay/wallet/api/WalletLoginHelper$d;");
                    return;
                }
            }
            f69346a = new WalletLoginHelper(null);
        }
    }

    public /* synthetic */ WalletLoginHelper(a aVar) {
        this();
    }

    public static final WalletLoginHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.f69346a : (WalletLoginHelper) invokeV.objValue;
    }

    public final PASSMethodCallTransfer.ParamsWap a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            PASSMethodCallTransfer.ParamsWap paramsWap = new PASSMethodCallTransfer.ParamsWap();
            paramsWap.param = "";
            HashMap hashMap = new HashMap();
            paramsWap.attributes = hashMap;
            if (i2 == 26) {
                hashMap.put(PASSMethodCallTransfer.ParamsWap.UID, "uid");
            } else if (i2 == 27) {
                hashMap.put(PASSMethodCallTransfer.ParamsWap.BDUSS, "bduss");
            } else {
                hashMap.put(PASSMethodCallTransfer.ParamsWap.UID, "uid");
            }
            return paramsWap;
        }
        return (PASSMethodCallTransfer.ParamsWap) invokeI.objValue;
    }

    public void clearOpenBduss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            logout(false);
        }
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, String str, Class<?>[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{obj, objArr, Integer.valueOf(i2), Integer.valueOf(i3), str, clsArr}) == null) {
            objArr[i3] = a(i2);
            new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new a(this), clsArr);
        }
    }

    public int getBdussState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SapiAccountManager.getInstance().getAccountService().getBdussState() : invokeV.intValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    @Deprecated
    public Map<String, String> getLoginData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f69341f;
            if (iWalletLoginListener == null) {
                return Collections.emptyMap();
            }
            return iWalletLoginListener.getLoginData(str);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    @Deprecated
    public String getLoginStoken(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f69341f;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().getLoginStoken(str);
            }
            return iWalletLoginListener.getLoginStoken(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getLoginToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f69341f;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().getLoginToken();
            }
            return iWalletLoginListener.getLoginToken();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public int getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, iLoginBackListener) == null) {
            IWalletLoginListener iWalletLoginListener = this.f69341f;
            if (iWalletLoginListener == null) {
                PassLoginUtil.getInstance().getOpenBduss(z, iLoginBackListener);
            } else {
                iWalletLoginListener.getOpenBduss(z, iLoginBackListener);
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), iLoginBackListener, Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getOpenLoginToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f69341f;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().getLoginOpenToken();
            }
            return iWalletLoginListener.getOpenLoginToken();
        }
        return (String) invokeV.objValue;
    }

    public String getPassUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Map<String, String> loginData = getLoginData();
            if (loginData != null) {
                return loginData.get("pass_uid");
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getPassUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Map<String, String> loginData = getLoginData();
            if (loginData != null) {
                return loginData.get("pass_user_name");
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public WalletApiExtListener.LoginstatuSyncListener getSyncLoginListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f69344i : (WalletApiExtListener.LoginstatuSyncListener) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public String getTpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "walletapp".equals(BeanConstants.CHANNEL_ID) ? "baiduwalletapp" : "bdwalletsdk" : (String) invokeV.objValue;
    }

    public String getUnionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            try {
                Map<String, String> loginData = getLoginData();
                if (loginData != null) {
                    return loginData.get("pass_union_id");
                }
                return null;
            } catch (Exception e2) {
                e2.getMessage();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void handlerWalletError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            StatisticManager.onEvent("#handlerWalletError");
            onHandleWalletError(i2);
            IWalletLoginListener iWalletLoginListener = this.f69341f;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.handlerWalletError(i2);
            }
        }
    }

    public void init(Context context, IWalletListener iWalletListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, iWalletListener) == null) {
            this.f69343h = iWalletListener;
            this.f69341f = new LoginImpl(context);
            PassLoginUtil.getInstance().init();
            this.f69342g = context.getApplicationContext();
        }
    }

    public boolean isInnerPassLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f69341f;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().isLogin();
            }
            return iWalletLoginListener.isLogin();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isPassLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f69341f;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().isPassLogin();
            }
            return iWalletLoginListener.isPassLogin();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public void login(ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onSuccess(0, "");
                }
            } else if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f69341f;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener);
                }
            } else {
                IWalletListener iWalletListener = this.f69343h;
                if (iWalletListener != null) {
                    iWalletListener.login(iLoginBackListener);
                } else if (iLoginBackListener != null) {
                    iLoginBackListener.onFail(-1, "");
                }
            }
        }
    }

    public void logout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            PassLoginUtil.getInstance().logout();
        }
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onHandleWalletError(int i2) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || (loginstatuSyncListener = this.f69344i) == null) {
            return;
        }
        loginstatuSyncListener.onHandleWalletError(i2);
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void onLoginChanaged(Context context, Map<String, String> map) {
        IWalletLoginListener iWalletLoginListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, context, map) == null) || (iWalletLoginListener = this.f69341f) == null) {
            return;
        }
        iWalletLoginListener.onLoginChanaged(context, map);
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onWebViewLogout(Context context) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, context) == null) || (loginstatuSyncListener = this.f69344i) == null) {
            return;
        }
        loginstatuSyncListener.onWebViewLogout(context);
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, iLoginBackListener, str) == null) {
            clearOpenBduss();
            if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f69341f;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener, str);
                    return;
                }
                return;
            }
            IWalletListener iWalletListener = this.f69343h;
            if (iWalletListener == null) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onFail(-1, "");
                }
            } else if (iWalletListener instanceof IWalletListener2) {
                ((IWalletListener2) iWalletListener).login(iLoginBackListener, str);
            } else {
                iWalletListener.login(iLoginBackListener);
            }
        }
    }

    public void setIntervalDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j2) == null) {
            PassLoginUtil.getInstance().setIntervalDuration(j2);
        }
    }

    public void setLoginSyncListener(WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, loginstatuSyncListener) == null) {
            this.f69344i = loginstatuSyncListener;
        }
    }

    public void setOpenBdussErrorCodeShowFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            PassLoginUtil.getInstance().setErrorCodeSwitchFlag(z);
        }
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public boolean startPage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            if (this.f69342g == null) {
                return false;
            }
            StatisticManager.onEvent("#startPage");
            if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f69341f;
                if (iWalletLoginListener != null && !iWalletLoginListener.startPage(str)) {
                    BaiduWalletDelegate.getInstance().openH5Module(this.f69342g, str, true);
                }
            } else {
                IWalletListener iWalletListener = this.f69343h;
                if (iWalletListener != null) {
                    if (!iWalletListener.startPage(str)) {
                        BaiduWalletDelegate.getInstance().openH5Module(this.f69342g, str, true);
                    }
                } else {
                    Context context = this.f69342g;
                    GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_load_fail"));
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void syncH5LoginStatus(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, context) == null) {
            int bdussState = SapiAccountManager.getInstance().getAccountService().getBdussState();
            if (bdussState == 2 || bdussState == 4) {
                syncLoginStatus(context, "", new c(this));
            } else if (bdussState == 3) {
                StatisticManager.onEvent("#invokePassLogout");
                onWebViewLogout(context);
                logout();
                AccountManager.getInstance(context).logout();
            }
        }
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void syncLoginStatus(Context context, String str, WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048614, this, context, str, syncLoginStatusCb) == null) || (loginstatuSyncListener = this.f69344i) == null) {
            return;
        }
        loginstatuSyncListener.syncLoginStatus(context, str, syncLoginStatusCb);
    }

    public void verifyPassLogin(ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                getOpenBduss(true, iLoginBackListener);
            } else if (iLoginBackListener != null) {
                iLoginBackListener.onFail(-1, "");
            }
        }
    }

    public WalletLoginHelper() {
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
        this.f69340e = WalletLoginHelper.class.getSimpleName();
    }

    public void logout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            PassLoginUtil.getInstance().logout(z);
        }
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public Map<String, String> getLoginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f69341f;
            if (iWalletLoginListener == null) {
                return Collections.emptyMap();
            }
            return iWalletLoginListener.getLoginData(getTpl());
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public String getLoginStoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f69341f;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().getLoginStoken(getTpl());
            }
            return iWalletLoginListener.getLoginStoken(getTpl());
        }
        return (String) invokeV.objValue;
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, int i4, String str, Class<?>[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{obj, objArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, clsArr}) == null) {
            if (i2 == 28) {
                objArr[i3] = a(26);
                objArr[i4] = a(27);
            }
            new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new b(this), clsArr);
        }
    }

    public void verifyPassLogin(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048616, this, z, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                getOpenBduss(z, iLoginBackListener);
            } else if (iLoginBackListener != null) {
                iLoginBackListener.onFail(-1, "未登录");
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletHostListener2
    public void login(ILoginBackListener iLoginBackListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, iLoginBackListener, str) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onSuccess(0, "");
                }
            } else if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f69341f;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener, str);
                }
            } else {
                IWalletListener iWalletListener = this.f69343h;
                if (iWalletListener == null) {
                    if (iLoginBackListener != null) {
                        iLoginBackListener.onFail(-1, "");
                    }
                } else if (iWalletListener instanceof IWalletListener2) {
                    ((IWalletListener2) iWalletListener).login(iLoginBackListener, str);
                } else {
                    iWalletListener.login(iLoginBackListener);
                }
            }
        }
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f69341f;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener);
                    return;
                }
                return;
            }
            IWalletListener iWalletListener = this.f69343h;
            if (iWalletListener == null) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onFail(-1, "");
                }
            } else if (iWalletListener instanceof IWalletListener2) {
                ((IWalletListener2) iWalletListener).login(iLoginBackListener);
            } else {
                iWalletListener.login(iLoginBackListener);
            }
        }
    }
}
