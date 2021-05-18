package d.a.i0.a.i1.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f42836a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Integer> f42837b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f42838c;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        f42836a = hashMap;
        hashMap.put("VRModeProjectionSphere", 201);
        f42836a.put("VRModeProjectionDome180", 202);
        f42836a.put("VRModeProjectionDome230", 203);
        f42836a.put("VRModeProjectionDome180Upper", 204);
        f42836a.put("VRModeProjectionDome230Upper", 205);
        f42836a.put("VRModeProjectionPlaneFit", 207);
        f42836a.put("VRModeProjectionPlaneCrop", 208);
        f42836a.put("VRModeProjectionPlaneFull", 209);
        f42836a.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        f42836a.put("VRModeProjectionMultiFishEyeVertical", 211);
        f42836a.put("VRModeProjectionStereoSphereHorizontal", 212);
        f42836a.put("VRModeProjectionStereoSphereVertical", 213);
        f42836a.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        f42836a.put("VRModeProjectionStereoPlaneFitVertical", Integer.valueOf((int) JfifUtil.MARKER_RST7));
        f42836a.put("VRModeProjectionPlaneFullHorizontal", Integer.valueOf((int) JfifUtil.MARKER_SOI));
        f42836a.put("VRModeProjectionPlaneFullVertical", 217);
        HashMap<String, Integer> hashMap2 = new HashMap<>(2);
        f42837b = hashMap2;
        hashMap2.put("VRModeDisplayNormal", 101);
        f42837b.put("VRModeDisplayGlass", 102);
        HashMap<String, Integer> hashMap3 = new HashMap<>(5);
        f42838c = hashMap3;
        hashMap3.put("VRModeInteractiveMotion", 1);
        f42838c.put("VRModeInteractiveTouch", 2);
        f42838c.put("VRModeInteractiveMotionWithTouch", 3);
        f42838c.put("VRModeInteractiveGVRMotion", 4);
        f42838c.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b a(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && f42836a.containsKey(optString)) {
            f42836a.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && f42837b.containsKey(optString2)) {
            f42837b.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && f42838c.containsKey(optString3)) {
            f42838c.get(optString3).intValue();
        }
        jSONObject.optInt("fov", -1);
        jSONObject.optInt("minFov", -1);
        jSONObject.optInt("maxFov", -1);
        jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
