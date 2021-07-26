package d.a.o0.a.t1.c.c;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.g1.f;
import d.a.o0.a.o0.d.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f47891a;

    /* renamed from: b  reason: collision with root package name */
    public String f47892b;

    /* renamed from: c  reason: collision with root package name */
    public Object f47893c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47894d;

    /* renamed from: e  reason: collision with root package name */
    public String f47895e;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47894d = false;
        this.f47892b = str;
    }

    public static String a(d.a.o0.a.t1.c.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("componentId", bVar.f47887f);
                jSONObject.put("pluginProvider", bVar.f47883b);
                jSONObject.put("args", bVar.f47888g);
                jSONObject.put("slaveId", bVar.f47886e);
            } catch (JSONException e2) {
                d.a.o0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g gVar = new g();
            ?? jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "functionPageFinished");
                jSONObject.put("componentId", this.f47892b);
                jSONObject.put("isSuccess", this.f47894d);
                jSONObject.put("data", this.f47895e);
                if (this.f47893c != null) {
                    jSONObject.put("error", this.f47893c.toString());
                }
            } catch (JSONException e2) {
                d.a.o0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
            gVar.f47056c = jSONObject;
            f.V().m(this.f47891a, gVar);
            d.a.o0.a.t1.d.a.a("finish event, isSuccess = " + this.f47894d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f47892b + "', error=" + this.f47893c + ", isSuccess=" + this.f47894d + ", resultData='" + this.f47895e + "'}";
        }
        return (String) invokeV.objValue;
    }
}
