package com.dxmpay.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
/* loaded from: classes11.dex */
public class LoginOutHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public interface IAfterDismissCallback {
        void onCancel();

        void onLogout();
    }

    /* loaded from: classes11.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Dialog f62412e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f62413f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IAfterDismissCallback f62414g;

        public a(Dialog dialog, Context context, IAfterDismissCallback iAfterDismissCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialog, context, iAfterDismissCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62412e = dialog;
            this.f62413f = context;
            this.f62414g = iAfterDismissCallback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62412e.dismiss();
                AccountManager.getInstance(this.f62413f.getApplicationContext()).logout();
                WalletLoginHelper.getInstance().logout();
                IAfterDismissCallback iAfterDismissCallback = this.f62414g;
                if (iAfterDismissCallback != null) {
                    iAfterDismissCallback.onLogout();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Dialog f62415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IAfterDismissCallback f62416f;

        public b(Dialog dialog, IAfterDismissCallback iAfterDismissCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialog, iAfterDismissCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62415e = dialog;
            this.f62416f = iAfterDismissCallback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62415e.dismiss();
                IAfterDismissCallback iAfterDismissCallback = this.f62416f;
                if (iAfterDismissCallback != null) {
                    iAfterDismissCallback.onCancel();
                }
            }
        }
    }

    public LoginOutHelper() {
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

    public static void showLogoutDialog(Context context, IAfterDismissCallback iAfterDismissCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, iAfterDismissCallback) == null) {
            Dialog dialog = new Dialog(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
            dialog.setContentView(ResUtils.layout(context, "dxm_wallet_base_dialog_logout"));
            dialog.findViewById(ResUtils.id(context, "ebpay_logout")).setOnClickListener(new a(dialog, context, iAfterDismissCallback));
            dialog.findViewById(ResUtils.id(context, "ebpay_cancel")).setOnClickListener(new b(dialog, iAfterDismissCallback));
            dialog.setCanceledOnTouchOutside(true);
            Window window = dialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = DisplayUtils.getDisplayWidth(context);
            attributes.y = (DisplayUtils.getDisplayHeight(context) - attributes.height) / 2;
            window.setAttributes(attributes);
            window.setWindowAnimations(ResUtils.style(context, "DxmDialogWindowAnim"));
            dialog.show();
        }
    }
}
