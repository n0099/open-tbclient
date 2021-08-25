package com.dxmpay.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.LogUtil;
/* loaded from: classes9.dex */
public class PassLoginDialogUtil implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f69678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f69679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f69680g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f69681h;

        public a(PassLoginDialogUtil passLoginDialogUtil, PromptDialog promptDialog, ILoginBackListener iLoginBackListener, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLoginDialogUtil, promptDialog, iLoginBackListener, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69678e = promptDialog;
            this.f69679f = iLoginBackListener;
            this.f69680g = i2;
            this.f69681h = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                try {
                    this.f69678e.dismiss();
                } catch (Exception e2) {
                    LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                }
                ILoginBackListener iLoginBackListener = this.f69679f;
                if (!(iLoginBackListener instanceof LoginBackListenerProxy) || ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener() == null) {
                    return;
                }
                ((LoginBackListenerProxy) this.f69679f).getLoginBackListener().onFail(this.f69680g, this.f69681h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f69682e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f69683f;

        public b(PassLoginDialogUtil passLoginDialogUtil, PromptDialog promptDialog, ILoginBackListener iLoginBackListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLoginDialogUtil, promptDialog, iLoginBackListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69682e = promptDialog;
            this.f69683f = iLoginBackListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                try {
                    this.f69682e.dismiss();
                } catch (Exception e2) {
                    LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                }
                WalletLoginHelper.getInstance().onlyLogin(this.f69683f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static PassLoginDialogUtil f69684a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1331459815, "Lcom/dxmpay/wallet/passport/PassLoginDialogUtil$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1331459815, "Lcom/dxmpay/wallet/passport/PassLoginDialogUtil$c;");
                    return;
                }
            }
            f69684a = new PassLoginDialogUtil(null);
        }
    }

    public /* synthetic */ PassLoginDialogUtil(a aVar) {
        this();
    }

    public static PassLoginDialogUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f69684a : (PassLoginDialogUtil) invokeV.objValue;
    }

    public void showLoginTipDialog(Context context, ILoginBackListener iLoginBackListener, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, context, iLoginBackListener, i2, str) == null) {
            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                PromptDialog promptDialog = new PromptDialog(context);
                promptDialog.setMessage(ResUtils.getString(context, "dxm_wallet_base_open_bduss_system_error"));
                promptDialog.setNegativeBtn(ResUtils.getString(context, "dxm_wallet_base_open_bduss_system_error_retry"), new a(this, promptDialog, iLoginBackListener, i2, str));
                promptDialog.setPositiveBtn(ResUtils.getString(context, "dxm_wallet_base_open_bduss_system_error_login"), new b(this, promptDialog, iLoginBackListener));
                promptDialog.show();
                return;
            }
            if (context != null) {
                GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
            }
            if (iLoginBackListener instanceof LoginBackListenerProxy) {
                LoginBackListenerProxy loginBackListenerProxy = (LoginBackListenerProxy) iLoginBackListener;
                if (loginBackListenerProxy.getLoginBackListener() != null) {
                    loginBackListenerProxy.getLoginBackListener().onFail(i2, str);
                }
            }
        }
    }

    public PassLoginDialogUtil() {
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
