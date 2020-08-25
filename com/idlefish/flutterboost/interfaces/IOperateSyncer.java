package com.idlefish.flutterboost.interfaces;

import android.content.Intent;
import java.util.Map;
/* loaded from: classes10.dex */
public interface IOperateSyncer {
    void onActivityResult(int i, int i2, Intent intent);

    void onAppear();

    void onBackPressed();

    void onContainerResult(int i, int i2, Map<String, Object> map);

    void onCreate();

    void onDestroy();

    void onDisappear();

    void onLowMemory();

    void onNewIntent(Intent intent);

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onTrimMemory(int i);
}
