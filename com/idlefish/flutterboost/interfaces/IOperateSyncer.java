package com.idlefish.flutterboost.interfaces;

import android.content.Intent;
import java.util.Map;
/* loaded from: classes7.dex */
public interface IOperateSyncer {
    boolean isLocked();

    void onActivityResult(int i2, int i3, Intent intent);

    void onAppear();

    void onBackPressed();

    void onContainerResult(int i2, int i3, Map<String, Object> map);

    void onCreate();

    void onDestroy();

    void onDisappear();

    void onLowMemory();

    void onNewIntent(Intent intent);

    void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);

    void onTrimMemory(int i2);
}
