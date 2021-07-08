package d.a.v0.k.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import d.a.v0.k.e.e;
import d.a.v0.k.e.f;
import d.a.v0.k.e.g;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes8.dex */
public class e implements d.a.v0.k.e.f, g.a, e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.v0.k.c f67986a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.v0.k.e.b f67987b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f67988c;

    /* renamed from: d  reason: collision with root package name */
    public String f67989d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.v0.k.a f67990e;

    /* renamed from: f  reason: collision with root package name */
    public f.a f67991f;

    /* renamed from: g  reason: collision with root package name */
    public int f67992g;

    /* renamed from: h  reason: collision with root package name */
    public a f67993h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.v0.k.e.g f67994i;
    public List<d.a.v0.k.e.e> j;

    public e(d.a.v0.k.c cVar, d.a.v0.k.e.b bVar, Executor executor, String str, d.a.v0.k.a aVar, f.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bVar, executor, str, aVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67986a = cVar;
        this.f67987b = bVar;
        this.f67988c = executor;
        this.f67989d = str;
        this.f67990e = aVar;
        this.f67991f = aVar2;
        g();
    }

    @Override // d.a.v0.k.e.e.a
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) && k()) {
            this.f67992g = 108;
            this.f67987b.a(downloadException);
            m();
        }
    }

    @Override // d.a.v0.k.e.g.a
    public void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            if (this.f67994i.isCanceled()) {
                onConnectCanceled();
            } else if (this.f67994i.isPaused()) {
                onDownloadPaused();
            } else {
                this.f67992g = 108;
                this.f67987b.b(downloadException);
                m();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            File file = new File(this.f67993h.a(), this.f67993h.d());
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    @Override // d.a.v0.k.e.f
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.v0.k.e.g gVar = this.f67994i;
            if (gVar != null) {
                gVar.cancel();
            }
            for (d.a.v0.k.e.e eVar : this.j) {
                eVar.cancel();
            }
            if (this.f67992g != 104) {
                onDownloadCanceled();
            }
        }
    }

    public final void d(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.f67992g = 104;
            h(j, z);
            for (d.a.v0.k.e.e eVar : this.j) {
                this.f67988c.execute(eVar);
            }
        }
    }

    public final List<i> e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            ArrayList arrayList = new ArrayList();
            int b2 = this.f67990e.b();
            int i2 = 0;
            while (i2 < b2) {
                long j2 = j / b2;
                long j3 = j2 * i2;
                arrayList.add(new i(i2, this.f67989d, this.f67986a.c(), j3, i2 == b2 + (-1) ? j : (j2 + j3) - 1, 0L));
                i2++;
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }

    public final i f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new i(0, this.f67989d, this.f67986a.c(), 0L) : (i) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f67993h = new a(this.f67986a.b().toString(), this.f67986a.c(), this.f67986a.a());
            this.j = new LinkedList();
        }
    }

    public final void h(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.j.clear();
            if (z) {
                List<i> e2 = e(j);
                int i2 = 0;
                for (i iVar : e2) {
                    i2 = (int) (i2 + iVar.b());
                }
                this.f67993h.f(i2);
                for (i iVar2 : e2) {
                    this.j.add(new g(this.f67993h, iVar2, this));
                }
                return;
            }
            this.j.add(new h(this.f67993h, f(), this));
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            for (d.a.v0.k.e.e eVar : this.j) {
                if (eVar.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.v0.k.e.f
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.f67992g;
            return i2 == 101 || i2 == 102 || i2 == 103 || i2 == 104;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            for (d.a.v0.k.e.e eVar : this.j) {
                if (!eVar.isComplete()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            for (d.a.v0.k.e.e eVar : this.j) {
                if (eVar.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            for (d.a.v0.k.e.e eVar : this.j) {
                if (eVar.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f67991f.a(this.f67989d, this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            f fVar = new f(this.f67986a.c(), this);
            this.f67994i = fVar;
            this.f67988c.execute(fVar);
        }
    }

    @Override // d.a.v0.k.e.g.a
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c();
            this.f67992g = 107;
            this.f67987b.onConnectCanceled();
            m();
        }
    }

    @Override // d.a.v0.k.e.g.a
    public void onConnectPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            onDownloadPaused();
        }
    }

    @Override // d.a.v0.k.e.g.a
    public void onConnected(long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            if (this.f67994i.isCanceled()) {
                onConnectCanceled();
                return;
            }
            this.f67992g = 103;
            this.f67987b.onConnected(j, j2, z);
            this.f67993h.e(z);
            this.f67993h.g(j2);
            d(j2, z);
        }
    }

    @Override // d.a.v0.k.e.g.a
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f67992g = 102;
            this.f67987b.onConnecting();
        }
    }

    @Override // d.a.v0.k.e.e.a
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && i()) {
            c();
            this.f67992g = 107;
            this.f67987b.onDownloadCanceled();
            m();
        }
    }

    @Override // d.a.v0.k.e.e.a
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && j()) {
            this.f67992g = 105;
            this.f67987b.onDownloadCompleted(str);
            m();
        }
    }

    @Override // d.a.v0.k.e.e.a
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && l()) {
            this.f67992g = 106;
            this.f67987b.onDownloadPaused();
            m();
        }
    }

    @Override // d.a.v0.k.e.e.a
    public void onDownloadProgress(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f67987b.onDownloadProgress(j, j2, (int) ((100 * j) / j2));
        }
    }

    @Override // d.a.v0.k.e.f
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            d.a.v0.k.e.g gVar = this.f67994i;
            if (gVar != null) {
                gVar.pause();
            }
            for (d.a.v0.k.e.e eVar : this.j) {
                eVar.pause();
            }
            if (this.f67992g != 104) {
                onDownloadPaused();
            }
        }
    }

    @Override // d.a.v0.k.e.f
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f67992g = 101;
            this.f67987b.onStarted();
            n();
        }
    }
}
