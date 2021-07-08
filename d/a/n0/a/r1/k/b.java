package d.a.n0.a.r1.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f47090a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f47091b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, List<d.a.n0.a.r1.k.a>> f47092c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f47093d;

    /* renamed from: e  reason: collision with root package name */
    public String f47094e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47095f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47096g;

    /* renamed from: h  reason: collision with root package name */
    public long f47097h;

    /* renamed from: i  reason: collision with root package name */
    public long f47098i;
    public volatile d.a.n0.a.r1.k.j.c j;

    /* loaded from: classes7.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47099a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47099a = bVar;
        }

        @Override // d.a.n0.a.r1.k.c
        public boolean a(d.a.n0.a.r1.k.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar == null || aVar.c() < 0) {
                    return false;
                }
                if (b.k || aVar.b() == 0) {
                    return this.f47099a.o(aVar.e());
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(632019607, "Ld/a/n0/a/r1/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(632019607, "Ld/a/n0/a/r1/k/b;");
                return;
            }
        }
        k = k.f45831a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47093d = new Object();
    }

    @Override // d.a.n0.a.r1.k.e
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            p();
            u();
            this.f47097h = j;
            q("launch start time-" + j);
        }
    }

    @Override // d.a.n0.a.r1.k.e
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f47096g = true;
            this.f47098i = j;
            v(k());
            q("launch end time-" + (this.f47097h + this.f47098i));
        }
    }

    @Override // d.a.n0.a.r1.k.d
    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) && f.j().m()) {
            p();
            if (this.f47095f) {
                q("aiapp start finish");
                return;
            }
            q("ubcReport enter");
            if (jSONObject != null && jSONObject.length() > 0) {
                String m = m(jSONObject);
                q("Id " + m);
                if (TextUtils.equals(m, "786")) {
                    if (k) {
                        Log.d("ApiCalledMarker", jSONObject.toString());
                    }
                    JSONObject l = l(jSONObject);
                    if (l != null && l.length() > 0) {
                        JSONObject optJSONObject = l.optJSONObject("ext");
                        if (optJSONObject != null && optJSONObject.length() > 0) {
                            if (TextUtils.isEmpty(this.f47094e)) {
                                this.f47094e = optJSONObject.optString("swan");
                                q("current swan version " + this.f47094e);
                            }
                            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                s(optJSONArray);
                                q("ubcReport over");
                                v(k());
                                return;
                            }
                            q("value-ext-list is empty");
                            return;
                        }
                        q("value-ext is empty");
                        return;
                    }
                    q("value is empty");
                    return;
                }
                return;
            }
            q("json data is empty");
        }
    }

    public String k() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f47096g && this.f47091b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("----- ");
                sb.append("launch start time ");
                sb.append(this.f47091b.format(Long.valueOf(this.f47097h)));
                sb.append("\n");
                sb.append("----- ");
                sb.append("launch end time ");
                sb.append(this.f47091b.format(Long.valueOf(this.f47097h + this.f47098i)));
                sb.append("\n");
                sb.append("----- ");
                sb.append("swan js version ");
                sb.append(this.f47094e);
                sb.append("\n");
                synchronized (this.f47093d) {
                    i2 = 0;
                    i3 = 0;
                    for (Map.Entry<String, List<d.a.n0.a.r1.k.a>> entry : this.f47092c.entrySet()) {
                        List<d.a.n0.a.r1.k.a> value = entry.getValue();
                        if (value != null && value.size() > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            int i4 = 0;
                            for (d.a.n0.a.r1.k.a aVar : value) {
                                if (this.f47090a == null || this.f47090a.a(aVar)) {
                                    sb2.append("----- start time ");
                                    sb2.append(this.f47091b.format(Long.valueOf(aVar.e())));
                                    sb2.append("\n");
                                    sb2.append("----- end time ");
                                    sb2.append(this.f47091b.format(Long.valueOf(aVar.d())));
                                    sb2.append("\n");
                                    sb2.append("----- cost time ");
                                    sb2.append(aVar.c());
                                    sb2.append("ms\n");
                                    sb2.append("----------------------------\n");
                                    i3++;
                                    i4++;
                                }
                            }
                            if (i4 > 0) {
                                sb.append("\n===== ");
                                sb.append(entry.getKey());
                                sb.append(" ");
                                sb.append(i4);
                                sb.append(" times\n");
                                sb.append((CharSequence) sb2);
                                i2++;
                            }
                        }
                    }
                }
                sb.append("===== total: ");
                sb.append(i2);
                sb.append(" apis, ");
                sb.append(i3);
                sb.append(" times");
                String sb3 = sb.toString();
                d.a.n0.a.e0.d.a("ApiCalledMarker", sb3);
                return sb3;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject l(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            return optJSONObject == null ? jSONObject.optJSONObject("value") : optJSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            String optString = jSONObject.optString("ubcId");
            return TextUtils.isEmpty(optString) ? jSONObject.optString("actionId") : optString;
        }
        return (String) invokeL.objValue;
    }

    public final void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) && this.j == null) {
            synchronized (this.f47093d) {
                if (this.j == null) {
                    this.j = jSONObject.has("caller") ? new d.a.n0.a.r1.k.j.b() : new d.a.n0.a.r1.k.j.a();
                }
            }
        }
    }

    public final boolean o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            long j2 = this.f47097h;
            return j >= j2 && j <= j2 + this.f47098i;
        }
        return invokeJ.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f47092c == null) {
            synchronized (this.f47093d) {
                if (this.f47092c == null) {
                    this.f47092c = new HashMap<>();
                    this.f47091b = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.f47090a = new a(this);
                }
            }
        }
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && k) {
            Log.d("ApiCalledMarker", str);
        }
    }

    public final boolean r(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) ? this.f47096g && j > this.f47097h + this.f47098i : invokeJ.booleanValue;
    }

    public final void s(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONArray) == null) {
            q("start parse api info");
            int length = jSONArray.length();
            boolean z = length > 0;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.length() > 0 && optJSONObject.optInt("success") == 1) {
                    z &= !t(optJSONObject);
                }
            }
            this.f47095f = z;
            q("start done " + this.f47095f);
        }
    }

    public final boolean t(JSONObject jSONObject) {
        InterceptResult invokeL;
        List<d.a.n0.a.r1.k.a> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jSONObject)) == null) {
            n(jSONObject);
            String optString = jSONObject.optString(com.alipay.sdk.cons.c.n);
            if (TextUtils.isEmpty(optString) || (a2 = this.j.a(jSONObject)) == null || a2.size() <= 0) {
                return true;
            }
            boolean z = a2.size() > 0;
            synchronized (this.f47093d) {
                List<d.a.n0.a.r1.k.a> list = this.f47092c.get(optString);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f47092c.put(optString, list);
                }
                list.addAll(a2);
                for (d.a.n0.a.r1.k.a aVar : a2) {
                    z &= r(aVar.e());
                }
            }
            if (k) {
                Log.d("ApiCalledMarker", "api - " + optString + ", all after fmp - " + z);
            }
            return !z;
        }
        return invokeL.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f47092c.size() > 0) {
                synchronized (this.f47093d) {
                    this.f47092c.clear();
                }
            }
            this.f47095f = false;
            this.f47096g = false;
            this.f47098i = 0L;
            this.f47097h = 0L;
            this.f47094e = null;
            v("===== loading... =====");
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d.a.n0.a.q2.d.j.d(str);
    }
}
