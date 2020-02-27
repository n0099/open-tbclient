package com.idlefish.flutterboost;

import com.baidu.adp.lib.util.BdLog;
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
public class BoostPluginRegistry implements PluginRegistry {
    private final FlutterEngine flutterEngine;
    private final Map<String, Object> pluginMap = new HashMap();
    private final BoostRegistrarAggregate shimRegistrarAggregate = new BoostRegistrarAggregate();

    public BoostRegistrarAggregate getRegistrarAggregate() {
        return this.shimRegistrarAggregate;
    }

    public BoostPluginRegistry(FlutterEngine flutterEngine) {
        this.flutterEngine = flutterEngine;
        this.flutterEngine.getPlugins().add(this.shimRegistrarAggregate);
    }

    public PluginRegistry.Registrar registrarFor(String str) {
        BdLog.v("Creating plugin Registrar for '" + str + "'");
        if (this.pluginMap.containsKey(str)) {
            throw new IllegalStateException("Plugin key " + str + " is already in use");
        }
        this.pluginMap.put(str, null);
        BoostRegistrar boostRegistrar = new BoostRegistrar(str, this.pluginMap);
        this.shimRegistrarAggregate.addPlugin(boostRegistrar);
        return boostRegistrar;
    }

    public boolean hasPlugin(String str) {
        return this.pluginMap.containsKey(str);
    }

    public Object valuePublishedByPlugin(String str) {
        return this.pluginMap.get(str);
    }

    /* loaded from: classes6.dex */
    public static class BoostRegistrarAggregate implements FlutterPlugin, ActivityAware {
        private ActivityPluginBinding activityPluginBinding;
        private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
        private final Set<BoostRegistrar> shimRegistrars;

        public ActivityPluginBinding getActivityPluginBinding() {
            return this.activityPluginBinding;
        }

        private BoostRegistrarAggregate() {
            this.shimRegistrars = new HashSet();
        }

        public void addPlugin(BoostRegistrar boostRegistrar) {
            this.shimRegistrars.add(boostRegistrar);
            if (this.flutterPluginBinding != null) {
                boostRegistrar.onAttachedToEngine(this.flutterPluginBinding);
            }
            if (this.activityPluginBinding != null) {
                boostRegistrar.onAttachedToActivity(this.activityPluginBinding);
            }
        }

        public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
            this.flutterPluginBinding = flutterPluginBinding;
            for (BoostRegistrar boostRegistrar : this.shimRegistrars) {
                boostRegistrar.onAttachedToEngine(flutterPluginBinding);
            }
        }

        public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
            for (BoostRegistrar boostRegistrar : this.shimRegistrars) {
                boostRegistrar.onDetachedFromEngine(flutterPluginBinding);
            }
            this.flutterPluginBinding = null;
        }

        public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
            this.activityPluginBinding = activityPluginBinding;
            for (BoostRegistrar boostRegistrar : this.shimRegistrars) {
                boostRegistrar.onAttachedToActivity(activityPluginBinding);
            }
        }

        public void onDetachedFromActivityForConfigChanges() {
            for (BoostRegistrar boostRegistrar : this.shimRegistrars) {
                boostRegistrar.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
            for (BoostRegistrar boostRegistrar : this.shimRegistrars) {
                boostRegistrar.onReattachedToActivityForConfigChanges(activityPluginBinding);
            }
        }

        public void onDetachedFromActivity() {
            for (BoostRegistrar boostRegistrar : this.shimRegistrars) {
                boostRegistrar.onDetachedFromActivity();
            }
        }
    }
}
