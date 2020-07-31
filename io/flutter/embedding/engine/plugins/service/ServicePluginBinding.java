package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.service.ServiceAware;
/* loaded from: classes12.dex */
public interface ServicePluginBinding {
    void addOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener onModeChangeListener);

    @Nullable
    Object getLifecycle();

    @NonNull
    Service getService();

    void removeOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener onModeChangeListener);
}
