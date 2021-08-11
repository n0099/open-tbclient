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
    public Context f76716a;

    /* renamed from: b  reason: collision with root package name */
    public String f76717b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f76718c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76719d;

    /* renamed from: e  reason: collision with root package name */
    public M f76720e;

    /* renamed from: f  reason: collision with root package name */
    public int f76721f;

    /* renamed from: g  reason: collision with root package name */
    public n1 f76722g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f76723h;

    /* renamed from: i  reason: collision with root package name */
    public r1 f76724i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f76725j;

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
        this.f76719d = false;
        this.f76721f = 5;
        this.f76725j = new h1(this, Looper.getMainLooper());
        this.f76716a = context;
        this.f76717b = str;
        this.f76720e = m;
        this.f76718c = new g1();
        this.f76721f = U1.r(context);
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || this.f76723h) {
            return;
        }
        this.f76723h = true;
        X1.f76551a.post(new j1(this, pBError));
    }

    public void b() {
        JSONStringer object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            X1.f76551a.post(new l1(this));
            boolean z = false;
            this.f76723h = false;
            Context context = this.f76716a;
            String str = this.f76717b;
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
                Y0 a2 = Z0.a(this.f76716a);
                String str2 = this.f76717b;
                try {
                    object = new JSONStringer().object();
                    a2.f76554b = object;
                    a2.a("e", "Ld").a("pid", str2).a("timeis", Z0.b());
                } catch (JSONException unused2) {
                }
                a2.a();
                a(PBError.PID_INVALID);
                return;
            }
            Info b2 = this.f76718c.b();
            if (b2 == null) {
                if (this.f76719d) {
                    a(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.f76719d = true;
                r1 r1Var = new r1(this.f76716a);
                r1Var.f76776b = this.f76717b;
                r1 a3 = r1Var.a(new i1(this));
                this.f76724i = a3;
                M m = this.f76720e;
                if (m == M.f76432a) {
                    a3.a();
                    return;
                } else if (m == M.f76433b) {
                    a3.c();
                    return;
                } else if (m == M.f76434c) {
                    a3.d();
                    return;
                } else if (m == M.f76435d) {
                    a3.f();
                    return;
                } else if (m == M.f76436e) {
                    a3.e();
                    return;
                } else if (m == M.f76437f) {
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, info) == null) || this.f76723h) {
            return;
        }
        this.f76723h = true;
        X1.f76551a.post(new k1(this, info));
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.f76724i != null) {
                    this.f76724i.f76778d = null;
                }
                if (this.f76725j != null) {
                    this.f76725j.removeCallbacksAndMessages(null);
                }
                if (this.f76718c != null) {
                    this.f76718c.a();
                }
                if (this.f76722g != null) {
                    this.f76722g = null;
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
            List list = k.f76426a;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f76718c.a(k.f76426a);
        } catch (Exception unused) {
        }
    }
}
