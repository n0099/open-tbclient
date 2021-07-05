package d.a.q0.a.m1;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.j2.h;
import d.a.q0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(d dVar, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{dVar, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e2 = c.e();
            if (dVar != null) {
                try {
                    e2.put("page", dVar.f49394b);
                } catch (JSONException e3) {
                    if (d.a.q0.a.a2.e.y) {
                        e3.printStackTrace();
                    }
                }
            }
            e2.put("firstPage", z2);
            if (z && bitmap != null) {
                e2.put("image", c.c(bitmap));
            }
            return e2;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (dVar != null) {
                try {
                    jSONObject.put("isH5Componet", dVar.f49399g == 0 ? "0" : "1");
                } catch (JSONException e2) {
                    if (d.a.q0.a.a2.e.y) {
                        e2.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(d dVar, int i2, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{dVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            d(dVar, i2, false, null, z, i3);
        }
    }

    public static void d(d dVar, int i2, boolean z, Bitmap bitmap, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{dVar, Integer.valueOf(i2), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
            aVar.j(5L);
            aVar.h(i2);
            if (!h.f49063e || z2) {
                aVar.e(a(dVar, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i3);
            d.a.q0.a.j2.p.d dVar2 = new d.a.q0.a.j2.p.d();
            dVar2.p(aVar);
            dVar2.q(k.m(d.a.q0.a.a2.d.g().l()));
            dVar2.m(d.a.q0.a.a2.d.g().getAppId());
            dVar2.s = dVar.f49394b;
            dVar2.n(false);
            b.a L = d.a.q0.a.a2.e.Q() != null ? d.a.q0.a.a2.e.Q().L() : null;
            if (!h.f49063e || z2) {
                dVar2.s(valueOf);
                dVar2.r(L);
                dVar2.e(b(dVar));
                dVar2.e(d.a.q0.a.i2.a.d().e());
                dVar2.e(d.a.q0.a.i2.a.d().g());
            }
            k.L(dVar2);
        }
    }
}
