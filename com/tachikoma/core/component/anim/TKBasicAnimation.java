package com.tachikoma.core.component.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.kwad.yoga.YogaValue;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.Tachikoma;
import com.tachikoma.core.V8FunctionImpl;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.anim.TimeFunctionConst;
import com.tachikoma.core.component.anim.interpolator.CubicBezierInterpolator;
import com.tachikoma.core.component.view.TKViewBackgroundDrawable;
import com.tachikoma.core.exception.TKExceptionDispatcher;
import com.tachikoma.core.log.Logger;
import com.tachikoma.core.utility.TKConverter;
import com.tachikoma.core.utility.UIThreadUtil;
import com.tachikoma.core.utility.V8Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class TKBasicAnimation {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AXIS_X = 1;
    public static final int AXIS_Y = 2;
    public static final int AXIS_Z = 3;
    public static final int DIRECTION_X = 11;
    public static final int DIRECTION_XY = 13;
    public static final int DIRECTION_Y = 12;
    public transient /* synthetic */ FieldHolder $fh;
    public V8Function animNJEndListener;
    public V8Function animNJStartListener;
    public String animType;
    public Object animValue;
    public V8Array animationV8Array;
    public Animator animator;
    public AnimatorListenerAdapter animatorListener;
    public Runnable animatorOnStartForDelay;
    public boolean autoReverse;
    public float delay;
    public float duration;
    public V8FunctionImpl endValue;
    public float mInitialAlpha;
    public float mInitialRotationX;
    public float mInitialRotationY;
    public float mInitialScaleX;
    public float mInitialScaleY;
    public float mInitialTranslationX;
    public float mInitialTranslationY;
    public View mTargetView;
    public boolean needTranformIdentity;
    public int repeatCount;
    public V8FunctionImpl startValue;
    public String timeFunction;
    public String timingFunction;

    /* loaded from: classes7.dex */
    public interface AnimationJsCallback {
        void onJsExecuteComplete(double d);
    }

    public TKBasicAnimation(Context context, @Nullable List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInitialScaleX = 1.0f;
        this.mInitialScaleY = 1.0f;
        this.mInitialTranslationX = 0.0f;
        this.mInitialTranslationY = 0.0f;
        this.mInitialRotationX = 0.0f;
        this.mInitialRotationY = 0.0f;
        this.mInitialAlpha = 1.0f;
        this.animatorOnStartForDelay = new Runnable(this) { // from class: com.tachikoma.core.component.anim.TKBasicAnimation.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TKBasicAnimation this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    V8Function v8Function = this.this$0.animNJStartListener;
                    if (v8Function != null && !v8Function.isReleased()) {
                        try {
                            this.this$0.animNJStartListener.call(null, null);
                        } catch (Throwable th) {
                            TKExceptionDispatcher.reportException(null, th);
                        }
                        V8Proxy.release(this.this$0.animNJStartListener);
                    }
                    this.this$0.readInitial();
                }
            }
        };
        this.animatorListener = new AnimatorListenerAdapter(this) { // from class: com.tachikoma.core.component.anim.TKBasicAnimation.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TKBasicAnimation this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    V8Function v8Function = this.this$0.animNJEndListener;
                    if (v8Function != null && !v8Function.isReleased()) {
                        try {
                            this.this$0.animNJEndListener.call(null, null);
                            V8Proxy.release(this.this$0.animNJEndListener);
                        } catch (Throwable th) {
                            TKExceptionDispatcher.reportException(null, th);
                        }
                    }
                    this.this$0.resetInitial();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    super.onAnimationStart(animator);
                    TKBasicAnimation tKBasicAnimation = this.this$0;
                    UIThreadUtil.postDelay(tKBasicAnimation.animatorOnStartForDelay, tKBasicAnimation.getAnimDelay());
                }
            }
        };
    }

    private boolean animationEnable(HashMap<Float, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, hashMap)) == null) {
            if (hashMap != null && !hashMap.isEmpty() && hashMap.size() != 1) {
                Iterator<Map.Entry<Float, Object>> it = hashMap.entrySet().iterator();
                Map.Entry<Float, Object> next = it.hasNext() ? it.next() : null;
                if (next == null) {
                    return false;
                }
                while (it.hasNext()) {
                    Map.Entry<Float, Object> next2 = it.next();
                    if (!isAnimationPropertyEquals(next.getValue(), next2.getValue())) {
                        return true;
                    }
                    next = next2;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private ObjectAnimator buildColorKeyFrameAnimator(TKBase tKBase, String str, Map<Float, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, tKBase, str, map)) == null) {
            if (tKBase != null && tKBase.getView() != null && map != null) {
                if (1 < map.size()) {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<Float, Object> entry : map.entrySet()) {
                        if (entry != null && entry.getValue() != null) {
                            Object value = entry.getValue();
                            if (value instanceof Integer) {
                                arrayList.add(Keyframe.ofInt(entry.getKey().floatValue(), ((Integer) value).intValue()));
                            }
                        }
                    }
                    if (arrayList.size() <= 0) {
                        return null;
                    }
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tKBase.getView(), PropertyValuesHolder.ofKeyframe(String.format("_%s_", str), (Keyframe[]) arrayList.toArray(new Keyframe[0])));
                    ofPropertyValuesHolder.setEvaluator(new ArgbEvaluator());
                    ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
                    ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
                    ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, tKBase) { // from class: com.tachikoma.core.component.anim.TKBasicAnimation.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TKBasicAnimation this$0;
                        public final /* synthetic */ TKBase val$tkBase;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, tKBase};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$tkBase = tKBase;
                        }

                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) && (valueAnimator.getAnimatedValue() instanceof Integer) && this.val$tkBase.getView() != null) {
                                this.val$tkBase.setBackgroundColorInt(((Integer) valueAnimator.getAnimatedValue()).intValue());
                            }
                        }
                    });
                    return ofPropertyValuesHolder;
                }
            }
            return null;
        }
        return (ObjectAnimator) invokeLLL.objValue;
    }

    private ObjectAnimator buildKeyFrameAnimator(View view2, String str, Map<Float, Object> map) {
        InterceptResult invokeLLL;
        float floatValue;
        float floatValue2;
        Keyframe ofFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, view2, str, map)) == null) {
            if (map != null) {
                if (1 < map.size()) {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<Float, Object> entry : map.entrySet()) {
                        if (entry != null && entry.getValue() != null) {
                            Object value = entry.getValue();
                            if (value instanceof Float) {
                                floatValue = entry.getKey().floatValue();
                                floatValue2 = ((Float) value).floatValue();
                            } else if (value instanceof YogaValue) {
                                floatValue = entry.getKey().floatValue();
                                floatValue2 = ((YogaValue) value).value;
                            } else if (value instanceof Integer) {
                                ofFloat = Keyframe.ofInt(entry.getKey().floatValue(), ((Integer) value).intValue());
                                arrayList.add(ofFloat);
                            }
                            ofFloat = Keyframe.ofFloat(floatValue, floatValue2);
                            arrayList.add(ofFloat);
                        }
                    }
                    if (arrayList.size() <= 0) {
                        return null;
                    }
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofKeyframe(str, (Keyframe[]) arrayList.toArray(new Keyframe[0])));
                    ofPropertyValuesHolder.setDuration(getAnimDuration());
                    ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
                    ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
                    return ofPropertyValuesHolder;
                }
            }
            return null;
        }
        return (ObjectAnimator) invokeLLL.objValue;
    }

    private boolean isAnimationPropertyEquals(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, obj, obj2)) == null) {
            if (obj == null && obj2 == null) {
                return true;
            }
            return ((obj instanceof Float) && (obj2 instanceof Float)) ? Float.compare(((Float) obj).floatValue(), ((Float) obj2).floatValue()) == 0 : ((obj instanceof Integer) && (obj2 instanceof Integer)) ? ((Integer) obj).intValue() == ((Integer) obj2).intValue() : (obj instanceof YogaValue) && (obj2 instanceof YogaValue) && Float.compare(((YogaValue) obj).value, ((YogaValue) obj2).value) == 0;
        }
        return invokeLL.booleanValue;
    }

    private void pauseAnimation(AnimatorSet animatorSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, animatorSet) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                pauseAnimation19(animatorSet);
            } else {
                pauseAnimation18(animatorSet);
            }
        }
    }

    @TargetApi(18)
    private void pauseAnimation18(AnimatorSet animatorSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, animatorSet) == null) {
            animatorSet.cancel();
        }
    }

    @TargetApi(19)
    private void pauseAnimation19(AnimatorSet animatorSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, animatorSet) == null) {
            animatorSet.pause();
        }
    }

    private void resumeAnimation(AnimatorSet animatorSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, animatorSet) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                resumeAnimation19(animatorSet);
            } else {
                resumeAnimation18(animatorSet);
            }
        }
    }

    @TargetApi(18)
    private void resumeAnimation18(AnimatorSet animatorSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, animatorSet) == null) {
            animatorSet.start();
        }
    }

    @TargetApi(19)
    private void resumeAnimation19(AnimatorSet animatorSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, animatorSet) == null) {
            animatorSet.resume();
        }
    }

    private ObjectAnimator setAlphaAnim(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, view2)) == null) {
            if (((Map) this.animValue).containsKey(NativeConstants.OPACITY)) {
                float alpha = view2.getAlpha();
                float parseFloatValue = parseFloatValue(trans2String(((Map) this.animValue).get(NativeConstants.OPACITY)));
                if (alpha != parseFloatValue) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.OPACITY, alpha, parseFloatValue);
                    ofFloat.setDuration(getAnimDuration());
                    ofFloat.setRepeatCount(this.repeatCount);
                    ofFloat.setRepeatMode(this.autoReverse ? 2 : 1);
                    return ofFloat;
                }
                return null;
            }
            return null;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    private ObjectAnimator setBackgroundColorAnim(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, view2)) == null) {
            if (((Map) this.animValue).containsKey("backgroundColor")) {
                Object obj = ((Map) this.animValue).get("backgroundColor");
                TKViewBackgroundDrawable tKViewBackgroundDrawable = (TKViewBackgroundDrawable) view2.getBackground();
                int color = tKViewBackgroundDrawable.getColor();
                int parseColor = parseColor(trans2String(obj));
                if (color != parseColor) {
                    ObjectAnimator ofInt = ObjectAnimator.ofInt(tKViewBackgroundDrawable, "color", color, parseColor);
                    ofInt.setDuration(getAnimDuration());
                    ofInt.setEvaluator(new ArgbEvaluator());
                    ofInt.setRepeatCount(this.repeatCount);
                    ofInt.setRepeatMode(this.autoReverse ? 2 : 1);
                    return ofInt;
                }
                return null;
            }
            return null;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    private ObjectAnimator setPositionAnim(View view2) {
        InterceptResult invokeL;
        String[] trans2StringArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, view2)) == null) {
            if (!((Map) this.animValue).containsKey("position") || (trans2StringArray = trans2StringArray(((Map) this.animValue).get("position"))) == null) {
                return null;
            }
            if (trans2StringArray.length == 2) {
                float[] fArr = {0.0f, 0.0f};
                fArr[0] = parsePxValue(trans2StringArray[0]);
                fArr[1] = parsePxValue(trans2StringArray[1]);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_X, fArr[0]), PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_Y, fArr[1]));
                ofPropertyValuesHolder.setDuration(getAnimDuration());
                ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
                ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
                return ofPropertyValuesHolder;
            }
            return null;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    private ObjectAnimator setRotationAnim(View view2) {
        InterceptResult invokeL;
        String[] trans2StringArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, view2)) == null) {
            if (!((Map) this.animValue).containsKey("rotation") || (trans2StringArray = trans2StringArray(((Map) this.animValue).get("rotation"))) == null) {
                return null;
            }
            if (trans2StringArray.length == 2) {
                float[] fArr = {0.0f, 0.0f};
                fArr[0] = parseFloatValue(trans2StringArray[0]);
                fArr[1] = parseFloatValue(trans2StringArray[1]);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(AnimationProperty.ROTATE_X, fArr[0]), PropertyValuesHolder.ofFloat(AnimationProperty.ROTATE_Y, fArr[1]));
                ofPropertyValuesHolder.setDuration(getAnimDuration());
                ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
                ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
                return ofPropertyValuesHolder;
            }
            return null;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    private ObjectAnimator setScaleAnim(View view2) {
        InterceptResult invokeL;
        String[] trans2StringArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, view2)) == null) {
            if (!((Map) this.animValue).containsKey(AnimationProperty.SCALE) || (trans2StringArray = trans2StringArray(((Map) this.animValue).get(AnimationProperty.SCALE))) == null) {
                return null;
            }
            if (trans2StringArray.length == 2) {
                float[] fArr = {0.0f, 0.0f};
                fArr[0] = parseFloatValue(trans2StringArray[0]);
                fArr[1] = parseFloatValue(trans2StringArray[1]);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, fArr[0]), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, fArr[1]));
                ofPropertyValuesHolder.setDuration(getAnimDuration());
                ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
                ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
                return ofPropertyValuesHolder;
            }
            return null;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: com.tachikoma.core.component.anim.TKBasicAnimation */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private void startAnimation(TKBase tKBase) {
        char c;
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, tKBase) == null) {
            List<String> animationPropertyList = AnimationProperty.getAnimationPropertyList();
            Map<String, HashMap<Float, Object>> diffAnimationProperty = diffAnimationProperty(animationPropertyList, tKBase.getAnimationPropertySnapshot());
            if (diffAnimationProperty.isEmpty()) {
                return;
            }
            View view2 = tKBase.getView();
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = animationPropertyList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                HashMap<Float, Object> hashMap = diffAnimationProperty.get(next);
                if (hashMap != null && 1 < hashMap.size()) {
                    Iterator<String> it2 = it;
                    Map<String, HashMap<Float, Object>> map = diffAnimationProperty;
                    ArrayList arrayList2 = arrayList;
                    switch (next.hashCode()) {
                        case -1702268461:
                            if (next.equals(AnimationProperty.SHADOW_OFFSET)) {
                                c = 20;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1621067310:
                            if (next.equals(AnimationProperty.SHADOW_RADIUS)) {
                                c = 18;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1589741021:
                            if (next.equals(AnimationProperty.SHADOW_COLOR)) {
                                c = 17;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1249320806:
                            if (next.equals(AnimationProperty.ROTATE_X)) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1249320805:
                            if (next.equals(AnimationProperty.ROTATE_Y)) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497657:
                            if (next.equals(AnimationProperty.TRANSLATE_X)) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497656:
                            if (next.equals(AnimationProperty.TRANSLATE_Y)) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497655:
                            if (next.equals(AnimationProperty.TRANSLATE_Z)) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1221029593:
                            if (next.equals("height")) {
                                c = 15;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1081309778:
                            if (next.equals("margin")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1044792121:
                            if (next.equals(AnimationProperty.MARGIN_TOP)) {
                                c = '\f';
                                break;
                            }
                            c = 65535;
                            break;
                        case -949513525:
                            if (next.equals(AnimationProperty.SHADOW_OPACITY)) {
                                c = 19;
                                break;
                            }
                            c = 65535;
                            break;
                        case -908189618:
                            if (next.equals(AnimationProperty.SCALE_X)) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -908189617:
                            if (next.equals(AnimationProperty.SCALE_Y)) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -289173127:
                            if (next.equals(AnimationProperty.MARGIN_BOTTOM)) {
                                c = '\r';
                                break;
                            }
                            c = 65535;
                            break;
                        case -40300674:
                            if (next.equals("rotation")) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 92909918:
                            if (next.equals(AnimationProperty.OPACITY)) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case 113126854:
                            if (next.equals("width")) {
                                c = 14;
                                break;
                            }
                            c = 65535;
                            break;
                        case 975087886:
                            if (next.equals(AnimationProperty.MARGIN_RIGHT)) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1287124693:
                            if (next.equals("backgroundColor")) {
                                c = 16;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1970934485:
                            if (next.equals(AnimationProperty.MARGIN_LEFT)) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            objectAnimator = buildKeyFrameAnimator(view2, AnimationProperty.TRANSLATE_X, hashMap);
                            break;
                        case 1:
                            objectAnimator = buildKeyFrameAnimator(view2, AnimationProperty.TRANSLATE_Y, hashMap);
                            break;
                        case 2:
                            objectAnimator = buildKeyFrameAnimator(view2, AnimationProperty.TRANSLATE_Z, hashMap);
                            break;
                        case 3:
                            objectAnimator = buildKeyFrameAnimator(view2, AnimationProperty.SCALE_X, hashMap);
                            break;
                        case 4:
                            objectAnimator = buildKeyFrameAnimator(view2, AnimationProperty.SCALE_Y, hashMap);
                            break;
                        case 5:
                            objectAnimator = buildKeyFrameAnimator(view2, AnimationProperty.ROTATE_X, hashMap);
                            break;
                        case 6:
                            objectAnimator = buildKeyFrameAnimator(view2, AnimationProperty.ROTATE_Y, hashMap);
                            break;
                        case 7:
                            objectAnimator = buildKeyFrameAnimator(view2, "rotation", hashMap);
                            break;
                        case '\b':
                            objectAnimator = buildKeyFrameAnimator(view2, AnimationProperty.OPACITY, hashMap);
                            break;
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                        case 14:
                        case 15:
                            objectAnimator = buildKeyFrameAnimator(view2, next, hashMap);
                            updateAnimateLayoutParams(objectAnimator, tKBase, next);
                            break;
                        case 16:
                            objectAnimator = buildColorKeyFrameAnimator(tKBase, "backgroundColor", hashMap);
                            break;
                        default:
                            Logger.logE("", new Exception("unknown animation property!!!"));
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                            objectAnimator = null;
                            break;
                    }
                    if (objectAnimator != null) {
                        arrayList2.add(objectAnimator);
                    }
                    arrayList = arrayList2;
                    it = it2;
                    diffAnimationProperty = map;
                }
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(getAnimDuration());
            animatorSet.playTogether(arrayList);
            animatorSet.setStartDelay(getAnimDelay());
            animatorSet.setInterpolator(getInterpolator());
            animatorSet.addListener(this.animatorListener);
            animatorSet.start();
            view2.setTag(R.id.obfuscated_res_0x7f0920bf, animatorSet);
        }
    }

    private void startBasicAnimation(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, this, view2) == null) && (this.animValue instanceof Map)) {
            ObjectAnimator positionAnim = setPositionAnim(view2);
            ObjectAnimator scaleAnim = setScaleAnim(view2);
            ObjectAnimator rotationAnim = setRotationAnim(view2);
            ObjectAnimator alphaAnim = setAlphaAnim(view2);
            ObjectAnimator backgroundColorAnim = setBackgroundColorAnim(view2);
            ArrayList arrayList = new ArrayList();
            if (positionAnim != null) {
                arrayList.add(positionAnim);
            }
            if (scaleAnim != null) {
                arrayList.add(scaleAnim);
            }
            if (rotationAnim != null) {
                arrayList.add(rotationAnim);
            }
            if (alphaAnim != null) {
                arrayList.add(alphaAnim);
            }
            if (backgroundColorAnim != null) {
                arrayList.add(backgroundColorAnim);
            }
            if (arrayList.size() == 0) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setStartDelay(getAnimDelay());
            animatorSet.setInterpolator(getInterpolator());
            animatorSet.addListener(this.animatorListener);
            animatorSet.start();
        }
    }

    private void startKeyframeAnimation(View view2) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, view2) == null) {
            if ("position".equalsIgnoreCase(this.animType)) {
                animTranslation(view2);
            } else if (NativeConstants.OPACITY.equalsIgnoreCase(this.animType)) {
                animAlpha(view2);
            } else {
                if (AnimationProperty.SCALE.equalsIgnoreCase(this.animType)) {
                    i2 = 13;
                } else if (AnimationProperty.SCALE_X.equalsIgnoreCase(this.animType)) {
                    i2 = 11;
                } else if (!AnimationProperty.SCALE_Y.equalsIgnoreCase(this.animType)) {
                    if (AnimationProperty.ROTATE_X.equalsIgnoreCase(this.animType)) {
                        i = 1;
                    } else if (AnimationProperty.ROTATE_Y.equalsIgnoreCase(this.animType)) {
                        i = 2;
                    } else if (!"rotationZ".equalsIgnoreCase(this.animType)) {
                        if ("bgColor".equalsIgnoreCase(this.animType)) {
                            animBackgroundColor(view2);
                            return;
                        }
                        return;
                    } else {
                        i = 3;
                    }
                    animRotation(view2, i);
                    return;
                } else {
                    i2 = 12;
                }
                animScale(view2, i2);
            }
        }
    }

    private void updateAnimateLayoutParams(ObjectAnimator objectAnimator, TKBase tKBase, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65555, this, objectAnimator, tKBase, str) == null) || objectAnimator == null || tKBase == null || tKBase.getView() == null) {
            return;
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, str, tKBase) { // from class: com.tachikoma.core.component.anim.TKBasicAnimation.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TKBasicAnimation this$0;
            public final /* synthetic */ String val$animationProperty;
            public final /* synthetic */ TKBase val$tkBase;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, tKBase};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$animationProperty = str;
                this.val$tkBase = tKBase;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (!(animatedValue instanceof Float)) {
                        Logger.logE("updateAnimateLayoutParams", new IllegalStateException("unknown state " + this.val$animationProperty));
                    } else if (this.val$tkBase.getView() == null) {
                    } else {
                        float floatValue = ((Float) animatedValue).floatValue();
                        HashMap hashMap = new HashMap();
                        hashMap.put(this.val$animationProperty, Float.valueOf(TKConverter.px2dp(this.val$tkBase.getView().getContext(), floatValue)));
                        this.val$tkBase.setStyle(hashMap);
                    }
                }
            }
        });
    }

    public void animAlpha(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            float alpha = view2.getAlpha();
            float parseFloatValue = parseFloatValue(trans2String(this.animValue));
            if (alpha != parseFloatValue) {
                ObjectAnimator duration = ObjectAnimator.ofFloat(view2, AnimationProperty.OPACITY, alpha, parseFloatValue).setDuration(getAnimDuration());
                this.animator = duration;
                duration.setRepeatCount(this.repeatCount);
                duration.setRepeatMode(this.autoReverse ? 2 : 1);
                duration.setStartDelay(getAnimDelay());
                duration.setInterpolator(getInterpolator());
                duration.addListener(this.animatorListener);
                duration.start();
            }
        }
    }

    public void animBackgroundColor(View view2) {
        int color;
        int parseColor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) || (color = ((TKViewBackgroundDrawable) view2.getBackground()).getColor()) == (parseColor = parseColor(trans2String(this.animValue)))) {
            return;
        }
        ObjectAnimator duration = ObjectAnimator.ofInt(view2, "backgroundColor", color, parseColor).setDuration(getAnimDuration());
        this.animator = duration;
        duration.setRepeatCount(this.repeatCount);
        duration.setRepeatMode(this.autoReverse ? 2 : 1);
        duration.setStartDelay(getAnimDelay());
        duration.setInterpolator(getInterpolator());
        duration.setEvaluator(new ArgbEvaluator());
        duration.addListener(this.animatorListener);
        duration.start();
    }

    public void animRotation(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) == null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, i != 1 ? i != 2 ? "rotation" : AnimationProperty.ROTATE_Y : AnimationProperty.ROTATE_X, 0.0f, parseFloatValue(trans2String(this.animValue))).setDuration(getAnimDuration());
            this.animator = duration;
            duration.setRepeatCount(this.repeatCount);
            duration.setRepeatMode(this.autoReverse ? 2 : 1);
            duration.setStartDelay(getAnimDelay());
            duration.setInterpolator(getInterpolator());
            duration.addListener(this.animatorListener);
            duration.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void animScale(View view2, int i) {
        ObjectAnimator ofFloat;
        ObjectAnimator duration;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view2, i) == null) {
            float parseFloatValue = parseFloatValue(trans2String(this.animValue));
            if (i == 11) {
                ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_X, 0.0f, parseFloatValue);
            } else if (i != 12) {
                duration = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, parseFloatValue), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, parseFloatValue));
                this.animator = duration;
                duration.setRepeatCount(this.repeatCount);
                duration.setRepeatMode(this.autoReverse ? 2 : 1);
                duration.setStartDelay(getAnimDelay());
                duration.setInterpolator(getInterpolator());
                duration.addListener(this.animatorListener);
                duration.start();
            } else {
                ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_Y, 0.0f, parseFloatValue);
            }
            duration = ofFloat.setDuration(getAnimDuration());
            this.animator = duration;
            duration.setRepeatCount(this.repeatCount);
            duration.setRepeatMode(this.autoReverse ? 2 : 1);
            duration.setStartDelay(getAnimDelay());
            duration.setInterpolator(getInterpolator());
            duration.addListener(this.animatorListener);
            duration.start();
        }
    }

    public void animTranslation(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            float[] fArr = {0.0f, 0.0f};
            String[] trans2StringArray = trans2StringArray(this.animValue);
            if (trans2StringArray != null && trans2StringArray.length == 2) {
                fArr[0] = parsePxValue(trans2StringArray[0]);
                fArr[1] = parsePxValue(trans2StringArray[1]);
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_X, fArr[0]), PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_Y, fArr[1]));
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
            ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
            ofPropertyValuesHolder.setStartDelay(getAnimDelay());
            ofPropertyValuesHolder.setInterpolator(getInterpolator());
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    public void destroyAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            V8Proxy.release(this.animationV8Array);
        }
    }

    public Map<String, HashMap<Float, Object>> diffAnimationProperty(List<String> list, HashMap<Float, HashMap<String, Object>> hashMap) {
        InterceptResult invokeLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, list, hashMap)) == null) {
            HashMap hashMap2 = new HashMap();
            if (hashMap != null && hashMap.size() > 0) {
                for (String str : list) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Float, HashMap<String, Object>> entry : hashMap.entrySet()) {
                        Float key = entry.getKey();
                        HashMap<String, Object> value = entry.getValue();
                        if (!value.isEmpty() && (obj = value.get(str)) != null) {
                            linkedHashMap.put(key, obj);
                        }
                    }
                    if (!linkedHashMap.isEmpty()) {
                        hashMap2.put(str, linkedHashMap);
                    }
                }
                Iterator it = hashMap2.entrySet().iterator();
                while (it.hasNext()) {
                    if (!animationEnable((HashMap) ((Map.Entry) it.next()).getValue())) {
                        it.remove();
                    }
                }
            }
            return hashMap2;
        }
        return (Map) invokeLL.objValue;
    }

    public void executeEndValueFunction(AnimationJsCallback animationJsCallback) {
        V8FunctionImpl v8FunctionImpl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, animationJsCallback) == null) || (v8FunctionImpl = this.endValue) == null) {
            return;
        }
        v8FunctionImpl.call(new Object[0]);
        if (animationJsCallback != null) {
            animationJsCallback.onJsExecuteComplete(1.0d);
        }
    }

    public void executeStartValueFunction(AnimationJsCallback animationJsCallback) {
        V8FunctionImpl v8FunctionImpl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, animationJsCallback) == null) || (v8FunctionImpl = this.startValue) == null) {
            return;
        }
        v8FunctionImpl.call(new Object[0]);
        if (animationJsCallback != null) {
            animationJsCallback.onJsExecuteComplete(0.0d);
        }
    }

    public int getAnimDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (int) this.delay : invokeV.intValue;
    }

    public long getAnimDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.duration : invokeV.longValue;
    }

    public TimeInterpolator getInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (TimeFunctionConst.Time.LINEAR.equalsIgnoreCase(this.timeFunction)) {
                return new LinearInterpolator();
            }
            if (TimeFunctionConst.Time.EASE_IN.equalsIgnoreCase(this.timeFunction)) {
                return new AccelerateInterpolator();
            }
            if (TimeFunctionConst.Time.EASE_OUT.equalsIgnoreCase(this.timeFunction)) {
                return new DecelerateInterpolator();
            }
            if (TimeFunctionConst.Time.EASE_IN_OUT.equalsIgnoreCase(this.timeFunction)) {
                return new AccelerateDecelerateInterpolator();
            }
            if (TimeFunctionConst.Timing.LINEAR.equalsIgnoreCase(this.timingFunction)) {
                return CubicBezierInterpolator.buildDefaultLinearInterpolator();
            }
            if (TimeFunctionConst.Timing.EASE_IN.equalsIgnoreCase(this.timingFunction)) {
                return CubicBezierInterpolator.buildDefaultEaseInInterpolator();
            }
            if (TimeFunctionConst.Timing.EASE_OUT.equalsIgnoreCase(this.timingFunction)) {
                return CubicBezierInterpolator.buildDefaultEaseOutInterpolator();
            }
            if (TimeFunctionConst.Timing.EASE_IN_OUT.equalsIgnoreCase(this.timingFunction)) {
                return CubicBezierInterpolator.buildDefaultEaseInOutInterpolator();
            }
            if (TextUtils.isEmpty(this.timingFunction)) {
                return new AccelerateDecelerateInterpolator();
            }
            String[] split = this.timingFunction.split(" ");
            if (4 != split.length) {
                return new AccelerateDecelerateInterpolator();
            }
            try {
                return new CubicBezierInterpolator(Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
            } catch (Throwable unused) {
                return new AccelerateDecelerateInterpolator();
            }
        }
        return (TimeInterpolator) invokeV.objValue;
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Animator animator = this.animator;
            return animator != null && animator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public boolean newVersionEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.startValue == null && this.endValue == null && this.animationV8Array == null) ? false : true : invokeV.booleanValue;
    }

    public void on(String str, V8Function v8Function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, v8Function) == null) {
            if ("start".equalsIgnoreCase(str)) {
                this.animNJStartListener = v8Function.twin();
            } else if ("end".equalsIgnoreCase(str)) {
                this.animNJEndListener = v8Function.twin();
            }
        }
    }

    public int parseColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            try {
                return Color.parseColor(str);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public float parseFloatValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
        return invokeL.floatValue;
    }

    public float parsePxValue(String str) {
        InterceptResult invokeL;
        float dp2px;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            float f = 0.0f;
            try {
                if (str.toLowerCase().endsWith("px")) {
                    dp2px = Float.parseFloat(str.replace("px", ""));
                } else {
                    f = Float.parseFloat(str);
                    dp2px = TKConverter.dp2px(Tachikoma.sApplication, f);
                }
                return dp2px;
            } catch (Exception e) {
                e.printStackTrace();
                return f;
            }
        }
        return invokeL.floatValue;
    }

    public void pauseAnimation(TKBase tKBase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, tKBase) == null) || tKBase == null || tKBase.getView() == null) {
            return;
        }
        Object tag = tKBase.getView().getTag(R.id.obfuscated_res_0x7f0920bf);
        if (tag instanceof AnimatorSet) {
            pauseAnimation((AnimatorSet) tag);
        }
    }

    public void readInitial() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (view2 = this.mTargetView) != null && this.needTranformIdentity) {
            this.mInitialScaleX = view2.getScaleX();
            this.mInitialScaleY = this.mTargetView.getScaleY();
            this.mInitialTranslationX = this.mTargetView.getTranslationX();
            this.mInitialTranslationY = this.mTargetView.getTranslationY();
            this.mInitialRotationX = this.mTargetView.getRotationX();
            this.mInitialRotationY = this.mTargetView.getRotationY();
            this.mInitialAlpha = this.mTargetView.getAlpha();
        }
    }

    public void resetInitial() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (view2 = this.mTargetView) != null && this.needTranformIdentity) {
            view2.setScaleX(this.mInitialScaleX);
            this.mTargetView.setScaleY(this.mInitialScaleY);
            this.mTargetView.setTranslationX(this.mInitialTranslationX);
            this.mTargetView.setTranslationY(this.mInitialTranslationY);
            this.mTargetView.setRotationX(this.mInitialRotationX);
            this.mTargetView.setRotationY(this.mInitialRotationY);
            this.mTargetView.setAlpha(this.mInitialAlpha);
        }
    }

    public void resumeAnimation(TKBase tKBase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, tKBase) == null) || tKBase == null || tKBase.getView() == null) {
            return;
        }
        Object tag = tKBase.getView().getTag(R.id.obfuscated_res_0x7f0920bf);
        if (tag instanceof AnimatorSet) {
            resumeAnimation((AnimatorSet) tag);
        }
    }

    public void setAnimType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.animType = str;
        }
    }

    public void setAnimValue(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, obj) == null) {
            this.animValue = obj;
        }
    }

    public void setAutoReverse(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.autoReverse = z;
        }
    }

    public void setDelay(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f) == null) {
            this.delay = f;
        }
    }

    public void setDuration(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f) == null) {
            this.duration = f;
        }
    }

    public void setEndValue(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, obj) == null) && (obj instanceof V8FunctionImpl)) {
            this.endValue = (V8FunctionImpl) obj;
        }
    }

    public void setNeedTranformIdentity(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.needTranformIdentity = z;
        }
    }

    public void setRepeatCount(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            if (i >= Integer.MAX_VALUE) {
                i2 = -1;
            } else if (i <= 0) {
                this.repeatCount = i;
                return;
            } else {
                i2 = i - 1;
            }
            this.repeatCount = i2;
        }
    }

    public void setStartValue(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, obj) == null) && (obj instanceof V8FunctionImpl)) {
            this.startValue = (V8FunctionImpl) obj;
        }
    }

    public void setTimeFunction(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.timeFunction = str;
        }
    }

    public void setTimingFunction(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.timingFunction = str;
        }
    }

    public void start(TKBase tKBase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, tKBase) == null) {
            stop(tKBase);
            if (newVersionEnable()) {
                startAnimation(tKBase);
                return;
            }
            this.mTargetView = tKBase.getView();
            if (!TextUtils.isEmpty(this.animType)) {
                startKeyframeAnimation(this.mTargetView);
            } else if (this.animValue != null) {
                startBasicAnimation(this.mTargetView);
            }
        }
    }

    public void stop(TKBase tKBase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, tKBase) == null) {
            if (newVersionEnable() && tKBase != null && tKBase.getView() != null) {
                Object tag = tKBase.getView().getTag(R.id.obfuscated_res_0x7f0920bf);
                if (tag instanceof AnimatorSet) {
                    AnimatorSet animatorSet = (AnimatorSet) tag;
                    animatorSet.removeAllListeners();
                    animatorSet.end();
                }
            }
            if (isRunning()) {
                this.animator.cancel();
                this.animator = null;
            }
            UIThreadUtil.removeCallback(this.animatorOnStartForDelay);
        }
    }

    public String trans2String(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, obj)) == null) {
            if (obj instanceof Map) {
                obj = ((Map) obj).get("value");
            } else if (!(obj instanceof String)) {
                return String.valueOf(obj);
            }
            return (String) obj;
        }
        return (String) invokeL.objValue;
    }

    public String[] trans2StringArray(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, obj)) == null) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                String[] strArr = new String[2];
                Object obj2 = map.get("x");
                if (obj2 instanceof String) {
                    strArr[0] = (String) obj2;
                } else {
                    strArr[0] = String.valueOf(obj2);
                }
                Object obj3 = map.get("y");
                if (obj3 instanceof String) {
                    strArr[1] = (String) obj3;
                    return strArr;
                }
                strArr[1] = String.valueOf(obj3);
                return strArr;
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }
}
