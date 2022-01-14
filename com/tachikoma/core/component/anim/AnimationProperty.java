package com.tachikoma.core.component.anim;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AnimationProperty {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String BOUNDS = "bounds";
    public static final String HEIGHT = "height";
    public static final String LEFT = "left";
    public static final String MARGIN = "margin";
    public static final String MARGIN_BOTTOM = "marginBottom";
    public static final String MARGIN_LEFT = "marginLeft";
    public static final String MARGIN_RIGHT = "marginRight";
    public static final String MARGIN_TOP = "marginTop";
    public static final String OPACITY = "alpha";
    public static final String POSITION = "position";
    public static final String ROTATE = "rotate";
    public static final String ROTATE_X = "rotationX";
    public static final String ROTATE_Y = "rotationY";
    public static final String ROTATE_Z = "rotation";
    public static final String ROTATION = "rotation";
    public static final String SCALE = "scale";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String SHADOW_COLOR = "shadowColor";
    public static final String SHADOW_OFFSET = "shadowOffset";
    public static final String SHADOW_OPACITY = "shadowOpacity";
    public static final String SHADOW_RADIUS = "shadowRadius";
    public static final String TOP = "top";
    public static final String TRANSFORM = "transform";
    public static final String TRANSLATE = "translate";
    public static final String TRANSLATE_X = "translationX";
    public static final String TRANSLATE_Y = "translationY";
    public static final String TRANSLATE_Z = "translationZ";
    public static final String WIDTH = "width";
    public transient /* synthetic */ FieldHolder $fh;

    public AnimationProperty() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static List<String> getAnimationPropertyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(TRANSLATE_X);
            arrayList.add(TRANSLATE_Y);
            arrayList.add(TRANSLATE_Z);
            arrayList.add(SCALE_X);
            arrayList.add(SCALE_Y);
            arrayList.add(ROTATE_X);
            arrayList.add(ROTATE_Y);
            arrayList.add("rotation");
            arrayList.add("position");
            arrayList.add("width");
            arrayList.add("height");
            arrayList.add("left");
            arrayList.add("top");
            arrayList.add(MARGIN);
            arrayList.add(MARGIN_LEFT);
            arrayList.add(MARGIN_RIGHT);
            arrayList.add(MARGIN_TOP);
            arrayList.add(MARGIN_BOTTOM);
            arrayList.add(BOUNDS);
            arrayList.add(OPACITY);
            arrayList.add("backgroundColor");
            arrayList.add(SHADOW_COLOR);
            arrayList.add(SHADOW_RADIUS);
            arrayList.add(SHADOW_OPACITY);
            arrayList.add(SHADOW_OFFSET);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
