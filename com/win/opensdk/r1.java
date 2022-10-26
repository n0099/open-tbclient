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
/* loaded from: classes8.dex */
public class r1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public l1 c;
    public boolean d;
    public L e;
    public int f;
    public s1 g;
    public boolean h;
    public w1 i;
    public Handler j;

    public r1(Context context, String str, L l) {
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
        this.j = new m1(this, Looper.getMainLooper());
        this.a = context;
        this.b = str;
        this.e = l;
        this.c = new l1();
        this.f = Z1.s(context);
    }

    public static /* synthetic */ int c() {
        return 100101;
    }

    public final PBError a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i != 100 ? i != 101 ? (i == 406 || i == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN : PBError.JSON_ERROR : PBError.SERVER_ERROR : (PBError) invokeI.objValue;
    }

    public void a() {
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

    public final void a(J j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j) == null) && j != null) {
            try {
                List list = j.a;
                if (list != null && list.size() > 0) {
                    this.c.a(j.a);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(PBError pBError) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, pBError) != null) || this.h) {
            return;
        }
        this.h = true;
        c2.a.post(new o1(this, pBError));
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, info) != null) || this.h) {
            return;
        }
        this.h = true;
        c2.a.post(new p1(this, info));
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c2.a.post(new q1(this));
            boolean z = false;
            this.h = false;
            Context context = this.a;
            String str = this.b;
            String m = Z1.m(context);
            if (!TextUtils.isEmpty(m)) {
                try {
                    JSONArray jSONArray = new JSONArray(m);
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
                d1 a = e1.a(this.a);
                String str2 = this.b;
                try {
                    a.b = e1.b();
                    a.a("e", "Ld").a("pid", str2).a("timeis", e1.a());
                } catch (JSONException unused2) {
                }
                a.a();
                a(PBError.PID_INVALID);
                return;
            }
            Info b = this.c.b();
            if (b == null) {
                if (this.d) {
                    a(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.d = true;
                w1 w1Var = new w1(this.a);
                w1Var.b = this.b;
                w1 a2 = w1Var.a(new n1(this));
                this.i = a2;
                L l = this.e;
                if (l == L.a) {
                    a2.a();
                    return;
                } else if (l == L.b) {
                    a2.c();
                    return;
                } else if (l == L.c) {
                    a2.d();
                    return;
                } else if (l == L.d) {
                    a2.f();
                    return;
                } else if (l == L.e) {
                    a2.e();
                    return;
                } else if (l == L.f) {
                    a2.b();
                    return;
                } else {
                    return;
                }
            }
            a(b);
        }
    }
}
