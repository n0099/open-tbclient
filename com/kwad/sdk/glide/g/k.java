package com.kwad.sdk.glide.g;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.glide.load.b.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
/* loaded from: classes7.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f37773a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f37774b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.glide.g.k$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37775a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1176312400, "Lcom/kwad/sdk/glide/g/k$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1176312400, "Lcom/kwad/sdk/glide/g/k$1;");
                    return;
                }
            }
            int[] iArr = new int[Bitmap.Config.values().length];
            f37775a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37775a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37775a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37775a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37775a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(906037533, "Lcom/kwad/sdk/glide/g/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(906037533, "Lcom/kwad/sdk/glide/g/k;");
                return;
            }
        }
        f37773a = "0123456789abcdef".toCharArray();
        f37774b = new char[64];
    }

    public static int a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f2)) == null) ? a(f2, 17) : invokeF.intValue;
    }

    public static int a(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) ? b(Float.floatToIntBits(f2), i2) : invokeCommon.intValue;
    }

    public static int a(int i2, int i3, @Nullable Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, config)) == null) ? i2 * i3 * a(config) : invokeIIL.intValue;
    }

    public static int a(@Nullable Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, config)) == null) {
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            int i2 = AnonymousClass1.f37775a[config.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    return 2;
                }
                return i2 != 4 ? 4 : 8;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    @TargetApi(19)
    public static int a(@NonNull Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bitmap)) == null) {
            if (!bitmap.isRecycled()) {
                if (Build.VERSION.SDK_INT >= 19) {
                    try {
                        return bitmap.getAllocationByteCount();
                    } catch (NullPointerException unused) {
                    }
                }
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
            throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + PreferencesUtil.LEFT_MOUNT + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
        return invokeL.intValue;
    }

    public static int a(@Nullable Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, obj, i2)) == null) {
            return b(obj == null ? 0 : obj.hashCode(), i2);
        }
        return invokeLI.intValue;
    }

    public static int a(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? b(z ? 1 : 0, i2) : invokeCommon.intValue;
    }

    @NonNull
    public static String a(@NonNull byte[] bArr) {
        InterceptResult invokeL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            synchronized (f37774b) {
                a2 = a(bArr, f37774b);
            }
            return a2;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static String a(@NonNull byte[] bArr, @NonNull char[] cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bArr, cArr)) == null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = bArr[i2] & 255;
                int i4 = i2 * 2;
                char[] cArr2 = f37773a;
                cArr[i4] = cArr2[i3 >>> 4];
                cArr[i4 + 1] = cArr2[i3 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public static <T> List<T> a(@NonNull Collection<T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, collection)) == null) {
            ArrayList arrayList = new ArrayList(collection.size());
            for (T t : collection) {
                if (t != null) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public static <T> Queue<T> a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? new ArrayDeque(i2) : (Queue) invokeI.objValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, null) == null) && !b()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65549, null, i2, i3)) == null) ? b(i2) && b(i3) : invokeII.booleanValue;
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, obj, obj2)) == null) ? obj == null ? obj2 == null : obj.equals(obj2) : invokeLL.booleanValue;
    }

    public static int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65551, null, i2, i3)) == null) ? (i3 * 31) + i2 : invokeII.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? Looper.myLooper() == Looper.getMainLooper() : invokeV.booleanValue;
    }

    public static boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) ? i2 > 0 || i2 == Integer.MIN_VALUE : invokeI.booleanValue;
    }

    public static boolean b(@Nullable Object obj, @Nullable Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, obj, obj2)) == null) ? obj == null ? obj2 == null : obj instanceof l ? ((l) obj).a(obj2) : obj.equals(obj2) : invokeLL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? !b() : invokeV.booleanValue;
    }
}
