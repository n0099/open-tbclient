package io.flutter.plugin.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.view.AccessibilityBridge;
/* loaded from: classes2.dex */
public class AccessibilityEventsDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AccessibilityBridge accessibilityBridge;

    public AccessibilityEventsDelegate() {
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

    public boolean requestSendAccessibilityEvent(@NonNull View view, @NonNull View view2, @NonNull AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, view, view2, accessibilityEvent)) == null) {
            AccessibilityBridge accessibilityBridge = this.accessibilityBridge;
            if (accessibilityBridge == null) {
                return false;
            }
            return accessibilityBridge.externalViewRequestSendAccessibilityEvent(view, view2, accessibilityEvent);
        }
        return invokeLLL.booleanValue;
    }

    public void setAccessibilityBridge(@Nullable AccessibilityBridge accessibilityBridge) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accessibilityBridge) == null) {
            this.accessibilityBridge = accessibilityBridge;
        }
    }
}
