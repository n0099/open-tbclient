package d.a.w0.i;

import android.media.MediaFormat;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.w0.t.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class c implements j, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.w0.l.d.j.c.a A;

    /* renamed from: e  reason: collision with root package name */
    public Object f68575e;

    /* renamed from: f  reason: collision with root package name */
    public Object f68576f;

    /* renamed from: g  reason: collision with root package name */
    public Object f68577g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f68578h;

    /* renamed from: i  reason: collision with root package name */
    public volatile a f68579i;
    public volatile long j;
    public volatile long k;
    public volatile e l;
    public volatile d.a.w0.l.d.j.b m;
    public volatile boolean n;
    public volatile boolean o;
    public volatile boolean p;
    public volatile boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public float v;
    public List<h> w;
    public int[] x;
    public int y;
    public int z;

    public c(int i2, String str, float f2, float f3, int[] iArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, Float.valueOf(f2), Float.valueOf(f3), iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = Long.MIN_VALUE;
        this.k = Long.MIN_VALUE;
        this.v = 1.0f;
        this.r = i2;
        this.x = iArr;
        m(str);
        this.l = l();
        this.f68575e = new Object();
        this.f68576f = new Object();
        this.f68577g = new Object();
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(int i2, String str, int[] iArr) throws Exception {
        this(i2, str, 1.0f, 1.0f, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue(), (int[]) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean k(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iArr)) == null) {
            if (iArr == null || iArr.length == 0) {
                return false;
            }
            boolean z = false;
            for (int i2 : iArr) {
                if (i2 > 300 || i2 > 200 || i2 > 100) {
                    return true;
                }
                if (i2 > 0) {
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void A(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            if (this.w == null) {
                this.w = new ArrayList();
            }
            d.a.w0.i.d.a aVar = null;
            Iterator<h> it = this.w.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof d.a.w0.i.d.a) {
                    aVar = (d.a.w0.i.d.a) next;
                    break;
                }
            }
            if (aVar == null) {
                aVar = new d.a.w0.i.d.a();
                aVar.a(this.r, this.s, this.t, this.u);
                this.w.add(0, aVar);
            }
            aVar.b(f2);
        }
    }

    public void B(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.v = f2;
            if (this.w == null) {
                this.w = new ArrayList();
            }
            d.a.w0.i.d.c cVar = null;
            Iterator<h> it = this.w.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof d.a.w0.i.d.c) {
                    cVar = (d.a.w0.i.d.c) next;
                    break;
                }
            }
            if (cVar == null) {
                cVar = new d.a.w0.i.d.c();
                cVar.a(this.r, this.s, this.t, this.u);
                List<h> list = this.w;
                list.add(list.size(), cVar);
            }
            cVar.b(this.v);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.f68575e) {
                q();
                this.n = false;
                this.q = false;
                this.o = false;
                this.p = false;
                this.f68575e.notifyAll();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.n) {
                synchronized (this.f68575e) {
                    this.n = false;
                    this.f68575e.notifyAll();
                }
            }
            r();
            this.o = true;
        }
    }

    @Override // d.a.w0.i.j
    public void a(MediaFormat mediaFormat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaFormat) == null) {
            try {
                this.s = this.f68579i.e();
                this.t = this.f68579i.b();
                n();
                if (this.l instanceof d.a.w0.i.g.b) {
                    ((d.a.w0.i.g.b) this.l).c(i(), f());
                }
            } catch (Exception e2) {
                d.a.w0.l.d.j.c.a aVar = this.A;
                if (aVar != null) {
                    aVar.onExceptionThrown(m.g(e2));
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || d.a.w0.t.h.e(this.w)) {
            return;
        }
        for (h hVar : this.w) {
            if (hVar != null) {
                hVar.e();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || d.a.w0.t.h.e(this.w)) {
            return;
        }
        for (h hVar : this.w) {
            if (hVar != null) {
                hVar.c();
            }
        }
    }

    public int[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.x : (int[]) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.u : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.z = this.s;
            if (j()) {
                this.z = 1;
            }
            return this.z;
        }
        return invokeV.intValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.f68577g) {
                if (this.f68579i != null) {
                    return this.f68579i.getCurrentPosition();
                }
                return Long.MIN_VALUE;
            }
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f68579i != null) {
                return this.f68579i.getDuration();
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.y = this.t;
            if (j()) {
                this.y = 16000;
            }
            return this.y;
        }
        return invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? k(this.x) : invokeV.booleanValue;
    }

    public abstract e l() throws IOException;

    public final void m(String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (Build.VERSION.SDK_INT < 16) {
                if (this.m == null || this.p) {
                    return;
                }
                this.m.onExceptionThrown("Only API level >= 16 supported.");
                return;
            }
            this.f68579i = new i(str);
            ((i) this.f68579i).k(this);
            this.s = this.f68579i.e();
            this.t = this.f68579i.b();
            this.u = this.f68579i.a();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || d.a.w0.t.h.e(this.w)) {
            return;
        }
        for (h hVar : this.w) {
            if (hVar != null) {
                hVar.a(this.r, this.s, this.t, this.u);
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.j == Long.MIN_VALUE || this.k == Long.MIN_VALUE) ? false : true : invokeV.booleanValue;
    }

    public abstract void p();

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (this.f68575e) {
                p();
                this.n = true;
            }
        }
    }

    public abstract void q();

    public abstract void r();

    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            while (!this.o) {
                try {
                    try {
                        if (!this.q) {
                            u();
                            synchronized (this.f68577g) {
                                this.f68579i.d();
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (this.m != null && !this.p) {
                            this.m.onExceptionThrown(m.g(e2));
                        }
                        this.o = true;
                        v();
                        synchronized (this.f68576f) {
                            try {
                                this.l.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            this.l = null;
                            synchronized (this.f68577g) {
                                if (this.f68579i != null) {
                                    this.f68579i.close();
                                }
                                this.f68579i = null;
                                return;
                            }
                        }
                    }
                } catch (Throwable th) {
                    this.o = true;
                    v();
                    synchronized (this.f68576f) {
                        try {
                            this.l.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        this.l = null;
                        synchronized (this.f68577g) {
                            if (this.f68579i != null) {
                                this.f68579i.close();
                            }
                            this.f68579i = null;
                            throw th;
                        }
                    }
                }
            }
            this.o = true;
            v();
            synchronized (this.f68576f) {
                try {
                    this.l.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                this.l = null;
            }
            synchronized (this.f68577g) {
                if (this.f68579i != null) {
                    this.f68579i.close();
                }
                this.f68579i = null;
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this.f68575e) {
                while (this.n) {
                    try {
                        this.f68575e.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final int t(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, bArr)) == null) {
            if (bArr == null) {
                return 0;
            }
            if (d.a.w0.t.h.e(this.w)) {
                length = bArr.length;
            } else {
                length = bArr.length;
                for (h hVar : this.w) {
                    if (!hVar.b()) {
                        hVar.a(this.r, this.s, this.t, this.u);
                    }
                    if (hVar.a() && bArr != null) {
                        int length2 = bArr.length;
                        hVar.a(bArr, length2);
                        bArr = hVar.a(length2);
                        length = bArr != null ? bArr.length : 0;
                    }
                }
            }
            if (length > 0) {
                synchronized (this.f68576f) {
                    this.f68578h += this.l.write(bArr, 0, length);
                }
            }
            return length;
        }
        return invokeL.intValue;
    }

    public final void u() throws IOException {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            while (true) {
                boolean z = false;
                if ((this.f68579i.f() || g() >= h()) && !o()) {
                    break;
                }
                s();
                if (this.o) {
                    break;
                }
                if (o() && this.f68579i.getCurrentPosition() >= this.k) {
                    w(this.j);
                }
                synchronized (this.f68577g) {
                    try {
                        z = this.f68579i.c();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (this.m != null && !this.p) {
                            this.m.onExceptionThrown(m.g(e2));
                        }
                    }
                }
                if (z) {
                    x();
                    t(this.f68579i.g());
                }
            }
            d.a.w0.t.c.j("VideoMuxer: ", "----解码结束-----");
            if (this.p) {
                if (this.m != null) {
                    this.m.onCancel();
                    return;
                }
                return;
            }
            if (!d.a.w0.t.h.e(this.w)) {
                for (int i2 = 0; i2 < this.w.size(); i2++) {
                    if (this.w.get(i2).a()) {
                        this.w.get(i2).c();
                        do {
                            byte[] a2 = this.w.get(i2).a(4096);
                            if (a2 != null && a2.length != 0) {
                                length = a2.length;
                                int i3 = length;
                                for (int i4 = i2 + 1; i4 < this.w.size(); i4++) {
                                    if (this.w.get(i4).a()) {
                                        int length2 = a2.length;
                                        this.w.get(i4).a(a2, length2);
                                        a2 = this.w.get(i4).a(length2);
                                        i3 = a2 != null ? a2.length : 0;
                                    }
                                }
                                if (i3 > 0) {
                                    synchronized (this.f68576f) {
                                        d.a.w0.t.c.j("VideoMuxer: ", "----getLastBuffer-----");
                                        this.f68578h += this.l.write(a2, 0, i3);
                                    }
                                    continue;
                                }
                            }
                        } while (length > 0);
                    }
                }
            }
            c();
            if (this.m != null) {
                this.m.onTrackEnd(this.r);
                d.a.w0.t.c.j("VideoMuxer: ", "----所有数据输入编码器onTrackEnd-----,bytesWritten:" + this.f68578h);
            }
            this.q = true;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || d.a.w0.t.h.e(this.w)) {
            return;
        }
        for (h hVar : this.w) {
            if (hVar != null) {
                hVar.d();
            }
        }
    }

    public abstract void w(long j);

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || this.m == null || this.o) {
            return;
        }
        long currentPosition = this.f68579i.getCurrentPosition();
        long duration = this.f68579i.getDuration();
        this.m.onProgressChanged(this.r, (currentPosition == 0 || duration == 0) ? 0.0d : currentPosition / duration, currentPosition);
    }

    public void y(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, iArr) == null) {
            this.x = iArr;
            if (this.w == null) {
                this.w = new ArrayList();
            }
            d.a.w0.i.d.b bVar = null;
            Iterator<h> it = this.w.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof d.a.w0.i.d.b) {
                    bVar = (d.a.w0.i.d.b) next;
                    break;
                }
            }
            if (bVar == null) {
                bVar = new d.a.w0.i.d.b();
                bVar.a(this.r, this.s, this.t, this.u * 8);
                List<h> list = this.w;
                list.add(list.size(), bVar);
            }
            bVar.b(this.x);
        }
    }

    public void z(d.a.w0.l.d.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bVar) == null) {
            this.m = bVar;
        }
    }
}
