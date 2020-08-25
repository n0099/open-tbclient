package com.google.ar.core;

import android.content.Context;
import com.baidu.sapi2.result.OneKeyLoginResult;
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
/* loaded from: classes11.dex */
public class Session {
    long nBU;
    final q nCj;

    /* loaded from: classes11.dex */
    enum a {
        END_OF_LIST(0);
        
        final int b = 0;

        a(int i) {
        }
    }

    /* loaded from: classes11.dex */
    enum b {
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
        UNAVAILABLE_SDK_TOO_OLD(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS, UnavailableSdkTooOldException.class),
        UNAVAILABLE_USER_DECLINED_INSTALLATION(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, UnavailableUserDeclinedInstallationException.class);
        
        final int j;
        final Class<? extends Exception> k;
        final String l;

        b(int i, Class cls) {
            this(i, cls, null);
        }

        b(int i, Class cls, String str) {
            this.j = i;
            this.k = cls;
            this.l = str;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes11.dex */
    static abstract class c {
        final int b;
        private final Class<?> h;
        private static final c c = new ad("BASE_TRACKABLE", 0, 1095893248, k.class);
        public static final c a = new ae("UNKNOWN_TO_JAVA", 1, -1, null);
        private static final c d = new af("PLANE", 2, 1095893249, Plane.class);
        private static final c e = new ag("POINT", 3, 1095893250, Point.class);
        private static final c f = new ah("AUGMENTED_IMAGE", 4, 1095893252, AugmentedImage.class);
        private static final c g = new ai("FACE", 5, 1095893253, AugmentedFace.class);
        private static final /* synthetic */ c[] i = {c, a, d, e, f, g};

        public static c[] values() {
            return (c[]) i.clone();
        }

        public abstract k a(long j, Session session);

        private c(String str, int i2, int i3, Class cls) {
            this.b = i3;
            this.h = cls;
        }

        public static c a(Class<? extends k> cls) {
            c[] values;
            for (c cVar : values()) {
                if (cVar.h != null && cVar.h.equals(cls)) {
                    return cVar;
                }
            }
            return a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(String str, int i2, int i3, Class cls, byte b) {
            this(str, i2, i3, cls);
        }
    }

    private native long[] nativeAcquireAllAnchors(long j);

    private native void nativeCloseSession(long j);

    private native void nativeConfigure(long j, long j2);

    private native long nativeCreateAnchor(long j, h hVar);

    private static native long nativeCreateSession(Context context);

    private static native long nativeCreateSessionForSharedCamera(Context context);

    private static native long nativeCreateSessionWithFeatures(Context context, int[] iArr) throws UnavailableArcoreNotInstalledException, UnavailableApkTooOldException, UnavailableSdkTooOldException, UnavailableDeviceNotCompatibleException;

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

    native long[] nativeAcquireAllTrackables(long j, int i);

    /* loaded from: classes11.dex */
    public enum Feature {
        FRONT_CAMERA(1),
        SHARED_CAMERA(1000);
        
        final int nativeCode;

        Feature(int i) {
            this.nativeCode = i;
        }
    }

    protected void finalize() throws Throwable {
        if (this.nBU != 0) {
            nativeDestroySession(this.nBU);
            this.nBU = 0L;
        }
        super.finalize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer q(ByteBuffer byteBuffer) {
        return byteBuffer == null ? ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder()) : byteBuffer.order(ByteOrder.nativeOrder());
    }
}
