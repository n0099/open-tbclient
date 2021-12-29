package io.flutter.plugins.packageinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class PackageInfoPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context applicationContext;
    public MethodChannel methodChannel;

    public PackageInfoPlugin() {
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

    public static long getLongVersionCode(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, packageInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return packageInfo.versionCode;
        }
        return invokeL.longValue;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, registrar) == null) {
            new PackageInfoPlugin().onAttachedToEngine(registrar.context(), registrar.messenger());
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterPluginBinding) == null) {
            onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterPluginBinding) == null) {
            this.applicationContext = null;
            this.methodChannel.setMethodCallHandler(null);
            this.methodChannel = null;
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, methodCall, result) == null) {
            try {
                if (methodCall.method.equals("getAll")) {
                    PackageManager packageManager = this.applicationContext.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(this.applicationContext.getPackageName(), 0);
                    HashMap hashMap = new HashMap();
                    hashMap.put("appName", packageInfo.applicationInfo.loadLabel(packageManager).toString());
                    hashMap.put("packageName", this.applicationContext.getPackageName());
                    hashMap.put("version", packageInfo.versionName);
                    hashMap.put("buildNumber", String.valueOf(getLongVersionCode(packageInfo)));
                    result.success(hashMap);
                    return;
                }
                result.notImplemented();
            } catch (PackageManager.NameNotFoundException e2) {
                result.error("Name not found", e2.getMessage(), null);
            }
        }
    }

    private void onAttachedToEngine(Context context, BinaryMessenger binaryMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, binaryMessenger) == null) {
            this.applicationContext = context;
            MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/package_info");
            this.methodChannel = methodChannel;
            methodChannel.setMethodCallHandler(this);
        }
    }
}
