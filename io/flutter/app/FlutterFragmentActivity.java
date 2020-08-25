package io.flutter.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import io.flutter.app.FlutterActivityDelegate;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
/* loaded from: classes19.dex */
public class FlutterFragmentActivity extends FragmentActivity implements FlutterActivityDelegate.ViewFactory, PluginRegistry, FlutterView.Provider {
    private final FlutterActivityDelegate delegate = new FlutterActivityDelegate(this, this);
    private final FlutterActivityEvents eventDelegate = this.delegate;
    private final FlutterView.Provider viewProvider = this.delegate;
    private final PluginRegistry pluginRegistry = this.delegate;

    @Override // io.flutter.view.FlutterView.Provider
    public FlutterView getFlutterView() {
        return this.viewProvider.getFlutterView();
    }

    @Override // io.flutter.app.FlutterActivityDelegate.ViewFactory
    public FlutterView createFlutterView(Context context) {
        return null;
    }

    @Override // io.flutter.app.FlutterActivityDelegate.ViewFactory
    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    @Override // io.flutter.app.FlutterActivityDelegate.ViewFactory
    public boolean retainFlutterNativeView() {
        return false;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public final boolean hasPlugin(String str) {
        return this.pluginRegistry.hasPlugin(str);
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public final <T> T valuePublishedByPlugin(String str) {
        return (T) this.pluginRegistry.valuePublishedByPlugin(str);
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public final PluginRegistry.Registrar registrarFor(String str) {
        return this.pluginRegistry.registrarFor(str);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eventDelegate.onCreate(bundle);
    }

    protected void onDestroy() {
        this.eventDelegate.onDestroy();
        super.onDestroy();
    }

    public void onBackPressed() {
        if (!this.eventDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    protected void onStart() {
        super.onStart();
        this.eventDelegate.onStart();
    }

    protected void onStop() {
        this.eventDelegate.onStop();
        super.onStop();
    }

    protected void onPause() {
        super.onPause();
        this.eventDelegate.onPause();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.eventDelegate.onPostResume();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.eventDelegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!this.eventDelegate.onActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.eventDelegate.onNewIntent(intent);
    }

    public void onUserLeaveHint() {
        this.eventDelegate.onUserLeaveHint();
    }

    public void onTrimMemory(int i) {
        this.eventDelegate.onTrimMemory(i);
    }

    public void onLowMemory() {
        this.eventDelegate.onLowMemory();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eventDelegate.onConfigurationChanged(configuration);
    }
}
