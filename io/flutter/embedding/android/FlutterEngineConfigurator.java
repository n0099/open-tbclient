package io.flutter.embedding.android;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;
/* loaded from: classes12.dex */
public interface FlutterEngineConfigurator {
    void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine);

    void configureFlutterEngine(@NonNull FlutterEngine flutterEngine);
}
