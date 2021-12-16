package io.flutter.plugins.webviewflutter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
/* loaded from: classes4.dex */
public class WebViewFlutterPlugin implements FlutterPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FlutterCookieManager flutterCookieManager;

    public WebViewFlutterPlugin() {
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

    public static void registerWith(PluginRegistry.Registrar registrar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, registrar) == null) {
            registrar.platformViewRegistry().registerViewFactory("plugins.flutter.io/webview", new WebViewFactory(registrar.messenger(), registrar.view()));
            new FlutterCookieManager(registrar.messenger());
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterPluginBinding) == null) {
            BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
            flutterPluginBinding.getFlutterEngine().getPlatformViewsController().getRegistry().registerViewFactory("plugins.flutter.io/webview", new WebViewFactory(binaryMessenger, null));
            this.flutterCookieManager = new FlutterCookieManager(binaryMessenger);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        FlutterCookieManager flutterCookieManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterPluginBinding) == null) || (flutterCookieManager = this.flutterCookieManager) == null) {
            return;
        }
        flutterCookieManager.dispose();
        this.flutterCookieManager = null;
    }
}
