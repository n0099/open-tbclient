package com.dxmpay.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.NoProguard;
/* loaded from: classes3.dex */
public class ThirdPartyLoginUtil implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] NEGATIVE_STRS;
    public static final String[] POSITIVE_STRS;
    public static final int THIRD_PARTH_BINDPHONE = 2;
    public static final int THIRD_PARTH_LOGIN = 0;
    public static final int THIRD_PARTH_NORMALIZE = 1;
    public static final int THIRD_PARTH_NOT = -1;
    public static final int THIRD_PARTH_PASSAUTH = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public LoginBackListenerProxy loginBackListener;
    public WalletApiExtListener.ThirdPartyLoginInterface mTPLImpl;

    /* loaded from: classes3.dex */
    public class a implements ILoginBackListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f54227e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ThirdPartyLoginUtil f54228f;

        public a(ThirdPartyLoginUtil thirdPartyLoginUtil, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thirdPartyLoginUtil, thirdPartyLoginListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54228f = thirdPartyLoginUtil;
            this.f54227e = thirdPartyLoginListener;
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(this.f54228f.loginBackListener);
                    return;
                }
                WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = this.f54227e;
                if (thirdPartyLoginListener != null) {
                    thirdPartyLoginListener.onCallFail(0, null);
                }
            }
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onSuccess(int i2, String str) {
            WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (thirdPartyLoginListener = this.f54227e) == null) {
                return;
            }
            thirdPartyLoginListener.onCallSuccess(0, null);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f54230f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f54231g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f54232h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ThirdPartyLoginUtil f54233i;

        public b(ThirdPartyLoginUtil thirdPartyLoginUtil, int i2, Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener, PromptDialog promptDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thirdPartyLoginUtil, Integer.valueOf(i2), activity, thirdPartyLoginListener, promptDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54233i = thirdPartyLoginUtil;
            this.f54229e = i2;
            this.f54230f = activity;
            this.f54231g = thirdPartyLoginListener;
            this.f54232h = promptDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f54229e;
                if (i2 == 0) {
                    this.f54233i.startLogin(this.f54230f, this.f54231g);
                } else if (i2 == 1) {
                    this.f54233i.startTuristNormalize(this.f54230f, this.f54231g);
                } else if (i2 == 2) {
                    this.f54233i.startBindPhone(this.f54230f, this.f54231g);
                } else if (i2 == 3) {
                    this.f54233i.startPassSMSAuth(this.f54230f, this.f54231g);
                }
                try {
                    this.f54232h.dismiss();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f54234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f54235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f54236g;

        public c(ThirdPartyLoginUtil thirdPartyLoginUtil, PromptDialog promptDialog, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thirdPartyLoginUtil, promptDialog, thirdPartyLoginListener, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54234e = promptDialog;
            this.f54235f = thirdPartyLoginListener;
            this.f54236g = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                try {
                    this.f54234e.dismiss();
                } catch (Throwable unused) {
                }
                WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = this.f54235f;
                if (thirdPartyLoginListener != null) {
                    thirdPartyLoginListener.onCallFail(0, null);
                }
                this.f54236g.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static ThirdPartyLoginUtil a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-102778852, "Lcom/dxmpay/wallet/passport/ThirdPartyLoginUtil$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-102778852, "Lcom/dxmpay/wallet/passport/ThirdPartyLoginUtil$d;");
                    return;
                }
            }
            a = new ThirdPartyLoginUtil();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-286140132, "Lcom/dxmpay/wallet/passport/ThirdPartyLoginUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-286140132, "Lcom/dxmpay/wallet/passport/ThirdPartyLoginUtil;");
                return;
            }
        }
        POSITIVE_STRS = new String[]{"dxm_wallet_base_third_login_positive", "dxm_wallet_base_third_login_normalize", "dxm_wallet_base_third_login_bindphone", "dxm_wallet_base_third_login_passauth"};
        NEGATIVE_STRS = new String[]{"dxm_wallet_base_third_login_negative", "dxm_wallet_base_third_login_giveup", "dxm_wallet_base_third_login_giveup", "dxm_wallet_base_third_login_giveup"};
    }

    public ThirdPartyLoginUtil() {
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

    public static ThirdPartyLoginUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.a : (ThirdPartyLoginUtil) invokeV.objValue;
    }

    public boolean checkThirdPartyLogin(Activity activity, int i2, String str, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        InterceptResult invokeLILL;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048576, this, activity, i2, str, thirdPartyLoginListener)) == null) {
            switch (i2) {
                case 5093:
                case 5095:
                    i3 = 3;
                    break;
                case 5094:
                case 5096:
                    i3 = 2;
                    break;
                case 5097:
                    i3 = 1;
                    break;
                case 5098:
                default:
                    i3 = -1;
                    break;
                case 5099:
                    i3 = 0;
                    break;
            }
            if (i3 == -1) {
                return false;
            }
            PromptDialog promptDialog = new PromptDialog(activity);
            if (i3 == 0) {
                promptDialog.setTitleText(ResUtils.getString(activity, "dxm_wallet_base_third_login_title"));
            } else {
                promptDialog.hideTitle();
            }
            promptDialog.setMessage(str);
            promptDialog.setPositiveBtn(ResUtils.getString(activity, POSITIVE_STRS[i3]), new b(this, i3, activity, thirdPartyLoginListener, promptDialog));
            promptDialog.setNegativeBtn(ResUtils.getString(activity, NEGATIVE_STRS[i3]), new c(this, promptDialog, thirdPartyLoginListener, activity));
            try {
                promptDialog.show();
            } catch (Throwable unused) {
            }
            return true;
        }
        return invokeLILL.booleanValue;
    }

    public void setThirdPartyLoginImpl(WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thirdPartyLoginInterface) == null) {
            this.mTPLImpl = thirdPartyLoginInterface;
        }
    }

    public void startBindPhone(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, thirdPartyLoginListener) == null) {
            WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface = this.mTPLImpl;
            if (thirdPartyLoginInterface != null) {
                thirdPartyLoginInterface.callBindPhone(activity, thirdPartyLoginListener);
            } else {
                thirdPartyLoginListener.onCallFail(0, null);
            }
        }
    }

    public void startLogin(Context context, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, thirdPartyLoginListener) == null) {
            this.loginBackListener = new LoginBackListenerProxy(context, new a(this, thirdPartyLoginListener));
            WalletLoginHelper.getInstance().login(this.loginBackListener);
        }
    }

    public void startPassSMSAuth(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, thirdPartyLoginListener) == null) {
            PassSMSAuthProxyActivity.startPassSMSAuth(activity, thirdPartyLoginListener);
        }
    }

    public void startTuristNormalize(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, activity, thirdPartyLoginListener) == null) {
            WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface = this.mTPLImpl;
            if (thirdPartyLoginInterface != null) {
                thirdPartyLoginInterface.callTuristNormalize(activity, thirdPartyLoginListener);
            } else {
                thirdPartyLoginListener.onCallFail(0, null);
            }
        }
    }
}
