package d.a.s0;

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
    public JSONArray f68098a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f68099b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f68100c;

    /* renamed from: d  reason: collision with root package name */
    public long f68101d;

    /* renamed from: e  reason: collision with root package name */
    public long f68102e;

    /* renamed from: f  reason: collision with root package name */
    public String f68103f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68104g;

    /* renamed from: h  reason: collision with root package name */
    public int f68105h;

    /* renamed from: i  reason: collision with root package name */
    public int f68106i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1296750265, "Ld/a/s0/i0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1296750265, "Ld/a/s0/i0;");
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
        this.f68104g = false;
        this.f68105h = 0;
        this.f68106i = 614400;
        this.f68098a = new JSONArray();
        this.f68099b = new SparseArray<>();
        this.f68100c = new ArrayList<>();
        this.f68101d = 0L;
        this.f68102e = 0L;
        this.f68103f = "0";
    }

    public final void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.f68098a.put(jSONObject);
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f68098a.toString().getBytes().length >= i2 : invokeI.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f68099b.clear();
            this.f68100c.clear();
            this.f68098a = null;
        }
    }

    public JSONArray d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68098a : (JSONArray) invokeV.objValue;
    }

    public final ArrayList e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68100c : (ArrayList) invokeV.objValue;
    }

    public final SparseArray<Integer> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f68099b : (SparseArray) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f68102e : invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f68101d : invokeV.longValue;
    }

    public JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("data", this.f68098a);
                if (this.f68101d == 0 || this.f68102e == 0) {
                    this.f68101d = this.f68102e;
                }
                jSONObject2.put("mintime", Long.toString(this.f68101d));
                jSONObject2.put("maxtime", Long.toString(this.f68102e));
                jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                jSONObject2.put(PackageTable.MD5, g0.b(this.f68098a.toString().getBytes(), true));
                jSONObject.put("metadata", jSONObject2);
                jSONObject.put("isAbtest", this.f68103f);
                jSONObject.put(Constant.IS_REAL, this.f68104g ? "1" : "0");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f68098a.length() == 0 : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f68105h >= this.f68106i : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f68104g : invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f68105h += i2;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || this.f68100c.contains(str)) {
            return;
        }
        this.f68100c.add(str);
    }

    public final void o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            this.f68099b.put(i2, Integer.valueOf(i3));
        }
    }

    public final void p(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            long j4 = this.f68101d;
            if ((j2 < j4 || j4 == 0) && j2 != 0) {
                this.f68101d = j2;
            }
            if (j3 > this.f68102e) {
                this.f68102e = j3;
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f68103f = str;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f68104g = z;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 < 0) {
            return;
        }
        this.f68106i = i2;
    }
}
