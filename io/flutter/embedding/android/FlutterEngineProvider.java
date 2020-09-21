package io.flutter.embedding.android;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.FlutterEngine;
/* loaded from: classes8.dex */
public interface FlutterEngineProvider {
    @Nullable
    FlutterEngine provideFlutterEngine(@NonNull Context context);
}
