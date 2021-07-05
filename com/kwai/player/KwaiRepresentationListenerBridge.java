package com.kwai.player;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.IKwaiRepresentationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
@Keep
/* loaded from: classes7.dex */
public class KwaiRepresentationListenerBridge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public KwaiRepresentationListenerBridge() {
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

    public static IKwaiRepresentationListener getListener(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            return (IKwaiRepresentationListener) ((WeakReference) obj).get();
        }
        return (IKwaiRepresentationListener) invokeL.objValue;
    }

    public static int onSelectRepresentation(Object obj, ArrayList arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, arrayList)) == null) {
            IKwaiRepresentationListener listener = getListener(obj);
            if (listener == null) {
                return 0;
            }
            return listener.onSelectRepresentation(arrayList);
        }
        return invokeLL.intValue;
    }

    public static void representationChangeEnd(Object obj, int i2) {
        IKwaiRepresentationListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, obj, i2) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.representationChangeEnd(i2);
    }

    public static void representationChangeStart(Object obj, int i2, int i3) {
        IKwaiRepresentationListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65540, null, obj, i2, i3) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.representationChangeStart(i2, i3);
    }
}
