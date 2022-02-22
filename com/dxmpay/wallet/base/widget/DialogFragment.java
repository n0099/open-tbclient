package com.dxmpay.wallet.base.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.widget.dialog.listener.DelegateOnCancleListener;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.BaseFragment;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
/* loaded from: classes3.dex */
public class DialogFragment extends BaseFragment implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_NO_NETWORK = 3851;
    public static final int DIALOG_PROMPT = 3843;
    public static final int DIALOG_WAIT_S0 = 0;
    public static final int DIALOG_WAIT_S1 = -1;
    public static final int DIALOG_WAIT_S2 = -2;
    public static final String TAG = "DialogFragment";
    public transient /* synthetic */ FieldHolder $fh;
    public String mDialogMsg;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogFragment f53990e;

        public a(DialogFragment dialogFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialogFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53990e = dialogFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                GlobalUtils.hideKeyboard(((BaseFragment) this.f53990e).mAct.getActivity());
                this.f53990e.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogFragment f53991e;

        public b(DialogFragment dialogFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialogFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53991e = dialogFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                GlobalUtils.hideKeyboard(((BaseFragment) this.f53991e).mAct.getActivity());
                this.f53991e.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogFragment f53992e;

        public c(DialogFragment dialogFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialogFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53992e = dialogFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || ((BaseFragment) this.f53992e).mAct == null) {
                return;
            }
            ((BaseFragment) this.f53992e).mAct.onBackPressed();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogFragment f53993e;

        public d(DialogFragment dialogFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialogFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53993e = dialogFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f53993e.cancleRequest();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogFragment f53994e;

        public e(DialogFragment dialogFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialogFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53994e = dialogFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                WalletGlobalUtils.safeDismissDialog(((BaseFragment) this.f53994e).mAct, 3851);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogFragment f53995e;

        public f(DialogFragment dialogFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialogFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53995e = dialogFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                WalletGlobalUtils.safeDismissDialog(((BaseFragment) this.f53995e).mAct, 3851);
                try {
                    this.f53995e.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f53996e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f53997f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f53998g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DialogFragment f53999h;

        public g(DialogFragment dialogFragment, int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialogFragment, Integer.valueOf(i2), obj, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53999h = dialogFragment;
            this.f53996e = i2;
            this.f53997f = obj;
            this.f53998g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ((BaseFragment) this.f53999h).mAct == null) {
                return;
            }
            this.f53999h.handleResponse(this.f53996e, this.f53997f, this.f53998g);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54000e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f54001f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f54002g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DialogFragment f54003h;

        public h(DialogFragment dialogFragment, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialogFragment, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54003h = dialogFragment;
            this.f54000e = i2;
            this.f54001f = i3;
            this.f54002g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ((BaseFragment) this.f54003h).mAct == null) {
                return;
            }
            this.f54003h.handleFailure(this.f54000e, this.f54001f, this.f54002g);
        }
    }

    public DialogFragment() {
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
        this.mDialogMsg = "";
    }

    public void cancleRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            if (i3 == 5003) {
                BaseActivity baseActivity = ((BaseFragment) this).mAct;
                GlobalUtils.toast(baseActivity, ResUtils.getString(baseActivity, "dxm_wallet_base_please_login"));
                AccountManager.getInstance(((BaseFragment) this).mAct).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (i3 == -2) {
                BaseActivity baseActivity2 = ((BaseFragment) this).mAct;
                GlobalUtils.toast(baseActivity2, ResUtils.getString(baseActivity2, "dxm_fp_get_data_fail"));
            } else if (i3 == -3) {
                BaseActivity baseActivity3 = ((BaseFragment) this).mAct;
                GlobalUtils.toast(baseActivity3, ResUtils.getString(baseActivity3, "dxm_fp_get_data_fail"));
            } else if (i3 == -4) {
                BaseActivity baseActivity4 = ((BaseFragment) this).mAct;
                GlobalUtils.toast(baseActivity4, ResUtils.getString(baseActivity4, "dxm_fp_get_data_fail"));
            } else if (i3 == -8) {
                WalletGlobalUtils.safeShowDialog(((BaseFragment) this).mAct, 3851, "");
            } else {
                this.mDialogMsg = str;
                if (TextUtils.isEmpty(str)) {
                    this.mDialogMsg = ResUtils.getString(getActivity(), "dxm_fp_get_data_fail");
                }
                GlobalUtils.toast(getActivity(), this.mDialogMsg);
            }
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
        }
    }

    public void initActionBar(View view, String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, str) == null) || (bdActionBar = (BdActionBar) view.findViewById(ResUtils.id(((BaseFragment) this).mAct, "bdactionbar"))) == null) {
            return;
        }
        bdActionBar.setTitle(ResUtils.string(((BaseFragment) this).mAct, str));
        bdActionBar.setLeftZoneOnClickListener(new a(this));
    }

    public void initHomeActionBar(View view, String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, view, str) == null) || (bdActionBar = (BdActionBar) view.findViewById(ResUtils.id(((BaseFragment) this).mAct, "bdactionbar"))) == null) {
            return;
        }
        bdActionBar.setTitle(ResUtils.string(((BaseFragment) this).mAct, str));
        bdActionBar.setLeftZoneOnClickListener(new b(this));
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
            String str2 = "onBeanExecFailure. bean id = " + i2 + ", err code = " + i3 + ", err msg = " + str;
            BaseActivity baseActivity = ((BaseFragment) this).mAct;
            if (baseActivity == null) {
                return;
            }
            baseActivity.runOnUiThread(new h(this, i2, i3, str));
        }
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            handleFailure(i2, i3, str);
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        BaseActivity baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048583, this, i2, obj, str) == null) || (baseActivity = ((BaseFragment) this).mAct) == null) {
            return;
        }
        baseActivity.runOnUiThread(new g(this, i2, obj, str));
    }

    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            String str = "onCreateDalog. id = " + i2;
            if (i2 != -2 && i2 != -1 && i2 != 0) {
                return new PromptDialog(((BaseFragment) this).mAct);
            }
            return new LoadingDialog(((BaseFragment) this).mAct);
        }
        return (Dialog) invokeI.objValue;
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, event) == null) && event != null && event.mEventKey.equals("ev_bean_execut_err_content")) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, dialog) == null) {
            String str = "onPrepareDialog. id = " + i2;
            if (i2 == -2) {
                LoadingDialog loadingDialog = (LoadingDialog) dialog;
                loadingDialog.setCancelable(true);
                loadingDialog.setOnCancelListener(new DelegateOnCancleListener(new d(this), loadingDialog));
            } else if (i2 == -1) {
                LoadingDialog loadingDialog2 = (LoadingDialog) dialog;
                loadingDialog2.setCancelable(true);
                loadingDialog2.setOnCancelListener(new DelegateOnCancleListener(new c(this), loadingDialog2));
            } else if (i2 == 0) {
                ((LoadingDialog) dialog).setCancelable(false);
            } else if (i2 != 3851) {
            } else {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(getString(ResUtils.string(((BaseFragment) this).mAct, "dxm_ebpay_no_network")));
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setNegativeBtn(ResUtils.string(((BaseFragment) this).mAct, "dxm_ebpay_cancel"), new e(this));
                promptDialog.setPositiveBtn(ResUtils.string(((BaseFragment) this).mAct, "dxm_ebpay_setting"), new f(this));
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            EventBus.getInstance().register(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        }
    }

    public void postEvent(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, obj) == null) {
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            eventBus.post(new EventBus.Event(eventBus, str, obj));
        }
    }
}
