package d.a.o0.a.f1.g;

import android.text.TextUtils;
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
import d.a.o0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44995e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44996a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.a.v2.e1.b<b> f44997b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0712b> f44998c;

    /* renamed from: d  reason: collision with root package name */
    public String f44999d;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.o0.a.f1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0712b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f45000a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f45001b;

        /* renamed from: c  reason: collision with root package name */
        public String f45002c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f45003d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f45004e;

        public /* synthetic */ C0712b(b bVar, a aVar) {
            this(bVar);
        }

        public synchronized C0712b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                synchronized (this) {
                    List<String> list = this.f45000a;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    list.add(str);
                }
                return this;
            }
            return (C0712b) invokeL.objValue;
        }

        public C0712b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f45002c = str;
                return this;
            }
            return (C0712b) invokeL.objValue;
        }

        public synchronized C0712b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    d(this.f45003d.size());
                }
                return this;
            }
            return (C0712b) invokeV.objValue;
        }

        public synchronized C0712b d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                synchronized (this) {
                    if (i2 < 1) {
                        i2 = 1;
                    }
                    if (i2 > this.f45003d.size()) {
                        i2 = this.f45003d.size();
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        b bVar = this.f45004e;
                        bVar.e("[Trace]==> " + this.f45003d.get(i3).toString());
                    }
                }
                return this;
            }
            return (C0712b) invokeI.objValue;
        }

        public synchronized C0712b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    d(1);
                }
                return this;
            }
            return (C0712b) invokeV.objValue;
        }

        public C0712b(b bVar) {
            StackTraceElement[] stackTrace;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45004e = bVar;
            this.f45000a = new ArrayList();
            this.f45001b = new ArrayList();
            this.f45003d = new ArrayList();
            int i4 = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i4++;
                if (i4 > 2 && !stackTraceElement.getClassName().startsWith(bVar.f44999d)) {
                    this.f45003d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.a.v2.e1.b<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && b.f44995e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && b.f44995e) {
                for (C0712b c0712b : bVar.f44998c) {
                    for (String str : c0712b.f45000a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0712b.f45002c) ? h2 : c0712b.f45002c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1299126418, "Ld/a/o0/a/f1/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1299126418, "Ld/a/o0/a/f1/g/b;");
                return;
            }
        }
        f44995e = k.f46335a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44998c = new ArrayList();
        this.f44999d = b.class.getPackage().getName();
    }

    public synchronized C0712b d() {
        InterceptResult invokeV;
        C0712b c0712b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                c0712b = new C0712b(this, null);
                this.f44998c.add(c0712b);
            }
            return c0712b;
        }
        return (C0712b) invokeV.objValue;
    }

    public synchronized C0712b e(String str) {
        InterceptResult invokeL;
        C0712b d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                d2 = d();
                d2.a(str);
            }
            return d2;
        }
        return (C0712b) invokeL.objValue;
    }

    public synchronized C0712b f(String str, String str2) {
        InterceptResult invokeLL;
        C0712b e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            synchronized (this) {
                e2 = e(str2);
                e2.b(str);
            }
            return e2;
        }
        return (C0712b) invokeLL.objValue;
    }

    public b g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f44996a = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44996a : (String) invokeV.objValue;
    }

    public synchronized List<C0712b> i() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.f44998c);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                k(this.f44997b);
            }
            return this;
        }
        return (b) invokeV.objValue;
    }

    public synchronized b k(d.a.o0.a.v2.e1.b<b> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            synchronized (this) {
                if (bVar == null) {
                    try {
                        bVar = new c(this, null);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                bVar.onCallback(this);
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b l(d.a.o0.a.v2.e1.b<b> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            this.f44997b = bVar;
            return this;
        }
        return (b) invokeL.objValue;
    }
}
