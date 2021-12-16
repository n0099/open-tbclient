package io.flutter.embedding.engine.plugins.activity;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public interface ActivityAware {
    void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding);

    void onDetachedFromActivity();

    void onDetachedFromActivityForConfigChanges();

    void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding);
}
