package com.idlefish.flutterboost.interfaces;

import android.app.Activity;
import com.idlefish.flutterboost.containers.FlutterSplashView;
import java.util.Map;
/* loaded from: classes5.dex */
public interface IFlutterViewContainer {
    void finishContainer(Map<String, Object> map);

    FlutterSplashView getBoostFlutterView();

    String getContainerUrl();

    Map<String, Object> getContainerUrlParams();

    Activity getContextActivity();

    void onContainerHidden();

    void onContainerShown();

    void setSwipeBackEnable(boolean z);

    void swipeBackControl(double d);
}
