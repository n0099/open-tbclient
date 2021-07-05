package d.a.o0.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AuthnHelper s;
    public long t;
    public long u;
    public boolean v;

    /* loaded from: classes8.dex */
    public class a implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f46291a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f46292b;

        public a(e eVar, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46292b = eVar;
            this.f46291a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f46292b.z(jSONObject, this.f46291a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f46293a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f46294b;

        public b(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46294b = eVar;
            this.f46293a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f46294b.C(jSONObject, this.f46293a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46295f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46296g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f46297h;

        public c(e eVar, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46297h = eVar;
            this.f46295f = jSONObject;
            this.f46296g = i2;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f46295f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                    String optString = this.f46295f.optString("authTypeDes", "");
                    if (optInt == 103000) {
                        if (!d.a.o0.b.c.f46238c) {
                            this.f46297h.u = System.currentTimeMillis();
                            this.f46297h.f46353h = this.f46295f.optString("token", "");
                            this.f46297h.e(this.f46296g, 0, 0, this.f46297h.f46348c, "preVerify success", 3);
                            return;
                        }
                        this.f46297h.e(this.f46296g, 1, 999, this.f46297h.f46348c, "device has risk.", 3);
                    } else if (optInt == 105312 && this.f46297h.f46348c != this.f46297h.f46349d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("pre verify");
                        sb.append(" error, wrong sim operator");
                        this.f46297h.e(this.f46296g, 3, 2002, this.f46297h.f46348c, sb.toString(), 3);
                    } else {
                        e eVar = this.f46297h;
                        int i2 = this.f46296g;
                        int i3 = this.f46297h.f46348c;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("pre verify");
                        sb2.append(" error.");
                        sb2.append(optString);
                        eVar.e(i2, 2, optInt, i3, sb2.toString(), 3);
                    }
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                    e eVar2 = this.f46297h;
                    int i4 = this.f46296g;
                    int i5 = eVar2.f46348c;
                    eVar2.e(i4, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i5, "cm on handle pre verify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46298f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46299g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f46300h;

        public d(e eVar, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46300h = eVar;
            this.f46298f = jSONObject;
            this.f46299g = i2;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f46298f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                    String optString = this.f46298f.optString("desc", "");
                    if (optInt == 103000) {
                        if (!d.a.o0.b.c.f46238c) {
                            this.f46300h.t = System.currentTimeMillis();
                            this.f46300h.f46352g = this.f46298f.optString("securityphone", "");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f46300h.a(this.f46300h.f46352g));
                            this.f46300h.e(this.f46299g, 0, 0, this.f46300h.f46348c, jSONObject.toString(), 1);
                            return;
                        }
                        this.f46300h.e(this.f46299g, 1, 999, this.f46300h.f46348c, "device has risk.", 1);
                    } else if (optInt == 105312 && this.f46300h.f46348c != this.f46300h.f46349d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("pre login");
                        sb.append(" error, wrong sim operator");
                        this.f46300h.e(this.f46299g, 3, 2002, this.f46300h.f46348c, sb.toString(), 1);
                    } else {
                        e eVar = this.f46300h;
                        int i2 = this.f46299g;
                        int i3 = this.f46300h.f46348c;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("pre login");
                        sb2.append(" error.");
                        sb2.append(optString);
                        eVar.e(i2, 2, optInt, i3, sb2.toString(), 1);
                    }
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                    e eVar2 = this.f46300h;
                    int i4 = this.f46299g;
                    int i5 = eVar2.f46348c;
                    eVar2.e(i4, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i5, "cm on handle pre login unknown error.", 1);
                }
            }
        }
    }

    /* renamed from: d.a.o0.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0672e extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46301f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46302g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f46303h;

        public C0672e(e eVar, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46303h = eVar;
            this.f46301f = jSONObject;
            this.f46302g = i2;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f46301f.has(MiPushCommandMessage.KEY_RESULT_CODE) ? this.f46301f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1) : -1;
                    if (optInt == 103000) {
                        this.f46303h.f46350e = this.f46301f.optString("token");
                        this.f46303h.b(this.f46302g);
                        return;
                    }
                    String optString = this.f46301f.optString("resultDesc", "");
                    e eVar = this.f46303h;
                    int i2 = this.f46302g;
                    int i3 = this.f46303h.f46348c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("error:");
                    sb.append(optString);
                    eVar.d(i2, 2, optInt, i3, sb.toString());
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                    e eVar2 = this.f46303h;
                    eVar2.d(this.f46302g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar2.f46348c, "cm on handle login unknown error.");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46304f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f46305g;

        public f(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46305g = eVar;
            this.f46304f = i2;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f46305g.g(this.f46304f, this.f46305g.f46348c, this.f46305g.f46353h);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                    e eVar = this.f46305g;
                    eVar.m(this.f46304f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar.f46348c, "cm on handle verify unknown error.");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f46306a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f46307b;

        public g(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46307b = eVar;
            this.f46306a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f46307b.w(jSONObject, this.f46306a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
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
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.f46348c = 1;
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            d.a.o0.k.e.c().b(new f(this, i2));
        }
    }

    public final void C(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i2) == null) {
            d.a.o0.k.e.c().b(new c(this, jSONObject, i2));
        }
    }

    @Override // d.a.o0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) {
            super.h(context, i2);
            if (!d.a.o0.b.a.h(this.f46346a).d()) {
                e(i2, 3, 997, this.f46348c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f46348c, "pre login error. cm has not valid config.", 1);
            } else if (d.a.o0.b.a.h(this.f46346a).p0()) {
                if (!this.v) {
                    System.currentTimeMillis();
                    AuthnHelper authnHelper = AuthnHelper.getInstance(this.f46346a);
                    this.s = authnHelper;
                    authnHelper.setOverTime(8000L);
                    this.v = true;
                }
                this.s.getPhoneInfo(i.k, i.l, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 994, this.f46348c, "pre login error. cm sdk stop run.", 1);
            }
        }
    }

    @Override // d.a.o0.e.i
    public void i(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.i(context, i2, j);
            c(i2, 2);
            this.s.loginAuth(i.k, i.l, new g(this, i2));
        }
    }

    @Override // d.a.o0.e.i
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t == 0 || System.currentTimeMillis() - this.t >= TimeUnit.HOURS.toMillis(1L) : invokeV.booleanValue;
    }

    @Override // d.a.o0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, context, i2) == null) {
            super.o(context, i2);
            if (!d.a.o0.b.a.h(this.f46346a).d()) {
                e(i2, 3, 997, this.f46348c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f46348c, "pre verify error. cm has not valid config.", 3);
            } else if (d.a.o0.b.a.h(this.f46346a).p0()) {
                if (!this.v) {
                    AuthnHelper authnHelper = AuthnHelper.getInstance(this.f46346a);
                    this.s = authnHelper;
                    authnHelper.setOverTime(8000L);
                    this.v = true;
                }
                this.s.mobileAuth(i.k, i.l, new b(this, i2));
            } else {
                e(i2, 3, 994, this.f46348c, "pre verify error. cm sdk stop run.", 3);
            }
        }
    }

    @Override // d.a.o0.e.i
    public void p(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.p(context, i2, j);
            c(i2, 4);
            A(i2);
        }
    }

    @Override // d.a.o0.e.i
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? System.currentTimeMillis() - this.u > 115000 : invokeV.booleanValue;
    }

    @Override // d.a.o0.e.i
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f46350e = null;
        }
    }

    @Override // d.a.o0.e.i
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f46353h = null;
            this.u = 0L;
        }
    }

    public final void w(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, jSONObject, i2) == null) {
            d.a.o0.k.e.c().b(new C0672e(this, jSONObject, i2));
        }
    }

    public final void z(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, jSONObject, i2) == null) {
            d.a.o0.k.e.c().b(new d(this, jSONObject, i2));
        }
    }
}
