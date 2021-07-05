package d.a.z.b;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.z.b.g.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f71468d = "a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.z.b.c.a f71469a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f71470b;

    /* renamed from: c  reason: collision with root package name */
    public int f71471c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1095804607, "Ld/a/z/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1095804607, "Ld/a/z/b/a;");
        }
    }

    public a(Object obj, List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f71471c = 0;
        b(obj, list);
    }

    public void a(long j) {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.f71469a == null || (list = this.f71470b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (b bVar : this.f71470b) {
                this.f71469a.b(bVar.c());
                bVar.b(j);
            }
            notifyAll();
        }
        this.f71469a.d(j);
        this.f71469a.e();
    }

    public final void b(Object obj, List<c> list) {
        b bVar;
        d.a.z.b.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) || list == null || list.size() == 0) {
            return;
        }
        List<b> list2 = this.f71470b;
        if (list2 == null) {
            this.f71470b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                this.f71470b.add(new b(list.get(i2)));
                if (list.get(i2).n()) {
                    this.f71471c = i2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = this.f71470b.size();
        int i3 = this.f71471c;
        if (size > i3) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.f71469a = new d.a.z.b.c.a(this.f71470b.get(this.f71471c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.f71469a = new d.a.z.b.c.a(this.f71470b.get(this.f71471c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.f71469a = new d.a.z.b.c.a(this.f71470b.get(this.f71471c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<b> list3 = this.f71470b;
                if (list3 != null && list3 != null && (bVar = list3.get(i3)) != null && (aVar = this.f71469a) != null) {
                    aVar.f(bVar.c());
                }
            }
        }
        for (b bVar2 : this.f71470b) {
            d.a.z.b.c.a aVar2 = this.f71469a;
            if (aVar2 != null) {
                aVar2.b(bVar2.c());
                bVar2.f();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.z.b.c.a aVar = this.f71469a;
            if (aVar != null) {
                aVar.g();
                this.f71469a = null;
            }
            List<b> list = this.f71470b;
            if (list != null) {
                for (b bVar : list) {
                    bVar.e();
                }
                this.f71470b.clear();
                this.f71470b = null;
            }
        }
    }

    public void d(d.a.z.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            for (b bVar : this.f71470b) {
                d.a.z.b.c.a aVar = this.f71469a;
                if (aVar != null) {
                    aVar.b(bVar.c());
                    bVar.g(cVar);
                }
            }
        }
    }

    public void e(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(f71468d, "updateSurfaceDrawer !!!");
            this.f71469a.c();
            for (b bVar : this.f71470b) {
                bVar.e();
            }
            this.f71470b.clear();
            b(null, list);
        }
    }
}
