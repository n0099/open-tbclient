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
/* loaded from: classes7.dex */
public class rt2 implements tt2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public st2 a;
    public SimpleDateFormat b;
    public HashMap<String, List<qt2>> c;
    public final Object d;
    public String e;
    public boolean f;
    public boolean g;
    public long h;
    public long i;
    public volatile eu2 j;

    /* loaded from: classes7.dex */
    public class a implements st2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt2 a;

        public a(rt2 rt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rt2Var;
        }

        @Override // com.repackage.st2
        public boolean a(qt2 qt2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qt2Var)) == null) {
                if (qt2Var == null || qt2Var.c() < 0) {
                    return false;
                }
                if (rt2.k || qt2Var.b() == 0) {
                    return this.a.m(qt2Var.e());
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755338879, "Lcom/repackage/rt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755338879, "Lcom/repackage/rt2;");
                return;
            }
        }
        k = sg1.a;
    }

    public rt2() {
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

    @Override // com.repackage.tt2
    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && vt2.h().k()) {
            n();
            if (this.f) {
                o("aiapp start finish");
                return;
            }
            o("ubcReport enter");
            if (jSONObject != null && jSONObject.length() > 0) {
                String k2 = k(jSONObject);
                o("Id " + k2);
                if (TextUtils.equals(k2, "786")) {
                    if (k) {
                        Log.d("ApiCalledMarker", jSONObject.toString());
                    }
                    JSONObject j = j(jSONObject);
                    if (j != null && j.length() > 0) {
                        JSONObject optJSONObject = j.optJSONObject("ext");
                        if (optJSONObject != null && optJSONObject.length() > 0) {
                            if (TextUtils.isEmpty(this.e)) {
                                this.e = optJSONObject.optString("swan");
                                o("current swan version " + this.e);
                            }
                            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                q(optJSONArray);
                                o("ubcReport over");
                                t(i());
                                return;
                            }
                            o("value-ext-list is empty");
                            return;
                        }
                        o("value-ext is empty");
                        return;
                    }
                    o("value is empty");
                    return;
                }
                return;
            }
            o("json data is empty");
        }
    }

    @Override // com.repackage.ut2
    public void end(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.g = true;
            this.i = j;
            t(i());
            o("launch end time-" + (this.h + this.i));
        }
    }

    public String i() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
                    for (Map.Entry<String, List<qt2>> entry : this.c.entrySet()) {
                        List<qt2> value = entry.getValue();
                        if (value != null && value.size() > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            int i3 = 0;
                            for (qt2 qt2Var : value) {
                                if (this.a == null || this.a.a(qt2Var)) {
                                    sb2.append("----- start time ");
                                    sb2.append(this.b.format(Long.valueOf(qt2Var.e())));
                                    sb2.append("\n");
                                    sb2.append("----- end time ");
                                    sb2.append(this.b.format(Long.valueOf(qt2Var.d())));
                                    sb2.append("\n");
                                    sb2.append("----- cost time ");
                                    sb2.append(qt2Var.c());
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
                ix1.b("ApiCalledMarker", sb3);
                return sb3;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            return optJSONObject == null ? jSONObject.optJSONObject("value") : optJSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String k(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            String optString = jSONObject.optString("ubcId");
            return TextUtils.isEmpty(optString) ? jSONObject.optString("actionId") : optString;
        }
        return (String) invokeL.objValue;
    }

    public final void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) && this.j == null) {
            synchronized (this.d) {
                if (this.j == null) {
                    this.j = jSONObject.has("caller") ? new du2() : new cu2();
                }
            }
        }
    }

    public final boolean m(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            long j2 = this.h;
            return j >= j2 && j <= j2 + this.i;
        }
        return invokeJ.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.c == null) {
            synchronized (this.d) {
                if (this.c == null) {
                    this.c = new HashMap<>();
                    this.b = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.a = new a(this);
                }
            }
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && k) {
            Log.d("ApiCalledMarker", str);
        }
    }

    public final boolean p(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) ? this.g && j > this.h + this.i : invokeJ.booleanValue;
    }

    public final void q(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONArray) == null) {
            o("start parse api info");
            int length = jSONArray.length();
            boolean z = length > 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.length() > 0 && optJSONObject.optInt("success") == 1) {
                    z &= !r(optJSONObject);
                }
            }
            this.f = z;
            o("start done " + this.f);
        }
    }

    public final boolean r(JSONObject jSONObject) {
        InterceptResult invokeL;
        List<qt2> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jSONObject)) == null) {
            l(jSONObject);
            String optString = jSONObject.optString("apiName");
            if (TextUtils.isEmpty(optString) || (a2 = this.j.a(jSONObject)) == null || a2.size() <= 0) {
                return true;
            }
            boolean z = a2.size() > 0;
            synchronized (this.d) {
                List<qt2> list = this.c.get(optString);
                if (list == null) {
                    list = new ArrayList<>();
                    this.c.put(optString, list);
                }
                list.addAll(a2);
                for (qt2 qt2Var : a2) {
                    z &= p(qt2Var.e());
                }
            }
            if (k) {
                Log.d("ApiCalledMarker", "api - " + optString + ", all after fmp - " + z);
            }
            return !z;
        }
        return invokeL.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
            t("===== loading... =====");
        }
    }

    @Override // com.repackage.ut2
    public void start(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            n();
            s();
            this.h = j;
            o("launch start time-" + j);
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ec3.j.update((dc3<String>) str);
    }
}
