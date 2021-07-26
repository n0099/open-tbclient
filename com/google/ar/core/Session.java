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
/* loaded from: classes6.dex */
public class Session {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f33154a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.c.a.g f33155b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f33156a;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ a[] f33157c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final int f33158b;

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
            f33156a = aVar;
            f33157c = new a[]{aVar};
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
            this.f33158b = 0;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (a[]) f33157c.clone() : (a[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b A;
        public static final b B;
        public static final b C;
        public static final /* synthetic */ b[] D;

        /* renamed from: a  reason: collision with root package name */
        public static final b f33159a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f33160b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f33161c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f33162d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f33163e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f33164f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f33165g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f33166h;

        /* renamed from: i  reason: collision with root package name */
        public static final b f33167i;
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
        public final int j;
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
            f33159a = new b(com.alipay.security.mobile.module.http.model.c.f2136g, 0, 0, null);
            f33160b = new b("ERROR_INVALID_ARGUMENT", 1, -1, IllegalArgumentException.class);
            f33161c = new b("ERROR_FATAL", 2, -2, FatalException.class);
            m = new b("ERROR_SESSION_PAUSED", 3, -3, SessionPausedException.class);
            n = new b("ERROR_SESSION_NOT_PAUSED", 4, -4, SessionNotPausedException.class);
            o = new b("ERROR_NOT_TRACKING", 5, -5, NotTrackingException.class);
            p = new b("ERROR_TEXTURE_NOT_SET", 6, -6, TextureNotSetException.class);
            q = new b("ERROR_MISSING_GL_CONTEXT", 7, -7, MissingGlContextException.class);
            r = new b("ERROR_UNSUPPORTED_CONFIGURATION", 8, -8, UnsupportedConfigurationException.class);
            s = new b("ERROR_CAMERA_PERMISSION_NOT_GRANTED", 9, -9, SecurityException.class, "Camera permission is not granted");
            t = new b("ERROR_DEADLINE_EXCEEDED", 10, -10, DeadlineExceededException.class);
            f33162d = new b("ERROR_RESOURCE_EXHAUSTED", 11, -11, ResourceExhaustedException.class);
            u = new b("ERROR_NOT_YET_AVAILABLE", 12, -12, NotYetAvailableException.class);
            v = new b("ERROR_CAMERA_NOT_AVAILABLE", 13, -13, CameraNotAvailableException.class);
            w = new b("ERROR_ANCHOR_NOT_SUPPORTED_FOR_HOSTING", 14, -16, AnchorNotSupportedForHostingException.class);
            x = new b("ERROR_IMAGE_INSUFFICIENT_QUALITY", 15, -17, ImageInsufficientQualityException.class);
            y = new b("ERROR_DATA_INVALID_FORMAT", 16, -18, DataInvalidFormatException.class);
            z = new b("ERROR_DATA_UNSUPPORTED_VERSION", 17, -19, DataUnsupportedVersionException.class);
            A = new b("ERROR_ILLEGAL_STATE", 18, -20, IllegalStateException.class);
            B = new b("ERROR_CLOUD_ANCHORS_NOT_CONFIGURED", 19, -14, CloudAnchorsNotConfiguredException.class);
            C = new b("ERROR_INTERNET_PERMISSION_NOT_GRANTED", 20, -15, SecurityException.class, "Internet permission is not granted");
            f33163e = new b("UNAVAILABLE_ARCORE_NOT_INSTALLED", 21, -100, UnavailableArcoreNotInstalledException.class);
            f33164f = new b("UNAVAILABLE_DEVICE_NOT_COMPATIBLE", 22, -101, UnavailableDeviceNotCompatibleException.class);
            f33165g = new b("UNAVAILABLE_APK_TOO_OLD", 23, -103, UnavailableApkTooOldException.class);
            f33166h = new b("UNAVAILABLE_SDK_TOO_OLD", 24, -104, UnavailableSdkTooOldException.class);
            b bVar = new b("UNAVAILABLE_USER_DECLINED_INSTALLATION", 25, -105, UnavailableUserDeclinedInstallationException.class);
            f33167i = bVar;
            D = new b[]{f33159a, f33160b, f33161c, m, n, o, p, q, r, s, t, f33162d, u, v, w, x, y, z, A, B, C, f33163e, f33164f, f33165g, f33166h, bVar};
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
            this.j = i3;
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
        this.f33155b = new d.f.c.a.g();
        this.f33154a = 0L;
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

    private native long[] nativeAcquireAllAnchors(long j);

    private native void nativeCloseSession(long j);

    private native void nativeConfigure(long j, long j2);

    private native long nativeCreateAnchor(long j, d.f.c.a.a aVar);

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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j = this.f33154a;
            if (j != 0) {
                nativeDestroySession(j);
                this.f33154a = 0L;
            }
            super.finalize();
        }
    }

    public native long[] nativeAcquireAllTrackables(long j, int i2);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f33168a;

        /* renamed from: c  reason: collision with root package name */
        public static final c f33169c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f33170d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f33171e;

        /* renamed from: f  reason: collision with root package name */
        public static final c f33172f;

        /* renamed from: g  reason: collision with root package name */
        public static final c f33173g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ c[] f33174i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final int f33175b;

        /* renamed from: h  reason: collision with root package name */
        public final Class<?> f33176h;

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
            f33169c = new ad("BASE_TRACKABLE", 0, 1095893248, d.f.c.a.b.class);
            f33168a = new ae("UNKNOWN_TO_JAVA", 1, -1, null);
            f33170d = new af("PLANE", 2, 1095893249, Plane.class);
            f33171e = new ag("POINT", 3, 1095893250, Point.class);
            f33172f = new ah("AUGMENTED_IMAGE", 4, 1095893252, AugmentedImage.class);
            ai aiVar = new ai("FACE", 5, 1095893253, AugmentedFace.class);
            f33173g = aiVar;
            f33174i = new c[]{f33169c, f33168a, f33170d, f33171e, f33172f, aiVar};
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
            this.f33175b = i3;
            this.f33176h = cls;
        }

        public static c a(Class<? extends d.f.c.a.b> cls) {
            InterceptResult invokeL;
            c[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
                for (c cVar : values()) {
                    Class<?> cls2 = cVar.f33176h;
                    if (cls2 != null && cls2.equals(cls)) {
                        return cVar;
                    }
                }
                return f33168a;
            }
            return (c) invokeL.objValue;
        }

        public static c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (c[]) f33174i.clone() : (c[]) invokeV.objValue;
        }

        public abstract d.f.c.a.b a(long j, Session session);

        public /* synthetic */ c(String str, int i2, int i3, Class cls, byte b2) {
            this(str, i2, i3, cls);
        }
    }
}
