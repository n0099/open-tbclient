package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ForwardingControllerListener implements ControllerListener, OnDrawControllerListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FdingControllerListener";
    public transient /* synthetic */ FieldHolder $fh;
    public final List mListeners;

    public ForwardingControllerListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mListeners = new ArrayList(2);
    }

    public static ForwardingControllerListener create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new ForwardingControllerListener();
        }
        return (ForwardingControllerListener) invokeV.objValue;
    }

    public synchronized void clearListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.mListeners.clear();
            }
        }
    }

    public static ForwardingControllerListener of(ControllerListener controllerListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, controllerListener)) == null) {
            ForwardingControllerListener create = create();
            create.addListener(controllerListener);
            return create;
        }
        return (ForwardingControllerListener) invokeL.objValue;
    }

    public synchronized void addListener(ControllerListener controllerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, controllerListener) == null) {
            synchronized (this) {
                this.mListeners.add(controllerListener);
            }
        }
    }

    public synchronized void removeListener(ControllerListener controllerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, controllerListener) == null) {
            synchronized (this) {
                int indexOf = this.mListeners.indexOf(controllerListener);
                if (indexOf != -1) {
                    this.mListeners.set(indexOf, null);
                }
            }
        }
    }

    public static ForwardingControllerListener of(ControllerListener controllerListener, ControllerListener controllerListener2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, controllerListener, controllerListener2)) == null) {
            ForwardingControllerListener create = create();
            create.addListener(controllerListener);
            create.addListener(controllerListener2);
            return create;
        }
        return (ForwardingControllerListener) invokeLL.objValue;
    }

    private synchronized void onException(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, th) == null) {
            synchronized (this) {
                Log.e(TAG, str, th);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, th) == null) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                    if (controllerListener != null) {
                        controllerListener.onIntermediateImageFailed(str, th);
                    }
                } catch (Exception e) {
                    onException("InternalListener exception in onIntermediateImageFailed", e);
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String str, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, obj) == null) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                    if (controllerListener != null) {
                        controllerListener.onIntermediateImageSet(str, obj);
                    }
                } catch (Exception e) {
                    onException("InternalListener exception in onIntermediateImageSet", e);
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onFailure(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, th) == null) {
            synchronized (this) {
                int size = this.mListeners.size();
                for (int i = 0; i < size; i++) {
                    try {
                        ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                        if (controllerListener != null) {
                            controllerListener.onFailure(str, th);
                        }
                    } catch (Exception e) {
                        onException("InternalListener exception in onFailure", e);
                    }
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onSubmit(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, obj) == null) {
            synchronized (this) {
                int size = this.mListeners.size();
                for (int i = 0; i < size; i++) {
                    try {
                        ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                        if (controllerListener != null) {
                            controllerListener.onSubmit(str, obj);
                        }
                    } catch (Exception e) {
                        onException("InternalListener exception in onSubmit", e);
                    }
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, obj, animatable) == null) {
            synchronized (this) {
                int size = this.mListeners.size();
                for (int i = 0; i < size; i++) {
                    try {
                        ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                        if (controllerListener != null) {
                            controllerListener.onFinalImageSet(str, obj, animatable);
                        }
                    } catch (Exception e) {
                        onException("InternalListener exception in onFinalImageSet", e);
                    }
                }
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.OnDrawControllerListener
    public void onImageDrawn(String str, Object obj, DimensionsInfo dimensionsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, obj, dimensionsInfo) == null) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                    if (controllerListener instanceof OnDrawControllerListener) {
                        ((OnDrawControllerListener) controllerListener).onImageDrawn(str, obj, dimensionsInfo);
                    }
                } catch (Exception e) {
                    onException("InternalListener exception in onImageDrawn", e);
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onRelease(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            synchronized (this) {
                int size = this.mListeners.size();
                for (int i = 0; i < size; i++) {
                    try {
                        ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                        if (controllerListener != null) {
                            controllerListener.onRelease(str);
                        }
                    } catch (Exception e) {
                        onException("InternalListener exception in onRelease", e);
                    }
                }
            }
        }
    }
}
