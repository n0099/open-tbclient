package com.repackage;

import android.view.MotionEvent;
/* loaded from: classes5.dex */
public interface cr0 {
    void onBeforeSwitchToFull();

    void onBeforeSwitchToHalf();

    void onGestureActionEnd();

    void onGestureActionStart();

    boolean onGestureDoubleClick(MotionEvent motionEvent);

    void onPanelVisibilityChanged(boolean z);

    void onVideoSwitchToFull();

    void onVideoSwitchToHalf();
}
