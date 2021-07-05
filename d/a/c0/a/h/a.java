package d.a.c0.a.h;

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
import d.a.c0.a.h.i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "def";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f44995a;

    /* renamed from: b  reason: collision with root package name */
    public String f44996b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f44997c;

    /* renamed from: d  reason: collision with root package name */
    public List<i> f44998d;

    /* renamed from: e  reason: collision with root package name */
    public c f44999e;

    /* renamed from: f  reason: collision with root package name */
    public c f45000f;

    /* renamed from: g  reason: collision with root package name */
    public i f45001g;

    /* renamed from: h  reason: collision with root package name */
    public i.c f45002h;

    /* renamed from: i  reason: collision with root package name */
    public Context f45003i;
    public Boolean j;
    public boolean k;
    public i.c l;

    /* renamed from: d.a.c0.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0605a extends i.c<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45004a;

        public C0605a(a aVar) {
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
            this.f45004a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.a.h.i.c
        /* renamed from: e */
        public void a(i iVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, iVar, str) == null) {
                this.f45004a.f44998d.remove(iVar);
                this.f45004a.f44997c.add(iVar);
                if (iVar == this.f45004a.f45001g) {
                    this.f45004a.f44995a.i(a.m, this.f45004a.f45001g.m());
                }
                if (this.f45004a.q()) {
                    this.f45004a.s();
                }
                super.a(iVar, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.a.h.i.c
        /* renamed from: f */
        public void b(i iVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, iVar, exc) == null) {
                super.b(iVar, exc);
                this.f45004a.t();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.a.h.i.c
        /* renamed from: g */
        public void c(i iVar, long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{iVar, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                super.c(iVar, j, j2, i2);
                int k = this.f45004a.k();
                if (this.f45004a.f45002h != null) {
                    this.f45004a.f45002h.c(this.f45004a, 0L, 100L, k);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f45005a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1281962834, "Ld/a/c0/a/h/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1281962834, "Ld/a/c0/a/h/a$b;");
                    return;
                }
            }
            f45005a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(369615340, "Ld/a/c0/a/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(369615340, "Ld/a/c0/a/h/a;");
        }
    }

    public /* synthetic */ a(C0605a c0605a) {
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
            return b.f45005a;
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
                this.f44997c.add(iVar);
                return;
            }
            if (this.f44998d == null) {
                this.f44998d = new ArrayList();
            }
            this.f44998d.add(iVar);
        }
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<i> list = this.f44998d;
            float f2 = 100.0f;
            if (list != null && list.size() != 0) {
                float size = 100.0f / (this.f44997c.size() + this.f44998d.size());
                float f3 = 0.0f;
                for (int i2 = 0; i2 < this.f44998d.size(); i2++) {
                    f3 += (this.f44998d.get(i2).n() / 100.0f) * size;
                }
                f2 = (this.f44997c.size() * size) + f3;
            }
            return (int) f2;
        }
        return invokeV.intValue;
    }

    public File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45000f.f45015g : (File) invokeV.objValue;
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44999e.f45015g : (File) invokeV.objValue;
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
            boolean r = r(context);
            if (p()) {
                i("loadSo " + r);
            }
            if (!r) {
                return this.j.booleanValue();
            }
            boolean k0 = d.a.c0.a.a.k0();
            if (p()) {
                i("ARControllerProxy.loadSoFile " + k0);
            }
            if (!k0) {
                return this.j.booleanValue();
            }
            File file = this.f45000f.f45015g;
            if (p()) {
                i("setResConfig " + file);
            }
            if (file != null) {
                d.a.c0.a.b.t(new d.a.c0.a.c(file.getAbsolutePath()));
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
            this.f44997c.clear();
            List<i> list = this.f44998d;
            if (list != null) {
                list.clear();
            }
            if ("live".equals(d.a.c0.a.b.f())) {
                this.f44999e = c.i();
                this.f45000f = c.g();
            }
            if (BdUploadHandler.MEDIA_SOURCE_KEY.equals(d.a.c0.a.b.f())) {
                this.f44999e = c.h();
                this.f45000f = c.f();
            }
            if ("tieba".equals(d.a.c0.a.b.f())) {
                this.f44999e = c.i();
                this.f45000f = c.f();
            }
            d.a.c0.a.h.b bVar = new d.a.c0.a.h.b(this.f45000f);
            this.f45001g = bVar;
            h(bVar);
            h(new d.a.c0.a.h.b(this.f44999e));
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? d.a.c0.a.b.n() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        List<i> list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f44997c.size() > 0 && ((list = this.f44998d) == null || list.size() == 0) : invokeV.booleanValue;
    }

    public boolean r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            if (d.a.s.a.a.f.b(context, this.f44999e.f45015g)) {
                return true;
            }
            d.a.s.a.a.f.a(context, this.f44999e.f45015g);
            return d.a.s.a.a.f.b(context, this.f44999e.f45015g);
        }
        return invokeL.booleanValue;
    }

    public void s() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean n = n(this.f45003i);
            this.f44995a.n(this.f44996b);
            this.f44995a.f();
            if (p()) {
                i("all onCompleted " + n);
            }
            synchronized (this) {
                this.k = false;
            }
            if (this.f45002h == null || !n) {
                return;
            }
            String str = null;
            c cVar = this.f45000f;
            if (cVar != null && (file = cVar.f45015g) != null) {
                str = file.getAbsolutePath();
            }
            this.f45002h.a(this, str);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (p()) {
                i("all onFailed .");
            }
            synchronized (this) {
                this.k = false;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f44996b = this.f44995a.e(m);
            List<i> list = this.f44998d;
            if (list != null && list.size() > 0) {
                for (i iVar : this.f44998d) {
                    iVar.l(this.l);
                }
                return;
            }
            s();
        }
    }

    public void v(Context context, i.c<a> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, cVar) == null) {
            this.f45003i = context;
            this.f45002h = cVar;
            synchronized (this) {
                if (this.k) {
                    if (p()) {
                        i("start return, isLoading true");
                    }
                    return;
                }
                this.k = true;
                o();
                u();
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
        this.f44997c = new ArrayList();
        this.f44998d = null;
        this.l = new C0605a(this);
        h hVar = new h(d.d().g());
        this.f44995a = hVar;
        hVar.h(m);
        o();
    }
}
