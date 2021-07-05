package d.a.q0.a.i1.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f48653a;

    /* renamed from: b  reason: collision with root package name */
    public String f48654b;

    /* renamed from: c  reason: collision with root package name */
    public String f48655c;

    /* renamed from: d  reason: collision with root package name */
    public int f48656d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48657e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48658f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48659g;

    /* renamed from: h  reason: collision with root package name */
    public int f48660h;

    /* renamed from: i  reason: collision with root package name */
    public float f48661i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1621430899, "Ld/a/q0/a/i1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1621430899, "Ld/a/q0/a/i1/c/b;");
                return;
            }
        }
        boolean z = k.f49133a;
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
        this.f48653a = "";
        this.f48654b = "";
        this.f48655c = "";
        this.f48656d = 0;
        this.f48657e = false;
        this.f48658f = false;
        this.f48659g = true;
        this.f48660h = 0;
        this.f48661i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.f48653a = jSONObject.optString("audioId", bVar.f48653a);
                bVar2.f48654b = jSONObject.optString("slaveId", bVar.f48654b);
                bVar2.f48657e = jSONObject.optBoolean("autoplay", bVar.f48657e);
                bVar2.f48658f = jSONObject.optBoolean("loop", bVar.f48658f);
                bVar2.f48655c = jSONObject.optString("src", bVar.f48655c);
                bVar2.f48656d = jSONObject.optInt("startTime", bVar.f48656d);
                bVar2.f48659g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f48659g);
                bVar2.f48660h = jSONObject.optInt("position", bVar.f48660h);
                bVar2.f48661i = (float) jSONObject.optDouble("volume", bVar.f48661i);
                bVar2.j = jSONObject.optString("cb", bVar.j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f48653a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.f48653a + "; slaveId : " + this.f48654b + "; url : " + this.f48655c + "; AutoPlay : " + this.f48657e + "; Loop : " + this.f48658f + "; startTime : " + this.f48656d + "; ObeyMute : " + this.f48659g + "; pos : " + this.f48660h;
        }
        return (String) invokeV.objValue;
    }
}
