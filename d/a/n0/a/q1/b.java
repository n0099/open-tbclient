package d.a.n0.a.q1;

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
import d.a.n0.a.e2.c.j.b;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.j2.k;
import d.a.n0.a.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements d.a.n0.a.q1.g.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.a.a2.e f46798a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f46799b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f46800c;

    /* renamed from: d  reason: collision with root package name */
    public String f46801d;

    /* renamed from: e  reason: collision with root package name */
    public String f46802e;

    /* renamed from: f  reason: collision with root package name */
    public int f46803f;

    /* renamed from: g  reason: collision with root package name */
    public String f46804g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c0.a f46805h;

    /* renamed from: i  reason: collision with root package name */
    public String f46806i;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46807e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46808f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46809g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f46810h;

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
            this.f46810h = bVar;
            this.f46807e = z;
            this.f46808f = str;
            this.f46809g = str2;
        }

        @Override // d.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f46807e) {
                        k.M("success", 9, this.f46808f);
                    }
                    this.f46810h.B(this.f46809g);
                    return;
                }
                if (!this.f46807e) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.f46808f);
                }
                this.f46810h.f46803f = 5;
                this.f46810h.f46804g = null;
                this.f46810h.K(null);
            }
        }
    }

    /* renamed from: d.a.n0.a.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0870b implements d.a.c0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f46811a;

        public C0870b(b bVar) {
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
            this.f46811a = bVar;
        }

        @Override // d.a.c0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f46811a.f46803f = i2;
                this.f46811a.f46804g = str;
                if (b.j) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + i2 + " ,result:" + str);
                }
                this.f46811a.M(i2, "baiduqianbao", str);
                k.F("baiduqianbao", "result", i2);
                if (i2 != 0 || !TextUtils.equals(this.f46811a.f46801d, "2.0")) {
                    this.f46811a.K(null);
                } else {
                    d.a.n0.a.c1.a.R().e(this.f46811a.f46802e, this.f46811a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.c0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f46812a;

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
            this.f46812a = bVar;
        }

        @Override // d.a.c0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f46812a.f46803f = i2;
                this.f46812a.f46804g = str;
                d.a.n0.a.e0.d.h("SwanAppPaymentManager", "statusCode: " + this.f46812a.f46803f + " ,result:" + this.f46812a.f46804g);
                this.f46812a.M(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
                if (i2 != 1) {
                    k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
                }
                if (i2 != 0 || !TextUtils.equals(this.f46812a.f46801d, "2.0")) {
                    this.f46812a.K(null);
                } else {
                    d.a.n0.a.c1.a.R().e(this.f46812a.f46802e, this.f46812a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46813e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46814f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f46815g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46816h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f46817i;
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
            this.f46813e = str;
            this.f46814f = str2;
            this.f46815g = strArr;
            this.f46816h = jSONObject;
            this.f46817i = z;
        }

        @Override // d.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    k.M("success", 8, this.f46813e);
                    if (this.j.f46798a.m0()) {
                        this.j.F(this.f46814f, this.f46815g, this.f46816h, true, false);
                        return;
                    } else {
                        this.j.C(this.f46814f, this.f46815g, this.f46816h, true, false);
                        return;
                    }
                }
                if (!this.f46817i) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.f46813e);
                    d.a.n0.a.e0.d.h("SwanAppPaymentManager", "login error");
                    k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.n0.a.q1.a.c("", "login error"));
                }
                this.j.f46803f = 5;
                this.j.f46804g = null;
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
        public final /* synthetic */ String f46818a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f46819b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46820c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f46821d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46822e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f46823f;

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
            this.f46823f = bVar;
            this.f46818a = str;
            this.f46819b = strArr;
            this.f46820c = jSONObject;
            this.f46821d = z;
            this.f46822e = z2;
        }

        @Override // d.a.n0.a.q1.b.j
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(this.f46823f.f46806i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f46823f.f46800c;
            String str2 = this.f46823f.f46806i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f46823f.f46798a.x().getString(d.a.n0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // d.a.n0.a.q1.b.j
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f46823f.C(this.f46818a, this.f46819b, this.f46820c, this.f46821d, this.f46822e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46824e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f46825f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46826g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46827h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f46828i;

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
            this.f46828i = bVar;
            this.f46824e = jSONObject;
            this.f46825f = strArr;
            this.f46826g = jSONObject2;
            this.f46827h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f46828i.D(this.f46824e, this.f46825f, this.f46826g);
                    return null;
                }
                d.a.n0.a.e0.d.h("SwanAppPaymentManager", "paykey invalid order info " + this.f46827h);
                k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.n0.a.q1.a.c("", "paykey invalid"));
                this.f46828i.L();
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements d.a.n0.a.q1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46829a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46830b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f46831c;

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
            this.f46831c = bVar;
            this.f46829a = jSONObject;
            this.f46830b = jSONObject2;
        }

        @Override // d.a.n0.a.q1.d
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f46831c.J(i2, str, this.f46829a, this.f46830b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements d.a.c0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46832a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46833b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f46834c;

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
            this.f46834c = bVar;
            this.f46832a = jSONObject;
            this.f46833b = jSONObject2;
        }

        @Override // d.a.c0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f46834c.J(i2, str, this.f46832a, this.f46833b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46835e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46836f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46837g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f46838h;

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
            this.f46838h = bVar;
            this.f46835e = str;
            this.f46836f = str2;
            this.f46837g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                char c2 = 0;
                if (!d.a.n0.a.e2.c.d.h(iVar)) {
                    String str = null;
                    if (TextUtils.equals(this.f46838h.f46801d, "2.0")) {
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
                    if (TextUtils.equals(this.f46835e, "mapp_request_duxiaoman")) {
                        k.D(false, "baiduqianbao", d.a.n0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f46835e, "mapp_request_alipayment")) {
                        k.D(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, d.a.n0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f46835e, "mapp_request_wechatpayment")) {
                        k.D(false, "wechatH5Action", d.a.n0.a.q1.a.c("", "authorize fail"));
                    }
                    d.a.n0.a.e0.d.h("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f46835e);
                    this.f46838h.f46800c.handleSchemeDispatchCallback(this.f46838h.f46806i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.f46835e;
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
                    this.f46838h.z(this.f46836f, this.f46837g);
                } else if (c2 == 1) {
                    this.f46838h.x(this.f46836f);
                } else if (c2 != 2) {
                } else {
                    this.f46838h.N();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(714816882, "Ld/a/n0/a/q1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(714816882, "Ld/a/n0/a/q1/b;");
                return;
            }
        }
        j = d.a.n0.a.k.f45831a;
        k = new String[]{"duershow"};
    }

    public b(d.a.n0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
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
        this.f46798a = eVar;
        this.f46799b = unitedSchemeEntity;
        this.f46800c = callbackHandler;
        this.f46801d = str;
        this.f46802e = str2;
        this.f46806i = str3;
        this.f46805h = new d.a.c0.a();
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
                this.f46799b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.n0.a.e0.d.h("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.f46798a.T().g(this.f46798a.x(), str, new i(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.f46800c, this.f46799b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            k.F("baiduqianbao", "intoPayment", 0);
            this.f46805h.d(this.f46798a.k(), str, new C0870b(this));
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
                if (d.a.n0.a.s.a.f.f47208d.f()) {
                    jSONObject.put("openBduss", d.a.n0.a.c1.a.a0().d(d.a.n0.a.c1.a.b()));
                    jSONObject.put("clientId", d.a.n0.a.c1.a.m().b());
                } else {
                    jSONObject.put("bduss", d.a.n0.a.c1.a.a0().d(d.a.n0.a.c1.a.b()));
                }
                jSONObject.put("cuid", d.a.n0.a.c1.a.a0().i(d.a.n0.a.c1.a.b()));
                String optString = jSONObject.optString("bizInfo");
                JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
                jSONObject3.put("swanFrom", this.f46798a.L().T());
                jSONObject3.put("cuid", d.a.n0.a.c1.a.a0().i(d.a.n0.a.c1.a.b()));
                jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.n0.a.a2.d.g().getAppId());
                w(jSONObject3);
                jSONObject.put("bizInfo", jSONObject3.toString());
                jSONObject.put("platformId", "100003");
                jSONObject.put("nativeAppId", d.a.n0.a.c1.a.m().a());
                jSONObject.put("sceneSource", "swan");
                jSONObject.put("swanNativeVersion", l.a());
                y(jSONObject, this.f46798a.D());
                if (j) {
                    Log.i("SwanAppPaymentManager", jSONObject.toString());
                }
            } catch (JSONException e2) {
                if (d.a.n0.a.k.f45831a) {
                    e2.printStackTrace();
                }
            }
            d.a.n0.a.g1.f.V().p();
            String[] strArr2 = k;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (strArr2[i2].equals(d.a.n0.a.c1.a.m().a())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            k.F(BeanConstants.CHANNEL_ID_NUOMI, "intoPayment", 0);
            if (z) {
                String a2 = d.a.n0.t.i.a(d.a.n0.t.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
                d.a.n0.a.h0.g.k.Q2("qrCodePay", d.a.n0.a.l1.b.g(a2, a2));
                d.a.n0.a.q1.e.b(new g(this, jSONObject2, jSONObject));
                d.a.n0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject.toString());
            } else {
                this.f46805h.i(this.f46798a.x(), jSONObject, strArr, new h(this, jSONObject2, jSONObject));
                d.a.n0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay: " + jSONObject.toString());
            }
            UnitedSchemeUtility.callCallback(this.f46800c, this.f46799b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.f46798a.z() != null) {
                String valueOf = String.valueOf(this.f46798a.L().G());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f46798a.L().W()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f46798a.L().H());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e3) {
                    if (j) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                    }
                }
                this.f46798a.z().N(7, bundle);
            }
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                d.a.n0.a.n1.q.c.d.b(jSONObject2.optString("appKey"), new f(this, jSONObject2, strArr, jSONObject, str));
            } catch (JSONException e2) {
                L();
                d.a.n0.a.e0.d.h("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (d.a.n0.a.k.f45831a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d.a.n0.a.c1.b.e().a(str, new e(this, str, strArr, jSONObject, z, z2));
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
            boolean e2 = this.f46798a.j().e(this.f46798a.x());
            if (!e2) {
                k.M("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.f46799b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            d.a.n0.a.t1.d.a.a("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                d.a.n0.a.t1.c.c.a aVar = new d.a.n0.a.t1.c.c.a(jSONObject.optString("componentId"));
                aVar.f47387a = optString3;
                aVar.f47389c = opt;
                aVar.f47390d = false;
                aVar.f47391e = null;
                aVar.b();
                d.a.n0.a.e0.d.h("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.n0.a.q1.a.c("", "param check error - plugin pay contains custom error"));
                this.f46799b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
            if (this.f46798a.x() == null) {
                this.f46803f = 5;
                this.f46804g = null;
                K(null);
                if (j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.f46798a.j().e(this.f46798a.k())) {
                if (this.f46798a.m0()) {
                    F(str, strArr, jSONObject, true, true);
                    return true;
                }
                C(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.f46798a.j().f(this.f46798a.k(), null, new d(this, str2, str, strArr, jSONObject, e2));
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void J(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), str, jSONObject, jSONObject2}) == null) {
            d.a.n0.a.g1.f.V().b();
            d.a.n0.a.e0.d.g("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f46803f + " params: " + this.f46804g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            M(i2, BeanConstants.CHANNEL_ID_NUOMI, G(str, jSONObject2));
            this.f46803f = i2;
            this.f46804g = str;
            if (i2 != 1) {
                k.F(BeanConstants.CHANNEL_ID_NUOMI, "result", i2);
            }
            K(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                d.a.n0.a.t1.c.c.a aVar = new d.a.n0.a.t1.c.c.a(optString2);
                aVar.f47387a = optString;
                aVar.f47389c = opt;
                aVar.f47390d = i2 == 0;
                aVar.f47391e = str;
                aVar.b();
                d.a.n0.a.t1.g.b.j();
            }
            if (this.f46803f != 0 || d.a.n0.a.x1.c.f48388c.c()) {
                return;
            }
            d.a.n0.a.x1.c.f48388c.e();
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (TextUtils.equals(this.f46801d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.f46804g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.f46804g.getBytes("UTF-8"), 2));
                    }
                    d.a.n0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f46803f);
                    this.f46800c.handleSchemeDispatchCallback(this.f46806i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f46803f, H(this.f46803f)).toString());
                    return;
                }
                d.a.n0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f46804g + " status code = " + this.f46803f);
                this.f46800c.handleSchemeDispatchCallback(this.f46806i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f46804g, this.f46803f, H(this.f46803f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                d.a.n0.a.e0.d.g("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.f46800c;
                String str2 = this.f46806i;
                int i2 = this.f46803f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, H(i2)).toString());
            }
        }
    }

    public final void L() {
        d.a.n0.a.a2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (eVar = this.f46798a) == null) {
            return;
        }
        d.a.n0.a.z1.b.f.e.f(eVar.x(), d.a.n0.a.h.swanapp_payment_illegal).F();
        if (TextUtils.isEmpty(this.f46806i)) {
            return;
        }
        this.f46800c.handleSchemeDispatchCallback(this.f46806i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f46798a.x().getString(d.a.n0.a.h.swanapp_payment_illegal)).toString());
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
            d.a.n0.a.e0.d.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (d.a.n0.a.q1.a.b().e(this.f46798a, this.f46800c, this.f46799b)) {
                this.f46803f = 0;
                this.f46804g = null;
                if (TextUtils.equals(this.f46801d, "2.0")) {
                    d.a.n0.a.c1.a.R().e(this.f46802e, this);
                } else {
                    K(null);
                }
                k.C("wechatH5Action", null, null);
                return true;
            }
            d.a.n0.a.e0.d.h("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f46799b.toString());
            this.f46800c.handleSchemeDispatchCallback(this.f46806i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.x1.a
    public void a(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            d.a.n0.a.e0.d.b("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                d.a.n0.a.e0.d.b("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            K(str);
            if (d.a.n0.a.x1.c.f48388c.c()) {
                return;
            }
            if (d.a.n0.a.c1.a.a0().e(this.f46798a)) {
                d.a.n0.a.x1.c.f48388c.e();
            } else {
                d.a.n0.a.x1.c.f48388c.f();
            }
        }
    }

    @Override // d.a.n0.a.x1.a
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            d.a.n0.a.e0.d.b("SwanAppPaymentManager", "Fail: request payId failed");
            d.a.n0.a.e0.d.b("SwanAppPaymentManager", str);
            K(null);
        }
    }

    public final JSONObject w(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
            if (this.f46798a.m0() && jSONObject != null) {
                b.a L = this.f46798a.L();
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
            this.f46805h.c(this.f46798a.k(), str, new c(this));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void y(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, jSONObject, str) == null) {
            PMSAppInfo s = d.a.n0.n.g.a.h().s(str);
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
            if (this.f46798a.j().e(this.f46798a.k())) {
                B(str);
                return true;
            }
            d.a.n0.a.a2.e eVar = this.f46798a;
            if (eVar == null) {
                return false;
            }
            boolean e2 = eVar.j().e(this.f46798a.x());
            if (!e2) {
                k.M("show", 9, str2);
            }
            this.f46798a.j().f(this.f46798a.k(), null, new a(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
