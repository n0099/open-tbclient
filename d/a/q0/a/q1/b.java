package d.a.q0.a.q1;

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
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.j2.k;
import d.a.q0.a.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements d.a.q0.a.q1.g.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.a2.e f50100a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f50101b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f50102c;

    /* renamed from: d  reason: collision with root package name */
    public String f50103d;

    /* renamed from: e  reason: collision with root package name */
    public String f50104e;

    /* renamed from: f  reason: collision with root package name */
    public int f50105f;

    /* renamed from: g  reason: collision with root package name */
    public String f50106g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.f0.a f50107h;

    /* renamed from: i  reason: collision with root package name */
    public String f50108i;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50109e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50110f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50111g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f50112h;

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
            this.f50112h = bVar;
            this.f50109e = z;
            this.f50110f = str;
            this.f50111g = str2;
        }

        @Override // d.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f50109e) {
                        k.M("success", 9, this.f50110f);
                    }
                    this.f50112h.B(this.f50111g);
                    return;
                }
                if (!this.f50109e) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.f50110f);
                }
                this.f50112h.f50105f = 5;
                this.f50112h.f50106g = null;
                this.f50112h.K(null);
            }
        }
    }

    /* renamed from: d.a.q0.a.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0921b implements d.a.f0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50113a;

        public C0921b(b bVar) {
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
            this.f50113a = bVar;
        }

        @Override // d.a.f0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f50113a.f50105f = i2;
                this.f50113a.f50106g = str;
                if (b.j) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + i2 + " ,result:" + str);
                }
                this.f50113a.M(i2, "baiduqianbao", str);
                k.F("baiduqianbao", "result", i2);
                if (i2 != 0 || !TextUtils.equals(this.f50113a.f50103d, "2.0")) {
                    this.f50113a.K(null);
                } else {
                    d.a.q0.a.c1.a.R().e(this.f50113a.f50104e, this.f50113a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.f0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50114a;

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
            this.f50114a = bVar;
        }

        @Override // d.a.f0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f50114a.f50105f = i2;
                this.f50114a.f50106g = str;
                d.a.q0.a.e0.d.h("SwanAppPaymentManager", "statusCode: " + this.f50114a.f50105f + " ,result:" + this.f50114a.f50106g);
                this.f50114a.M(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
                if (i2 != 1) {
                    k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
                }
                if (i2 != 0 || !TextUtils.equals(this.f50114a.f50103d, "2.0")) {
                    this.f50114a.K(null);
                } else {
                    d.a.q0.a.c1.a.R().e(this.f50114a.f50104e, this.f50114a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50116f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f50117g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50118h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f50119i;
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
            this.f50115e = str;
            this.f50116f = str2;
            this.f50117g = strArr;
            this.f50118h = jSONObject;
            this.f50119i = z;
        }

        @Override // d.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    k.M("success", 8, this.f50115e);
                    if (this.j.f50100a.m0()) {
                        this.j.F(this.f50116f, this.f50117g, this.f50118h, true, false);
                        return;
                    } else {
                        this.j.C(this.f50116f, this.f50117g, this.f50118h, true, false);
                        return;
                    }
                }
                if (!this.f50119i) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.f50115e);
                    d.a.q0.a.e0.d.h("SwanAppPaymentManager", "login error");
                    k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.q0.a.q1.a.c("", "login error"));
                }
                this.j.f50105f = 5;
                this.j.f50106g = null;
                this.j.K(null);
                k.E(BeanConstants.CHANNEL_ID_NUOMI, false, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50120a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f50121b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50122c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f50123d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50125f;

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
            this.f50125f = bVar;
            this.f50120a = str;
            this.f50121b = strArr;
            this.f50122c = jSONObject;
            this.f50123d = z;
            this.f50124e = z2;
        }

        @Override // d.a.q0.a.q1.b.j
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(this.f50125f.f50108i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f50125f.f50102c;
            String str2 = this.f50125f.f50108i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f50125f.f50100a.x().getString(d.a.q0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // d.a.q0.a.q1.b.j
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f50125f.C(this.f50120a, this.f50121b, this.f50122c, this.f50123d, this.f50124e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50126e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f50127f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50128g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50129h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f50130i;

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
            this.f50130i = bVar;
            this.f50126e = jSONObject;
            this.f50127f = strArr;
            this.f50128g = jSONObject2;
            this.f50129h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f50130i.D(this.f50126e, this.f50127f, this.f50128g);
                    return null;
                }
                d.a.q0.a.e0.d.h("SwanAppPaymentManager", "paykey invalid order info " + this.f50129h);
                k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.q0.a.q1.a.c("", "paykey invalid"));
                this.f50130i.L();
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.a.q0.a.q1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50131a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50132b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f50133c;

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
            this.f50133c = bVar;
            this.f50131a = jSONObject;
            this.f50132b = jSONObject2;
        }

        @Override // d.a.q0.a.q1.d
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f50133c.J(i2, str, this.f50131a, this.f50132b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements d.a.f0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50134a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50135b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f50136c;

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
            this.f50136c = bVar;
            this.f50134a = jSONObject;
            this.f50135b = jSONObject2;
        }

        @Override // d.a.f0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f50136c.J(i2, str, this.f50134a, this.f50135b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50138f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50139g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f50140h;

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
            this.f50140h = bVar;
            this.f50137e = str;
            this.f50138f = str2;
            this.f50139g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                char c2 = 0;
                if (!d.a.q0.a.e2.c.d.h(iVar)) {
                    String str = null;
                    if (TextUtils.equals(this.f50140h.f50103d, "2.0")) {
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
                    if (TextUtils.equals(this.f50137e, "mapp_request_duxiaoman")) {
                        k.D(false, "baiduqianbao", d.a.q0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f50137e, "mapp_request_alipayment")) {
                        k.D(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, d.a.q0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f50137e, "mapp_request_wechatpayment")) {
                        k.D(false, "wechatH5Action", d.a.q0.a.q1.a.c("", "authorize fail"));
                    }
                    d.a.q0.a.e0.d.h("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f50137e);
                    this.f50140h.f50102c.handleSchemeDispatchCallback(this.f50140h.f50108i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.f50137e;
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
                    this.f50140h.z(this.f50138f, this.f50139g);
                } else if (c2 == 1) {
                    this.f50140h.x(this.f50138f);
                } else if (c2 != 2) {
                } else {
                    this.f50140h.N();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface j {
        void onFail(String str);

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(125276367, "Ld/a/q0/a/q1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(125276367, "Ld/a/q0/a/q1/b;");
                return;
            }
        }
        j = d.a.q0.a.k.f49133a;
        k = new String[]{"duershow"};
    }

    public b(d.a.q0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
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
        this.f50100a = eVar;
        this.f50101b = unitedSchemeEntity;
        this.f50102c = callbackHandler;
        this.f50103d = str;
        this.f50104e = str2;
        this.f50108i = str3;
        this.f50107h = new d.a.f0.a();
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
                this.f50101b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.q0.a.e0.d.h("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.f50100a.T().g(this.f50100a.x(), str, new i(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.f50102c, this.f50101b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            k.F("baiduqianbao", "intoPayment", 0);
            this.f50107h.d(this.f50100a.k(), str, new C0921b(this));
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
                if (d.a.q0.a.s.a.f.f50510d.f()) {
                    jSONObject.put("openBduss", d.a.q0.a.c1.a.a0().d(d.a.q0.a.c1.a.b()));
                    jSONObject.put("clientId", d.a.q0.a.c1.a.m().b());
                } else {
                    jSONObject.put("bduss", d.a.q0.a.c1.a.a0().d(d.a.q0.a.c1.a.b()));
                }
                jSONObject.put("cuid", d.a.q0.a.c1.a.a0().i(d.a.q0.a.c1.a.b()));
                String optString = jSONObject.optString("bizInfo");
                JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
                jSONObject3.put("swanFrom", this.f50100a.L().T());
                jSONObject3.put("cuid", d.a.q0.a.c1.a.a0().i(d.a.q0.a.c1.a.b()));
                jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.q0.a.a2.d.g().getAppId());
                w(jSONObject3);
                jSONObject.put("bizInfo", jSONObject3.toString());
                jSONObject.put("platformId", "100003");
                jSONObject.put("nativeAppId", d.a.q0.a.c1.a.m().a());
                jSONObject.put("sceneSource", "swan");
                jSONObject.put("swanNativeVersion", l.a());
                y(jSONObject, this.f50100a.D());
                if (j) {
                    Log.i("SwanAppPaymentManager", jSONObject.toString());
                }
            } catch (JSONException e2) {
                if (d.a.q0.a.k.f49133a) {
                    e2.printStackTrace();
                }
            }
            d.a.q0.a.g1.f.V().p();
            String[] strArr2 = k;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (strArr2[i2].equals(d.a.q0.a.c1.a.m().a())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            k.F(BeanConstants.CHANNEL_ID_NUOMI, "intoPayment", 0);
            if (z) {
                String a2 = d.a.q0.t.i.a(d.a.q0.t.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
                d.a.q0.a.h0.g.k.Q2("qrCodePay", d.a.q0.a.l1.b.g(a2, a2));
                d.a.q0.a.q1.e.b(new g(this, jSONObject2, jSONObject));
                d.a.q0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject.toString());
            } else {
                this.f50107h.i(this.f50100a.x(), jSONObject, strArr, new h(this, jSONObject2, jSONObject));
                d.a.q0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay: " + jSONObject.toString());
            }
            UnitedSchemeUtility.callCallback(this.f50102c, this.f50101b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.f50100a.z() != null) {
                String valueOf = String.valueOf(this.f50100a.L().G());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f50100a.L().W()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f50100a.L().H());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e3) {
                    if (j) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                    }
                }
                this.f50100a.z().N(7, bundle);
            }
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                d.a.q0.a.n1.q.c.d.b(jSONObject2.optString("appKey"), new f(this, jSONObject2, strArr, jSONObject, str));
            } catch (JSONException e2) {
                L();
                d.a.q0.a.e0.d.h("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (d.a.q0.a.k.f49133a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d.a.q0.a.c1.b.e().a(str, new e(this, str, strArr, jSONObject, z, z2));
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
            boolean e2 = this.f50100a.j().e(this.f50100a.x());
            if (!e2) {
                k.M("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.f50101b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            d.a.q0.a.t1.d.a.a("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                d.a.q0.a.t1.c.c.a aVar = new d.a.q0.a.t1.c.c.a(jSONObject.optString("componentId"));
                aVar.f50689a = optString3;
                aVar.f50691c = opt;
                aVar.f50692d = false;
                aVar.f50693e = null;
                aVar.b();
                d.a.q0.a.e0.d.h("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.q0.a.q1.a.c("", "param check error - plugin pay contains custom error"));
                this.f50101b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
            if (this.f50100a.x() == null) {
                this.f50105f = 5;
                this.f50106g = null;
                K(null);
                if (j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.f50100a.j().e(this.f50100a.k())) {
                if (this.f50100a.m0()) {
                    F(str, strArr, jSONObject, true, true);
                    return true;
                }
                C(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.f50100a.j().f(this.f50100a.k(), null, new d(this, str2, str, strArr, jSONObject, e2));
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void J(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), str, jSONObject, jSONObject2}) == null) {
            d.a.q0.a.g1.f.V().b();
            d.a.q0.a.e0.d.g("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f50105f + " params: " + this.f50106g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            M(i2, BeanConstants.CHANNEL_ID_NUOMI, G(str, jSONObject2));
            this.f50105f = i2;
            this.f50106g = str;
            if (i2 != 1) {
                k.F(BeanConstants.CHANNEL_ID_NUOMI, "result", i2);
            }
            K(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                d.a.q0.a.t1.c.c.a aVar = new d.a.q0.a.t1.c.c.a(optString2);
                aVar.f50689a = optString;
                aVar.f50691c = opt;
                aVar.f50692d = i2 == 0;
                aVar.f50693e = str;
                aVar.b();
                d.a.q0.a.t1.g.b.j();
            }
            if (this.f50105f != 0 || d.a.q0.a.x1.c.f51690c.c()) {
                return;
            }
            d.a.q0.a.x1.c.f51690c.e();
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (TextUtils.equals(this.f50103d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.f50106g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.f50106g.getBytes("UTF-8"), 2));
                    }
                    d.a.q0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f50105f);
                    this.f50102c.handleSchemeDispatchCallback(this.f50108i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f50105f, H(this.f50105f)).toString());
                    return;
                }
                d.a.q0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f50106g + " status code = " + this.f50105f);
                this.f50102c.handleSchemeDispatchCallback(this.f50108i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f50106g, this.f50105f, H(this.f50105f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                d.a.q0.a.e0.d.g("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.f50102c;
                String str2 = this.f50108i;
                int i2 = this.f50105f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, H(i2)).toString());
            }
        }
    }

    public final void L() {
        d.a.q0.a.a2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (eVar = this.f50100a) == null) {
            return;
        }
        d.a.q0.a.z1.b.f.e.f(eVar.x(), d.a.q0.a.h.swanapp_payment_illegal).F();
        if (TextUtils.isEmpty(this.f50108i)) {
            return;
        }
        this.f50102c.handleSchemeDispatchCallback(this.f50108i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f50100a.x().getString(d.a.q0.a.h.swanapp_payment_illegal)).toString());
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
            d.a.q0.a.e0.d.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (d.a.q0.a.q1.a.b().e(this.f50100a, this.f50102c, this.f50101b)) {
                this.f50105f = 0;
                this.f50106g = null;
                if (TextUtils.equals(this.f50103d, "2.0")) {
                    d.a.q0.a.c1.a.R().e(this.f50104e, this);
                } else {
                    K(null);
                }
                k.C("wechatH5Action", null, null);
                return true;
            }
            d.a.q0.a.e0.d.h("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f50101b.toString());
            this.f50102c.handleSchemeDispatchCallback(this.f50108i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.x1.a
    public void a(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            d.a.q0.a.e0.d.b("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                d.a.q0.a.e0.d.b("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            K(str);
            if (d.a.q0.a.x1.c.f51690c.c()) {
                return;
            }
            if (d.a.q0.a.c1.a.a0().e(this.f50100a)) {
                d.a.q0.a.x1.c.f51690c.e();
            } else {
                d.a.q0.a.x1.c.f51690c.f();
            }
        }
    }

    @Override // d.a.q0.a.x1.a
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            d.a.q0.a.e0.d.b("SwanAppPaymentManager", "Fail: request payId failed");
            d.a.q0.a.e0.d.b("SwanAppPaymentManager", str);
            K(null);
        }
    }

    public final JSONObject w(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
            if (this.f50100a.m0() && jSONObject != null) {
                b.a L = this.f50100a.L();
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
            this.f50107h.c(this.f50100a.k(), str, new c(this));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void y(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, jSONObject, str) == null) {
            PMSAppInfo s = d.a.q0.n.g.a.h().s(str);
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
            if (this.f50100a.j().e(this.f50100a.k())) {
                B(str);
                return true;
            }
            d.a.q0.a.a2.e eVar = this.f50100a;
            if (eVar == null) {
                return false;
            }
            boolean e2 = eVar.j().e(this.f50100a.x());
            if (!e2) {
                k.M("show", 9, str2);
            }
            this.f50100a.j().f(this.f50100a.k(), null, new a(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
