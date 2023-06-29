package com.google.ar.core;

import android.content.Context;
import com.baidu.tieba.idb;
import com.baidu.tieba.ndb;
import com.google.ar.core.exceptions.AnchorNotSupportedForHostingException;
import com.google.ar.core.exceptions.CameraNotAvailableException;
import com.google.ar.core.exceptions.CloudAnchorsNotConfiguredException;
import com.google.ar.core.exceptions.DataInvalidFormatException;
import com.google.ar.core.exceptions.DataUnsupportedVersionException;
import com.google.ar.core.exceptions.DeadlineExceededException;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.ImageInsufficientQualityException;
import com.google.ar.core.exceptions.MissingGlContextException;
import com.google.ar.core.exceptions.NotTrackingException;
import com.google.ar.core.exceptions.NotYetAvailableException;
import com.google.ar.core.exceptions.ResourceExhaustedException;
import com.google.ar.core.exceptions.SessionNotPausedException;
import com.google.ar.core.exceptions.SessionPausedException;
import com.google.ar.core.exceptions.TextureNotSetException;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import com.google.ar.core.exceptions.UnsupportedConfigurationException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes9.dex */
public class Session {
    public final Object b = new Object();
    public final ndb c = new ndb();
    public long a = 0;

    private native long[] nativeAcquireAllAnchors(long j);

    private native void nativeCloseSession(long j);

    private native void nativeConfigure(long j, long j2);

    private native long nativeCreateAnchor(long j, Pose pose);

    public static native long nativeCreateSession(Context context);

    public static native long nativeCreateSessionForSharedCamera(Context context);

    public static native long nativeCreateSessionWithFeatures(Context context, int[] iArr);

    private native void nativeDestroySession(long j);

    private native long nativeGetCameraConfig(long j);

    private native void nativeGetConfig(long j, long j2);

    private native long[] nativeGetSupportedCameraConfigs(long j);

    private native long nativeHostCloudAnchor(long j, long j2);

    private native boolean nativeIsSupported(long j, long j2);

    private native void nativePause(long j);

    private native long nativeResolveCloudAnchor(long j, String str);

    private native void nativeResume(long j);

    private native int nativeSetCameraConfig(long j, long j2);

    private native void nativeSetCameraTextureName(long j, int i);

    private native void nativeSetDisplayGeometry(long j, int i, int i2, int i3);

    private native void nativeUpdate(long j, long j2);

    public native long[] nativeAcquireAllTrackables(long j, int i);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes9.dex */
    public static abstract class c {
        public static final c g;
        public static final /* synthetic */ c[] i;
        public final int b;
        public final Class<?> h;
        public static final c c = new ad("BASE_TRACKABLE", 0, 1095893248, idb.class);
        public static final c a = new ae("UNKNOWN_TO_JAVA", 1, -1, null);
        public static final c d = new af("PLANE", 2, 1095893249, Plane.class);
        public static final c e = new ag("POINT", 3, 1095893250, Point.class);
        public static final c f = new ah("AUGMENTED_IMAGE", 4, 1095893252, AugmentedImage.class);

        public abstract idb a(long j, Session session);

        static {
            ai aiVar = new ai("FACE", 5, 1095893253, AugmentedFace.class);
            g = aiVar;
            i = new c[]{c, a, d, e, f, aiVar};
        }

        public c(String str, int i2, int i3, Class cls) {
            this.b = i3;
            this.h = cls;
        }

        public /* synthetic */ c(String str, int i2, int i3, Class cls, byte b) {
            this(str, i2, i3, cls);
        }

        public static c a(Class<? extends idb> cls) {
            c[] values;
            for (c cVar : values()) {
                Class<?> cls2 = cVar.h;
                if (cls2 != null && cls2.equals(cls)) {
                    return cVar;
                }
            }
            return a;
        }

        public static c[] values() {
            return (c[]) i.clone();
        }
    }

    public void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeDestroySession(j);
            this.a = 0L;
        }
        super.finalize();
    }

    public Frame update() {
        Frame frame;
        synchronized (this.b) {
            frame = new Frame(this);
            nativeUpdate(this.a, frame.c);
        }
        return frame;
    }

    /* loaded from: classes9.dex */
    public enum Feature {
        FRONT_CAMERA(1),
        SHARED_CAMERA(1000);
        
        public final int nativeCode;

        Feature(int i) {
            this.nativeCode = i;
        }
    }

    /* loaded from: classes9.dex */
    public enum a {
        END_OF_LIST(0);
        
        public final int b = 0;

        a(int i) {
        }
    }

    /* loaded from: classes9.dex */
    public enum b {
        SUCCESS(0, null),
        ERROR_INVALID_ARGUMENT(-1, IllegalArgumentException.class),
        ERROR_FATAL(-2, FatalException.class),
        ERROR_SESSION_PAUSED(-3, SessionPausedException.class),
        ERROR_SESSION_NOT_PAUSED(-4, SessionNotPausedException.class),
        ERROR_NOT_TRACKING(-5, NotTrackingException.class),
        ERROR_TEXTURE_NOT_SET(-6, TextureNotSetException.class),
        ERROR_MISSING_GL_CONTEXT(-7, MissingGlContextException.class),
        ERROR_UNSUPPORTED_CONFIGURATION(-8, UnsupportedConfigurationException.class),
        ERROR_CAMERA_PERMISSION_NOT_GRANTED(-9, SecurityException.class, "Camera permission is not granted"),
        ERROR_DEADLINE_EXCEEDED(-10, DeadlineExceededException.class),
        ERROR_RESOURCE_EXHAUSTED(-11, ResourceExhaustedException.class),
        ERROR_NOT_YET_AVAILABLE(-12, NotYetAvailableException.class),
        ERROR_CAMERA_NOT_AVAILABLE(-13, CameraNotAvailableException.class),
        ERROR_ANCHOR_NOT_SUPPORTED_FOR_HOSTING(-16, AnchorNotSupportedForHostingException.class),
        ERROR_IMAGE_INSUFFICIENT_QUALITY(-17, ImageInsufficientQualityException.class),
        ERROR_DATA_INVALID_FORMAT(-18, DataInvalidFormatException.class),
        ERROR_DATA_UNSUPPORTED_VERSION(-19, DataUnsupportedVersionException.class),
        ERROR_ILLEGAL_STATE(-20, IllegalStateException.class),
        ERROR_CLOUD_ANCHORS_NOT_CONFIGURED(-14, CloudAnchorsNotConfiguredException.class),
        ERROR_INTERNET_PERMISSION_NOT_GRANTED(-15, SecurityException.class, "Internet permission is not granted"),
        UNAVAILABLE_ARCORE_NOT_INSTALLED(-100, UnavailableArcoreNotInstalledException.class),
        UNAVAILABLE_DEVICE_NOT_COMPATIBLE(-101, UnavailableDeviceNotCompatibleException.class),
        UNAVAILABLE_APK_TOO_OLD(-103, UnavailableApkTooOldException.class),
        UNAVAILABLE_SDK_TOO_OLD(-104, UnavailableSdkTooOldException.class),
        UNAVAILABLE_USER_DECLINED_INSTALLATION(-105, UnavailableUserDeclinedInstallationException.class);
        
        public final int j;
        public final Class<? extends Exception> k;
        public final String l;

        b(int i, Class cls) {
            this(i, cls, null);
        }

        b(int i, Class cls, String str) {
            this.j = i;
            this.k = cls;
            this.l = str;
        }
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
        }
        return byteBuffer.order(ByteOrder.nativeOrder());
    }
}
