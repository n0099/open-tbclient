package com.facebook.fresco.middleware;

import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.fresco.ui.common.ControllerListener2;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class MiddlewareUtils {
    public static ControllerListener2.Extras obtainExtras(Map<String, Object> map, Map<String, Object> map2, @Nullable Map<String, Object> map3, @Nullable Rect rect, @Nullable String str, @Nullable PointF pointF, @Nullable Map<String, Object> map4, @Nullable Object obj, @Nullable Uri uri) {
        ControllerListener2.Extras extras = new ControllerListener2.Extras();
        HashMap hashMap = new HashMap();
        extras.f1068view = hashMap;
        hashMap.putAll(map);
        if (rect != null) {
            extras.f1068view.put("viewport_width", Integer.valueOf(rect.width()));
            extras.f1068view.put("viewport_height", Integer.valueOf(rect.height()));
        } else {
            extras.f1068view.put("viewport_width", -1);
            extras.f1068view.put("viewport_height", -1);
        }
        extras.f1068view.put("scale_type", str);
        if (pointF != null) {
            extras.f1068view.put("focus_point_x", Float.valueOf(pointF.x));
            extras.f1068view.put("focus_point_y", Float.valueOf(pointF.y));
        }
        extras.f1068view.put("caller_context", obj);
        if (uri != null) {
            extras.f1068view.put("uri_main", uri);
        }
        if (map3 != null) {
            extras.pipe = map3;
            if (map4 != null) {
                map3.putAll(map4);
            }
        } else {
            extras.pipe = map4;
            extras.f1068view.putAll(map2);
        }
        return extras;
    }
}
