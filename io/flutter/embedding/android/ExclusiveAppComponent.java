package io.flutter.embedding.android;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface ExclusiveAppComponent<T> {
    void detachFromFlutterEngine();

    @NonNull
    T getAppComponent();
}
