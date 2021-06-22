package com.kwad.sdk.glide.g;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.kwad.sdk.glide.load.b.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
/* loaded from: classes7.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f36010a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f36011b = new char[64];

    /* renamed from: com.kwad.sdk.glide.g.k$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36012a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f36012a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36012a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36012a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36012a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36012a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int a(float f2) {
        return a(f2, 17);
    }

    public static int a(float f2, int i2) {
        return b(Float.floatToIntBits(f2), i2);
    }

    public static int a(int i2, int i3, @Nullable Bitmap.Config config) {
        return i2 * i3 * a(config);
    }

    public static int a(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = AnonymousClass1.f36012a[config.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return 2;
            }
            return i2 != 4 ? 4 : 8;
        }
        return 1;
    }

    @TargetApi(19)
    public static int a(@NonNull Bitmap bitmap) {
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

    public static int a(@Nullable Object obj, int i2) {
        return b(obj == null ? 0 : obj.hashCode(), i2);
    }

    public static int a(boolean z, int i2) {
        return b(z ? 1 : 0, i2);
    }

    @NonNull
    public static String a(@NonNull byte[] bArr) {
        String a2;
        synchronized (f36011b) {
            a2 = a(bArr, f36011b);
        }
        return a2;
    }

    @NonNull
    public static String a(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = f36010a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    public static <T> List<T> a(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NonNull
    public static <T> Queue<T> a(int i2) {
        return new ArrayDeque(i2);
    }

    public static void a() {
        if (!b()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean a(int i2, int i3) {
        return b(i2) && b(i3);
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int b(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean b(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean b(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj instanceof l ? ((l) obj).a(obj2) : obj.equals(obj2);
    }

    public static boolean c() {
        return !b();
    }
}
