package d.a.r0;

import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f67420a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f67421b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f67422c;

    /* renamed from: d  reason: collision with root package name */
    public long f67423d;

    /* renamed from: e  reason: collision with root package name */
    public long f67424e;

    /* renamed from: f  reason: collision with root package name */
    public String f67425f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67426g;

    /* renamed from: h  reason: collision with root package name */
    public int f67427h;

    /* renamed from: i  reason: collision with root package name */
    public int f67428i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1325379416, "Ld/a/r0/i0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1325379416, "Ld/a/r0/i0;");
                return;
            }
        }
        j = AppConfig.isDebug();
    }

    public i0() {
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
        this.f67426g = false;
        this.f67427h = 0;
        this.f67428i = 614400;
        this.f67420a = new JSONArray();
        this.f67421b = new SparseArray<>();
        this.f67422c = new ArrayList<>();
        this.f67423d = 0L;
        this.f67424e = 0L;
        this.f67425f = "0";
    }

    public final void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.f67420a.put(jSONObject);
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f67420a.toString().getBytes().length >= i2 : invokeI.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67421b.clear();
            this.f67422c.clear();
            this.f67420a = null;
        }
    }

    public JSONArray d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67420a : (JSONArray) invokeV.objValue;
    }

    public final ArrayList e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67422c : (ArrayList) invokeV.objValue;
    }

    public final SparseArray<Integer> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67421b : (SparseArray) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67424e : invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f67423d : invokeV.longValue;
    }

    public JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("data", this.f67420a);
                if (this.f67423d == 0 || this.f67424e == 0) {
                    this.f67423d = this.f67424e;
                }
                jSONObject2.put("mintime", Long.toString(this.f67423d));
                jSONObject2.put("maxtime", Long.toString(this.f67424e));
                jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                jSONObject2.put(PackageTable.MD5, g0.b(this.f67420a.toString().getBytes(), true));
                jSONObject.put("metadata", jSONObject2);
                jSONObject.put("isAbtest", this.f67425f);
                jSONObject.put(Constant.IS_REAL, this.f67426g ? "1" : "0");
            } catch (JSONException unused) {
                if (j) {
                    Log.d("UBCUploadData", "json exception:");
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f67420a.length() == 0 : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f67427h >= this.f67428i : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f67426g : invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f67427h += i2;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || this.f67422c.contains(str)) {
            return;
        }
        this.f67422c.add(str);
    }

    public final void o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            this.f67421b.put(i2, Integer.valueOf(i3));
        }
    }

    public final void p(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            long j4 = this.f67423d;
            if ((j2 < j4 || j4 == 0) && j2 != 0) {
                this.f67423d = j2;
            }
            if (j3 > this.f67424e) {
                this.f67424e = j3;
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f67425f = str;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f67426g = z;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 < 0) {
            return;
        }
        this.f67428i = i2;
    }
}
