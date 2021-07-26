package d.a.a0.a.h;

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
import d.a.a0.a.h.i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "def";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f41105a;

    /* renamed from: b  reason: collision with root package name */
    public String f41106b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f41107c;

    /* renamed from: d  reason: collision with root package name */
    public List<i> f41108d;

    /* renamed from: e  reason: collision with root package name */
    public c f41109e;

    /* renamed from: f  reason: collision with root package name */
    public c f41110f;

    /* renamed from: g  reason: collision with root package name */
    public i f41111g;

    /* renamed from: h  reason: collision with root package name */
    public i.c f41112h;

    /* renamed from: i  reason: collision with root package name */
    public Context f41113i;
    public Boolean j;
    public boolean k;
    public i.c l;

    /* renamed from: d.a.a0.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0543a extends i.c<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f41114a;

        public C0543a(a aVar) {
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
            this.f41114a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a0.a.h.i.c
        /* renamed from: e */
        public void a(i iVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, iVar, str) == null) {
                this.f41114a.f41108d.remove(iVar);
                this.f41114a.f41107c.add(iVar);
                if (iVar == this.f41114a.f41111g) {
                    this.f41114a.f41105a.i(a.m, this.f41114a.f41111g.m());
                }
                if (this.f41114a.q()) {
                    this.f41114a.r();
                }
                super.a(iVar, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a0.a.h.i.c
        /* renamed from: f */
        public void b(i iVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, iVar, exc) == null) {
                super.b(iVar, exc);
                this.f41114a.s();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a0.a.h.i.c
        /* renamed from: g */
        public void c(i iVar, long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{iVar, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                super.c(iVar, j, j2, i2);
                int k = this.f41114a.k();
                if (this.f41114a.f41112h != null) {
                    this.f41114a.f41112h.c(this.f41114a, 0L, 100L, k);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f41115a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1983027412, "Ld/a/a0/a/h/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1983027412, "Ld/a/a0/a/h/a$b;");
                    return;
                }
            }
            f41115a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-310443030, "Ld/a/a0/a/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-310443030, "Ld/a/a0/a/h/a;");
        }
    }

    public /* synthetic */ a(C0543a c0543a) {
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
            return b.f41115a;
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
                this.f41107c.add(iVar);
                return;
            }
            if (this.f41108d == null) {
                this.f41108d = new ArrayList();
            }
            this.f41108d.add(iVar);
        }
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<i> list = this.f41108d;
            float f2 = 100.0f;
            if (list != null && list.size() != 0) {
                float size = 100.0f / (this.f41107c.size() + this.f41108d.size());
                float f3 = 0.0f;
                for (int i2 = 0; i2 < this.f41108d.size(); i2++) {
                    f3 += (this.f41108d.get(i2).n() / 100.0f) * size;
                }
                f2 = (this.f41107c.size() * size) + f3;
            }
            return (int) f2;
        }
        return invokeV.intValue;
    }

    public File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41110f.f41125g : (File) invokeV.objValue;
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41109e.f41125g : (File) invokeV.objValue;
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
            boolean k0 = d.a.a0.a.a.k0();
            if (p()) {
                i("ARControllerProxy.loadSoFile " + k0);
            }
            if (!k0) {
                return this.j.booleanValue();
            }
            File file = this.f41110f.f41125g;
            if (p()) {
                i("setResConfig " + file);
            }
            if (file != null) {
                d.a.a0.a.b.u(new d.a.a0.a.c(file.getAbsolutePath()));
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
            this.f41107c.clear();
            List<i> list = this.f41108d;
            if (list != null) {
                list.clear();
            }
            if ("live".equals(d.a.a0.a.b.f())) {
                this.f41109e = c.i();
                this.f41110f = c.g();
            }
            if (BdUploadHandler.MEDIA_SOURCE_KEY.equals(d.a.a0.a.b.f())) {
                this.f41109e = c.h();
                this.f41110f = c.f();
            }
            if ("tieba".equals(d.a.a0.a.b.f())) {
                this.f41109e = c.i();
                this.f41110f = c.f();
            }
            d.a.a0.a.h.b bVar = new d.a.a0.a.h.b(this.f41110f);
            this.f41111g = bVar;
            h(bVar);
            h(new d.a.a0.a.h.b(this.f41109e));
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? d.a.a0.a.b.n() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        List<i> list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41107c.size() > 0 && ((list = this.f41108d) == null || list.size() == 0) : invokeV.booleanValue;
    }

    public void r() {
        File file;
        i.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean n = n(this.f41113i);
            String str = null;
            if (!n && (cVar = this.f41112h) != null) {
                cVar.b(null, null);
                return;
            }
            this.f41105a.n(this.f41106b);
            this.f41105a.f();
            if (p()) {
                i("all onCompleted " + n);
            }
            synchronized (this) {
                this.k = false;
            }
            if (this.f41112h == null || !n) {
                return;
            }
            c cVar2 = this.f41110f;
            if (cVar2 != null && (file = cVar2.f41125g) != null) {
                str = file.getAbsolutePath();
            }
            this.f41112h.a(this, str);
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
            this.f41106b = this.f41105a.e(m);
            List<i> list = this.f41108d;
            if (list != null && list.size() > 0) {
                for (i iVar : this.f41108d) {
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
            this.f41113i = context;
            this.f41112h = cVar;
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
        this.f41107c = new ArrayList();
        this.f41108d = null;
        this.l = new C0543a(this);
        h hVar = new h(d.d().g());
        this.f41105a = hVar;
        hVar.h(m);
        o();
    }
}
