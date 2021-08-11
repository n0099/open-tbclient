package com.google.ar.core;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f69857a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.c.a.g f69858b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Feature {
        public static final /* synthetic */ Feature[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Feature FRONT_CAMERA;
        public static final Feature SHARED_CAMERA;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(896004705, "Lcom/google/ar/core/Session$Feature;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(896004705, "Lcom/google/ar/core/Session$Feature;");
                    return;
                }
            }
            FRONT_CAMERA = new Feature("FRONT_CAMERA", 0, 1);
            Feature feature = new Feature("SHARED_CAMERA", 1, 1000);
            SHARED_CAMERA = feature;
            $VALUES = new Feature[]{FRONT_CAMERA, feature};
        }

        public Feature(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeCode = i3;
        }

        public static Feature valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Feature) Enum.valueOf(Feature.class, str) : (Feature) invokeL.objValue;
        }

        public static Feature[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Feature[]) $VALUES.clone() : (Feature[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f69859a;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ a[] f69860c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final int f69861b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2051806006, "Lcom/google/ar/core/Session$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2051806006, "Lcom/google/ar/core/Session$a;");
                    return;
                }
            }
            a aVar = new a("END_OF_LIST", 0, 0);
            f69859a = aVar;
            f69860c = new a[]{aVar};
        }

        public a(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f69861b = 0;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (a[]) f69860c.clone() : (a[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b A;
        public static final b B;
        public static final b C;
        public static final /* synthetic */ b[] D;

        /* renamed from: a  reason: collision with root package name */
        public static final b f69862a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f69863b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f69864c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f69865d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f69866e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f69867f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f69868g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f69869h;

        /* renamed from: i  reason: collision with root package name */
        public static final b f69870i;
        public static final b m;
        public static final b n;
        public static final b o;
        public static final b p;
        public static final b q;
        public static final b r;
        public static final b s;
        public static final b t;
        public static final b u;
        public static final b v;
        public static final b w;
        public static final b x;
        public static final b y;
        public static final b z;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final int f69871j;
        public final Class<? extends Exception> k;
        public final String l;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2051806037, "Lcom/google/ar/core/Session$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2051806037, "Lcom/google/ar/core/Session$b;");
                    return;
                }
            }
            f69862a = new b(com.alipay.security.mobile.module.http.model.c.f35984g, 0, 0, null);
            f69863b = new b("ERROR_INVALID_ARGUMENT", 1, -1, IllegalArgumentException.class);
            f69864c = new b("ERROR_FATAL", 2, -2, FatalException.class);
            m = new b("ERROR_SESSION_PAUSED", 3, -3, SessionPausedException.class);
            n = new b("ERROR_SESSION_NOT_PAUSED", 4, -4, SessionNotPausedException.class);
            o = new b("ERROR_NOT_TRACKING", 5, -5, NotTrackingException.class);
            p = new b("ERROR_TEXTURE_NOT_SET", 6, -6, TextureNotSetException.class);
            q = new b("ERROR_MISSING_GL_CONTEXT", 7, -7, MissingGlContextException.class);
            r = new b("ERROR_UNSUPPORTED_CONFIGURATION", 8, -8, UnsupportedConfigurationException.class);
            s = new b("ERROR_CAMERA_PERMISSION_NOT_GRANTED", 9, -9, SecurityException.class, "Camera permission is not granted");
            t = new b("ERROR_DEADLINE_EXCEEDED", 10, -10, DeadlineExceededException.class);
            f69865d = new b("ERROR_RESOURCE_EXHAUSTED", 11, -11, ResourceExhaustedException.class);
            u = new b("ERROR_NOT_YET_AVAILABLE", 12, -12, NotYetAvailableException.class);
            v = new b("ERROR_CAMERA_NOT_AVAILABLE", 13, -13, CameraNotAvailableException.class);
            w = new b("ERROR_ANCHOR_NOT_SUPPORTED_FOR_HOSTING", 14, -16, AnchorNotSupportedForHostingException.class);
            x = new b("ERROR_IMAGE_INSUFFICIENT_QUALITY", 15, -17, ImageInsufficientQualityException.class);
            y = new b("ERROR_DATA_INVALID_FORMAT", 16, -18, DataInvalidFormatException.class);
            z = new b("ERROR_DATA_UNSUPPORTED_VERSION", 17, -19, DataUnsupportedVersionException.class);
            A = new b("ERROR_ILLEGAL_STATE", 18, -20, IllegalStateException.class);
            B = new b("ERROR_CLOUD_ANCHORS_NOT_CONFIGURED", 19, -14, CloudAnchorsNotConfiguredException.class);
            C = new b("ERROR_INTERNET_PERMISSION_NOT_GRANTED", 20, -15, SecurityException.class, "Internet permission is not granted");
            f69866e = new b("UNAVAILABLE_ARCORE_NOT_INSTALLED", 21, -100, UnavailableArcoreNotInstalledException.class);
            f69867f = new b("UNAVAILABLE_DEVICE_NOT_COMPATIBLE", 22, -101, UnavailableDeviceNotCompatibleException.class);
            f69868g = new b("UNAVAILABLE_APK_TOO_OLD", 23, -103, UnavailableApkTooOldException.class);
            f69869h = new b("UNAVAILABLE_SDK_TOO_OLD", 24, -104, UnavailableSdkTooOldException.class);
            b bVar = new b("UNAVAILABLE_USER_DECLINED_INSTALLATION", 25, -105, UnavailableUserDeclinedInstallationException.class);
            f69870i = bVar;
            D = new b[]{f69862a, f69863b, f69864c, m, n, o, p, q, r, s, t, f69865d, u, v, w, x, y, z, A, B, C, f69866e, f69867f, f69868g, f69869h, bVar};
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(String str, int i2, int i3, Class cls) {
            this(str, i2, i3, cls, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), cls};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (Class) objArr2[3], (String) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (b[]) D.clone() : (b[]) invokeV.objValue;
        }

        public b(String str, int i2, int i3, Class cls, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), cls, str2};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f69871j = i3;
            this.k = cls;
            this.l = str2;
        }
    }

    public Session() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69858b = new c.i.c.a.g();
        this.f69857a = 0L;
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, byteBuffer)) == null) {
            if (byteBuffer == null) {
                return ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
            }
            return byteBuffer.order(ByteOrder.nativeOrder());
        }
        return (ByteBuffer) invokeL.objValue;
    }

    private native long[] nativeAcquireAllAnchors(long j2);

    private native void nativeCloseSession(long j2);

    private native void nativeConfigure(long j2, long j3);

    private native long nativeCreateAnchor(long j2, c.i.c.a.a aVar);

    public static native long nativeCreateSession(Context context);

    public static native long nativeCreateSessionForSharedCamera(Context context);

    public static native long nativeCreateSessionWithFeatures(Context context, int[] iArr);

    private native void nativeDestroySession(long j2);

    private native long nativeGetCameraConfig(long j2);

    private native void nativeGetConfig(long j2, long j3);

    private native long[] nativeGetSupportedCameraConfigs(long j2);

    private native long nativeHostCloudAnchor(long j2, long j3);

    private native boolean nativeIsSupported(long j2, long j3);

    private native void nativePause(long j2);

    private native long nativeResolveCloudAnchor(long j2, String str);

    private native void nativeResume(long j2);

    private native int nativeSetCameraConfig(long j2, long j3);

    private native void nativeSetCameraTextureName(long j2, int i2);

    private native void nativeSetDisplayGeometry(long j2, int i2, int i3, int i4);

    private native void nativeUpdate(long j2, long j3);

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.f69857a;
            if (j2 != 0) {
                nativeDestroySession(j2);
                this.f69857a = 0L;
            }
            super.finalize();
        }
    }

    public native long[] nativeAcquireAllTrackables(long j2, int i2);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f69872a;

        /* renamed from: c  reason: collision with root package name */
        public static final c f69873c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f69874d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f69875e;

        /* renamed from: f  reason: collision with root package name */
        public static final c f69876f;

        /* renamed from: g  reason: collision with root package name */
        public static final c f69877g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ c[] f69878i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final int f69879b;

        /* renamed from: h  reason: collision with root package name */
        public final Class<?> f69880h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2051806068, "Lcom/google/ar/core/Session$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2051806068, "Lcom/google/ar/core/Session$c;");
                    return;
                }
            }
            f69873c = new ad("BASE_TRACKABLE", 0, 1095893248, c.i.c.a.b.class);
            f69872a = new ae("UNKNOWN_TO_JAVA", 1, -1, null);
            f69874d = new af("PLANE", 2, 1095893249, Plane.class);
            f69875e = new ag("POINT", 3, 1095893250, Point.class);
            f69876f = new ah("AUGMENTED_IMAGE", 4, 1095893252, AugmentedImage.class);
            ai aiVar = new ai("FACE", 5, 1095893253, AugmentedFace.class);
            f69877g = aiVar;
            f69878i = new c[]{f69873c, f69872a, f69874d, f69875e, f69876f, aiVar};
        }

        public c(String str, int i2, int i3, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), cls};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f69879b = i3;
            this.f69880h = cls;
        }

        public static c a(Class<? extends c.i.c.a.b> cls) {
            InterceptResult invokeL;
            c[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
                for (c cVar : values()) {
                    Class<?> cls2 = cVar.f69880h;
                    if (cls2 != null && cls2.equals(cls)) {
                        return cVar;
                    }
                }
                return f69872a;
            }
            return (c) invokeL.objValue;
        }

        public static c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (c[]) f69878i.clone() : (c[]) invokeV.objValue;
        }

        public abstract c.i.c.a.b a(long j2, Session session);

        public /* synthetic */ c(String str, int i2, int i3, Class cls, byte b2) {
            this(str, i2, i3, cls);
        }
    }
}
