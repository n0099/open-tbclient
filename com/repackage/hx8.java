package com.repackage;

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
import com.repackage.dx8;
import com.repackage.fx8;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes6.dex */
public class hx8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hx8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public fx8 a;
    public List<mx8> b;

    /* loaded from: classes6.dex */
    public class a implements lx8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx8 a;

        public a(hx8 hx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx8Var;
        }

        @Override // com.repackage.lx8
        public void a(dx8.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                dx8.a().c(bVar);
                if (ab9.e(this.a.b)) {
                    return;
                }
                hx8 hx8Var = this.a;
                hx8Var.h((mx8) ab9.c(hx8Var.b, 0));
                ab9.g(this.a.b, 0);
            }
        }
    }

    public hx8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new Vector();
        this.a = new fx8.b().d();
    }

    public static hx8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (hx8.class) {
                    if (c == null) {
                        c = new hx8();
                    }
                }
            }
            return c;
        }
        return (hx8) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a == null) {
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

    public ax8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c();
            String str = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
            if (!TextUtils.equals(this.a.c.b(), str)) {
                this.a.c.d(str);
            }
            return this.a.c;
        }
        return (ax8) invokeV.objValue;
    }

    public kx8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (kx8) invokeV.objValue;
    }

    public final void h(mx8 mx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mx8Var) == null) {
            c();
            dx8.b b = dx8.a().b();
            if (b != null) {
                b.p(this.a.a);
                b.setDataSource(mx8Var.a);
                b.h(mx8Var, new a(this));
                return;
            }
            this.b.add(mx8Var);
        }
    }

    public void i(nx8 nx8Var, ex8 ex8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, nx8Var, ex8Var) == null) {
            List<mx8> c2 = jx8.c(nx8Var, ex8Var);
            if (ab9.e(c2)) {
                return;
            }
            for (mx8 mx8Var : c2) {
                h(mx8Var);
            }
        }
    }

    public void j(ox8 ox8Var, ex8 ex8Var) {
        mx8 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, ox8Var, ex8Var) == null) || (b = jx8.b(ox8Var, ex8Var)) == null) {
            return;
        }
        h(b);
    }
}
