package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
/* loaded from: classes4.dex */
public class SharedPreferencesPlugin implements FlutterPlugin {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHANNEL_NAME = "plugins.flutter.io/shared_preferences";
    public transient /* synthetic */ FieldHolder $fh;
    public MethodChannel channel;
    public MethodCallHandlerImpl handler;

    public SharedPreferencesPlugin() {
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
            new SharedPreferencesPlugin().setupChannel(registrar.messenger(), registrar.context());
        }
    }

    private void setupChannel(BinaryMessenger binaryMessenger, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, binaryMessenger, context) == null) {
            this.channel = new MethodChannel(binaryMessenger, CHANNEL_NAME);
            MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(context);
            this.handler = methodCallHandlerImpl;
            this.channel.setMethodCallHandler(methodCallHandlerImpl);
        }
    }

    private void teardownChannel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.handler.teardown();
            this.handler = null;
            this.channel.setMethodCallHandler(null);
            this.channel = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterPluginBinding) == null) {
            setupChannel(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterPluginBinding) == null) {
            teardownChannel();
        }
    }
}
