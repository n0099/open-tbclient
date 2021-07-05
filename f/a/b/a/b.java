package f.a.b.a;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.platform.PlatformView;
/* compiled from: PlatformView.java */
/* loaded from: classes10.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"NewApi"})
    public static void $default$onFlutterViewAttached(@NonNull PlatformView platformView, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, platformView, view) == null) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void $default$onFlutterViewDetached(PlatformView platformView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, platformView) == null) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void $default$onInputConnectionLocked(PlatformView platformView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, platformView) == null) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void $default$onInputConnectionUnlocked(PlatformView platformView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, platformView) == null) {
        }
    }
}
