package com.dxmpay.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletLoginListener;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.widget.LoadingActivity;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.MainHandler;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class PassLoginUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOGIN_STATUS_ERROR_CODE = 603;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile OpenBdussResult f70217a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownTimer f70218b;

    /* renamed from: c  reason: collision with root package name */
    public CountDownTimer f70219c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f70220d;

    /* renamed from: e  reason: collision with root package name */
    public long f70221e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70222f;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f70223e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f70224f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PassLoginUtil f70225g;

        public a(PassLoginUtil passLoginUtil, boolean z, ILoginBackListener iLoginBackListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLoginUtil, Boolean.valueOf(z), iLoginBackListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70225g = passLoginUtil;
            this.f70223e = z;
            this.f70224f = iLoginBackListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70225g.g(this.f70223e, this.f70224f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f70226a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f70227b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PassLoginUtil f70228c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PassLoginUtil passLoginUtil, long j2, long j3, ILoginBackListener iLoginBackListener, boolean z) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {passLoginUtil, Long.valueOf(j2), Long.valueOf(j3), iLoginBackListener, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70228c = passLoginUtil;
            this.f70226a = iLoginBackListener;
            this.f70227b = z;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70228c.o();
                this.f70228c.setIntervalDuration(-1L);
                ILoginBackListener iLoginBackListener = this.f70226a;
                if ((iLoginBackListener instanceof LoginBackListenerProxy) && this.f70227b) {
                    Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                    ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.f70226a).getLoginBackListener();
                    if (loginBackListener != null) {
                        if (context != null && this.f70228c.f70222f) {
                            GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_error"));
                        }
                        this.f70228c.setErrorCodeSwitchFlag(true);
                        this.f70228c.f70220d = true;
                        loginBackListener.onFail(601, context != null ? ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_error") : "");
                    }
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f70229a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f70230b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PassLoginUtil f70231c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PassLoginUtil passLoginUtil, long j2, long j3, boolean z, ILoginBackListener iLoginBackListener) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {passLoginUtil, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), iLoginBackListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70231c = passLoginUtil;
            this.f70229a = z;
            this.f70230b = iLoginBackListener;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70231c.setIntervalDuration(-1L);
                if (this.f70231c.f70217a == null && this.f70229a) {
                    ILoginBackListener iLoginBackListener = this.f70230b;
                    if (iLoginBackListener instanceof LoginBackListenerProxy) {
                        this.f70231c.c(((LoginBackListenerProxy) iLoginBackListener).getContext());
                    }
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends GetOpenBdussCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f70232e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f70233f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PassLoginUtil f70234g;

        public d(PassLoginUtil passLoginUtil, ILoginBackListener iLoginBackListener, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLoginUtil, iLoginBackListener, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70234g = passLoginUtil;
            this.f70232e = iLoginBackListener;
            this.f70233f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onSuccess(OpenBdussResult openBdussResult) {
            Map<String, String> map;
            Map<String, String> map2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, openBdussResult) == null) {
                this.f70234g.i();
                this.f70234g.o();
                this.f70234g.setIntervalDuration(-1L);
                if (openBdussResult != null) {
                    StatisticManager.onEventEnd("DXMGetOpenbduss", openBdussResult.getResultCode());
                    if (this.f70234g.f70220d) {
                        this.f70234g.m();
                        return;
                    }
                    this.f70234g.f70217a = openBdussResult;
                    ILoginBackListener iLoginBackListener = this.f70232e;
                    if (iLoginBackListener instanceof LoginBackListenerProxy) {
                        Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.f70232e).getLoginBackListener();
                        if (!TextUtils.isEmpty(openBdussResult.openBduss) && !TextUtils.isEmpty(openBdussResult.unionid) && (map2 = openBdussResult.tplStokenMap) != null && !TextUtils.isEmpty(map2.get(WalletLoginHelper.getInstance().getTpl()))) {
                            c.f.b.d.a.a().d(openBdussResult.openBduss);
                            if (loginBackListener != null) {
                                this.f70234g.setErrorCodeSwitchFlag(true);
                                loginBackListener.onSuccess(2, openBdussResult.openBduss);
                            }
                        } else if (context == null || loginBackListener == null) {
                        } else {
                            if (this.f70233f && this.f70234g.f70222f) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                            }
                            this.f70234g.setErrorCodeSwitchFlag(true);
                            StatisticManager.onEvent("DXMGetOpenbdussSuccessNoUserInfo");
                            loginBackListener.onFail(602, openBdussResult.getResultMsg());
                        }
                    } else if (TextUtils.isEmpty(openBdussResult.openBduss) || TextUtils.isEmpty(openBdussResult.unionid) || (map = openBdussResult.tplStokenMap) == null || TextUtils.isEmpty(map.get(WalletLoginHelper.getInstance().getTpl()))) {
                    } else {
                        c.f.b.d.a.a().d(openBdussResult.openBduss);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onFailure(OpenBdussResult openBdussResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, openBdussResult) == null) {
                this.f70234g.i();
                this.f70234g.o();
                this.f70234g.setIntervalDuration(-1L);
                if (openBdussResult != null) {
                    StatisticManager.onEventEnd("DXMGetOpenbduss", openBdussResult.getResultCode());
                    if (this.f70234g.f70220d) {
                        this.f70234g.m();
                        return;
                    }
                    this.f70234g.logout(false);
                    ILoginBackListener iLoginBackListener = this.f70232e;
                    if (iLoginBackListener instanceof LoginBackListenerProxy) {
                        Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.f70232e).getLoginBackListener();
                        if (loginBackListener != null) {
                            if (openBdussResult.getResultCode() != 2 && openBdussResult.getResultCode() != 6 && openBdussResult.getResultCode() != -901) {
                                if (openBdussResult.getResultCode() == -203) {
                                    if (context != null && this.f70233f && this.f70234g.f70222f) {
                                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_ssl_error"));
                                    }
                                    this.f70234g.setErrorCodeSwitchFlag(true);
                                    loginBackListener.onFail(605, openBdussResult.getResultMsg());
                                    return;
                                } else if (openBdussResult.getResultCode() != -201 && openBdussResult.getResultCode() != -202) {
                                    if (openBdussResult.getResultCode() != 3 && openBdussResult.getResultCode() != 4 && openBdussResult.getResultCode() != 7) {
                                        if (openBdussResult.getResultCode() == 1) {
                                            if (context != null && this.f70233f && this.f70234g.f70222f) {
                                                this.f70234g.setErrorCodeSwitchFlag(true);
                                                try {
                                                    PassLoginDialogUtil.getInstance().showLoginTipDialog(context, this.f70232e, 604, openBdussResult.getResultMsg());
                                                    return;
                                                } catch (Exception e2) {
                                                    LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                                                    GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                                                    loginBackListener.onFail(604, openBdussResult.getResultMsg());
                                                    return;
                                                }
                                            }
                                            this.f70234g.setErrorCodeSwitchFlag(true);
                                            loginBackListener.onFail(604, openBdussResult.getResultMsg());
                                            return;
                                        }
                                        if (context != null && this.f70233f && this.f70234g.f70222f) {
                                            GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                                        }
                                        this.f70234g.setErrorCodeSwitchFlag(true);
                                        loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                        return;
                                    }
                                    if (context != null && this.f70233f && this.f70234g.f70222f) {
                                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                                    }
                                    this.f70234g.setErrorCodeSwitchFlag(true);
                                    loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                    return;
                                } else {
                                    if (context != null && this.f70233f && this.f70234g.f70222f) {
                                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_error"));
                                    }
                                    this.f70234g.setErrorCodeSwitchFlag(true);
                                    loginBackListener.onFail(601, openBdussResult.getResultMsg());
                                    return;
                                }
                            }
                            loginBackListener.onFail(603, openBdussResult.getResultMsg());
                        }
                    }
                }
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final PassLoginUtil f70235a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-998364851, "Lcom/dxmpay/wallet/passport/PassLoginUtil$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-998364851, "Lcom/dxmpay/wallet/passport/PassLoginUtil$e;");
                    return;
                }
            }
            f70235a = new PassLoginUtil(null);
        }
    }

    public /* synthetic */ PassLoginUtil(a aVar) {
        this();
    }

    public static PassLoginUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? e.f70235a : (PassLoginUtil) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f70217a = null;
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || context == null) {
            return;
        }
        Intent intent = new Intent(context, LoadingActivity.class);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
            return;
        }
        intent.addFlags(268435456);
        context.getApplicationContext().startActivity(intent);
    }

    public final void g(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, iLoginBackListener) == null) {
            i();
            b();
            q(z, iLoginBackListener);
        }
    }

    public synchronized Map<String, String> getLoginData(Context context, String str) {
        InterceptResult invokeLL;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            synchronized (this) {
                hashMap = new HashMap();
                if (isLogin()) {
                    if (!TextUtils.isEmpty(this.f70217a.uid)) {
                        hashMap.put("pass_uid", this.f70217a.uid);
                    }
                    if (!TextUtils.isEmpty(this.f70217a.bduss)) {
                        hashMap.put("pass_bduss", this.f70217a.bduss);
                    }
                    if (!TextUtils.isEmpty(this.f70217a.displayname)) {
                        hashMap.put("pass_user_name", this.f70217a.displayname);
                    }
                    if (!TextUtils.isEmpty(this.f70217a.openBduss)) {
                        hashMap.put("pass_open_bduss", this.f70217a.openBduss);
                    }
                    if (!TextUtils.isEmpty(this.f70217a.unionid)) {
                        hashMap.put("pass_union_id", this.f70217a.unionid);
                    }
                    if (this.f70217a.tplStokenMap != null && !TextUtils.isEmpty(this.f70217a.tplStokenMap.get(str))) {
                        hashMap.put("pass_stoken", this.f70217a.tplStokenMap.get(str));
                    }
                    hashMap.put(IWalletLoginListener.KEY_LOGIN_TYPE, "0");
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public synchronized String getLoginOpenToken() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                str = isLogin() ? this.f70217a.openBduss : "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized String getLoginStoken(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this) {
                str2 = isLogin() ? this.f70217a.tplStokenMap.get(str) : null;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public synchronized String getLoginToken() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                str = "";
                if (isPassLogin() && this.f70217a != null && !TextUtils.isEmpty(this.f70217a.bduss)) {
                    str = this.f70217a.bduss;
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, iLoginBackListener) == null) {
            synchronized (this) {
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    MainHandler.getInstance().post(new a(this, z, iLoginBackListener));
                } else {
                    g(z, iLoginBackListener);
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            CountDownTimer countDownTimer = this.f70218b;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f70218b = null;
            }
            CountDownTimer countDownTimer2 = this.f70219c;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
                this.f70219c = null;
            }
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public synchronized boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                boolean z = false;
                if (SapiAccountManager.getInstance().isLogin()) {
                    if (this.f70217a != null && !TextUtils.isEmpty(this.f70217a.openBduss) && !TextUtils.isEmpty(this.f70217a.unionid) && this.f70217a.tplStokenMap != null) {
                        if (!TextUtils.isEmpty(this.f70217a.tplStokenMap.get(WalletLoginHelper.getInstance().getTpl()))) {
                            z = true;
                        }
                    }
                    return z;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isPassLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? SapiAccountManager.getInstance().isLogin() : invokeV.booleanValue;
    }

    public final void j(boolean z, ILoginBackListener iLoginBackListener) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048588, this, z, iLoginBackListener) == null) && z) {
            m();
            boolean z2 = iLoginBackListener instanceof LoginBackListenerProxy;
            long j2 = com.baidu.wallet.passport.PassLoginUtil.f62552c;
            if (z2 && (context = ((LoginBackListenerProxy) iLoginBackListener).getContext()) != null && !TextUtils.isEmpty(SdkInitResponse.getInstance().getLoadingDurationInterval(context))) {
                try {
                    long parseLong = Long.parseLong(SdkInitResponse.getInstance().getLoadingDurationInterval(context));
                    if (parseLong >= 0) {
                        j2 = parseLong;
                    }
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
            long j3 = j2;
            b bVar = new b(this, j3, j3, iLoginBackListener, z);
            this.f70219c = bVar;
            bVar.start();
        }
    }

    public synchronized void logout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                SapiAccountManager.getInstance().logout();
                c.f.b.d.a.a().e();
                b();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f70220d = false;
        }
    }

    public final void n(boolean z, ILoginBackListener iLoginBackListener) {
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048592, this, z, iLoginBackListener) == null) && z) {
            long j3 = this.f70221e;
            long j4 = 300;
            if (j3 < 0) {
                if (!TextUtils.isEmpty(SdkInitResponse.getInstance().needShowLoadingInterval)) {
                    try {
                        long parseLong = Long.parseLong(SdkInitResponse.getInstance().needShowLoadingInterval);
                        if (parseLong >= 0) {
                            j4 = parseLong;
                        }
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
                j2 = j4;
            } else {
                j2 = j3;
            }
            c cVar = new c(this, j2, j2, z, iLoginBackListener);
            this.f70218b = cVar;
            cVar.start();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            LoadingActivity.exitLoading();
        }
    }

    public final void q(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048594, this, z, iLoginBackListener) == null) {
            j(z, iLoginBackListener);
            n(z, iLoginBackListener);
            GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
            getOpenBdussDTO.clientId = "fHUnn02XwCrywmmdUtCdK6eC";
            getOpenBdussDTO.targetTplList.add(WalletLoginHelper.getInstance().getTpl());
            StatisticManager.onEventStart("DXMGetOpenbduss");
            SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new d(this, iLoginBackListener, z));
        }
    }

    public synchronized void setErrorCodeSwitchFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            synchronized (this) {
                this.f70222f = z;
            }
        }
    }

    public synchronized void setIntervalDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            synchronized (this) {
                this.f70221e = j2;
            }
        }
    }

    public PassLoginUtil() {
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
        this.f70220d = false;
        this.f70221e = -1L;
        this.f70222f = true;
    }

    public synchronized void logout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            synchronized (this) {
                if (z) {
                    SapiAccountManager.getInstance().logout();
                }
                c.f.b.d.a.a().e();
                b();
            }
        }
    }
}
