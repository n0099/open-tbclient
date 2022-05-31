package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.x30;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r20 implements k20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public x30.a b;
        public boolean c;
        public boolean d;
        public boolean e;
        public long f;
        public JSONObject g;
        public JSONObject h;
        public long i;

        public a(r20 r20Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r20Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            this.b = new x30(context.getApplicationContext()).d().f("cloud").f("cstore");
        }

        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.g = jSONObject;
                h();
            }
        }

        public final boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
            InterceptResult invokeLL;
            JSONArray jSONArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, jSONObject2)) == null) {
                JSONArray jSONArray2 = null;
                try {
                    jSONArray = p20.a(jSONObject.optJSONArray("sids"), "pkg");
                    try {
                        jSONArray2 = p20.a(jSONObject2.optJSONArray("sids"), "pkg");
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jSONArray = null;
                }
                return r20.c(jSONArray, jSONArray2) || p20.c(jSONObject, jSONObject2, "oid") || p20.c(jSONObject, jSONObject2, "gaid") || p20.c(jSONObject, jSONObject2, "iid") || p20.c(jSONObject, jSONObject2, "adrid") || p20.c(jSONObject, jSONObject2, "aid");
            }
            return invokeLL.booleanValue;
        }

        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.h = jSONObject;
            }
        }

        public final synchronized boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this) {
                    JSONObject jSONObject = this.g;
                    if (jSONObject == null) {
                        return true;
                    }
                    JSONObject jSONObject2 = this.h;
                    if (jSONObject2 != null) {
                        return b(jSONObject, jSONObject2);
                    }
                    throw new IllegalArgumentException("you forgot invoke methond :IMatchConditions.setComparedCStoreParams before ");
                }
            }
            return invokeV.booleanValue;
        }

        public final long e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject jSONObject = this.g;
                if (jSONObject == null) {
                    return 0L;
                }
                return jSONObject.optLong("ctime", 0L);
            }
            return invokeV.longValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Math.abs(System.currentTimeMillis() - this.i) / 1000 > this.f : invokeV.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
            if (d() != false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                synchronized (this) {
                    i();
                    l();
                    boolean h = h10.e(this.a).h();
                    boolean z = false;
                    if (this.c && h) {
                        if (this.g == null) {
                            return true;
                        }
                        if (!f()) {
                        }
                        z = true;
                        return z;
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                try {
                    this.b.i("cs.dat", this.g.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final synchronized void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                synchronized (this) {
                    if (this.d) {
                        this.d = !j();
                    }
                    if (this.e) {
                        this.e = !k();
                    }
                }
            }
        }

        public final boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("isOn", this.c);
                    this.b.i("ci.dat", jSONObject.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("TIME_OUT", this.f);
                    this.b.i("ct.dat", jSONObject.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                m();
                o();
                n();
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                try {
                    this.g = q20.a(this.b.g("cs.dat", true));
                    this.i = e();
                } catch (Exception unused) {
                    this.i = 0L;
                }
            }
        }

        public final void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                try {
                    JSONObject a = q20.a(this.b.g("ci.dat", true));
                    if (a == null) {
                        this.c = true;
                    } else {
                        this.c = a.optBoolean("isOn", true);
                    }
                } catch (Exception unused) {
                    this.c = true;
                }
            }
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                try {
                    JSONObject a = q20.a(this.b.g("ct.dat", true));
                    if (a == null) {
                        this.f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                    } else {
                        this.f = a.optLong("TIME_OUT", ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME);
                    }
                } catch (Exception unused) {
                    this.f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                }
            }
        }
    }

    public r20(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null) {
            throw new NullPointerException("context should not be null");
        }
        if (this.a == null) {
            this.a = new a(this, context.getApplicationContext());
        }
    }

    public static boolean c(JSONArray jSONArray, JSONArray jSONArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONArray, jSONArray2)) == null) {
            int length = jSONArray == null ? 0 : jSONArray.length();
            if (length != (jSONArray2 == null ? 0 : jSONArray2.length())) {
                return true;
            }
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                JSONObject optJSONObject2 = jSONArray2.optJSONObject(i);
                if (p20.c(optJSONObject, optJSONObject2, "pkg") || p20.c(optJSONObject, optJSONObject2, "aid") || p20.b(optJSONObject, optJSONObject2, "priority")) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.k20
    public k20 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            this.a.c(jSONObject);
            return this;
        }
        return (k20) invokeL.objValue;
    }

    @Override // com.repackage.k20
    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            this.a.a(jSONObject);
        }
    }

    @Override // com.repackage.k20
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.g() : invokeV.booleanValue;
    }
}
