package com.repackage;

import android.content.Context;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes5.dex */
public interface d2 extends Application {
    Window getApplicationWindow();

    Context getContext();

    y6<Runnable> getExecutedRunnables();

    Handler getHandler();

    p2 getInput();

    e8<d1> getLifecycleListeners();

    y6<Runnable> getRunnables();

    WindowManager getWindowManager();

    void useImmersiveMode(boolean z);
}
