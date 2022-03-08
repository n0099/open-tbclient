package com.davemorrissey.labs.subscaleview;

import android.graphics.PointF;
import android.view.MotionEvent;
/* loaded from: classes7.dex */
public interface IScrollDistanceCallBack {
    void onMove(float f2);

    void onMove(MotionEvent motionEvent, MotionEvent motionEvent2, PointF pointF, float f2, float f3);
}
