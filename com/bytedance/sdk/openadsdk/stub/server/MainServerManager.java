package com.bytedance.sdk.openadsdk.stub.server;

import android.app.Application;
import android.content.Context;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.a.b;
import com.bytedance.sdk.openadsdk.api.plugin.e;
/* loaded from: classes4.dex */
public class MainServerManager extends AbsServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        Context applicationContext = getContext().getApplicationContext();
        TTAppContextHolder.setContext(applicationContext);
        e.a(applicationContext);
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(b.a().b());
        }
        return super.onCreate();
    }
}
