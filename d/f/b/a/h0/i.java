package d.f.b.a.h0;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.h0.c;
/* loaded from: classes10.dex */
public final class i implements c, p<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f73295a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a f73296b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.i0.p f73297c;

    /* renamed from: d  reason: collision with root package name */
    public final d.f.b.a.i0.b f73298d;

    /* renamed from: e  reason: collision with root package name */
    public int f73299e;

    /* renamed from: f  reason: collision with root package name */
    public long f73300f;

    /* renamed from: g  reason: collision with root package name */
    public long f73301g;

    /* renamed from: h  reason: collision with root package name */
    public long f73302h;

    /* renamed from: i  reason: collision with root package name */
    public long f73303i;
    public long j;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f73304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f73305f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f73306g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f73307h;

        public a(i iVar, int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73307h = iVar;
            this.f73304e = i2;
            this.f73305f = j;
            this.f73306g = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f73307h.f73296b.a(this.f73304e, this.f73305f, this.f73306g);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i() {
        this(null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Handler) objArr[0], (c.a) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.f.b.a.h0.p
    public synchronized void a(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, obj, i2) == null) {
            synchronized (this) {
                this.f73301g += i2;
            }
        }
    }

    @Override // d.f.b.a.h0.p
    public synchronized void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            synchronized (this) {
                d.f.b.a.i0.a.f(this.f73299e > 0);
                long a2 = this.f73298d.a();
                int i2 = (int) (a2 - this.f73300f);
                long j = i2;
                this.f73302h += j;
                this.f73303i += this.f73301g;
                if (i2 > 0) {
                    this.f73297c.a((int) Math.sqrt(this.f73301g), (float) ((this.f73301g * 8000) / j));
                    if (this.f73302h >= 2000 || this.f73303i >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                        float d2 = this.f73297c.d(0.5f);
                        this.j = Float.isNaN(d2) ? -1L : d2;
                    }
                }
                f(i2, this.f73301g, this.j);
                int i3 = this.f73299e - 1;
                this.f73299e = i3;
                if (i3 > 0) {
                    this.f73300f = a2;
                }
                this.f73301g = 0L;
            }
        }
    }

    @Override // d.f.b.a.h0.c
    public synchronized long c() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                j = this.j;
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.h0.p
    public synchronized void d(Object obj, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, gVar) == null) {
            synchronized (this) {
                if (this.f73299e == 0) {
                    this.f73300f = this.f73298d.a();
                }
                this.f73299e++;
            }
        }
    }

    public final void f(int i2, long j, long j2) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || (handler = this.f73295a) == null || this.f73296b == null) {
            return;
        }
        handler.post(new a(this, i2, j, j2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Handler handler, c.a aVar) {
        this(handler, aVar, 2000);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], (c.a) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Handler handler, c.a aVar, int i2) {
        this(handler, aVar, i2, d.f.b.a.i0.b.f73351a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], (c.a) objArr2[1], ((Integer) objArr2[2]).intValue(), (d.f.b.a.i0.b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public i(Handler handler, c.a aVar, int i2, d.f.b.a.i0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, aVar, Integer.valueOf(i2), bVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f73295a = handler;
        this.f73296b = aVar;
        this.f73297c = new d.f.b.a.i0.p(i2);
        this.f73298d = bVar;
        this.j = -1L;
    }
}
