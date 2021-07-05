package d.a.f0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.g0.a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static d.a.g0.a f45307a = null;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.g0.o.a.a f45308b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f45309c = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0617a extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.f0.e.a f45310a;

        public C0617a(a aVar, d.a.f0.e.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45310a = aVar2;
        }

        @Override // d.a.g0.a.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (i2 == 3) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put("statusCode", 6);
                        this.f45310a.onPayResult(6, jSONObject.toString());
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        this.f45310a.onPayResult(6, str);
                        return;
                    }
                }
                this.f45310a.onPayResult(i2, str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements d.a.g0.o.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.a.f0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0618a implements d.a.f0.e.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.g0.o.a.a f45311a;

            public C0618a(b bVar, d.a.g0.o.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45311a = aVar;
            }

            @Override // d.a.f0.e.a
            public void onPayResult(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                    a.f(this.f45311a, i2, str);
                }
            }
        }

        /* renamed from: d.a.f0.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0619b implements d.a.f0.e.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.g0.o.a.a f45312a;

            public C0619b(b bVar, d.a.g0.o.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45312a = aVar;
            }

            @Override // d.a.f0.e.a
            public void onPayResult(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                    a.f(this.f45312a, i2, str);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements d.a.f0.e.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.g0.o.a.a f45313a;

            public c(b bVar, d.a.g0.o.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45313a = aVar;
            }

            @Override // d.a.f0.e.a
            public void onPayResult(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                    a.f(this.f45313a, i2, str);
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.g0.o.a.c
        public void a(Activity activity, d.a.g0.o.a.b bVar, d.a.g0.o.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bVar, aVar) == null) {
                if (bVar == null || TextUtils.isEmpty(bVar.f45498a) || bVar.f45499b == null) {
                    a.f(aVar, 6, "支付信息不能为空");
                    return;
                }
                String str = bVar.f45498a;
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1537577171:
                        if (str.equals("BAIDU-QUICKPAY")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1021180251:
                        if (str.equals("BAIDU-ALIPAY-WISE-HUABEI-PAY")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 299450696:
                        if (str.equals(PayChannelController.BAIFUBAO_PAYCHANNEL)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1455583605:
                        if (str.equals(PayChannelController.ALIPAY_PAYCHANNEL)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1525377225:
                        if (str.equals("BAIDU-CHINAPAY-B2C")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 2009937959:
                        if (str.equals(PayChannelController.WXPAY_PAYCHANNEL)) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                if (c2 == 0 || c2 == 1) {
                    d.a.f0.c.e().a(activity, bVar.f45499b.optString("orderInfo"), new C0618a(this, aVar));
                } else if (c2 == 2) {
                    d.a.f0.c.e().d(activity, bVar.f45499b, new C0619b(this, aVar));
                } else if (c2 == 3) {
                    d.a.f0.c.e().b(activity, bVar.f45499b.optString("orderInfo"), new c(this, aVar));
                } else if (c2 == 4) {
                    d.a.g0.o.a.a unused = a.f45308b = aVar;
                    d.c();
                    d.a.f0.c.e().c(activity, bVar.f45499b);
                } else {
                    aVar.onResult(3, "未知的支付方式");
                }
                activity.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-469478662, "Ld/a/f0/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-469478662, "Ld/a/f0/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static d.a.g0.a e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            d.a.g0.a aVar = f45307a;
            if (aVar != null) {
                return aVar;
            }
            f45309c = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
            a.C0622a c0622a = new a.C0622a();
            c0622a.g(f45309c);
            c0622a.e(context.getApplicationContext());
            c0622a.f(false);
            d.a.g0.a d2 = c0622a.d();
            f45307a = d2;
            return d2;
        }
        return (d.a.g0.a) invokeL.objValue;
    }

    public static void f(d.a.g0.o.a.a aVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, null, aVar, i2, str) == null) || aVar == null) {
            return;
        }
        int i3 = 2;
        if (i2 == 0) {
            i3 = 0;
        } else if (i2 == 1) {
            i3 = 1;
        } else if (i2 != 2) {
            i3 = 3;
        }
        aVar.onResult(i3, str);
    }

    public static d.a.g0.o.a.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? new b() : (d.a.g0.o.a.c) invokeV.objValue;
    }

    public static void h(int i2, String str) {
        d.a.g0.o.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, null, i2, str) == null) || (aVar = f45308b) == null) {
            return;
        }
        aVar.onResult(i2, str);
        f45308b = null;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c(Activity activity, String str, d.a.f0.e.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, aVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            d.a.f0.b.a().b(activity, str, aVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean d(Activity activity, String str, d.a.f0.e.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, aVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            d.a.f0.b.a().d(activity, str, aVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void i(Activity activity, JSONObject jSONObject, String[] strArr, d.a.f0.e.a aVar) {
        Bundle bundle;
        char c2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, jSONObject, strArr, aVar) == null) {
            String[] strArr2 = strArr;
            if (activity == null) {
                return;
            }
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.optString(next));
            }
            String str = "BAIDU-CHINAPAY-B2C";
            if (strArr2 != null) {
                String[] strArr3 = new String[strArr2.length];
                int i2 = 0;
                while (i2 < strArr2.length) {
                    String str2 = strArr2[i2];
                    switch (str2.hashCode()) {
                        case -2122629326:
                            if (str2.equals("Huabei")) {
                                c3 = 4;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -1708856474:
                            if (str2.equals("WeChat")) {
                                c3 = 1;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -1001747525:
                            if (str2.equals("Quickpay")) {
                                c3 = 3;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1725926417:
                            if (str2.equals("Chinapay")) {
                                c3 = 5;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1865715419:
                            if (str2.equals("BDWallet")) {
                                c3 = 2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1963873898:
                            if (str2.equals("Alipay")) {
                                c3 = 0;
                                break;
                            }
                            c3 = 65535;
                            break;
                        default:
                            c3 = 65535;
                            break;
                    }
                    if (c3 == 0) {
                        strArr3[i2] = PayChannelController.ALIPAY_PAYCHANNEL;
                    } else if (c3 == 1) {
                        strArr3[i2] = PayChannelController.WXPAY_PAYCHANNEL;
                    } else if (c3 == 2) {
                        strArr3[i2] = PayChannelController.BAIFUBAO_PAYCHANNEL;
                    } else if (c3 == 3) {
                        strArr3[i2] = "BAIDU-QUICKPAY";
                    } else if (c3 == 4) {
                        strArr3[i2] = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                    } else if (c3 == 5) {
                        strArr3[i2] = "BAIDU-CHINAPAY-B2C";
                    }
                    i2++;
                    strArr2 = strArr;
                }
                bundle = bundle2;
                bundle.putStringArray("blockedPayChannels", strArr3);
            } else {
                bundle = bundle2;
            }
            String string = bundle.getString("chosenChannel", "");
            if (!TextUtils.isEmpty(string)) {
                switch (string.hashCode()) {
                    case -2122629326:
                        if (string.equals("Huabei")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1708856474:
                        if (string.equals("WeChat")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1001747525:
                        if (string.equals("Quickpay")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1725926417:
                        if (string.equals("Chinapay")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1865715419:
                        if (string.equals("BDWallet")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1963873898:
                        if (string.equals("Alipay")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    str = PayChannelController.ALIPAY_PAYCHANNEL;
                } else if (c2 == 1) {
                    str = PayChannelController.WXPAY_PAYCHANNEL;
                } else if (c2 == 2) {
                    str = PayChannelController.BAIFUBAO_PAYCHANNEL;
                } else if (c2 == 3) {
                    str = "BAIDU-QUICKPAY";
                } else if (c2 == 4) {
                    str = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                } else if (c2 != 5) {
                    str = string;
                }
                bundle.putString("chosenChannel", str);
            }
            bundle.putString("zid", d.a.f0.b.a().e(activity));
            e(activity).a(activity, bundle, g(), new C0617a(this, aVar));
        }
    }

    public void k(JSONObject jSONObject, d.a.g0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, aVar) == null) {
            e(AppRuntime.getAppContext()).b(1, jSONObject, aVar);
        }
    }

    public void l(d.a.g0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            e(AppRuntime.getAppContext()).b(2, null, aVar);
        }
    }
}
