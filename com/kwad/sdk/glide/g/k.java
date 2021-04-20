package com.kwad.sdk.glide.g;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.b.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f35518a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f35519b = new char[64];

    /* renamed from: com.kwad.sdk.glide.g.k$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35520a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f35520a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35520a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35520a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35520a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35520a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int a(float f2) {
        return a(f2, 17);
    }

    public static int a(float f2, int i) {
        return b(Float.floatToIntBits(f2), i);
    }

    public static int a(int i, int i2, @Nullable Bitmap.Config config) {
        return i * i2 * a(config);
    }

    public static int a(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = AnonymousClass1.f35520a[config.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                return 2;
            }
            return i != 4 ? 4 : 8;
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
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int a(@Nullable Object obj, int i) {
        return b(obj == null ? 0 : obj.hashCode(), i);
    }

    public static int a(boolean z, int i) {
        return b(z ? 1 : 0, i);
    }

    @NonNull
    public static String a(@NonNull byte[] bArr) {
        String a2;
        synchronized (f35519b) {
            a2 = a(bArr, f35519b);
        }
        return a2;
    }

    @NonNull
    public static String a(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f35518a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
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
    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    public static void a() {
        if (!b()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean a(int i, int i2) {
        return b(i) && b(i2);
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int b(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean b(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean b(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj instanceof l ? ((l) obj).a(obj2) : obj.equals(obj2);
    }

    public static boolean c() {
        return !b();
    }
}
