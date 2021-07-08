package io.flutter.embedding.engine.plugins.shim;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class ShimPluginRegistry implements PluginRegistry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ShimPluginRegistry";
    public transient /* synthetic */ FieldHolder $fh;
    public final FlutterEngine flutterEngine;
    public final Map<String, Object> pluginMap;
    public final ShimRegistrarAggregate shimRegistrarAggregate;

    /* renamed from: io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public ShimPluginRegistry(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterEngine};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pluginMap = new HashMap();
        this.flutterEngine = flutterEngine;
        this.shimRegistrarAggregate = new ShimRegistrarAggregate(null);
        this.flutterEngine.getPlugins().add(this.shimRegistrarAggregate);
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public boolean hasPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.pluginMap.containsKey(str) : invokeL.booleanValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public PluginRegistry.Registrar registrarFor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Log.v(TAG, "Creating plugin Registrar for '" + str + "'");
            if (!this.pluginMap.containsKey(str)) {
                this.pluginMap.put(str, null);
                ShimRegistrar shimRegistrar = new ShimRegistrar(str, this.pluginMap);
                this.shimRegistrarAggregate.addPlugin(shimRegistrar);
                return shimRegistrar;
            }
            throw new IllegalStateException("Plugin key " + str + " is already in use");
        }
        return (PluginRegistry.Registrar) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public <T> T valuePublishedByPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? (T) this.pluginMap.get(str) : (T) invokeL.objValue;
    }

    /* loaded from: classes9.dex */
    public static class ShimRegistrarAggregate implements FlutterPlugin, ActivityAware {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ActivityPluginBinding activityPluginBinding;
        public FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
        public final Set<ShimRegistrar> shimRegistrars;

        public ShimRegistrarAggregate() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.shimRegistrars = new HashSet();
        }

        public void addPlugin(@NonNull ShimRegistrar shimRegistrar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shimRegistrar) == null) {
                this.shimRegistrars.add(shimRegistrar);
                FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.flutterPluginBinding;
                if (flutterPluginBinding != null) {
                    shimRegistrar.onAttachedToEngine(flutterPluginBinding);
                }
                ActivityPluginBinding activityPluginBinding = this.activityPluginBinding;
                if (activityPluginBinding != null) {
                    shimRegistrar.onAttachedToActivity(activityPluginBinding);
                }
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activityPluginBinding) == null) {
                this.activityPluginBinding = activityPluginBinding;
                for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                    shimRegistrar.onAttachedToActivity(activityPluginBinding);
                }
            }
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
        public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flutterPluginBinding) == null) {
                this.flutterPluginBinding = flutterPluginBinding;
                for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                    shimRegistrar.onAttachedToEngine(flutterPluginBinding);
                }
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onDetachedFromActivity() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                    shimRegistrar.onDetachedFromActivity();
                }
                this.activityPluginBinding = null;
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onDetachedFromActivityForConfigChanges() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                    shimRegistrar.onDetachedFromActivity();
                }
                this.activityPluginBinding = null;
            }
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
        public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, flutterPluginBinding) == null) {
                for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                    shimRegistrar.onDetachedFromEngine(flutterPluginBinding);
                }
                this.flutterPluginBinding = null;
                this.activityPluginBinding = null;
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activityPluginBinding) == null) {
                this.activityPluginBinding = activityPluginBinding;
                for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                    shimRegistrar.onReattachedToActivityForConfigChanges(activityPluginBinding);
                }
            }
        }

        public /* synthetic */ ShimRegistrarAggregate(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
