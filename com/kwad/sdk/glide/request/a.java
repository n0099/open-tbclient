package com.kwad.sdk.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy;
import com.kwad.sdk.glide.load.resource.bitmap.m;
import com.kwad.sdk.glide.load.resource.bitmap.o;
import com.kwad.sdk.glide.request.a;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f38322a;

    /* renamed from: b  reason: collision with root package name */
    public float f38323b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.h f38324c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Priority f38325d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public Drawable f38326e;

    /* renamed from: f  reason: collision with root package name */
    public int f38327f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public Drawable f38328g;

    /* renamed from: h  reason: collision with root package name */
    public int f38329h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38330i;
    public int j;
    public int k;
    @NonNull
    public com.kwad.sdk.glide.load.c l;
    public boolean m;
    public boolean n;
    @Nullable
    public Drawable o;
    public int p;
    @NonNull
    public com.kwad.sdk.glide.load.e q;
    @NonNull
    public Map<Class<?>, com.kwad.sdk.glide.load.h<?>> r;
    @NonNull
    public Class<?> s;
    public boolean t;
    @Nullable
    public Resources.Theme u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public a() {
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
        this.f38323b = 1.0f;
        this.f38324c = com.kwad.sdk.glide.load.engine.h.f38089e;
        this.f38325d = Priority.NORMAL;
        this.f38330i = true;
        this.j = -1;
        this.k = -1;
        this.l = com.kwad.sdk.glide.f.a.a();
        this.n = true;
        this.q = new com.kwad.sdk.glide.load.e();
        this.r = new com.kwad.sdk.glide.g.b();
        this.s = Object.class;
        this.y = true;
    }

    @NonNull
    private T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.t) {
                throw new IllegalStateException("You cannot modify locked T, consider clone()");
            }
            return b();
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    private T a(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, this, downsampleStrategy, hVar, z)) == null) {
            T b2 = z ? b(downsampleStrategy, hVar) : a(downsampleStrategy, hVar);
            b2.y = true;
            return b2;
        }
        return (T) invokeLLZ.objValue;
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) ? a(this.f38322a, i2) : invokeI.booleanValue;
    }

    public static boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65540, null, i2, i3)) == null) ? (i2 & i3) != 0 : invokeII.booleanValue;
    }

    private T b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this : (T) invokeV.objValue;
    }

    @NonNull
    private T c(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, downsampleStrategy, hVar)) == null) ? a(downsampleStrategy, hVar, false) : (T) invokeLL.objValue;
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : invokeV.intValue;
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? k.a(this.k, this.j) : invokeV.booleanValue;
    }

    public final int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.intValue;
    }

    public final float D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38323b : invokeV.floatValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.x : invokeV.booleanValue;
    }

    @NonNull
    @CheckResult
    public T a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2)) == null) {
            if (this.v) {
                return (T) clone().a(f2);
            }
            if (f2 < 0.0f || f2 > 1.0f) {
                throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
            }
            this.f38323b = f2;
            this.f38322a |= 2;
            return a();
        }
        return (T) invokeF.objValue;
    }

    @NonNull
    @CheckResult
    public T a(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, drawable)) == null) {
            if (this.v) {
                return (T) clone().a(drawable);
            }
            this.f38328g = drawable;
            int i2 = this.f38322a | 64;
            this.f38322a = i2;
            this.f38329h = 0;
            this.f38322a = i2 & (-129);
            return a();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T a(@NonNull Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, priority)) == null) {
            if (this.v) {
                return (T) clone().a(priority);
            }
            this.f38325d = (Priority) j.a(priority);
            this.f38322a |= 8;
            return a();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.kwad.sdk.glide.load.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cVar)) == null) {
            if (this.v) {
                return (T) clone().a(cVar);
            }
            this.l = (com.kwad.sdk.glide.load.c) j.a(cVar);
            this.f38322a |= 1024;
            return a();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public <Y> T a(@NonNull com.kwad.sdk.glide.load.d<Y> dVar, @NonNull Y y) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, dVar, y)) == null) {
            if (this.v) {
                return (T) clone().a(dVar, y);
            }
            j.a(dVar);
            j.a(y);
            this.q.a(dVar, y);
            return a();
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.kwad.sdk.glide.load.engine.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, hVar)) == null) {
            if (this.v) {
                return (T) clone().a(hVar);
            }
            this.f38324c = (com.kwad.sdk.glide.load.engine.h) j.a(hVar);
            this.f38322a |= 4;
            return a();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, hVar)) == null) ? a(hVar, true) : (T) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.kwad.sdk.glide.load.h<android.graphics.Bitmap> */
    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: com.kwad.sdk.glide.load.h<android.graphics.drawable.BitmapDrawable>, com.kwad.sdk.glide.load.h<Y> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T a(@NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, hVar, z)) == null) {
            if (this.v) {
                return (T) clone().a(hVar, z);
            }
            m mVar = new m(hVar, z);
            a(Bitmap.class, hVar, z);
            a(Drawable.class, mVar, z);
            a(BitmapDrawable.class, mVar.a(), z);
            a(com.kwad.sdk.glide.load.resource.d.c.class, new com.kwad.sdk.glide.load.resource.d.f(hVar), z);
            return a();
        }
        return (T) invokeLZ.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.kwad.sdk.glide.load.d<com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy>, com.kwad.sdk.glide.load.d<Y> */
    @NonNull
    @CheckResult
    public T a(@NonNull DownsampleStrategy downsampleStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, downsampleStrategy)) == null) ? a((com.kwad.sdk.glide.load.d<com.kwad.sdk.glide.load.d>) DownsampleStrategy.f38197h, (com.kwad.sdk.glide.load.d) j.a(downsampleStrategy)) : (T) invokeL.objValue;
    }

    @NonNull
    public final T a(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, downsampleStrategy, hVar)) == null) {
            if (this.v) {
                return (T) clone().a(downsampleStrategy, hVar);
            }
            a(downsampleStrategy);
            return a(hVar, false);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public T a(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, cls)) == null) {
            if (this.v) {
                return (T) clone().a(cls);
            }
            this.s = (Class) j.a(cls);
            this.f38322a |= 4096;
            return a();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public <Y> T a(@NonNull Class<Y> cls, @NonNull com.kwad.sdk.glide.load.h<Y> hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, cls, hVar)) == null) ? a((Class) cls, (com.kwad.sdk.glide.load.h) hVar, false) : (T) invokeLL.objValue;
    }

    @NonNull
    public <Y> T a(@NonNull Class<Y> cls, @NonNull com.kwad.sdk.glide.load.h<Y> hVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048596, this, cls, hVar, z)) == null) {
            if (this.v) {
                return (T) clone().a(cls, hVar, z);
            }
            j.a(cls);
            j.a(hVar);
            this.r.put(cls, hVar);
            int i2 = this.f38322a | 2048;
            this.f38322a = i2;
            this.n = true;
            int i3 = i2 | 65536;
            this.f38322a = i3;
            this.y = false;
            if (z) {
                this.f38322a = i3 | 131072;
                this.m = true;
            }
            return a();
        }
        return (T) invokeLLZ.objValue;
    }

    @NonNull
    @CheckResult
    public T a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            if (this.v) {
                return (T) clone().a(z);
            }
            this.z = z;
            this.f38322a |= 1048576;
            return a();
        }
        return (T) invokeZ.objValue;
    }

    @NonNull
    @CheckResult
    public T b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i2, i3)) == null) {
            if (this.v) {
                return (T) clone().b(i2, i3);
            }
            this.k = i2;
            this.j = i3;
            this.f38322a |= 512;
            return a();
        }
        return (T) invokeII.objValue;
    }

    @NonNull
    @CheckResult
    public T b(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, drawable)) == null) {
            if (this.v) {
                return (T) clone().b(drawable);
            }
            this.o = drawable;
            int i2 = this.f38322a | 8192;
            this.f38322a = i2;
            this.p = 0;
            this.f38322a = i2 & (-16385);
            return a();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T b(@NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, hVar)) == null) ? a(hVar, false) : (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public final T b(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, downsampleStrategy, hVar)) == null) {
            if (this.v) {
                return (T) clone().b(downsampleStrategy, hVar);
            }
            a(downsampleStrategy);
            return a(hVar);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public T b(@NonNull a<?> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, aVar)) == null) {
            if (this.v) {
                return (T) clone().b(aVar);
            }
            if (a(aVar.f38322a, 2)) {
                this.f38323b = aVar.f38323b;
            }
            if (a(aVar.f38322a, 262144)) {
                this.w = aVar.w;
            }
            if (a(aVar.f38322a, 1048576)) {
                this.z = aVar.z;
            }
            if (a(aVar.f38322a, 4)) {
                this.f38324c = aVar.f38324c;
            }
            if (a(aVar.f38322a, 8)) {
                this.f38325d = aVar.f38325d;
            }
            if (a(aVar.f38322a, 16)) {
                this.f38326e = aVar.f38326e;
                this.f38327f = 0;
                this.f38322a &= -33;
            }
            if (a(aVar.f38322a, 32)) {
                this.f38327f = aVar.f38327f;
                this.f38326e = null;
                this.f38322a &= -17;
            }
            if (a(aVar.f38322a, 64)) {
                this.f38328g = aVar.f38328g;
                this.f38329h = 0;
                this.f38322a &= -129;
            }
            if (a(aVar.f38322a, 128)) {
                this.f38329h = aVar.f38329h;
                this.f38328g = null;
                this.f38322a &= -65;
            }
            if (a(aVar.f38322a, 256)) {
                this.f38330i = aVar.f38330i;
            }
            if (a(aVar.f38322a, 512)) {
                this.k = aVar.k;
                this.j = aVar.j;
            }
            if (a(aVar.f38322a, 1024)) {
                this.l = aVar.l;
            }
            if (a(aVar.f38322a, 4096)) {
                this.s = aVar.s;
            }
            if (a(aVar.f38322a, 8192)) {
                this.o = aVar.o;
                this.p = 0;
                this.f38322a &= -16385;
            }
            if (a(aVar.f38322a, 16384)) {
                this.p = aVar.p;
                this.o = null;
                this.f38322a &= -8193;
            }
            if (a(aVar.f38322a, 32768)) {
                this.u = aVar.u;
            }
            if (a(aVar.f38322a, 65536)) {
                this.n = aVar.n;
            }
            if (a(aVar.f38322a, 131072)) {
                this.m = aVar.m;
            }
            if (a(aVar.f38322a, 2048)) {
                this.r.putAll(aVar.r);
                this.y = aVar.y;
            }
            if (a(aVar.f38322a, 524288)) {
                this.x = aVar.x;
            }
            if (!this.n) {
                this.r.clear();
                int i2 = this.f38322a & (-2049);
                this.f38322a = i2;
                this.m = false;
                this.f38322a = i2 & (-131073);
                this.y = true;
            }
            this.f38322a |= aVar.f38322a;
            this.q.a(aVar.q);
            return a();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            if (this.v) {
                return (T) clone().b(true);
            }
            this.f38330i = !z;
            this.f38322a |= 256;
            return a();
        }
        return (T) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    @CheckResult
    /* renamed from: c */
    public T clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            try {
                T t = (T) super.clone();
                com.kwad.sdk.glide.load.e eVar = new com.kwad.sdk.glide.load.e();
                t.q = eVar;
                eVar.a(this.q);
                com.kwad.sdk.glide.g.b bVar = new com.kwad.sdk.glide.g.b();
                t.r = bVar;
                bVar.putAll(this.r);
                t.t = false;
                t.v = false;
                return t;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T c(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, drawable)) == null) {
            if (this.v) {
                return (T) clone().c(drawable);
            }
            this.f38326e = drawable;
            int i2 = this.f38322a | 16;
            this.f38322a = i2;
            this.f38327f = 0;
            this.f38322a = i2 & (-33);
            return a();
        }
        return (T) invokeL.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? a(2048) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Float.compare(aVar.f38323b, this.f38323b) == 0 && this.f38327f == aVar.f38327f && k.a(this.f38326e, aVar.f38326e) && this.f38329h == aVar.f38329h && k.a(this.f38328g, aVar.f38328g) && this.p == aVar.p && k.a(this.o, aVar.o) && this.f38330i == aVar.f38330i && this.j == aVar.j && this.k == aVar.k && this.m == aVar.m && this.n == aVar.n && this.w == aVar.w && this.x == aVar.x && this.f38324c.equals(aVar.f38324c) && this.f38325d == aVar.f38325d && this.q.equals(aVar.q) && this.r.equals(aVar.r) && this.s.equals(aVar.s) && k.a(this.l, aVar.l) && k.a(this.u, aVar.u);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    @CheckResult
    public T f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? a(DownsampleStrategy.f38191b, new com.kwad.sdk.glide.load.resource.bitmap.g()) : (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? c(DownsampleStrategy.f38190a, new o()) : (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? c(DownsampleStrategy.f38194e, new com.kwad.sdk.glide.load.resource.bitmap.h()) : (T) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? k.a(this.u, k.a(this.l, k.a(this.s, k.a(this.r, k.a(this.q, k.a(this.f38325d, k.a(this.f38324c, k.a(this.x, k.a(this.w, k.a(this.n, k.a(this.m, k.b(this.k, k.b(this.j, k.a(this.f38330i, k.a(this.o, k.b(this.p, k.a(this.f38328g, k.b(this.f38329h, k.a(this.f38326e, k.b(this.f38327f, k.a(this.f38323b))))))))))))))))))))) : invokeV.intValue;
    }

    @NonNull
    public T i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            this.t = true;
            return b();
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    public T j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (!this.t || this.v) {
                this.v = true;
                return i();
            }
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    public final Map<Class<?>, com.kwad.sdk.glide.load.h<?>> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.r : (Map) invokeV.objValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.m : invokeV.booleanValue;
    }

    @NonNull
    public final com.kwad.sdk.glide.load.e m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.q : (com.kwad.sdk.glide.load.e) invokeV.objValue;
    }

    @NonNull
    public final Class<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.s : (Class) invokeV.objValue;
    }

    @NonNull
    public final com.kwad.sdk.glide.load.engine.h o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f38324c : (com.kwad.sdk.glide.load.engine.h) invokeV.objValue;
    }

    @Nullable
    public final Drawable p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f38326e : (Drawable) invokeV.objValue;
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f38327f : invokeV.intValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f38329h : invokeV.intValue;
    }

    @Nullable
    public final Drawable s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f38328g : (Drawable) invokeV.objValue;
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.p : invokeV.intValue;
    }

    @Nullable
    public final Drawable u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.o : (Drawable) invokeV.objValue;
    }

    @Nullable
    public final Resources.Theme v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.u : (Resources.Theme) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f38330i : invokeV.booleanValue;
    }

    @NonNull
    public final com.kwad.sdk.glide.load.c x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.l : (com.kwad.sdk.glide.load.c) invokeV.objValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? a(8) : invokeV.booleanValue;
    }

    @NonNull
    public final Priority z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f38325d : (Priority) invokeV.objValue;
    }
}
