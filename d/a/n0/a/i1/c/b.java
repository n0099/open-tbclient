package d.a.n0.a.i1.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45351a;

    /* renamed from: b  reason: collision with root package name */
    public String f45352b;

    /* renamed from: c  reason: collision with root package name */
    public String f45353c;

    /* renamed from: d  reason: collision with root package name */
    public int f45354d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45355e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45356f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45357g;

    /* renamed from: h  reason: collision with root package name */
    public int f45358h;

    /* renamed from: i  reason: collision with root package name */
    public float f45359i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1234182742, "Ld/a/n0/a/i1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1234182742, "Ld/a/n0/a/i1/c/b;");
                return;
            }
        }
        boolean z = k.f45831a;
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
        this.f45351a = "";
        this.f45352b = "";
        this.f45353c = "";
        this.f45354d = 0;
        this.f45355e = false;
        this.f45356f = false;
        this.f45357g = true;
        this.f45358h = 0;
        this.f45359i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.f45351a = jSONObject.optString("audioId", bVar.f45351a);
                bVar2.f45352b = jSONObject.optString("slaveId", bVar.f45352b);
                bVar2.f45355e = jSONObject.optBoolean("autoplay", bVar.f45355e);
                bVar2.f45356f = jSONObject.optBoolean("loop", bVar.f45356f);
                bVar2.f45353c = jSONObject.optString("src", bVar.f45353c);
                bVar2.f45354d = jSONObject.optInt("startTime", bVar.f45354d);
                bVar2.f45357g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f45357g);
                bVar2.f45358h = jSONObject.optInt("position", bVar.f45358h);
                bVar2.f45359i = (float) jSONObject.optDouble("volume", bVar.f45359i);
                bVar2.j = jSONObject.optString("cb", bVar.j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f45351a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.f45351a + "; slaveId : " + this.f45352b + "; url : " + this.f45353c + "; AutoPlay : " + this.f45355e + "; Loop : " + this.f45356f + "; startTime : " + this.f45354d + "; ObeyMute : " + this.f45357g + "; pos : " + this.f45358h;
        }
        return (String) invokeV.objValue;
    }
}
