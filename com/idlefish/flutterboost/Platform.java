package com.idlefish.flutterboost;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugin.common.PluginRegistry;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class Platform {
    public FlutterBoost.BoostLifecycleListener lifecycleListener;
    public FlutterBoost.BoostPluginsRegister pluginsRegister;

    public abstract Application getApplication();

    public abstract String initialRoute();

    public abstract boolean isDebug();

    public abstract void openContainer(Context context, String str, Map<String, Object> map, int i, Map<String, Object> map2);

    public abstract FlutterView.RenderMode renderMode();

    public abstract int whenEngineStart();

    public void closeContainer(IContainerRecord iContainerRecord, Map<String, Object> map, Map<String, Object> map2) {
        if (iContainerRecord != null) {
            iContainerRecord.getContainer().finishContainer(map);
        }
    }

    public void registerPlugins(PluginRegistry pluginRegistry) {
        if (this.pluginsRegister != null) {
            this.pluginsRegister.registerPlugins(pluginRegistry);
        } else {
            try {
                Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", PluginRegistry.class).invoke(null, pluginRegistry);
            } catch (Throwable th) {
                Log.i("flutterboost.platform", th.toString());
            }
        }
        if (this.lifecycleListener != null) {
            this.lifecycleListener.onPluginsRegistered();
        }
    }
}
