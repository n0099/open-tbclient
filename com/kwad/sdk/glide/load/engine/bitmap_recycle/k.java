package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class k implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Bitmap.Config f38041a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final l f38042b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Bitmap.Config> f38043c;

    /* renamed from: d  reason: collision with root package name */
    public final long f38044d;

    /* renamed from: e  reason: collision with root package name */
    public final a f38045e;

    /* renamed from: f  reason: collision with root package name */
    public long f38046f;

    /* renamed from: g  reason: collision with root package name */
    public long f38047g;

    /* renamed from: h  reason: collision with root package name */
    public int f38048h;

    /* renamed from: i  reason: collision with root package name */
    public int f38049i;
    public int j;
    public int k;

    /* loaded from: classes7.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* loaded from: classes7.dex */
    public static final class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.k.a
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
            }
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.k.a
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-761476077, "Lcom/kwad/sdk/glide/load/engine/bitmap_recycle/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-761476077, "Lcom/kwad/sdk/glide/load/engine/bitmap_recycle/k;");
                return;
            }
        }
        f38041a = Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(long j) {
        this(j, f(), g());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (l) objArr2[1], (Set) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public k(long j, l lVar, Set<Bitmap.Config> set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), lVar, set};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38044d = j;
        this.f38046f = j;
        this.f38042b = lVar;
        this.f38043c = set;
        this.f38045e = new b();
    }

    private synchronized void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, this, j) == null) {
            synchronized (this) {
                while (this.f38047g > j) {
                    Bitmap a2 = this.f38042b.a();
                    if (a2 == null) {
                        if (Log.isLoggable(LruBitmapPool.TAG, 5)) {
                            Log.w(LruBitmapPool.TAG, "Size mismatch, resetting");
                            e();
                        }
                        this.f38047g = 0L;
                        return;
                    }
                    this.f38045e.b(a2);
                    this.f38047g -= this.f38042b.c(a2);
                    this.k++;
                    if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                        Log.d(LruBitmapPool.TAG, "Evicting bitmap=" + this.f38042b.b(a2));
                    }
                    d();
                    a2.recycle();
                }
            }
        }
    }

    @TargetApi(26)
    public static void a(Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, null, config) == null) && Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    public static void b(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bitmap) == null) {
            bitmap.setHasAlpha(true);
            c(bitmap);
        }
    }

    @NonNull
    public static Bitmap c(int i2, int i3, @Nullable Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3, config)) == null) {
            if (config == null) {
                config = f38041a;
            }
            return Bitmap.createBitmap(i2, i3, config);
        }
        return (Bitmap) invokeIIL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            a(this.f38046f);
        }
    }

    @TargetApi(19)
    public static void c(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, bitmap) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        bitmap.setPremultiplied(true);
    }

    @Nullable
    private synchronized Bitmap d(int i2, int i3, @Nullable Bitmap.Config config) {
        InterceptResult invokeIIL;
        Bitmap a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65545, this, i2, i3, config)) == null) {
            synchronized (this) {
                a(config);
                a2 = this.f38042b.a(i2, i3, config != null ? config : f38041a);
                if (a2 == null) {
                    if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                        Log.d(LruBitmapPool.TAG, "Missing bitmap=" + this.f38042b.b(i2, i3, config));
                    }
                    this.f38049i++;
                } else {
                    this.f38048h++;
                    this.f38047g -= this.f38042b.c(a2);
                    this.f38045e.b(a2);
                    b(a2);
                }
                if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
                    Log.v(LruBitmapPool.TAG, "Get bitmap=" + this.f38042b.b(i2, i3, config));
                }
                d();
            }
            return a2;
        }
        return (Bitmap) invokeIIL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && Log.isLoggable(LruBitmapPool.TAG, 2)) {
            e();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            Log.v(LruBitmapPool.TAG, "Hits=" + this.f38048h + ", misses=" + this.f38049i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.f38047g + ", maxSize=" + this.f38046f + "\nStrategy=" + this.f38042b);
        }
    }

    public static l f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? Build.VERSION.SDK_INT >= 19 ? new n() : new c() : (l) invokeV.objValue;
    }

    @TargetApi(26)
    public static Set<Bitmap.Config> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
            if (Build.VERSION.SDK_INT >= 19) {
                hashSet.add(null);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                hashSet.remove(Bitmap.Config.HARDWARE);
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return (Set) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, config)) == null) {
            Bitmap d2 = d(i2, i3, config);
            if (d2 != null) {
                d2.eraseColor(0);
                return d2;
            }
            return c(i2, i3, config);
        }
        return (Bitmap) invokeIIL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                Log.d(LruBitmapPool.TAG, "clearMemory");
            }
            a(0L);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                Log.d(LruBitmapPool.TAG, "trimMemory, level=" + i2);
            }
            if (i2 >= 40) {
                a();
            } else if (i2 >= 20 || i2 == 15) {
                a(b() / 2);
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public synchronized void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
            synchronized (this) {
                try {
                    if (bitmap == null) {
                        throw new NullPointerException("Bitmap must not be null");
                    }
                    if (bitmap.isRecycled()) {
                        throw new IllegalStateException("Cannot pool recycled bitmap");
                    }
                    if (bitmap.isMutable() && this.f38042b.c(bitmap) <= this.f38046f && this.f38043c.contains(bitmap.getConfig())) {
                        int c2 = this.f38042b.c(bitmap);
                        this.f38042b.a(bitmap);
                        this.f38045e.a(bitmap);
                        this.j++;
                        this.f38047g += c2;
                        if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
                            Log.v(LruBitmapPool.TAG, "Put bitmap in pool=" + this.f38042b.b(bitmap));
                        }
                        d();
                        c();
                        return;
                    }
                    if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
                        Log.v(LruBitmapPool.TAG, "Reject bitmap from pool, bitmap: " + this.f38042b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f38043c.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38046f : invokeV.longValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i2, i3, config)) == null) {
            Bitmap d2 = d(i2, i3, config);
            return d2 == null ? c(i2, i3, config) : d2;
        }
        return (Bitmap) invokeIIL.objValue;
    }
}
