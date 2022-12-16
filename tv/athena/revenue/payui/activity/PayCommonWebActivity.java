package tv.athena.revenue.payui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.aba;
import com.baidu.tieba.mba;
import com.baidu.tieba.naa;
import com.baidu.tieba.oaa;
import com.baidu.tieba.oba;
import com.baidu.tieba.r8a;
import com.baidu.tieba.wba;
import com.baidu.tieba.xba;
import com.baidu.tieba.yaa;
import com.baidu.tieba.z8a;
import com.baidu.tieba.zaa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsPayMessageReceiver;
import tv.athena.revenue.payui.view.impl.YYPayWebView;
import tv.athena.revenue.payui.webview.UrlPageType;
import tv.athena.revenue.payui.widget.SimpleNavigationBar;
/* loaded from: classes9.dex */
public class PayCommonWebActivity extends YYPayBaseActivity implements YYPayWebView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public SimpleNavigationBar c;
    public FrameLayout d;
    public AbsPayMessageReceiver e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public YYPayWebView o;
    public r8a p;
    public int q;
    public TextView r;
    public TextView s;
    public PayFlowType t;
    public boolean u;
    public boolean v;

    /* loaded from: classes9.dex */
    public class e implements IPaySignCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayCommonWebActivity a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.o != null && this.a.a.i != null && !this.a.a.i.isEmpty()) {
                    this.a.a.o.k(this.a.a.i);
                }
            }
        }

        public e(PayCommonWebActivity payCommonWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payCommonWebActivity;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback
        public void onPaySignFinish(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                RLog.debug(this.a.a, "onOpenSignPay finish");
                if (!xba.a.a(this.a)) {
                    RLog.info(this.a.a, "onOpenSignPay finish activity not valid");
                } else {
                    this.a.runOnUiThread(new a(this));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements IPayCallback<CurrencyChargeMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayCommonWebActivity a;

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, purchaseStatus, payCallBackBean) == null) {
            }
        }

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.o != null && this.a.a.i != null && !this.a.a.i.isEmpty()) {
                    this.a.a.o.k(this.a.a.i);
                }
            }
        }

        public f(PayCommonWebActivity payCommonWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payCommonWebActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, currencyChargeMessage, payCallBackBean) == null) {
                RLog.debug(this.a.a, "onSuccess");
                if (!xba.a.a(this.a)) {
                    RLog.info(this.a.a, "onSuccess activity not valid");
                } else {
                    this.a.runOnUiThread(new a(this));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements SimpleNavigationBar.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayCommonWebActivity a;

        public a(PayCommonWebActivity payCommonWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payCommonWebActivity;
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
                this.a.B();
            }
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.d
        public void onBackPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.A();
                this.a.finish();
            }
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.d
        public void onRightClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.D();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends AbsPayMessageReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayCommonWebActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PayCommonWebActivity payCommonWebActivity, PayFlowType payFlowType) {
            super(payFlowType);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity, payFlowType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((PayFlowType) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = payCommonWebActivity;
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onAllPayFlowViewRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RLog.info(this.this$0.a, "AbsReleasePayViewReceiver onAllPayFlowViewRelease");
                this.this$0.u = true;
                this.this$0.finish();
            }
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onDialogPayFlowViewRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                RLog.info(this.this$0.a, "AbsReleasePayViewReceiver onDialogPayFlowViewRelease");
                this.this$0.finish();
            }
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onWalletPayFlowViewRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                RLog.info(this.this$0.a, "AbsReleasePayViewReceiver onWalletPayFlowViewRelease");
                this.this$0.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayCommonWebActivity a;

        public c(PayCommonWebActivity payCommonWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payCommonWebActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            z8a z8aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (z8aVar = YYPayUIKit.mTestFunListenerr) != null) {
                z8aVar.b(view2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayCommonWebActivity a;

        public d(PayCommonWebActivity payCommonWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payCommonWebActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            z8a z8aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (z8aVar = YYPayUIKit.mTestFunListenerr) != null) {
                z8aVar.a(view2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ NativeOperationParams b;
        public final /* synthetic */ PayCommonWebActivity c;

        public g(PayCommonWebActivity payCommonWebActivity, Activity activity, NativeOperationParams nativeOperationParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity, activity, nativeOperationParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = payCommonWebActivity;
            this.a = activity;
            this.b = nativeOperationParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RLog.info(this.c.a, "openThirdPartPayApp in run");
                naa.j(this.c.m, this.c.n, this.a, this.b, this.c.o);
            }
        }
    }

    public PayCommonWebActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "PayCommonWebActivity";
        this.b = "PayCommonWebActivity";
        this.m = -1;
        this.n = -1;
        this.v = false;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && t()) {
            aba.b(this.m, this.n, PayUIEventType.walletclickClose);
            RLog.info(this.a, PayUIEventType.walletclickClose);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && t()) {
            RLog.info(this.a, "walletShowSet");
            aba.d(this.m, this.n, PayUVEventType.PAY_WALLET_RIGHT_SET_BTN_CLICK, "", "", "");
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onStop();
            E();
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.q == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.q == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (Env.instance().isTestEnv() && this.q == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.q == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.q == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b bVar = new b(this, this.t);
            this.e = bVar;
            oba.d(this, bVar);
        }
    }

    public final void u(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, nativeOperationParams) == null) {
            naa.e(this.m, this.n, this, nativeOperationParams, new f(this));
        }
    }

    public final void v(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, nativeOperationParams) == null) {
            this.v = true;
            naa.f(this, this.m, this.n, nativeOperationParams, new e(this));
        }
    }

    public static void z(Context context, PayFlowType payFlowType, Intent intent, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, payFlowType, intent, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            oaa.b(str, i, i2, payFlowType);
            intent.putExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, payFlowType.getTypeId());
            context.startActivity(intent);
        }
    }

    public final void C() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (str = this.l) != null && !str.isEmpty() && (str2 = this.k) != null && !str2.isEmpty()) {
            Intent intent = new Intent(this, PayCommonWebActivity.class);
            intent.putExtra(H5PayConstant.EXTRA_URL, this.l);
            intent.putExtra(H5PayConstant.EXTRA_TITLE, this.k);
            intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.m);
            intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.n);
            if (TextUtils.isEmpty(this.k)) {
                str3 = wba.a(this.l);
            } else {
                str3 = this.g;
            }
            z(this, this.t, intent, this.m, this.n, str3);
        }
    }

    public final void D() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (str = this.f) != null && !str.isEmpty() && (str2 = this.g) != null && !str2.isEmpty()) {
            Intent intent = new Intent(this, PayCommonWebActivity.class);
            intent.putExtra(H5PayConstant.EXTRA_URL, this.f);
            intent.putExtra(H5PayConstant.EXTRA_TITLE, this.g);
            intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.m);
            intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.n);
            if (TextUtils.isEmpty(this.g)) {
                str3 = wba.a(this.f);
            } else {
                str3 = this.g;
            }
            z(this, this.t, intent, this.m, this.n, str3);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean q = q();
            boolean r = r();
            boolean s = s();
            boolean p = p();
            String str = this.a;
            RLog.debug(str, "tryVerifyPayOrder() isDxmKjPayPage:" + q + ", isMockTestPage:" + r + " isUnionPayPage:" + s + " isDxmH5PayPage:" + p);
            if (q || r || s || p) {
                H5PayManager.getInstance().verifyPayOrder();
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.m, this.n);
            if (uIKit == null) {
                RLog.error(this.a, "getToken() yyPayUIKit null", new Object[0]);
                return "";
            }
            PayUIKitConfig payUIKitConfig = uIKit.getPayUIKitConfig();
            if (payUIKitConfig == null) {
                RLog.error(this.a, "getToken()  payUIKitConfig null", new Object[0]);
                return "";
            }
            MiddleRevenueConfig middleRevenueConfig = payUIKitConfig.revenueConfig;
            if (middleRevenueConfig == null) {
                RLog.error(this.a, "getToken()  revenueConfig null", new Object[0]);
                return "";
            }
            IToken tokenCallback = middleRevenueConfig.getTokenCallback();
            if (tokenCallback == null) {
                RLog.error(this.a, "getToken()  iToken null", new Object[0]);
                return "";
            }
            return tokenCallback.onUpdateToken();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            String str2 = this.a;
            RLog.info(str2, "onDestroy mAllPayFlowRelease:" + this.u);
            r8a r8aVar = this.p;
            if (r8aVar != null) {
                r8aVar.f();
            }
            AbsPayMessageReceiver absPayMessageReceiver = this.e;
            if (absPayMessageReceiver != null) {
                oba.e(this, absPayMessageReceiver);
                this.e = null;
            }
            if (!this.u) {
                if (TextUtils.isEmpty(this.h)) {
                    str = wba.a(this.i);
                } else {
                    str = this.h;
                }
                oaa.a(str, this.m, this.n, this.t);
            }
        }
    }

    public final void y() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(H5PayConstant.EXTRA_URL);
        this.i = stringExtra;
        RLog.info(this.a, "startLoadWebView: %s", wba.a(stringExtra));
        String str = this.i;
        if (str != null && !str.isEmpty()) {
            YYPayWebView yYPayWebView = new YYPayWebView(this);
            this.o = yYPayWebView;
            yYPayWebView.setCallback(this);
            this.o.k(this.i);
            this.d.addView(this.o, -1, -1);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (YYPayUIKit.mTestFunListenerr != null) {
                this.r.setVisibility(0);
                this.r.setOnClickListener(new c(this));
                this.s.setVisibility(0);
                this.s.setOnClickListener(new d(this));
                return;
            }
            this.r.setVisibility(8);
            this.s.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            String str2 = this.a;
            RLog.info(str2, "onResume  isSignPayPage=" + this.v);
            if (this.v && this.o != null && (str = this.i) != null && !str.isEmpty()) {
                this.o.k(this.i);
            }
        }
    }

    public final void G() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        this.h = intent.getStringExtra(H5PayConstant.EXTRA_TITLE);
        this.g = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT);
        this.f = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_URL);
        this.j = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_ICON);
        this.k = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_ICON_TITLE);
        this.l = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_ICON_URL);
        x(this.h, this.g, this.j);
        this.a = this.b + "@" + hashCode() + "@title:" + this.h;
    }

    public final void o() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        this.m = intent.getIntExtra(H5PayConstant.EXTRA_APP_ID, -1);
        this.n = intent.getIntExtra(H5PayConstant.EXTRA_USER_CHANNEL, -1);
        this.q = intent.getIntExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 0);
        PayFlowType a2 = mba.a(intent.getIntExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, 0));
        this.t = a2;
        if (a2 == null) {
            Toast.makeText(this, "error payFlowTypeId!", 1).show();
            RLog.error(this.a, "error payFlowTypeId", new Object[0]);
            finish();
        }
        String str = this.a;
        RLog.info(str, "fetchPayParamsFromIntent payFlowTypeId: " + this.t.getTypeId());
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void b(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nativeOperationParams) == null) {
            RLog.debug(this.a, "onNativeOperation: %s", nativeOperationParams);
            if (nativeOperationParams == null) {
                return;
            }
            int i = nativeOperationParams.opCode;
            if (i == 4) {
                u(nativeOperationParams);
            } else if (i == 5) {
                naa.c(this.m, this.n, this.t, nativeOperationParams);
            } else if (i == 6) {
                naa.g(this.m, this.n, this.t, nativeOperationParams);
            } else if (i == 7) {
                naa.d(this.m, this.n);
            } else if (i == 8) {
                v(nativeOperationParams);
            } else if (i == 9) {
                ThreadPool.getDefault().networkIO().execute(new g(this, this, nativeOperationParams));
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void e(yaa yaaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yaaVar) == null) {
            RLog.info(this.a, "onUpdateTopUi: %s", yaaVar);
            if (yaaVar != null) {
                String str = yaaVar.b;
                if (str != null && !str.isEmpty()) {
                    this.g = yaaVar.b;
                }
                String str2 = yaaVar.c;
                if (str2 != null && !str2.isEmpty()) {
                    this.f = yaaVar.c;
                }
                String str3 = yaaVar.a;
                if (str3 != null && !str3.isEmpty()) {
                    this.h = yaaVar.a;
                }
                String str4 = yaaVar.d;
                if (str4 != null && !str4.isEmpty()) {
                    this.j = yaaVar.d;
                }
                String str5 = yaaVar.e;
                if (str5 != null && !str5.isEmpty()) {
                    this.k = yaaVar.e;
                }
                String str6 = yaaVar.f;
                if (str6 != null && !str6.isEmpty()) {
                    this.l = yaaVar.f;
                }
                x(this.h, this.g, this.j);
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void c(zaa zaaVar, yaa yaaVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zaaVar, yaaVar) == null) {
            RLog.info(this.a, "onOpenNewUrl: urlParams:%s, topUiParams:%s", zaaVar, yaaVar);
            if (zaaVar != null && (str = zaaVar.a) != null && !str.isEmpty()) {
                Intent intent = new Intent(this, PayCommonWebActivity.class);
                String str3 = yaaVar.a;
                if (str3 != null && !str3.isEmpty()) {
                    intent.putExtra(H5PayConstant.EXTRA_TITLE, yaaVar.a);
                }
                String str4 = yaaVar.b;
                if (str4 != null && !str4.isEmpty()) {
                    intent.putExtra(H5PayConstant.EXTRA_RIGHT, yaaVar.b);
                }
                intent.putExtra(H5PayConstant.EXTRA_URL, zaaVar.a);
                String str5 = yaaVar.c;
                if (str5 != null && !str5.isEmpty()) {
                    intent.putExtra(H5PayConstant.EXTRA_RIGHT_URL, yaaVar.c);
                }
                String str6 = yaaVar.d;
                if (str6 != null && !str6.isEmpty()) {
                    intent.putExtra(H5PayConstant.EXTRA_RIGHT_ICON, yaaVar.d);
                }
                String str7 = yaaVar.e;
                if (str7 != null && !str7.isEmpty()) {
                    intent.putExtra(H5PayConstant.EXTRA_RIGHT_ICON_TITLE, yaaVar.e);
                }
                String str8 = yaaVar.f;
                if (str8 != null && !str8.isEmpty()) {
                    intent.putExtra(H5PayConstant.EXTRA_RIGHT_ICON_URL, yaaVar.f);
                }
                intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.m);
                intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.n);
                aba.b(this.m, this.n, PayUIEventType.wallet_secondpage_title);
                RLog.warn(this.a, PayUIEventType.wallet_secondpage_title);
                if (zaaVar.b == UrlPageType.WALLET_DETAIL_PAGE.ordinal()) {
                    aba.b(this.m, this.n, PayUIEventType.walletclickdetail);
                    RLog.warn(this.a, PayUIEventType.walletclickClose);
                }
                if (TextUtils.isEmpty(yaaVar.a)) {
                    str2 = wba.a(zaaVar.a);
                } else {
                    str2 = yaaVar.a;
                }
                z(this, this.t, intent, this.m, this.n, str2);
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void d(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, webView, str) == null) && Env.instance().isTestEnv() && this.q == 3) {
            RLog.info(this.a, "onUrlLoading url:%s", str);
            if (str.startsWith("https://payplf-gate-test.yy.com/tpay/return.do")) {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.pay_ui_common_web_activity);
            this.a = this.b + "@" + hashCode();
            if (Build.VERSION.SDK_INT >= 19) {
                r8a H = r8a.H(this);
                H.g(true);
                H.F();
                H.z(17170443);
                H.q(false);
                H.B(true);
                H.i();
                this.p = H;
            }
            o();
            String str = this.a;
            RLog.info(str, "onCreate mPayFlowType:" + this.t);
            w();
            this.r = (TextView) findViewById(R.id.test_banner_btn);
            this.s = (TextView) findViewById(R.id.test_wallet_btn);
            this.d = (FrameLayout) findViewById(R.id.fl_container);
            SimpleNavigationBar simpleNavigationBar = (SimpleNavigationBar) findViewById(R.id.simple_navigation_bar);
            this.c = simpleNavigationBar;
            simpleNavigationBar.setCallback(new a(this));
            G();
            F();
            y();
        }
    }

    public final void x(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, str3) == null) {
            this.c.setTitle(str);
            this.c.setRight(str2);
            this.c.setRightIcon(str3);
        }
    }
}
