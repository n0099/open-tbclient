package io.flutter.plugin.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
/* loaded from: classes10.dex */
public interface PluginRegistry {

    /* loaded from: classes10.dex */
    public interface ActivityResultListener {
        boolean onActivityResult(int i2, int i3, Intent intent);
    }

    /* loaded from: classes10.dex */
    public interface NewIntentListener {
        boolean onNewIntent(Intent intent);
    }

    /* loaded from: classes10.dex */
    public interface PluginRegistrantCallback {
        void registerWith(PluginRegistry pluginRegistry);
    }

    /* loaded from: classes10.dex */
    public interface Registrar {
        Context activeContext();

        Activity activity();

        Registrar addActivityResultListener(ActivityResultListener activityResultListener);

        Registrar addNewIntentListener(NewIntentListener newIntentListener);

        Registrar addRequestPermissionsResultListener(RequestPermissionsResultListener requestPermissionsResultListener);

        Registrar addUserLeaveHintListener(UserLeaveHintListener userLeaveHintListener);

        Registrar addViewDestroyListener(ViewDestroyListener viewDestroyListener);

        Context context();

        String lookupKeyForAsset(String str);

        String lookupKeyForAsset(String str, String str2);

        BinaryMessenger messenger();

        PlatformViewRegistry platformViewRegistry();

        Registrar publish(Object obj);

        TextureRegistry textures();

        FlutterView view();
    }

    /* loaded from: classes10.dex */
    public interface RequestPermissionsResultListener {
        boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    /* loaded from: classes10.dex */
    public interface UserLeaveHintListener {
        void onUserLeaveHint();
    }

    /* loaded from: classes10.dex */
    public interface ViewDestroyListener {
        boolean onViewDestroy(FlutterNativeView flutterNativeView);
    }

    boolean hasPlugin(String str);

    Registrar registrarFor(String str);

    <T> T valuePublishedByPlugin(String str);
}
