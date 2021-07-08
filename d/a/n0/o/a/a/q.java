package d.a.n0.o.a.a;

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
import d.a.n0.o.a.a.p;
import d.a.n0.o.a.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
public class q extends p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f50890g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.n0.o.a.c.g<a> f50891a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.n0.o.a.c.g<a> f50892b;

    /* renamed from: c  reason: collision with root package name */
    public final String f50893c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50894d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50895e;

    /* renamed from: f  reason: collision with root package name */
    public k f50896f;

    /* loaded from: classes7.dex */
    public final class a implements d.b<Object>, d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f50897a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f50898b;

        /* renamed from: c  reason: collision with root package name */
        public p.a<Object> f50899c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.n0.o.a.b.d<Object> f50900d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f50901e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f50902f;

        /* renamed from: g  reason: collision with root package name */
        public Object f50903g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f50904h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f50905i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ q o;

        public void a(d.a.n0.o.a.b.d<Object> dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || this.f50899c == null) {
                return;
            }
            String str = null;
            if (this.o.f50896f != null) {
                str = this.o.f50896f.f50851d.s;
                this.o.f50896f.f50851d.s = "onLoadFinished";
            }
            try {
                if (q.f50890g) {
                    Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.a(obj));
                }
                this.f50899c.b(dVar, obj);
                this.f50902f = true;
            } finally {
                if (this.o.f50896f != null) {
                    this.o.f50896f.f50851d.s = str;
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (q.f50890g) {
                    Log.v("LoaderManager", "  Destroying: " + this);
                }
                this.l = true;
                boolean z = this.f50902f;
                this.f50902f = false;
                if (this.f50899c != null && this.f50900d != null && this.f50901e && z) {
                    if (q.f50890g) {
                        Log.v("LoaderManager", "  Reseting: " + this);
                    }
                    if (this.o.f50896f != null) {
                        str = this.o.f50896f.f50851d.s;
                        this.o.f50896f.f50851d.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.f50899c.a(this.f50900d);
                    } finally {
                        if (this.o.f50896f != null) {
                            this.o.f50896f.f50851d.s = str;
                        }
                    }
                }
                this.f50899c = null;
                this.f50903g = null;
                this.f50901e = false;
                d.a.n0.o.a.b.d<Object> dVar = this.f50900d;
                if (dVar != null) {
                    if (this.m) {
                        this.m = false;
                        dVar.h(this);
                        this.f50900d.i(this);
                    }
                    this.f50900d.e();
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
                printWriter.print(this.f50897a);
                printWriter.print(" mArgs=");
                printWriter.println(this.f50898b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f50899c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.f50900d);
                d.a.n0.o.a.b.d<Object> dVar = this.f50900d;
                if (dVar != null) {
                    dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.f50901e || this.f50902f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f50901e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f50902f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f50903g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f50904h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.f50905i);
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
                if (this.f50905i) {
                    if (q.f50890g) {
                        Log.v("LoaderManager", "  Finished Retaining: " + this);
                    }
                    this.f50905i = false;
                    boolean z = this.f50904h;
                    if (z != this.j && !z) {
                        h();
                    }
                }
                if (this.f50904h && this.f50901e && !this.k) {
                    a(this.f50900d, this.f50903g);
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f50904h && this.k) {
                this.k = false;
                if (this.f50901e) {
                    a(this.f50900d, this.f50903g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (q.f50890g) {
                    Log.v("LoaderManager", "  Retaining: " + this);
                }
                this.f50905i = true;
                this.j = this.f50904h;
                this.f50904h = false;
                this.f50899c = null;
            }
        }

        public void g() {
            p.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.f50905i && this.j) {
                    this.f50904h = true;
                } else if (this.f50904h) {
                } else {
                    this.f50904h = true;
                    if (q.f50890g) {
                        Log.v("LoaderManager", "  Starting: " + this);
                    }
                    if (this.f50900d == null && (aVar = this.f50899c) != null) {
                        this.f50900d = aVar.onCreateLoader(this.f50897a, this.f50898b);
                    }
                    d.a.n0.o.a.b.d<Object> dVar = this.f50900d;
                    if (dVar != null) {
                        if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f50900d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f50900d);
                        }
                        if (!this.m) {
                            this.f50900d.c(this.f50897a, this);
                            this.f50900d.d(this);
                            this.m = true;
                        }
                        this.f50900d.f();
                        throw null;
                    }
                }
            }
        }

        public void h() {
            d.a.n0.o.a.b.d<Object> dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (q.f50890g) {
                    Log.v("LoaderManager", "  Stopping: " + this);
                }
                this.f50904h = false;
                if (this.f50905i || (dVar = this.f50900d) == null || !this.m) {
                    return;
                }
                this.m = false;
                dVar.h(this);
                this.f50900d.i(this);
                this.f50900d.g();
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
                sb.append(this.f50897a);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                d.a.n0.o.a.c.c.a(this.f50900d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1144443410, "Ld/a/n0/o/a/a/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1144443410, "Ld/a/n0/o/a/a/q;");
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
        this.f50891a = new d.a.n0.o.a.c.g<>();
        this.f50892b = new d.a.n0.o.a.c.g<>();
        this.f50893c = str;
        this.f50896f = kVar;
        this.f50894d = z;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f50895e) {
                if (f50890g) {
                    Log.v("LoaderManager", "Destroying Active in " + this);
                }
                for (int h2 = this.f50891a.h() - 1; h2 >= 0; h2--) {
                    this.f50891a.i(h2).b();
                }
                this.f50891a.d();
            }
            if (f50890g) {
                Log.v("LoaderManager", "Destroying Inactive in " + this);
            }
            for (int h3 = this.f50892b.h() - 1; h3 >= 0; h3--) {
                this.f50892b.i(h3).b();
            }
            this.f50892b.d();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int h2 = this.f50891a.h() - 1; h2 >= 0; h2--) {
                this.f50891a.i(h2).k = true;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int h2 = this.f50891a.h() - 1; h2 >= 0; h2--) {
                this.f50891a.i(h2).e();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f50890g) {
                Log.v("LoaderManager", "Retaining in " + this);
            }
            if (!this.f50894d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
                return;
            }
            this.f50895e = true;
            this.f50894d = false;
            for (int h2 = this.f50891a.h() - 1; h2 >= 0; h2--) {
                this.f50891a.i(h2).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f50890g) {
                Log.v("LoaderManager", "Starting in " + this);
            }
            if (this.f50894d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
                return;
            }
            this.f50894d = true;
            for (int h2 = this.f50891a.h() - 1; h2 >= 0; h2--) {
                this.f50891a.i(h2).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f50890g) {
                Log.v("LoaderManager", "Stopping in " + this);
            }
            if (!this.f50894d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
                return;
            }
            for (int h2 = this.f50891a.h() - 1; h2 >= 0; h2--) {
                this.f50891a.i(h2).h();
            }
            this.f50894d = false;
        }
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            if (this.f50891a.h() > 0) {
                printWriter.print(str);
                printWriter.println("Active Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f50891a.h(); i2++) {
                    a i3 = this.f50891a.i(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f50891a.g(i2));
                    printWriter.print(": ");
                    printWriter.println(i3.toString());
                    i3.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
            if (this.f50892b.h() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i4 = 0; i4 < this.f50892b.h(); i4++) {
                    a i5 = this.f50892b.i(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f50892b.g(i4));
                    printWriter.print(": ");
                    printWriter.println(i5.toString());
                    i5.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f50895e) {
            if (f50890g) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f50895e = false;
            for (int h2 = this.f50891a.h() - 1; h2 >= 0; h2--) {
                this.f50891a.i(h2).d();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int h2 = this.f50891a.h();
            boolean z = false;
            for (int i2 = 0; i2 < h2; i2++) {
                a i3 = this.f50891a.i(i2);
                z |= i3.f50904h && !i3.f50902f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kVar) == null) {
            this.f50896f = kVar;
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
            d.a.n0.o.a.c.c.a(this.f50896f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
