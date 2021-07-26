package d.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class v extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] m;
    public int n;
    public int o;
    public JSONArray p;
    public JSONArray q;
    public u r;
    public JSONArray s;
    public y t;
    public JSONObject u;
    public JSONArray v;

    public v() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.b.a.p
    @NonNull
    public p a(@NonNull Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cursor)) == null) {
            this.f69277e = cursor.getLong(0);
            this.m = cursor.getBlob(1);
            this.n = cursor.getInt(2);
            this.u = null;
            this.r = null;
            this.t = null;
            this.s = null;
            this.p = null;
            this.q = null;
            this.v = null;
            return this;
        }
        return (p) invokeL.objValue;
    }

    @Override // d.b.a.p
    public void d(@NonNull ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentValues) == null) {
            contentValues.put("local_time_ms", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("_data", AppLog.toEncryptByte(m().toString()));
        }
    }

    @Override // d.b.a.p
    public void e(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            h0.b(null);
        }
    }

    @Override // d.b.a.p
    public String[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new String[]{"local_time_ms", "integer", "_data", "blob", "_fail", "integer", "_full", "integer"} : (String[]) invokeV.objValue;
    }

    @Override // d.b.a.p
    public p h(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            h0.b(null);
            return null;
        }
        return (p) invokeL.objValue;
    }

    @Override // d.b.a.p
    public JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", this.u);
            jSONObject.put("time_sync", n.f69261b);
            if (this.r != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.r.m());
                jSONObject.put("launch", jSONArray);
            }
            y yVar = this.t;
            if (yVar != null) {
                JSONObject m = yVar.m();
                JSONArray jSONArray2 = this.s;
                int length = jSONArray2 != null ? jSONArray2.length() : 0;
                JSONArray jSONArray3 = new JSONArray();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONArray jSONArray4 = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject(new JSONObject(this.s.optString(i2)).optString("params"));
                    jSONArray4.put(0, jSONObject2.optString("page_key", ""));
                    jSONArray4.put(1, (jSONObject2.optInt("duration", 0) + 999) / 1000);
                    jSONArray3.put(jSONArray4);
                }
                if (length > 0) {
                    m.put("activites", jSONArray3);
                }
                JSONArray jSONArray5 = new JSONArray();
                jSONArray5.put(m);
                jSONObject.put("terminate", jSONArray5);
            }
            JSONArray jSONArray6 = this.p;
            int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
            if (length2 > 0) {
                jSONObject.put("event", this.p);
            }
            JSONArray jSONArray7 = this.s;
            int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
            if (this.q == null) {
                this.q = this.s;
            } else if (length3 > 0) {
                for (int i3 = 0; i3 < length3; i3++) {
                    this.q.put(this.s.get(i3));
                }
            }
            JSONArray jSONArray8 = this.q;
            int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
            if (length4 > 0) {
                jSONObject.put("event_v3", this.q);
            }
            JSONArray jSONArray9 = this.v;
            int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
            if (length5 > 0) {
                jSONObject.put("log_data", this.v);
            }
            StringBuilder sb = new StringBuilder("wP {");
            Object obj = this.r;
            if (obj == null) {
                obj = "la";
            }
            sb.append(obj);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            Object obj2 = this.t;
            if (obj2 == null) {
                obj2 = "te";
            }
            sb.append(obj2);
            sb.append(", p: ");
            sb.append(length3);
            sb.append(", v1: ");
            sb.append(length2);
            sb.append(", v3: ");
            sb.append(length4);
            sb.append("}");
            sb.append(", m: ");
            sb.append(length5);
            sb.append("}");
            h0.e(sb.toString(), null);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // d.b.a.p
    @NonNull
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "pack" : (String) invokeV.objValue;
    }

    public void p(long j, JSONObject jSONObject, u uVar, y yVar, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), jSONObject, uVar, yVar, jSONArray, jSONArray2, jSONArray3, jSONArray4}) == null) {
            this.f69277e = j;
            this.u = jSONObject;
            this.r = uVar;
            this.t = yVar;
            this.s = null;
            this.p = jSONArray2;
            this.q = jSONArray3;
            this.v = jSONArray4;
        }
    }
}
