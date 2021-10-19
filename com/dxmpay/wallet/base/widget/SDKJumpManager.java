package com.dxmpay.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.NetworkUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.BaiduWalletServiceController;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
/* loaded from: classes9.dex */
public class SDKJumpManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LoginBackListenerProxy f70009a;

    /* loaded from: classes9.dex */
    public interface OnJumpListener {
        void beforeJump(Context context, String str, String str2, String str3, boolean z);
    }

    /* loaded from: classes9.dex */
    public class a implements ILoginBackListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f70010e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f70011f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SDKJumpManager f70012g;

        public a(SDKJumpManager sDKJumpManager, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sDKJumpManager, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70012g = sDKJumpManager;
            this.f70010e = context;
            this.f70011f = str;
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) && i2 == 603) {
                WalletLoginHelper.getInstance().onlyLogin(this.f70012g.f70009a);
            }
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                BaiduWalletDelegate.getInstance().openH5Module(this.f70010e, this.f70011f, true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ILoginBackListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SDKJumpManager f70013e;

        public b(SDKJumpManager sDKJumpManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sDKJumpManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70013e = sDKJumpManager;
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) && i2 == 603) {
                WalletLoginHelper.getInstance().onlyLogin(this.f70013e.f70009a);
            }
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static SDKJumpManager f70014a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1888668154, "Lcom/dxmpay/wallet/base/widget/SDKJumpManager$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1888668154, "Lcom/dxmpay/wallet/base/widget/SDKJumpManager$c;");
                    return;
                }
            }
            f70014a = new SDKJumpManager(null);
        }
    }

    public /* synthetic */ SDKJumpManager(a aVar) {
        this();
    }

    public static SDKJumpManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.f70014a : (SDKJumpManager) invokeV.objValue;
    }

    public final boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                return false;
            }
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void doSDKJump(Context context, String str, String str2, String str3, boolean z, OnJumpListener onJumpListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z), onJumpListener}) == null) {
            if (onJumpListener != null) {
                onJumpListener.beforeJump(context, str, str2, str3, z);
            }
            if ("3".equals(str2) && !TextUtils.isEmpty(str3)) {
                BaiduWalletServiceController.getInstance().gotoWalletService(context, str3, "");
            } else if ("1".equals(str2) && !TextUtils.isEmpty(str3)) {
                if (!NetworkUtils.isNetworkAvailable(context)) {
                    GlobalUtils.toast(context, ResUtils.getString(context, "dxm_ebpay_no_network"));
                } else if (z) {
                    this.f70009a = new LoginBackListenerProxy(context, new a(this, context, str3));
                    WalletLoginHelper.getInstance().login(this.f70009a);
                } else {
                    BaiduWalletDelegate.getInstance().openH5Module(context, str3, true);
                }
            } else if ("2".equals(str2) && !TextUtils.isEmpty(str3)) {
                if (!NetworkUtils.isNetworkAvailable(context)) {
                    GlobalUtils.toast(context, ResUtils.getString(context, "dxm_ebpay_no_network"));
                } else {
                    WalletLoginHelper.getInstance().startPage(str3);
                }
            } else if ("4".equals(str2) && !TextUtils.isEmpty(str3)) {
                BaiduWalletDelegate.getInstance().invokeHostNative(str3, "");
            } else if ("5".equals(str2)) {
                this.f70009a = new LoginBackListenerProxy(context, new b(this));
                WalletLoginHelper.getInstance().login(this.f70009a);
            } else if (!"6".equals(str2) || b(context, str3)) {
            } else {
                GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_string_service_forbidden"));
            }
        }
    }

    public SDKJumpManager() {
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
