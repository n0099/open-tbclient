package d.b.c.b.h.a;

import android.content.Context;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.b.c.b.l;
import d.b.c.b.m;
import io.reactivex.annotations.SchedulerSupport;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.tea.crash.c f69426a;

    /* renamed from: b  reason: collision with root package name */
    public Context f69427b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.b.g f69428c;

    /* renamed from: d  reason: collision with root package name */
    public b f69429d;

    /* renamed from: e  reason: collision with root package name */
    public d f69430e;

    public c(com.bytedance.tea.crash.c cVar, Context context, b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, context, bVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69426a = cVar;
        this.f69427b = context;
        this.f69429d = bVar;
        this.f69430e = dVar;
        this.f69428c = m.a().d();
    }

    public d.b.c.b.e.a a(d.b.c.b.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null) {
                aVar = new d.b.c.b.e.a();
            }
            c(aVar);
            g(aVar);
            return aVar;
        }
        return (d.b.c.b.e.a) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c(d.b.c.b.e.a aVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (d() && (bVar = this.f69429d) != null) {
                aVar.e(bVar);
            }
            aVar.b(m.g());
            aVar.k("is_background", Boolean.valueOf(!l.b.g(this.f69427b)));
            aVar.k("pid", Integer.valueOf(Process.myPid()));
            aVar.k("battery", Integer.valueOf(this.f69430e.a()));
            aVar.h(this.f69428c.e());
            aVar.m(m.j());
            aVar.a(m.k(), m.l());
            aVar.g(this.f69428c.f());
            aVar.i(l.o.b(this.f69427b));
            if (b()) {
                f(aVar);
            }
            aVar.f(this.f69428c.d());
            String h2 = m.h();
            if (h2 != null) {
                aVar.k(Constant.KEY_BUSINESS, h2);
            }
            if (m.i()) {
                aVar.k("is_mp", 1);
            }
            aVar.n(m.c().b());
            aVar.k("crash_uuid", UUID.randomUUID().toString());
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void e(d.b.c.b.e.a aVar) {
        Map<String, Object> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || (a2 = m.a().a()) == null) {
            return;
        }
        if (a2.containsKey("app_version")) {
            aVar.k("crash_version", a2.get("app_version"));
        }
        if (a2.containsKey("version_name")) {
            aVar.k("app_version", a2.get("version_name"));
        }
        if (a2.containsKey("version_code")) {
            try {
                aVar.k("crash_version_code", Integer.valueOf(Integer.parseInt(a2.get("version_code").toString())));
            } catch (Exception unused) {
                aVar.k("crash_version_code", a2.get("version_code"));
            }
        }
        if (a2.containsKey("update_version_code")) {
            try {
                aVar.k("crash_update_version_code", Integer.valueOf(Integer.parseInt(a2.get("update_version_code").toString())));
            } catch (Exception unused2) {
                aVar.k("crash_update_version_code", a2.get("update_version_code"));
            }
        }
    }

    public void f(d.b.c.b.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            aVar.l(d.b.c.b.h.f.b(m.f().b(), m.f().c()));
        }
    }

    public final void g(d.b.c.b.e.a aVar) {
        List<d.b.c.b.b> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || (a2 = m.c().a(this.f69426a)) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (d.b.c.b.b bVar : a2) {
            Map<? extends String, ? extends String> a3 = bVar.a(this.f69426a);
            if (a3 != null) {
                try {
                    for (String str : a3.keySet()) {
                        jSONObject.put(str, a3.get(str));
                    }
                } catch (Throwable unused) {
                }
            }
        }
        aVar.k(SchedulerSupport.CUSTOM, jSONObject);
    }
}
