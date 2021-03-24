package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import io.flutter.app.FlutterActivityDelegate;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
/* loaded from: classes7.dex */
public class FlutterActivity extends Activity implements FlutterView.Provider, PluginRegistry, FlutterActivityDelegate.ViewFactory {
    public static final String TAG = "FlutterActivity";
    public final FlutterActivityDelegate delegate;
    public final FlutterActivityEvents eventDelegate;
    public final PluginRegistry pluginRegistry;
    public final FlutterView.Provider viewProvider;

    public FlutterActivity() {
        FlutterActivityDelegate flutterActivityDelegate = new FlutterActivityDelegate(this, this);
        this.delegate = flutterActivityDelegate;
        this.eventDelegate = flutterActivityDelegate;
        this.viewProvider = flutterActivityDelegate;
        this.pluginRegistry = flutterActivityDelegate;
    }

    @Override // io.flutter.app.FlutterActivityDelegate.ViewFactory
    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    @Override // io.flutter.app.FlutterActivityDelegate.ViewFactory
    public FlutterView createFlutterView(Context context) {
        return null;
    }

    @Override // io.flutter.view.FlutterView.Provider
    public FlutterView getFlutterView() {
        return this.viewProvider.getFlutterView();
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public final boolean hasPlugin(String str) {
        return this.pluginRegistry.hasPlugin(str);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eventDelegate.onActivityResult(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eventDelegate.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eventDelegate.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eventDelegate.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.eventDelegate.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.eventDelegate.onLowMemory();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        this.eventDelegate.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.eventDelegate.onPause();
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.eventDelegate.onPostResume();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.eventDelegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.eventDelegate.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.eventDelegate.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        this.eventDelegate.onStop();
        super.onStop();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        this.eventDelegate.onTrimMemory(i);
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        this.eventDelegate.onUserLeaveHint();
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public final PluginRegistry.Registrar registrarFor(String str) {
        return this.pluginRegistry.registrarFor(str);
    }

    @Override // io.flutter.app.FlutterActivityDelegate.ViewFactory
    public boolean retainFlutterNativeView() {
        return false;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public final <T> T valuePublishedByPlugin(String str) {
        return (T) this.pluginRegistry.valuePublishedByPlugin(str);
    }
}
