package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.g f38282a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.b.a f38283b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f38284c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f38285d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38286e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38287f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38288g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38289h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.glide.f<Bitmap> f38290i;
    public a j;
    public boolean k;
    public a l;
    public Bitmap m;
    public com.kwad.sdk.glide.load.h<Bitmap> n;
    public a o;
    @Nullable
    public d p;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.glide.request.a.h<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f38291a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f38292b;

        /* renamed from: c  reason: collision with root package name */
        public final long f38293c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f38294d;

        public a(Handler handler, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38292b = handler;
            this.f38291a = i2;
            this.f38293c = j;
        }

        public Bitmap a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38294d : (Bitmap) invokeV.objValue;
        }

        public void a(@NonNull Bitmap bitmap, @Nullable com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, bVar) == null) {
                this.f38294d = bitmap;
                this.f38292b.sendMessageAtTime(this.f38292b.obtainMessage(1, this), this.f38293c);
            }
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.kwad.sdk.glide.request.b.b bVar) {
            a((Bitmap) obj, (com.kwad.sdk.glide.request.b.b<? super Bitmap>) bVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void f();
    }

    /* loaded from: classes7.dex */
    public class c implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f38295a;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38295a = gVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 1) {
                    this.f38295a.a((a) message.obj);
                    return true;
                } else if (i2 == 2) {
                    this.f38295a.f38282a.a((a) message.obj);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(com.kwad.sdk.glide.c cVar, com.kwad.sdk.glide.b.a aVar, int i2, int i3, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.a(), com.kwad.sdk.glide.c.b(cVar.c()), aVar, null, a(com.kwad.sdk.glide.c.b(cVar.c()), i2, i3), hVar, bitmap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r5;
            Object[] objArr = {cVar, aVar, Integer.valueOf(i2), Integer.valueOf(i3), hVar, bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.glide.load.engine.bitmap_recycle.e) objArr2[0], (com.kwad.sdk.glide.g) objArr2[1], (com.kwad.sdk.glide.b.a) objArr2[2], (Handler) objArr2[3], (com.kwad.sdk.glide.f) objArr2[4], (com.kwad.sdk.glide.load.h) objArr2[5], (Bitmap) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public g(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, com.kwad.sdk.glide.b.a aVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, gVar, aVar, handler, fVar, hVar, bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38285d = new ArrayList();
        this.f38282a = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c(this)) : handler;
        this.f38286e = eVar;
        this.f38284c = handler;
        this.f38290i = fVar;
        this.f38283b = aVar;
        a(hVar, bitmap);
    }

    public static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, gVar, i2, i3)) == null) ? gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f38086b).a(true).b(true).b(i2, i3)) : (com.kwad.sdk.glide.f) invokeLII.objValue;
    }

    private int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? k.a(i().getWidth(), i().getHeight(), i().getConfig()) : invokeV.intValue;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65540, this) == null) || this.f38287f) {
            return;
        }
        this.f38287f = true;
        this.k = false;
        m();
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f38287f = false;
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && this.f38287f && !this.f38288g) {
            if (this.f38289h) {
                com.kwad.sdk.glide.g.j.a(this.o == null, "Pending target must be null when starting from the first frame");
                this.f38283b.f();
                this.f38289h = false;
            }
            a aVar = this.o;
            if (aVar != null) {
                this.o = null;
                a(aVar);
                return;
            }
            this.f38288g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + this.f38283b.c();
            this.f38283b.b();
            this.l = new a(this.f38284c, this.f38283b.e(), uptimeMillis);
            this.f38290i.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(o())).a(this.f38283b).a((com.kwad.sdk.glide.f<Bitmap>) this.l);
        }
    }

    private void n() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (bitmap = this.m) == null) {
            return;
        }
        this.f38286e.a(bitmap);
        this.m = null;
    }

    public static com.kwad.sdk.glide.load.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new com.kwad.sdk.glide.f.b(Double.valueOf(Math.random())) : (com.kwad.sdk.glide.load.c) invokeV.objValue;
    }

    public Bitmap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (Bitmap) invokeV.objValue;
    }

    public void a(com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, bitmap) == null) {
            this.n = (com.kwad.sdk.glide.load.h) com.kwad.sdk.glide.g.j.a(hVar);
            this.m = (Bitmap) com.kwad.sdk.glide.g.j.a(bitmap);
            this.f38290i = this.f38290i.a((com.kwad.sdk.glide.request.a<?>) new com.kwad.sdk.glide.request.f().a(hVar));
        }
    }

    @VisibleForTesting
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            d dVar = this.p;
            if (dVar != null) {
                dVar.a();
            }
            this.f38288g = false;
            if (this.k) {
                this.f38284c.obtainMessage(2, aVar).sendToTarget();
            } else if (!this.f38287f) {
                this.o = aVar;
            } else {
                if (aVar.a() != null) {
                    n();
                    a aVar2 = this.j;
                    this.j = aVar;
                    for (int size = this.f38285d.size() - 1; size >= 0; size--) {
                        this.f38285d.get(size).f();
                    }
                    if (aVar2 != null) {
                        this.f38284c.obtainMessage(2, aVar2).sendToTarget();
                    }
                }
                m();
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.k) {
                throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
            }
            if (this.f38285d.contains(bVar)) {
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            boolean isEmpty = this.f38285d.isEmpty();
            this.f38285d.add(bVar);
            if (isEmpty) {
                k();
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i().getWidth() : invokeV.intValue;
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f38285d.remove(bVar);
            if (this.f38285d.isEmpty()) {
                l();
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? i().getHeight() : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38283b.g() + j() : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            a aVar = this.j;
            if (aVar != null) {
                return aVar.f38291a;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public ByteBuffer f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38283b.a().asReadOnlyBuffer() : (ByteBuffer) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f38283b.d() : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f38285d.clear();
            n();
            l();
            a aVar = this.j;
            if (aVar != null) {
                this.f38282a.a(aVar);
                this.j = null;
            }
            a aVar2 = this.l;
            if (aVar2 != null) {
                this.f38282a.a(aVar2);
                this.l = null;
            }
            a aVar3 = this.o;
            if (aVar3 != null) {
                this.f38282a.a(aVar3);
                this.o = null;
            }
            this.f38283b.i();
            this.k = true;
        }
    }

    public Bitmap i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            a aVar = this.j;
            return aVar != null ? aVar.a() : this.m;
        }
        return (Bitmap) invokeV.objValue;
    }
}
