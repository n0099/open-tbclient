package com.tachikoma.core.component.button;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.utility.TKColorUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
public class StyleHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_BACKGROUND_COLOR = "backgroundColor";
    public static final String KEY_ONDISABLE = "disabled";
    public static final String KEY_ONNORMAL = "normal";
    public static final String KEY_ONPRESS = "pressed";
    public static final String KEY_TEXT_COLOR = "color";
    public transient /* synthetic */ FieldHolder $fh;

    public StyleHelper() {
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

    public static GradientDrawable createGradientDrawable(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String obj = entry.getKey().toString();
                Object value = entry.getValue();
                if (value instanceof String) {
                    String str = (String) value;
                    if ("backgroundColor".equals(obj) && str.contains("#")) {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setColor(Color.parseColor(TKColorUtil.rgba2argb(str)));
                        return gradientDrawable;
                    }
                }
            }
            return null;
        }
        return (GradientDrawable) invokeL.objValue;
    }

    public static int fetchTextColor(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String obj = entry.getKey().toString();
                Object value = entry.getValue();
                if (value instanceof String) {
                    String str = (String) value;
                    if ("color".equals(obj) && str.contains("#")) {
                        return Color.parseColor(TKColorUtil.rgba2argb(str));
                    }
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static ColorStateList getTextColor(HashMap hashMap) {
        InterceptResult invokeL;
        int i;
        int fetchTextColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hashMap)) == null) {
            Iterator it = hashMap.entrySet().iterator();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String obj = entry.getKey().toString();
                Object value = entry.getValue();
                if (KEY_ONDISABLE.equals(obj) && (value instanceof HashMap)) {
                    fetchTextColor = fetchTextColor((HashMap) value);
                    arrayList.add(new int[]{-16842910});
                } else if (KEY_ONPRESS.equals(obj)) {
                    fetchTextColor = fetchTextColor((HashMap) value);
                    arrayList.add(new int[]{16842919});
                } else if ("normal".equals(obj)) {
                    fetchTextColor = fetchTextColor((HashMap) value);
                    arrayList.add(new int[]{16842910});
                }
                arrayList2.add(Integer.valueOf(fetchTextColor));
            }
            if (arrayList.size() > 0) {
                int[][] iArr = new int[arrayList.size()];
                int[] iArr2 = new int[arrayList2.size()];
                for (i = 0; i < arrayList2.size(); i++) {
                    iArr2[i] = ((Integer) arrayList2.get(i)).intValue();
                }
                return new ColorStateList((int[][]) arrayList.toArray(iArr), iArr2);
            }
            return null;
        }
        return (ColorStateList) invokeL.objValue;
    }
}
