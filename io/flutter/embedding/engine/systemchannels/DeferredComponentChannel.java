package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class DeferredComponentChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DeferredComponentChannel";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final MethodChannel channel;
    @NonNull
    public Map<String, List<MethodChannel.Result>> componentNameToResults;
    @Nullable
    public DeferredComponentManager deferredComponentManager;
    @NonNull
    @VisibleForTesting
    public final MethodChannel.MethodCallHandler parsingMethodHandler;

    public DeferredComponentChannel(@NonNull DartExecutor dartExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dartExecutor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parsingMethodHandler = new MethodChannel.MethodCallHandler(this) { // from class: io.flutter.embedding.engine.systemchannels.DeferredComponentChannel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DeferredComponentChannel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, methodCall, result) == null) || this.this$0.deferredComponentManager == null) {
                    return;
                }
                String str = methodCall.method;
                Map map = (Map) methodCall.arguments();
                Log.v(DeferredComponentChannel.TAG, "Received '" + str + "' message.");
                int intValue = ((Integer) map.get("loadingUnitId")).intValue();
                String str2 = (String) map.get("componentName");
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1004447972) {
                    if (hashCode != 399701758) {
                        if (hashCode == 520962947 && str.equals("installDeferredComponent")) {
                            c2 = 0;
                        }
                    } else if (str.equals("getDeferredComponentInstallState")) {
                        c2 = 1;
                    }
                } else if (str.equals("uninstallDeferredComponent")) {
                    c2 = 2;
                }
                if (c2 == 0) {
                    this.this$0.deferredComponentManager.installDeferredComponent(intValue, str2);
                    if (!this.this$0.componentNameToResults.containsKey(str2)) {
                        this.this$0.componentNameToResults.put(str2, new ArrayList());
                    }
                    ((List) this.this$0.componentNameToResults.get(str2)).add(result);
                } else if (c2 == 1) {
                    result.success(this.this$0.deferredComponentManager.getDeferredComponentInstallState(intValue, str2));
                } else if (c2 == 2) {
                    this.this$0.deferredComponentManager.uninstallDeferredComponent(intValue, str2);
                    result.success(null);
                } else {
                    result.notImplemented();
                }
            }
        };
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/deferredcomponent", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodHandler);
        this.deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
        this.componentNameToResults = new HashMap();
    }

    public void completeInstallError(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && this.componentNameToResults.containsKey(str)) {
            for (MethodChannel.Result result : this.componentNameToResults.get(str)) {
                result.error("DeferredComponent Install failure", str2, null);
            }
            this.componentNameToResults.get(str).clear();
        }
    }

    public void completeInstallSuccess(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.componentNameToResults.containsKey(str)) {
            for (MethodChannel.Result result : this.componentNameToResults.get(str)) {
                result.success(null);
            }
            this.componentNameToResults.get(str).clear();
        }
    }

    @VisibleForTesting
    public void setDeferredComponentManager(@Nullable DeferredComponentManager deferredComponentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, deferredComponentManager) == null) {
            this.deferredComponentManager = deferredComponentManager;
        }
    }
}
