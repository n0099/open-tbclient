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
/* loaded from: classes7.dex */
public class xo5 implements bl2 {
    public static /* synthetic */ Interceptable $ic;
    public static BroadcastReceiver a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w71 a;

        public a(xo5 xo5Var, w71 w71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xo5Var, w71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w71Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                this.a.onPayResult(delegateResult.mResult.getInt("status_code"), delegateResult.mResult.getString("params"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w71 a;

        public b(xo5 xo5Var, w71 w71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xo5Var, w71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w71Var;
        }

        @Override // com.repackage.zo5
        public void a(Bundle bundle) {
            w71 w71Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || (w71Var = this.a) == null) {
                return;
            }
            w71Var.onPayResult(bundle.getInt("result_code"), bundle.getString("result_msg"));
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xo5 this$0;
        public final /* synthetic */ w71 val$callback;

        public c(xo5 xo5Var, w71 w71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xo5Var, w71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = xo5Var;
            this.val$callback = w71Var;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755164845, "Lcom/repackage/xo5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755164845, "Lcom/repackage/xo5;");
        }
    }

    public xo5() {
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

    @Override // com.repackage.bl2
    public void a(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, str2) == null) {
        }
    }

    @Override // com.repackage.bl2
    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (WXAPIFactory.createWXAPI(context, null).isWXAppInstalled()) {
                return true;
            }
            r03.g(context, "您没有安装微信，请选择其他支付方式").G();
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.bl2
    public void c(Activity activity, String str, w71 w71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, w71Var) == null) {
            if (!da5.c().d()) {
                qi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0eb1);
                return;
            }
            z03 M = z03.M();
            if (M == null || M.getActivity() == null) {
                return;
            }
            wo5 wo5Var = new wo5();
            wo5Var.mParams.putInt("type", 2);
            wo5Var.mParams.putString("orderInfo", str);
            wo5Var.d(M.getActivity());
            wo5Var.e(new b(this, w71Var));
            wo5Var.onExec();
        }
    }

    @Override // com.repackage.bl2
    public void d(Context context, JSONObject jSONObject, w71 w71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, jSONObject, w71Var) == null) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
            PayReq g = g(jSONObject);
            createWXAPI.registerApp(g.appId);
            if (!createWXAPI.isWXAppInstalled()) {
                w71Var.onPayResult(3, "wx_not_installed");
                r03.g(context, "您没有安装微信，请选择其他支付方式").G();
            } else if (z03.M() == null) {
            } else {
                if (!createWXAPI.sendReq(g)) {
                    w71Var.onPayResult(6, "wx_start_failed");
                }
                if (a != null) {
                    TbadkCoreApplication.getInst().unregisterReceiver(a);
                }
                a = new c(this, w71Var);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("WXPayResult");
                TbadkCoreApplication.getInst().registerReceiver(a, intentFilter);
            }
        }
    }

    @Override // com.repackage.bl2
    public void e(Activity activity, String str, w71 w71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, str, w71Var) == null) {
            DelegateUtils.callOnMainWithActivity(mm2.U().getActivity(), MainProcessDelegateActivity.class, ap5.class, ap5.d(str), new a(this, w71Var));
        }
    }

    @Override // com.repackage.bl2
    public void f(Activity activity, String str, h81<JSONObject> h81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, h81Var) == null) {
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
