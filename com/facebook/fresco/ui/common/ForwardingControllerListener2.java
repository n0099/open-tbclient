package com.facebook.fresco.ui.common;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.fresco.ui.common.ControllerListener2;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ForwardingControllerListener2<I> extends BaseControllerListener2<I> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FwdControllerListener2";
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ControllerListener2<I>> mListeners;

    public ForwardingControllerListener2() {
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

    private synchronized void onException(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, str, th) == null) {
            synchronized (this) {
                Log.e(TAG, str, th);
            }
        }
    }

    public synchronized void addListener(ControllerListener2<I> controllerListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, controllerListener2) == null) {
            synchronized (this) {
                this.mListeners.add(controllerListener2);
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(String str, Throwable th, ControllerListener2.Extras extras) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th, extras) == null) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    ControllerListener2<I> controllerListener2 = this.mListeners.get(i);
                    if (controllerListener2 != null) {
                        controllerListener2.onFailure(str, th, extras);
                    }
                } catch (Exception e) {
                    onException("ForwardingControllerListener2 exception in onFailure", e);
                }
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(String str, @Nullable I i, ControllerListener2.Extras extras) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, i, extras) == null) {
            int size = this.mListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    ControllerListener2<I> controllerListener2 = this.mListeners.get(i2);
                    if (controllerListener2 != null) {
                        controllerListener2.onFinalImageSet(str, i, extras);
                    }
                } catch (Exception e) {
                    onException("ForwardingControllerListener2 exception in onFinalImageSet", e);
                }
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(String str, ControllerListener2.Extras extras) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, extras) == null) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    ControllerListener2<I> controllerListener2 = this.mListeners.get(i);
                    if (controllerListener2 != null) {
                        controllerListener2.onRelease(str, extras);
                    }
                } catch (Exception e) {
                    onException("ForwardingControllerListener2 exception in onRelease", e);
                }
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(String str, Object obj, ControllerListener2.Extras extras) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, obj, extras) == null) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    ControllerListener2<I> controllerListener2 = this.mListeners.get(i);
                    if (controllerListener2 != null) {
                        controllerListener2.onSubmit(str, obj, extras);
                    }
                } catch (Exception e) {
                    onException("ForwardingControllerListener2 exception in onSubmit", e);
                }
            }
        }
    }

    public synchronized void removeAllListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.mListeners.clear();
            }
        }
    }

    public synchronized void removeListener(ControllerListener2<I> controllerListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, controllerListener2) == null) {
            synchronized (this) {
                int indexOf = this.mListeners.indexOf(controllerListener2);
                if (indexOf != -1) {
                    this.mListeners.set(indexOf, null);
                }
            }
        }
    }
}
