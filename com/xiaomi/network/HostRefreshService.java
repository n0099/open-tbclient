package com.xiaomi.network;

import android.app.IntentService;
import android.content.Intent;
/* loaded from: classes2.dex */
public class HostRefreshService extends IntentService {
    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        HostManager.getInstance().refreshFallbacks();
    }
}
