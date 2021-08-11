package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
/* loaded from: classes10.dex */
public interface ActivityControlSurface {
    void attachToActivity(@NonNull Activity activity, @NonNull Lifecycle lifecycle);

    void detachFromActivity();

    void detachFromActivityForConfigChanges();

    boolean onActivityResult(int i2, int i3, @Nullable Intent intent);

    void onNewIntent(@NonNull Intent intent);

    boolean onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);

    void onRestoreInstanceState(@Nullable Bundle bundle);

    void onSaveInstanceState(@NonNull Bundle bundle);

    void onUserLeaveHint();
}
