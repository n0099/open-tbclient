package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes7.dex */
public class ForwardingControllerListener<INFO> implements ControllerListener<INFO> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FdingControllerListener";
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ControllerListener<? super INFO>> mListeners;

    public ForwardingControllerListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mListeners = new ArrayList(2);
    }

    public static <INFO> ForwardingControllerListener<INFO> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new ForwardingControllerListener<>() : (ForwardingControllerListener) invokeV.objValue;
    }

    public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> controllerListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, controllerListener)) == null) {
            ForwardingControllerListener<INFO> create = create();
            create.addListener(controllerListener);
            return create;
        }
        return (ForwardingControllerListener) invokeL.objValue;
    }

    private synchronized void onException(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, th) == null) {
            synchronized (this) {
            }
        }
    }

    public synchronized void addListener(ControllerListener<? super INFO> controllerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, controllerListener) == null) {
            synchronized (this) {
                this.mListeners.add(controllerListener);
            }
        }
    }

    public synchronized void clearListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.mListeners.clear();
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onFailure(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, th) == null) {
            synchronized (this) {
                int size = this.mListeners.size();
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        ControllerListener<? super INFO> controllerListener = this.mListeners.get(i2);
                        if (controllerListener != null) {
                            controllerListener.onFailure(str, th);
                        }
                    } catch (Exception e2) {
                        onException("InternalListener exception in onFailure", e2);
                    }
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onFinalImageSet(String str, @Nullable INFO info, @Nullable Animatable animatable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, info, animatable) == null) {
            synchronized (this) {
                int size = this.mListeners.size();
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        ControllerListener<? super INFO> controllerListener = this.mListeners.get(i2);
                        if (controllerListener != null) {
                            controllerListener.onFinalImageSet(str, info, animatable);
                        }
                    } catch (Exception e2) {
                        onException("InternalListener exception in onFinalImageSet", e2);
                    }
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, th) == null) {
            int size = this.mListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    ControllerListener<? super INFO> controllerListener = this.mListeners.get(i2);
                    if (controllerListener != null) {
                        controllerListener.onIntermediateImageFailed(str, th);
                    }
                } catch (Exception e2) {
                    onException("InternalListener exception in onIntermediateImageFailed", e2);
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String str, @Nullable INFO info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, info) == null) {
            int size = this.mListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    ControllerListener<? super INFO> controllerListener = this.mListeners.get(i2);
                    if (controllerListener != null) {
                        controllerListener.onIntermediateImageSet(str, info);
                    }
                } catch (Exception e2) {
                    onException("InternalListener exception in onIntermediateImageSet", e2);
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onRelease(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this) {
                int size = this.mListeners.size();
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        ControllerListener<? super INFO> controllerListener = this.mListeners.get(i2);
                        if (controllerListener != null) {
                            controllerListener.onRelease(str);
                        }
                    } catch (Exception e2) {
                        onException("InternalListener exception in onRelease", e2);
                    }
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onSubmit(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, obj) == null) {
            synchronized (this) {
                int size = this.mListeners.size();
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        ControllerListener<? super INFO> controllerListener = this.mListeners.get(i2);
                        if (controllerListener != null) {
                            controllerListener.onSubmit(str, obj);
                        }
                    } catch (Exception e2) {
                        onException("InternalListener exception in onSubmit", e2);
                    }
                }
            }
        }
    }

    public synchronized void removeListener(ControllerListener<? super INFO> controllerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, controllerListener) == null) {
            synchronized (this) {
                int indexOf = this.mListeners.indexOf(controllerListener);
                if (indexOf != -1) {
                    this.mListeners.set(indexOf, null);
                }
            }
        }
    }

    public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, controllerListener, controllerListener2)) == null) {
            ForwardingControllerListener<INFO> create = create();
            create.addListener(controllerListener);
            create.addListener(controllerListener2);
            return create;
        }
        return (ForwardingControllerListener) invokeLL.objValue;
    }
}
