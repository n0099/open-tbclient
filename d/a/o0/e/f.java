package d.a.o0.e;

import android.content.Context;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveFileData;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;

    /* loaded from: classes8.dex */
    public class a implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f46308a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f46309b;

        public a(f fVar, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46309b = fVar;
            this.f46308a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f46309b.w(str, this.f46308a, 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f46310a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f46311b;

        public b(f fVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46311b = fVar;
            this.f46310a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f46311b.w(str, this.f46310a, 3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46312f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46313g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46314h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f46315i;

        public c(f fVar, String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46315i = fVar;
            this.f46312f = str;
            this.f46313g = i2;
            this.f46314h = i3;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f46312f);
                    if (jSONObject.optInt("result", -1) == 0) {
                        this.f46315i.z(jSONObject, this.f46313g, this.f46314h);
                    } else {
                        this.f46315i.x(jSONObject, this.f46313g, this.f46314h);
                    }
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46316f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46317g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46318h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f46319i;

        public d(f fVar, int i2, int i3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2), Integer.valueOf(i3), jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46319i = fVar;
            this.f46316f = i2;
            this.f46317g = i3;
            this.f46318h = jSONObject;
        }

        @Override // d.a.o0.k.c
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (d.a.o0.b.c.f46238c) {
                        this.f46319i.e(this.f46316f, 1, 999, this.f46319i.f46348c, "device has risk.", this.f46317g);
                        return;
                    }
                    JSONObject optJSONObject = this.f46318h.optJSONObject("data");
                    if (this.f46317g == 1) {
                        this.f46319i.f46350e = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f46319i.f46352g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                        this.f46319i.f46351f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f46319i.a(this.f46319i.f46352g));
                        str = jSONObject.toString();
                    } else {
                        this.f46319i.f46353h = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f46319i.f46354i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        str = "preVerify success";
                    }
                    this.f46319i.e(this.f46316f, 0, 0, this.f46319i.f46348c, str, this.f46317g);
                } catch (Throwable unused) {
                    f fVar = this.f46319i;
                    fVar.e(this.f46316f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar.f46348c, "ct on handle pre login or verify unknown error.", this.f46317g);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46320f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46321g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46322h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f46323i;

        public e(f fVar, JSONObject jSONObject, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, jSONObject, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46323i = fVar;
            this.f46320f = jSONObject;
            this.f46321g = i2;
            this.f46322h = i3;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f46320f.optInt("result", -1);
                    String optString = this.f46320f.optString("msg", "");
                    if (this.f46323i.f46348c != this.f46323i.f46349d && (optInt == -10009 || optInt == -10008)) {
                        this.f46323i.e(this.f46321g, 3, 2002, this.f46323i.f46348c, "pre login error, wrong sim operator", this.f46322h);
                    } else {
                        f fVar = this.f46323i;
                        int i2 = this.f46321g;
                        int i3 = this.f46323i.f46348c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ct pre login error.");
                        sb.append(optString);
                        sb.append(", status ");
                        sb.append(optInt);
                        fVar.e(i2, 2, optInt, i3, sb.toString(), this.f46322h);
                    }
                } catch (Throwable unused) {
                    f fVar2 = this.f46323i;
                    fVar2.e(this.f46321g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar2.f46348c, "ct on handle pre login or verify unknown error.", this.f46322h);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = false;
        this.f46348c = 3;
    }

    @Override // d.a.o0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            super.h(context, i2);
            if (!d.a.o0.b.a.h(this.f46346a).d()) {
                e(i2, 3, 997, this.f46348c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f46348c, "pre login error. ct has not valid config.", 1);
            } else if (d.a.o0.b.a.h(this.f46346a).a()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 996, this.f46348c, "pre login error. ct sdk stop run.", 1);
            }
        }
    }

    @Override // d.a.o0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            super.o(context, i2);
            if (!d.a.o0.b.a.h(this.f46346a).d()) {
                e(i2, 3, 997, this.f46348c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f46348c, "pre verify error. ct has not valid config.", 3);
            } else if (d.a.o0.b.a.h(this.f46346a).a()) {
                if (!this.s) {
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new b(this, i2));
            } else {
                e(i2, 3, 996, this.f46348c, "pre verify error. ct sdk stop run.", 3);
            }
        }
    }

    @Override // d.a.o0.e.j, d.a.o0.e.i
    public void p(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.p(context, i2, j);
        }
    }

    public final void w(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, str, i2, i3) == null) {
            d.a.o0.k.e.c().b(new c(this, str, i2, i3));
        }
    }

    public final void x(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, jSONObject, i2, i3) == null) {
            d.a.o0.k.e.c().b(new e(this, jSONObject, i2, i3));
        }
    }

    public final void z(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, jSONObject, i2, i3) == null) {
            d.a.o0.k.e.c().b(new d(this, i2, i3, jSONObject));
        }
    }
}
