package com.repackage;

import android.view.MotionEvent;
/* loaded from: classes6.dex */
public interface pp0 {
    void onBeforeSwitchToFull();

    void onBeforeSwitchToHalf();

    void onGestureActionEnd();

    void onGestureActionStart();

    boolean onGestureDoubleClick(MotionEvent motionEvent);

    void onPanelVisibilityChanged(boolean z);

    void onVideoSwitchToFull();

    void onVideoSwitchToHalf();
}
