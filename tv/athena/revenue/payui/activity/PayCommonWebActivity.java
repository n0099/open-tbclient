package tv.athena.revenue.payui.activity;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.d6a;
import com.baidu.tieba.e6a;
import com.baidu.tieba.j3a;
import com.baidu.tieba.j5a;
import com.baidu.tieba.k5a;
import com.baidu.tieba.l5a;
import com.baidu.tieba.r3a;
import com.baidu.tieba.w5a;
import com.baidu.tieba.x4a;
import com.baidu.tieba.y4a;
import com.baidu.tieba.y5a;
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
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.model.PayFlowType;
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
    public int j;
    public int k;
    public YYPayWebView l;
    public j3a m;
    public int n;
    public TextView o;
    public TextView p;
    public PayFlowType q;
    public boolean r;

    /* loaded from: classes9.dex */
    public class e implements IPayCallback {
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.l != null && this.a.a.i != null && !this.a.a.i.isEmpty()) {
                    this.a.a.l.i(this.a.a.i);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, currencyChargeMessage, payCallBackBean) == null) {
                RLog.debug(this.a.a, "onSuccess");
                if (!e6a.a.a(this.a)) {
                    RLog.info(this.a.a, "onSuccess activity not valid");
                } else {
                    this.a.runOnUiThread(new a(this));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements SimpleNavigationBar.c {
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

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.c
        public void onBackPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
                this.a.finish();
            }
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.c
        public void onRightClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.y();
                this.a.x();
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
                this.this$0.r = true;
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
            r3a r3aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (r3aVar = YYPayUIKit.mTestFunListenerr) != null) {
                r3aVar.b(view2);
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
            r3a r3aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (r3aVar = YYPayUIKit.mTestFunListenerr) != null) {
                r3aVar.a(view2);
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
        this.j = -1;
        this.k = -1;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.n == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.n == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (Env.instance().isTestEnv() && this.n == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
            z();
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.n == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.n == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b bVar = new b(this, this.q);
            this.e = bVar;
            y5a.d(this, bVar);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && q()) {
            l5a.b(this.j, this.k, PayUIEventType.walletclickClose);
            RLog.info(this.a, PayUIEventType.walletclickClose);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && q()) {
            l5a.b(this.j, this.k, PayUIEventType.walletshowhelp);
            RLog.info(this.a, PayUIEventType.walletshowhelp);
        }
    }

    public final void r(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, nativeOperationParams) == null) {
            x4a.c(this.j, this.k, this, nativeOperationParams, new e(this));
        }
    }

    public final void t(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
            this.c.setTitle(str);
            this.c.setRight(str2);
        }
    }

    public static void v(Context context, PayFlowType payFlowType, Intent intent, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, payFlowType, intent, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            y4a.b(str, i, i2, payFlowType);
            intent.putExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, payFlowType.getTypeId());
            context.startActivity(intent);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (YYPayUIKit.mTestFunListenerr != null) {
                this.o.setVisibility(0);
                this.o.setOnClickListener(new c(this));
                this.p.setVisibility(0);
                this.p.setOnClickListener(new d(this));
                return;
            }
            this.o.setVisibility(8);
            this.p.setVisibility(8);
        }
    }

    public final void B() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        this.h = intent.getStringExtra(H5PayConstant.EXTRA_TITLE);
        this.g = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT);
        this.f = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_URL);
        t(this.h, this.g);
        this.a = this.b + "@" + hashCode() + "@title:" + this.h;
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.j, this.k);
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            String str2 = this.a;
            RLog.info(str2, "onDestroy mAllPayFlowRelease:" + this.r);
            j3a j3aVar = this.m;
            if (j3aVar != null) {
                j3aVar.f();
            }
            AbsPayMessageReceiver absPayMessageReceiver = this.e;
            if (absPayMessageReceiver != null) {
                y5a.e(this, absPayMessageReceiver);
                this.e = null;
            }
            if (!this.r) {
                if (TextUtils.isEmpty(this.h)) {
                    str = d6a.a(this.i);
                } else {
                    str = this.h;
                }
                y4a.a(str, this.j, this.k, this.q);
            }
        }
    }

    public final void u() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(H5PayConstant.EXTRA_URL);
        this.i = stringExtra;
        RLog.info(this.a, "startLoadWebView: %s", d6a.a(stringExtra));
        String str = this.i;
        if (str != null && !str.isEmpty()) {
            YYPayWebView yYPayWebView = new YYPayWebView(this);
            this.l = yYPayWebView;
            yYPayWebView.setCallback(this);
            this.l.i(this.i);
            this.d.addView(this.l, -1, -1);
        }
    }

    public final void y() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (str = this.f) != null && !str.isEmpty() && (str2 = this.g) != null && !str2.isEmpty()) {
            Intent intent = new Intent(this, PayCommonWebActivity.class);
            intent.putExtra(H5PayConstant.EXTRA_URL, this.f);
            intent.putExtra(H5PayConstant.EXTRA_TITLE, this.g);
            intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.j);
            intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.k);
            if (TextUtils.isEmpty(this.g)) {
                str3 = d6a.a(this.f);
            } else {
                str3 = this.g;
            }
            v(this, this.q, intent, this.j, this.k, str3);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean n = n();
            boolean o = o();
            boolean p = p();
            boolean m = m();
            String str = this.a;
            RLog.debug(str, "tryVerifyPayOrder() isDxmKjPayPage:" + n + ", isMockTestPage:" + o + " isUnionPayPage:" + p + " isDxmH5PayPage:" + m);
            if (n || o || p || m) {
                H5PayManager.getInstance().verifyPayOrder();
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void a(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nativeOperationParams) == null) {
            RLog.debug(this.a, "onNativeOperation: %s", nativeOperationParams);
            if (nativeOperationParams == null) {
                return;
            }
            int i = nativeOperationParams.opCode;
            if (i == 4) {
                r(nativeOperationParams);
            } else if (i == 5) {
                x4a.a(this.j, this.k, this.q, nativeOperationParams);
            } else if (i == 6) {
                x4a.d(this.j, this.k, this.q, nativeOperationParams);
            } else if (i == 7) {
                x4a.b(this.j, this.k);
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void d(j5a j5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, j5aVar) == null) {
            RLog.info(this.a, "onUpdateTopUi: %s", j5aVar);
            if (j5aVar != null) {
                String str = j5aVar.b;
                if (str != null && !str.isEmpty()) {
                    this.g = j5aVar.b;
                }
                String str2 = j5aVar.c;
                if (str2 != null && !str2.isEmpty()) {
                    this.f = j5aVar.c;
                }
                String str3 = j5aVar.a;
                if (str3 != null && !str3.isEmpty()) {
                    this.h = j5aVar.a;
                }
                t(this.h, this.g);
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void b(k5a k5aVar, j5a j5aVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, k5aVar, j5aVar) == null) {
            RLog.info(this.a, "onOpenNewUrl: urlParams:%s, topUiParams:%s", k5aVar, j5aVar);
            if (k5aVar != null && (str = k5aVar.a) != null && !str.isEmpty()) {
                Intent intent = new Intent(this, PayCommonWebActivity.class);
                String str3 = j5aVar.a;
                if (str3 != null && !str3.isEmpty()) {
                    intent.putExtra(H5PayConstant.EXTRA_TITLE, j5aVar.a);
                }
                String str4 = j5aVar.b;
                if (str4 != null && !str4.isEmpty()) {
                    intent.putExtra(H5PayConstant.EXTRA_RIGHT, j5aVar.b);
                }
                intent.putExtra(H5PayConstant.EXTRA_URL, k5aVar.a);
                String str5 = j5aVar.c;
                if (str5 != null && !str5.isEmpty()) {
                    intent.putExtra(H5PayConstant.EXTRA_RIGHT_URL, j5aVar.c);
                }
                intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.j);
                intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.k);
                l5a.b(this.j, this.k, PayUIEventType.wallet_secondpage_title);
                RLog.warn(this.a, PayUIEventType.wallet_secondpage_title);
                if (k5aVar.b == UrlPageType.WALLET_DETAIL_PAGE.ordinal()) {
                    l5a.b(this.j, this.k, PayUIEventType.walletclickdetail);
                    RLog.warn(this.a, PayUIEventType.walletclickClose);
                }
                if (TextUtils.isEmpty(j5aVar.a)) {
                    str2 = d6a.a(k5aVar.a);
                } else {
                    str2 = j5aVar.a;
                }
                v(this, this.q, intent, this.j, this.k, str2);
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void c(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) && Env.instance().isTestEnv() && this.n == 3) {
            RLog.info(this.a, "onUrlLoading url:%s", str);
            if (str.startsWith("https://payplf-gate-test.yy.com/tpay/return.do")) {
                finish();
            }
        }
    }

    public final void l() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        this.j = intent.getIntExtra(H5PayConstant.EXTRA_APP_ID, -1);
        this.k = intent.getIntExtra(H5PayConstant.EXTRA_USER_CHANNEL, -1);
        this.n = intent.getIntExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 0);
        PayFlowType a2 = w5a.a(intent.getIntExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, 0));
        this.q = a2;
        if (a2 == null) {
            Toast.makeText(this, "error payFlowTypeId!", 1).show();
            RLog.error(this.a, "error payFlowTypeId", new Object[0]);
            finish();
        }
        String str = this.a;
        RLog.info(str, "fetchPayParamsFromIntent payFlowTypeId: " + this.q.getTypeId());
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d06a1);
            this.a = this.b + "@" + hashCode();
            if (Build.VERSION.SDK_INT >= 19) {
                j3a H = j3a.H(this);
                H.g(true);
                H.F();
                H.z(17170443);
                H.q(false);
                H.B(true);
                H.i();
                this.m = H;
            }
            l();
            String str = this.a;
            RLog.info(str, "onCreate mPayFlowType:" + this.q);
            s();
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f0920f3);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f0920f8);
            this.d = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0909ec);
            SimpleNavigationBar simpleNavigationBar = (SimpleNavigationBar) findViewById(R.id.obfuscated_res_0x7f091ef6);
            this.c = simpleNavigationBar;
            simpleNavigationBar.setCallback(new a(this));
            B();
            A();
            u();
        }
    }
}
