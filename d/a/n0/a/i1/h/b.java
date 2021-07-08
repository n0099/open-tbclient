package d.a.n0.a.i1.h;

import android.text.TextUtils;
import com.baidu.ar.face.algo.FAUEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f45642a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Integer> f45643b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f45644c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1234331697, "Ld/a/n0/a/i1/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1234331697, "Ld/a/n0/a/i1/h/b;");
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        f45642a = hashMap;
        hashMap.put("VRModeProjectionSphere", 201);
        f45642a.put("VRModeProjectionDome180", 202);
        f45642a.put("VRModeProjectionDome230", 203);
        f45642a.put("VRModeProjectionDome180Upper", 204);
        f45642a.put("VRModeProjectionDome230Upper", 205);
        f45642a.put("VRModeProjectionPlaneFit", 207);
        f45642a.put("VRModeProjectionPlaneCrop", 208);
        f45642a.put("VRModeProjectionPlaneFull", Integer.valueOf((int) FAUEnum.PR_TIMEOUT));
        f45642a.put("VRModeProjectionMultiFishEyeHorizontal", 210);
        f45642a.put("VRModeProjectionMultiFishEyeVertical", 211);
        f45642a.put("VRModeProjectionStereoSphereHorizontal", 212);
        f45642a.put("VRModeProjectionStereoSphereVertical", 213);
        f45642a.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        f45642a.put("VRModeProjectionStereoPlaneFitVertical", Integer.valueOf((int) JfifUtil.MARKER_RST7));
        f45642a.put("VRModeProjectionPlaneFullHorizontal", Integer.valueOf((int) JfifUtil.MARKER_SOI));
        f45642a.put("VRModeProjectionPlaneFullVertical", 217);
        HashMap<String, Integer> hashMap2 = new HashMap<>(2);
        f45643b = hashMap2;
        hashMap2.put("VRModeDisplayNormal", 101);
        f45643b.put("VRModeDisplayGlass", 102);
        HashMap<String, Integer> hashMap3 = new HashMap<>(5);
        f45644c = hashMap3;
        hashMap3.put("VRModeInteractiveMotion", 1);
        f45644c.put("VRModeInteractiveTouch", 2);
        f45644c.put("VRModeInteractiveMotionWithTouch", 3);
        f45644c.put("VRModeInteractiveGVRMotion", 4);
        f45644c.put("VRModeInteractiveGVRMotionWithTouch", 5);
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
            }
        }
    }

    public b a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            b bVar = new b();
            if (jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("projectionMode");
            if (!TextUtils.isEmpty(optString) && f45642a.containsKey(optString)) {
                f45642a.get(optString).intValue();
            }
            String optString2 = jSONObject.optString("displayMode");
            if (!TextUtils.isEmpty(optString2) && f45643b.containsKey(optString2)) {
                f45643b.get(optString2).intValue();
            }
            String optString3 = jSONObject.optString("interactiveMode");
            if (!TextUtils.isEmpty(optString3) && f45644c.containsKey(optString3)) {
                f45644c.get(optString3).intValue();
            }
            jSONObject.optInt("fov", -1);
            jSONObject.optInt("minFov", -1);
            jSONObject.optInt("maxFov", -1);
            jSONObject.optBoolean("pinchEnable", true);
            return bVar;
        }
        return (b) invokeL.objValue;
    }
}
