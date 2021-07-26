package d.a.q0.z3.m.c.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import d.a.q0.z3.m.c.d.e;
import d.a.q0.z3.m.c.d.g;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile i f67596c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f67597a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f67598b;

    /* loaded from: classes8.dex */
    public class a implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f67599a;

        public a(i iVar) {
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
            this.f67599a = iVar;
        }

        @Override // d.a.q0.z3.m.c.d.m
        public void a(e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                e.a().c(bVar);
                if (d.a.w0.t.h.e(this.f67599a.f67598b)) {
                    return;
                }
                i iVar = this.f67599a;
                iVar.h((n) d.a.w0.t.h.c(iVar.f67598b, 0));
                d.a.w0.t.h.g(this.f67599a.f67598b, 0);
            }
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67598b = new Vector();
        this.f67597a = new g.b().d();
    }

    public static i f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f67596c == null) {
                synchronized (i.class) {
                    if (f67596c == null) {
                        f67596c = new i();
                    }
                }
            }
            return f67596c;
        }
        return (i) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f67597a == null) {
            throw new IllegalStateException(ImageLoader.ERROR_NOT_INIT);
        }
    }

    public Bitmap d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap a2 = g().a(str);
            if (a2 == null || a2.isRecycled()) {
                Bitmap a3 = e().a(str);
                if (a3 == null || a3.isRecycled()) {
                    return null;
                }
                return a3;
            }
            return a2;
        }
        return (Bitmap) invokeL.objValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c();
            String str = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
            if (!TextUtils.equals(this.f67597a.f67580c.b(), str)) {
                this.f67597a.f67580c.d(str);
            }
            return this.f67597a.f67580c;
        }
        return (b) invokeV.objValue;
    }

    public l g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.f67597a.f67579b;
        }
        return (l) invokeV.objValue;
    }

    public final void h(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nVar) == null) {
            c();
            e.b b2 = e.a().b();
            if (b2 != null) {
                b2.t(this.f67597a.f67578a);
                b2.setDataSource(nVar.f67604a);
                b2.o(nVar, new a(this));
                return;
            }
            this.f67598b.add(nVar);
        }
    }

    public void i(o oVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, oVar, fVar) == null) {
            List<n> c2 = k.c(oVar, fVar);
            if (d.a.w0.t.h.e(c2)) {
                return;
            }
            for (n nVar : c2) {
                h(nVar);
            }
        }
    }

    public void j(p pVar, f fVar) {
        n b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, pVar, fVar) == null) || (b2 = k.b(pVar, fVar)) == null) {
            return;
        }
        h(b2);
    }
}
