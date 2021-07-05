package org.webrtc;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
/* loaded from: classes10.dex */
public interface EglBase {
    public static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final Object lock = new Object();
    public static final int[] CONFIG_PLAIN = {ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, 12352, 4, ZeusMonitorType.MONITOR_TYPE_AD_FILTER};
    public static final int[] CONFIG_RGBA = {ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, 8, 12352, 4, ZeusMonitorType.MONITOR_TYPE_AD_FILTER};
    public static final int[] CONFIG_PIXEL_BUFFER = {ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, 12352, 4, ZeusMonitorType.MONITOR_TYPE_MULTI_PERFORMANCE_TIMING, 1, ZeusMonitorType.MONITOR_TYPE_AD_FILTER};
    public static final int[] CONFIG_PIXEL_RGBA_BUFFER = {ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, 8, 12352, 4, ZeusMonitorType.MONITOR_TYPE_MULTI_PERFORMANCE_TIMING, 1, ZeusMonitorType.MONITOR_TYPE_AD_FILTER};
    public static final int[] CONFIG_RECORDABLE = {ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, 12352, 4, 12610, 1, ZeusMonitorType.MONITOR_TYPE_AD_FILTER};

    /* loaded from: classes10.dex */
    public interface Context {
        long getNativeEglContext();
    }

    void createDummyPbufferSurface();

    void createPbufferSurface(int i2, int i3);

    void createSurface(SurfaceTexture surfaceTexture);

    void createSurface(Surface surface);

    void detachCurrent();

    Context getEglBaseContext();

    boolean hasSurface();

    void makeCurrent();

    void release();

    void releaseSurface();

    int surfaceHeight();

    int surfaceWidth();

    void swapBuffers();

    void swapBuffers(long j);
}
