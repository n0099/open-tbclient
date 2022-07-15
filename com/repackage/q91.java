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
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.repackage.s81;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p91 a;
    public w91 b;
    public t91 c;
    public PolyNoticeDialog d;

    /* loaded from: classes7.dex */
    public class a extends q71<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ PayChannelEntity b;
        public final /* synthetic */ ChannelListView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ q91 e;

        public a(q91 q91Var, Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q91Var, bundle, payChannelEntity, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = q91Var;
            this.a = bundle;
            this.b = payChannelEntity;
            this.c = channelListView;
            this.d = str;
        }

        @Override // com.repackage.q71
        public void b(Throwable th, String str) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                if (str != null) {
                    message = str;
                } else {
                    message = th != null ? th.getMessage() : null;
                }
                String string = this.a.getString("panelType");
                String string2 = this.a.getString("tradeType");
                i91.g("onWindowFocusChanged panelType=" + string + ", tradeType=" + string2);
                if (TextUtils.equals(string, HlsPlaylistParser.METHOD_NONE) && TextUtils.equals(string2, "DIRECTPAY")) {
                    this.c.S(e91.c(m91.a().getString(R.string.obfuscated_res_0x7f0f0d5e) + message), str);
                } else {
                    ChannelListView channelListView = this.c;
                    channelListView.S(m91.a().getString(R.string.obfuscated_res_0x7f0f0d5e) + message, str);
                }
                w81 w81Var = new w81("1");
                w81Var.b(new SdkException("launchpayment error --> " + str, th).getStackMessage());
                z81.e(w81Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
        /* renamed from: d */
        public void c(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                s81.b().d(map.get("orderInfoUrl"));
                z81.e = map.get("orderId");
                String str = map.get("logicType");
                if (TextUtils.equals(str, "PASS_CHECK")) {
                    String str2 = map.get("authId");
                    if (this.e.c != null) {
                        s71 s71Var = new s71();
                        s71Var.d("logicType", str);
                        s71Var.d("authId", str2);
                        this.e.c.b(new n91(s71Var, this.a, this.b));
                    }
                } else if (TextUtils.equals(str, "RISK_BLOCK")) {
                    if (this.e.c != null) {
                        this.e.c.a();
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
    public class b implements s81.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public b(q91 q91Var, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q91Var, channelListView};
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

        @Override // com.repackage.s81.b
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || this.a == null) {
                return;
            }
            this.a.b0(i, f91.a(i, "", str), "0");
        }
    }

    /* loaded from: classes7.dex */
    public class c implements u91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ChannelListView b;
        public final /* synthetic */ q91 c;

        public c(q91 q91Var, String str, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q91Var, str, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q91Var;
            this.a = str;
            this.b = channelListView;
        }

        @Override // com.repackage.u91
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (1 == i) {
                    this.c.t(this.a, this.b);
                } else if (6 == i) {
                    if (this.c.d != null) {
                        this.c.d.f("请点击查询按钮确认支付结果");
                        this.c.d.i();
                        this.c.d.d(true);
                    }
                } else if (i == 0) {
                    z81.e(new w81("108"));
                    this.b.b0(i, f91.a(i, "", str), "0");
                } else if (3 == i) {
                    z81.e(new w81(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP));
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

        public d(q91 q91Var, PolyNoticeDialog polyNoticeDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q91Var, polyNoticeDialog};
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
                this.a.g(EventAlias.PayEventAlias.PAY_FAIL);
                this.a.f("请确认账号余额，或选择其他支付方式");
                this.a.e("我知道了");
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
        public final /* synthetic */ q91 c;

        /* loaded from: classes7.dex */
        public class a implements u91 {
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

            @Override // com.repackage.u91
            public void onResult(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                    if (6 == i) {
                        this.a.c.d.f("请点击查询按钮确认支付结果");
                        this.a.c.d.i();
                        this.a.c.d.d(true);
                    } else if (i == 0) {
                        z81.e(new w81("108"));
                        this.a.a.b0(i, f91.a(i, "", str), "0");
                    } else if (3 == i) {
                        z81.e(new w81(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP));
                        this.a.a.d0();
                        e eVar = this.a;
                        eVar.c.u(eVar.a);
                    }
                }
            }
        }

        public e(q91 q91Var, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q91Var, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q91Var;
            this.a = channelListView;
            this.b = str;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d.g("确认小额免密支付结果");
                this.c.d.f("支付结果查询中 请稍后");
                this.c.d.h();
                this.c.d.b("关闭", "查询");
                this.c.d.d(false);
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                r81.h().f();
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (i == R.id.obfuscated_res_0x7f091916) {
                    r81.h().f();
                    this.a.b0(6, "支付结果查询失败，请重试", "0");
                    this.c.d.dismiss();
                } else if (i == R.id.obfuscated_res_0x7f091918) {
                    z81.e(new w81("111"));
                    this.c.d.d(false);
                    this.c.d.h();
                    this.c.d.f("支付结果查询中 请稍后");
                    r81.h().g(this.b, new a(this));
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

        public f(q91 q91Var, PopupWindow popupWindow, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q91Var, popupWindow, channelListView, str};
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

    public q91(p91 p91Var, t91 t91Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p91Var, t91Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = p91Var;
        this.c = t91Var;
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
                                v81.h("8");
                                HashMap hashMap = new HashMap();
                                hashMap.put("exceptionCode", "0");
                                if (!TextUtils.isEmpty(str)) {
                                    hashMap.put("isFoldChannel", str);
                                }
                                v81.c("8", hashMap);
                                return;
                            }
                            v81.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-101", "没有安装微信");
                            Toast.makeText(channelListView.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            channelListView.b0(3, "wx_not_installed", "0");
                            return;
                        }
                        v81.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-107", "调起微信H5链接无效");
                        channelListView.S("H5 no corresponding url ", null);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("exceptionCode", "3");
                        hashMap2.put("errno", null);
                        hashMap2.put("errmsg", "H5 no corresponding url");
                        if (!TextUtils.isEmpty(str)) {
                            hashMap2.put("isFoldChannel", str);
                        }
                        v81.c("8", hashMap2);
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
                    v81.c("8", hashMap3);
                    channelListView.S("launchpayment extData analyze failed ", null);
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("exceptionCode", "3");
                    hashMap4.put("errno", null);
                    hashMap4.put("errmsg", "launchpayment extData analyze failed");
                    if (!TextUtils.isEmpty(str)) {
                        hashMap4.put("isFoldChannel", str);
                    }
                    v81.c("8", hashMap4);
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
        intent.putExtra("load_url", str);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        intent.putExtra("launch_payment_data", bundle);
        activity.startActivityForResult(intent, 200);
    }

    public void l(Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, bundle, payChannelEntity, channelListView, str) == null) {
            m(null, bundle, payChannelEntity, channelListView, str);
        }
    }

    public void m(s71 s71Var, Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, s71Var, bundle, payChannelEntity, channelListView, str) == null) {
            if (payChannelEntity != null && payChannelEntity.isNeedAgreementGuide() && payChannelEntity.isAlreadySigned()) {
                ga1.e(channelListView.getContext(), R.drawable.obfuscated_res_0x7f080623, "小额免密扣款中");
            }
            y71.j().v(s71Var, bundle, new a(this, bundle, payChannelEntity, channelListView, str), payChannelEntity, str);
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
                    String a2 = f91.a(0, map.get("orderId"), "Successful payment");
                    PopupWindow popupWindow = new PopupWindow(View.inflate(channelListView.getContext(), R.layout.obfuscated_res_0x7f0d0658, null), -1, -1, true);
                    popupWindow.w(false);
                    popupWindow.y(false);
                    popupWindow.B(false);
                    popupWindow.D(channelListView, 0, 0, 0);
                    new Handler().postDelayed(new f(this, popupWindow, channelListView, a2), 2000L);
                    v81.h("8");
                    i91.g("WalletList->pay() 命中0单元");
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
            i91.g("processDirectOuter ------ payChannel=" + payChannelEntity.getPayChannel());
            String str = map.get("extData");
            if (!TextUtils.isEmpty(str)) {
                try {
                    String optString = new JSONObject(str).optString("actionType");
                    StringBuilder sb = new StringBuilder();
                    sb.append("processWxH5Pay actionType=");
                    sb.append(optString);
                    i91.g(sb.toString());
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
            r81.h().g(queryOrderString, new c(this, queryOrderString, channelListView));
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
                s81.b().e(new b(this, channelListView));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void r(Map<String, String> map, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, map, channelListView) == null) {
            String str = map.get("orderId");
            z81.e = str;
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
                            v81.h("8");
                            channelListView.b0(1, e91.d(str, str3, "wx H5 paying"), "");
                        } else {
                            v81.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-101", "没有安装微信");
                            Toast.makeText(channelListView.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            channelListView.b0(3, e91.d(str, str3, "wx_not_installed"), "0");
                        }
                    } else {
                        channelListView.S(e91.d(str, str3, "H5 no corresponding url "), null);
                        v81.b("8", null, "H5 no corresponding url");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                channelListView.S(e91.d(str, "", "launchpayment extData analyze failed "), null);
                v81.b("8", null, "launchpayment extData analyze failed");
            }
        }
    }

    public void s(w91 w91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, w91Var) == null) {
            this.b = w91Var;
        }
    }

    public final void t(String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, channelListView) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            this.d = polyNoticeDialog;
            polyNoticeDialog.setCancelable(false);
            this.d.c(new e(this, channelListView, str));
            this.d.show(((Activity) channelListView.getContext()).getFragmentManager(), "QUERY_ORDER_NOTICE_FRAGMENT_TAG");
            z81.e(new w81(TbEnum.SystemMessage.EVENT_ID_COMMON));
        }
    }

    public final void u(ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, channelListView) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            polyNoticeDialog.setCancelable(true);
            polyNoticeDialog.c(new d(this, polyNoticeDialog));
            polyNoticeDialog.show(((Activity) channelListView.getContext()).getFragmentManager(), "PAY_FAILED_NOTICE_FRAGMENT_TAG");
        }
    }
}
