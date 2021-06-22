package com.google.ar.core;

import android.content.Context;
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
/* loaded from: classes6.dex */
public class Session {

    /* renamed from: b  reason: collision with root package name */
    public final d.g.b.a.g f30943b = new d.g.b.a.g();

    /* renamed from: a  reason: collision with root package name */
    public long f30942a = 0;

    /* loaded from: classes6.dex */
    public enum Feature {
        FRONT_CAMERA(1),
        SHARED_CAMERA(1000);
        
        public final int nativeCode;

        Feature(int i2) {
            this.nativeCode = i2;
        }
    }

    /* loaded from: classes6.dex */
    public enum a {
        END_OF_LIST(0);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f30946b = 0;

        a(int i2) {
        }
    }

    /* loaded from: classes6.dex */
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

        b(int i2, Class cls) {
            this(i2, cls, null);
        }

        b(int i2, Class cls, String str) {
            this.j = i2;
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

    private native long[] nativeAcquireAllAnchors(long j);

    private native void nativeCloseSession(long j);

    private native void nativeConfigure(long j, long j2);

    private native long nativeCreateAnchor(long j, d.g.b.a.a aVar);

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

    private native void nativeSetCameraTextureName(long j, int i2);

    private native void nativeSetDisplayGeometry(long j, int i2, int i3, int i4);

    private native void nativeUpdate(long j, long j2);

    public void finalize() {
        long j = this.f30942a;
        if (j != 0) {
            nativeDestroySession(j);
            this.f30942a = 0L;
        }
        super.finalize();
    }

    public native long[] nativeAcquireAllTrackables(long j, int i2);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes6.dex */
    public static abstract class c {

        /* renamed from: g  reason: collision with root package name */
        public static final c f30961g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ c[] f30962i;

        /* renamed from: b  reason: collision with root package name */
        public final int f30963b;

        /* renamed from: h  reason: collision with root package name */
        public final Class<?> f30964h;

        /* renamed from: c  reason: collision with root package name */
        public static final c f30957c = new ad("BASE_TRACKABLE", 0, 1095893248, d.g.b.a.b.class);

        /* renamed from: a  reason: collision with root package name */
        public static final c f30956a = new ae("UNKNOWN_TO_JAVA", 1, -1, null);

        /* renamed from: d  reason: collision with root package name */
        public static final c f30958d = new af("PLANE", 2, 1095893249, Plane.class);

        /* renamed from: e  reason: collision with root package name */
        public static final c f30959e = new ag("POINT", 3, 1095893250, Point.class);

        /* renamed from: f  reason: collision with root package name */
        public static final c f30960f = new ah("AUGMENTED_IMAGE", 4, 1095893252, AugmentedImage.class);

        static {
            ai aiVar = new ai("FACE", 5, 1095893253, AugmentedFace.class);
            f30961g = aiVar;
            f30962i = new c[]{f30957c, f30956a, f30958d, f30959e, f30960f, aiVar};
        }

        public c(String str, int i2, int i3, Class cls) {
            this.f30963b = i3;
            this.f30964h = cls;
        }

        public static c a(Class<? extends d.g.b.a.b> cls) {
            c[] values;
            for (c cVar : values()) {
                Class<?> cls2 = cVar.f30964h;
                if (cls2 != null && cls2.equals(cls)) {
                    return cVar;
                }
            }
            return f30956a;
        }

        public static c[] values() {
            return (c[]) f30962i.clone();
        }

        public abstract d.g.b.a.b a(long j, Session session);

        public /* synthetic */ c(String str, int i2, int i3, Class cls, byte b2) {
            this(str, i2, i3, cls);
        }
    }
}
