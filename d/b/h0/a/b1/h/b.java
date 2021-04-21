package d.b.h0.a.b1.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f44279a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Integer> f44280b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f44281c;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        f44279a = hashMap;
        hashMap.put("VRModeProjectionSphere", 201);
        f44279a.put("VRModeProjectionDome180", 202);
        f44279a.put("VRModeProjectionDome230", 203);
        f44279a.put("VRModeProjectionDome180Upper", 204);
        f44279a.put("VRModeProjectionDome230Upper", 205);
        f44279a.put("VRModeProjectionPlaneFit", 207);
        f44279a.put("VRModeProjectionPlaneCrop", 208);
        f44279a.put("VRModeProjectionPlaneFull", 209);
        f44279a.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        f44279a.put("VRModeProjectionMultiFishEyeVertical", 211);
        f44279a.put("VRModeProjectionStereoSphereHorizontal", 212);
        f44279a.put("VRModeProjectionStereoSphereVertical", 213);
        f44279a.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        f44279a.put("VRModeProjectionStereoPlaneFitVertical", Integer.valueOf((int) JfifUtil.MARKER_RST7));
        f44279a.put("VRModeProjectionPlaneFullHorizontal", Integer.valueOf((int) JfifUtil.MARKER_SOI));
        f44279a.put("VRModeProjectionPlaneFullVertical", 217);
        HashMap<String, Integer> hashMap2 = new HashMap<>(2);
        f44280b = hashMap2;
        hashMap2.put("VRModeDisplayNormal", 101);
        f44280b.put("VRModeDisplayGlass", 102);
        HashMap<String, Integer> hashMap3 = new HashMap<>(5);
        f44281c = hashMap3;
        hashMap3.put("VRModeInteractiveMotion", 1);
        f44281c.put("VRModeInteractiveTouch", 2);
        f44281c.put("VRModeInteractiveMotionWithTouch", 3);
        f44281c.put("VRModeInteractiveGVRMotion", 4);
        f44281c.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b a(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && f44279a.containsKey(optString)) {
            f44279a.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && f44280b.containsKey(optString2)) {
            f44280b.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && f44281c.containsKey(optString3)) {
            f44281c.get(optString3).intValue();
        }
        jSONObject.optInt("fov", -1);
        jSONObject.optInt("minFov", -1);
        jSONObject.optInt("maxFov", -1);
        jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
