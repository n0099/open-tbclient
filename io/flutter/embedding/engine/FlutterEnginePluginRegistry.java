package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import io.flutter.Log;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.embedding.engine.plugins.service.ServiceAware;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.service.ServicePluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class FlutterEnginePluginRegistry implements PluginRegistry, ActivityControlSurface, BroadcastReceiverControlSurface, ContentProviderControlSurface, ServiceControlSurface {
    private static final String TAG = "FlutterEnginePluginRegistry";
    @Nullable
    private Activity activity;
    @Nullable
    private FlutterEngineActivityPluginBinding activityPluginBinding;
    @Nullable
    private BroadcastReceiver broadcastReceiver;
    @Nullable
    private FlutterEngineBroadcastReceiverPluginBinding broadcastReceiverPluginBinding;
    @Nullable
    private ContentProvider contentProvider;
    @Nullable
    private FlutterEngineContentProviderPluginBinding contentProviderPluginBinding;
    @NonNull
    private final FlutterEngine flutterEngine;
    @NonNull
    private final FlutterPlugin.FlutterPluginBinding pluginBinding;
    @Nullable
    private Service service;
    @Nullable
    private FlutterEngineServicePluginBinding servicePluginBinding;
    @NonNull
    private final Map<Class<? extends FlutterPlugin>, FlutterPlugin> plugins = new HashMap();
    @NonNull
    private final Map<Class<? extends FlutterPlugin>, ActivityAware> activityAwarePlugins = new HashMap();
    private boolean isWaitingForActivityReattachment = false;
    @NonNull
    private final Map<Class<? extends FlutterPlugin>, ServiceAware> serviceAwarePlugins = new HashMap();
    @NonNull
    private final Map<Class<? extends FlutterPlugin>, BroadcastReceiverAware> broadcastReceiverAwarePlugins = new HashMap();
    @NonNull
    private final Map<Class<? extends FlutterPlugin>, ContentProviderAware> contentProviderAwarePlugins = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlutterEnginePluginRegistry(@NonNull Context context, @NonNull FlutterEngine flutterEngine, @NonNull FlutterLoader flutterLoader) {
        this.flutterEngine = flutterEngine;
        this.pluginBinding = new FlutterPlugin.FlutterPluginBinding(context, flutterEngine, flutterEngine.getDartExecutor(), flutterEngine.getRenderer(), flutterEngine.getPlatformViewsController().getRegistry(), new DefaultFlutterAssets(flutterLoader));
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        detachFromAndroidComponent();
        removeAll();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.FlutterPlugin>, io.flutter.embedding.engine.plugins.FlutterPlugin> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.FlutterPlugin>, io.flutter.embedding.engine.plugins.service.ServiceAware> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.FlutterPlugin>, io.flutter.embedding.engine.plugins.activity.ActivityAware> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.FlutterPlugin>, io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.FlutterPlugin>, io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.flutter.embedding.engine.FlutterEnginePluginRegistry */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public void add(@NonNull FlutterPlugin flutterPlugin) {
        if (has(flutterPlugin.getClass())) {
            Log.w(TAG, "Attempted to register plugin (" + flutterPlugin + ") but it was already registered with this FlutterEngine (" + this.flutterEngine + ").");
            return;
        }
        Log.v(TAG, "Adding plugin: " + flutterPlugin);
        this.plugins.put(flutterPlugin.getClass(), flutterPlugin);
        flutterPlugin.onAttachedToEngine(this.pluginBinding);
        if (flutterPlugin instanceof ActivityAware) {
            ActivityAware activityAware = (ActivityAware) flutterPlugin;
            this.activityAwarePlugins.put(flutterPlugin.getClass(), activityAware);
            if (isAttachedToActivity()) {
                activityAware.onAttachedToActivity(this.activityPluginBinding);
            }
        }
        if (flutterPlugin instanceof ServiceAware) {
            ServiceAware serviceAware = (ServiceAware) flutterPlugin;
            this.serviceAwarePlugins.put(flutterPlugin.getClass(), serviceAware);
            if (isAttachedToService()) {
                serviceAware.onAttachedToService(this.servicePluginBinding);
            }
        }
        if (flutterPlugin instanceof BroadcastReceiverAware) {
            BroadcastReceiverAware broadcastReceiverAware = (BroadcastReceiverAware) flutterPlugin;
            this.broadcastReceiverAwarePlugins.put(flutterPlugin.getClass(), broadcastReceiverAware);
            if (isAttachedToBroadcastReceiver()) {
                broadcastReceiverAware.onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
            }
        }
        if (flutterPlugin instanceof ContentProviderAware) {
            ContentProviderAware contentProviderAware = (ContentProviderAware) flutterPlugin;
            this.contentProviderAwarePlugins.put(flutterPlugin.getClass(), contentProviderAware);
            if (isAttachedToContentProvider()) {
                contentProviderAware.onAttachedToContentProvider(this.contentProviderPluginBinding);
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public void add(@NonNull Set<FlutterPlugin> set) {
        for (FlutterPlugin flutterPlugin : set) {
            add(flutterPlugin);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public boolean has(@NonNull Class<? extends FlutterPlugin> cls) {
        return this.plugins.containsKey(cls);
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public FlutterPlugin get(@NonNull Class<? extends FlutterPlugin> cls) {
        return this.plugins.get(cls);
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public void remove(@NonNull Class<? extends FlutterPlugin> cls) {
        FlutterPlugin flutterPlugin = this.plugins.get(cls);
        if (flutterPlugin != null) {
            Log.v(TAG, "Removing plugin: " + flutterPlugin);
            if (flutterPlugin instanceof ActivityAware) {
                if (isAttachedToActivity()) {
                    ((ActivityAware) flutterPlugin).onDetachedFromActivity();
                }
                this.activityAwarePlugins.remove(cls);
            }
            if (flutterPlugin instanceof ServiceAware) {
                if (isAttachedToService()) {
                    ((ServiceAware) flutterPlugin).onDetachedFromService();
                }
                this.serviceAwarePlugins.remove(cls);
            }
            if (flutterPlugin instanceof BroadcastReceiverAware) {
                if (isAttachedToBroadcastReceiver()) {
                    ((BroadcastReceiverAware) flutterPlugin).onDetachedFromBroadcastReceiver();
                }
                this.broadcastReceiverAwarePlugins.remove(cls);
            }
            if (flutterPlugin instanceof ContentProviderAware) {
                if (isAttachedToContentProvider()) {
                    ((ContentProviderAware) flutterPlugin).onDetachedFromContentProvider();
                }
                this.contentProviderAwarePlugins.remove(cls);
            }
            flutterPlugin.onDetachedFromEngine(this.pluginBinding);
            this.plugins.remove(cls);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public void remove(@NonNull Set<Class<? extends FlutterPlugin>> set) {
        for (Class<? extends FlutterPlugin> cls : set) {
            remove(cls);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public void removeAll() {
        remove(new HashSet(this.plugins.keySet()));
        this.plugins.clear();
    }

    private void detachFromAndroidComponent() {
        if (isAttachedToActivity()) {
            detachFromActivity();
        } else if (isAttachedToService()) {
            detachFromService();
        } else if (isAttachedToBroadcastReceiver()) {
            detachFromBroadcastReceiver();
        } else if (isAttachedToContentProvider()) {
            detachFromContentProvider();
        }
    }

    private boolean isAttachedToActivity() {
        return this.activity != null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void attachToActivity(@NonNull Activity activity, @NonNull Lifecycle lifecycle) {
        Log.v(TAG, "Attaching to an Activity: " + activity + "." + (this.isWaitingForActivityReattachment ? " This is after a config change." : ""));
        detachFromAndroidComponent();
        this.activity = activity;
        this.activityPluginBinding = new FlutterEngineActivityPluginBinding(activity, lifecycle);
        this.flutterEngine.getPlatformViewsController().attach(activity, this.flutterEngine.getRenderer(), this.flutterEngine.getDartExecutor());
        for (ActivityAware activityAware : this.activityAwarePlugins.values()) {
            if (this.isWaitingForActivityReattachment) {
                activityAware.onReattachedToActivityForConfigChanges(this.activityPluginBinding);
            } else {
                activityAware.onAttachedToActivity(this.activityPluginBinding);
            }
        }
        this.isWaitingForActivityReattachment = false;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void detachFromActivityForConfigChanges() {
        if (isAttachedToActivity()) {
            Log.v(TAG, "Detaching from an Activity for config changes: " + this.activity);
            this.isWaitingForActivityReattachment = true;
            for (ActivityAware activityAware : this.activityAwarePlugins.values()) {
                activityAware.onDetachedFromActivityForConfigChanges();
            }
            this.flutterEngine.getPlatformViewsController().detach();
            this.activity = null;
            this.activityPluginBinding = null;
            return;
        }
        Log.e(TAG, "Attempted to detach plugins from an Activity when no Activity was attached.");
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void detachFromActivity() {
        if (isAttachedToActivity()) {
            Log.v(TAG, "Detaching from an Activity: " + this.activity);
            for (ActivityAware activityAware : this.activityAwarePlugins.values()) {
                activityAware.onDetachedFromActivity();
            }
            this.flutterEngine.getPlatformViewsController().detach();
            this.activity = null;
            this.activityPluginBinding = null;
            return;
        }
        Log.e(TAG, "Attempted to detach plugins from an Activity when no Activity was attached.");
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Log.v(TAG, "Forwarding onRequestPermissionsResult() to plugins.");
        if (isAttachedToActivity()) {
            return this.activityPluginBinding.onRequestPermissionsResult(i, strArr, iArr);
        }
        Log.e(TAG, "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
        return false;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public boolean onActivityResult(int i, int i2, @Nullable Intent intent) {
        Log.v(TAG, "Forwarding onActivityResult() to plugins.");
        if (isAttachedToActivity()) {
            return this.activityPluginBinding.onActivityResult(i, i2, intent);
        }
        Log.e(TAG, "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
        return false;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void onNewIntent(@NonNull Intent intent) {
        Log.v(TAG, "Forwarding onNewIntent() to plugins.");
        if (isAttachedToActivity()) {
            this.activityPluginBinding.onNewIntent(intent);
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void onUserLeaveHint() {
        Log.v(TAG, "Forwarding onUserLeaveHint() to plugins.");
        if (isAttachedToActivity()) {
            this.activityPluginBinding.onUserLeaveHint();
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Log.v(TAG, "Forwarding onSaveInstanceState() to plugins.");
        if (isAttachedToActivity()) {
            this.activityPluginBinding.onSaveInstanceState(bundle);
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void onRestoreInstanceState(@Nullable Bundle bundle) {
        Log.v(TAG, "Forwarding onRestoreInstanceState() to plugins.");
        if (isAttachedToActivity()) {
            this.activityPluginBinding.onRestoreInstanceState(bundle);
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
        }
    }

    private boolean isAttachedToService() {
        return this.service != null;
    }

    @Override // io.flutter.embedding.engine.plugins.service.ServiceControlSurface
    public void attachToService(@NonNull Service service, @Nullable Lifecycle lifecycle, boolean z) {
        Log.v(TAG, "Attaching to a Service: " + service);
        detachFromAndroidComponent();
        this.service = service;
        this.servicePluginBinding = new FlutterEngineServicePluginBinding(service, lifecycle);
        for (ServiceAware serviceAware : this.serviceAwarePlugins.values()) {
            serviceAware.onAttachedToService(this.servicePluginBinding);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.service.ServiceControlSurface
    public void detachFromService() {
        if (isAttachedToService()) {
            Log.v(TAG, "Detaching from a Service: " + this.service);
            for (ServiceAware serviceAware : this.serviceAwarePlugins.values()) {
                serviceAware.onDetachedFromService();
            }
            this.service = null;
            this.servicePluginBinding = null;
            return;
        }
        Log.e(TAG, "Attempted to detach plugins from a Service when no Service was attached.");
    }

    @Override // io.flutter.embedding.engine.plugins.service.ServiceControlSurface
    public void onMoveToForeground() {
        if (isAttachedToService()) {
            Log.v(TAG, "Attached Service moved to foreground.");
            this.servicePluginBinding.onMoveToForeground();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.service.ServiceControlSurface
    public void onMoveToBackground() {
        if (isAttachedToService()) {
            Log.v(TAG, "Attached Service moved to background.");
            this.servicePluginBinding.onMoveToBackground();
        }
    }

    private boolean isAttachedToBroadcastReceiver() {
        return this.broadcastReceiver != null;
    }

    @Override // io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface
    public void attachToBroadcastReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull Lifecycle lifecycle) {
        Log.v(TAG, "Attaching to BroadcastReceiver: " + broadcastReceiver);
        detachFromAndroidComponent();
        this.broadcastReceiver = broadcastReceiver;
        this.broadcastReceiverPluginBinding = new FlutterEngineBroadcastReceiverPluginBinding(broadcastReceiver);
        for (BroadcastReceiverAware broadcastReceiverAware : this.broadcastReceiverAwarePlugins.values()) {
            broadcastReceiverAware.onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface
    public void detachFromBroadcastReceiver() {
        if (isAttachedToBroadcastReceiver()) {
            Log.v(TAG, "Detaching from BroadcastReceiver: " + this.broadcastReceiver);
            for (BroadcastReceiverAware broadcastReceiverAware : this.broadcastReceiverAwarePlugins.values()) {
                broadcastReceiverAware.onDetachedFromBroadcastReceiver();
            }
            return;
        }
        Log.e(TAG, "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
    }

    private boolean isAttachedToContentProvider() {
        return this.contentProvider != null;
    }

    @Override // io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface
    public void attachToContentProvider(@NonNull ContentProvider contentProvider, @NonNull Lifecycle lifecycle) {
        Log.v(TAG, "Attaching to ContentProvider: " + contentProvider);
        detachFromAndroidComponent();
        this.contentProvider = contentProvider;
        this.contentProviderPluginBinding = new FlutterEngineContentProviderPluginBinding(contentProvider);
        for (ContentProviderAware contentProviderAware : this.contentProviderAwarePlugins.values()) {
            contentProviderAware.onAttachedToContentProvider(this.contentProviderPluginBinding);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface
    public void detachFromContentProvider() {
        if (isAttachedToContentProvider()) {
            Log.v(TAG, "Detaching from ContentProvider: " + this.contentProvider);
            for (ContentProviderAware contentProviderAware : this.contentProviderAwarePlugins.values()) {
                contentProviderAware.onDetachedFromContentProvider();
            }
            return;
        }
        Log.e(TAG, "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
    }

    /* loaded from: classes8.dex */
    private static class DefaultFlutterAssets implements FlutterPlugin.FlutterAssets {
        final FlutterLoader flutterLoader;

        private DefaultFlutterAssets(@NonNull FlutterLoader flutterLoader) {
            this.flutterLoader = flutterLoader;
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets
        public String getAssetFilePathByName(@NonNull String str) {
            return this.flutterLoader.getLookupKeyForAsset(str);
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets
        public String getAssetFilePathByName(@NonNull String str, @NonNull String str2) {
            return this.flutterLoader.getLookupKeyForAsset(str, str2);
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets
        public String getAssetFilePathBySubpath(@NonNull String str) {
            return this.flutterLoader.getLookupKeyForAsset(str);
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets
        public String getAssetFilePathBySubpath(@NonNull String str, @NonNull String str2) {
            return this.flutterLoader.getLookupKeyForAsset(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class FlutterEngineActivityPluginBinding implements ActivityPluginBinding {
        @NonNull
        private final Activity activity;
        @NonNull
        private final HiddenLifecycleReference hiddenLifecycleReference;
        @NonNull
        private final Set<PluginRegistry.RequestPermissionsResultListener> onRequestPermissionsResultListeners = new HashSet();
        @NonNull
        private final Set<PluginRegistry.ActivityResultListener> onActivityResultListeners = new HashSet();
        @NonNull
        private final Set<PluginRegistry.NewIntentListener> onNewIntentListeners = new HashSet();
        @NonNull
        private final Set<PluginRegistry.UserLeaveHintListener> onUserLeaveHintListeners = new HashSet();
        @NonNull
        private final Set<ActivityPluginBinding.OnSaveInstanceStateListener> onSaveInstanceStateListeners = new HashSet();

        public FlutterEngineActivityPluginBinding(@NonNull Activity activity, @NonNull Lifecycle lifecycle) {
            this.activity = activity;
            this.hiddenLifecycleReference = new HiddenLifecycleReference(lifecycle);
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        @NonNull
        public Activity getActivity() {
            return this.activity;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        @NonNull
        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void addRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            this.onRequestPermissionsResultListeners.add(requestPermissionsResultListener);
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void removeRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            this.onRequestPermissionsResultListeners.remove(requestPermissionsResultListener);
        }

        boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            boolean z = false;
            for (PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener : this.onRequestPermissionsResultListeners) {
                z = requestPermissionsResultListener.onRequestPermissionsResult(i, strArr, iArr) || z;
            }
            return z;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void addActivityResultListener(@NonNull PluginRegistry.ActivityResultListener activityResultListener) {
            this.onActivityResultListeners.add(activityResultListener);
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void removeActivityResultListener(@NonNull PluginRegistry.ActivityResultListener activityResultListener) {
            this.onActivityResultListeners.remove(activityResultListener);
        }

        boolean onActivityResult(int i, int i2, @Nullable Intent intent) {
            boolean z = false;
            for (PluginRegistry.ActivityResultListener activityResultListener : this.onActivityResultListeners) {
                z = activityResultListener.onActivityResult(i, i2, intent) || z;
            }
            return z;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void addOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener newIntentListener) {
            this.onNewIntentListeners.add(newIntentListener);
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void removeOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener newIntentListener) {
            this.onNewIntentListeners.remove(newIntentListener);
        }

        void onNewIntent(@Nullable Intent intent) {
            for (PluginRegistry.NewIntentListener newIntentListener : this.onNewIntentListeners) {
                newIntentListener.onNewIntent(intent);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void addOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            this.onUserLeaveHintListeners.add(userLeaveHintListener);
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void removeOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            this.onUserLeaveHintListeners.remove(userLeaveHintListener);
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void addOnSaveStateListener(@NonNull ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            this.onSaveInstanceStateListeners.add(onSaveInstanceStateListener);
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void removeOnSaveStateListener(@NonNull ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            this.onSaveInstanceStateListeners.remove(onSaveInstanceStateListener);
        }

        void onUserLeaveHint() {
            for (PluginRegistry.UserLeaveHintListener userLeaveHintListener : this.onUserLeaveHintListeners) {
                userLeaveHintListener.onUserLeaveHint();
            }
        }

        void onSaveInstanceState(@NonNull Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener : this.onSaveInstanceStateListeners) {
                onSaveInstanceStateListener.onSaveInstanceState(bundle);
            }
        }

        void onRestoreInstanceState(@Nullable Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener : this.onSaveInstanceStateListeners) {
                onSaveInstanceStateListener.onRestoreInstanceState(bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class FlutterEngineServicePluginBinding implements ServicePluginBinding {
        @Nullable
        private final HiddenLifecycleReference hiddenLifecycleReference;
        @NonNull
        private final Set<ServiceAware.OnModeChangeListener> onModeChangeListeners = new HashSet();
        @NonNull
        private final Service service;

        FlutterEngineServicePluginBinding(@NonNull Service service, @Nullable Lifecycle lifecycle) {
            this.service = service;
            this.hiddenLifecycleReference = lifecycle != null ? new HiddenLifecycleReference(lifecycle) : null;
        }

        @Override // io.flutter.embedding.engine.plugins.service.ServicePluginBinding
        @NonNull
        public Service getService() {
            return this.service;
        }

        @Override // io.flutter.embedding.engine.plugins.service.ServicePluginBinding
        @Nullable
        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        @Override // io.flutter.embedding.engine.plugins.service.ServicePluginBinding
        public void addOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener onModeChangeListener) {
            this.onModeChangeListeners.add(onModeChangeListener);
        }

        @Override // io.flutter.embedding.engine.plugins.service.ServicePluginBinding
        public void removeOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener onModeChangeListener) {
            this.onModeChangeListeners.remove(onModeChangeListener);
        }

        void onMoveToForeground() {
            for (ServiceAware.OnModeChangeListener onModeChangeListener : this.onModeChangeListeners) {
                onModeChangeListener.onMoveToForeground();
            }
        }

        void onMoveToBackground() {
            for (ServiceAware.OnModeChangeListener onModeChangeListener : this.onModeChangeListeners) {
                onModeChangeListener.onMoveToBackground();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class FlutterEngineBroadcastReceiverPluginBinding implements BroadcastReceiverPluginBinding {
        @NonNull
        private final BroadcastReceiver broadcastReceiver;

        FlutterEngineBroadcastReceiverPluginBinding(@NonNull BroadcastReceiver broadcastReceiver) {
            this.broadcastReceiver = broadcastReceiver;
        }

        @Override // io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding
        @NonNull
        public BroadcastReceiver getBroadcastReceiver() {
            return this.broadcastReceiver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class FlutterEngineContentProviderPluginBinding implements ContentProviderPluginBinding {
        @NonNull
        private final ContentProvider contentProvider;

        FlutterEngineContentProviderPluginBinding(@NonNull ContentProvider contentProvider) {
            this.contentProvider = contentProvider;
        }

        @Override // io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding
        @NonNull
        public ContentProvider getContentProvider() {
            return this.contentProvider;
        }
    }
}
