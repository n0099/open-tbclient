package com.kwai.player.vr;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.player.vr.KwaiVR;
/* loaded from: classes7.dex */
public class KwaiGestureHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MODE_INIT = 0;
    public static final int MODE_PINCH = 1;
    public static final String TAG = "KwaiGestureHelperf";
    public static final float mDamping = 0.2f;
    public static final float mDensity;
    public transient /* synthetic */ FieldHolder $fh;
    public float defaultScale;
    public KwaiVR.IAdvanceGestureListener mAdvanceGestureListener;
    public int mCurrentMode;
    public KwaiFlingConfig mFlingConfig;
    public boolean mFlingEnabled;
    public GestureDetector mGestureDetector;
    public boolean mGestureEnabled;
    public float mGlobalScale;
    public boolean mPinchEnabled;
    public PinchInfo mPinchInfo;
    public float mPreDistanceX;
    public float mPreDistanceY;
    public float mSensitivity;
    public float mTouchSensitivity;
    public float maxScale;
    public float minScale;
    public ValueAnimator valueAnimator;

    /* loaded from: classes7.dex */
    public class PinchInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float currentScale;
        public float oDistance;
        public float prevScale;
        public final /* synthetic */ KwaiGestureHelper this$0;
        public float x1;
        public float x2;
        public float y1;
        public float y2;

        public PinchInfo(KwaiGestureHelper kwaiGestureHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kwaiGestureHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = kwaiGestureHelper;
        }

        public void mark(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                this.x1 = f2;
                this.y1 = f3;
                this.x2 = f4;
                this.y2 = f5;
                this.oDistance = KwaiGestureHelper.calDistance(f2, f3, f4, f5);
                this.prevScale = this.currentScale;
            }
        }

        public float pinch(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
                if (this.oDistance == 0.0f) {
                    this.oDistance = f2;
                }
                float f3 = this.prevScale + (((f2 / this.oDistance) - 1.0f) * this.this$0.mSensitivity * 3.0f);
                this.currentScale = f3;
                float max = Math.max(f3, this.this$0.minScale);
                this.currentScale = max;
                float min = Math.min(max, this.this$0.maxScale);
                this.currentScale = min;
                return min;
            }
            return invokeF.floatValue;
        }

        public float reset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? setScale(this.this$0.defaultScale) : invokeV.floatValue;
        }

        public float setScale(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
                this.prevScale = f2;
                this.currentScale = f2;
                return f2;
            }
            return invokeF.floatValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2146021854, "Lcom/kwai/player/vr/KwaiGestureHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2146021854, "Lcom/kwai/player/vr/KwaiGestureHelper;");
                return;
            }
        }
        mDensity = Resources.getSystem().getDisplayMetrics().density;
    }

    public KwaiGestureHelper(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurrentMode = 0;
        this.mPinchInfo = new PinchInfo();
        this.mGestureEnabled = false;
        this.mPinchEnabled = false;
        this.minScale = 1.0f;
        this.maxScale = 4.0f;
        this.mSensitivity = 1.0f;
        this.defaultScale = 1.0f;
        this.mGlobalScale = 1.0f;
        this.mTouchSensitivity = 1.0f;
        this.mPreDistanceX = 0.0f;
        this.mPreDistanceY = 0.0f;
        this.mFlingEnabled = true;
        this.mFlingConfig = new KwaiFlingConfig();
        this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(this) { // from class: com.kwai.player.vr.KwaiGestureHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KwaiGestureHelper this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    if (this.this$0.mCurrentMode != 1 && this.this$0.mFlingEnabled) {
                        this.this$0.animStart(f2, f3);
                        return true;
                    }
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    if (this.this$0.mCurrentMode == 1) {
                        return false;
                    }
                    KwaiGestureHelper kwaiGestureHelper = this.this$0;
                    kwaiGestureHelper.onDrag(kwaiGestureHelper.scaled(f2), this.this$0.scaled(f3));
                    return true;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? this.this$0.mCurrentMode != 1 : invokeL.booleanValue;
            }
        });
    }

    private void animCancel() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (valueAnimator = this.valueAnimator) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animStart(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            animCancel();
            ValueAnimator duration = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("vx", f2, 0.0f), PropertyValuesHolder.ofFloat("vy", f3, 0.0f)).setDuration(this.mFlingConfig.getDuring());
            this.valueAnimator = duration;
            duration.setInterpolator(this.mFlingConfig.getInterpolator());
            this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwai.player.vr.KwaiGestureHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public long lastTime;
                public final /* synthetic */ KwaiGestureHelper this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.lastTime = 0L;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        long currentPlayTime = valueAnimator.getCurrentPlayTime();
                        float f4 = (float) (currentPlayTime - this.lastTime);
                        float floatValue = ((((Float) valueAnimator.getAnimatedValue("vy")).floatValue() * f4) / (-1000.0f)) * this.this$0.mFlingConfig.getSensitivity();
                        this.lastTime = currentPlayTime;
                        KwaiGestureHelper kwaiGestureHelper = this.this$0;
                        kwaiGestureHelper.onDrag(kwaiGestureHelper.scaled(((((Float) valueAnimator.getAnimatedValue("vx")).floatValue() * f4) / (-1000.0f)) * this.this$0.mFlingConfig.getSensitivity()), this.this$0.scaled(floatValue));
                    }
                }
            });
            this.valueAnimator.start();
        }
    }

    public static float calDistance(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (float) Math.sqrt(Math.pow(f2 - f4, 2.0d) + Math.pow(f3 - f5, 2.0d)) : invokeCommon.floatValue;
    }

    private void handlePinch(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(65552, this, f2) == null) && this.mPinchEnabled) {
            setScaleInner(this.mPinchInfo.pinch(f2));
        }
    }

    private void markPinchInfo(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.mPinchInfo.mark(f2, f3, f4, f5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDrag(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && this.mGestureEnabled) {
            float f4 = this.mPreDistanceX;
            float f5 = mDensity;
            float f6 = f4 - ((f2 / f5) * 0.2f);
            float f7 = this.mPreDistanceY - ((f3 / f5) * 0.2f);
            KwaiVR.IAdvanceGestureListener iAdvanceGestureListener = this.mAdvanceGestureListener;
            if (iAdvanceGestureListener != null) {
                iAdvanceGestureListener.onDrag(f6, f7);
            }
            this.mPreDistanceX = f6;
            this.mPreDistanceY = f7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float scaled(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65555, this, f2)) == null) ? (f2 / this.mGlobalScale) * this.mTouchSensitivity : invokeF.floatValue;
    }

    private void setScaleInner(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65556, this, f2) == null) {
            KwaiVR.IAdvanceGestureListener iAdvanceGestureListener = this.mAdvanceGestureListener;
            if (iAdvanceGestureListener != null) {
                iAdvanceGestureListener.onPinch(f2);
            }
            this.mGlobalScale = f2;
        }
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        float x;
        float y;
        float x2;
        float y2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 1 || action == 3) {
                this.mCurrentMode = 0;
            } else if (action == 6) {
                if (this.mCurrentMode == 1 && motionEvent.getPointerCount() > 2) {
                    if ((motionEvent.getAction() >> 8) == 0) {
                        x = motionEvent.getX(1);
                        y = motionEvent.getY(1);
                    } else if ((motionEvent.getAction() >> 8) == 1) {
                        x = motionEvent.getX(0);
                        y = motionEvent.getY(0);
                    }
                    x2 = motionEvent.getX(2);
                    y2 = motionEvent.getY(2);
                    markPinchInfo(x, y, x2, y2);
                }
            } else if (action == 5) {
                this.mCurrentMode = 1;
                x = motionEvent.getX(0);
                y = motionEvent.getY(0);
                x2 = motionEvent.getX(1);
                y2 = motionEvent.getY(1);
                markPinchInfo(x, y, x2, y2);
            } else if (action == 2) {
                if (this.mCurrentMode == 1 && motionEvent.getPointerCount() > 1) {
                    handlePinch(calDistance(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1)));
                }
            } else if (action == 0) {
                animCancel();
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean isFlingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFlingEnabled : invokeV.booleanValue;
    }

    public boolean isGestureEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mGestureEnabled : invokeV.booleanValue;
    }

    public boolean isPinchEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPinchEnabled : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setScaleInner(this.mPinchInfo.reset());
        }
    }

    public void scaleTo(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            setScaleInner(this.mPinchInfo.setScale(f2));
        }
    }

    public void setAdvanceGestureListener(KwaiVR.IAdvanceGestureListener iAdvanceGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iAdvanceGestureListener) == null) {
            this.mAdvanceGestureListener = iAdvanceGestureListener;
        }
    }

    public void setFlingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mFlingEnabled = z;
        }
    }

    public void setGestureEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mGestureEnabled = z;
        }
    }

    public void setPinchEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mPinchEnabled = z;
        }
    }

    public void setTouchSensitivity(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.mTouchSensitivity = f2;
        }
    }
}
