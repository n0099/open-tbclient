package com.repackage;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public IChannelPay b;

    /* loaded from: classes7.dex */
    public class a extends t71<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ChannelListView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ s91 d;

        public a(s91 s91Var, String str, ChannelListView channelListView, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s91Var, str, channelListView, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = s91Var;
            this.a = str;
            this.b = channelListView;
            this.c = str2;
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
                ChannelListView channelListView = this.b;
                channelListView.S(p91.a().getString(R.string.obfuscated_res_0x7f0f0d4a) + message, str);
                z81 z81Var = new z81("1");
                z81Var.b(new SdkException("pay_platform error --> " + str, th).getStackMessage());
                c91.e(z81Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t71
        /* renamed from: d */
        public void c(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("exceptionCode", "0");
                if (!TextUtils.isEmpty(this.a)) {
                    hashMap.put("isFoldChannel", this.a);
                }
                y81.c("8", hashMap);
                this.b.W();
                this.d.f("STEP_INNER", map, this.c, this.b, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements x91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ ChannelListView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ s91 g;

        public b(s91 s91Var, String str, Map map, ChannelListView channelListView, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s91Var, str, map, channelListView, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = s91Var;
            this.a = str;
            this.b = map;
            this.c = channelListView;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        @Override // com.repackage.x91
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                l91.g("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
                if (TextUtils.equals(this.a, "DIRECT_OUTTER")) {
                    this.g.e(i, str, this.b, this.c, this.d);
                    return;
                }
                this.c.c0(i, i91.a(i, this.e, str), "1", this.a, this.b, this.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends t71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(s91 s91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.t71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t71
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }
    }

    public s91(Activity activity, IChannelPay iChannelPay) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, iChannelPay};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = iChannelPay;
    }

    public void b(Bundle bundle, PayChannelEntity payChannelEntity, String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, bundle, payChannelEntity, str, channelListView) == null) || payChannelEntity == null) {
            return;
        }
        String payChannel = payChannelEntity.getPayChannel();
        String installmentPeriod = payChannelEntity.getInstallmentPeriod();
        if (TextUtils.isEmpty(payChannel)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b81.b, payChannel);
        if (!TextUtils.isEmpty(installmentPeriod)) {
            jSONObject.put(b81.c, installmentPeriod);
        }
        bundle.putString("reqData", jSONObject.toString());
        b81.j().u(bundle, new a(this, str, channelListView, payChannel));
    }

    public JSONObject c(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            if (TextUtils.isEmpty(map.get("payInfo"))) {
                return null;
            }
            try {
                return new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void d(Map<String, String> map, PayChannelEntity payChannelEntity, String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, map, payChannelEntity, str, channelListView) == null) {
            try {
                b(m91.a(map), payChannelEntity, str, channelListView);
            } catch (Throwable th) {
                String message = th.getMessage();
                channelListView.S("third pay error msg is " + message, null);
            }
        }
    }

    public final void e(int i, String str, Map<String, String> map, ChannelListView channelListView, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, map, channelListView, str2}) == null) {
            if (!TextUtils.isEmpty(str2) && i == 0) {
                new z71().d(str2, new v71(), new c(this));
            }
            channelListView.b0(i, h91.a(map.get("orderId"), map.get("payInfo"), str), "1");
        }
    }

    public void f(String str, Map<String, String> map, String str2, ChannelListView channelListView, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, str, map, str2, channelListView, str3) == null) {
            y91 y91Var = new y91();
            y91Var.b = c(map);
            y91Var.a = str2;
            String str4 = map.get("payOrderNo");
            c91.f = str4;
            if (this.b != null) {
                y81.d();
                this.b.pay(this.a, y91Var, new b(this, str, map, channelListView, str3, str4, str2));
                l91.g("WalletChannel->thirdPay setIsPreparePaying()");
                channelListView.setIsPreparePaying(false);
            }
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (Activity) invokeV.objValue;
    }
}
