package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONStringer;
/* loaded from: classes10.dex */
public class m1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f77451a;

    /* renamed from: b  reason: collision with root package name */
    public String f77452b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f77453c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f77454d;

    /* renamed from: e  reason: collision with root package name */
    public M f77455e;

    /* renamed from: f  reason: collision with root package name */
    public int f77456f;

    /* renamed from: g  reason: collision with root package name */
    public n1 f77457g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f77458h;

    /* renamed from: i  reason: collision with root package name */
    public r1 f77459i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f77460j;

    public m1(Context context, String str, M m) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77454d = false;
        this.f77456f = 5;
        this.f77460j = new h1(this, Looper.getMainLooper());
        this.f77451a = context;
        this.f77452b = str;
        this.f77455e = m;
        this.f77453c = new g1();
        this.f77456f = U1.r(context);
    }

    public static /* synthetic */ int c() {
        return 100101;
    }

    public final PBError a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (i2 == 100 || i2 == 101) ? PBError.SERVER_ERROR : (i2 == 406 || i2 == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN : (PBError) invokeI.objValue;
    }

    public final void a(PBError pBError) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || this.f77458h) {
            return;
        }
        this.f77458h = true;
        X1.f77286a.post(new j1(this, pBError));
    }

    public void b() {
        JSONStringer object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            X1.f77286a.post(new l1(this));
            boolean z = false;
            this.f77458h = false;
            Context context = this.f77451a;
            String str = this.f77452b;
            String l = U1.l(context);
            if (!TextUtils.isEmpty(l)) {
                try {
                    JSONArray jSONArray = new JSONArray(l);
                    if (jSONArray.length() > 0) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            String optString = jSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString) && optString.equals(str)) {
                                z = true;
                                break;
                            }
                            i2++;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (!z) {
                Y0 a2 = Z0.a(this.f77451a);
                String str2 = this.f77452b;
                try {
                    object = new JSONStringer().object();
                    a2.f77289b = object;
                    a2.a("e", "Ld").a("pid", str2).a("timeis", Z0.b());
                } catch (JSONException unused2) {
                }
                a2.a();
                a(PBError.PID_INVALID);
                return;
            }
            Info b2 = this.f77453c.b();
            if (b2 == null) {
                if (this.f77454d) {
                    a(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.f77454d = true;
                r1 r1Var = new r1(this.f77451a);
                r1Var.f77511b = this.f77452b;
                r1 a3 = r1Var.a(new i1(this));
                this.f77459i = a3;
                M m = this.f77455e;
                if (m == M.f77167a) {
                    a3.a();
                    return;
                } else if (m == M.f77168b) {
                    a3.c();
                    return;
                } else if (m == M.f77169c) {
                    a3.d();
                    return;
                } else if (m == M.f77170d) {
                    a3.f();
                    return;
                } else if (m == M.f77171e) {
                    a3.e();
                    return;
                } else if (m == M.f77172f) {
                    a3.b();
                    return;
                } else {
                    return;
                }
            }
            a(b2);
        }
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, info) == null) || this.f77458h) {
            return;
        }
        this.f77458h = true;
        X1.f77286a.post(new k1(this, info));
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.f77459i != null) {
                    this.f77459i.f77513d = null;
                }
                if (this.f77460j != null) {
                    this.f77460j.removeCallbacksAndMessages(null);
                }
                if (this.f77453c != null) {
                    this.f77453c.a();
                }
                if (this.f77457g != null) {
                    this.f77457g = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(K k) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k) == null) || k == null) {
            return;
        }
        try {
            List list = k.f77161a;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f77453c.a(k.f77161a);
        } catch (Exception unused) {
        }
    }
}
