package io.flutter.embedding.engine.plugins.shim;

import androidx.annotation.NonNull;
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
/* loaded from: classes6.dex */
public class ShimPluginRegistry implements PluginRegistry {
    private static final String TAG = "ShimPluginRegistry";
    private final FlutterEngine flutterEngine;
    private final Map<String, Object> pluginMap = new HashMap();
    private final ShimRegistrarAggregate shimRegistrarAggregate = new ShimRegistrarAggregate();

    public ShimPluginRegistry(@NonNull FlutterEngine flutterEngine) {
        this.flutterEngine = flutterEngine;
        this.flutterEngine.getPlugins().add(this.shimRegistrarAggregate);
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public PluginRegistry.Registrar registrarFor(String str) {
        Log.v(TAG, "Creating plugin Registrar for '" + str + "'");
        if (this.pluginMap.containsKey(str)) {
            throw new IllegalStateException("Plugin key " + str + " is already in use");
        }
        this.pluginMap.put(str, null);
        ShimRegistrar shimRegistrar = new ShimRegistrar(str, this.pluginMap);
        this.shimRegistrarAggregate.addPlugin(shimRegistrar);
        return shimRegistrar;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public boolean hasPlugin(String str) {
        return this.pluginMap.containsKey(str);
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public <T> T valuePublishedByPlugin(String str) {
        return (T) this.pluginMap.get(str);
    }

    /* loaded from: classes6.dex */
    private static class ShimRegistrarAggregate implements FlutterPlugin, ActivityAware {
        private ActivityPluginBinding activityPluginBinding;
        private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
        private final Set<ShimRegistrar> shimRegistrars;

        private ShimRegistrarAggregate() {
            this.shimRegistrars = new HashSet();
        }

        public void addPlugin(@NonNull ShimRegistrar shimRegistrar) {
            this.shimRegistrars.add(shimRegistrar);
            if (this.flutterPluginBinding != null) {
                shimRegistrar.onAttachedToEngine(this.flutterPluginBinding);
            }
            if (this.activityPluginBinding != null) {
                shimRegistrar.onAttachedToActivity(this.activityPluginBinding);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
        public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
            this.flutterPluginBinding = flutterPluginBinding;
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onAttachedToEngine(flutterPluginBinding);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
        public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onDetachedFromEngine(flutterPluginBinding);
            }
            this.flutterPluginBinding = null;
            this.activityPluginBinding = null;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
            this.activityPluginBinding = activityPluginBinding;
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onAttachedToActivity(activityPluginBinding);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onDetachedFromActivityForConfigChanges() {
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
            this.activityPluginBinding = activityPluginBinding;
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onReattachedToActivityForConfigChanges(activityPluginBinding);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onDetachedFromActivity() {
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }
    }
}
