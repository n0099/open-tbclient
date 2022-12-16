package com.facebook.fresco.middleware;

import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.fresco.ui.common.ControllerListener2;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class MiddlewareUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MiddlewareUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ControllerListener2.Extras obtainExtras(Map<String, Object> map, Map<String, Object> map2, @Nullable Map<String, Object> map3, @Nullable Rect rect, @Nullable String str, @Nullable PointF pointF, @Nullable Map<String, Object> map4, @Nullable Object obj, @Nullable Uri uri) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{map, map2, map3, rect, str, pointF, map4, obj, uri})) == null) {
            ControllerListener2.Extras extras = new ControllerListener2.Extras();
            HashMap hashMap = new HashMap();
            extras.f1094view = hashMap;
            hashMap.putAll(map);
            if (rect != null) {
                extras.f1094view.put("viewport_width", Integer.valueOf(rect.width()));
                extras.f1094view.put("viewport_height", Integer.valueOf(rect.height()));
            } else {
                extras.f1094view.put("viewport_width", -1);
                extras.f1094view.put("viewport_height", -1);
            }
            extras.f1094view.put("scale_type", str);
            if (pointF != null) {
                extras.f1094view.put("focus_point_x", Float.valueOf(pointF.x));
                extras.f1094view.put("focus_point_y", Float.valueOf(pointF.y));
            }
            extras.f1094view.put("caller_context", obj);
            if (uri != null) {
                extras.f1094view.put("uri_main", uri);
            }
            if (map3 != null) {
                extras.pipe = map3;
                if (map4 != null) {
                    map3.putAll(map4);
                }
            } else {
                extras.pipe = map4;
                extras.f1094view.putAll(map2);
            }
            return extras;
        }
        return (ControllerListener2.Extras) invokeCommon.objValue;
    }
}
