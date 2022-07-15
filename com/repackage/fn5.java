package com.repackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes6.dex */
public class fn5 implements jk2 {
    public static /* synthetic */ Interceptable $ic;
    public static BroadcastReceiver a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f71 a;

        public a(fn5 fn5Var, f71 f71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn5Var, f71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f71Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                this.a.onPayResult(delegateResult.mResult.getInt("status_code"), delegateResult.mResult.getString("params"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements hn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f71 a;

        public b(fn5 fn5Var, f71 f71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn5Var, f71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f71Var;
        }

        @Override // com.repackage.hn5
        public void a(Bundle bundle) {
            f71 f71Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || (f71Var = this.a) == null) {
                return;
            }
            f71Var.onPayResult(bundle.getInt("result_code"), bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn5 this$0;
        public final /* synthetic */ f71 val$callback;

        public c(fn5 fn5Var, f71 f71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn5Var, f71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fn5Var;
            this.val$callback = f71Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                intent.getExtras();
                this.val$callback.onPayResult(intent.getExtras().getInt("errorCode", -1), intent.getExtras().getString("errorMsg"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755702044, "Lcom/repackage/fn5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755702044, "Lcom/repackage/fn5;");
        }
    }

    public fn5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.jk2
    public void a(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, str2) == null) {
        }
    }

    @Override // com.repackage.jk2
    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (WXAPIFactory.createWXAPI(context, null).isWXAppInstalled()) {
                return true;
            }
            zz2.g(context, "您没有安装微信，请选择其他支付方式").G();
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.jk2
    public void c(Activity activity, String str, f71 f71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, f71Var) == null) {
            if (!e95.c().d()) {
                pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0e9a);
                return;
            }
            h03 M = h03.M();
            if (M == null || M.getActivity() == null) {
                return;
            }
            en5 en5Var = new en5();
            en5Var.mParams.putInt("type", 2);
            en5Var.mParams.putString("orderInfo", str);
            en5Var.d(M.getActivity());
            en5Var.e(new b(this, f71Var));
            en5Var.onExec();
        }
    }

    @Override // com.repackage.jk2
    public void d(Context context, JSONObject jSONObject, f71 f71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, jSONObject, f71Var) == null) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
            PayReq g = g(jSONObject);
            createWXAPI.registerApp(g.appId);
            if (!createWXAPI.isWXAppInstalled()) {
                f71Var.onPayResult(3, "wx_not_installed");
                zz2.g(context, "您没有安装微信，请选择其他支付方式").G();
            } else if (h03.M() == null) {
            } else {
                if (!createWXAPI.sendReq(g)) {
                    f71Var.onPayResult(6, "wx_start_failed");
                }
                if (a != null) {
                    TbadkCoreApplication.getInst().unregisterReceiver(a);
                }
                a = new c(this, f71Var);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("WXPayResult");
                TbadkCoreApplication.getInst().registerReceiver(a, intentFilter);
            }
        }
    }

    @Override // com.repackage.jk2
    public void e(Activity activity, String str, f71 f71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, str, f71Var) == null) {
            DelegateUtils.callOnMainWithActivity(ul2.U().getActivity(), MainProcessDelegateActivity.class, in5.class, in5.d(str), new a(this, f71Var));
        }
    }

    @Override // com.repackage.jk2
    public void f(Activity activity, String str, q71<JSONObject> q71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, q71Var) == null) {
        }
    }

    public final PayReq g(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            PayReq payReq = new PayReq();
            payReq.appId = jSONObject.optString("appid");
            payReq.partnerId = jSONObject.optString("partnerid");
            payReq.prepayId = jSONObject.optString("prepayid");
            payReq.packageValue = jSONObject.optString("packagealias");
            payReq.nonceStr = jSONObject.optString("noncestr");
            payReq.timeStamp = jSONObject.optString("timestamp");
            payReq.sign = jSONObject.optString("sign");
            return payReq;
        }
        return (PayReq) invokeL.objValue;
    }
}
