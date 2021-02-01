package com.thunder.livesdk.system;

import android.content.Context;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
/* loaded from: classes4.dex */
public class ThunderForeBackgroundListener implements ILifecycleCallbacks {
    private boolean mIsAppOnBackground = false;

    public ThunderForeBackgroundListener(Context context) {
    }

    public void init() {
        LifecycleEventDispatcher.registerCallback(this);
    }

    public void fini() {
        LifecycleEventDispatcher.removeCallback(this);
    }

    @Override // com.thunder.livesdk.system.ILifecycleCallbacks
    public void onForeground() {
        if (this.mIsAppOnBackground) {
            ThunderNative.enterForeground();
            this.mIsAppOnBackground = false;
        }
        ThunderLog.release(ThunderLog.kLogTagSdk, "APP background -> foreground, isAppOnBack:%b", Boolean.valueOf(this.mIsAppOnBackground));
    }

    @Override // com.thunder.livesdk.system.ILifecycleCallbacks
    public void onBackground() {
        if (!this.mIsAppOnBackground) {
            ThunderNative.enterBackground();
            this.mIsAppOnBackground = true;
        }
        ThunderLog.release(ThunderLog.kLogTagSdk, "APP foreground -> background, isAppOnBack:%b", Boolean.valueOf(this.mIsAppOnBackground));
    }
}
