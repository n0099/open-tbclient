package com.repackage;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class du2 implements fu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public eu2 a;
    public SimpleDateFormat b;
    public HashMap<String, List<cu2>> c;
    public final Object d;
    public String e;
    public boolean f;
    public boolean g;
    public long h;
    public long i;
    public volatile qu2 j;

    /* loaded from: classes5.dex */
    public class a implements eu2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du2 a;

        public a(du2 du2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du2Var;
        }

        @Override // com.repackage.eu2
        public boolean a(cu2 cu2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cu2Var)) == null) {
                if (cu2Var == null || cu2Var.c() < 0) {
                    return false;
                }
                if (du2.k || cu2Var.b() == 0) {
                    return this.a.o(cu2Var.e());
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755754992, "Lcom/repackage/du2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755754992, "Lcom/repackage/du2;");
                return;
            }
        }
        k = eh1.a;
    }

    public du2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new Object();
    }

    @Override // com.repackage.gu2
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            p();
            u();
            this.h = j;
            q("launch start time-" + j);
        }
    }

    @Override // com.repackage.gu2
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.g = true;
            this.i = j;
            v(k());
            q("launch end time-" + (this.h + this.i));
        }
    }

    @Override // com.repackage.fu2
    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) && hu2.j().m()) {
            p();
            if (this.f) {
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
                            if (TextUtils.isEmpty(this.e)) {
                                this.e = optJSONObject.optString("swan");
                                q("current swan version " + this.e);
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
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.g && this.b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("----- ");
                sb.append("launch start time ");
                sb.append(this.b.format(Long.valueOf(this.h)));
                sb.append("\n");
                sb.append("----- ");
                sb.append("launch end time ");
                sb.append(this.b.format(Long.valueOf(this.h + this.i)));
                sb.append("\n");
                sb.append("----- ");
                sb.append("swan js version ");
                sb.append(this.e);
                sb.append("\n");
                synchronized (this.d) {
                    i = 0;
                    i2 = 0;
                    for (Map.Entry<String, List<cu2>> entry : this.c.entrySet()) {
                        List<cu2> value = entry.getValue();
                        if (value != null && value.size() > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            int i3 = 0;
                            for (cu2 cu2Var : value) {
                                if (this.a == null || this.a.a(cu2Var)) {
                                    sb2.append("----- start time ");
                                    sb2.append(this.b.format(Long.valueOf(cu2Var.e())));
                                    sb2.append("\n");
                                    sb2.append("----- end time ");
                                    sb2.append(this.b.format(Long.valueOf(cu2Var.d())));
                                    sb2.append("\n");
                                    sb2.append("----- cost time ");
                                    sb2.append(cu2Var.c());
                                    sb2.append("ms\n");
                                    sb2.append("----------------------------\n");
                                    i2++;
                                    i3++;
                                }
                            }
                            if (i3 > 0) {
                                sb.append("\n===== ");
                                sb.append(entry.getKey());
                                sb.append(" ");
                                sb.append(i3);
                                sb.append(" times\n");
                                sb.append((CharSequence) sb2);
                                i++;
                            }
                        }
                    }
                }
                sb.append("===== total: ");
                sb.append(i);
                sb.append(" apis, ");
                sb.append(i2);
                sb.append(" times");
                String sb3 = sb.toString();
                ux1.b("ApiCalledMarker", sb3);
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
            synchronized (this.d) {
                if (this.j == null) {
                    this.j = jSONObject.has("caller") ? new pu2() : new ou2();
                }
            }
        }
    }

    public final boolean o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            long j2 = this.h;
            return j >= j2 && j <= j2 + this.i;
        }
        return invokeJ.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.c == null) {
            synchronized (this.d) {
                if (this.c == null) {
                    this.c = new HashMap<>();
                    this.b = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.a = new a(this);
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
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) ? this.g && j > this.h + this.i : invokeJ.booleanValue;
    }

    public final void s(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONArray) == null) {
            q("start parse api info");
            int length = jSONArray.length();
            boolean z = length > 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.length() > 0 && optJSONObject.optInt("success") == 1) {
                    z &= !t(optJSONObject);
                }
            }
            this.f = z;
            q("start done " + this.f);
        }
    }

    public final boolean t(JSONObject jSONObject) {
        InterceptResult invokeL;
        List<cu2> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jSONObject)) == null) {
            n(jSONObject);
            String optString = jSONObject.optString("apiName");
            if (TextUtils.isEmpty(optString) || (a2 = this.j.a(jSONObject)) == null || a2.size() <= 0) {
                return true;
            }
            boolean z = a2.size() > 0;
            synchronized (this.d) {
                List<cu2> list = this.c.get(optString);
                if (list == null) {
                    list = new ArrayList<>();
                    this.c.put(optString, list);
                }
                list.addAll(a2);
                for (cu2 cu2Var : a2) {
                    z &= r(cu2Var.e());
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
            if (this.c.size() > 0) {
                synchronized (this.d) {
                    this.c.clear();
                }
            }
            this.f = false;
            this.g = false;
            this.i = 0L;
            this.h = 0L;
            this.e = null;
            v("===== loading... =====");
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        qc3.j.update((pc3<String>) str);
    }
}
