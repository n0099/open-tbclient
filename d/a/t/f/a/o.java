package d.a.t.f.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.t.g.d.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class o implements j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f70303a;

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f70304a;

        /* renamed from: b  reason: collision with root package name */
        public a.C1937a f70305b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f70306c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f70307d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f70308e;

        /* renamed from: f  reason: collision with root package name */
        public long f70309f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f70310g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f70311h;

        /* renamed from: i  reason: collision with root package name */
        public long f70312i;

        public a(o oVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            this.f70305b = new d.a.t.g.d.a(context.getApplicationContext()).d().f("cloud").f("cstore");
        }

        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f70311h = jSONObject;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
            if (e() != false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    n();
                    o();
                    boolean g2 = d.a.t.b.d(this.f70304a).g();
                    boolean z = false;
                    if (this.f70306c && g2) {
                        if (this.f70310g == null) {
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

        public final boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
            InterceptResult invokeLL;
            JSONArray jSONArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, jSONObject2)) == null) {
                JSONArray jSONArray2 = null;
                try {
                    jSONArray = m.a(jSONObject.optJSONArray("sids"), "pkg");
                    try {
                        jSONArray2 = m.a(jSONObject2.optJSONArray("sids"), "pkg");
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jSONArray = null;
                }
                return o.b(jSONArray, jSONArray2) || m.b(jSONObject, jSONObject2, "oid") || m.b(jSONObject, jSONObject2, "gaid") || m.b(jSONObject, jSONObject2, CommonUrlParamManager.PARAM_IID) || m.b(jSONObject, jSONObject2, "adrid") || m.b(jSONObject, jSONObject2, "aid");
            }
            return invokeLL.booleanValue;
        }

        public void d(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
                this.f70310g = jSONObject;
                k();
            }
        }

        public final synchronized boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    if (this.f70310g == null) {
                        return true;
                    }
                    if (this.f70311h != null) {
                        return c(this.f70310g, this.f70311h);
                    }
                    throw new IllegalArgumentException("you forgot invoke methond :IMatchConditions.setComparedCStoreParams before ");
                }
            }
            return invokeV.booleanValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Math.abs(System.currentTimeMillis() - this.f70312i) / 1000 > this.f70309f : invokeV.booleanValue;
        }

        public final long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                JSONObject jSONObject = this.f70310g;
                if (jSONObject == null) {
                    return 0L;
                }
                return jSONObject.optLong("ctime", 0L);
            }
            return invokeV.longValue;
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                try {
                    this.f70310g = n.a(this.f70305b.g("cs.dat", true));
                    this.f70312i = g();
                } catch (Exception unused) {
                    this.f70312i = 0L;
                }
            }
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                try {
                    JSONObject a2 = n.a(this.f70305b.g("ct.dat", true));
                    if (a2 == null) {
                        this.f70309f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                    } else {
                        this.f70309f = a2.optLong("TIME_OUT", ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME);
                    }
                } catch (Exception unused) {
                    this.f70309f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                }
            }
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                try {
                    JSONObject a2 = n.a(this.f70305b.g("ci.dat", true));
                    if (a2 == null) {
                        this.f70306c = true;
                    } else {
                        this.f70306c = a2.optBoolean("isOn", true);
                    }
                } catch (Exception unused) {
                    this.f70306c = true;
                }
            }
        }

        public final boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                try {
                    this.f70305b.i("cs.dat", this.f70310g.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final boolean l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("isOn", this.f70306c);
                    this.f70305b.i("ci.dat", jSONObject.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("TIME_OUT", this.f70309f);
                    this.f70305b.i("ct.dat", jSONObject.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final synchronized void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                synchronized (this) {
                    boolean z = true;
                    if (this.f70307d) {
                        this.f70307d = !l();
                    }
                    if (this.f70308e) {
                        if (m()) {
                            z = false;
                        }
                        this.f70308e = z;
                    }
                }
            }
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                h();
                i();
                j();
            }
        }
    }

    public o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null) {
            throw new NullPointerException("context should not be null");
        }
        if (this.f70303a == null) {
            this.f70303a = new a(this, context.getApplicationContext());
        }
    }

    public static boolean b(JSONArray jSONArray, JSONArray jSONArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONArray, jSONArray2)) == null) {
            int length = jSONArray == null ? 0 : jSONArray.length();
            if (length != (jSONArray2 == null ? 0 : jSONArray2.length())) {
                return true;
            }
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                JSONObject optJSONObject2 = jSONArray2.optJSONObject(i2);
                if (m.b(optJSONObject, optJSONObject2, "pkg") || m.b(optJSONObject, optJSONObject2, "aid") || m.c(optJSONObject, optJSONObject2, "priority")) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.t.f.a.j
    public j a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            this.f70303a.a(jSONObject);
            return this;
        }
        return (j) invokeL.objValue;
    }

    @Override // d.a.t.f.a.j
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70303a.b() : invokeV.booleanValue;
    }

    @Override // d.a.t.f.a.j
    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            this.f70303a.d(jSONObject);
        }
    }
}
