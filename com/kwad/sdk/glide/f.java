package com.kwad.sdk.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.request.SingleRequest;
import com.kwad.sdk.glide.request.a.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class f<TranscodeType> extends com.kwad.sdk.glide.request.a<f<TranscodeType>> implements Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.request.f f37699a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f37700b;

    /* renamed from: c  reason: collision with root package name */
    public final g f37701c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<TranscodeType> f37702d;

    /* renamed from: e  reason: collision with root package name */
    public final c f37703e;

    /* renamed from: f  reason: collision with root package name */
    public final e f37704f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public h<?, ? super TranscodeType> f37705g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Object f37706h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public List<com.kwad.sdk.glide.request.e<TranscodeType>> f37707i;
    @Nullable
    public f<TranscodeType> j;
    @Nullable
    public f<TranscodeType> k;
    @Nullable
    public Float l;
    public boolean m;
    public boolean n;
    public boolean o;

    /* renamed from: com.kwad.sdk.glide.f$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37708a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f37709b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(905995373, "Lcom/kwad/sdk/glide/f$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(905995373, "Lcom/kwad/sdk/glide/f$1;");
                    return;
                }
            }
            int[] iArr = new int[Priority.values().length];
            f37709b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37709b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37709b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37709b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f37708a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37708a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37708a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f37708a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f37708a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f37708a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f37708a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f37708a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1341723418, "Lcom/kwad/sdk/glide/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1341723418, "Lcom/kwad/sdk/glide/f;");
                return;
            }
        }
        f37699a = new com.kwad.sdk.glide.request.f().a(com.kwad.sdk.glide.load.engine.h.f38087c).a(Priority.LOW).b(true);
    }

    @SuppressLint({"CheckResult"})
    public f(@NonNull c cVar, g gVar, Class<TranscodeType> cls, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, gVar, cls, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = true;
        this.f37703e = cVar;
        this.f37701c = gVar;
        this.f37702d = cls;
        this.f37700b = context;
        this.f37705g = gVar.b(cls);
        this.f37704f = cVar.e();
        a(gVar.h());
        a((com.kwad.sdk.glide.request.a<?>) gVar.i());
    }

    private <Y extends j<TranscodeType>> Y a(@NonNull Y y, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, y, eVar, aVar, executor)) == null) {
            com.kwad.sdk.glide.g.j.a(y);
            if (this.n) {
                com.kwad.sdk.glide.request.c b2 = b(y, eVar, aVar, executor);
                com.kwad.sdk.glide.request.c b3 = y.b();
                if (!b2.a(b3) || a(aVar, b3)) {
                    this.f37701c.a((j<?>) y);
                    y.a(b2);
                    this.f37701c.a(y, b2);
                    return y;
                }
                b2.h();
                if (!((com.kwad.sdk.glide.request.c) com.kwad.sdk.glide.g.j.a(b3)).c()) {
                    b3.a();
                }
                return y;
            }
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        return (Y) invokeLLLL.objValue;
    }

    private com.kwad.sdk.glide.request.c a(j<TranscodeType> jVar, com.kwad.sdk.glide.request.e<TranscodeType> eVar, com.kwad.sdk.glide.request.a<?> aVar, com.kwad.sdk.glide.request.d dVar, h<?, ? super TranscodeType> hVar, Priority priority, int i2, int i3, Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{jVar, eVar, aVar, dVar, hVar, priority, Integer.valueOf(i2), Integer.valueOf(i3), executor})) == null) {
            Context context = this.f37700b;
            e eVar2 = this.f37704f;
            return SingleRequest.a(context, eVar2, this.f37706h, this.f37702d, aVar, i2, i3, priority, jVar, eVar, this.f37707i, dVar, eVar2.c(), hVar.b(), executor);
        }
        return (com.kwad.sdk.glide.request.c) invokeCommon.objValue;
    }

    private com.kwad.sdk.glide.request.c a(j<TranscodeType> jVar, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, @Nullable com.kwad.sdk.glide.request.d dVar, h<?, ? super TranscodeType> hVar, Priority priority, int i2, int i3, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        InterceptResult invokeCommon;
        com.kwad.sdk.glide.request.b bVar;
        com.kwad.sdk.glide.request.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, this, new Object[]{jVar, eVar, dVar, hVar, priority, Integer.valueOf(i2), Integer.valueOf(i3), aVar, executor})) == null) {
            if (this.k != null) {
                bVar2 = new com.kwad.sdk.glide.request.b(dVar);
                bVar = bVar2;
            } else {
                bVar = null;
                bVar2 = dVar;
            }
            com.kwad.sdk.glide.request.c b2 = b(jVar, eVar, bVar2, hVar, priority, i2, i3, aVar, executor);
            if (bVar == null) {
                return b2;
            }
            int A = this.k.A();
            int C = this.k.C();
            if (k.a(i2, i3) && !this.k.B()) {
                A = aVar.A();
                C = aVar.C();
            }
            f<TranscodeType> fVar = this.k;
            com.kwad.sdk.glide.request.b bVar3 = bVar;
            bVar3.a(b2, fVar.a(jVar, eVar, bVar, fVar.f37705g, fVar.z(), A, C, this.k, executor));
            return bVar3;
        }
        return (com.kwad.sdk.glide.request.c) invokeCommon.objValue;
    }

    @SuppressLint({"CheckResult"})
    private void a(List<com.kwad.sdk.glide.request.e<Object>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list) == null) {
            for (com.kwad.sdk.glide.request.e<Object> eVar : list) {
                b((com.kwad.sdk.glide.request.e) eVar);
            }
        }
    }

    private boolean a(com.kwad.sdk.glide.request.a<?> aVar, com.kwad.sdk.glide.request.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, aVar, cVar)) == null) ? !aVar.w() && cVar.e_() : invokeLL.booleanValue;
    }

    @NonNull
    private Priority b(@NonNull Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, priority)) == null) {
            int i2 = AnonymousClass1.f37709b[priority.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3 || i2 == 4) {
                        return Priority.IMMEDIATE;
                    }
                    throw new IllegalArgumentException("unknown priority: " + z());
                }
                return Priority.HIGH;
            }
            return Priority.NORMAL;
        }
        return (Priority) invokeL.objValue;
    }

    @NonNull
    private f<TranscodeType> b(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, obj)) == null) {
            this.f37706h = obj;
            this.n = true;
            return this;
        }
        return (f) invokeL.objValue;
    }

    private com.kwad.sdk.glide.request.c b(j<TranscodeType> jVar, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, this, jVar, eVar, aVar, executor)) == null) ? a(jVar, eVar, (com.kwad.sdk.glide.request.d) null, this.f37705g, aVar.z(), aVar.A(), aVar.C(), aVar, executor) : (com.kwad.sdk.glide.request.c) invokeLLLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.kwad.sdk.glide.request.a] */
    private com.kwad.sdk.glide.request.c b(j<TranscodeType> jVar, com.kwad.sdk.glide.request.e<TranscodeType> eVar, @Nullable com.kwad.sdk.glide.request.d dVar, h<?, ? super TranscodeType> hVar, Priority priority, int i2, int i3, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{jVar, eVar, dVar, hVar, priority, Integer.valueOf(i2), Integer.valueOf(i3), aVar, executor})) == null) {
            f<TranscodeType> fVar = this.j;
            if (fVar == null) {
                if (this.l != null) {
                    com.kwad.sdk.glide.request.h hVar2 = new com.kwad.sdk.glide.request.h(dVar);
                    hVar2.a(a(jVar, eVar, aVar, hVar2, hVar, priority, i2, i3, executor), a(jVar, eVar, aVar.clone().a(this.l.floatValue()), hVar2, hVar, b(priority), i2, i3, executor));
                    return hVar2;
                }
                return a(jVar, eVar, aVar, dVar, hVar, priority, i2, i3, executor);
            } else if (this.o) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            } else {
                h<?, ? super TranscodeType> hVar3 = fVar.m ? hVar : fVar.f37705g;
                Priority z = this.j.y() ? this.j.z() : b(priority);
                int A = this.j.A();
                int C = this.j.C();
                if (k.a(i2, i3) && !this.j.B()) {
                    A = aVar.A();
                    C = aVar.C();
                }
                int i4 = A;
                int i5 = C;
                com.kwad.sdk.glide.request.h hVar4 = new com.kwad.sdk.glide.request.h(dVar);
                com.kwad.sdk.glide.request.c a2 = a(jVar, eVar, aVar, hVar4, hVar, priority, i2, i3, executor);
                this.o = true;
                f<TranscodeType> fVar2 = this.j;
                com.kwad.sdk.glide.request.c a3 = fVar2.a(jVar, eVar, hVar4, hVar3, z, i4, i5, fVar2, executor);
                this.o = false;
                hVar4.a(a2, a3);
                return hVar4;
            }
        }
        return (com.kwad.sdk.glide.request.c) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @CheckResult
    /* renamed from: a */
    public f<TranscodeType> clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            f<TranscodeType> fVar = (f) super.clone();
            fVar.f37705g = (h<?, ? super TranscodeType>) fVar.f37705g.clone();
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> a(@NonNull com.kwad.sdk.glide.request.a<?> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            com.kwad.sdk.glide.g.j.a(aVar);
            return (f) super.b(aVar);
        }
        return (f) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> a(@Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            this.f37707i = null;
            return b((com.kwad.sdk.glide.request.e) eVar);
        }
        return (f) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> a(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? b(obj) : (f) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? b(str) : (f) invokeL.objValue;
    }

    @NonNull
    public j<TranscodeType> a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) ? a((f<TranscodeType>) com.kwad.sdk.glide.request.a.g.a(this.f37701c, i2, i3)) : (j) invokeII.objValue;
    }

    @NonNull
    public <Y extends j<TranscodeType>> Y a(@NonNull Y y) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, y)) == null) ? (Y) a((f<TranscodeType>) y, (com.kwad.sdk.glide.request.e) null, com.kwad.sdk.glide.g.e.a()) : (Y) invokeL.objValue;
    }

    @NonNull
    public <Y extends j<TranscodeType>> Y a(@NonNull Y y, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, Executor executor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, y, eVar, executor)) == null) ? (Y) a(y, eVar, this, executor) : (Y) invokeLLL.objValue;
    }

    @NonNull
    public com.kwad.sdk.glide.request.a.k<ImageView, TranscodeType> a(@NonNull ImageView imageView) {
        InterceptResult invokeL;
        com.kwad.sdk.glide.request.a<?> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageView)) == null) {
            k.a();
            com.kwad.sdk.glide.g.j.a(imageView);
            if (!e() && d() && imageView.getScaleType() != null) {
                switch (AnonymousClass1.f37708a[imageView.getScaleType().ordinal()]) {
                    case 1:
                        aVar = c().f();
                        break;
                    case 2:
                    case 6:
                        aVar = c().h();
                        break;
                    case 3:
                    case 4:
                    case 5:
                        aVar = c().g();
                        break;
                }
                return (com.kwad.sdk.glide.request.a.k) a(this.f37704f.a(imageView, this.f37702d), null, aVar, com.kwad.sdk.glide.g.e.a());
            }
            aVar = this;
            return (com.kwad.sdk.glide.request.a.k) a(this.f37704f.a(imageView, this.f37702d), null, aVar, com.kwad.sdk.glide.g.e.a());
        }
        return (com.kwad.sdk.glide.request.a.k) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> b(@Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eVar)) == null) {
            if (eVar != null) {
                if (this.f37707i == null) {
                    this.f37707i = new ArrayList();
                }
                this.f37707i.add(eVar);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    @NonNull
    public j<TranscodeType> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? a(Integer.MIN_VALUE, Integer.MIN_VALUE) : (j) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    public /* synthetic */ com.kwad.sdk.glide.request.a b(@NonNull com.kwad.sdk.glide.request.a aVar) {
        return a((com.kwad.sdk.glide.request.a<?>) aVar);
    }
}
