package d.a.o0.o.a.a;

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
import d.a.o0.o.a.a.p;
import d.a.o0.o.a.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
public class q extends p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f51394g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.o0.o.a.c.g<a> f51395a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.o0.o.a.c.g<a> f51396b;

    /* renamed from: c  reason: collision with root package name */
    public final String f51397c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51398d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51399e;

    /* renamed from: f  reason: collision with root package name */
    public k f51400f;

    /* loaded from: classes7.dex */
    public final class a implements d.b<Object>, d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f51401a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f51402b;

        /* renamed from: c  reason: collision with root package name */
        public p.a<Object> f51403c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.o0.o.a.b.d<Object> f51404d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51405e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f51406f;

        /* renamed from: g  reason: collision with root package name */
        public Object f51407g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f51408h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f51409i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ q o;

        public void a(d.a.o0.o.a.b.d<Object> dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || this.f51403c == null) {
                return;
            }
            String str = null;
            if (this.o.f51400f != null) {
                str = this.o.f51400f.f51355d.s;
                this.o.f51400f.f51355d.s = "onLoadFinished";
            }
            try {
                if (q.f51394g) {
                    Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.a(obj));
                }
                this.f51403c.b(dVar, obj);
                this.f51406f = true;
            } finally {
                if (this.o.f51400f != null) {
                    this.o.f51400f.f51355d.s = str;
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (q.f51394g) {
                    Log.v("LoaderManager", "  Destroying: " + this);
                }
                this.l = true;
                boolean z = this.f51406f;
                this.f51406f = false;
                if (this.f51403c != null && this.f51404d != null && this.f51405e && z) {
                    if (q.f51394g) {
                        Log.v("LoaderManager", "  Reseting: " + this);
                    }
                    if (this.o.f51400f != null) {
                        str = this.o.f51400f.f51355d.s;
                        this.o.f51400f.f51355d.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.f51403c.a(this.f51404d);
                    } finally {
                        if (this.o.f51400f != null) {
                            this.o.f51400f.f51355d.s = str;
                        }
                    }
                }
                this.f51403c = null;
                this.f51407g = null;
                this.f51405e = false;
                d.a.o0.o.a.b.d<Object> dVar = this.f51404d;
                if (dVar != null) {
                    if (this.m) {
                        this.m = false;
                        dVar.h(this);
                        this.f51404d.i(this);
                    }
                    this.f51404d.e();
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
                printWriter.print(this.f51401a);
                printWriter.print(" mArgs=");
                printWriter.println(this.f51402b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f51403c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.f51404d);
                d.a.o0.o.a.b.d<Object> dVar = this.f51404d;
                if (dVar != null) {
                    dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.f51405e || this.f51406f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f51405e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f51406f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f51407g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f51408h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.f51409i);
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
                if (this.f51409i) {
                    if (q.f51394g) {
                        Log.v("LoaderManager", "  Finished Retaining: " + this);
                    }
                    this.f51409i = false;
                    boolean z = this.f51408h;
                    if (z != this.j && !z) {
                        h();
                    }
                }
                if (this.f51408h && this.f51405e && !this.k) {
                    a(this.f51404d, this.f51407g);
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f51408h && this.k) {
                this.k = false;
                if (this.f51405e) {
                    a(this.f51404d, this.f51407g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (q.f51394g) {
                    Log.v("LoaderManager", "  Retaining: " + this);
                }
                this.f51409i = true;
                this.j = this.f51408h;
                this.f51408h = false;
                this.f51403c = null;
            }
        }

        public void g() {
            p.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.f51409i && this.j) {
                    this.f51408h = true;
                } else if (this.f51408h) {
                } else {
                    this.f51408h = true;
                    if (q.f51394g) {
                        Log.v("LoaderManager", "  Starting: " + this);
                    }
                    if (this.f51404d == null && (aVar = this.f51403c) != null) {
                        this.f51404d = aVar.onCreateLoader(this.f51401a, this.f51402b);
                    }
                    d.a.o0.o.a.b.d<Object> dVar = this.f51404d;
                    if (dVar != null) {
                        if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f51404d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f51404d);
                        }
                        if (!this.m) {
                            this.f51404d.c(this.f51401a, this);
                            this.f51404d.d(this);
                            this.m = true;
                        }
                        this.f51404d.f();
                        throw null;
                    }
                }
            }
        }

        public void h() {
            d.a.o0.o.a.b.d<Object> dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (q.f51394g) {
                    Log.v("LoaderManager", "  Stopping: " + this);
                }
                this.f51408h = false;
                if (this.f51409i || (dVar = this.f51404d) == null || !this.m) {
                    return;
                }
                this.m = false;
                dVar.h(this);
                this.f51404d.i(this);
                this.f51404d.g();
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
                sb.append(this.f51401a);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                d.a.o0.o.a.c.c.a(this.f51404d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1353572527, "Ld/a/o0/o/a/a/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1353572527, "Ld/a/o0/o/a/a/q;");
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
        this.f51395a = new d.a.o0.o.a.c.g<>();
        this.f51396b = new d.a.o0.o.a.c.g<>();
        this.f51397c = str;
        this.f51400f = kVar;
        this.f51398d = z;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f51399e) {
                if (f51394g) {
                    Log.v("LoaderManager", "Destroying Active in " + this);
                }
                for (int h2 = this.f51395a.h() - 1; h2 >= 0; h2--) {
                    this.f51395a.i(h2).b();
                }
                this.f51395a.d();
            }
            if (f51394g) {
                Log.v("LoaderManager", "Destroying Inactive in " + this);
            }
            for (int h3 = this.f51396b.h() - 1; h3 >= 0; h3--) {
                this.f51396b.i(h3).b();
            }
            this.f51396b.d();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int h2 = this.f51395a.h() - 1; h2 >= 0; h2--) {
                this.f51395a.i(h2).k = true;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int h2 = this.f51395a.h() - 1; h2 >= 0; h2--) {
                this.f51395a.i(h2).e();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f51394g) {
                Log.v("LoaderManager", "Retaining in " + this);
            }
            if (!this.f51398d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
                return;
            }
            this.f51399e = true;
            this.f51398d = false;
            for (int h2 = this.f51395a.h() - 1; h2 >= 0; h2--) {
                this.f51395a.i(h2).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f51394g) {
                Log.v("LoaderManager", "Starting in " + this);
            }
            if (this.f51398d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
                return;
            }
            this.f51398d = true;
            for (int h2 = this.f51395a.h() - 1; h2 >= 0; h2--) {
                this.f51395a.i(h2).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f51394g) {
                Log.v("LoaderManager", "Stopping in " + this);
            }
            if (!this.f51398d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
                return;
            }
            for (int h2 = this.f51395a.h() - 1; h2 >= 0; h2--) {
                this.f51395a.i(h2).h();
            }
            this.f51398d = false;
        }
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            if (this.f51395a.h() > 0) {
                printWriter.print(str);
                printWriter.println("Active Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f51395a.h(); i2++) {
                    a i3 = this.f51395a.i(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f51395a.g(i2));
                    printWriter.print(": ");
                    printWriter.println(i3.toString());
                    i3.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
            if (this.f51396b.h() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i4 = 0; i4 < this.f51396b.h(); i4++) {
                    a i5 = this.f51396b.i(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f51396b.g(i4));
                    printWriter.print(": ");
                    printWriter.println(i5.toString());
                    i5.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f51399e) {
            if (f51394g) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f51399e = false;
            for (int h2 = this.f51395a.h() - 1; h2 >= 0; h2--) {
                this.f51395a.i(h2).d();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int h2 = this.f51395a.h();
            boolean z = false;
            for (int i2 = 0; i2 < h2; i2++) {
                a i3 = this.f51395a.i(i2);
                z |= i3.f51408h && !i3.f51406f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kVar) == null) {
            this.f51400f = kVar;
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
            d.a.o0.o.a.c.c.a(this.f51400f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
