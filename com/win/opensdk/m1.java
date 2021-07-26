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
/* loaded from: classes6.dex */
public class m1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f39872a;

    /* renamed from: b  reason: collision with root package name */
    public String f39873b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f39874c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39875d;

    /* renamed from: e  reason: collision with root package name */
    public M f39876e;

    /* renamed from: f  reason: collision with root package name */
    public int f39877f;

    /* renamed from: g  reason: collision with root package name */
    public n1 f39878g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39879h;

    /* renamed from: i  reason: collision with root package name */
    public r1 f39880i;
    public Handler j;

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
        this.f39875d = false;
        this.f39877f = 5;
        this.j = new h1(this, Looper.getMainLooper());
        this.f39872a = context;
        this.f39873b = str;
        this.f39876e = m;
        this.f39874c = new g1();
        this.f39877f = U1.r(context);
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || this.f39879h) {
            return;
        }
        this.f39879h = true;
        X1.f39711a.post(new j1(this, pBError));
    }

    public void b() {
        JSONStringer object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            X1.f39711a.post(new l1(this));
            boolean z = false;
            this.f39879h = false;
            Context context = this.f39872a;
            String str = this.f39873b;
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
                Y0 a2 = Z0.a(this.f39872a);
                String str2 = this.f39873b;
                try {
                    object = new JSONStringer().object();
                    a2.f39714b = object;
                    a2.a("e", "Ld").a("pid", str2).a("timeis", Z0.b());
                } catch (JSONException unused2) {
                }
                a2.a();
                a(PBError.PID_INVALID);
                return;
            }
            Info b2 = this.f39874c.b();
            if (b2 == null) {
                if (this.f39875d) {
                    a(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.f39875d = true;
                r1 r1Var = new r1(this.f39872a);
                r1Var.f39928b = this.f39873b;
                r1 a3 = r1Var.a(new i1(this));
                this.f39880i = a3;
                M m = this.f39876e;
                if (m == M.f39596a) {
                    a3.a();
                    return;
                } else if (m == M.f39597b) {
                    a3.c();
                    return;
                } else if (m == M.f39598c) {
                    a3.d();
                    return;
                } else if (m == M.f39599d) {
                    a3.f();
                    return;
                } else if (m == M.f39600e) {
                    a3.e();
                    return;
                } else if (m == M.f39601f) {
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, info) == null) || this.f39879h) {
            return;
        }
        this.f39879h = true;
        X1.f39711a.post(new k1(this, info));
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.f39880i != null) {
                    this.f39880i.f39930d = null;
                }
                if (this.j != null) {
                    this.j.removeCallbacksAndMessages(null);
                }
                if (this.f39874c != null) {
                    this.f39874c.a();
                }
                if (this.f39878g != null) {
                    this.f39878g = null;
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
            List list = k.f39590a;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f39874c.a(k.f39590a);
        } catch (Exception unused) {
        }
    }
}
