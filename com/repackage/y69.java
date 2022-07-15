package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import com.repackage.r69;
import com.repackage.s69;
import com.repackage.t69;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class y69 implements s69, t69.a, r69.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l69 a;
    public o69 b;
    public Executor c;
    public String d;
    public j69 e;
    public s69.a f;
    public int g;
    public u69 h;
    public t69 i;
    public List<r69> j;

    public y69(l69 l69Var, o69 o69Var, Executor executor, String str, j69 j69Var, s69.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l69Var, o69Var, executor, str, j69Var, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = l69Var;
        this.b = o69Var;
        this.c = executor;
        this.d = str;
        this.e = j69Var;
        this.f = aVar;
        g();
    }

    @Override // com.repackage.r69.a
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) && k()) {
            this.g = 108;
            this.b.a(downloadException);
            m();
        }
    }

    @Override // com.repackage.t69.a
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

    @Override // com.repackage.s69
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            t69 t69Var = this.i;
            if (t69Var != null) {
                t69Var.cancel();
            }
            for (r69 r69Var : this.j) {
                r69Var.cancel();
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
            for (r69 r69Var : this.j) {
                this.c.execute(r69Var);
            }
        }
    }

    public final List<c79> e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            ArrayList arrayList = new ArrayList();
            int b = this.e.b();
            int i = 0;
            while (i < b) {
                long j2 = j / b;
                long j3 = j2 * i;
                arrayList.add(new c79(i, this.d, this.a.c(), j3, i == b + (-1) ? j : (j2 + j3) - 1, 0L));
                i++;
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }

    public final c79 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new c79(0, this.d, this.a.c(), 0L) : (c79) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h = new u69(this.a.b().toString(), this.a.c(), this.a.a());
            this.j = new LinkedList();
        }
    }

    public final void h(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.j.clear();
            if (z) {
                List<c79> e = e(j);
                int i = 0;
                for (c79 c79Var : e) {
                    i = (int) (i + c79Var.b());
                }
                this.h.f(i);
                for (c79 c79Var2 : e) {
                    this.j.add(new a79(this.h, c79Var2, this));
                }
                return;
            }
            this.j.add(new b79(this.h, f(), this));
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            for (r69 r69Var : this.j) {
                if (r69Var.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.s69
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
            for (r69 r69Var : this.j) {
                if (!r69Var.isComplete()) {
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
            for (r69 r69Var : this.j) {
                if (r69Var.isDownloading()) {
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
            for (r69 r69Var : this.j) {
                if (r69Var.isDownloading()) {
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
            z69 z69Var = new z69(this.a.c(), this);
            this.i = z69Var;
            this.c.execute(z69Var);
        }
    }

    @Override // com.repackage.t69.a
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c();
            this.g = 107;
            this.b.onConnectCanceled();
            m();
        }
    }

    @Override // com.repackage.t69.a
    public void onConnectPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            onDownloadPaused();
        }
    }

    @Override // com.repackage.t69.a
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

    @Override // com.repackage.t69.a
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.g = 102;
            this.b.onConnecting();
        }
    }

    @Override // com.repackage.r69.a
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && i()) {
            c();
            this.g = 107;
            this.b.onDownloadCanceled();
            m();
        }
    }

    @Override // com.repackage.r69.a
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && j()) {
            this.g = 105;
            this.b.onDownloadCompleted(str);
            m();
        }
    }

    @Override // com.repackage.r69.a
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && l()) {
            this.g = 106;
            this.b.onDownloadPaused();
            m();
        }
    }

    @Override // com.repackage.r69.a
    public void onDownloadProgress(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.b.onDownloadProgress(j, j2, (int) ((100 * j) / j2));
        }
    }

    @Override // com.repackage.s69
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            t69 t69Var = this.i;
            if (t69Var != null) {
                t69Var.pause();
            }
            for (r69 r69Var : this.j) {
                r69Var.pause();
            }
            if (this.g != 104) {
                onDownloadPaused();
            }
        }
    }

    @Override // com.repackage.s69
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.g = 101;
            this.b.onStarted();
            n();
        }
    }
}
