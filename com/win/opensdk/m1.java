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
    public Context f77097a;

    /* renamed from: b  reason: collision with root package name */
    public String f77098b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f77099c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f77100d;

    /* renamed from: e  reason: collision with root package name */
    public M f77101e;

    /* renamed from: f  reason: collision with root package name */
    public int f77102f;

    /* renamed from: g  reason: collision with root package name */
    public n1 f77103g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f77104h;

    /* renamed from: i  reason: collision with root package name */
    public r1 f77105i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f77106j;

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
        this.f77100d = false;
        this.f77102f = 5;
        this.f77106j = new h1(this, Looper.getMainLooper());
        this.f77097a = context;
        this.f77098b = str;
        this.f77101e = m;
        this.f77099c = new g1();
        this.f77102f = U1.r(context);
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || this.f77104h) {
            return;
        }
        this.f77104h = true;
        X1.f76932a.post(new j1(this, pBError));
    }

    public void b() {
        JSONStringer object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            X1.f76932a.post(new l1(this));
            boolean z = false;
            this.f77104h = false;
            Context context = this.f77097a;
            String str = this.f77098b;
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
                Y0 a2 = Z0.a(this.f77097a);
                String str2 = this.f77098b;
                try {
                    object = new JSONStringer().object();
                    a2.f76935b = object;
                    a2.a("e", "Ld").a("pid", str2).a("timeis", Z0.b());
                } catch (JSONException unused2) {
                }
                a2.a();
                a(PBError.PID_INVALID);
                return;
            }
            Info b2 = this.f77099c.b();
            if (b2 == null) {
                if (this.f77100d) {
                    a(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.f77100d = true;
                r1 r1Var = new r1(this.f77097a);
                r1Var.f77157b = this.f77098b;
                r1 a3 = r1Var.a(new i1(this));
                this.f77105i = a3;
                M m = this.f77101e;
                if (m == M.f76813a) {
                    a3.a();
                    return;
                } else if (m == M.f76814b) {
                    a3.c();
                    return;
                } else if (m == M.f76815c) {
                    a3.d();
                    return;
                } else if (m == M.f76816d) {
                    a3.f();
                    return;
                } else if (m == M.f76817e) {
                    a3.e();
                    return;
                } else if (m == M.f76818f) {
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, info) == null) || this.f77104h) {
            return;
        }
        this.f77104h = true;
        X1.f76932a.post(new k1(this, info));
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.f77105i != null) {
                    this.f77105i.f77159d = null;
                }
                if (this.f77106j != null) {
                    this.f77106j.removeCallbacksAndMessages(null);
                }
                if (this.f77099c != null) {
                    this.f77099c.a();
                }
                if (this.f77103g != null) {
                    this.f77103g = null;
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
            List list = k.f76807a;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f77099c.a(k.f76807a);
        } catch (Exception unused) {
        }
    }
}
