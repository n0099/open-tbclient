package com.idlefish.flutterboost;

import android.app.Application;
import android.content.Context;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import io.flutter.embedding.android.FlutterView;
import java.util.Map;
/* loaded from: classes18.dex */
public abstract class Platform {
    public FlutterBoost.BoostLifecycleListener lifecycleListener;

    public abstract String dartEntrypoint();

    public abstract Application getApplication();

    public abstract String initialRoute();

    public abstract boolean isDebug();

    public abstract void openContainer(Context context, String str, Map<String, Object> map, int i, Map<String, Object> map2);

    public abstract FlutterView.RenderMode renderMode();

    public abstract int whenEngineStart();

    public void closeContainer(IContainerRecord iContainerRecord, Map<String, Object> map, Map<String, Object> map2) {
        if (iContainerRecord != null) {
            iContainerRecord.getContainer().finishContainer(map);
        }
    }
}
