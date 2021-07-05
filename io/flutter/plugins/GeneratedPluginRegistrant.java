package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p.a.a;
import d.a.p.c.b;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
@Keep
/* loaded from: classes10.dex */
public final class GeneratedPluginRegistrant {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GeneratedPluginRegistrant() {
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

    public static void registerWith(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, flutterEngine) == null) {
            flutterEngine.getPlugins().add(new a());
            flutterEngine.getPlugins().add(new d.a.p.b.a());
            flutterEngine.getPlugins().add(new b());
            flutterEngine.getPlugins().add(new PathProviderPlugin());
            flutterEngine.getPlugins().add(new SharedPreferencesPlugin());
        }
    }
}
