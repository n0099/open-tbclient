package d.a.o0.a.q1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.f1.e.b;
import d.a.o0.a.j2.k;
import d.a.o0.a.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements d.a.o0.a.q1.g.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.a2.e f47302a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f47303b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f47304c;

    /* renamed from: d  reason: collision with root package name */
    public String f47305d;

    /* renamed from: e  reason: collision with root package name */
    public String f47306e;

    /* renamed from: f  reason: collision with root package name */
    public int f47307f;

    /* renamed from: g  reason: collision with root package name */
    public String f47308g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.d0.a f47309h;

    /* renamed from: i  reason: collision with root package name */
    public String f47310i;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47311e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47312f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47313g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f47314h;

        public a(b bVar, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47314h = bVar;
            this.f47311e = z;
            this.f47312f = str;
            this.f47313g = str2;
        }

        @Override // d.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f47311e) {
                        k.M("success", 9, this.f47312f);
                    }
                    this.f47314h.B(this.f47313g);
                    return;
                }
                if (!this.f47311e) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.f47312f);
                }
                this.f47314h.f47307f = 5;
                this.f47314h.f47308g = null;
                this.f47314h.K(null);
            }
        }
    }

    /* renamed from: d.a.o0.a.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0879b implements d.a.d0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47315a;

        public C0879b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47315a = bVar;
        }

        @Override // d.a.d0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f47315a.f47307f = i2;
                this.f47315a.f47308g = str;
                if (b.j) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + i2 + " ,result:" + str);
                }
                this.f47315a.M(i2, "baiduqianbao", str);
                k.F("baiduqianbao", "result", i2);
                if (i2 != 0 || !TextUtils.equals(this.f47315a.f47305d, "2.0")) {
                    this.f47315a.K(null);
                } else {
                    d.a.o0.a.c1.a.R().e(this.f47315a.f47306e, this.f47315a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.d0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47316a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47316a = bVar;
        }

        @Override // d.a.d0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f47316a.f47307f = i2;
                this.f47316a.f47308g = str;
                d.a.o0.a.e0.d.h("SwanAppPaymentManager", "statusCode: " + this.f47316a.f47307f + " ,result:" + this.f47316a.f47308g);
                this.f47316a.M(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
                if (i2 != 1) {
                    k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
                }
                if (i2 != 0 || !TextUtils.equals(this.f47316a.f47305d, "2.0")) {
                    this.f47316a.K(null);
                } else {
                    d.a.o0.a.c1.a.R().e(this.f47316a.f47306e, this.f47316a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47317e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47318f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f47319g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47320h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f47321i;
        public final /* synthetic */ b j;

        public d(b bVar, String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, strArr, jSONObject, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = bVar;
            this.f47317e = str;
            this.f47318f = str2;
            this.f47319g = strArr;
            this.f47320h = jSONObject;
            this.f47321i = z;
        }

        @Override // d.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    k.M("success", 8, this.f47317e);
                    if (this.j.f47302a.m0()) {
                        this.j.F(this.f47318f, this.f47319g, this.f47320h, true, false);
                        return;
                    } else {
                        this.j.C(this.f47318f, this.f47319g, this.f47320h, true, false);
                        return;
                    }
                }
                if (!this.f47321i) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.f47317e);
                    d.a.o0.a.e0.d.h("SwanAppPaymentManager", "login error");
                    k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.o0.a.q1.a.c("", "login error"));
                }
                this.j.f47307f = 5;
                this.j.f47308g = null;
                this.j.K(null);
                k.E(BeanConstants.CHANNEL_ID_NUOMI, false, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47322a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f47323b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47324c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f47325d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f47327f;

        public e(b bVar, String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47327f = bVar;
            this.f47322a = str;
            this.f47323b = strArr;
            this.f47324c = jSONObject;
            this.f47325d = z;
            this.f47326e = z2;
        }

        @Override // d.a.o0.a.q1.b.j
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(this.f47327f.f47310i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f47327f.f47304c;
            String str2 = this.f47327f.f47310i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f47327f.f47302a.x().getString(d.a.o0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // d.a.o0.a.q1.b.j
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f47327f.C(this.f47322a, this.f47323b, this.f47324c, this.f47325d, this.f47326e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f47329f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47330g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47331h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f47332i;

        public f(b bVar, JSONObject jSONObject, String[] strArr, JSONObject jSONObject2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, jSONObject, strArr, jSONObject2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47332i = bVar;
            this.f47328e = jSONObject;
            this.f47329f = strArr;
            this.f47330g = jSONObject2;
            this.f47331h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f47332i.D(this.f47328e, this.f47329f, this.f47330g);
                    return null;
                }
                d.a.o0.a.e0.d.h("SwanAppPaymentManager", "paykey invalid order info " + this.f47331h);
                k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.o0.a.q1.a.c("", "paykey invalid"));
                this.f47332i.L();
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements d.a.o0.a.q1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47333a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47334b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f47335c;

        public g(b bVar, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, jSONObject, jSONObject2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47335c = bVar;
            this.f47333a = jSONObject;
            this.f47334b = jSONObject2;
        }

        @Override // d.a.o0.a.q1.d
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f47335c.J(i2, str, this.f47333a, this.f47334b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements d.a.d0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47336a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47337b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f47338c;

        public h(b bVar, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, jSONObject, jSONObject2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47338c = bVar;
            this.f47336a = jSONObject;
            this.f47337b = jSONObject2;
        }

        @Override // d.a.d0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f47338c.J(i2, str, this.f47336a, this.f47337b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47340f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47341g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f47342h;

        public i(b bVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47342h = bVar;
            this.f47339e = str;
            this.f47340f = str2;
            this.f47341g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                char c2 = 0;
                if (!d.a.o0.a.e2.c.d.h(iVar)) {
                    String str = null;
                    if (TextUtils.equals(this.f47342h.f47305d, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("payId", "");
                        } catch (JSONException e2) {
                            if (b.j) {
                                e2.printStackTrace();
                            }
                        }
                        str = String.valueOf(jSONObject);
                    }
                    if (TextUtils.equals(this.f47339e, "mapp_request_duxiaoman")) {
                        k.D(false, "baiduqianbao", d.a.o0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f47339e, "mapp_request_alipayment")) {
                        k.D(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, d.a.o0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f47339e, "mapp_request_wechatpayment")) {
                        k.D(false, "wechatH5Action", d.a.o0.a.q1.a.c("", "authorize fail"));
                    }
                    d.a.o0.a.e0.d.h("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f47339e);
                    this.f47342h.f47304c.handleSchemeDispatchCallback(this.f47342h.f47310i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.f47339e;
                int hashCode = str2.hashCode();
                if (hashCode == -1689456891) {
                    if (str2.equals("mapp_request_wechatpayment")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else if (hashCode != -1250772529) {
                    if (hashCode == 1111965155 && str2.equals("mapp_request_alipayment")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    this.f47342h.z(this.f47340f, this.f47341g);
                } else if (c2 == 1) {
                    this.f47342h.x(this.f47340f);
                } else if (c2 != 2) {
                } else {
                    this.f47342h.N();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void onFail(String str);

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(518303377, "Ld/a/o0/a/q1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(518303377, "Ld/a/o0/a/q1/b;");
                return;
            }
        }
        j = d.a.o0.a.k.f46335a;
        k = new String[]{"duershow"};
    }

    public b(d.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, unitedSchemeEntity, callbackHandler, str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47302a = eVar;
        this.f47303b = unitedSchemeEntity;
        this.f47304c = callbackHandler;
        this.f47305d = str;
        this.f47306e = str2;
        this.f47310i = str3;
        this.f47309h = new d.a.d0.a();
    }

    public static String H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 != 0 ? i2 != 2 ? EventAlias.PayEventAlias.PAY_FAIL : "支付取消" : EventAlias.PayEventAlias.PAY_SUCCESS : (String) invokeI.objValue;
    }

    public boolean A(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
                this.f47303b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.o0.a.e0.d.h("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.f47302a.T().g(this.f47302a.x(), str, new i(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.f47304c, this.f47303b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            k.F("baiduqianbao", "intoPayment", 0);
            this.f47309h.d(this.f47302a.k(), str, new C0879b(this));
        }
    }

    public final void C(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            E(str, strArr, jSONObject);
            k.E(BeanConstants.CHANNEL_ID_NUOMI, z, z2);
        }
    }

    public final void D(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, jSONObject, strArr, jSONObject2) == null) {
            try {
                if (d.a.o0.a.s.a.f.f47712d.f()) {
                    jSONObject.put("openBduss", d.a.o0.a.c1.a.a0().d(d.a.o0.a.c1.a.b()));
                    jSONObject.put("clientId", d.a.o0.a.c1.a.m().b());
                } else {
                    jSONObject.put("bduss", d.a.o0.a.c1.a.a0().d(d.a.o0.a.c1.a.b()));
                }
                jSONObject.put("cuid", d.a.o0.a.c1.a.a0().i(d.a.o0.a.c1.a.b()));
                String optString = jSONObject.optString("bizInfo");
                JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
                jSONObject3.put("swanFrom", this.f47302a.L().T());
                jSONObject3.put("cuid", d.a.o0.a.c1.a.a0().i(d.a.o0.a.c1.a.b()));
                jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.o0.a.a2.d.g().getAppId());
                w(jSONObject3);
                jSONObject.put("bizInfo", jSONObject3.toString());
                jSONObject.put("platformId", "100003");
                jSONObject.put("nativeAppId", d.a.o0.a.c1.a.m().a());
                jSONObject.put("sceneSource", "swan");
                jSONObject.put("swanNativeVersion", l.a());
                y(jSONObject, this.f47302a.D());
                if (j) {
                    Log.i("SwanAppPaymentManager", jSONObject.toString());
                }
            } catch (JSONException e2) {
                if (d.a.o0.a.k.f46335a) {
                    e2.printStackTrace();
                }
            }
            d.a.o0.a.g1.f.V().p();
            String[] strArr2 = k;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (strArr2[i2].equals(d.a.o0.a.c1.a.m().a())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            k.F(BeanConstants.CHANNEL_ID_NUOMI, "intoPayment", 0);
            if (z) {
                String a2 = d.a.o0.t.i.a(d.a.o0.t.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
                d.a.o0.a.h0.g.k.Q2("qrCodePay", d.a.o0.a.l1.b.g(a2, a2));
                d.a.o0.a.q1.e.b(new g(this, jSONObject2, jSONObject));
                d.a.o0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject.toString());
            } else {
                this.f47309h.i(this.f47302a.x(), jSONObject, strArr, new h(this, jSONObject2, jSONObject));
                d.a.o0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay: " + jSONObject.toString());
            }
            UnitedSchemeUtility.callCallback(this.f47304c, this.f47303b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.f47302a.z() != null) {
                String valueOf = String.valueOf(this.f47302a.L().G());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f47302a.L().W()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f47302a.L().H());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e3) {
                    if (j) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                    }
                }
                this.f47302a.z().N(7, bundle);
            }
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                d.a.o0.a.n1.q.c.d.b(jSONObject2.optString("appKey"), new f(this, jSONObject2, strArr, jSONObject, str));
            } catch (JSONException e2) {
                L();
                d.a.o0.a.e0.d.h("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (d.a.o0.a.k.f46335a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d.a.o0.a.c1.b.e().a(str, new e(this, str, strArr, jSONObject, z, z2));
        }
    }

    public final String G(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, jSONObject)) == null) {
            String optString = jSONObject.optString("tpOrderId");
            try {
                return new JSONObject(str).put("orderId", optString).toString();
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
                return str + " orderId = " + optString;
            }
        }
        return (String) invokeLL.objValue;
    }

    public boolean I(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        String[] strArr;
        Object opt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, jSONObject)) == null) {
            String optString = jSONObject.optString("invokeFrom");
            if (TextUtils.isEmpty(optString)) {
                optString = RetrieveTaskManager.KEY;
            }
            String str2 = optString;
            boolean e2 = this.f47302a.j().e(this.f47302a.x());
            if (!e2) {
                k.M("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.f47303b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            d.a.o0.a.t1.d.a.a("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                d.a.o0.a.t1.c.c.a aVar = new d.a.o0.a.t1.c.c.a(jSONObject.optString("componentId"));
                aVar.f47891a = optString3;
                aVar.f47893c = opt;
                aVar.f47894d = false;
                aVar.f47895e = null;
                aVar.b();
                d.a.o0.a.e0.d.h("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.o0.a.q1.a.c("", "param check error - plugin pay contains custom error"));
                this.f47303b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("bannedChannels");
            if (optJSONArray != null) {
                String[] strArr2 = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    strArr2[i2] = String.valueOf(optJSONArray.opt(i2));
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            k.F(BeanConstants.CHANNEL_ID_NUOMI, "login", 0);
            if (this.f47302a.x() == null) {
                this.f47307f = 5;
                this.f47308g = null;
                K(null);
                if (j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.f47302a.j().e(this.f47302a.k())) {
                if (this.f47302a.m0()) {
                    F(str, strArr, jSONObject, true, true);
                    return true;
                }
                C(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.f47302a.j().f(this.f47302a.k(), null, new d(this, str2, str, strArr, jSONObject, e2));
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void J(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), str, jSONObject, jSONObject2}) == null) {
            d.a.o0.a.g1.f.V().b();
            d.a.o0.a.e0.d.g("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f47307f + " params: " + this.f47308g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            M(i2, BeanConstants.CHANNEL_ID_NUOMI, G(str, jSONObject2));
            this.f47307f = i2;
            this.f47308g = str;
            if (i2 != 1) {
                k.F(BeanConstants.CHANNEL_ID_NUOMI, "result", i2);
            }
            K(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                d.a.o0.a.t1.c.c.a aVar = new d.a.o0.a.t1.c.c.a(optString2);
                aVar.f47891a = optString;
                aVar.f47893c = opt;
                aVar.f47894d = i2 == 0;
                aVar.f47895e = str;
                aVar.b();
                d.a.o0.a.t1.g.b.j();
            }
            if (this.f47307f != 0 || d.a.o0.a.x1.c.f48892c.c()) {
                return;
            }
            d.a.o0.a.x1.c.f48892c.e();
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (TextUtils.equals(this.f47305d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.f47308g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.f47308g.getBytes("UTF-8"), 2));
                    }
                    d.a.o0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f47307f);
                    this.f47304c.handleSchemeDispatchCallback(this.f47310i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f47307f, H(this.f47307f)).toString());
                    return;
                }
                d.a.o0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f47308g + " status code = " + this.f47307f);
                this.f47304c.handleSchemeDispatchCallback(this.f47310i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f47308g, this.f47307f, H(this.f47307f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                d.a.o0.a.e0.d.g("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.f47304c;
                String str2 = this.f47310i;
                int i2 = this.f47307f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, H(i2)).toString());
            }
        }
    }

    public final void L() {
        d.a.o0.a.a2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (eVar = this.f47302a) == null) {
            return;
        }
        d.a.o0.a.z1.b.f.e.f(eVar.x(), d.a.o0.a.h.swanapp_payment_illegal).F();
        if (TextUtils.isEmpty(this.f47310i)) {
            return;
        }
        this.f47304c.handleSchemeDispatchCallback(this.f47310i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f47302a.x().getString(d.a.o0.a.h.swanapp_payment_illegal)).toString());
    }

    public final void M(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i2, str, str2) == null) {
            k.D(i2 == 0, str, str2);
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d.a.o0.a.e0.d.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (d.a.o0.a.q1.a.b().e(this.f47302a, this.f47304c, this.f47303b)) {
                this.f47307f = 0;
                this.f47308g = null;
                if (TextUtils.equals(this.f47305d, "2.0")) {
                    d.a.o0.a.c1.a.R().e(this.f47306e, this);
                } else {
                    K(null);
                }
                k.C("wechatH5Action", null, null);
                return true;
            }
            d.a.o0.a.e0.d.h("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f47303b.toString());
            this.f47304c.handleSchemeDispatchCallback(this.f47310i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.o0.a.x1.a
    public void a(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            d.a.o0.a.e0.d.b("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                d.a.o0.a.e0.d.b("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            K(str);
            if (d.a.o0.a.x1.c.f48892c.c()) {
                return;
            }
            if (d.a.o0.a.c1.a.a0().e(this.f47302a)) {
                d.a.o0.a.x1.c.f48892c.e();
            } else {
                d.a.o0.a.x1.c.f48892c.f();
            }
        }
    }

    @Override // d.a.o0.a.x1.a
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            d.a.o0.a.e0.d.b("SwanAppPaymentManager", "Fail: request payId failed");
            d.a.o0.a.e0.d.b("SwanAppPaymentManager", str);
            K(null);
        }
    }

    public final JSONObject w(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
            if (this.f47302a.m0() && jSONObject != null) {
                b.a L = this.f47302a.L();
                if (L.M() == null) {
                    return jSONObject;
                }
                JSONObject M = L.M();
                String optString = M.optString(TiebaStatic.Params.LOGID);
                String optString2 = M.optString("module_id");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    try {
                        jSONObject.put(TiebaStatic.Params.LOGID, optString);
                        jSONObject.put("module_id", optString2);
                    } catch (JSONException e2) {
                        if (j) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (j) {
                Log.d("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
            }
            k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "intoPayment", 0);
            this.f47309h.c(this.f47302a.k(), str, new c(this));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void y(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, jSONObject, str) == null) {
            PMSAppInfo s = d.a.o0.n.g.a.h().s(str);
            int i2 = s == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : s.payProtected;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("baoStatus", i2);
            jSONObject2.put("sappId", 10001);
            jSONObject2.put("objectId", str);
            jSONObject.put("baoInfo", jSONObject2.toString());
        }
    }

    public final boolean z(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) {
            if (this.f47302a.j().e(this.f47302a.k())) {
                B(str);
                return true;
            }
            d.a.o0.a.a2.e eVar = this.f47302a;
            if (eVar == null) {
                return false;
            }
            boolean e2 = eVar.j().e(this.f47302a.x());
            if (!e2) {
                k.M("show", 9, str2);
            }
            this.f47302a.j().f(this.f47302a.k(), null, new a(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
