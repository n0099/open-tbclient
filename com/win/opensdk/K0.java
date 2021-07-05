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
/* loaded from: classes7.dex */
public class K0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f42379a;

    /* renamed from: b  reason: collision with root package name */
    public String f42380b;

    /* renamed from: c  reason: collision with root package name */
    public E0 f42381c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42382d;

    /* renamed from: e  reason: collision with root package name */
    public y f42383e;

    /* renamed from: f  reason: collision with root package name */
    public int f42384f;

    /* renamed from: g  reason: collision with root package name */
    public L0 f42385g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42386h;

    /* renamed from: i  reason: collision with root package name */
    public P0 f42387i;
    public Handler j;

    public K0(Context context, String str, y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, yVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42382d = false;
        this.f42384f = 5;
        this.j = new F0(this, Looper.getMainLooper());
        this.f42379a = context;
        this.f42380b = str;
        this.f42383e = yVar;
        this.f42381c = new E0();
        this.f42384f = s1.q(context);
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) || this.f42386h) {
            return;
        }
        this.f42386h = true;
        v1.f42660a.post(new H0(this, pBError));
    }

    public void b() {
        JSONStringer object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            v1.f42660a.post(new J0(this));
            boolean z = false;
            this.f42386h = false;
            Context context = this.f42379a;
            String str = this.f42380b;
            String k = s1.k(context);
            if (!TextUtils.isEmpty(k)) {
                try {
                    JSONArray jSONArray = new JSONArray(k);
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
                w0 a2 = x0.a(this.f42379a);
                String str2 = this.f42380b;
                try {
                    object = new JSONStringer().object();
                    a2.f42683b = object;
                    a2.a("e", "Ld").a("pid", str2).a("timeis", x0.b());
                } catch (JSONException unused2) {
                }
                a2.a();
                a(PBError.PID_INVALID);
                return;
            }
            Info b2 = this.f42381c.b();
            if (b2 == null) {
                if (this.f42382d) {
                    a(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.f42382d = true;
                P0 p0 = new P0(this.f42379a);
                p0.f42417b = this.f42380b;
                P0 a3 = p0.a(new G0(this));
                this.f42387i = a3;
                y yVar = this.f42383e;
                if (yVar == y.f42702a) {
                    a3.a();
                    return;
                } else if (yVar == y.f42703b) {
                    a3.b();
                    return;
                } else if (yVar == y.f42704c) {
                    a3.c();
                    return;
                } else if (yVar == y.f42705d) {
                    a3.e();
                    return;
                } else if (yVar == y.f42706e) {
                    a3.d();
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, info) == null) || this.f42386h) {
            return;
        }
        this.f42386h = true;
        v1.f42660a.post(new I0(this, info));
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.f42387i != null) {
                    this.f42387i.f42419d = null;
                }
                if (this.j != null) {
                    this.j.removeCallbacksAndMessages(null);
                }
                if (this.f42381c != null) {
                    this.f42381c.a();
                }
                if (this.f42385g != null) {
                    this.f42385g = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) || wVar == null) {
            return;
        }
        try {
            List list = wVar.f42679a;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f42381c.a(wVar.f42679a);
        } catch (Exception unused) {
        }
    }
}
