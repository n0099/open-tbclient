package d.a.q0.a.q;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f50068a;

    /* renamed from: b  reason: collision with root package name */
    public String f50069b;

    /* renamed from: c  reason: collision with root package name */
    public String f50070c;

    /* renamed from: d  reason: collision with root package name */
    public int f50071d;

    /* renamed from: e  reason: collision with root package name */
    public int f50072e;

    /* renamed from: f  reason: collision with root package name */
    public int f50073f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50074g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(835324815, "Ld/a/q0/a/q/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(835324815, "Ld/a/q0/a/q/c;");
                return;
            }
        }
        boolean z = k.f49133a;
    }

    public c(String str, String str2, String str3, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50068a = str;
        this.f50069b = str2;
        this.f50070c = str3;
        this.f50071d = i2;
        this.f50072e = i3;
        this.f50073f = i4;
        this.f50074g = z;
    }

    public d.a.q0.a.i1.g.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                d.a.q0.a.i1.g.c cVar = new d.a.q0.a.i1.g.c();
                cVar.n = "SwanAdPlayer";
                cVar.f46779f = "SwanAdPlayer";
                cVar.s = true;
                cVar.o = false;
                cVar.B = !this.f50074g;
                cVar.M = false;
                cVar.p = this.f50068a;
                cVar.C = this.f50069b;
                cVar.f46780g = this.f50070c;
                d.a.q0.a.l1.e.a.a aVar = new d.a.q0.a.l1.e.a.a(0, 0, this.f50071d, this.f50072e);
                cVar.l = aVar;
                aVar.l(true);
                cVar.q = this.f50073f;
                if (this.f50074g) {
                    cVar.u = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return d.a.q0.a.i1.g.c.j(jSONObject, cVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (d.a.q0.a.i1.g.c) invokeV.objValue;
    }
}
