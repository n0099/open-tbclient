package d.a.o0.a.i1.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45855a;

    /* renamed from: b  reason: collision with root package name */
    public String f45856b;

    /* renamed from: c  reason: collision with root package name */
    public String f45857c;

    /* renamed from: d  reason: collision with root package name */
    public int f45858d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45859e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45860f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45861g;

    /* renamed from: h  reason: collision with root package name */
    public int f45862h;

    /* renamed from: i  reason: collision with root package name */
    public float f45863i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1363265461, "Ld/a/o0/a/i1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1363265461, "Ld/a/o0/a/i1/c/b;");
                return;
            }
        }
        boolean z = k.f46335a;
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
        this.f45855a = "";
        this.f45856b = "";
        this.f45857c = "";
        this.f45858d = 0;
        this.f45859e = false;
        this.f45860f = false;
        this.f45861g = true;
        this.f45862h = 0;
        this.f45863i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.f45855a = jSONObject.optString("audioId", bVar.f45855a);
                bVar2.f45856b = jSONObject.optString("slaveId", bVar.f45856b);
                bVar2.f45859e = jSONObject.optBoolean("autoplay", bVar.f45859e);
                bVar2.f45860f = jSONObject.optBoolean("loop", bVar.f45860f);
                bVar2.f45857c = jSONObject.optString("src", bVar.f45857c);
                bVar2.f45858d = jSONObject.optInt("startTime", bVar.f45858d);
                bVar2.f45861g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f45861g);
                bVar2.f45862h = jSONObject.optInt("position", bVar.f45862h);
                bVar2.f45863i = (float) jSONObject.optDouble("volume", bVar.f45863i);
                bVar2.j = jSONObject.optString("cb", bVar.j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f45855a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.f45855a + "; slaveId : " + this.f45856b + "; url : " + this.f45857c + "; AutoPlay : " + this.f45859e + "; Loop : " + this.f45860f + "; startTime : " + this.f45858d + "; ObeyMute : " + this.f45861g + "; pos : " + this.f45862h;
        }
        return (String) invokeV.objValue;
    }
}
