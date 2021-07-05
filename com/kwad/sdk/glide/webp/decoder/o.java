package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
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
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy> f38430a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.g f38431b;

    /* renamed from: c  reason: collision with root package name */
    public final i f38432c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f38433d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f38434e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38435f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38436g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38437h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38438i;
    public com.kwad.sdk.glide.f<Bitmap> j;
    public a k;
    public boolean l;
    public a m;
    public Bitmap n;
    public com.kwad.sdk.glide.load.h<Bitmap> o;
    public a p;
    @Nullable
    public d q;
    public int r;
    public int s;
    public int t;

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.glide.request.a.c<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f38439a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f38440b;

        /* renamed from: c  reason: collision with root package name */
        public final long f38441c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f38442d;

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
            this.f38440b = handler;
            this.f38439a = i2;
            this.f38441c = j;
        }

        public Bitmap a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38442d : (Bitmap) invokeV.objValue;
        }

        public void a(Bitmap bitmap, com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, bVar) == null) {
                this.f38442d = bitmap;
                Message obtainMessage = this.f38440b.obtainMessage(1, this);
                this.f38440b.removeMessages(1);
                this.f38440b.sendMessageAtTime(obtainMessage, this.f38441c);
            }
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public void a(@Nullable Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) {
                this.f38442d = null;
            }
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.kwad.sdk.glide.request.b.b bVar) {
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
        public final /* synthetic */ o f38443a;

        public c(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38443a = oVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 1) {
                    this.f38443a.a((a) message.obj);
                    return true;
                } else if (i2 == 2) {
                    this.f38443a.f38431b.a((a) message.obj);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes7.dex */
    public static class e implements com.kwad.sdk.glide.load.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f38444b;

        /* renamed from: c  reason: collision with root package name */
        public final int f38445c;

        public e(com.kwad.sdk.glide.load.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38444b = cVar;
            this.f38445c = i2;
        }

        @Override // com.kwad.sdk.glide.load.c
        public void a(@NonNull MessageDigest messageDigest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, messageDigest) == null) {
                messageDigest.update(ByteBuffer.allocate(12).putInt(this.f38445c).array());
                this.f38444b.a(messageDigest);
            }
        }

        @Override // com.kwad.sdk.glide.load.c
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof e) {
                    e eVar = (e) obj;
                    return this.f38444b.equals(eVar.f38444b) && this.f38445c == eVar.f38445c;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.kwad.sdk.glide.load.c
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f38444b.hashCode() * 31) + this.f38445c : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1391955269, "Lcom/kwad/sdk/glide/webp/decoder/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1391955269, "Lcom/kwad/sdk/glide/webp/decoder/o;");
                return;
            }
        }
        f38430a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.WebpFrameLoader.CacheStrategy", WebpFrameCacheStrategy.f38379b);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(com.kwad.sdk.glide.c cVar, i iVar, int i2, int i3, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.a(), com.kwad.sdk.glide.c.b(cVar.c()), iVar, null, a(com.kwad.sdk.glide.c.b(cVar.c()), i2, i3), hVar, bitmap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r5;
            Object[] objArr = {cVar, iVar, Integer.valueOf(i2), Integer.valueOf(i3), hVar, bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.glide.load.engine.bitmap_recycle.e) objArr2[0], (com.kwad.sdk.glide.g) objArr2[1], (i) objArr2[2], (Handler) objArr2[3], (com.kwad.sdk.glide.f) objArr2[4], (com.kwad.sdk.glide.load.h) objArr2[5], (Bitmap) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public o(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, i iVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, gVar, iVar, handler, fVar, hVar, bitmap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38434e = new ArrayList();
        this.f38436g = false;
        this.f38437h = false;
        this.f38438i = false;
        this.f38431b = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c(this)) : handler;
        this.f38435f = eVar;
        this.f38433d = handler;
        this.j = fVar;
        this.f38432c = iVar;
        a(hVar, bitmap);
    }

    public static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, gVar, i2, i3)) == null) ? gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f38086b).a(true).b(true).b(i2, i3)) : (com.kwad.sdk.glide.f) invokeLII.objValue;
    }

    private com.kwad.sdk.glide.load.c a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65540, this, i2)) == null) ? new e(new com.kwad.sdk.glide.f.b(this.f38432c), i2) : (com.kwad.sdk.glide.load.c) invokeI.objValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || this.f38436g) {
            return;
        }
        this.f38436g = true;
        this.l = false;
        l();
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f38436g = false;
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.f38436g && !this.f38437h) {
            if (this.f38438i) {
                com.kwad.sdk.glide.g.j.a(this.p == null, "Pending target must be null when starting from the first frame");
                this.f38432c.f();
                this.f38438i = false;
            }
            a aVar = this.p;
            if (aVar != null) {
                this.p = null;
                a(aVar);
                return;
            }
            this.f38437h = true;
            int c2 = this.f38432c.c();
            this.f38432c.b();
            int e2 = this.f38432c.e();
            this.m = new a(this.f38433d, e2, SystemClock.uptimeMillis() + c2);
            this.j.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(a(e2)).b(this.f38432c.j().a())).a(this.f38432c).a((com.kwad.sdk.glide.f<Bitmap>) this.m);
        }
    }

    private void m() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (bitmap = this.n) == null) {
            return;
        }
        this.f38435f.a(bitmap);
        this.n = null;
    }

    public Bitmap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : (Bitmap) invokeV.objValue;
    }

    public void a(com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, bitmap) == null) {
            this.o = (com.kwad.sdk.glide.load.h) com.kwad.sdk.glide.g.j.a(hVar);
            this.n = (Bitmap) com.kwad.sdk.glide.g.j.a(bitmap);
            this.j = this.j.a((com.kwad.sdk.glide.request.a<?>) new com.kwad.sdk.glide.request.f().a(hVar));
            this.r = com.kwad.sdk.glide.g.k.a(bitmap);
            this.s = bitmap.getWidth();
            this.t = bitmap.getHeight();
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            d dVar = this.q;
            if (dVar != null) {
                dVar.a();
            }
            this.f38437h = false;
            if (this.l) {
                this.f38433d.obtainMessage(2, aVar).sendToTarget();
            } else if (this.f38436g) {
                if (aVar.a() != null) {
                    m();
                    a aVar2 = this.k;
                    this.k = aVar;
                    for (int size = this.f38434e.size() - 1; size >= 0; size--) {
                        this.f38434e.get(size).f();
                    }
                    if (aVar2 != null) {
                        this.f38433d.obtainMessage(2, aVar2).sendToTarget();
                    }
                }
                l();
            } else if (this.f38438i) {
                this.f38433d.obtainMessage(2, aVar).sendToTarget();
            } else {
                this.p = aVar;
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.l) {
                throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
            }
            if (this.f38434e.contains(bVar)) {
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            boolean isEmpty = this.f38434e.isEmpty();
            this.f38434e.add(bVar);
            if (isEmpty) {
                j();
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s : invokeV.intValue;
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f38434e.remove(bVar);
            if (this.f38434e.isEmpty()) {
                k();
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38432c.g() + this.r : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            a aVar = this.k;
            if (aVar != null) {
                return aVar.f38439a;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public ByteBuffer f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38432c.a().asReadOnlyBuffer() : (ByteBuffer) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f38432c.d() : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f38434e.clear();
            m();
            k();
            a aVar = this.k;
            if (aVar != null) {
                this.f38431b.a(aVar);
                this.k = null;
            }
            a aVar2 = this.m;
            if (aVar2 != null) {
                this.f38431b.a(aVar2);
                this.m = null;
            }
            a aVar3 = this.p;
            if (aVar3 != null) {
                this.f38431b.a(aVar3);
                this.p = null;
            }
            this.f38432c.i();
            this.l = true;
        }
    }

    public Bitmap i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            a aVar = this.k;
            return aVar != null ? aVar.a() : this.n;
        }
        return (Bitmap) invokeV.objValue;
    }
}
