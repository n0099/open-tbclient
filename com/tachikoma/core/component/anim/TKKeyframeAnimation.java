package com.tachikoma.core.component.anim;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.Releasable;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.kwad.v8.V8Value;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.component.anim.TKBasicAnimation;
import com.tachikoma.core.utility.V8Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@TK_EXPORT_CLASS
/* loaded from: classes4.dex */
public class TKKeyframeAnimation extends TKBasicAnimation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<KeyFrame> keyframes;

    /* loaded from: classes4.dex */
    public class KeyFrame {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String easing;
        public float percent;
        public final /* synthetic */ TKKeyframeAnimation this$0;
        public Object value;

        public KeyFrame(TKKeyframeAnimation tKKeyframeAnimation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tKKeyframeAnimation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tKKeyframeAnimation;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKKeyframeAnimation(Context context, @Nullable List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.tachikoma.core.component.anim.TKBasicAnimation
    public void animAlpha(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            Keyframe[] keyframeArr = new Keyframe[this.keyframes.size()];
            for (int i2 = 0; i2 < this.keyframes.size(); i2++) {
                KeyFrame keyFrame = this.keyframes.get(i2);
                keyframeArr[i2] = Keyframe.ofFloat(keyFrame.percent, parseFloatValue(trans2String(keyFrame.value)));
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(AnimationProperty.OPACITY, keyframeArr));
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(getAnimDuration());
            ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
            ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
            ofPropertyValuesHolder.setStartDelay(getAnimDelay());
            ofPropertyValuesHolder.setInterpolator(getInterpolator());
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    @Override // com.tachikoma.core.component.anim.TKBasicAnimation
    public void animBackgroundColor(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            Keyframe[] keyframeArr = new Keyframe[this.keyframes.size()];
            for (int i2 = 0; i2 < this.keyframes.size(); i2++) {
                KeyFrame keyFrame = this.keyframes.get(i2);
                keyframeArr[i2] = Keyframe.ofInt(keyFrame.percent, parseColor(trans2String(keyFrame.value)));
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe("backgroundColor", keyframeArr));
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(getAnimDuration());
            ofPropertyValuesHolder.setEvaluator(new ArgbEvaluator());
            ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
            ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
            ofPropertyValuesHolder.setStartDelay(getAnimDelay());
            ofPropertyValuesHolder.setInterpolator(getInterpolator());
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    @Override // com.tachikoma.core.component.anim.TKBasicAnimation
    public void animRotation(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
            String str = i2 != 1 ? i2 != 2 ? "rotation" : AnimationProperty.ROTATE_Y : AnimationProperty.ROTATE_X;
            Keyframe[] keyframeArr = new Keyframe[this.keyframes.size()];
            for (int i3 = 0; i3 < this.keyframes.size(); i3++) {
                KeyFrame keyFrame = this.keyframes.get(i3);
                keyframeArr[i3] = Keyframe.ofFloat(keyFrame.percent, parseFloatValue(trans2String(keyFrame.value)));
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(str, keyframeArr));
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(getAnimDuration());
            ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
            ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
            ofPropertyValuesHolder.setStartDelay(getAnimDelay());
            ofPropertyValuesHolder.setInterpolator(getInterpolator());
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    @Override // com.tachikoma.core.component.anim.TKBasicAnimation
    public void animScale(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
            Keyframe[] keyframeArr = new Keyframe[this.keyframes.size()];
            for (int i3 = 0; i3 < this.keyframes.size(); i3++) {
                KeyFrame keyFrame = this.keyframes.get(i3);
                keyframeArr[i3] = Keyframe.ofFloat(keyFrame.percent, parseFloatValue(trans2String(keyFrame.value)));
            }
            ObjectAnimator ofPropertyValuesHolder = i2 != 11 ? i2 != 12 ? ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(AnimationProperty.SCALE_X, keyframeArr), PropertyValuesHolder.ofKeyframe(AnimationProperty.SCALE_Y, keyframeArr)) : ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(AnimationProperty.SCALE_Y, keyframeArr)) : ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(AnimationProperty.SCALE_X, keyframeArr));
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(getAnimDuration());
            ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
            ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
            ofPropertyValuesHolder.setStartDelay(getAnimDelay());
            ofPropertyValuesHolder.setInterpolator(getInterpolator());
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    @Override // com.tachikoma.core.component.anim.TKBasicAnimation
    public void animTranslation(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            Keyframe[] keyframeArr = new Keyframe[this.keyframes.size()];
            Keyframe[] keyframeArr2 = new Keyframe[this.keyframes.size()];
            int i2 = 0;
            while (true) {
                if (i2 >= this.keyframes.size()) {
                    break;
                }
                KeyFrame keyFrame = this.keyframes.get(i2);
                String[] trans2StringArray = trans2StringArray(keyFrame.value);
                Keyframe ofFloat = Keyframe.ofFloat(keyFrame.percent, parsePxValue(trans2StringArray[0]));
                Keyframe ofFloat2 = Keyframe.ofFloat(keyFrame.percent, parsePxValue(trans2StringArray[1]));
                keyframeArr[i2] = ofFloat;
                keyframeArr2[i2] = ofFloat2;
                i2++;
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(AnimationProperty.TRANSLATE_X, keyframeArr), PropertyValuesHolder.ofKeyframe(AnimationProperty.TRANSLATE_Y, keyframeArr2));
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(getAnimDuration());
            ofPropertyValuesHolder.setRepeatCount(this.repeatCount);
            ofPropertyValuesHolder.setRepeatMode(this.autoReverse ? 2 : 1);
            ofPropertyValuesHolder.setStartDelay(getAnimDelay());
            ofPropertyValuesHolder.setInterpolator(getInterpolator());
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, IGET, INVOKE, MOVE_EXCEPTION] complete} */
    public void executeAnimationFunction(TKBasicAnimation.AnimationJsCallback animationJsCallback) {
        V8Array v8Array;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, animationJsCallback) == null) || (v8Array = this.animationV8Array) == null || v8Array.isReleased()) {
            return;
        }
        int length = this.animationV8Array.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                Object obj = this.animationV8Array.get(i2);
                if (obj instanceof V8Function) {
                    V8Function v8Function = (V8Function) obj;
                    V8Array createV8Array = V8Proxy.createV8Array((V8Value) v8Function, new String[0]);
                    Object call = v8Function.call(null, createV8Array);
                    if (animationJsCallback != null && (call instanceof Number)) {
                        animationJsCallback.onJsExecuteComplete(((Number) call).floatValue());
                    }
                    if (call instanceof V8Value) {
                        V8Proxy.release((V8Value) call);
                    }
                    createV8Array.close();
                    v8Function.close();
                } else if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public void setAnimations(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (obj instanceof V8Array)) {
            this.animationV8Array = ((V8Array) obj).twin();
        }
    }

    @Override // com.tachikoma.core.component.anim.TKBasicAnimation
    public void setDuration(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.duration = f2;
        }
    }

    public void setKeyframes(ArrayList<Object> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.keyframes = new ArrayList<>();
            Object[] array = arrayList.toArray();
            for (int i2 = 0; i2 < array.length; i2++) {
                Object obj = array[i2];
                KeyFrame keyFrame = new KeyFrame(this);
                Map map = (Map) obj;
                if (map.containsKey(SapiOptions.KEY_CACHE_PERCENT)) {
                    keyFrame.percent = ((Number) map.get(SapiOptions.KEY_CACHE_PERCENT)).floatValue();
                }
                if (map.containsKey("value")) {
                    keyFrame.value = map.get("value");
                }
                if (map.containsKey("easing")) {
                    keyFrame.easing = (String) map.get("easing");
                }
                if (keyFrame.percent == 0.0f) {
                    float f2 = 1.0f;
                    if (array.length != 1) {
                        if (i2 > 0) {
                            f2 = (1.0f / (array.length - 1)) * i2;
                        }
                    }
                    keyFrame.percent = f2;
                }
                this.keyframes.add(keyFrame);
            }
        }
    }
}
