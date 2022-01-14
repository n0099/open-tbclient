package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.base.widget.BdContextMenuView;
import com.dxmpay.wallet.base.widget.BdMenu;
import com.dxmpay.wallet.base.widget.BdMenuItem;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BeanActivity extends BaseActivity implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BaseActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public BeanActivity mAct;
    public Handler mHandler;

    /* loaded from: classes2.dex */
    public class ActionBarMenu extends BdMenu {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MENU_ITEM_INDEX_LOGOUT = 35;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BeanActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionBarMenu(BeanActivity beanActivity, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {beanActivity, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = beanActivity;
            add(35, ResUtils.string(this.mContext, "dxm_wallet_logout"));
            setDismissOnClick(true);
        }

        @Override // com.dxmpay.wallet.base.widget.BdMenu
        public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, list) == null) {
                ((BdContextMenuView) view).layoutMenu(list);
            }
        }

        @Override // com.dxmpay.wallet.base.widget.BdMenu
        public View getMenuView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new BdContextMenuView(context) : (View) invokeL.objValue;
        }

        @Override // com.dxmpay.wallet.base.widget.BdMenu
        public void showMenu(PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, popupWindow) == null) {
                popupWindow.showAsDropDown(this.mViewToAttach);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BeanActivity f53943e;

        public a(BeanActivity beanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {beanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53943e = beanActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                GlobalUtils.hideKeyboard(this.f53943e.getActivity());
                this.f53943e.onBackPressed();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BeanActivity f53944e;

        public b(BeanActivity beanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {beanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53944e = beanActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                GlobalUtils.hideKeyboard(this.f53944e.getActivity());
                this.f53944e.onBackPressed();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f53945e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f53946f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f53947g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ BeanActivity f53948h;

        public c(BeanActivity beanActivity, int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {beanActivity, Integer.valueOf(i2), obj, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53948h = beanActivity;
            this.f53945e = i2;
            this.f53946f = obj;
            this.f53947g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BeanActivity beanActivity = this.f53948h;
                if (beanActivity.mAct != null) {
                    beanActivity.handleResponse(this.f53945e, this.f53946f, this.f53947g);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f53949e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f53950f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f53951g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ BeanActivity f53952h;

        public d(BeanActivity beanActivity, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {beanActivity, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53952h = beanActivity;
            this.f53949e = i2;
            this.f53950f = i3;
            this.f53951g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BeanActivity beanActivity = this.f53952h;
                if (beanActivity.mAct != null) {
                    beanActivity.handleFailure(this.f53949e, this.f53950f, this.f53951g);
                }
            }
        }
    }

    public BeanActivity() {
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
        this.mHandler = null;
    }

    private Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(getMainLooper());
            }
            return this.mHandler;
        }
        return (Handler) invokeV.objValue;
    }

    public BdActionBar getBdActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar")) : (BdActionBar) invokeV.objValue;
    }

    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            if (i3 == 5003) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_wallet_base_please_login"));
                AccountManager.getInstance(getActivity()).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (i3 == -2) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
            } else if (i3 == -3) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
            } else if (i3 == -4) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
            } else if (i3 == -8) {
                WalletGlobalUtils.safeShowDialog(this, 11, "");
            } else {
                this.mDialogMsg = str;
                if (TextUtils.isEmpty(str)) {
                    this.mDialogMsg = ResUtils.getString(getActivity(), "dxm_fp_get_data_fail");
                }
                GlobalUtils.toast(getActivity(), this.mDialogMsg);
            }
        }
    }

    public abstract void handleResponse(int i2, Object obj, String str);

    public void initActionBar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            initActionBarWithActualTitleValue(ResUtils.getString(getActivity(), str));
        }
    }

    public void initActionBarWithActualTitleValue(String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"))) == null) {
            return;
        }
        bdActionBar.setTitle(str);
        bdActionBar.setLeftZoneOnClickListener(new b(this));
    }

    public void initHomeActionBar(String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"))) == null) {
            return;
        }
        bdActionBar.setTitle(ResUtils.string(getActivity(), str));
        bdActionBar.setLeftZoneOnClickListener(new a(this));
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, str) == null) {
            String str2 = "onBeanExecFailure. bean id = " + i2 + ", err code = " + i3 + ", err msg = " + str;
            getHandler().post(new d(this, i2, i3, str));
        }
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            handleFailure(i2, i3, str);
        }
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, obj, str) == null) {
            getHandler().post(new c(this, i2, obj, str));
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            this.mAct = this;
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        }
    }
}
