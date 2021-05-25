package d.a.l0.a.i1.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f43010a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Integer> f43011b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f43012c;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        f43010a = hashMap;
        hashMap.put("VRModeProjectionSphere", 201);
        f43010a.put("VRModeProjectionDome180", 202);
        f43010a.put("VRModeProjectionDome230", 203);
        f43010a.put("VRModeProjectionDome180Upper", 204);
        f43010a.put("VRModeProjectionDome230Upper", 205);
        f43010a.put("VRModeProjectionPlaneFit", 207);
        f43010a.put("VRModeProjectionPlaneCrop", 208);
        f43010a.put("VRModeProjectionPlaneFull", 209);
        f43010a.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        f43010a.put("VRModeProjectionMultiFishEyeVertical", 211);
        f43010a.put("VRModeProjectionStereoSphereHorizontal", 212);
        f43010a.put("VRModeProjectionStereoSphereVertical", 213);
        f43010a.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        f43010a.put("VRModeProjectionStereoPlaneFitVertical", Integer.valueOf((int) JfifUtil.MARKER_RST7));
        f43010a.put("VRModeProjectionPlaneFullHorizontal", Integer.valueOf((int) JfifUtil.MARKER_SOI));
        f43010a.put("VRModeProjectionPlaneFullVertical", 217);
        HashMap<String, Integer> hashMap2 = new HashMap<>(2);
        f43011b = hashMap2;
        hashMap2.put("VRModeDisplayNormal", 101);
        f43011b.put("VRModeDisplayGlass", 102);
        HashMap<String, Integer> hashMap3 = new HashMap<>(5);
        f43012c = hashMap3;
        hashMap3.put("VRModeInteractiveMotion", 1);
        f43012c.put("VRModeInteractiveTouch", 2);
        f43012c.put("VRModeInteractiveMotionWithTouch", 3);
        f43012c.put("VRModeInteractiveGVRMotion", 4);
        f43012c.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b a(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && f43010a.containsKey(optString)) {
            f43010a.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && f43011b.containsKey(optString2)) {
            f43011b.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && f43012c.containsKey(optString3)) {
            f43012c.get(optString3).intValue();
        }
        jSONObject.optInt("fov", -1);
        jSONObject.optInt("minFov", -1);
        jSONObject.optInt("maxFov", -1);
        jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
