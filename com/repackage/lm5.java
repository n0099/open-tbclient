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
public class lm5 implements wk2 {
    public static /* synthetic */ Interceptable $ic;
    public static BroadcastReceiver a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t71 a;

        public a(lm5 lm5Var, t71 t71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm5Var, t71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t71Var;
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
    public class b implements nm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t71 a;

        public b(lm5 lm5Var, t71 t71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm5Var, t71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t71Var;
        }

        @Override // com.repackage.nm5
        public void a(Bundle bundle) {
            t71 t71Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || (t71Var = this.a) == null) {
                return;
            }
            t71Var.onPayResult(bundle.getInt("result_code"), bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lm5 this$0;
        public final /* synthetic */ t71 val$callback;

        public c(lm5 lm5Var, t71 t71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm5Var, t71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = lm5Var;
            this.val$callback = t71Var;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755524259, "Lcom/repackage/lm5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755524259, "Lcom/repackage/lm5;");
        }
    }

    public lm5() {
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

    @Override // com.repackage.wk2
    public void a(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, str2) == null) {
        }
    }

    @Override // com.repackage.wk2
    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (WXAPIFactory.createWXAPI(context, null).isWXAppInstalled()) {
                return true;
            }
            m03.g(context, "您没有安装微信，请选择其他支付方式").G();
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.wk2
    public void c(Activity activity, String str, t71 t71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, t71Var) == null) {
            if (!v85.c().d()) {
                mi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0e94);
                return;
            }
            u03 L = u03.L();
            if (L == null || L.getActivity() == null) {
                return;
            }
            km5 km5Var = new km5();
            km5Var.mParams.putInt("type", 2);
            km5Var.mParams.putString("orderInfo", str);
            km5Var.c(L.getActivity());
            km5Var.d(new b(this, t71Var));
            km5Var.onExec();
        }
    }

    @Override // com.repackage.wk2
    public void d(Context context, JSONObject jSONObject, t71 t71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, jSONObject, t71Var) == null) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
            PayReq g = g(jSONObject);
            createWXAPI.registerApp(g.appId);
            if (!createWXAPI.isWXAppInstalled()) {
                t71Var.onPayResult(3, "wx_not_installed");
                m03.g(context, "您没有安装微信，请选择其他支付方式").G();
            } else if (u03.L() == null) {
            } else {
                if (!createWXAPI.sendReq(g)) {
                    t71Var.onPayResult(6, "wx_start_failed");
                }
                if (a != null) {
                    TbadkCoreApplication.getInst().unregisterReceiver(a);
                }
                a = new c(this, t71Var);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("WXPayResult");
                TbadkCoreApplication.getInst().registerReceiver(a, intentFilter);
            }
        }
    }

    @Override // com.repackage.wk2
    public void e(Activity activity, String str, t71 t71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, str, t71Var) == null) {
            DelegateUtils.callOnMainWithActivity(hm2.U().getActivity(), MainProcessDelegateActivity.class, om5.class, om5.c(str), new a(this, t71Var));
        }
    }

    @Override // com.repackage.wk2
    public void f(Activity activity, String str, e81<JSONObject> e81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, e81Var) == null) {
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
