package com.yy.mediaframework;

import com.yy.mediaframework.model.AbstractSurfaceInfo;
/* loaded from: classes4.dex */
public interface IYYVideoSurfaceInfoListener {
    public static final int EVENT_SURFACE_AVAIBLE = 1;
    public static final int EVENT_SURFACE_DESTROYED = 3;
    public static final int EVENT_SURFACE_SIZE_CHANGED = 2;

    void onSurfaceInfoEvent(int i, AbstractSurfaceInfo abstractSurfaceInfo);
}
