package d.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long m;
    public String n;
    public String o;
    public int p;

    public w() {
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
            this.f69278f = cursor.getLong(1);
            this.f69279g = cursor.getString(2);
            this.f69280h = cursor.getString(3);
            this.o = cursor.getString(4);
            this.n = cursor.getString(5);
            this.m = cursor.getLong(6);
            this.p = cursor.getInt(7);
            return this;
        }
        return (p) invokeL.objValue;
    }

    @Override // d.b.a.p
    public void d(@NonNull ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentValues) == null) {
            contentValues.put("local_time_ms", Long.valueOf(this.f69277e));
            contentValues.put("tea_event_index", Long.valueOf(this.f69278f));
            contentValues.put("session_id", this.f69279g);
            contentValues.put("user_unique_id", this.f69280h);
            contentValues.put("page_key", this.o);
            contentValues.put("refer_page_key", this.n);
            contentValues.put("duration", Long.valueOf(this.m));
            contentValues.put("is_back", Integer.valueOf(this.p));
        }
    }

    @Override // d.b.a.p
    public void e(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            jSONObject.put("page_key", this.o);
            jSONObject.put("refer_page_key", this.n);
            jSONObject.put("duration", this.m);
            jSONObject.put("local_time_ms", this.f69277e);
            jSONObject.put("session_id", this.f69279g);
            jSONObject.put("tea_event_index", this.f69278f);
            jSONObject.put("is_back", this.p);
        }
    }

    @Override // d.b.a.p
    public String[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer"} : (String[]) invokeV.objValue;
    }

    @Override // d.b.a.p
    public p h(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            this.f69277e = jSONObject.optLong("local_time_ms", 0L);
            this.f69278f = jSONObject.optLong("tea_event_index", 0L);
            this.f69279g = jSONObject.optString("session_id", null);
            this.o = jSONObject.optString("page_key", null);
            this.n = jSONObject.optString("refer_page_key", null);
            this.m = jSONObject.optLong("duration", 0L);
            this.p = jSONObject.optInt("is_back", 0);
            return this;
        }
        return (p) invokeL.objValue;
    }

    @Override // d.b.a.p
    public JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("local_time_ms", this.f69277e);
            jSONObject.put("tea_event_index", this.f69278f);
            jSONObject.put("session_id", this.f69279g);
            if (!TextUtils.isEmpty(this.f69280h)) {
                jSONObject.put("user_unique_id", this.f69280h);
            }
            jSONObject.put("event", "bav2b_page");
            jSONObject.put("is_bav", 1);
            jSONObject.put("params", r());
            jSONObject.put("datetime", this.k);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // d.b.a.p
    @NonNull
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "page" : (String) invokeV.objValue;
    }

    @Override // d.b.a.p
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return super.o() + " name:" + this.o + " duration:" + this.m;
        }
        return (String) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m == -1 : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o.contains(":") : invokeV.booleanValue;
    }

    public final JSONObject r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("page_key", this.o);
            jSONObject.put("refer_page_key", this.n);
            jSONObject.put("is_back", this.p);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
