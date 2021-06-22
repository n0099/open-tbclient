package d.a.m0.a.i1.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f46794a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Integer> f46795b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f46796c;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        f46794a = hashMap;
        hashMap.put("VRModeProjectionSphere", 201);
        f46794a.put("VRModeProjectionDome180", 202);
        f46794a.put("VRModeProjectionDome230", 203);
        f46794a.put("VRModeProjectionDome180Upper", 204);
        f46794a.put("VRModeProjectionDome230Upper", 205);
        f46794a.put("VRModeProjectionPlaneFit", 207);
        f46794a.put("VRModeProjectionPlaneCrop", 208);
        f46794a.put("VRModeProjectionPlaneFull", 209);
        f46794a.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        f46794a.put("VRModeProjectionMultiFishEyeVertical", 211);
        f46794a.put("VRModeProjectionStereoSphereHorizontal", 212);
        f46794a.put("VRModeProjectionStereoSphereVertical", 213);
        f46794a.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        f46794a.put("VRModeProjectionStereoPlaneFitVertical", Integer.valueOf((int) JfifUtil.MARKER_RST7));
        f46794a.put("VRModeProjectionPlaneFullHorizontal", Integer.valueOf((int) JfifUtil.MARKER_SOI));
        f46794a.put("VRModeProjectionPlaneFullVertical", 217);
        HashMap<String, Integer> hashMap2 = new HashMap<>(2);
        f46795b = hashMap2;
        hashMap2.put("VRModeDisplayNormal", 101);
        f46795b.put("VRModeDisplayGlass", 102);
        HashMap<String, Integer> hashMap3 = new HashMap<>(5);
        f46796c = hashMap3;
        hashMap3.put("VRModeInteractiveMotion", 1);
        f46796c.put("VRModeInteractiveTouch", 2);
        f46796c.put("VRModeInteractiveMotionWithTouch", 3);
        f46796c.put("VRModeInteractiveGVRMotion", 4);
        f46796c.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b a(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && f46794a.containsKey(optString)) {
            f46794a.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && f46795b.containsKey(optString2)) {
            f46795b.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && f46796c.containsKey(optString3)) {
            f46796c.get(optString3).intValue();
        }
        jSONObject.optInt("fov", -1);
        jSONObject.optInt("minFov", -1);
        jSONObject.optInt("maxFov", -1);
        jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
