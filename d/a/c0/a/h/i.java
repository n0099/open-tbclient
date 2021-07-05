package d.a.c0.a.h;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c0.a.j.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45038a;

    /* renamed from: b  reason: collision with root package name */
    public File f45039b;

    /* renamed from: c  reason: collision with root package name */
    public File f45040c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f45041d;

    /* renamed from: e  reason: collision with root package name */
    public b f45042e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c0.a.g.a f45043f;

    /* renamed from: g  reason: collision with root package name */
    public long f45044g;

    /* renamed from: h  reason: collision with root package name */
    public int f45045h;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b<T> implements d.a.c0.a.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public T f45046a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f45047b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f45048c;

        /* loaded from: classes8.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f45049e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f45050f;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45050f = bVar;
                this.f45049e = str;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f45050f.f45048c.s(this.f45049e);
                    this.f45050f.f(null);
                }
            }
        }

        /* renamed from: d.a.c0.a.h.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0606b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f45051e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Exception f45052f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f45053g;

            public RunnableC0606b(b bVar, boolean z, Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Boolean.valueOf(z), exc};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45053g = bVar;
                this.f45051e = z;
                this.f45052f = exc;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: d.a.c0.a.h.i$c */
            /* JADX DEBUG: Multi-variable search result rejected for r0v32, resolved type: d.a.c0.a.h.i$c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = 0;
                    if (this.f45051e) {
                        while (i2 < this.f45053g.f45048c.f45041d.size()) {
                            c cVar = (c) this.f45053g.f45048c.f45041d.get(i2);
                            if (cVar != 0) {
                                cVar.a(this.f45053g.f45046a, this.f45053g.f45048c.f45039b.getAbsolutePath());
                            }
                            i2++;
                        }
                        if (this.f45053g.f45048c.f45043f != null) {
                            this.f45053g.f45048c.f45043f.b(this.f45053g.f45048c.f45039b.getAbsolutePath());
                            return;
                        }
                        return;
                    }
                    while (i2 < this.f45053g.f45048c.f45041d.size()) {
                        c cVar2 = (c) this.f45053g.f45048c.f45041d.get(i2);
                        if (cVar2 != 0) {
                            cVar2.b(this.f45053g.f45046a, this.f45052f);
                        }
                        i2++;
                    }
                    if (this.f45053g.f45048c.f45043f != null) {
                        this.f45053g.f45048c.f45043f.onFailed(this.f45052f);
                    }
                }
            }
        }

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45048c = iVar;
        }

        @Override // d.a.c0.a.g.a
        public void a(long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) || i2 == this.f45048c.f45045h) {
                return;
            }
            this.f45048c.f45044g = j2;
            this.f45048c.f45045h = i2;
            for (int i3 = 0; i3 < this.f45048c.f45041d.size(); i3++) {
                c cVar = (c) this.f45048c.f45041d.get(i3);
                if (cVar != null) {
                    cVar.c(this.f45046a, j, j2, i2);
                }
            }
            if (this.f45048c.f45043f != null) {
                this.f45048c.f45043f.a(j, j2, i2);
            }
        }

        @Override // d.a.c0.a.g.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f45048c.p()) {
                    d("onCompleted(download): " + str);
                }
                new a(this, str).start();
                this.f45047b = false;
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                i.j("res:" + str);
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45047b : invokeV.booleanValue;
        }

        public void f(Exception exc) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, exc) == null) || this.f45048c.f45041d == null || this.f45048c.f45041d.isEmpty()) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new RunnableC0606b(this, this.f45048c.q(), exc));
        }

        public void g(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                this.f45046a = t;
            }
        }

        @Override // d.a.c0.a.g.a
        public void onFailed(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                if (this.f45048c.p()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onFailed: ");
                    sb.append(this.f45048c.f45038a);
                    sb.append("\n");
                    sb.append(exc != null ? exc.getMessage() : "");
                    d(sb.toString());
                }
                if (this.f45048c.f45040c.exists()) {
                    this.f45048c.f45040c.delete();
                }
                for (int i2 = 0; i2 < this.f45048c.f45041d.size(); i2++) {
                    c cVar = (c) this.f45048c.f45041d.get(i2);
                    if (cVar != null) {
                        cVar.b(this.f45046a, exc);
                    }
                }
                if (this.f45048c.f45043f != null) {
                    this.f45048c.f45043f.onFailed(exc);
                }
                this.f45047b = false;
            }
        }

        @Override // d.a.c0.a.g.a
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f45047b = true;
                if (this.f45048c.p()) {
                    d("onStarted");
                }
                for (int i2 = 0; i2 < this.f45048c.f45041d.size(); i2++) {
                    c cVar = (c) this.f45048c.f45041d.get(i2);
                    if (cVar != null) {
                        cVar.d(this.f45046a);
                    }
                }
                if (this.f45048c.f45043f != null) {
                    this.f45048c.f45043f.onStarted();
                }
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        public void a(T t, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, t, str) == null) {
            }
        }

        public void b(T t, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, exc) == null) {
            }
        }

        public void c(T t, long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{t, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            }
        }

        public void d(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            }
        }
    }

    public i(String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45038a = str;
        this.f45039b = file;
        this.f45041d = new ArrayList();
        this.f45040c = new File(this.f45039b.getAbsolutePath() + ".loading");
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            Log.d("DuAr_FileLoader", str);
        }
    }

    public boolean i(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || q() || r()) {
            return;
        }
        synchronized (this) {
            if (!q() && !r()) {
                if (this.f45042e == null) {
                    b bVar = new b(this, null);
                    this.f45042e = bVar;
                    bVar.g(this);
                }
                d.a.c0.a.g.b d2 = d.a.c0.a.b.d();
                if (d2 != null) {
                    d2.a(this.f45038a, this.f45040c.getParent(), this.f45040c.getName(), this.f45042e);
                }
            }
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (q()) {
                if (cVar != null) {
                    cVar.a(this, this.f45039b.getAbsolutePath());
                    return;
                }
                return;
            }
            if (cVar != null && !this.f45041d.contains(cVar)) {
                this.f45041d.add(cVar);
            }
            k();
        }
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45039b : (File) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45045h : invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f45038a : (String) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? d.a.c0.a.b.n() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            File file = this.f45039b;
            return file != null && file.exists();
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.f45042e;
            return bVar != null && bVar.e();
        }
        return invokeV.booleanValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            File file = new File(str);
            boolean z2 = false;
            try {
                if (p()) {
                    j("onCompleted-unzip:" + str + "\nto " + this.f45039b.getAbsolutePath());
                }
                File file2 = new File(this.f45039b + ".ziping");
                if (file2.exists()) {
                    if (p()) {
                        j("delete older exists " + file2);
                    }
                    d.a.c0.a.j.e.e(file2);
                }
                boolean z3 = true;
                try {
                    j.a(file, file2);
                    z = true;
                } catch (Exception e2) {
                    j("unzipFile Exception : " + e2.getMessage() + " " + str);
                    z = false;
                }
                if (!z || !i(file2)) {
                    z3 = false;
                }
                if (!z3) {
                    if (p()) {
                        j("faild on afterUnziped " + file2);
                    }
                    d.a.c0.a.j.e.e(file2);
                    z2 = z3;
                } else {
                    z2 = file2.renameTo(this.f45039b) & z3;
                }
            } catch (Exception e3) {
                j("Exception on onFileLoaderCompledted " + e3.getMessage());
                e3.printStackTrace();
            }
            d.a.c0.a.j.e.d(file);
            return z2;
        }
        return invokeL.booleanValue;
    }
}
