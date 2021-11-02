package com.qq.e.comm.pi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
/* loaded from: classes2.dex */
public interface SVSD {
    IBinder onBind(Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onDestroy();

    void onLowMemory();

    void onRebind(Intent intent);

    int onStartCommand(Intent intent, int i2, int i3);

    void onTaskRemoved(Intent intent);

    void onTrimMemory(int i2);

    boolean onUnbind(Intent intent);
}
