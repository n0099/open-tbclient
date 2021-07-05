package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class DraweeHolder<DH extends DraweeHierarchy> implements VisibilityCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DraweeController mController;
    public final DraweeEventTracker mEventTracker;
    public DH mHierarchy;
    public boolean mIsControllerAttached;
    public boolean mIsHolderAttached;
    public boolean mIsVisible;

    public DraweeHolder(@Nullable DH dh) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dh};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsControllerAttached = false;
        this.mIsHolderAttached = false;
        this.mIsVisible = true;
        this.mController = null;
        this.mEventTracker = DraweeEventTracker.newInstance();
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    private void attachController() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.mIsControllerAttached) {
            return;
        }
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        this.mIsControllerAttached = true;
        DraweeController draweeController = this.mController;
        if (draweeController == null || draweeController.getHierarchy() == null) {
            return;
        }
        this.mController.onAttach();
    }

    private void attachOrDetachController() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.mIsHolderAttached && this.mIsVisible) {
                attachController();
            } else {
                detachController();
            }
        }
    }

    public static <DH extends DraweeHierarchy> DraweeHolder<DH> create(@Nullable DH dh, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dh, context)) == null) {
            DraweeHolder<DH> draweeHolder = new DraweeHolder<>(dh);
            draweeHolder.registerWithContext(context);
            return draweeHolder;
        }
        return (DraweeHolder) invokeLL.objValue;
    }

    private void detachController() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65540, this) == null) && this.mIsControllerAttached) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.mIsControllerAttached = false;
            if (isControllerValid()) {
                this.mController.onDetach();
            }
        }
    }

    private void setVisibilityCallback(@Nullable VisibilityCallback visibilityCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, visibilityCallback) == null) {
            Drawable topLevelDrawable = getTopLevelDrawable();
            if (topLevelDrawable instanceof VisibilityAwareDrawable) {
                ((VisibilityAwareDrawable) topLevelDrawable).setVisibilityCallback(visibilityCallback);
            }
        }
    }

    @Nullable
    public DraweeController getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mController : (DraweeController) invokeV.objValue;
    }

    public DraweeEventTracker getDraweeEventTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mEventTracker : (DraweeEventTracker) invokeV.objValue;
    }

    public DH getHierarchy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (DH) Preconditions.checkNotNull(this.mHierarchy) : (DH) invokeV.objValue;
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            DH dh = this.mHierarchy;
            if (dh == null) {
                return null;
            }
            return dh.getTopLevelDrawable();
        }
        return (Drawable) invokeV.objValue;
    }

    public boolean hasHierarchy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mHierarchy != null : invokeV.booleanValue;
    }

    public boolean isAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIsHolderAttached : invokeV.booleanValue;
    }

    public boolean isControllerValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            DraweeController draweeController = this.mController;
            return draweeController != null && draweeController.getHierarchy() == this.mHierarchy;
        }
        return invokeV.booleanValue;
    }

    public void onAttach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
            this.mIsHolderAttached = true;
            attachOrDetachController();
        }
    }

    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_DETACH);
            this.mIsHolderAttached = false;
            attachOrDetachController();
        }
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onDraw() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.mIsControllerAttached) {
            return;
        }
        FLog.w(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mController)), toString());
        this.mIsHolderAttached = true;
        this.mIsVisible = true;
        attachOrDetachController();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            if (isControllerValid()) {
                return this.mController.onTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onVisibilityChange(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.mIsVisible == z) {
            return;
        }
        this.mEventTracker.recordEvent(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
        this.mIsVisible = z;
        attachOrDetachController();
    }

    public void registerWithContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
        }
    }

    public void setController(@Nullable DraweeController draweeController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, draweeController) == null) {
            boolean z = this.mIsControllerAttached;
            if (z) {
                detachController();
            }
            if (isControllerValid()) {
                this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
                this.mController.setHierarchy(null);
            }
            this.mController = draweeController;
            if (draweeController != null) {
                this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_CONTROLLER);
                this.mController.setHierarchy(this.mHierarchy);
            } else {
                this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
            }
            if (z) {
                attachController();
            }
        }
    }

    public void setHierarchy(DH dh) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dh) == null) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_HIERARCHY);
            boolean isControllerValid = isControllerValid();
            setVisibilityCallback(null);
            DH dh2 = (DH) Preconditions.checkNotNull(dh);
            this.mHierarchy = dh2;
            Drawable topLevelDrawable = dh2.getTopLevelDrawable();
            onVisibilityChange(topLevelDrawable == null || topLevelDrawable.isVisible());
            setVisibilityCallback(this);
            if (isControllerValid) {
                this.mController.setHierarchy(dh);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? Objects.toStringHelper(this).add("controllerAttached", this.mIsControllerAttached).add("holderAttached", this.mIsHolderAttached).add("drawableVisible", this.mIsVisible).add("events", this.mEventTracker.toString()).toString() : (String) invokeV.objValue;
    }
}
