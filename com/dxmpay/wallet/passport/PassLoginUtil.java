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
/* loaded from: classes11.dex */
public class PassLoginUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOGIN_STATUS_ERROR_CODE = 603;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile OpenBdussResult f62633a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownTimer f62634b;

    /* renamed from: c  reason: collision with root package name */
    public CountDownTimer f62635c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62636d;

    /* renamed from: e  reason: collision with root package name */
    public long f62637e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62638f;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f62639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f62640f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PassLoginUtil f62641g;

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
            this.f62641g = passLoginUtil;
            this.f62639e = z;
            this.f62640f = iLoginBackListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62641g.g(this.f62639e, this.f62640f);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f62642a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f62643b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PassLoginUtil f62644c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PassLoginUtil passLoginUtil, long j, long j2, ILoginBackListener iLoginBackListener, boolean z) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {passLoginUtil, Long.valueOf(j), Long.valueOf(j2), iLoginBackListener, Boolean.valueOf(z)};
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
            this.f62644c = passLoginUtil;
            this.f62642a = iLoginBackListener;
            this.f62643b = z;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62644c.o();
                this.f62644c.setIntervalDuration(-1L);
                ILoginBackListener iLoginBackListener = this.f62642a;
                if ((iLoginBackListener instanceof LoginBackListenerProxy) && this.f62643b) {
                    Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                    ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.f62642a).getLoginBackListener();
                    if (loginBackListener != null) {
                        if (context != null && this.f62644c.f62638f) {
                            GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_error"));
                        }
                        this.f62644c.setErrorCodeSwitchFlag(true);
                        this.f62644c.f62636d = true;
                        loginBackListener.onFail(601, context != null ? ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_error") : "");
                    }
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f62645a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f62646b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PassLoginUtil f62647c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PassLoginUtil passLoginUtil, long j, long j2, boolean z, ILoginBackListener iLoginBackListener) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {passLoginUtil, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), iLoginBackListener};
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
            this.f62647c = passLoginUtil;
            this.f62645a = z;
            this.f62646b = iLoginBackListener;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62647c.setIntervalDuration(-1L);
                if (this.f62647c.f62633a == null && this.f62645a) {
                    ILoginBackListener iLoginBackListener = this.f62646b;
                    if (iLoginBackListener instanceof LoginBackListenerProxy) {
                        this.f62647c.c(((LoginBackListenerProxy) iLoginBackListener).getContext());
                    }
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d extends GetOpenBdussCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f62648e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f62649f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PassLoginUtil f62650g;

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
            this.f62650g = passLoginUtil;
            this.f62648e = iLoginBackListener;
            this.f62649f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onSuccess(OpenBdussResult openBdussResult) {
            Map<String, String> map;
            Map<String, String> map2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, openBdussResult) == null) {
                this.f62650g.i();
                this.f62650g.o();
                this.f62650g.setIntervalDuration(-1L);
                if (openBdussResult != null) {
                    StatisticManager.onEventEnd("DXMGetOpenbduss", openBdussResult.getResultCode());
                    if (this.f62650g.f62636d) {
                        this.f62650g.m();
                        return;
                    }
                    this.f62650g.f62633a = openBdussResult;
                    ILoginBackListener iLoginBackListener = this.f62648e;
                    if (iLoginBackListener instanceof LoginBackListenerProxy) {
                        Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.f62648e).getLoginBackListener();
                        if (!TextUtils.isEmpty(openBdussResult.openBduss) && !TextUtils.isEmpty(openBdussResult.unionid) && (map2 = openBdussResult.tplStokenMap) != null && !TextUtils.isEmpty(map2.get(WalletLoginHelper.getInstance().getTpl()))) {
                            b.f.b.d.a.a().d(openBdussResult.openBduss);
                            if (loginBackListener != null) {
                                this.f62650g.setErrorCodeSwitchFlag(true);
                                loginBackListener.onSuccess(2, openBdussResult.openBduss);
                            }
                        } else if (context == null || loginBackListener == null) {
                        } else {
                            if (this.f62649f && this.f62650g.f62638f) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                            }
                            this.f62650g.setErrorCodeSwitchFlag(true);
                            StatisticManager.onEvent("DXMGetOpenbdussSuccessNoUserInfo");
                            loginBackListener.onFail(602, openBdussResult.getResultMsg());
                        }
                    } else if (TextUtils.isEmpty(openBdussResult.openBduss) || TextUtils.isEmpty(openBdussResult.unionid) || (map = openBdussResult.tplStokenMap) == null || TextUtils.isEmpty(map.get(WalletLoginHelper.getInstance().getTpl()))) {
                    } else {
                        b.f.b.d.a.a().d(openBdussResult.openBduss);
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
                this.f62650g.i();
                this.f62650g.o();
                this.f62650g.setIntervalDuration(-1L);
                if (openBdussResult != null) {
                    StatisticManager.onEventEnd("DXMGetOpenbduss", openBdussResult.getResultCode());
                    if (this.f62650g.f62636d) {
                        this.f62650g.m();
                        return;
                    }
                    this.f62650g.logout(false);
                    ILoginBackListener iLoginBackListener = this.f62648e;
                    if (iLoginBackListener instanceof LoginBackListenerProxy) {
                        Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.f62648e).getLoginBackListener();
                        if (loginBackListener != null) {
                            if (openBdussResult.getResultCode() != 2 && openBdussResult.getResultCode() != 6 && openBdussResult.getResultCode() != -901) {
                                if (openBdussResult.getResultCode() == -203) {
                                    if (context != null && this.f62649f && this.f62650g.f62638f) {
                                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_ssl_error"));
                                    }
                                    this.f62650g.setErrorCodeSwitchFlag(true);
                                    loginBackListener.onFail(605, openBdussResult.getResultMsg());
                                    return;
                                } else if (openBdussResult.getResultCode() != -201 && openBdussResult.getResultCode() != -202) {
                                    if (openBdussResult.getResultCode() != 3 && openBdussResult.getResultCode() != 4 && openBdussResult.getResultCode() != 7) {
                                        if (openBdussResult.getResultCode() == 1) {
                                            if (context != null && this.f62649f && this.f62650g.f62638f) {
                                                this.f62650g.setErrorCodeSwitchFlag(true);
                                                try {
                                                    PassLoginDialogUtil.getInstance().showLoginTipDialog(context, this.f62648e, 604, openBdussResult.getResultMsg());
                                                    return;
                                                } catch (Exception e2) {
                                                    LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                                                    GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                                                    loginBackListener.onFail(604, openBdussResult.getResultMsg());
                                                    return;
                                                }
                                            }
                                            this.f62650g.setErrorCodeSwitchFlag(true);
                                            loginBackListener.onFail(604, openBdussResult.getResultMsg());
                                            return;
                                        }
                                        if (context != null && this.f62649f && this.f62650g.f62638f) {
                                            GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                                        }
                                        this.f62650g.setErrorCodeSwitchFlag(true);
                                        loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                        return;
                                    }
                                    if (context != null && this.f62649f && this.f62650g.f62638f) {
                                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                                    }
                                    this.f62650g.setErrorCodeSwitchFlag(true);
                                    loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                    return;
                                } else {
                                    if (context != null && this.f62649f && this.f62650g.f62638f) {
                                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_error"));
                                    }
                                    this.f62650g.setErrorCodeSwitchFlag(true);
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

    /* loaded from: classes11.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final PassLoginUtil f62651a;
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
            f62651a = new PassLoginUtil(null);
        }
    }

    public /* synthetic */ PassLoginUtil(a aVar) {
        this();
    }

    public static PassLoginUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? e.f62651a : (PassLoginUtil) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62633a = null;
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
                    if (!TextUtils.isEmpty(this.f62633a.uid)) {
                        hashMap.put("pass_uid", this.f62633a.uid);
                    }
                    if (!TextUtils.isEmpty(this.f62633a.bduss)) {
                        hashMap.put("pass_bduss", this.f62633a.bduss);
                    }
                    if (!TextUtils.isEmpty(this.f62633a.displayname)) {
                        hashMap.put("pass_user_name", this.f62633a.displayname);
                    }
                    if (!TextUtils.isEmpty(this.f62633a.openBduss)) {
                        hashMap.put("pass_open_bduss", this.f62633a.openBduss);
                    }
                    if (!TextUtils.isEmpty(this.f62633a.unionid)) {
                        hashMap.put("pass_union_id", this.f62633a.unionid);
                    }
                    if (this.f62633a.tplStokenMap != null && !TextUtils.isEmpty(this.f62633a.tplStokenMap.get(str))) {
                        hashMap.put("pass_stoken", this.f62633a.tplStokenMap.get(str));
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
                str = isLogin() ? this.f62633a.openBduss : "";
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
                str2 = isLogin() ? this.f62633a.tplStokenMap.get(str) : null;
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
                if (isPassLogin() && this.f62633a != null && !TextUtils.isEmpty(this.f62633a.bduss)) {
                    str = this.f62633a.bduss;
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
            CountDownTimer countDownTimer = this.f62634b;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f62634b = null;
            }
            CountDownTimer countDownTimer2 = this.f62635c;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
                this.f62635c = null;
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
                    if (this.f62633a != null && !TextUtils.isEmpty(this.f62633a.openBduss) && !TextUtils.isEmpty(this.f62633a.unionid) && this.f62633a.tplStokenMap != null) {
                        if (!TextUtils.isEmpty(this.f62633a.tplStokenMap.get(WalletLoginHelper.getInstance().getTpl()))) {
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
            long j = com.baidu.wallet.passport.PassLoginUtil.f59423c;
            if (z2 && (context = ((LoginBackListenerProxy) iLoginBackListener).getContext()) != null && !TextUtils.isEmpty(SdkInitResponse.getInstance().getLoadingDurationInterval(context))) {
                try {
                    long parseLong = Long.parseLong(SdkInitResponse.getInstance().getLoadingDurationInterval(context));
                    if (parseLong >= 0) {
                        j = parseLong;
                    }
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
            long j2 = j;
            b bVar = new b(this, j2, j2, iLoginBackListener, z);
            this.f62635c = bVar;
            bVar.start();
        }
    }

    public synchronized void logout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                SapiAccountManager.getInstance().logout();
                b.f.b.d.a.a().e();
                b();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f62636d = false;
        }
    }

    public final void n(boolean z, ILoginBackListener iLoginBackListener) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048592, this, z, iLoginBackListener) == null) && z) {
            long j2 = this.f62637e;
            long j3 = 300;
            if (j2 < 0) {
                if (!TextUtils.isEmpty(SdkInitResponse.getInstance().needShowLoadingInterval)) {
                    try {
                        long parseLong = Long.parseLong(SdkInitResponse.getInstance().needShowLoadingInterval);
                        if (parseLong >= 0) {
                            j3 = parseLong;
                        }
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
                j = j3;
            } else {
                j = j2;
            }
            c cVar = new c(this, j, j, z, iLoginBackListener);
            this.f62634b = cVar;
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
                this.f62638f = z;
            }
        }
    }

    public synchronized void setIntervalDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            synchronized (this) {
                this.f62637e = j;
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
        this.f62636d = false;
        this.f62637e = -1L;
        this.f62638f = true;
    }

    public synchronized void logout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            synchronized (this) {
                if (z) {
                    SapiAccountManager.getInstance().logout();
                }
                b.f.b.d.a.a().e();
                b();
            }
        }
    }
}
