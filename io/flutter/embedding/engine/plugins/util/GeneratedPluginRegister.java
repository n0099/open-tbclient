package io.flutter.embedding.engine.plugins.util;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
/* loaded from: classes3.dex */
public class GeneratedPluginRegister {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GeneratedPluginsRegister";
    public transient /* synthetic */ FieldHolder $fh;

    public GeneratedPluginRegister() {
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

    public static void registerGeneratedPlugins(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, flutterEngine) == null) {
            try {
                Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", FlutterEngine.class).invoke(null, flutterEngine);
            } catch (Exception e2) {
                Log.e(TAG, "Tried to automatically register plugins with FlutterEngine (" + flutterEngine + ") but could not find or invoke the GeneratedPluginRegistrant.");
                Log.e(TAG, "Received exception while registering", e2);
            }
        }
    }
}
