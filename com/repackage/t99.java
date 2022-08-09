package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import com.repackage.m99;
import com.repackage.n99;
import com.repackage.o99;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class t99 implements n99, o99.a, m99.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g99 a;
    public j99 b;
    public Executor c;
    public String d;
    public e99 e;
    public n99.a f;
    public int g;
    public p99 h;
    public o99 i;
    public List<m99> j;

    public t99(g99 g99Var, j99 j99Var, Executor executor, String str, e99 e99Var, n99.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g99Var, j99Var, executor, str, e99Var, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = g99Var;
        this.b = j99Var;
        this.c = executor;
        this.d = str;
        this.e = e99Var;
        this.f = aVar;
        g();
    }

    @Override // com.repackage.m99.a
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) && k()) {
            this.g = 108;
            this.b.a(downloadException);
            m();
        }
    }

    @Override // com.repackage.o99.a
    public void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            if (this.i.isCanceled()) {
                onConnectCanceled();
            } else if (this.i.isPaused()) {
                onDownloadPaused();
            } else {
                this.g = 108;
                this.b.b(downloadException);
                m();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            File file = new File(this.h.a(), this.h.d());
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    @Override // com.repackage.n99
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o99 o99Var = this.i;
            if (o99Var != null) {
                o99Var.cancel();
            }
            for (m99 m99Var : this.j) {
                m99Var.cancel();
            }
            if (this.g != 104) {
                onDownloadCanceled();
            }
        }
    }

    public final void d(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.g = 104;
            h(j, z);
            for (m99 m99Var : this.j) {
                this.c.execute(m99Var);
            }
        }
    }

    public final List<x99> e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            ArrayList arrayList = new ArrayList();
            int b = this.e.b();
            int i = 0;
            while (i < b) {
                long j2 = j / b;
                long j3 = j2 * i;
                arrayList.add(new x99(i, this.d, this.a.c(), j3, i == b + (-1) ? j : (j2 + j3) - 1, 0L));
                i++;
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }

    public final x99 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new x99(0, this.d, this.a.c(), 0L) : (x99) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h = new p99(this.a.b().toString(), this.a.c(), this.a.a());
            this.j = new LinkedList();
        }
    }

    public final void h(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.j.clear();
            if (z) {
                List<x99> e = e(j);
                int i = 0;
                for (x99 x99Var : e) {
                    i = (int) (i + x99Var.b());
                }
                this.h.f(i);
                for (x99 x99Var2 : e) {
                    this.j.add(new v99(this.h, x99Var2, this));
                }
                return;
            }
            this.j.add(new w99(this.h, f(), this));
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            for (m99 m99Var : this.j) {
                if (m99Var.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.n99
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.g;
            return i == 101 || i == 102 || i == 103 || i == 104;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            for (m99 m99Var : this.j) {
                if (!m99Var.isComplete()) {
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
            for (m99 m99Var : this.j) {
                if (m99Var.isDownloading()) {
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
            for (m99 m99Var : this.j) {
                if (m99Var.isDownloading()) {
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
            this.f.a(this.d, this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            u99 u99Var = new u99(this.a.c(), this);
            this.i = u99Var;
            this.c.execute(u99Var);
        }
    }

    @Override // com.repackage.o99.a
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c();
            this.g = 107;
            this.b.onConnectCanceled();
            m();
        }
    }

    @Override // com.repackage.o99.a
    public void onConnectPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            onDownloadPaused();
        }
    }

    @Override // com.repackage.o99.a
    public void onConnected(long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            if (this.i.isCanceled()) {
                onConnectCanceled();
                return;
            }
            this.g = 103;
            this.b.onConnected(j, j2, z);
            this.h.e(z);
            this.h.g(j2);
            d(j2, z);
        }
    }

    @Override // com.repackage.o99.a
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.g = 102;
            this.b.onConnecting();
        }
    }

    @Override // com.repackage.m99.a
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && i()) {
            c();
            this.g = 107;
            this.b.onDownloadCanceled();
            m();
        }
    }

    @Override // com.repackage.m99.a
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && j()) {
            this.g = 105;
            this.b.onDownloadCompleted(str);
            m();
        }
    }

    @Override // com.repackage.m99.a
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && l()) {
            this.g = 106;
            this.b.onDownloadPaused();
            m();
        }
    }

    @Override // com.repackage.m99.a
    public void onDownloadProgress(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.b.onDownloadProgress(j, j2, (int) ((100 * j) / j2));
        }
    }

    @Override // com.repackage.n99
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            o99 o99Var = this.i;
            if (o99Var != null) {
                o99Var.pause();
            }
            for (m99 m99Var : this.j) {
                m99Var.pause();
            }
            if (this.g != 104) {
                onDownloadPaused();
            }
        }
    }

    @Override // com.repackage.n99
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.g = 101;
            this.b.onStarted();
            n();
        }
    }
}
