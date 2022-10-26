package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class GestureDetector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mActionDownTime;
    public float mActionDownX;
    public float mActionDownY;
    @Nullable
    public ClickListener mClickListener;
    public boolean mIsCapturingGesture;
    public boolean mIsClickCandidate;
    public final float mSingleTapSlopPx;

    /* loaded from: classes7.dex */
    public interface ClickListener {
        boolean onClick();
    }

    public GestureDetector(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSingleTapSlopPx = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static GestureDetector newInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return new GestureDetector(context);
        }
        return (GestureDetector) invokeL.objValue;
    }

    public void setClickListener(ClickListener clickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, clickListener) == null) {
            this.mClickListener = clickListener;
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mClickListener = null;
            reset();
        }
    }

    public boolean isCapturingGesture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mIsCapturingGesture;
        }
        return invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mIsCapturingGesture = false;
            this.mIsClickCandidate = false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        ClickListener clickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3) {
                            this.mIsCapturingGesture = false;
                            this.mIsClickCandidate = false;
                        }
                    } else if (Math.abs(motionEvent.getX() - this.mActionDownX) > this.mSingleTapSlopPx || Math.abs(motionEvent.getY() - this.mActionDownY) > this.mSingleTapSlopPx) {
                        this.mIsClickCandidate = false;
                    }
                } else {
                    this.mIsCapturingGesture = false;
                    if (Math.abs(motionEvent.getX() - this.mActionDownX) > this.mSingleTapSlopPx || Math.abs(motionEvent.getY() - this.mActionDownY) > this.mSingleTapSlopPx) {
                        this.mIsClickCandidate = false;
                    }
                    if (this.mIsClickCandidate && motionEvent.getEventTime() - this.mActionDownTime <= ViewConfiguration.getLongPressTimeout() && (clickListener = this.mClickListener) != null) {
                        clickListener.onClick();
                    }
                    this.mIsClickCandidate = false;
                }
            } else {
                this.mIsCapturingGesture = true;
                this.mIsClickCandidate = true;
                this.mActionDownTime = motionEvent.getEventTime();
                this.mActionDownX = motionEvent.getX();
                this.mActionDownY = motionEvent.getY();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
