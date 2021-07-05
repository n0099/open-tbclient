package d.a.q0.o.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.engine.GlideException;
import d.a.q0.o.a.a.p;
import d.a.q0.o.a.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes8.dex */
public class q extends p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f54192g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.q0.o.a.c.g<a> f54193a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.q0.o.a.c.g<a> f54194b;

    /* renamed from: c  reason: collision with root package name */
    public final String f54195c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54196d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54197e;

    /* renamed from: f  reason: collision with root package name */
    public k f54198f;

    /* loaded from: classes8.dex */
    public final class a implements d.b<Object>, d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f54199a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f54200b;

        /* renamed from: c  reason: collision with root package name */
        public p.a<Object> f54201c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.q0.o.a.b.d<Object> f54202d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f54203e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f54204f;

        /* renamed from: g  reason: collision with root package name */
        public Object f54205g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f54206h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f54207i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ q o;

        public void a(d.a.q0.o.a.b.d<Object> dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || this.f54201c == null) {
                return;
            }
            String str = null;
            if (this.o.f54198f != null) {
                str = this.o.f54198f.f54153d.s;
                this.o.f54198f.f54153d.s = "onLoadFinished";
            }
            try {
                if (q.f54192g) {
                    Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.a(obj));
                }
                this.f54201c.b(dVar, obj);
                this.f54204f = true;
            } finally {
                if (this.o.f54198f != null) {
                    this.o.f54198f.f54153d.s = str;
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (q.f54192g) {
                    Log.v("LoaderManager", "  Destroying: " + this);
                }
                this.l = true;
                boolean z = this.f54204f;
                this.f54204f = false;
                if (this.f54201c != null && this.f54202d != null && this.f54203e && z) {
                    if (q.f54192g) {
                        Log.v("LoaderManager", "  Reseting: " + this);
                    }
                    if (this.o.f54198f != null) {
                        str = this.o.f54198f.f54153d.s;
                        this.o.f54198f.f54153d.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.f54201c.a(this.f54202d);
                    } finally {
                        if (this.o.f54198f != null) {
                            this.o.f54198f.f54153d.s = str;
                        }
                    }
                }
                this.f54201c = null;
                this.f54205g = null;
                this.f54203e = false;
                d.a.q0.o.a.b.d<Object> dVar = this.f54202d;
                if (dVar != null) {
                    if (this.m) {
                        this.m = false;
                        dVar.h(this);
                        this.f54202d.i(this);
                    }
                    this.f54202d.e();
                }
                a aVar = this.n;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, fileDescriptor, printWriter, strArr) == null) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(this.f54199a);
                printWriter.print(" mArgs=");
                printWriter.println(this.f54200b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f54201c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.f54202d);
                d.a.q0.o.a.b.d<Object> dVar = this.f54202d;
                if (dVar != null) {
                    dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.f54203e || this.f54204f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f54203e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f54204f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f54205g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f54206h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.f54207i);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.j);
                printWriter.print(" mListenerRegistered=");
                printWriter.println(this.m);
                if (this.n != null) {
                    printWriter.print(str);
                    printWriter.println("Pending Loader ");
                    printWriter.print(this.n);
                    printWriter.println(":");
                    a aVar = this.n;
                    aVar.c(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f54207i) {
                    if (q.f54192g) {
                        Log.v("LoaderManager", "  Finished Retaining: " + this);
                    }
                    this.f54207i = false;
                    boolean z = this.f54206h;
                    if (z != this.j && !z) {
                        h();
                    }
                }
                if (this.f54206h && this.f54203e && !this.k) {
                    a(this.f54202d, this.f54205g);
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f54206h && this.k) {
                this.k = false;
                if (this.f54203e) {
                    a(this.f54202d, this.f54205g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (q.f54192g) {
                    Log.v("LoaderManager", "  Retaining: " + this);
                }
                this.f54207i = true;
                this.j = this.f54206h;
                this.f54206h = false;
                this.f54201c = null;
            }
        }

        public void g() {
            p.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.f54207i && this.j) {
                    this.f54206h = true;
                } else if (this.f54206h) {
                } else {
                    this.f54206h = true;
                    if (q.f54192g) {
                        Log.v("LoaderManager", "  Starting: " + this);
                    }
                    if (this.f54202d == null && (aVar = this.f54201c) != null) {
                        this.f54202d = aVar.onCreateLoader(this.f54199a, this.f54200b);
                    }
                    d.a.q0.o.a.b.d<Object> dVar = this.f54202d;
                    if (dVar != null) {
                        if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f54202d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f54202d);
                        }
                        if (!this.m) {
                            this.f54202d.c(this.f54199a, this);
                            this.f54202d.d(this);
                            this.m = true;
                        }
                        this.f54202d.f();
                        throw null;
                    }
                }
            }
        }

        public void h() {
            d.a.q0.o.a.b.d<Object> dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (q.f54192g) {
                    Log.v("LoaderManager", "  Stopping: " + this);
                }
                this.f54206h = false;
                if (this.f54207i || (dVar = this.f54202d) == null || !this.m) {
                    return;
                }
                this.m = false;
                dVar.h(this);
                this.f54202d.i(this);
                this.f54202d.g();
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                StringBuilder sb = new StringBuilder(64);
                sb.append("LoaderInfo{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" #");
                sb.append(this.f54199a);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                d.a.q0.o.a.c.c.a(this.f54202d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2054637105, "Ld/a/q0/o/a/a/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2054637105, "Ld/a/q0/o/a/a/q;");
        }
    }

    public q(String str, k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, kVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54193a = new d.a.q0.o.a.c.g<>();
        this.f54194b = new d.a.q0.o.a.c.g<>();
        this.f54195c = str;
        this.f54198f = kVar;
        this.f54196d = z;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f54197e) {
                if (f54192g) {
                    Log.v("LoaderManager", "Destroying Active in " + this);
                }
                for (int h2 = this.f54193a.h() - 1; h2 >= 0; h2--) {
                    this.f54193a.i(h2).b();
                }
                this.f54193a.d();
            }
            if (f54192g) {
                Log.v("LoaderManager", "Destroying Inactive in " + this);
            }
            for (int h3 = this.f54194b.h() - 1; h3 >= 0; h3--) {
                this.f54194b.i(h3).b();
            }
            this.f54194b.d();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int h2 = this.f54193a.h() - 1; h2 >= 0; h2--) {
                this.f54193a.i(h2).k = true;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int h2 = this.f54193a.h() - 1; h2 >= 0; h2--) {
                this.f54193a.i(h2).e();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f54192g) {
                Log.v("LoaderManager", "Retaining in " + this);
            }
            if (!this.f54196d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
                return;
            }
            this.f54197e = true;
            this.f54196d = false;
            for (int h2 = this.f54193a.h() - 1; h2 >= 0; h2--) {
                this.f54193a.i(h2).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f54192g) {
                Log.v("LoaderManager", "Starting in " + this);
            }
            if (this.f54196d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
                return;
            }
            this.f54196d = true;
            for (int h2 = this.f54193a.h() - 1; h2 >= 0; h2--) {
                this.f54193a.i(h2).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f54192g) {
                Log.v("LoaderManager", "Stopping in " + this);
            }
            if (!this.f54196d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
                return;
            }
            for (int h2 = this.f54193a.h() - 1; h2 >= 0; h2--) {
                this.f54193a.i(h2).h();
            }
            this.f54196d = false;
        }
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            if (this.f54193a.h() > 0) {
                printWriter.print(str);
                printWriter.println("Active Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f54193a.h(); i2++) {
                    a i3 = this.f54193a.i(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f54193a.g(i2));
                    printWriter.print(": ");
                    printWriter.println(i3.toString());
                    i3.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
            if (this.f54194b.h() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i4 = 0; i4 < this.f54194b.h(); i4++) {
                    a i5 = this.f54194b.i(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f54194b.g(i4));
                    printWriter.print(": ");
                    printWriter.println(i5.toString());
                    i5.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f54197e) {
            if (f54192g) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f54197e = false;
            for (int h2 = this.f54193a.h() - 1; h2 >= 0; h2--) {
                this.f54193a.i(h2).d();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int h2 = this.f54193a.h();
            boolean z = false;
            for (int i2 = 0; i2 < h2; i2++) {
                a i3 = this.f54193a.i(i2);
                z |= i3.f54206h && !i3.f54204f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kVar) == null) {
            this.f54198f = kVar;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("LoaderManager{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" in ");
            d.a.q0.o.a.c.c.a(this.f54198f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
