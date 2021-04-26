package d.a.h0.a.b1.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f41563a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Integer> f41564b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f41565c;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        f41563a = hashMap;
        hashMap.put("VRModeProjectionSphere", 201);
        f41563a.put("VRModeProjectionDome180", 202);
        f41563a.put("VRModeProjectionDome230", 203);
        f41563a.put("VRModeProjectionDome180Upper", 204);
        f41563a.put("VRModeProjectionDome230Upper", 205);
        f41563a.put("VRModeProjectionPlaneFit", 207);
        f41563a.put("VRModeProjectionPlaneCrop", 208);
        f41563a.put("VRModeProjectionPlaneFull", 209);
        f41563a.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        f41563a.put("VRModeProjectionMultiFishEyeVertical", 211);
        f41563a.put("VRModeProjectionStereoSphereHorizontal", 212);
        f41563a.put("VRModeProjectionStereoSphereVertical", 213);
        f41563a.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        f41563a.put("VRModeProjectionStereoPlaneFitVertical", Integer.valueOf((int) JfifUtil.MARKER_RST7));
        f41563a.put("VRModeProjectionPlaneFullHorizontal", Integer.valueOf((int) JfifUtil.MARKER_SOI));
        f41563a.put("VRModeProjectionPlaneFullVertical", 217);
        HashMap<String, Integer> hashMap2 = new HashMap<>(2);
        f41564b = hashMap2;
        hashMap2.put("VRModeDisplayNormal", 101);
        f41564b.put("VRModeDisplayGlass", 102);
        HashMap<String, Integer> hashMap3 = new HashMap<>(5);
        f41565c = hashMap3;
        hashMap3.put("VRModeInteractiveMotion", 1);
        f41565c.put("VRModeInteractiveTouch", 2);
        f41565c.put("VRModeInteractiveMotionWithTouch", 3);
        f41565c.put("VRModeInteractiveGVRMotion", 4);
        f41565c.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b a(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && f41563a.containsKey(optString)) {
            f41563a.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && f41564b.containsKey(optString2)) {
            f41564b.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && f41565c.containsKey(optString3)) {
            f41565c.get(optString3).intValue();
        }
        jSONObject.optInt("fov", -1);
        jSONObject.optInt("minFov", -1);
        jSONObject.optInt("maxFov", -1);
        jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
