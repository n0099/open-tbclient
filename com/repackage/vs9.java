package com.repackage;

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
import com.win.opensdk.L;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONStringer;
/* loaded from: classes7.dex */
public class vs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public xr9 c;
    public boolean d;
    public L e;
    public int f;
    public zs9 g;
    public boolean h;
    public ot9 i;
    public Handler j;

    public vs9(Context context, String str, L l) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, l};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.f = 5;
        this.j = new bs9(this, Looper.getMainLooper());
        this.a = context;
        this.b = str;
        this.e = l;
        this.c = new xr9();
        this.f = hq9.L(context);
    }

    public static /* synthetic */ int h() {
        return 100101;
    }

    public final PBError a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (i == 100 || i == 101) ? PBError.SERVER_ERROR : (i == 406 || i == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN : (PBError) invokeI.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.i != null) {
                    this.i.d = null;
                }
                if (this.j != null) {
                    this.j.removeCallbacksAndMessages(null);
                }
                if (this.c != null) {
                    this.c.a();
                }
                if (this.g != null) {
                    this.g = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void c(jo9 jo9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jo9Var) == null) || jo9Var == null) {
            return;
        }
        try {
            List list = jo9Var.a;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.c.b(jo9Var.a);
        } catch (Exception unused) {
        }
    }

    public final void d(PBError pBError) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || this.h) {
            return;
        }
        this.h = true;
        rq9.a.post(new js9(this, pBError));
    }

    public final void e(Info info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, info) == null) || this.h) {
            return;
        }
        this.h = true;
        rq9.a.post(new ns9(this, info));
    }

    public void g() {
        JSONStringer object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            rq9.a.post(new rs9(this));
            boolean z = false;
            this.h = false;
            Context context = this.a;
            String str = this.b;
            String F = hq9.F(context);
            if (!TextUtils.isEmpty(F)) {
                try {
                    JSONArray jSONArray = new JSONArray(F);
                    if (jSONArray.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= jSONArray.length()) {
                                break;
                            }
                            String optString = jSONArray.optString(i);
                            if (!TextUtils.isEmpty(optString) && optString.equals(str)) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (!z) {
                tq9 a = xq9.a(this.a);
                String str2 = this.b;
                try {
                    object = new JSONStringer().object();
                    a.b = object;
                    a.l("e", "Ld");
                    a.l("pid", str2);
                    a.l("timeis", xq9.e());
                } catch (JSONException unused2) {
                }
                a.m();
                d(PBError.PID_INVALID);
                return;
            }
            Info c = this.c.c();
            if (c == null) {
                if (this.d) {
                    d(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.d = true;
                ot9 ot9Var = new ot9(this.a);
                ot9Var.b = this.b;
                ot9Var.a(new fs9(this));
                this.i = ot9Var;
                L l = this.e;
                if (l == L.a) {
                    ot9Var.c();
                    return;
                } else if (l == L.b) {
                    ot9Var.e();
                    return;
                } else if (l == L.c) {
                    ot9Var.f();
                    return;
                } else if (l == L.d) {
                    ot9Var.h();
                    return;
                } else if (l == L.e) {
                    ot9Var.g();
                    return;
                } else if (l == L.f) {
                    ot9Var.d();
                    return;
                } else {
                    return;
                }
            }
            e(c);
        }
    }
}
