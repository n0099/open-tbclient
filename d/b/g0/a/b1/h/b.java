package d.b.g0.a.b1.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f43557a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Integer> f43558b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f43559c;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        f43557a = hashMap;
        hashMap.put("VRModeProjectionSphere", 201);
        f43557a.put("VRModeProjectionDome180", 202);
        f43557a.put("VRModeProjectionDome230", 203);
        f43557a.put("VRModeProjectionDome180Upper", 204);
        f43557a.put("VRModeProjectionDome230Upper", 205);
        f43557a.put("VRModeProjectionPlaneFit", 207);
        f43557a.put("VRModeProjectionPlaneCrop", 208);
        f43557a.put("VRModeProjectionPlaneFull", 209);
        f43557a.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        f43557a.put("VRModeProjectionMultiFishEyeVertical", 211);
        f43557a.put("VRModeProjectionStereoSphereHorizontal", 212);
        f43557a.put("VRModeProjectionStereoSphereVertical", 213);
        f43557a.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        f43557a.put("VRModeProjectionStereoPlaneFitVertical", Integer.valueOf((int) JfifUtil.MARKER_RST7));
        f43557a.put("VRModeProjectionPlaneFullHorizontal", Integer.valueOf((int) JfifUtil.MARKER_SOI));
        f43557a.put("VRModeProjectionPlaneFullVertical", 217);
        HashMap<String, Integer> hashMap2 = new HashMap<>(2);
        f43558b = hashMap2;
        hashMap2.put("VRModeDisplayNormal", 101);
        f43558b.put("VRModeDisplayGlass", 102);
        HashMap<String, Integer> hashMap3 = new HashMap<>(5);
        f43559c = hashMap3;
        hashMap3.put("VRModeInteractiveMotion", 1);
        f43559c.put("VRModeInteractiveTouch", 2);
        f43559c.put("VRModeInteractiveMotionWithTouch", 3);
        f43559c.put("VRModeInteractiveGVRMotion", 4);
        f43559c.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b a(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && f43557a.containsKey(optString)) {
            f43557a.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && f43558b.containsKey(optString2)) {
            f43558b.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && f43559c.containsKey(optString3)) {
            f43559c.get(optString3).intValue();
        }
        jSONObject.optInt("fov", -1);
        jSONObject.optInt("minFov", -1);
        jSONObject.optInt("maxFov", -1);
        jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
