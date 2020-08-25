package io.flutter.embedding.engine.plugins.shim;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes19.dex */
class ShimRegistrar implements FlutterPlugin, ActivityAware, PluginRegistry.Registrar {
    private static final String TAG = "ShimRegistrar";
    private ActivityPluginBinding activityPluginBinding;
    private final Map<String, Object> globalRegistrarMap;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;
    private final String pluginId;
    private final Set<PluginRegistry.ViewDestroyListener> viewDestroyListeners = new HashSet();
    private final Set<PluginRegistry.RequestPermissionsResultListener> requestPermissionsResultListeners = new HashSet();
    private final Set<PluginRegistry.ActivityResultListener> activityResultListeners = new HashSet();
    private final Set<PluginRegistry.NewIntentListener> newIntentListeners = new HashSet();
    private final Set<PluginRegistry.UserLeaveHintListener> userLeaveHintListeners = new HashSet();

    public ShimRegistrar(@NonNull String str, @NonNull Map<String, Object> map) {
        this.pluginId = str;
        this.globalRegistrarMap = map;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public Activity activity() {
        if (this.activityPluginBinding != null) {
            return this.activityPluginBinding.getActivity();
        }
        return null;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public Context context() {
        if (this.pluginBinding != null) {
            return this.pluginBinding.getApplicationContext();
        }
        return null;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public Context activeContext() {
        return this.activityPluginBinding == null ? context() : activity();
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public BinaryMessenger messenger() {
        if (this.pluginBinding != null) {
            return this.pluginBinding.getBinaryMessenger();
        }
        return null;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public TextureRegistry textures() {
        if (this.pluginBinding != null) {
            return this.pluginBinding.getTextureRegistry();
        }
        return null;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PlatformViewRegistry platformViewRegistry() {
        if (this.pluginBinding != null) {
            return this.pluginBinding.getPlatformViewRegistry();
        }
        return null;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public FlutterView view() {
        throw new UnsupportedOperationException("The new embedding does not support the old FlutterView.");
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public String lookupKeyForAsset(String str) {
        return FlutterMain.getLookupKeyForAsset(str);
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public String lookupKeyForAsset(String str, String str2) {
        return FlutterMain.getLookupKeyForAsset(str, str2);
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar publish(Object obj) {
        this.globalRegistrarMap.put(this.pluginId, obj);
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
        this.requestPermissionsResultListeners.add(requestPermissionsResultListener);
        if (this.activityPluginBinding != null) {
            this.activityPluginBinding.addRequestPermissionsResultListener(requestPermissionsResultListener);
        }
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
        this.activityResultListeners.add(activityResultListener);
        if (this.activityPluginBinding != null) {
            this.activityPluginBinding.addActivityResultListener(activityResultListener);
        }
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
        this.newIntentListeners.add(newIntentListener);
        if (this.activityPluginBinding != null) {
            this.activityPluginBinding.addOnNewIntentListener(newIntentListener);
        }
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
        this.userLeaveHintListeners.add(userLeaveHintListener);
        if (this.activityPluginBinding != null) {
            this.activityPluginBinding.addOnUserLeaveHintListener(userLeaveHintListener);
        }
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    @NonNull
    public PluginRegistry.Registrar addViewDestroyListener(@NonNull PluginRegistry.ViewDestroyListener viewDestroyListener) {
        this.viewDestroyListeners.add(viewDestroyListener);
        return this;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.v(TAG, "Attached to FlutterEngine.");
        this.pluginBinding = flutterPluginBinding;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.v(TAG, "Detached from FlutterEngine.");
        for (PluginRegistry.ViewDestroyListener viewDestroyListener : this.viewDestroyListeners) {
            viewDestroyListener.onViewDestroy(null);
        }
        this.pluginBinding = null;
        this.activityPluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        Log.v(TAG, "Attached to an Activity.");
        this.activityPluginBinding = activityPluginBinding;
        addExistingListenersToActivityPluginBinding();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        Log.v(TAG, "Detached from an Activity for config changes.");
        this.activityPluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        Log.v(TAG, "Reconnected to an Activity after config changes.");
        this.activityPluginBinding = activityPluginBinding;
        addExistingListenersToActivityPluginBinding();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        Log.v(TAG, "Detached from an Activity.");
        this.activityPluginBinding = null;
    }

    private void addExistingListenersToActivityPluginBinding() {
        for (PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener : this.requestPermissionsResultListeners) {
            this.activityPluginBinding.addRequestPermissionsResultListener(requestPermissionsResultListener);
        }
        for (PluginRegistry.ActivityResultListener activityResultListener : this.activityResultListeners) {
            this.activityPluginBinding.addActivityResultListener(activityResultListener);
        }
        for (PluginRegistry.NewIntentListener newIntentListener : this.newIntentListeners) {
            this.activityPluginBinding.addOnNewIntentListener(newIntentListener);
        }
        for (PluginRegistry.UserLeaveHintListener userLeaveHintListener : this.userLeaveHintListeners) {
            this.activityPluginBinding.addOnUserLeaveHintListener(userLeaveHintListener);
        }
    }
}
