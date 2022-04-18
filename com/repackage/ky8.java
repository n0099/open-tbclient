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
import com.repackage.gy8;
import com.repackage.iy8;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes6.dex */
public class ky8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ky8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public iy8 a;
    public List<py8> b;

    /* loaded from: classes6.dex */
    public class a implements oy8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky8 a;

        public a(ky8 ky8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky8Var;
        }

        @Override // com.repackage.oy8
        public void a(gy8.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                gy8.a().c(bVar);
                if (fc9.e(this.a.b)) {
                    return;
                }
                ky8 ky8Var = this.a;
                ky8Var.h((py8) fc9.c(ky8Var.b, 0));
                fc9.g(this.a.b, 0);
            }
        }
    }

    public ky8() {
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
        this.a = new iy8.b().d();
    }

    public static ky8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (ky8.class) {
                    if (c == null) {
                        c = new ky8();
                    }
                }
            }
            return c;
        }
        return (ky8) invokeV.objValue;
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

    public dy8 e() {
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
        return (dy8) invokeV.objValue;
    }

    public ny8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (ny8) invokeV.objValue;
    }

    public final void h(py8 py8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, py8Var) == null) {
            c();
            gy8.b b = gy8.a().b();
            if (b != null) {
                b.m(this.a.a);
                b.setDataSource(py8Var.a);
                b.h(py8Var, new a(this));
                return;
            }
            this.b.add(py8Var);
        }
    }

    public void i(qy8 qy8Var, hy8 hy8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, qy8Var, hy8Var) == null) {
            List<py8> c2 = my8.c(qy8Var, hy8Var);
            if (fc9.e(c2)) {
                return;
            }
            for (py8 py8Var : c2) {
                h(py8Var);
            }
        }
    }

    public void j(ry8 ry8Var, hy8 hy8Var) {
        py8 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, ry8Var, hy8Var) == null) || (b = my8.b(ry8Var, hy8Var)) == null) {
            return;
        }
        h(b);
    }
}
