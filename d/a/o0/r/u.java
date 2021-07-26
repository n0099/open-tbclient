package d.a.o0.r;

import android.util.SparseIntArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f51609a;

    /* renamed from: b  reason: collision with root package name */
    public SparseIntArray f51610b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f51611c;

    /* renamed from: d  reason: collision with root package name */
    public long f51612d;

    /* renamed from: e  reason: collision with root package name */
    public long f51613e;

    /* renamed from: f  reason: collision with root package name */
    public String f51614f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51615g;

    public u() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51615g = false;
        this.f51609a = new JSONArray();
        this.f51610b = new SparseIntArray();
        this.f51611c = new ArrayList<>();
        this.f51612d = 0L;
        this.f51613e = 0L;
        this.f51614f = "0";
    }

    public final void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.f51609a.put(jSONObject);
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f51609a.toString().getBytes().length >= i2 : invokeI.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f51610b.clear();
            this.f51611c.clear();
            this.f51609a = null;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51609a.length() == 0 : invokeV.booleanValue;
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f51611c.contains(str)) {
            return;
        }
        this.f51611c.add(str);
    }

    public final void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.f51610b.put(i2, i3);
        }
    }

    public final void g(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            long j3 = this.f51612d;
            if ((j < j3 || j3 == 0) && j != 0) {
                this.f51612d = j;
            }
            if (j2 > this.f51613e) {
                this.f51613e = j2;
            }
        }
    }
}
