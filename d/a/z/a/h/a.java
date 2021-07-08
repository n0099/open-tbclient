package d.a.z.a.h;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.z.a.h.i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "def";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f68573a;

    /* renamed from: b  reason: collision with root package name */
    public String f68574b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f68575c;

    /* renamed from: d  reason: collision with root package name */
    public List<i> f68576d;

    /* renamed from: e  reason: collision with root package name */
    public c f68577e;

    /* renamed from: f  reason: collision with root package name */
    public c f68578f;

    /* renamed from: g  reason: collision with root package name */
    public i f68579g;

    /* renamed from: h  reason: collision with root package name */
    public i.c f68580h;

    /* renamed from: i  reason: collision with root package name */
    public Context f68581i;
    public Boolean j;
    public boolean k;
    public i.c l;

    /* renamed from: d.a.z.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1955a extends i.c<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68582a;

        public C1955a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68582a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.z.a.h.i.c
        /* renamed from: e */
        public void a(i iVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, iVar, str) == null) {
                this.f68582a.f68576d.remove(iVar);
                this.f68582a.f68575c.add(iVar);
                if (iVar == this.f68582a.f68579g) {
                    this.f68582a.f68573a.i(a.m, this.f68582a.f68579g.m());
                }
                if (this.f68582a.q()) {
                    this.f68582a.r();
                }
                super.a(iVar, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.z.a.h.i.c
        /* renamed from: f */
        public void b(i iVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, iVar, exc) == null) {
                super.b(iVar, exc);
                this.f68582a.s();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.z.a.h.i.c
        /* renamed from: g */
        public void c(i iVar, long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{iVar, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                super.c(iVar, j, j2, i2);
                int k = this.f68582a.k();
                if (this.f68582a.f68580h != null) {
                    this.f68582a.f68580h.c(this.f68582a, 0L, 100L, k);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f68583a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1552097643, "Ld/a/z/a/h/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1552097643, "Ld/a/z/a/h/a$b;");
                    return;
                }
            }
            f68583a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-829668887, "Ld/a/z/a/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-829668887, "Ld/a/z/a/h/a;");
        }
    }

    public /* synthetic */ a(C1955a c1955a) {
        this();
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            Log.d("DuAr_InitModel", str);
        }
    }

    public static final a j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            m = str;
            return b.f68583a;
        }
        return (a) invokeL.objValue;
    }

    public final void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            boolean q = iVar.q();
            if (p()) {
                i("isLoaded " + q + StringUtil.ARRAY_ELEMENT_SEPARATOR + iVar.o() + " to " + iVar.m());
            }
            if (iVar.q()) {
                this.f68575c.add(iVar);
                return;
            }
            if (this.f68576d == null) {
                this.f68576d = new ArrayList();
            }
            this.f68576d.add(iVar);
        }
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<i> list = this.f68576d;
            float f2 = 100.0f;
            if (list != null && list.size() != 0) {
                float size = 100.0f / (this.f68575c.size() + this.f68576d.size());
                float f3 = 0.0f;
                for (int i2 = 0; i2 < this.f68576d.size(); i2++) {
                    f3 += (this.f68576d.get(i2).n() / 100.0f) * size;
                }
                f2 = (this.f68575c.size() * size) + f3;
            }
            return (int) f2;
        }
        return invokeV.intValue;
    }

    public File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68578f.f68593g : (File) invokeV.objValue;
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68577e.f68593g : (File) invokeV.objValue;
    }

    public boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Boolean bool = this.j;
            if (bool != null && bool.booleanValue()) {
                return this.j.booleanValue();
            }
            this.j = Boolean.FALSE;
            long currentTimeMillis = System.currentTimeMillis();
            boolean k0 = d.a.z.a.a.k0();
            if (p()) {
                i("ARControllerProxy.loadSoFile " + k0);
            }
            if (!k0) {
                return this.j.booleanValue();
            }
            File file = this.f68578f.f68593g;
            if (p()) {
                i("setResConfig " + file);
            }
            if (file != null) {
                d.a.z.a.b.u(new d.a.z.a.c(file.getAbsolutePath()));
            }
            if (p()) {
                i("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            Boolean bool2 = Boolean.TRUE;
            this.j = bool2;
            return bool2.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f68575c.clear();
            List<i> list = this.f68576d;
            if (list != null) {
                list.clear();
            }
            if ("live".equals(d.a.z.a.b.f())) {
                this.f68577e = c.i();
                this.f68578f = c.g();
            }
            if (BdUploadHandler.MEDIA_SOURCE_KEY.equals(d.a.z.a.b.f())) {
                this.f68577e = c.h();
                this.f68578f = c.f();
            }
            if ("tieba".equals(d.a.z.a.b.f())) {
                this.f68577e = c.i();
                this.f68578f = c.f();
            }
            d.a.z.a.h.b bVar = new d.a.z.a.h.b(this.f68578f);
            this.f68579g = bVar;
            h(bVar);
            h(new d.a.z.a.h.b(this.f68577e));
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? d.a.z.a.b.n() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        List<i> list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f68575c.size() > 0 && ((list = this.f68576d) == null || list.size() == 0) : invokeV.booleanValue;
    }

    public void r() {
        File file;
        i.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean n = n(this.f68581i);
            String str = null;
            if (!n && (cVar = this.f68580h) != null) {
                cVar.b(null, null);
                return;
            }
            this.f68573a.n(this.f68574b);
            this.f68573a.f();
            if (p()) {
                i("all onCompleted " + n);
            }
            synchronized (this) {
                this.k = false;
            }
            if (this.f68580h == null || !n) {
                return;
            }
            c cVar2 = this.f68578f;
            if (cVar2 != null && (file = cVar2.f68593g) != null) {
                str = file.getAbsolutePath();
            }
            this.f68580h.a(this, str);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (p()) {
                i("all onFailed .");
            }
            synchronized (this) {
                this.k = false;
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f68574b = this.f68573a.e(m);
            List<i> list = this.f68576d;
            if (list != null && list.size() > 0) {
                for (i iVar : this.f68576d) {
                    iVar.l(this.l);
                }
                return;
            }
            r();
        }
    }

    public void u(Context context, i.c<a> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, cVar) == null) {
            this.f68581i = context;
            this.f68580h = cVar;
            synchronized (this) {
                if (this.k) {
                    if (p()) {
                        i("start return, isLoading true");
                    }
                    return;
                }
                this.k = true;
                o();
                t();
            }
        }
    }

    public a() {
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
        this.f68575c = new ArrayList();
        this.f68576d = null;
        this.l = new C1955a(this);
        h hVar = new h(d.d().g());
        this.f68573a = hVar;
        hVar.h(m);
        o();
    }
}
