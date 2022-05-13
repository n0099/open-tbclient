package com.repackage;

import android.text.TextUtils;
import android.util.JsonWriter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h39 implements q49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public String c;
    public JSONObject d;
    public long e;
    public long f;
    public int g;
    public String h;
    public String i;
    public String j;
    public JSONArray k;
    public JSONArray l;
    public boolean m;
    public int n;
    public int o;
    public String p;

    public h39() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = false;
        this.n = 0;
        this.o = 0;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a = str;
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.k = new JSONArray(str);
            this.n = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.h = str;
        }
    }

    @Override // com.repackage.q49
    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        JSONObject e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put(LaunchedTaskSpeedStats.KEY_START_TIME, Long.toString(this.e));
            jSONObject.put("endtime", Long.toString(this.f));
            jSONObject.put("type", "1");
            y29 o = y29.o();
            jSONObject.put(Constant.IS_REAL, o.O(this.a) ? "1" : "0");
            int n = o.n(this.a);
            if (n != 0) {
                jSONObject.put("gflow", String.valueOf(n));
            }
            JSONObject jSONObject2 = this.d;
            if (jSONObject2 != null) {
                jSONObject.put("content", jSONObject2.toString());
            } else if (!TextUtils.isEmpty(this.c)) {
                jSONObject.put("content", this.c);
            }
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put("abtest", this.i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject.put("c", this.j);
            }
            JSONArray jSONArray = this.k;
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONObject.put(SpeedStatsMainTable.PART, this.k);
            }
            if (this.m) {
                jSONObject.put("of", "1");
            }
            jSONObject.put(Constant.ID_TYPE, o.z(this.a));
            JSONArray jSONArray2 = this.l;
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                jSONObject.put("eventlist", this.l);
            }
            if (!TextUtils.isEmpty(this.p) && (e = e()) != null) {
                jSONObject.put("bizInfo", e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.repackage.q49
    public void b(JsonWriter jsonWriter) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsonWriter) == null) {
            jsonWriter.beginObject();
            jsonWriter.name("id").value(this.a);
            jsonWriter.name(LaunchedTaskSpeedStats.KEY_START_TIME).value(Long.toString(this.e));
            jsonWriter.name("endtime").value(Long.toString(this.f));
            jsonWriter.name("type").value("1");
            jsonWriter.name(Constant.IS_REAL).value(y29.o().O(this.a) ? "1" : "0");
            int n = y29.o().n(this.a);
            if (n != 0) {
                jsonWriter.name("gflow").value(n);
            }
            if (this.d != null) {
                jsonWriter.name("content").value(this.d.toString());
            } else if (!TextUtils.isEmpty(this.c)) {
                jsonWriter.name("content").value(this.c);
            }
            if (!TextUtils.isEmpty(this.i)) {
                jsonWriter.name("abtest").value(this.i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                jsonWriter.name("c").value(this.j);
            }
            JSONArray jSONArray = this.k;
            if (jSONArray != null && jSONArray.length() > 0) {
                jsonWriter.name(SpeedStatsMainTable.PART);
                x49.a(jsonWriter, this.k);
            }
            if (this.m) {
                jsonWriter.name("of").value("1");
            }
            jsonWriter.name(Constant.ID_TYPE).value(y29.o().z(this.a));
            JSONArray jSONArray2 = this.l;
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                jsonWriter.name("eventlist");
                jsonWriter.beginArray();
                int length = this.l.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject = (JSONObject) this.l.get(i);
                        if (jSONObject != null) {
                            jsonWriter.beginObject();
                            if (jSONObject.has("id")) {
                                String optString = jSONObject.optString("id");
                                if (!TextUtils.isEmpty(optString)) {
                                    jsonWriter.name("id").value(optString);
                                }
                            }
                            if (jSONObject.has("timestamp")) {
                                jsonWriter.name("timestamp").value(Long.toString(jSONObject.optLong("timestamp")));
                            }
                            if (jSONObject.has("content")) {
                                String optString2 = jSONObject.optString("content");
                                if (!TextUtils.isEmpty(optString2)) {
                                    jsonWriter.name("content").value(optString2);
                                }
                            }
                            jsonWriter.endObject();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                jsonWriter.endArray();
            }
            if (!TextUtils.isEmpty(this.p) && e() != null) {
                jsonWriter.name("bizInfo");
                x49.a(jsonWriter, e());
            }
            jsonWriter.endObject();
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : invokeV.longValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TextUtils.isEmpty(this.p)) {
                return null;
            }
            try {
                return new JSONObject(this.p);
            } catch (JSONException e) {
                if (t39.m()) {
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int h() {
        InterceptResult invokeV;
        int length;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.o;
            if (i > 0) {
                return i;
            }
            int length2 = TextUtils.isEmpty(this.a) ? 0 : 0 + this.a.getBytes().length;
            JSONObject jSONObject = this.d;
            if (jSONObject != null) {
                try {
                    length = jSONObject.toString().getBytes("UTF-8").length;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                if (!TextUtils.isEmpty(this.c)) {
                    length = this.c.getBytes().length;
                }
                if (!TextUtils.isEmpty(this.i)) {
                    length2 += this.i.getBytes().length;
                }
                jSONArray = this.k;
                if (jSONArray != null && jSONArray.length() > 0) {
                    length2 += this.n;
                }
                if (!TextUtils.isEmpty(this.p)) {
                    length2 += this.p.getBytes().length;
                }
                this.o = length2;
                return length2;
            }
            length2 += length;
            if (!TextUtils.isEmpty(this.i)) {
            }
            jSONArray = this.k;
            if (jSONArray != null) {
                length2 += this.n;
            }
            if (!TextUtils.isEmpty(this.p)) {
            }
            this.o = length2;
            return length2;
        }
        return invokeV.intValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f : invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.b : invokeV.intValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.d : (JSONObject) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.g : invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.e = j;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.p = str;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.j = str;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.c = str;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.m = z;
        }
    }

    public void v(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.f = j;
        }
    }

    public void w(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jSONArray) == null) {
            this.l = jSONArray;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && y29.o().a(this.a)) {
            this.i = t39.i().h();
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.i = str;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.b = i;
        }
    }

    public h39(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = false;
        this.n = 0;
        this.o = 0;
        this.a = str;
        this.b = i;
        this.c = str2;
        this.g = i2;
    }

    public h39(String str, int i, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), jSONObject, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = false;
        this.n = 0;
        this.o = 0;
        this.a = str;
        this.b = i;
        this.d = jSONObject;
        this.g = i2;
    }
}
