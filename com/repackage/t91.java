package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.poly.widget.PayWebActivity;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.poly.widget.PolyNoticeDialog;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.v81;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s91 a;
    public z91 b;
    public w91 c;
    public PolyNoticeDialog d;

    /* loaded from: classes7.dex */
    public class a extends t71<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ PayChannelEntity b;
        public final /* synthetic */ ChannelListView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ t91 e;

        public a(t91 t91Var, Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t91Var, bundle, payChannelEntity, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t91Var;
            this.a = bundle;
            this.b = payChannelEntity;
            this.c = channelListView;
            this.d = str;
        }

        @Override // com.repackage.t71
        public void b(Throwable th, String str) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                if (str != null) {
                    message = str;
                } else {
                    message = th != null ? th.getMessage() : null;
                }
                String string = this.a.getString(PolyActivity.PANEL_TYPE_KEY);
                String string2 = this.a.getString(PolyActivity.TRADE_TYPE);
                l91.g("onWindowFocusChanged panelType=" + string + ", tradeType=" + string2);
                if (TextUtils.equals(string, "NONE") && TextUtils.equals(string2, PolyActivity.DIRECT_PAY_TRADE_TYPE)) {
                    this.c.S(h91.c(p91.a().getString(R.string.obfuscated_res_0x7f0f0d46) + message), str);
                } else {
                    ChannelListView channelListView = this.c;
                    channelListView.S(p91.a().getString(R.string.obfuscated_res_0x7f0f0d46) + message, str);
                }
                z81 z81Var = new z81("1");
                z81Var.b(new SdkException("launchpayment error --> " + str, th).getStackMessage());
                c91.e(z81Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t71
        /* renamed from: d */
        public void c(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                v81.b().d(map.get("orderInfoUrl"));
                c91.e = map.get("orderId");
                String str = map.get("logicType");
                if (TextUtils.equals(str, "PASS_CHECK")) {
                    String str2 = map.get("authId");
                    if (this.e.c != null) {
                        v71 v71Var = new v71();
                        v71Var.d("logicType", str);
                        v71Var.d("authId", str2);
                        this.e.c.showNeedAuthDialog(new q91(v71Var, this.a, this.b));
                    }
                } else if (TextUtils.equals(str, "RISK_BLOCK")) {
                    if (this.e.c != null) {
                        this.e.c.showBlockDialog();
                    }
                } else if (TextUtils.equals(str, "DIRECT_OUTTER")) {
                    this.e.o(this.b, this.c, map);
                } else if (TextUtils.equals(str, "SDK_TO_AGREEMENT")) {
                    this.e.p(this.c, map);
                } else if (TextUtils.equals(str, "SIGN_AFTER_PAY")) {
                    this.e.q(this.c, map);
                } else if (!TextUtils.equals(str, "DIRECT_DRMB")) {
                    this.e.n(this.b, this.c, map, this.d);
                } else {
                    this.c.p0(map.get("orderId"), this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements v81.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public b(t91 t91Var, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t91Var, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.repackage.v81.b
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || this.a == null) {
                return;
            }
            this.a.b0(i, i91.a(i, "", str), "0");
        }
    }

    /* loaded from: classes7.dex */
    public class c implements x91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ChannelListView b;
        public final /* synthetic */ t91 c;

        public c(t91 t91Var, String str, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t91Var, str, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t91Var;
            this.a = str;
            this.b = channelListView;
        }

        @Override // com.repackage.x91
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (1 == i) {
                    this.c.t(this.a, this.b);
                } else if (6 == i) {
                    if (this.c.d != null) {
                        this.c.d.setTips("请点击查询按钮确认支付结果");
                        this.c.d.stopLoadingAnim();
                        this.c.d.setRightBtnEnable(true);
                    }
                } else if (i == 0) {
                    c91.e(new z81("108"));
                    this.b.b0(i, i91.a(i, "", str), "0");
                } else if (3 == i) {
                    c91.e(new z81(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP));
                    this.b.d0();
                    this.c.u(this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyNoticeDialog a;

        public d(t91 t91Var, PolyNoticeDialog polyNoticeDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t91Var, polyNoticeDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyNoticeDialog;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setTitle(EventAlias.PayEventAlias.PAY_FAIL);
                this.a.setTips("请确认账号余额，或选择其他支付方式");
                this.a.setSingleBtnText("我知道了");
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ t91 c;

        /* loaded from: classes7.dex */
        public class a implements x91 {
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

            @Override // com.repackage.x91
            public void onResult(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                    if (6 == i) {
                        this.a.c.d.setTips("请点击查询按钮确认支付结果");
                        this.a.c.d.stopLoadingAnim();
                        this.a.c.d.setRightBtnEnable(true);
                    } else if (i == 0) {
                        c91.e(new z81("108"));
                        this.a.a.b0(i, i91.a(i, "", str), "0");
                    } else if (3 == i) {
                        c91.e(new z81(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP));
                        this.a.a.d0();
                        e eVar = this.a;
                        eVar.c.u(eVar.a);
                    }
                }
            }
        }

        public e(t91 t91Var, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t91Var, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t91Var;
            this.a = channelListView;
            this.b = str;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d.setTitle("确认小额免密支付结果");
                this.c.d.setTips("支付结果查询中 请稍后");
                this.c.d.startLoadingAnim();
                this.c.d.setActionLayoutBtnText("关闭", "查询");
                this.c.d.setRightBtnEnable(false);
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                u81.h().f();
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (i == R.id.obfuscated_res_0x7f091869) {
                    u81.h().f();
                    this.a.b0(6, "支付结果查询失败，请重试", "0");
                    this.c.d.dismiss();
                } else if (i == R.id.obfuscated_res_0x7f09186b) {
                    c91.e(new z81("111"));
                    this.c.d.setRightBtnEnable(false);
                    this.c.d.startLoadingAnim();
                    this.c.d.setTips("支付结果查询中 请稍后");
                    u81.h().g(this.b, new a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopupWindow a;
        public final /* synthetic */ ChannelListView b;
        public final /* synthetic */ String c;

        public f(t91 t91Var, PopupWindow popupWindow, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t91Var, popupWindow, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = popupWindow;
            this.b = channelListView;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PopupWindow popupWindow = this.a;
                if (popupWindow != null && popupWindow.r()) {
                    this.a.n();
                }
                this.b.b0(0, this.c, "0");
            }
        }
    }

    public t91(s91 s91Var, w91 w91Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s91Var, w91Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = s91Var;
        this.c = w91Var;
    }

    public final void i(Map<String, String> map, PayChannelEntity payChannelEntity, String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, map, payChannelEntity, str, channelListView) == null) {
            String str2 = map.get("extData");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (TextUtils.equals(new JSONObject(str2).optString("actionType"), "H5")) {
                        String str3 = map.get("payUrl");
                        if (!TextUtils.isEmpty(str3)) {
                            if (j(channelListView.getContext())) {
                                channelListView.setWechatH5Pay(true);
                                channelListView.setIsPreparePaying(false);
                                k((Activity) channelListView.getContext(), str3, map);
                                y81.h("8");
                                HashMap hashMap = new HashMap();
                                hashMap.put("exceptionCode", "0");
                                if (!TextUtils.isEmpty(str)) {
                                    hashMap.put("isFoldChannel", str);
                                }
                                y81.c("8", hashMap);
                                return;
                            }
                            y81.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-101", "没有安装微信");
                            Toast.makeText(channelListView.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            channelListView.b0(3, "wx_not_installed", "0");
                            return;
                        }
                        y81.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-107", "调起微信H5链接无效");
                        channelListView.S("H5 no corresponding url ", null);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("exceptionCode", "3");
                        hashMap2.put("errno", null);
                        hashMap2.put("errmsg", "H5 no corresponding url");
                        if (!TextUtils.isEmpty(str)) {
                            hashMap2.put("isFoldChannel", str);
                        }
                        y81.c("8", hashMap2);
                        return;
                    }
                } catch (Exception e2) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("exceptionType", "119502");
                    hashMap3.put("path", "cashier/launchpayment");
                    hashMap3.put(StatConstants.KEY_EXT_ERR_CODE, TbEnum.CustomGroupId.OFFICIAL_MERGE);
                    if (!TextUtils.isEmpty(str)) {
                        hashMap3.put("isFoldChannel", str);
                    }
                    hashMap3.put(StatConstants.KEY_EXT_ERR_MSG, e2.getMessage());
                    y81.c("8", hashMap3);
                    channelListView.S("launchpayment extData analyze failed ", null);
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("exceptionCode", "3");
                    hashMap4.put("errno", null);
                    hashMap4.put("errmsg", "launchpayment extData analyze failed");
                    if (!TextUtils.isEmpty(str)) {
                        hashMap4.put("isFoldChannel", str);
                    }
                    y81.c("8", hashMap4);
                    return;
                }
            }
            this.a.d(map, payChannelEntity, str, channelListView);
        }
    }

    public final boolean j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? context.getPackageManager().getPackageInfo("com.tencent.mm", 0) != null : invokeL.booleanValue;
    }

    public final void k(Activity activity, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, map) == null) || activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(activity, PayWebActivity.class);
        intent.putExtra(PayWebActivity.LOAD_URL, str);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        intent.putExtra(PayWebActivity.LAUNCH_PAYMENT_DATA, bundle);
        activity.startActivityForResult(intent, 200);
    }

    public void l(Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, bundle, payChannelEntity, channelListView, str) == null) {
            m(null, bundle, payChannelEntity, channelListView, str);
        }
    }

    public void m(v71 v71Var, Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, v71Var, bundle, payChannelEntity, channelListView, str) == null) {
            if (payChannelEntity != null && payChannelEntity.isNeedAgreementGuide() && payChannelEntity.isAlreadySigned()) {
                ja1.e(channelListView.getContext(), R.drawable.obfuscated_res_0x7f080638, "小额免密扣款中");
            }
            b81.j().v(v71Var, bundle, new a(this, bundle, payChannelEntity, channelListView, str), payChannelEntity, str);
        }
    }

    public final void n(PayChannelEntity payChannelEntity, ChannelListView channelListView, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, payChannelEntity, channelListView, map, str) == null) {
            if (map.containsKey("parentType")) {
                String str2 = map.get("parentType");
                if (TextUtils.isEmpty(str2)) {
                    i(map, payChannelEntity, str, channelListView);
                    return;
                } else if (4 == Integer.parseInt(str2)) {
                    String a2 = i91.a(0, map.get("orderId"), "Successful payment");
                    PopupWindow popupWindow = new PopupWindow(View.inflate(channelListView.getContext(), R.layout.obfuscated_res_0x7f0d0657, null), -1, -1, true);
                    popupWindow.w(false);
                    popupWindow.y(false);
                    popupWindow.B(false);
                    popupWindow.D(channelListView, 0, 0, 0);
                    new Handler().postDelayed(new f(this, popupWindow, channelListView, a2), 2000L);
                    y81.h("8");
                    l91.g("WalletList->pay() 命中0单元");
                    return;
                } else {
                    i(map, payChannelEntity, str, channelListView);
                    return;
                }
            }
            i(map, payChannelEntity, str, channelListView);
        }
    }

    public final void o(PayChannelEntity payChannelEntity, ChannelListView channelListView, Map<String, String> map) {
        boolean equalsIgnoreCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, payChannelEntity, channelListView, map) == null) {
            l91.g("processDirectOuter ------ payChannel=" + payChannelEntity.getPayChannel());
            String str = map.get("extData");
            if (!TextUtils.isEmpty(str)) {
                try {
                    String optString = new JSONObject(str).optString("actionType");
                    StringBuilder sb = new StringBuilder();
                    sb.append("processWxH5Pay actionType=");
                    sb.append(optString);
                    l91.g(sb.toString());
                    equalsIgnoreCase = "H5".equalsIgnoreCase(optString);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!equalsIgnoreCase && TextUtils.equals("BAIDU-SUPER-WECHAT-WISE", payChannelEntity.getPayChannel())) {
                    r(map, channelListView);
                    return;
                }
                this.a.f("DIRECT_OUTTER", map, payChannelEntity.getPayChannel(), channelListView, map.get("payResUrl"));
            }
            equalsIgnoreCase = false;
            if (!equalsIgnoreCase) {
            }
            this.a.f("DIRECT_OUTTER", map, payChannelEntity.getPayChannel(), channelListView, map.get("payResUrl"));
        }
    }

    public final void p(ChannelListView channelListView, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, channelListView, map) == null) {
            if (!TextUtils.equals(map.get(StatConstants.KEY_EXT_ERR_CODE), "0")) {
                channelListView.d0();
                u(channelListView);
                return;
            }
            String queryOrderString = channelListView.getSelectedPayChannelEntity().getQueryOrderString();
            u81.h().g(queryOrderString, new c(this, queryOrderString, channelListView));
        }
    }

    public final void q(ChannelListView channelListView, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, channelListView, map) == null) {
            String str = map.get("signUrl");
            try {
                Activity activity = (Activity) channelListView.getContext();
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("preEntrustWebId");
                this.b.a(activity, jSONObject.optString("wechatAppId"), optString);
                v81.b().e(new b(this, channelListView));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void r(Map<String, String> map, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, map, channelListView) == null) {
            String str = map.get("orderId");
            c91.e = str;
            String str2 = map.get("extData");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                if ("H5".equalsIgnoreCase(new JSONObject(str2).optString("actionType"))) {
                    String str3 = map.get("payUrl");
                    if (!TextUtils.isEmpty(str3)) {
                        if (j(channelListView.getContext())) {
                            channelListView.setWechatH5Pay(true);
                            channelListView.setIsPreparePaying(false);
                            k((Activity) channelListView.getContext(), str3, map);
                            y81.h("8");
                            channelListView.b0(1, h91.d(str, str3, "wx H5 paying"), "");
                        } else {
                            y81.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-101", "没有安装微信");
                            Toast.makeText(channelListView.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            channelListView.b0(3, h91.d(str, str3, "wx_not_installed"), "0");
                        }
                    } else {
                        channelListView.S(h91.d(str, str3, "H5 no corresponding url "), null);
                        y81.b("8", null, "H5 no corresponding url");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                channelListView.S(h91.d(str, "", "launchpayment extData analyze failed "), null);
                y81.b("8", null, "launchpayment extData analyze failed");
            }
        }
    }

    public void s(z91 z91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, z91Var) == null) {
            this.b = z91Var;
        }
    }

    public final void t(String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, channelListView) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            this.d = polyNoticeDialog;
            polyNoticeDialog.setCancelable(false);
            this.d.setOptionOnClickListener(new e(this, channelListView, str));
            this.d.show(((Activity) channelListView.getContext()).getFragmentManager(), "QUERY_ORDER_NOTICE_FRAGMENT_TAG");
            c91.e(new z81(TbEnum.SystemMessage.EVENT_ID_COMMON));
        }
    }

    public final void u(ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, channelListView) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            polyNoticeDialog.setCancelable(true);
            polyNoticeDialog.setOptionOnClickListener(new d(this, polyNoticeDialog));
            polyNoticeDialog.show(((Activity) channelListView.getContext()).getFragmentManager(), "PAY_FAILED_NOTICE_FRAGMENT_TAG");
        }
    }
}
