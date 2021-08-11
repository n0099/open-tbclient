package io.flutter.embedding.engine.plugins.service;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public interface ServiceAware {

    /* loaded from: classes10.dex */
    public interface OnModeChangeListener {
        void onMoveToBackground();

        void onMoveToForeground();
    }

    void onAttachedToService(@NonNull ServicePluginBinding servicePluginBinding);

    void onDetachedFromService();
}
