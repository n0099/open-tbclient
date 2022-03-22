package com.tachikoma.core.component.anim;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class TKSpringAnimation extends TKBasicAnimation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float damping;
    public float stiffness;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKSpringAnimation(Context context, @Nullable List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.stiffness = 380.0f;
        this.damping = 20.0f;
    }

    private float calculateDampingRatio(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (float) (f2 / (Math.sqrt(f3) * 2.0d)) : invokeCommon.floatValue;
    }

    private void createAndStartAnimation(View view, FloatPropertyCompat<View> floatPropertyCompat, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{view, floatPropertyCompat, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            SpringAnimation springAnimation = new SpringAnimation(view, floatPropertyCompat, f2);
            springAnimation.getSpring().setStiffness(f4);
            springAnimation.getSpring().setDampingRatio(f3);
            springAnimation.start();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.tachikoma.core.component.anim.TKSpringAnimation */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a4, code lost:
        if (r3.equals(com.tachikoma.core.component.anim.AnimationProperty.TRANSLATE_Y) != false) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void startAnimationNew(TKBase tKBase) {
        FloatPropertyCompat floatPropertyCompat;
        FloatPropertyCompat floatPropertyCompat2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, tKBase) == null) {
            HashMap<Float, Map<String, Object>> animationPropertySnapshot = tKBase.getAnimationPropertySnapshot();
            if (animationPropertySnapshot.isEmpty()) {
                return;
            }
            List<String> animationPropertyList = AnimationProperty.getAnimationPropertyList();
            Map<String, HashMap<Float, Object>> diffAnimationProperty = diffAnimationProperty(animationPropertyList, animationPropertySnapshot);
            if (diffAnimationProperty.isEmpty()) {
                return;
            }
            float calculateDampingRatio = calculateDampingRatio(this.damping, this.stiffness);
            View view = tKBase.getView();
            Iterator<String> it = animationPropertyList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                HashMap<Float, Object> hashMap = diffAnimationProperty.get(next);
                if (hashMap != null) {
                    char c2 = 1;
                    if (1 < hashMap.size()) {
                        Object obj = hashMap.get(Float.valueOf(0.0f));
                        Object obj2 = hashMap.get(Float.valueOf(1.0f));
                        if ((obj2 instanceof Number) && (obj instanceof Number)) {
                            float floatValue = ((Number) obj).floatValue();
                            switch (next.hashCode()) {
                                case -1249320806:
                                    if (next.equals(AnimationProperty.ROTATE_X)) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1249320805:
                                    if (next.equals(AnimationProperty.ROTATE_Y)) {
                                        c2 = 5;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1225497657:
                                    if (next.equals(AnimationProperty.TRANSLATE_X)) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1225497656:
                                    break;
                                case -908189618:
                                    if (next.equals(AnimationProperty.SCALE_X)) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -908189617:
                                    if (next.equals(AnimationProperty.SCALE_Y)) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -40300674:
                                    if (next.equals("rotation")) {
                                        c2 = 6;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 92909918:
                                    if (next.equals(AnimationProperty.OPACITY)) {
                                        c2 = 7;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    view.setTranslationX(floatValue);
                                    floatPropertyCompat = DynamicAnimation.TRANSLATION_X;
                                    floatPropertyCompat2 = floatPropertyCompat;
                                    break;
                                case 1:
                                    view.setTranslationY(floatValue);
                                    floatPropertyCompat = DynamicAnimation.TRANSLATION_Y;
                                    floatPropertyCompat2 = floatPropertyCompat;
                                    break;
                                case 2:
                                    view.setScaleX(floatValue);
                                    floatPropertyCompat = DynamicAnimation.SCALE_X;
                                    floatPropertyCompat2 = floatPropertyCompat;
                                    break;
                                case 3:
                                    view.setScaleY(floatValue);
                                    floatPropertyCompat = DynamicAnimation.SCALE_Y;
                                    floatPropertyCompat2 = floatPropertyCompat;
                                    break;
                                case 4:
                                    view.setRotationX(floatValue);
                                    floatPropertyCompat = DynamicAnimation.ROTATION_X;
                                    floatPropertyCompat2 = floatPropertyCompat;
                                    break;
                                case 5:
                                    view.setRotationY(floatValue);
                                    floatPropertyCompat = DynamicAnimation.ROTATION_Y;
                                    floatPropertyCompat2 = floatPropertyCompat;
                                    break;
                                case 6:
                                    view.setRotation(floatValue);
                                    floatPropertyCompat = DynamicAnimation.ROTATION;
                                    floatPropertyCompat2 = floatPropertyCompat;
                                    break;
                                case 7:
                                    view.setAlpha(floatValue);
                                    floatPropertyCompat = DynamicAnimation.ALPHA;
                                    floatPropertyCompat2 = floatPropertyCompat;
                                    break;
                                default:
                                    Logger.logE("startAnimation", new Exception("unknown property"));
                                    floatPropertyCompat2 = null;
                                    break;
                            }
                            if (floatPropertyCompat2 != null) {
                                createAndStartAnimation(view, floatPropertyCompat2, ((Number) obj2).floatValue(), calculateDampingRatio, this.stiffness);
                            }
                        }
                    }
                }
            }
        }
    }

    private void startAnimationOld(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view) == null) || this.animValue == null) {
            return;
        }
        float calculateDampingRatio = calculateDampingRatio(this.damping, this.stiffness);
        startPositionAnim(view, calculateDampingRatio, this.stiffness);
        startScaleAnim(view, calculateDampingRatio, this.stiffness);
    }

    private void startPositionAnim(View view, float f2, float f3) {
        String[] trans2StringArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) && ((Map) this.animValue).containsKey("position") && (trans2StringArray = trans2StringArray(((Map) this.animValue).get("position"))) != null && trans2StringArray.length == 2) {
            float[] fArr = {0.0f, 0.0f};
            fArr[0] = parsePxValue(trans2StringArray[0]);
            fArr[1] = parsePxValue(trans2StringArray[1]);
            createAndStartAnimation(view, DynamicAnimation.TRANSLATION_X, fArr[0], f2, f3);
            createAndStartAnimation(view, DynamicAnimation.TRANSLATION_Y, fArr[1], f2, f3);
        }
    }

    private void startScaleAnim(View view, float f2, float f3) {
        String[] trans2StringArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) && ((Map) this.animValue).containsKey(AnimationProperty.SCALE) && (trans2StringArray = trans2StringArray(((Map) this.animValue).get(AnimationProperty.SCALE))) != null && trans2StringArray.length == 2) {
            float[] fArr = {0.0f, 0.0f};
            fArr[0] = parseFloatValue(trans2StringArray[0]);
            fArr[1] = parseFloatValue(trans2StringArray[1]);
            createAndStartAnimation(view, DynamicAnimation.SCALE_X, fArr[0], f2, f3);
            createAndStartAnimation(view, DynamicAnimation.SCALE_Y, fArr[1], f2, f3);
        }
    }

    public void setDamping(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.damping = f2;
        }
    }

    public void setStiffness(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.stiffness = f2;
        }
    }

    @Override // com.tachikoma.core.component.anim.TKBasicAnimation
    public void start(TKBase tKBase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tKBase) == null) {
            if (newVersionEnable()) {
                startAnimationNew(tKBase);
            } else {
                startAnimationOld(tKBase.getView());
            }
        }
    }
}
